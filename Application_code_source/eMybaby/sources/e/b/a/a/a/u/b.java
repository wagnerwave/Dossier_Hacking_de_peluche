package e.b.a.a.a.u;

import com.tuya.smart.mqtt.MqttServiceConstants;
import e.b.a.a.a.k;
import e.b.a.a.a.p;
import e.b.a.a.a.r;
import e.b.a.a.a.t;
import e.b.a.a.a.u.t.d;
import e.b.a.a.a.u.t.i;
import e.b.a.a.a.u.t.l;
import e.b.a.a.a.u.t.m;
import e.b.a.a.a.u.t.n;
import e.b.a.a.a.u.t.o;
import e.b.a.a.a.u.t.q;
import e.b.a.a.a.u.t.s;
import e.b.a.a.a.u.t.u;
import e.b.a.a.a.u.t.v;
import e.b.a.a.a.v.c;
import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class b {
    public static final e.b.a.a.a.v.b C = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", b.class.getName());
    public Hashtable A = null;
    public r B = null;

    /* renamed from: a  reason: collision with root package name */
    public int f5241a = 0;

    /* renamed from: b  reason: collision with root package name */
    public Hashtable f5242b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Vector f5243c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Vector f5244d;

    /* renamed from: e  reason: collision with root package name */
    public f f5245e;
    public a f = null;
    public c g = null;
    public long h;
    public boolean i;
    public k j;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public Object n = new Object();
    public Object o = new Object();
    public boolean p = false;
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public u t;
    public Object u = new Object();
    public int v = 0;
    public boolean w = false;
    public Hashtable x = null;
    public Hashtable y = null;
    public Hashtable z = null;

    public b(k kVar, f fVar, c cVar, a aVar, r rVar) {
        Hashtable hashtable;
        Object obj;
        Integer num;
        Hashtable hashtable2;
        Integer num2;
        Hashtable hashtable3;
        Integer num3;
        C.i(aVar.f5224a.getClientId());
        C.b("e.b.a.a.a.u.b", "<Init>", "");
        this.f5242b = new Hashtable();
        this.f5244d = new Vector();
        this.x = new Hashtable();
        this.y = new Hashtable();
        this.z = new Hashtable();
        this.A = new Hashtable();
        this.t = new i();
        this.m = 0;
        this.l = 0;
        this.j = kVar;
        this.g = cVar;
        this.f5245e = fVar;
        this.f = aVar;
        this.B = rVar;
        Enumeration keys = kVar.keys();
        int i2 = this.f5241a;
        Vector vector = new Vector();
        C.h("e.b.a.a.a.u.b", "restoreState", "600");
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            u z2 = z(str, this.j.get(str));
            if (z2 != null) {
                if (str.startsWith("r-")) {
                    C.e("e.b.a.a.a.u.b", "restoreState", "604", new Object[]{str, z2});
                    hashtable = this.A;
                    num = new Integer(z2.f5339b);
                    obj = z2;
                } else if (str.startsWith("s-")) {
                    o oVar = (o) z2;
                    i2 = Math.max(oVar.f5339b, i2);
                    if (this.j.containsKey(k(oVar))) {
                        n nVar = (n) z(str, this.j.get(k(oVar)));
                        if (nVar != null) {
                            C.e("e.b.a.a.a.u.b", "restoreState", "605", new Object[]{str, z2});
                            this.x.put(new Integer(nVar.f5339b), nVar);
                        } else {
                            C.e("e.b.a.a.a.u.b", "restoreState", "606", new Object[]{str, z2});
                        }
                    } else {
                        oVar.f5340c = true;
                        if (oVar.f5333e.getQos() == 2) {
                            C.e("e.b.a.a.a.u.b", "restoreState", "607", new Object[]{str, z2});
                            hashtable3 = this.x;
                            num3 = new Integer(oVar.f5339b);
                        } else {
                            C.e("e.b.a.a.a.u.b", "restoreState", "608", new Object[]{str, z2});
                            hashtable3 = this.y;
                            num3 = new Integer(oVar.f5339b);
                        }
                        hashtable3.put(num3, oVar);
                    }
                    this.f5245e.h(oVar).f5223a.j = this.f.f5224a;
                    hashtable = this.f5242b;
                    num = new Integer(oVar.f5339b);
                    obj = new Integer(oVar.f5339b);
                } else if (str.startsWith("sb-")) {
                    o oVar2 = (o) z2;
                    i2 = Math.max(oVar2.f5339b, i2);
                    if (oVar2.f5333e.getQos() == 2) {
                        C.e("e.b.a.a.a.u.b", "restoreState", "607", new Object[]{str, z2});
                        hashtable2 = this.x;
                        num2 = new Integer(oVar2.f5339b);
                    } else if (oVar2.f5333e.getQos() == 1) {
                        C.e("e.b.a.a.a.u.b", "restoreState", "608", new Object[]{str, z2});
                        hashtable2 = this.y;
                        num2 = new Integer(oVar2.f5339b);
                    } else {
                        C.e("e.b.a.a.a.u.b", "restoreState", "511", new Object[]{str, z2});
                        this.z.put(new Integer(oVar2.f5339b), oVar2);
                        this.j.remove(str);
                        this.f5245e.h(oVar2).f5223a.j = this.f.f5224a;
                        hashtable = this.f5242b;
                        num = new Integer(oVar2.f5339b);
                        obj = new Integer(oVar2.f5339b);
                    }
                    hashtable2.put(num2, oVar2);
                    this.f5245e.h(oVar2).f5223a.j = this.f.f5224a;
                    hashtable = this.f5242b;
                    num = new Integer(oVar2.f5339b);
                    obj = new Integer(oVar2.f5339b);
                } else if (str.startsWith("sc-") && !this.j.containsKey(l((n) z2))) {
                    vector.addElement(str);
                }
                hashtable.put(num, obj);
            }
        }
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            String str2 = (String) elements.nextElement();
            C.e("e.b.a.a.a.u.b", "restoreState", "609", new Object[]{str2});
            this.j.remove(str2);
        }
        this.f5241a = i2;
    }

    public void A(u uVar, t tVar) {
        k kVar;
        String l2;
        if (uVar.q() && uVar.f5339b == 0 && (((uVar instanceof o) && ((o) uVar).f5333e.getQos() != 0) || (uVar instanceof e.b.a.a.a.u.t.k) || (uVar instanceof m) || (uVar instanceof n) || (uVar instanceof l) || (uVar instanceof e.b.a.a.a.u.t.r) || (uVar instanceof q) || (uVar instanceof e.b.a.a.a.u.t.t) || (uVar instanceof s))) {
            uVar.s(h());
        }
        if (tVar != null) {
            try {
                tVar.f5223a.m = uVar.f5339b;
            } catch (Exception unused) {
            }
        }
        if (uVar instanceof o) {
            synchronized (this.n) {
                if (this.l < this.k) {
                    e.b.a.a.a.o oVar = ((o) uVar).f5333e;
                    C.e("e.b.a.a.a.u.b", MqttServiceConstants.SEND_ACTION, "628", new Object[]{new Integer(uVar.f5339b), new Integer(oVar.getQos()), uVar});
                    int qos = oVar.getQos();
                    if (qos == 1) {
                        this.y.put(new Integer(uVar.f5339b), uVar);
                        kVar = this.j;
                        l2 = l(uVar);
                    } else if (qos != 2) {
                        this.f5245e.j(tVar, uVar);
                        this.f5243c.addElement(uVar);
                        this.n.notifyAll();
                    } else {
                        this.x.put(new Integer(uVar.f5339b), uVar);
                        kVar = this.j;
                        l2 = l(uVar);
                    }
                    kVar.put(l2, (o) uVar);
                    this.f5245e.j(tVar, uVar);
                    this.f5243c.addElement(uVar);
                    this.n.notifyAll();
                } else {
                    C.e("e.b.a.a.a.u.b", MqttServiceConstants.SEND_ACTION, "613", new Object[]{new Integer(this.l)});
                    throw new e.b.a.a.a.n(32202);
                }
            }
            return;
        }
        C.e("e.b.a.a.a.u.b", MqttServiceConstants.SEND_ACTION, "615", new Object[]{new Integer(uVar.f5339b), uVar});
        if (uVar instanceof d) {
            synchronized (this.n) {
                this.f5245e.j(tVar, uVar);
                this.f5244d.insertElementAt(uVar, 0);
                this.n.notifyAll();
            }
            return;
        }
        if (uVar instanceof i) {
            this.t = uVar;
        } else if (uVar instanceof n) {
            this.x.put(new Integer(uVar.f5339b), uVar);
            this.j.put(k(uVar), (n) uVar);
        } else if (uVar instanceof l) {
            this.j.remove(i(uVar));
        }
        synchronized (this.n) {
            if (!(uVar instanceof e.b.a.a.a.u.t.b)) {
                this.f5245e.j(tVar, uVar);
            }
            this.f5244d.addElement(uVar);
            this.n.notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r2 <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r2 = java.lang.System.currentTimeMillis();
        r7 = r1.u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r1.v <= 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if ((r2 - r1.r) >= (r1.h + ((long) 100))) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        C.d("e.b.a.a.a.u.b", "checkForActivity", "619", new java.lang.Object[]{new java.lang.Long(r1.h), new java.lang.Long(r1.q), new java.lang.Long(r1.r), new java.lang.Long(r2), new java.lang.Long(r1.s)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
        throw a.e.a.a.r.b.g(32000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        if (r1.v != 0) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0097, code lost:
        if ((r2 - r1.q) >= (r1.h * 2)) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009a, code lost:
        C.d("e.b.a.a.a.u.b", "checkForActivity", "642", new java.lang.Object[]{new java.lang.Long(r1.h), new java.lang.Long(r1.q), new java.lang.Long(r1.r), new java.lang.Long(r2), new java.lang.Long(r1.s)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00db, code lost:
        throw a.e.a.a.r.b.g(32002);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00de, code lost:
        if (r1.v != 0) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ea, code lost:
        if ((r2 - r1.r) >= (r1.h - ((long) 100))) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f6, code lost:
        if ((r2 - r1.q) < (r1.h - ((long) 100))) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f8, code lost:
        C.e("e.b.a.a.a.u.b", "checkForActivity", "620", new java.lang.Object[]{new java.lang.Long(r1.h), new java.lang.Long(r1.q), new java.lang.Long(r1.r)});
        r2 = new e.b.a.a.a.t(r1.f.f5224a.getClientId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x012f, code lost:
        if (r0 == null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0131, code lost:
        r2.f5223a.k = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0135, code lost:
        r1.f5245e.j(r2, r1.t);
        r1.f5244d.insertElementAt(r1.t, 0);
        r3 = r1.h;
        o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0149, code lost:
        C.e("e.b.a.a.a.u.b", "checkForActivity", "634", (java.lang.Object[]) null);
        r16 = java.lang.Math.max(1, r1.h - (r2 - r1.q));
        r2 = null;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0165, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0166, code lost:
        C.e("e.b.a.a.a.u.b", "checkForActivity", "624", new java.lang.Object[]{new java.lang.Long(r3)});
        r1.B.schedule(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r2 = r1.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r1.w == false) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.b.a.a.a.t a(e.b.a.a.a.c r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            e.b.a.a.a.v.b r2 = C
            java.lang.String r3 = "e.b.a.a.a.u.b"
            java.lang.String r4 = "checkForActivity"
            java.lang.String r5 = "616"
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r2.e(r3, r4, r5, r7)
            java.lang.Object r2 = r1.o
            monitor-enter(r2)
            boolean r3 = r1.p     // Catch:{ all -> 0x0185 }
            r4 = 0
            if (r3 == 0) goto L_0x001c
            monitor-exit(r2)     // Catch:{ all -> 0x0185 }
            return r4
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x0185 }
            long r2 = r1.h
            boolean r5 = r1.w
            if (r5 == 0) goto L_0x0184
            r7 = 0
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0184
            long r2 = java.lang.System.currentTimeMillis()
            r5 = 100
            java.lang.Object r7 = r1.u
            monitor-enter(r7)
            int r8 = r1.v     // Catch:{ all -> 0x0181 }
            r10 = 5
            r13 = 1
            if (r8 <= 0) goto L_0x0087
            long r14 = r1.r     // Catch:{ all -> 0x0181 }
            long r14 = r2 - r14
            long r11 = r1.h     // Catch:{ all -> 0x0181 }
            long r8 = (long) r5     // Catch:{ all -> 0x0181 }
            long r11 = r11 + r8
            int r8 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r8 >= 0) goto L_0x0045
            goto L_0x0087
        L_0x0045:
            e.b.a.a.a.v.b r0 = C     // Catch:{ all -> 0x0181 }
            java.lang.String r4 = "e.b.a.a.a.u.b"
            java.lang.String r5 = "checkForActivity"
            java.lang.String r8 = "619"
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x0181 }
            java.lang.Long r10 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r11 = r1.h     // Catch:{ all -> 0x0181 }
            r10.<init>(r11)     // Catch:{ all -> 0x0181 }
            r9[r6] = r10     // Catch:{ all -> 0x0181 }
            java.lang.Long r6 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r10 = r1.q     // Catch:{ all -> 0x0181 }
            r6.<init>(r10)     // Catch:{ all -> 0x0181 }
            r9[r13] = r6     // Catch:{ all -> 0x0181 }
            java.lang.Long r6 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r10 = r1.r     // Catch:{ all -> 0x0181 }
            r6.<init>(r10)     // Catch:{ all -> 0x0181 }
            r10 = 2
            r9[r10] = r6     // Catch:{ all -> 0x0181 }
            java.lang.Long r6 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            r6.<init>(r2)     // Catch:{ all -> 0x0181 }
            r2 = 3
            r9[r2] = r6     // Catch:{ all -> 0x0181 }
            java.lang.Long r2 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r10 = r1.s     // Catch:{ all -> 0x0181 }
            r2.<init>(r10)     // Catch:{ all -> 0x0181 }
            r3 = 4
            r9[r3] = r2     // Catch:{ all -> 0x0181 }
            r0.d(r4, r5, r8, r9)     // Catch:{ all -> 0x0181 }
            r0 = 32000(0x7d00, float:4.4842E-41)
            e.b.a.a.a.n r0 = a.e.a.a.r.b.g(r0)     // Catch:{ all -> 0x0181 }
            throw r0     // Catch:{ all -> 0x0181 }
        L_0x0087:
            int r9 = r1.v     // Catch:{ all -> 0x0181 }
            if (r9 != 0) goto L_0x00dc
            long r11 = r1.q     // Catch:{ all -> 0x0181 }
            long r11 = r2 - r11
            r14 = 2
            long r8 = r1.h     // Catch:{ all -> 0x0181 }
            long r8 = r8 * r14
            int r14 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r14 >= 0) goto L_0x009a
            goto L_0x00dc
        L_0x009a:
            e.b.a.a.a.v.b r0 = C     // Catch:{ all -> 0x0181 }
            java.lang.String r4 = "e.b.a.a.a.u.b"
            java.lang.String r5 = "checkForActivity"
            java.lang.String r8 = "642"
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x0181 }
            java.lang.Long r10 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r11 = r1.h     // Catch:{ all -> 0x0181 }
            r10.<init>(r11)     // Catch:{ all -> 0x0181 }
            r9[r6] = r10     // Catch:{ all -> 0x0181 }
            java.lang.Long r6 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r10 = r1.q     // Catch:{ all -> 0x0181 }
            r6.<init>(r10)     // Catch:{ all -> 0x0181 }
            r9[r13] = r6     // Catch:{ all -> 0x0181 }
            java.lang.Long r6 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r10 = r1.r     // Catch:{ all -> 0x0181 }
            r6.<init>(r10)     // Catch:{ all -> 0x0181 }
            r10 = 2
            r9[r10] = r6     // Catch:{ all -> 0x0181 }
            java.lang.Long r6 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            r6.<init>(r2)     // Catch:{ all -> 0x0181 }
            r2 = 3
            r9[r2] = r6     // Catch:{ all -> 0x0181 }
            java.lang.Long r2 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r10 = r1.s     // Catch:{ all -> 0x0181 }
            r2.<init>(r10)     // Catch:{ all -> 0x0181 }
            r3 = 4
            r9[r3] = r2     // Catch:{ all -> 0x0181 }
            r0.d(r4, r5, r8, r9)     // Catch:{ all -> 0x0181 }
            r0 = 32002(0x7d02, float:4.4844E-41)
            e.b.a.a.a.n r0 = a.e.a.a.r.b.g(r0)     // Catch:{ all -> 0x0181 }
            throw r0     // Catch:{ all -> 0x0181 }
        L_0x00dc:
            int r9 = r1.v     // Catch:{ all -> 0x0181 }
            if (r9 != 0) goto L_0x00ec
            long r9 = r1.r     // Catch:{ all -> 0x0181 }
            long r9 = r2 - r9
            long r11 = r1.h     // Catch:{ all -> 0x0181 }
            long r14 = (long) r5     // Catch:{ all -> 0x0181 }
            long r11 = r11 - r14
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 >= 0) goto L_0x00f8
        L_0x00ec:
            long r9 = r1.q     // Catch:{ all -> 0x0181 }
            long r9 = r2 - r9
            long r11 = r1.h     // Catch:{ all -> 0x0181 }
            long r14 = (long) r5     // Catch:{ all -> 0x0181 }
            long r11 = r11 - r14
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x0149
        L_0x00f8:
            e.b.a.a.a.v.b r2 = C     // Catch:{ all -> 0x0181 }
            java.lang.String r3 = "e.b.a.a.a.u.b"
            java.lang.String r4 = "checkForActivity"
            java.lang.String r5 = "620"
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0181 }
            java.lang.Long r10 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r11 = r1.h     // Catch:{ all -> 0x0181 }
            r10.<init>(r11)     // Catch:{ all -> 0x0181 }
            r9[r6] = r10     // Catch:{ all -> 0x0181 }
            java.lang.Long r10 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r11 = r1.q     // Catch:{ all -> 0x0181 }
            r10.<init>(r11)     // Catch:{ all -> 0x0181 }
            r9[r13] = r10     // Catch:{ all -> 0x0181 }
            java.lang.Long r10 = new java.lang.Long     // Catch:{ all -> 0x0181 }
            long r11 = r1.r     // Catch:{ all -> 0x0181 }
            r10.<init>(r11)     // Catch:{ all -> 0x0181 }
            r8 = 2
            r9[r8] = r10     // Catch:{ all -> 0x0181 }
            r2.e(r3, r4, r5, r9)     // Catch:{ all -> 0x0181 }
            e.b.a.a.a.t r2 = new e.b.a.a.a.t     // Catch:{ all -> 0x0181 }
            e.b.a.a.a.u.a r3 = r1.f     // Catch:{ all -> 0x0181 }
            e.b.a.a.a.d r3 = r3.f5224a     // Catch:{ all -> 0x0181 }
            java.lang.String r3 = r3.getClientId()     // Catch:{ all -> 0x0181 }
            r2.<init>(r3)     // Catch:{ all -> 0x0181 }
            if (r0 == 0) goto L_0x0135
            e.b.a.a.a.u.q r3 = r2.f5223a     // Catch:{ all -> 0x0181 }
            r3.k = r0     // Catch:{ all -> 0x0181 }
        L_0x0135:
            e.b.a.a.a.u.f r0 = r1.f5245e     // Catch:{ all -> 0x0181 }
            e.b.a.a.a.u.t.u r3 = r1.t     // Catch:{ all -> 0x0181 }
            r0.j(r2, r3)     // Catch:{ all -> 0x0181 }
            java.util.Vector r0 = r1.f5244d     // Catch:{ all -> 0x0181 }
            e.b.a.a.a.u.t.u r3 = r1.t     // Catch:{ all -> 0x0181 }
            r0.insertElementAt(r3, r6)     // Catch:{ all -> 0x0181 }
            long r3 = r1.h     // Catch:{ all -> 0x0181 }
            r18.o()     // Catch:{ all -> 0x0181 }
            goto L_0x0165
        L_0x0149:
            e.b.a.a.a.v.b r0 = C     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = "e.b.a.a.a.u.b"
            java.lang.String r8 = "checkForActivity"
            java.lang.String r9 = "634"
            r0.e(r5, r8, r9, r4)     // Catch:{ all -> 0x0181 }
            r8 = 1
            long r10 = r1.h     // Catch:{ all -> 0x0181 }
            long r14 = r1.q     // Catch:{ all -> 0x0181 }
            long r2 = r2 - r14
            long r10 = r10 - r2
            long r2 = java.lang.Math.max(r8, r10)     // Catch:{ all -> 0x0181 }
            r16 = r2
            r2 = r4
            r3 = r16
        L_0x0165:
            monitor-exit(r7)     // Catch:{ all -> 0x0181 }
            e.b.a.a.a.v.b r0 = C
            java.lang.String r5 = "e.b.a.a.a.u.b"
            java.lang.String r7 = "checkForActivity"
            java.lang.String r8 = "624"
            java.lang.Object[] r9 = new java.lang.Object[r13]
            java.lang.Long r10 = new java.lang.Long
            r10.<init>(r3)
            r9[r6] = r10
            r0.e(r5, r7, r8, r9)
            e.b.a.a.a.r r0 = r1.B
            r0.schedule(r3)
            r4 = r2
            goto L_0x0184
        L_0x0181:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0181 }
            throw r0
        L_0x0184:
            return r4
        L_0x0185:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0185 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.b.a(e.b.a.a.a.c):e.b.a.a.a.t");
    }

    public boolean b() {
        int size;
        f fVar = this.f5245e;
        synchronized (fVar.f5262a) {
            size = fVar.f5262a.size();
        }
        if (!this.p || size != 0 || this.f5244d.size() != 0 || !this.g.e()) {
            return false;
        }
        C.e("e.b.a.a.a.u.b", "checkQuiesceLock", "626", new Object[]{new Boolean(this.p), new Integer(this.l), new Integer(this.f5244d.size()), new Integer(this.m), Boolean.valueOf(this.g.e()), new Integer(size)});
        synchronized (this.o) {
            this.o.notifyAll();
        }
        return true;
    }

    public void c() {
        C.h("e.b.a.a.a.u.b", "clearState", ">");
        this.j.clear();
        this.f5242b.clear();
        this.f5243c.clear();
        this.f5244d.clear();
        this.x.clear();
        this.y.clear();
        this.z.clear();
        this.A.clear();
        this.f5245e.a();
    }

    public void d() {
        this.f5242b.clear();
        if (this.f5243c != null) {
            this.f5243c.clear();
        }
        this.f5244d.clear();
        this.x.clear();
        this.y.clear();
        this.z.clear();
        this.A.clear();
        this.f5245e.a();
        this.f5242b = null;
        this.f5243c = null;
        this.f5244d = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.f5245e = null;
        this.g = null;
        this.f = null;
        this.j = null;
        this.t = null;
    }

    public final void e() {
        synchronized (this.n) {
            this.l--;
            C.e("e.b.a.a.a.u.b", "decrementInFlight", "646", new Object[]{new Integer(this.l)});
            if (!b()) {
                this.n.notifyAll();
            }
        }
    }

    public void f(e.b.a.a.a.n nVar) {
        C.e("e.b.a.a.a.u.b", "disconnected", "633", new Object[]{nVar});
        this.w = false;
        try {
            if (this.i) {
                c();
            }
            this.f5243c.clear();
            this.f5244d.clear();
            synchronized (this.u) {
                this.v = 0;
            }
        } catch (e.b.a.a.a.n unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|(2:15|16)|17|18|(3:27|(4:29|(1:31)|32|45)(2:33|(1:46)(2:35|(2:37|47)(2:38|48)))|42)(3:24|25|26)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.b.a.a.a.u.t.u g() {
        /*
            r11 = this;
            java.lang.Object r0 = r11.n
            monitor-enter(r0)
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r2 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00e2 }
            return r2
        L_0x0009:
            java.util.Vector r3 = r11.f5243c     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x0019
            java.util.Vector r3 = r11.f5244d     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0027
        L_0x0019:
            java.util.Vector r3 = r11.f5244d     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x0042
            int r3 = r11.l     // Catch:{ all -> 0x00e2 }
            int r4 = r11.k     // Catch:{ all -> 0x00e2 }
            if (r3 < r4) goto L_0x0042
        L_0x0027:
            e.b.a.a.a.v.b r3 = C     // Catch:{ InterruptedException -> 0x0042 }
            java.lang.String r4 = "e.b.a.a.a.u.b"
            java.lang.String r5 = "get"
            java.lang.String r6 = "644"
            r3.h(r4, r5, r6)     // Catch:{ InterruptedException -> 0x0042 }
            java.lang.Object r3 = r11.n     // Catch:{ InterruptedException -> 0x0042 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0042 }
            e.b.a.a.a.v.b r3 = C     // Catch:{ InterruptedException -> 0x0042 }
            java.lang.String r4 = "e.b.a.a.a.u.b"
            java.lang.String r5 = "get"
            java.lang.String r6 = "647"
            r3.h(r4, r5, r6)     // Catch:{ InterruptedException -> 0x0042 }
        L_0x0042:
            boolean r3 = r11.w     // Catch:{ all -> 0x00e2 }
            r4 = 0
            if (r3 != 0) goto L_0x0068
            java.util.Vector r3 = r11.f5244d     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x005b
            java.util.Vector r3 = r11.f5244d     // Catch:{ all -> 0x00e2 }
            java.lang.Object r3 = r3.elementAt(r4)     // Catch:{ all -> 0x00e2 }
            e.b.a.a.a.u.t.u r3 = (e.b.a.a.a.u.t.u) r3     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3 instanceof e.b.a.a.a.u.t.d     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0068
        L_0x005b:
            e.b.a.a.a.v.b r2 = C     // Catch:{ all -> 0x00e2 }
            java.lang.String r3 = "e.b.a.a.a.u.b"
            java.lang.String r4 = "get"
            java.lang.String r5 = "621"
            r2.h(r3, r4, r5)     // Catch:{ all -> 0x00e2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e2 }
            return r1
        L_0x0068:
            java.util.Vector r3 = r11.f5244d     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00e2 }
            r5 = 1
            if (r3 != 0) goto L_0x009d
            java.util.Vector r2 = r11.f5244d     // Catch:{ all -> 0x00e2 }
            java.lang.Object r2 = r2.remove(r4)     // Catch:{ all -> 0x00e2 }
            e.b.a.a.a.u.t.u r2 = (e.b.a.a.a.u.t.u) r2     // Catch:{ all -> 0x00e2 }
            boolean r3 = r2 instanceof e.b.a.a.a.u.t.n     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x0098
            int r3 = r11.m     // Catch:{ all -> 0x00e2 }
            int r3 = r3 + r5
            r11.m = r3     // Catch:{ all -> 0x00e2 }
            e.b.a.a.a.v.b r3 = C     // Catch:{ all -> 0x00e2 }
            java.lang.String r6 = "e.b.a.a.a.u.b"
            java.lang.String r7 = "get"
            java.lang.String r8 = "617"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r9 = new java.lang.Integer     // Catch:{ all -> 0x00e2 }
            int r10 = r11.m     // Catch:{ all -> 0x00e2 }
            r9.<init>(r10)     // Catch:{ all -> 0x00e2 }
            r5[r4] = r9     // Catch:{ all -> 0x00e2 }
            r3.e(r6, r7, r8, r5)     // Catch:{ all -> 0x00e2 }
        L_0x0098:
            r11.b()     // Catch:{ all -> 0x00e2 }
            goto L_0x0005
        L_0x009d:
            java.util.Vector r3 = r11.f5243c     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0005
            int r3 = r11.l     // Catch:{ all -> 0x00e2 }
            int r6 = r11.k     // Catch:{ all -> 0x00e2 }
            if (r3 >= r6) goto L_0x00d5
            java.util.Vector r2 = r11.f5243c     // Catch:{ all -> 0x00e2 }
            java.lang.Object r2 = r2.elementAt(r4)     // Catch:{ all -> 0x00e2 }
            e.b.a.a.a.u.t.u r2 = (e.b.a.a.a.u.t.u) r2     // Catch:{ all -> 0x00e2 }
            java.util.Vector r3 = r11.f5243c     // Catch:{ all -> 0x00e2 }
            r3.removeElementAt(r4)     // Catch:{ all -> 0x00e2 }
            int r3 = r11.l     // Catch:{ all -> 0x00e2 }
            int r3 = r3 + r5
            r11.l = r3     // Catch:{ all -> 0x00e2 }
            e.b.a.a.a.v.b r3 = C     // Catch:{ all -> 0x00e2 }
            java.lang.String r6 = "e.b.a.a.a.u.b"
            java.lang.String r7 = "get"
            java.lang.String r8 = "623"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r9 = new java.lang.Integer     // Catch:{ all -> 0x00e2 }
            int r10 = r11.l     // Catch:{ all -> 0x00e2 }
            r9.<init>(r10)     // Catch:{ all -> 0x00e2 }
            r5[r4] = r9     // Catch:{ all -> 0x00e2 }
            r3.e(r6, r7, r8, r5)     // Catch:{ all -> 0x00e2 }
            goto L_0x0005
        L_0x00d5:
            e.b.a.a.a.v.b r3 = C     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = "e.b.a.a.a.u.b"
            java.lang.String r5 = "get"
            java.lang.String r6 = "622"
            r3.h(r4, r5, r6)     // Catch:{ all -> 0x00e2 }
            goto L_0x0005
        L_0x00e2:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e2 }
            goto L_0x00e6
        L_0x00e5:
            throw r1
        L_0x00e6:
            goto L_0x00e5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.b.g():e.b.a.a.a.u.t.u");
    }

    public final synchronized int h() {
        int i2 = this.f5241a;
        int i3 = 0;
        do {
            int i4 = this.f5241a + 1;
            this.f5241a = i4;
            if (i4 > 65535) {
                this.f5241a = 1;
            }
            if (this.f5241a == i2) {
                i3++;
                if (i3 == 2) {
                    throw a.e.a.a.r.b.g(32001);
                }
            }
        } while (this.f5242b.containsKey(new Integer(this.f5241a)));
        Integer num = new Integer(this.f5241a);
        this.f5242b.put(num, num);
        return this.f5241a;
    }

    public final String i(u uVar) {
        return "r-" + uVar.f5339b;
    }

    public final String j(u uVar) {
        return "sb-" + uVar.f5339b;
    }

    public final String k(u uVar) {
        return "sc-" + uVar.f5339b;
    }

    public final String l(u uVar) {
        return "s-" + uVar.f5339b;
    }

    public final void m(Vector vector, u uVar) {
        int i2 = uVar.f5339b;
        for (int i3 = 0; i3 < vector.size(); i3++) {
            if (((u) vector.elementAt(i3)).f5339b > i2) {
                vector.insertElementAt(uVar, i3);
                return;
            }
        }
        vector.addElement(uVar);
    }

    public void n(t tVar) {
        u uVar = tVar.f5223a.f;
        if (uVar != null && (uVar instanceof e.b.a.a.a.u.t.b)) {
            C.e("e.b.a.a.a.u.b", "notifyComplete", "629", new Object[]{new Integer(uVar.f5339b), tVar, uVar});
            e.b.a.a.a.u.t.b bVar = (e.b.a.a.a.u.t.b) uVar;
            if (bVar instanceof e.b.a.a.a.u.t.k) {
                this.j.remove(l(uVar));
                this.j.remove(j(uVar));
                this.y.remove(new Integer(bVar.f5339b));
                e();
                w(uVar.f5339b);
                this.f5245e.g(uVar);
                C.e("e.b.a.a.a.u.b", "notifyComplete", "650", new Object[]{new Integer(bVar.f5339b)});
            } else if (bVar instanceof l) {
                this.j.remove(l(uVar));
                this.j.remove(k(uVar));
                this.j.remove(j(uVar));
                this.x.remove(new Integer(bVar.f5339b));
                this.m--;
                e();
                w(uVar.f5339b);
                this.f5245e.g(uVar);
                C.e("e.b.a.a.a.u.b", "notifyComplete", "645", new Object[]{new Integer(bVar.f5339b), new Integer(this.m)});
            }
            b();
        }
    }

    public void o() {
        synchronized (this.n) {
            C.h("e.b.a.a.a.u.b", "notifyQueueLock", "638");
            this.n.notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e1, code lost:
        s(r11, r0, (e.b.a.a.a.n) null);
        r10.f5245e.g(r11);
        r11 = r10.n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r10.n.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f1, code lost:
        monitor-exit(r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(e.b.a.a.a.u.t.b r11) {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r10.r = r0
            e.b.a.a.a.v.b r0 = C
            java.lang.String r1 = "e.b.a.a.a.u.b"
            java.lang.String r2 = "notifyReceivedAck"
            java.lang.String r3 = "627"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = new java.lang.Integer
            int r6 = r11.f5339b
            r5.<init>(r6)
            r6 = 0
            r4[r6] = r5
            r5 = 1
            r4[r5] = r11
            r0.e(r1, r2, r3, r4)
            e.b.a.a.a.u.f r0 = r10.f5245e
            e.b.a.a.a.t r0 = r0.d(r11)
            if (r0 != 0) goto L_0x0041
            e.b.a.a.a.v.b r0 = C
            java.lang.String r1 = "e.b.a.a.a.u.b"
            java.lang.String r2 = "notifyReceivedAck"
            java.lang.String r3 = "662"
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Integer r5 = new java.lang.Integer
            int r11 = r11.f5339b
            r5.<init>(r11)
            r4[r6] = r5
            r0.e(r1, r2, r3, r4)
            goto L_0x0129
        L_0x0041:
            boolean r1 = r11 instanceof e.b.a.a.a.u.t.m
            if (r1 == 0) goto L_0x0051
            e.b.a.a.a.u.t.n r1 = new e.b.a.a.a.u.t.n
            e.b.a.a.a.u.t.m r11 = (e.b.a.a.a.u.t.m) r11
            r1.<init>((e.b.a.a.a.u.t.m) r11)
            r10.A(r1, r0)
            goto L_0x0129
        L_0x0051:
            boolean r1 = r11 instanceof e.b.a.a.a.u.t.k
            r2 = 0
            if (r1 != 0) goto L_0x0126
            boolean r1 = r11 instanceof e.b.a.a.a.u.t.l
            if (r1 == 0) goto L_0x005c
            goto L_0x0126
        L_0x005c:
            boolean r1 = r11 instanceof e.b.a.a.a.u.t.j
            if (r1 == 0) goto L_0x0094
            java.lang.Object r1 = r10.u
            monitor-enter(r1)
            int r3 = r10.v     // Catch:{ all -> 0x0091 }
            int r3 = r3 - r5
            int r3 = java.lang.Math.max(r6, r3)     // Catch:{ all -> 0x0091 }
            r10.v = r3     // Catch:{ all -> 0x0091 }
            r10.s(r11, r0, r2)     // Catch:{ all -> 0x0091 }
            int r0 = r10.v     // Catch:{ all -> 0x0091 }
            if (r0 != 0) goto L_0x0078
            e.b.a.a.a.u.f r0 = r10.f5245e     // Catch:{ all -> 0x0091 }
            r0.g(r11)     // Catch:{ all -> 0x0091 }
        L_0x0078:
            monitor-exit(r1)     // Catch:{ all -> 0x0091 }
            e.b.a.a.a.v.b r11 = C
            java.lang.String r0 = "e.b.a.a.a.u.b"
            java.lang.String r1 = "notifyReceivedAck"
            java.lang.String r2 = "636"
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.Integer r4 = new java.lang.Integer
            int r5 = r10.v
            r4.<init>(r5)
            r3[r6] = r4
            r11.e(r0, r1, r2, r3)
            goto L_0x0129
        L_0x0091:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0091 }
            throw r11
        L_0x0094:
            boolean r1 = r11 instanceof e.b.a.a.a.u.t.c
            if (r1 == 0) goto L_0x0118
            r1 = r11
            e.b.a.a.a.u.t.c r1 = (e.b.a.a.a.u.t.c) r1
            int r3 = r1.f5322e
            if (r3 != 0) goto L_0x0113
            java.lang.Object r4 = r10.n
            monitor-enter(r4)
            boolean r3 = r10.i     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x00ae
            r10.c()     // Catch:{ all -> 0x0110 }
            e.b.a.a.a.u.f r3 = r10.f5245e     // Catch:{ all -> 0x0110 }
            r3.j(r0, r11)     // Catch:{ all -> 0x0110 }
        L_0x00ae:
            r10.m = r6     // Catch:{ all -> 0x0110 }
            r10.l = r6     // Catch:{ all -> 0x0110 }
            r10.y()     // Catch:{ all -> 0x0110 }
            e.b.a.a.a.v.b r3 = C     // Catch:{ all -> 0x0110 }
            java.lang.String r7 = "e.b.a.a.a.u.b"
            java.lang.String r8 = "connected"
            java.lang.String r9 = "631"
            r3.h(r7, r8, r9)     // Catch:{ all -> 0x0110 }
            r10.w = r5     // Catch:{ all -> 0x0110 }
            e.b.a.a.a.r r3 = r10.B     // Catch:{ all -> 0x0110 }
            r3.start()     // Catch:{ all -> 0x0110 }
            monitor-exit(r4)     // Catch:{ all -> 0x0110 }
            e.b.a.a.a.u.a r3 = r10.f
            if (r3 == 0) goto L_0x010f
            int r1 = r1.f5322e
            java.lang.Object r4 = r3.n
            monitor-enter(r4)
            if (r1 != 0) goto L_0x00f6
            e.b.a.a.a.v.b r1 = e.b.a.a.a.u.a.r     // Catch:{ all -> 0x010c }
            java.lang.String r5 = "e.b.a.a.a.u.a"
            java.lang.String r7 = "connectComplete"
            java.lang.String r8 = "215"
            r1.h(r5, r7, r8)     // Catch:{ all -> 0x010c }
            r3.m = r6     // Catch:{ all -> 0x010c }
            monitor-exit(r4)     // Catch:{ all -> 0x010c }
            r10.s(r11, r0, r2)
            e.b.a.a.a.u.f r0 = r10.f5245e
            r0.g(r11)
            java.lang.Object r11 = r10.n
            monitor-enter(r11)
            java.lang.Object r0 = r10.n     // Catch:{ all -> 0x00f3 }
            r0.notifyAll()     // Catch:{ all -> 0x00f3 }
            monitor-exit(r11)     // Catch:{ all -> 0x00f3 }
            goto L_0x0129
        L_0x00f3:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00f3 }
            throw r0
        L_0x00f6:
            monitor-exit(r4)     // Catch:{ all -> 0x010c }
            e.b.a.a.a.v.b r11 = e.b.a.a.a.u.a.r
            java.lang.String r0 = "e.b.a.a.a.u.a"
            java.lang.String r3 = "connectComplete"
            java.lang.String r4 = "204"
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r1)
            r5[r6] = r7
            r11.e(r0, r3, r4, r5)
            throw r2
        L_0x010c:
            r11 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x010c }
            throw r11
        L_0x010f:
            throw r2
        L_0x0110:
            r11 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0110 }
            throw r11
        L_0x0113:
            e.b.a.a.a.n r11 = a.e.a.a.r.b.g(r3)
            throw r11
        L_0x0118:
            r10.s(r11, r0, r2)
            int r0 = r11.f5339b
            r10.w(r0)
            e.b.a.a.a.u.f r0 = r10.f5245e
            r0.g(r11)
            goto L_0x0129
        L_0x0126:
            r10.s(r11, r0, r2)
        L_0x0129:
            r10.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.b.p(e.b.a.a.a.u.t.b):void");
    }

    public void q(int i2) {
        if (i2 > 0) {
            this.r = System.currentTimeMillis();
        }
        C.e("e.b.a.a.a.u.b", "notifyReceivedBytes", "630", new Object[]{new Integer(i2)});
    }

    public void r(u uVar) {
        c cVar;
        o oVar;
        this.r = System.currentTimeMillis();
        C.e("e.b.a.a.a.u.b", "notifyReceivedMsg", "651", new Object[]{new Integer(uVar.f5339b), uVar});
        if (!this.p) {
            if (uVar instanceof o) {
                oVar = (o) uVar;
                int qos = oVar.f5333e.getQos();
                if (qos == 0 || qos == 1) {
                    cVar = this.g;
                    if (cVar == null) {
                        return;
                    }
                } else if (qos == 2) {
                    this.j.put(i(uVar), oVar);
                    this.A.put(new Integer(oVar.f5339b), oVar);
                    A(new m(oVar), (t) null);
                    return;
                } else {
                    return;
                }
            } else if (uVar instanceof n) {
                oVar = (o) this.A.get(new Integer(uVar.f5339b));
                if (oVar != null) {
                    cVar = this.g;
                    if (cVar == null) {
                        return;
                    }
                } else {
                    A(new l(uVar.f5339b), (t) null);
                    return;
                }
            } else {
                return;
            }
            cVar.f(oVar);
        }
    }

    public void s(u uVar, t tVar, e.b.a.a.a.n nVar) {
        tVar.f5223a.a(uVar, (e.b.a.a.a.n) null);
        tVar.f5223a.b();
        if (!(uVar instanceof m)) {
            C.e("e.b.a.a.a.u.b", "notifyResult", "648", new Object[]{tVar.f5223a.i, uVar, null});
            this.g.a(tVar);
        }
    }

    public void t(u uVar) {
        this.q = System.currentTimeMillis();
        C.e("e.b.a.a.a.u.b", "notifySent", "625", new Object[]{uVar.m()});
        t d2 = this.f5245e.d(uVar);
        q qVar = d2.f5223a;
        q.o.e("e.b.a.a.a.u.q", "notifySent", "403", new Object[]{qVar.i});
        synchronized (qVar.f5293d) {
            qVar.f = null;
            qVar.f5290a = false;
        }
        synchronized (qVar.f5294e) {
            qVar.f5292c = true;
            qVar.f5294e.notifyAll();
        }
        if (uVar instanceof i) {
            synchronized (this.u) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.u) {
                    this.s = currentTimeMillis;
                    this.v++;
                }
                C.e("e.b.a.a.a.u.b", "notifySent", "635", new Object[]{new Integer(this.v)});
            }
        } else if ((uVar instanceof o) && ((o) uVar).f5333e.getQos() == 0) {
            d2.f5223a.a((u) null, (e.b.a.a.a.n) null);
            this.g.a(d2);
            e();
            w(uVar.f5339b);
            this.f5245e.g(uVar);
            b();
        }
    }

    public void u(int i2) {
        if (i2 > 0) {
            this.q = System.currentTimeMillis();
        }
        C.e("e.b.a.a.a.u.b", "notifySentBytes", "643", new Object[]{new Integer(i2)});
    }

    public final Vector v(Vector vector) {
        Vector vector2 = new Vector();
        if (vector.size() == 0) {
            return vector2;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < vector.size()) {
            int i6 = ((u) vector.elementAt(i2)).f5339b;
            int i7 = i6 - i3;
            if (i7 > i4) {
                i5 = i2;
                i4 = i7;
            }
            i2++;
            i3 = i6;
        }
        int i8 = (65535 - i3) + ((u) vector.elementAt(0)).f5339b > i4 ? 0 : i5;
        for (int i9 = i8; i9 < vector.size(); i9++) {
            vector2.addElement(vector.elementAt(i9));
        }
        for (int i10 = 0; i10 < i8; i10++) {
            vector2.addElement(vector.elementAt(i10));
        }
        return vector2;
    }

    public final synchronized void w(int i2) {
        this.f5242b.remove(new Integer(i2));
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 143 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Vector x(e.b.a.a.a.n r7) {
        /*
            r6 = this;
            e.b.a.a.a.v.b r0 = C
            java.lang.String r1 = "e.b.a.a.a.u.b"
            java.lang.String r2 = "resolveOldTokens"
            java.lang.String r3 = "632"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r7
            r0.e(r1, r2, r3, r4)
            if (r7 != 0) goto L_0x001a
            e.b.a.a.a.n r7 = new e.b.a.a.a.n
            r0 = 32102(0x7d66, float:4.4984E-41)
            r7.<init>((int) r0)
        L_0x001a:
            e.b.a.a.a.u.f r0 = r6.f5245e
            java.util.Hashtable r1 = r0.f5262a
            monitor-enter(r1)
            e.b.a.a.a.v.b r2 = e.b.a.a.a.u.f.f5261d     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = "e.b.a.a.a.u.f"
            java.lang.String r4 = "getOutstandingTokens"
            java.lang.String r5 = "312"
            r2.h(r3, r4, r5)     // Catch:{ all -> 0x0085 }
            java.util.Vector r2 = new java.util.Vector     // Catch:{ all -> 0x0085 }
            r2.<init>()     // Catch:{ all -> 0x0085 }
            java.util.Hashtable r0 = r0.f5262a     // Catch:{ all -> 0x0085 }
            java.util.Enumeration r0 = r0.elements()     // Catch:{ all -> 0x0085 }
        L_0x0035:
            boolean r3 = r0.hasMoreElements()     // Catch:{ all -> 0x0085 }
            if (r3 != 0) goto L_0x0079
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            java.util.Enumeration r0 = r2.elements()
        L_0x0040:
            boolean r1 = r0.hasMoreElements()
            if (r1 != 0) goto L_0x0047
            return r2
        L_0x0047:
            java.lang.Object r1 = r0.nextElement()
            r3 = r1
            e.b.a.a.a.t r3 = (e.b.a.a.a.t) r3
            monitor-enter(r3)
            e.b.a.a.a.u.q r1 = r3.f5223a     // Catch:{ all -> 0x0077 }
            boolean r1 = r1.f5290a     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x0066
            e.b.a.a.a.u.q r1 = r3.f5223a     // Catch:{ all -> 0x0077 }
            boolean r1 = r1.f5291b     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x0066
            e.b.a.a.a.u.q r1 = r3.f5223a     // Catch:{ all -> 0x0077 }
            e.b.a.a.a.n r1 = r1.g     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x0066
            e.b.a.a.a.u.q r1 = r3.f5223a     // Catch:{ all -> 0x0077 }
            r1.c(r7)     // Catch:{ all -> 0x0077 }
        L_0x0066:
            monitor-exit(r3)     // Catch:{ all -> 0x0077 }
            boolean r1 = r3 instanceof e.b.a.a.a.m
            if (r1 != 0) goto L_0x0040
            e.b.a.a.a.u.f r1 = r6.f5245e
            e.b.a.a.a.u.q r3 = r3.f5223a
            java.lang.String r3 = r3.i
            r1.f(r3)
            goto L_0x0040
        L_0x0075:
            monitor-exit(r3)     // Catch:{ all -> 0x0077 }
            throw r7
        L_0x0077:
            r7 = move-exception
            goto L_0x0075
        L_0x0079:
            java.lang.Object r3 = r0.nextElement()     // Catch:{ all -> 0x0085 }
            e.b.a.a.a.t r3 = (e.b.a.a.a.t) r3     // Catch:{ all -> 0x0085 }
            if (r3 == 0) goto L_0x0035
            r2.addElement(r3)     // Catch:{ all -> 0x0085 }
            goto L_0x0035
        L_0x0085:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            goto L_0x0089
        L_0x0088:
            throw r7
        L_0x0089:
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.b.x(e.b.a.a.a.n):java.util.Vector");
    }

    public final void y() {
        Vector vector;
        u uVar;
        this.f5243c = new Vector(this.k);
        this.f5244d = new Vector();
        Enumeration keys = this.x.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            u uVar2 = (u) this.x.get(nextElement);
            if (uVar2 instanceof o) {
                C.e("e.b.a.a.a.u.b", "restoreInflightMessages", "610", new Object[]{nextElement});
                uVar2.f5340c = true;
                vector = this.f5243c;
                uVar = (o) uVar2;
            } else if (uVar2 instanceof n) {
                C.e("e.b.a.a.a.u.b", "restoreInflightMessages", "611", new Object[]{nextElement});
                vector = this.f5244d;
                uVar = (n) uVar2;
            }
            m(vector, uVar);
        }
        Enumeration keys2 = this.y.keys();
        while (keys2.hasMoreElements()) {
            Object nextElement2 = keys2.nextElement();
            o oVar = (o) this.y.get(nextElement2);
            oVar.f5340c = true;
            C.e("e.b.a.a.a.u.b", "restoreInflightMessages", "612", new Object[]{nextElement2});
            m(this.f5243c, oVar);
        }
        Enumeration keys3 = this.z.keys();
        while (keys3.hasMoreElements()) {
            Object nextElement3 = keys3.nextElement();
            C.e("e.b.a.a.a.u.b", "restoreInflightMessages", "512", new Object[]{nextElement3});
            m(this.f5243c, (o) this.z.get(nextElement3));
        }
        this.f5244d = v(this.f5244d);
        this.f5243c = v(this.f5243c);
    }

    public final u z(String str, p pVar) {
        u uVar;
        try {
            byte[] c2 = pVar.c();
            if (c2 == null) {
                c2 = new byte[0];
            }
            uVar = u.g(new v(pVar.e(), pVar.b(), pVar.f(), c2, pVar.d(), pVar.a()));
        } catch (e.b.a.a.a.n e2) {
            C.c("e.b.a.a.a.u.b", "restoreMessage", "602", new Object[]{str}, e2);
            if (e2.f5222b instanceof EOFException) {
                if (str != null) {
                    this.j.remove(str);
                }
                uVar = null;
            } else {
                throw e2;
            }
        }
        C.e("e.b.a.a.a.u.b", "restoreMessage", "601", new Object[]{str, uVar});
        return uVar;
    }
}
