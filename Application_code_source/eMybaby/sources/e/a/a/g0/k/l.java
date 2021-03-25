package e.a.a.g0.k;

import e.a.a.h0.b;
import e.a.a.j0.c;
import e.a.a.l0.a;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.Socket;

public class l extends c implements b {
    public static final Class m;
    public final Socket k;
    public boolean l;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("java.net.SocketTimeoutException");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        m = cls;
    }

    public l(Socket socket, int i, c cVar) {
        if (socket != null) {
            this.k = socket;
            boolean z = false;
            this.l = false;
            i = i < 0 ? socket.getReceiveBufferSize() : i;
            i = i < 1024 ? 1024 : i;
            InputStream inputStream = socket.getInputStream();
            if (inputStream == null) {
                throw new IllegalArgumentException("Input stream may not be null");
            } else if (i <= 0) {
                throw new IllegalArgumentException("Buffer size may not be negative or zero");
            } else if (cVar != null) {
                this.f5092a = inputStream;
                this.f5093b = new byte[i];
                this.f5094c = 0;
                this.f5095d = 0;
                this.f5096e = new a(i);
                String y = a.e.a.a.r.b.y(cVar);
                this.f = y;
                this.g = (y.equalsIgnoreCase("US-ASCII") || this.f.equalsIgnoreCase("ASCII")) ? true : z;
                this.h = cVar.b("http.connection.max-line-length", -1);
                this.i = cVar.b("http.connection.min-chunk-limit", 512);
                this.j = new i();
            } else {
                throw new IllegalArgumentException("HTTP parameters may not be null");
            }
        } else {
            throw new IllegalArgumentException("Socket may not be null");
        }
    }

    public boolean c() {
        return this.l;
    }

    public boolean d(int i) {
        boolean f = f();
        if (!f) {
            int soTimeout = this.k.getSoTimeout();
            try {
                this.k.setSoTimeout(i);
                e();
                f = f();
            } catch (InterruptedIOException e2) {
                Class cls = m;
                if (!(cls != null ? cls.isInstance(e2) : true)) {
                    throw e2;
                }
            } catch (Throwable th) {
                this.k.setSoTimeout(soTimeout);
                throw th;
            }
            this.k.setSoTimeout(soTimeout);
        }
        return f;
    }

    public int e() {
        int e2 = super.e();
        this.l = e2 == -1;
        return e2;
    }
}
