package okio;

import a.a.a.a.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater2) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater2 != null) {
            this.source = bufferedSource;
            this.inflater = inflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public InflaterSource(Source source2, Inflater inflater2) {
        this(Okio.buffer(source2), inflater2);
    }

    private void releaseInflatedBytes() {
        int i = this.bufferBytesHeldByInflater;
        if (i != 0) {
            int remaining = i - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= remaining;
            this.source.skip((long) remaining);
        }
    }

    public void close() {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }

    public long read(Buffer buffer, long j) {
        Segment writableSegment;
        if (j < 0) {
            throw new IllegalArgumentException(a.i("byteCount < 0: ", j));
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean refill = refill();
                try {
                    writableSegment = buffer.writableSegment(1);
                    int inflate = this.inflater.inflate(writableSegment.data, writableSegment.limit, 8192 - writableSegment.limit);
                    if (inflate > 0) {
                        writableSegment.limit += inflate;
                        long j2 = (long) inflate;
                        buffer.size += j2;
                        return j2;
                    } else if (this.inflater.finished()) {
                        break;
                    } else if (this.inflater.needsDictionary()) {
                        break;
                    } else if (refill) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            releaseInflatedBytes();
            if (writableSegment.pos != writableSegment.limit) {
                return -1;
            }
            buffer.head = writableSegment.pop();
            SegmentPool.recycle(writableSegment);
            return -1;
        }
    }

    public boolean refill() {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.source.exhausted()) {
            return true;
        } else {
            Segment segment = this.source.buffer().head;
            int i = segment.limit;
            int i2 = segment.pos;
            int i3 = i - i2;
            this.bufferBytesHeldByInflater = i3;
            this.inflater.setInput(segment.data, i2, i3);
            return false;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
