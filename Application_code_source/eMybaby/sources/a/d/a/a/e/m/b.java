package a.d.a.a.e.m;

import a.d.a.a.e.k.l.u;
import a.d.a.a.e.k.l.v;
import a.d.a.a.e.m.g;
import a.d.a.a.e.m.k;
import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class b<T extends IInterface> {
    public static final Feature[] v = new Feature[0];

    /* renamed from: a  reason: collision with root package name */
    public k0 f1355a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1356b;

    /* renamed from: c  reason: collision with root package name */
    public final g f1357c;

    /* renamed from: d  reason: collision with root package name */
    public final a.d.a.a.e.d f1358d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f1359e;
    public final Object f = new Object();
    public final Object g = new Object();
    @GuardedBy("mServiceBrokerLock")
    public m h;
    public c i;
    @GuardedBy("mLock")
    public T j;
    public final ArrayList<g<?>> k = new ArrayList<>();
    @GuardedBy("mLock")
    public j l;
    @GuardedBy("mLock")
    public int m = 1;
    public final a n;
    public final C0060b o;
    public final int p;
    public final String q;
    public ConnectionResult r = null;
    public boolean s = false;
    public volatile zza t = null;
    public AtomicInteger u = new AtomicInteger(0);

    public interface a {
        void e(int i);

        void h(@Nullable Bundle bundle);
    }

    /* renamed from: a.d.a.a.e.m.b$b  reason: collision with other inner class name */
    public interface C0060b {
        void g(@NonNull ConnectionResult connectionResult);
    }

    public interface c {
        void a(@NonNull ConnectionResult connectionResult);
    }

    public class d implements c {
        public d() {
        }

        public void a(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.h()) {
                b bVar = b.this;
                bVar.c((j) null, bVar.o());
                return;
            }
            C0060b bVar2 = b.this.o;
            if (bVar2 != null) {
                bVar2.g(connectionResult);
            }
        }
    }

    public interface e {
    }

    public abstract class f extends g<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public final int f1361d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f1362e;

        @BinderThread
        public f(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.f1361d = i;
            this.f1362e = bundle;
        }

        /* JADX WARNING: type inference failed for: r5v12, types: [android.os.Parcelable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void b(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                int r5 = r4.f1361d
                r0 = 1
                r1 = 0
                if (r5 == 0) goto L_0x0056
                r2 = 10
                if (r5 == r2) goto L_0x0026
                a.d.a.a.e.m.b r5 = a.d.a.a.e.m.b.this
                r5.t(r0, r1)
                android.os.Bundle r5 = r4.f1362e
                if (r5 == 0) goto L_0x001e
                java.lang.String r0 = "pendingIntent"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
            L_0x001e:
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                int r0 = r4.f1361d
                r5.<init>(r0, r1)
                goto L_0x0068
            L_0x0026:
                a.d.a.a.e.m.b r5 = a.d.a.a.e.m.b.this
                r5.t(r0, r1)
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                java.lang.Class r3 = r4.getClass()
                java.lang.String r3 = r3.getSimpleName()
                r1[r2] = r3
                a.d.a.a.e.m.b r2 = a.d.a.a.e.m.b.this
                java.lang.String r2 = r2.r()
                r1[r0] = r2
                r0 = 2
                a.d.a.a.e.m.b r2 = a.d.a.a.e.m.b.this
                java.lang.String r2 = r2.q()
                r1[r0] = r2
                java.lang.String r0 = "A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. "
                java.lang.String r0 = java.lang.String.format(r0, r1)
                r5.<init>(r0)
                throw r5
            L_0x0056:
                boolean r5 = r4.d()
                if (r5 != 0) goto L_0x006b
                a.d.a.a.e.m.b r5 = a.d.a.a.e.m.b.this
                r5.t(r0, r1)
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                r0 = 8
                r5.<init>(r0, r1)
            L_0x0068:
                r4.c(r5)
            L_0x006b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.m.b.f.b(java.lang.Object):void");
        }

        public abstract void c(ConnectionResult connectionResult);

        public abstract boolean d();
    }

    public abstract class g<TListener> {

        /* renamed from: a  reason: collision with root package name */
        public TListener f1363a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1364b = false;

        public g(TListener tlistener) {
            this.f1363a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f1363a = null;
            }
            synchronized (b.this.k) {
                b.this.k.remove(this);
            }
        }

        public abstract void b(TListener tlistener);
    }

    public final class h extends a.d.a.a.h.e.d {
        public h(Looper looper) {
            super(looper);
        }

        public static void a(Message message) {
            g gVar = (g) message.obj;
            if (((f) gVar) != null) {
                gVar.a();
                return;
            }
            throw null;
        }

        public static boolean b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            if (r0 == 5) goto L_0x002b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r8) {
            /*
                r7 = this;
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.u
                int r0 = r0.get()
                int r1 = r8.arg1
                if (r0 == r1) goto L_0x0016
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x0015
                a(r8)
            L_0x0015:
                return
            L_0x0016:
                int r0 = r8.what
                r1 = 4
                r2 = 1
                r3 = 5
                r4 = 0
                if (r0 == r2) goto L_0x002b
                r5 = 7
                if (r0 == r5) goto L_0x002b
                if (r0 != r1) goto L_0x0029
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                if (r0 == 0) goto L_0x0028
                goto L_0x002b
            L_0x0028:
                throw r4
            L_0x0029:
                if (r0 != r3) goto L_0x0037
            L_0x002b:
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                boolean r0 = r0.g()
                if (r0 != 0) goto L_0x0037
                a(r8)
                return
            L_0x0037:
                int r0 = r8.what
                r5 = 8
                r6 = 3
                if (r0 != r1) goto L_0x0077
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r1.<init>(r8)
                r0.r = r1
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                boolean r8 = a.d.a.a.e.m.b.w(r8)
                if (r8 == 0) goto L_0x005b
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                boolean r0 = r8.s
                if (r0 != 0) goto L_0x005b
                r8.t(r6, r4)
                return
            L_0x005b:
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                com.google.android.gms.common.ConnectionResult r8 = r8.r
                if (r8 == 0) goto L_0x0062
                goto L_0x0067
            L_0x0062:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r5)
            L_0x0067:
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                a.d.a.a.e.m.b$c r0 = r0.i
                r0.a(r8)
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                if (r8 == 0) goto L_0x0076
                java.lang.System.currentTimeMillis()
                return
            L_0x0076:
                throw r4
            L_0x0077:
                if (r0 != r3) goto L_0x0095
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                com.google.android.gms.common.ConnectionResult r8 = r8.r
                if (r8 == 0) goto L_0x0080
                goto L_0x0085
            L_0x0080:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r5)
            L_0x0085:
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                a.d.a.a.e.m.b$c r0 = r0.i
                r0.a(r8)
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                if (r8 == 0) goto L_0x0094
                java.lang.System.currentTimeMillis()
                return
            L_0x0094:
                throw r4
            L_0x0095:
                if (r0 != r6) goto L_0x00b8
                java.lang.Object r0 = r8.obj
                boolean r1 = r0 instanceof android.app.PendingIntent
                if (r1 == 0) goto L_0x00a0
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
                goto L_0x00a1
            L_0x00a0:
                r0 = r4
            L_0x00a1:
                com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r1.<init>(r8, r0)
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                a.d.a.a.e.m.b$c r8 = r8.i
                r8.a(r1)
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                if (r8 == 0) goto L_0x00b7
                java.lang.System.currentTimeMillis()
                return
            L_0x00b7:
                throw r4
            L_0x00b8:
                r1 = 6
                if (r0 != r1) goto L_0x00d9
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                r0.t(r3, r4)
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                a.d.a.a.e.m.b$a r0 = r0.n
                if (r0 == 0) goto L_0x00cb
                int r8 = r8.arg2
                r0.e(r8)
            L_0x00cb:
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                if (r8 == 0) goto L_0x00d8
                java.lang.System.currentTimeMillis()
                a.d.a.a.e.m.b r8 = a.d.a.a.e.m.b.this
                a.d.a.a.e.m.b.v(r8, r3, r2, r4)
                return
            L_0x00d8:
                throw r4
            L_0x00d9:
                r1 = 2
                if (r0 != r1) goto L_0x00e8
                a.d.a.a.e.m.b r0 = a.d.a.a.e.m.b.this
                boolean r0 = r0.isConnected()
                if (r0 != 0) goto L_0x00e8
                a(r8)
                return
            L_0x00e8:
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x0136
                java.lang.Object r8 = r8.obj
                r0 = r8
                a.d.a.a.e.m.b$g r0 = (a.d.a.a.e.m.b.g) r0
                monitor-enter(r0)
                TListener r8 = r0.f1363a     // Catch:{ all -> 0x0133 }
                boolean r1 = r0.f1364b     // Catch:{ all -> 0x0133 }
                if (r1 == 0) goto L_0x011f
                java.lang.String r1 = "GmsClient"
                java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0133 }
                int r4 = r3.length()     // Catch:{ all -> 0x0133 }
                int r4 = r4 + 47
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
                r5.<init>(r4)     // Catch:{ all -> 0x0133 }
                java.lang.String r4 = "Callback proxy "
                r5.append(r4)     // Catch:{ all -> 0x0133 }
                r5.append(r3)     // Catch:{ all -> 0x0133 }
                java.lang.String r3 = " being reused. This is not safe."
                r5.append(r3)     // Catch:{ all -> 0x0133 }
                java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0133 }
                android.util.Log.w(r1, r3)     // Catch:{ all -> 0x0133 }
            L_0x011f:
                monitor-exit(r0)     // Catch:{ all -> 0x0133 }
                if (r8 == 0) goto L_0x0128
                r0.b(r8)     // Catch:{ RuntimeException -> 0x0126 }
                goto L_0x0128
            L_0x0126:
                r8 = move-exception
                throw r8
            L_0x0128:
                monitor-enter(r0)
                r0.f1364b = r2     // Catch:{ all -> 0x0130 }
                monitor-exit(r0)     // Catch:{ all -> 0x0130 }
                r0.a()
                return
            L_0x0130:
                r8 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0130 }
                throw r8
            L_0x0133:
                r8 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0133 }
                throw r8
            L_0x0136:
                java.lang.String r0 = "GmsClient"
                int r8 = r8.what
                r1 = 45
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "Don't know how to handle message: "
                r2.append(r1)
                r2.append(r8)
                java.lang.String r8 = r2.toString()
                java.lang.Exception r1 = new java.lang.Exception
                r1.<init>()
                android.util.Log.wtf(r0, r8, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.m.b.h.handleMessage(android.os.Message):void");
        }
    }

    public static final class i extends k.a {

        /* renamed from: a  reason: collision with root package name */
        public b f1367a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1368b;

        public i(@NonNull b bVar, int i) {
            this.f1367a = bVar;
            this.f1368b = i;
        }

        @BinderThread
        public final void g(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            a.c.a.f.b.l(this.f1367a, "onPostInitComplete can be called only once per call to getRemoteService");
            b bVar = this.f1367a;
            int i2 = this.f1368b;
            Handler handler = bVar.f1359e;
            handler.sendMessage(handler.obtainMessage(1, i2, -1, new l(i, iBinder, bundle)));
            this.f1367a = null;
        }
    }

    public final class j implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final int f1369a;

        public j(int i) {
            this.f1369a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b bVar = b.this;
            if (iBinder == null) {
                b.u(bVar);
                return;
            }
            synchronized (bVar.g) {
                b bVar2 = b.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.h = (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new l(iBinder) : (m) queryLocalInterface;
            }
            b bVar3 = b.this;
            int i = this.f1369a;
            Handler handler = bVar3.f1359e;
            handler.sendMessage(handler.obtainMessage(7, i, -1, new k(0)));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (b.this.g) {
                b.this.h = null;
            }
            Handler handler = b.this.f1359e;
            handler.sendMessage(handler.obtainMessage(6, this.f1369a, 1));
        }
    }

    public final class k extends f {
        @BinderThread
        public k(int i) {
            super(i, (Bundle) null);
        }

        public final void c(ConnectionResult connectionResult) {
            b bVar = b.this;
            if (bVar != null) {
                bVar.i.a(connectionResult);
                if (b.this != null) {
                    System.currentTimeMillis();
                    return;
                }
                throw null;
            }
            throw null;
        }

        public final boolean d() {
            b.this.i.a(ConnectionResult.f4190e);
            return true;
        }
    }

    public final class l extends f {
        public final IBinder g;

        @BinderThread
        public l(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.g = iBinder;
        }

        public final void c(ConnectionResult connectionResult) {
            C0060b bVar = b.this.o;
            if (bVar != null) {
                bVar.g(connectionResult);
            }
            if (b.this != null) {
                System.currentTimeMillis();
                return;
            }
            throw null;
        }

        public final boolean d() {
            try {
                String interfaceDescriptor = this.g.getInterfaceDescriptor();
                if (!b.this.q().equals(interfaceDescriptor)) {
                    String q = b.this.q();
                    StringBuilder sb = new StringBuilder(String.valueOf(interfaceDescriptor).length() + String.valueOf(q).length() + 34);
                    sb.append("service descriptor mismatch: ");
                    sb.append(q);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface l = b.this.l(this.g);
                if (l == null || (!b.v(b.this, 2, 4, l) && !b.v(b.this, 3, 4, l))) {
                    return false;
                }
                b bVar = b.this;
                bVar.r = null;
                a aVar = bVar.n;
                if (aVar == null) {
                    return true;
                }
                aVar.h((Bundle) null);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public b(Context context, Looper looper, g gVar, a.d.a.a.e.d dVar, int i2, a aVar, C0060b bVar, String str) {
        a.c.a.f.b.l(context, "Context must not be null");
        this.f1356b = context;
        a.c.a.f.b.l(looper, "Looper must not be null");
        Looper looper2 = looper;
        a.c.a.f.b.l(gVar, "Supervisor must not be null");
        this.f1357c = gVar;
        a.c.a.f.b.l(dVar, "API availability must not be null");
        this.f1358d = dVar;
        this.f1359e = new h(looper);
        this.p = i2;
        this.n = aVar;
        this.o = bVar;
        this.q = str;
    }

    public static void u(b bVar) {
        boolean z;
        int i2;
        synchronized (bVar.f) {
            z = bVar.m == 3;
        }
        if (z) {
            i2 = 5;
            bVar.s = true;
        } else {
            i2 = 4;
        }
        Handler handler = bVar.f1359e;
        handler.sendMessage(handler.obtainMessage(i2, bVar.u.get(), 16));
    }

    public static boolean v(b bVar, int i2, int i3, IInterface iInterface) {
        boolean z;
        synchronized (bVar.f) {
            if (bVar.m != i2) {
                z = false;
            } else {
                bVar.t(i3, iInterface);
                z = true;
            }
        }
        return z;
    }

    public static boolean w(b bVar) {
        if (bVar.s || TextUtils.isEmpty(bVar.q()) || TextUtils.isEmpty((CharSequence) null)) {
            return false;
        }
        try {
            Class.forName(bVar.q());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void a(@NonNull e eVar) {
        v vVar = (v) eVar;
        a.d.a.a.e.k.l.f.this.m.post(new u(vVar));
    }

    @WorkerThread
    public void c(j jVar, Set<Scope> set) {
        Bundle n2 = n();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.p);
        getServiceRequest.f4220d = this.f1356b.getPackageName();
        getServiceRequest.g = n2;
        if (set != null) {
            getServiceRequest.f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (j()) {
            getServiceRequest.h = m() != null ? m() : new Account("<<default account>>", "com.google");
            if (jVar != null) {
                getServiceRequest.f4221e = jVar.asBinder();
            }
        }
        Feature[] featureArr = v;
        getServiceRequest.i = featureArr;
        getServiceRequest.j = featureArr;
        try {
            synchronized (this.g) {
                if (this.h != null) {
                    this.h.E(new i(this, this.u.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Handler handler = this.f1359e;
            handler.sendMessage(handler.obtainMessage(6, this.u.get(), 1));
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            int i2 = this.u.get();
            Handler handler2 = this.f1359e;
            handler2.sendMessage(handler2.obtainMessage(1, i2, -1, new l(8, (IBinder) null, (Bundle) null)));
        }
    }

    public void disconnect() {
        this.u.incrementAndGet();
        synchronized (this.k) {
            int size = this.k.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = this.k.get(i2);
                synchronized (gVar) {
                    gVar.f1363a = null;
                }
            }
            this.k.clear();
        }
        synchronized (this.g) {
            this.h = null;
        }
        t(1, (IInterface) null);
    }

    public boolean e() {
        return true;
    }

    public abstract int f();

    public boolean g() {
        boolean z;
        synchronized (this.f) {
            if (this.m != 2) {
                if (this.m != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public String h() {
        k0 k0Var;
        if (isConnected() && (k0Var = this.f1355a) != null) {
            return k0Var.f1401b;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public void i(@NonNull c cVar) {
        a.c.a.f.b.l(cVar, "Connection progress callbacks cannot be null.");
        this.i = cVar;
        t(2, (IInterface) null);
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.f) {
            z = this.m == 4;
        }
        return z;
    }

    public boolean j() {
        return false;
    }

    public void k() {
        int b2 = this.f1358d.b(this.f1356b, f());
        if (b2 != 0) {
            t(1, (IInterface) null);
            d dVar = new d();
            a.c.a.f.b.l(dVar, "Connection progress callbacks cannot be null.");
            this.i = dVar;
            Handler handler = this.f1359e;
            handler.sendMessage(handler.obtainMessage(3, this.u.get(), b2, (Object) null));
            return;
        }
        i(new d());
    }

    @Nullable
    public abstract T l(IBinder iBinder);

    public Account m() {
        return null;
    }

    public Bundle n() {
        return new Bundle();
    }

    public Set<Scope> o() {
        return Collections.EMPTY_SET;
    }

    public final T p() {
        T t2;
        synchronized (this.f) {
            if (this.m == 5) {
                throw new DeadObjectException();
            } else if (isConnected()) {
                a.c.a.f.b.o(this.j != null, "Client is connected but service is null");
                t2 = this.j;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t2;
    }

    @NonNull
    public abstract String q();

    @NonNull
    public abstract String r();

    public void s(int i2, T t2) {
    }

    public final void t(int i2, T t2) {
        a.c.a.f.b.d((i2 == 4) == (t2 != null));
        synchronized (this.f) {
            this.m = i2;
            this.j = t2;
            s(i2, t2);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (!(this.l == null || this.f1355a == null)) {
                        String str = this.f1355a.f1400a;
                        String str2 = this.f1355a.f1401b;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 70 + String.valueOf(str2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str);
                        sb.append(" on ");
                        sb.append(str2);
                        Log.e("GmsClient", sb.toString());
                        this.f1357c.b(this.f1355a.f1400a, this.f1355a.f1401b, this.f1355a.f1402c, this.l, x(), this.f1355a.f1403d);
                        this.u.incrementAndGet();
                    }
                    this.l = new j(this.u.get());
                    k0 k0Var = new k0("com.google.android.gms", r(), false, false);
                    this.f1355a = k0Var;
                    if (!k0Var.f1403d || f() >= 17895000) {
                        if (!this.f1357c.c(new g.a(this.f1355a.f1400a, this.f1355a.f1401b, this.f1355a.f1402c, this.f1355a.f1403d), this.l, x())) {
                            String str3 = this.f1355a.f1400a;
                            String str4 = this.f1355a.f1401b;
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 34 + String.valueOf(str4).length());
                            sb2.append("unable to connect to service: ");
                            sb2.append(str3);
                            sb2.append(" on ");
                            sb2.append(str4);
                            Log.e("GmsClient", sb2.toString());
                            int i3 = this.u.get();
                            Handler handler = this.f1359e;
                            handler.sendMessage(handler.obtainMessage(7, i3, -1, new k(16)));
                        }
                    } else {
                        String valueOf = String.valueOf(this.f1355a.f1400a);
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                } else if (i2 == 4) {
                    System.currentTimeMillis();
                }
            } else if (this.l != null) {
                this.f1357c.b(this.f1355a.f1400a, this.f1355a.f1401b, this.f1355a.f1402c, this.l, x(), this.f1355a.f1403d);
                this.l = null;
            }
        }
    }

    @Nullable
    public final String x() {
        String str = this.q;
        return str == null ? this.f1356b.getClass().getName() : str;
    }
}
