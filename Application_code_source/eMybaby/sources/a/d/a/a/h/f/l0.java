package a.d.a.a.h.f;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final h f1526a;

    /* renamed from: b  reason: collision with root package name */
    public final m0 f1527b = new m0();

    public l0(h hVar) {
        this.f1526a = hVar;
    }

    public final void a(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.f1527b.f1535e = z ? 1 : 0;
            return;
        }
        this.f1526a.c().l("Bool xml configuration name not recognized", str);
    }

    public final void b(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f1527b.f1534d = i;
        } else {
            this.f1526a.c().l("Int xml configuration name not recognized", str);
        }
    }

    public final void c(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f1527b.f1531a = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.f1527b.f1532b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f1527b.f1533c = str2;
        } else {
            this.f1526a.c().l("String xml configuration name not recognized", str);
        }
    }
}
