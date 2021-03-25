package a.d.a.a.i.b;

import a.c.a.f.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

public class i4 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final o9 f2262a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2263b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2264c;

    static {
        Class<i4> cls = i4.class;
    }

    public i4(o9 o9Var) {
        b.k(o9Var);
        this.f2262a = o9Var;
    }

    @WorkerThread
    public final void a() {
        this.f2262a.O();
        this.f2262a.f().b();
        this.f2262a.f().b();
        if (this.f2263b) {
            this.f2262a.i().n.a("Unregistering connectivity change receiver");
            this.f2263b = false;
            this.f2264c = false;
            try {
                this.f2262a.j.f2123a.unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f2262a.i().f.b("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.f2262a.O();
        String action = intent.getAction();
        this.f2262a.i().n.b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean u = this.f2262a.I().u();
            if (this.f2264c != u) {
                this.f2264c = u;
                this.f2262a.f().v(new h4(this, u));
                return;
            }
            return;
        }
        this.f2262a.i().i.b("NetworkBroadcastReceiver received unknown action", action);
    }
}
