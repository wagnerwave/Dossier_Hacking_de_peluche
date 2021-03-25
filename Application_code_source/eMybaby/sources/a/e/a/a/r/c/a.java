package a.e.a.a.r.c;

import a.c.a.f.b;
import java.lang.reflect.Method;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Object f3296a;

    /* renamed from: b  reason: collision with root package name */
    public Method f3297b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f3298c;

    public a(Object obj, Method method, Object[] objArr) {
        this.f3296a = obj;
        this.f3297b = method;
        this.f3298c = objArr;
    }

    public static Object a(Object obj) {
        a aVar = (a) obj;
        if (aVar != null) {
            try {
                return aVar.f3297b.invoke(aVar.f3296a, aVar.f3298c);
            } catch (Throwable th) {
                b.z(th);
                return null;
            }
        } else {
            throw null;
        }
    }
}
