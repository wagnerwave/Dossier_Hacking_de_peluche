package a.e.a.a.o.i;

import a.a.a.a.a;
import a.e.a.a.h;
import a.e.a.a.o.h.i;
import android.os.Message;
import android.util.Log;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.model.BleGattProfile;

public class b extends k implements i {
    public BleConnectOptions k;
    public int l;
    public int m;

    public b(BleConnectOptions bleConnectOptions, a.e.a.a.o.j.b bVar) {
        super(bVar);
        this.k = bleConnectOptions == null ? new BleConnectOptions(new BleConnectOptions.b()) : bleConnectOptions;
    }

    public void F() {
        K();
    }

    public final void I() {
        BleGattProfile m2 = m();
        if (m2 != null) {
            this.f3251b.putParcelable("extra.gatt.profile", m2);
        }
        D(0);
    }

    public final void J() {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onServiceDiscoverFailed", new Object[0]));
        h();
        this.f.sendEmptyMessage(5);
    }

    public final void K() {
        this.f.removeCallbacksAndMessages((Object) null);
        this.m = 0;
        int o = o();
        if (o == 0) {
            this.l++;
            if (!this.f3254e.C()) {
                r();
            } else {
                this.f.sendEmptyMessageDelayed(3, (long) this.k.f4319c);
            }
        } else if (o == 2) {
            L();
        } else if (o == 19) {
            I();
        }
    }

    public final void L() {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("processDiscoverService, status = %s", h.a(o())));
        int o = o();
        if (o == 0) {
            M();
        } else if (o == 2) {
            this.m++;
            if (!k()) {
                J();
            } else {
                this.f.sendEmptyMessageDelayed(4, (long) this.k.f4320d);
            }
        } else if (o == 19) {
            I();
        }
    }

    public final void M() {
        if (this.l < this.k.f4317a + 1) {
            x(a.e.a.a.r.b.o("retry connect later", new Object[0]));
            this.f.removeCallbacksAndMessages((Object) null);
            this.f.sendEmptyMessageDelayed(1, 1000);
            return;
        }
        D(-1);
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            K();
        } else if (i == 2) {
            L();
        } else if (i == 3) {
            x(a.e.a.a.r.b.o("connect timeout", new Object[0]));
            this.f.removeCallbacksAndMessages((Object) null);
            r();
        } else if (i == 4) {
            x(a.e.a.a.r.b.o("service discover timeout", new Object[0]));
            this.f.removeCallbacksAndMessages((Object) null);
            r();
        } else if (i == 5) {
            if (this.m < this.k.f4318b + 1) {
                x(a.e.a.a.r.b.o("retry discover service later", new Object[0]));
                this.f.removeCallbacksAndMessages((Object) null);
                this.f.sendEmptyMessageDelayed(2, 1000);
            } else {
                r();
            }
        }
        super.handleMessage(message);
        return true;
    }

    public void n(int i, BleGattProfile bleGattProfile) {
        this.i.y();
        this.f.removeMessages(4);
        if (i == 0) {
            I();
        } else {
            J();
        }
    }

    public void q(boolean z) {
        this.i.y();
        this.f.removeMessages(3);
        if (z) {
            this.f.sendEmptyMessageDelayed(2, 300);
            return;
        }
        this.f.removeCallbacksAndMessages((Object) null);
        M();
    }

    public String toString() {
        StringBuilder n = a.n("BleConnectRequest{options=");
        n.append(this.k);
        n.append('}');
        return n.toString();
    }
}
