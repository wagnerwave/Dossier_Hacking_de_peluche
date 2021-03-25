package a.c.a.f;

import a.a.a.a.a;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f40a = "APP_TAG";

    public static void a(Object obj, String str) {
        if (str != null) {
            String str2 = f40a;
            StringBuilder n = a.n("[");
            n.append(obj.getClass().getSimpleName());
            n.append("] ");
            n.append(str);
            Log.d(str2, n.toString());
        }
    }

    public static void b(String str) {
        if (str != null) {
            Log.d(f40a, str);
        }
    }

    public static void c(String str) {
        if (str != null) {
            Log.e(f40a, str);
        }
    }

    public static void d(Throwable th) {
        String str = f40a;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        Log.e(str, stringWriter.toString());
    }

    public static void e(String str) {
        if (str != null) {
            Log.w(f40a, str);
        }
    }
}
