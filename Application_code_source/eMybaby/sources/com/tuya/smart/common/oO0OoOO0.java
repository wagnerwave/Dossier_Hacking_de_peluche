package com.tuya.smart.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.device.utils.SandRMap;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class oO0OoOO0 extends BaseModel implements oO0OOo0o {
    public static final String O000000o = "DevControlModel";
    public static final int O00000Oo = 1;
    public oO0Oo0oo O00000o;
    public final String O00000o0;
    public oO0Ooooo O00000oO;
    public Handler O00000oo = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            oOo0oooO.O000000o().queryDev(oO0OoOO0.this.O00000o0);
            return false;
        }
    });

    public static class O000000o {
        public String O000000o;
        public String O00000Oo;

        public O000000o(String str, String str2) {
            this.O000000o = str;
            this.O00000Oo = str2;
        }
    }

    public oO0OoOO0(Context context, String str) {
        super(context);
        this.O00000o0 = str;
        this.O00000o = new oO0Oo0oo();
        this.O00000oO = new oO0Ooooo();
    }

    private o0oo00o00o O000000o() {
        o0oo00o00o o0oo00o00o = SandRMap.getInstance().get(this.O00000o0);
        if (o0oo00o00o == null) {
            o0oo00o00o = new o0oo00o00o();
            SandRMap.getInstance().put(this.O00000o0, o0oo00o00o);
        }
        o0oo00o00o.O00000o0();
        return o0oo00o00o;
    }

    private O000000o O000000o(String str) {
        String str2;
        DeviceRespBean O00000o02 = oO00O0o0.O000000o().O00000o0(str);
        String str3 = this.O00000o0;
        if (O00000o02 != null) {
            str2 = O00000o02.getNodeId();
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(O00000o02.getMeshId())) {
                str3 = O00000o02.getMeshId();
            }
        } else {
            str2 = str3;
        }
        return new O000000o(str3, str2);
    }

    private void O000000o(DeviceBean deviceBean, String str, int i, String str2, o0oo00o00o o0oo00o00o, String str3, IResultCallback iResultCallback) {
        LinkedHashMap<String, Object> O00000Oo2 = O00000Oo(str2);
        if (O00000Oo2 == null) {
            if (iResultCallback != null) {
                iResultCallback.onError("11001", (String) null);
            }
        } else if (TuyaUtil.compareVersion(deviceBean.getCadv(), "1.0.1") >= 0 || deviceBean.hasZigBee() || deviceBean.isBleMesh()) {
            this.O00000o.O000000o(deviceBean.getDevId(), str, i, O00000Oo2, o0oo00o00o, str3, iResultCallback);
        } else {
            this.O00000o.O000000o(deviceBean.getDevId(), O00000Oo2, o0oo00o00o, iResultCallback);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(DeviceBean deviceBean, String str, int i, String str2, String str3, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        if (deviceBean.getIsOnline().booleanValue()) {
            O000000o(deviceBean.getDevId(), str2, str, i, str3, o0oo00o00o, iResultCallback);
        } else if (iResultCallback != null) {
            iResultCallback.onError("10203", (String) null);
        }
    }

    private void O000000o(String str, String str2, String str3, int i, String str4, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        LinkedHashMap<String, Object> O00000Oo2 = O00000Oo(str2);
        if (O00000Oo2 != null) {
            O000000o(str, O00000Oo2, str3, i, str4, o0oo00o00o, iResultCallback);
        } else if (iResultCallback != null) {
            iResultCallback.onError("11001", (String) null);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(String str, LinkedHashMap<String, Object> linkedHashMap, String str2, int i, String str3, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        this.O00000oO.O000000o(str, linkedHashMap, str2, i, str3, o0oo00o00o, iResultCallback);
    }

    private LinkedHashMap<String, Object> O00000Oo(String str) {
        LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        if (!oOO0OO0O.O000000o(this.O00000o0, (Map<String, Object>) linkedHashMap)) {
            return null;
        }
        oOO0OO0O.O000000o(this.O00000o0, str, (Map<String, Object>) linkedHashMap);
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public void O00000Oo(IResultCallback iResultCallback) {
        oOo0oooO.O000000o().queryDps(this.O00000o0);
        if (iResultCallback != null) {
            iResultCallback.onSuccess();
        }
    }

    public void O000000o(int i, String str, String str2, long j, IResultCallback iResultCallback) {
        this.O00000oO.O000000o(i, str, str2, j, O000000o(), iResultCallback);
    }

    public void O000000o(final IResultCallback iResultCallback) {
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(this.O00000o0);
        if (deviceBean == null || !deviceBean.getIsLocalOnline().booleanValue()) {
            O00000Oo(iResultCallback);
        } else {
            oOo0o0oO.O000000o(this.O00000o0, (IResultCallback) new IResultCallback() {
                public void onError(String str, String str2) {
                    oO0OoOO0.this.O00000Oo(iResultCallback);
                }

                public void onSuccess() {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                    }
                }
            });
        }
    }

    public void O000000o(String str, int i, IResultCallback iResultCallback) {
        o0oo00o00o O000000o2 = O000000o();
        O000000o O000000o3 = O000000o(this.O00000o0);
        O000000o(O000000o3.O000000o, str, O000000o3.O00000Oo, i, "", O000000o2, iResultCallback);
    }

    public void O000000o(String str, final IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
        oOO0O00O O000000o2 = new oOO0O00O() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
                Map<String, String> O000000o2 = O000000o();
                O000000o2.put("code", str);
                O000000o2.put("msg", str2);
                oOO0O0O0.O000000o(oOO0O0O0.O00000Oo, O000000o2);
            }

            public void onSuccess() {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
                Map<String, String> O000000o2 = O000000o();
                O000000o2.put("code", oOO0O0O0.O0000oO0);
                O000000o2.put("msg", "success");
                oOO0O0O0.O000000o(oOO0O0O0.O00000Oo, O000000o2);
            }
        }.O000000o(this.O00000o0);
        Map<String, String> O000000o3 = O000000o2.O000000o();
        O000000o3.put(oOO0O0O0.O0000Ooo, str);
        oOO0O0O0.O000000o(oOO0O0O0.O000000o, O000000o3);
        if (dev == null || oOo0oooO.O000000o().O00000Oo() || dev.getIsLocalOnline().booleanValue() || !NetworkUtil.isNetworkAvailable(this.mContext)) {
            O000000o O000000o4 = O000000o(this.O00000o0);
            O000000o(O000000o4.O000000o, O000000o4.O00000Oo, str, 0, (IResultCallback) O000000o2);
            return;
        }
        L.d(O000000o, "sendByHTTP");
        LinkedHashMap<String, Object> O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 == null) {
            O000000o2.onError("11001", (String) null);
            return;
        }
        if (dev.isWifiDevice()) {
            oO0Ooooo oo0ooooo = this.O00000oO;
            String str2 = this.O00000o0;
            oo0ooooo.O000000o(str2, str2, JSON.toJSONString((Object) O00000Oo2, SerializerFeature.WriteMapNullValue), (IResultCallback) O000000o2);
        } else if (!TextUtils.isEmpty(dev.getMeshId())) {
            this.O00000oO.O000000o(dev.getMeshId(), this.O00000o0, JSON.toJSONString((Object) O00000Oo2, SerializerFeature.WriteMapNullValue), (IResultCallback) O000000o2);
        } else {
            O000000o2.onError("10203", (String) null);
        }
        this.O00000oo.sendEmptyMessageDelayed(1, 500);
    }

    public void O000000o(String str, String str2, String str3, int i, IResultCallback iResultCallback) {
        O000000o(str, str2, str3, i, "", iResultCallback);
    }

    public void O000000o(String str, String str2, String str3, int i, String str4, IResultCallback iResultCallback) {
        IResultCallback iResultCallback2 = iResultCallback;
        String str5 = str;
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(str);
        if (deviceBean != null) {
            if (O00000Oo(str3) != null) {
                o0oo00o00o O000000o2 = O000000o();
                if (deviceBean.getIsLocalOnline().booleanValue()) {
                    final DeviceBean deviceBean2 = deviceBean;
                    final String str6 = str2;
                    final int i2 = i;
                    final String str7 = str3;
                    final String str8 = str4;
                    final o0oo00o00o o0oo00o00o = O000000o2;
                    final IResultCallback iResultCallback3 = iResultCallback;
                    O000000o(deviceBean2, str6, i2, str7, O000000o2, str4, (IResultCallback) new IResultCallback() {
                        public void onError(String str, String str2) {
                            oO0OoOO0.this.O000000o(deviceBean2, str6, i2, str7, str8, o0oo00o00o, iResultCallback3);
                        }

                        public void onSuccess() {
                            IResultCallback iResultCallback = iResultCallback3;
                            if (iResultCallback != null) {
                                iResultCallback.onSuccess();
                            }
                        }
                    });
                    return;
                }
                O000000o(deviceBean, str2, i, str3, str4, O000000o2, iResultCallback);
            } else if (iResultCallback2 != null) {
                iResultCallback2.onError("11001", (String) null);
            }
        } else if (iResultCallback2 != null) {
            iResultCallback2.onError("11002", (String) null);
        }
    }

    public void O000000o(String str, String str2, String str3, long j, IResultCallback iResultCallback) {
        this.O00000oO.O000000o(str, str2, str3, j, O000000o(), iResultCallback);
    }

    public void O000000o(String str, List<String> list, List<Integer> list2, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        o0oo00o00o O000000o2 = O000000o();
        if (dev == null || !dev.getIsLocalOnline().booleanValue()) {
            this.O00000oO.O000000o(str, list, list2, O000000o2, iResultCallback);
        } else {
            this.O00000o.O000000o(str, list, list2, iResultCallback);
        }
    }

    public void O000000o(List<String> list, IResultCallback iResultCallback) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && !list.isEmpty()) {
            for (String put : list) {
                linkedHashMap.put(put, (Object) null);
            }
            final O000000o O000000o2 = O000000o(this.O00000o0);
            DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(O000000o2.O000000o);
            if (deviceBean != null) {
                o0oo00o00o O000000o3 = O000000o();
                if (deviceBean.getIsLocalOnline().booleanValue()) {
                    final LinkedHashMap linkedHashMap2 = linkedHashMap;
                    final o0oo00o00o o0oo00o00o = O000000o3;
                    final IResultCallback iResultCallback2 = iResultCallback;
                    this.O00000o.O000000o(deviceBean.getDevId(), (LinkedHashMap<String, Object>) linkedHashMap, O000000o3, (IResultCallback) new IResultCallback() {
                        public void onError(String str, String str2) {
                            oO0OoOO0.this.O000000o(O000000o2.O000000o, (LinkedHashMap<String, Object>) linkedHashMap2, O000000o2.O00000Oo, 0, "", o0oo00o00o, iResultCallback2);
                        }

                        public void onSuccess() {
                            IResultCallback iResultCallback = iResultCallback2;
                            if (iResultCallback != null) {
                                iResultCallback.onSuccess();
                            }
                        }
                    });
                    return;
                }
                O000000o(O000000o2.O000000o, (LinkedHashMap<String, Object>) linkedHashMap, O000000o2.O00000Oo, 0, "", O000000o3, iResultCallback);
            } else if (iResultCallback != null) {
                iResultCallback.onError("11002", (String) null);
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11001", (String) null);
        }
    }

    public void O000000o(List<String> list, String str, IResultCallback iResultCallback) {
        this.O00000oO.O000000o(this.O00000o0, str, list, O000000o(), iResultCallback);
    }

    public void O000000o(List<String> list, String str, String str2, IResultCallback iResultCallback) {
        this.O00000oO.O000000o(this.O00000o0, str, str2, list, O000000o(), iResultCallback);
    }

    public void O00000Oo(String str, IResultCallback iResultCallback) {
        O000000o O000000o2 = O000000o(this.O00000o0);
        O000000o(O000000o2.O000000o, O000000o2.O00000Oo, str, 3, iResultCallback);
    }

    public void O00000Oo(List<String> list, String str, IResultCallback iResultCallback) {
        this.O00000oO.O00000Oo(this.O00000o0, str, list, O000000o(), iResultCallback);
    }

    public void O00000Oo(List<String> list, String str, String str2, IResultCallback iResultCallback) {
        this.O00000oO.O00000Oo(this.O00000o0, str, str2, list, O000000o(), iResultCallback);
    }

    public void O00000o(String str, IResultCallback iResultCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        O000000o((List<String>) arrayList, iResultCallback);
    }

    public void O00000o0(String str, IResultCallback iResultCallback) {
        o0oo00o00o O000000o2 = O000000o();
        O000000o O000000o3 = O000000o(this.O00000o0);
        O000000o(oO0OO000.O000000o().getDeviceBean(O000000o3.O000000o), O000000o3.O00000Oo, 0, str, O000000o2, "", iResultCallback);
    }

    public void O00000oO(String str, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
        if (dev != null) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
            }, new Feature[0]);
            if (dev.getIsOnline().booleanValue()) {
                if (TuyaUtil.checkPvVersion(dev.getPv(), 2.0f)) {
                    this.O00000oO.O000000o(dev.getDevId(), (LinkedHashMap<String, Object>) linkedHashMap, O000000o(), iResultCallback);
                }
            } else if (iResultCallback != null) {
                iResultCallback.onError("10203", (String) null);
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", (String) null);
        }
    }

    public void O00000oo(String str, IResultCallback iResultCallback) {
        this.O00000oO.O000000o(str, this.O00000o0, O000000o(), iResultCallback);
    }

    public void onDestroy() {
        this.O00000oO.O000000o();
        this.O00000oo.removeMessages(1);
    }
}
