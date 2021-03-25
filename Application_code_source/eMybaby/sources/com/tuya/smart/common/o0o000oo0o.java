package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.hardware.bean.HResponse;
import com.tuya.sdk.hardware.enums.FrameTypeEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.device.TuyaNetworkApi;
import com.tuya.smart.android.device.TuyaNetworkInterface;
import com.tuya.smart.android.hardware.bean.HgwBean;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class o0o000oo0o implements o0000oooo, o000o0000, o0o000o00o {
    public static final String O000000o = "TuyaWiredConfig";
    public static volatile o0o000oo0o O00000Oo;
    public WeakReference<Context> O00000o;
    public Timer O00000o0;
    public String O00000oO;
    public volatile HgwBean O00000oo;
    public String O0000O0o;

    private void O000000o(final String str, final JSONObject jSONObject, final int i) {
        L.d(O000000o, "normalControl: " + str);
        o000o0o00.O000000o().O000000o((o000o0000) this);
        this.O00000o0.schedule(new TimerTask() {
            public void run() {
                if (o0o000oo0o.this.O00000oo != null) {
                    L.d(o0o000oo0o.O000000o, "gw !=null ");
                    String jSONString = JSON.toJSONString((Object) jSONObject, SerializerFeature.WriteMapNullValue);
                    byte[] encryptAesData = TuyaUtil.checkPvVersion(o0o000oo0o.this.O00000oo.getVersion(), 3.3f) ? TuyaNetworkApi.encryptAesData(jSONString, (String) null) : jSONString.getBytes();
                    L.d(o0o000oo0o.O000000o, jSONString);
                    L.d(o0o000oo0o.O000000o, "control: " + str + " " + o0o000oo0o.this.O00000oo.getVersion());
                    o000o0o00.O000000o().O000000o(str, i, encryptAesData, new o000o00o0() {
                        public void O000000o() {
                        }

                        public void O000000o(String str, String str2) {
                        }
                    });
                    return;
                }
                L.d(o0o000oo0o.O000000o, "queryDev");
                List<HgwBean> O000000o2 = o000o0o00.O000000o().O000000o();
                if (L.getLogStatus()) {
                    L.d(o0o000oo0o.O000000o, JSON.toJSONString(O000000o2));
                }
                if (O000000o2 != null) {
                    for (HgwBean next : O000000o2) {
                        if (TextUtils.isEmpty(o0o000oo0o.this.O0000O0o)) {
                            if (o0o000oo0o.this.O000000o(next)) {
                                HgwBean unused = o0o000oo0o.this.O00000oo = next;
                            }
                        } else if (TextUtils.equals(o0o000oo0o.this.O0000O0o, next.getGwId())) {
                            if (L.getLogStatus()) {
                                StringBuilder n = a.n("onFind: ");
                                n.append(JSON.toJSONString(next));
                                L.d(o0o000oo0o.O000000o, n.toString());
                            }
                            HgwBean unused2 = o0o000oo0o.this.O00000oo = next;
                            return;
                        }
                    }
                }
            }
        }, 1000, 5000);
    }

    private void O000000o(String str, String str2) {
        if (this.O00000o0 != null) {
            L.d(O000000o, "mTimer started");
            return;
        }
        this.O00000o0 = new Timer();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", (Object) str2);
        O000000o(str, jSONObject, FrameTypeEnum.TOKEN_BIND.getType());
    }

    /* access modifiers changed from: private */
    public boolean O000000o(HgwBean hgwBean) {
        return hgwBean.isToken() && hgwBean.getActive() == 0;
    }

    public static o0o000o00o O00000Oo() {
        if (O00000Oo == null) {
            synchronized (o0o000oo0o.class) {
                O00000Oo = new o0o000oo0o();
            }
        }
        return O00000Oo;
    }

    private void O00000o0() {
        o000o0o00.O000000o().O00000Oo((o0000oooo) this);
    }

    public void O000000o() {
        L.d(O000000o, "stopConfig");
        o000o0o00.O000000o().O00000Oo((o000o0000) this);
        Timer timer = this.O00000o0;
        if (timer != null) {
            timer.cancel();
            this.O00000o0 = null;
        }
        this.O00000oo = null;
        O00000o0();
    }

    public void O000000o(Context context, String str) {
        L.d(O000000o, "startConfig");
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.O00000o = weakReference;
        Context context2 = (Context) weakReference.get();
        this.O00000oO = str;
        TuyaNetworkInterface.setSecurityContent(TuyaUtil.getAssetsData(context, "fixed_key.bmp", "woeijrweir".getBytes()));
        if (context2 != null) {
            o000o0o00.O000000o().O000000o(context2);
        }
        o000o0o00.O000000o().O000000o((o0000oooo) this);
    }

    public void O000000o(Context context, String str, String str2) {
        this.O0000O0o = str;
        O000000o(context, str2);
        O000000o(str, str2);
    }

    public void O000000o(HResponse hResponse) {
        if (L.getLogStatus()) {
            StringBuilder n = a.n("response: ");
            n.append(JSON.toJSONString(hResponse));
            L.d(O000000o, n.toString());
        }
        if (hResponse.getType() == FrameTypeEnum.TOKEN_BIND.getType()) {
            O000000o();
        }
    }

    public void O000000o(HgwBean hgwBean, boolean z) {
    }

    public void O000000o(List<HgwBean> list) {
        if (list != null) {
            for (HgwBean next : list) {
                L.log2(O000000o, next.toString());
                if (O000000o(next)) {
                    StringBuilder n = a.n("hgwBean gwId add: ");
                    n.append(next.getGwId());
                    L.d(O000000o, n.toString());
                    o000o0o00.O000000o().O000000o(next);
                    synchronized (this) {
                        if (this.O00000oo == null) {
                            O000000o(next.getGwId(), this.O00000oO);
                        } else {
                            L.d(O000000o, "mGW !=null");
                        }
                    }
                    return;
                }
            }
        }
    }
}
