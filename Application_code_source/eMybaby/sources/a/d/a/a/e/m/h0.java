package a.d.a.a.e.m;

import a.c.a.f.b;
import a.d.a.a.e.m.g;
import a.d.a.a.e.p.a;
import a.d.a.a.h.e.d;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

public final class h0 extends g implements Handler.Callback {
    @GuardedBy("mConnectionStatus")

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<g.a, j0> f1390c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final Context f1391d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f1392e;
    public final a f;
    public final long g;
    public final long h;

    public h0(Context context) {
        this.f1391d = context.getApplicationContext();
        this.f1392e = new d(context.getMainLooper(), this);
        this.f = a.a();
        this.g = 5000;
        this.h = 300000;
    }

    public final boolean c(g.a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        b.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1390c) {
            j0 j0Var = this.f1390c.get(aVar);
            if (j0Var == null) {
                j0Var = new j0(this, aVar);
                h0 h0Var = j0Var.g;
                a aVar2 = h0Var.f;
                j0Var.f1399e.a(h0Var.f1391d);
                j0Var.f1395a.put(serviceConnection, serviceConnection);
                j0Var.a(str);
                this.f1390c.put(aVar, j0Var);
            } else {
                this.f1392e.removeMessages(0, aVar);
                if (!j0Var.f1395a.containsKey(serviceConnection)) {
                    h0 h0Var2 = j0Var.g;
                    a aVar3 = h0Var2.f;
                    j0Var.f1399e.a(h0Var2.f1391d);
                    j0Var.f1395a.put(serviceConnection, serviceConnection);
                    int i = j0Var.f1396b;
                    if (i == 1) {
                        serviceConnection.onServiceConnected(j0Var.f, j0Var.f1398d);
                    } else if (i == 2) {
                        j0Var.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            z = j0Var.f1397c;
        }
        return z;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f1390c) {
                g.a aVar = (g.a) message.obj;
                j0 j0Var = this.f1390c.get(aVar);
                if (j0Var != null && j0Var.f1395a.isEmpty()) {
                    if (j0Var.f1397c) {
                        j0Var.g.f1392e.removeMessages(1, j0Var.f1399e);
                        h0 h0Var = j0Var.g;
                        a aVar2 = h0Var.f;
                        Context context = h0Var.f1391d;
                        if (aVar2 != null) {
                            context.unbindService(j0Var);
                            j0Var.f1397c = false;
                            j0Var.f1396b = 2;
                        } else {
                            throw null;
                        }
                    }
                    this.f1390c.remove(aVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f1390c) {
                g.a aVar3 = (g.a) message.obj;
                j0 j0Var2 = this.f1390c.get(aVar3);
                if (j0Var2 != null && j0Var2.f1396b == 3) {
                    String valueOf = String.valueOf(aVar3);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = j0Var2.f;
                    if (componentName == null) {
                        componentName = aVar3.f1387c;
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(aVar3.f1386b, EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    j0Var2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
