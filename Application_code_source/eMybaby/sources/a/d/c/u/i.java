package a.d.c.u;

import a.d.c.a;
import a.d.c.e;
import a.d.c.k;
import a.d.c.l;
import a.d.c.u.p.f.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class i extends k {

    /* renamed from: a  reason: collision with root package name */
    public final k[] f3065a;

    public i(Map<e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13) || collection.contains(a.UPC_A) || collection.contains(a.EAN_8) || collection.contains(a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.RSS_14)) {
                arrayList.add(new a.d.c.u.p.e());
            }
            if (collection.contains(a.RSS_EXPANDED)) {
                arrayList.add(new b());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new a.d.c.u.p.e());
            arrayList.add(new b());
        }
        this.f3065a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    public l b(int i, a.d.c.r.a aVar, Map<e, ?> map) {
        k[] kVarArr = this.f3065a;
        int i2 = 0;
        while (i2 < kVarArr.length) {
            try {
                return kVarArr[i2].b(i, aVar, map);
            } catch (k unused) {
                i2++;
            }
        }
        throw a.d.c.i.f2874a;
    }

    public void reset() {
        for (k reset : this.f3065a) {
            reset.reset();
        }
    }
}
