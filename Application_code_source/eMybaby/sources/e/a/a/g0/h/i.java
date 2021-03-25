package e.a.a.g0.h;

import e.a.a.j;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class i extends InetSocketAddress {

    /* renamed from: a  reason: collision with root package name */
    public final j f5018a;

    public i(j jVar, InetAddress inetAddress, int i) {
        super(inetAddress, i);
        if (jVar != null) {
            this.f5018a = jVar;
            return;
        }
        throw new IllegalArgumentException("HTTP host may not be null");
    }

    public String toString() {
        return this.f5018a.f5170a + ":" + getPort();
    }
}
