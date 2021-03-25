package a.d.a.a.i.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class l8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2355a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2356b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2357c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2358d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f2359e;
    public final /* synthetic */ zzn f;
    public final /* synthetic */ u7 g;

    public l8(u7 u7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzn zzn) {
        this.g = u7Var;
        this.f2355a = atomicReference;
        this.f2356b = str;
        this.f2357c = str2;
        this.f2358d = str3;
        this.f2359e = z;
        this.f = zzn;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<zzkw> y;
        synchronized (this.f2355a) {
            try {
                p3 p3Var = this.g.f2549d;
                if (p3Var == null) {
                    this.g.i().f.d("(legacy) Failed to get user properties; not connected to service", x3.s(this.f2356b), this.f2357c, this.f2358d);
                    this.f2355a.set(Collections.emptyList());
                    this.f2355a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f2356b)) {
                    atomicReference2 = this.f2355a;
                    y = p3Var.j(this.f2357c, this.f2358d, this.f2359e, this.f);
                } else {
                    atomicReference2 = this.f2355a;
                    y = p3Var.y(this.f2356b, this.f2357c, this.f2358d, this.f2359e);
                }
                atomicReference2.set(y);
                this.g.H();
                atomicReference = this.f2355a;
                atomicReference.notify();
            } catch (RemoteException e2) {
                try {
                    this.g.i().f.d("(legacy) Failed to get user properties; remote exception", x3.s(this.f2356b), this.f2357c, e2);
                    this.f2355a.set(Collections.emptyList());
                    atomicReference = this.f2355a;
                } catch (Throwable th) {
                    this.f2355a.notify();
                    throw th;
                }
            }
        }
    }
}
