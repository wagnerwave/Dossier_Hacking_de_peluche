package e.a.a.f0.g.h;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public final File f4932b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4933c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4934d = null;

    public c(File file) {
        super("application/octet-stream");
        this.f4932b = file;
        this.f4933c = file.getName();
    }

    public String a() {
        return "binary";
    }

    public String b() {
        return this.f4934d;
    }

    public String c() {
        return this.f4933c;
    }

    public long getContentLength() {
        return this.f4932b.length();
    }

    public void writeTo(OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(this.f4932b);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }
}
