package a.d.a.a.h.f;

import android.database.sqlite.SQLiteException;

public final class u extends d0 {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f1565e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(s sVar, h hVar) {
        super(hVar);
        this.f1565e = sVar;
    }

    public final void c() {
        s sVar = this.f1565e;
        if (sVar != null) {
            try {
                sVar.f1555d.B();
                sVar.z();
            } catch (SQLiteException e2) {
                sVar.l("Failed to delete stale hits", e2);
            }
            sVar.j.e(86400000);
            return;
        }
        throw null;
    }
}
