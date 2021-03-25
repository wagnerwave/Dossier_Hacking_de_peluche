package a.d.a.a.e.m;

import a.d.a.a.e.k.l.i;
import android.content.Intent;

public final class v extends e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f1416a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f1417b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f1418c;

    public v(Intent intent, i iVar, int i) {
        this.f1416a = intent;
        this.f1417b = iVar;
        this.f1418c = i;
    }

    public final void a() {
        Intent intent = this.f1416a;
        if (intent != null) {
            this.f1417b.startActivityForResult(intent, this.f1418c);
        }
    }
}
