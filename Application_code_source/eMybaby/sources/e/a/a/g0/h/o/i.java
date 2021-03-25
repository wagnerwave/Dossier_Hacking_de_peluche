package e.a.a.g0.h.o;

import a.a.a.a.a;
import java.util.Date;
import java.util.concurrent.locks.Condition;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final Condition f5056a;

    /* renamed from: b  reason: collision with root package name */
    public Thread f5057b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5058c;

    public i(Condition condition, g gVar) {
        if (condition != null) {
            this.f5056a = condition;
            return;
        }
        throw new IllegalArgumentException("Condition must not be null.");
    }

    public boolean a(Date date) {
        boolean z;
        if (this.f5057b != null) {
            StringBuilder n = a.n("A thread is already waiting on this object.\ncaller: ");
            n.append(Thread.currentThread());
            n.append("\nwaiter: ");
            n.append(this.f5057b);
            throw new IllegalStateException(n.toString());
        } else if (!this.f5058c) {
            this.f5057b = Thread.currentThread();
            if (date != null) {
                try {
                    z = this.f5056a.awaitUntil(date);
                } catch (Throwable th) {
                    this.f5057b = null;
                    throw th;
                }
            } else {
                this.f5056a.await();
                z = true;
            }
            if (!this.f5058c) {
                this.f5057b = null;
                return z;
            }
            throw new InterruptedException("Operation interrupted");
        } else {
            throw new InterruptedException("Operation interrupted");
        }
    }
}
