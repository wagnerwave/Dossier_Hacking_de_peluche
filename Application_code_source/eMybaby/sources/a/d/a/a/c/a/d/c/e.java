package a.d.a.a.c.a.d.c;

import a.d.a.a.e.k.d;
import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class e extends AsyncTaskLoader<Void> {

    /* renamed from: a  reason: collision with root package name */
    public Semaphore f1215a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    public Set<d> f1216b;

    public e(Context context, Set<d> set) {
        super(context);
        this.f1216b = set;
    }

    public final Object loadInBackground() {
        Iterator<d> it = this.f1216b.iterator();
        if (!it.hasNext()) {
            try {
                this.f1215a.tryAcquire(0, 5, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                Log.i("GACSignInLoader", "Unexpected InterruptedException", e2);
                Thread.currentThread().interrupt();
            }
            return null;
        } else if (it.next() != null) {
            throw new UnsupportedOperationException();
        } else {
            throw null;
        }
    }

    public final void onStartLoading() {
        this.f1215a.drainPermits();
        forceLoad();
    }
}
