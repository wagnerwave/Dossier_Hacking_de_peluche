package e.a.a.f0;

import java.io.InputStream;
import java.io.OutputStream;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f4905d;

    /* renamed from: e  reason: collision with root package name */
    public long f4906e = -1;

    public InputStream getContent() {
        InputStream inputStream = this.f4905d;
        if (inputStream != null) {
            return inputStream;
        }
        throw new IllegalStateException("Content has not been provided");
    }

    public long getContentLength() {
        return this.f4906e;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return this.f4905d != null;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            InputStream content = getContent();
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = content.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                }
            } finally {
                content.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }
}
