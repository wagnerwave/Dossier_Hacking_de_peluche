package com.tuya.smart.android.base.utils;

import android.text.TextUtils;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.base.mmkv.manager.MMKVManager;
import com.tuya.smart.android.base.mmkv.util.GlobalMMKVManager;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00oo0oo;
import com.tuya.smart.common.oo0o0oo0o;
import java.util.HashSet;

public class PreferencesUtil {
    public static final String ADD_DEVICE_HAS_TIP = "add_device_has_tip";
    public static final String AWS_ACCESS_KEY = "aws_access_key";
    public static final String AWS_EXPIRE = "aws_expire";
    public static final String AWS_SECRET_KEY = "aws_secret_key";
    public static final String AWS_TOKEN = "aws_token";
    public static final String CONFIG_ALL = "config_all";
    public static final String DEVICE_SHOW_MORE_CONFIG_JSON = "device_show_more_config_json";
    public static final String DEVICE_TYPE_CONFIG_JSON = "device_type_config_json";
    public static final String FEEDBACK_UPDATE_TIME = "feedback_update_time";
    public static final String GESTURE_PASSWORD_TRY_MORE = "gesture_password_try_more";
    public static final String GESTURE_PASSWORD_TRY_MORE_LOCK = "gesture_password_try_more_lock";
    public static final String GESTURE_PASSWORD_TRY_MORE_TIME = "gesture_password_try_more_lock_time";
    public static final String GLOBAL_KEY = "preferences_global_key";
    public static final String GLOBAL_USER_KEY = "nuo";
    public static final String LOGIN_FROM = "login_from";
    public static final int LOGIN_FROM_CELLPHONE = 0;
    public static final int LOGIN_FROM_MAIL = 1;
    public static final int LOGIN_FROM_SOCIAL = 2;
    public static final String SERVER_REGION = "server_region";
    public static final String SETTING_LOOK_PHOTO_NEED_GESTURE_PASSWORD = "setting_gesture_password";
    public static final String SETTING_PUSH_STATUS = "setting_push_status";
    public static final String SETTING_SET_PASSWORD = "setting_set_gesture_password";
    public static final String SETTING_SHAKE_STATE = "setting_shake_state";
    public static final String SETTING_VOICE_STATE = "setting_voice_state";
    public static final String TAG = "PreferencesUtil";
    public static final String TUYA_CACHE_DIRECTORY = "tuya_cache_internal_directory";
    public static final String UNIVERSAL_PANEL = "tyrct_universal_panel";
    public static final boolean UNIVERSAL_PANEL_DEFAULT = false;
    public static final String UNIVERSAL_PANEL_SUFF = "-pre";
    public static volatile MMKVManager sMMKVManager = null;
    public static volatile String sUID = "";

    public static void clear() {
        getMMKVManager().clear();
    }

    public static Boolean getBoolean(String str) {
        return Boolean.valueOf(getMMKVManager().getBoolean(str, false));
    }

    public static Boolean getBoolean(String str, boolean z) {
        return Boolean.valueOf(getMMKVManager().getBoolean(str, z));
    }

    public static float getFloat(String str) {
        return getMMKVManager().getFloat(str, 0.0f);
    }

    public static float getFloat(String str, float f) {
        return getMMKVManager().getFloat(str, f);
    }

    public static String getGlobalPrefrencesKey(String str) {
        return oo0o0oo0o.O000000o(str);
    }

    public static int getInt(String str) {
        return getMMKVManager().getInt(str, 0);
    }

    public static int getInt(String str, int i) {
        return getMMKVManager().getInt(str, i);
    }

    public static long getLong(String str) {
        return getMMKVManager().getLong(str, 0);
    }

    public static long getLong(String str, long j) {
        return getMMKVManager().getLong(str, j);
    }

    public static MMKVManager getMMKVManager() {
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        User user = o0o00oo0oo != null ? o0o00oo0oo.O000000o().getUser() : null;
        if (sMMKVManager == null || (user != null && !sUID.equals(user.getUid()))) {
            synchronized (PreferencesUtil.class) {
                if (o0o00oo0oo != null) {
                    user = o0o00oo0oo.O000000o().getUser();
                }
                if (sMMKVManager == null || (user != null && !sUID.equals(user.getUid()))) {
                    if (user == null) {
                        sUID = "";
                        sMMKVManager = GlobalMMKVManager.getMMKVManager();
                    } else if (!TextUtils.isEmpty(user.getUid())) {
                        sUID = user.getUid();
                        sMMKVManager = new MMKVManager(TuyaSmartSdk.getApplication(), GLOBAL_KEY + user.getUid());
                    }
                }
            }
        }
        return sMMKVManager;
    }

    public static String getString(String str) {
        return getMMKVManager().getString(str, "");
    }

    public static String getString(String str, String str2) {
        return getMMKVManager().getString(str, str2);
    }

    public static HashSet<String> getStringSet(String str) {
        return (HashSet) getMMKVManager().getStringSet(str, new HashSet());
    }

    public static void remove(String str) {
        getMMKVManager().remove(str);
    }

    public static void reset() {
        synchronized (PreferencesUtil.class) {
            sMMKVManager = null;
        }
    }

    public static void set(String str, float f) {
        getMMKVManager().putFloat(str, f);
    }

    public static void set(String str, int i) {
        getMMKVManager().putInt(str, i);
    }

    public static void set(String str, long j) {
        getMMKVManager().putLong(str, j);
    }

    public static void set(String str, String str2) {
        getMMKVManager().putString(str, str2);
    }

    public static void set(String str, HashSet<String> hashSet) {
        getMMKVManager().putStringSet(str, hashSet);
    }

    public static void set(String str, boolean z) {
        getMMKVManager().putBoolean(str, z);
    }
}
