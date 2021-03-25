package e.a.a.l0;

import java.lang.reflect.Method;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f5185a;

    /* renamed from: b  reason: collision with root package name */
    public static /* synthetic */ Class f5186b;

    static {
        Method method;
        Class<?> cls;
        Class<?> cls2;
        try {
            Class[] clsArr = new Class[1];
            if (f5186b == null) {
                cls = Class.forName("java.lang.Throwable");
                f5186b = cls;
            } else {
                cls = f5186b;
            }
            clsArr[0] = cls;
            if (f5186b == null) {
                cls2 = Class.forName("java.lang.Throwable");
                f5186b = cls2;
            } else {
                cls2 = f5186b;
            }
            method = cls2.getMethod("initCause", clsArr);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        } catch (ClassNotFoundException e3) {
            throw new NoClassDefFoundError(e3.getMessage());
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        f5185a = method;
    }
}
