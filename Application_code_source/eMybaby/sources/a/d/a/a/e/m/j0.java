package a.d.a.a.e.m;

import a.d.a.a.e.m.g;
import a.d.a.a.e.p.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

public final class j0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Map<ServiceConnection, ServiceConnection> f1395a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public int f1396b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1397c;

    /* renamed from: d  reason: collision with root package name */
    public IBinder f1398d;

    /* renamed from: e  reason: collision with root package name */
    public final g.a f1399e;
    public ComponentName f;
    public final /* synthetic */ h0 g;

    public j0(h0 h0Var, g.a aVar) {
        this.g = h0Var;
        this.f1399e = aVar;
    }

    public final void a(String str) {
        this.f1396b = 3;
        h0 h0Var = this.g;
        a aVar = h0Var.f;
        Context context = h0Var.f1391d;
        boolean b2 = aVar.b(context, this.f1399e.a(context), this, this.f1399e.f1388d);
        this.f1397c = b2;
        if (b2) {
            Message obtainMessage = this.g.f1392e.obtainMessage(1, this.f1399e);
            h0 h0Var2 = this.g;
            h0Var2.f1392e.sendMessageDelayed(obtainMessage, h0Var2.h);
            return;
        }
        this.f1396b = 2;
        try {
            a aVar2 = this.g.f;
            Context context2 = this.g.f1391d;
            if (aVar2 != null) {
                context2.unbindService(this);
                return;
            }
            throw null;
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f1390c) {
            this.g.f1392e.removeMessages(1, this.f1399e);
            this.f1398d = iBinder;
            this.f = componentName;
            for (ServiceConnection onServiceConnected : this.f1395a.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f1396b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f1390c) {
            this.g.f1392e.removeMessages(1, this.f1399e);
            this.f1398d = null;
            this.f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f1395a.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f1396b = 2;
        }
    }
}
