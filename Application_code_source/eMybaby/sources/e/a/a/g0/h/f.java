package e.a.a.g0.h;

import a.e.a.a.r.b;
import e.a.a.d0.m.g;
import e.a.a.j0.c;
import java.net.Socket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final Log f5015a = LogFactory.getLog(f.class);

    /* renamed from: b  reason: collision with root package name */
    public final g f5016b;

    public f(g gVar) {
        if (gVar != null) {
            this.f5016b = gVar;
            return;
        }
        throw new IllegalArgumentException("Scheme registry amy not be null");
    }

    public void a(Socket socket, c cVar) {
        boolean z = true;
        socket.setTcpNoDelay(cVar.c("http.tcp.nodelay", true));
        socket.setSoTimeout(b.C(cVar));
        int b2 = cVar.b("http.socket.linger", -1);
        if (b2 >= 0) {
            if (b2 <= 0) {
                z = false;
            }
            socket.setSoLinger(z, b2);
        }
    }
}
