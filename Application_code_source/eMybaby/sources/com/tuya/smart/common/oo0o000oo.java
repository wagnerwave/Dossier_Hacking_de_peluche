package com.tuya.smart.common;

import com.tuya.smart.home.sdk.api.ITuyaHomeScene;
import com.tuya.smart.home.sdk.bean.scene.SceneBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;

public class oo0o000oo implements ITuyaHomeScene {
    public static oo0o000oo O00000o0;
    public String O000000o;
    public oo0o0000o O00000Oo = new oo0o0000o();

    public oo0o000oo(String str) {
        this.O000000o = str;
    }

    public static oo0o000oo O000000o(String str) {
        oo0o000oo oo0o000oo = O00000o0;
        if (oo0o000oo == null) {
            synchronized (oo0o000oo.class) {
                if (O00000o0 == null) {
                    O00000o0 = new oo0o000oo(str);
                } else {
                    O00000o0.O00000Oo(str);
                }
            }
        } else {
            oo0o000oo.O00000Oo(str);
        }
        return O00000o0;
    }

    private void O00000Oo(String str) {
        this.O000000o = str;
    }

    public void deleteScene(IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(this.O000000o, iResultCallback);
    }

    public void disableScene(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(false, str, iResultCallback);
    }

    public void enableScene(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(true, str, iResultCallback);
    }

    public void executeScene(IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, iResultCallback);
    }

    public void modifyScene(SceneBean sceneBean, ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        this.O00000Oo.O000000o(sceneBean, iTuyaResultCallback);
    }

    public void onDestroy() {
        oo0o0000o oo0o0000o = this.O00000Oo;
        if (oo0o0000o != null) {
            oo0o0000o.onDestroy();
            this.O00000Oo = null;
        }
    }
}
