package a.c.d.q;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f775a;

    public c(b bVar) {
        this.f775a = bVar;
    }

    public void run() {
        b bVar = this.f775a;
        if (bVar.i != null) {
            if (bVar.j) {
                bVar.e();
            }
            this.f775a.i.close();
            this.f775a.i = null;
        }
    }
}
