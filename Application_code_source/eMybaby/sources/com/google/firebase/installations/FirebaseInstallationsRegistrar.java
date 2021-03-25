package com.google.firebase.installations;

import a.c.a.f.b;
import a.d.b.g.d;
import a.d.b.g.e;
import a.d.b.g.i;
import a.d.b.g.q;
import a.d.b.k.c;
import a.d.b.k.d;
import a.d.b.m.f;
import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInstallationsRegistrar implements i {
    public static /* synthetic */ d lambda$getComponents$0(e eVar) {
        return new c((a.d.b.c) eVar.a(a.d.b.c.class), (f) eVar.a(f.class), (a.d.b.i.c) eVar.a(a.d.b.i.c.class));
    }

    public List<a.d.b.g.d<?>> getComponents() {
        d.b<a.d.b.k.d> a2 = a.d.b.g.d.a(a.d.b.k.d.class);
        a2.a(q.b(a.d.b.c.class));
        a2.a(q.b(a.d.b.i.c.class));
        a2.a(q.b(f.class));
        a2.c(a.d.b.k.f.f2797a);
        return Arrays.asList(new a.d.b.g.d[]{a2.b(), b.q("fire-installations", "16.3.2")});
    }
}
