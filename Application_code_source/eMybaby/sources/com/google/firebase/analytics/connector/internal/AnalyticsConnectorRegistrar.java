package com.google.firebase.analytics.connector.internal;

import a.c.a.f.b;
import a.d.b.c;
import a.d.b.f.a.a;
import a.d.b.g.d;
import a.d.b.g.i;
import a.d.b.g.q;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;

@Keep
public class AnalyticsConnectorRegistrar implements i {
    @SuppressLint({"MissingPermission"})
    @Keep
    public List<d<?>> getComponents() {
        d[] dVarArr = new d[2];
        d.b<a> a2 = d.a(a.class);
        a2.a(q.b(c.class));
        a2.a(q.b(Context.class));
        a2.a(q.b(a.d.b.h.d.class));
        a2.c(a.d.b.f.a.c.a.f2731a);
        if (a2.f2744c == 0) {
            a2.f2744c = 2;
            dVarArr[0] = a2.b();
            dVarArr[1] = b.q("fire-analytics", "17.5.0");
            return Arrays.asList(dVarArr);
        }
        throw new IllegalStateException("Instantiation type has already been set.");
    }
}
