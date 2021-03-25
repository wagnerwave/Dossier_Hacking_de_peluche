package a.d.a.a.h.g;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class n8 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f1846a = Logger.getLogger(n8.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final Unsafe f1847b = k();

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f1848c = t4.f1945a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f1849d = p(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f1850e = p(Integer.TYPE);
    public static final d f;
    public static final boolean g;
    public static final boolean h;
    public static final long i = ((long) h(byte[].class));
    public static final boolean j = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            if (n8.j) {
                return n8.t(obj, j);
            }
            return n8.u(obj, j);
        }

        public final void b(Object obj, long j, byte b2) {
            if (n8.j) {
                n8.l(obj, j, b2);
            } else {
                n8.o(obj, j, b2);
            }
        }

        public final void c(Object obj, long j, double d2) {
            f(obj, j, Double.doubleToLongBits(d2));
        }

        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        public final void g(Object obj, long j, boolean z) {
            if (n8.j) {
                n8.l(obj, j, z ? (byte) 1 : 0);
            } else {
                n8.o(obj, j, z ? (byte) 1 : 0);
            }
        }

        public final boolean h(Object obj, long j) {
            if (n8.j) {
                return n8.t(obj, j) != 0;
            }
            if (n8.u(obj, j) != 0) {
                return true;
            }
            return false;
        }

        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            return this.f1851a.getByte(obj, j);
        }

        public final void b(Object obj, long j, byte b2) {
            this.f1851a.putByte(obj, j, b2);
        }

        public final void c(Object obj, long j, double d2) {
            this.f1851a.putDouble(obj, j, d2);
        }

        public final void d(Object obj, long j, float f) {
            this.f1851a.putFloat(obj, j, f);
        }

        public final void g(Object obj, long j, boolean z) {
            this.f1851a.putBoolean(obj, j, z);
        }

        public final boolean h(Object obj, long j) {
            return this.f1851a.getBoolean(obj, j);
        }

        public final float i(Object obj, long j) {
            return this.f1851a.getFloat(obj, j);
        }

        public final double j(Object obj, long j) {
            return this.f1851a.getDouble(obj, j);
        }
    }

    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            if (n8.j) {
                return n8.t(obj, j);
            }
            return n8.u(obj, j);
        }

        public final void b(Object obj, long j, byte b2) {
            if (n8.j) {
                n8.l(obj, j, b2);
            } else {
                n8.o(obj, j, b2);
            }
        }

        public final void c(Object obj, long j, double d2) {
            f(obj, j, Double.doubleToLongBits(d2));
        }

        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        public final void g(Object obj, long j, boolean z) {
            if (n8.j) {
                n8.l(obj, j, z ? (byte) 1 : 0);
            } else {
                n8.o(obj, j, z ? (byte) 1 : 0);
            }
        }

        public final boolean h(Object obj, long j) {
            if (n8.j) {
                return n8.t(obj, j) != 0;
            }
            if (n8.u(obj, j) != 0) {
                return true;
            }
            return false;
        }

        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f1851a;

        public d(Unsafe unsafe) {
            this.f1851a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void b(Object obj, long j, byte b2);

        public abstract void c(Object obj, long j, double d2);

        public abstract void d(Object obj, long j, float f);

        public final void e(Object obj, long j, int i) {
            this.f1851a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.f1851a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract boolean h(Object obj, long j);

        public abstract float i(Object obj, long j);

        public abstract double j(Object obj, long j);

        public final int k(Object obj, long j) {
            return this.f1851a.getInt(obj, j);
        }

        public final long l(Object obj, long j) {
            return this.f1851a.getLong(obj, j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x016a A[SYNTHETIC, Splitter:B:41:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02e9  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            java.lang.Class<double[]> r2 = double[].class
            java.lang.Class<float[]> r3 = float[].class
            java.lang.Class<long[]> r4 = long[].class
            java.lang.Class<int[]> r5 = int[].class
            java.lang.Class<boolean[]> r6 = boolean[].class
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            java.lang.Class<a.d.a.a.h.g.n8> r0 = a.d.a.a.h.g.n8.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f1846a = r0
            sun.misc.Unsafe r0 = k()
            f1847b = r0
            java.lang.Class<?> r0 = a.d.a.a.h.g.t4.f1945a
            f1848c = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = p(r0)
            f1849d = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = p(r0)
            f1850e = r0
            sun.misc.Unsafe r0 = f1847b
            r8 = 0
            if (r0 != 0) goto L_0x003a
            goto L_0x005f
        L_0x003a:
            boolean r0 = a.d.a.a.h.g.t4.a()
            if (r0 == 0) goto L_0x0058
            boolean r0 = f1849d
            if (r0 == 0) goto L_0x004c
            a.d.a.a.h.g.n8$c r8 = new a.d.a.a.h.g.n8$c
            sun.misc.Unsafe r0 = f1847b
            r8.<init>(r0)
            goto L_0x005f
        L_0x004c:
            boolean r0 = f1850e
            if (r0 == 0) goto L_0x005f
            a.d.a.a.h.g.n8$a r8 = new a.d.a.a.h.g.n8$a
            sun.misc.Unsafe r0 = f1847b
            r8.<init>(r0)
            goto L_0x005f
        L_0x0058:
            a.d.a.a.h.g.n8$b r8 = new a.d.a.a.h.g.n8$b
            sun.misc.Unsafe r0 = f1847b
            r8.<init>(r0)
        L_0x005f:
            f = r8
            java.lang.String r0 = "copyMemory"
            sun.misc.Unsafe r8 = f1847b
            java.lang.String r10 = "putLong"
            java.lang.String r11 = "putInt"
            java.lang.String r12 = "getInt"
            java.lang.String r13 = "putByte"
            java.lang.String r14 = "getByte"
            java.lang.String r9 = "com.google.protobuf.UnsafeUtil"
            java.lang.String r15 = "platform method missing - proto runtime falling back to safer methods: "
            r16 = r1
            java.lang.String r1 = "objectFieldOffset"
            r17 = r2
            java.lang.String r2 = "getLong"
            r18 = r3
            r3 = 1
            r19 = 0
            if (r8 != 0) goto L_0x0089
            r20 = r4
        L_0x0084:
            r22 = r5
        L_0x0086:
            r0 = 0
            goto L_0x015f
        L_0x0089:
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0136 }
            r20 = r4
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0134 }
            java.lang.Class<java.lang.reflect.Field> r21 = java.lang.reflect.Field.class
            r4[r19] = r21     // Catch:{ all -> 0x0134 }
            r8.getMethod(r1, r4)     // Catch:{ all -> 0x0134 }
            r4 = 2
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ all -> 0x0134 }
            r3[r19] = r7     // Catch:{ all -> 0x0134 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0134 }
            r21 = 1
            r3[r21] = r4     // Catch:{ all -> 0x0134 }
            r8.getMethod(r2, r3)     // Catch:{ all -> 0x0134 }
            java.lang.reflect.Field r3 = s()     // Catch:{ all -> 0x0134 }
            if (r3 != 0) goto L_0x00ad
            goto L_0x0084
        L_0x00ad:
            boolean r3 = a.d.a.a.h.g.t4.a()     // Catch:{ all -> 0x0134 }
            if (r3 == 0) goto L_0x00b8
            r22 = r5
        L_0x00b5:
            r0 = 1
            goto L_0x015f
        L_0x00b8:
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0134 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0134 }
            r4[r19] = r3     // Catch:{ all -> 0x0134 }
            r8.getMethod(r14, r4)     // Catch:{ all -> 0x0134 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0134 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0134 }
            r4[r19] = r3     // Catch:{ all -> 0x0134 }
            java.lang.Class r3 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0134 }
            r22 = r5
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0132 }
            r8.getMethod(r13, r4)     // Catch:{ all -> 0x0132 }
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ all -> 0x0132 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r3[r19] = r4     // Catch:{ all -> 0x0132 }
            r8.getMethod(r12, r3)     // Catch:{ all -> 0x0132 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0132 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r4[r19] = r3     // Catch:{ all -> 0x0132 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0132 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0132 }
            r8.getMethod(r11, r4)     // Catch:{ all -> 0x0132 }
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ all -> 0x0132 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r3[r19] = r4     // Catch:{ all -> 0x0132 }
            r8.getMethod(r2, r3)     // Catch:{ all -> 0x0132 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0132 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r4[r19] = r3     // Catch:{ all -> 0x0132 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0132 }
            r8.getMethod(r10, r4)     // Catch:{ all -> 0x0132 }
            r3 = 3
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0132 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r4[r19] = r3     // Catch:{ all -> 0x0132 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0132 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r5 = 2
            r4[r5] = r3     // Catch:{ all -> 0x0132 }
            r8.getMethod(r0, r4)     // Catch:{ all -> 0x0132 }
            r3 = 5
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ all -> 0x0132 }
            r3[r19] = r7     // Catch:{ all -> 0x0132 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x0132 }
            r4 = 2
            r3[r4] = r7     // Catch:{ all -> 0x0132 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r5 = 3
            r3[r5] = r4     // Catch:{ all -> 0x0132 }
            r4 = 4
            java.lang.Class r5 = java.lang.Long.TYPE     // Catch:{ all -> 0x0132 }
            r3[r4] = r5     // Catch:{ all -> 0x0132 }
            r8.getMethod(r0, r3)     // Catch:{ all -> 0x0132 }
            goto L_0x00b5
        L_0x0132:
            r0 = move-exception
            goto L_0x013b
        L_0x0134:
            r0 = move-exception
            goto L_0x0139
        L_0x0136:
            r0 = move-exception
            r20 = r4
        L_0x0139:
            r22 = r5
        L_0x013b:
            java.util.logging.Logger r3 = f1846a
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r0.length()
            int r5 = r5 + 71
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            r8.append(r15)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            java.lang.String r5 = "supportsUnsafeByteBufferOperations"
            r3.logp(r4, r9, r5, r0)
            goto L_0x0086
        L_0x015f:
            g = r0
            sun.misc.Unsafe r0 = f1847b
            if (r0 != 0) goto L_0x016a
            r0 = 0
        L_0x0166:
            r21 = 1
            goto L_0x02a0
        L_0x016a:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x027a }
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x027a }
            java.lang.Class<java.lang.reflect.Field> r5 = java.lang.reflect.Field.class
            r4[r19] = r5     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r4)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "arrayBaseOffset"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x027a }
            java.lang.Class<java.lang.Class> r5 = java.lang.Class.class
            r4[r19] = r5     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r4)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "arrayIndexScale"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x027a }
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            r4[r19] = r3     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r4)     // Catch:{ all -> 0x027a }
            r1 = 2
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x027a }
            r3[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r3[r4] = r1     // Catch:{ all -> 0x027a }
            r0.getMethod(r12, r3)     // Catch:{ all -> 0x027a }
            r1 = 3
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x027a }
            r3[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r3[r4] = r1     // Catch:{ all -> 0x027a }
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x027a }
            r4 = 2
            r3[r4] = r1     // Catch:{ all -> 0x027a }
            r0.getMethod(r11, r3)     // Catch:{ all -> 0x027a }
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch:{ all -> 0x027a }
            r1[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r1[r4] = r3     // Catch:{ all -> 0x027a }
            r0.getMethod(r2, r1)     // Catch:{ all -> 0x027a }
            r1 = 3
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ all -> 0x027a }
            r2[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r2[r4] = r1     // Catch:{ all -> 0x027a }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r3 = 2
            r2[r3] = r1     // Catch:{ all -> 0x027a }
            r0.getMethod(r10, r2)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "getObject"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ all -> 0x027a }
            r2[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "putObject"
            r2 = 3
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x027a }
            r3[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x027a }
            r2 = 2
            r3[r2] = r7     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r3)     // Catch:{ all -> 0x027a }
            boolean r1 = a.d.a.a.h.g.t4.a()     // Catch:{ all -> 0x027a }
            if (r1 == 0) goto L_0x01f2
            r0 = 1
            goto L_0x0166
        L_0x01f2:
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ all -> 0x027a }
            r1[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r3 = 1
            r1[r3] = r2     // Catch:{ all -> 0x027a }
            r0.getMethod(r14, r1)     // Catch:{ all -> 0x027a }
            r1 = 3
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ all -> 0x027a }
            r2[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r2[r3] = r1     // Catch:{ all -> 0x027a }
            java.lang.Class r1 = java.lang.Byte.TYPE     // Catch:{ all -> 0x027a }
            r3 = 2
            r2[r3] = r1     // Catch:{ all -> 0x027a }
            r0.getMethod(r13, r2)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "getBoolean"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ all -> 0x027a }
            r2[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "putBoolean"
            r2 = 3
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x027a }
            r3[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x027a }
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x027a }
            r4 = 2
            r3[r4] = r2     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r3)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "getFloat"
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ all -> 0x027a }
            r2[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "putFloat"
            r2 = 3
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x027a }
            r3[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x027a }
            java.lang.Class r2 = java.lang.Float.TYPE     // Catch:{ all -> 0x027a }
            r4 = 2
            r3[r4] = r2     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r3)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "getDouble"
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ all -> 0x027a }
            r2[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x027a }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x027a }
            java.lang.String r1 = "putDouble"
            r2 = 3
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ all -> 0x027a }
            r2[r19] = r7     // Catch:{ all -> 0x027a }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x027a }
            r21 = 1
            r2[r21] = r3     // Catch:{ all -> 0x0278 }
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ all -> 0x0278 }
            r4 = 2
            r2[r4] = r3     // Catch:{ all -> 0x0278 }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x0278 }
            r0 = 1
            goto L_0x02a0
        L_0x0278:
            r0 = move-exception
            goto L_0x027d
        L_0x027a:
            r0 = move-exception
            r21 = 1
        L_0x027d:
            java.util.logging.Logger r1 = f1846a
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r3 = r0.length()
            int r3 = r3 + 71
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r15)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r3 = "supportsUnsafeArrayOperations"
            r1.logp(r2, r9, r3, r0)
            r0 = 0
        L_0x02a0:
            h = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = h(r0)
            long r0 = (long) r0
            i = r0
            h(r6)
            j(r6)
            h(r22)
            j(r22)
            h(r20)
            j(r20)
            h(r18)
            j(r18)
            h(r17)
            j(r17)
            h(r16)
            j(r16)
            java.lang.reflect.Field r0 = s()
            if (r0 == 0) goto L_0x02df
            a.d.a.a.h.g.n8$d r1 = f
            if (r1 != 0) goto L_0x02da
            goto L_0x02df
        L_0x02da:
            sun.misc.Unsafe r1 = r1.f1851a
            r1.objectFieldOffset(r0)
        L_0x02df:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x02e9
            r3 = 1
            goto L_0x02ea
        L_0x02e9:
            r3 = 0
        L_0x02ea:
            j = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.n8.<clinit>():void");
    }

    public static byte a(byte[] bArr, long j2) {
        return f.a(bArr, i + j2);
    }

    public static int b(Object obj, long j2) {
        return f.k(obj, j2);
    }

    public static <T> T c(Class<T> cls) {
        try {
            return f1847b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void d(Object obj, long j2, double d2) {
        f.c(obj, j2, d2);
    }

    public static void e(Object obj, long j2, long j3) {
        f.f(obj, j2, j3);
    }

    public static void f(Object obj, long j2, Object obj2) {
        f.f1851a.putObject(obj, j2, obj2);
    }

    public static void g(byte[] bArr, long j2, byte b2) {
        f.b(bArr, i + j2, b2);
    }

    public static int h(Class<?> cls) {
        if (h) {
            return f.f1851a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static long i(Object obj, long j2) {
        return f.l(obj, j2);
    }

    public static int j(Class<?> cls) {
        if (h) {
            return f.f1851a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Unsafe k() {
        try {
            return (Unsafe) AccessController.doPrivileged(new p8());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void l(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = ((((int) j2) ^ -1) & 3) << 3;
        d dVar = f;
        dVar.e(obj, j3, ((255 & b2) << i2) | (b(obj, j3) & ((255 << i2) ^ -1)));
    }

    public static boolean m(Object obj, long j2) {
        return f.h(obj, j2);
    }

    public static float n(Object obj, long j2) {
        return f.i(obj, j2);
    }

    public static void o(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        d dVar = f;
        dVar.e(obj, j3, ((255 & b2) << i2) | (b(obj, j3) & ((255 << i2) ^ -1)));
    }

    public static boolean p(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!t4.a()) {
            return false;
        }
        try {
            Class<?> cls3 = f1848c;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static double q(Object obj, long j2) {
        return f.j(obj, j2);
    }

    public static Object r(Object obj, long j2) {
        return f.f1851a.getObject(obj, j2);
    }

    public static Field s() {
        Field field;
        Field field2;
        if (t4.a()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static byte t(Object obj, long j2) {
        return (byte) (b(obj, -4 & j2) >>> ((int) (((j2 ^ -1) & 3) << 3)));
    }

    public static byte u(Object obj, long j2) {
        return (byte) (b(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }
}
