package e.a.a.f0;

import e.a.a.c;
import e.a.a.g;
import java.io.InputStream;
import java.io.OutputStream;

public class e implements g {

    /* renamed from: a  reason: collision with root package name */
    public g f4908a;

    public e(g gVar) {
        if (gVar != null) {
            this.f4908a = gVar;
            return;
        }
        throw new IllegalArgumentException("wrapped entity must not be null");
    }

    public c b() {
        return this.f4908a.b();
    }

    public boolean c() {
        return this.f4908a.c();
    }

    public InputStream getContent() {
        return this.f4908a.getContent();
    }

    public long getContentLength() {
        return this.f4908a.getContentLength();
    }

    public c getContentType() {
        return this.f4908a.getContentType();
    }

    public boolean isRepeatable() {
        return this.f4908a.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f4908a.isStreaming();
    }

    public void writeTo(OutputStream outputStream) {
        this.f4908a.writeTo(outputStream);
    }
}
