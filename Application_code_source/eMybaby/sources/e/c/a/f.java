package e.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final i f5378a = new i();

    /* renamed from: b  reason: collision with root package name */
    public final int f5379b;

    /* renamed from: c  reason: collision with root package name */
    public final c f5380c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5381d;

    public f(c cVar, Looper looper, int i) {
        super(looper);
        this.f5380c = cVar;
        this.f5379b = i;
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                h a2 = this.f5378a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f5378a.a();
                        if (a2 == null) {
                            this.f5381d = false;
                            this.f5381d = false;
                            return;
                        }
                    }
                }
                this.f5380c.b(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f5379b));
            if (sendMessage(obtainMessage())) {
                this.f5381d = true;
                return;
            }
            throw new e("Could not send handler message");
        } catch (Throwable th) {
            this.f5381d = false;
            throw th;
        }
    }
}
