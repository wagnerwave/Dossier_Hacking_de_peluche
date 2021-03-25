package com.tuya.smart.common;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.bluemesh.bean.SubDevGetDpBean;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.common.utils.Base64;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.interior.device.bean.CloudControlRawBean;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class O0000O0o extends BaseModel implements O00OO0O {
    public static final String O000000o = "BlueMeshControlModel";
    public static final int O00000Oo = 17;
    public Handler O00000o0 = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 17) {
                return false;
            }
            o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
            Bundle data = message.getData();
            String string = data.getString("nodeId");
            String string2 = data.getString("meshId");
            if (o0o00o00o0 == null) {
                return false;
            }
            o0o00o00o0.O0000o00().queryDev(o0o00o00o0.O0000OoO().O00000o0(string2, string).getDevId(), (ITuyaDataCallback<DeviceBean>) null);
            return false;
        }
    });

    public O0000O0o(Context context) {
        super(context);
    }

    private DeviceBean O000000o(List<DeviceBean> list) {
        for (DeviceBean next : list) {
            if (next.isBleMeshWifi() && next.isCloudOnline()) {
                return next;
            }
        }
        return null;
    }

    public void O000000o(String str) {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
            O000000o2.O000000o("smart/mb/in/" + str, (IResultCallback) null);
        }
    }

    public void O000000o(String str, String str2, String str3, Object obj, int i, IResultCallback iResultCallback) {
        o0oo00o00o O000000o2 = O00OOo0.O000000o().O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = new o0oo00o00o();
            O00OOo0.O000000o().O000000o(str, O000000o2);
        }
        o0oo00o00o o0oo00o00o = O000000o2;
        o0oo00o00o.O00000o0();
        o0oo00o00o.O000000o(o00o0o0ooo.O000000o().O00000Oo());
        O000000o(str, str2, str3, obj, o0oo00o00o, i, iResultCallback);
    }

    public void O000000o(String str, String str2, String str3, Object obj, o0oo00o00o o0oo00o00o, int i, IResultCallback iResultCallback) {
        o0oo0oo0o0 O00000o02 = new o0oo0oo0o0().O000000o(obj).O00000o0(str3).O00000Oo(str2).O00000Oo(i).O000000o(str).O000000o(o0oo00o00o.O00000Oo()).O00000o(o0oo00o00o.O000000o()).O00000oO(o0oo00o00o.O00000Oo()).O00000o0((int) TimeStampManager.instance().getCurrentTimeStamp());
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0o00o0oo0.O000000o().O000000o(O00000o02, iResultCallback);
        }
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, int i, Map<String, Object> map, IResultCallback iResultCallback) {
        String str6 = str;
        String str7 = str5;
        Map<String, Object> map2 = map;
        Class cls = o0o00o00o0.class;
        L.d(O000000o, "controlBlueMesh");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cid", (Object) str5);
        jSONObject.put("ctype", (Object) Integer.valueOf(i));
        if (!TextUtils.isEmpty(str4)) {
            String str8 = str4;
            jSONObject.put("pcc", (Object) str4);
        } else {
            String str9 = str4;
        }
        jSONObject.put("dps", (Object) map2);
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if ((o0o00o0oo0 != null && o0o00o0oo0.O000000o().O00000o()) || !NetworkUtil.isNetworkAvailable(TuyaSdk.getApplication())) {
            O000000o(str, str2, str3, (Object) jSONObject, 5, iResultCallback);
            return;
        }
        L.d(O000000o, "sendByHTTP");
        ((o0o00o00o0) Oo0.O000000o(cls)).O0000o0O().O000000o(str, ((o0o00o00o0) Oo0.O000000o(cls)).O0000OoO().O00000o0(str, str5).getDevId(), JSON.toJSONString((Object) map2, SerializerFeature.WriteMapNullValue), str4, iResultCallback);
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = str7;
        Bundle data = obtain.getData();
        data.putString("nodeId", str5);
        data.putString("meshId", str);
        this.O00000o0.sendMessageDelayed(obtain, 1500);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, int i, IResultCallback iResultCallback) {
        LinkedHashMap linkedHashMap;
        String str7 = str;
        IResultCallback iResultCallback2 = iResultCallback;
        L.d(O000000o, "meshID : " + str + "  pv:" + str6);
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            List<DeviceBean> O00000o = o0o00o00o0.O0000OoO().O00000o(str);
            if (O00000o == null) {
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(o00oo0o0o0.O00oOooo, "the subdevice is empty and may not have been initialized");
                }
            } else if (O000000o(O00000o) != null) {
                try {
                    String str8 = str2;
                    linkedHashMap = (LinkedHashMap) JSON.parseObject(str2, new TypeReference<LinkedHashMap<String, Object>>() {
                    }, new Feature[0]);
                } catch (Exception unused) {
                    linkedHashMap = null;
                }
                if (linkedHashMap != null) {
                    O000000o(str, str6, str3, str4, str5, i, (Map<String, Object>) linkedHashMap, iResultCallback);
                } else if (iResultCallback2 != null) {
                    iResultCallback2.onError("13004", "format error");
                }
            } else if (iResultCallback2 != null) {
                iResultCallback2.onError(o00oo0o0o0.O000O00o, "ble mesh gateway is offline");
            }
        }
    }

    public void O000000o(String str, String str2, String str3, String str4, List<Integer> list, IResultCallback iResultCallback) {
        SubDevGetDpBean subDevGetDpBean = new SubDevGetDpBean();
        subDevGetDpBean.setDpId(list);
        subDevGetDpBean.setDevId(str4);
        O000000o(str, str2, str3, (Object) subDevGetDpBean, 24, iResultCallback);
    }

    public void O000000o(String str, String str2, String str3, byte[] bArr, IResultCallback iResultCallback) {
        L.d(O000000o, "controlBlueMesh");
        CloudControlRawBean cloudControlRawBean = new CloudControlRawBean();
        cloudControlRawBean.setRaw(new String(Base64.encodeBase64(bArr)));
        L.d(O000000o, cloudControlRawBean.getRaw());
        O000000o(str, str2, str3, (Object) cloudControlRawBean, 28, iResultCallback);
    }

    public void O000000o(String str, String str2, byte[] bArr, String str3, IResultCallback iResultCallback) {
        L.d(O000000o, "meshID : " + str + DpTimerBean.FILL + str3);
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            List<DeviceBean> O00000o = o0o00o00o0.O0000OoO().O00000o(str);
            if (O00000o == null) {
                if (iResultCallback != null) {
                    iResultCallback.onError(o00oo0o0o0.O00oOooo, "the subdevice is empty and may not have been initialized");
                }
            } else if (O000000o(O00000o) != null) {
                O000000o(str, str3, str2, bArr, iResultCallback);
            } else if (iResultCallback != null) {
                iResultCallback.onError(o00oo0o0o0.O000O00o, "ble mesh is offline");
            }
        }
    }

    public void O000000o(String[] strArr) {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            for (String str : strArr) {
                o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
                O000000o2.O000000o("smart/mb/in/" + str, (IResultCallback) null);
            }
        }
    }

    public void onDestroy() {
        this.O00000o0.removeMessages(17);
    }
}
