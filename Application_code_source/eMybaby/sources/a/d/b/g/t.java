package a.d.b.g;

import a.d.b.h.a;
import a.d.b.h.b;
import java.util.Map;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Map.Entry f2765a;

    /* renamed from: b  reason: collision with root package name */
    public final a f2766b;

    public t(Map.Entry entry, a aVar) {
        this.f2765a = entry;
        this.f2766b = aVar;
    }

    public void run() {
        Map.Entry entry = this.f2765a;
        ((b) entry.getKey()).a(this.f2766b);
    }
}
