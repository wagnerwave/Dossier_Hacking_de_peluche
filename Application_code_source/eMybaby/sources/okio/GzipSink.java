package okio;

import a.a.a.a.a;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {
    public boolean closed;
    public final CRC32 crc = new CRC32();
    public final Deflater deflater;
    public final DeflaterSink deflaterSink;
    public final BufferedSink sink;

    public GzipSink(Sink sink2) {
        if (sink2 != null) {
            this.deflater = new Deflater(-1, true);
            BufferedSink buffer = Okio.buffer(sink2);
            this.sink = buffer;
            this.deflaterSink = new DeflaterSink(buffer, this.deflater);
            writeHeader();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    private void updateCrc(Buffer buffer, long j) {
        Segment segment = buffer.head;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            this.crc.update(segment.data, segment.pos, min);
            j -= (long) min;
            segment = segment.next;
        }
    }

    private void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void writeHeader() {
        Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    public void close() {
        if (!this.closed) {
            Throwable th = null;
            try {
                this.deflaterSink.finishDeflate();
                writeFooter();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.deflater.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.closed = true;
            if (th != null) {
                Util.sneakyRethrow(th);
            }
        }
    }

    public Deflater deflater() {
        return this.deflater;
    }

    public void flush() {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long j) {
        if (j < 0) {
            throw new IllegalArgumentException(a.i("byteCount < 0: ", j));
        } else if (j != 0) {
            updateCrc(buffer, j);
            this.deflaterSink.write(buffer, j);
        }
    }
}
