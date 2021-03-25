package e.a.a.g0.h;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.logging.Log;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final Log f5034a;

    public n(Log log) {
        this.f5034a = log;
    }

    public boolean a() {
        return this.f5034a.isDebugEnabled();
    }

    public void b(byte[] bArr) {
        if (bArr != null) {
            c(">> ", new ByteArrayInputStream(bArr));
            return;
        }
        throw new IllegalArgumentException("Output may not be null");
    }

    public final void c(String str, InputStream inputStream) {
        String str2;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            if (read == 13) {
                str2 = "[\\r]";
            } else if (read == 10) {
                sb.append("[\\n]\"");
                sb.insert(0, "\"");
                sb.insert(0, str);
                this.f5034a.debug(sb.toString());
                sb.setLength(0);
            } else if (read < 32 || read > 127) {
                sb.append("[0x");
                sb.append(Integer.toHexString(read));
                str2 = "]";
            } else {
                sb.append((char) read);
            }
            sb.append(str2);
        }
        if (sb.length() > 0) {
            sb.append('\"');
            sb.insert(0, '\"');
            sb.insert(0, str);
            this.f5034a.debug(sb.toString());
        }
    }
}
