package com.google.android.gms.auth.api.signin;

import a.c.a.f.b;
import a.d.a.a.c.a.d.f;
import a.d.a.a.c.a.d.g;
import a.d.a.a.e.k.a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new g();
    public static final Scope k = new Scope("profile");
    public static final Scope l = new Scope("email");
    public static final Scope m = new Scope("openid");
    public static final Scope n = new Scope("https://www.googleapis.com/auth/games_lite");
    public static final Scope o = new Scope("https://www.googleapis.com/auth/games");
    public static final GoogleSignInOptions p;
    public static Comparator<Scope> q = new f();

    /* renamed from: a  reason: collision with root package name */
    public final int f4171a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Scope> f4172b;

    /* renamed from: c  reason: collision with root package name */
    public Account f4173c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4174d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4175e;
    public final boolean f;
    public String g;
    public String h;
    public ArrayList<GoogleSignInOptionsExtensionParcelable> i;
    public String j;

    static {
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        hashSet.add(m);
        hashSet.add(k);
        if (hashSet.contains(o) && hashSet.contains(n)) {
            hashSet.remove(n);
        }
        p = new GoogleSignInOptions(3, new ArrayList(hashSet), (Account) null, false, false, false, (String) null, (String) null, hashMap, (String) null);
        HashSet hashSet2 = new HashSet();
        HashMap hashMap2 = new HashMap();
        hashSet2.add(n);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(o) && hashSet2.contains(n)) {
            hashSet2.remove(n);
        }
        new ArrayList(hashSet2);
        new ArrayList(hashMap2.values());
    }

    public GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String str3) {
        this.f4171a = i2;
        this.f4172b = arrayList;
        this.f4173c = account;
        this.f4174d = z;
        this.f4175e = z2;
        this.f = z3;
        this.g = str;
        this.h = str2;
        this.i = new ArrayList<>(map.values());
        this.j = str3;
    }

    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> h(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.f4180b), next);
        }
        return hashMap;
    }

    @Nullable
    public static GoogleSignInOptions l(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString = jSONObject.optString("accountName", (String) null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", (String) null), jSONObject.optString("hostedDomain", (String) null), new HashMap(), (String) null);
    }

    public ArrayList<Scope> e() {
        return new ArrayList<>(this.f4172b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r3.f4173c.equals(r4.f4173c) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        if (r3.g.equals(r4.g) != false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0080 }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.i     // Catch:{ ClassCastException -> 0x0080 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 > 0) goto L_0x0080
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.i     // Catch:{ ClassCastException -> 0x0080 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 <= 0) goto L_0x0017
            goto L_0x0080
        L_0x0017:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f4172b     // Catch:{ ClassCastException -> 0x0080 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0080 }
            java.util.ArrayList r2 = r4.e()     // Catch:{ ClassCastException -> 0x0080 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f4172b     // Catch:{ ClassCastException -> 0x0080 }
            java.util.ArrayList r2 = r4.e()     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != 0) goto L_0x0034
            goto L_0x0080
        L_0x0034:
            android.accounts.Account r1 = r3.f4173c     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != 0) goto L_0x003d
            android.accounts.Account r1 = r4.f4173c     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != 0) goto L_0x0080
            goto L_0x0047
        L_0x003d:
            android.accounts.Account r1 = r3.f4173c     // Catch:{ ClassCastException -> 0x0080 }
            android.accounts.Account r2 = r4.f4173c     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0080
        L_0x0047:
            java.lang.String r1 = r3.g     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0058
            java.lang.String r1 = r4.g     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0080
            goto L_0x0062
        L_0x0058:
            java.lang.String r1 = r3.g     // Catch:{ ClassCastException -> 0x0080 }
            java.lang.String r2 = r4.g     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0080
        L_0x0062:
            boolean r1 = r3.f     // Catch:{ ClassCastException -> 0x0080 }
            boolean r2 = r4.f     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            boolean r1 = r3.f4174d     // Catch:{ ClassCastException -> 0x0080 }
            boolean r2 = r4.f4174d     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            boolean r1 = r3.f4175e     // Catch:{ ClassCastException -> 0x0080 }
            boolean r2 = r4.f4175e     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            java.lang.String r1 = r3.j     // Catch:{ ClassCastException -> 0x0080 }
            java.lang.String r4 = r4.j     // Catch:{ ClassCastException -> 0x0080 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0080 }
            if (r4 == 0) goto L_0x0080
            r4 = 1
            return r4
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i2;
        int i3;
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f4172b;
        int size = arrayList2.size();
        int i4 = 0;
        int i5 = 0;
        while (i5 < size) {
            Scope scope = arrayList2.get(i5);
            i5++;
            arrayList.add(scope.f4204b);
        }
        Collections.sort(arrayList);
        Account account = this.f4173c;
        int hashCode = (arrayList.hashCode() + 31) * 31;
        if (account == null) {
            i2 = 0;
        } else {
            i2 = account.hashCode();
        }
        int i6 = hashCode + i2;
        String str = this.g;
        int i7 = i6 * 31;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = str.hashCode();
        }
        int i8 = ((((((i7 + i3) * 31) + (this.f ? 1 : 0)) * 31) + (this.f4174d ? 1 : 0)) * 31) + (this.f4175e ? 1 : 0);
        String str2 = this.j;
        int i9 = i8 * 31;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return i9 + i4;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4171a);
        b.J0(parcel, 2, e(), false);
        b.G0(parcel, 3, this.f4173c, i2, false);
        b.B0(parcel, 4, this.f4174d);
        b.B0(parcel, 5, this.f4175e);
        b.B0(parcel, 6, this.f);
        b.H0(parcel, 7, this.g, false);
        b.H0(parcel, 8, this.h, false);
        b.J0(parcel, 9, this.i, false);
        b.H0(parcel, 10, this.j, false);
        b.u1(parcel, b2);
    }
}
