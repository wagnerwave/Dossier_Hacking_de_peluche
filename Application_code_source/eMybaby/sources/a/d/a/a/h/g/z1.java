package a.d.a.a.h.g;

import android.database.ContentObserver;
import android.os.Handler;

public final class z1 extends ContentObserver {
    public z1() {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        c2.j.incrementAndGet();
    }
}
