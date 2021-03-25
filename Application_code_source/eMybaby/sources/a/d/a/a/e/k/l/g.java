package a.d.a.a.e.k.l;

import a.c.a.f.b;
import a.d.a.a.e.i;
import a.d.a.a.e.m.q0;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
public final class g {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f1299d = new Object();
    @GuardedBy("sLock")

    /* renamed from: e  reason: collision with root package name */
    public static g f1300e;

    /* renamed from: a  reason: collision with root package name */
    public final String f1301a;

    /* renamed from: b  reason: collision with root package name */
    public final Status f1302b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1303c;

    public g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(i.common_google_play_services_unknown_issue));
        boolean z = false;
        if (identifier != 0) {
            this.f1303c = !(resources.getInteger(identifier) != 0 ? true : z);
        } else {
            this.f1303c = false;
        }
        q0.a(context);
        String str = q0.f1411c;
        if (str == null) {
            b.k(context);
            Resources resources2 = context.getResources();
            int identifier2 = resources2.getIdentifier("google_app_id", StringSchemaBean.type, resources2.getResourcePackageName(i.common_google_play_services_unknown_issue));
            str = identifier2 == 0 ? null : resources2.getString(identifier2);
        }
        if (TextUtils.isEmpty(str)) {
            this.f1302b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f1301a = null;
            return;
        }
        this.f1301a = str;
        this.f1302b = Status.f4205e;
    }

    public static g a(String str) {
        g gVar;
        synchronized (f1299d) {
            if (f1300e != null) {
                gVar = f1300e;
            } else {
                StringBuilder sb = new StringBuilder(str.length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return gVar;
    }

    public static Status b(Context context) {
        Status status;
        b.l(context, "Context must not be null.");
        synchronized (f1299d) {
            if (f1300e == null) {
                f1300e = new g(context);
            }
            status = f1300e.f1302b;
        }
        return status;
    }
}
