package okhttp3.internal.http2;

import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {
    public static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
    public static final ByteString ENCODING = ByteString.encodeUtf8("encoding");
    public static final ByteString HOST = ByteString.encodeUtf8("host");
    public static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS;
    public static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((T[]) new ByteString[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    public static final ByteString KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
    public static final ByteString PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
    public static final ByteString TE = ByteString.encodeUtf8("te");
    public static final ByteString TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
    public static final ByteString UPGRADE;
    public final OkHttpClient client;
    public final Http2Connection connection;
    public Http2Stream stream;
    public final StreamAllocation streamAllocation;

    public class StreamFinishingSource extends ForwardingSource {
        public StreamFinishingSource(Source source) {
            super(source);
        }

        public void close() {
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.streamAllocation.streamFinished(false, http2Codec);
            super.close();
        }
    }

    static {
        ByteString encodeUtf8 = ByteString.encodeUtf8("upgrade");
        UPGRADE = encodeUtf8;
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((T[]) new ByteString[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, encodeUtf8, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY});
    }

    public Http2Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation2, Http2Connection http2Connection) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation2;
        this.connection = http2Connection;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = list.get(i);
            if (header != null) {
                ByteString byteString = header.name;
                String utf8 = header.value.utf8();
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    statusLine = StatusLine.parse("HTTP/1.1 " + utf8);
                } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                    Internal.instance.addLenient(builder, byteString.utf8(), utf8);
                }
            } else if (statusLine != null && statusLine.code == 100) {
                builder = new Headers.Builder();
                statusLine = null;
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    public void finishRequest() {
        this.stream.getSink().close();
    }

    public void flushRequest() {
        this.connection.flush();
    }

    public ResponseBody openResponseBody(Response response) {
        return new RealResponseBody(response.headers(), Okio.buffer((Source) new StreamFinishingSource(this.stream.getSource())));
    }

    public Response.Builder readResponseHeaders(boolean z) {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders());
        if (!z || Internal.instance.code(readHttp2HeadersList) != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public void writeRequestHeaders(Request request) {
        if (this.stream == null) {
            Http2Stream newStream = this.connection.newStream(http2HeadersList(request), request.body() != null);
            this.stream = newStream;
            newStream.readTimeout().timeout((long) this.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }
}
