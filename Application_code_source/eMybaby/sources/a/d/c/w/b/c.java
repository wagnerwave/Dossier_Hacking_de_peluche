package a.d.c.w.b;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c[] f3145a = {new b((a) null), new C0072c((a) null), new d((a) null), new e((a) null), new f((a) null), new g((a) null), new h((a) null), new i((a) null)};

    public static class b extends c {
        public b(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    /* renamed from: a.d.c.w.b.c$c  reason: collision with other inner class name */
    public static class C0072c extends c {
        public C0072c(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            return (i & 1) == 0;
        }
    }

    public static class d extends c {
        public d(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    public static class e extends c {
        public e(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    public static class f extends c {
        public f(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            return (((i2 / 3) + (i >>> 1)) & 1) == 0;
        }
    }

    public static class g extends c {
        public g(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            int i3 = i * i2;
            return (i3 % 3) + (i3 & 1) == 0;
        }
    }

    public static class h extends c {
        public h(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            int i3 = i * i2;
            return (((i3 % 3) + (i3 & 1)) & 1) == 0;
        }
    }

    public static class i extends c {
        public i(a aVar) {
            super((a) null);
        }

        public boolean a(int i, int i2) {
            return ((((i * i2) % 3) + ((i + i2) & 1)) & 1) == 0;
        }
    }

    public c(a aVar) {
    }

    public abstract boolean a(int i2, int i3);
}
