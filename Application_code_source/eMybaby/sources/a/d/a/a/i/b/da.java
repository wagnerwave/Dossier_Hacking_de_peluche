package a.d.a.a.i.b;

import a.d.a.a.h.g.d1;
import a.d.a.a.h.g.e1;
import a.d.a.a.h.g.f6;
import a.d.a.a.h.g.g6;
import a.d.a.a.h.g.la;
import a.d.a.a.h.g.o4;
import a.d.a.a.h.g.v0;
import a.d.a.a.h.g.w0;
import a.d.a.a.h.g.y5;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class da {

    /* renamed from: a  reason: collision with root package name */
    public String f2155a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2156b;

    /* renamed from: c  reason: collision with root package name */
    public d1 f2157c;

    /* renamed from: d  reason: collision with root package name */
    public BitSet f2158d;

    /* renamed from: e  reason: collision with root package name */
    public BitSet f2159e;
    public Map<Integer, Long> f;
    public Map<Integer, List<Long>> g;
    public final /* synthetic */ ba h;

    public da(ba baVar, String str, d1 d1Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, ea eaVar) {
        this.h = baVar;
        this.f2155a = str;
        this.f2158d = bitSet;
        this.f2159e = bitSet2;
        this.f = map;
        this.g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.g.put(num, arrayList);
        }
        this.f2156b = false;
        this.f2157c = d1Var;
    }

    @NonNull
    public final v0 a(int i) {
        ArrayList arrayList;
        List list;
        v0.a aVar = (v0.a) v0.zzh.q();
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        v0 v0Var = (v0) aVar.f2047b;
        v0Var.zzc |= 1;
        v0Var.zzd = i;
        boolean z = this.f2156b;
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        v0 v0Var2 = (v0) aVar.f2047b;
        v0Var2.zzc |= 8;
        v0Var2.zzg = z;
        d1 d1Var = this.f2157c;
        if (d1Var != null) {
            if (aVar.f2048c) {
                aVar.k();
                aVar.f2048c = false;
            }
            v0.t((v0) aVar.f2047b, d1Var);
        }
        d1.a aVar2 = (d1.a) d1.zzg.q();
        aVar2.s(s9.B(this.f2158d));
        aVar2.p(s9.B(this.f2159e));
        if (this.f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f.size());
            for (Integer intValue : this.f.keySet()) {
                int intValue2 = intValue.intValue();
                w0.a aVar3 = (w0.a) w0.zzf.q();
                if (aVar3.f2048c) {
                    aVar3.k();
                    aVar3.f2048c = false;
                }
                w0 w0Var = (w0) aVar3.f2047b;
                w0Var.zzc |= 1;
                w0Var.zzd = intValue2;
                long longValue = this.f.get(Integer.valueOf(intValue2)).longValue();
                if (aVar3.f2048c) {
                    aVar3.k();
                    aVar3.f2048c = false;
                }
                w0 w0Var2 = (w0) aVar3.f2047b;
                w0Var2.zzc |= 2;
                w0Var2.zze = longValue;
                arrayList.add((w0) ((y5) aVar3.m()));
            }
        }
        if (aVar2.f2048c) {
            aVar2.k();
            aVar2.f2048c = false;
        }
        d1 d1Var2 = (d1) aVar2.f2047b;
        f6<w0> f6Var = d1Var2.zze;
        if (!f6Var.a()) {
            d1Var2.zze = y5.l(f6Var);
        }
        o4.i(arrayList, d1Var2.zze);
        if (this.g == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(this.g.size());
            for (Integer next : this.g.keySet()) {
                e1.a aVar4 = (e1.a) e1.zzf.q();
                int intValue3 = next.intValue();
                if (aVar4.f2048c) {
                    aVar4.k();
                    aVar4.f2048c = false;
                }
                e1 e1Var = (e1) aVar4.f2047b;
                e1Var.zzc |= 1;
                e1Var.zzd = intValue3;
                List list2 = this.g.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    if (aVar4.f2048c) {
                        aVar4.k();
                        aVar4.f2048c = false;
                    }
                    e1 e1Var2 = (e1) aVar4.f2047b;
                    g6 g6Var = e1Var2.zze;
                    if (!g6Var.a()) {
                        e1Var2.zze = y5.m(g6Var);
                    }
                    o4.i(list2, e1Var2.zze);
                }
                arrayList2.add((e1) ((y5) aVar4.m()));
            }
            list = arrayList2;
        }
        if (aVar2.f2048c) {
            aVar2.k();
            aVar2.f2048c = false;
        }
        d1 d1Var3 = (d1) aVar2.f2047b;
        f6<e1> f6Var2 = d1Var3.zzf;
        if (!f6Var2.a()) {
            d1Var3.zzf = y5.l(f6Var2);
        }
        o4.i(list, d1Var3.zzf);
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        v0.s((v0) aVar.f2047b, (d1) ((y5) aVar2.m()));
        return (v0) ((y5) aVar.m());
    }

    public final void b(@NonNull ia iaVar) {
        int a2 = iaVar.a();
        Boolean bool = iaVar.f2281c;
        if (bool != null) {
            this.f2159e.set(a2, bool.booleanValue());
        }
        Boolean bool2 = iaVar.f2282d;
        if (bool2 != null) {
            this.f2158d.set(a2, bool2.booleanValue());
        }
        if (iaVar.f2283e != null) {
            Long l = this.f.get(Integer.valueOf(a2));
            long longValue = iaVar.f2283e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f.put(Integer.valueOf(a2), Long.valueOf(longValue));
            }
        }
        if (iaVar.f != null) {
            List list = this.g.get(Integer.valueOf(a2));
            if (list == null) {
                list = new ArrayList();
                this.g.put(Integer.valueOf(a2), list);
            }
            if (iaVar.g()) {
                list.clear();
            }
            if (la.b() && this.h.f2563a.g.t(this.f2155a, q.d0) && iaVar.h()) {
                list.clear();
            }
            if (!la.b() || !this.h.f2563a.g.t(this.f2155a, q.d0)) {
                list.add(Long.valueOf(iaVar.f.longValue() / 1000));
                return;
            }
            long longValue2 = iaVar.f.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    public da(ba baVar, String str, ea eaVar) {
        this.h = baVar;
        this.f2155a = str;
        this.f2156b = true;
        this.f2158d = new BitSet();
        this.f2159e = new BitSet();
        this.f = new ArrayMap();
        this.g = new ArrayMap();
    }
}
