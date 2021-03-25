package a.d.b;

import a.c.a.f.b;
import a.d.a.a.e.i;
import a.d.a.a.e.m.o;
import a.d.a.a.e.q.g;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import java.util.Arrays;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f2724a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2725b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2726c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2727d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2728e;
    public final String f;
    public final String g;

    public e(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        b.o(!g.a(str), "ApplicationId must be set.");
        this.f2725b = str;
        this.f2724a = str2;
        this.f2726c = str3;
        this.f2727d = str4;
        this.f2728e = str5;
        this.f = str6;
        this.g = str7;
    }

    @Nullable
    public static e a(@NonNull Context context) {
        b.k(context);
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(i.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_id", StringSchemaBean.type, resourcePackageName);
        String str = null;
        String string = identifier == 0 ? null : resources.getString(identifier);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        int identifier2 = resources.getIdentifier("google_api_key", StringSchemaBean.type, resourcePackageName);
        String string2 = identifier2 == 0 ? null : resources.getString(identifier2);
        int identifier3 = resources.getIdentifier("firebase_database_url", StringSchemaBean.type, resourcePackageName);
        String string3 = identifier3 == 0 ? null : resources.getString(identifier3);
        int identifier4 = resources.getIdentifier("ga_trackingId", StringSchemaBean.type, resourcePackageName);
        String string4 = identifier4 == 0 ? null : resources.getString(identifier4);
        int identifier5 = resources.getIdentifier("gcm_defaultSenderId", StringSchemaBean.type, resourcePackageName);
        String string5 = identifier5 == 0 ? null : resources.getString(identifier5);
        int identifier6 = resources.getIdentifier("google_storage_bucket", StringSchemaBean.type, resourcePackageName);
        String string6 = identifier6 == 0 ? null : resources.getString(identifier6);
        int identifier7 = resources.getIdentifier("project_id", StringSchemaBean.type, resourcePackageName);
        if (identifier7 != 0) {
            str = resources.getString(identifier7);
        }
        return new e(string, string2, string3, string4, string5, string6, str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return b.B(this.f2725b, eVar.f2725b) && b.B(this.f2724a, eVar.f2724a) && b.B(this.f2726c, eVar.f2726c) && b.B(this.f2727d, eVar.f2727d) && b.B(this.f2728e, eVar.f2728e) && b.B(this.f, eVar.f) && b.B(this.g, eVar.g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2725b, this.f2724a, this.f2726c, this.f2727d, this.f2728e, this.f, this.g});
    }

    public String toString() {
        o y0 = b.y0(this);
        y0.a("applicationId", this.f2725b);
        y0.a("apiKey", this.f2724a);
        y0.a("databaseUrl", this.f2726c);
        y0.a("gcmSenderId", this.f2728e);
        y0.a("storageBucket", this.f);
        y0.a("projectId", this.g);
        return y0.toString();
    }
}
