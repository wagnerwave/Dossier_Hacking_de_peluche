package a.d.a.a.i.b;

import a.c.a.f.b;

public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2611a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f2612b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f2613c;

    public x(a aVar, String str, long j) {
        this.f2613c = aVar;
        this.f2611a = str;
        this.f2612b = j;
    }

    public final void run() {
        a aVar = this.f2613c;
        String str = this.f2611a;
        long j = this.f2612b;
        aVar.b();
        b.h(str);
        Integer num = aVar.f2069c.get(str);
        if (num != null) {
            m7 y = aVar.r().y(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                aVar.f2069c.remove(str);
                Long l = aVar.f2068b.get(str);
                if (l == null) {
                    aVar.i().f.a("First ad unit exposure time was never set");
                } else {
                    aVar.f2068b.remove(str);
                    aVar.x(str, j - l.longValue(), y);
                }
                if (aVar.f2069c.isEmpty()) {
                    long j2 = aVar.f2070d;
                    if (j2 == 0) {
                        aVar.i().f.a("First ad exposure time was never set");
                        return;
                    }
                    aVar.v(j - j2, y);
                    aVar.f2070d = 0;
                    return;
                }
                return;
            }
            aVar.f2069c.put(str, Integer.valueOf(intValue));
            return;
        }
        aVar.i().f.b("Call to endAdUnitExposure for unknown ad unit id", str);
    }
}
