package a.d.a.a.f;

import a.c.a.f.b;
import a.d.a.a.e.g;
import android.content.Context;
import android.os.IBinder;

public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f1457a;

    /* renamed from: b  reason: collision with root package name */
    public T f1458b;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public c(String str) {
        this.f1457a = str;
    }

    public abstract T a(IBinder iBinder);

    public final T b(Context context) {
        if (this.f1458b == null) {
            b.k(context);
            Context c2 = g.c(context);
            if (c2 != null) {
                try {
                    this.f1458b = a((IBinder) c2.getClassLoader().loadClass(this.f1457a).newInstance());
                } catch (ClassNotFoundException e2) {
                    throw new a("Could not load creator class.", e2);
                } catch (InstantiationException e3) {
                    throw new a("Could not instantiate creator.", e3);
                } catch (IllegalAccessException e4) {
                    throw new a("Could not access creator.", e4);
                }
            } else {
                throw new a("Could not get remote context.");
            }
        }
        return this.f1458b;
    }
}
