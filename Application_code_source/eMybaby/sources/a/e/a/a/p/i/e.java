package a.e.a.a.p.i;

import a.e.a.a.b;
import a.e.a.a.d;

public abstract class e extends g {
    public String a() {
        return e.class.getSimpleName();
    }

    public void onInvoke(Object... objArr) {
        String str = objArr[0];
        int intValue = objArr[1].intValue();
        d dVar = (d) this;
        dVar.f3221a.p(true);
        b bVar = dVar.f3221a;
        bVar.p(true);
        for (d invokeSync : bVar.j) {
            invokeSync.invokeSync(str, Integer.valueOf(intValue));
        }
    }
}
