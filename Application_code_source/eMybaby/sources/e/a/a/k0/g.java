package e.a.a.k0;

import com.tuya.smart.common.oOO0O0O0;
import e.a.a.h;
import e.a.a.i0.l;
import e.a.a.m;
import e.a.a.n;
import e.a.a.q;
import e.a.a.v;
import e.a.a.w;

public class g implements n {
    public void b(m mVar, c cVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (!(mVar instanceof h)) {
        } else {
            if (mVar.j("Transfer-Encoding")) {
                throw new v("Transfer-encoding header already present");
            } else if (!mVar.j("Content-Length")) {
                w wVar = ((l) mVar.f()).f5153a;
                e.a.a.g b2 = ((h) mVar).b();
                if (b2 == null) {
                    mVar.e("Content-Length", oOO0O0O0.O0000oO0);
                    return;
                }
                if (!b2.c() && b2.getContentLength() >= 0) {
                    mVar.e("Content-Length", Long.toString(b2.getContentLength()));
                } else if (!wVar.c(q.f5193e)) {
                    mVar.e("Transfer-Encoding", "chunked");
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Chunked transfer encoding not allowed for ");
                    stringBuffer.append(wVar);
                    throw new v(stringBuffer.toString());
                }
                if (b2.getContentType() != null && !mVar.j("Content-Type")) {
                    mVar.h(b2.getContentType());
                }
                if (b2.b() != null && !mVar.j("Content-Encoding")) {
                    mVar.h(b2.b());
                }
            } else {
                throw new v("Content-Length header already present");
            }
        }
    }
}
