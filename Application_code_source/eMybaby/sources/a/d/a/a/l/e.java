package a.d.a.a.l;

import a.c.a.f.b;
import androidx.annotation.NonNull;

public class e<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final p<TResult> f2689a = new p<>();

    public boolean a(@NonNull Exception exc) {
        p<TResult> pVar = this.f2689a;
        if (pVar != null) {
            b.l(exc, "Exception must not be null");
            synchronized (pVar.f2708a) {
                if (pVar.f2710c) {
                    return false;
                }
                pVar.f2710c = true;
                pVar.f2712e = exc;
                pVar.f2709b.b(pVar);
                return true;
            }
        }
        throw null;
    }

    public boolean b(TResult tresult) {
        boolean z;
        p<TResult> pVar = this.f2689a;
        synchronized (pVar.f2708a) {
            z = true;
            if (pVar.f2710c) {
                z = false;
            } else {
                pVar.f2710c = true;
                pVar.f2711d = tresult;
                pVar.f2709b.b(pVar);
            }
        }
        return z;
    }
}
