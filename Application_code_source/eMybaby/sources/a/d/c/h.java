package a.d.c;

import a.d.c.p.b;
import a.d.c.u.i;
import a.d.c.w.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class h implements j {

    /* renamed from: a  reason: collision with root package name */
    public Map<e, ?> f2872a;

    /* renamed from: b  reason: collision with root package name */
    public j[] f2873b;

    public l a(c cVar, Map<e, ?> map) {
        c(map);
        return b(cVar);
    }

    public final l b(c cVar) {
        j[] jVarArr = this.f2873b;
        if (jVarArr != null) {
            int length = jVarArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return jVarArr[i].a(cVar, this.f2872a);
                } catch (k unused) {
                    i++;
                }
            }
        }
        throw i.f2874a;
    }

    public void c(Map<e, ?> map) {
        this.f2872a = map;
        boolean z = false;
        boolean z2 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED)) {
                z = true;
            }
            if (z && !z2) {
                arrayList.add(new i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new a.d.c.s.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new a.d.c.v.a());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new a.d.c.t.a());
            }
            if (z && z2) {
                arrayList.add(new i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new i(map));
            }
            arrayList.add(new a());
            arrayList.add(new a.d.c.s.a());
            arrayList.add(new b());
            arrayList.add(new a.d.c.v.a());
            arrayList.add(new a.d.c.t.a());
            if (z2) {
                arrayList.add(new i(map));
            }
        }
        this.f2873b = (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    public void reset() {
        j[] jVarArr = this.f2873b;
        if (jVarArr != null) {
            for (j reset : jVarArr) {
                reset.reset();
            }
        }
    }
}
