package a.d.a.a.e.m;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Account f1371a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Scope> f1372b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Scope> f1373c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<a.d.a.a.e.k.a<?>, b> f1374d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1375e;
    public final String f;
    public final a.d.a.a.j.a g;
    public Integer h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Account f1376a;

        /* renamed from: b  reason: collision with root package name */
        public ArraySet<Scope> f1377b;

        /* renamed from: c  reason: collision with root package name */
        public int f1378c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f1379d;

        /* renamed from: e  reason: collision with root package name */
        public String f1380e;
        public a.d.a.a.j.a f = a.d.a.a.j.a.j;

        public final c a() {
            return new c(this.f1376a, this.f1377b, (Map<a.d.a.a.e.k.a<?>, b>) null, this.f1378c, (View) null, this.f1379d, this.f1380e, this.f, false);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f1381a;
    }

    public c(Account account, Set<Scope> set, Map<a.d.a.a.e.k.a<?>, b> map, int i, View view, String str, String str2, a.d.a.a.j.a aVar, boolean z) {
        this.f1371a = account;
        this.f1372b = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f1374d = Collections.emptyMap();
        this.f1375e = str;
        this.f = str2;
        this.g = aVar;
        HashSet hashSet = new HashSet(this.f1372b);
        for (b bVar : this.f1374d.values()) {
            hashSet.addAll(bVar.f1381a);
        }
        this.f1373c = Collections.unmodifiableSet(hashSet);
    }
}
