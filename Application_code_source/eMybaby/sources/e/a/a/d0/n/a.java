package e.a.a.d0.n;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public abstract class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f4889a;

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f4889a = strArr;
        Arrays.sort(strArr);
    }

    public static int b(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    public static boolean c(String str) {
        if (str != null) {
            if (e.a.a.d0.o.a.f4894a.matcher(str).matches()) {
                return true;
            }
            if (e.a.a.d0.o.a.f4895b.matcher(str).matches() || e.a.a.d0.o.a.f4896c.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public final void d(String str, X509Certificate x509Certificate) {
        String[] strArr;
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        StringTokenizer stringTokenizer = new StringTokenizer(x509Certificate.getSubjectX500Principal().toString(), ",");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("CN=");
            if (indexOf >= 0) {
                linkedList.add(nextToken.substring(indexOf + 3));
            }
        }
        String[] strArr2 = null;
        if (!linkedList.isEmpty()) {
            strArr = new String[linkedList.size()];
            linkedList.toArray(strArr);
        } else {
            strArr = null;
        }
        int i = c(str) ? 7 : 2;
        LinkedList linkedList2 = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e2) {
            Logger.getLogger(a.class.getName()).log(Level.FINE, "Error parsing certificate.", e2);
            collection = null;
        }
        if (collection != null) {
            for (List next : collection) {
                if (((Integer) next.get(0)).intValue() == i) {
                    linkedList2.add((String) next.get(1));
                }
            }
        }
        if (!linkedList2.isEmpty()) {
            strArr2 = new String[linkedList2.size()];
            linkedList2.toArray(strArr2);
        }
        a(str, strArr, strArr2);
    }

    public final void e(String str, SSLSocket sSLSocket) {
        if (str != null) {
            SSLSession session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.getInputStream().available();
                session = sSLSocket.getSession();
                if (session == null) {
                    sSLSocket.startHandshake();
                    session = sSLSocket.getSession();
                }
            }
            d(str, (X509Certificate) session.getPeerCertificates()[0]);
            return;
        }
        throw new NullPointerException("host to verify is null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fd A[EDGE_INSN: B:68:0x00fd->B:58:0x00fd ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.lang.String r11, java.lang.String[] r12, java.lang.String[] r13, boolean r14) {
        /*
            r10 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r1 = 0
            if (r12 == 0) goto L_0x0014
            int r2 = r12.length
            if (r2 <= 0) goto L_0x0014
            r2 = r12[r1]
            if (r2 == 0) goto L_0x0014
            r12 = r12[r1]
            r0.add(r12)
        L_0x0014:
            if (r13 == 0) goto L_0x0024
            int r12 = r13.length
            r2 = 0
        L_0x0018:
            if (r2 >= r12) goto L_0x0024
            r3 = r13[r2]
            if (r3 == 0) goto L_0x0021
            r0.add(r3)
        L_0x0021:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x0024:
            boolean r12 = r0.isEmpty()
            if (r12 != 0) goto L_0x011f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = r11.trim()
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r13 = r13.toLowerCase(r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x003e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00fd
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r2 = r2.toLowerCase(r3)
            java.lang.String r3 = " <"
            r12.append(r3)
            r12.append(r2)
            r3 = 62
            r12.append(r3)
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0068
            java.lang.String r3 = " OR"
            r12.append(r3)
        L_0x0068:
            java.lang.String r3 = "\\."
            java.lang.String[] r4 = r2.split(r3)
            int r5 = r4.length
            r6 = 2
            r7 = 3
            r8 = 1
            if (r5 < r7) goto L_0x00a6
            r5 = r4[r1]
            java.lang.String r9 = "*"
            boolean r5 = r5.endsWith(r9)
            if (r5 == 0) goto L_0x00a6
            java.lang.String[] r3 = r2.split(r3)
            int r5 = r3.length
            if (r5 != r7) goto L_0x009b
            r5 = r3[r6]
            int r5 = r5.length()
            if (r5 == r6) goto L_0x008e
            goto L_0x009b
        L_0x008e:
            java.lang.String[] r5 = f4889a
            r3 = r3[r8]
            int r3 = java.util.Arrays.binarySearch(r5, r3)
            if (r3 >= 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r3 = 0
            goto L_0x009c
        L_0x009b:
            r3 = 1
        L_0x009c:
            if (r3 == 0) goto L_0x00a6
            boolean r3 = c(r11)
            if (r3 != 0) goto L_0x00a6
            r3 = 1
            goto L_0x00a7
        L_0x00a6:
            r3 = 0
        L_0x00a7:
            if (r3 == 0) goto L_0x00f7
            r3 = r4[r1]
            int r3 = r3.length()
            if (r3 <= r8) goto L_0x00db
            r3 = r4[r1]
            int r5 = r4.length
            int r5 = r5 - r6
            java.lang.String r3 = r3.substring(r1, r5)
            r4 = r4[r1]
            int r4 = r4.length()
            java.lang.String r4 = r2.substring(r4)
            int r5 = r3.length()
            java.lang.String r5 = r13.substring(r5)
            boolean r3 = r13.startsWith(r3)
            if (r3 == 0) goto L_0x00d9
            boolean r3 = r5.endsWith(r4)
            if (r3 == 0) goto L_0x00d9
            r3 = 1
            goto L_0x00e3
        L_0x00d9:
            r3 = 0
            goto L_0x00e3
        L_0x00db:
            java.lang.String r3 = r2.substring(r8)
            boolean r3 = r13.endsWith(r3)
        L_0x00e3:
            if (r3 == 0) goto L_0x00f5
            if (r14 == 0) goto L_0x00f5
            int r3 = b(r13)
            int r2 = b(r2)
            if (r3 != r2) goto L_0x00f2
            goto L_0x00f3
        L_0x00f2:
            r8 = 0
        L_0x00f3:
            r2 = r8
            goto L_0x00fb
        L_0x00f5:
            r2 = r3
            goto L_0x00fb
        L_0x00f7:
            boolean r2 = r13.equals(r2)
        L_0x00fb:
            if (r2 == 0) goto L_0x003e
        L_0x00fd:
            if (r2 == 0) goto L_0x0100
            return
        L_0x0100:
            javax.net.ssl.SSLException r13 = new javax.net.ssl.SSLException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "hostname in certificate didn't match: <"
            r14.append(r0)
            r14.append(r11)
            java.lang.String r11 = "> !="
            r14.append(r11)
            r14.append(r12)
            java.lang.String r11 = r14.toString()
            r13.<init>(r11)
            throw r13
        L_0x011f:
            java.lang.String r12 = "Certificate for <"
            java.lang.String r13 = "> doesn't contain CN or DNS subjectAlt"
            java.lang.String r11 = a.a.a.a.a.l(r12, r11, r13)
            javax.net.ssl.SSLException r12 = new javax.net.ssl.SSLException
            r12.<init>(r11)
            goto L_0x012e
        L_0x012d:
            throw r12
        L_0x012e:
            goto L_0x012d
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d0.n.a.f(java.lang.String, java.lang.String[], java.lang.String[], boolean):void");
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            d(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException unused) {
            return false;
        }
    }
}
