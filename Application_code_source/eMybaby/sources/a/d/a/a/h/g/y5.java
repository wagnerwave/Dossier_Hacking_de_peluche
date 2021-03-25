package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;
import a.d.a.a.h.g.y5.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class y5<MessageType extends y5<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends o4<MessageType, BuilderType> {
    public static Map<Object, y5<?, ?>> zzd = new ConcurrentHashMap();
    public k8 zzb = k8.f;
    public int zzc = -1;

    public static class a<T extends y5<T, ?>> extends s4<T> {
        public a(T t) {
        }
    }

    public static abstract class b<MessageType extends y5<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends q4<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        public final MessageType f2046a;

        /* renamed from: b  reason: collision with root package name */
        public MessageType f2047b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2048c = false;

        public b(MessageType messagetype) {
            this.f2046a = messagetype;
            this.f2047b = (y5) messagetype.n(4, (Object) null, (Object) null);
        }

        public /* synthetic */ Object clone() {
            b bVar = (b) this.f2046a.n(5, (Object) null, (Object) null);
            bVar.i((y5) l());
            return bVar;
        }

        public final boolean g() {
            return y5.p(this.f2047b, false);
        }

        public final /* synthetic */ i7 h() {
            return this.f2046a;
        }

        public final BuilderType i(MessageType messagetype) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            MessageType messagetype2 = this.f2047b;
            r7.f1920c.b(messagetype2).i(messagetype2, messagetype);
            return this;
        }

        public final b j(byte[] bArr, int i, l5 l5Var) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            try {
                r7.f1920c.b(this.f2047b).g(this.f2047b, bArr, 0, i, new v4(l5Var));
                return this;
            } catch (i6 e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw i6.a();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        public void k() {
            MessageType messagetype = (y5) this.f2047b.n(4, (Object) null, (Object) null);
            r7.f1920c.b(messagetype).i(messagetype, this.f2047b);
            this.f2047b = messagetype;
        }

        public i7 l() {
            if (!this.f2048c) {
                MessageType messagetype = this.f2047b;
                r7.f1920c.b(messagetype).e(messagetype);
                this.f2048c = true;
            }
            return this.f2047b;
        }

        public i7 m() {
            y5 y5Var = (y5) l();
            if (y5Var.g()) {
                return y5Var;
            }
            throw new i8();
        }
    }

    public static final class c implements t5<c> {
        public final int a() {
            throw new NoSuchMethodError();
        }

        public final x8 b() {
            throw new NoSuchMethodError();
        }

        public final a9 c() {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final boolean d() {
            throw new NoSuchMethodError();
        }

        public final boolean e() {
            throw new NoSuchMethodError();
        }

        public final l7 h(l7 l7Var, l7 l7Var2) {
            throw new NoSuchMethodError();
        }

        public final h7 l(h7 h7Var, i7 i7Var) {
            throw new NoSuchMethodError();
        }
    }

    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends y5<MessageType, BuilderType> implements j7 {
        public r5<c> zzc = r5.f1916d;

        public final r5<c> s() {
            r5<c> r5Var = this.zzc;
            if (r5Var.f1918b) {
                this.zzc = (r5) r5Var.clone();
            }
            return this.zzc;
        }
    }

    /* 'enum' modifier removed */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2049a = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) f2049a.clone();
        }
    }

    public static class f<ContainingType extends i7, Type> extends m5<ContainingType, Type> {
    }

    public static <T extends y5<?, ?>> T k(Class<T> cls) {
        T t = (y5) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (y5) zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (y5) ((y5) n8.c(cls)).n(6, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <E> f6<E> l(f6<E> f6Var) {
        int size = f6Var.size();
        return f6Var.f(size == 0 ? 10 : size << 1);
    }

    public static g6 m(g6 g6Var) {
        int size = g6Var.size();
        return ((w6) g6Var).f(size == 0 ? 10 : size << 1);
    }

    public static Object o(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static final <T extends y5<T, ?>> boolean p(T t, boolean z) {
        byte byteValue = ((Byte) t.n(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c2 = r7.f1920c.b(t).c(t);
        if (z) {
            t.n(2, c2 ? t : null, (Object) null);
        }
        return c2;
    }

    public final int c() {
        if (this.zzc == -1) {
            this.zzc = r7.f1920c.b(this).f(this);
        }
        return this.zzc;
    }

    public final /* synthetic */ h7 d() {
        b bVar = (b) n(5, (Object) null, (Object) null);
        bVar.i(this);
        return bVar;
    }

    public final void e(i5 i5Var) {
        v7 b2 = r7.f1920c.b(this);
        k5 k5Var = i5Var.f1738a;
        if (k5Var == null) {
            k5Var = new k5(i5Var);
        }
        b2.h(this, k5Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return r7.f1920c.b(this).d(this, (y5) obj);
        }
        return false;
    }

    public final /* synthetic */ h7 f() {
        return (b) n(5, (Object) null, (Object) null);
    }

    public final boolean g() {
        return p(this, true);
    }

    public final /* synthetic */ i7 h() {
        return (y5) n(6, (Object) null, (Object) null);
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int b2 = r7.f1920c.b(this).b(this);
        this.zza = b2;
        return b2;
    }

    public abstract Object n(int i, Object obj, Object obj2);

    public final <MessageType extends y5<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType q() {
        return (b) n(5, (Object) null, (Object) null);
    }

    public final BuilderType r() {
        BuilderType buildertype = (b) n(5, (Object) null, (Object) null);
        buildertype.i(this);
        return buildertype;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        a.c.a.f.b.k1(this, sb, 0);
        return sb.toString();
    }
}
