package com.tuya.smart.common;

import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.api.IGroupListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaGroup;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.List;

public class oOo00ooO implements ITuyaGroup {
    public long O000000o;
    public final ITuyaGroup O00000Oo;
    public oO00o000 O00000o0;

    public oOo00ooO(long j) {
        this.O000000o = j;
        this.O00000Oo = new oOOoOOO0(j);
    }

    public void addDevice(final String str, final IResultCallback iResultCallback) {
        this.O00000Oo.addDevice(str, new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o0().addDevToGroup(oOo00ooO.this.O000000o, str);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void dismissGroup(final IResultCallback iResultCallback) {
        this.O00000Oo.dismissGroup(new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o0().removeGroup(oOo00ooO.this.O000000o);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void onDestroy() {
        this.O00000Oo.onDestroy();
        unRegisterGroupListener();
    }

    public void publishDps(String str, IResultCallback iResultCallback) {
        this.O00000Oo.publishDps(str, iResultCallback);
    }

    public void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback) {
        this.O00000Oo.publishDps(str, tYDevicePublishModeEnum, iResultCallback);
    }

    public void registerGroupListener(IGroupListener iGroupListener) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new oO00o000(this.O000000o, iGroupListener);
        }
    }

    public void removeDevice(final String str, final IResultCallback iResultCallback) {
        this.O00000Oo.removeDevice(str, new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o0().removeDevFromGroup(oOo00ooO.this.O000000o, str);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void renameGroup(final String str, final IResultCallback iResultCallback) {
        this.O00000Oo.renameGroup(str, new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                GroupRespBean O00000o02 = o0O000Oo.O000000o().O00000o0(oOo00ooO.this.O000000o);
                O00000o02.setName(str);
                o0O000Oo.O000000o().O00000Oo(O00000o02);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void unRegisterGroupListener() {
        oO00o000 oo00o000 = this.O00000o0;
        if (oo00o000 != null) {
            oo00o000.O000000o();
        }
    }

    public void updateDeviceList(final List<String> list, final IResultCallback iResultCallback) {
        this.O00000Oo.updateDeviceList(list, new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                o0O0O00O.O00000o0();
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o0().updateDeviceList(oOo00ooO.this.O000000o, list);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }
}
