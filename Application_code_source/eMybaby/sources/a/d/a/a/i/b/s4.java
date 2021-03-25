package a.d.a.a.i.b;

import a.d.a.a.h.g.a2;
import a.d.a.a.h.g.k4;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;

public final class s4 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final String f2512a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p4 f2513b;

    public s4(p4 p4Var, String str) {
        this.f2513b = p4Var;
        this.f2512a = str;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f2513b.f2455a.i().i.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            a2 g = k4.g(iBinder);
            if (g == null) {
                this.f2513b.f2455a.i().i.a("Install Referrer Service implementation was not found");
                return;
            }
            this.f2513b.f2455a.i().n.a("Install Referrer Service connected");
            this.f2513b.f2455a.f().v(new r4(this, g, this));
        } catch (Exception e2) {
            this.f2513b.f2455a.i().i.b("Exception occurred while calling Install Referrer API", e2);
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2513b.f2455a.i().n.a("Install Referrer Service disconnected");
    }
}
