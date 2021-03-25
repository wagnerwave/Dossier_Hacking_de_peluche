package a.h.a.l0;

import a.e.a.a.r.b;
import android.os.Handler;
import android.os.Message;
import e.a.a.s;
import java.util.List;

public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f3509a;

    /* renamed from: b  reason: collision with root package name */
    public List<s> f3510b;

    /* renamed from: c  reason: collision with root package name */
    public String f3511c;

    public a(Handler handler, List<s> list, String str) {
        this.f3509a = handler;
        this.f3510b = list;
        this.f3511c = str;
    }

    public void run() {
        Message message = new Message();
        try {
            message.obj = b.x(this.f3510b, this.f3511c);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            this.f3509a.sendMessage(message);
            throw th;
        }
        this.f3509a.sendMessage(message);
    }
}
