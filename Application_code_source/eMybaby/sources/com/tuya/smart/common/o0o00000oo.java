package com.tuya.smart.common;

import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.user.api.IUserStorage;
import com.tuya.smart.android.user.bean.User;

public class o0o00000oo implements IUserStorage {
    public static final String O000000o = "TuyaUserStorageProxy";
    public IUserStorage O00000Oo;
    public IUserStorage O00000o0;

    public o0o00000oo(boolean z) {
        IUserStorage iUserStorage;
        L.d(O000000o, "mSdk: " + z);
        if (z) {
            L.d(O000000o, o0o0000000.O000000o);
            iUserStorage = new o0o0000000(TuyaSmartSdk.getApplication());
        } else {
            L.d(O000000o, o0o000000o.O000000o);
            iUserStorage = new o0o000000o(TuyaSmartSdk.getApplication());
        }
        this.O00000Oo = iUserStorage;
        this.O00000o0 = new o0o00000o0();
    }

    public User load() {
        User load = this.O00000o0.load();
        L.d(O000000o, "mmkvUserStorage user : " + load);
        if (load == null) {
            L.d(O000000o, "mmkvUserStorage user == null");
            load = this.O00000Oo.load();
            if (load != null) {
                L.d(O000000o, "copy userStorage user to mmkvUserStorage");
                this.O00000o0.store((User) load.clone());
            }
        }
        return load;
    }

    public boolean remove() {
        if (this.O00000o0.load() != null) {
            L.d(O000000o, "mmkvUserStorage user != null  clear mmkvUserStorage");
            this.O00000o0.remove();
        }
        this.O00000Oo.remove();
        return true;
    }

    public boolean store(User user) {
        L.d(O000000o, "store");
        this.O00000o0.store(user);
        return true;
    }
}
