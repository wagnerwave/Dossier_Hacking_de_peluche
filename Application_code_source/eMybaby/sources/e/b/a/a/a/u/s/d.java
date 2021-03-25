package e.b.a.a.a.u.s;

import com.tutk.IOTC.AVFrame;
import com.tuya.smart.android.common.utils.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte f5306a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5307b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5308c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5309d = false;

    public d(byte b2, boolean z, byte[] bArr) {
        this.f5306a = b2;
        this.f5307b = z;
        this.f5308c = bArr;
    }

    public d(InputStream inputStream) {
        byte[] bArr;
        int i = 0;
        byte read = (byte) inputStream.read();
        this.f5307b = (read & 128) != 0;
        byte b2 = (byte) (read & 15);
        this.f5306a = b2;
        int i2 = 2;
        if (b2 == 2) {
            byte read2 = (byte) inputStream.read();
            boolean z = (read2 & 128) != 0;
            int i3 = (byte) (read2 & Byte.MAX_VALUE);
            if (i3 == 127) {
                i2 = 8;
            } else if (i3 != 126) {
                i2 = 0;
            }
            i3 = i2 > 0 ? 0 : i3;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                i3 |= (((byte) inputStream.read()) & AVFrame.FRM_STATE_UNKOWN) << (i2 * 8);
            }
            if (z) {
                bArr = new byte[4];
                inputStream.read(bArr, 0, 4);
            } else {
                bArr = null;
            }
            this.f5308c = new byte[i3];
            int i4 = i3;
            int i5 = 0;
            while (i5 != i3) {
                int read3 = inputStream.read(this.f5308c, i5, i4);
                i5 += read3;
                i4 -= read3;
            }
            if (z) {
                while (true) {
                    byte[] bArr2 = this.f5308c;
                    if (i < bArr2.length) {
                        bArr2[i] = (byte) (bArr2[i] ^ bArr[i % 4]);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } else if (b2 == 8) {
            this.f5309d = true;
        } else {
            throw new IOException("Invalid Frame: Opcode: " + this.f5306a);
        }
    }

    public static void a(ByteBuffer byteBuffer, int i, boolean z) {
        int i2;
        int i3;
        if (i >= 0) {
            int i4 = z ? Base64.SIGN : 0;
            if (i > 65535) {
                byteBuffer.put((byte) (i4 | 127));
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) 0);
                byteBuffer.put((byte) ((i >> 24) & 255));
                byteBuffer.put((byte) ((i >> 16) & 255));
                i3 = (i >> 8) & 255;
            } else if (i >= 126) {
                byteBuffer.put((byte) (i4 | 126));
                i3 = i >> 8;
            } else {
                i2 = i | i4;
                byteBuffer.put((byte) i2);
                return;
            }
            byteBuffer.put((byte) i3);
            i2 = i & 255;
            byteBuffer.put((byte) i2);
            return;
        }
        throw new IllegalArgumentException("Length cannot be negative");
    }

    public byte[] b() {
        byte[] bArr = this.f5308c;
        int length = bArr.length + 6;
        if (bArr.length > 65535) {
            length += 8;
        } else if (bArr.length >= 126) {
            length += 2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        int i = 0;
        allocate.put((byte) ((this.f5306a & 15) | (this.f5307b ? (byte) 128 : 0)));
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr2 = {(byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255)};
        a(allocate, this.f5308c.length, true);
        allocate.put(bArr2);
        while (true) {
            byte[] bArr3 = this.f5308c;
            if (i >= bArr3.length) {
                allocate.flip();
                return allocate.array();
            }
            byte b2 = (byte) (bArr3[i] ^ bArr2[i % 4]);
            bArr3[i] = b2;
            allocate.put(b2);
            i++;
        }
    }
}
