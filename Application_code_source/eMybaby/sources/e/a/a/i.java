package e.a.a;

import e.a.a.l0.c;
import java.lang.reflect.Method;

public class i extends Exception {
    public i(String str) {
        super(str);
    }

    public i(String str, Throwable th) {
        super(str);
        Method method = c.f5185a;
        if (method != null) {
            try {
                method.invoke(this, new Object[]{th});
            } catch (Exception unused) {
            }
        }
    }
}
