package a.e.a.a;

import android.content.Context;

public class i {

    /* renamed from: b  reason: collision with root package name */
    public static volatile i f3229b;

    /* renamed from: a  reason: collision with root package name */
    public Context f3230a;

    public static i a() {
        if (f3229b == null) {
            synchronized (i.class) {
                if (f3229b == null) {
                    f3229b = new i();
                }
            }
        }
        return f3229b;
    }
}
