package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.b.f;
import a.d.a.a.e.q.c;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tuya.smart.common.oOO0O0O0;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

public final class t0 extends f {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f1562e = "\n".getBytes();

    /* renamed from: c  reason: collision with root package name */
    public final String f1563c;

    /* renamed from: d  reason: collision with root package name */
    public final d1 f1564d;

    public t0(h hVar) {
        super(hVar);
        String str;
        String str2 = g.f1496a;
        String str3 = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        if (locale != null) {
            String language = locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                StringBuilder sb = new StringBuilder();
                sb.append(language.toLowerCase(locale));
                if (!TextUtils.isEmpty(locale.getCountry())) {
                    sb.append("-");
                    sb.append(locale.getCountry().toLowerCase(locale));
                }
                str = sb.toString();
                this.f1563c = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str2, str3, str, Build.MODEL, Build.ID});
                this.f1564d = new d1(hVar.f1505c);
            }
        }
        str = null;
        this.f1563c = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str2, str3, str, Build.MODEL, Build.ID});
        this.f1564d = new d1(hVar.f1505c);
    }

    public static void x(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x025d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x025e, code lost:
        r1 = r0;
        r13 = null;
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0263, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0264, code lost:
        r17 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03c9, code lost:
        if (r0 != 200) goto L_0x0458;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0454, code lost:
        if (v(r5, r4) == 200) goto L_0x0456;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x025d A[ExcHandler: all (r0v70 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:79:0x0195] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x026f A[SYNTHETIC, Splitter:B:122:0x026f] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x028b A[SYNTHETIC, Splitter:B:132:0x028b] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x014b A[EDGE_INSN: B:226:0x014b->B:63:0x014b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x046e A[EDGE_INSN: B:227:0x046e->B:224:0x046e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0140 A[LOOP:0: B:35:0x00c5->B:62:0x0140, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> A(java.util.List<a.d.a.a.h.f.n0> r20) {
        /*
            r19 = this;
            r7 = r19
            a.d.a.a.h.f.x r0 = a.d.a.a.h.f.x.NONE
            a.d.a.a.b.f.b()
            r19.u()
            a.c.a.f.b.k(r20)
            a.d.a.a.h.f.h r1 = r7.f1490a
            a.d.a.a.h.f.b0 r1 = r1.f1506d
            java.util.Set r1 = r1.g()
            boolean r1 = r1.isEmpty()
            r8 = 1
            r9 = 0
            if (r1 != 0) goto L_0x0091
            a.d.a.a.h.f.d1 r1 = r7.f1564d
            a.d.a.a.h.f.j0<java.lang.Integer> r2 = a.d.a.a.h.f.i0.t
            V r2 = r2.f1517a
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            long r2 = (long) r2
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            boolean r1 = r1.b(r2)
            if (r1 != 0) goto L_0x0035
            goto L_0x0091
        L_0x0035:
            a.d.a.a.h.f.j0<java.lang.String> r1 = a.d.a.a.h.f.i0.n
            V r1 = r1.f1517a
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "BATCH_BY_SESSION"
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x0046
            a.d.a.a.h.f.x r1 = a.d.a.a.h.f.x.BATCH_BY_SESSION
            goto L_0x0073
        L_0x0046:
            java.lang.String r2 = "BATCH_BY_TIME"
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x0051
            a.d.a.a.h.f.x r1 = a.d.a.a.h.f.x.BATCH_BY_TIME
            goto L_0x0073
        L_0x0051:
            java.lang.String r2 = "BATCH_BY_BRUTE_FORCE"
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x005c
            a.d.a.a.h.f.x r1 = a.d.a.a.h.f.x.BATCH_BY_BRUTE_FORCE
            goto L_0x0073
        L_0x005c:
            java.lang.String r2 = "BATCH_BY_COUNT"
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x0067
            a.d.a.a.h.f.x r1 = a.d.a.a.h.f.x.BATCH_BY_COUNT
            goto L_0x0073
        L_0x0067:
            java.lang.String r2 = "BATCH_BY_SIZE"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0072
            a.d.a.a.h.f.x r1 = a.d.a.a.h.f.x.BATCH_BY_SIZE
            goto L_0x0073
        L_0x0072:
            r1 = r0
        L_0x0073:
            if (r1 == r0) goto L_0x0077
            r0 = 1
            goto L_0x0078
        L_0x0077:
            r0 = 0
        L_0x0078:
            a.d.a.a.h.f.j0<java.lang.String> r1 = a.d.a.a.h.f.i0.o
            V r1 = r1.f1517a
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "GZIP"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0089
            a.d.a.a.h.f.z r1 = a.d.a.a.h.f.z.GZIP
            goto L_0x008b
        L_0x0089:
            a.d.a.a.h.f.z r1 = a.d.a.a.h.f.z.NONE
        L_0x008b:
            a.d.a.a.h.f.z r2 = a.d.a.a.h.f.z.GZIP
            if (r1 != r2) goto L_0x0092
            r10 = 1
            goto L_0x0093
        L_0x0091:
            r0 = 0
        L_0x0092:
            r10 = 0
        L_0x0093:
            java.lang.String r11 = "Error trying to parse the hardcoded host url"
            r12 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x02da
            boolean r0 = r20.isEmpty()
            r0 = r0 ^ r8
            a.c.a.f.b.d(r0)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r10)
            int r0 = r20.size()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r2 = 2
            r6 = 0
            java.lang.String r3 = "Uploading batched hits. compression, count"
            r1 = r19
            r1.a(r2, r3, r4, r5, r6)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r2 = r20.iterator()
            r3 = 0
        L_0x00c5:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x014b
            java.lang.Object r0 = r2.next()
            r4 = r0
            a.d.a.a.h.f.n0 r4 = (a.d.a.a.h.f.n0) r4
            a.c.a.f.b.k(r4)
            int r0 = r3 + 1
            a.d.a.a.h.f.j0<java.lang.Integer> r5 = a.d.a.a.h.f.i0.h
            V r5 = r5.f1517a
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r0 <= r5) goto L_0x00e4
            goto L_0x0125
        L_0x00e4:
            java.lang.String r5 = r7.w(r4, r9)
            if (r5 != 0) goto L_0x00f1
            a.d.a.a.h.f.r0 r0 = r19.g()
            java.lang.String r5 = "Error formatting hit"
            goto L_0x0108
        L_0x00f1:
            byte[] r5 = r5.getBytes()
            int r6 = r5.length
            a.d.a.a.h.f.j0<java.lang.Integer> r15 = a.d.a.a.h.f.i0.p
            V r15 = r15.f1517a
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            if (r6 <= r15) goto L_0x010c
            a.d.a.a.h.f.r0 r0 = r19.g()
            java.lang.String r5 = "Hit size exceeds the maximum size limit"
        L_0x0108:
            r0.v(r4, r5)
            goto L_0x013d
        L_0x010c:
            int r15 = r1.size()
            if (r15 <= 0) goto L_0x0114
            int r6 = r6 + 1
        L_0x0114:
            int r15 = r1.size()
            int r15 = r15 + r6
            a.d.a.a.h.f.j0<java.lang.Integer> r6 = a.d.a.a.h.f.i0.r
            V r6 = r6.f1517a
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r15 <= r6) goto L_0x0127
        L_0x0125:
            r0 = 0
            goto L_0x013e
        L_0x0127:
            int r6 = r1.size()     // Catch:{ IOException -> 0x0137 }
            if (r6 <= 0) goto L_0x0132
            byte[] r6 = f1562e     // Catch:{ IOException -> 0x0137 }
            r1.write(r6)     // Catch:{ IOException -> 0x0137 }
        L_0x0132:
            r1.write(r5)     // Catch:{ IOException -> 0x0137 }
            r3 = r0
            goto L_0x013d
        L_0x0137:
            r0 = move-exception
            java.lang.String r5 = "Failed to write payload when batching hits"
            r7.n(r5, r0)
        L_0x013d:
            r0 = 1
        L_0x013e:
            if (r0 == 0) goto L_0x014b
            long r4 = r4.f1539b
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            r14.add(r0)
            goto L_0x00c5
        L_0x014b:
            r15 = r3
            if (r15 != 0) goto L_0x014f
            return r14
        L_0x014f:
            java.lang.String r0 = a.d.a.a.h.f.b0.d()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            a.d.a.a.h.f.j0<java.lang.String> r2 = a.d.a.a.h.f.i0.l
            V r2 = r2.f1517a
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x016c
            java.lang.String r0 = r0.concat(r2)
            goto L_0x0172
        L_0x016c:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x0172:
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0179 }
            r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x0179 }
            r0 = r2
            goto L_0x017e
        L_0x0179:
            r0 = move-exception
            r7.n(r11, r0)
            r0 = 0
        L_0x017e:
            if (r0 != 0) goto L_0x0187
            java.lang.String r0 = "Failed to build batching endpoint url"
            r7.q(r0)
            goto L_0x02d5
        L_0x0187:
            if (r10 == 0) goto L_0x029a
            byte[] r10 = r1.toByteArray()
            java.lang.String r11 = "Error closing http compressed post connection output stream"
            a.c.a.f.b.k(r0)
            a.c.a.f.b.k(r10)
            a.d.a.a.h.f.h r1 = r7.f1490a     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            android.content.Context r1 = r1.f1503a     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r1.getPackageName()     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r1.<init>()     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r2.write(r10)     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r2.close()     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r1.close()     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            byte[] r6 = r1.toByteArray()     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            java.lang.String r3 = "POST compressed size, ratio %, url"
            int r1 = r6.length     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r1 = 100
            int r5 = r6.length     // Catch:{ IOException -> 0x0263, all -> 0x025d }
            r17 = r14
            long r13 = (long) r5
            long r13 = r13 * r1
            int r1 = r10.length     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            long r1 = (long) r1     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            long r13 = r13 / r1
            java.lang.Long r5 = java.lang.Long.valueOf(r13)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            r2 = 3
            r1 = r19
            r13 = r6
            r6 = r0
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            int r1 = r13.length     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            int r2 = r10.length     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            if (r1 <= r2) goto L_0x01e4
            java.lang.String r1 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            int r2 = r13.length     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            int r3 = r10.length     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            r7.f(r1, r2, r3)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
        L_0x01e4:
            a.d.a.a.h.f.j0<java.lang.String> r1 = a.d.a.a.h.f.i0.f1511b     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            V r1 = r1.f1517a     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            r2 = 2
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            if (r1 == 0) goto L_0x020e
            java.lang.String r1 = "Post payload"
            java.lang.String r2 = "\n"
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            r3.<init>(r10)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            int r4 = r3.length()     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            if (r4 == 0) goto L_0x0205
            java.lang.String r2 = r2.concat(r3)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            goto L_0x020b
        L_0x0205:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            r3.<init>(r2)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            r2 = r3
        L_0x020b:
            r7.b(r1, r2)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
        L_0x020e:
            java.net.HttpURLConnection r1 = r7.z(r0)     // Catch:{ IOException -> 0x025b, all -> 0x025d }
            r1.setDoOutput(r8)     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r2 = "gzip"
            r1.addRequestProperty(r0, r2)     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            int r0 = r13.length     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            r1.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            r1.connect()     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            r2.write(r13)     // Catch:{ IOException -> 0x0251, all -> 0x024c }
            r2.close()     // Catch:{ IOException -> 0x0251, all -> 0x024c }
            r7.y(r1)     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            int r0 = r1.getResponseCode()     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            if (r0 != r12) goto L_0x023d
            a.d.a.a.h.f.b r2 = r19.i()     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            r2.v()     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
        L_0x023d:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            r7.d(r2, r3)     // Catch:{ IOException -> 0x0259, all -> 0x0254 }
            r1.disconnect()
            r9 = r0
            goto L_0x02a4
        L_0x024c:
            r0 = move-exception
            r13 = r1
            r16 = r2
            goto L_0x0282
        L_0x0251:
            r0 = move-exception
            r13 = r2
            goto L_0x0268
        L_0x0254:
            r0 = move-exception
            r13 = r1
            r16 = 0
            goto L_0x0282
        L_0x0259:
            r0 = move-exception
            goto L_0x0267
        L_0x025b:
            r0 = move-exception
            goto L_0x0266
        L_0x025d:
            r0 = move-exception
            r1 = r0
            r13 = 0
            r16 = 0
            goto L_0x0289
        L_0x0263:
            r0 = move-exception
            r17 = r14
        L_0x0266:
            r1 = 0
        L_0x0267:
            r13 = 0
        L_0x0268:
            java.lang.String r2 = "Network compressed POST connection error"
            r7.l(r2, r0)     // Catch:{ all -> 0x027e }
            if (r13 == 0) goto L_0x0278
            r13.close()     // Catch:{ IOException -> 0x0273 }
            goto L_0x0278
        L_0x0273:
            r0 = move-exception
            r2 = r0
            r7.n(r11, r2)
        L_0x0278:
            if (r1 == 0) goto L_0x02a4
            r1.disconnect()
            goto L_0x02a4
        L_0x027e:
            r0 = move-exception
            r16 = r13
            r13 = r1
        L_0x0282:
            r1 = r0
            r18 = r16
            r16 = r13
            r13 = r18
        L_0x0289:
            if (r13 == 0) goto L_0x0294
            r13.close()     // Catch:{ IOException -> 0x028f }
            goto L_0x0294
        L_0x028f:
            r0 = move-exception
            r2 = r0
            r7.n(r11, r2)
        L_0x0294:
            if (r16 == 0) goto L_0x0299
            r16.disconnect()
        L_0x0299:
            throw r1
        L_0x029a:
            r17 = r14
            byte[] r1 = r1.toByteArray()
            int r9 = r7.v(r0, r1)
        L_0x02a4:
            if (r12 != r9) goto L_0x02b0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            java.lang.String r1 = "Batched upload completed. Hits batched"
            r7.b(r1, r0)
            return r17
        L_0x02b0:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            java.lang.String r1 = "Network error uploading hits. status code"
            r7.b(r1, r0)
            a.d.a.a.h.f.h r0 = r7.f1490a
            a.d.a.a.h.f.b0 r0 = r0.f1506d
            java.util.Set r0 = r0.g()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x02d5
            java.lang.String r0 = "Server instructed the client to stop batching"
            r7.p(r0)
            a.d.a.a.h.f.d1 r0 = r7.f1564d
            r0.a()
        L_0x02d5:
            java.util.List r0 = java.util.Collections.emptyList()
            return r0
        L_0x02da:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r0 = r20.size()
            r1.<init>(r0)
            java.util.Iterator r2 = r20.iterator()
        L_0x02e7:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x046e
            java.lang.Object r0 = r2.next()
            r3 = r0
            a.d.a.a.h.f.n0 r3 = (a.d.a.a.h.f.n0) r3
            a.c.a.f.b.k(r3)
            boolean r0 = r3.f1542e
            r0 = r0 ^ r8
            java.lang.String r0 = r7.w(r3, r0)
            if (r0 != 0) goto L_0x0308
            a.d.a.a.h.f.r0 r0 = r19.g()
            java.lang.String r4 = "Error formatting hit for upload"
            goto L_0x03f7
        L_0x0308:
            int r4 = r0.length()
            a.d.a.a.h.f.j0<java.lang.Integer> r5 = a.d.a.a.h.f.i0.m
            V r5 = r5.f1517a
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r4 > r5) goto L_0x03d3
            boolean r4 = r3.f1542e
            if (r4 == 0) goto L_0x0341
            java.lang.String r4 = a.d.a.a.h.f.b0.d()
            java.lang.String r5 = a.d.a.a.h.f.b0.f()
            java.lang.String r6 = java.lang.String.valueOf(r4)
            int r6 = r6.length()
            int r6 = r6 + r8
            java.lang.String r10 = java.lang.String.valueOf(r5)
            int r10 = r10.length()
            int r10 = r10 + r6
            int r6 = r0.length()
            int r6 = r6 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r6)
            goto L_0x0365
        L_0x0341:
            java.lang.String r4 = a.d.a.a.h.f.b0.e()
            java.lang.String r5 = a.d.a.a.h.f.b0.f()
            java.lang.String r6 = java.lang.String.valueOf(r4)
            int r6 = r6.length()
            int r6 = r6 + r8
            java.lang.String r10 = java.lang.String.valueOf(r5)
            int r10 = r10.length()
            int r10 = r10 + r6
            int r6 = r0.length()
            int r6 = r6 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r6)
        L_0x0365:
            r10.append(r4)
            r10.append(r5)
            java.lang.String r4 = "?"
            r10.append(r4)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x037d }
            r4.<init>(r0)     // Catch:{ MalformedURLException -> 0x037d }
            goto L_0x0382
        L_0x037d:
            r0 = move-exception
            r7.n(r11, r0)
            r4 = 0
        L_0x0382:
            if (r4 != 0) goto L_0x0388
            java.lang.String r0 = "Failed to build collect GET endpoint url"
            goto L_0x044c
        L_0x0388:
            a.c.a.f.b.k(r4)
            java.lang.String r0 = "GET request"
            r7.d(r0, r4)
            java.net.HttpURLConnection r4 = r7.z(r4)     // Catch:{ IOException -> 0x03bc, all -> 0x03b9 }
            r4.connect()     // Catch:{ IOException -> 0x03b7 }
            r7.y(r4)     // Catch:{ IOException -> 0x03b7 }
            int r0 = r4.getResponseCode()     // Catch:{ IOException -> 0x03b7 }
            if (r0 != r12) goto L_0x03a7
            a.d.a.a.h.f.b r5 = r19.i()     // Catch:{ IOException -> 0x03b7 }
            r5.v()     // Catch:{ IOException -> 0x03b7 }
        L_0x03a7:
            java.lang.String r5 = "GET status"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x03b7 }
            r7.d(r5, r6)     // Catch:{ IOException -> 0x03b7 }
            r4.disconnect()
            goto L_0x03c9
        L_0x03b4:
            r0 = move-exception
            r13 = r4
            goto L_0x03cd
        L_0x03b7:
            r0 = move-exception
            goto L_0x03be
        L_0x03b9:
            r0 = move-exception
            r13 = 0
            goto L_0x03cd
        L_0x03bc:
            r0 = move-exception
            r4 = 0
        L_0x03be:
            java.lang.String r5 = "Network GET connection error"
            r7.l(r5, r0)     // Catch:{ all -> 0x03b4 }
            if (r4 == 0) goto L_0x03c8
            r4.disconnect()
        L_0x03c8:
            r0 = 0
        L_0x03c9:
            if (r0 != r12) goto L_0x0458
            goto L_0x0456
        L_0x03cd:
            if (r13 == 0) goto L_0x03d2
            r13.disconnect()
        L_0x03d2:
            throw r0
        L_0x03d3:
            java.lang.String r0 = r7.w(r3, r9)
            if (r0 != 0) goto L_0x03e0
            a.d.a.a.h.f.r0 r0 = r19.g()
            java.lang.String r4 = "Error formatting hit for POST upload"
            goto L_0x03f7
        L_0x03e0:
            byte[] r4 = r0.getBytes()
            int r0 = r4.length
            a.d.a.a.h.f.j0<java.lang.Integer> r5 = a.d.a.a.h.f.i0.q
            V r5 = r5.f1517a
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r0 <= r5) goto L_0x03fb
            a.d.a.a.h.f.r0 r0 = r19.g()
            java.lang.String r4 = "Hit payload exceeds size limit"
        L_0x03f7:
            r0.v(r3, r4)
            goto L_0x0456
        L_0x03fb:
            boolean r0 = r3.f1542e
            if (r0 == 0) goto L_0x041c
            java.lang.String r0 = a.d.a.a.h.f.b0.d()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r5 = a.d.a.a.h.f.b0.f()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0416
            goto L_0x0432
        L_0x0416:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0)
            goto L_0x043c
        L_0x041c:
            java.lang.String r0 = a.d.a.a.h.f.b0.e()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r5 = a.d.a.a.h.f.b0.f()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0437
        L_0x0432:
            java.lang.String r0 = r0.concat(r5)
            goto L_0x043d
        L_0x0437:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0)
        L_0x043c:
            r0 = r5
        L_0x043d:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0443 }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x0443 }
            goto L_0x0448
        L_0x0443:
            r0 = move-exception
            r7.n(r11, r0)
            r5 = 0
        L_0x0448:
            if (r5 != 0) goto L_0x0450
            java.lang.String r0 = "Failed to build collect POST endpoint url"
        L_0x044c:
            r7.q(r0)
            goto L_0x0458
        L_0x0450:
            int r0 = r7.v(r5, r4)
            if (r0 != r12) goto L_0x0458
        L_0x0456:
            r0 = 1
            goto L_0x0459
        L_0x0458:
            r0 = 0
        L_0x0459:
            if (r0 == 0) goto L_0x046e
            long r3 = r3.f1539b
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            r1.add(r0)
            int r0 = r1.size()
            int r3 = a.d.a.a.h.f.b0.c()
            if (r0 < r3) goto L_0x02e7
        L_0x046e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.t0.A(java.util.List):java.util.List");
    }

    public final boolean B() {
        f.b();
        u();
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ((ConnectivityManager) this.f1490a.f1503a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        o("No network connectivity");
        return false;
    }

    public final void t() {
        b("Network initialized. User agent", this.f1563c);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r10v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC, Splitter:B:27:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096 A[SYNTHETIC, Splitter:B:36:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int v(java.net.URL r10, byte[] r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            a.c.a.f.b.k(r10)
            a.c.a.f.b.k(r11)
            int r1 = r11.length
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r3 = 3
            java.lang.String r4 = "POST bytes, url"
            r7 = 0
            r2 = r9
            r6 = r10
            r2.a(r3, r4, r5, r6, r7)
            a.d.a.a.h.f.j0<java.lang.String> r1 = a.d.a.a.h.f.i0.f1511b
            V r1 = r1.f1517a
            java.lang.String r1 = (java.lang.String) r1
            r2 = 2
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = new java.lang.String
            r1.<init>(r11)
            java.lang.String r2 = "Post payload\n"
            r9.b(r2, r1)
        L_0x002d:
            r1 = 0
            a.d.a.a.h.f.h r2 = r9.f1490a     // Catch:{ IOException -> 0x0077, all -> 0x0074 }
            android.content.Context r2 = r2.f1503a     // Catch:{ IOException -> 0x0077, all -> 0x0074 }
            r2.getPackageName()     // Catch:{ IOException -> 0x0077, all -> 0x0074 }
            java.net.HttpURLConnection r10 = r9.z(r10)     // Catch:{ IOException -> 0x0077, all -> 0x0074 }
            r2 = 1
            r10.setDoOutput(r2)     // Catch:{ IOException -> 0x0072 }
            int r2 = r11.length     // Catch:{ IOException -> 0x0072 }
            r10.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x0072 }
            r10.connect()     // Catch:{ IOException -> 0x0072 }
            java.io.OutputStream r1 = r10.getOutputStream()     // Catch:{ IOException -> 0x0072 }
            r1.write(r11)     // Catch:{ IOException -> 0x0072 }
            r9.y(r10)     // Catch:{ IOException -> 0x0072 }
            int r11 = r10.getResponseCode()     // Catch:{ IOException -> 0x0072 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r11 != r2) goto L_0x005d
            a.d.a.a.h.f.b r2 = r9.i()     // Catch:{ IOException -> 0x0072 }
            r2.v()     // Catch:{ IOException -> 0x0072 }
        L_0x005d:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)     // Catch:{ IOException -> 0x0072 }
            r9.d(r2, r3)     // Catch:{ IOException -> 0x0072 }
            r1.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r1 = move-exception
            r9.n(r0, r1)
        L_0x006e:
            r10.disconnect()
            return r11
        L_0x0072:
            r11 = move-exception
            goto L_0x007a
        L_0x0074:
            r10 = move-exception
            r11 = r1
            goto L_0x0094
        L_0x0077:
            r10 = move-exception
            r11 = r10
            r10 = r1
        L_0x007a:
            java.lang.String r2 = "Network POST connection error"
            r9.l(r2, r11)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0089
            r1.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r11 = move-exception
            r9.n(r0, r11)
        L_0x0089:
            if (r10 == 0) goto L_0x008e
            r10.disconnect()
        L_0x008e:
            r10 = 0
            return r10
        L_0x0090:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x0094:
            if (r1 == 0) goto L_0x009e
            r1.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r1 = move-exception
            r9.n(r0, r1)
        L_0x009e:
            if (r11 == 0) goto L_0x00a3
            r11.disconnect()
        L_0x00a3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.t0.v(java.net.URL, byte[]):int");
    }

    public final String w(n0 n0Var, boolean z) {
        long j;
        String str;
        b.k(n0Var);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : n0Var.f1538a.entrySet()) {
                String str2 = (String) next.getKey();
                if (!"ht".equals(str2) && !"qt".equals(str2) && !"AppUID".equals(str2) && !"z".equals(str2) && !"_gmsv".equals(str2)) {
                    x(sb, str2, (String) next.getValue());
                }
            }
            x(sb, "ht", String.valueOf(n0Var.f1540c));
            if (((c) this.f1490a.f1505c) != null) {
                x(sb, "qt", String.valueOf(System.currentTimeMillis() - n0Var.f1540c));
                if (z) {
                    b.h("_s");
                    b.e(true, "Short param name required");
                    String str3 = n0Var.f1538a.get("_s");
                    if (str3 == null) {
                        str3 = oOO0O0O0.O0000oO0;
                    }
                    try {
                        j = Long.parseLong(str3);
                    } catch (NumberFormatException unused) {
                        j = 0;
                    }
                    if (j != 0) {
                        str = String.valueOf(j);
                    } else {
                        str = String.valueOf(n0Var.f1539b);
                    }
                    x(sb, "z", str);
                }
                return sb.toString();
            }
            throw null;
        } catch (UnsupportedEncodingException e2) {
            n("Failed to encode name or value", e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC, Splitter:B:18:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y(java.net.HttpURLConnection r4) {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x001b }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0019 }
        L_0x000a:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x0019 }
            if (r2 > 0) goto L_0x000a
            r4.close()     // Catch:{ IOException -> 0x0014 }
            return
        L_0x0014:
            r4 = move-exception
            r3.n(r0, r4)
            return
        L_0x0019:
            r1 = move-exception
            goto L_0x001d
        L_0x001b:
            r1 = move-exception
            r4 = 0
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r3.n(r0, r4)
        L_0x0027:
            goto L_0x0029
        L_0x0028:
            throw r1
        L_0x0029:
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.t0.y(java.net.HttpURLConnection):void");
    }

    public final HttpURLConnection z(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) i0.u.f1517a).intValue());
            httpURLConnection.setReadTimeout(((Integer) i0.v.f1517a).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.f1563c);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }
}
