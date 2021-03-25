package a.d.a.a.h.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.tuya.smart.mqtt.MqttServiceConstants;
import java.util.Locale;

public final class f1 extends f {

    /* renamed from: c  reason: collision with root package name */
    public String f1493c;

    /* renamed from: d  reason: collision with root package name */
    public String f1494d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1495e;
    public int f;
    public boolean g;
    public boolean h;

    public f1(h hVar) {
        super(hVar);
    }

    public final void t() {
        ApplicationInfo applicationInfo;
        int i;
        Context context = this.f1490a.f1503a;
        m0 m0Var = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            l("PackageManager doesn't know about the app package", e2);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            p("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0) {
            k0 k0Var = new k0(this.f1490a);
            try {
                m0Var = k0Var.r(k0Var.f1490a.f1504b.getResources().getXml(i));
            } catch (Resources.NotFoundException e3) {
                k0Var.l("inflate() called with unknown resourceId", e3);
            }
            if (m0Var != null) {
                o("Loading global XML config values");
                boolean z = false;
                if (m0Var.f1531a != null) {
                    String str = m0Var.f1531a;
                    this.f1494d = str;
                    d("XML config - app name", str);
                }
                if (m0Var.f1532b != null) {
                    String str2 = m0Var.f1532b;
                    this.f1493c = str2;
                    d("XML config - app version", str2);
                }
                if (m0Var.f1533c != null) {
                    String lowerCase = m0Var.f1533c.toLowerCase(Locale.US);
                    int i2 = "verbose".equals(lowerCase) ? 0 : "info".equals(lowerCase) ? 1 : "warning".equals(lowerCase) ? 2 : MqttServiceConstants.TRACE_ERROR.equals(lowerCase) ? 3 : -1;
                    if (i2 >= 0) {
                        b("XML config - log level", Integer.valueOf(i2));
                    }
                }
                if (m0Var.f1534d >= 0) {
                    int i3 = m0Var.f1534d;
                    this.f = i3;
                    this.f1495e = true;
                    d("XML config - dispatch period (sec)", Integer.valueOf(i3));
                }
                int i4 = m0Var.f1535e;
                if (i4 != -1) {
                    if (i4 == 1) {
                        z = true;
                    }
                    this.h = z;
                    this.g = true;
                    d("XML config - dry run", Boolean.valueOf(z));
                }
            }
        }
    }
}
