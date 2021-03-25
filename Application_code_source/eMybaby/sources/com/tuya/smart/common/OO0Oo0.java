package com.tuya.smart.common;

import a.a.a.a.a;
import android.app.Application;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.base.event.NetWorkStatusEvent;
import com.tuya.smart.android.base.event.NetWorkStatusEventModel;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.home.sdk.api.config.IApConnectListener;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.ArrayList;
import java.util.Map;

public class OO0Oo0 extends OOO00O0 implements NetWorkStatusEvent {
    public static final String O00000oO = "APSearchUDP";
    public static final int O0000OoO = 100000000;
    public static final int O0000Ooo = 23;
    public static final int O0000o00 = 1;
    public final OO0OOo0 O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public OO0Oo00 O0000Oo;
    public ActiveTokenBean O0000Oo0;
    public o0o00o0o00 O0000o = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class));
    public boolean O0000o0 = false;
    public volatile boolean O0000o0O = false;
    public String O0000o0o;
    public OOO0OO0 O0000oO;
    public OOO00Oo O0000oO0;

    public OO0Oo0(OO0Oo00 oO0Oo00) {
        super(oO0Oo00.O000000o());
        this.O0000O0o = oO0Oo00.O00000o0();
        this.O0000OOo = oO0Oo00.O00000o();
        this.O0000Oo = oO0Oo00;
        this.O00000oo = new OOO0oO(TuyaSmartNetWork.getAppContext(), this.mHandler);
        this.O0000o0 = false;
        TuyaSdk.getEventBus().register(this);
    }

    private void O00000o0() {
        L.d(O00000oO, "getGWListLoop");
        this.mHandler.sendEmptyMessageDelayed(23, 2000);
    }

    public void O000000o() {
        L.d(O00000oO, "start search...");
        this.O0000o0O = false;
        this.O0000o0 = true;
        o0o00o0o00 o0o00o0o00 = this.O0000o;
        if (o0o00o0o00 != null) {
            o0oo00oooo O00000Oo = o0o00o0o00.O00000Oo();
            Application application = TuyaSdk.getApplication();
            String str = this.O0000O0o;
            String str2 = this.O0000OOo;
            O00000Oo.O000000o(application, str, str2, TuyaSmartNetWork.getRegion() + this.O0000Oo0.getToken() + this.O0000Oo0.getSecret());
        }
        this.O0000o0o = WiFiUtil.getCurrentSSID((Context) TuyaSmartSdk.getApplication());
        O00000o0();
        OOO00Oo oOO00Oo = this.O0000oO0;
        if (oOO00Oo != null) {
            oOO00Oo.O00000oO().put("step", "token");
        }
        if (this.O0000oO != null) {
            this.O0000oO.O00000Oo((Map<String, Object>) null, a.r("step", "token"));
        }
    }

    public void O000000o(OOO00Oo oOO00Oo) {
        this.O0000oO0 = oOO00Oo;
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000oO = ooo0oo0;
    }

    public void O000000o(ActiveTokenBean activeTokenBean) {
        this.O0000Oo0 = activeTokenBean;
    }

    public void O00000Oo() {
        this.O0000o0O = true;
        this.O0000o0 = false;
        o0o00o0o00 o0o00o0o00 = this.O0000o;
        if (o0o00o0o00 != null) {
            o0o00o0o00.O00000Oo().O00000Oo();
        }
        this.mHandler.removeMessages(23);
        L.d(O00000oO, "stop search...");
    }

    public boolean handleMessage(Message message) {
        if (this.O0000o0O) {
            return false;
        }
        int i = message.what;
        if (i == 1) {
            L.d(O00000oO, "network changed and start bind device...");
            this.O0000o0 = false;
            o0o00o0o00 o0o00o0o00 = this.O0000o;
            if (o0o00o0o00 != null) {
                o0o00o0o00.O00000Oo().O00000Oo();
            }
            LogUtils.logServer(OOOOO00.O00000Oo, OOOOO00.O000000o(OOOOO00.O0000Oo, this.O0000Oo.O0000Oo0()));
            WiFiUtil.enableNetwork(this.O0000Oo.O000000o(), this.O0000Oo.O00000o0());
        } else if (i == 18) {
            IApConnectListener O00000oO2 = this.O0000Oo.O00000oO();
            if (O00000oO2 != null) {
                O00000oO2.onActiveError("1007", JSON.toJSONString(((Result) message.obj).getObj()));
            }
        } else if (i == 23) {
            this.O00000oo.O000000o(this.O0000Oo0.getToken());
        } else if (i == 8) {
            OOO00Oo oOO00Oo = this.O0000oO0;
            if (oOO00Oo != null) {
                oOO00Oo.O00000oO().put("step", "token_failure");
            }
            if (this.O0000oO != null) {
                this.O0000oO.O00000Oo((Map<String, Object>) null, a.r("step", "token_failure"));
            }
            if (!TextUtils.equals(((Result) message.obj).getErrorCode(), "EXPIRE")) {
                O00000o0();
            }
        } else if (i == 9) {
            try {
                ArrayList arrayList = (ArrayList) ((Result) message.obj).getObj();
                if (arrayList.size() > 0) {
                    L.d(O00000oO, "bind gateway starting...");
                    if (this.O00000o != null) {
                        this.O00000o.O000000o(((GwDevResp) arrayList.get(0)).getGwId());
                    }
                } else {
                    O00000o0();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return super.handleMessage(message);
    }

    public void onDestroy() {
        this.O00000oo.onDestroy();
        TuyaSdk.getEventBus().unregister(this);
        O00000Oo();
        this.mHandler.removeMessages(1);
        super.onDestroy();
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        if (this.O0000o0) {
            if (!TextUtils.equals(this.O0000o0o, WiFiUtil.getCurrentSSID(this.O0000Oo.O000000o()))) {
                this.mHandler.sendEmptyMessageDelayed(1, 500);
            }
        }
        StringBuilder n = a.n("cur ssid name....");
        n.append(WiFiUtil.getCurrentSSID(this.O0000Oo.O000000o()));
        n.append(" apSsid: ");
        n.append(this.O0000o0o);
        L.d(O00000oO, n.toString());
    }
}
