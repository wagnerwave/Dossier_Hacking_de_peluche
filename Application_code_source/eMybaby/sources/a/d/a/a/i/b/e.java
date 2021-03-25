package a.d.a.a.i.b;

import android.os.Bundle;

public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static final e f2160c = new e((Boolean) null, (Boolean) null);

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f2161a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f2162b;

    public e(Boolean bool, Boolean bool2) {
        this.f2161a = bool;
        this.f2162b = bool2;
    }

    public static int a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.d.a.a.i.b.e b(java.lang.String r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0038
            int r1 = r7.length()
            r2 = 49
            r3 = 48
            r4 = 3
            if (r1 < r4) goto L_0x001e
            r1 = 2
            char r1 = r7.charAt(r1)
            if (r1 == r3) goto L_0x001b
            if (r1 == r2) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            goto L_0x001f
        L_0x001b:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto L_0x001f
        L_0x001e:
            r1 = r0
        L_0x001f:
            int r5 = r7.length()
            r6 = 4
            if (r5 < r6) goto L_0x0035
            char r7 = r7.charAt(r4)
            if (r7 == r3) goto L_0x0032
            if (r7 == r2) goto L_0x002f
            goto L_0x0035
        L_0x002f:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            goto L_0x0034
        L_0x0032:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
        L_0x0034:
            r0 = r7
        L_0x0035:
            r7 = r0
            r0 = r1
            goto L_0x0039
        L_0x0038:
            r7 = r0
        L_0x0039:
            a.d.a.a.i.b.e r1 = new a.d.a.a.i.b.e
            r1.<init>(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.e.b(java.lang.String):a.d.a.a.i.b.e");
    }

    public static Boolean c(Boolean bool, Boolean bool2) {
        if (bool != null) {
            return bool.booleanValue() ? bool2 : Boolean.FALSE;
        }
        if (bool2 == null || bool2.booleanValue()) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static boolean e(int i, int i2) {
        return i <= i2;
    }

    public static e g(Bundle bundle) {
        return bundle == null ? f2160c : new e(i(bundle.getString("ad_storage")), i(bundle.getString("analytics_storage")));
    }

    public static Boolean i(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder("G1");
        Boolean bool = this.f2161a;
        char c2 = '0';
        sb.append(bool == null ? '-' : bool.booleanValue() ? '1' : '0');
        Boolean bool2 = this.f2162b;
        if (bool2 == null) {
            c2 = '-';
        } else if (bool2.booleanValue()) {
            c2 = '1';
        }
        sb.append(c2);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return a(this.f2161a) == a(eVar.f2161a) && a(this.f2162b) == a(eVar.f2162b);
    }

    public final boolean f(e eVar) {
        Boolean bool = this.f2161a;
        Boolean bool2 = Boolean.FALSE;
        if (bool == bool2 && eVar.f2161a != bool2) {
            return true;
        }
        Boolean bool3 = this.f2162b;
        Boolean bool4 = Boolean.FALSE;
        return bool3 == bool4 && eVar.f2162b != bool4;
    }

    public final e h(e eVar) {
        return new e(c(this.f2161a, eVar.f2161a), c(this.f2162b, eVar.f2162b));
    }

    public final int hashCode() {
        return a(this.f2162b) + ((a(this.f2161a) + 527) * 31);
    }

    public final boolean j() {
        Boolean bool = this.f2161a;
        return bool == null || bool.booleanValue();
    }

    public final boolean k() {
        Boolean bool = this.f2162b;
        return bool == null || bool.booleanValue();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.f2161a;
        String str = "granted";
        if (bool == null) {
            sb.append("uninitialized");
        } else {
            sb.append(bool.booleanValue() ? str : "denied");
        }
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.f2162b;
        if (bool2 == null) {
            sb.append("uninitialized");
        } else {
            if (!bool2.booleanValue()) {
                str = "denied";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
