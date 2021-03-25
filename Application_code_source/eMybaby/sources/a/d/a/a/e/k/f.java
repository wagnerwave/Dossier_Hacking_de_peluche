package a.d.a.a.e.k;

import a.d.a.a.e.k.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class f<R extends i> extends BasePendingResult<R> {
    public final R m;

    public f(d dVar, R r) {
        super(dVar);
        this.m = r;
    }

    public final R b(Status status) {
        return this.m;
    }
}
