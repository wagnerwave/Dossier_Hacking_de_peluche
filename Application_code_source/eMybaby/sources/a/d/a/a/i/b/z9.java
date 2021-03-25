package a.d.a.a.i.b;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class z9 extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public final SSLSocketFactory f2673a = HttpsURLConnection.getDefaultSSLSocketFactory();

    public final Socket createSocket() {
        return new x9((SSLSocket) this.f2673a.createSocket());
    }

    public final String[] getDefaultCipherSuites() {
        return this.f2673a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f2673a.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i) {
        return new x9((SSLSocket) this.f2673a.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return new x9((SSLSocket) this.f2673a.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return new x9((SSLSocket) this.f2673a.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return new x9((SSLSocket) this.f2673a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return new x9((SSLSocket) this.f2673a.createSocket(socket, str, i, z));
    }
}
