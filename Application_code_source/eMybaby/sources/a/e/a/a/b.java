package a.e.a.a;

import a.e.a.a.k;
import a.e.a.a.o.j.k;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.inuker.bluetooth.library.BluetoothService;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class b implements Handler.Callback, j, a.e.a.a.r.c.b {
    public static final String k = b.class.getSimpleName();
    public static volatile j l;

    /* renamed from: a  reason: collision with root package name */
    public Context f3192a;

    /* renamed from: b  reason: collision with root package name */
    public volatile k f3193b;

    /* renamed from: c  reason: collision with root package name */
    public CountDownLatch f3194c;

    /* renamed from: d  reason: collision with root package name */
    public final ServiceConnection f3195d = new d();

    /* renamed from: e  reason: collision with root package name */
    public HandlerThread f3196e;
    public Handler f;
    public HashMap<String, HashMap<String, List<a.e.a.a.o.j.d>>> g;
    public HashMap<String, List<a.e.a.a.o.h.a>> h;
    public List<a.e.a.a.o.h.b> i;
    public List<a.e.a.a.p.i.d> j;

    public class a extends k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3197b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UUID f3198c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UUID f3199d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.h f3200e;

        public a(String str, UUID uuid, UUID uuid2, a.e.a.a.o.j.h hVar) {
            this.f3197b = str;
            this.f3198c = uuid;
            this.f3199d = uuid2;
            this.f3200e = hVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            b bVar = b.this;
            String str = this.f3197b;
            UUID uuid = this.f3198c;
            UUID uuid2 = this.f3199d;
            bVar.p(true);
            HashMap hashMap = bVar.g.get(str);
            if (hashMap != null) {
                hashMap.remove(bVar.q(uuid, uuid2));
            }
            a.e.a.a.o.j.h hVar = this.f3200e;
            if (hVar != null) {
                hVar.onResponse(i);
            }
        }
    }

    /* renamed from: a.e.a.a.b$b  reason: collision with other inner class name */
    public class C0073b extends k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.c f3201b;

        public C0073b(a.e.a.a.o.j.c cVar) {
            this.f3201b = cVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            a.e.a.a.o.j.c cVar = this.f3201b;
            if (cVar != null) {
                cVar.onResponse(i, Integer.valueOf(bundle.getInt("extra.mtu")));
            }
        }
    }

    public class c extends k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.q.i.b f3203b;

        public c(a.e.a.a.q.i.b bVar) {
            this.f3203b = bVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            if (this.f3203b != null) {
                bundle.setClassLoader(c.class.getClassLoader());
                if (i == 1) {
                    this.f3203b.onSearchStarted();
                } else if (i == 2) {
                    this.f3203b.onSearchStopped();
                } else if (i == 3) {
                    this.f3203b.onSearchCanceled();
                } else if (i == 4) {
                    this.f3203b.onDeviceFounded((SearchResult) bundle.getParcelable("extra.search.result"));
                } else {
                    throw new IllegalStateException("unknown code");
                }
            }
        }
    }

    public class d implements ServiceConnection {
        public d() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.v("miio-bluetooth", a.e.a.a.r.b.o("onServiceConnected", new Object[0]));
            b.this.f3193b = k.a.e(iBinder);
            b bVar = b.this;
            CountDownLatch countDownLatch = bVar.f3194c;
            if (countDownLatch != null) {
                countDownLatch.countDown();
                bVar.f3194c = null;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.v("miio-bluetooth", a.e.a.a.r.b.o("onServiceDisconnected", new Object[0]));
            b.this.f3193b = null;
        }
    }

    public class e extends a.e.a.a.o.j.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.a f3206b;

        public e(a.e.a.a.o.j.a aVar) {
            this.f3206b = aVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            if (this.f3206b != null) {
                bundle.setClassLoader(e.class.getClassLoader());
                this.f3206b.onResponse(i, (BleGattProfile) bundle.getParcelable("extra.gatt.profile"));
            }
        }
    }

    public class f extends a.e.a.a.o.j.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.a f3208b;

        public f(a.e.a.a.o.j.a aVar) {
            this.f3208b = aVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            if (this.f3208b != null) {
                bundle.setClassLoader(f.class.getClassLoader());
                this.f3208b.onResponse(i, (BleGattProfile) bundle.getParcelable("extra.gatt.profile"));
            }
        }
    }

    public class g extends a.e.a.a.o.j.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.e f3210b;

        public g(a.e.a.a.o.j.e eVar) {
            this.f3210b = eVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            a.e.a.a.o.j.e eVar = this.f3210b;
            if (eVar != null) {
                eVar.onResponse(i, bundle.getByteArray("extra.byte.value"));
            }
        }
    }

    public class h extends a.e.a.a.o.j.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.i f3212b;

        public h(a.e.a.a.o.j.i iVar) {
            this.f3212b = iVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            a.e.a.a.o.j.i iVar = this.f3212b;
            if (iVar != null) {
                iVar.onResponse(i);
            }
        }
    }

    public class i extends a.e.a.a.o.j.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.i f3214b;

        public i(a.e.a.a.o.j.i iVar) {
            this.f3214b = iVar;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            a.e.a.a.o.j.i iVar = this.f3214b;
            if (iVar != null) {
                iVar.onResponse(i);
            }
        }
    }

    public class j extends a.e.a.a.o.j.k {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e.a.a.o.j.d f3216b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f3217c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UUID f3218d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UUID f3219e;

        public j(a.e.a.a.o.j.d dVar, String str, UUID uuid, UUID uuid2) {
            this.f3216b = dVar;
            this.f3217c = str;
            this.f3218d = uuid;
            this.f3219e = uuid2;
        }

        public void g(int i, Bundle bundle) {
            b.this.p(true);
            a.e.a.a.o.j.d dVar = this.f3216b;
            if (dVar != null) {
                if (i == 0) {
                    b bVar = b.this;
                    String str = this.f3217c;
                    UUID uuid = this.f3218d;
                    UUID uuid2 = this.f3219e;
                    bVar.p(true);
                    HashMap hashMap = bVar.g.get(str);
                    if (hashMap == null) {
                        hashMap = new HashMap();
                        bVar.g.put(str, hashMap);
                    }
                    String q = bVar.q(uuid, uuid2);
                    List list = (List) hashMap.get(q);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(q, list);
                    }
                    list.add(dVar);
                }
                this.f3216b.onResponse(i);
            }
        }
    }

    public b(Context context) {
        this.f3192a = context.getApplicationContext();
        i.a().f3230a = this.f3192a;
        HandlerThread handlerThread = new HandlerThread(k);
        this.f3196e = handlerThread;
        handlerThread.start();
        this.f = new Handler(this.f3196e.getLooper(), this);
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new LinkedList();
        this.j = new LinkedList();
        this.f.obtainMessage(2).sendToTarget();
    }

    public static j s(Context context) {
        if (l == null) {
            synchronized (b.class) {
                if (l == null) {
                    b bVar = new b(context);
                    l = (j) a.e.a.a.r.b.B(bVar, j.class, bVar, true, false);
                }
            }
        }
        return l;
    }

    public void a(String str, UUID uuid, UUID uuid2, byte[] bArr, a.e.a.a.o.j.i iVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        bundle.putByteArray("extra.byte.value", bArr);
        t(4, bundle, new h(iVar));
    }

    public void b(String str, a.e.a.a.o.h.a aVar) {
        p(true);
        List list = this.h.get(str);
        if (aVar != null && !a.c.a.f.b.S(list)) {
            list.remove(aVar);
        }
    }

    public void c(String str, UUID uuid, UUID uuid2, a.e.a.a.o.j.h hVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        t(7, bundle, new a(str, uuid, uuid2, hVar));
    }

    public void d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        t(2, bundle, (a.e.a.a.o.j.k) null);
        p(true);
        this.g.remove(str);
    }

    public void e(String str, int i2, a.e.a.a.o.j.c cVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putInt("extra.mtu", i2);
        t(9, bundle, new C0073b(cVar));
    }

    public void f(String str) {
        p(true);
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        t(21, bundle, (a.e.a.a.o.j.k) null);
    }

    public void g(String str, a.e.a.a.o.j.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        t(24, bundle, new f(aVar));
    }

    public void h(String str, UUID uuid, UUID uuid2, byte[] bArr, a.e.a.a.o.j.i iVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        bundle.putByteArray("extra.byte.value", bArr);
        t(5, bundle, new i(iVar));
    }

    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a.e.a.a.r.c.a.a(message.obj);
        } else if (i2 == 2) {
            p(true);
            a.e.a.a.p.g a2 = a.e.a.a.p.e.a();
            ((a.e.a.a.p.e) a2).f3265b.obtainMessage(1, new c(this)).sendToTarget();
            a.e.a.a.p.g a3 = a.e.a.a.p.e.a();
            ((a.e.a.a.p.e) a3).f3265b.obtainMessage(1, new d(this)).sendToTarget();
            a.e.a.a.p.g a4 = a.e.a.a.p.e.a();
            ((a.e.a.a.p.e) a4).f3265b.obtainMessage(1, new e(this)).sendToTarget();
            a.e.a.a.p.g a5 = a.e.a.a.p.e.a();
            ((a.e.a.a.p.e) a5).f3265b.obtainMessage(1, new f(this)).sendToTarget();
        }
        return true;
    }

    public void i(a.e.a.a.o.h.b bVar) {
        p(true);
        if (bVar != null) {
            this.i.remove(bVar);
        }
    }

    public void j(String str, UUID uuid, UUID uuid2, a.e.a.a.o.j.d dVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        t(22, bundle, new j(dVar, str, uuid, uuid2));
    }

    public void k(String str, UUID uuid, UUID uuid2, a.e.a.a.o.j.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        t(3, bundle, new g(eVar));
    }

    public void l(String str, a.e.a.a.o.h.a aVar) {
        p(true);
        List list = this.h.get(str);
        if (list == null) {
            list = new ArrayList();
            this.h.put(str, list);
        }
        if (aVar != null && !list.contains(aVar)) {
            list.add(aVar);
        }
    }

    public void m(SearchRequest searchRequest, a.e.a.a.q.i.b bVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra.request", searchRequest);
        t(11, bundle, new c(bVar));
    }

    public void n(a.e.a.a.o.h.b bVar) {
        p(true);
        if (bVar != null && !this.i.contains(bVar)) {
            this.i.add(bVar);
        }
    }

    public void o(String str, BleConnectOptions bleConnectOptions, a.e.a.a.o.j.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.mac", str);
        bundle.putParcelable("extra.options", bleConnectOptions);
        t(1, bundle, new e(aVar));
    }

    public final void p(boolean z) {
        if (Looper.myLooper() != (z ? this.f.getLooper() : Looper.getMainLooper())) {
            throw new RuntimeException();
        }
    }

    public final String q(UUID uuid, UUID uuid2) {
        return a.e.a.a.r.b.o("%s_%s", uuid, uuid2);
    }

    public final k r() {
        if (this.f3193b == null) {
            p(true);
            Log.v("miio-bluetooth", a.e.a.a.r.b.o("bindServiceSync", new Object[0]));
            this.f3194c = new CountDownLatch(1);
            Intent intent = new Intent();
            intent.setClass(this.f3192a, BluetoothService.class);
            if (this.f3192a.bindService(intent, this.f3195d, 1)) {
                Log.v("miio-bluetooth", a.e.a.a.r.b.o("BluetoothService registered", new Object[0]));
                try {
                    if (this.f3194c != null) {
                        this.f3194c.await();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                Log.v("miio-bluetooth", a.e.a.a.r.b.o("BluetoothService not registered", new Object[0]));
                this.f3193b = g.g();
            }
        }
        return this.f3193b;
    }

    public void stopSearch() {
        t(12, (Bundle) null, (a.e.a.a.o.j.k) null);
    }

    public final void t(int i2, Bundle bundle, a.e.a.a.o.j.k kVar) {
        p(true);
        try {
            k r = r();
            Log.v("miio-bluetooth", a.e.a.a.r.b.o("IBluetoothService = %s", r));
            if (r != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                r.L(i2, bundle, kVar);
                return;
            }
            kVar.p(-6, (Bundle) null);
        } catch (Throwable th) {
            a.c.a.f.b.z(th);
        }
    }

    public boolean x(Object obj, Method method, Object[] objArr) {
        this.f.obtainMessage(1, new a.e.a.a.r.c.a(obj, method, objArr)).sendToTarget();
        return true;
    }
}
