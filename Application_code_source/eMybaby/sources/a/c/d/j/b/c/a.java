package a.c.d.j.b.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f171a = 1099001;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<WeakReference<Activity>> f172b = new ArrayList<>();

    public static void a(Activity activity) {
        WeakReference weakReference = new WeakReference(activity);
        if (f172b.indexOf(weakReference) == -1) {
            f172b.add(weakReference);
        }
    }
}
