package com.tuya.smart.common;

import android.content.Context;
import android.text.TextUtils;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.user.api.IUserStorage;
import com.tuya.smart.android.user.bean.User;

public class o00ooooooo extends BaseModel implements o00oooo0oo {
    public User O000000o;
    public IUserStorage O00000Oo;

    public o00ooooooo(Context context, IUserStorage iUserStorage) {
        super(context);
        this.O00000Oo = iUserStorage;
    }

    public User O000000o() {
        if (this.O000000o == null) {
            this.O000000o = this.O00000Oo.load();
        }
        return this.O000000o;
    }

    public void O000000o(IUserStorage iUserStorage) {
        this.O00000Oo = iUserStorage;
    }

    public boolean O000000o(User user) {
        User user2 = (User) user.clone();
        this.O000000o = user2;
        return this.O00000Oo.store(user2);
    }

    public boolean O00000Oo() {
        this.O000000o = null;
        return this.O00000Oo.remove();
    }

    public String O00000o() {
        if (this.O000000o == null) {
            O000000o();
        }
        User user = this.O000000o;
        return user == null ? "" : user.getSid();
    }

    public boolean O00000o0() {
        O000000o();
        User user = this.O000000o;
        return user != null && !TextUtils.isEmpty(user.getUid()) && !TextUtils.isEmpty(this.O000000o.getSid());
    }

    public void onDestroy() {
    }
}
