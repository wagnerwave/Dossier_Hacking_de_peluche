package a.d.a.a.i.b;

import a.c.a.f.b;
import java.util.Map;

public final class y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2628a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f2629b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f2630c;

    public y0(a aVar, String str, long j) {
        this.f2630c = aVar;
        this.f2628a = str;
        this.f2629b = j;
    }

    public final void run() {
        Object obj;
        Map map;
        a aVar = this.f2630c;
        String str = this.f2628a;
        long j = this.f2629b;
        aVar.b();
        b.h(str);
        if (aVar.f2069c.isEmpty()) {
            aVar.f2070d = j;
        }
        Integer num = aVar.f2069c.get(str);
        if (num != null) {
            map = aVar.f2069c;
            obj = Integer.valueOf(num.intValue() + 1);
        } else if (aVar.f2069c.size() >= 100) {
            aVar.i().i.a("Too many ads visible");
            return;
        } else {
            aVar.f2069c.put(str, 1);
            map = aVar.f2068b;
            obj = Long.valueOf(j);
        }
        map.put(str, obj);
    }
}
