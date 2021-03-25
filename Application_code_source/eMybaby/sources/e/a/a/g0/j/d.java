package e.a.a.g0.j;

import e.a.a.c;
import e.a.a.l;
import e.a.a.q;
import e.a.a.v;

public class d implements e.a.a.f0.d {
    public long a(l lVar) {
        if (lVar != null) {
            c l = lVar.l("Transfer-Encoding");
            c l2 = lVar.l("Content-Length");
            if (l != null) {
                String value = l.getValue();
                if ("chunked".equalsIgnoreCase(value)) {
                    if (!lVar.v().c(q.f5193e)) {
                        return -2;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Chunked transfer encoding not allowed for ");
                    stringBuffer.append(lVar.v());
                    throw new v(stringBuffer.toString());
                } else if ("identity".equalsIgnoreCase(value)) {
                    return -1;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Unsupported transfer encoding: ");
                    stringBuffer2.append(value);
                    throw new v(stringBuffer2.toString());
                }
            } else if (l2 == null) {
                return -1;
            } else {
                String value2 = l2.getValue();
                try {
                    long parseLong = Long.parseLong(value2);
                    if (parseLong >= 0) {
                        return parseLong;
                    }
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Negative content length: ");
                    stringBuffer3.append(value2);
                    throw new v(stringBuffer3.toString());
                } catch (NumberFormatException unused) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Invalid content length: ");
                    stringBuffer4.append(value2);
                    throw new v(stringBuffer4.toString());
                }
            }
        } else {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
    }
}
