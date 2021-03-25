package okio;

import a.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Logger;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {
    public static final Logger logger = Logger.getLogger(Okio.class.getName());

    public static Sink appendingSink(File file) {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() {
            public void close() {
            }

            public void flush() {
            }

            public Timeout timeout() {
                return Timeout.NONE;
            }

            public void write(Buffer buffer, long j) {
                buffer.skip(j);
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(File file) {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    public static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new Sink() {
                public void close() {
                    outputStream.close();
                }

                public void flush() {
                    outputStream.flush();
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    StringBuilder n = a.n("sink(");
                    n.append(outputStream);
                    n.append(")");
                    return n.toString();
                }

                public void write(Buffer buffer, long j) {
                    Util.checkOffsetAndCount(buffer.size, 0, j);
                    while (j > 0) {
                        timeout.throwIfReached();
                        Segment segment = buffer.head;
                        int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                        outputStream.write(segment.data, segment.pos, min);
                        int i = segment.pos + min;
                        segment.pos = i;
                        long j2 = (long) min;
                        j -= j2;
                        buffer.size -= j2;
                        if (i == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink sink(Socket socket) {
        if (socket != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.sink(sink(socket.getOutputStream(), (Timeout) timeout));
        }
        throw new IllegalArgumentException("socket == null");
    }

    @IgnoreJRERequirement
    public static Sink sink(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(File file) {
        if (file != null) {
            return source((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    public static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new Source() {
                public void close() {
                    inputStream.close();
                }

                public long read(Buffer buffer, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException(a.i("byteCount < 0: ", j));
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            timeout.throwIfReached();
                            Segment writableSegment = buffer.writableSegment(1);
                            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, (long) (8192 - writableSegment.limit)));
                            if (read == -1) {
                                return -1;
                            }
                            writableSegment.limit += read;
                            long j2 = (long) read;
                            buffer.size += j2;
                            return j2;
                        } catch (AssertionError e2) {
                            if (Okio.isAndroidGetsocknameError(e2)) {
                                throw new IOException(e2);
                            }
                            throw e2;
                        }
                    }
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    StringBuilder n = a.n("source(");
                    n.append(inputStream);
                    n.append(")");
                    return n.toString();
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source source(Socket socket) {
        if (socket != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.source(source(socket.getInputStream(), (Timeout) timeout));
        }
        throw new IllegalArgumentException("socket == null");
    }

    @IgnoreJRERequirement
    public static Source source(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() {
            public IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Exception} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.AssertionError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Exception} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void timedOut() {
                /*
                    r5 = this;
                    java.lang.String r0 = "Failed to close timed out socket "
                    java.net.Socket r1 = r1     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                    r1.close()     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                    goto L_0x0033
                L_0x0008:
                    r1 = move-exception
                    boolean r2 = okio.Okio.isAndroidGetsocknameError(r1)
                    if (r2 == 0) goto L_0x0019
                    java.util.logging.Logger r2 = okio.Okio.logger
                    java.util.logging.Level r3 = java.util.logging.Level.WARNING
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    goto L_0x0024
                L_0x0019:
                    throw r1
                L_0x001a:
                    r1 = move-exception
                    java.util.logging.Logger r2 = okio.Okio.logger
                    java.util.logging.Level r3 = java.util.logging.Level.WARNING
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                L_0x0024:
                    r4.append(r0)
                    java.net.Socket r0 = r1
                    r4.append(r0)
                    java.lang.String r0 = r4.toString()
                    r2.log(r3, r0, r1)
                L_0x0033:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.Okio.AnonymousClass4.timedOut():void");
            }
        };
    }
}
