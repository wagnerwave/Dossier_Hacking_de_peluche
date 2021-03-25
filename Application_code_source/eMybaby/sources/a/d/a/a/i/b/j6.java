package a.d.a.a.i.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

public final class j6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f6 f2297a;

    public j6(f6 f6Var) {
        this.f2297a = f6Var;
    }

    public final void run() {
        ca caVar = this.f2297a.n;
        caVar.f2141a.f().b();
        if (caVar.c()) {
            if (caVar.b()) {
                caVar.f2141a.o().A.b((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                caVar.f2141a.s().H("auto", "_cmpx", bundle);
            } else {
                String a2 = caVar.f2141a.o().A.a();
                if (TextUtils.isEmpty(a2)) {
                    caVar.f2141a.i().g.a("Cache still valid but referrer not found");
                } else {
                    long a3 = ((caVar.f2141a.o().B.a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(a2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", a3);
                    caVar.f2141a.s().H((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                caVar.f2141a.o().A.b((String) null);
            }
            caVar.f2141a.o().B.b(0);
        }
    }
}
