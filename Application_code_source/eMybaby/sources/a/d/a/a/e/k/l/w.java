package a.d.a.a.e.k.l;

import a.d.a.a.e.k.a;
import a.d.a.a.e.k.a.d;
import a.d.a.a.e.k.c;
import a.d.a.a.e.k.i;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class w<O extends a.d> extends p {

    /* renamed from: b  reason: collision with root package name */
    public final c<O> f1342b;

    public w(c<O> cVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f1342b = cVar;
    }

    public final <A extends a.b, T extends d<? extends i, A>> T a(@NonNull T t) {
        c<O> cVar = this.f1342b;
        if (cVar != null) {
            t.k = t.k || BasePendingResult.l.get().booleanValue();
            f fVar = cVar.h;
            i0 i0Var = new i0(1, t);
            Handler handler = fVar.m;
            handler.sendMessage(handler.obtainMessage(4, new z(i0Var, fVar.h.get(), cVar)));
            return t;
        }
        throw null;
    }

    public final Looper b() {
        return this.f1342b.f1258e;
    }
}
