package okhttp3.internal.ws;

import a.a.a.a.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public final class WebSocketReader {
    public boolean closed;
    public long frameBytesRead;
    public final FrameCallback frameCallback;
    public long frameLength;
    public final boolean isClient;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    public boolean isMasked;
    public final byte[] maskBuffer = new byte[8192];
    public final byte[] maskKey = new byte[4];
    public int opcode;
    public final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(ByteString byteString);

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback2) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback2 != null) {
            this.isClient = z;
            this.source = bufferedSource;
            this.frameCallback = frameCallback2;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    private void readControlFrame() {
        String str;
        Buffer buffer = new Buffer();
        long j = this.frameBytesRead;
        long j2 = this.frameLength;
        if (j < j2) {
            if (!this.isClient) {
                while (true) {
                    long j3 = this.frameBytesRead;
                    long j4 = this.frameLength;
                    if (j3 >= j4) {
                        break;
                    }
                    int read = this.source.read(this.maskBuffer, 0, (int) Math.min(j4 - j3, (long) this.maskBuffer.length));
                    if (read != -1) {
                        long j5 = (long) read;
                        WebSocketProtocol.toggleMask(this.maskBuffer, j5, this.maskKey, this.frameBytesRead);
                        buffer.write(this.maskBuffer, 0, read);
                        this.frameBytesRead += j5;
                    } else {
                        throw new EOFException();
                    }
                }
            } else {
                this.source.readFully(buffer, j2);
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                long size = buffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s = buffer.readShort();
                        str = buffer.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.frameCallback.onReadClose(s, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(buffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(buffer.readByteString());
                return;
            default:
                StringBuilder n = a.n("Unknown control opcode: ");
                n.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(n.toString());
        }
    }

    /* JADX INFO: finally extract failed */
    private void readHeader() {
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                byte readByte = this.source.readByte() & AVFrame.FRM_STATE_UNKOWN;
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.opcode = readByte & 15;
                boolean z = true;
                this.isFinalFrame = (readByte & 128) != 0;
                boolean z2 = (readByte & 8) != 0;
                this.isControlFrame = z2;
                if (!z2 || this.isFinalFrame) {
                    boolean z3 = (readByte & 64) != 0;
                    boolean z4 = (readByte & 32) != 0;
                    boolean z5 = (readByte & Tnaf.POW_2_WIDTH) != 0;
                    if (z3 || z4 || z5) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.source.readByte() & AVFrame.FRM_STATE_UNKOWN;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    this.isMasked = z;
                    if (z == this.isClient) {
                        throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j = (long) (readByte2 & Byte.MAX_VALUE);
                    this.frameLength = j;
                    if (j == 126) {
                        this.frameLength = ((long) this.source.readShort()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                    } else if (j == 127) {
                        long readLong = this.source.readLong();
                        this.frameLength = readLong;
                        if (readLong < 0) {
                            StringBuilder n = a.n("Frame length 0x");
                            n.append(Long.toHexString(this.frameLength));
                            n.append(" > 0x7FFFFFFFFFFFFFFF");
                            throw new ProtocolException(n.toString());
                        }
                    }
                    this.frameBytesRead = 0;
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (this.isMasked) {
                        this.source.readFully(this.maskKey);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void readMessage(Buffer buffer) {
        long j;
        while (!this.closed) {
            if (this.frameBytesRead == this.frameLength) {
                if (!this.isFinalFrame) {
                    readUntilNonControlFrame();
                    if (this.opcode != 0) {
                        StringBuilder n = a.n("Expected continuation opcode. Got: ");
                        n.append(Integer.toHexString(this.opcode));
                        throw new ProtocolException(n.toString());
                    } else if (this.isFinalFrame && this.frameLength == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            long j2 = this.frameLength - this.frameBytesRead;
            if (this.isMasked) {
                j = (long) this.source.read(this.maskBuffer, 0, (int) Math.min(j2, (long) this.maskBuffer.length));
                if (j != -1) {
                    WebSocketProtocol.toggleMask(this.maskBuffer, j, this.maskKey, this.frameBytesRead);
                    buffer.write(this.maskBuffer, 0, (int) j);
                } else {
                    throw new EOFException();
                }
            } else {
                j = this.source.read(buffer, j2);
                if (j == -1) {
                    throw new EOFException();
                }
            }
            this.frameBytesRead += j;
        }
        throw new IOException("closed");
    }

    private void readMessageFrame() {
        int i = this.opcode;
        if (i == 1 || i == 2) {
            Buffer buffer = new Buffer();
            readMessage(buffer);
            if (i == 1) {
                this.frameCallback.onReadMessage(buffer.readUtf8());
            } else {
                this.frameCallback.onReadMessage(buffer.readByteString());
            }
        } else {
            StringBuilder n = a.n("Unknown opcode: ");
            n.append(Integer.toHexString(i));
            throw new ProtocolException(n.toString());
        }
    }

    public void processNextFrame() {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    public void readUntilNonControlFrame() {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }
}
