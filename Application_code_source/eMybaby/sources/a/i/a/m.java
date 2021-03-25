package a.i.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

public class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<String, Bitmap> f3625a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3626b;

    /* renamed from: c  reason: collision with root package name */
    public int f3627c;

    /* renamed from: d  reason: collision with root package name */
    public int f3628d;

    /* renamed from: e  reason: collision with root package name */
    public int f3629e;
    public int f;
    public int g;

    public m(Context context) {
        int b2 = g0.b(context);
        if (b2 > 0) {
            this.f3626b = b2;
            this.f3625a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("Max size must be positive.");
    }

    public final synchronized int a() {
        return this.f3626b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x00a1
            if (r4 == 0) goto L_0x00a1
            monitor-enter(r2)
            int r0 = r2.f3628d     // Catch:{ all -> 0x009e }
            int r0 = r0 + 1
            r2.f3628d = r0     // Catch:{ all -> 0x009e }
            int r0 = r2.f3627c     // Catch:{ all -> 0x009e }
            int r1 = a.i.a.g0.j(r4)     // Catch:{ all -> 0x009e }
            int r0 = r0 + r1
            r2.f3627c = r0     // Catch:{ all -> 0x009e }
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r2.f3625a     // Catch:{ all -> 0x009e }
            java.lang.Object r3 = r0.put(r3, r4)     // Catch:{ all -> 0x009e }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ all -> 0x009e }
            if (r3 == 0) goto L_0x0027
            int r4 = r2.f3627c     // Catch:{ all -> 0x009e }
            int r3 = a.i.a.g0.j(r3)     // Catch:{ all -> 0x009e }
            int r4 = r4 - r3
            r2.f3627c = r4     // Catch:{ all -> 0x009e }
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x009e }
            int r3 = r2.f3626b
        L_0x002a:
            monitor-enter(r2)
            int r4 = r2.f3627c     // Catch:{ all -> 0x009b }
            if (r4 < 0) goto L_0x007c
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r4 = r2.f3625a     // Catch:{ all -> 0x009b }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x009b }
            if (r4 == 0) goto L_0x003b
            int r4 = r2.f3627c     // Catch:{ all -> 0x009b }
            if (r4 != 0) goto L_0x007c
        L_0x003b:
            int r4 = r2.f3627c     // Catch:{ all -> 0x009b }
            if (r4 <= r3) goto L_0x007a
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r4 = r2.f3625a     // Catch:{ all -> 0x009b }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x009b }
            if (r4 == 0) goto L_0x0048
            goto L_0x007a
        L_0x0048:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r4 = r2.f3625a     // Catch:{ all -> 0x009b }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x009b }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x009b }
            java.lang.Object r4 = r4.next()     // Catch:{ all -> 0x009b }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x009b }
            java.lang.Object r0 = r4.getKey()     // Catch:{ all -> 0x009b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x009b }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x009b }
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ all -> 0x009b }
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r1 = r2.f3625a     // Catch:{ all -> 0x009b }
            r1.remove(r0)     // Catch:{ all -> 0x009b }
            int r0 = r2.f3627c     // Catch:{ all -> 0x009b }
            int r4 = a.i.a.g0.j(r4)     // Catch:{ all -> 0x009b }
            int r0 = r0 - r4
            r2.f3627c = r0     // Catch:{ all -> 0x009b }
            int r4 = r2.f3629e     // Catch:{ all -> 0x009b }
            int r4 = r4 + 1
            r2.f3629e = r4     // Catch:{ all -> 0x009b }
            monitor-exit(r2)     // Catch:{ all -> 0x009b }
            goto L_0x002a
        L_0x007a:
            monitor-exit(r2)     // Catch:{ all -> 0x009b }
            return
        L_0x007c:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r4.<init>()     // Catch:{ all -> 0x009b }
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x009b }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x009b }
            r4.append(r0)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = ".sizeOf() is reporting inconsistent results!"
            r4.append(r0)     // Catch:{ all -> 0x009b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009b }
            r3.<init>(r4)     // Catch:{ all -> 0x009b }
            throw r3     // Catch:{ all -> 0x009b }
        L_0x009b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009b }
            throw r3
        L_0x009e:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009e }
            throw r3
        L_0x00a1:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "key == null || bitmap == null"
            r3.<init>(r4)
            goto L_0x00aa
        L_0x00a9:
            throw r3
        L_0x00aa:
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.m.b(java.lang.String, android.graphics.Bitmap):void");
    }

    public Bitmap get(String str) {
        if (str != null) {
            synchronized (this) {
                Bitmap bitmap = this.f3625a.get(str);
                if (bitmap != null) {
                    this.f++;
                    return bitmap;
                }
                this.g++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized int size() {
        return this.f3627c;
    }
}
