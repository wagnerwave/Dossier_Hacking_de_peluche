package com.tuya.smart.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.enums.ModeEnum;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IDevListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class oo0o000o0 implements IDevListener {
    public static final String O000000o = "TuyaDeviceControl";
    public static final int O00000Oo = 1001;
    public static final int O00000o0 = 1002;
    public ITuyaDevice O00000o;
    public Map<String, Object> O00000oO;
    public IResultCallback O00000oo;
    public IDevModel O0000O0o;
    public List<String> O0000OOo;
    public Handler O0000Oo;
    public o0o00o00o0 O0000Oo0;

    public oo0o000o0() {
        this.O0000OOo = new ArrayList();
        this.O0000Oo = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i != 1001) {
                    if (i != 1002) {
                        return false;
                    }
                    if (oo0o000o0.this.O00000oo != null) {
                        oo0o000o0.this.O00000oo.onSuccess();
                    }
                } else if (oo0o000o0.this.O00000oo != null) {
                    oo0o000o0.this.O00000oo.onError("103201", "timeout");
                }
                oo0o000o0.this.O000000o();
                return false;
            }
        });
        this.O0000OOo = new ArrayList();
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        this.O0000Oo.removeMessages(1001);
        ITuyaDevice iTuyaDevice = this.O00000o;
        if (iTuyaDevice != null) {
            iTuyaDevice.onDestroy();
        }
        IDevModel iDevModel = this.O0000O0o;
        if (iDevModel != null) {
            iDevModel.onDestroy();
        }
    }

    public void O000000o(String str, Map<String, Object> map, final IResultCallback iResultCallback) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        this.O0000Oo0 = o0o00o00o0;
        if (o0o00o00o0 == null) {
            L.e(O000000o, "ITuyaDevicePlugin is null");
            return;
        }
        this.O00000o = o0o00o00o0.O000000o(str);
        this.O00000oO = map;
        this.O00000oo = iResultCallback;
        IDevModel O000000o2 = this.O0000Oo0.O000000o(TuyaSdk.getApplication(), str);
        this.O0000O0o = O000000o2;
        O000000o2.sendScene(JSON.toJSONString(map), new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
            }
        });
        boolean z = false;
        Map<String, SchemaBean> schemaMap = this.O0000Oo0.O0000OOo().getDeviceBean(str).getSchemaMap();
        if (schemaMap != null && !schemaMap.isEmpty()) {
            Iterator<Map.Entry<String, SchemaBean>> it = schemaMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((SchemaBean) it.next().getValue()).getMode().equals(ModeEnum.WR.getType())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.O0000OOo.add(str);
            this.O0000Oo.sendEmptyMessageDelayed(1002, 1000);
        }
        this.O0000Oo.sendEmptyMessageDelayed(1001, 5000);
        this.O00000o.registerDevListener(this);
    }

    public void onDevInfoUpdate(String str) {
    }

    public void onDpUpdate(String str, String str2) {
        if (!this.O0000OOo.contains(str)) {
            for (Map.Entry key : ((LinkedHashMap) JSON.parseObject(str2, new TypeReference<LinkedHashMap<String, Object>>() {
            }, new Feature[0])).entrySet()) {
                if (this.O00000oO.get(key.getKey()) != null) {
                    IResultCallback iResultCallback = this.O00000oo;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                    }
                    O000000o();
                    return;
                }
            }
        }
    }

    public void onNetworkStatusChanged(String str, boolean z) {
    }

    public void onRemoved(String str) {
    }

    public void onStatusChanged(String str, boolean z) {
    }
}
