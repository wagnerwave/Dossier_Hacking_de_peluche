package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tuya.sdk.security.SecuredPreferenceStore;
import com.tuya.smart.android.common.utils.MD5Util;
import java.util.UUID;

public class oo0o0oo0o {
    public static Context O000000o;

    public static String O000000o() {
        SharedPreferences sharedPreferences = O000000o.getSharedPreferences("global_preference_table", 0);
        String string = sharedPreferences.getString("70f737feb6cd4a17f2e7859a405f5d99", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String md5AsBase64 = MD5Util.md5AsBase64(UUID.randomUUID().toString());
        sharedPreferences.edit().putString("70f737feb6cd4a17f2e7859a405f5d99", md5AsBase64).apply();
        return md5AsBase64;
    }

    public static String O000000o(String str) {
        String string = SecuredPreferenceStore.O000000o().getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        StringBuilder n = a.n(str);
        n.append(UUID.randomUUID());
        String md5AsBase64 = MD5Util.md5AsBase64(n.toString());
        SecuredPreferenceStore.O000000o().edit().putString(str, md5AsBase64).apply();
        return md5AsBase64;
    }

    public static void O000000o(Context context) {
        O000000o = context;
        SecuredPreferenceStore.O000000o(context, "global_preference", "preference_alias", O000000o().getBytes(), new oo0o0o0oo());
    }
}
