package com.tuya.smart.common;

import android.content.Context;
import com.tuya.smart.android.mvp.presenter.BasePresenter;

public abstract class OOO00O0 extends BasePresenter {
    public static final String O000000o = "ec_bssid";
    public static final String O00000Oo = "ec_password";
    public static final String O00000o0 = "ec_key";
    public O000000o O00000o;

    public interface O000000o {
        void O000000o(String str);
    }

    public OOO00O0(Context context) {
        super(context);
    }

    public abstract void O000000o();

    public void O000000o(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public abstract void O00000Oo();

    public void onDestroy() {
        super.onDestroy();
    }
}
