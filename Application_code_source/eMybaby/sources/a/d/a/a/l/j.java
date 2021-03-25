package a.d.a.a.l;

public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f2698a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f2699b;

    public j(i iVar, p pVar) {
        this.f2699b = iVar;
        this.f2698a = pVar;
    }

    public final void run() {
        synchronized (this.f2699b.f2696b) {
            if (this.f2699b.f2697c != null) {
                b bVar = this.f2699b.f2697c;
                synchronized (this.f2698a.f2708a) {
                }
                ((g) bVar).f2691a.countDown();
            }
        }
    }
}
