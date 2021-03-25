package a.i.a;

import a.i.a.j;
import a.i.a.t;
import a.i.a.y;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.os.Handler;
import java.io.IOException;
import java.io.InputStream;

public class r extends y {

    /* renamed from: a  reason: collision with root package name */
    public final j f3650a;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f3651b;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public r(j jVar, a0 a0Var) {
        this.f3650a = jVar;
        this.f3651b = a0Var;
    }

    public boolean c(w wVar) {
        String scheme = wVar.f3680d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    public int e() {
        return 2;
    }

    public y.a f(w wVar, int i) {
        t.d dVar = t.d.DISK;
        t.d dVar2 = t.d.NETWORK;
        j.a a2 = this.f3650a.a(wVar.f3680d, wVar.f3679c);
        if (a2 == null) {
            return null;
        }
        t.d dVar3 = a2.f3621c ? dVar : dVar2;
        Bitmap bitmap = a2.f3620b;
        if (bitmap != null) {
            g0.d(bitmap, "bitmap == null");
            return new y.a(bitmap, (InputStream) null, dVar3, 0);
        }
        InputStream inputStream = a2.f3619a;
        if (inputStream == null) {
            return null;
        }
        if (dVar3 == dVar && a2.f3622d == 0) {
            g0.e(inputStream);
            throw new a("Received response with 0 content-length header.");
        }
        if (dVar3 == dVar2) {
            long j = a2.f3622d;
            if (j > 0) {
                Handler handler = this.f3651b.f3579c;
                handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
            }
        }
        return new y.a(inputStream, dVar3);
    }

    public boolean g(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    public boolean h() {
        return true;
    }
}
