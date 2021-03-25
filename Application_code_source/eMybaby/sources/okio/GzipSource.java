package okio;

import a.a.a.a.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {
    public static final byte FCOMMENT = 4;
    public static final byte FEXTRA = 2;
    public static final byte FHCRC = 1;
    public static final byte FNAME = 3;
    public static final byte SECTION_BODY = 1;
    public static final byte SECTION_DONE = 3;
    public static final byte SECTION_HEADER = 0;
    public static final byte SECTION_TRAILER = 2;
    public final CRC32 crc = new CRC32();
    public final Inflater inflater;
    public final InflaterSource inflaterSource;
    public int section = 0;
    public final BufferedSource source;

    public GzipSource(Source source2) {
        if (source2 != null) {
            this.inflater = new Inflater(true);
            BufferedSource buffer = Okio.buffer(source2);
            this.source = buffer;
            this.inflaterSource = new InflaterSource(buffer, this.inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void checkEqual(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    private void consumeHeader() {
        this.source.require(10);
        byte b2 = this.source.buffer().getByte(3);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            updateCrc(this.source.buffer(), 0, 10);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((b2 >> 2) & 1) == 1) {
            this.source.require(2);
            if (z) {
                updateCrc(this.source.buffer(), 0, 2);
            }
            long readShortLe = (long) this.source.buffer().readShortLe();
            this.source.require(readShortLe);
            if (z) {
                updateCrc(this.source.buffer(), 0, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b2 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z) {
                    updateCrc(this.source.buffer(), 0, indexOf + 1);
                }
                this.source.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b2 >> 4) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z) {
                    updateCrc(this.source.buffer(), 0, indexOf2 + 1);
                }
                this.source.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) ((int) this.crc.getValue()));
            this.crc.reset();
        }
    }

    private void consumeTrailer() {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private void updateCrc(Buffer buffer, long j, long j2) {
        Segment segment = buffer.head;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) segment.pos) + j);
            int min = (int) Math.min((long) (segment.limit - i3), j2);
            this.crc.update(segment.data, i3, min);
            j2 -= (long) min;
            segment = segment.next;
            j = 0;
        }
    }

    public void close() {
        this.inflaterSource.close();
    }

    public long read(Buffer buffer, long j) {
        if (j < 0) {
            throw new IllegalArgumentException(a.i("byteCount < 0: ", j));
        } else if (j == 0) {
            return 0;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = 1;
            }
            if (this.section == 1) {
                long j2 = buffer.size;
                long read = this.inflaterSource.read(buffer, j);
                if (read != -1) {
                    updateCrc(buffer, j2, read);
                    return read;
                }
                this.section = 2;
            }
            if (this.section == 2) {
                consumeTrailer();
                this.section = 3;
                if (!this.source.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
