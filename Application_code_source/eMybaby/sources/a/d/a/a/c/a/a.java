package a.d.a.a.c.a;

import a.c.a.f.b;
import a.d.a.a.c.a.d.c.g;
import a.d.a.a.e.k.a;
import a.d.a.a.h.b.e;
import a.d.a.a.h.c.d;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g<e> f1189a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    public static final a.g<g> f1190b = new a.g<>();

    /* renamed from: c  reason: collision with root package name */
    public static final a.C0057a<e, C0054a> f1191c = new f();

    /* renamed from: d  reason: collision with root package name */
    public static final a.C0057a<g, GoogleSignInOptions> f1192d = new g();

    /* renamed from: e  reason: collision with root package name */
    public static final a.d.a.a.e.k.a<GoogleSignInOptions> f1193e = new a.d.a.a.e.k.a<>("Auth.GOOGLE_SIGN_IN_API", f1192d, f1190b);

    @Deprecated
    /* renamed from: a.d.a.a.c.a.a$a  reason: collision with other inner class name */
    public static class C0054a implements a.d {

        /* renamed from: d  reason: collision with root package name */
        public static final C0054a f1194d = new C0054a(new C0055a());

        /* renamed from: a  reason: collision with root package name */
        public final String f1195a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1196b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final String f1197c;

        @Deprecated
        /* renamed from: a.d.a.a.c.a.a$a$a  reason: collision with other inner class name */
        public static class C0055a {

            /* renamed from: a  reason: collision with root package name */
            public String f1198a;

            /* renamed from: b  reason: collision with root package name */
            public Boolean f1199b = Boolean.FALSE;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            public String f1200c;

            public C0055a() {
            }

            public C0055a(C0054a aVar) {
                this.f1198a = aVar.f1195a;
                this.f1199b = Boolean.valueOf(aVar.f1196b);
                this.f1200c = aVar.f1197c;
            }
        }

        public C0054a(C0055a aVar) {
            this.f1195a = aVar.f1198a;
            this.f1196b = aVar.f1199b.booleanValue();
            this.f1197c = aVar.f1200c;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0054a)) {
                return false;
            }
            C0054a aVar = (C0054a) obj;
            return b.B(this.f1195a, aVar.f1195a) && this.f1196b == aVar.f1196b && b.B(this.f1197c, aVar.f1197c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f1195a, Boolean.valueOf(this.f1196b), this.f1197c});
        }
    }

    static {
        a.d.a.a.e.k.a<c> aVar = b.f1203c;
        a.C0057a<e, C0054a> aVar2 = f1191c;
        a.g<e> gVar = f1189a;
        b.l(aVar2, "Cannot construct an Api with a null ClientBuilder");
        b.l(gVar, "Cannot construct an Api with a null ClientKey");
        d dVar = b.f1204d;
    }
}
