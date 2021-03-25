package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.user.bean.User;
import java.util.concurrent.atomic.AtomicInteger;

public class o00000o0o extends SQLiteOpenHelper {
    public static final String O000000o = "DataBaseHelper";
    public static final int O00000Oo = 1;
    public static o00000o0o O00000o = null;
    public static final String O00000o0 = "tuyasmart";
    public static SQLiteDatabase O00000oO;
    public volatile AtomicInteger O00000oo = new AtomicInteger(0);

    public o00000o0o(Context context, String str) {
        super(context, a.k("tuyasmart_", str), (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static o00000o0o O000000o() {
        User user;
        if (O00000o == null) {
            synchronized (o00000o0o.class) {
                o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
                String str = O000000o;
                if (!(o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null)) {
                    str = user.getUid();
                }
                if (O00000o == null) {
                    O00000o = new o00000o0o(TuyaSmartSdk.getApplication(), str);
                }
            }
        }
        return O00000o;
    }

    public static void O00000Oo() {
        o00000o0o o00000o0o = O00000o;
        if (o00000o0o != null) {
            o00000o0o.close();
            O00000o = null;
        }
    }

    public void O00000o() {
        this.O00000oo.decrementAndGet();
        if (this.O00000oo.get() == 0 && O00000oO != null) {
            synchronized (o00000o0o.class) {
                if (this.O00000oo.get() == 0 && O00000oO != null) {
                    O00000oO.close();
                    O00000oO = null;
                }
            }
        }
    }

    public synchronized SQLiteDatabase O00000o0() {
        if (O00000oO == null || !O00000oO.isOpen()) {
            O00000oO = getWritableDatabase();
        }
        this.O00000oo.incrementAndGet();
        return O00000oO;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        L.d(O000000o, "onCreate");
        sQLiteDatabase.execSQL(o00000oo0.O0000OOo);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        L.d(O000000o, "onUpgrade:" + i + "," + i2);
        new o0000o000(sQLiteDatabase, i, i2).O000000o();
    }
}
