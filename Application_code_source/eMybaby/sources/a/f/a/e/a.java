package a.f.a.e;

public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3330a = false;

    public void a() {
        throw null;
    }

    public final void run() {
        while (this.f3330a) {
            try {
                a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public synchronized void start() {
        this.f3330a = true;
        super.start();
    }
}
