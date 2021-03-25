package a.e.a.a.p;

import a.c.a.f.b;
import a.e.a.a.p.i.g;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.List;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public h f3259a;

    public a(h hVar) {
        this.f3259a = hVar;
        b.E();
        new Handler(Looper.getMainLooper());
    }

    public abstract List<String> a();

    public List<g> b(Class<?> cls) {
        List<g> list = e.this.f3264a.get(cls.getSimpleName());
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public abstract boolean c(Context context, Intent intent);
}
