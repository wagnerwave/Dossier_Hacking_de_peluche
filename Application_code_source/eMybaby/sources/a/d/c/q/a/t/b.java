package a.d.c.q.a.t;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import java.util.Collection;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2952a;

    /* renamed from: b  reason: collision with root package name */
    public Point f2953b;

    /* renamed from: c  reason: collision with root package name */
    public Point f2954c;

    public b(Context context) {
        this.f2952a = context;
    }

    public static String a(Collection<String> collection, String... strArr) {
        String str;
        Log.i("CameraConfiguration", "Supported values: " + collection);
        if (collection != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                str = strArr[i];
                if (collection.contains(str)) {
                    break;
                }
                i++;
            }
        }
        str = null;
        Log.i("CameraConfiguration", "Settable value: " + str);
        return str;
    }
}
