package e.a.a.d0.m;

import e.a.a.j0.c;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
public class i implements h {

    /* renamed from: a  reason: collision with root package name */
    public final j f4888a;

    public i(j jVar) {
        this.f4888a = jVar;
    }

    public boolean a(Socket socket) {
        return this.f4888a.a(socket);
    }

    public Socket e(c cVar) {
        return this.f4888a.c();
    }

    public boolean equals(Object obj) {
        j jVar;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            jVar = this.f4888a;
            obj = ((i) obj).f4888a;
        } else {
            jVar = this.f4888a;
        }
        return jVar.equals(obj);
    }

    public Socket f(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, c cVar) {
        int i;
        InetAddress inetAddress;
        String hostName = inetSocketAddress.getHostName();
        int port = inetSocketAddress.getPort();
        if (inetSocketAddress2 != null) {
            inetAddress = inetSocketAddress2.getAddress();
            i = inetSocketAddress2.getPort();
        } else {
            inetAddress = null;
            i = 0;
        }
        return this.f4888a.b(socket, hostName, port, inetAddress, i, cVar);
    }

    public int hashCode() {
        return this.f4888a.hashCode();
    }
}
