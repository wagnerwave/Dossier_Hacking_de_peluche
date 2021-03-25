package e.a.a.g0.h.o;

import androidx.recyclerview.widget.RecyclerView;
import e.a.a.d0.l.a;
import e.a.a.g0.h.f;
import java.util.concurrent.TimeUnit;

public class b extends e.a.a.g0.h.b {
    public final long f;
    public long g;
    public long h;
    public long i;

    public b(f fVar, a aVar, long j, TimeUnit timeUnit) {
        super(fVar, aVar);
        if (aVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f = currentTimeMillis;
            if (j > 0) {
                this.h = timeUnit.toMillis(j) + currentTimeMillis;
            } else {
                this.h = RecyclerView.FOREVER_NS;
            }
            this.i = this.h;
            return;
        }
        throw new IllegalArgumentException("HTTP route may not be null");
    }

    public void a() {
        super.a();
    }
}
