package com.tuya.smart.common;

import android.content.Context;
import android.text.TextUtils;
import com.tuya.sdk.config.bean.ErrorConfig;
import com.tuya.sdk.config.enums.WifiSecurityEnum;
import com.tuya.smart.home.sdk.api.config.IApConnectListener;

public class OO0Oo00 {
    public Context O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public WifiSecurityEnum O00000oO;
    public IApConnectListener O00000oo;
    public String O0000O0o;
    public long O0000OOo = -1;

    public Context O000000o() {
        return this.O000000o;
    }

    public OO0Oo00 O000000o(long j) {
        this.O0000OOo = j;
        return this;
    }

    public OO0Oo00 O000000o(Context context) {
        this.O000000o = context;
        return this;
    }

    @Deprecated
    public OO0Oo00 O000000o(WifiSecurityEnum wifiSecurityEnum) {
        this.O00000oO = wifiSecurityEnum;
        return this;
    }

    public OO0Oo00 O000000o(IApConnectListener iApConnectListener) {
        this.O00000oo = iApConnectListener;
        return this;
    }

    @Deprecated
    public OO0Oo00 O000000o(String str) {
        this.O00000Oo = str;
        return this;
    }

    public OO0Oo00 O00000Oo(String str) {
        this.O00000o0 = str;
        return this;
    }

    @Deprecated
    public String O00000Oo() {
        return this.O00000Oo;
    }

    public OO0Oo00 O00000o(String str) {
        this.O0000O0o = str;
        return this;
    }

    public String O00000o() {
        return this.O00000o;
    }

    public OO0Oo00 O00000o0(String str) {
        this.O00000o = str;
        return this;
    }

    public String O00000o0() {
        return this.O00000o0;
    }

    public IApConnectListener O00000oO() {
        return this.O00000oo;
    }

    @Deprecated
    public WifiSecurityEnum O00000oo() {
        return this.O00000oO;
    }

    public OO0o00 O0000O0o() {
        if (!TextUtils.isEmpty(this.O00000o0)) {
            return new OO0o00(this);
        }
        throw new IllegalArgumentException(ErrorConfig.ILLEGAL_BSSID);
    }

    public OO0o O0000OOo() {
        if (!TextUtils.isEmpty(this.O00000o0)) {
            return new OO0o(this);
        }
        throw new IllegalArgumentException(ErrorConfig.ILLEGAL_BSSID);
    }

    public long O0000Oo() {
        return this.O0000OOo;
    }

    public String O0000Oo0() {
        return this.O0000O0o;
    }
}
