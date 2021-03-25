package e.a.a.g0.f;

import e.a.a.b0.h;
import e.a.a.c;
import e.a.a.l0.b;
import e.a.a.m;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.Oid;

public class j extends a {

    /* renamed from: b  reason: collision with root package name */
    public final Log f4962b = LogFactory.getLog(j.class);

    /* renamed from: c  reason: collision with root package name */
    public final m f4963c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4964d;

    /* renamed from: e  reason: collision with root package name */
    public GSSContext f4965e = null;
    public a f = a.UNINITIATED;
    public byte[] g;
    public Oid h = null;

    public enum a {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        TOKEN_GENERATED,
        FAILED
    }

    public j(m mVar, boolean z) {
        this.f4963c = mVar;
        this.f4964d = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0167, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0168, code lost:
        r6.f = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0173, code lost:
        throw new e.a.a.b0.f(r7.getMessage());
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0167 A[ExcHandler: IOException (r7v6 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:4:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.a.a.c a(e.a.a.b0.h r7, e.a.a.m r8, e.a.a.k0.c r9) {
        /*
            r6 = this;
            java.lang.String r7 = "HTTP@"
            e.a.a.g0.f.j$a r0 = e.a.a.g0.f.j.a.FAILED
            if (r8 == 0) goto L_0x01d8
            e.a.a.g0.f.j$a r8 = r6.f
            e.a.a.g0.f.j$a r1 = e.a.a.g0.f.j.a.CHALLENGE_RECEIVED
            if (r8 != r1) goto L_0x01d0
            boolean r8 = r6.f4947a     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r8 == 0) goto L_0x0013
            java.lang.String r8 = "http.proxy_host"
            goto L_0x0015
        L_0x0013:
            java.lang.String r8 = "http.target_host"
        L_0x0015:
            java.lang.Object r8 = r9.b(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            e.a.a.j r8 = (e.a.a.j) r8     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r8 == 0) goto L_0x015f
            boolean r9 = r6.f4964d     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r9 != 0) goto L_0x002a
            int r9 = r8.f5172c     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r9 <= 0) goto L_0x002a
            java.lang.String r8 = r8.b()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            goto L_0x002c
        L_0x002a:
            java.lang.String r8 = r8.f5170a     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x002c:
            org.apache.commons.logging.Log r9 = r6.f4962b     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            boolean r9 = r9.isDebugEnabled()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r9 == 0) goto L_0x004a
            org.apache.commons.logging.Log r9 = r6.f4962b     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r1.<init>()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r2 = "init "
            r1.append(r2)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r1.append(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r1 = r1.toString()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r9.debug(r1)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x004a:
            org.ietf.jgss.Oid r9 = new org.ietf.jgss.Oid     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r1 = "1.3.6.1.5.5.2"
            r9.<init>(r1)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r6.h = r9     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r9 = 0
            r1 = 0
            r2 = 1
            org.ietf.jgss.GSSManager r3 = r6.i()     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            r4.<init>()     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            r4.append(r7)     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            r4.append(r8)     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            java.lang.String r4 = r4.toString()     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            org.ietf.jgss.Oid r5 = org.ietf.jgss.GSSName.NT_HOSTBASED_SERVICE     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            org.ietf.jgss.GSSName r4 = r3.createName(r4, r5)     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            org.ietf.jgss.Oid r5 = r6.h     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            org.ietf.jgss.GSSName r4 = r4.canonicalize(r5)     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            org.ietf.jgss.Oid r5 = r6.h     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            org.ietf.jgss.GSSContext r3 = r3.createContext(r4, r5, r9, r1)     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            r6.f4965e = r3     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            r3.requestMutualAuth(r2)     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            org.ietf.jgss.GSSContext r3 = r6.f4965e     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            r3.requestCredDeleg(r2)     // Catch:{ GSSException -> 0x0087, IOException -> 0x0167 }
            r3 = 0
            goto L_0x0097
        L_0x0087:
            r3 = move-exception
            int r4 = r3.getMajor()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r5 = 2
            if (r4 != r5) goto L_0x015e
            org.apache.commons.logging.Log r3 = r6.f4962b     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r4 = "GSSException BAD_MECH, retry with Kerberos MECH"
            r3.debug(r4)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r3 = 1
        L_0x0097:
            java.lang.String r4 = "1.2.840.113554.1.2.2"
            if (r3 == 0) goto L_0x00d8
            org.apache.commons.logging.Log r3 = r6.f4962b     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r5 = "Using Kerberos MECH 1.2.840.113554.1.2.2"
            r3.debug(r5)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.Oid r3 = new org.ietf.jgss.Oid     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r3.<init>(r4)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r6.h = r3     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.GSSManager r3 = r6.i()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r5.<init>()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r5.append(r7)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r5.append(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r7 = r5.toString()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.Oid r8 = org.ietf.jgss.GSSName.NT_HOSTBASED_SERVICE     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.GSSName r7 = r3.createName(r7, r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.Oid r8 = r6.h     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.GSSName r7 = r7.canonicalize(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.Oid r8 = r6.h     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.GSSContext r7 = r3.createContext(r7, r8, r9, r1)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r6.f4965e = r7     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r7.requestMutualAuth(r2)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.ietf.jgss.GSSContext r7 = r6.f4965e     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r7.requestCredDeleg(r2)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x00d8:
            byte[] r7 = r6.g     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r7 != 0) goto L_0x00e0
            byte[] r7 = new byte[r1]     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r6.g = r7     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x00e0:
            org.ietf.jgss.GSSContext r7 = r6.f4965e     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            byte[] r8 = r6.g     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            byte[] r9 = r6.g     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            int r9 = r9.length     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            byte[] r7 = r7.initSecContext(r8, r1, r9)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r6.g = r7     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r7 == 0) goto L_0x0154
            e.a.a.g0.f.m r7 = r6.f4963c     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r7 == 0) goto L_0x0109
            org.ietf.jgss.Oid r7 = r6.h     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r7 = r7.toString()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            boolean r7 = r7.equals(r4)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r7 == 0) goto L_0x0109
            e.a.a.g0.f.m r7 = r6.f4963c     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            byte[] r8 = r6.g     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            byte[] r7 = r7.a(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r6.g = r7     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x0109:
            e.a.a.g0.f.j$a r7 = e.a.a.g0.f.j.a.TOKEN_GENERATED     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r6.f = r7     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r7 = new java.lang.String     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            byte[] r8 = r6.g     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            byte[] r8 = org.apache.commons.codec.binary.Base64.encodeBase64(r8, r1)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r7.<init>(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            org.apache.commons.logging.Log r8 = r6.f4962b     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            boolean r8 = r8.isDebugEnabled()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            if (r8 == 0) goto L_0x013b
            org.apache.commons.logging.Log r8 = r6.f4962b     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r9.<init>()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r1 = "Sending response '"
            r9.append(r1)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r9.append(r7)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r1 = "' back to the auth server"
            r9.append(r1)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r9 = r9.toString()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r8.debug(r9)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x013b:
            e.a.a.i0.b r8 = new e.a.a.i0.b     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r9 = "Authorization"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r1.<init>()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r2 = "Negotiate "
            r1.append(r2)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r1.append(r7)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r7 = r1.toString()     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            r8.<init>(r9, r7)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            return r8
        L_0x0154:
            r6.f = r0     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            e.a.a.b0.f r7 = new e.a.a.b0.f     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r8 = "GSS security context initialization failed"
            r7.<init>(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            throw r7     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x015e:
            throw r3     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x015f:
            e.a.a.b0.f r7 = new e.a.a.b0.f     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            java.lang.String r8 = "Authentication host is not set in the execution context"
            r7.<init>(r8)     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
            throw r7     // Catch:{ GSSException -> 0x0174, IOException -> 0x0167 }
        L_0x0167:
            r7 = move-exception
            r6.f = r0
            e.a.a.b0.f r8 = new e.a.a.b0.f
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r7)
            throw r8
        L_0x0174:
            r7 = move-exception
            r6.f = r0
            int r8 = r7.getMajor()
            r9 = 9
            if (r8 == r9) goto L_0x01c6
            int r8 = r7.getMajor()
            r9 = 8
            if (r8 == r9) goto L_0x01c6
            int r8 = r7.getMajor()
            r9 = 13
            if (r8 == r9) goto L_0x01bc
            int r8 = r7.getMajor()
            r9 = 10
            if (r8 == r9) goto L_0x01b2
            int r8 = r7.getMajor()
            r9 = 19
            if (r8 == r9) goto L_0x01b2
            int r8 = r7.getMajor()
            r9 = 20
            if (r8 != r9) goto L_0x01a8
            goto L_0x01b2
        L_0x01a8:
            e.a.a.b0.f r8 = new e.a.a.b0.f
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r7)
            throw r8
        L_0x01b2:
            e.a.a.b0.f r8 = new e.a.a.b0.f
            java.lang.String r9 = r7.getMessage()
            r8.<init>(r9, r7)
            throw r8
        L_0x01bc:
            e.a.a.b0.i r8 = new e.a.a.b0.i
            java.lang.String r9 = r7.getMessage()
            r8.<init>(r9, r7)
            throw r8
        L_0x01c6:
            e.a.a.b0.i r8 = new e.a.a.b0.i
            java.lang.String r9 = r7.getMessage()
            r8.<init>(r9, r7)
            throw r8
        L_0x01d0:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Negotiation authentication process has not been initiated"
            r7.<init>(r8)
            throw r7
        L_0x01d8:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "HTTP request may not be null"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.f.j.a(e.a.a.b0.h, e.a.a.m, e.a.a.k0.c):e.a.a.c");
    }

    @Deprecated
    public c c(h hVar, m mVar) {
        return a(hVar, mVar, (e.a.a.k0.c) null);
    }

    public String d() {
        return null;
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        a aVar = this.f;
        return aVar == a.TOKEN_GENERATED || aVar == a.FAILED;
    }

    public String g() {
        return "Negotiate";
    }

    public void h(b bVar, int i, int i2) {
        a aVar;
        String i3 = bVar.i(i, i2);
        if (this.f4962b.isDebugEnabled()) {
            Log log = this.f4962b;
            log.debug("Received challenge '" + i3 + "' from the auth server");
        }
        if (this.f == a.UNINITIATED) {
            this.g = new Base64().decode(i3.getBytes());
            aVar = a.CHALLENGE_RECEIVED;
        } else {
            this.f4962b.debug("Authentication already attempted");
            aVar = a.FAILED;
        }
        this.f = aVar;
    }

    public GSSManager i() {
        return GSSManager.getInstance();
    }
}
