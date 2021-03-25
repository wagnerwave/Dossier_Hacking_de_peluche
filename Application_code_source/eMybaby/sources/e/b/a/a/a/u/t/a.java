package e.b.a.a.a.u.t;

import java.io.InputStream;

public class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f5320a;

    /* renamed from: b  reason: collision with root package name */
    public int f5321b = 0;

    public a(InputStream inputStream) {
        this.f5320a = inputStream;
    }

    public int read() {
        int read = this.f5320a.read();
        if (read != -1) {
            this.f5321b++;
        }
        return read;
    }
}
