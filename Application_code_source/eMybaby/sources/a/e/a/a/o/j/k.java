package a.e.a.a.o.j;

import a.e.a.a.l;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class k extends l.a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public Handler f3258a;

    public k() {
        if (Looper.myLooper() != null) {
            this.f3258a = new Handler(Looper.myLooper(), this);
            return;
        }
        throw new RuntimeException();
    }

    public abstract void g(int i, Bundle bundle);

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            g(message.arg1, (Bundle) message.obj);
        }
        return true;
    }

    public void p(int i, Bundle bundle) {
        this.f3258a.obtainMessage(1, i, 0, bundle).sendToTarget();
    }
}
