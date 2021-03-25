package a.c.d;

import a.c.a.b;
import android.content.Context;
import android.content.SharedPreferences;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b {

    /* renamed from: c  reason: collision with root package name */
    public static a f53c;

    public a(Context context) {
        super(context);
    }

    public static a l() {
        if (f53c == null) {
            f53c = new a(a.c.a.a.f);
        }
        return f53c;
    }

    public ArrayList<String> k() {
        return e("KEY_FAVOURITE_ID_SONGS");
    }

    public String m() {
        return d("KEY_USER_USERNAME");
    }

    public String n() {
        return d("KEY_USER_PASSWORD");
    }

    public int o() {
        if (this.f6a.contains("KEY_MYSCALE_MEASURE_UNIT")) {
            return this.f6a.getInt("KEY_MYSCALE_MEASURE_UNIT", -1);
        }
        return -1;
    }

    public final ArrayList<String> p() {
        return this.f6a.contains("KEY_TUTORIALES_REPRODUCIDOS") ? e("KEY_TUTORIALES_REPRODUCIDOS") : new ArrayList<>();
    }

    public boolean q(String str) {
        ArrayList<String> p = p();
        if (p == null) {
            p = new ArrayList<>();
        }
        return p.contains(str);
    }

    public HashMap<String, String> r() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            return (HashMap) new ObjectInputStream(new FileInputStream(AppMiniland.f().getCacheDir().getAbsolutePath() + "/ResponseCache.dat")).readObject();
        } catch (Exception unused) {
            return hashMap;
        }
    }

    public HashMap<String, Integer> s() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            return (HashMap) new ObjectInputStream(new FileInputStream(AppMiniland.f().getCacheDir().getAbsolutePath() + "/HumidifyDevices.dat")).readObject();
        } catch (Exception unused) {
            return hashMap;
        }
    }

    public Usuario t() {
        try {
            return new Usuario(this.f6a.contains("KEY_USER_JSON") ? new JSONObject(this.f6a.getString("KEY_USER_JSON", (String) null)) : null);
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void u(HashMap<String, String> hashMap) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(AppMiniland.f().getCacheDir().getAbsolutePath() + "/ResponseCache.dat"));
            objectOutputStream.writeObject(hashMap);
            objectOutputStream.close();
        } catch (Exception unused) {
        }
    }

    public void v(int i) {
        Integer valueOf = Integer.valueOf(i);
        if (valueOf == null) {
            SharedPreferences.Editor edit = this.f6a.edit();
            edit.remove("KEY_MYSCALE_MEASURE_UNIT");
            edit.commit();
            return;
        }
        SharedPreferences.Editor edit2 = this.f6a.edit();
        edit2.putInt("KEY_MYSCALE_MEASURE_UNIT", valueOf.intValue());
        edit2.commit();
    }

    public boolean w() {
        return a("KEY_SHOW_CAMERA_IP_WARNING", true);
    }
}
