package a.d.a.a.e.k;

import a.d.a.a.e.k.a.d;
import a.d.a.a.e.k.d;
import a.d.a.a.e.m.b;
import a.d.a.a.e.m.j;
import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    public final C0057a<?, O> f1250a;

    /* renamed from: b  reason: collision with root package name */
    public final g<?> f1251b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1252c;

    /* renamed from: a.d.a.a.e.k.a$a  reason: collision with other inner class name */
    public static abstract class C0057a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, a.d.a.a.e.m.c cVar, O o, d.a aVar, d.b bVar) {
            throw null;
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: a.d.a.a.e.k.a$d$a  reason: collision with other inner class name */
        public interface C0058a extends d {
            Account d();
        }

        public interface b extends d {
            GoogleSignInAccount c();
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void a(b.e eVar);

        @NonNull
        Set<Scope> b();

        void c(j jVar, Set<Scope> set);

        void disconnect();

        boolean e();

        int f();

        boolean g();

        String h();

        void i(b.c cVar);

        boolean isConnected();

        boolean j();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> a(String str, C0057a<C, O> aVar, g<C> gVar) {
        a.c.a.f.b.l(aVar, "Cannot construct an Api with a null ClientBuilder");
        a.c.a.f.b.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f1252c = str;
        this.f1250a = aVar;
        this.f1251b = gVar;
    }
}
