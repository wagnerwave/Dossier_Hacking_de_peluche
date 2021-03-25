package com.tuya.smart.mqtt;

import a.a.a.a.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tuya.smart.mqtt.MessageStore;
import e.b.a.a.a.o;
import java.util.Iterator;
import java.util.UUID;

public class DatabaseMessageStore implements MessageStore {
    public static final String ARRIVED_MESSAGE_TABLE_NAME = "MqttArrivedMessageTable";
    public static final String MTIMESTAMP = "mtimestamp";
    public static final String TAG = "DatabaseMessageStore";
    public SQLiteDatabase db = null;
    public MQTTDatabaseHelper mqttDb = null;
    public MqttTraceHandler traceHandler = null;

    public class DbStoredData implements MessageStore.StoredMessage {
        public String clientHandle;
        public o message;
        public String messageId;
        public String topic;

        public DbStoredData(String str, String str2, String str3, o oVar) {
            this.messageId = str;
            this.topic = str3;
            this.message = oVar;
        }

        public String getClientHandle() {
            return this.clientHandle;
        }

        public o getMessage() {
            return this.message;
        }

        public String getMessageId() {
            return this.messageId;
        }

        public String getTopic() {
            return this.topic;
        }
    }

    public static class MQTTDatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "mqttAndroidService.db";
        public static final int DATABASE_VERSION = 1;
        public static final String TAG = "MQTTDatabaseHelper";
        public MqttTraceHandler traceHandler = null;

