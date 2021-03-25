package a.e.a.a;

import a.e.a.a.k;
import a.e.a.a.o.j.b;
import a.e.a.a.q.c;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.search.SearchRequest;
import java.util.UUID;

public class g extends k.a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public static g f3224b;

    /* renamed from: a  reason: collision with root package name */
    public Handler f3225a = new Handler(Looper.getMainLooper(), this);

    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f3226a;

        public a(g gVar, l lVar) {
            this.f3226a = lVar;
        }

        public void onResponse(int i, Object obj) {
            Bundle bundle = (Bundle) obj;
            if (this.f3226a != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                try {
                    this.f3226a.p(i, bundle);
                } catch (Throwable th) {
                    a.c.a.f.b.z(th);
                }
            }
        }
    }

    public static g g() {
        if (f3224b == null) {
            synchronized (g.class) {
                if (f3224b == null) {
                    f3224b = new g();
                }
            }
        }
        return f3224b;
    }

    public void L(int i, Bundle bundle, l lVar) {
        Message obtainMessage = this.f3225a.obtainMessage(i, new a(this, lVar));
        bundle.setClassLoader(g.class.getClassLoader());
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public boolean handleMessage(Message message) {
        Bundle data = message.getData();
        String string = data.getString("extra.mac");
        UUID uuid = (UUID) data.getSerializable("extra.service.uuid");
        UUID uuid2 = (UUID) data.getSerializable("extra.character.uuid");
        UUID uuid3 = (UUID) data.getSerializable("extra.descriptor.uuid");
        byte[] byteArray = data.getByteArray("extra.byte.value");
        int i = data.getInt("extra.mtu", 0);
        b bVar = (b) message.obj;
        int i2 = message.what;
        switch (i2) {
            case 1:
                a.e.a.a.o.b.a(string).h((BleConnectOptions) data.getParcelable("extra.options"), bVar);
                return true;
            case 2:
                a.e.a.a.o.b.a(string).disconnect();
                return true;
            case 3:
                a.e.a.a.o.b.a(string).f(uuid, uuid2, bVar);
                return true;
            case 4:
                a.e.a.a.o.b.a(string).e(uuid, uuid2, byteArray, bVar);
                return true;
            case 5:
                a.e.a.a.o.b.a(string).i(uuid, uuid2, byteArray, bVar);
                return true;
            case 6:
                a.e.a.a.o.b.a(string).k(uuid, uuid2, bVar);
                return true;
            case 7:
                a.e.a.a.o.b.a(string).l(uuid, uuid2, bVar);
                return true;
            case 8:
                a.e.a.a.o.b.a(string).m(bVar);
                return true;
            case 9:
                a.e.a.a.o.b.a(string).a(i, bVar);
                return true;
            case 10:
                a.e.a.a.o.b.a(string).d(uuid, uuid2, bVar);
                return true;
            case 11:
                a.e.a.a.q.a.b().a(new c((SearchRequest) data.getParcelable("extra.request")), new a.e.a.a.q.b(bVar));
                return true;
            case 12:
                a.e.a.a.q.a.b().stopSearch();
                return true;
            case 13:
                a.e.a.a.o.b.a(string).q(uuid, uuid2, uuid3, bVar);
                return true;
            case 14:
                a.e.a.a.o.b.a(string).n(uuid, uuid2, uuid3, byteArray, bVar);
                return true;
            default:
                switch (i2) {
                    case 20:
                        a.e.a.a.o.b.a(string).b(data.getInt("extra.type", 0));
                        return true;
                    case 21:
                        a.e.a.a.o.b.a(string).o();
                        return true;
                    case 22:
                        a.e.a.a.o.b.a(string).j(uuid, uuid2, bVar);
                        return true;
                    case 23:
                        a.e.a.a.o.b.a(string).c();
                        return true;
                    case 24:
                        a.e.a.a.o.b.a(string).g(bVar);
                        return true;
                    case 25:
                        a.e.a.a.o.b.a(string).p(data.getInt("extra.priority", 0));
                        return true;
                    default:
                        return true;
                }
        }
    }
}
