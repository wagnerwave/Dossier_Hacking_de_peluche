package a.d.a.a.i.b;

import a.c.a.f.b;
import androidx.annotation.WorkerThread;
import java.util.List;
import java.util.Map;

@WorkerThread
public final class g4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final d4 f2206a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2207b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f2208c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f2209d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2210e;
    public final Map<String, List<String>> f;

    public g4(String str, d4 d4Var, int i, Throwable th, byte[] bArr, Map map, e4 e4Var) {
        b.k(d4Var);
        this.f2206a = d4Var;
        this.f2207b = i;
        this.f2208c = th;
        this.f2209d = bArr;
        this.f2210e = str;
        this.f = map;
    }

    public final void run() {
        this.f2206a.a(this.f2210e, this.f2207b, this.f2208c, this.f2209d, this.f);
    }
}
