package okhttp3;

import a.a.a.a.a;
import java.net.URL;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {
    public final RequestBody body;
    public volatile CacheControl cacheControl;
    public final Headers headers;
    public final String method;
    public final Object tag;
    public final HttpUrl url;

    public static class Builder {
        public RequestBody body;
        public Headers.Builder headers;
        public String method;
        public Object tag;
        public HttpUrl url;

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request request) {
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tag = request.tag;
            this.headers = request.headers.newBuilder();
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public Builder head() {
            return method("HEAD", (RequestBody) null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException(a.l("method ", str, " must not have a request body."));
            } else if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.method = str;
                this.body = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException(a.l("method ", str, " must have a request body."));
            }
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okhttp3.Request.Builder url(java.lang.String r9) {
            /*
                r8 = this;
                if (r9 == 0) goto L_0x004d
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 3
                java.lang.String r3 = "ws:"
                r0 = r9
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L_0x0017
                java.lang.String r0 = "http:"
                java.lang.StringBuilder r0 = a.a.a.a.a.n(r0)
                r1 = 3
                goto L_0x002b
            L_0x0017:
                r3 = 1
                r4 = 0
                r6 = 0
                r7 = 4
                java.lang.String r5 = "wss:"
                r2 = r9
                boolean r0 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r0 == 0) goto L_0x0036
                java.lang.String r0 = "https:"
                java.lang.StringBuilder r0 = a.a.a.a.a.n(r0)
                r1 = 4
            L_0x002b:
                java.lang.String r9 = r9.substring(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
            L_0x0036:
                okhttp3.HttpUrl r0 = okhttp3.HttpUrl.parse(r9)
                if (r0 == 0) goto L_0x0041
                okhttp3.Request$Builder r9 = r8.url((okhttp3.HttpUrl) r0)
                return r9
            L_0x0041:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "unexpected url: "
                java.lang.String r9 = a.a.a.a.a.k(r1, r9)
                r0.<init>(r9)
                throw r0
            L_0x004d:
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r0 = "url == null"
                r9.<init>(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Request.Builder.url(java.lang.String):okhttp3.Request$Builder");
        }

        public Builder url(URL url2) {
            if (url2 != null) {
                HttpUrl httpUrl = HttpUrl.get(url2);
                if (httpUrl != null) {
                    return url(httpUrl);
                }
                throw new IllegalArgumentException("unexpected url: " + url2);
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.url = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }
    }

    public Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        Object obj = builder.tag;
        this.tag = obj == null ? this : obj;
    }

    public RequestBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl2 = this.cacheControl;
        if (cacheControl2 != null) {
            return cacheControl2;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    public String header(String str) {
        return this.headers.get(str);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Object tag() {
        return this.tag;
    }

    public String toString() {
        StringBuilder n = a.n("Request{method=");
        n.append(this.method);
        n.append(", url=");
        n.append(this.url);
        n.append(", tag=");
        Object obj = this.tag;
        if (obj == this) {
            obj = null;
        }
        n.append(obj);
        n.append('}');
        return n.toString();
    }

    public HttpUrl url() {
        return this.url;
    }
}