        public MQTTDatabaseHelper(MqttTraceHandler mqttTraceHandler, Context context) {
            super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
            this.traceHandler = mqttTraceHandler;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            MqttTraceHandler mqttTraceHandler = this.traceHandler;
            mqttTraceHandler.traceDebug(TAG, "onCreate {" + "CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);" + "}");
            try {
                sQLiteDatabase.execSQL("CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);");
                this.traceHandler.traceDebug(TAG, "created the table");
            } catch (SQLException e2) {
                this.traceHandler.traceException(TAG, "onCreate", e2);
                throw e2;
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.traceHandler.traceDebug(TAG, "onUpgrade");
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MqttArrivedMessageTable");
                onCreate(sQLiteDatabase);
                this.traceHandler.traceDebug(TAG, "onUpgrade complete");
            } catch (SQLException e2) {
                this.traceHandler.traceException(TAG, "onUpgrade", e2);
                throw e2;
            }
        }
    }

    public class MqttMessageHack extends o {
        public MqttMessageHack(byte[] bArr) {
            super(bArr);
        }

        public void setDuplicate(boolean z) {
            super.setDuplicate(z);
        }
    }

    public DatabaseMessageStore(MqttService mqttService, Context context) {
        this.traceHandler = mqttService;
        this.mqttDb = new MQTTDatabaseHelper(this.traceHandler, context);
        this.traceHandler.traceDebug(TAG, "DatabaseMessageStore<init> complete");
    }

    private int getArrivedRowCount(String str) {
        int i = 0;
        Cursor query = this.db.query(ARRIVED_MESSAGE_TABLE_NAME, new String[]{MqttServiceConstants.MESSAGE_ID}, "clientHandle=?", new String[]{str}, (String) null, (String) null, (String) null);
        if (query.moveToFirst()) {
            i = query.getInt(0);
        }
        query.close();
        return i;
    }

    public void clearArrivedMessages(String str) {
        int i;
        this.db = this.mqttDb.getWritableDatabase();
        String[] strArr = {str};
        if (str == null) {
            this.traceHandler.traceDebug(TAG, "clearArrivedMessages: clearing the table");
            i = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, (String) null, (String[]) null);
        } else {
            MqttTraceHandler mqttTraceHandler = this.traceHandler;
            mqttTraceHandler.traceDebug(TAG, "clearArrivedMessages: clearing the table of " + str + " messages");
            i = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, "clientHandle=?", strArr);
        }
        MqttTraceHandler mqttTraceHandler2 = this.traceHandler;
        mqttTraceHandler2.traceDebug(TAG, "clearArrivedMessages: rows affected = " + i);
    }

    public void close() {
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public boolean discardArrived(String str, String str2) {
        int i;
        this.db = this.mqttDb.getWritableDatabase();
        MqttTraceHandler mqttTraceHandler = this.traceHandler;
        mqttTraceHandler.traceDebug(TAG, "discardArrived{" + str + "}, {" + str2 + "}");
        try {
            i = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, "messageId=? AND clientHandle=?", new String[]{str2, str});
        } catch (SQLException e2) {
            this.traceHandler.traceException(TAG, "discardArrived", e2);
            i = -1;
        }
        if (i != 1) {
            MqttTraceHandler mqttTraceHandler2 = this.traceHandler;
            mqttTraceHandler2.traceError(TAG, "discardArrived - Error deleting message {" + str2 + "} from database: Rows affected = " + i);
            return false;
        }
        int arrivedRowCount = getArrivedRowCount(str);
        MqttTraceHandler mqttTraceHandler3 = this.traceHandler;
        mqttTraceHandler3.traceDebug(TAG, "discardArrived - Message deleted successfully. - messages in db for this clientHandle " + arrivedRowCount);
        return true;
    }

    public Iterator<MessageStore.StoredMessage> getAllArrivedMessages(final String str) {
        return new Iterator<MessageStore.StoredMessage>() {

            /* renamed from: c  reason: collision with root package name */
            public Cursor f4801c;
            public boolean hasNext;
            public final String[] selectionArgs = {str};

            {
                DatabaseMessageStore databaseMessageStore = DatabaseMessageStore.this;
                SQLiteDatabase unused = databaseMessageStore.db = databaseMessageStore.mqttDb.getWritableDatabase();
                this.f4801c = str == null ? DatabaseMessageStore.this.db.query(DatabaseMessageStore.ARRIVED_MESSAGE_TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "mtimestamp ASC") : DatabaseMessageStore.this.db.query(DatabaseMessageStore.ARRIVED_MESSAGE_TABLE_NAME, (String[]) null, "clientHandle=?", this.selectionArgs, (String) null, (String) null, "mtimestamp ASC");
                this.hasNext = this.f4801c.moveToFirst();
            }

            public void finalize() {
                this.f4801c.close();
                super.finalize();
            }

            public boolean hasNext() {
                if (!this.hasNext) {
                    this.f4801c.close();
                }
                return this.hasNext;
            }

            public MessageStore.StoredMessage next() {
                Cursor cursor = this.f4801c;
                String string = cursor.getString(cursor.getColumnIndex(MqttServiceConstants.MESSAGE_ID));
                Cursor cursor2 = this.f4801c;
                String string2 = cursor2.getString(cursor2.getColumnIndex(MqttServiceConstants.CLIENT_HANDLE));
                Cursor cursor3 = this.f4801c;
                String string3 = cursor3.getString(cursor3.getColumnIndex(MqttServiceConstants.DESTINATION_NAME));
                Cursor cursor4 = this.f4801c;
                byte[] blob = cursor4.getBlob(cursor4.getColumnIndex(MqttServiceConstants.PAYLOAD));
                Cursor cursor5 = this.f4801c;
                int i = cursor5.getInt(cursor5.getColumnIndex(MqttServiceConstants.QOS));
                Cursor cursor6 = this.f4801c;
                boolean parseBoolean = Boolean.parseBoolean(cursor6.getString(cursor6.getColumnIndex(MqttServiceConstants.RETAINED)));
                Cursor cursor7 = this.f4801c;
                boolean parseBoolean2 = Boolean.parseBoolean(cursor7.getString(cursor7.getColumnIndex(MqttServiceConstants.DUPLICATE)));
                MqttMessageHack mqttMessageHack = new MqttMessageHack(blob);
                mqttMessageHack.setQos(i);
                mqttMessageHack.setRetained(parseBoolean);
                mqttMessageHack.setDuplicate(parseBoolean2);
                this.hasNext = this.f4801c.moveToNext();
                return new DbStoredData(string, string2, string3, mqttMessageHack);
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public String storeArrived(String str, String str2, o oVar) {
        this.db = this.mqttDb.getWritableDatabase();
        MqttTraceHandler mqttTraceHandler = this.traceHandler;
        StringBuilder q = a.q("storeArrived{", str, "}, {");
        q.append(oVar.toString());
        q.append("}");
        mqttTraceHandler.traceDebug(TAG, q.toString());
        byte[] payload = oVar.getPayload();
        int qos = oVar.getQos();
        boolean isRetained = oVar.isRetained();
        boolean isDuplicate = oVar.isDuplicate();
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put(MqttServiceConstants.MESSAGE_ID, uuid);
        contentValues.put(MqttServiceConstants.CLIENT_HANDLE, str);
        contentValues.put(MqttServiceConstants.DESTINATION_NAME, str2);
        contentValues.put(MqttServiceConstants.PAYLOAD, payload);
        contentValues.put(MqttServiceConstants.QOS, Integer.valueOf(qos));
        contentValues.put(MqttServiceConstants.RETAINED, Boolean.valueOf(isRetained));
        contentValues.put(MqttServiceConstants.DUPLICATE, Boolean.valueOf(isDuplicate));
        contentValues.put(MTIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        try {
            this.db.insertOrThrow(ARRIVED_MESSAGE_TABLE_NAME, (String) null, contentValues);
            int arrivedRowCount = getArrivedRowCount(str);
            MqttTraceHandler mqttTraceHandler2 = this.traceHandler;
            mqttTraceHandler2.traceDebug(TAG, "storeArrived: inserted message with id of {" + uuid + "} - Number of messages in database for this clientHandle = " + arrivedRowCount);
            return uuid;
        } catch (SQLException e2) {
            this.traceHandler.traceException(TAG, "onUpgrade", e2);
            throw e2;
        }
    }
}
