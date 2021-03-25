package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.d;
import a.d.a.a.e.g;
import a.d.a.a.e.r.c;
import a.d.a.a.h.g.aa;
import a.d.a.a.h.g.jb;
import a.d.a.a.h.g.od;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzw;
import com.tuya.smart.common.o00000oo0;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import okhttp3.internal.ws.RealWebSocket;

public final class v9 extends y5 {
    public static final String[] g = {"firebase_", "google_", "ga_"};
    public static final String[] h = {"_err"};

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f2576c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f2577d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    public int f2578e;
    public Integer f = null;

    public v9(c5 c5Var) {
        super(c5Var);
    }

    public static Bundle A(List<zzkw> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkw next : list) {
            String str = next.f4284e;
            if (str != null) {
                bundle.putString(next.f4281b, str);
            } else {
                Long l = next.f4283d;
                if (l != null) {
                    bundle.putLong(next.f4281b, l.longValue());
                } else {
                    Double d2 = next.g;
                    if (d2 != null) {
                        bundle.putDouble(next.f4281b, d2.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public static String E(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static void F(Bundle bundle, int i, String str, Object obj) {
        if (k0(bundle, i)) {
            bundle.putString("_ev", E(str, 40, true));
            if (obj != null) {
                b.k(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    public static boolean S(Context context) {
        b.k(context);
        return j0(context, Build.VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean T(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean U(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean V(String str) {
        b.h(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean b0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static boolean c0(String str, String[] strArr) {
        b.k(strArr);
        for (String r0 : strArr) {
            if (r0(str, r0)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] e0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static ArrayList<Bundle> i0(List<zzw> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzw next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.f4290a);
            bundle.putString("origin", next.f4291b);
            bundle.putLong("creation_timestamp", next.f4293d);
            bundle.putString("name", next.f4292c.f4281b);
            b.h1(bundle, next.f4292c.e());
            bundle.putBoolean("active", next.f4294e);
            String str = next.f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzar zzar = next.g;
            if (zzar != null) {
                bundle.putString("timed_out_event_name", zzar.f4276a);
                zzam zzam = next.g.f4277b;
                if (zzam != null) {
                    bundle.putBundle("timed_out_event_params", zzam.h());
                }
            }
            bundle.putLong("trigger_timeout", next.h);
            zzar zzar2 = next.i;
            if (zzar2 != null) {
                bundle.putString("triggered_event_name", zzar2.f4276a);
                zzam zzam2 = next.i.f4277b;
                if (zzam2 != null) {
                    bundle.putBundle("triggered_event_params", zzam2.h());
                }
            }
            bundle.putLong("triggered_timestamp", next.f4292c.f4282c);
            bundle.putLong("time_to_live", next.j);
            zzar zzar3 = next.k;
            if (zzar3 != null) {
                bundle.putString("expired_event_name", zzar3.f4276a);
                zzam zzam3 = next.k.f4277b;
                if (zzam3 != null) {
                    bundle.putBundle("expired_event_params", zzam3.h());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r3 = r1.getServiceInfo(new android.content.ComponentName(r3, r4), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean j0(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0019 }
            r2.<init>(r3, r4)     // Catch:{ NameNotFoundException -> 0x0019 }
            android.content.pm.ServiceInfo r3 = r1.getServiceInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r3 == 0) goto L_0x0019
            boolean r3 = r3.enabled     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r3 == 0) goto L_0x0019
            r3 = 1
            return r3
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.v9.j0(android.content.Context, java.lang.String):boolean");
    }

    public static boolean k0(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    public static Bundle[] n0(Object obj) {
        Object[] array;
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            array = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            array = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) array;
    }

    public static boolean r0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean s0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static long u(long j, long j2) {
        return ((j2 * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) + j) / 86400000;
    }

    public static long v(zzam zzam) {
        long j = 0;
        if (zzam == null) {
            return 0;
        }
        for (String e2 : zzam.f4275a.keySet()) {
            Object e3 = zzam.e(e2);
            if (e3 instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) e3).length;
            }
        }
        return j;
    }

    public static long w(byte[] bArr) {
        b.k(bArr);
        int i = 0;
        b.n(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static MessageDigest y0() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public final int A0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (!this.f2563a.g.o(q.i0) || !"_lgclid".equals(str)) ? 36 : 100;
    }

    public final zzar B(String str, String str2, Bundle bundle, String str3, long j, boolean z) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (t(str2, z) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            bundle2.putString("_o", str3);
            return new zzar(str2, new zzam(y(z(str, str2, bundle2, Collections.singletonList("_o"), false, false))), str3, j);
        }
        i().f.b("Invalid conditional property event name", d().y(str2));
        throw new IllegalArgumentException();
    }

    public final Object C(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return E(String.valueOf(obj), i, z);
            }
            if (!aa.b() || !this.f2563a.g.o(q.B0) || !this.f2563a.g.o(q.A0) || !z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle y = y((Bundle) parcelable);
                    if (!y.isEmpty()) {
                        arrayList.add(y);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public final Object D(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return C(256, obj, true, true);
        }
        if (!s0(str)) {
            i = 100;
        }
        return C(i, obj, false, true);
    }

    @WorkerThread
    public final void G(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            i().i.b("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void H(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    e().I(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    public final void I(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (aa.b() && this.f2563a.g.o(q.B0) && this.f2563a.g.o(q.A0) && (obj instanceof Bundle[])) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                i().k.c("Not putting event parameter. Invalid value type. name, type", d().x(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void J(od odVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f2563a.i().i.b("Error returning int value to wrapper", e2);
        }
    }

    public final void K(od odVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f2563a.i().i.b("Error returning long value to wrapper", e2);
        }
    }

    public final void L(od odVar, Bundle bundle) {
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f2563a.i().i.b("Error returning bundle value to wrapper", e2);
        }
    }

    public final void M(od odVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f2563a.i().i.b("Error returning string value to wrapper", e2);
        }
    }

    public final void N(od odVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f2563a.i().i.b("Error returning bundle list to wrapper", e2);
        }
    }

    public final void O(od odVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f2563a.i().i.b("Error returning boolean value to wrapper", e2);
        }
    }

    public final void P(od odVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f2563a.i().i.b("Error returning byte array to wrapper", e2);
        }
    }

    public final void Q(c4 c4Var, int i) {
        Iterator it = new TreeSet(c4Var.f2122d.keySet()).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (V(str) && (i2 = i2 + 1) > i) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i);
                sb.append(" params");
                i().h.c(sb.toString(), d().u(c4Var.f2119a), d().s(c4Var.f2122d));
                k0(c4Var.f2122d, 5);
                c4Var.f2122d.remove(str);
            }
        }
    }

    public final void R(String str, String str2, String str3, Bundle bundle, @Nullable List<String> list, boolean z) {
        int i;
        int i2;
        String str4;
        int i3;
        String str5;
        String str6 = str2;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        if (bundle2 != null) {
            boolean o = this.f2563a.g.o(q.C0);
            if (o) {
                i = 0;
            } else {
                i = this.f2563a.g.s();
            }
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i4 = 0;
            while (it.hasNext()) {
                String str7 = (String) it.next();
                if (list2 == null || !list2.contains(str7)) {
                    i2 = z ? v0(str7) : 0;
                    if (i2 == 0) {
                        i2 = x0(str7);
                    }
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    F(bundle2, i2, str7, i2 == 3 ? str7 : null);
                    bundle2.remove(str7);
                } else {
                    if (U(bundle2.get(str7))) {
                        i().k.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str6, str3, str7);
                        i3 = 22;
                        str4 = str7;
                    } else {
                        String str8 = str3;
                        str4 = str7;
                        i3 = s(str, str2, str7, bundle2.get(str7), bundle, list, z, false);
                    }
                    if (i3 != 0 && !"_ev".equals(str4)) {
                        F(bundle2, i3, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (V(str4) && (!o || !c0(str4, c6.f2131d))) {
                        int i5 = i4 + 1;
                        if (i5 > i) {
                            if (o) {
                                str5 = "Item cannot contain custom parameters";
                            } else {
                                StringBuilder sb = new StringBuilder(63);
                                sb.append("Child bundles can't contain more than ");
                                sb.append(i);
                                sb.append(" custom params");
                                str5 = sb.toString();
                            }
                            i().h.c(str5, d().u(str6), d().s(bundle2));
                            k0(bundle2, o ? 23 : 5);
                            bundle2.remove(str4);
                        }
                        i4 = i5;
                    }
                }
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public final boolean W(String str, double d2) {
        try {
            SharedPreferences.Editor edit = this.f2563a.f2123a.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return edit.commit();
        } catch (Exception e2) {
            i().f.b("Failed to persist Deferred Deep Link. exception", e2);
            return false;
        }
    }

    public final boolean X(String str, int i, String str2) {
        if (str2 == null) {
            i().h.b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            i().h.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public final boolean Y(String str, String str2) {
        if (str2 == null) {
            i().h.b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            i().h.b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                i().h.c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    i().h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean Z(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                i().k.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean a0(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            b.k(str);
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (this.f2563a.v()) {
                i().h.b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", x3.s(str));
            }
            return false;
        } else if (jb.b() && this.f2563a.g.o(q.k0) && !TextUtils.isEmpty(str3)) {
            return true;
        } else {
            if (!TextUtils.isEmpty(str2)) {
                b.k(str2);
                if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                    return true;
                }
                i().h.b("Invalid admob_app_id. Analytics disabled.", x3.s(str2));
                return false;
            }
            if (this.f2563a.v()) {
                i().h.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
    }

    public final boolean d0(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z;
        if (str2 == null) {
            i().h.b("Name is required and can't be null. Type", str);
            return false;
        }
        b.k(str2);
        String[] strArr3 = g;
        int length = strArr3.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr3[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            i().h.c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !c0(str2, strArr) || (strArr2 != null && c0(str2, strArr2))) {
            return true;
        } else {
            i().h.c("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public final void f0(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        k0(bundle, i);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            bundle.putString(str, str2);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.f2563a.s().H("auto", "_err", bundle);
    }

    public final int g0(String str) {
        if (!l0("user property", str)) {
            return 6;
        }
        if (!d0("user property", b6.f2100a, (String[]) null, str)) {
            return 15;
        }
        if (!X("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    public final int h0(String str, Object obj) {
        String str2;
        int i;
        if ("_ldl".equals(str)) {
            i = A0(str);
            str2 = "user property referrer";
        } else {
            i = A0(str);
            str2 = "user property";
        }
        return Z(str2, str, i, obj) ? 0 : 7;
    }

    @WorkerThread
    public final void l() {
        b();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                i().i.a("Utils falling back to Random for random id");
            }
        }
        this.f2577d.set(nextLong);
    }

    public final boolean l0(String str, String str2) {
        if (str2 == null) {
            i().h.b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            i().h.b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        i().h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            i().h.c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public final boolean m0(String str, String str2, int i, Object obj) {
        int i2;
        if (obj instanceof Parcelable[]) {
            i2 = ((Parcelable[]) obj).length;
        } else if (!(obj instanceof ArrayList)) {
            return true;
        } else {
            i2 = ((ArrayList) obj).size();
        }
        if (i2 <= i) {
            return true;
        }
        i().k.d("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(i2));
        return false;
    }

    public final Object o0(String str, Object obj) {
        boolean equals = "_ldl".equals(str);
        int A0 = A0(str);
        return equals ? C(A0, obj, true, false) : C(A0, obj, false, false);
    }

    public final boolean p0(Context context, String str) {
        z3 z3Var;
        String str2;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = c.a(context).f1443a.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e2) {
            e = e2;
            z3Var = i().f;
            str2 = "Error obtaining certificate";
            z3Var.b(str2, e);
            return true;
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
            z3Var = i().f;
            str2 = "Package name not found";
            z3Var.b(str2, e);
            return true;
        }
    }

    public final boolean q() {
        return true;
    }

    @WorkerThread
    public final boolean q0(String str) {
        b();
        if (c.a(this.f2563a.f2123a).f1443a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        i().m.b("Permission not granted", str);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cb  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int s(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object r21, android.os.Bundle r22, @androidx.annotation.Nullable java.util.List<java.lang.String> r23, boolean r24, boolean r25) {
        /*
            r17 = this;
            r7 = r17
            r8 = r20
            r0 = r21
            r1 = r22
            r17.b()
            boolean r2 = a.d.a.a.h.g.aa.b()
            r3 = 17
            r9 = 1
            r10 = 0
            java.lang.String r4 = "param"
            if (r2 == 0) goto L_0x0099
            a.d.a.a.i.b.c5 r2 = r7.f2563a
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.C0
            boolean r2 = r2.o(r5)
            if (r2 == 0) goto L_0x0099
            boolean r2 = U(r21)
            if (r2 == 0) goto L_0x00a4
            if (r25 == 0) goto L_0x0096
            java.lang.String[] r2 = a.d.a.a.i.b.c6.f2130c
            boolean r2 = c0(r8, r2)
            if (r2 != 0) goto L_0x0036
            r0 = 20
            return r0
        L_0x0036:
            a.d.a.a.i.b.c5 r2 = r7.f2563a
            a.d.a.a.i.b.u7 r2 = r2.x()
            r2.b()
            r2.u()
            boolean r5 = r2.I()
            if (r5 != 0) goto L_0x0049
            goto L_0x0056
        L_0x0049:
            a.d.a.a.i.b.v9 r2 = r2.e()
            int r2 = r2.z0()
            r5 = 200900(0x310c4, float:2.81521E-40)
            if (r2 < r5) goto L_0x0058
        L_0x0056:
            r2 = 1
            goto L_0x0059
        L_0x0058:
            r2 = 0
        L_0x0059:
            if (r2 != 0) goto L_0x005e
            r0 = 25
            return r0
        L_0x005e:
            r2 = 200(0xc8, float:2.8E-43)
            boolean r5 = r7.m0(r4, r8, r2, r0)
            if (r5 != 0) goto L_0x00a4
            boolean r5 = r0 instanceof android.os.Parcelable[]
            if (r5 == 0) goto L_0x007a
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            if (r6 <= r2) goto L_0x0093
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r2)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x0093
        L_0x007a:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x0093
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            if (r6 <= r2) goto L_0x0093
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r5.subList(r10, r2)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x0093:
            r11 = 17
            goto L_0x00a5
        L_0x0096:
            r0 = 21
            return r0
        L_0x0099:
            if (r25 == 0) goto L_0x00a4
            r1 = 1000(0x3e8, float:1.401E-42)
            boolean r1 = r7.m0(r4, r8, r1, r0)
            if (r1 != 0) goto L_0x00a4
            return r3
        L_0x00a4:
            r11 = 0
        L_0x00a5:
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.i.b.ka r1 = r1.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.R
            r12 = r18
            boolean r1 = r1.t(r12, r2)
            if (r1 == 0) goto L_0x00b9
            boolean r1 = s0(r19)
            if (r1 != 0) goto L_0x00bf
        L_0x00b9:
            boolean r1 = s0(r20)
            if (r1 == 0) goto L_0x00c2
        L_0x00bf:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x00c4
        L_0x00c2:
            r1 = 100
        L_0x00c4:
            boolean r1 = r7.Z(r4, r8, r1, r0)
            if (r1 == 0) goto L_0x00cb
            return r11
        L_0x00cb:
            if (r25 == 0) goto L_0x017c
            boolean r1 = a.d.a.a.h.g.aa.b()
            if (r1 == 0) goto L_0x00e1
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.i.b.ka r1 = r1.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.B0
            boolean r1 = r1.o(r2)
            if (r1 == 0) goto L_0x00e1
            r13 = 1
            goto L_0x00e2
        L_0x00e1:
            r13 = 0
        L_0x00e2:
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00fc
            if (r13 == 0) goto L_0x0179
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r23
            r6 = r24
            r0.R(r1, r2, r3, r4, r5, r6)
            goto L_0x0179
        L_0x00fc:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x0139
            r14 = r0
            android.os.Parcelable[] r14 = (android.os.Parcelable[]) r14
            int r15 = r14.length
            r6 = 0
        L_0x0105:
            if (r6 >= r15) goto L_0x0179
            r0 = r14[r6]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x011d
            a.d.a.a.i.b.x3 r1 = r17.i()
            a.d.a.a.i.b.z3 r1 = r1.k
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.c(r2, r0, r8)
            goto L_0x0178
        L_0x011d:
            if (r13 == 0) goto L_0x0134
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r23
            r16 = r6
            r6 = r24
            r0.R(r1, r2, r3, r4, r5, r6)
            goto L_0x0136
        L_0x0134:
            r16 = r6
        L_0x0136:
            int r6 = r16 + 1
            goto L_0x0105
        L_0x0139:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0178
            r14 = r0
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            int r15 = r14.size()
            r0 = 0
        L_0x0145:
            if (r0 >= r15) goto L_0x0179
            java.lang.Object r1 = r14.get(r0)
            int r16 = r0 + 1
            boolean r0 = r1 instanceof android.os.Bundle
            if (r0 != 0) goto L_0x0161
            a.d.a.a.i.b.x3 r0 = r17.i()
            a.d.a.a.i.b.z3 r0 = r0.k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r0.c(r2, r1, r8)
            goto L_0x0178
        L_0x0161:
            if (r13 == 0) goto L_0x0175
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r23
            r6 = r24
            r0.R(r1, r2, r3, r4, r5, r6)
        L_0x0175:
            r0 = r16
            goto L_0x0145
        L_0x0178:
            r9 = 0
        L_0x0179:
            if (r9 == 0) goto L_0x017c
            return r11
        L_0x017c:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.v9.s(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final int t(String str, boolean z) {
        if (!l0(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (z) {
            if (!d0(NotificationCompat.CATEGORY_EVENT, z5.f2662a, z5.f2663b, str)) {
                return 13;
            }
        } else if (!d0(NotificationCompat.CATEGORY_EVENT, z5.f2662a, (String[]) null, str)) {
            return 13;
        }
        if (!X(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    public final boolean t0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f2563a.g.h("debug.firebase.analytics.app", "").equals(str);
    }

    public final long u0() {
        int i = (this.f2577d.get() > 0 ? 1 : (this.f2577d.get() == 0 ? 0 : -1));
        synchronized (this.f2577d) {
            if (i == 0) {
                long nanoTime = System.nanoTime();
                if (((a.d.a.a.e.q.c) this.f2563a.n) != null) {
                    long nextLong = new Random(nanoTime ^ System.currentTimeMillis()).nextLong();
                    int i2 = this.f2578e + 1;
                    this.f2578e = i2;
                    long j = nextLong + ((long) i2);
                    return j;
                }
                throw null;
            }
            this.f2577d.compareAndSet(-1, 1);
            long andIncrement = this.f2577d.getAndIncrement();
            return andIncrement;
        }
    }

    public final int v0(String str) {
        if (!Y("event param", str)) {
            return 3;
        }
        if (!d0("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        if (!X("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    @WorkerThread
    public final SecureRandom w0() {
        b();
        if (this.f2576c == null) {
            this.f2576c = new SecureRandom();
        }
        return this.f2576c;
    }

    public final Bundle x(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("source", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("medium", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(o00000oo0.O00000o0, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            i().i.b("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    public final int x0(String str) {
        if (!l0("event param", str)) {
            return 3;
        }
        if (!d0("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        if (!X("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final Bundle y(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object D = D(str, bundle.get(str));
                if (D == null) {
                    i().k.b("Param value can't be null", d().x(str));
                } else {
                    I(bundle2, str, D);
                }
            }
        }
        return bundle2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle z(java.lang.String r20, java.lang.String r21, android.os.Bundle r22, @androidx.annotation.Nullable java.util.List<java.lang.String> r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r9 = r19
            r10 = r21
            r11 = r22
            r12 = r23
            boolean r0 = a.d.a.a.h.g.aa.b()
            if (r0 == 0) goto L_0x001d
            a.d.a.a.i.b.c5 r0 = r9.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r1 = a.d.a.a.i.b.q.C0
            boolean r0 = r0.o(r1)
            if (r0 == 0) goto L_0x001d
            r0 = 1
            r14 = 1
            goto L_0x001e
        L_0x001d:
            r14 = 0
        L_0x001e:
            if (r14 == 0) goto L_0x0028
            java.lang.String[] r0 = a.d.a.a.i.b.z5.f2665d
            boolean r0 = c0(r10, r0)
            r15 = r0
            goto L_0x002a
        L_0x0028:
            r15 = r25
        L_0x002a:
            r16 = 0
            if (r11 == 0) goto L_0x012a
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>(r11)
            a.d.a.a.i.b.c5 r0 = r9.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            int r7 = r0.s()
            a.d.a.a.i.b.c5 r0 = r9.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r1 = a.d.a.a.i.b.q.a0
            r6 = r20
            boolean r0 = r0.t(r6, r1)
            if (r0 == 0) goto L_0x0053
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r22.keySet()
            r0.<init>(r1)
            goto L_0x0057
        L_0x0053:
            java.util.Set r0 = r22.keySet()
        L_0x0057:
            java.util.Iterator r17 = r0.iterator()
            r18 = 0
        L_0x005d:
            boolean r0 = r17.hasNext()
            if (r0 == 0) goto L_0x0127
            java.lang.Object r0 = r17.next()
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
            if (r12 == 0) goto L_0x0075
            boolean r0 = r12.contains(r5)
            if (r0 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r0 = 0
            goto L_0x0083
        L_0x0075:
            if (r24 == 0) goto L_0x007c
            int r0 = r9.v0(r5)
            goto L_0x007d
        L_0x007c:
            r0 = 0
        L_0x007d:
            if (r0 != 0) goto L_0x0083
            int r0 = r9.x0(r5)
        L_0x0083:
            if (r0 == 0) goto L_0x0095
            r1 = 3
            if (r0 != r1) goto L_0x008a
            r1 = r5
            goto L_0x008c
        L_0x008a:
            r1 = r16
        L_0x008c:
            F(r8, r0, r5, r1)
            r8.remove(r5)
            r9 = r7
            r12 = r8
            goto L_0x00d4
        L_0x0095:
            java.lang.Object r4 = r11.get(r5)
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r5
            r13 = r5
            r5 = r8
            r6 = r23
            r9 = r7
            r7 = r24
            r12 = r8
            r8 = r15
            int r0 = r0.s(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r14 == 0) goto L_0x00b9
            r1 = 17
            if (r0 != r1) goto L_0x00b9
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            F(r12, r0, r13, r1)
            goto L_0x00dd
        L_0x00b9:
            if (r0 == 0) goto L_0x00dd
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x00dd
            r1 = 21
            if (r0 != r1) goto L_0x00c9
            r5 = r10
            goto L_0x00ca
        L_0x00c9:
            r5 = r13
        L_0x00ca:
            java.lang.Object r1 = r11.get(r13)
            F(r12, r0, r5, r1)
            r12.remove(r13)
        L_0x00d4:
            r6 = r20
        L_0x00d6:
            r7 = r9
            r8 = r12
            r9 = r19
            r12 = r23
            goto L_0x005d
        L_0x00dd:
            boolean r0 = V(r13)
            if (r0 == 0) goto L_0x00d4
            int r0 = r18 + 1
            if (r0 <= r9) goto L_0x0124
            r1 = 48
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Event can't contain more than "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r1 = " params"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            a.d.a.a.i.b.x3 r2 = r19.i()
            a.d.a.a.i.b.z3 r2 = r2.h
            a.d.a.a.i.b.v3 r3 = r19.d()
            java.lang.String r3 = r3.u(r10)
            a.d.a.a.i.b.v3 r4 = r19.d()
            java.lang.String r4 = r4.s(r11)
            r2.c(r1, r3, r4)
            r1 = 5
            k0(r12, r1)
            r12.remove(r13)
            r6 = r20
            r18 = r0
            goto L_0x00d6
        L_0x0124:
            r18 = r0
            goto L_0x00d4
        L_0x0127:
            r12 = r8
            r16 = r12
        L_0x012a:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.v9.z(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    public final int z0() {
        if (this.f == null) {
            d dVar = d.f1239b;
            Context context = this.f2563a.f2123a;
            if (dVar != null) {
                this.f = Integer.valueOf(g.a(context) / 1000);
            } else {
                throw null;
            }
        }
        return this.f.intValue();
    }
}
