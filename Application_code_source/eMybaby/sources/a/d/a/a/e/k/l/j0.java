package a.d.a.a.e.k.l;

import a.d.a.a.e.k.b;
import a.d.a.a.e.k.l.f;
import a.d.a.a.l.e;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

public abstract class j0<T> extends q {

    /* renamed from: a  reason: collision with root package name */
    public final e<T> f1307a;

    public j0(int i, e<T> eVar) {
        super(i);
        this.f1307a = eVar;
    }

    public void a(@NonNull Status status) {
        this.f1307a.a(new b(status));
    }

    public void c(@NonNull RuntimeException runtimeException) {
        this.f1307a.a(runtimeException);
    }

    public final void e(f.a<?> aVar) {
        try {
            f(aVar);
        } catch (DeadObjectException e2) {
            this.f1307a.a(new b(b0.d(e2)));
            throw e2;
        } catch (RemoteException e3) {
            this.f1307a.a(new b(b0.d(e3)));
        } catch (RuntimeException e4) {
            this.f1307a.a(e4);
        }
    }

    public abstract void f(f.a<?> aVar);
}
