package a.d.a.a.e.m;

import a.c.a.f.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.tuya.smart.common.o00000oo0;
import java.util.Arrays;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1383a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static g f1384b;

    public static final class a {
        public static final Uri f = new Uri.Builder().scheme(o00000oo0.O00000o0).authority("com.google.android.gms.chimera").build();

        /* renamed from: a  reason: collision with root package name */
        public final String f1385a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1386b;

        /* renamed from: c  reason: collision with root package name */
        public final ComponentName f1387c = null;

        /* renamed from: d  reason: collision with root package name */
        public final int f1388d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f1389e;

        public a(String str, String str2, int i, boolean z) {
            b.h(str);
            this.f1385a = str;
            b.h(str2);
            this.f1386b = str2;
            this.f1388d = i;
            this.f1389e = z;
        }

        public final Intent a(Context context) {
            if (this.f1385a == null) {
                return new Intent().setComponent(this.f1387c);
            }
            Intent intent = null;
            if (this.f1389e) {
                Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", this.f1385a);
                Bundle call = context.getContentResolver().call(f, "serviceIntentCall", (String) null, bundle);
                if (call != null) {
                    intent = (Intent) call.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    String valueOf = String.valueOf(this.f1385a);
                    Log.w("ConnectionStatusConfig", valueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf) : new String("Dynamic lookup for intent failed for action: "));
                }
            }
            return intent == null ? new Intent(this.f1385a).setPackage(this.f1386b) : intent;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return b.B(this.f1385a, aVar.f1385a) && b.B(this.f1386b, aVar.f1386b) && b.B(this.f1387c, aVar.f1387c) && this.f1388d == aVar.f1388d && this.f1389e == aVar.f1389e;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f1385a, this.f1386b, this.f1387c, Integer.valueOf(this.f1388d), Boolean.valueOf(this.f1389e)});
        }

        public final String toString() {
            String str = this.f1385a;
            return str == null ? this.f1387c.flattenToString() : str;
        }
    }

    public static g a(Context context) {
        synchronized (f1383a) {
            if (f1384b == null) {
                f1384b = new h0(context.getApplicationContext());
            }
        }
        return f1384b;
    }

    public final void b(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        a aVar = new a(str, str2, i, z);
        h0 h0Var = (h0) this;
        b.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (h0Var.f1390c) {
            j0 j0Var = h0Var.f1390c.get(aVar);
            if (j0Var == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (j0Var.f1395a.containsKey(serviceConnection)) {
                a.d.a.a.e.p.a aVar2 = j0Var.g.f;
                j0Var.f1395a.remove(serviceConnection);
                if (j0Var.f1395a.isEmpty()) {
                    h0Var.f1392e.sendMessageDelayed(h0Var.f1392e.obtainMessage(0, aVar), h0Var.g);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public abstract boolean c(a aVar, ServiceConnection serviceConnection, String str);
}
