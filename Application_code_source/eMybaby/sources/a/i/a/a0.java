package a.i.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f3577a;

    /* renamed from: b  reason: collision with root package name */
    public final d f3578b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f3579c = new a(this.f3577a.getLooper(), this);

    /* renamed from: d  reason: collision with root package name */
    public long f3580d;

    /* renamed from: e  reason: collision with root package name */
    public long f3581e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public int l;
    public int m;
    public int n;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final a0 f3582a;

        /* renamed from: a.i.a.a0$a$a  reason: collision with other inner class name */
        public class C0085a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Message f3583a;

            public C0085a(a aVar, Message message) {
                this.f3583a = message;
            }

            public void run() {
                StringBuilder n = a.a.a.a.a.n("Unhandled stats message.");
                n.append(this.f3583a.what);
                throw new AssertionError(n.toString());
            }
        }

        public a(Looper looper, a0 a0Var) {
            super(looper);
            this.f3582a = a0Var;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f3582a.f3580d++;
            } else if (i == 1) {
                this.f3582a.f3581e++;
            } else if (i == 2) {
                a0 a0Var = this.f3582a;
                long j = (long) message.arg1;
                int i2 = a0Var.m + 1;
                a0Var.m = i2;
                long j2 = a0Var.g + j;
                a0Var.g = j2;
                a0Var.j = j2 / ((long) i2);
            } else if (i == 3) {
                a0 a0Var2 = this.f3582a;
                long j3 = (long) message.arg1;
                a0Var2.n++;
                long j4 = a0Var2.h + j3;
                a0Var2.h = j4;
                a0Var2.k = j4 / ((long) a0Var2.m);
            } else if (i != 4) {
                t.o.post(new C0085a(this, message));
            } else {
                a0 a0Var3 = this.f3582a;
                a0Var3.l++;
                long longValue = ((Long) message.obj).longValue() + a0Var3.f;
                a0Var3.f = longValue;
                a0Var3.i = longValue / ((long) a0Var3.l);
            }
        }
    }

    public a0(d dVar) {
        this.f3578b = dVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f3577a = handlerThread;
        handlerThread.start();
        g0.i(this.f3577a.getLooper());
    }

    public b0 a() {
        return new b0(this.f3578b.a(), this.f3578b.size(), this.f3580d, this.f3581e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }
}
