package a.d.a.a.e.k.l;

import a.c.a.f.b;
import a.d.a.a.e.k.a;
import a.d.a.a.e.k.d;
import a.d.a.a.e.k.l.f;
import a.d.a.a.e.m.c;
import a.d.a.a.j.b.d;
import a.d.a.a.j.e;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class d0 extends d implements d.a, d.b {
    public static a.C0057a<? extends e, a.d.a.a.j.a> h = a.d.a.a.j.d.f2681c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1275a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f1276b;

    /* renamed from: c  reason: collision with root package name */
    public final a.C0057a<? extends e, a.d.a.a.j.a> f1277c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Scope> f1278d;

    /* renamed from: e  reason: collision with root package name */
    public c f1279e;
    public e f;
    public e0 g;

    @WorkerThread
    public d0(Context context, Handler handler, @NonNull c cVar) {
        a.C0057a<? extends e, a.d.a.a.j.a> aVar = h;
        this.f1275a = context;
        this.f1276b = handler;
        b.l(cVar, "ClientSettings must not be null");
        this.f1279e = cVar;
        this.f1278d = cVar.f1372b;
        this.f1277c = aVar;
    }

    @WorkerThread
    public final void e(int i) {
        this.f.disconnect();
    }

    @WorkerThread
    public final void g(@NonNull ConnectionResult connectionResult) {
        ((f.b) this.g).b(connectionResult);
    }

    @WorkerThread
    public final void h(@Nullable Bundle bundle) {
        this.f.d(this);
    }
}
