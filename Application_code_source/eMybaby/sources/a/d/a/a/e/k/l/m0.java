package a.d.a.a.e.k.l;

import a.d.a.a.e.c;
import a.d.a.a.h.d.d;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

public abstract class m0 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f1311b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<o0> f1312c = new AtomicReference<>((Object) null);

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1313d = new d(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final c f1314e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m0(i iVar) {
        super(iVar);
        c cVar = c.f1231d;
        this.f1314e = cVar;
    }

    public void c(int i, int i2, Intent intent) {
        o0 o0Var = this.f1312c.get();
        boolean z = false;
        if (i != 1) {
            if (i == 2) {
                int c2 = this.f1314e.c(b());
                if (c2 == 0) {
                    z = true;
                }
                if (o0Var != null) {
                    if (o0Var.f1318b.f4192b == 18 && c2 == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i2 == -1) {
            z = true;
        } else if (i2 == 0) {
            int i3 = 13;
            if (intent != null) {
                i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
            }
            o0 o0Var2 = new o0(new ConnectionResult(i3, (PendingIntent) null, o0Var.f1318b.toString()), o0Var.f1317a);
            this.f1312c.set(o0Var2);
            o0Var = o0Var2;
        }
        if (z) {
            j();
        } else if (o0Var != null) {
            i(o0Var.f1318b, o0Var.f1317a);
        }
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.f1312c.set(bundle.getBoolean("resolving_error", false) ? new o0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public void f(Bundle bundle) {
        o0 o0Var = this.f1312c.get();
        if (o0Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", o0Var.f1317a);
            bundle.putInt("failed_status", o0Var.f1318b.f4192b);
            bundle.putParcelable("failed_resolution", o0Var.f1318b.f4193c);
        }
    }

    public abstract void i(ConnectionResult connectionResult, int i);

    public final void j() {
        this.f1312c.set((Object) null);
        Handler handler = ((n) this).g.m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public void onCancel(DialogInterface dialogInterface) {
        ConnectionResult connectionResult = new ConnectionResult(13, (PendingIntent) null);
        o0 o0Var = this.f1312c.get();
        i(connectionResult, o0Var == null ? -1 : o0Var.f1317a);
        j();
    }
}
