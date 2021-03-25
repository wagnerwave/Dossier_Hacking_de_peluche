package a.e.a.a.o;

import android.os.HandlerThread;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, f> f3239a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static HandlerThread f3240b;

    public static f a(String str) {
        f fVar = f3239a.get(str);
        if (fVar != null) {
            return fVar;
        }
        if (f3240b == null) {
            HandlerThread handlerThread = new HandlerThread("b");
            f3240b = handlerThread;
            handlerThread.start();
        }
        c cVar = new c(str, f3240b.getLooper());
        f fVar2 = (f) a.e.a.a.r.b.A(cVar, f.class, cVar);
        f3239a.put(str, fVar2);
        return fVar2;
    }
}
