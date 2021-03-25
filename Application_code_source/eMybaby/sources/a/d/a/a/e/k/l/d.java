package a.d.a.a.e.k.l;

import a.d.a.a.e.k.a;
import a.d.a.a.e.k.a.b;
import a.d.a.a.e.k.i;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public abstract class d<R extends i, A extends a.b> extends BasePendingResult<R> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(@NonNull a<?> aVar, @NonNull a.d.a.a.e.k.d dVar) {
        super(dVar);
        a.c.a.f.b.l(dVar, "GoogleApiClient must not be null");
        a.c.a.f.b.l(aVar, "Api must not be null");
        if (aVar.f1251b == null) {
            throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
        }
    }

    public abstract void i(@NonNull A a2);

    public final void j(@NonNull Status status) {
        a.c.a.f.b.e(!status.e(), "Failed result must not be success");
        e(b(status));
    }
}
