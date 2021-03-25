package e.a.a.g0.h;

import e.a.a.g0.c;
import e.a.a.g0.k.a;
import e.a.a.i0.s;
import e.a.a.l0.b;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class h extends a {
    public final Log h = LogFactory.getLog(h.class);
    public final c i;
    public final b j;
    public final int k;

    public h(e.a.a.h0.c cVar, s sVar, c cVar2, e.a.a.j0.c cVar3) {
        super(cVar, (s) null, cVar3);
        if (cVar2 != null) {
            this.i = cVar2;
            this.j = new b(128);
            this.k = cVar3.b("http.connection.max-status-line-garbage", Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Response factory may not be null");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:66|67|68) */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r3 = new java.lang.StringBuffer();
        r3.append("Status line contains invalid status code: ");
        r3.append(r0.h(r1, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0117, code lost:
        throw new e.a.a.u(r3.toString());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x00ff */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0089 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.a.a.l a(e.a.a.h0.c r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            e.a.a.l0.b r2 = r14.j
            r2.f5184b = r0
            int r2 = r15.b(r2)
            r3 = -1
            if (r2 != r3) goto L_0x0018
            if (r1 == 0) goto L_0x0010
            goto L_0x0018
        L_0x0010:
            e.a.a.t r15 = new e.a.a.t
            java.lang.String r0 = "The target server failed to respond"
            r15.<init>(r0)
            throw r15
        L_0x0018:
            e.a.a.i0.t r4 = new e.a.a.i0.t
            e.a.a.l0.b r5 = r14.j
            int r5 = r5.f5184b
            r4.<init>(r0, r5)
            e.a.a.i0.s r5 = r14.f5088e
            e.a.a.l0.b r6 = r14.j
            e.a.a.i0.i r5 = (e.a.a.i0.i) r5
            r7 = 0
            if (r5 == 0) goto L_0x0173
            java.lang.String r8 = "Char array buffer may not be null"
            if (r6 == 0) goto L_0x016d
            int r9 = r4.f5169c
            e.a.a.w r5 = r5.f5146a
            java.lang.String r5 = r5.f5194a
            int r10 = r5.length()
            int r11 = r6.f5184b
            int r12 = r10 + 4
            if (r11 >= r12) goto L_0x003f
            goto L_0x0061
        L_0x003f:
            if (r9 >= 0) goto L_0x0046
            int r11 = r11 + -4
            int r9 = r11 - r10
            goto L_0x0059
        L_0x0046:
            if (r9 != 0) goto L_0x0059
        L_0x0048:
            int r11 = r6.f5184b
            if (r9 >= r11) goto L_0x0059
            char[] r11 = r6.f5183a
            char r11 = r11[r9]
            boolean r11 = a.e.a.a.r.b.N(r11)
            if (r11 == 0) goto L_0x0059
            int r9 = r9 + 1
            goto L_0x0048
        L_0x0059:
            int r11 = r9 + r10
            int r12 = r11 + 4
            int r13 = r6.f5184b
            if (r12 <= r13) goto L_0x0063
        L_0x0061:
            r0 = 0
            goto L_0x0087
        L_0x0063:
            r12 = 1
            r12 = r0
            r0 = 1
        L_0x0066:
            if (r0 == 0) goto L_0x007c
            if (r12 >= r10) goto L_0x007c
            int r0 = r9 + r12
            char[] r13 = r6.f5183a
            char r0 = r13[r0]
            char r13 = r5.charAt(r12)
            if (r0 != r13) goto L_0x0078
            r0 = 1
            goto L_0x0079
        L_0x0078:
            r0 = 0
        L_0x0079:
            int r12 = r12 + 1
            goto L_0x0066
        L_0x007c:
            if (r0 == 0) goto L_0x0087
            char[] r0 = r6.f5183a
            char r0 = r0[r11]
            r5 = 47
            if (r0 != r5) goto L_0x0061
            r0 = 1
        L_0x0087:
            if (r0 == 0) goto L_0x013a
            e.a.a.i0.s r15 = r14.f5088e
            e.a.a.l0.b r0 = r14.j
            e.a.a.i0.i r15 = (e.a.a.i0.i) r15
            if (r15 == 0) goto L_0x0139
            if (r0 == 0) goto L_0x0133
            int r1 = r4.f5169c
            int r2 = r4.f5168b
            e.a.a.w r3 = r15.a(r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r15.b(r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            int r15 = r4.f5169c     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r4 = 32
            int r4 = r0.g(r4, r15, r2)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            if (r4 >= 0) goto L_0x00a9
            r4 = r2
        L_0x00a9:
            java.lang.String r15 = r0.i(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r5 = 0
        L_0x00ae:
            int r6 = r15.length()     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            java.lang.String r8 = "Status line contains invalid status code: "
            if (r5 >= r6) goto L_0x00dc
            char r6 = r15.charAt(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            boolean r6 = java.lang.Character.isDigit(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            if (r6 == 0) goto L_0x00c3
            int r5 = r5 + 1
            goto L_0x00ae
        L_0x00c3:
            e.a.a.u r15 = new e.a.a.u     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r3.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            java.lang.String r4 = r0.h(r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r15.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            throw r15     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
        L_0x00dc:
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x00ff }
            if (r4 >= r2) goto L_0x00e7
            java.lang.String r4 = r0.i(r4, r2)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            goto L_0x00e9
        L_0x00e7:
            java.lang.String r4 = ""
        L_0x00e9:
            e.a.a.i0.m r5 = new e.a.a.i0.m     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r5.<init>(r3, r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            e.a.a.g0.c r15 = r14.i
            if (r15 == 0) goto L_0x00fe
            java.util.Locale r0 = java.util.Locale.getDefault()
            e.a.a.i0.g r1 = new e.a.a.i0.g
            e.a.a.x r15 = r15.f4942a
            r1.<init>(r5, r15, r0)
            return r1
        L_0x00fe:
            throw r7
        L_0x00ff:
            e.a.a.u r15 = new e.a.a.u     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r3.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            java.lang.String r4 = r0.h(r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            r15.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
            throw r15     // Catch:{ IndexOutOfBoundsException -> 0x0118 }
        L_0x0118:
            e.a.a.u r15 = new e.a.a.u
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = "Invalid status line: "
            r3.append(r4)
            java.lang.String r0 = r0.h(r1, r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r15.<init>(r0)
            throw r15
        L_0x0133:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r8)
            throw r15
        L_0x0139:
            throw r7
        L_0x013a:
            if (r2 == r3) goto L_0x0165
            int r0 = r14.k
            if (r1 >= r0) goto L_0x0165
            org.apache.commons.logging.Log r0 = r14.h
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0160
            org.apache.commons.logging.Log r0 = r14.h
            java.lang.String r2 = "Garbage in response: "
            java.lang.StringBuilder r2 = a.a.a.a.a.n(r2)
            e.a.a.l0.b r3 = r14.j
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.debug(r2)
        L_0x0160:
            int r1 = r1 + 1
            r0 = 0
            goto L_0x0002
        L_0x0165:
            e.a.a.v r15 = new e.a.a.v
            java.lang.String r0 = "The server failed to respond with a valid HTTP response"
            r15.<init>(r0)
            throw r15
        L_0x016d:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r8)
            throw r15
        L_0x0173:
            goto L_0x0175
        L_0x0174:
            throw r7
        L_0x0175:
            goto L_0x0174
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.h.a(e.a.a.h0.c):e.a.a.l");
    }
}
