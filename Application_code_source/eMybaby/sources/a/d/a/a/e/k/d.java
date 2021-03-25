package a.d.a.a.e.k;

import a.d.a.a.e.k.a;
import a.d.a.a.e.k.l.e;
import a.d.a.a.e.k.l.k;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
public abstract class d {
    @GuardedBy("sAllClients")

    /* renamed from: a  reason: collision with root package name */
    public static final Set<d> f1263a = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    public interface a extends e {
    }

    @Deprecated
    public interface b extends k {
    }

    public <A extends a.b, T extends a.d.a.a.e.k.l.d<? extends i, A>> T a(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public Looper b() {
        throw new UnsupportedOperationException();
    }
}
