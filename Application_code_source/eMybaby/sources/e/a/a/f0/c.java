package e.a.a.f0;

import e.a.a.g;
import e.a.a.l0.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class c extends e {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f4907b;

    /* JADX INFO: finally extract failed */
    public c(g gVar) {
        super(gVar);
        byte[] bArr;
        InputStream content;
        if ((!gVar.isRepeatable() || gVar.getContentLength() < 0) && (content = gVar.getContent()) != null) {
            try {
                if (gVar.getContentLength() <= 2147483647L) {
                    int contentLength = (int) gVar.getContentLength();
                    a aVar = new a(contentLength < 0 ? 4096 : contentLength);
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int read = content.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        aVar.a(bArr2, 0, read);
                    }
                    int i = aVar.f5182b;
                    byte[] bArr3 = new byte[i];
                    if (i > 0) {
                        System.arraycopy(aVar.f5181a, 0, bArr3, 0, i);
                    }
                    content.close();
                    bArr = bArr3;
                } else {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
            } catch (Throwable th) {
                content.close();
                throw th;
            }
        } else {
            bArr = null;
        }
        this.f4907b = bArr;
    }

    public boolean c() {
        return this.f4907b == null && this.f4908a.c();
    }

    public InputStream getContent() {
        return this.f4907b != null ? new ByteArrayInputStream(this.f4907b) : this.f4908a.getContent();
    }

    public long getContentLength() {
        byte[] bArr = this.f4907b;
        return bArr != null ? (long) bArr.length : this.f4908a.getContentLength();
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return this.f4907b == null && this.f4908a.isStreaming();
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            byte[] bArr = this.f4907b;
            if (bArr != null) {
                outputStream.write(bArr);
            } else {
                this.f4908a.writeTo(outputStream);
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }
}
