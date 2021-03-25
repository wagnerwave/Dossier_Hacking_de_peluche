package okhttp3.internal.huc;

import a.a.a.a.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.JavaNetHeaders;
import okhttp3.internal.URLFilter;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;

public final class OkHttpURLConnection extends HttpURLConnection implements Callback {
    public static final Set<String> METHODS = new LinkedHashSet(Arrays.asList(new String[]{"OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"}));
    public static final String RESPONSE_SOURCE = (Platform.get().getPrefix() + "-Response-Source");
    public static final String SELECTED_PROTOCOL = (Platform.get().getPrefix() + "-Selected-Protocol");
    public Call call;
    public Throwable callFailure;
    public OkHttpClient client;
    public boolean connectPending;
    public boolean executed;
    public long fixedContentLength;
    public Handshake handshake;
    public final Object lock;
    public final NetworkInterceptor networkInterceptor;
    public Response networkResponse;
    public Proxy proxy;
    public Headers.Builder requestHeaders;
    public Response response;
    public Headers responseHeaders;
    public URLFilter urlFilter;

    public final class NetworkInterceptor implements Interceptor {
        public boolean proceed;

        public NetworkInterceptor() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|27) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0091, code lost:
            throw new java.io.InterruptedIOException();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x008c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okhttp3.Response intercept(okhttp3.Interceptor.Chain r5) {
            /*
                r4 = this;
                okhttp3.Request r0 = r5.request()
                okhttp3.internal.huc.OkHttpURLConnection r1 = okhttp3.internal.huc.OkHttpURLConnection.this
                okhttp3.internal.URLFilter r1 = r1.urlFilter
                if (r1 == 0) goto L_0x0015
                okhttp3.HttpUrl r2 = r0.url()
                java.net.URL r2 = r2.url()
                r1.checkURLPermitted(r2)
            L_0x0015:
                okhttp3.internal.huc.OkHttpURLConnection r1 = okhttp3.internal.huc.OkHttpURLConnection.this
                java.lang.Object r1 = r1.lock
                monitor-enter(r1)
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0092 }
                r3 = 0
                r2.connectPending = r3     // Catch:{ all -> 0x0092 }
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0092 }
                okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0092 }
                okhttp3.Route r3 = r3.route()     // Catch:{ all -> 0x0092 }
                java.net.Proxy r3 = r3.proxy()     // Catch:{ all -> 0x0092 }
                r2.proxy = r3     // Catch:{ all -> 0x0092 }
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0092 }
                okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0092 }
                okhttp3.Handshake r3 = r3.handshake()     // Catch:{ all -> 0x0092 }
                r2.handshake = r3     // Catch:{ all -> 0x0092 }
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0092 }
                java.lang.Object r2 = r2.lock     // Catch:{ all -> 0x0092 }
                r2.notifyAll()     // Catch:{ all -> 0x0092 }
            L_0x0046:
                boolean r2 = r4.proceed     // Catch:{ InterruptedException -> 0x008c }
                if (r2 != 0) goto L_0x0054
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ InterruptedException -> 0x008c }
                java.lang.Object r2 = r2.lock     // Catch:{ InterruptedException -> 0x008c }
                r2.wait()     // Catch:{ InterruptedException -> 0x008c }
                goto L_0x0046
            L_0x0054:
                monitor-exit(r1)     // Catch:{ all -> 0x0092 }
                okhttp3.RequestBody r1 = r0.body()
                boolean r1 = r1 instanceof okhttp3.internal.huc.OutputStreamRequestBody
                if (r1 == 0) goto L_0x0067
                okhttp3.RequestBody r1 = r0.body()
                okhttp3.internal.huc.OutputStreamRequestBody r1 = (okhttp3.internal.huc.OutputStreamRequestBody) r1
                okhttp3.Request r0 = r1.prepareToSendRequest(r0)
            L_0x0067:
                okhttp3.Response r5 = r5.proceed(r0)
                okhttp3.internal.huc.OkHttpURLConnection r0 = okhttp3.internal.huc.OkHttpURLConnection.this
                java.lang.Object r0 = r0.lock
                monitor-enter(r0)
                okhttp3.internal.huc.OkHttpURLConnection r1 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0089 }
                r1.networkResponse = r5     // Catch:{ all -> 0x0089 }
                okhttp3.internal.huc.OkHttpURLConnection r1 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0089 }
                okhttp3.Request r2 = r5.request()     // Catch:{ all -> 0x0089 }
                okhttp3.HttpUrl r2 = r2.url()     // Catch:{ all -> 0x0089 }
                java.net.URL r2 = r2.url()     // Catch:{ all -> 0x0089 }
                java.net.URL unused = r1.url = r2     // Catch:{ all -> 0x0089 }
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                return r5
            L_0x0089:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                throw r5
            L_0x008c:
                java.io.InterruptedIOException r5 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0092 }
                r5.<init>()     // Catch:{ all -> 0x0092 }
                throw r5     // Catch:{ all -> 0x0092 }
            L_0x0092:
                r5 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0092 }
                goto L_0x0096
            L_0x0095:
                throw r5
            L_0x0096:
                goto L_0x0095
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.huc.OkHttpURLConnection.NetworkInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
        }

        public void proceed() {
            synchronized (OkHttpURLConnection.this.lock) {
                this.proceed = true;
                OkHttpURLConnection.this.lock.notifyAll();
            }
        }
    }

    public static final class UnexpectedException extends IOException {
        public static final Interceptor INTERCEPTOR = new Interceptor() {
            public Response intercept(Interceptor.Chain chain) {
                try {
                    return chain.proceed(chain.request());
                } catch (Error | RuntimeException e2) {
                    throw new UnexpectedException(e2);
                }
            }
        };

        public UnexpectedException(Throwable th) {
            super(th);
        }
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient) {
        super(url);
        this.networkInterceptor = new NetworkInterceptor();
        this.requestHeaders = new Headers.Builder();
        this.fixedContentLength = -1;
        this.lock = new Object();
        this.connectPending = true;
        this.client = okHttpClient;
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(url, okHttpClient);
        this.urlFilter = uRLFilter;
    }

    private Call buildCall() {
        OutputStreamRequestBody outputStreamRequestBody;
        Call call2 = this.call;
        if (call2 != null) {
            return call2;
        }
        boolean z = true;
        this.connected = true;
        if (this.doOutput) {
            if (this.method.equals("GET")) {
                this.method = "POST";
            } else if (!HttpMethod.permitsRequestBody(this.method)) {
                throw new ProtocolException(a.m(new StringBuilder(), this.method, " does not support writing"));
            }
        }
        if (this.requestHeaders.get("User-Agent") == null) {
            this.requestHeaders.add("User-Agent", defaultUserAgent());
        }
        if (HttpMethod.permitsRequestBody(this.method)) {
            if (this.requestHeaders.get("Content-Type") == null) {
                this.requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
            }
            long j = -1;
            if (this.fixedContentLength == -1 && this.chunkLength <= 0) {
                z = false;
            }
            String str = this.requestHeaders.get("Content-Length");
            long j2 = this.fixedContentLength;
            if (j2 != -1) {
                j = j2;
            } else if (str != null) {
                j = Long.parseLong(str);
            }
            outputStreamRequestBody = z ? new StreamedRequestBody(j) : new BufferedRequestBody(j);
            outputStreamRequestBody.timeout().timeout((long) this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        } else {
            outputStreamRequestBody = null;
        }
        Request build = new Request.Builder().url(Internal.instance.getHttpUrlChecked(getURL().toString())).headers(this.requestHeaders.build()).method(this.method, outputStreamRequestBody).build();
        URLFilter uRLFilter = this.urlFilter;
        if (uRLFilter != null) {
            uRLFilter.checkURLPermitted(build.url().url());
        }
        OkHttpClient.Builder newBuilder = this.client.newBuilder();
        newBuilder.interceptors().clear();
        newBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
        newBuilder.networkInterceptors().clear();
        newBuilder.networkInterceptors().add(this.networkInterceptor);
        newBuilder.dispatcher(new Dispatcher(this.client.dispatcher().executorService()));
        if (!getUseCaches()) {
            newBuilder.cache((Cache) null);
        }
        Call newCall = newBuilder.build().newCall(build);
        this.call = newCall;
        return newCall;
    }

    private String defaultUserAgent() {
        String property = System.getProperty("http.agent");
        return property != null ? Util.toHumanReadableAscii(property) : Version.userAgent();
    }

    private Headers getHeaders() {
        if (this.responseHeaders == null) {
            Response response2 = getResponse(true);
            this.responseHeaders = response2.headers().newBuilder().add(SELECTED_PROTOCOL, response2.protocol().toString()).add(RESPONSE_SOURCE, responseSourceHeader(response2)).build();
        }
        return this.responseHeaders;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        r3 = buildCall();
        r2.networkInterceptor.proceed();
        r0 = (okhttp3.internal.huc.OutputStreamRequestBody) r3.request().body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r0 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r0.outputStream().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r2.executed == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        r0 = r2.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        if (r2.response != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        if (r2.callFailure != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        r2.lock.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005d, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005e, code lost:
        r2.executed = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        onResponse(r3, r3.execute());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0069, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006a, code lost:
        onFailure(r3, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.Response getResponse(boolean r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            okhttp3.Response r1 = r2.response     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x000b
            okhttp3.Response r3 = r2.response     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return r3
        L_0x000b:
            java.lang.Throwable r1 = r2.callFailure     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0020
            if (r3 == 0) goto L_0x0019
            okhttp3.Response r3 = r2.networkResponse     // Catch:{ all -> 0x008d }
            if (r3 == 0) goto L_0x0019
            okhttp3.Response r3 = r2.networkResponse     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return r3
        L_0x0019:
            java.lang.Throwable r3 = r2.callFailure     // Catch:{ all -> 0x008d }
            java.io.IOException r3 = propagate(r3)     // Catch:{ all -> 0x008d }
            throw r3     // Catch:{ all -> 0x008d }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            okhttp3.Call r3 = r2.buildCall()
            okhttp3.internal.huc.OkHttpURLConnection$NetworkInterceptor r0 = r2.networkInterceptor
            r0.proceed()
            okhttp3.Request r0 = r3.request()
            okhttp3.RequestBody r0 = r0.body()
            okhttp3.internal.huc.OutputStreamRequestBody r0 = (okhttp3.internal.huc.OutputStreamRequestBody) r0
            if (r0 == 0) goto L_0x003d
            java.io.OutputStream r0 = r0.outputStream()
            r0.close()
        L_0x003d:
            boolean r0 = r2.executed
            if (r0 == 0) goto L_0x005e
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
        L_0x0044:
            okhttp3.Response r3 = r2.response     // Catch:{ InterruptedException -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.Throwable r3 = r2.callFailure     // Catch:{ InterruptedException -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.Object r3 = r2.lock     // Catch:{ InterruptedException -> 0x0056 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0056 }
            goto L_0x0044
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            goto L_0x006d
        L_0x0054:
            r3 = move-exception
            goto L_0x005c
        L_0x0056:
            java.io.InterruptedIOException r3 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r3
        L_0x005e:
            r0 = 1
            r2.executed = r0
            okhttp3.Response r0 = r3.execute()     // Catch:{ IOException -> 0x0069 }
            r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            r2.onFailure(r3, r0)
        L_0x006d:
            java.lang.Object r3 = r2.lock
            monitor-enter(r3)
            java.lang.Throwable r0 = r2.callFailure     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0083
            okhttp3.Response r0 = r2.response     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x007c
            okhttp3.Response r0 = r2.response     // Catch:{ all -> 0x008a }
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            return r0
        L_0x007c:
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L_0x0083:
            java.lang.Throwable r0 = r2.callFailure     // Catch:{ all -> 0x008a }
            java.io.IOException r0 = propagate(r0)     // Catch:{ all -> 0x008a }
            throw r0     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            throw r0
        L_0x008d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            goto L_0x0091
        L_0x0090:
            throw r3
        L_0x0091:
            goto L_0x0090
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.huc.OkHttpURLConnection.getResponse(boolean):okhttp3.Response");
    }

    public static IOException propagate(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new AssertionError();
        }
    }

    public static String responseSourceHeader(Response response2) {
        StringBuilder sb;
        String str;
        if (response2.networkResponse() == null) {
            if (response2.cacheResponse() == null) {
                return "NONE";
            }
            sb = new StringBuilder();
            str = "CACHE ";
        } else if (response2.cacheResponse() == null) {
            sb = new StringBuilder();
            str = "NETWORK ";
        } else {
            sb = a.n("CONDITIONAL_CACHE ");
            response2 = response2.networkResponse();
            sb.append(response2.code());
            return sb.toString();
        }
        sb.append(str);
        sb.append(response2.code());
        return sb.toString();
    }

    public void addRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            Platform.get().log(5, a.l("Ignoring header ", str, " because its value was null."), (Throwable) null);
        } else {
            this.requestHeaders.add(str, str2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect() {
        /*
            r2 = this;
            boolean r0 = r2.executed
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            okhttp3.Call r0 = r2.buildCall()
            r1 = 1
            r2.executed = r1
            r0.enqueue(r2)
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
        L_0x0012:
            boolean r1 = r2.connectPending     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 == 0) goto L_0x0024
            okhttp3.Response r1 = r2.response     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Throwable r1 = r2.callFailure     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x0024
            java.lang.Object r1 = r2.lock     // Catch:{ InterruptedException -> 0x0033 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0033 }
            goto L_0x0012
        L_0x0024:
            java.lang.Throwable r1 = r2.callFailure     // Catch:{ InterruptedException -> 0x0033 }
            if (r1 != 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x002a:
            java.lang.Throwable r1 = r2.callFailure     // Catch:{ InterruptedException -> 0x0033 }
            java.io.IOException r1 = propagate(r1)     // Catch:{ InterruptedException -> 0x0033 }
            throw r1     // Catch:{ InterruptedException -> 0x0033 }
        L_0x0031:
            r1 = move-exception
            goto L_0x0039
        L_0x0033:
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0031 }
            r1.<init>()     // Catch:{ all -> 0x0031 }
            throw r1     // Catch:{ all -> 0x0031 }
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            goto L_0x003c
        L_0x003b:
            throw r1
        L_0x003c:
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.huc.OkHttpURLConnection.connect():void");
    }

    public void disconnect() {
        if (this.call != null) {
            this.networkInterceptor.proceed();
            this.call.cancel();
        }
    }

    public int getConnectTimeout() {
        return this.client.connectTimeoutMillis();
    }

    public InputStream getErrorStream() {
        try {
            Response response2 = getResponse(true);
            if (HttpHeaders.hasBody(response2) && response2.code() >= 400) {
                return response2.body().byteStream();
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderField(int i) {
        try {
            Headers headers = getHeaders();
            if (i >= 0) {
                if (i < headers.size()) {
                    return headers.value(i);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderField(String str) {
        if (str != null) {
            return getHeaders().get(str);
        }
        try {
            return StatusLine.get(getResponse(true)).toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getHeaderFieldKey(int i) {
        try {
            Headers headers = getHeaders();
            if (i >= 0) {
                if (i < headers.size()) {
                    return headers.name(i);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public Map<String, List<String>> getHeaderFields() {
        try {
            return JavaNetHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse(true)).toString());
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    public InputStream getInputStream() {
        if (this.doInput) {
            Response response2 = getResponse(false);
            if (response2.code() < 400) {
                return response2.body().byteStream();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public boolean getInstanceFollowRedirects() {
        return this.client.followRedirects();
    }

    public OutputStream getOutputStream() {
        OutputStreamRequestBody outputStreamRequestBody = (OutputStreamRequestBody) buildCall().request().body();
        if (outputStreamRequestBody != null) {
            if (outputStreamRequestBody instanceof StreamedRequestBody) {
                connect();
                this.networkInterceptor.proceed();
            }
            if (!outputStreamRequestBody.isClosed()) {
                return outputStreamRequestBody.outputStream();
            }
            throw new ProtocolException("cannot write request body after response has been read");
        }
        StringBuilder n = a.n("method does not support a request body: ");
        n.append(this.method);
        throw new ProtocolException(n.toString());
    }

    public Permission getPermission() {
        URL url = getURL();
        String host = url.getHost();
        int port = url.getPort() != -1 ? url.getPort() : HttpUrl.defaultPort(url.getProtocol());
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.client.proxy().address();
            host = inetSocketAddress.getHostName();
            port = inetSocketAddress.getPort();
        }
        return new SocketPermission(host + ":" + port, "connect, resolve");
    }

    public int getReadTimeout() {
        return this.client.readTimeoutMillis();
    }

    public Map<String, List<String>> getRequestProperties() {
        if (!this.connected) {
            return JavaNetHeaders.toMultimap(this.requestHeaders.build(), (String) null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.requestHeaders.get(str);
    }

    public int getResponseCode() {
        return getResponse(true).code();
    }

    public String getResponseMessage() {
        return getResponse(true).message();
    }

    public void onFailure(Call call2, IOException iOException) {
        synchronized (this.lock) {
            boolean z = iOException instanceof UnexpectedException;
            Throwable th = iOException;
            if (z) {
                th = iOException.getCause();
            }
            this.callFailure = th;
            this.lock.notifyAll();
        }
    }

    public void onResponse(Call call2, Response response2) {
        synchronized (this.lock) {
            this.response = response2;
            this.handshake = response2.handshake();
            this.url = response2.request().url().url();
            this.lock.notifyAll();
        }
    }

    public void setConnectTimeout(int i) {
        this.client = this.client.newBuilder().connectTimeout((long) i, TimeUnit.MILLISECONDS).build();
    }

    public void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode((long) i);
    }

    public void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (j >= 0) {
            this.fixedContentLength = j;
            this.fixedContentLength = (int) Math.min(j, 2147483647L);
        } else {
            throw new IllegalArgumentException("contentLength < 0");
        }
    }

    public void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        int i = (this.ifModifiedSince > 0 ? 1 : (this.ifModifiedSince == 0 ? 0 : -1));
        Headers.Builder builder = this.requestHeaders;
        if (i != 0) {
            builder.set("If-Modified-Since", HttpDate.format(new Date(this.ifModifiedSince)));
        } else {
            builder.removeAll("If-Modified-Since");
        }
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.client = this.client.newBuilder().followRedirects(z).build();
    }

    public void setReadTimeout(int i) {
        this.client = this.client.newBuilder().readTimeout((long) i, TimeUnit.MILLISECONDS).build();
    }

    public void setRequestMethod(String str) {
        if (METHODS.contains(str)) {
            this.method = str;
            return;
        }
        StringBuilder n = a.n("Expected one of ");
        n.append(METHODS);
        n.append(" but was ");
        n.append(str);
        throw new ProtocolException(n.toString());
    }

    public void setRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            Platform.get().log(5, a.l("Ignoring header ", str, " because its value was null."), (Throwable) null);
        } else {
            this.requestHeaders.set(str, str2);
        }
    }

    public boolean usingProxy() {
        if (this.proxy != null) {
            return true;
        }
        Proxy proxy2 = this.client.proxy();
        return (proxy2 == null || proxy2.type() == Proxy.Type.DIRECT) ? false : true;
    }
}
