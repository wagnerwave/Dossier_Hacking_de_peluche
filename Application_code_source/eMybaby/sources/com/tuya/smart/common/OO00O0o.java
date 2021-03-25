package com.tuya.smart.common;

import a.e.a.a.r.a;
import a.j.a.b;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class OO00O0o implements OO000OO {
    public static final String O000000o = "TuyaMeshParse";
    public static final String O000O0o = "2";
    public static final String O000O0o0 = "1";

    public static class O000000o {
        public String O000000o;
        public int O00000Oo;
        public int O00000o0;

        public O000000o(int i, int i2, int i3) {
            this.O00000o0 = i;
            this.O00000Oo = i2;
            this.O000000o = a.d(i3);
        }

        public String O000000o() {
            return this.O000000o;
        }

        public int O00000Oo() {
            return this.O00000Oo;
        }

        public int O00000o0() {
            return this.O00000o0;
        }
    }

    public DpsParseBean O000000o(String str) {
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            if (TextUtils.equals((String) entry.getKey(), "2")) {
                return O00000oo((String) entry.getValue());
            }
        }
        return null;
    }

    public void O000000o(String str, byte[] bArr) {
        int length = bArr.length;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i + 4 < length) {
            int i2 = i + 1;
            byte b2 = bArr[i];
            int i3 = i2 + 1;
            byte b3 = bArr[i2];
            int i4 = i3 + 1;
            byte b4 = bArr[i3] & AVFrame.FRM_STATE_UNKOWN;
            int i5 = i4 + 1;
            byte b5 = bArr[i4];
            byte b6 = b2 & AVFrame.FRM_STATE_UNKOWN;
            L.d("TuyaMeshParse", "meshAddress: " + b6);
            if (b6 == 0 || (b6 == 255 && b4 == 255)) {
                break;
            }
            arrayList.add(new O000000o(b3, b4, b6));
            i = i5;
        }
        O000OO00 o000oo00 = new O000OO00(str);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            O000000o o000000o = (O000000o) it.next();
            String O000000o2 = o000000o.O000000o();
            DeviceBean meshSubDevBeanByNodeId = o000oo00.getMeshSubDevBeanByNodeId(O000000o2);
            if (meshSubDevBeanByNodeId != null) {
                if (o000000o.O00000o0() == 0) {
                    if (meshSubDevBeanByNodeId.getIsLocalOnline().booleanValue()) {
                        O0O0o00.O000000o().O00000Oo(str, O000000o2);
                    }
                    L.d("TuyaMeshParse", "offline: " + O000000o2);
                    arrayList2.add(O000000o2);
                } else {
                    if (!meshSubDevBeanByNodeId.getIsLocalOnline().booleanValue()) {
                        O0O0o00.O000000o().O000000o(str, O000000o2);
                    }
                    L.d("TuyaMeshParse", "online: " + O000000o2);
                    arrayList3.add(O000000o2);
                }
                String O000000o3 = OO00o00.O00000Oo(OO00o00.O000000o(meshSubDevBeanByNodeId.getCategory())).O000000o(str, o000000o, meshSubDevBeanByNodeId);
                L.d("TuyaMeshParse", "json: " + O000000o3);
                if (!TextUtils.isEmpty(O000000o3)) {
                    O0000o.O000000o(str, O000000o2, (String) null, -2, O000000o3);
                }
            }
        }
        if (arrayList2.size() > 0 || arrayList3.size() > 0) {
            O0000o.O000000o(str, arrayList3, arrayList2);
        }
    }

    public boolean O000000o(Set set) {
        return Arrays.asList(O000000o()).containsAll(set);
    }

    public List<DpsParseBean> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_DA.f());
        dpsParseBean.setParams(new byte[]{Tnaf.POW_2_WIDTH});
        arrayList.add(dpsParseBean);
        return arrayList;
    }

    public DpsParseBean O00000o(String str) {
        return null;
    }

    public DpsParseBean O00000oo(String str) {
        if (str.length() != 16) {
            return null;
        }
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_F4.f());
        byte[] bArr = new byte[9];
        bArr[0] = -16;
        int parseInt = Integer.parseInt(str.substring(0, 4).replaceFirst("^0*", "")) & 65535;
        bArr[1] = (byte) (parseInt & 255);
        bArr[2] = (byte) ((parseInt >> 8) & 255);
        int i = 2;
        while (i < str.length() / 2) {
            int i2 = i * 2;
            i++;
            bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2)) & 255);
        }
        dpsParseBean.setParams(bArr);
        return dpsParseBean;
    }
}
