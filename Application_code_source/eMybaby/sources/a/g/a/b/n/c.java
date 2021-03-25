package a.g.a.b.n;

import java.io.InputStream;
import java.net.URI;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final b f3447a;

    public c(b bVar) {
        this.f3447a = bVar;
    }

    public InputStream a(URI uri, Object obj) {
        String scheme = uri.getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return this.f3447a.a(uri, obj);
        }
        throw new IllegalStateException();
    }
}
