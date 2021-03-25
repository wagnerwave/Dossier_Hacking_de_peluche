package a.e.a.a.o.i;

import a.e.a.a.m;
import a.e.a.a.o.e;
import a.e.a.a.o.g;
import a.e.a.a.o.h.c;
import a.e.a.a.o.j.b;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.inuker.bluetooth.library.model.BleGattProfile;
import java.util.UUID;

public abstract class k implements Handler.Callback, m, g, c {

    /* renamed from: a  reason: collision with root package name */
    public b f3250a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f3251b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public String f3252c;

    /* renamed from: d  reason: collision with root package name */
    public e f3253d;

    /* renamed from: e  reason: collision with root package name */
    public g f3254e;
    public Handler f = new Handler(Looper.myLooper(), this);
    public Handler g = new Handler(Looper.getMainLooper());
    public boolean h;
    public m i;
    public boolean j;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3255a;

        public a(int i) {
            this.f3255a = i;
        }

        public void run() {
            try {
                if (k.this.f3250a != null) {
                    k.this.f3250a.onResponse(this.f3255a, k.this.f3251b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public k(b bVar) {
        this.f3250a = bVar;
    }

    public void A(c cVar) {
        this.f3254e.A(cVar);
    }

    public void B(c cVar) {
        this.f3254e.B(cVar);
    }

    public boolean C() {
        return this.f3254e.C();
    }

    public void D(int i2) {
        this.i.y();
        x(a.e.a.a.r.b.o("request complete: code = %d", Integer.valueOf(i2)));
        this.f.removeCallbacksAndMessages((Object) null);
        this.f3254e.B(this);
        E(i2);
        a.e.a.a.o.a aVar = (a.e.a.a.o.a) this.f3253d;
        aVar.y();
        if (this == aVar.f3235b) {
            aVar.f3235b = null;
            aVar.f3238e.sendEmptyMessageDelayed(18, 10);
            return;
        }
        throw new IllegalStateException("request not match");
    }

    public void E(int i2) {
        if (!this.j) {
            this.j = true;
            this.g.post(new a(i2));
        }
    }

    public abstract void F();

    public void G() {
        this.f.sendEmptyMessageDelayed(32, 30000);
    }

    public void H() {
        this.f.removeMessages(32);
    }

    public void disconnect() {
        x(a.e.a.a.r.b.o("disconnect gatt", new Object[0]));
        this.f3254e.disconnect();
    }

    public boolean g(UUID uuid, UUID uuid2) {
        return this.f3254e.g(uuid, uuid2);
    }

    public boolean h() {
        return this.f3254e.h();
    }

    public boolean handleMessage(Message message) {
        if (message.what == 32) {
            this.h = true;
            r();
        }
        return true;
    }

    public boolean i(int i2) {
        return this.f3254e.i(i2);
    }

    public boolean j(UUID uuid, UUID uuid2, UUID uuid3) {
        return this.f3254e.j(uuid, uuid2, uuid3);
    }

    public boolean k() {
        return this.f3254e.k();
    }

    public boolean l(UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        return this.f3254e.l(uuid, uuid2, uuid3, bArr);
    }

    public BleGattProfile m() {
        return this.f3254e.m();
    }

    public int o() {
        return this.f3254e.o();
    }

    public boolean p(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.f3254e.p(uuid, uuid2, bArr);
    }

    public void q(boolean z) {
        if (!z) {
            D(this.h ? -7 : -1);
        }
    }

    public void r() {
        x(a.e.a.a.r.b.o("close gatt", new Object[0]));
        this.f3254e.r();
    }

    public void s(int i2) {
        this.f3254e.s(i2);
    }

    public void t() {
        this.i.y();
        x(a.e.a.a.r.b.o("request canceled", new Object[0]));
        this.f.removeCallbacksAndMessages((Object) null);
        this.f3254e.B(this);
        E(-2);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public boolean u() {
        return this.f3254e.u();
    }

    public boolean v(UUID uuid, UUID uuid2, boolean z) {
        return this.f3254e.v(uuid, uuid2, z);
    }

    public boolean w(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.f3254e.w(uuid, uuid2, bArr);
    }

    public void x(String str) {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("%s %s >>> %s", getClass().getSimpleName(), this.f3252c, str));
    }

    public void y() {
        this.i.y();
    }

    public boolean z(UUID uuid, UUID uuid2, boolean z) {
        return this.f3254e.z(uuid, uuid2, z);
    }
}
