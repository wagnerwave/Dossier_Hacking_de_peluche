package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tutk.IOTC.Camera;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.ZigbeeGroupCreateResultBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class oOO0O000 implements o0o0o00000<o0o0oo000o> {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o = 1001;
    public static final int O00000o0 = 0;
    public IDevModel O00000oO;
    public o0o00o00o0 O00000oo;
    public List<String> O0000O0o;
    public ITuyaResultCallback<ZigbeeGroupCreateResultBean> O0000OOo;
    public Handler O0000Oo = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1001) {
                return false;
            }
            L.i("HHHHH", "time out");
            oOO0O000.this.O000000o();
            ZigbeeGroupCreateResultBean zigbeeGroupCreateResultBean = new ZigbeeGroupCreateResultBean();
            zigbeeGroupCreateResultBean.setFailure(oOO0O000.this.O0000O0o);
            HashMap hashMap = new HashMap();
            for (String put : oOO0O000.this.O0000O0o) {
                hashMap.put(put, 6);
            }
            zigbeeGroupCreateResultBean.setErrorCode(hashMap);
            if (oOO0O000.this.O0000OOo == null) {
                return false;
            }
            oOO0O000.this.O0000OOo.onSuccess(zigbeeGroupCreateResultBean);
            return false;
        }
    });
    public o0000 O0000Oo0;

    public oOO0O000() {
        oOo0oooO.O000000o().registerDeviceMqttListener(o0o0oo000o.class, this);
        this.O0000O0o = new ArrayList();
        this.O0000Oo0 = new o0000();
    }

    private List<String> O000000o(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String deviceBean : list) {
            DeviceBean deviceBean2 = oO0OO000.O000000o().getDeviceBean(deviceBean);
            if (deviceBean2 != null) {
                arrayList.add(deviceBean2.getNodeId());
            }
        }
        return arrayList;
    }

    public void O000000o() {
        IDevModel iDevModel = this.O00000oO;
        if (iDevModel != null) {
            iDevModel.onDestroy();
        }
        this.O0000Oo.removeMessages(1001);
        oOo0oooO.O000000o().unRegisterDeviceMqttListener(o0o0oo000o.class, this);
    }

    public void O000000o(long j, long j2, List<String> list, IResultCallback iResultCallback) {
        final IResultCallback iResultCallback2 = iResultCallback;
        final long j3 = j2;
        final List<String> list2 = list;
        this.O0000Oo0.O000000o(j, j2, list, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o0().updateDeviceList(j3, list2);
                }
                o0O0O00O.O00000o0();
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    /* renamed from: O000000o */
    public void onResult(o0o0oo000o o0o0oo000o) {
        List<Integer> O00000o2 = o0o0oo000o.O00000o();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (O00000o2 != null && O00000o2.size() == this.O0000O0o.size()) {
            for (int i = 0; i < this.O0000O0o.size(); i++) {
                String str = this.O0000O0o.get(i);
                int intValue = O00000o2.get(i).intValue();
                if (intValue == 0) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                    hashMap.put(str, Integer.valueOf(intValue));
                }
            }
            ZigbeeGroupCreateResultBean zigbeeGroupCreateResultBean = new ZigbeeGroupCreateResultBean();
            zigbeeGroupCreateResultBean.setSuccess(arrayList);
            zigbeeGroupCreateResultBean.setFailure(arrayList2);
            zigbeeGroupCreateResultBean.setErrorCode(hashMap);
            zigbeeGroupCreateResultBean.setGid(o0o0oo000o.O00000o0());
            zigbeeGroupCreateResultBean.setGwId(o0o0oo000o.O000000o());
            zigbeeGroupCreateResultBean.setOperateType(o0o0oo000o.O00000Oo());
            if (arrayList.size() > 0 || !hashMap.isEmpty()) {
                StringBuilder n = a.n("onEventMainThread..SUC....");
                n.append(zigbeeGroupCreateResultBean.toString());
                L.i("HHHHH", n.toString());
                ITuyaResultCallback<ZigbeeGroupCreateResultBean> iTuyaResultCallback = this.O0000OOo;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(zigbeeGroupCreateResultBean);
                }
            }
        }
        L.i("HHHHH", "WHAT_CONTROL_TIME_OUT...REMOVE...");
        this.O0000Oo.removeMessages(1001);
        O000000o();
    }

    public void O000000o(String str, List<String> list, String str2, int i, ITuyaResultCallback<ZigbeeGroupCreateResultBean> iTuyaResultCallback) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        this.O00000oo = o0o00o00o0;
        if (o0o00o00o0 != null) {
            this.O0000O0o.clear();
            this.O0000O0o.addAll(list);
            this.O00000oO = this.O00000oo.O000000o(TuyaSdk.getApplication(), str);
            List<String> O000000o2 = O000000o(list);
            if (i == 0) {
                this.O00000oO.addZigBeeGroup(O000000o2, str2, new IResultCallback() {
                    public void onError(String str, String str2) {
                    }

                    public void onSuccess() {
                    }
                });
            } else {
                this.O00000oO.removeZigBeeGroup(O000000o2, str2, new IResultCallback() {
                    public void onError(String str, String str2) {
                    }

                    public void onSuccess() {
                    }
                });
            }
        }
        this.O0000Oo.sendEmptyMessageDelayed(1001, (long) ((list.size() * 6000) + Camera.ThreadSendAudio.SAMPLE_RATE_IN_HZ));
        this.O0000OOo = iTuyaResultCallback;
    }
}
