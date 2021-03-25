package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaCache;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.TuyaSmartNetWork;
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

public class OOOO0O extends BasePresenter {
    public static final String O000000o = "MultiEZSearchNew";
    public static final int O00000oo = 23;
    public final OO0OOo0 O00000Oo = new OOO0oO(TuyaSmartNetWork.getAppContext(), this.mHandler);
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public OOO0o0 O0000O0o;
    public boolean O0000OOo;
    public Map<String, Boolean> O0000Oo = new HashMap();
    public O000000o O0000Oo0;
    public Map<String, Boolean> O0000OoO = new HashMap();
    public o0o00o0o00 O0000Ooo = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class));
    public OOO00Oo O0000o0 = new OOO00Oo(new HashMap(), new HashMap(), new HashMap());
    public o0o00o00o0 O0000o00 = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public OOO0OO0 O0000o0O;

    public interface O000000o {
        void O000000o(DeviceBean deviceBean);

        void O000000o(List<DeviceBean> list);

        void O00000Oo(List<ConfigErrorRespBean> list);
    }

    public OOOO0O(Context context) {
        super(context);
    }

    private void O000000o(ActiveTokenBean activeTokenBean) {
        this.O00000oO = activeTokenBean.getToken();
        O000000o(TuyaSmartNetWork.getRegion() + activeTokenBean.getToken() + activeTokenBean.getSecret());
        O00000oO();
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
        O000000o o000000o = this.O0000Oo0;
        if (o000000o != null) {
            o000000o.O000000o(deviceBean);
        }
    }

    private void O000000o(String str) {
        O00000o();
        o0o00o0o00 o0o00o0o00 = this.O0000Ooo;
        if (o0o00o0o00 != null) {
            o0o00o0o00.O00000o0().O000000o(this.O00000o0, this.O00000o, str);
        }
    }

    private void O000000o(ArrayList<GwDevResp> arrayList) {
        if (this.O0000o00 != null && arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<GwDevResp> it = arrayList.iterator();
            while (it.hasNext()) {
                GwDevResp next = it.next();
                String gwId = next.getGwId();
                DeviceBean O000000o2 = this.O0000o00.O0000OoO().O000000o(next);
                if (this.O0000Oo.get(gwId) == null) {
                    arrayList2.add(next);
                    this.O0000Oo.put(gwId, Boolean.TRUE);
                }
                if (!next.getIsOnline().booleanValue()) {
                    OOO00Oo oOO00Oo = this.O0000o0;
                    if (oOO00Oo != null) {
                        oOO00Oo.O00000oO().put("step", "online");
                    }
                    if (this.O0000o0O != null) {
                        this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "online"));
                    }
                } else if (this.O0000OoO.get(gwId) == null) {
                    if (TextUtils.isEmpty(next.getMeshId())) {
                        O00000Oo(O000000o2);
                    } else {
                        O000000o(O000000o2);
                        OO0OOOO.O000000o(next.getMeshId(), next.getGwId());
                    }
                    this.O0000OoO.put(gwId, Boolean.TRUE);
                }
                arrayList3.add(O000000o2);
            }
            if (this.O0000Oo0 != null && !arrayList2.isEmpty()) {
                this.O0000Oo0.O000000o((List<DeviceBean>) arrayList3);
            }
        }
    }

    private void O00000Oo(DeviceBean deviceBean) {
        if (this.O0000o00 != null) {
            OOO00Oo oOO00Oo = this.O0000o0;
            if (oOO00Oo != null) {
                oOO00Oo.O00000oO().put("step", "update_device");
            }
            if (this.O0000o0O != null) {
                this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "update_device"));
                this.O0000o00.O0000Ooo().O000000o(this.O0000o0O.O000000o(), "device_config_add");
            }
            this.O0000o00.O0000Ooo().O000000o(deviceBean.getDevId(), (ITuyaDataCallback<DeviceBean>) new ITuyaDataCallback<DeviceBean>() {
                /* renamed from: O000000o */
                public void onSuccess(DeviceBean deviceBean) {
                    Object key = TuyaCache.getInstance().getKey(OOOO0O.this.O0000O0o.O00000oo());
                    if (key != null) {
                        OO0OOOO.O000000o(((Long) key).longValue(), deviceBean.getDevId());
                    }
                    OOOO0O.this.O000000o(deviceBean);
                }

                public void onError(String str, String str2) {
                    if (OOOO0O.this.O0000o0O != null) {
                        OOOO0O.this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "update_device_failure"));
                        OOOO0O.this.O0000o00.O0000Ooo().O000000o(OOOO0O.this.O0000o0O.O000000o(), "device_config_add");
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(TuyaSdk.getLatitude()) && !TextUtils.isEmpty(TuyaSdk.getLongitude())) {
            new oOo00().O00000Oo(deviceBean.getDevId());
        }
    }

    private void O00000o() {
        L.d(O000000o, "stopSendEC");
        o0o00o0o00 o0o00o0o00 = this.O0000Ooo;
        if (o0o00o0o00 != null) {
            o0o00o0o00.O00000o0().O000000o();
        }
    }

    private void O00000oO() {
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

    public void O000000o(OOO0o0 oOO0o0) {
        this.O0000O0o = oOO0o0;
        this.O00000o = oOO0o0.O00000Oo();
        this.O00000o0 = this.O0000O0o.O000000o();
    }

    public void O000000o(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    public void O00000Oo() {
        this.O0000OOo = false;
        String O00000oo2 = this.O0000O0o.O00000oo();
        if (!TextUtils.isEmpty(O00000oo2)) {
            O000000o(new ActiveTokenBean(O00000oo2));
        }
        this.O0000OoO.clear();
    }

    public void O00000o0() {
        this.O0000Oo.clear();
        this.O0000OoO.clear();
        this.O0000OOo = true;
        O00000o();
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
                O00000oO();
            }
        } else if (i == 9) {
            O00000oO();
            O000000o((ArrayList<GwDevResp>) (ArrayList) ((Result) message.obj).getObj());
        } else if (i == 18) {
            O000000o o000000o = this.O0000Oo0;
            if (o000000o != null) {
                o000000o.O00000Oo((List) ((Result) message.obj).getObj());
            }
        } else if (i == 23) {
            this.O00000Oo.O000000o(this.O00000oO);
        }
        return super.handleMessage(message);
    }

    public void onDestroy() {
        O00000o();
        this.O00000Oo.onDestroy();
        O00000o0();
    }
}
