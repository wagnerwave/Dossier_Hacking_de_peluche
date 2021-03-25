package a.i.a;

import a.i.a.t;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final b f3611a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3612b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f3613c;

    /* renamed from: d  reason: collision with root package name */
    public final j f3614d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, c> f3615e = new LinkedHashMap();
    public final Map<Object, a> f = new WeakHashMap();
    public final Map<Object, a> g = new WeakHashMap();
    public final Set<Object> h = new HashSet();
    public final Handler i = new a(this.f3611a.getLooper(), this);
    public final Handler j;
    public final d k;
    public final a0 l;
    public final List<c> m;
    public final c n;
    public final boolean o;
    public boolean p;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final i f3616a;

        /* renamed from: a.i.a.i$a$a  reason: collision with other inner class name */
        public class C0087a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Message f3617a;

            public C0087a(a aVar, Message message) {
                this.f3617a = message;
            }

            public void run() {
                StringBuilder n = a.a.a.a.a.n("Unknown handler message received: ");
                n.append(this.f3617a.what);
                throw new AssertionError(n.toString());
            }
        }

        public a(Looper looper, i iVar) {
            super(looper);
            this.f3616a = iVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v37, resolved type: java.util.ArrayList} */
        /* JADX WARNING: type inference failed for: r6v36, types: [java.util.List] */
        /* JADX WARNING: type inference failed for: r6v40 */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0034, code lost:
            r6 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x017a, code lost:
            if (r7 != 12) goto L_0x0180;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                int r2 = r1.what
                java.lang.String r3 = "canceled"
                java.lang.String r4 = ""
                java.lang.String r5 = "Dispatcher"
                r6 = 0
                switch(r2) {
                    case 1: goto L_0x0399;
                    case 2: goto L_0x0323;
                    case 3: goto L_0x0010;
                    case 4: goto L_0x02e5;
                    case 5: goto L_0x0237;
                    case 6: goto L_0x022b;
                    case 7: goto L_0x01c7;
                    case 8: goto L_0x0010;
                    case 9: goto L_0x0144;
                    case 10: goto L_0x0136;
                    case 11: goto L_0x0066;
                    case 12: goto L_0x001c;
                    default: goto L_0x0010;
                }
            L_0x0010:
                android.os.Handler r2 = a.i.a.t.o
                a.i.a.i$a$a r3 = new a.i.a.i$a$a
                r3.<init>(r0, r1)
                r2.post(r3)
                goto L_0x03a3
            L_0x001c:
                java.lang.Object r1 = r1.obj
                a.i.a.i r2 = r0.f3616a
                java.util.Set<java.lang.Object> r3 = r2.h
                boolean r3 = r3.remove(r1)
                if (r3 != 0) goto L_0x002a
                goto L_0x03a3
            L_0x002a:
                java.util.Map<java.lang.Object, a.i.a.a> r3 = r2.g
                java.util.Collection r3 = r3.values()
                java.util.Iterator r3 = r3.iterator()
            L_0x0034:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0057
                java.lang.Object r4 = r3.next()
                a.i.a.a r4 = (a.i.a.a) r4
                java.lang.Object r5 = r4.j
                boolean r5 = r5.equals(r1)
                if (r5 == 0) goto L_0x0034
                if (r6 != 0) goto L_0x0050
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                r6 = r5
            L_0x0050:
                r6.add(r4)
                r3.remove()
                goto L_0x0034
            L_0x0057:
                if (r6 == 0) goto L_0x03a3
                android.os.Handler r1 = r2.j
                r2 = 13
                android.os.Message r2 = r1.obtainMessage(r2, r6)
                r1.sendMessage(r2)
                goto L_0x03a3
            L_0x0066:
                java.lang.Object r1 = r1.obj
                a.i.a.i r2 = r0.f3616a
                java.util.Set<java.lang.Object> r4 = r2.h
                boolean r4 = r4.add(r1)
                if (r4 != 0) goto L_0x0074
                goto L_0x03a3
            L_0x0074:
                java.util.Map<java.lang.String, a.i.a.c> r4 = r2.f3615e
                java.util.Collection r4 = r4.values()
                java.util.Iterator r4 = r4.iterator()
            L_0x007e:
                boolean r6 = r4.hasNext()
                if (r6 == 0) goto L_0x03a3
                java.lang.Object r6 = r4.next()
                a.i.a.c r6 = (a.i.a.c) r6
                a.i.a.t r9 = r6.f3591b
                boolean r9 = r9.n
                a.i.a.a r10 = r6.k
                java.util.List<a.i.a.a> r11 = r6.l
                if (r11 == 0) goto L_0x009c
                boolean r12 = r11.isEmpty()
                if (r12 != 0) goto L_0x009c
                r12 = 1
                goto L_0x009d
            L_0x009c:
                r12 = 0
            L_0x009d:
                if (r10 != 0) goto L_0x00a2
                if (r12 != 0) goto L_0x00a2
                goto L_0x007e
            L_0x00a2:
                java.lang.String r13 = "' was paused"
                java.lang.String r14 = "because tag '"
                java.lang.String r15 = "paused"
                if (r10 == 0) goto L_0x00db
                java.lang.Object r8 = r10.j
                boolean r8 = r8.equals(r1)
                if (r8 == 0) goto L_0x00db
                r6.d(r10)
                java.util.Map<java.lang.Object, a.i.a.a> r8 = r2.g
                java.lang.Object r7 = r10.d()
                r8.put(r7, r10)
                if (r9 == 0) goto L_0x00db
                a.i.a.w r7 = r10.f3572b
                java.lang.String r7 = r7.b()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r14)
                r8.append(r1)
                r8.append(r13)
                java.lang.String r8 = r8.toString()
                a.i.a.g0.p(r5, r15, r7, r8)
            L_0x00db:
                if (r12 == 0) goto L_0x0120
                int r7 = r11.size()
                r8 = 1
                int r7 = r7 - r8
            L_0x00e3:
                if (r7 < 0) goto L_0x0120
                java.lang.Object r8 = r11.get(r7)
                a.i.a.a r8 = (a.i.a.a) r8
                java.lang.Object r10 = r8.j
                boolean r10 = r10.equals(r1)
                if (r10 != 0) goto L_0x00f4
                goto L_0x011d
            L_0x00f4:
                r6.d(r8)
                java.util.Map<java.lang.Object, a.i.a.a> r10 = r2.g
                java.lang.Object r12 = r8.d()
                r10.put(r12, r8)
                if (r9 == 0) goto L_0x011d
                a.i.a.w r8 = r8.f3572b
                java.lang.String r8 = r8.b()
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r14)
                r10.append(r1)
                r10.append(r13)
                java.lang.String r10 = r10.toString()
                a.i.a.g0.p(r5, r15, r8, r10)
            L_0x011d:
                int r7 = r7 + -1
                goto L_0x00e3
            L_0x0120:
                boolean r7 = r6.b()
                if (r7 == 0) goto L_0x007e
                r4.remove()
                if (r9 == 0) goto L_0x007e
                java.lang.String r6 = a.i.a.g0.k(r6)
                java.lang.String r7 = "all actions paused"
                a.i.a.g0.p(r5, r3, r6, r7)
                goto L_0x007e
            L_0x0136:
                a.i.a.i r2 = r0.f3616a
                int r1 = r1.arg1
                r3 = 1
                if (r1 != r3) goto L_0x013f
                r7 = 1
                goto L_0x0140
            L_0x013f:
                r7 = 0
            L_0x0140:
                r2.p = r7
                goto L_0x03a3
            L_0x0144:
                java.lang.Object r1 = r1.obj
                android.net.NetworkInfo r1 = (android.net.NetworkInfo) r1
                a.i.a.i r2 = r0.f3616a
                java.util.concurrent.ExecutorService r3 = r2.f3613c
                boolean r7 = r3 instanceof a.i.a.v
                if (r7 == 0) goto L_0x0188
                a.i.a.v r3 = (a.i.a.v) r3
                if (r3 == 0) goto L_0x0187
                r6 = 3
                if (r1 == 0) goto L_0x0180
                boolean r7 = r1.isConnectedOrConnecting()
                if (r7 != 0) goto L_0x015e
                goto L_0x0180
            L_0x015e:
                int r7 = r1.getType()
                if (r7 == 0) goto L_0x0171
                r8 = 1
                if (r7 == r8) goto L_0x016f
                r8 = 6
                if (r7 == r8) goto L_0x016f
                r8 = 9
                if (r7 == r8) goto L_0x016f
                goto L_0x0180
            L_0x016f:
                r6 = 4
                goto L_0x0180
            L_0x0171:
                int r7 = r1.getSubtype()
                switch(r7) {
                    case 1: goto L_0x017d;
                    case 2: goto L_0x017d;
                    case 3: goto L_0x017f;
                    case 4: goto L_0x017f;
                    case 5: goto L_0x017f;
                    case 6: goto L_0x017f;
                    default: goto L_0x0178;
                }
            L_0x0178:
                r8 = 12
                if (r7 == r8) goto L_0x017f
                goto L_0x0180
            L_0x017d:
                r6 = 1
                goto L_0x0180
            L_0x017f:
                r6 = 2
            L_0x0180:
                r3.setCorePoolSize(r6)
                r3.setMaximumPoolSize(r6)
                goto L_0x0188
            L_0x0187:
                throw r6
            L_0x0188:
                if (r1 == 0) goto L_0x03a3
                boolean r1 = r1.isConnected()
                if (r1 == 0) goto L_0x03a3
                java.util.Map<java.lang.Object, a.i.a.a> r1 = r2.f
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L_0x03a3
                java.util.Map<java.lang.Object, a.i.a.a> r1 = r2.f
                java.util.Collection r1 = r1.values()
                java.util.Iterator r1 = r1.iterator()
            L_0x01a2:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x03a3
                java.lang.Object r3 = r1.next()
                a.i.a.a r3 = (a.i.a.a) r3
                r1.remove()
                a.i.a.t r6 = r3.f3571a
                boolean r6 = r6.n
                if (r6 == 0) goto L_0x01c2
                a.i.a.w r6 = r3.f3572b
                java.lang.String r6 = r6.b()
                java.lang.String r7 = "replaying"
                a.i.a.g0.p(r5, r7, r6, r4)
            L_0x01c2:
                r6 = 0
                r2.f(r3, r6)
                goto L_0x01a2
            L_0x01c7:
                a.i.a.i r1 = r0.f3616a
                if (r1 == 0) goto L_0x022a
                java.util.ArrayList r2 = new java.util.ArrayList
                java.util.List<a.i.a.c> r3 = r1.m
                r2.<init>(r3)
                java.util.List<a.i.a.c> r3 = r1.m
                r3.clear()
                android.os.Handler r1 = r1.j
                r3 = 8
                android.os.Message r3 = r1.obtainMessage(r3, r2)
                r1.sendMessage(r3)
                boolean r1 = r2.isEmpty()
                if (r1 == 0) goto L_0x01ea
                goto L_0x03a3
            L_0x01ea:
                r1 = 0
                java.lang.Object r1 = r2.get(r1)
                a.i.a.c r1 = (a.i.a.c) r1
                a.i.a.t r1 = r1.f3591b
                boolean r1 = r1.n
                if (r1 == 0) goto L_0x03a3
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.util.Iterator r2 = r2.iterator()
            L_0x0200:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x021f
                java.lang.Object r3 = r2.next()
                a.i.a.c r3 = (a.i.a.c) r3
                int r6 = r1.length()
                if (r6 <= 0) goto L_0x0217
                java.lang.String r6 = ", "
                r1.append(r6)
            L_0x0217:
                java.lang.String r3 = a.i.a.g0.k(r3)
                r1.append(r3)
                goto L_0x0200
            L_0x021f:
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "delivered"
                a.i.a.g0.p(r5, r2, r1, r4)
                goto L_0x03a3
            L_0x022a:
                throw r6
            L_0x022b:
                java.lang.Object r1 = r1.obj
                a.i.a.c r1 = (a.i.a.c) r1
                a.i.a.i r2 = r0.f3616a
                r3 = 0
                r2.e(r1, r3)
                goto L_0x03a3
            L_0x0237:
                java.lang.Object r1 = r1.obj
                a.i.a.c r1 = (a.i.a.c) r1
                a.i.a.i r2 = r0.f3616a
                if (r2 == 0) goto L_0x02e4
                java.util.concurrent.Future<?> r3 = r1.n
                if (r3 == 0) goto L_0x024b
                boolean r3 = r3.isCancelled()
                if (r3 == 0) goto L_0x024b
                r3 = 1
                goto L_0x024c
            L_0x024b:
                r3 = 0
            L_0x024c:
                if (r3 == 0) goto L_0x0250
                goto L_0x03a3
            L_0x0250:
                java.util.concurrent.ExecutorService r3 = r2.f3613c
                boolean r3 = r3.isShutdown()
                r8 = 0
                if (r3 == 0) goto L_0x025e
                r2.e(r1, r8)
                goto L_0x03a3
            L_0x025e:
                boolean r3 = r2.o
                if (r3 == 0) goto L_0x0270
                android.content.Context r3 = r2.f3612b
                java.lang.String r6 = "connectivity"
                java.lang.Object r3 = a.i.a.g0.n(r3, r6)
                android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
                android.net.NetworkInfo r6 = r3.getActiveNetworkInfo()
            L_0x0270:
                if (r6 == 0) goto L_0x027a
                boolean r3 = r6.isConnected()
                if (r3 == 0) goto L_0x027a
                r3 = 1
                goto L_0x027b
            L_0x027a:
                r3 = 0
            L_0x027b:
                boolean r7 = r2.p
                int r9 = r1.r
                if (r9 <= 0) goto L_0x0283
                r9 = 1
                goto L_0x0284
            L_0x0283:
                r9 = 0
            L_0x0284:
                if (r9 != 0) goto L_0x0288
                r6 = 0
                goto L_0x0294
            L_0x0288:
                int r9 = r1.r
                r10 = 1
                int r9 = r9 - r10
                r1.r = r9
                a.i.a.y r9 = r1.j
                boolean r6 = r9.g(r7, r6)
            L_0x0294:
                a.i.a.y r7 = r1.j
                boolean r7 = r7.h()
                if (r6 != 0) goto L_0x02af
                boolean r3 = r2.o
                if (r3 == 0) goto L_0x02a4
                if (r7 == 0) goto L_0x02a4
                r7 = 1
                goto L_0x02a5
            L_0x02a4:
                r7 = 0
            L_0x02a5:
                r2.e(r1, r7)
                if (r7 == 0) goto L_0x03a3
            L_0x02aa:
                r2.d(r1)
                goto L_0x03a3
            L_0x02af:
                boolean r6 = r2.o
                if (r6 == 0) goto L_0x02bc
                if (r3 == 0) goto L_0x02b6
                goto L_0x02bc
            L_0x02b6:
                r2.e(r1, r7)
                if (r7 == 0) goto L_0x03a3
                goto L_0x02aa
            L_0x02bc:
                a.i.a.t r3 = r1.f3591b
                boolean r3 = r3.n
                if (r3 == 0) goto L_0x02cb
                java.lang.String r3 = a.i.a.g0.k(r1)
                java.lang.String r6 = "retrying"
                a.i.a.g0.p(r5, r6, r3, r4)
            L_0x02cb:
                java.lang.Exception r3 = r1.p
                boolean r3 = r3 instanceof a.i.a.r.a
                if (r3 == 0) goto L_0x02da
                int r3 = r1.i
                a.i.a.q r4 = a.i.a.q.NO_CACHE
                int r4 = r4.f3649a
                r3 = r3 | r4
                r1.i = r3
            L_0x02da:
                java.util.concurrent.ExecutorService r2 = r2.f3613c
                java.util.concurrent.Future r2 = r2.submit(r1)
                r1.n = r2
                goto L_0x03a3
            L_0x02e4:
                throw r6
            L_0x02e5:
                r8 = 0
                java.lang.Object r1 = r1.obj
                a.i.a.c r1 = (a.i.a.c) r1
                a.i.a.i r2 = r0.f3616a
                if (r2 == 0) goto L_0x0322
                int r3 = r1.h
                a.i.a.p r4 = a.i.a.p.NO_STORE
                int r4 = r4.f3644a
                r3 = r3 & r4
                if (r3 != 0) goto L_0x02f9
                r7 = 1
                goto L_0x02fa
            L_0x02f9:
                r7 = 0
            L_0x02fa:
                if (r7 == 0) goto L_0x0305
                a.i.a.d r3 = r2.k
                java.lang.String r4 = r1.f
                android.graphics.Bitmap r6 = r1.m
                r3.b(r4, r6)
            L_0x0305:
                java.util.Map<java.lang.String, a.i.a.c> r3 = r2.f3615e
                java.lang.String r4 = r1.f
                r3.remove(r4)
                r2.a(r1)
                a.i.a.t r2 = r1.f3591b
                boolean r2 = r2.n
                if (r2 == 0) goto L_0x03a3
                java.lang.String r1 = a.i.a.g0.k(r1)
                java.lang.String r2 = "batched"
                java.lang.String r3 = "for completion"
                a.i.a.g0.p(r5, r2, r1, r3)
                goto L_0x03a3
            L_0x0322:
                throw r6
            L_0x0323:
                java.lang.Object r1 = r1.obj
                a.i.a.a r1 = (a.i.a.a) r1
                a.i.a.i r2 = r0.f3616a
                if (r2 == 0) goto L_0x0398
                java.lang.String r6 = r1.i
                java.util.Map<java.lang.String, a.i.a.c> r7 = r2.f3615e
                java.lang.Object r7 = r7.get(r6)
                a.i.a.c r7 = (a.i.a.c) r7
                if (r7 == 0) goto L_0x0354
                r7.d(r1)
                boolean r7 = r7.b()
                if (r7 == 0) goto L_0x0354
                java.util.Map<java.lang.String, a.i.a.c> r7 = r2.f3615e
                r7.remove(r6)
                a.i.a.t r6 = r1.f3571a
                boolean r6 = r6.n
                if (r6 == 0) goto L_0x0354
                a.i.a.w r6 = r1.f3572b
                java.lang.String r6 = r6.b()
                a.i.a.g0.p(r5, r3, r6, r4)
            L_0x0354:
                java.util.Set<java.lang.Object> r4 = r2.h
                java.lang.Object r6 = r1.j
                boolean r4 = r4.contains(r6)
                if (r4 == 0) goto L_0x0378
                java.util.Map<java.lang.Object, a.i.a.a> r4 = r2.g
                java.lang.Object r6 = r1.d()
                r4.remove(r6)
                a.i.a.t r4 = r1.f3571a
                boolean r4 = r4.n
                if (r4 == 0) goto L_0x0378
                a.i.a.w r4 = r1.f3572b
                java.lang.String r4 = r4.b()
                java.lang.String r6 = "because paused request got canceled"
                a.i.a.g0.p(r5, r3, r4, r6)
            L_0x0378:
                java.util.Map<java.lang.Object, a.i.a.a> r2 = r2.f
                java.lang.Object r1 = r1.d()
                java.lang.Object r1 = r2.remove(r1)
                a.i.a.a r1 = (a.i.a.a) r1
                if (r1 == 0) goto L_0x03a3
                a.i.a.t r2 = r1.f3571a
                boolean r2 = r2.n
                if (r2 == 0) goto L_0x03a3
                a.i.a.w r1 = r1.f3572b
                java.lang.String r1 = r1.b()
                java.lang.String r2 = "from replaying"
                a.i.a.g0.p(r5, r3, r1, r2)
                goto L_0x03a3
            L_0x0398:
                throw r6
            L_0x0399:
                java.lang.Object r1 = r1.obj
                a.i.a.a r1 = (a.i.a.a) r1
                a.i.a.i r2 = r0.f3616a
                r3 = 1
                r2.f(r1, r3)
            L_0x03a3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.i.a.i.a.handleMessage(android.os.Message):void");
        }
    }

    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    public static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final i f3618a;

        public c(i iVar) {
            this.f3618a = iVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        i iVar = this.f3618a;
                        boolean booleanExtra = intent.getBooleanExtra("state", false);
                        Handler handler = iVar.i;
                        handler.sendMessage(handler.obtainMessage(10, booleanExtra ? 1 : 0, 0));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    i iVar2 = this.f3618a;
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) g0.n(context, "connectivity")).getActiveNetworkInfo();
                    Handler handler2 = iVar2.i;
                    handler2.sendMessage(handler2.obtainMessage(9, activeNetworkInfo));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(android.content.Context r2, java.util.concurrent.ExecutorService r3, android.os.Handler r4, a.i.a.j r5, a.i.a.d r6, a.i.a.a0 r7) {
        /*
            r1 = this;
            r1.<init>()
            a.i.a.i$b r0 = new a.i.a.i$b
            r0.<init>()
            r1.f3611a = r0
            r0.start()
            a.i.a.i$b r0 = r1.f3611a
            android.os.Looper r0 = r0.getLooper()
            a.i.a.g0.i(r0)
            r1.f3612b = r2
            r1.f3613c = r3
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            r1.f3615e = r3
            java.util.WeakHashMap r3 = new java.util.WeakHashMap
            r3.<init>()
            r1.f = r3
            java.util.WeakHashMap r3 = new java.util.WeakHashMap
            r3.<init>()
            r1.g = r3
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r1.h = r3
            a.i.a.i$a r3 = new a.i.a.i$a
            a.i.a.i$b r0 = r1.f3611a
            android.os.Looper r0 = r0.getLooper()
            r3.<init>(r0, r1)
            r1.i = r3
            r1.f3614d = r5
            r1.j = r4
            r1.k = r6
            r1.l = r7
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 4
            r3.<init>(r4)
            r1.m = r3
            android.content.Context r3 = r1.f3612b
            android.content.ContentResolver r3 = r3.getContentResolver()
            r4 = 1
            r5 = 0
            java.lang.String r6 = "airplane_mode_on"
            int r3 = android.provider.Settings.System.getInt(r3, r6, r5)     // Catch:{ NullPointerException -> 0x0065 }
            if (r3 == 0) goto L_0x0065
            r3 = 1
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            r1.p = r3
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            int r2 = r2.checkCallingOrSelfPermission(r3)
            if (r2 != 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            r1.o = r4
            a.i.a.i$c r2 = new a.i.a.i$c
            r2.<init>(r1)
            r1.n = r2
            android.content.IntentFilter r3 = new android.content.IntentFilter
            r3.<init>()
            java.lang.String r4 = "android.intent.action.AIRPLANE_MODE"
            r3.addAction(r4)
            a.i.a.i r4 = r2.f3618a
            boolean r4 = r4.o
            if (r4 == 0) goto L_0x0090
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r3.addAction(r4)
        L_0x0090:
            a.i.a.i r4 = r2.f3618a
            android.content.Context r4 = r4.f3612b
            r4.registerReceiver(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.i.<init>(android.content.Context, java.util.concurrent.ExecutorService, android.os.Handler, a.i.a.j, a.i.a.d, a.i.a.a0):void");
    }

    public final void a(c cVar) {
        Future<?> future = cVar.n;
        if (!(future != null && future.isCancelled())) {
            this.m.add(cVar);
            if (!this.i.hasMessages(7)) {
                this.i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    public void b(c cVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    public void c(c cVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    public final void d(c cVar) {
        Object d2;
        a aVar = cVar.k;
        if (!(aVar == null || (d2 = aVar.d()) == null)) {
            aVar.k = true;
            this.f.put(d2, aVar);
        }
        List<a> list = cVar.l;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = list.get(i2);
                Object d3 = aVar2.d();
                if (d3 != null) {
                    aVar2.k = true;
                    this.f.put(d3, aVar2);
                }
            }
        }
    }

    public void e(c cVar, boolean z) {
        if (cVar.f3591b.n) {
            String k2 = g0.k(cVar);
            StringBuilder n2 = a.a.a.a.a.n("for error");
            n2.append(z ? " (will replay)" : "");
            g0.p("Dispatcher", "batched", k2, n2.toString());
        }
        this.f3615e.remove(cVar.f);
        a(cVar);
    }

    public void f(a aVar, boolean z) {
        String str;
        String str2;
        if (this.h.contains(aVar.j)) {
            this.g.put(aVar.d(), aVar);
            if (aVar.f3571a.n) {
                String b2 = aVar.f3572b.b();
                StringBuilder n2 = a.a.a.a.a.n("because tag '");
                n2.append(aVar.j);
                n2.append("' is paused");
                g0.p("Dispatcher", "paused", b2, n2.toString());
                return;
            }
            return;
        }
        c cVar = this.f3615e.get(aVar.i);
        if (cVar != null) {
            boolean z2 = cVar.f3591b.n;
            w wVar = aVar.f3572b;
            if (cVar.k == null) {
                cVar.k = aVar;
                if (z2) {
                    List<a> list = cVar.l;
                    if (list == null || list.isEmpty()) {
                        str2 = wVar.b();
                        str = "to empty hunter";
                    } else {
                        str2 = wVar.b();
                        str = g0.l(cVar, "to ");
                    }
                    g0.p("Hunter", "joined", str2, str);
                    return;
                }
                return;
            }
            if (cVar.l == null) {
                cVar.l = new ArrayList(3);
            }
            cVar.l.add(aVar);
            if (z2) {
                g0.p("Hunter", "joined", wVar.b(), g0.l(cVar, "to "));
            }
            t.e eVar = aVar.f3572b.r;
            if (eVar.ordinal() > cVar.s.ordinal()) {
                cVar.s = eVar;
            }
        } else if (!this.f3613c.isShutdown()) {
            c e2 = c.e(aVar.f3571a, this, this.k, this.l, aVar);
            e2.n = this.f3613c.submit(e2);
            this.f3615e.put(aVar.i, e2);
            if (z) {
                this.f.remove(aVar.d());
            }
            if (aVar.f3571a.n) {
                g0.p("Dispatcher", "enqueued", aVar.f3572b.b(), "");
            }
        } else if (aVar.f3571a.n) {
            g0.p("Dispatcher", "ignored", aVar.f3572b.b(), "because shut down");
        }
    }
}
