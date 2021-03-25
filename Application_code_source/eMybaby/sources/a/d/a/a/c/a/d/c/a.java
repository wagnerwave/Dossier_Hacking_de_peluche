package a.d.a.a.c.a.d.c;

import a.c.a.f.b;
import a.d.a.a.c.a.d.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final Lock f1208c = new ReentrantLock();
    @GuardedBy("sLk")

    /* renamed from: d  reason: collision with root package name */
    public static a f1209d;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f1210a = new ReentrantLock();
    @GuardedBy("mLk")

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f1211b;

    public a(Context context) {
        this.f1211b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        b.k(context);
        f1208c.lock();
        try {
            if (f1209d == null) {
                f1209d = new a(context.getApplicationContext());
            }
            return f1209d;
        } finally {
            f1208c.unlock();
        }
    }

    public static String f(String str, String str2) {
        return a.a.a.a.a.d(String.valueOf(str2).length() + str.length() + 1, str, ":", str2);
    }

    @Nullable
    public GoogleSignInAccount b() {
        String g;
        String g2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(g2) || (g = g(f("googleSignInAccount", g2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.l(g);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    public GoogleSignInOptions c() {
        String g;
        String g2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(g2) || (g = g(f("googleSignInOptions", g2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.l(g);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void d(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        b.k(googleSignInAccount);
        b.k(googleSignInOptions);
        e("defaultGoogleSignInAccount", googleSignInAccount.i);
        b.k(googleSignInAccount);
        b.k(googleSignInOptions);
        String str = googleSignInAccount.i;
        String f = f("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            if (googleSignInAccount.f4167b != null) {
                jSONObject.put("id", googleSignInAccount.f4167b);
            }
            if (googleSignInAccount.f4168c != null) {
                jSONObject.put("tokenId", googleSignInAccount.f4168c);
            }
            if (googleSignInAccount.f4169d != null) {
                jSONObject.put("email", googleSignInAccount.f4169d);
            }
            if (googleSignInAccount.f4170e != null) {
                jSONObject.put("displayName", googleSignInAccount.f4170e);
            }
            if (googleSignInAccount.k != null) {
                jSONObject.put("givenName", googleSignInAccount.k);
            }
            if (googleSignInAccount.l != null) {
                jSONObject.put("familyName", googleSignInAccount.l);
            }
            if (googleSignInAccount.f != null) {
                jSONObject.put("photoUrl", googleSignInAccount.f.toString());
            }
            if (googleSignInAccount.g != null) {
                jSONObject.put("serverAuthCode", googleSignInAccount.g);
            }
            jSONObject.put("expirationTime", googleSignInAccount.h);
            jSONObject.put("obfuscatedIdentifier", googleSignInAccount.i);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) googleSignInAccount.j.toArray(new Scope[googleSignInAccount.j.size()]);
            Arrays.sort(scopeArr, d.f1223a);
            int i = 0;
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.f4204b);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            e(f, jSONObject.toString());
            String f2 = f("googleSignInOptions", str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(googleSignInOptions.f4172b, GoogleSignInOptions.q);
                ArrayList<Scope> arrayList = googleSignInOptions.f4172b;
                int size = arrayList.size();
                while (i < size) {
                    Scope scope2 = arrayList.get(i);
                    i++;
                    jSONArray2.put(scope2.f4204b);
                }
                jSONObject2.put("scopes", jSONArray2);
                if (googleSignInOptions.f4173c != null) {
                    jSONObject2.put("accountName", googleSignInOptions.f4173c.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.f4174d);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.f);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.f4175e);
                if (!TextUtils.isEmpty(googleSignInOptions.g)) {
                    jSONObject2.put("serverClientId", googleSignInOptions.g);
                }
                if (!TextUtils.isEmpty(googleSignInOptions.h)) {
                    jSONObject2.put("hostedDomain", googleSignInOptions.h);
                }
                e(f2, jSONObject2.toString());
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void e(String str, String str2) {
        this.f1210a.lock();
        try {
            this.f1211b.edit().putString(str, str2).apply();
        } finally {
            this.f1210a.unlock();
        }
    }

    @Nullable
    public final String g(String str) {
        this.f1210a.lock();
        try {
            return this.f1211b.getString(str, (String) null);
        } finally {
            this.f1210a.unlock();
        }
    }
}
