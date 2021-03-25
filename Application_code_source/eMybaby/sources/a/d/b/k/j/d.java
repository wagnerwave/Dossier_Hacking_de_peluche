package a.d.b.k.j;

import a.d.b.k.j.a;
import a.d.b.k.j.c;
import androidx.annotation.NonNull;

public abstract class d {

    public static abstract class a {
        @NonNull
        public abstract d a();

        @NonNull
        public abstract a b(long j);

        @NonNull
        public abstract a c(@NonNull c.a aVar);

        @NonNull
        public abstract a d(long j);
    }

    static {
        Long l = 0L;
        String str = l == null ? " expiresInSecs" : "";
        if (l == null) {
            str = a.a.a.a.a.k(str, " tokenCreationEpochInSecs");
        }
        if (str.isEmpty()) {
            l.longValue();
            l.longValue();
            return;
        }
        throw new IllegalStateException(a.a.a.a.a.k("Missing required properties:", str));
    }

    @NonNull
    public static a a() {
        a.b bVar = new a.b();
        bVar.d(0);
        bVar.c(c.a.ATTEMPT_MIGRATION);
        bVar.b(0);
        return bVar;
    }

    public boolean b() {
        c.a aVar = ((a) this).f2803b;
        return aVar == c.a.NOT_GENERATED || aVar == c.a.ATTEMPT_MIGRATION;
    }

    @NonNull
    public abstract a c();
}
