package com.tuya.smart.common;

import a.j.a.b;
import com.alibaba.fastjson.JSON;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.common.OO00O0o;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OO00O0 extends OO00O0o {
    private String O000000o(String str, byte[] bArr, String str2) {
        if (new O000OO00(str).getMeshSubDevBeanByNodeId(str2) == null) {
            return "";
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < 10) {
            int i2 = i + 1;
            byte b2 = bArr[i] & AVFrame.FRM_STATE_UNKOWN;
            if (b2 <= 0) {
                break;
            }
            int i3 = i2 + 1;
            byte b3 = bArr[i2] & AVFrame.FRM_STATE_UNKOWN;
            int i4 = i3 + 1;
            byte b4 = bArr[i3];
            if (b3 == 1) {
                int i5 = i4 + 1;
                hashMap.put(String.valueOf(b2), Boolean.valueOf((bArr[i4] & AVFrame.FRM_STATE_UNKOWN) == 1));
                i = i5 + 1;
            } else {
                if (b3 == 2) {
                    int i6 = i4 + 1;
                    i4 = i6 + 1;
                    hashMap.put(String.valueOf(b2), Integer.valueOf(((bArr[i4] & AVFrame.FRM_STATE_UNKOWN) << 8) + (bArr[i6] & AVFrame.FRM_STATE_UNKOWN)));
                }
                i = i4;
            }
        }
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, str2);
        if (subDevRespBean != null) {
            subDevRespBean.getDps().putAll(hashMap);
        }
        String jSONString = JSON.toJSONString(hashMap);
        O0000o.O000000o(str, str2, (String) null, -2, jSONString);
        return jSONString;
    }

    public DpsParseBean O000000o(String str) {
        return null;
    }

    public String O000000o(String str, byte b2, byte[] bArr, String str2) {
        return b2 == b.BLE_GATT_OP_CTRL_EB.f() ? O000000o(str, bArr, str2) : "";
    }

    public String O000000o(String str, OO00O0o.O000000o o000000o, DeviceBean deviceBean) {
        return "";
    }

    public String[] O000000o() {
        return new String[0];
    }

    public DpsParseBean O00000Oo(String str) {
        return null;
    }

    public List<DpsParseBean> O00000Oo() {
        return new ArrayList();
    }

    /* renamed from: O00000o0 */
    public String O00000oO(String str) {
        return "";
    }
}
