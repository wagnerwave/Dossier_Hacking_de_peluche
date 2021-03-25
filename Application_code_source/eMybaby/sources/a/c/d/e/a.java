package a.c.d.e;

import a.d.a.a.h.g.f;
import a.d.a.a.h.g.m;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

public class a implements a.c.a.e.a {
    public a() {
        f fVar = FirebaseAnalytics.getInstance(a.c.a.a.f).f4305a;
        Boolean bool = Boolean.TRUE;
        if (fVar != null) {
            fVar.f1683c.execute(new m(fVar, bool));
            return;
        }
        throw null;
    }

    public void a(String str, String str2, String str3, Long l) {
        Bundle bundle = new Bundle();
        bundle.putString("value", str3);
        bundle.putString("item_category", str);
        if (str2.length() > 40) {
            str2 = str2.substring(0, 40);
        }
        String str4 = str2;
        bundle.putString("item_name", str4);
        FirebaseAnalytics.getInstance(a.c.a.a.f).f4305a.c((String) null, str4, bundle, false, true, (Long) null);
    }

    public void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("value", str);
        bundle.putString("item_name", "screen_name");
        FirebaseAnalytics.getInstance(a.c.a.a.f).f4305a.c((String) null, "screen_name", bundle, false, true, (Long) null);
    }
}
