package a.e.a.a.p.i;

import a.e.a.a.b;
import a.e.a.a.e;
import a.e.a.a.o.h.a;
import java.util.List;

public abstract class c extends g {
    public String a() {
        return c.class.getSimpleName();
    }

    public void onInvoke(Object... objArr) {
        String str = objArr[0];
        int intValue = objArr[1].intValue();
        e eVar = (e) this;
        eVar.f3222a.p(true);
        if (intValue == 32) {
            b bVar = eVar.f3222a;
            bVar.p(true);
            bVar.g.remove(str);
        }
        b bVar2 = eVar.f3222a;
        bVar2.p(true);
        List<a> list = bVar2.h.get(str);
        if (!a.c.a.f.b.S(list)) {
            for (a invokeSync : list) {
                invokeSync.invokeSync(str, Integer.valueOf(intValue));
            }
        }
    }
}
