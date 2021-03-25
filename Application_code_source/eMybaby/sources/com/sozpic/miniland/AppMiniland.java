package com.sozpic.miniland;

import a.c.a.a;
import a.c.a.e.f;
import a.c.a.f.e;
import a.c.c.b;
import a.g.a.a.a.c.c;
import a.g.a.b.b;
import a.g.a.b.d;
import a.g.a.b.f;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Process;
import android.util.Xml;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.multidex.MultiDex;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.sdk.TuyaSdk;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;

public class AppMiniland extends a {
    public static Context l;
    public Usuario g = null;
    public SharedPreferences h;
    public SharedPreferences.Editor i;
    public boolean j;
    public d k;

    public AppMiniland() {
        new ArrayList();
        new ArrayList();
        this.j = true;
    }

    public static AppMiniland f() {
        return (AppMiniland) a.f;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public void d() {
        a();
        Process.myPid();
        a.c.d.a.l();
    }

    public int g() {
        return (int) (TimeUnit.MILLISECONDS.toDays(i().getBirthDate().getTime() - Calendar.getInstance().getTimeInMillis()) % 7);
    }

    public int h() {
        return (int) (TimeUnit.MILLISECONDS.toDays(i().getBirthDate().getTime() - Calendar.getInstance().getTimeInMillis()) / 7);
    }

    public Usuario i() {
        if (this.g == null) {
            this.g = a.c.d.a.l().t();
        }
        return this.g;
    }

    public final void j() {
        try {
            f.c().b(getAssets().open("analytics/analytics.xml"));
            f.c().a(new a.c.d.e.a());
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new RuntimeException(e2);
        }
    }

    public final void k() {
        b.f45d = b.a.SDCARD_ANDROID_DATA_FILE_DIR;
        a.c.c.a aVar = new a.c.c.a();
        File a2 = b.c().a();
        b.c().d(aVar);
        c cVar = new c(a2, aVar);
        this.k = d.e();
        b.C0080b bVar = new b.C0080b();
        bVar.a(Bitmap.Config.RGB_565);
        bVar.c();
        bVar.d();
        bVar.e(a.g.a.b.l.d.IN_SAMPLE_POWER_OF_2);
        bVar.f(R.drawable.imagenes_default);
        bVar.g(R.drawable.imagenes_default);
        a.g.a.b.b b2 = bVar.b();
        f.a aVar2 = new f.a(this);
        aVar2.d(new a.g.a.a.b.d.c());
        aVar2.c(cVar);
        aVar2.e(5);
        aVar2.b(b2);
        this.k.g(aVar2.a());
    }

    public void l() {
        String language = Locale.getDefault().getLanguage();
        String str = "pt";
        if (!a.c.a.d.a.j(language) && "es".equals(language)) {
            str = "es";
        } else if (!a.c.a.d.a.j(language) && "it".equals(language)) {
            str = "it";
        } else if (!a.c.a.d.a.j(language) && "ru".equals(language)) {
            str = "ru";
        } else if (a.c.a.d.a.j(language) || !str.equals(language)) {
            str = "en";
        }
        a.c.d.a.l().j(str);
        this.f1b = str;
        e(str);
    }

    public final void m() {
        TuyaSdk.init(this);
    }

    public boolean n() {
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses()) {
            if (next.processName.equals(getPackageName())) {
                return next.importance == 100;
            }
        }
        return false;
    }

    public void onCreate() {
        super.onCreate();
        l = this;
        SharedPreferences sharedPreferences = getSharedPreferences("emybaby", 0);
        this.h = sharedPreferences;
        this.i = sharedPreferences.edit();
        e.f40a = getApplicationContext().getResources().getString(R.string.app_name);
        a.f = this;
        k();
        l();
        Hashtable<String, Hashtable<String, String>> hashtable = new Hashtable<>();
        this.f0a = hashtable;
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(getResources().openRawResource(R.raw.translations), String.valueOf(Xml.Encoding.UTF_8));
            String str = null;
            String str2 = null;
            while (newPullParser.getEventType() != 1) {
                if (newPullParser.getEventType() == 2) {
                    if (newPullParser.getName().equals("resource-entry")) {
                        str2 = newPullParser.getAttributeValue(0);
                    }
                    if (newPullParser.getName().equals("language-entry")) {
                        str = newPullParser.getAttributeValue(0);
                        if (!hashtable.containsKey(str)) {
                            hashtable.put(str, new Hashtable());
                        }
                    }
                    if (newPullParser.getName().equals("value")) {
                        newPullParser.next();
                        if (newPullParser.getEventType() == 4) {
                            hashtable.get(str).put(str2, newPullParser.getText());
                        }
                    }
                }
                newPullParser.next();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String b2 = b();
        this.f1b = b2;
        if (b2 == null) {
            this.f1b = Locale.getDefault().getLanguage();
        }
        j();
        m();
    }

    public void onTerminate() {
        super.onTerminate();
    }
}
