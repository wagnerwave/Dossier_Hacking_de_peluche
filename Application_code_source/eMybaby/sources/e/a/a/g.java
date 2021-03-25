package e.a.a;

import java.io.InputStream;
import java.io.OutputStream;

public interface g {
    c b();

    boolean c();

    InputStream getContent();

    long getContentLength();

    c getContentType();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream);
}
