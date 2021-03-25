package a.e.a.a.o;

import a.c.a.f.b;
import a.e.a.a.h;
import a.e.a.a.m;
import a.e.a.a.o.i.k;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public class a implements Handler.Callback, m, e {

    /* renamed from: a  reason: collision with root package name */
    public List<k> f3234a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public k f3235b;

    /* renamed from: c  reason: collision with root package name */
    public g f3236c;

    /* renamed from: d  reason: collision with root package name */
    public String f3237d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f3238e;

    public a(String str) {
        this.f3237d = str;
        this.f3236c = new d(str, this);
        this.f3238e = new Handler(Looper.myLooper(), this);
    }

    public final void a(k kVar) {
        y();
        if (this.f3234a.size() < 100) {
            kVar.i = this;
            kVar.f3252c = this.f3237d;
            kVar.f3254e = this.f3236c;
            this.f3234a.add(kVar);
        } else {
            kVar.E(-8);
        }
        this.f3238e.sendEmptyMessageDelayed(18, 10);
    }

    public boolean handleMessage(Message message) {
        int i;
        if (message.what == 18 && this.f3235b == null && !b.S(this.f3234a)) {
            k remove = this.f3234a.remove(0);
            this.f3235b = remove;
            remove.i.y();
            remove.f3253d = this;
            Log.w("miio-bluetooth", a.e.a.a.r.b.o("Process %s, status = %s", remove.getClass().getSimpleName(), h.a(remove.o())));
            if (!b.P()) {
                i = -4;
            } else if (!b.Q()) {
                i = -5;
            } else {
                try {
                    remove.f3254e.A(remove);
                    remove.F();
                } catch (Throwable th) {
                    b.z(th);
                    i = -10;
                }
            }
            remove.D(i);
        }
        return true;
    }

    public void y() {
        if (Thread.currentThread() != this.f3238e.getLooper().getThread()) {
            throw new IllegalStateException("Thread Context Illegal");
        }
    }
}
