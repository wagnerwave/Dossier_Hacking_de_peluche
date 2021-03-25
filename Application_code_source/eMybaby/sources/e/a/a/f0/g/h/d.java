package e.a.a.f0.g.h;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f4935b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f4936c;

    public d(String str) {
        this(str, "text/plain", (Charset) null);
    }

    public d(String str, String str2, Charset charset) {
        super(str2);
        if (str != null) {
            charset = charset == null ? Charset.forName("US-ASCII") : charset;
            this.f4935b = str.getBytes(charset.name());
            this.f4936c = charset;
            return;
        }
        throw new IllegalArgumentException("Text may not be null");
    }

    public String a() {
        return "8bit";
    }

    public String b() {
        return this.f4936c.name();
    }

    public String c() {
        return null;
    }

    public long getContentLength() {
        return (long) this.f4935b.length;
    }

    public void writeTo(OutputStream outputStream) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f4935b);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }
}
