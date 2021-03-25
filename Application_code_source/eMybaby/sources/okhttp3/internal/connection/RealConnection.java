package okhttp3.internal.connection;

import a.a.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.tuya.smart.android.common.utils.NetworkUtil;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public final ConnectionPool connectionPool;
    public Handshake handshake;
    public Http2Connection http2Connection;
    public long idleAtNanos = RecyclerView.FOREVER_NS;
    public boolean noNewStreams;
    public Protocol protocol;
    public Socket rawSocket;
    public final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool2, Route route2) {
        this.connectionPool = connectionPool2;
        this.route = route2;
    }

    private void connectSocket(int i, int i2) {
        Proxy proxy = this.route.proxy();
        Socket createSocket = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.route.address().socketFactory().createSocket() : new Socket(proxy);
        this.rawSocket = createSocket;
        createSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            this.source = Okio.buffer(Okio.source(this.rawSocket));
            this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        } catch (ConnectException e2) {
            StringBuilder n = a.n("Failed to connect to ");
            n.append(this.route.socketAddress());
            ConnectException connectException = new ConnectException(n.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0111 A[Catch:{ all -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0117 A[Catch:{ all -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connectTls(okhttp3.internal.connection.ConnectionSpecSelector r8) {
        /*
            r7 = this;
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r1 = r0.sslSocketFactory()
            r2 = 0
            java.net.Socket r3 = r7.rawSocket     // Catch:{ AssertionError -> 0x010a }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x010a }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x010a }
            okhttp3.HttpUrl r5 = r0.url()     // Catch:{ AssertionError -> 0x010a }
            int r5 = r5.port()     // Catch:{ AssertionError -> 0x010a }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x010a }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x010a }
            okhttp3.ConnectionSpec r8 = r8.configureSecureSocket(r1)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            boolean r3 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            if (r3 == 0) goto L_0x0041
            okhttp3.internal.platform.Platform r3 = okhttp3.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.util.List r5 = r0.protocols()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r3.configureTlsExtensions(r1, r4, r5)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okhttp3.Handshake r3 = okhttp3.Handshake.get(r3)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            javax.net.ssl.HostnameVerifier r4 = r0.hostnameVerifier()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okhttp3.HttpUrl r5 = r0.url()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r5 = r5.host()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            javax.net.ssl.SSLSession r6 = r1.getSession()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            boolean r4 = r4.verify(r5, r6)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            if (r4 == 0) goto L_0x00b0
            okhttp3.CertificatePinner r4 = r0.certificatePinner()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.util.List r5 = r3.peerCertificates()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r4.check((java.lang.String) r0, (java.util.List<java.security.cert.Certificate>) r5)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            boolean r8 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            if (r8 == 0) goto L_0x0083
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r2 = r8.getSelectedProtocol(r1)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
        L_0x0083:
            r7.socket = r1     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okio.Source r8 = okio.Okio.source((java.net.Socket) r1)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r7.source = r8     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.net.Socket r8 = r7.socket     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okio.Sink r8 = okio.Okio.sink((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okio.BufferedSink r8 = okio.Okio.buffer((okio.Sink) r8)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r7.sink = r8     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r7.handshake = r3     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            if (r2 == 0) goto L_0x00a4
            okhttp3.Protocol r8 = okhttp3.Protocol.get(r2)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            goto L_0x00a6
        L_0x00a4:
            okhttp3.Protocol r8 = okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
        L_0x00a6:
            r7.protocol = r8     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.get()
            r8.afterHandshake(r1)
            return
        L_0x00b0:
            java.util.List r8 = r3.peerCertificates()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r0 = okhttp3.CertificatePinner.pin(r8)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.util.List r8 = okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(r8)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
            throw r2     // Catch:{ AssertionError -> 0x0105, all -> 0x0102 }
        L_0x0102:
            r8 = move-exception
            r2 = r1
            goto L_0x0118
        L_0x0105:
            r8 = move-exception
            r2 = r1
            goto L_0x010b
        L_0x0108:
            r8 = move-exception
            goto L_0x0118
        L_0x010a:
            r8 = move-exception
        L_0x010b:
            boolean r0 = okhttp3.internal.Util.isAndroidGetsocknameError(r8)     // Catch:{ all -> 0x0108 }
            if (r0 == 0) goto L_0x0117
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0108 }
            r0.<init>(r8)     // Catch:{ all -> 0x0108 }
            throw r0     // Catch:{ all -> 0x0108 }
        L_0x0117:
            throw r8     // Catch:{ all -> 0x0108 }
        L_0x0118:
            if (r2 == 0) goto L_0x0121
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()
            r0.afterHandshake(r2)
        L_0x0121:
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connectTls(okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    private void connectTunnel(int i, int i2, int i3) {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 <= 21) {
                connectSocket(i, i2);
                createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
                if (createTunnelRequest != null) {
                    Util.closeQuietly(this.rawSocket);
                    this.rawSocket = null;
                    this.sink = null;
                    this.source = null;
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Too many tunnel connections attempted: 21");
            }
        }
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) {
        StringBuilder n = a.n("CONNECT ");
        n.append(Util.hostHeader(httpUrl, true));
        n.append(" HTTP/1.1");
        String sb = n.toString();
        while (true) {
            Http1Codec http1Codec = new Http1Codec((OkHttpClient) null, (StreamAllocation) null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), sb);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(build.header("Connection"))) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    StringBuilder n2 = a.n("Unexpected response code for CONNECT: ");
                    n2.append(build.code());
                    throw new IOException(n2.toString());
                }
            } else if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request createTunnelRequest() {
        return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector) {
        if (this.route.address().sslSocketFactory() == null) {
            this.protocol = Protocol.HTTP_1_1;
            this.socket = this.rawSocket;
            return;
        }
        connectTls(connectionSpecSelector);
        if (this.protocol == Protocol.HTTP_2) {
            this.socket.setSoTimeout(0);
            Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).build();
            this.http2Connection = build;
            build.start();
        }
    }

    public static RealConnection testConnection(ConnectionPool connectionPool2, Route route2, Socket socket2, long j) {
        RealConnection realConnection = new RealConnection(connectionPool2, route2);
        realConnection.socket = socket2;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a A[Catch:{ IOException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e A[Catch:{ IOException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r6, int r7, int r8, boolean r9) {
        /*
            r5 = this;
            okhttp3.Protocol r0 = r5.protocol
            if (r0 != 0) goto L_0x00b7
            okhttp3.Route r0 = r5.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            okhttp3.internal.connection.ConnectionSpecSelector r1 = new okhttp3.internal.connection.ConnectionSpecSelector
            r1.<init>(r0)
            okhttp3.Route r2 = r5.route
            okhttp3.Address r2 = r2.address()
            javax.net.ssl.SSLSocketFactory r2 = r2.sslSocketFactory()
            if (r2 != 0) goto L_0x0060
            okhttp3.ConnectionSpec r2 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0053
            okhttp3.Route r0 = r5.route
            okhttp3.Address r0 = r0.address()
            okhttp3.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            okhttp3.internal.platform.Platform r2 = okhttp3.internal.platform.Platform.get()
            boolean r2 = r2.isCleartextTrafficPermitted(r0)
            if (r2 == 0) goto L_0x0040
            goto L_0x0060
        L_0x0040:
            okhttp3.internal.connection.RouteException r6 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r7 = new java.net.UnknownServiceException
            java.lang.String r8 = "CLEARTEXT communication to "
            java.lang.String r9 = " not permitted by network security policy"
            java.lang.String r8 = a.a.a.a.a.l(r8, r0, r9)
            r7.<init>(r8)
            r6.<init>(r7)
            throw r6
        L_0x0053:
            okhttp3.internal.connection.RouteException r6 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r7 = new java.net.UnknownServiceException
            java.lang.String r8 = "CLEARTEXT communication not enabled for client"
            r7.<init>(r8)
            r6.<init>(r7)
            throw r6
        L_0x0060:
            r0 = 0
            r2 = r0
        L_0x0062:
            okhttp3.Route r3 = r5.route     // Catch:{ IOException -> 0x0089 }
            boolean r3 = r3.requiresTunnel()     // Catch:{ IOException -> 0x0089 }
            if (r3 == 0) goto L_0x006e
            r5.connectTunnel(r6, r7, r8)     // Catch:{ IOException -> 0x0089 }
            goto L_0x0071
        L_0x006e:
            r5.connectSocket(r6, r7)     // Catch:{ IOException -> 0x0089 }
        L_0x0071:
            r5.establishProtocol(r1)     // Catch:{ IOException -> 0x0089 }
            okhttp3.internal.http2.Http2Connection r6 = r5.http2Connection
            if (r6 == 0) goto L_0x0088
            okhttp3.ConnectionPool r6 = r5.connectionPool
            monitor-enter(r6)
            okhttp3.internal.http2.Http2Connection r7 = r5.http2Connection     // Catch:{ all -> 0x0085 }
            int r7 = r7.maxConcurrentStreams()     // Catch:{ all -> 0x0085 }
            r5.allocationLimit = r7     // Catch:{ all -> 0x0085 }
            monitor-exit(r6)     // Catch:{ all -> 0x0085 }
            goto L_0x0088
        L_0x0085:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0085 }
            throw r7
        L_0x0088:
            return
        L_0x0089:
            r3 = move-exception
            java.net.Socket r4 = r5.socket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r4)
            java.net.Socket r4 = r5.rawSocket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r4)
            r5.socket = r0
            r5.rawSocket = r0
            r5.source = r0
            r5.sink = r0
            r5.handshake = r0
            r5.protocol = r0
            r5.http2Connection = r0
            if (r2 != 0) goto L_0x00aa
            okhttp3.internal.connection.RouteException r2 = new okhttp3.internal.connection.RouteException
            r2.<init>(r3)
            goto L_0x00ad
        L_0x00aa:
            r2.addConnectException(r3)
        L_0x00ad:
            if (r9 == 0) goto L_0x00b6
            boolean r3 = r1.connectionFailed(r3)
            if (r3 == 0) goto L_0x00b6
            goto L_0x0062
        L_0x00b6:
            throw r2
        L_0x00b7:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "already connected"
            r6.<init>(r7)
            goto L_0x00c0
        L_0x00bf:
            throw r6
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, boolean):void");
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(Address address) {
        return this.allocations.size() < this.allocationLimit && address.equals(route().address()) && !this.noNewStreams;
    }

    public boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return !http2Connection2.isShutdown();
        }
        if (z) {
            try {
                soTimeout = this.socket.getSoTimeout();
                this.socket.setSoTimeout(1);
                if (this.source.exhausted()) {
                    this.socket.setSoTimeout(soTimeout);
                    return false;
                }
                this.socket.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, StreamAllocation streamAllocation) {
        if (this.http2Connection != null) {
            return new Http2Codec(okHttpClient, streamAllocation, this.http2Connection);
        }
        this.socket.setSoTimeout(okHttpClient.readTimeoutMillis());
        this.source.timeout().timeout((long) okHttpClient.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout((long) okHttpClient.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public RealWebSocket.Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        return new RealWebSocket.Streams(true, this.source, this.sink) {
            public void close() {
                StreamAllocation streamAllocation = streamAllocation2;
                streamAllocation.streamFinished(true, streamAllocation.codec());
            }
        };
    }

    public void onSettings(Http2Connection http2Connection2) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection2.maxConcurrentStreams();
        }
    }

    public void onStream(Http2Stream http2Stream) {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public Route route() {
        return this.route;
    }

    public Socket socket() {
        return this.socket;
    }

    public String toString() {
        StringBuilder n = a.n("Connection{");
        n.append(this.route.address().url().host());
        n.append(":");
        n.append(this.route.address().url().port());
        n.append(", proxy=");
        n.append(this.route.proxy());
        n.append(" hostAddress=");
        n.append(this.route.socketAddress());
        n.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        n.append(handshake2 != null ? handshake2.cipherSuite() : NetworkUtil.CONN_TYPE_NONE);
        n.append(" protocol=");
        n.append(this.protocol);
        n.append('}');
        return n.toString();
    }
}
