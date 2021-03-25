package a.d.a.a.e.m;

import a.d.a.a.f.b;
import a.d.a.a.f.c;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.internal.SignInButtonConfig;

public final class q extends c<n> {

    /* renamed from: c  reason: collision with root package name */
    public static final q f1408c = new q();

    public q() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View c(Context context, int i, int i2) {
        q qVar = f1408c;
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2);
            return (View) b.h(((n) qVar.b(context)).O(new b(context), signInButtonConfig));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i);
            sb.append(" and color ");
            sb.append(i2);
            throw new c.a(sb.toString(), e2);
        }
    }

    public final Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof n ? (n) queryLocalInterface : new y(iBinder);
    }
}
