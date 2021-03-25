package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.device.utils.SandRMap;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.home.sdk.builder.TuyaGwSubDevActivatorBuilder;
import com.tuya.smart.interior.enums.FrameTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ISubDevListener;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaGateway;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Oo000 implements o0o00ooooo, o0o0o00000<o0o0oo0000>, ISubDevListener, ITuyaActivator {
    public static final String O000000o = "TuyaSubDevActivatorImpl";
    public static final int O00000Oo = 1;
    public static final int O00000o0 = 2;
    public final TuyaGwSubDevActivatorBuilder O00000o;
    public final ITuyaSmartActivatorListener O00000oO;
    public boolean O00000oo;
    public ITuyaGateway O0000O0o;
    public Timer O0000OOo;
    public long O0000Oo;
    public DeviceBean O0000Oo0;
    public o0o00o00o0 O0000OoO = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public o0oo0o0ooo O0000Ooo = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));
    public OOO0OO0 O0000o0;
    public OOO00Oo O0000o00;
    public Handler O0000o0O = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    if (Oo000.this.O0000OoO != null) {
                        if (Oo000.this.O0000o0 != null) {
                            Oo000.this.O0000o0.O00000Oo((Map<String, Object>) null, a.r("step", "sub_dev_recv"));
                            Oo000.this.O0000OoO.O0000Ooo().O000000o(Oo000.this.O0000o0.O000000o(), "device_config_add");
                        }
                        Oo000.this.O0000o00.O00000oO().put("step", "sub_dev_recv");
                        Oo000.this.O0000OoO.O0000Ooo().O00000Oo(Oo000.this.O00000o.getDevId(), (ITuyaDataCallback<List<DeviceBean>>) new ITuyaDataCallback<List<DeviceBean>>() {
                            /* renamed from: O000000o */
                            public void onSuccess(List<DeviceBean> list) {
                                for (DeviceBean next : list) {
                                    StringBuilder n = a.n("deviceBean: ");
                                    n.append(next.getTime());
                                    L.d(Oo000.O000000o, n.toString());
                                    if (next.getTime() > Oo000.this.O0000Oo) {
                                        OO0OOOO.O000000o(Oo000.this.O00000o.getDevId(), next.getDevId());
                                    }
                                }
                            }

                            public void onError(String str, String str2) {
                            }
                        });
                    }
                    Oo000.this.O000000o(0);
                }
            } else if (Oo000.this.O00000oO != null) {
                Oo000.this.O00000oO.onError("1006", "time out");
                if (Oo000.this.O0000o00 != null) {
                    Oo000.this.O0000o00.O00000oO().put("type", OO0OO0o.O00000o0.O0000OOo);
                    if (Oo000.this.O0000Ooo != null) {
                        Oo000.this.O0000Ooo.O000000o("f22f53893cedc95aa34844b792f341ba", Oo000.this.O0000o00.O00000oO());
                    }
                }
                if (Oo000.this.O0000o0 != null) {
                    Oo000.this.O0000o0.O00000o0(a.r("config_result", "failure"), (Map<String, Object>) null);
                }
            }
            return false;
        }
    });

    public Oo000(TuyaGwSubDevActivatorBuilder tuyaGwSubDevActivatorBuilder) {
        this.O00000o = tuyaGwSubDevActivatorBuilder;
        if (!TextUtils.isEmpty(tuyaGwSubDevActivatorBuilder.getDevId())) {
            this.O00000oO = this.O00000o.getListener();
            this.O0000o00 = new OOO00Oo(new HashMap(), new HashMap(), new HashMap());
            this.O0000o0 = new OOO0OO0();
            return;
        }
        throw new IllegalArgumentException("deviceId is null");
    }

    private void O000000o() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new Timer();
        }
        this.O0000OOo.schedule(new TimerTask() {
            public void run() {
                int timeOut = (int) (((long) (((int) Oo000.this.O00000o.getTimeOut()) / 1000)) - ((TimeStampManager.instance().getCurrentTimeStamp() - Oo000.this.O0000Oo) / 1000));
                L.d(Oo000.O000000o, "time: " + timeOut);
                Oo000.this.O000000o(timeOut);
            }
        }, 0, 5000);
    }

    /* access modifiers changed from: private */
    public void O000000o(int i) {
        if (i != 0) {
            OOO00Oo oOO00Oo = this.O0000o00;
            if (oOO00Oo != null) {
                oOO00Oo.O00000oO().put("step", "act_sub_dev");
            }
            if (this.O0000o0 != null) {
                this.O0000o0.O00000Oo((Map<String, Object>) null, a.r("step", "act_sub_dev"));
            }
        }
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        DeviceBean deviceBean = this.O0000Oo0;
        if (deviceBean == null || !deviceBean.getIsOnline().booleanValue() || o0o00o0oo0 == null || !o0o00o0oo0.O000000o().O00000o()) {
            L.d(O000000o, "enableWifi by local time: " + i);
            OOOo00.O000000o(this.O00000o.getDevId(), i, (IResultCallback) null);
            return;
        }
        L.d(O000000o, "enableWifi by cloud time: " + i);
        O000000o((long) i);
    }

    private void O000000o(long j) {
        o0oo00o00o o0oo00o00o = SandRMap.getInstance().get(this.O00000o.getDevId());
        if (o0oo00o00o == null) {
            o0oo00o00o = new o0oo00o00o();
            SandRMap.getInstance().put(this.O00000o.getDevId(), o0oo00o00o);
        }
        o0oo00o00o o0oo00o00o2 = o0oo00o00o;
        o0oo00o00o2.O00000o0();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) 0);
        jSONObject.put("time", (Object) Long.valueOf(j));
        OOOo00.O000000o(this.O0000Oo0.getDevId(), this.O0000Oo0.getPv(), this.O0000Oo0.getLocalKey(), jSONObject, o0oo00o00o2, new IResultCallback() {
            public void onError(String str, String str2) {
            }

            public void onSuccess() {
            }
        });
    }

    private void O00000Oo() {
        Timer timer = this.O0000OOo;
        if (timer != null) {
            timer.cancel();
            this.O0000OOo = null;
        }
    }

    private void O00000o0() {
        this.O0000o0O.removeMessages(1);
        this.O0000o0O.removeMessages(2);
    }

    /* renamed from: O000000o */
    public void onResult(o0o0oo0000 o0o0oo0000) {
        O00000Oo();
    }

    public void O000000o(String str, int i, boolean z, byte[] bArr) {
        if (z && TextUtils.equals(str, this.O00000o.getDevId())) {
            O00000Oo();
        }
    }

    public void onDestroy() {
        stop();
    }

    public void onSubDevAdded(String str) {
        o0o00o00o0 o0o00o00o0;
        ITuyaSmartActivatorListener iTuyaSmartActivatorListener = this.O00000oO;
        if (!(iTuyaSmartActivatorListener == null || (o0o00o00o0 = this.O0000OoO) == null)) {
            iTuyaSmartActivatorListener.onActiveSuccess(o0o00o00o0.O0000OOo().getDeviceBean(str));
            OOO00Oo oOO00Oo = this.O0000o00;
            if (oOO00Oo != null) {
                oOO00Oo.O00000Oo(System.currentTimeMillis());
                this.O0000o00.O00000o().put("type", OO0OO0o.O00000o0.O0000OOo);
                this.O0000o00.O00000o().put("time", Long.valueOf((this.O0000o00.O00000o0() - this.O0000o00.O00000Oo()) / 1000));
                o0oo0o0ooo o0oo0o0ooo = this.O0000Ooo;
                if (o0oo0o0ooo != null) {
                    o0oo0o0ooo.O000000o(OO0OO0o.O000000o.O000000o, this.O0000o00.O00000o());
                }
            }
            if (this.O0000o0 != null) {
                this.O0000o0.O00000o0(a.r("config_result", "success"), (Map<String, Object>) null);
            }
        }
        a.v("onSubDevAdded : ", str, O000000o);
        O00000o0();
    }

    public void onSubDevDpUpdate(String str, String str2) {
    }

    public void onSubDevInfoUpdate(String str) {
    }

    public void onSubDevRemoved(String str) {
    }

    public void onSubDevStatusChanged(List<String> list, List<String> list2) {
    }

    public void start() {
        if (!this.O00000oo) {
            this.O00000oo = true;
            this.O0000Oo = TimeStampManager.instance().getCurrentTimeStamp();
            StringBuilder n = a.n("startTime: ");
            n.append(this.O0000Oo);
            L.d(O000000o, n.toString());
            o0o00o00o0 o0o00o00o0 = this.O0000OoO;
            if (o0o00o00o0 != null) {
                o0o00o00o0.O0000o00().registerDeviceHardwareResponseListener(FrameTypeEnum.ENABLE_WIFI.getType(), this);
                this.O0000OoO.O0000o00().registerDeviceMqttListener(o0o0oo0000.class, this);
                ITuyaGateway O00000o02 = this.O0000OoO.O00000o0(this.O00000o.getDevId());
                this.O0000O0o = O00000o02;
                O00000o02.registerSubDevListener(this);
                this.O0000Oo0 = this.O0000OoO.O0000OOo().getDeviceBean(this.O00000o.getDevId());
            }
            this.O0000o0O.sendEmptyMessageDelayed(1, this.O00000o.getTimeOut());
            if (this.O0000Oo0 == null) {
                ITuyaSmartActivatorListener iTuyaSmartActivatorListener = this.O00000oO;
                if (iTuyaSmartActivatorListener != null) {
                    iTuyaSmartActivatorListener.onError("1001", "deviceBean == null");
                }
                stop();
                return;
            }
            this.O0000Ooo.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", a.r("type", OO0OO0o.O00000o0.O0000OOo));
            OOO00Oo oOO00Oo = this.O0000o00;
            if (oOO00Oo != null) {
                oOO00Oo.O000000o(System.currentTimeMillis());
            }
            if (this.O0000o0 != null) {
                this.O0000o0.O000000o(a.r("type", OO0OO0o.O00000o0.O0000OOo), (Map<String, Object>) null);
            }
            O000000o();
            this.O0000o0O.sendEmptyMessageDelayed(2, this.O00000o.getTimeOut() - 8000);
        }
    }

    public void stop() {
        if (this.O00000oo) {
            this.O00000oo = false;
            O00000Oo();
            ITuyaGateway iTuyaGateway = this.O0000O0o;
            if (iTuyaGateway != null) {
                iTuyaGateway.onDestroy();
            }
            o0o00o00o0 o0o00o00o0 = this.O0000OoO;
            if (o0o00o00o0 != null) {
                o0o00o00o0.O0000o00().unRegisterDeviceHardwareResponseListener(this);
                this.O0000OoO.O0000o00().unRegisterDeviceMqttListener(o0o0oo0000.class, this);
            }
            O000000o(0);
            O00000o0();
        }
    }
}
