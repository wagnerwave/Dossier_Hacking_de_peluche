package a.d.a.a.h.g;

public final class t4 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f1945a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f1946b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f1945a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f1946b = cls2 != null;
    }

    public static boolean a() {
        return f1945a != null && !f1946b;
    }
}
