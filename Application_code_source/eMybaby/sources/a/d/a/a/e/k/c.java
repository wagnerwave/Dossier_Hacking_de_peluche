package a.d.a.a.e.k;

import a.d.a.a.e.k.a;
import a.d.a.a.e.k.a.d;
import a.d.a.a.e.k.l.b;
import a.d.a.a.e.k.l.f;
import a.d.a.a.e.k.l.w;
import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class c<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1254a;

    /* renamed from: b  reason: collision with root package name */
    public final a<O> f1255b;

    /* renamed from: c  reason: collision with root package name */
    public final O f1256c;

    /* renamed from: d  reason: collision with root package name */
    public final b<O> f1257d;

    /* renamed from: e  reason: collision with root package name */
    public final Looper f1258e;
    public final int f;
    public final d g = new w(this);
    public final f h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final a.d.a.a.e.k.l.a f1259a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f1260b;

        /* renamed from: a.d.a.a.e.k.c$a$a  reason: collision with other inner class name */
        public static class C0059a {

            /* renamed from: a  reason: collision with root package name */
            public a.d.a.a.e.k.l.a f1261a;

            /* renamed from: b  reason: collision with root package name */
            public Looper f1262b;

            public a a() {
                if (this.f1261a == null) {
                    this.f1261a = new a.d.a.a.e.k.l.a();
                }
                if (this.f1262b == null) {
                    this.f1262b = Looper.getMainLooper();
                }
                return new a(this.f1261a, (Account) null, this.f1262b);
            }
        }

        static {
            new C0059a().a();
        }

        public a(a.d.a.a.e.k.l.a aVar, Account account, Looper looper) {
            this.f1259a = aVar;
            this.f1260b = looper;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: a.d.a.a.e.k.l.s0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: a.d.a.a.e.k.l.s0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: a.d.a.a.e.k.l.s0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: a.d.a.a.e.k.l.s0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: a.d.a.a.e.k.l.v0} */
    /* JADX WARNING: type inference failed for: r0v18, types: [a.d.a.a.e.k.l.v0, androidx.fragment.app.Fragment] */
    /* JADX WARNING: type inference failed for: r0v20, types: [a.d.a.a.e.k.l.v0, androidx.fragment.app.Fragment] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008b, code lost:
        if (r1 != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c7, code lost:
        if (r0 != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00da, code lost:
        if (r1 != false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0077, code lost:
        if (r0 != null) goto L_0x00fa;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(@androidx.annotation.NonNull android.app.Activity r4, a.d.a.a.e.k.a<O> r5, @androidx.annotation.Nullable O r6, a.d.a.a.e.k.l.a r7) {
        /*
            r3 = this;
            java.lang.String r0 = "StatusExceptionMapper must not be null."
            a.c.a.f.b.l(r7, r0)
            android.os.Looper r0 = r4.getMainLooper()
            java.lang.String r1 = "Looper must not be null."
            a.c.a.f.b.l(r0, r1)
            a.d.a.a.e.k.c$a r1 = new a.d.a.a.e.k.c$a
            r2 = 0
            r1.<init>(r7, r2, r0)
            r3.<init>()
            java.lang.String r7 = "Null activity is not permitted."
            a.c.a.f.b.l(r4, r7)
            java.lang.String r7 = "Api must not be null."
            a.c.a.f.b.l(r5, r7)
            java.lang.String r7 = "Settings must not be null; use Settings.DEFAULT_SETTINGS instead."
            a.c.a.f.b.l(r1, r7)
            android.content.Context r7 = r4.getApplicationContext()
            r3.f1254a = r7
            r3.f1255b = r5
            r3.f1256c = r6
            android.os.Looper r7 = r1.f1260b
            r3.f1258e = r7
            a.d.a.a.e.k.l.b r7 = new a.d.a.a.e.k.l.b
            r7.<init>(r5, r6)
            r3.f1257d = r7
            a.d.a.a.e.k.l.w r5 = new a.d.a.a.e.k.l.w
            r5.<init>(r3)
            r3.g = r5
            android.content.Context r5 = r3.f1254a
            a.d.a.a.e.k.l.f r5 = a.d.a.a.e.k.l.f.b(r5)
            r3.h = r5
            java.util.concurrent.atomic.AtomicInteger r5 = r5.g
            int r5 = r5.getAndIncrement()
            r3.f = r5
            boolean r5 = r4 instanceof com.google.android.gms.common.api.GoogleApiActivity
            if (r5 != 0) goto L_0x0124
            a.d.a.a.e.k.l.f r5 = r3.h
            a.d.a.a.e.k.l.b<O> r6 = r3.f1257d
            java.lang.String r7 = "Activity must not be null"
            a.c.a.f.b.l(r4, r7)
            boolean r7 = r4 instanceof androidx.fragment.app.FragmentActivity
            if (r7 == 0) goto L_0x00b5
            androidx.fragment.app.FragmentActivity r4 = (androidx.fragment.app.FragmentActivity) r4
            java.lang.String r7 = "SupportLifecycleFragmentImpl"
            java.util.WeakHashMap<androidx.fragment.app.FragmentActivity, java.lang.ref.WeakReference<a.d.a.a.e.k.l.v0>> r0 = a.d.a.a.e.k.l.v0.f1338d
            java.lang.Object r0 = r0.get(r4)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            if (r0 == 0) goto L_0x007b
            java.lang.Object r0 = r0.get()
            a.d.a.a.e.k.l.v0 r0 = (a.d.a.a.e.k.l.v0) r0
            if (r0 == 0) goto L_0x007b
            goto L_0x00fa
        L_0x007b:
            androidx.fragment.app.FragmentManager r0 = r4.getSupportFragmentManager()     // Catch:{ ClassCastException -> 0x00ac }
            androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r7)     // Catch:{ ClassCastException -> 0x00ac }
            a.d.a.a.e.k.l.v0 r0 = (a.d.a.a.e.k.l.v0) r0     // Catch:{ ClassCastException -> 0x00ac }
            if (r0 == 0) goto L_0x008d
            boolean r1 = r0.isRemoving()
            if (r1 == 0) goto L_0x00a1
        L_0x008d:
            a.d.a.a.e.k.l.v0 r0 = new a.d.a.a.e.k.l.v0
            r0.<init>()
            androidx.fragment.app.FragmentManager r1 = r4.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r1 = r1.beginTransaction()
            androidx.fragment.app.FragmentTransaction r7 = r1.add((androidx.fragment.app.Fragment) r0, (java.lang.String) r7)
            r7.commitAllowingStateLoss()
        L_0x00a1:
            java.util.WeakHashMap<androidx.fragment.app.FragmentActivity, java.lang.ref.WeakReference<a.d.a.a.e.k.l.v0>> r7 = a.d.a.a.e.k.l.v0.f1338d
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r0)
            r7.put(r4, r1)
            goto L_0x00fa
        L_0x00ac:
            r4 = move-exception
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl"
            r5.<init>(r6, r4)
            throw r5
        L_0x00b5:
            java.lang.String r7 = "LifecycleFragmentImpl"
            java.util.WeakHashMap<android.app.Activity, java.lang.ref.WeakReference<a.d.a.a.e.k.l.s0>> r0 = a.d.a.a.e.k.l.s0.f1325d
            java.lang.Object r0 = r0.get(r4)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            if (r0 == 0) goto L_0x00ca
            java.lang.Object r0 = r0.get()
            a.d.a.a.e.k.l.s0 r0 = (a.d.a.a.e.k.l.s0) r0
            if (r0 == 0) goto L_0x00ca
            goto L_0x00fa
        L_0x00ca:
            android.app.FragmentManager r0 = r4.getFragmentManager()     // Catch:{ ClassCastException -> 0x011b }
            android.app.Fragment r0 = r0.findFragmentByTag(r7)     // Catch:{ ClassCastException -> 0x011b }
            a.d.a.a.e.k.l.s0 r0 = (a.d.a.a.e.k.l.s0) r0     // Catch:{ ClassCastException -> 0x011b }
            if (r0 == 0) goto L_0x00dc
            boolean r1 = r0.isRemoving()
            if (r1 == 0) goto L_0x00f0
        L_0x00dc:
            a.d.a.a.e.k.l.s0 r0 = new a.d.a.a.e.k.l.s0
            r0.<init>()
            android.app.FragmentManager r1 = r4.getFragmentManager()
            android.app.FragmentTransaction r1 = r1.beginTransaction()
            android.app.FragmentTransaction r7 = r1.add(r0, r7)
            r7.commitAllowingStateLoss()
        L_0x00f0:
            java.util.WeakHashMap<android.app.Activity, java.lang.ref.WeakReference<a.d.a.a.e.k.l.s0>> r7 = a.d.a.a.e.k.l.s0.f1325d
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r0)
            r7.put(r4, r1)
        L_0x00fa:
            java.lang.Class<a.d.a.a.e.k.l.n> r4 = a.d.a.a.e.k.l.n.class
            java.lang.String r7 = "ConnectionlessLifecycleHelper"
            com.google.android.gms.common.api.internal.LifecycleCallback r4 = r0.j(r7, r4)
            a.d.a.a.e.k.l.n r4 = (a.d.a.a.e.k.l.n) r4
            if (r4 != 0) goto L_0x010b
            a.d.a.a.e.k.l.n r4 = new a.d.a.a.e.k.l.n
            r4.<init>(r0)
        L_0x010b:
            r4.g = r5
            java.lang.String r7 = "ApiKey cannot be null"
            a.c.a.f.b.l(r6, r7)
            androidx.collection.ArraySet<a.d.a.a.e.k.l.b<?>> r7 = r4.f
            r7.add(r6)
            r5.a(r4)
            goto L_0x0124
        L_0x011b:
            r4 = move-exception
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl"
            r5.<init>(r6, r4)
            throw r5
        L_0x0124:
            a.d.a.a.e.k.l.f r4 = r3.h
            android.os.Handler r4 = r4.m
            r5 = 7
            android.os.Message r5 = r4.obtainMessage(r5, r3)
            r4.sendMessage(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.k.c.<init>(android.app.Activity, a.d.a.a.e.k.a, a.d.a.a.e.k.a$d, a.d.a.a.e.k.l.a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r1 = ((a.d.a.a.e.k.a.d.b) r1).c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.a.a.e.m.c.a a() {
        /*
            r4 = this;
            a.d.a.a.e.m.c$a r0 = new a.d.a.a.e.m.c$a
            r0.<init>()
            O r1 = r4.f1256c
            boolean r2 = r1 instanceof a.d.a.a.e.k.a.d.b
            r3 = 0
            if (r2 == 0) goto L_0x0024
            a.d.a.a.e.k.a$d$b r1 = (a.d.a.a.e.k.a.d.b) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.c()
            if (r1 == 0) goto L_0x0024
            java.lang.String r2 = r1.f4169d
            if (r2 != 0) goto L_0x0019
            goto L_0x0030
        L_0x0019:
            android.accounts.Account r2 = new android.accounts.Account
            java.lang.String r1 = r1.f4169d
            java.lang.String r3 = "com.google"
            r2.<init>(r1, r3)
            r3 = r2
            goto L_0x0030
        L_0x0024:
            O r1 = r4.f1256c
            boolean r2 = r1 instanceof a.d.a.a.e.k.a.d.C0058a
            if (r2 == 0) goto L_0x0030
            a.d.a.a.e.k.a$d$a r1 = (a.d.a.a.e.k.a.d.C0058a) r1
            android.accounts.Account r3 = r1.d()
        L_0x0030:
            r0.f1376a = r3
            O r1 = r4.f1256c
            boolean r2 = r1 instanceof a.d.a.a.e.k.a.d.b
            if (r2 == 0) goto L_0x0045
            a.d.a.a.e.k.a$d$b r1 = (a.d.a.a.e.k.a.d.b) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.c()
            if (r1 == 0) goto L_0x0045
            java.util.Set r1 = r1.e()
            goto L_0x0049
        L_0x0045:
            java.util.Set r1 = java.util.Collections.emptySet()
        L_0x0049:
            androidx.collection.ArraySet<com.google.android.gms.common.api.Scope> r2 = r0.f1377b
            if (r2 != 0) goto L_0x0054
            androidx.collection.ArraySet r2 = new androidx.collection.ArraySet
            r2.<init>()
            r0.f1377b = r2
        L_0x0054:
            androidx.collection.ArraySet<com.google.android.gms.common.api.Scope> r2 = r0.f1377b
            r2.addAll(r1)
            android.content.Context r1 = r4.f1254a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.f1380e = r1
            android.content.Context r1 = r4.f1254a
            java.lang.String r1 = r1.getPackageName()
            r0.f1379d = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.k.c.a():a.d.a.a.e.m.c$a");
    }

    @Deprecated
    public c(@NonNull Context context, a<O> aVar, @Nullable O o, a.d.a.a.e.k.l.a aVar2) {
        a.c.a.f.b.l(aVar2, "StatusExceptionMapper must not be null.");
        a aVar3 = new a(aVar2, (Account) null, Looper.getMainLooper());
        a.c.a.f.b.l(context, "Null context is not permitted.");
        a.c.a.f.b.l(aVar, "Api must not be null.");
        a.c.a.f.b.l(aVar3, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f1254a = context.getApplicationContext();
        this.f1255b = aVar;
        this.f1256c = o;
        this.f1258e = aVar3.f1260b;
        this.f1257d = new b<>(aVar, o);
        f b2 = f.b(this.f1254a);
        this.h = b2;
        this.f = b2.g.getAndIncrement();
        Handler handler = this.h.m;
        handler.sendMessage(handler.obtainMessage(7, this));
    }
}
