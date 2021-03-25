package a.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f5b;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f6a;

    public b(Context context) {
        this.f6a = context.getSharedPreferences("APPLICATION_PREFERENCES", 0);
        f5b = this;
    }

    public static b b() {
        return f5b;
    }

    public static String f(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            if (i < arrayList.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public boolean a(String str, boolean z) {
        return this.f6a.contains(str) ? this.f6a.getBoolean(str, z) : z;
    }

    public String c() {
        if (this.f6a.contains("LANGUAGE")) {
            return this.f6a.getString("LANGUAGE", (String) null);
        }
        return null;
    }

    public String d(String str) {
        if (this.f6a.contains(str)) {
            return this.f6a.getString(str, (String) null);
        }
        return null;
    }

    public ArrayList<String> e(String str) {
        String d2 = d(str);
        if (d2 == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (d2.length() > 0) {
            for (String str2 : d2.split(",")) {
                if (str2.length() != 0) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public void g(String str, Boolean bool) {
        if (bool == null) {
            SharedPreferences.Editor edit = this.f6a.edit();
            edit.remove(str);
            edit.commit();
            return;
        }
        SharedPreferences.Editor edit2 = this.f6a.edit();
        edit2.putBoolean(str, bool.booleanValue());
        edit2.commit();
    }

    public void h(String str, Long l) {
        if (l == null) {
            SharedPreferences.Editor edit = this.f6a.edit();
            edit.remove(str);
            edit.commit();
            return;
        }
        SharedPreferences.Editor edit2 = this.f6a.edit();
        edit2.putLong(str, l.longValue());
        edit2.commit();
    }

    public void i(String str, String str2) {
        if (str2 == null) {
            SharedPreferences.Editor edit = this.f6a.edit();
            edit.remove(str);
            edit.commit();
            return;
        }
        SharedPreferences.Editor edit2 = this.f6a.edit();
        edit2.putString(str, str2);
        edit2.commit();
    }

    public void j(String str) {
        SharedPreferences.Editor edit = this.f6a.edit();
        edit.putString("LANGUAGE", str);
        edit.commit();
    }
}
