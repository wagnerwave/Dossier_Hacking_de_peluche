package a.d.c.s.c;

import a.d.c.n;
import a.d.c.r.f;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final a.d.c.r.b f3034a;

    /* renamed from: b  reason: collision with root package name */
    public final a.d.c.r.k.a f3035b;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final n f3036a;

        /* renamed from: b  reason: collision with root package name */
        public final n f3037b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3038c;

        public b(n nVar, n nVar2, int i, C0071a aVar) {
            this.f3036a = nVar;
            this.f3037b = nVar2;
            this.f3038c = i;
        }

        public String toString() {
            return this.f3036a + "/" + this.f3037b + '/' + this.f3038c;
        }
    }

    public static class c implements Comparator<b>, Serializable {
        public c(C0071a aVar) {
        }

        public int compare(Object obj, Object obj2) {
            return ((b) obj).f3038c - ((b) obj2).f3038c;
        }
    }

    public a(a.d.c.r.b bVar) {
        this.f3034a = bVar;
        this.f3035b = new a.d.c.r.k.a(bVar);
    }

    public static int a(n nVar, n nVar2) {
        float f = nVar.f2885a;
        float f2 = nVar2.f2885a;
        float f3 = f - f2;
        float f4 = nVar.f2886b;
        float f5 = nVar2.f2886b;
        return (int) (((float) Math.sqrt((double) a.a.a.a.a.a(f4, f5, f4 - f5, (f - f2) * f3))) + 0.5f);
    }

    public static void b(Map<n, Integer> map, n nVar) {
        Integer num = map.get(nVar);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(nVar, Integer.valueOf(i));
    }

    public static a.d.c.r.b d(a.d.c.r.b bVar, n nVar, n nVar2, n nVar3, n nVar4, int i, int i2) {
        n nVar5 = nVar;
        n nVar6 = nVar2;
        n nVar7 = nVar3;
        n nVar8 = nVar4;
        float f = ((float) i) - 0.5f;
        float f2 = ((float) i2) - 0.5f;
        return f.f2982a.a(bVar, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, nVar5.f2885a, nVar5.f2886b, nVar8.f2885a, nVar8.f2886b, nVar7.f2885a, nVar7.f2886b, nVar6.f2885a, nVar6.f2886b);
    }

    public final boolean c(n nVar) {
        float f = nVar.f2885a;
        if (f >= 0.0f) {
            a.d.c.r.b bVar = this.f3034a;
            if (f < ((float) bVar.f2966a)) {
                float f2 = nVar.f2886b;
                return f2 > 0.0f && f2 < ((float) bVar.f2967b);
            }
        }
    }

    public final b e(n nVar, n nVar2) {
        a aVar = this;
        n nVar3 = nVar;
        n nVar4 = nVar2;
        int i = (int) nVar3.f2885a;
        int i2 = (int) nVar3.f2886b;
        int i3 = (int) nVar4.f2885a;
        int i4 = (int) nVar4.f2886b;
        int i5 = 1;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z) {
            int i6 = i2;
            i2 = i;
            i = i6;
            int i7 = i4;
            i4 = i3;
            i3 = i7;
        }
        int abs = Math.abs(i3 - i);
        int abs2 = Math.abs(i4 - i2);
        int i8 = (-abs) >> 1;
        int i9 = i2 < i4 ? 1 : -1;
        if (i >= i3) {
            i5 = -1;
        }
        boolean a2 = aVar.f3034a.a(z ? i2 : i, z ? i : i2);
        int i10 = 0;
        while (i != i3) {
            boolean a3 = aVar.f3034a.a(z ? i2 : i, z ? i : i2);
            if (a3 != a2) {
                i10++;
                a2 = a3;
            }
            i8 += abs2;
            if (i8 > 0) {
                if (i2 == i4) {
                    break;
                }
                i2 += i9;
                i8 -= abs;
            }
            i += i5;
            aVar = this;
        }
        return new b(nVar3, nVar4, i10, (C0071a) null);
    }
}
