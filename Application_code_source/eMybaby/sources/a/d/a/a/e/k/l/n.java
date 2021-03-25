package a.d.a.a.e.k.l;

import android.os.Handler;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;

public class n extends m0 {
    public final ArraySet<b<?>> f = new ArraySet<>();
    public f g;

    public n(i iVar) {
        super(iVar);
        this.f4216a.b("ConnectionlessLifecycleHelper", this);
    }

    public void e() {
        if (!this.f.isEmpty()) {
            this.g.a(this);
        }
    }

    public void g() {
        this.f1311b = true;
        if (!this.f.isEmpty()) {
            this.g.a(this);
        }
    }

    public void h() {
        this.f1311b = false;
        f fVar = this.g;
        if (fVar != null) {
            synchronized (f.p) {
                if (fVar.j == this) {
                    fVar.j = null;
                    fVar.k.clear();
                }
            }
            return;
        }
        throw null;
    }

    public final void i(ConnectionResult connectionResult, int i) {
        f fVar = this.g;
        if (!fVar.d(connectionResult, i)) {
            Handler handler = fVar.m;
            handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
        }
    }
}
