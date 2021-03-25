package a.d.a.a.i.b;

public final class w5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2590a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2591b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2592c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f2593d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d5 f2594e;

    public w5(d5 d5Var, String str, String str2, String str3, long j) {
        this.f2594e = d5Var;
        this.f2590a = str;
        this.f2591b = str2;
        this.f2592c = str3;
        this.f2593d = j;
    }

    public final void run() {
        if (this.f2590a == null) {
            this.f2594e.f2148a.j.w().F(this.f2591b, (m7) null);
            return;
        }
        l7 w = this.f2594e.f2148a.j.w();
        String str = this.f2591b;
        w.b();
        synchronized (w) {
            if (w.m != null) {
                boolean equals = w.m.equals(str);
            }
            w.m = str;
        }
    }
}
