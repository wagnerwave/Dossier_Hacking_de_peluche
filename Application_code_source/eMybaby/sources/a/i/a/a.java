package a.i.a;

import a.i.a.t;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final t f3571a;

    /* renamed from: b  reason: collision with root package name */
    public final w f3572b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<T> f3573c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3574d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3575e;
    public final int f;
    public final int g;
    public final Drawable h;
    public final String i;
    public final Object j;
    public boolean k;
    public boolean l;

    /* renamed from: a.i.a.a$a  reason: collision with other inner class name */
    public static class C0084a<M> extends WeakReference<M> {

        /* renamed from: a  reason: collision with root package name */
        public final a f3576a;

        public C0084a(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f3576a = aVar;
        }
    }

    public a(t tVar, T t, w wVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, boolean z) {
        this.f3571a = tVar;
        this.f3572b = wVar;
        this.f3573c = t == null ? null : new C0084a(this, t, tVar.k);
        this.f3575e = i2;
        this.f = i3;
        this.f3574d = z;
        this.g = i4;
        this.h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    public void a() {
        this.l = true;
    }

    public abstract void b(Bitmap bitmap, t.d dVar);

    public abstract void c();

    public T d() {
        WeakReference<T> weakReference = this.f3573c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
