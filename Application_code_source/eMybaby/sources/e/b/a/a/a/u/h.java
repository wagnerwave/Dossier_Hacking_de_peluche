package e.b.a.a.a.u;

import e.b.a.a.a.a;
import e.b.a.a.a.n;
import e.b.a.a.a.u.a;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.util.ArrayList;

public class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final b f5270e = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "DisconnectedMessageBuffer");

    /* renamed from: a  reason: collision with root package name */
    public e.b.a.a.a.b f5271a = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f5272b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Object f5273c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public j f5274d;

    public a a(int i) {
        a aVar;
        synchronized (this.f5273c) {
            aVar = (a) this.f5272b.get(i);
        }
        return aVar;
    }

    public int b() {
        int size;
        synchronized (this.f5273c) {
            size = this.f5272b.size();
        }
        return size;
    }

    public void run() {
        f5270e.h("DisconnectedMessageBuffer", "run", "516");
        while (b() > 0) {
            try {
                ((a.c) this.f5274d).a(a(0));
                synchronized (this.f5273c) {
                    this.f5272b.remove(0);
                }
            } catch (n unused) {
                f5270e.a("DisconnectedMessageBuffer", "run", "517");
                return;
            }
        }
    }
}
