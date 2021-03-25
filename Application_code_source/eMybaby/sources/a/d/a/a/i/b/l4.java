package a.d.a.a.i.b;

import a.c.a.f.b;
import a.g.a.b.d;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.tuya.smart.common.o0ooo00oo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2341a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f2342b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    public boolean f2343c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f2344d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k4 f2345e;

    public l4(k4 k4Var, String str) {
        this.f2345e = k4Var;
        b.h(str);
        this.f2341a = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:34|35|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r12.f2345e.i().f.a("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009e */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle a() {
        /*
            r12 = this;
            boolean r0 = r12.f2343c
            if (r0 != 0) goto L_0x00c7
            r0 = 1
            r12.f2343c = r0
            a.d.a.a.i.b.k4 r1 = r12.f2345e
            android.content.SharedPreferences r1 = r1.v()
            java.lang.String r2 = r12.f2341a
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)
            if (r1 == 0) goto L_0x00bf
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x00b2 }
            r2.<init>()     // Catch:{ JSONException -> 0x00b2 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00b2 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x00b2 }
            r1 = 0
            r4 = 0
        L_0x0022:
            int r5 = r3.length()     // Catch:{ JSONException -> 0x00b2 }
            if (r4 >= r5) goto L_0x00af
            org.json.JSONObject r5 = r3.getJSONObject(r4)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            java.lang.String r6 = "n"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            java.lang.String r7 = "t"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            r8 = -1
            int r9 = r7.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            r10 = 100
            r11 = 2
            if (r9 == r10) goto L_0x005f
            r10 = 108(0x6c, float:1.51E-43)
            if (r9 == r10) goto L_0x0055
            r10 = 115(0x73, float:1.61E-43)
            if (r9 == r10) goto L_0x004b
            goto L_0x0068
        L_0x004b:
            java.lang.String r9 = "s"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            if (r9 == 0) goto L_0x0068
            r8 = 0
            goto L_0x0068
        L_0x0055:
            java.lang.String r9 = "l"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            if (r9 == 0) goto L_0x0068
            r8 = 2
            goto L_0x0068
        L_0x005f:
            java.lang.String r9 = "d"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            if (r9 == 0) goto L_0x0068
            r8 = 1
        L_0x0068:
            java.lang.String r9 = "v"
            if (r8 == 0) goto L_0x0096
            if (r8 == r0) goto L_0x008a
            if (r8 == r11) goto L_0x007e
            a.d.a.a.i.b.k4 r5 = r12.f2345e     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            java.lang.String r6 = "Unrecognized persisted bundle type. Type"
            r5.b(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            goto L_0x00ab
        L_0x007e:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            long r7 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            r2.putLong(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            goto L_0x00ab
        L_0x008a:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            double r7 = java.lang.Double.parseDouble(r5)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            r2.putDouble(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            goto L_0x00ab
        L_0x0096:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            r2.putString(r6, r5)     // Catch:{ NumberFormatException | JSONException -> 0x009e }
            goto L_0x00ab
        L_0x009e:
            a.d.a.a.i.b.k4 r5 = r12.f2345e     // Catch:{ JSONException -> 0x00b2 }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ JSONException -> 0x00b2 }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r6 = "Error reading value from SharedPreferences. Value dropped"
            r5.a(r6)     // Catch:{ JSONException -> 0x00b2 }
        L_0x00ab:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x00af:
            r12.f2344d = r2     // Catch:{ JSONException -> 0x00b2 }
            goto L_0x00bf
        L_0x00b2:
            a.d.a.a.i.b.k4 r0 = r12.f2345e
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.a(r1)
        L_0x00bf:
            android.os.Bundle r0 = r12.f2344d
            if (r0 != 0) goto L_0x00c7
            android.os.Bundle r0 = r12.f2342b
            r12.f2344d = r0
        L_0x00c7:
            android.os.Bundle r0 = r12.f2344d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.l4.a():android.os.Bundle");
    }

    @WorkerThread
    public final void b(Bundle bundle) {
        String str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f2345e.v().edit();
        if (bundle.size() == 0) {
            edit.remove(this.f2341a);
        } else {
            String str2 = this.f2341a;
            JSONArray jSONArray = new JSONArray();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str3);
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            str = "s";
                        } else if (obj instanceof Long) {
                            str = "l";
                        } else if (obj instanceof Double) {
                            str = d.f;
                        } else {
                            this.f2345e.i().f.b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONObject.put(o0ooo00oo.O00000oo, str);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        this.f2345e.i().f.b("Cannot serialize bundle value to SharedPreferences", e2);
                    }
                }
            }
            edit.putString(str2, jSONArray.toString());
        }
        edit.apply();
        this.f2344d = bundle;
    }
}
