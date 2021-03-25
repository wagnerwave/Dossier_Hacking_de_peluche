package okhttp3.internal.huc;

import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSink;

public final class BufferedRequestBody extends OutputStreamRequestBody {
    public final Buffer buffer;
    public long contentLength = -1;

    public BufferedRequestBody(long j) {
        Buffer buffer2 = new Buffer();
        this.buffer = buffer2;
        initOutputStream(buffer2, j);
    }

    public long contentLength() {
        return this.contentLength;
    }

    public Request prepareToSendRequest(Request request) {
        if (request.header("Content-Length") != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.size();
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.size())).build();
    }

    public void writeTo(BufferedSink bufferedSink) {
        this.buffer.copyTo(bufferedSink.buffer(), 0, this.buffer.size());
    }
}
