package a.e.a.a.p.i;

import a.e.a.a.b;
import a.e.a.a.c;
import android.content.Context;

public abstract class h extends g {
    public String a() {
        return h.class.getSimpleName();
    }

    public void onInvoke(Object... objArr) {
        objArr[0].intValue();
        int intValue = objArr[1].intValue();
        if (intValue == 10 || intValue == 13) {
            b.s((Context) null).stopSearch();
        }
        c cVar = (c) this;
        cVar.f3220a.p(true);
        b bVar = cVar.f3220a;
        bVar.p(true);
        if (intValue == 10 || intValue == 12) {
            for (a.e.a.a.o.h.b next : bVar.i) {
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(intValue == 12);
                next.invokeSync(objArr2);
            }
        }
    }
}
