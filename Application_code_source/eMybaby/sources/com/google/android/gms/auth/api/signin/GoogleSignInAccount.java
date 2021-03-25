package com.google.android.gms.auth.api.signin;

import a.d.a.a.c.a.d.e;
import a.d.a.a.e.q.b;
import a.d.a.a.e.q.c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e();
    public static b n = c.f1429a;

    /* renamed from: a  reason: collision with root package name */
    public final int f4166a;

    /* renamed from: b  reason: collision with root package name */
    public String f4167b;

    /* renamed from: c  reason: collision with root package name */
    public String f4168c;

    /* renamed from: d  reason: collision with root package name */
    public String f4169d;

    /* renamed from: e  reason: collision with root package name */
    public String f4170e;
    public Uri f;
    public String g;
    public long h;
    public String i;
    public List<Scope> j;
    public String k;
    public String l;
    public Set<Scope> m = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f4166a = i2;
        this.f4167b = str;
        this.f4168c = str2;
        this.f4169d = str3;
        this.f4170e = str4;
        this.f = uri;
        this.g = str5;
        this.h = j2;
        this.i = str6;
        this.j = list;
        this.k = str7;
        this.l = str8;
    }

    public static final int h(Scope scope, Scope scope2) {
        return scope.f4204b.compareTo(scope2.f4204b);
    }

    @Nullable
    public static GoogleSignInAccount l(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.optString("tokenId", (String) null);
        String optString4 = jSONObject.optString("email", (String) null);
        String optString5 = jSONObject.optString("displayName", (String) null);
        String optString6 = jSONObject.optString("givenName", (String) null);
        String optString7 = jSONObject.optString("familyName", (String) null);
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (valueOf == null) {
            valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        long longValue = valueOf.longValue();
        a.c.a.f.b.h(string);
        a.c.a.f.b.k(hashSet);
        GoogleSignInAccount googleSignInAccount = r3;
        GoogleSignInAccount googleSignInAccount2 = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, (String) null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        GoogleSignInAccount googleSignInAccount3 = googleSignInAccount;
        googleSignInAccount3.g = jSONObject.optString("serverAuthCode", (String) null);
        return googleSignInAccount3;
    }

    @NonNull
    public Set<Scope> e() {
        HashSet hashSet = new HashSet(this.j);
        hashSet.addAll(this.m);
        return hashSet;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.i.equals(this.i)) {
            if (((AbstractSet) googleSignInAccount.e()).equals(e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((AbstractSet) e()).hashCode() + ((this.i.hashCode() + 527) * 31);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int b2 = a.c.a.f.b.b(parcel);
        a.c.a.f.b.E0(parcel, 1, this.f4166a);
        a.c.a.f.b.H0(parcel, 2, this.f4167b, false);
        a.c.a.f.b.H0(parcel, 3, this.f4168c, false);
        a.c.a.f.b.H0(parcel, 4, this.f4169d, false);
        a.c.a.f.b.H0(parcel, 5, this.f4170e, false);
        a.c.a.f.b.G0(parcel, 6, this.f, i2, false);
        a.c.a.f.b.H0(parcel, 7, this.g, false);
        a.c.a.f.b.F0(parcel, 8, this.h);
        a.c.a.f.b.H0(parcel, 9, this.i, false);
        a.c.a.f.b.J0(parcel, 10, this.j, false);
        a.c.a.f.b.H0(parcel, 11, this.k, false);
        a.c.a.f.b.H0(parcel, 12, this.l, false);
        a.c.a.f.b.u1(parcel, b2);
    }
}
