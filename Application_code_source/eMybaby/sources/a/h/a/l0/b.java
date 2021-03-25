package a.h.a.l0;

import a.c.a.d.a;
import android.os.Handler;
import android.os.Message;

public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f3512a;

    /* renamed from: b  reason: collision with root package name */
    public String f3513b;

    /* renamed from: c  reason: collision with root package name */
    public String f3514c;

    /* renamed from: d  reason: collision with root package name */
    public String f3515d;

    public b(Handler handler, String str) {
        this.f3512a = handler;
        this.f3515d = str;
    }

    public b(Handler handler, String str, String str2) {
        this.f3512a = handler;
        this.f3513b = str;
        this.f3514c = str2;
    }

    public void run() {
        Message message = new Message();
        try {
            message.obj = !a.j(this.f3515d) ? a.e.a.a.r.b.u(this.f3515d) : a.e.a.a.r.b.v(this.f3513b, this.f3514c);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            this.f3512a.sendMessage(message);
            throw th;
        }
        this.f3512a.sendMessage(message);
    }
}
