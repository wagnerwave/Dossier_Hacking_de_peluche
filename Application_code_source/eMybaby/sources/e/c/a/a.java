package e.c.a;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final i f5358a = new i();

    /* renamed from: b  reason: collision with root package name */
    public final c f5359b;

    public a(c cVar) {
        this.f5359b = cVar;
    }

    public void run() {
        h a2 = this.f5358a.a();
        if (a2 != null) {
            this.f5359b.b(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
