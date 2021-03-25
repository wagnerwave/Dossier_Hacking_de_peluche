package e.a.a.g0.j;

import e.a.a.f0.d;
import e.a.a.l;
import e.a.a.u;
import e.a.a.v;

public class c implements d {
    public long a(l lVar) {
        long j;
        if (lVar != null) {
            boolean f = lVar.getParams().f("http.protocol.strict-transfer-encoding");
            e.a.a.c l = lVar.l("Transfer-Encoding");
            e.a.a.c l2 = lVar.l("Content-Length");
            if (l != null) {
                try {
                    e.a.a.d[] c2 = l.c();
                    if (f) {
                        int i = 0;
                        while (i < c2.length) {
                            String name = c2[i].getName();
                            if (name == null || name.length() <= 0 || name.equalsIgnoreCase("chunked") || name.equalsIgnoreCase("identity")) {
                                i++;
                            } else {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("Unsupported transfer encoding: ");
                                stringBuffer.append(name);
                                throw new v(stringBuffer.toString());
                            }
                        }
                    }
                    int length = c2.length;
                    if ("identity".equalsIgnoreCase(l.getValue())) {
                        return -1;
                    }
                    if (length > 0 && "chunked".equalsIgnoreCase(c2[length - 1].getName())) {
                        return -2;
                    }
                    if (!f) {
                        return -1;
                    }
                    throw new v("Chunk-encoding must be the last one applied");
                } catch (u e2) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Invalid Transfer-Encoding header value: ");
                    stringBuffer2.append(l);
                    throw new v(stringBuffer2.toString(), e2);
                }
            } else {
                if (l2 != null) {
                    e.a.a.c[] p = lVar.p("Content-Length");
                    if (!f || p.length <= 1) {
                        int length2 = p.length - 1;
                        while (true) {
                            if (length2 < 0) {
                                j = -1;
                                break;
                            }
                            e.a.a.c cVar = p[length2];
                            try {
                                j = Long.parseLong(cVar.getValue());
                                break;
                            } catch (NumberFormatException unused) {
                                if (!f) {
                                    length2--;
                                } else {
                                    StringBuffer stringBuffer3 = new StringBuffer();
                                    stringBuffer3.append("Invalid content length: ");
                                    stringBuffer3.append(cVar.getValue());
                                    throw new v(stringBuffer3.toString());
                                }
                            }
                        }
                        if (j >= 0) {
                            return j;
                        }
                    } else {
                        throw new v("Multiple content length headers");
                    }
                }
                return -1;
            }
        } else {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
    }
}
