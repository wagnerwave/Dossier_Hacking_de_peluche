package e.a.a.d0.m;

import a.e.a.a.r.b;
import e.a.a.j0.c;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class e implements j, h {

    /* renamed from: a  reason: collision with root package name */
    public final a f4881a = null;

    public final boolean a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null.");
        } else if (!socket.isClosed()) {
            return false;
        } else {
            throw new IllegalArgumentException("Socket is closed.");
        }
    }

    @Deprecated
    public Socket b(Socket socket, String str, int i, InetAddress inetAddress, int i2, c cVar) {
        InetSocketAddress inetSocketAddress;
        if (inetAddress != null || i2 > 0) {
            if (i2 < 0) {
                i2 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i2);
        } else {
            inetSocketAddress = null;
        }
        a aVar = this.f4881a;
        return f(socket, new InetSocketAddress(aVar != null ? aVar.a(str) : InetAddress.getByName(str), i), inetSocketAddress, cVar);
    }

    public Socket c() {
        return new Socket();
    }

    public Socket e(c cVar) {
        return new Socket();
    }

    public Socket f(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, c cVar) {
        if (cVar != null) {
            if (socket == null) {
                socket = new Socket();
            }
            if (inetSocketAddress2 != null) {
                socket.setReuseAddress(cVar.c("http.socket.reuseaddr", false));
                socket.bind(inetSocketAddress2);
            }
            int b2 = cVar.b("http.connection.timeout", 0);
            try {
                socket.setSoTimeout(b.C(cVar));
                socket.connect(inetSocketAddress, b2);
                return socket;
            } catch (SocketTimeoutException unused) {
                throw new e.a.a.d0.e("Connect to " + inetSocketAddress + " timed out");
            }
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }
}
