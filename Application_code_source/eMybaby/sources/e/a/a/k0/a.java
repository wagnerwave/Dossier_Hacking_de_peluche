package e.a.a.k0;

import java.util.HashMap;
import java.util.Map;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c f5175a = null;

    /* renamed from: b  reason: collision with root package name */
    public Map f5176b = null;

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r1 = r2.f5175a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0016
            r0 = 0
            java.util.Map r1 = r2.f5176b
            if (r1 == 0) goto L_0x000b
            java.lang.Object r0 = r1.get(r3)
        L_0x000b:
            if (r0 != 0) goto L_0x0015
            e.a.a.k0.c r1 = r2.f5175a
            if (r1 == 0) goto L_0x0015
            java.lang.Object r0 = r1.b(r3)
        L_0x0015:
            return r0
        L_0x0016:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Id may not be null"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.k0.a.b(java.lang.String):java.lang.Object");
    }

    public void e(String str, Object obj) {
        if (str != null) {
            if (this.f5176b == null) {
                this.f5176b = new HashMap();
            }
            this.f5176b.put(str, obj);
            return;
        }
        throw new IllegalArgumentException("Id may not be null");
    }
}
