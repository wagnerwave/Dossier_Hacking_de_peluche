package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.android.common.utils.TuyaCache;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.home.sdk.api.config.IConnectListener;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.Map;

public class OOO0O0O extends BasePresenter {
    public static final int O000000o = 21;
    public static final String O00000Oo = "DeviceBindLoop";
    public OOOO00O O00000o;
    public final IConnectListener O00000o0;
    public final OO0OOo0 O00000oO = new OOO0oO(TuyaSmartNetWork.getAppContext(), this.mHandler);
    public boolean O00000oo;
    public boolean O0000O0o;
    public String O0000OOo;
    public o0o00o00o0 O0000Oo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public long O0000Oo0;
    public OOO00Oo O0000OoO;
    public OOO0OO0 O0000Ooo;

    public OOO0O0O(Context context, IConnectListener iConnectListener) {
        super(context);
        this.O00000o0 = iConnectListener;
    }

    private void O000000o(final GwDevResp gwDevResp) {
        o0o00o00o0 o0o00o00o0;
        L.d(O00000Oo, "checkActiveSuccess");
        if (!gwDevResp.getIsShare().booleanValue()) {
            L.d(O00000Oo, "device is active");
            if (!this.O0000O0o && gwDevResp.getActiveTime() + 10 > this.O0000Oo0) {
                this.O0000O0o = true;
                IConnectListener iConnectListener = this.O00000o0;
                if (!(iConnectListener == null || (o0o00o00o0 = this.O0000Oo) == null)) {
                    iConnectListener.onDeviceBindSuccess(o0o00o00o0.O0000OoO().O000000o(gwDevResp));
                }
            }
            if (!gwDevResp.getIsOnline().booleanValue()) {
                OOO00Oo oOO00Oo = this.O0000OoO;
                if (oOO00Oo != null) {
                    oOO00Oo.O00000oO().put("step", "online");
                }
                if (this.O0000Ooo != null) {
                    this.O0000Ooo.O00000Oo((Map<String, Object>) null, a.r("step", "online"));
                }
            } else if (TextUtils.isEmpty(gwDevResp.getOwnerId())) {
                OOO00Oo oOO00Oo2 = this.O0000OoO;
                if (oOO00Oo2 != null) {
                    oOO00Oo2.O00000oO().put("step", "bind_home");
                }
                if (this.O0000Ooo != null) {
                    this.O0000Ooo.O00000Oo((Map<String, Object>) null, a.r("step", "bind_home"));
                }
                O000000o(gwDevResp.getGwId(), (IResultCallback) new IResultCallback() {
                    public void onError(String str, String str2) {
                    }

                    public void onSuccess() {
                        if (OOO0O0O.this.O0000Oo != null) {
                            OOO0O0O ooo0o0o = OOO0O0O.this;
                            ooo0o0o.O000000o(ooo0o0o.O0000Oo.O0000OoO().O000000o(gwDevResp));
                        }
                    }
                });
                return;
            } else {
                L.d(O00000Oo, "device is onLine");
                o0o00o00o0 o0o00o00o02 = this.O0000Oo;
                if (o0o00o00o02 != null) {
                    O000000o(o0o00o00o02.O0000OoO().O000000o(gwDevResp));
                    return;
                }
                return;
            }
        }
        O00000Oo();
    }

