package okhttp3.internal.huc;

import a.a.a.a.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;

public abstract class OutputStreamRequestBody extends RequestBody {
    public boolean closed;
    public long expectedContentLength;
    public OutputStream outputStream;
    public Timeout timeout;

    public long contentLength() {
        return this.expectedContentLength;
    }

    public final MediaType contentType() {
        return null;
    }

    public void initOutputStream(final BufferedSink bufferedSink, final long j) {
        this.timeout = bufferedSink.timeout();
        this.expectedContentLength = j;
        this.outputStream = new OutputStream() {
            public long bytesReceived;

            public void close() {
                OutputStreamRequestBody.this.closed = true;
                long j = j;
                if (j == -1 || this.bytesReceived >= j) {
                    bufferedSink.close();
                    return;
                }
                StringBuilder n = a.n("expected ");
                n.append(j);
                n.append(" bytes but received ");
                n.append(this.bytesReceived);
                throw new ProtocolException(n.toString());
            }

            public void flush() {
                if (!OutputStreamRequestBody.this.closed) {
                    bufferedSink.flush();
                }
            }

            public void write(int i) {
                write(new byte[]{(byte) i}, 0, 1);
            }

            public void write(byte[] bArr, int i, int i2) {
                if (!OutputStreamRequestBody.this.closed) {
                    long j = j;
                    if (j == -1 || this.bytesReceived + ((long) i2) <= j) {
                        this.bytesReceived += (long) i2;
                        try {
                            bufferedSink.write(bArr, i, i2);
                        } catch (InterruptedIOException e2) {
                            throw new SocketTimeoutException(e2.getMessage());
                        }
                    } else {
                        StringBuilder n = a.n("expected ");
                        n.append(j);
                        n.append(" bytes but received ");
                        n.append(this.bytesReceived);
                        n.append(i2);
                        throw new ProtocolException(n.toString());
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        };
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public Request prepareToSendRequest(Request request) {
        return request;
    }

    public final Timeout timeout() {
        return this.timeout;
    }
}
