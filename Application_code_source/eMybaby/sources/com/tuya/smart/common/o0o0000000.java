package com.tuya.smart.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.security.SecuredPreferenceStore;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.user.api.IUserStorage;
import com.tuya.smart.android.user.bean.User;

public class o0o0000000 implements IUserStorage {
    public static final String O000000o = "SimpleUserStorage";
    public SharedPreferences O00000Oo;
    public SecuredPreferenceStore O00000o0 = SecuredPreferenceStore.O000000o();

    public o0o0000000(Context context) {
        this.O00000Oo = context.getSharedPreferences(o00ooo0o0o.O000000o, 0);
    }

    public User load() {
        String string = this.O00000o0.getString(o00ooo0o0o.O00000Oo, (String) null);
        if (TextUtils.isEmpty(string)) {
            L.d(O000000o, "try load user new str");
            String string2 = this.O00000Oo.getString(o00ooo0o0o.O00000Oo, (String) null);
            if (!TextUtils.isEmpty(string2)) {
                L.d(O000000o, "change old data to new");
                SecuredPreferenceStore.O000000o O00000o02 = this.O00000o0.edit();
                O00000o02.putString(o00ooo0o0o.O00000Oo, string2);
                O00000o02.apply();
                SharedPreferences.Editor edit = this.O00000Oo.edit();
                edit.remove(o00ooo0o0o.O00000Oo);
                edit.putString(o00ooo0o0o.O00000Oo, (String) null);
                edit.apply();
            }
            string = string2;
        }
        if (string == null) {
            return null;
        }
        try {
            return (User) JSON.parseObject(string, User.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean remove() {
        SecuredPreferenceStore.O000000o O00000o02 = this.O00000o0.edit();
        O00000o02.putString(o00ooo0o0o.O00000Oo, (String) null);
        O00000o02.remove(o00ooo0o0o.O00000Oo);
        return O00000o02.commit();
    }

    public boolean store(User user) {
        SecuredPreferenceStore.O000000o O00000o02 = this.O00000o0.edit();
        O00000o02.putString(o00ooo0o0o.O00000Oo, JSON.toJSONString(user));
        return O00000o02.commit();
    }
}
