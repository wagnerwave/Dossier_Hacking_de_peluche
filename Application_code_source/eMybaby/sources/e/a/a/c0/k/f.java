package e.a.a.c0.k;

import a.e.a.a.r.b;
import e.a.a.d0.d;
import e.a.a.d0.g;
import e.a.a.i0.a;
import e.a.a.i0.l;
import e.a.a.i0.p;
import e.a.a.j0.c;
import e.a.a.w;
import e.a.a.y;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class f extends a implements g, a, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public Lock f4846c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public boolean f4847d;

    /* renamed from: e  reason: collision with root package name */
    public URI f4848e;

    public Object clone() {
        f fVar = (f) super.clone();
        fVar.f4846c = new ReentrantLock();
        fVar.f4847d = false;
        fVar.f5125a = (p) b.d(this.f5125a);
        fVar.f5126b = (c) b.d(this.f5126b);
        return fVar;
    }

    public y f() {
        String t = t();
        w v = v();
        URI uri = this.f4848e;
        String str = null;
        if (uri != null) {
            str = uri.toASCIIString();
        }
        if (str == null || str.length() == 0) {
            str = "/";
        }
        return new l(t, str, v);
    }

    public URI i() {
        return this.f4848e;
    }

    public void k(g gVar) {
        this.f4846c.lock();
        try {
            if (this.f4847d) {
                throw new IOException("Request already aborted");
            }
        } finally {
            this.f4846c.unlock();
        }
    }

    public abstract String t();

    public void u(d dVar) {
        this.f4846c.lock();
        try {
            if (this.f4847d) {
                throw new IOException("Request already aborted");
            }
        } finally {
            this.f4846c.unlock();
        }
    }

    public w v() {
        return b.E(getParams());
    }
}
