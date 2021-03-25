package e.b.a.a.a.u;

import e.b.a.a.a.i;
import e.b.a.a.a.j;
import e.b.a.a.a.m;
import e.b.a.a.a.n;
import e.b.a.a.a.t;
import e.b.a.a.a.v.b;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class c implements Runnable {
    public static final String r;
    public static final b s;

    /* renamed from: a  reason: collision with root package name */
    public i f5246a;

    /* renamed from: b  reason: collision with root package name */
    public j f5247b;

    /* renamed from: c  reason: collision with root package name */
    public Hashtable f5248c;

    /* renamed from: d  reason: collision with root package name */
    public a f5249d;

    /* renamed from: e  reason: collision with root package name */
    public Vector f5250e;
    public Vector f;
    public boolean g = false;
    public boolean h = false;
    public Object i = new Object();
    public Thread j;
    public Object k = new Object();
    public Object l = new Object();
    public b m;
    public boolean n = false;
    public String o;
    public final Semaphore p = new Semaphore(1);
    public Future q;

    static {
        String name = c.class.getName();
        r = name;
        s = e.b.a.a.a.v.c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public c(a aVar) {
        this.f5249d = aVar;
        this.f5250e = new Vector(10);
        this.f = new Vector(10);
        this.f5248c = new Hashtable();
        s.i(aVar.f5224a.getClientId());
    }

    public void a(t tVar) {
        if (this.g) {
            this.f.addElement(tVar);
            synchronized (this.k) {
                s.e(r, "asyncOperationComplete", "715", new Object[]{tVar.f5223a.i});
                this.k.notifyAll();
            }
            return;
        }
        try {
            c(tVar);
        } catch (Throwable th) {
            s.c(r, "asyncOperationComplete", "719", (Object[]) null, th);
            this.f5249d.l((t) null, new n(th));
        }
    }

    public void b(t tVar) {
        q qVar = tVar.f5223a;
        e.b.a.a.a.c cVar = qVar.k;
        if (cVar == null) {
            return;
        }
        if (qVar.g == null) {
            s.e(r, "fireActionEvent", "716", new Object[]{qVar.i});
            cVar.onSuccess(tVar);
            return;
        }
        s.e(r, "fireActionEvent", "716", new Object[]{qVar.i});
        cVar.onFailure(tVar, tVar.f5223a.g);
    }

    public final void c(t tVar) {
        synchronized (tVar) {
            s.e(r, "handleActionComplete", "705", new Object[]{tVar.f5223a.i});
            if (tVar.f5223a.f5290a) {
                this.m.n(tVar);
            }
            tVar.f5223a.b();
            if (!tVar.f5223a.n) {
                if (this.f5246a != null && (tVar instanceof m) && tVar.f5223a.f5290a) {
                    this.f5246a.deliveryComplete((m) tVar);
                }
                b(tVar);
            }
            if (tVar.f5223a.f5290a && ((tVar instanceof m) || (tVar.f5223a.k instanceof e.b.a.a.a.c))) {
                tVar.f5223a.n = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r8v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r7v2, types: [boolean, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(e.b.a.a.a.u.t.o r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = r1.f
            e.b.a.a.a.v.b r3 = s
            java.lang.String r4 = r
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Integer r7 = new java.lang.Integer
            int r8 = r1.f5339b
            r7.<init>(r8)
            r8 = 0
            r6[r8] = r7
            r7 = 1
            r6[r7] = r2
            java.lang.String r9 = "handleMessage"
            java.lang.String r10 = "713"
            r3.e(r4, r9, r10, r6)
            int r3 = r1.f5339b
            e.b.a.a.a.o r4 = r1.f5333e
            java.util.Hashtable r6 = r0.f5248c
            java.util.Enumeration r6 = r6.keys()
            r9 = 0
        L_0x002c:
            boolean r10 = r6.hasMoreElements()
            if (r10 != 0) goto L_0x00b6
            e.b.a.a.a.i r6 = r0.f5246a
            if (r6 == 0) goto L_0x0040
            if (r9 != 0) goto L_0x0040
            r4.setId(r3)
            e.b.a.a.a.i r3 = r0.f5246a
            r3.messageArrived(r2, r4)
        L_0x0040:
            boolean r2 = r0.n
            if (r2 != 0) goto L_0x00b5
            e.b.a.a.a.o r2 = r1.f5333e
            int r2 = r2.getQos()
            if (r2 != r7) goto L_0x0064
            e.b.a.a.a.u.a r2 = r0.f5249d
            e.b.a.a.a.u.t.k r3 = new e.b.a.a.a.u.t.k
            r3.<init>((e.b.a.a.a.u.t.o) r1)
            e.b.a.a.a.t r1 = new e.b.a.a.a.t
            e.b.a.a.a.u.a r4 = r0.f5249d
            e.b.a.a.a.d r4 = r4.f5224a
            java.lang.String r4 = r4.getClientId()
            r1.<init>(r4)
            r2.e(r3, r1)
            goto L_0x00b5
        L_0x0064:
            e.b.a.a.a.o r2 = r1.f5333e
            int r2 = r2.getQos()
            if (r2 != r5) goto L_0x00b5
            e.b.a.a.a.u.a r2 = r0.f5249d
            e.b.a.a.a.u.b r2 = r2.g
            if (r2 == 0) goto L_0x00b3
            e.b.a.a.a.v.b r3 = e.b.a.a.a.u.b.C
            java.lang.String r4 = "e.b.a.a.a.u.b"
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r6 = new java.lang.Integer
            int r7 = r1.f5339b
            r6.<init>(r7)
            r5[r8] = r6
            java.lang.String r6 = "deliveryComplete"
            java.lang.String r7 = "641"
            r3.e(r4, r6, r7, r5)
            e.b.a.a.a.k r3 = r2.j
            java.lang.String r4 = r2.i(r1)
            r3.remove(r4)
            java.util.Hashtable r2 = r2.A
            java.lang.Integer r3 = new java.lang.Integer
            int r4 = r1.f5339b
            r3.<init>(r4)
            r2.remove(r3)
            e.b.a.a.a.u.t.l r2 = new e.b.a.a.a.u.t.l
            r2.<init>((e.b.a.a.a.u.t.o) r1)
            e.b.a.a.a.u.a r1 = r0.f5249d
            e.b.a.a.a.t r3 = new e.b.a.a.a.t
            e.b.a.a.a.d r4 = r1.f5224a
            java.lang.String r4 = r4.getClientId()
            r3.<init>(r4)
            r1.e(r2, r3)
            goto L_0x00b5
        L_0x00b3:
            r1 = 0
            throw r1
        L_0x00b5:
            return
        L_0x00b6:
            java.lang.Object r10 = r6.nextElement()
            java.lang.String r10 = (java.lang.String) r10
            int r11 = r2.length()
            int r12 = r10.length()
            a.e.a.a.r.b.e0(r10, r7)
            a.e.a.a.r.b.e0(r2, r8)
            boolean r13 = r10.equals(r2)
            if (r13 == 0) goto L_0x00d2
            r5 = 1
            goto L_0x0130
        L_0x00d2:
            r13 = 0
            r14 = 0
        L_0x00d4:
            if (r13 >= r12) goto L_0x0128
            if (r14 < r11) goto L_0x00d9
            goto L_0x0128
        L_0x00d9:
            char r15 = r2.charAt(r14)
            r5 = 47
            if (r15 != r5) goto L_0x00e8
            char r15 = r10.charAt(r13)
            if (r15 == r5) goto L_0x00e8
            goto L_0x0128
        L_0x00e8:
            char r15 = r10.charAt(r13)
            r8 = 35
            r7 = 43
            if (r15 == r7) goto L_0x0103
            char r15 = r10.charAt(r13)
            if (r15 == r8) goto L_0x0103
            char r15 = r10.charAt(r13)
            char r8 = r2.charAt(r14)
            if (r15 == r8) goto L_0x0103
            goto L_0x0128
        L_0x0103:
            char r8 = r10.charAt(r13)
            if (r8 != r7) goto L_0x0116
        L_0x0109:
            int r7 = r14 + 1
            if (r7 >= r11) goto L_0x0120
            char r8 = r2.charAt(r7)
            if (r8 != r5) goto L_0x0114
            goto L_0x0120
        L_0x0114:
            r14 = r7
            goto L_0x0109
        L_0x0116:
            char r5 = r10.charAt(r13)
            r7 = 35
            if (r5 != r7) goto L_0x0120
            int r14 = r11 + -1
        L_0x0120:
            int r13 = r13 + 1
            r5 = 1
            int r14 = r14 + r5
            r5 = 2
            r7 = 1
            r8 = 0
            goto L_0x00d4
        L_0x0128:
            r5 = 1
            if (r14 != r11) goto L_0x012f
            if (r13 != r12) goto L_0x012f
            r7 = 1
            goto L_0x0130
        L_0x012f:
            r7 = 0
        L_0x0130:
            if (r7 == 0) goto L_0x0146
            r4.setId(r3)
            java.util.Hashtable r7 = r0.f5248c
            java.lang.Object r7 = r7.get(r10)
            e.b.a.a.a.f r7 = (e.b.a.a.a.f) r7
            r7.messageArrived(r2, r4)
            r5 = 2
            r7 = 1
            r8 = 0
            r9 = 1
            goto L_0x002c
        L_0x0146:
            r5 = 2
            r7 = 1
            r8 = 0
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.c.d(e.b.a.a.a.u.t.o):void");
    }

    public boolean e() {
        return this.h && this.f.size() == 0 && this.f5250e.size() == 0;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000f A[LOOP:0: B:6:0x000f->B:33:0x000f, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(e.b.a.a.a.u.t.o r6) {
        /*
            r5 = this;
            e.b.a.a.a.i r0 = r5.f5246a
            if (r0 != 0) goto L_0x000c
            java.util.Hashtable r0 = r5.f5248c
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0057
        L_0x000c:
            java.lang.Object r0 = r5.l
            monitor-enter(r0)
        L_0x000f:
            boolean r1 = r5.g     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0035
            boolean r1 = r5.h     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x0035
            java.util.Vector r1 = r5.f5250e     // Catch:{ all -> 0x0058 }
            int r1 = r1.size()     // Catch:{ all -> 0x0058 }
            r2 = 10
            if (r1 >= r2) goto L_0x0022
            goto L_0x0035
        L_0x0022:
            e.b.a.a.a.v.b r1 = s     // Catch:{ InterruptedException -> 0x000f }
            java.lang.String r2 = r     // Catch:{ InterruptedException -> 0x000f }
            java.lang.String r3 = "messageArrived"
            java.lang.String r4 = "709"
            r1.h(r2, r3, r4)     // Catch:{ InterruptedException -> 0x000f }
            java.lang.Object r1 = r5.l     // Catch:{ InterruptedException -> 0x000f }
            r2 = 200(0xc8, double:9.9E-322)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x000f }
            goto L_0x000f
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            boolean r0 = r5.h
            if (r0 != 0) goto L_0x0057
            java.util.Vector r0 = r5.f5250e
            r0.addElement(r6)
            java.lang.Object r6 = r5.k
            monitor-enter(r6)
            e.b.a.a.a.v.b r0 = s     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = r     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "messageArrived"
            java.lang.String r3 = "710"
            r0.h(r1, r2, r3)     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r5.k     // Catch:{ all -> 0x0054 }
            r0.notifyAll()     // Catch:{ all -> 0x0054 }
            monitor-exit(r6)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            return
        L_0x0058:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            goto L_0x005c
        L_0x005b:
            throw r6
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.c.f(e.b.a.a.a.u.t.o):void");
    }

    public void g(String str, ExecutorService executorService) {
        this.o = str;
        synchronized (this.i) {
            if (!this.g) {
                this.f5250e.clear();
                this.f.clear();
                this.g = true;
                this.h = false;
                this.q = executorService.submit(this);
            }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void h() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.i
            monitor-enter(r0)
            java.util.concurrent.Future r1 = r6.q     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x000d
            java.util.concurrent.Future r1 = r6.q     // Catch:{ all -> 0x0067 }
            r2 = 1
            r1.cancel(r2)     // Catch:{ all -> 0x0067 }
        L_0x000d:
            boolean r1 = r6.g     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0057
            e.b.a.a.a.v.b r1 = s     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = r     // Catch:{ all -> 0x0067 }
            java.lang.String r3 = "stop"
            java.lang.String r4 = "700"
            r1.h(r2, r3, r4)     // Catch:{ all -> 0x0067 }
            r1 = 0
            r6.g = r1     // Catch:{ all -> 0x0067 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0067 }
            java.lang.Thread r2 = r6.j     // Catch:{ all -> 0x0067 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x0057
            java.lang.Object r1 = r6.k     // Catch:{ InterruptedException -> 0x0054, all -> 0x004d }
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0054, all -> 0x004d }
            e.b.a.a.a.v.b r2 = s     // Catch:{ all -> 0x004a }
            java.lang.String r3 = r     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "stop"
            java.lang.String r5 = "701"
            r2.h(r3, r4, r5)     // Catch:{ all -> 0x004a }
            java.lang.Object r2 = r6.k     // Catch:{ all -> 0x004a }
            r2.notifyAll()     // Catch:{ all -> 0x004a }
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            java.util.concurrent.Semaphore r1 = r6.p     // Catch:{ InterruptedException -> 0x0054, all -> 0x004d }
            r1.acquire()     // Catch:{ InterruptedException -> 0x0054, all -> 0x004d }
            java.util.concurrent.Semaphore r1 = r6.p     // Catch:{ all -> 0x0067 }
        L_0x0046:
            r1.release()     // Catch:{ all -> 0x0067 }
            goto L_0x0057
        L_0x004a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            throw r2     // Catch:{ InterruptedException -> 0x0054, all -> 0x004d }
        L_0x004d:
            r1 = move-exception
            java.util.concurrent.Semaphore r2 = r6.p     // Catch:{ all -> 0x0067 }
            r2.release()     // Catch:{ all -> 0x0067 }
            throw r1     // Catch:{ all -> 0x0067 }
        L_0x0054:
            java.util.concurrent.Semaphore r1 = r6.p     // Catch:{ all -> 0x0067 }
            goto L_0x0046
        L_0x0057:
            r1 = 0
            r6.j = r1     // Catch:{ all -> 0x0067 }
            e.b.a.a.a.v.b r1 = s     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = r     // Catch:{ all -> 0x0067 }
            java.lang.String r3 = "stop"
            java.lang.String r4 = "703"
            r1.h(r2, r3, r4)     // Catch:{ all -> 0x0067 }
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            return
        L_0x0067:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            goto L_0x006b
        L_0x006a:
            throw r1
        L_0x006b:
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.c.h():void");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void run() {
        /*
            r9 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r9.j = r0
            java.lang.String r1 = r9.o
            r0.setName(r1)
            r0 = 0
            java.util.concurrent.Semaphore r1 = r9.p     // Catch:{ InterruptedException -> 0x010d }
            r1.acquire()     // Catch:{ InterruptedException -> 0x010d }
        L_0x0011:
            boolean r1 = r9.g
            if (r1 != 0) goto L_0x0016
            return
        L_0x0016:
            r1 = 0
            java.lang.Object r2 = r9.k     // Catch:{ InterruptedException -> 0x0046 }
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x0046 }
            boolean r3 = r9.g     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x003e
            java.util.Vector r3 = r9.f5250e     // Catch:{ all -> 0x0040 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x003e
            java.util.Vector r3 = r9.f     // Catch:{ all -> 0x0040 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x003e
            e.b.a.a.a.v.b r3 = s     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = r     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = "run"
            java.lang.String r6 = "704"
            r3.h(r4, r5, r6)     // Catch:{ all -> 0x0040 }
            java.lang.Object r3 = r9.k     // Catch:{ all -> 0x0040 }
            r3.wait()     // Catch:{ all -> 0x0040 }
        L_0x003e:
            monitor-exit(r2)     // Catch:{ all -> 0x0040 }
            goto L_0x0046
        L_0x0040:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0040 }
            throw r3     // Catch:{ InterruptedException -> 0x0046 }
        L_0x0043:
            r2 = move-exception
            goto L_0x00b8
        L_0x0046:
            boolean r2 = r9.g     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0091
            java.util.Vector r2 = r9.f     // Catch:{ all -> 0x0043 }
            monitor-enter(r2)     // Catch:{ all -> 0x0043 }
            java.util.Vector r3 = r9.f     // Catch:{ all -> 0x008e }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x008e }
            if (r3 != 0) goto L_0x0063
            java.util.Vector r3 = r9.f     // Catch:{ all -> 0x008e }
            java.lang.Object r3 = r3.elementAt(r0)     // Catch:{ all -> 0x008e }
            e.b.a.a.a.t r3 = (e.b.a.a.a.t) r3     // Catch:{ all -> 0x008e }
            java.util.Vector r4 = r9.f     // Catch:{ all -> 0x008e }
            r4.removeElementAt(r0)     // Catch:{ all -> 0x008e }
            goto L_0x0064
        L_0x0063:
            r3 = r1
        L_0x0064:
            monitor-exit(r2)     // Catch:{ all -> 0x008e }
            if (r3 == 0) goto L_0x006a
            r9.c(r3)     // Catch:{ all -> 0x0043 }
        L_0x006a:
            java.util.Vector r2 = r9.f5250e     // Catch:{ all -> 0x0043 }
            monitor-enter(r2)     // Catch:{ all -> 0x0043 }
            java.util.Vector r3 = r9.f5250e     // Catch:{ all -> 0x008b }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x008b }
            if (r3 != 0) goto L_0x0083
            java.util.Vector r3 = r9.f5250e     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = r3.elementAt(r0)     // Catch:{ all -> 0x008b }
            e.b.a.a.a.u.t.o r3 = (e.b.a.a.a.u.t.o) r3     // Catch:{ all -> 0x008b }
            java.util.Vector r4 = r9.f5250e     // Catch:{ all -> 0x008b }
            r4.removeElementAt(r0)     // Catch:{ all -> 0x008b }
            goto L_0x0084
        L_0x0083:
            r3 = r1
        L_0x0084:
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x0091
            r9.d(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0091
        L_0x008b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            throw r3     // Catch:{ all -> 0x0043 }
        L_0x008e:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x008e }
            throw r3     // Catch:{ all -> 0x0043 }
        L_0x0091:
            boolean r2 = r9.h     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x009a
            e.b.a.a.a.u.b r2 = r9.m     // Catch:{ all -> 0x0043 }
            r2.b()     // Catch:{ all -> 0x0043 }
        L_0x009a:
            java.util.concurrent.Semaphore r1 = r9.p
            r1.release()
            java.lang.Object r2 = r9.l
            monitor-enter(r2)
            e.b.a.a.a.v.b r1 = s     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = r     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r1.h(r3, r4, r5)     // Catch:{ all -> 0x00b5 }
            java.lang.Object r1 = r9.l     // Catch:{ all -> 0x00b5 }
            r1.notifyAll()     // Catch:{ all -> 0x00b5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b5 }
            goto L_0x0011
        L_0x00b5:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00b5 }
            throw r0
        L_0x00b8:
            e.b.a.a.a.v.b r3 = s     // Catch:{ all -> 0x00ef }
            java.lang.String r4 = r     // Catch:{ all -> 0x00ef }
            java.lang.String r5 = "run"
            java.lang.String r6 = "714"
            r7 = 0
            r8 = r2
            r3.c(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ef }
            r9.g = r0     // Catch:{ all -> 0x00ef }
            e.b.a.a.a.u.a r3 = r9.f5249d     // Catch:{ all -> 0x00ef }
            e.b.a.a.a.n r4 = new e.b.a.a.a.n     // Catch:{ all -> 0x00ef }
            r4.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x00ef }
            r3.l(r1, r4)     // Catch:{ all -> 0x00ef }
            java.util.concurrent.Semaphore r1 = r9.p
            r1.release()
            java.lang.Object r1 = r9.l
            monitor-enter(r1)
            e.b.a.a.a.v.b r2 = s     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r2.h(r3, r4, r5)     // Catch:{ all -> 0x00ec }
            java.lang.Object r2 = r9.l     // Catch:{ all -> 0x00ec }
            r2.notifyAll()     // Catch:{ all -> 0x00ec }
            monitor-exit(r1)     // Catch:{ all -> 0x00ec }
            goto L_0x0011
        L_0x00ec:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ec }
            throw r0
        L_0x00ef:
            r0 = move-exception
            java.util.concurrent.Semaphore r1 = r9.p
            r1.release()
            java.lang.Object r1 = r9.l
            monitor-enter(r1)
            e.b.a.a.a.v.b r2 = s     // Catch:{ all -> 0x010a }
            java.lang.String r3 = r     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r2.h(r3, r4, r5)     // Catch:{ all -> 0x010a }
            java.lang.Object r2 = r9.l     // Catch:{ all -> 0x010a }
            r2.notifyAll()     // Catch:{ all -> 0x010a }
            monitor-exit(r1)     // Catch:{ all -> 0x010a }
            throw r0
        L_0x010a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x010a }
            throw r0
        L_0x010d:
            r9.g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.c.run():void");
    }
}
