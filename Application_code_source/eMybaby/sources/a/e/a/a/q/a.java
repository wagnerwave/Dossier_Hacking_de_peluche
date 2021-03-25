package a.e.a.a.q;

import a.e.a.a.r.c.b;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inuker.bluetooth.library.search.SearchResult;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class a implements Handler.Callback, f, b {

    /* renamed from: c  reason: collision with root package name */
    public static f f3271c;

    /* renamed from: a  reason: collision with root package name */
    public c f3272a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3273b = new Handler(Looper.getMainLooper(), this);

    /* renamed from: a.e.a.a.q.a$a  reason: collision with other inner class name */
    public class C0076a implements a.e.a.a.q.i.a {

        /* renamed from: a  reason: collision with root package name */
        public a.e.a.a.q.i.a f3274a;

        public C0076a(a.e.a.a.q.i.a aVar) {
            this.f3274a = aVar;
        }

        public void onDeviceFounded(SearchResult searchResult) {
            this.f3274a.onDeviceFounded(searchResult);
        }

        public void onSearchCanceled() {
            this.f3274a.onSearchCanceled();
            a.this.f3272a = null;
        }

        public void onSearchStarted() {
            this.f3274a.onSearchStarted();
        }

        public void onSearchStopped() {
            this.f3274a.onSearchStopped();
            a.this.f3272a = null;
        }
    }

    public static f b() {
        if (f3271c == null) {
            synchronized (a.class) {
                if (f3271c == null) {
                    a aVar = new a();
                    f3271c = (f) a.e.a.a.r.b.A(aVar, f.class, aVar);
                }
            }
        }
        return f3271c;
    }

    public void a(c cVar, a.e.a.a.q.i.a aVar) {
        Set<BluetoothDevice> bondedDevices;
        cVar.f3278b = new C0076a(aVar);
        if (!a.c.a.f.b.Q()) {
            cVar.a();
            return;
        }
        c cVar2 = this.f3272a;
        BluetoothManager bluetoothManager = null;
        if (cVar2 != null) {
            cVar2.a();
            this.f3272a = null;
        }
        if (this.f3272a == null) {
            this.f3272a = cVar;
            a.e.a.a.q.i.a aVar2 = cVar.f3278b;
            if (aVar2 != null) {
                aVar2.onSearchStarted();
            }
            boolean z = false;
            boolean z2 = false;
            for (d next : cVar.f3277a) {
                if (next.f3283a == 2) {
                    z = true;
                } else {
                    if (next.f3283a == 1) {
                        z2 = true;
                    } else {
                        throw new IllegalArgumentException("unknown search task type!");
                    }
                }
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                if (a.c.a.f.b.P()) {
                    if (a.c.a.f.b.h == null) {
                        a.c.a.f.b.h = (BluetoothManager) a.c.a.f.b.E().getSystemService("bluetooth");
                    }
                    bluetoothManager = a.c.a.f.b.h;
                }
                if (bluetoothManager != null) {
                    arrayList.addAll(bluetoothManager.getConnectedDevices(7));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    cVar.f3280d.obtainMessage(18, new SearchResult((BluetoothDevice) it.next())).sendToTarget();
                }
            }
            if (z2) {
                BluetoothAdapter D = a.c.a.f.b.D();
                ArrayList arrayList2 = new ArrayList();
                if (!(D == null || (bondedDevices = D.getBondedDevices()) == null)) {
                    arrayList2.addAll(bondedDevices);
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    cVar.f3280d.obtainMessage(18, new SearchResult((BluetoothDevice) it2.next())).sendToTarget();
                }
            }
            cVar.f3280d.sendEmptyMessageDelayed(17, 100);
        }
    }

    public boolean handleMessage(Message message) {
        a.e.a.a.r.c.a.a(message.obj);
        return true;
    }

    public void stopSearch() {
        c cVar = this.f3272a;
        if (cVar != null) {
            cVar.a();
            this.f3272a = null;
        }
    }

    public boolean x(Object obj, Method method, Object[] objArr) {
        this.f3273b.obtainMessage(0, new a.e.a.a.r.c.a(obj, method, objArr)).sendToTarget();
        return true;
    }
}
