package e.b.a.a.a.u.s;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import okhttp3.internal.ws.WebSocketProtocol;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f5310a;

    /* renamed from: b  reason: collision with root package name */
    public OutputStream f5311b;

    /* renamed from: c  reason: collision with root package name */
    public String f5312c;

    /* renamed from: d  reason: collision with root package name */
    public String f5313d;

    /* renamed from: e  reason: collision with root package name */
    public int f5314e;

    public e(InputStream inputStream, OutputStream outputStream, String str, String str2, int i) {
        this.f5310a = inputStream;
        this.f5311b = outputStream;
        this.f5312c = str;
        this.f5313d = str2;
        this.f5314e = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ed A[Catch:{ URISyntaxException -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x012d A[LOOP:0: B:26:0x012d->B:61:0x01d0, LOOP_START, PHI: r4 
      PHI: (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v9 java.lang.String) binds: [B:25:0x012b, B:61:0x01d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r9 = this;
            r0 = 16
            byte[] r1 = new byte[r0]
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            byte[] r2 = r2.getBytes()
            r3 = 0
            java.lang.System.arraycopy(r2, r3, r1, r3, r0)
            e.b.a.a.a.u.s.a$a r0 = e.b.a.a.a.u.s.a.f5302b
            java.lang.String r2 = "aKey"
            r0.putByteArray(r2, r1)
            e.b.a.a.a.u.s.a$a r0 = e.b.a.a.a.u.s.a.f5302b
            java.lang.String r0 = r0.f5303a
            java.lang.String r1 = "\r\n"
            java.lang.String r2 = "/mqtt"
            java.net.URI r4 = new java.net.URI     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r5 = r9.f5312c     // Catch:{ URISyntaxException -> 0x01e1 }
            r4.<init>(r5)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r5 = r4.getRawPath()     // Catch:{ URISyntaxException -> 0x01e1 }
            if (r5 == 0) goto L_0x0067
            java.lang.String r5 = r4.getRawPath()     // Catch:{ URISyntaxException -> 0x01e1 }
            boolean r5 = r5.isEmpty()     // Catch:{ URISyntaxException -> 0x01e1 }
            if (r5 != 0) goto L_0x0067
            java.lang.String r2 = r4.getRawPath()     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r5 = r4.getRawQuery()     // Catch:{ URISyntaxException -> 0x01e1 }
            if (r5 == 0) goto L_0x0067
            java.lang.String r5 = r4.getRawQuery()     // Catch:{ URISyntaxException -> 0x01e1 }
            boolean r5 = r5.isEmpty()     // Catch:{ URISyntaxException -> 0x01e1 }
            if (r5 != 0) goto L_0x0067
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.<init>(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = "?"
            r5.append(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = r4.getRawQuery()     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.append(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = r5.toString()     // Catch:{ URISyntaxException -> 0x01e1 }
        L_0x0067:
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ URISyntaxException -> 0x01e1 }
            java.io.OutputStream r6 = r9.f5311b     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.<init>(r6)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r7 = "GET "
            r6.<init>(r7)     // Catch:{ URISyntaxException -> 0x01e1 }
            r6.append(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = " HTTP/1.1"
            r6.append(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            r6.append(r1)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = r6.toString()     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            int r2 = r9.f5314e     // Catch:{ URISyntaxException -> 0x01e1 }
            r6 = 80
            java.lang.String r7 = "Host: "
            java.lang.String r8 = ":"
            if (r2 == r6) goto L_0x00ad
            int r2 = r9.f5314e     // Catch:{ URISyntaxException -> 0x01e1 }
            r6 = 443(0x1bb, float:6.21E-43)
            if (r2 == r6) goto L_0x00ad
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.<init>(r7)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r6 = r9.f5313d     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.append(r6)     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.append(r8)     // Catch:{ URISyntaxException -> 0x01e1 }
            int r6 = r9.f5314e     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.append(r6)     // Catch:{ URISyntaxException -> 0x01e1 }
        L_0x00a9:
            r2.append(r1)     // Catch:{ URISyntaxException -> 0x01e1 }
            goto L_0x00b8
        L_0x00ad:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.<init>(r7)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r6 = r9.f5313d     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.append(r6)     // Catch:{ URISyntaxException -> 0x01e1 }
            goto L_0x00a9
        L_0x00b8:
            java.lang.String r2 = r2.toString()     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = "Upgrade: websocket\r\n"
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = "Connection: Upgrade\r\n"
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r6 = "Sec-WebSocket-Key: "
            r2.<init>(r6)     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.append(r0)     // Catch:{ URISyntaxException -> 0x01e1 }
            r2.append(r1)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = r2.toString()     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = "Sec-WebSocket-Protocol: mqtt\r\n"
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = "Sec-WebSocket-Version: 13\r\n"
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = r4.getUserInfo()     // Catch:{ URISyntaxException -> 0x01e1 }
            if (r2 == 0) goto L_0x0110
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r6 = "Authorization: Basic "
            r4.<init>(r6)     // Catch:{ URISyntaxException -> 0x01e1 }
            e.b.a.a.a.u.s.a$a r6 = e.b.a.a.a.u.s.a.f5302b     // Catch:{ URISyntaxException -> 0x01e1 }
            byte[] r2 = r2.getBytes()     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r7 = "akey"
            r6.putByteArray(r7, r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            e.b.a.a.a.u.s.a$a r2 = e.b.a.a.a.u.s.a.f5302b     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = r2.f5303a     // Catch:{ URISyntaxException -> 0x01e1 }
            r4.append(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
            r4.append(r1)     // Catch:{ URISyntaxException -> 0x01e1 }
            java.lang.String r2 = r4.toString()     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.print(r2)     // Catch:{ URISyntaxException -> 0x01e1 }
        L_0x0110:
            r5.print(r1)     // Catch:{ URISyntaxException -> 0x01e1 }
            r5.flush()     // Catch:{ URISyntaxException -> 0x01e1 }
            java.io.BufferedReader r1 = new java.io.BufferedReader
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.io.InputStream r4 = r9.f5310a
            r2.<init>(r4)
            r1.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r4 = r1.readLine()
            if (r4 == 0) goto L_0x01d9
        L_0x012d:
            java.lang.String r5 = ""
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x01d0
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r6 = 1
            r1 = 1
        L_0x013c:
            int r4 = r2.size()
            if (r1 < r4) goto L_0x01b7
            java.lang.String r1 = "connection"
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x01af
            java.lang.String r2 = "upgrade"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x01af
            java.lang.Object r1 = r5.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x01a7
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = "websocket"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x01a7
            java.lang.String r1 = "sec-websocket-protocol"
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x019f
            java.lang.String r1 = "sec-websocket-accept"
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L_0x0197
            java.lang.Object r1 = r5.get(r1)     // Catch:{ NoSuchAlgorithmException -> 0x018c, c -> 0x0184 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NoSuchAlgorithmException -> 0x018c, c -> 0x0184 }
            r9.b(r0, r1)     // Catch:{ NoSuchAlgorithmException -> 0x018c, c -> 0x0184 }
            return
        L_0x0184:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "WebSocket Response header: Incorrect Sec-WebSocket-Key"
            r0.<init>(r1)
            throw r0
        L_0x018c:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            throw r1
        L_0x0197:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "WebSocket Response header: Missing Sec-WebSocket-Accept"
            r0.<init>(r1)
            throw r0
        L_0x019f:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "WebSocket Response header: empty sec-websocket-protocol"
            r0.<init>(r1)
            throw r0
        L_0x01a7:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "WebSocket Response header: Incorrect upgrade."
            r0.<init>(r1)
            throw r0
        L_0x01af:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "WebSocket Response header: Incorrect connection header"
            r0.<init>(r1)
            throw r0
        L_0x01b7:
            java.lang.Object r4 = r2.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String[] r4 = r4.split(r8)
            r7 = r4[r3]
            java.lang.String r7 = r7.toLowerCase()
            r4 = r4[r6]
            r5.put(r7, r4)
            int r1 = r1 + 1
            goto L_0x013c
        L_0x01d0:
            r2.add(r4)
            java.lang.String r4 = r1.readLine()
            goto L_0x012d
        L_0x01d9:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "WebSocket Response header: Invalid response from Server, It may not support WebSockets."
            r0.<init>(r1)
            throw r0
        L_0x01e1:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            goto L_0x01ed
        L_0x01ec:
            throw r1
        L_0x01ed:
            goto L_0x01ec
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.s.e.a():void");
    }

    public final void b(String str, String str2) {
        a.f5302b.putByteArray("aKey", MessageDigest.getInstance("SHA1").digest((String.valueOf(str) + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        if (!a.f5302b.f5303a.trim().equals(str2.trim())) {
            throw new c();
        }
    }
}
