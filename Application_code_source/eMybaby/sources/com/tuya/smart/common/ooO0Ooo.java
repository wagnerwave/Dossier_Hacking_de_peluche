package com.tuya.smart.common;

import a.j.a.b;
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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ooO0Ooo extends OO00O0o {
    public static final String O000000o = "ActionParse";
    public static final String O00000Oo = "121";
    public static final String O00000o = "123";
    public static final String O00000o0 = "122";
    public static final String O00000oO = "124";
    public static final String O00000oo = "125";
    public static final String O0000O0o = "126";
    public static final String O0000OOo = "127";
    public static final String O0000Oo = "129";
    public static final String O0000Oo0 = "128";
    public static final String O0000OoO = "130";
    public static final String O0000Ooo = "131";
    public static final String O0000o = "136";
    public static final String O0000o0 = "133";
    public static final String O0000o00 = "132";
    public static final String O0000o0O = "134";
    public static final String O0000o0o = "135";
    public static final String O0000oO = "138";
    public static final String O0000oO0 = "137";
    public static final String O0000oOO = "150";

    private DpsParseBean O000000o(DpsParseBean dpsParseBean, int i) {
        if (dpsParseBean == null) {
            dpsParseBean = new DpsParseBean();
        }
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_EA.f());
        byte[] params = dpsParseBean.getParams();
        if (params == null || params.length == 0) {
            params = new byte[3];
            params[0] = Tnaf.POW_2_WIDTH;
            params[1] = (byte) (i & 255);
        } else if (params.length == 3) {
            params[2] = (byte) (i & 255);
        }
        dpsParseBean.setParams(params);
        return dpsParseBean;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, byte], vars: [r1v2 ?, r1v3 ?, r1v7 ?, r1v8 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private com.tuya.smart.android.blemesh.bean.DpsParseBean O000000o(com.tuya.smart.android.blemesh.bean.DpsParseBean r9, int r10, java.lang.Object r11) {
        /*
            r8 = this;
            a.j.a.b r0 = a.j.a.b.BLE_GATT_OP_CTRL_D2
            byte r0 = r0.f()
            r9.setOpCode(r0)
            byte[] r0 = r9.getParams()
            r1 = 10
            r2 = 0
            if (r0 == 0) goto L_0x001c
            int r3 = r0.length
            if (r3 != 0) goto L_0x0016
            goto L_0x001c
        L_0x0016:
            int r3 = r0.length
            if (r3 != r1) goto L_0x001b
            r1 = 5
            goto L_0x001f
        L_0x001b:
            return r9
        L_0x001c:
            byte[] r0 = new byte[r1]
            r1 = 0
        L_0x001f:
            int r3 = r1 + 1
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r0[r1] = r10
            boolean r10 = r11 instanceof java.lang.Boolean
            r1 = 2
            r4 = 1
            if (r10 == 0) goto L_0x0039
            byte[] r10 = new byte[r4]
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            byte r11 = (byte) r11
            r10[r2] = r11
            r1 = 1
            goto L_0x007d
        L_0x0039:
            boolean r10 = r11 instanceof java.lang.Integer
            if (r10 == 0) goto L_0x0056
            byte[] r10 = new byte[r1]
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            short r11 = (short) r11
            r5 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r11
            int r5 = r5 >> 8
            byte r5 = (byte) r5
            r10[r2] = r5
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r11 = (byte) r11
            r10[r4] = r11
            r4 = 2
            goto L_0x007d
        L_0x0056:
            boolean r10 = r11 instanceof java.lang.String
            if (r10 == 0) goto L_0x0095
            r1 = 3
            java.lang.String r11 = (java.lang.String) r11
            int r10 = r11.length()
            r4 = 7
            if (r10 >= r4) goto L_0x006a
            int r10 = r11.length()
            byte r10 = (byte) r10
            goto L_0x006b
        L_0x006a:
            r10 = 7
        L_0x006b:
            byte[] r4 = new byte[r10]
            r5 = 0
        L_0x006e:
            if (r5 >= r10) goto L_0x007a
            char r6 = r11.charAt(r5)
            byte r6 = (byte) r6
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x006e
        L_0x007a:
            r7 = r4
            r4 = r10
            r10 = r7
        L_0x007d:
            int r11 = r3 + 1
            r0[r3] = r1
            int r1 = r11 + 1
            r0[r11] = r4
            int r11 = r10.length
        L_0x0086:
            if (r2 >= r11) goto L_0x0092
            byte r3 = r10[r2]
            int r4 = r1 + 1
            r0[r1] = r3
            int r2 = r2 + 1
            r1 = r4
            goto L_0x0086
        L_0x0092:
            r9.setParams(r0)
        L_0x0095:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.ooO0Ooo.O000000o(com.tuya.smart.android.blemesh.bean.DpsParseBean, int, java.lang.Object):com.tuya.smart.android.blemesh.bean.DpsParseBean");
    }

    private DpsParseBean O000000o(String str, byte b2) {
        DpsParseBean dpsParseBean = new DpsParseBean();
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            int parseInt = Integer.parseInt((String) entry.getKey());
            if ((parseInt >= Integer.parseInt(O00000Oo) && parseInt <= Integer.parseInt(O0000OoO)) || parseInt == Integer.parseInt(O0000oOO)) {
                O000000o(dpsParseBean, parseInt, entry.getValue());
            } else if (parseInt >= Integer.parseInt(O0000Ooo) && parseInt <= Integer.parseInt(O0000oO)) {
                O000000o(dpsParseBean, parseInt);
            }
        }
        return dpsParseBean;
    }

    private String O000000o(String str, byte[] bArr, String str2) {
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, str2);
        if (subDevRespBean == null) {
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
        subDevRespBean.getDps().putAll(hashMap);
        String jSONString = JSON.toJSONString(hashMap);
        O0000o.O000000o(str, str2, (String) null, -2, jSONString);
        return jSONString;
    }

    private String O00000Oo(String str, byte[] bArr, String str2) {
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
        int i7 = bArr[6] & AVFrame.FRM_STATE_UNKOWN;
        int i8 = bArr[7] & AVFrame.FRM_STATE_UNKOWN;
        String[] strArr = {O0000Ooo, O0000o00, O0000o0, O0000o0O, O0000o0o, O0000o, O0000oO0, O0000oO};
        int[] iArr = {i, i2, i3, i4, i5, i6, i7, i8};
        HashMap hashMap = new HashMap();
        for (int i9 = 0; i9 < 8; i9++) {
            hashMap.put(strArr[i9], Integer.valueOf(iArr[i9]));
        }
        subDevRespBean.getDps().putAll(hashMap);
        String jSONString = JSON.toJSONString(hashMap);
        L.d(O000000o, "actionStatus: " + jSONString + " nodeId: " + str4);
        O0000o.O000000o(str3, str4, (String) null, -2, jSONString);
        return jSONString;
    }

    public DpsParseBean O000000o(String str) {
        return O000000o(str, (byte) 0);
    }

    public String O000000o(String str, byte b2, byte[] bArr, String str2) {
        return b2 == b.BLE_GATT_OP_CTRL_DB.f() ? O00000Oo(str, bArr, str2) : b2 == b.BLE_GATT_OP_CTRL_EB.f() ? O000000o(str, bArr, str2) : "";
    }

    public String O000000o(String str, OO00O0o.O000000o o000000o, DeviceBean deviceBean) {
        return "";
    }

    public String[] O000000o() {
        return new String[]{O00000Oo, O00000o0, O00000o, O00000oO, O00000oo, O0000O0o, O0000OOo, O0000Oo0, O0000Oo, O0000OoO, O0000Ooo, O0000o00, O0000o0, O0000o0O, O0000o0o, O0000o, O0000oO0, O0000oO, O0000oOO};
    }

    public DpsParseBean O00000Oo(String str) {
        return O000000o(str, (byte) 0);
    }

    public DpsParseBean O00000o(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt < Integer.parseInt(O0000Ooo) || parseInt > Integer.parseInt(O0000oO)) {
            return null;
        }
        return O000000o((DpsParseBean) null, parseInt);
    }

    /* renamed from: O00000o0 */
    public String O00000oO(String str) {
        return str;
    }
}
