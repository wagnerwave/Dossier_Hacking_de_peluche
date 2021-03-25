package a.d.a.a.e.m;

import a.d.a.a.e.f;
import a.d.a.a.e.i;
import a.d.a.a.e.r.b;
import a.d.a.a.e.r.c;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import javax.annotation.concurrent.GuardedBy;

public final class d {
    @GuardedBy("sCache")

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleArrayMap<String, String> f1382a = new SimpleArrayMap<>();

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            b a2 = c.a(context);
            return a2.f1443a.getPackageManager().getApplicationLabel(a2.f1443a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(a.d.a.a.d.c.common_google_play_services_notification_channel_name);
    }

    @NonNull
    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        String a2 = a(context);
        if (i == 1) {
            return resources.getString(a.d.a.a.d.c.common_google_play_services_install_text, new Object[]{a2});
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(a.d.a.a.d.c.common_google_play_services_enable_text, new Object[]{a2});
            } else if (i == 5) {
                return f(context, "common_google_play_services_invalid_account_text", a2);
            } else {
                if (i == 7) {
                    return f(context, "common_google_play_services_network_error_text", a2);
                }
                if (i == 9) {
                    return resources.getString(a.d.a.a.d.c.common_google_play_services_unsupported_text, new Object[]{a2});
                } else if (i == 20) {
                    return f(context, "common_google_play_services_restricted_profile_text", a2);
                } else {
                    switch (i) {
                        case 16:
                            return f(context, "common_google_play_services_api_unavailable_text", a2);
                        case 17:
                            return f(context, "common_google_play_services_sign_in_failed_text", a2);
                        case 18:
                            return resources.getString(a.d.a.a.d.c.common_google_play_services_updating_text, new Object[]{a2});
                        default:
                            return resources.getString(i.common_google_play_services_unknown_issue, new Object[]{a2});
                    }
                }
            }
        } else if (a.c.a.f.b.W(context)) {
            return resources.getString(a.d.a.a.d.c.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(a.d.a.a.d.c.common_google_play_services_update_text, new Object[]{a2});
        }
    }

    @Nullable
    public static String d(Context context, int i) {
        String str;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(a.d.a.a.d.c.common_google_play_services_install_title);
            case 2:
                return resources.getString(a.d.a.a.d.c.common_google_play_services_update_title);
            case 3:
                return resources.getString(a.d.a.a.d.c.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return e(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return e(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return e(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return e(context, "common_google_play_services_restricted_profile_title");
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                str = sb.toString();
                break;
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    @Nullable
    public static String e(Context context, String str) {
        synchronized (f1382a) {
            String str2 = f1382a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources i = f.i(context);
            if (i == null) {
                return null;
            }
            int identifier = i.getIdentifier(str, StringSchemaBean.type, "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = i.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            f1382a.put(str, string);
            return string;
        }
    }

    public static String f(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String e2 = e(context, str);
        if (e2 == null) {
            e2 = resources.getString(i.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, e2, new Object[]{str2});
    }
}
