package e.a.a.f0;

import e.a.a.i0.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class f extends a implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f4909d;

    public f(String str, String str2) {
        if (str != null) {
            str2 = str2 == null ? "ISO-8859-1" : str2;
            this.f4909d = str.getBytes(str2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("text/plain");
            stringBuffer.append("; charset=");
            stringBuffer.append(str2);
            String stringBuffer2 = stringBuffer.toString();
            d(stringBuffer2 != null ? new b("Content-Type", stringBuffer2) : null);
            return;
        }
        throw new IllegalArgumentException("Source string may not be null");
    }

    public Object clone() {
        return super.clone();
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.f4909d);
    }

    public long getContentLength() {
        return (long) this.f4909d.length;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            outputStream.write(this.f4909d);
            outputStream.flush();
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }
}
