package a.g.a.b;

import a.g.a.b.l.d;
import a.g.a.b.m.c;
import android.graphics.Bitmap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f3358a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3359b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3360c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3361d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3362e;
    public final boolean f;
    public final boolean g;
    public final d h;
    public final Bitmap.Config i;
    public final int j;
    public final Object k;
    public final a.g.a.b.o.a l;
    public final a.g.a.b.o.a m;
    public final a.g.a.b.m.a n;
    public boolean o;

    /* renamed from: a.g.a.b.b$b  reason: collision with other inner class name */
    public static class C0080b {

        /* renamed from: a  reason: collision with root package name */
        public int f3363a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f3364b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f3365c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f3366d = 0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3367e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public d i = d.IN_SAMPLE_POWER_OF_2;
        public Bitmap.Config j = Bitmap.Config.ARGB_8888;
        public int k = 0;
        public Object l = null;
        public a.g.a.b.o.a m = null;
        public a.g.a.b.o.a n = null;
        public a.g.a.b.m.a o = new c();

        public C0080b a(Bitmap.Config config) {
            this.j = config;
            return this;
        }

        public b b() {
            return new b(this, (a) null);
        }

        public C0080b c() {
            this.f = true;
            return this;
        }

        public C0080b d() {
            this.g = true;
            return this;
        }

        public C0080b e(d dVar) {
            this.i = dVar;
            return this;
        }

        public C0080b f(int i2) {
            this.f3365c = i2;
            return this;
        }

        public C0080b g(int i2) {
            this.f3366d = i2;
            return this;
        }
    }

    public b(C0080b bVar, a aVar) {
        this.f3358a = bVar.f3363a;
        this.f3359b = bVar.f3364b;
        this.f3360c = bVar.f3365c;
        this.f3361d = bVar.f3366d;
        this.f3362e = bVar.f3367e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.i;
        this.i = bVar.j;
        this.j = bVar.k;
        this.k = bVar.l;
        this.l = bVar.m;
        this.m = bVar.n;
        this.n = bVar.o;
        this.o = bVar.h;
    }
}
