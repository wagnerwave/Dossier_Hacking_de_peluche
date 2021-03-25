package a.d.a.a.c.a.d;

import a.d.a.a.e.g;
import a.d.a.a.e.k.c;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.dynamite.DynamiteModule;

public class a extends c<GoogleSignInOptions> {
    public static int i = 1;

    /* 'enum' modifier removed */
    /* renamed from: a.d.a.a.c.a.d.a$a  reason: collision with other inner class name */
    public static final class C0056a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1205a = {1, 2, 3, 4};
    }

    public a(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, a.d.a.a.c.a.a.f1193e, googleSignInOptions, new a.d.a.a.e.k.l.a());
    }

    public a(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, a.d.a.a.c.a.a.f1193e, googleSignInOptions, new a.d.a.a.e.k.l.a());
    }

    public final synchronized int b() {
        if (i == 1) {
            Context context = this.f1254a;
            a.d.a.a.e.c cVar = a.d.a.a.e.c.f1231d;
            int b2 = cVar.b(context, g.f1241a);
            i = b2 == 0 ? 4 : (cVar.a(context, b2, (String) null) != null || DynamiteModule.a(context, "com.google.android.gms.auth.api.fallback") == 0) ? 2 : 3;
        }
        return i;
    }
}
