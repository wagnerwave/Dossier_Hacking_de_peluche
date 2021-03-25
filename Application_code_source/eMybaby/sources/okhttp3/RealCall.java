package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

public final class RealCall implements Call {
    public final OkHttpClient client;
    public boolean executed;
    public final boolean forWebSocket;
    public final Request originalRequest;
    public final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;

    public final class AsyncCall extends NamedRunnable {
        public final Callback responseCallback;

        public AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[SYNTHETIC, Splitter:B:12:0x0032] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0052 A[Catch:{ all -> 0x002b }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x002d }
                okhttp3.Response r2 = r2.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x002d }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x002d }
                okhttp3.internal.http.RetryAndFollowUpInterceptor r3 = r3.retryAndFollowUpInterceptor     // Catch:{ IOException -> 0x002d }
                boolean r1 = r3.isCanceled()     // Catch:{ IOException -> 0x002d }
                if (r1 == 0) goto L_0x0021
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x0029 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0029 }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0029 }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x0029 }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x0029 }
                goto L_0x0059
            L_0x0021:
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x0029 }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0029 }
                r1.onResponse(r3, r2)     // Catch:{ IOException -> 0x0029 }
                goto L_0x0059
            L_0x0029:
                r1 = move-exception
                goto L_0x0030
            L_0x002b:
                r0 = move-exception
                goto L_0x0065
            L_0x002d:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0030:
                if (r0 == 0) goto L_0x0052
                okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x002b }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
                r3.<init>()     // Catch:{ all -> 0x002b }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x002b }
                okhttp3.RealCall r4 = okhttp3.RealCall.this     // Catch:{ all -> 0x002b }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x002b }
                r3.append(r4)     // Catch:{ all -> 0x002b }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002b }
                r0.log(r2, r3, r1)     // Catch:{ all -> 0x002b }
                goto L_0x0059
            L_0x0052:
                okhttp3.Callback r0 = r5.responseCallback     // Catch:{ all -> 0x002b }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x002b }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x002b }
            L_0x0059:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.client
                okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished((okhttp3.RealCall.AsyncCall) r5)
                return
            L_0x0065:
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.client
                okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished((okhttp3.RealCall.AsyncCall) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.execute():void");
        }

        public RealCall get() {
            return RealCall.this;
        }

        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        public Request request() {
            return RealCall.this.originalRequest;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public Response execute() {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    public Response getResponseWithInterceptorChain() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        return new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (Connection) null, 0, this.originalRequest).proceed(this.originalRequest);
    }

    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    public Request request() {
        return this.originalRequest;
    }

    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    public String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }
}
