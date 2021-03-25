package com.google.android.gms.common.api.internal;

import a.d.a.a.e.k.e;
import a.d.a.a.e.k.g;
import a.d.a.a.e.k.i;
import a.d.a.a.e.k.j;
import a.d.a.a.e.k.l.h0;
import a.d.a.a.e.k.l.q0;
import a.d.a.a.h.d.d;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends i> extends e<R> {
    public static final ThreadLocal<Boolean> l = new q0();

    /* renamed from: a  reason: collision with root package name */
    public final Object f4210a;

    /* renamed from: b  reason: collision with root package name */
    public final a<R> f4211b;

    /* renamed from: c  reason: collision with root package name */
    public final CountDownLatch f4212c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<e.a> f4213d;

    /* renamed from: e  reason: collision with root package name */
    public j<? super R> f4214e;
    public final AtomicReference<h0> f;
    public R g;
    public Status h;
    public volatile boolean i;
    public boolean j;
    public boolean k;
    @KeepName
    public b mResultGuardian;

    public static class a<R extends i> extends d {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                j jVar = (j) pair.first;
                i iVar = (i) pair.second;
                try {
                    jVar.a(iVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.g(iVar);
                    throw e2;
                }
            } else if (i != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).h(Status.h);
            }
        }
    }

    public final class b {
        public b(q0 q0Var) {
        }

        public final void finalize() {
            BasePendingResult.g(BasePendingResult.this.g);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.f4210a = new Object();
        this.f4212c = new CountDownLatch(1);
        this.f4213d = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.k = false;
        this.f4211b = new a<>(Looper.getMainLooper());
        new WeakReference((Object) null);
    }

    public BasePendingResult(a.d.a.a.e.k.d dVar) {
        this.f4210a = new Object();
        this.f4212c = new CountDownLatch(1);
        this.f4213d = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.k = false;
        this.f4211b = new a<>(dVar != null ? dVar.b() : Looper.getMainLooper());
        new WeakReference(dVar);
    }

    public static void g(i iVar) {
        if (iVar instanceof g) {
            try {
                ((g) iVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(iVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    public final void a(e.a aVar) {
        a.c.a.f.b.e(true, "Callback cannot be null.");
        synchronized (this.f4210a) {
            if (d()) {
                aVar.a(this.h);
            } else {
                this.f4213d.add(aVar);
            }
        }
    }

    @NonNull
    public abstract R b(Status status);

    public final R c() {
        R r;
        synchronized (this.f4210a) {
            a.c.a.f.b.o(!this.i, "Result has already been consumed.");
            a.c.a.f.b.o(d(), "Result is not ready.");
            r = this.g;
            this.g = null;
            this.f4214e = null;
            this.i = true;
        }
        h0 andSet = this.f.getAndSet((Object) null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    public final boolean d() {
        return this.f4212c.getCount() == 0;
    }

    public final void e(R r) {
        synchronized (this.f4210a) {
            if (!this.j) {
                d();
                boolean z = true;
                a.c.a.f.b.o(!d(), "Results have already been set");
                if (this.i) {
                    z = false;
                }
                a.c.a.f.b.o(z, "Result has already been consumed");
                f(r);
                return;
            }
            g(r);
        }
    }

    public final void f(R r) {
        this.g = r;
        this.f4212c.countDown();
        this.h = this.g.getStatus();
        if (this.f4214e != null) {
            this.f4211b.removeMessages(2);
            a<R> aVar = this.f4211b;
            j<? super R> jVar = this.f4214e;
            i c2 = c();
            if (aVar != null) {
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(jVar, c2)));
            } else {
                throw null;
            }
        } else if (this.g instanceof g) {
            this.mResultGuardian = new b((q0) null);
        }
        ArrayList<e.a> arrayList = this.f4213d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            e.a aVar2 = arrayList.get(i2);
            i2++;
            aVar2.a(this.h);
        }
        this.f4213d.clear();
    }

    public final void h(Status status) {
        synchronized (this.f4210a) {
            if (!d()) {
                e(b(status));
                this.j = true;
            }
        }
    }
}
