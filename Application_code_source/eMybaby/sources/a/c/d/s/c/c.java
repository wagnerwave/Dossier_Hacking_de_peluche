package a.c.d.s.c;

import com.cuatroochenta.miniland.webservices.help.HelpInfoRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f882b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public d f883a;

        public a(HelpInfoRequest helpInfoRequest, d dVar) {
            this.f883a = dVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x007e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x006d }
                r0.<init>()     // Catch:{ Exception -> 0x006d }
                java.lang.String r1 = "platform"
                java.lang.String r2 = "android"
                r0.put(r1, r2)     // Catch:{ Exception -> 0x006d }
                java.lang.String r1 = "language"
                com.sozpic.miniland.AppMiniland r2 = com.sozpic.miniland.AppMiniland.f()     // Catch:{ Exception -> 0x006d }
                java.lang.String r2 = r2.f1b     // Catch:{ Exception -> 0x006d }
                r0.put(r1, r2)     // Catch:{ Exception -> 0x006d }
                a.c.d.s.c.c r1 = a.c.d.s.c.c.this     // Catch:{ Exception -> 0x006d }
                java.lang.String r1 = r1.f882b     // Catch:{ Exception -> 0x006d }
                java.lang.String r0 = a.c.a.d.a.c(r1, r0)     // Catch:{ Exception -> 0x006d }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x006f }
                r1.<init>(r0)     // Catch:{ Exception -> 0x006f }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x006f }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x006f }
                a.c.d.s.c.c r2 = a.c.d.s.c.c.this     // Catch:{ Exception -> 0x006f }
                java.io.InputStream r1 = r1.getInputStream()     // Catch:{ Exception -> 0x006f }
                java.lang.String r1 = a.c.d.s.c.c.a(r2, r1)     // Catch:{ Exception -> 0x006f }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x006f }
                r2.<init>(r1)     // Catch:{ Exception -> 0x006f }
                a.c.d.s.c.b r3 = new a.c.d.s.c.b     // Catch:{ Exception -> 0x006f }
                r3.<init>()     // Catch:{ Exception -> 0x006f }
                a.c.d.s.c.a r2 = r3.a(r2)     // Catch:{ Exception -> 0x006f }
                if (r2 == 0) goto L_0x0063
                java.lang.Boolean r2 = r2.f42a     // Catch:{ Exception -> 0x006f }
                boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x006f }
                if (r2 == 0) goto L_0x0063
                a.c.d.a r2 = a.c.d.a.l()     // Catch:{ Exception -> 0x006f }
                java.util.HashMap r2 = r2.r()     // Catch:{ Exception -> 0x006f }
                java.lang.String r3 = a.c.a.f.b.c(r0)     // Catch:{ Exception -> 0x006f }
                r2.put(r3, r1)     // Catch:{ Exception -> 0x006f }
                a.c.d.a r1 = a.c.d.a.l()     // Catch:{ Exception -> 0x006f }
                r1.u(r2)     // Catch:{ Exception -> 0x006f }
                goto L_0x0078
            L_0x0063:
                a.c.d.s.c.c r1 = a.c.d.s.c.c.this     // Catch:{ Exception -> 0x006f }
                java.lang.String r2 = a.c.a.f.b.c(r0)     // Catch:{ Exception -> 0x006f }
                a.c.d.s.c.c.b(r1, r2)     // Catch:{ Exception -> 0x006f }
                goto L_0x0078
            L_0x006d:
                java.lang.String r0 = ""
            L_0x006f:
                a.c.d.s.c.c r1 = a.c.d.s.c.c.this
                java.lang.String r0 = a.c.a.f.b.c(r0)
                a.c.d.s.c.c.b(r1, r0)
            L_0x0078:
                a.c.d.s.c.d r0 = r4.f883a
                a.h.a.d0 r0 = (a.h.a.d0) r0
                if (r0 == 0) goto L_0x007f
                return
            L_0x007f:
                r0 = 0
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a.c.d.s.c.c.a.run():void");
        }
    }

    public c() {
        super("HELP_IMAGES_INFO");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[SYNTHETIC, Splitter:B:19:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A[SYNTHETIC, Splitter:B:27:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(a.c.d.s.c.c r3, java.io.InputStream r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0046
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0027 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0027 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0027 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0027 }
        L_0x0012:
            java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            if (r4 == 0) goto L_0x001c
            r3.append(r4)     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            goto L_0x0012
        L_0x001c:
            r1.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0020:
            r3 = move-exception
            goto L_0x003b
        L_0x0022:
            r4 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0025:
            r3 = move-exception
            goto L_0x003a
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            r4.printStackTrace()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0035:
            java.lang.String r3 = r3.toString()
            return r3
        L_0x003a:
            r1 = r0
        L_0x003b:
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0045:
            throw r3
        L_0x0046:
            goto L_0x0048
        L_0x0047:
            throw r0
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.s.c.c.a(a.c.d.s.c.c, java.io.InputStream):java.lang.String");
    }

    public static a b(c cVar, String str) {
        if (cVar != null) {
            HashMap<String, String> r = a.c.d.a.l().r();
            if (r.containsKey(str)) {
                try {
                    return new b().a(new JSONObject(r.get(str)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            a aVar = new a();
            aVar.f42a = Boolean.FALSE;
            return aVar;
        }
        throw null;
    }
}
