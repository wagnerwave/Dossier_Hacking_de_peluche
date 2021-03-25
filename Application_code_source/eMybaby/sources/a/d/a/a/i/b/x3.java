package a.d.a.a.i.b;

import a.c.a.f.b;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;

public final class x3 extends y5 {

    /* renamed from: c  reason: collision with root package name */
    public char f2617c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f2618d = -1;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    public String f2619e;
    public final z3 f = new z3(this, 6, false, false);
    public final z3 g = new z3(this, 6, true, false);
    public final z3 h = new z3(this, 6, false, true);
    public final z3 i = new z3(this, 5, false, false);
    public final z3 j = new z3(this, 5, true, false);
    public final z3 k = new z3(this, 5, false, true);
    public final z3 l = new z3(this, 4, false, false);
    public final z3 m = new z3(this, 3, false, false);
    public final z3 n = new z3(this, 2, false, false);

    public x3(c5 c5Var) {
        super(c5Var);
    }

    public static Object s(String str) {
        if (str == null) {
            return null;
        }
        return new y3(str);
    }

    public static String t(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l2.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + str.length() + 43);
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String y = y(c5.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && y(className).equals(y)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i2++;
                }
                return sb2.toString();
            } else if (obj instanceof y3) {
                return ((y3) obj).f2633a;
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    public static String u(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String t = t(z, obj);
        String t2 = t(z, obj2);
        String t3 = t(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(t)) {
            sb.append(str2);
            sb.append(t);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(t2)) {
            sb.append(str2);
            sb.append(t2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(t3)) {
            sb.append(str3);
            sb.append(t3);
        }
        return sb.toString();
    }

    public static String y(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public final z3 A() {
        return this.i;
    }

    public final z3 B() {
        return this.k;
    }

    public final z3 C() {
        return this.m;
    }

    public final z3 D() {
        return this.n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String E() {
        /*
            r10 = this;
            a.d.a.a.i.b.k4 r0 = r10.k()
            a.d.a.a.i.b.n4 r0 = r0.f2316d
            a.d.a.a.i.b.k4 r1 = r0.f2402e
            r1.b()
            a.d.a.a.i.b.k4 r1 = r0.f2402e
            r1.b()
            a.d.a.a.i.b.k4 r1 = r0.f2402e
            android.content.SharedPreferences r1 = r1.v()
            java.lang.String r2 = r0.f2398a
            r3 = 0
            long r1 = r1.getLong(r2, r3)
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0028
            r0.a()
            r1 = r3
            goto L_0x003b
        L_0x0028:
            a.d.a.a.i.b.k4 r6 = r0.f2402e
            a.d.a.a.i.b.c5 r6 = r6.f2563a
            a.d.a.a.e.q.b r6 = r6.n
            a.d.a.a.e.q.c r6 = (a.d.a.a.e.q.c) r6
            if (r6 == 0) goto L_0x00a2
            long r6 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            long r1 = java.lang.Math.abs(r1)
        L_0x003b:
            long r6 = r0.f2401d
            r8 = 1
            int r9 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0043
            goto L_0x004b
        L_0x0043:
            long r6 = r6 << r8
            int r9 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x004d
            r0.a()
        L_0x004b:
            r0 = r5
            goto L_0x007b
        L_0x004d:
            a.d.a.a.i.b.k4 r1 = r0.f2402e
            android.content.SharedPreferences r1 = r1.v()
            java.lang.String r2 = r0.f2400c
            java.lang.String r1 = r1.getString(r2, r5)
            a.d.a.a.i.b.k4 r2 = r0.f2402e
            android.content.SharedPreferences r2 = r2.v()
            java.lang.String r6 = r0.f2399b
            long r6 = r2.getLong(r6, r3)
            r0.a()
            if (r1 == 0) goto L_0x0079
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x006f
            goto L_0x0079
        L_0x006f:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            r0.<init>(r1, r2)
            goto L_0x007b
        L_0x0079:
            android.util.Pair<java.lang.String, java.lang.Long> r0 = a.d.a.a.i.b.k4.D
        L_0x007b:
            if (r0 == 0) goto L_0x00a1
            android.util.Pair<java.lang.String, java.lang.Long> r1 = a.d.a.a.i.b.k4.D
            if (r0 != r1) goto L_0x0082
            goto L_0x00a1
        L_0x0082:
            java.lang.Object r1 = r0.second
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object r0 = r0.first
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r1.length()
            int r2 = r2 + r8
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + r2
            java.lang.String r2 = ":"
            java.lang.String r0 = a.a.a.a.a.d(r3, r1, r2, r0)
            return r0
        L_0x00a1:
            return r5
        L_0x00a2:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.x3.E():java.lang.String");
    }

    public final String F() {
        String str;
        synchronized (this) {
            if (this.f2619e == null) {
                this.f2619e = this.f2563a.f2126d != null ? this.f2563a.f2126d : "FA";
            }
            str = this.f2619e;
        }
        return str;
    }

    public final boolean q() {
        return false;
    }

    public final void v(int i2, String str) {
        Log.println(i2, F(), str);
    }

    public final void w(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        String str2;
        if (!z && Log.isLoggable(F(), i2)) {
            Log.println(i2, F(), u(false, str, obj, obj2, obj3));
        }
        if (!z2 && i2 >= 5) {
            b.k(str);
            v4 v4Var = this.f2563a.j;
            if (v4Var == null) {
                str2 = "Scheduler not set. Not logging error/warn";
            } else if (!v4Var.r()) {
                str2 = "Scheduler not initialized. Not logging error/warn";
            } else {
                if (i2 < 0) {
                    i2 = 0;
                }
                v4Var.v(new w3(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3));
                return;
            }
            v(6, str2);
        }
    }

    public final boolean x(int i2) {
        return Log.isLoggable(F(), i2);
    }

    public final z3 z() {
        return this.f;
    }
}
