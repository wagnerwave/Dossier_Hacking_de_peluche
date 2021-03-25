package a.d.a.a.e.k.l;

import a.d.a.a.e.k.l.f;
import a.d.a.a.e.m.j;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f1343a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f1344b;

    public x(f.b bVar, ConnectionResult connectionResult) {
        this.f1344b = bVar;
        this.f1343a = connectionResult;
    }

    public final void run() {
        ConnectionResult connectionResult;
        j jVar;
        f.b bVar = this.f1344b;
        f.a aVar = f.this.i.get(bVar.f1291b);
        if (aVar != null) {
            if (this.f1343a.h()) {
                f.b bVar2 = this.f1344b;
                bVar2.f1294e = true;
                if (bVar2.f1290a.j()) {
                    f.b bVar3 = this.f1344b;
                    if (bVar3.f1294e && (jVar = bVar3.f1292c) != null) {
                        bVar3.f1290a.c(jVar, bVar3.f1293d);
                        return;
                    }
                    return;
                }
                try {
                    this.f1344b.f1290a.c((j) null, this.f1344b.f1290a.b());
                } catch (SecurityException e2) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                    connectionResult = new ConnectionResult(10);
                }
            } else {
                connectionResult = this.f1343a;
                aVar.g(connectionResult);
            }
        }
    }
}
