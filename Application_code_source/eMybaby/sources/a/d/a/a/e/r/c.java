package a.d.a.a.e.r;

import android.content.Context;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f1444b = new c();

    /* renamed from: a  reason: collision with root package name */
    public b f1445a = null;

    public static b a(Context context) {
        b bVar;
        c cVar = f1444b;
        synchronized (cVar) {
            if (cVar.f1445a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                cVar.f1445a = new b(context);
            }
            bVar = cVar.f1445a;
        }
        return bVar;
    }
}
