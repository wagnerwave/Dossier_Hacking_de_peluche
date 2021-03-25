package a.h.a.n0;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tuya.smart.common.oOO0O0O0;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public C0083a f3524a;

    /* renamed from: a.h.a.n0.a$a  reason: collision with other inner class name */
    public class C0083a extends SQLiteOpenHelper {
        public C0083a(a aVar, Context context) {
            super(context, "IOTCamViewer.db", (SQLiteDatabase.CursorFactory) null, 6);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE device(_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, dev_nickname\t\t\tNVARCHAR(30) NULL, dev_uid\t\t\t\tVARCHAR(20) NULL, dev_name\t\t\t\tVARCHAR(30) NULL, dev_pwd\t\t\t\tVARCHAR(30) NULL, view_acc\t\t\t\tVARCHAR(30) NULL, view_pwd\t\t\t\tVARCHAR(30) NULL, event_notification \tINTEGER, ask_format_sdcard\t\tINTEGER,camera_channel\t\t\tINTEGER, snapshot\t\t\t\tBLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE search_history(_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, dev_uid\t\t\tVARCHAR(20) NULL, search_event_type\tINTEGER, search_start_time\tINTEGER, search_stop_time\tINTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE snapshot(_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, dev_uid\t\t\tVARCHAR(20) NULL, file_path\t\t\tVARCHAR(80), time\t\t\t\tINTEGER);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("drop table if exists device;");
            sQLiteDatabase.execSQL("drop table if exists search_history;");
            sQLiteDatabase.execSQL("drop table if exists snapshot;");
            onCreate(sQLiteDatabase);
        }
    }

    public a(Context context) {
        this.f3524a = new C0083a(this, context);
    }

    public static Bitmap a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = 2;
        try {
            BitmapFactory.Options.class.getDeclaredField("inNativeAlloc").setBoolean(options, true);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
        return BitmapFactory.decodeStream(byteArrayInputStream, (Rect) null, options);
    }

    public SQLiteDatabase b() {
        return this.f3524a.getReadableDatabase();
    }

    public void c(String str) {
        SQLiteDatabase writableDatabase = this.f3524a.getWritableDatabase();
        writableDatabase.delete(oOO0O0O0.O0000oOO, a.a.a.a.a.l("dev_uid = '", str, "'"), (String[]) null);
        writableDatabase.close();
    }

    public void d(ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) {
            SQLiteDatabase writableDatabase = this.f3524a.getWritableDatabase();
            writableDatabase.delete(oOO0O0O0.O0000oOO, (String) null, (String[]) null);
            writableDatabase.close();
            return;
        }
        StringBuilder n = a.a.a.a.a.n("dev_uid NOT IN (");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                n.append(",");
            }
            n.append("'");
            n.append(arrayList.get(i));
            n.append("'");
        }
        n.append(")");
        SQLiteDatabase writableDatabase2 = this.f3524a.getWritableDatabase();
        writableDatabase2.delete(oOO0O0O0.O0000oOO, n.toString(), (String[]) null);
        writableDatabase2.close();
    }

    public void e(String str, boolean z) {
        SQLiteDatabase writableDatabase = this.f3524a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ask_format_sdcard", Integer.valueOf(z ? 1 : 0));
        writableDatabase.update(oOO0O0O0.O0000oOO, contentValues, "dev_uid = '" + str + "'", (String[]) null);
        writableDatabase.close();
    }

    public void f(String str, int i) {
        SQLiteDatabase writableDatabase = this.f3524a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("camera_channel", Integer.valueOf(i));
        writableDatabase.update(oOO0O0O0.O0000oOO, contentValues, "dev_uid = '" + str + "'", (String[]) null);
        writableDatabase.close();
    }

    public void g(long j, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        SQLiteDatabase writableDatabase = this.f3524a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dev_uid", str);
        contentValues.put("dev_nickname", str2);
        contentValues.put("dev_name", str3);
        contentValues.put("dev_pwd", str4);
        contentValues.put("view_acc", str5);
        contentValues.put("view_pwd", str6);
        contentValues.put("event_notification", Integer.valueOf(i));
        contentValues.put("camera_channel", Integer.valueOf(i2));
        writableDatabase.update(oOO0O0O0.O0000oOO, contentValues, "_id = '" + j + "'", (String[]) null);
        writableDatabase.close();
    }

    public void h(String str, byte[] bArr) {
        SQLiteDatabase writableDatabase = this.f3524a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("snapshot", bArr);
        writableDatabase.update(oOO0O0O0.O0000oOO, contentValues, a.a.a.a.a.l("dev_uid = '", str, "'"), (String[]) null);
        writableDatabase.close();
    }
}
