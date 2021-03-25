package a.d.a.a.i.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzw;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class j8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2303b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2304c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2305d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ zzn f2306e;
    public final /* synthetic */ u7 f;

    public j8(u7 u7Var, AtomicReference atomicReference, String str, String str2, String str3, zzn zzn) {
        this.f = u7Var;
        this.f2302a = atomicReference;
        this.f2303b = str;
        this.f2304c = str2;
        this.f2305d = str3;
        this.f2306e = zzn;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<zzw> Q;
        synchronized (this.f2302a) {
            try {
                p3 p3Var = this.f.f2549d;
                if (p3Var == null) {
                    this.f.i().f.d("(legacy) Failed to get conditional properties; not connected to service", x3.s(this.f2303b), this.f2304c, this.f2305d);
                    this.f2302a.set(Collections.emptyList());
                    this.f2302a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f2303b)) {
                    atomicReference2 = this.f2302a;
                    Q = p3Var.S(this.f2304c, this.f2305d, this.f2306e);
                } else {
                    atomicReference2 = this.f2302a;
                    Q = p3Var.Q(this.f2303b, this.f2304c, this.f2305d);
                }
                atomicReference2.set(Q);
                this.f.H();
                atomicReference = this.f2302a;
                atomicReference.notify();
            } catch (RemoteException e2) {
                try {
                    this.f.i().f.d("(legacy) Failed to get conditional properties; remote exception", x3.s(this.f2303b), this.f2304c, e2);
                    this.f2302a.set(Collections.emptyList());
                    atomicReference = this.f2302a;
                } catch (Throwable th) {
                    this.f2302a.notify();
                    throw th;
                }
            }
        }
    }
}
