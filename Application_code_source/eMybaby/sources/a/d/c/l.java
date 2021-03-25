package a.d.c;

import java.util.EnumMap;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f2875a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f2876b;

    /* renamed from: c  reason: collision with root package name */
    public n[] f2877c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2878d;

    /* renamed from: e  reason: collision with root package name */
    public Map<m, Object> f2879e = null;

    public l(String str, byte[] bArr, n[] nVarArr, a aVar) {
        System.currentTimeMillis();
        this.f2875a = str;
        this.f2876b = bArr;
        this.f2877c = nVarArr;
        this.f2878d = aVar;
    }

    public void a(m mVar, Object obj) {
        if (this.f2879e == null) {
            this.f2879e = new EnumMap(m.class);
        }
        this.f2879e.put(mVar, obj);
    }

    public String toString() {
        return this.f2875a;
    }
}
