package e.b.a.a.a.u;

import com.tuya.smart.mqtt.MqttServiceConstants;
import e.b.a.a.a.d;
import e.b.a.a.a.k;
import e.b.a.a.a.l;
import e.b.a.a.a.m;
import e.b.a.a.a.n;
import e.b.a.a.a.q;
import e.b.a.a.a.r;
import e.b.a.a.a.t;
import e.b.a.a.a.u.t.e;
import e.b.a.a.a.u.t.o;
import e.b.a.a.a.u.t.u;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class a {
    public static final e.b.a.a.a.v.b r = e.b.a.a.a.v.c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public d f5224a;

    /* renamed from: b  reason: collision with root package name */
    public int f5225b;

    /* renamed from: c  reason: collision with root package name */
    public m[] f5226c;

    /* renamed from: d  reason: collision with root package name */
    public d f5227d;

    /* renamed from: e  reason: collision with root package name */
    public e f5228e;
    public c f;
    public b g;
    public l h;
    public k i;
    public r j;
    public f k;
    public boolean l;
    public byte m;
    public Object n;
    public boolean o;
    public h p;
    public ExecutorService q;

    /* renamed from: e.b.a.a.a.u.a$a  reason: collision with other inner class name */
    public class C0108a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public a f5229a = null;

        /* renamed from: b  reason: collision with root package name */
        public t f5230b;

        /* renamed from: c  reason: collision with root package name */
        public e.b.a.a.a.u.t.d f5231c;

        /* renamed from: d  reason: collision with root package name */
        public String f5232d;

        public C0108a(a aVar, t tVar, e.b.a.a.a.u.t.d dVar) {
            this.f5229a = aVar;
            this.f5230b = tVar;
            this.f5231c = dVar;
            this.f5232d = "MQTT Con: " + a.this.f5224a.getClientId();
        }

        public void run() {
            Thread.currentThread().setName(this.f5232d);
            a.r.h("e.b.a.a.a.u.a", "connectBG:run", "220");
            n nVar = null;
            try {
                m[] c2 = a.this.k.c();
                for (m mVar : c2) {
                    mVar.f5223a.c((n) null);
                }
                a.this.k.j(this.f5230b, this.f5231c);
                m mVar2 = a.this.f5226c[a.this.f5225b];
                mVar2.start();
                a.this.f5227d = new d(this.f5229a, a.this.g, a.this.k, mVar2.b());
                a.this.f5227d.a("MQTT Rec: " + a.this.f5224a.getClientId(), a.this.q);
                a.this.f5228e = new e(this.f5229a, a.this.g, a.this.k, mVar2.a());
                a.this.f5228e.b("MQTT Snd: " + a.this.f5224a.getClientId(), a.this.q);
                a.this.f.g("MQTT Call: " + a.this.f5224a.getClientId(), a.this.q);
                a.this.e(this.f5231c, this.f5230b);
            } catch (n e2) {
                n nVar2 = e2;
                a.r.c("e.b.a.a.a.u.a", "connectBG:run", "212", (Object[]) null, nVar2);
                nVar = nVar2;
            } catch (Exception e3) {
                Exception exc = e3;
                a.r.c("e.b.a.a.a.u.a", "connectBG:run", "209", (Object[]) null, exc);
                nVar = a.e.a.a.r.b.h(exc);
            }
            if (nVar != null) {
                a.this.l(this.f5230b, nVar);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public e f5234a;

        /* renamed from: b  reason: collision with root package name */
        public long f5235b;

        /* renamed from: c  reason: collision with root package name */
        public t f5236c;

        /* renamed from: d  reason: collision with root package name */
        public String f5237d;

        public b(e eVar, long j, t tVar) {
            this.f5234a = eVar;
            this.f5235b = j;
            this.f5236c = tVar;
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r15 = this;
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.String r1 = r15.f5237d
                r0.setName(r1)
                e.b.a.a.a.v.b r0 = e.b.a.a.a.u.a.r
                java.lang.String r1 = "e.b.a.a.a.u.a"
                java.lang.String r2 = "disconnectBG:run"
                java.lang.String r3 = "221"
                r0.h(r1, r2, r3)
                e.b.a.a.a.u.a r0 = e.b.a.a.a.u.a.this
                e.b.a.a.a.u.b r0 = r0.g
                long r1 = r15.f5235b
                r3 = 0
                if (r0 == 0) goto L_0x010d
                r4 = 0
                int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x00dd
                e.b.a.a.a.v.b r4 = e.b.a.a.a.u.b.C
                java.lang.String r5 = "e.b.a.a.a.u.b"
                java.lang.String r6 = "quiesce"
                java.lang.String r7 = "637"
                r8 = 1
                java.lang.Object[] r9 = new java.lang.Object[r8]
                java.lang.Long r10 = new java.lang.Long
                r10.<init>(r1)
                r11 = 0
                r9[r11] = r10
                r4.e(r5, r6, r7, r9)
                java.lang.Object r4 = r0.n
                monitor-enter(r4)
                r0.p = r8     // Catch:{ all -> 0x00da }
                monitor-exit(r4)     // Catch:{ all -> 0x00da }
                e.b.a.a.a.u.c r4 = r0.g
                r4.h = r8
                java.lang.Object r5 = r4.l
                monitor-enter(r5)
                e.b.a.a.a.v.b r6 = e.b.a.a.a.u.c.s     // Catch:{ all -> 0x00d7 }
                java.lang.String r7 = e.b.a.a.a.u.c.r     // Catch:{ all -> 0x00d7 }
                java.lang.String r9 = "quiesce"
                java.lang.String r10 = "711"
                r6.h(r7, r9, r10)     // Catch:{ all -> 0x00d7 }
                java.lang.Object r4 = r4.l     // Catch:{ all -> 0x00d7 }
                r4.notifyAll()     // Catch:{ all -> 0x00d7 }
                monitor-exit(r5)     // Catch:{ all -> 0x00d7 }
                r0.o()
                java.lang.Object r4 = r0.o
                monitor-enter(r4)
                e.b.a.a.a.u.f r5 = r0.f5245e     // Catch:{ InterruptedException -> 0x00b3 }
                int r5 = r5.b()     // Catch:{ InterruptedException -> 0x00b3 }
                if (r5 > 0) goto L_0x0075
                java.util.Vector r6 = r0.f5244d     // Catch:{ InterruptedException -> 0x00b3 }
                int r6 = r6.size()     // Catch:{ InterruptedException -> 0x00b3 }
                if (r6 > 0) goto L_0x0075
                e.b.a.a.a.u.c r6 = r0.g     // Catch:{ InterruptedException -> 0x00b3 }
                boolean r6 = r6.e()     // Catch:{ InterruptedException -> 0x00b3 }
                if (r6 != 0) goto L_0x00b3
            L_0x0075:
                e.b.a.a.a.v.b r6 = e.b.a.a.a.u.b.C     // Catch:{ InterruptedException -> 0x00b3 }
                java.lang.String r7 = "e.b.a.a.a.u.b"
                java.lang.String r9 = "quiesce"
                java.lang.String r10 = "639"
                r12 = 4
                java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ InterruptedException -> 0x00b3 }
                java.lang.Integer r13 = new java.lang.Integer     // Catch:{ InterruptedException -> 0x00b3 }
                int r14 = r0.l     // Catch:{ InterruptedException -> 0x00b3 }
                r13.<init>(r14)     // Catch:{ InterruptedException -> 0x00b3 }
                r12[r11] = r13     // Catch:{ InterruptedException -> 0x00b3 }
                java.lang.Integer r13 = new java.lang.Integer     // Catch:{ InterruptedException -> 0x00b3 }
                java.util.Vector r14 = r0.f5244d     // Catch:{ InterruptedException -> 0x00b3 }
                int r14 = r14.size()     // Catch:{ InterruptedException -> 0x00b3 }
                r13.<init>(r14)     // Catch:{ InterruptedException -> 0x00b3 }
                r12[r8] = r13     // Catch:{ InterruptedException -> 0x00b3 }
                r8 = 2
                java.lang.Integer r13 = new java.lang.Integer     // Catch:{ InterruptedException -> 0x00b3 }
                int r14 = r0.m     // Catch:{ InterruptedException -> 0x00b3 }
                r13.<init>(r14)     // Catch:{ InterruptedException -> 0x00b3 }
                r12[r8] = r13     // Catch:{ InterruptedException -> 0x00b3 }
                r8 = 3
                java.lang.Integer r13 = new java.lang.Integer     // Catch:{ InterruptedException -> 0x00b3 }
                r13.<init>(r5)     // Catch:{ InterruptedException -> 0x00b3 }
                r12[r8] = r13     // Catch:{ InterruptedException -> 0x00b3 }
                r6.e(r7, r9, r10, r12)     // Catch:{ InterruptedException -> 0x00b3 }
                java.lang.Object r5 = r0.o     // Catch:{ InterruptedException -> 0x00b3 }
                r5.wait(r1)     // Catch:{ InterruptedException -> 0x00b3 }
                goto L_0x00b3
            L_0x00b1:
                r0 = move-exception
                goto L_0x00d5
            L_0x00b3:
                monitor-exit(r4)     // Catch:{ all -> 0x00b1 }
                java.lang.Object r1 = r0.n
                monitor-enter(r1)
                java.util.Vector r2 = r0.f5243c     // Catch:{ all -> 0x00d2 }
                r2.clear()     // Catch:{ all -> 0x00d2 }
                java.util.Vector r2 = r0.f5244d     // Catch:{ all -> 0x00d2 }
                r2.clear()     // Catch:{ all -> 0x00d2 }
                r0.p = r11     // Catch:{ all -> 0x00d2 }
                r0.l = r11     // Catch:{ all -> 0x00d2 }
                monitor-exit(r1)     // Catch:{ all -> 0x00d2 }
                e.b.a.a.a.v.b r0 = e.b.a.a.a.u.b.C
                java.lang.String r1 = "e.b.a.a.a.u.b"
                java.lang.String r2 = "quiesce"
                java.lang.String r4 = "640"
                r0.h(r1, r2, r4)
                goto L_0x00dd
            L_0x00d2:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00d2 }
                throw r0
            L_0x00d5:
                monitor-exit(r4)     // Catch:{ all -> 0x00b1 }
                throw r0
            L_0x00d7:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00d7 }
                throw r0
            L_0x00da:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x00da }
                throw r0
            L_0x00dd:
                e.b.a.a.a.u.a r0 = e.b.a.a.a.u.a.this     // Catch:{ n -> 0x00fe, all -> 0x00ee }
                e.b.a.a.a.u.t.e r1 = r15.f5234a     // Catch:{ n -> 0x00fe, all -> 0x00ee }
                e.b.a.a.a.t r2 = r15.f5236c     // Catch:{ n -> 0x00fe, all -> 0x00ee }
                r0.e(r1, r2)     // Catch:{ n -> 0x00fe, all -> 0x00ee }
                e.b.a.a.a.t r0 = r15.f5236c     // Catch:{ n -> 0x00fe, all -> 0x00ee }
                e.b.a.a.a.u.q r0 = r0.f5223a     // Catch:{ n -> 0x00fe, all -> 0x00ee }
                r0.d()     // Catch:{ n -> 0x00fe, all -> 0x00ee }
                goto L_0x00fe
            L_0x00ee:
                r0 = move-exception
                e.b.a.a.a.t r1 = r15.f5236c
                e.b.a.a.a.u.q r1 = r1.f5223a
                r1.a(r3, r3)
                e.b.a.a.a.u.a r1 = e.b.a.a.a.u.a.this
                e.b.a.a.a.t r2 = r15.f5236c
                r1.l(r2, r3)
                throw r0
            L_0x00fe:
                e.b.a.a.a.t r0 = r15.f5236c
                e.b.a.a.a.u.q r0 = r0.f5223a
                r0.a(r3, r3)
                e.b.a.a.a.u.a r0 = e.b.a.a.a.u.a.this
                e.b.a.a.a.t r1 = r15.f5236c
                r0.l(r1, r3)
                return
            L_0x010d:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.a.b.run():void");
        }
    }

    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final String f5239a;

        public c(String str) {
            this.f5239a = str;
        }

        public void a(e.b.a.a.a.a aVar) {
            if (a.this.g()) {
                while (true) {
                    b bVar = a.this.g;
                    if (bVar.l < bVar.k - 1) {
                        break;
                    }
                    Thread.yield();
                }
                a.r.e("e.b.a.a.a.u.a", this.f5239a, "510", new Object[]{aVar.f5204a.m()});
                a.this.e(aVar.f5204a, aVar.f5205b);
                b bVar2 = a.this.g;
                u uVar = aVar.f5204a;
                if (bVar2 != null) {
                    try {
                        b.C.e("e.b.a.a.a.u.b", "unPersistBufferedMessage", "517", new Object[]{uVar.m()});
                        bVar2.j.remove(bVar2.j(uVar));
                    } catch (q unused) {
                        b.C.e("e.b.a.a.a.u.b", "unPersistBufferedMessage", "518", new Object[]{uVar.m()});
                    }
                } else {
                    throw null;
                }
            } else {
                a.r.h("e.b.a.a.a.u.a", this.f5239a, "208");
                throw a.e.a.a.r.b.g(32104);
            }
        }
    }

    public a(d dVar, k kVar, r rVar, ExecutorService executorService) {
        this.l = false;
        this.m = 3;
        this.n = new Object();
        this.o = false;
        this.m = 3;
        this.f5224a = dVar;
        this.i = kVar;
        this.j = rVar;
        rVar.init(this);
        this.q = executorService;
        this.k = new f(this.f5224a.getClientId());
        this.f = new c(this);
        b bVar = new b(kVar, this.k, this.f, this, rVar);
        this.g = bVar;
        this.f.m = bVar;
        r.i(this.f5224a.getClientId());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.n
            monitor-enter(r0)
            boolean r1 = r4.f()     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x0061
            boolean r1 = r4.i()     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x0011
            if (r5 == 0) goto L_0x0033
        L_0x0011:
            e.b.a.a.a.v.b r5 = r     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "e.b.a.a.a.u.a"
            java.lang.String r2 = "close"
            java.lang.String r3 = "224"
            r5.h(r1, r2, r3)     // Catch:{ all -> 0x0063 }
            boolean r5 = r4.h()     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x0059
            boolean r5 = r4.g()     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x0052
            boolean r5 = r4.j()     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x0033
            r5 = 1
            r4.o = r5     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0033:
            r5 = 4
            r4.m = r5     // Catch:{ all -> 0x0063 }
            r4.m()     // Catch:{ all -> 0x0063 }
            e.b.a.a.a.u.b r5 = r4.g     // Catch:{ all -> 0x0063 }
            r5.d()     // Catch:{ all -> 0x0063 }
            r5 = 0
            r4.g = r5     // Catch:{ all -> 0x0063 }
            r4.f = r5     // Catch:{ all -> 0x0063 }
            r4.i = r5     // Catch:{ all -> 0x0063 }
            r4.f5228e = r5     // Catch:{ all -> 0x0063 }
            r4.j = r5     // Catch:{ all -> 0x0063 }
            r4.f5227d = r5     // Catch:{ all -> 0x0063 }
            r4.f5226c = r5     // Catch:{ all -> 0x0063 }
            r4.h = r5     // Catch:{ all -> 0x0063 }
            r4.k = r5     // Catch:{ all -> 0x0063 }
            goto L_0x0061
        L_0x0052:
            r5 = 32100(0x7d64, float:4.4982E-41)
            e.b.a.a.a.n r5 = a.e.a.a.r.b.g(r5)     // Catch:{ all -> 0x0063 }
            throw r5     // Catch:{ all -> 0x0063 }
        L_0x0059:
            e.b.a.a.a.n r5 = new e.b.a.a.a.n     // Catch:{ all -> 0x0063 }
            r1 = 32110(0x7d6e, float:4.4996E-41)
            r5.<init>((int) r1)     // Catch:{ all -> 0x0063 }
            throw r5     // Catch:{ all -> 0x0063 }
        L_0x0061:
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0063:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.a.a(boolean):void");
    }

    public void b(l lVar, t tVar) {
        synchronized (this.n) {
            if (!i() || this.o) {
                r.e("e.b.a.a.a.u.a", MqttServiceConstants.CONNECT_ACTION, "207", new Object[]{new Byte(this.m)});
                if (f() || this.o) {
                    throw new n(32111);
                } else if (h()) {
                    throw new n(32110);
                } else if (j()) {
                    throw new n(32102);
                } else {
                    throw a.e.a.a.r.b.g(32100);
                }
            } else {
                r.h("e.b.a.a.a.u.a", MqttServiceConstants.CONNECT_ACTION, "214");
                this.m = 1;
                this.h = lVar;
                e.b.a.a.a.u.t.d dVar = new e.b.a.a.a.u.t.d(this.f5224a.getClientId(), this.h.m, this.h.j, this.h.f5216a, this.h.f5220e, this.h.f, this.h.f5219d, this.h.f5218c);
                this.g.h = ((long) this.h.f5216a) * 1000;
                this.g.i = this.h.j;
                b bVar = this.g;
                bVar.k = this.h.f5217b;
                bVar.f5243c = new Vector(bVar.k);
                f fVar = this.k;
                synchronized (fVar.f5262a) {
                    f.f5261d.h("e.b.a.a.a.u.f", "open", "310");
                    fVar.f5264c = null;
                }
                C0108a aVar = new C0108a(this, tVar, dVar);
                a.this.q.execute(aVar);
            }
        }
    }

    public void c(e eVar, long j2, t tVar) {
        synchronized (this.n) {
            if (f()) {
                r.h("e.b.a.a.a.u.a", MqttServiceConstants.DISCONNECT_ACTION, "223");
                throw a.e.a.a.r.b.g(32111);
            } else if (i()) {
                r.h("e.b.a.a.a.u.a", MqttServiceConstants.DISCONNECT_ACTION, "211");
                throw a.e.a.a.r.b.g(32101);
            } else if (j()) {
                r.h("e.b.a.a.a.u.a", MqttServiceConstants.DISCONNECT_ACTION, "219");
                throw a.e.a.a.r.b.g(32102);
            } else if (Thread.currentThread() != this.f.j) {
                r.h("e.b.a.a.a.u.a", MqttServiceConstants.DISCONNECT_ACTION, "218");
                this.m = 2;
                b bVar = new b(eVar, j2, tVar);
                bVar.f5237d = "MQTT Disc: " + a.this.f5224a.getClientId();
                a.this.q.execute(bVar);
            } else {
                r.h("e.b.a.a.a.u.a", MqttServiceConstants.DISCONNECT_ACTION, "210");
                throw a.e.a.a.r.b.g(32107);
            }
        }
    }

    public final void d(Exception exc) {
        r.c("e.b.a.a.a.u.a", "handleRunException", "804", (Object[]) null, exc);
        l((t) null, !(exc instanceof n) ? new n(32109, exc) : (n) exc);
    }

    public void e(u uVar, t tVar) {
        Integer num;
        Hashtable hashtable;
        r.e("e.b.a.a.a.u.a", "internalSend", "200", new Object[]{uVar.m(), uVar, tVar});
        q qVar = tVar.f5223a;
        if (qVar.j == null) {
            qVar.j = this.f5224a;
            try {
                this.g.A(uVar, tVar);
            } catch (n e2) {
                if (uVar instanceof o) {
                    b bVar = this.g;
                    o oVar = (o) uVar;
                    synchronized (bVar.n) {
                        b.C.e("e.b.a.a.a.u.b", "undo", "618", new Object[]{new Integer(oVar.f5339b), new Integer(oVar.f5333e.getQos())});
                        if (oVar.f5333e.getQos() == 1) {
                            hashtable = bVar.y;
                            num = new Integer(oVar.f5339b);
                        } else {
                            hashtable = bVar.x;
                            num = new Integer(oVar.f5339b);
                        }
                        hashtable.remove(num);
                        bVar.f5243c.removeElement(oVar);
                        bVar.j.remove(bVar.l(oVar));
                        bVar.f5245e.g(oVar);
                        if (oVar.f5333e.getQos() > 0) {
                            bVar.w(oVar.f5339b);
                            oVar.s(0);
                        }
                        bVar.b();
                    }
                }
                throw e2;
            }
        } else {
            r.e("e.b.a.a.a.u.a", "internalSend", "213", new Object[]{uVar.m(), uVar, tVar});
            throw new n(32201);
        }
    }

    public boolean f() {
        boolean z;
        synchronized (this.n) {
            z = this.m == 4;
        }
        return z;
    }

    public boolean g() {
        boolean z;
        synchronized (this.n) {
            z = this.m == 0;
        }
        return z;
    }

    public boolean h() {
        boolean z;
        synchronized (this.n) {
            z = true;
            if (this.m != 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean i() {
        boolean z;
        synchronized (this.n) {
            z = this.m == 3;
        }
        return z;
    }

    public boolean j() {
        boolean z;
        synchronized (this.n) {
            z = this.m == 2;
        }
        return z;
    }

    public void k(u uVar, t tVar) {
        if (g() || ((!g() && (uVar instanceof e.b.a.a.a.u.t.d)) || (j() && (uVar instanceof e)))) {
            h hVar = this.p;
            if (hVar == null || hVar.b() == 0) {
                e(uVar, tVar);
                return;
            }
            r.e("e.b.a.a.a.u.a", "sendNoWait", "507", new Object[]{uVar.m()});
            if (this.p != null) {
                throw null;
            }
            throw null;
        } else if (this.p != null) {
            r.e("e.b.a.a.a.u.a", "sendNoWait", "508", new Object[]{uVar.m()});
            if (this.p != null) {
                throw null;
            }
            throw null;
        } else {
            r.h("e.b.a.a.a.u.a", "sendNoWait", "208");
            throw a.e.a.a.r.b.g(32104);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0116 */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0121 A[Catch:{ Exception -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0135  */
    public void l(e.b.a.a.a.t r11, e.b.a.a.a.n r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.n
            monitor-enter(r0)
            boolean r1 = r10.l     // Catch:{ all -> 0x01bf }
            if (r1 != 0) goto L_0x01bd
            boolean r1 = r10.o     // Catch:{ all -> 0x01bf }
            if (r1 != 0) goto L_0x01bd
            boolean r1 = r10.f()     // Catch:{ all -> 0x01bf }
            if (r1 == 0) goto L_0x0013
            goto L_0x01bd
        L_0x0013:
            r1 = 1
            r10.l = r1     // Catch:{ all -> 0x01bf }
            e.b.a.a.a.v.b r2 = r     // Catch:{ all -> 0x01bf }
            java.lang.String r3 = "e.b.a.a.a.u.a"
            java.lang.String r4 = "shutdownConnection"
            java.lang.String r5 = "216"
            r2.h(r3, r4, r5)     // Catch:{ all -> 0x01bf }
            boolean r2 = r10.g()     // Catch:{ all -> 0x01bf }
            r3 = 0
            if (r2 != 0) goto L_0x0030
            boolean r2 = r10.j()     // Catch:{ all -> 0x01bf }
            if (r2 != 0) goto L_0x0030
            r2 = 0
            goto L_0x0031
        L_0x0030:
            r2 = 1
        L_0x0031:
            r4 = 2
            r10.m = r4     // Catch:{ all -> 0x01bf }
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            if (r11 == 0) goto L_0x0042
            e.b.a.a.a.u.q r0 = r11.f5223a
            boolean r0 = r0.f5290a
            if (r0 != 0) goto L_0x0042
            e.b.a.a.a.u.q r0 = r11.f5223a
            r0.c(r12)
        L_0x0042:
            e.b.a.a.a.u.c r0 = r10.f
            if (r0 == 0) goto L_0x0049
            r0.h()
        L_0x0049:
            e.b.a.a.a.u.d r0 = r10.f5227d
            r4 = 0
            if (r0 == 0) goto L_0x009b
            java.lang.Object r5 = r0.f5252b
            monitor-enter(r5)
            java.util.concurrent.Future r6 = r0.j     // Catch:{ all -> 0x0098 }
            if (r6 == 0) goto L_0x005a
            java.util.concurrent.Future r6 = r0.j     // Catch:{ all -> 0x0098 }
            r6.cancel(r1)     // Catch:{ all -> 0x0098 }
        L_0x005a:
            e.b.a.a.a.v.b r6 = e.b.a.a.a.u.d.l     // Catch:{ all -> 0x0098 }
            java.lang.String r7 = e.b.a.a.a.u.d.k     // Catch:{ all -> 0x0098 }
            java.lang.String r8 = "stop"
            java.lang.String r9 = "850"
            r6.h(r7, r8, r9)     // Catch:{ all -> 0x0098 }
            boolean r6 = r0.f5251a     // Catch:{ all -> 0x0098 }
            if (r6 == 0) goto L_0x0089
            r0.f5251a = r3     // Catch:{ all -> 0x0098 }
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0098 }
            java.lang.Thread r7 = r0.g     // Catch:{ all -> 0x0098 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0098 }
            if (r6 != 0) goto L_0x0089
            java.util.concurrent.Semaphore r6 = r0.h     // Catch:{ InterruptedException -> 0x007c, all -> 0x007f }
            r6.acquire()     // Catch:{ InterruptedException -> 0x007c, all -> 0x007f }
        L_0x007c:
            java.util.concurrent.Semaphore r6 = r0.h     // Catch:{ all -> 0x0098 }
            goto L_0x0086
        L_0x007f:
            r11 = move-exception
            java.util.concurrent.Semaphore r12 = r0.h     // Catch:{ all -> 0x0098 }
            r12.release()     // Catch:{ all -> 0x0098 }
            throw r11     // Catch:{ all -> 0x0098 }
        L_0x0086:
            r6.release()     // Catch:{ all -> 0x0098 }
        L_0x0089:
            monitor-exit(r5)     // Catch:{ all -> 0x0098 }
            r0.g = r4
            e.b.a.a.a.v.b r0 = e.b.a.a.a.u.d.l
            java.lang.String r5 = e.b.a.a.a.u.d.k
            java.lang.String r6 = "stop"
            java.lang.String r7 = "851"
            r0.h(r5, r6, r7)
            goto L_0x009b
        L_0x0098:
            r11 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0098 }
            throw r11
        L_0x009b:
            e.b.a.a.a.u.m[] r0 = r10.f5226c     // Catch:{ Exception -> 0x00aa }
            if (r0 == 0) goto L_0x00aa
            e.b.a.a.a.u.m[] r0 = r10.f5226c     // Catch:{ Exception -> 0x00aa }
            int r5 = r10.f5225b     // Catch:{ Exception -> 0x00aa }
            r0 = r0[r5]     // Catch:{ Exception -> 0x00aa }
            if (r0 == 0) goto L_0x00aa
            r0.stop()     // Catch:{ Exception -> 0x00aa }
        L_0x00aa:
            e.b.a.a.a.u.f r0 = r10.k
            e.b.a.a.a.n r5 = new e.b.a.a.a.n
            r6 = 32102(0x7d66, float:4.4984E-41)
            r5.<init>((int) r6)
            r0.e(r5)
            e.b.a.a.a.v.b r0 = r
            java.lang.String r5 = "e.b.a.a.a.u.a"
            java.lang.String r6 = "handleOldTokens"
            java.lang.String r7 = "222"
            r0.h(r5, r6, r7)
            if (r11 == 0) goto L_0x00dc
            e.b.a.a.a.u.f r0 = r10.k     // Catch:{ Exception -> 0x0115 }
            e.b.a.a.a.u.q r5 = r11.f5223a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = r5.i     // Catch:{ Exception -> 0x0115 }
            java.util.Hashtable r0 = r0.f5262a     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x0115 }
            e.b.a.a.a.t r0 = (e.b.a.a.a.t) r0     // Catch:{ Exception -> 0x0115 }
            if (r0 != 0) goto L_0x00dc
            e.b.a.a.a.u.f r0 = r10.k     // Catch:{ Exception -> 0x0115 }
            e.b.a.a.a.u.q r5 = r11.f5223a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = r5.i     // Catch:{ Exception -> 0x0115 }
            r0.i(r11, r5)     // Catch:{ Exception -> 0x0115 }
        L_0x00dc:
            e.b.a.a.a.u.b r11 = r10.g     // Catch:{ Exception -> 0x0115 }
            java.util.Vector r11 = r11.x(r12)     // Catch:{ Exception -> 0x0115 }
            java.util.Enumeration r11 = r11.elements()     // Catch:{ Exception -> 0x0115 }
            r0 = r4
        L_0x00e7:
            boolean r5 = r11.hasMoreElements()     // Catch:{ Exception -> 0x0116 }
            if (r5 != 0) goto L_0x00ee
            goto L_0x0116
        L_0x00ee:
            java.lang.Object r5 = r11.nextElement()     // Catch:{ Exception -> 0x0116 }
            e.b.a.a.a.t r5 = (e.b.a.a.a.t) r5     // Catch:{ Exception -> 0x0116 }
            e.b.a.a.a.u.q r6 = r5.f5223a     // Catch:{ Exception -> 0x0116 }
            java.lang.String r6 = r6.i     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = "Disc"
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0116 }
            if (r6 != 0) goto L_0x0113
            e.b.a.a.a.u.q r6 = r5.f5223a     // Catch:{ Exception -> 0x0116 }
            java.lang.String r6 = r6.i     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = "Con"
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0116 }
            if (r6 == 0) goto L_0x010d
            goto L_0x0113
        L_0x010d:
            e.b.a.a.a.u.c r6 = r10.f     // Catch:{ Exception -> 0x0116 }
            r6.a(r5)     // Catch:{ Exception -> 0x0116 }
            goto L_0x00e7
        L_0x0113:
            r0 = r5
            goto L_0x00e7
        L_0x0115:
            r0 = r4
        L_0x0116:
            e.b.a.a.a.u.b r11 = r10.g     // Catch:{ Exception -> 0x0129 }
            r11.f(r12)     // Catch:{ Exception -> 0x0129 }
            e.b.a.a.a.u.b r11 = r10.g     // Catch:{ Exception -> 0x0129 }
            boolean r11 = r11.i     // Catch:{ Exception -> 0x0129 }
            if (r11 == 0) goto L_0x012a
            e.b.a.a.a.u.c r11 = r10.f     // Catch:{ Exception -> 0x0129 }
            java.util.Hashtable r11 = r11.f5248c     // Catch:{ Exception -> 0x0129 }
            r11.clear()     // Catch:{ Exception -> 0x0129 }
            goto L_0x012a
        L_0x0129:
        L_0x012a:
            e.b.a.a.a.u.e r11 = r10.f5228e
            if (r11 == 0) goto L_0x0131
            r11.c()
        L_0x0131:
            e.b.a.a.a.r r11 = r10.j
            if (r11 == 0) goto L_0x0138
            r11.stop()
        L_0x0138:
            e.b.a.a.a.u.h r11 = r10.p     // Catch:{ Exception -> 0x0145 }
            if (r11 != 0) goto L_0x0145
            e.b.a.a.a.k r11 = r10.i     // Catch:{ Exception -> 0x0145 }
            if (r11 == 0) goto L_0x0145
            e.b.a.a.a.k r11 = r10.i     // Catch:{ Exception -> 0x0145 }
            r11.close()     // Catch:{ Exception -> 0x0145 }
        L_0x0145:
            java.lang.Object r11 = r10.n
            monitor-enter(r11)
            e.b.a.a.a.v.b r5 = r     // Catch:{ all -> 0x01ba }
            java.lang.String r6 = "e.b.a.a.a.u.a"
            java.lang.String r7 = "shutdownConnection"
            java.lang.String r8 = "217"
            r5.h(r6, r7, r8)     // Catch:{ all -> 0x01ba }
            r5 = 3
            r10.m = r5     // Catch:{ all -> 0x01ba }
            r10.l = r3     // Catch:{ all -> 0x01ba }
            monitor-exit(r11)     // Catch:{ all -> 0x01ba }
            if (r0 == 0) goto L_0x015d
            r11 = 1
            goto L_0x015e
        L_0x015d:
            r11 = 0
        L_0x015e:
            e.b.a.a.a.u.c r5 = r10.f
            if (r5 == 0) goto L_0x0164
            r5 = 1
            goto L_0x0165
        L_0x0164:
            r5 = 0
        L_0x0165:
            r11 = r11 & r5
            if (r11 == 0) goto L_0x016d
            e.b.a.a.a.u.c r11 = r10.f
            r11.a(r0)
        L_0x016d:
            if (r2 == 0) goto L_0x01ab
            e.b.a.a.a.u.c r11 = r10.f
            if (r11 == 0) goto L_0x01ab
            if (r11 == 0) goto L_0x01aa
            java.lang.String r0 = "connectionLost"
            e.b.a.a.a.i r2 = r11.f5246a     // Catch:{ all -> 0x019b }
            if (r2 == 0) goto L_0x018f
            if (r12 == 0) goto L_0x018f
            e.b.a.a.a.v.b r2 = e.b.a.a.a.u.c.s     // Catch:{ all -> 0x019b }
            java.lang.String r4 = e.b.a.a.a.u.c.r     // Catch:{ all -> 0x019b }
            java.lang.String r5 = "708"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x019b }
            r6[r3] = r12     // Catch:{ all -> 0x019b }
            r2.e(r4, r0, r5, r6)     // Catch:{ all -> 0x019b }
            e.b.a.a.a.i r2 = r11.f5246a     // Catch:{ all -> 0x019b }
            r2.connectionLost(r12)     // Catch:{ all -> 0x019b }
        L_0x018f:
            e.b.a.a.a.j r2 = r11.f5247b     // Catch:{ all -> 0x019b }
            if (r2 == 0) goto L_0x01ab
            if (r12 == 0) goto L_0x01ab
            e.b.a.a.a.j r11 = r11.f5247b     // Catch:{ all -> 0x019b }
            r11.connectionLost(r12)     // Catch:{ all -> 0x019b }
            goto L_0x01ab
        L_0x019b:
            r11 = move-exception
            e.b.a.a.a.v.b r12 = e.b.a.a.a.u.c.s
            java.lang.String r2 = e.b.a.a.a.u.c.r
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r3] = r11
            java.lang.String r11 = "720"
            r12.e(r2, r0, r11, r4)
            goto L_0x01ab
        L_0x01aa:
            throw r4
        L_0x01ab:
            java.lang.Object r12 = r10.n
            monitor-enter(r12)
            boolean r11 = r10.o     // Catch:{ all -> 0x01b7 }
            if (r11 == 0) goto L_0x01b5
            r10.a(r1)     // Catch:{ Exception -> 0x01b5 }
        L_0x01b5:
            monitor-exit(r12)     // Catch:{ all -> 0x01b7 }
            return
        L_0x01b7:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x01b7 }
            throw r11
        L_0x01ba:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x01ba }
            throw r12
        L_0x01bd:
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            return
        L_0x01bf:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            goto L_0x01c3
        L_0x01c2:
            throw r11
        L_0x01c3:
            goto L_0x01c2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.a.l(e.b.a.a.a.t, e.b.a.a.a.n):void");
    }

    public final void m() {
        this.q.shutdown();
        try {
            if (!this.q.awaitTermination(1, TimeUnit.SECONDS)) {
                this.q.shutdownNow();
                if (!this.q.awaitTermination(1, TimeUnit.SECONDS)) {
                    r.h("e.b.a.a.a.u.a", "shutdownExecutorService", "executorService did not terminate");
                }
            }
        } catch (InterruptedException unused) {
            this.q.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
