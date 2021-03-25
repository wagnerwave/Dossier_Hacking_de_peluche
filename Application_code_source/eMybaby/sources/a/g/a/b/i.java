package a.g.a.b;

import a.e.a.a.r.b;
import a.g.a.b.l.c;
import a.g.a.b.l.e;
import android.net.Uri;
import android.widget.ImageView;
import java.util.concurrent.locks.ReentrantLock;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f3395a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3396b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f3397c;

    /* renamed from: d  reason: collision with root package name */
    public final e f3398d;

    /* renamed from: e  reason: collision with root package name */
    public final b f3399e;
    public final c f;
    public final ReentrantLock g;

    public i(String str, ImageView imageView, e eVar, b bVar, c cVar, ReentrantLock reentrantLock) {
        this.f3395a = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        this.f3397c = imageView;
        this.f3398d = eVar;
        this.f3399e = bVar;
        this.f = cVar;
        this.g = reentrantLock;
        this.f3396b = b.q(str, eVar);
    }
}
