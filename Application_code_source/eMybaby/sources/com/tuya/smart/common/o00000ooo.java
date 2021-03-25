package com.tuya.smart.common;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgBean;
import java.util.ArrayList;
import java.util.List;

public class o00000ooo {
    public static final String O000000o = "FeedbackSet";
    public static final int O00000Oo = 0;
    public static final int O00000o0 = -1;

    public static synchronized long O000000o(FeedbackMsgBean feedbackMsgBean) {
        long j;
        o00000o0o O000000o2;
        synchronized (o00000ooo.class) {
            try {
                j = o00000o0o.O000000o().O00000o0().insert(o00000oo0.O000000o, (String) null, O00000o0(feedbackMsgBean));
                O000000o2 = o00000o0o.O000000o();
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    j = -1;
                    O000000o2 = o00000o0o.O000000o();
                } catch (Throwable th) {
                    o00000o0o.O000000o().O00000o();
                    throw th;
                }
            }
            O000000o2.O00000o();
        }
        return j;
    }

    public static synchronized long O000000o(String str, int i, List<FeedbackMsgBean> list) {
        long j;
        o00000o0o O000000o2;
        synchronized (o00000ooo.class) {
            SQLiteDatabase O00000o02 = o00000o0o.O000000o().O00000o0();
            O00000o02.beginTransaction();
            j = 0;
            try {
                for (FeedbackMsgBean next : list) {
                    next.setHdId(str);
                    next.setHdType(i);
                    j += O00000o02.replace(o00000oo0.O000000o, (String) null, O00000o0(next));
                }
                O00000o02.setTransactionSuccessful();
                O00000o02.endTransaction();
                O000000o2 = o00000o0o.O000000o();
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    j = -1;
                    O00000o02.endTransaction();
                    O000000o2 = o00000o0o.O000000o();
                } catch (Throwable th) {
                    O00000o02.endTransaction();
                    o00000o0o.O000000o().O00000o();
                    throw th;
                }
            }
            O000000o2.O00000o();
        }
        return j;
    }

    public static synchronized long O000000o(List<FeedbackMsgBean> list) {
        long j;
        o00000o0o O000000o2;
        synchronized (o00000ooo.class) {
            SQLiteDatabase O00000o02 = o00000o0o.O000000o().O00000o0();
            O00000o02.beginTransaction();
            j = 0;
            try {
                for (FeedbackMsgBean O00000o03 : list) {
                    j += O00000o02.insert(o00000oo0.O000000o, (String) null, O00000o0(O00000o03));
                }
                O00000o02.setTransactionSuccessful();
                O00000o02.endTransaction();
                O000000o2 = o00000o0o.O000000o();
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    j = -1;
                    O00000o02.endTransaction();
                    O000000o2 = o00000o0o.O000000o();
                } catch (Throwable th) {
                    O00000o02.endTransaction();
                    o00000o0o.O000000o().O00000o();
                    throw th;
                }
            }
            O000000o2.O00000o();
        }
        return j;
    }

    public static FeedbackMsgBean O000000o() {
        FeedbackMsgBean feedbackMsgBean = null;
        try {
            Cursor rawQuery = o00000o0o.O000000o().O00000o0().rawQuery("SELECT * FROM feedback ORDER BY id DESC LIMIT 1", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    feedbackMsgBean = O000000o(rawQuery);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            o00000o0o.O000000o().O00000o();
            throw th;
        }
        o00000o0o.O000000o().O00000o();
        return feedbackMsgBean;
    }

    public static FeedbackMsgBean O000000o(Cursor cursor) {
        FeedbackMsgBean feedbackMsgBean = new FeedbackMsgBean();
        feedbackMsgBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
        feedbackMsgBean.setContent(cursor.getString(cursor.getColumnIndex(o00000oo0.O00000o0)));
        feedbackMsgBean.setCtime(cursor.getInt(cursor.getColumnIndex(o00000oo0.O00000o)));
        feedbackMsgBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
        feedbackMsgBean.setHdId(cursor.getString(cursor.getColumnIndex(o00000oo0.O00000oo)));
        feedbackMsgBean.setHdType(cursor.getInt(cursor.getColumnIndex(o00000oo0.O0000O0o)));
        return feedbackMsgBean;
    }

    public static ArrayList<FeedbackMsgBean> O000000o(String str, int i) {
        ArrayList<FeedbackMsgBean> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = o00000o0o.O000000o().O00000o0().rawQuery("SELECT * FROM feedback WHERE hdId = '" + str + "' AND " + o00000oo0.O0000O0o + " = " + i + " ORDER BY " + o00000oo0.O00000o + " ASC", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(O000000o(rawQuery));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            o00000o0o.O000000o().O00000o();
            throw th;
        }
        o00000o0o.O000000o().O00000o();
        return arrayList;
    }

    public static synchronized long O00000Oo(FeedbackMsgBean feedbackMsgBean) {
        long j;
        o00000o0o O000000o2;
        synchronized (o00000ooo.class) {
            try {
                j = o00000o0o.O000000o().O00000o0().replace(o00000oo0.O000000o, (String) null, O00000o0(feedbackMsgBean));
                O000000o2 = o00000o0o.O000000o();
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    j = -1;
                    O000000o2 = o00000o0o.O000000o();
                } catch (Throwable th) {
                    o00000o0o.O000000o().O00000o();
                    throw th;
                }
            }
            O000000o2.O00000o();
        }
        return j;
    }

    public static FeedbackMsgBean O00000o(FeedbackMsgBean feedbackMsgBean) {
        if (feedbackMsgBean.getId() == 0) {
            return null;
        }
        if (feedbackMsgBean.getContent() == null) {
            feedbackMsgBean.setContent("");
        }
        return feedbackMsgBean;
    }

    public static ContentValues O00000o0(FeedbackMsgBean feedbackMsgBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(feedbackMsgBean.getId()));
        if (feedbackMsgBean.getContent() != null) {
            contentValues.put(o00000oo0.O00000o0, feedbackMsgBean.getContent());
        }
        if (feedbackMsgBean.getCtime() != 0) {
            contentValues.put(o00000oo0.O00000o, Integer.valueOf(feedbackMsgBean.getCtime()));
        }
        if (feedbackMsgBean.getType() != 0) {
            contentValues.put("type", Integer.valueOf(feedbackMsgBean.getType()));
        }
        if (feedbackMsgBean.getHdId() != null) {
            contentValues.put(o00000oo0.O00000oo, feedbackMsgBean.getHdId());
        }
        contentValues.put(o00000oo0.O0000O0o, Integer.valueOf(feedbackMsgBean.getHdType()));
        return contentValues;
    }
}
