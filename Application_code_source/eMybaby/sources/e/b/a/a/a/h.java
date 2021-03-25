package e.b.a.a.a;

import com.tuya.smart.common.OO000o0;
import com.tuya.smart.mqtt.MqttServiceConstants;
import e.b.a.a.a.u.q;
import e.b.a.a.a.u.t.e;
import e.b.a.a.a.u.t.o;
import e.b.a.a.a.u.t.r;
import e.b.a.a.a.u.t.t;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class h implements d {
    public static final e.b.a.a.a.v.b k = e.b.a.a.a.v.c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", h.class.getName());
    public static int l = 1000;
    public static Object m = new Object();

    /* renamed from: a  reason: collision with root package name */
    public String f5206a;

    /* renamed from: b  reason: collision with root package name */
    public String f5207b;

    /* renamed from: c  reason: collision with root package name */
    public e.b.a.a.a.u.a f5208c;

    /* renamed from: d  reason: collision with root package name */
    public k f5209d;

    /* renamed from: e  reason: collision with root package name */
    public i f5210e;
    public l f;
    public Object g;
    public Timer h;
    public boolean i = false;
    public ScheduledExecutorService j;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f5211a;

        public a(String str) {
            this.f5211a = str;
        }

        public void onFailure(g gVar, Throwable th) {
            h.k.e("e.b.a.a.a.h", this.f5211a, "502", new Object[]{gVar.getClient().getClientId()});
            int i = h.l;
            if (i < 128000) {
                h.l = i * 2;
            }
            int i2 = h.l;
            h.k.e("e.b.a.a.a.h", String.valueOf(this.f5211a) + ":rescheduleReconnectCycle", "505", new Object[]{h.this.f5206a, String.valueOf(h.l)});
            synchronized (h.m) {
                if (h.this.f.n) {
                    if (h.this.h != null) {
                        h.this.h.schedule(new c((c) null), (long) i2);
                    } else {
                        h.l = i2;
                        h.a(h.this);
                    }
                }
            }
        }

        public void onSuccess(g gVar) {
            h.k.e("e.b.a.a.a.h", this.f5211a, "501", new Object[]{gVar.getClient().getClientId()});
            h hVar = h.this;
            if (hVar.f5208c != null) {
                hVar.i();
                return;
            }
            throw null;
        }
    }

    public class b implements j {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f5213a;

        public b(boolean z) {
            this.f5213a = z;
        }

        public void connectComplete(boolean z, String str) {
        }

        public void connectionLost(Throwable th) {
            if (this.f5213a) {
                h hVar = h.this;
                if (hVar.f5208c != null) {
                    hVar.i = true;
                    h.a(hVar);
                    return;
                }
                throw null;
            }
        }

        public void deliveryComplete(e eVar) {
        }

        public void messageArrived(String str, o oVar) {
        }
    }

    public class c extends TimerTask {
        public c(c cVar) {
        }

        public void run() {
            h.k.h("e.b.a.a.a.h", "ReconnectTask.run", "506");
            h.this.b();
        }
    }

    public h(String str, String str2, k kVar, r rVar) {
        k.i(str2);
        if (str2 != null) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < str2.length() - 1) {
                char charAt = str2.charAt(i2);
                if (charAt >= 55296 && charAt <= 56319) {
                    i2++;
                }
                i3++;
                i2++;
            }
            if (i3 <= 65535) {
                l.c(str);
                this.f5207b = str;
                this.f5206a = str2;
                this.f5209d = kVar;
                if (kVar == null) {
                    this.f5209d = new e.b.a.a.a.w.a();
                }
                this.j = null;
                this.j = Executors.newScheduledThreadPool(10);
                k.e("e.b.a.a.a.h", "MqttAsyncClient", "101", new Object[]{str2, str, kVar});
                this.f5209d.open(str2, str);
                this.f5208c = new e.b.a.a.a.u.a(this, this.f5209d, rVar, this.j);
                this.f5209d.close();
                new Hashtable();
                return;
            }
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        throw new IllegalArgumentException("Null clientId");
    }

    public static void a(h hVar) {
        k.e("e.b.a.a.a.h", "startReconnectCycle", "503", new Object[]{hVar.f5206a, new Long((long) l)});
        Timer timer = new Timer("MQTT Reconnect: " + hVar.f5206a);
        hVar.h = timer;
        timer.schedule(new c((c) null), (long) l);
    }

    public final void b() {
        k.e("e.b.a.a.a.h", "attemptReconnect", "500", new Object[]{this.f5206a});
        try {
            c(this.f, this.g, new a("attemptReconnect"));
        } catch (n | s e2) {
            k.c("e.b.a.a.a.h", "attemptReconnect", "804", (Object[]) null, e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: e.b.a.a.a.u.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: e.b.a.a.a.u.s.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: e.b.a.a.a.u.s.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: e.b.a.a.a.u.s.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: e.b.a.a.a.u.s.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: e.b.a.a.a.u.s.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v19, resolved type: e.b.a.a.a.u.s.h} */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.b.a.a.a.g c(e.b.a.a.a.l r27, java.lang.Object r28, e.b.a.a.a.c r29) {
        /*
            r26 = this;
            r10 = r26
            r0 = r28
            java.lang.String r1 = "e.b.a.a.a.h"
            e.b.a.a.a.u.a r2 = r10.f5208c
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x02d9
            e.b.a.a.a.u.a r2 = r10.f5208c
            boolean r2 = r2.h()
            if (r2 != 0) goto L_0x02d1
            e.b.a.a.a.u.a r2 = r10.f5208c
            boolean r2 = r2.j()
            if (r2 != 0) goto L_0x02c9
            e.b.a.a.a.u.a r2 = r10.f5208c
            boolean r2 = r2.f()
            if (r2 != 0) goto L_0x02c1
            if (r27 != 0) goto L_0x002f
            e.b.a.a.a.l r2 = new e.b.a.a.a.l
            r2.<init>()
            r5 = r2
            goto L_0x0031
        L_0x002f:
            r5 = r27
        L_0x0031:
            r10.f = r5
            r10.g = r0
            boolean r2 = r5.n
            e.b.a.a.a.v.b r3 = k
            r4 = 8
            java.lang.Object[] r4 = new java.lang.Object[r4]
            boolean r6 = r5.j
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r11 = 0
            r4[r11] = r6
            java.lang.Integer r6 = new java.lang.Integer
            int r7 = r5.k
            r6.<init>(r7)
            r7 = 1
            r4[r7] = r6
            r6 = 2
            java.lang.Integer r8 = new java.lang.Integer
            int r9 = r5.f5216a
            r8.<init>(r9)
            r4[r6] = r8
            java.lang.String r6 = r5.f5220e
            r8 = 3
            r4[r8] = r6
            char[] r6 = r5.f
            java.lang.String r9 = "[null]"
            java.lang.String r12 = "[notnull]"
            if (r6 != 0) goto L_0x0069
            r6 = r9
            goto L_0x006a
        L_0x0069:
            r6 = r12
        L_0x006a:
            r13 = 4
            r4[r13] = r6
            r6 = 5
            e.b.a.a.a.o r14 = r5.f5219d
            if (r14 != 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r9 = r12
        L_0x0074:
            r4[r6] = r9
            r6 = 6
            r4[r6] = r0
            r6 = 7
            r4[r6] = r29
            java.lang.String r6 = "connect"
            java.lang.String r9 = "103"
            r3.e(r1, r6, r9, r4)
            e.b.a.a.a.u.a r3 = r10.f5208c
            java.lang.String r4 = r10.f5207b
            e.b.a.a.a.v.b r6 = k
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r9[r11] = r4
            java.lang.String r12 = "createNetworkModules"
            java.lang.String r14 = "116"
            r6.e(r1, r12, r14, r9)
            java.lang.String[] r6 = r5.l
            if (r6 != 0) goto L_0x009d
            java.lang.String[] r6 = new java.lang.String[r7]
            r6[r11] = r4
            goto L_0x00a4
        L_0x009d:
            int r9 = r6.length
            if (r9 != 0) goto L_0x00a4
            java.lang.String[] r6 = new java.lang.String[r7]
            r6[r11] = r4
        L_0x00a4:
            int r4 = r6.length
            e.b.a.a.a.u.m[] r4 = new e.b.a.a.a.u.m[r4]
            r9 = 0
        L_0x00a8:
            int r14 = r6.length
            if (r9 < r14) goto L_0x00f1
            e.b.a.a.a.v.b r6 = k
            java.lang.String r7 = "108"
            r6.h(r1, r12, r7)
            r3.f5226c = r4
            e.b.a.a.a.u.a r1 = r10.f5208c
            e.b.a.a.a.h$b r3 = new e.b.a.a.a.h$b
            r3.<init>(r2)
            e.b.a.a.a.u.c r1 = r1.f
            r1.f5247b = r3
            e.b.a.a.a.t r12 = new e.b.a.a.a.t
            java.lang.String r1 = r10.f5206a
            r12.<init>(r1)
            e.b.a.a.a.u.g r13 = new e.b.a.a.a.u.g
            e.b.a.a.a.k r3 = r10.f5209d
            e.b.a.a.a.u.a r4 = r10.f5208c
            boolean r9 = r10.i
            r1 = r13
            r2 = r26
            r6 = r12
            r7 = r28
            r8 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            e.b.a.a.a.u.q r0 = r12.f5223a
            r0.k = r13
            r0.l = r10
            e.b.a.a.a.i r0 = r10.f5210e
            boolean r1 = r0 instanceof e.b.a.a.a.j
            if (r1 == 0) goto L_0x00e9
            e.b.a.a.a.j r0 = (e.b.a.a.a.j) r0
            r13.i = r0
        L_0x00e9:
            e.b.a.a.a.u.a r0 = r10.f5208c
            r0.f5225b = r11
            r13.a()
            return r12
        L_0x00f1:
            r15 = r6[r9]
            e.b.a.a.a.v.b r14 = k
            java.lang.Object[] r13 = new java.lang.Object[r7]
            r13[r11] = r15
            java.lang.String r11 = "createNetworkModule"
            java.lang.String r8 = "115"
            r14.e(r1, r11, r8, r13)
            javax.net.SocketFactory r8 = r5.g
            int r13 = e.b.a.a.a.l.c(r15)
            java.net.URI r14 = new java.net.URI     // Catch:{ URISyntaxException -> 0x029c }
            r14.<init>(r15)     // Catch:{ URISyntaxException -> 0x029c }
            java.lang.String r16 = r14.getHost()     // Catch:{ URISyntaxException -> 0x029c }
            if (r16 != 0) goto L_0x014d
            java.lang.String r7 = "_"
            boolean r7 = r15.contains(r7)     // Catch:{ URISyntaxException -> 0x029c }
            if (r7 == 0) goto L_0x014d
            java.lang.Class<java.net.URI> r7 = java.net.URI.class
            java.lang.String r0 = "host"
            java.lang.reflect.Field r0 = r7.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0143, SecurityException -> 0x0141, IllegalArgumentException -> 0x013f, IllegalAccessException -> 0x013d }
            r7 = 1
            r0.setAccessible(r7)     // Catch:{ NoSuchFieldException -> 0x0143, SecurityException -> 0x0141, IllegalArgumentException -> 0x013f, IllegalAccessException -> 0x013d }
            java.lang.String r7 = r14.getScheme()     // Catch:{ NoSuchFieldException -> 0x0143, SecurityException -> 0x0141, IllegalArgumentException -> 0x013f, IllegalAccessException -> 0x013d }
            int r7 = r7.length()     // Catch:{ NoSuchFieldException -> 0x0143, SecurityException -> 0x0141, IllegalArgumentException -> 0x013f, IllegalAccessException -> 0x013d }
            r16 = 3
            int r7 = r7 + 3
            java.lang.String r7 = r15.substring(r7)     // Catch:{ NoSuchFieldException -> 0x0143, SecurityException -> 0x0141, IllegalArgumentException -> 0x013f, IllegalAccessException -> 0x013d }
            java.lang.String r7 = r10.e(r7)     // Catch:{ NoSuchFieldException -> 0x0143, SecurityException -> 0x0141, IllegalArgumentException -> 0x013f, IllegalAccessException -> 0x013d }
            r0.set(r14, r7)     // Catch:{ NoSuchFieldException -> 0x0143, SecurityException -> 0x0141, IllegalArgumentException -> 0x013f, IllegalAccessException -> 0x013d }
            goto L_0x014d
        L_0x013d:
            r0 = move-exception
            goto L_0x0144
        L_0x013f:
            r0 = move-exception
            goto L_0x0144
        L_0x0141:
            r0 = move-exception
            goto L_0x0144
        L_0x0143:
            r0 = move-exception
        L_0x0144:
            java.lang.Throwable r0 = r0.getCause()     // Catch:{ URISyntaxException -> 0x029c }
            e.b.a.a.a.n r0 = a.e.a.a.r.b.h(r0)     // Catch:{ URISyntaxException -> 0x029c }
            throw r0     // Catch:{ URISyntaxException -> 0x029c }
        L_0x014d:
            java.lang.String r0 = r14.getHost()
            int r7 = r14.getPort()
            if (r13 == 0) goto L_0x025f
            r14 = 1
            if (r13 == r14) goto L_0x0210
            r14 = 3
            if (r13 == r14) goto L_0x01d6
            r21 = r2
            r2 = 4
            if (r13 == r2) goto L_0x0179
            e.b.a.a.a.v.b r0 = k
            r13 = 1
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r20 = 0
            r7[r20] = r15
            java.lang.String r8 = "119"
            r0.e(r1, r11, r8, r7)
            r23 = r1
            r14 = 0
            r22 = 3
            r24 = 1
            goto L_0x0285
        L_0x0179:
            r11 = -1
            r13 = 1
            r20 = 0
            if (r7 != r11) goto L_0x0181
            r7 = 443(0x1bb, float:6.21E-43)
        L_0x0181:
            if (r8 != 0) goto L_0x019a
            e.b.a.a.a.u.r.a r8 = new e.b.a.a.a.u.r.a
            r8.<init>()
            java.util.Properties r11 = r5.h
            r2 = 0
            if (r11 == 0) goto L_0x0190
            r8.q(r11, r2)
        L_0x0190:
            javax.net.ssl.SSLSocketFactory r11 = r8.a(r2)
            r25 = r11
            r11 = r8
            r8 = r25
            goto L_0x01a0
        L_0x019a:
            r2 = 0
            boolean r11 = r8 instanceof javax.net.ssl.SSLSocketFactory
            if (r11 == 0) goto L_0x01cf
            r11 = r2
        L_0x01a0:
            e.b.a.a.a.u.s.h r2 = new e.b.a.a.a.u.s.h
            javax.net.ssl.SSLSocketFactory r8 = (javax.net.ssl.SSLSocketFactory) r8
            java.lang.String r13 = r10.f5206a
            r23 = r1
            r1 = 0
            r22 = 3
            r24 = 1
            r14 = r2
            r17 = r15
            r15 = r8
            r16 = r17
            r17 = r0
            r18 = r7
            r19 = r13
            r14.<init>(r15, r16, r17, r18, r19)
            int r0 = r5.k
            r2.f5289e = r0
            r2.h = r0
            if (r11 == 0) goto L_0x0256
            java.lang.String[] r0 = r11.c(r1)
            if (r0 == 0) goto L_0x0256
            r2.d(r0)
            goto L_0x0256
        L_0x01cf:
            r0 = 32105(0x7d69, float:4.4989E-41)
            e.b.a.a.a.n r0 = a.e.a.a.r.b.g(r0)
            throw r0
        L_0x01d6:
            r23 = r1
            r21 = r2
            r17 = r15
            r1 = -1
            r20 = 0
            r22 = 3
            r24 = 1
            if (r7 != r1) goto L_0x01ea
            r1 = 80
            r18 = 80
            goto L_0x01ec
        L_0x01ea:
            r18 = r7
        L_0x01ec:
            if (r8 != 0) goto L_0x01f4
            javax.net.SocketFactory r1 = javax.net.SocketFactory.getDefault()
            r15 = r1
            goto L_0x01f9
        L_0x01f4:
            boolean r1 = r8 instanceof javax.net.ssl.SSLSocketFactory
            if (r1 != 0) goto L_0x0209
            r15 = r8
        L_0x01f9:
            e.b.a.a.a.u.s.f r1 = new e.b.a.a.a.u.s.f
            java.lang.String r2 = r10.f5206a
            r14 = r1
            r16 = r17
            r17 = r0
            r19 = r2
            r14.<init>(r15, r16, r17, r18, r19)
            goto L_0x0281
        L_0x0209:
            r0 = 32105(0x7d69, float:4.4989E-41)
            e.b.a.a.a.n r0 = a.e.a.a.r.b.g(r0)
            throw r0
        L_0x0210:
            r23 = r1
            r21 = r2
            r1 = 0
            r2 = -1
            r20 = 0
            r22 = 3
            r24 = 1
            if (r7 != r2) goto L_0x0220
            r7 = 8883(0x22b3, float:1.2448E-41)
        L_0x0220:
            if (r8 != 0) goto L_0x0233
            e.b.a.a.a.u.r.a r14 = new e.b.a.a.a.u.r.a
            r14.<init>()
            java.util.Properties r2 = r5.h
            if (r2 == 0) goto L_0x022e
            r14.q(r2, r1)
        L_0x022e:
            javax.net.ssl.SSLSocketFactory r8 = r14.a(r1)
            goto L_0x0238
        L_0x0233:
            boolean r2 = r8 instanceof javax.net.ssl.SSLSocketFactory
            if (r2 == 0) goto L_0x0258
            r14 = r1
        L_0x0238:
            e.b.a.a.a.u.o r2 = new e.b.a.a.a.u.o
            javax.net.ssl.SSLSocketFactory r8 = (javax.net.ssl.SSLSocketFactory) r8
            java.lang.String r11 = r10.f5206a
            r2.<init>(r8, r0, r7, r11)
            int r0 = r5.k
            r2.f5289e = r0
            r2.h = r0
            javax.net.ssl.HostnameVerifier r0 = r5.i
            r2.i = r0
            if (r14 == 0) goto L_0x0256
            java.lang.String[] r0 = r14.c(r1)
            if (r0 == 0) goto L_0x0256
            r2.d(r0)
        L_0x0256:
            r14 = r2
            goto L_0x0285
        L_0x0258:
            r0 = 32105(0x7d69, float:4.4989E-41)
            e.b.a.a.a.n r0 = a.e.a.a.r.b.g(r0)
            throw r0
        L_0x025f:
            r23 = r1
            r21 = r2
            r1 = -1
            r20 = 0
            r22 = 3
            r24 = 1
            if (r7 != r1) goto L_0x026e
            r7 = 1883(0x75b, float:2.639E-42)
        L_0x026e:
            if (r8 != 0) goto L_0x0275
            javax.net.SocketFactory r8 = javax.net.SocketFactory.getDefault()
            goto L_0x0279
        L_0x0275:
            boolean r1 = r8 instanceof javax.net.ssl.SSLSocketFactory
            if (r1 != 0) goto L_0x0295
        L_0x0279:
            e.b.a.a.a.u.p r1 = new e.b.a.a.a.u.p
            java.lang.String r2 = r10.f5206a
            r1.<init>(r8, r0, r7, r2)
            r14 = r1
        L_0x0281:
            int r0 = r5.k
            r14.f5289e = r0
        L_0x0285:
            r4[r9] = r14
            int r9 = r9 + 1
            r0 = r28
            r2 = r21
            r1 = r23
            r7 = 1
            r8 = 3
            r11 = 0
            r13 = 4
            goto L_0x00a8
        L_0x0295:
            r0 = 32105(0x7d69, float:4.4989E-41)
            e.b.a.a.a.n r0 = a.e.a.a.r.b.g(r0)
            throw r0
        L_0x029c:
            r0 = move-exception
            r17 = r15
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Malformed URI: "
            r2.<init>(r3)
            r3 = r17
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x02c1:
            e.b.a.a.a.n r0 = new e.b.a.a.a.n
            r1 = 32111(0x7d6f, float:4.4997E-41)
            r0.<init>((int) r1)
            throw r0
        L_0x02c9:
            e.b.a.a.a.n r0 = new e.b.a.a.a.n
            r1 = 32102(0x7d66, float:4.4984E-41)
            r0.<init>((int) r1)
            throw r0
        L_0x02d1:
            e.b.a.a.a.n r0 = new e.b.a.a.a.n
            r1 = 32110(0x7d6e, float:4.4996E-41)
            r0.<init>((int) r1)
            throw r0
        L_0x02d9:
            r0 = 32100(0x7d64, float:4.4982E-41)
            e.b.a.a.a.n r0 = a.e.a.a.r.b.g(r0)
            goto L_0x02e1
        L_0x02e0:
            throw r0
        L_0x02e1:
            goto L_0x02e0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.h.c(e.b.a.a.a.l, java.lang.Object, e.b.a.a.a.c):e.b.a.a.a.g");
    }

    public g d(long j2, Object obj, c cVar) {
        k.e("e.b.a.a.a.h", MqttServiceConstants.DISCONNECT_ACTION, "104", new Object[]{new Long(j2), obj, cVar});
        t tVar = new t(this.f5206a);
        q qVar = tVar.f5223a;
        qVar.k = cVar;
        qVar.l = obj;
        try {
            this.f5208c.c(new e(), j2, tVar);
            k.h("e.b.a.a.a.h", MqttServiceConstants.DISCONNECT_ACTION, OO000o0.O0000OoO);
            return tVar;
        } catch (n e2) {
            k.c("e.b.a.a.a.h", MqttServiceConstants.DISCONNECT_ACTION, "105", (Object[]) null, e2);
            throw e2;
        }
    }

    public final String e(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            indexOf = str.indexOf(47);
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    public boolean f() {
        return this.f5208c.g();
    }

    public e g(String str, o oVar, Object obj, c cVar) {
        k.e("e.b.a.a.a.h", "publish", OO000o0.O0000o0, new Object[]{str, obj, cVar});
        a.e.a.a.r.b.e0(str, false);
        m mVar = new m(this.f5206a);
        q qVar = mVar.f5223a;
        qVar.k = cVar;
        qVar.l = obj;
        qVar.h = new String[]{str};
        this.f5208c.k(new o(str, oVar), mVar);
        k.h("e.b.a.a.a.h", "publish", OO000o0.O0000o0O);
        return mVar;
    }

    public String getClientId() {
        return this.f5206a;
    }

    public void h() {
        k.e("e.b.a.a.a.h", "reconnect", "500", new Object[]{this.f5206a});
        if (this.f5208c.g()) {
            throw a.e.a.a.r.b.g(32100);
        } else if (this.f5208c.h()) {
            throw new n(32110);
        } else if (this.f5208c.j()) {
            throw new n(32102);
        } else if (!this.f5208c.f()) {
            i();
            b();
        } else {
            throw new n(32111);
        }
    }

    public final void i() {
        k.e("e.b.a.a.a.h", "stopReconnectCycle", "504", new Object[]{this.f5206a});
        synchronized (m) {
            if (this.f.n) {
                if (this.h != null) {
                    this.h.cancel();
                    this.h = null;
                }
                l = 1000;
            }
        }
    }

    public g j(String[] strArr, int[] iArr, Object obj, c cVar) {
        if (strArr.length == iArr.length) {
            for (String remove : strArr) {
                this.f5208c.f.f5248c.remove(remove);
            }
            if (k.f(5)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (i2 > 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append("topic=");
                    stringBuffer.append(strArr[i2]);
                    stringBuffer.append(" qos=");
                    stringBuffer.append(iArr[i2]);
                    a.e.a.a.r.b.e0(strArr[i2], true);
                }
                k.e("e.b.a.a.a.h", MqttServiceConstants.SUBSCRIBE_ACTION, "106", new Object[]{stringBuffer.toString(), obj, cVar});
            }
            t tVar = new t(this.f5206a);
            q qVar = tVar.f5223a;
            qVar.k = cVar;
            qVar.l = obj;
            qVar.h = strArr;
            this.f5208c.k(new r(strArr, iArr), tVar);
            k.h("e.b.a.a.a.h", MqttServiceConstants.SUBSCRIBE_ACTION, OO000o0.O0000Ooo);
            return tVar;
        }
        throw new IllegalArgumentException();
    }

    public g k(String[] strArr, int[] iArr, f[] fVarArr) {
        if (fVarArr.length == iArr.length && iArr.length == strArr.length) {
            g j2 = j(strArr, iArr, (Object) null, (c) null);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                e.b.a.a.a.u.a aVar = this.f5208c;
                aVar.f.f5248c.put(strArr[i2], fVarArr[i2]);
            }
            return j2;
        }
        throw new IllegalArgumentException();
    }

    public g l(String[] strArr, Object obj, c cVar) {
        if (k.f(5)) {
            String str = "";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 > 0) {
                    str = String.valueOf(str) + ", ";
                }
                str = String.valueOf(str) + strArr[i2];
            }
            k.e("e.b.a.a.a.h", MqttServiceConstants.UNSUBSCRIBE_ACTION, "107", new Object[]{str, obj, cVar});
        }
        for (String e0 : strArr) {
            a.e.a.a.r.b.e0(e0, true);
        }
        for (String remove : strArr) {
            this.f5208c.f.f5248c.remove(remove);
        }
        t tVar = new t(this.f5206a);
        q qVar = tVar.f5223a;
        qVar.k = cVar;
        qVar.l = obj;
        qVar.h = strArr;
        this.f5208c.k(new t(strArr), tVar);
        k.h("e.b.a.a.a.h", MqttServiceConstants.UNSUBSCRIBE_ACTION, OO000o0.O0000o00);
        return tVar;
    }
}
