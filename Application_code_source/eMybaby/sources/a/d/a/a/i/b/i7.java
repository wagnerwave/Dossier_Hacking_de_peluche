package a.d.a.a.i.b;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class i7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final j7 f2270a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2271b;

    /* renamed from: c  reason: collision with root package name */
    public final Exception f2272c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f2273d;

    /* renamed from: e  reason: collision with root package name */
    public final Map f2274e;

    public i7(j7 j7Var, int i, Exception exc, byte[] bArr, Map map) {
        this.f2270a = j7Var;
        this.f2271b = i;
        this.f2272c = exc;
        this.f2273d = bArr;
        this.f2274e = map;
    }

    public final void run() {
        List<ResolveInfo> queryIntentActivities;
        j7 j7Var = this.f2270a;
        int i = this.f2271b;
        Exception exc = this.f2272c;
        byte[] bArr = this.f2273d;
        c5 c5Var = j7Var.f2299b.f2099a;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && exc == null)) {
            c5Var.i().i.c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), exc);
            return;
        }
        c5Var.o().x.a(true);
        if (bArr.length == 0) {
            c5Var.i().m.a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                c5Var.i().m.a("Deferred Deep Link is empty.");
                return;
            }
            v9 t = c5Var.t();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = t.f2563a.f2123a.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                c5Var.i().i.c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            c5Var.p.H("auto", "_cmp", bundle);
            v9 t2 = c5Var.t();
            if (!TextUtils.isEmpty(optString) && t2.W(optString, optDouble)) {
                t2.f2563a.f2123a.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e2) {
            c5Var.i().f.b("Failed to parse the Deferred Deep Link response. exception", e2);
        }
    }
}
