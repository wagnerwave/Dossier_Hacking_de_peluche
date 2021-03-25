package e.b.a.a.a.u;

import e.b.a.a.a.n;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class p implements m {
    public static final b f = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", p.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public Socket f5285a;

    /* renamed from: b  reason: collision with root package name */
    public SocketFactory f5286b;

    /* renamed from: c  reason: collision with root package name */
    public String f5287c;

    /* renamed from: d  reason: collision with root package name */
    public int f5288d;

    /* renamed from: e  reason: collision with root package name */
    public int f5289e;

    public p(SocketFactory socketFactory, String str, int i, String str2) {
        f.i(str2);
        this.f5286b = socketFactory;
        this.f5287c = str;
        this.f5288d = i;
    }

    public OutputStream a() {
        return this.f5285a.getOutputStream();
    }

    public InputStream b() {
        return this.f5285a.getInputStream();
    }

    public String c() {
        return "tcp://" + this.f5287c + ":" + this.f5288d;
    }

    public void start() {
        try {
            f.e("e.b.a.a.a.u.p", "start", "252", new Object[]{this.f5287c, new Integer(this.f5288d), new Long((long) (this.f5289e * 1000))});
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f5287c, this.f5288d);
            if (this.f5286b instanceof SSLSocketFactory) {
                Socket socket = new Socket();
                socket.connect(inetSocketAddress, this.f5289e * 1000);
                this.f5285a = ((SSLSocketFactory) this.f5286b).createSocket(socket, this.f5287c, this.f5288d, true);
                return;
            }
            Socket createSocket = this.f5286b.createSocket();
            this.f5285a = createSocket;
            createSocket.connect(inetSocketAddress, this.f5289e * 1000);
        } catch (ConnectException e2) {
            f.c("e.b.a.a.a.u.p", "start", "250", (Object[]) null, e2);
            throw new n(32103, e2);
        }
    }

    public void stop() {
        Socket socket = this.f5285a;
        if (socket != null) {
            socket.shutdownInput();
            this.f5285a.close();
        }
    }
}
