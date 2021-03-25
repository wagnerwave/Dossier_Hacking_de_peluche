package e.a.a.e0;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, i> f4901a = new ConcurrentHashMap<>();

    public void a(String str, i iVar) {
        this.f4901a.put(str.toLowerCase(Locale.ENGLISH), iVar);
    }
}
