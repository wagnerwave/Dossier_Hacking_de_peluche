package a.d.a.a.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;

public final class f extends g {
    public static Resources i(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
