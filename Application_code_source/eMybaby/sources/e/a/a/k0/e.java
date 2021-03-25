package e.a.a.k0;

import androidx.recyclerview.widget.RecyclerView;
import e.a.a.h;
import e.a.a.i;
import e.a.a.i0.l;
import e.a.a.m;
import e.a.a.o;
import e.a.a.q;
import e.a.a.w;
import java.io.IOException;
import java.net.ProtocolException;

public class e {
    public boolean a(m mVar, o oVar) {
        int i;
        if ("HEAD".equalsIgnoreCase(((l) mVar.f()).f5154b) || (i = ((e.a.a.i0.m) oVar.s()).f5157b) < 200 || i == 204 || i == 304 || i == 205) {
            return false;
        }
        return true;
    }

    public o b(m mVar, e.a.a.e eVar, c cVar) {
        o oVar = null;
        int i = 0;
        while (true) {
            if (oVar != null && i >= 200) {
                return oVar;
            }
            oVar = eVar.f();
            if (a(mVar, oVar)) {
                eVar.a(oVar);
            }
            i = ((e.a.a.i0.m) oVar.s()).f5157b;
        }
    }

    public o c(m mVar, e.a.a.e eVar, c cVar) {
        cVar.e("http.connection", eVar);
        cVar.e("http.request_sent", Boolean.FALSE);
        eVar.sendRequestHeader(mVar);
        o oVar = null;
        if (mVar instanceof h) {
            boolean z = true;
            w wVar = ((l) mVar.f()).f5153a;
            h hVar = (h) mVar;
            if (hVar.c() && !wVar.c(q.f5193e)) {
                eVar.flush();
                if (eVar.d(mVar.getParams().b("http.protocol.wait-for-continue", RecyclerView.MAX_SCROLL_DURATION))) {
                    o f = eVar.f();
                    if (a(mVar, f)) {
                        eVar.a(f);
                    }
                    int i = ((e.a.a.i0.m) f.s()).f5157b;
                    if (i >= 200) {
                        z = false;
                        oVar = f;
                    } else if (i != 100) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Unexpected response: ");
                        stringBuffer.append(f.s());
                        throw new ProtocolException(stringBuffer.toString());
                    }
                }
            }
            if (z) {
                eVar.sendRequestEntity(hVar);
            }
        }
        eVar.flush();
        cVar.e("http.request_sent", Boolean.TRUE);
        return oVar;
    }

    public o d(m mVar, e.a.a.e eVar, c cVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("Client connection may not be null");
        } else if (cVar != null) {
            try {
                o c2 = c(mVar, eVar, cVar);
                return c2 == null ? b(mVar, eVar, cVar) : c2;
            } catch (IOException e2) {
                try {
                    eVar.close();
                } catch (IOException unused) {
                }
                throw e2;
            } catch (i e3) {
                try {
                    eVar.close();
                } catch (IOException unused2) {
                }
                throw e3;
            } catch (RuntimeException e4) {
                try {
                    eVar.close();
                } catch (IOException unused3) {
                }
                throw e4;
            }
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }

    public void e(o oVar, d dVar, c cVar) {
        if (dVar != null) {
            cVar.e("http.response", oVar);
            dVar.c(oVar, cVar);
            return;
        }
        throw new IllegalArgumentException("HTTP processor may not be null");
    }

    public void f(m mVar, d dVar, c cVar) {
        if (dVar != null) {
            cVar.e("http.request", mVar);
            dVar.b(mVar, cVar);
            return;
        }
        throw new IllegalArgumentException("HTTP processor may not be null");
    }
}
