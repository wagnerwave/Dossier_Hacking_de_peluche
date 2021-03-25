package e.a.a.d0.n;

import e.a.a.d0.e;
import e.a.a.d0.m.a;
import e.a.a.d0.m.b;
import e.a.a.j0.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class d implements b, e.a.a.d0.m.d {

    /* renamed from: d  reason: collision with root package name */
    public static final g f4890d = new c();

    /* renamed from: a  reason: collision with root package name */
    public final SSLSocketFactory f4891a;

    /* renamed from: b  reason: collision with root package name */
    public final a f4892b;

    /* renamed from: c  reason: collision with root package name */
    public volatile g f4893c;

    public d() {
        try {
            SSLContext h = h("TLS", (KeyStore) null, (String) null, (KeyStore) null, (SecureRandom) null, (f) null);
            g gVar = f4890d;
            this.f4891a = h.getSocketFactory();
            this.f4893c = gVar;
            this.f4892b = null;
        } catch (Exception e2) {
            throw new IllegalStateException("Failure initializing default SSL context", e2);
        }
    }

    public static SSLContext h(String str, KeyStore keyStore, String str2, KeyStore keyStore2, SecureRandom secureRandom, f fVar) {
        KeyManagerFactory instance = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null, (char[]) null);
        KeyManager[] keyManagers = instance.getKeyManagers();
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance2.init((KeyStore) null);
        TrustManager[] trustManagers = instance2.getTrustManagers();
        SSLContext instance3 = SSLContext.getInstance(str);
        instance3.init(keyManagers, trustManagers, (SecureRandom) null);
        return instance3;
    }

    public boolean a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        } else if (!(socket instanceof SSLSocket)) {
            throw new IllegalArgumentException("Socket not created by this factory");
        } else if (!socket.isClosed()) {
            return true;
        } else {
            throw new IllegalArgumentException("Socket is closed");
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
        a aVar = this.f4892b;
        return f(socket, new InetSocketAddress(aVar != null ? aVar.a(str) : InetAddress.getByName(str), i), inetSocketAddress, cVar);
    }

    @Deprecated
    public Socket c() {
        return this.f4891a.createSocket();
    }

    @Deprecated
    public Socket d(Socket socket, String str, int i, boolean z) {
        SSLSocket sSLSocket = (SSLSocket) this.f4891a.createSocket(socket, str, i, z);
        if (this.f4893c != null) {
            ((a) this.f4893c).e(str, sSLSocket);
        }
        return sSLSocket;
    }

    public Socket e(c cVar) {
        return this.f4891a.createSocket();
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
                socket.setSoTimeout(a.e.a.a.r.b.C(cVar));
                socket.connect(inetSocketAddress, b2);
                String inetSocketAddress3 = inetSocketAddress.toString();
                int port = inetSocketAddress.getPort();
                String h = a.a.a.a.a.h(":", port);
                if (inetSocketAddress3.endsWith(h)) {
                    inetSocketAddress3 = inetSocketAddress3.substring(0, inetSocketAddress3.length() - h.length());
                }
                if (!(socket instanceof SSLSocket)) {
                    socket = this.f4891a.createSocket(socket, inetSocketAddress3, port, true);
                }
                SSLSocket sSLSocket = (SSLSocket) socket;
                if (this.f4893c != null) {
                    try {
                        ((a) this.f4893c).e(inetSocketAddress3, sSLSocket);
                    } catch (IOException e2) {
                        try {
                            sSLSocket.close();
                        } catch (Exception unused) {
                        }
                        throw e2;
                    }
                }
                return sSLSocket;
            } catch (SocketTimeoutException unused2) {
                throw new e("Connect to " + inetSocketAddress + " timed out");
            }
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    public Socket g(Socket socket, String str, int i, boolean z) {
        SSLSocket sSLSocket = (SSLSocket) this.f4891a.createSocket(socket, str, i, z);
        if (this.f4893c != null) {
            ((a) this.f4893c).e(str, sSLSocket);
        }
        return sSLSocket;
    }
}
