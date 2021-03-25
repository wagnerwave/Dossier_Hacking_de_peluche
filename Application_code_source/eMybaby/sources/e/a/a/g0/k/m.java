package e.a.a.g0.k;

import a.e.a.a.r.b;
import e.a.a.h0.a;
import e.a.a.h0.d;
import e.a.a.j0.c;
import java.io.OutputStream;
import java.net.Socket;

public class m implements d, a {
    public static final byte[] g = {13, 10};

    /* renamed from: a  reason: collision with root package name */
    public OutputStream f5120a;

    /* renamed from: b  reason: collision with root package name */
    public e.a.a.l0.a f5121b;

    /* renamed from: c  reason: collision with root package name */
    public String f5122c = "US-ASCII";

    /* renamed from: d  reason: collision with root package name */
    public boolean f5123d;

    /* renamed from: e  reason: collision with root package name */
    public int f5124e;
    public i f;

    public m(Socket socket, int i, c cVar) {
        boolean z = true;
        this.f5123d = true;
        this.f5124e = 512;
        if (socket != null) {
            i = i < 0 ? socket.getSendBufferSize() : i;
            i = i < 1024 ? 1024 : i;
            OutputStream outputStream = socket.getOutputStream();
            if (outputStream == null) {
                throw new IllegalArgumentException("Input stream may not be null");
            } else if (i <= 0) {
                throw new IllegalArgumentException("Buffer size may not be negative or zero");
            } else if (cVar != null) {
                this.f5120a = outputStream;
                this.f5121b = new e.a.a.l0.a(i);
                String y = b.y(cVar);
                this.f5122c = y;
                if (!y.equalsIgnoreCase("US-ASCII") && !this.f5122c.equalsIgnoreCase("ASCII")) {
                    z = false;
                }
                this.f5123d = z;
                this.f5124e = cVar.b("http.connection.min-chunk-limit", 512);
                this.f = new i();
            } else {
                throw new IllegalArgumentException("HTTP parameters may not be null");
            }
        } else {
            throw new IllegalArgumentException("Socket may not be null");
        }
    }

    public i a() {
        return this.f;
    }

    public void b(String str) {
        if (str != null) {
            if (str.length() > 0) {
                f(str.getBytes(this.f5122c));
            }
            f(g);
        }
    }

    public void c(e.a.a.l0.b bVar) {
        int i;
        if (bVar != null) {
            if (this.f5123d) {
                int i2 = bVar.f5184b;
                int i3 = 0;
                while (i2 > 0) {
                    e.a.a.l0.a aVar = this.f5121b;
                    int min = Math.min(aVar.f5181a.length - aVar.f5182b, i2);
                    boolean z = true;
                    if (min > 0) {
                        e.a.a.l0.a aVar2 = this.f5121b;
                        if (aVar2 != null) {
                            char[] cArr = bVar.f5183a;
                            if (cArr != null) {
                                if (i3 < 0 || i3 > cArr.length || min < 0 || (i = i3 + min) < 0 || i > cArr.length) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("off: ");
                                    stringBuffer.append(i3);
                                    stringBuffer.append(" len: ");
                                    stringBuffer.append(min);
                                    stringBuffer.append(" b.length: ");
                                    stringBuffer.append(cArr.length);
                                    throw new IndexOutOfBoundsException(stringBuffer.toString());
                                } else if (min != 0) {
                                    int i4 = aVar2.f5182b;
                                    int i5 = min + i4;
                                    if (i5 > aVar2.f5181a.length) {
                                        aVar2.b(i5);
                                    }
                                    int i6 = i3;
                                    while (i4 < i5) {
                                        aVar2.f5181a[i4] = (byte) cArr[i6];
                                        i6++;
                                        i4++;
                                    }
                                    aVar2.f5182b = i5;
                                }
                            }
                        } else {
                            throw null;
                        }
                    }
                    e.a.a.l0.a aVar3 = this.f5121b;
                    if (aVar3.f5182b != aVar3.f5181a.length) {
                        z = false;
                    }
                    if (z) {
                        e();
                    }
                    i3 += min;
                    i2 -= min;
                }
            } else {
                f(bVar.toString().getBytes(this.f5122c));
            }
            f(g);
        }
    }

    public void d(int i) {
        e.a.a.l0.a aVar = this.f5121b;
        if (aVar.f5182b == aVar.f5181a.length) {
            e();
        }
        e.a.a.l0.a aVar2 = this.f5121b;
        int i2 = aVar2.f5182b + 1;
        if (i2 > aVar2.f5181a.length) {
            aVar2.b(i2);
        }
        aVar2.f5181a[aVar2.f5182b] = (byte) i;
        aVar2.f5182b = i2;
    }

    public void e() {
        e.a.a.l0.a aVar = this.f5121b;
        int i = aVar.f5182b;
        if (i > 0) {
            this.f5120a.write(aVar.f5181a, 0, i);
            this.f5121b.f5182b = 0;
            this.f.a((long) i);
        }
    }

    public void f(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
        }
    }

    public void flush() {
        e();
        this.f5120a.flush();
    }

    public int length() {
        return this.f5121b.f5182b;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i2 <= this.f5124e) {
                e.a.a.l0.a aVar = this.f5121b;
                byte[] bArr2 = aVar.f5181a;
                if (i2 <= bArr2.length) {
                    if (i2 > bArr2.length - aVar.f5182b) {
                        e();
                    }
                    this.f5121b.a(bArr, i, i2);
                    return;
                }
            }
            e();
            this.f5120a.write(bArr, i, i2);
            this.f.a((long) i2);
        }
    }
}
