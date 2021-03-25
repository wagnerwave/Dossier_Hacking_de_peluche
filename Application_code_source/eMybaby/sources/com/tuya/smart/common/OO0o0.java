package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.home.sdk.api.config.IGwConfigListener;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OO0o0 extends BasePresenter implements Handler.Callback, IConfig {
    public static final String O000000o = "ApConfigTCP";
    public static final int O0000O0o = 23;
    public final OO0OOo0 O00000Oo;
    public final IGwConfigListener O00000o;
    public final String O00000o0;
    public o0oo0o00o0 O00000oO;
    public String O00000oo;
    public boolean O0000OOo;
    public Map<String, Boolean> O0000Oo;
    public Map<String, Boolean> O0000Oo0;
    public OO0o000 O0000OoO;
    public o0o00o00o0 O0000Ooo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public OOO00Oo O0000o0;
    public o0o00o0o00 O0000o00 = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class));
    public OOO0OO0 O0000o0O;

    public OO0o0(OO0o000 oO0o000) {
        this.O0000OoO = oO0o000;
        this.O00000o0 = oO0o000.O00000oO();
        this.O00000o = oO0o000.O00000oo();
        this.O00000Oo = new OOO0oO(TuyaSmartNetWork.getAppContext(), this.mHandler);
        this.O0000Oo0 = new HashMap();
        this.O0000Oo = new HashMap();
        o0o00o0o00 o0o00o0o00 = this.O0000o00;
        if (o0o00o0o00 != null) {
            this.O00000oO = o0o00o0o00.O00000o();
        }
        this.O0000o0 = new OOO00Oo(new HashMap(), new HashMap(), new HashMap());
    }

    private void O000000o(ActiveTokenBean activeTokenBean) {
        this.O00000oo = activeTokenBean.getToken();
        o0oo0o00o0 o0oo0o00o0 = this.O00000oO;
        if (o0oo0o00o0 != null) {
            o0oo0o00o0.O000000o(TuyaSdk.getApplication(), this.O00000o0, this.O0000OoO.O00000o0());
        }
        O00000o0();
        OOO00Oo oOO00Oo = this.O0000o0;
        if (oOO00Oo != null) {
            oOO00Oo.O00000oO().put("step", "token");
        }
        if (this.O0000o0O != null) {
            this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "token"));
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(DeviceBean deviceBean) {
        IGwConfigListener iGwConfigListener = this.O00000o;
        if (iGwConfigListener != null) {
            iGwConfigListener.onDevOnline(deviceBean);
        }
        cancel();
    }

    private void O000000o(ArrayList<GwDevResp> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<GwDevResp> it = arrayList.iterator();
            while (it.hasNext()) {
                GwDevResp next = it.next();
                String gwId = next.getGwId();
                DeviceBean O000000o2 = this.O0000Ooo.O0000OoO().O000000o(next);
                if (this.O0000Oo0.get(gwId) == null) {
                    arrayList2.add(next);
                    this.O0000Oo0.put(gwId, Boolean.TRUE);
                }
                if (!next.getIsOnline().booleanValue()) {
                    OOO00Oo oOO00Oo = this.O0000o0;
                    if (oOO00Oo != null) {
                        oOO00Oo.O00000oO().put("step", "online");
                    }
                    if (this.O0000o0O != null) {
                        this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "online"));
                    }
                } else if (this.O0000Oo.get(gwId) == null) {
                    if (TextUtils.isEmpty(next.getMeshId())) {
                        O00000Oo(O000000o2);
                    } else {
                        O000000o(O000000o2);
                    }
                    this.O0000Oo.put(gwId, Boolean.TRUE);
                }
                arrayList3.add(O000000o2);
            }
            if (this.O00000o != null && !arrayList2.isEmpty()) {
                this.O00000o.onFind(arrayList3);
            }
        }
    }

    private void O00000Oo() {
        L.d(O000000o, "stopSendBindCommand");
        o0oo0o00o0 o0oo0o00o0 = this.O00000oO;
        if (o0oo0o00o0 != null) {
            o0oo0o00o0.O00000Oo();
        }
    }

    private void O00000Oo(DeviceBean deviceBean) {
        OOO00Oo oOO00Oo = this.O0000o0;
        if (oOO00Oo != null) {
            oOO00Oo.O00000oO().put("step", "update_device");
        }
        if (this.O0000o0O != null) {
            this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "update_device"));
            this.O0000Ooo.O0000Ooo().O000000o(this.O0000o0O.O000000o(), "device_config_add");
        }
        this.O0000Ooo.O0000Ooo().O000000o(deviceBean.getDevId(), (ITuyaDataCallback<DeviceBean>) new ITuyaDataCallback<DeviceBean>() {
            /* renamed from: O000000o */
            public void onSuccess(DeviceBean deviceBean) {
                OO0o0.this.O000000o(deviceBean);
            }

            public void onError(String str, String str2) {
                if (OO0o0.this.O0000o0O != null) {
                    OO0o0.this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "update_device_failure"));
                }
            }
        });
        if (!TextUtils.isEmpty(TuyaSdk.getLatitude()) && !TextUtils.isEmpty(TuyaSdk.getLongitude())) {
            new oOo00().O00000Oo(deviceBean.getDevId());
        }
    }

    private void O00000o0() {
        if (!this.O0000OOo) {
            this.mHandler.sendEmptyMessageDelayed(23, 2000);
        }
    }

    public OOO00Oo O000000o() {
        return this.O0000o0;
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000o0O = ooo0oo0;
        this.O00000Oo.O000000o(ooo0oo0);
    }

    public void cancel() {
        this.O0000Oo0.clear();
        this.O0000Oo.clear();
        this.O0000OOo = true;
        this.mHandler.removeMessages(23);
    }

    public boolean handleMessage(Message message) {
        if (this.O0000OOo) {
            return false;
        }
        int i = message.what;
        if (i == 8) {
            OOO00Oo oOO00Oo = this.O0000o0;
            if (oOO00Oo != null) {
                oOO00Oo.O00000oO().put("step", "token_failure");
            }
            if (this.O0000o0O != null) {
                this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "token_failure"));
            }
            if (!TextUtils.equals(((Result) message.obj).getErrorCode(), "EXPIRE")) {
                O00000o0();
            }
        } else if (i == 9) {
            O00000o0();
            O000000o((ArrayList<GwDevResp>) (ArrayList) ((Result) message.obj).getObj());
        } else if (i == 18) {
            IGwConfigListener iGwConfigListener = this.O00000o;
            if (iGwConfigListener != null) {
                iGwConfigListener.onFindErrorList((List) ((Result) message.obj).getObj());
            }
        } else if (i == 23) {
            this.O00000Oo.O000000o(this.O00000oo);
        }
        return super.handleMessage(message);
    }

    public void onDestroy() {
        O00000Oo();
        this.O00000Oo.onDestroy();
        cancel();
    }

    public void start() {
        this.O0000OOo = false;
        String O00000o02 = this.O0000OoO.O00000o0();
        if (!TextUtils.isEmpty(O00000o02)) {
            O000000o(new ActiveTokenBean(O00000o02));
            OOO00Oo oOO00Oo = this.O0000o0;
            if (oOO00Oo != null) {
                oOO00Oo.O000000o(System.currentTimeMillis());
            }
        }
    }
}
