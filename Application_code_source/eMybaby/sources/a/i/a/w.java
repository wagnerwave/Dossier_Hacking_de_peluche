package a.i.a;

import a.i.a.t;
import android.graphics.Bitmap;
import android.net.Uri;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class w {
    public static final long s = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    public int f3677a;

    /* renamed from: b  reason: collision with root package name */
    public long f3678b;

    /* renamed from: c  reason: collision with root package name */
    public int f3679c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f3680d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3681e;
    public final String f = null;
    public final List<e0> g = null;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final Bitmap.Config q;
    public final t.e r;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Uri f3682a;

        /* renamed from: b  reason: collision with root package name */
        public int f3683b;

        /* renamed from: c  reason: collision with root package name */
        public int f3684c;

        /* renamed from: d  reason: collision with root package name */
        public int f3685d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f3686e;
        public t.e f;

        public b(Uri uri, int i, Bitmap.Config config) {
            this.f3682a = uri;
            this.f3683b = i;
            this.f3686e = config;
        }

        public b a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f3684c = i;
                this.f3685d = i2;
                return this;
            }
        }
    }

    public w(Uri uri, int i2, String str, List list, int i3, int i4, boolean z, boolean z2, boolean z3, float f2, float f3, float f4, boolean z4, Bitmap.Config config, t.e eVar, a aVar) {
        this.f3680d = uri;
        this.f3681e = i2;
        this.h = i3;
        this.i = i4;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = f2;
        this.n = f3;
        this.o = f4;
        this.p = z4;
        this.q = config;
        this.r = eVar;
    }

    public boolean a() {
        return (this.h == 0 && this.i == 0) ? false : true;
    }

    public String b() {
        StringBuilder sb;
        long nanoTime = System.nanoTime() - this.f3678b;
        if (nanoTime > s) {
            sb.append(d());
            sb.append('+');
            sb.append(TimeUnit.NANOSECONDS.toSeconds(nanoTime));
            sb.append('s');
        } else {
            sb = new StringBuilder();
            sb.append(d());
            sb.append('+');
            sb.append(TimeUnit.NANOSECONDS.toMillis(nanoTime));
            sb.append("ms");
        }
        return sb.toString();
    }

    public boolean c() {
        return a() || this.m != 0.0f;
    }

    public String d() {
        StringBuilder n2 = a.a.a.a.a.n("[R");
        n2.append(this.f3677a);
        n2.append(']');
        return n2.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i2 = this.f3681e;
        if (i2 > 0) {
            sb.append(i2);
        } else {
            sb.append(this.f3680d);
        }
        List<e0> list = this.g;
        if (list != null && !list.isEmpty()) {
            for (e0 b2 : this.g) {
                sb.append(' ');
                sb.append(b2.b());
            }
        }
        if (this.f != null) {
            sb.append(" stableKey(");
            sb.append(this.f);
            sb.append(')');
        }
        if (this.h > 0) {
            sb.append(" resize(");
            sb.append(this.h);
            sb.append(',');
            sb.append(this.i);
            sb.append(')');
        }
        if (this.j) {
            sb.append(" centerCrop");
        }
        if (this.k) {
            sb.append(" centerInside");
        }
        if (this.m != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.m);
            if (this.p) {
                sb.append(" @ ");
                sb.append(this.n);
                sb.append(',');
                sb.append(this.o);
            }
            sb.append(')');
        }
        if (this.q != null) {
            sb.append(' ');
            sb.append(this.q);
        }
        sb.append('}');
        return sb.toString();
    }
}
