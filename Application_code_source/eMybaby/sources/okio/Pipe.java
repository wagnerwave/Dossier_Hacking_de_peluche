package okio;

import a.a.a.a.a;
import java.io.IOException;

public final class Pipe {
    public final Buffer buffer = new Buffer();
    public final long maxBufferSize;
    public final Sink sink = new PipeSink();
    public boolean sinkClosed;
    public final Source source = new PipeSource();
    public boolean sourceClosed;

    public final class PipeSink implements Sink {
        public final Timeout timeout = new Timeout();

        public PipeSink() {
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    try {
                        flush();
                    } finally {
                        Pipe.this.sinkClosed = true;
                        Pipe.this.buffer.notifyAll();
                    }
                }
            }
        }

        public void flush() {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (Pipe.this.buffer.size() > 0) {
                        if (!Pipe.this.sourceClosed) {
                            this.timeout.waitUntilNotified(Pipe.this.buffer);
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (j > 0) {
                        if (!Pipe.this.sourceClosed) {
                            long size = Pipe.this.maxBufferSize - Pipe.this.buffer.size();
                            if (size == 0) {
                                this.timeout.waitUntilNotified(Pipe.this.buffer);
                            } else {
                                long min = Math.min(size, j);
                                Pipe.this.buffer.write(buffer, min);
                                j -= min;
                                Pipe.this.buffer.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }
    }

    public final class PipeSource implements Source {
        public final Timeout timeout = new Timeout();

        public PipeSource() {
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                Pipe.this.sourceClosed = true;
                Pipe.this.buffer.notifyAll();
            }
        }

        public long read(Buffer buffer, long j) {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sourceClosed) {
                    while (Pipe.this.buffer.size() == 0) {
                        if (Pipe.this.sinkClosed) {
                            return -1;
                        }
                        this.timeout.waitUntilNotified(Pipe.this.buffer);
                    }
                    long read = Pipe.this.buffer.read(buffer, j);
                    Pipe.this.buffer.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new IllegalArgumentException(a.i("maxBufferSize < 1: ", j));
    }

    public Sink sink() {
        return this.sink;
    }

    public Source source() {
        return this.source;
    }
}
