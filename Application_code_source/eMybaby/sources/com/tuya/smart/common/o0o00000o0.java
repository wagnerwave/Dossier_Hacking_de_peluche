package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.utils.UserPreferenceUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.user.api.IUserStorage;
import com.tuya.smart.android.user.bean.User;

public class o0o00000o0 implements IUserStorage {
    public static final String O000000o = "TuyaUserStorageMMKV";

    public User load() {
        try {
            String string = UserPreferenceUtil.getString(o00ooo0o0o.O00000Oo, "");
            L.d(O000000o, "load jsonUser : " + string);
            if (!TextUtils.isEmpty(string)) {
                try {
                    return (User) JSON.parseObject(string, User.class);
                } catch (Exception e2) {
                    StringBuilder n = a.n("parseObject error: ");
                    n.append(e2.getMessage());
                    L.e(O000000o, n.toString());
                }
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public boolean remove() {
        try {
            UserPreferenceUtil.remove(o00ooo0o0o.O00000Oo);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public boolean store(User user) {
        try {
            UserPreferenceUtil.clear();
            UserPreferenceUtil.putString(o00ooo0o0o.O00000Oo, JSON.toJSONString(user));
            L.d(O000000o, "load store");
            return true;
        } catch (Exception e2) {
            StringBuilder n = a.n("store putString: ");
            n.append(e2.getMessage());
            L.e(O000000o, n.toString());
            e2.printStackTrace();
            return true;
        }
    }
}
