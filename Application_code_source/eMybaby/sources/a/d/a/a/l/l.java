package a.d.a.a.l;

public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f2703a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f2704b;

    public l(k kVar, p pVar) {
        this.f2704b = kVar;
        this.f2703a = pVar;
    }

    public final void run() {
        synchronized (this.f2704b.f2701b) {
            if (this.f2704b.f2702c != null) {
                c<? super TResult> cVar = this.f2704b.f2702c;
                this.f2703a.a();
                ((g) cVar).f2691a.countDown();
            }
        }
    }
}
