package a.g.a.b;

import a.g.a.a.b.c;
import a.g.a.b.b;
import a.g.a.b.l.g;
import a.g.a.b.n.b;
import android.content.Context;
import android.graphics.Bitmap;
import java.util.concurrent.ThreadFactory;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3378a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3379b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3380c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3381d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3382e;
    public final Bitmap.CompressFormat f;
    public final int g;
    public final int h;
    public final boolean i;
    public final g j;
    public final c<String, Bitmap> k;
    public final a.g.a.a.a.a l;
    public final b m;
    public final b n;
    public final ThreadFactory o;
    public final boolean p;
    public final b q = new a.g.a.b.n.c(this.m);
    public final String r = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3383a;

        /* renamed from: b  reason: collision with root package name */
        public int f3384b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f3385c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f3386d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f3387e = 0;
        public Bitmap.CompressFormat f = null;
        public int g = 0;
        public int h = 3;
        public int i = 4;
        public boolean j = false;
        public boolean k = true;
        public g l = g.FIFO;
        public int m = 2097152;
        public int n = 0;
        public int o = 0;
        public c<String, Bitmap> p = null;
        public a.g.a.a.a.a q = null;
        public a.g.a.a.a.d.a r = null;
        public b s = null;
        public b t = null;
        public boolean u = false;

        public a(Context context) {
            this.f3383a = context.getApplicationContext();
        }

        public f a() {
            if (this.q == null) {
                if (this.r == null) {
                    this.r = new a.g.a.a.a.d.b();
                }
                Context context = this.f3383a;
                a.g.a.a.a.d.a aVar = this.r;
                int i2 = this.n;
                int i3 = this.o;
                this.q = i2 > 0 ? new a.g.a.a.a.c.b(a.e.a.a.r.b.z(context), aVar, i2) : i3 > 0 ? new a.g.a.a.a.c.a(a.e.a.a.r.b.z(context), aVar, i3) : new a.g.a.a.a.c.c(a.e.a.a.r.b.s(context), aVar);
            }
            if (this.p == null) {
                int i4 = this.m;
                boolean z = this.j;
                c bVar = new a.g.a.a.b.d.b(i4);
                if (z) {
                    bVar = new a.g.a.a.b.d.a(bVar, new a.g.a.b.l.f());
                }
                this.p = bVar;
            }
            if (this.s == null) {
                this.s = new a.g.a.b.n.a(this.f3383a);
            }
            if (this.t == null) {
                this.t = new b.C0080b().b();
            }
            return new f(this, (e) null);
        }

        public a b(b bVar) {
            this.t = bVar;
            return this;
        }

        public a c(a.g.a.a.a.a aVar) {
            if (this.n > 0) {
                a.e.a.a.r.b.f0("This method's call overlaps discCacheSize() method call", new Object[0]);
            }
            if (this.o > 0) {
                a.e.a.a.r.b.f0("This method's call overlaps discCacheFileCount() method call", new Object[0]);
            }
            if (this.r != null) {
                a.e.a.a.r.b.f0("This method's call overlaps discCacheFileNameGenerator() method call", new Object[0]);
            }
            this.q = aVar;
            return this;
        }

        public a d(c<String, Bitmap> cVar) {
            if (this.m != 2097152) {
                a.e.a.a.r.b.f0("This method's call overlaps memoryCacheSize() method call", new Object[0]);
            }
            this.p = cVar;
            return this;
        }

        public a e(int i2) {
            this.h = i2;
            return this;
        }
    }

    public f(a aVar, e eVar) {
        this.f3378a = aVar.f3383a;
        this.f3379b = aVar.f3384b;
        this.f3380c = aVar.f3385c;
        this.f3381d = aVar.f3386d;
        this.f3382e = aVar.f3387e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.k;
        this.l = aVar.q;
        this.k = aVar.p;
        this.n = aVar.t;
        this.p = aVar.u;
        this.m = aVar.s;
        this.j = aVar.l;
        this.o = new e(this, aVar);
    }
}
