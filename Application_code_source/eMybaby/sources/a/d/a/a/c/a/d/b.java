package a.d.a.a.c.a.d;

import a.d.a.a.e.k.i;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public class b implements i {

    /* renamed from: a  reason: collision with root package name */
    public Status f1206a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public GoogleSignInAccount f1207b;

    public b(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.f1207b = googleSignInAccount;
        this.f1206a = status;
    }

    @NonNull
    public Status getStatus() {
        return this.f1206a;
    }
}
