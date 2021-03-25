package a.d.a.a.c.a.d;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator f1223a = new d();

    public final int compare(Object obj, Object obj2) {
        return GoogleSignInAccount.h((Scope) obj, (Scope) obj2);
    }
}