    /* access modifiers changed from: private */
    public void O000000o(DeviceBean deviceBean) {
        OOO00Oo oOO00Oo = this.O0000OoO;
        if (oOO00Oo != null) {
            oOO00Oo.O00000oO().put("step", "update_device");
        }
        if (this.O0000Ooo != null) {
            this.O0000Ooo.O00000Oo((Map<String, Object>) null, a.r("step", "update_device"));
            this.O0000Oo.O0000Ooo().O000000o(this.O0000Ooo.O000000o(), "device_config_add");
        }
        if (!TextUtils.isEmpty(TuyaSdk.getLatitude()) && !TextUtils.isEmpty(TuyaSdk.getLongitude())) {
            new oOo00().O00000Oo(deviceBean.getDevId());
        }
        o0o00o00o0 o0o00o00o0 = this.O0000Oo;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000Ooo().O000000o(deviceBean.getDevId(), (ITuyaDataCallback<DeviceBean>) new ITuyaDataCallback<DeviceBean>() {
                /* renamed from: O000000o */
                public void onSuccess(DeviceBean deviceBean) {
                    OOO0O0O.this.O00000Oo(deviceBean);
                    OOO0O0O.this.O000000o();
                }

                public void onError(String str, String str2) {
                    OOO0O0O.this.O000000o();
                    if (OOO0O0O.this.O0000Ooo != null) {
                        OOO0O0O.this.O0000Ooo.O00000Oo((Map<String, Object>) null, a.r("step", "update_device_failure"));
                    }
                }
            });
        }
    }

    private void O000000o(String str, final IResultCallback iResultCallback) {
        L.d(O00000Oo, "bind device to family: " + str);
        L.d(O00000Oo, "token: " + this.O0000OOo);
        Object key = TuyaCache.getInstance().getKey(this.O0000OOo);
        if (key != null) {
            L.d(O00000Oo, " groupId " + key);
            this.O00000oO.O000000o(str, (Long) key, new IResultCallback() {
                public void onError(String str, String str2) {
                    iResultCallback.onError(str, str2);
                }

                public void onSuccess() {
                    iResultCallback.onSuccess();
                    LogUtils.logServer(OOO0O0O.this.O00000o.O0000OOo() ? OOOOO00.O00000Oo : OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O0000OOo, OOO0O0O.this.O0000OOo));
                }
            });
        }
    }

    private void O00000Oo() {
        if (!this.O00000oo) {
            this.mHandler.sendEmptyMessageDelayed(21, 2000);
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(DeviceBean deviceBean) {
        DeviceRespBean O00000o02;
        o0o00o00o0 o0o00o00o0 = this.O0000Oo;
        if (!(o0o00o00o0 == null || (O00000o02 = o0o00o00o0.O0000OoO().O00000o0(deviceBean.getDevId())) == null)) {
            O00000o02.setLat(TuyaSdk.getLatitude());
            O00000o02.setLon(TuyaSdk.getLongitude());
        }
        Object key = TuyaCache.getInstance().getKey(this.O0000OOo);
        if (key != null) {
            OO0OOOO.O000000o(((Long) key).longValue(), deviceBean.getDevId());
        }
        IConnectListener iConnectListener = this.O00000o0;
        if (iConnectListener != null) {
            iConnectListener.onActiveSuccess(deviceBean);
        }
    }

    public void O000000o() {
        this.O00000oo = true;
        this.O0000O0o = false;
        this.mHandler.removeMessages(21);
    }

    public void O000000o(OOO00Oo oOO00Oo) {
        this.O0000OoO = oOO00Oo;
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000Ooo = ooo0oo0;
        this.O00000oO.O000000o(ooo0oo0);
    }

    public void O000000o(OOOO00O oooo00o, String str) {
        L.d(O00000Oo, "startActive");
        if (oooo00o != null && oooo00o.O00000o() != null) {
            this.O0000OOo = str;
            this.O00000o = oooo00o;
            this.O00000oo = false;
            this.O0000Oo0 = TimeStampManager.instance().getCurrentTimeStamp();
            this.O0000O0o = false;
            this.mHandler.sendEmptyMessage(21);
        }
    }

    public boolean handleMessage(Message message) {
        if (this.O00000oo) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            L.d(O00000Oo, "WHAT_CONFIG_GW_FAILURE");
            O00000Oo();
        } else if (i == 1) {
            L.d(O00000Oo, "WHAT_CONFIG_GW_SUCCESS");
            GwDevResp gwDevResp = (GwDevResp) ((Result) message.obj).getObj();
            if (gwDevResp != null) {
                O000000o(gwDevResp);
            } else {
                O000000o();
                IConnectListener iConnectListener = this.O00000o0;
                if (iConnectListener != null) {
                    iConnectListener.onActiveError("1005", "");
                }
            }
        } else if (i == 21) {
            this.O00000oO.O000000o(this.O00000o.O00000o(), this.O0000OOo);
        }
        return super.handleMessage(message);
    }

    public void onDestroy() {
        L.d(O00000Oo, "DeviceBindLoop onDestroy");
        O000000o();
        this.O00000oO.onDestroy();
        super.onDestroy();
    }
}
