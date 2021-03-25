package com.tuya.smart.common;

import a.a.a.a.a;
import a.j.a.b;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.OO00O0o;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OO0000o extends OO00O0o {
    public static final String O000000o = "TuyaMeshParse";
    public static final String O00000Oo = "1";
    public static final String O00000o = "42";
    public static final String O00000o0 = "41";
    public static final String O00000oO = "43";
    public static final String O00000oo = "44";
    public static final String O0000O0o = "45";
    public static final String O0000OOo = "46";
    public static final String O0000Oo = "48";
    public static final String O0000Oo0 = "47";
    public static final String O0000OoO = "49";

    public static class O000000o {
        public static final int O000000o = 0;
        public static final int O00000Oo = 1;
        public static final int O00000o = 3;
        public static final int O00000o0 = 2;
        public static final int O00000oO = 4;
        public static final int O00000oo = 5;
        public int O0000O0o;
        public int O0000OOo;
        public int O0000Oo;
        public int O0000Oo0;
        public int O0000OoO;
        public int O0000Ooo;
        public ArrayList<Integer> O0000o00 = new ArrayList<>();

        public static byte O000000o(byte[] bArr) {
            byte b2 = 0;
            for (int i = 0; i < bArr.length; i++) {
                b2 = (byte) (b2 + ((byte) ((bArr[i] << (7 - i)) & 255)));
            }
            return (byte) (b2 & AVFrame.FRM_STATE_UNKOWN);
        }

        public static int O000000o() {
            return 0;
        }

        public static int O00000Oo() {
            return 1;
        }

        public static int O00000o() {
            return 3;
        }

        public static int O00000o0() {
            return 2;
        }

        public static int O00000oO() {
            return 4;
        }

        public static int O00000oo() {
            return 5;
        }

        public void O000000o(int i) {
            this.O0000o00.add(Integer.valueOf(i));
        }

        public byte[] O0000O0o() {
            byte[] bArr = new byte[8];
            bArr[0] = 1;
            bArr[1] = (byte) (this.O0000O0o & 255);
            bArr[2] = (byte) (this.O0000OOo & 255);
            bArr[3] = (byte) (this.O0000Oo0 & 255);
            bArr[4] = (byte) (this.O0000Oo & 255);
            bArr[5] = (byte) (this.O0000OoO & 255);
            bArr[6] = (byte) (this.O0000Ooo & 255);
            byte[] bArr2 = new byte[6];
            Iterator<Integer> it = this.O0000o00.iterator();
            while (it.hasNext()) {
                bArr2[it.next().intValue()] = 1;
            }
            bArr[7] = O000000o(bArr2);
            return bArr;
        }

        public byte O0000OOo() {
            byte[] bArr = new byte[8];
            Iterator<Integer> it = this.O0000o00.iterator();
            while (it.hasNext()) {
                bArr[it.next().intValue()] = 1;
            }
            return O000000o(bArr);
        }
    }

    private DpsParseBean O000000o(String str, byte b2) {
        DpsParseBean dpsParseBean = new DpsParseBean();
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            String str2 = (String) entry.getKey();
            if (TextUtils.equals(str2, "1")) {
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_D0.f());
                if (booleanValue) {
                    dpsParseBean.setParams(new byte[]{1, 0, b2});
                } else {
                    dpsParseBean.setParams(new byte[]{0, 0, b2});
                }
            } else if (TextUtils.equals(str2, O00000o0)) {
                dpsParseBean = O0000Oo0((String) entry.getValue());
            } else if (Integer.parseInt(str2) >= Integer.parseInt(O00000o) && Integer.parseInt(str2) <= Integer.parseInt(O0000Oo0)) {
                dpsParseBean = O0000Oo(str);
            } else if (TextUtils.equals(str2, O0000Oo)) {
                dpsParseBean = O0000OOo((String) entry.getValue());
            } else if (TextUtils.equals(str2, O0000OoO)) {
                dpsParseBean = O0000O0o((String) entry.getValue());
            }
        }
        return dpsParseBean;
    }

    private String O000000o(String str, byte[] bArr, String str2) {
        if (new O000OO00(str).getMeshSubDevBeanByNodeId(str2) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[1]);
        stringBuffer.append(bArr[2]);
        stringBuffer.append(bArr[3]);
        stringBuffer.append(bArr[4]);
        stringBuffer.append(String.format("%04d", new Object[]{Integer.valueOf(((bArr[6] << 8) & AVFrame.FRM_STATE_UNKOWN) + (bArr[5] & AVFrame.FRM_STATE_UNKOWN))}));
        stringBuffer.append(String.format("%08d", new Object[]{Long.valueOf(Long.parseLong(Long.toString((long) (bArr[7] & AVFrame.FRM_STATE_UNKOWN), 2)))}));
        L.d("TuyaMeshParse", "eleLocalTimerReceiveParse:" + stringBuffer.toString());
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, str2);
        if (subDevRespBean != null) {
            subDevRespBean.getDps().put(O0000OoO, stringBuffer.toString());
        }
        HashMap hashMap = new HashMap();
        hashMap.put(O0000OoO, stringBuffer.toString());
        String jSONString = JSON.toJSONString(hashMap);
        O0000o.O000000o(str, str2, (String) null, -2, jSONString);
        return jSONString;
    }

    private Map<String, Object> O000000o(int i, String[] strArr, int[] iArr, DeviceRespBean deviceRespBean) {
        Boolean bool;
        String[] strArr2 = strArr;
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            int i3 = 255;
            String str = strArr2[i2];
            int i4 = iArr[i2];
            char c2 = 65535;
            switch (str.hashCode()) {
                case 1662:
                    if (str.equals(O00000o)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1663:
                    if (str.equals(O00000oO)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1664:
                    if (str.equals(O00000oo)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals(O0000O0o)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1666:
                    if (str.equals(O0000OOo)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1667:
                    if (str.equals(O0000Oo0)) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                i3 = 128;
            } else if (c2 == 1) {
                i3 = 64;
            } else if (c2 == 2) {
                i3 = 32;
            } else if (c2 == 3) {
                i3 = 16;
            } else if (c2 == 4) {
                i3 = 8;
            } else if (c2 == 5) {
                i3 = 4;
            }
            if ((i & i3) == i3) {
                if (i4 == 0) {
                    deviceRespBean.getDps().put(str, Boolean.FALSE);
                    bool = Boolean.FALSE;
                } else if (i4 == 1) {
                    deviceRespBean.getDps().put(str, Boolean.TRUE);
                    bool = Boolean.TRUE;
                }
                hashMap.put(str, bool);
            }
        }
        return hashMap;
    }

    private String O00000Oo(String str, byte[] bArr, String str2) {
        String str3;
        if (new O000OO00(str).getMeshSubDevBeanByNodeId(str2) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < bArr.length; i++) {
            stringBuffer.append(String.format("%08d", new Object[]{Long.valueOf(Long.parseLong(Long.toString((long) (bArr[i] & AVFrame.FRM_STATE_UNKOWN), 2)))}));
        }
        StringBuilder n = a.n("parse byte to 2 string:");
        n.append(stringBuffer.toString());
        L.d("TuyaMeshParse", n.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer.length() / 12; i2++) {
            int i3 = i2 * 12;
            String substring = stringBuffer.substring(i3, i3 + 12);
            if (substring.startsWith("1")) {
                int parseInt = Integer.parseInt(substring.substring(1, 12), 2);
                stringBuffer2.append("1");
                str3 = String.format("%04d", new Object[]{Integer.valueOf(parseInt)});
            } else {
                str3 = "00000";
            }
            stringBuffer2.append(str3);
        }
        StringBuilder n2 = a.n("eleCountDownReceiveParse:");
        n2.append(stringBuffer2.toString());
        L.d("TuyaMeshParse", n2.toString());
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, str2);
        if (subDevRespBean != null) {
            subDevRespBean.getDps().put(O00000o0, stringBuffer2.toString());
        }
        HashMap hashMap = new HashMap();
        hashMap.put(O00000o0, stringBuffer2.toString());
        String jSONString = JSON.toJSONString(hashMap);
        O0000o.O000000o(str, str2, (String) null, -2, jSONString);
        return jSONString;
    }

    private String O00000o0(String str, byte[] bArr, String str2) {
        String str3 = str;
        String str4 = str2;
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str3, str4);
        if (subDevRespBean == null) {
            return "";
        }
        int i = bArr[0] & AVFrame.FRM_STATE_UNKOWN;
        int i2 = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
        int i3 = bArr[2] & AVFrame.FRM_STATE_UNKOWN;
        int i4 = bArr[3] & AVFrame.FRM_STATE_UNKOWN;
        int i5 = bArr[4] & AVFrame.FRM_STATE_UNKOWN;
        int i6 = bArr[5] & AVFrame.FRM_STATE_UNKOWN;
        Map<String, Object> O000000o2 = O000000o((int) bArr[6] & AVFrame.FRM_STATE_UNKOWN, new String[]{O00000o, O00000oO, O00000oo, O0000O0o, O0000OOo, O0000Oo0}, new int[]{i, i2, i3, i4, i5, i6}, subDevRespBean);
        Iterator<Map.Entry<String, Object>> it = O000000o2.entrySet().iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (z || ((Boolean) next.getValue()).booleanValue()) {
                        z = true;
                    }
                } else {
                    subDevRespBean.getDps().put("1", Boolean.valueOf(z));
                    O000000o2.put("1", Boolean.valueOf(z));
                    String jSONString = JSON.toJSONString(O000000o2);
                    L.d("TuyaMeshParse", "eleStatus: " + jSONString + " nodeId: " + str4);
                    O0000o.O000000o(str3, str4, (String) null, -2, jSONString);
                    return jSONString;
                }
            }
        }
    }

    private DpsParseBean O0000O0o(String str) {
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_EA.f());
        dpsParseBean.setParams(new byte[]{Tnaf.POW_2_WIDTH, 2, (byte) Integer.parseInt(str)});
        return dpsParseBean;
    }

    private DpsParseBean O0000OOo(String str) {
        if (str.length() != 16) {
            return null;
        }
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_E2.f());
        byte[] bArr = new byte[8];
        bArr[0] = -15;
        bArr[1] = (byte) (Integer.parseInt(str.substring(0, 1)) & 255);
        bArr[2] = (byte) (Integer.parseInt(str.substring(1, 2)) & 255);
        bArr[3] = (byte) (Integer.parseInt(str.substring(2, 3)) & 255);
        bArr[4] = (byte) (Integer.parseInt(str.substring(3, 4)) & 255);
        String replaceFirst = str.substring(4, 8).replaceFirst("^0*", "");
        if (TextUtils.isEmpty(replaceFirst)) {
            replaceFirst = oOO0O0O0.O0000oO0;
        }
        int parseInt = Integer.parseInt(replaceFirst) & 65535;
        bArr[5] = (byte) (parseInt & 255);
        bArr[6] = (byte) ((parseInt >> 8) & 255);
        bArr[7] = (byte) Integer.parseInt(str.substring(8, 16), 2);
        dpsParseBean.setParams(bArr);
        return dpsParseBean;
    }

    private DpsParseBean O0000Oo(String str) {
        int O00000oo2;
        DpsParseBean dpsParseBean = new DpsParseBean();
        O000000o o000000o = new O000000o();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_E2.f());
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            String str2 = (String) entry.getKey();
            if (TextUtils.equals(str2, O00000o)) {
                o000000o.O0000O0o = ((Boolean) entry.getValue()).booleanValue() ? 1 : 0;
                O00000oo2 = O000000o.O000000o();
            } else if (TextUtils.equals(str2, O00000oO)) {
                o000000o.O0000OOo = ((Boolean) entry.getValue()).booleanValue() ? 1 : 0;
                O00000oo2 = O000000o.O00000Oo();
            } else if (TextUtils.equals(str2, O00000oo)) {
                o000000o.O0000Oo0 = ((Boolean) entry.getValue()).booleanValue() ? 1 : 0;
                O00000oo2 = O000000o.O00000o0();
            } else if (TextUtils.equals(str2, O0000O0o)) {
                o000000o.O0000Oo = ((Boolean) entry.getValue()).booleanValue() ? 1 : 0;
                O00000oo2 = O000000o.O00000o();
            } else if (TextUtils.equals(str2, O0000OOo)) {
                o000000o.O0000OoO = ((Boolean) entry.getValue()).booleanValue() ? 1 : 0;
                O00000oo2 = O000000o.O00000oO();
            } else if (TextUtils.equals(str2, O0000Oo0)) {
                o000000o.O0000Ooo = ((Boolean) entry.getValue()).booleanValue() ? 1 : 0;
                O00000oo2 = O000000o.O00000oo();
            }
            o000000o.O000000o(O00000oo2);
        }
        dpsParseBean.setParams(o000000o.O0000O0o());
        return dpsParseBean;
    }

    private DpsParseBean O0000Oo0(String str) {
        String str2;
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_D2.f());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length() / 5; i++) {
            int i2 = i * 5;
            String substring = str.substring(i2, i2 + 5);
            L.d("TuyaMeshParse", "paramCountDown:" + substring);
            if (substring.startsWith("1")) {
                stringBuffer.append("1");
                String binaryString = Integer.toBinaryString(Integer.parseInt(substring.substring(1, 5)));
                a.v("time:", binaryString, "TuyaMeshParse");
                str2 = String.format("%011d", new Object[]{Long.valueOf(Long.parseLong(binaryString))});
            } else {
                str2 = "000000000000";
            }
            stringBuffer.append(str2);
        }
        byte[] bArr = new byte[9];
        for (int i3 = 0; i3 < stringBuffer.length() / 8; i3++) {
            int i4 = i3 * 8;
            bArr[i3] = Long.valueOf(stringBuffer.substring(i4, i4 + 8), 2).byteValue();
        }
        dpsParseBean.setParams(bArr);
        return dpsParseBean;
    }

    private int O0000OoO(String str) {
        if (str.startsWith("01")) {
            return 128;
        }
        if (str.startsWith("02")) {
            return o00o0000o0.O00000Oo;
        }
        if (str.startsWith("03")) {
            return 224;
        }
        if (str.startsWith("04")) {
            return 240;
        }
        return str.startsWith("05") ? O0o00.O0000O0o : str.startsWith("06") ? 252 : 0;
    }

    public DpsParseBean O000000o(String str) {
        DpsParseBean O000000o2 = super.O000000o(str);
        return O000000o2 != null ? O000000o2 : O000000o(str, (byte) 0);
    }

    public String O000000o(String str, byte b2, byte[] bArr, String str2) {
        return b2 == b.BLE_GATT_OP_CTRL_DB.f() ? O00000o0(str, bArr, str2) : b2 == b.BLE_GATT_OP_CTRL_EB.f() ? bArr[0] == 1 ? O00000Oo(str, bArr, str2) : bArr[0] == 2 ? O000000o(str, bArr, str2) : "" : "";
    }

    public String O000000o(String str, OO00O0o.O000000o o000000o, DeviceBean deviceBean) {
        int O00000Oo2 = o000000o.O00000Oo();
        String[] strArr = {O00000o, O00000oO, O00000oo, O0000O0o, O0000OOo, O0000Oo0};
        int[] iArr = {(O00000Oo2 >> 7) & 1, (O00000Oo2 >> 6) & 1, (O00000Oo2 >> 5) & 1, (O00000Oo2 >> 4) & 1, (O00000Oo2 >> 3) & 1, (O00000Oo2 >> 2) & 1};
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, deviceBean.getNodeId());
        Map<String, Object> O000000o2 = O000000o(O0000OoO(OO00o00.O000000o(deviceBean.getCategory())), strArr, iArr, subDevRespBean);
        Iterator<Map.Entry<String, Object>> it = O000000o2.entrySet().iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (z || ((Boolean) next.getValue()).booleanValue()) {
                        z = true;
                    }
                } else {
                    subDevRespBean.getDps().put("1", Boolean.valueOf(z));
                    O000000o2.put("1", Boolean.valueOf(z));
                    return JSON.toJSONString(O000000o2);
                }
            }
        }
    }

    public String[] O000000o() {
        return new String[]{"1", O00000o0, O00000o, O00000oO, O00000oo, O0000O0o, O0000OOo, O0000Oo0, O0000Oo, O0000OoO};
    }

    public DpsParseBean O00000Oo(String str) {
        return O000000o(str);
    }

    public List<DpsParseBean> O00000Oo() {
        List<DpsParseBean> O00000Oo2 = super.O00000Oo();
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_EA.f());
        dpsParseBean.setParams(new byte[]{Tnaf.POW_2_WIDTH, 1});
        O00000Oo2.add(dpsParseBean);
        return O00000Oo2;
    }

    public DpsParseBean O00000o(String str) {
        if (!O00000o0.equals(str)) {
            return null;
        }
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_EA.f());
        dpsParseBean.setParams(new byte[]{Tnaf.POW_2_WIDTH, 1});
        return dpsParseBean;
    }

    /* renamed from: O00000o0 */
    public String O00000oO(String str) {
        return str;
    }
}
