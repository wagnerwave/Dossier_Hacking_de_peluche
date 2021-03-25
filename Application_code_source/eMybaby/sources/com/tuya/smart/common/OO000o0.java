package com.tuya.smart.common;

import a.a.a.a.a;
import a.j.a.b;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.OO00O0o;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class OO000o0 extends OO00O0o {
    public static final String O000000o = "LightParse";
    public static final String O00000Oo = "1";
    public static final String O00000o = "3";
    public static final String O00000o0 = "4";
    public static final String O00000oO = "101";
    public static final String O00000oo = "102";
    public static final String O0000O0o = "103";
    public static final String O0000OOo = "104";
    public static final String O0000Oo = "106";
    public static final String O0000Oo0 = "105";
    public static final String O0000OoO = "108";
    public static final String O0000Ooo = "109";
    public static final String O0000o = "114";
    public static final String O0000o0 = "111";
    public static final String O0000o00 = "110";
    public static final String O0000o0O = "112";
    public static final String O0000o0o = "113";
    public static final String O0000oO = "116";
    public static final String O0000oO0 = "115";
    public static final String O0000oOO = "117";
    public static final String O0000oOo = "118";
    public static final String O0000oo = "colour";
    public static final String O0000oo0 = "white";
    public static final String O0000ooO = "scene_1";
    public static final String O0000ooo = "scene_2";
    public static final String O000O00o = "scene_5";
    public static final String O000O0OO = "scene_6";
    public static final String O000O0Oo = "scene_7";
    public static final String O00oOoOo = "scene_8";
    public static final String O00oOooO = "scene_3";
    public static final String O00oOooo = "scene_4";

    public static class O000000o {
        public static final int O000000o = 0;
        public static final int O00000Oo = 1;
        public static final int O00000o = 5;
        public static final int O00000o0 = 2;
        public static final int O00000oO = 3;
        public static final int O00000oo = 4;
        public static final int O0000O0o = 6;
        public int O0000OOo;
        public int O0000Oo;
        public int O0000Oo0;
        public int O0000OoO;
        public int O0000Ooo;
        public int O0000o0;
        public int O0000o00;
        public ArrayList<Integer> O0000o0O = new ArrayList<>();

        public static byte O000000o(byte[] bArr) {
            byte b2 = 0;
            for (int i = 0; i < bArr.length; i++) {
                b2 = (byte) (b2 + ((byte) ((bArr[i] << (7 - i)) & 255)));
            }
            return (byte) (b2 & AVFrame.FRM_STATE_UNKOWN);
        }

        public static int O000000o() {
            return 5;
        }

        public static int O00000Oo() {
            return 3;
        }

        public static int O00000o() {
            return 0;
        }

        public static int O00000o0() {
            return 4;
        }

        public static int O00000oO() {
            return 1;
        }

        public static int O00000oo() {
            return 2;
        }

        public static int O0000O0o() {
            return 6;
        }

        public void O000000o(int i) {
            this.O0000o0O.add(Integer.valueOf(i));
        }

        public byte[] O0000OOo() {
            byte[] bArr = new byte[9];
            bArr[0] = 9;
            bArr[1] = (byte) (this.O0000OOo & 255);
            bArr[2] = (byte) (this.O0000Oo0 & 255);
            bArr[3] = (byte) (this.O0000Oo & 255);
            bArr[4] = (byte) (this.O0000OoO & 255);
            bArr[5] = (byte) (this.O0000Ooo & 255);
            bArr[6] = (byte) (this.O0000o00 & 255);
            bArr[7] = (byte) (this.O0000o0 & 255);
            byte[] bArr2 = new byte[8];
            Iterator<Integer> it = this.O0000o0O.iterator();
            while (it.hasNext()) {
                bArr2[it.next().intValue()] = 1;
            }
            bArr[8] = O000000o(bArr2);
            return bArr;
        }

        public byte O0000Oo0() {
            byte[] bArr = new byte[8];
            Iterator<Integer> it = this.O0000o0O.iterator();
            while (it.hasNext()) {
                bArr[it.next().intValue()] = 1;
            }
            return O000000o(bArr);
        }
    }

    private DpsParseBean O000000o(String str, byte b2) {
        DpsParseBean dpsParseBean = new DpsParseBean();
        LinkedHashMap O00000o02 = O00000o0(str);
        for (Map.Entry entry : O00000o02.entrySet()) {
            String str2 = (String) entry.getKey();
            if (TextUtils.equals(str2, "1")) {
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_D0.f());
                if (booleanValue) {
                    dpsParseBean.setParams(new byte[]{1, 0, b2});
                } else {
                    dpsParseBean.setParams(new byte[]{0, 0, b2});
                }
                return dpsParseBean;
            } else if (TextUtils.equals(str2, O0000Ooo)) {
                String valueOf = String.valueOf(entry.getValue());
                dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_E2.f());
                byte O0000O0o2 = O0000O0o(valueOf);
                if (O0000O0o2 != -1) {
                    dpsParseBean.setParams(new byte[]{10, O0000O0o2});
                }
            } else if (Integer.parseInt(str2) >= Integer.parseInt(O0000o0) && Integer.parseInt(str2) <= Integer.parseInt(O0000oOo)) {
                String valueOf2 = String.valueOf(entry.getValue());
                if (!TextUtils.isEmpty(valueOf2)) {
                    return O000000o(str2, valueOf2);
                }
            } else if (!TextUtils.equals(str2, O0000o00)) {
                return O000000o((LinkedHashMap<String, Object>) O00000o02);
            }
        }
        return dpsParseBean;
    }

    private DpsParseBean O000000o(String str, String str2) {
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_F2.f());
        byte[] bArr = new byte[10];
        if (str2.startsWith(oOO0O0O0.O0000oO0)) {
            bArr[0] = (byte) ((O0000OOo(str) << 3) & 255);
        } else if (str2.startsWith("1")) {
            bArr[0] = (byte) (((O0000OOo(str) << 3) & 255) + 1);
        }
        for (int i = 1; i <= str2.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str2.substring(i2 - 1, i2 + 1), 16);
        }
        StringBuilder n = a.n("parseCustomModeFromDp:");
        n.append(a.e.a.a.r.a.b(bArr));
        L.d(O000000o, n.toString());
        dpsParseBean.setParams(bArr);
        return dpsParseBean;
    }

    private DpsParseBean O000000o(LinkedHashMap<String, Object> linkedHashMap) {
        int O00000oo2;
        DpsParseBean dpsParseBean = new DpsParseBean();
        O000000o o000000o = new O000000o();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_E2.f());
        for (Map.Entry next : linkedHashMap.entrySet()) {
            String str = (String) next.getKey();
            if (TextUtils.equals(str, O00000o)) {
                o000000o.O0000o00 = ((Integer) next.getValue()).intValue();
                O00000oo2 = O000000o.O000000o();
            } else if (TextUtils.equals(str, "104")) {
                o000000o.O0000OoO = ((Integer) next.getValue()).intValue();
                O00000oo2 = O000000o.O00000Oo();
            } else if (TextUtils.equals(str, "105")) {
                o000000o.O0000Ooo = ((Integer) next.getValue()).intValue();
                O00000oo2 = O000000o.O00000o0();
            } else if (TextUtils.equals(str, "101")) {
                o000000o.O0000OOo = ((Integer) next.getValue()).intValue();
                O00000oo2 = O000000o.O00000o();
            } else if (TextUtils.equals(str, "102")) {
                o000000o.O0000Oo0 = ((Integer) next.getValue()).intValue();
                O00000oo2 = O000000o.O00000oO();
            } else {
                if (TextUtils.equals(str, "103")) {
                    o000000o.O0000Oo = ((Integer) next.getValue()).intValue();
                } else if (TextUtils.equals(str, "106")) {
                    o000000o.O0000o0 = ((Integer) next.getValue()).intValue();
                }
                O00000oo2 = O000000o.O00000oo();
            }
            o000000o.O000000o(O00000oo2);
        }
        dpsParseBean.setParams(o000000o.O0000OOo());
        return dpsParseBean;
    }

    private String O000000o(int i) {
        switch (i) {
            case 1:
                return "colour";
            case 2:
                return O0000ooO;
            case 3:
                return O0000ooo;
            case 4:
                return O00oOooO;
            case 5:
                return O00oOooo;
            case 6:
                return O000O00o;
            case 7:
                return O000O0OO;
            case 8:
                return O000O0Oo;
            case 9:
                return O00oOoOo;
            default:
                return "white";
        }
    }

    private String O000000o(String str, byte[] bArr, String str2) {
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, str2);
        if (subDevRespBean == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = (bArr[0] >> 3) & 255;
        if (i == 0 || i == 1) {
            byte[] bArr2 = new byte[8];
            System.arraycopy(bArr, 1, bArr2, 0, 8);
            return O000000o(str, bArr2, str2, i == 0 ? "white" : "colour");
        }
        sb.append((bArr[0] & 7) == 0 ? oOO0O0O0.O0000oO0 : "1");
        for (int i2 = 1; i2 < bArr.length; i2++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i2] & AVFrame.FRM_STATE_UNKOWN)}));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(O00000Oo(i), sb.toString());
        hashMap.put(O0000Ooo, O000000o(i));
        subDevRespBean.getDps().putAll(hashMap);
        String jSONString = new JSONObject((Map<String, Object>) hashMap).toJSONString();
        L.d(O000000o, "parseCustomModeToDp: " + jSONString + " nodeId: " + str2);
        O0000o.O000000o(str, str2, (String) null, -2, jSONString);
        return jSONString;
    }

    private String O000000o(String str, byte[] bArr, String str2, String str3) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        String str4 = str3;
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, str2);
        if (subDevRespBean == null) {
            return "";
        }
        byte b2 = bArr[0] & AVFrame.FRM_STATE_UNKOWN;
        byte b3 = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
        byte b4 = bArr[2] & AVFrame.FRM_STATE_UNKOWN;
        byte b5 = bArr[3] & AVFrame.FRM_STATE_UNKOWN;
        byte b6 = bArr[4] & AVFrame.FRM_STATE_UNKOWN;
        byte b7 = bArr[5] & AVFrame.FRM_STATE_UNKOWN;
        byte b8 = bArr[7] & AVFrame.FRM_STATE_UNKOWN;
        HashMap hashMap = new HashMap();
        DeviceRespBean deviceRespBean = subDevRespBean;
        byte b9 = b8;
        Object obj6 = "103";
        byte b10 = b4;
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(O0000Ooo, str4);
            if (str4.equals("white")) {
                hashMap.put("104", Integer.valueOf(b5));
                hashMap.put("105", Integer.valueOf(b6));
                hashMap.put(O00000o, Integer.valueOf(b7));
            } else if (str4.equals("colour")) {
                hashMap.put("101", Integer.valueOf(b2));
                hashMap.put("102", Integer.valueOf(b3));
                hashMap.put(obj6, Integer.valueOf(b10));
            }
        } else {
            Object obj7 = obj6;
            Object obj8 = "104";
            hashMap.put("1", b7 > 0 ? Boolean.TRUE : Boolean.FALSE);
            if (b9 % 2 != 0) {
                String str5 = str;
                Object obj9 = obj8;
                O0OO0O o0oo0o = new O0OO0O(str5);
                Object obj10 = "105";
                String str6 = str2;
                DeviceBean meshSubDevBeanByNodeId = new O0OO0O(str5).getMeshSubDevBeanByNodeId(str6);
                if (meshSubDevBeanByNodeId != null) {
                    obj5 = obj9;
                    DpsParseBean dpsParseBean = new DpsParseBean();
                    obj4 = obj10;
                    dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_EA.f());
                    dpsParseBean.setParams(new byte[]{Tnaf.POW_2_WIDTH, 1, -1});
                    o0oo0o.publishDps(meshSubDevBeanByNodeId.getCategory(), str6, dpsParseBean, (IResultCallback) new IResultCallback() {
                        public void onError(String str, String str2) {
                            L.e(OO000o0.O000000o, "send onError :" + str + DpTimerBean.FILL + str2);
                        }

                        public void onSuccess() {
                            L.e(OO000o0.O000000o, "send onSuccess");
                        }
                    });
                } else {
                    obj5 = obj9;
                    obj4 = obj10;
                }
                obj3 = obj4;
                obj = O00000o;
                obj2 = obj5;
            } else {
                obj3 = "105";
                obj2 = obj8;
                obj = O00000o;
                byte b11 = b9;
                if (b11 == (Integer.parseInt("11100000", 2) & AVFrame.FRM_STATE_UNKOWN)) {
                    hashMap.put(O0000Ooo, "colour");
                } else if ((b11 & 4) == 4) {
                    hashMap.put(O0000Ooo, "white");
                }
            }
            hashMap.put("101", Integer.valueOf(b2));
            hashMap.put("102", Integer.valueOf(b3));
            hashMap.put(obj7, Integer.valueOf(b10));
            hashMap.put(obj2, Integer.valueOf(b5));
            hashMap.put(obj3, Integer.valueOf(b6));
            hashMap.put(obj, Integer.valueOf(b7));
        }
        deviceRespBean.getDps().putAll(hashMap);
        String jSONString = JSON.toJSONString(hashMap);
        StringBuilder sb = new StringBuilder();
        sb.append("rgbwc: ");
        sb.append(jSONString);
        sb.append(" nodeId: ");
        String str7 = str2;
        sb.append(str7);
        L.d(O000000o, sb.toString());
        O0000o.O000000o(str, str7, (String) null, -2, jSONString);
        return jSONString;
    }

    private String O00000Oo(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                return O0000o0;
            case 3:
                return O0000o0O;
            case 4:
                return O0000o0o;
            case 5:
                return O0000o;
            case 6:
                return O0000oO0;
            case 7:
                return O0000oO;
            case 8:
                return O0000oOO;
            case 9:
                return O0000oOo;
            default:
                return "";
        }
    }

    private LinkedHashMap O00000o0(String str) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        if (linkedHashMap.containsKey(O0000Ooo) && (linkedHashMap.containsKey("101") || linkedHashMap.containsKey("102") || linkedHashMap.containsKey("103"))) {
            linkedHashMap.remove(O0000Ooo);
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0091 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte O0000O0o(java.lang.String r14) {
        /*
            r13 = this;
            int r0 = r14.hashCode()
            r1 = -1354842676(0xffffffffaf3ebdcc, float:-1.7347829E-10)
            r2 = 9
            r3 = 8
            r4 = 7
            r5 = 6
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            r12 = -1
            if (r0 == r1) goto L_0x007c
            r1 = 113101865(0x6bdcc29, float:7.1393885E-35)
            if (r0 == r1) goto L_0x0072
            switch(r0) {
                case 1914646846: goto L_0x0068;
                case 1914646847: goto L_0x005e;
                case 1914646848: goto L_0x0054;
                case 1914646849: goto L_0x004a;
                case 1914646850: goto L_0x0040;
                case 1914646851: goto L_0x0036;
                case 1914646852: goto L_0x002b;
                case 1914646853: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0086
        L_0x0020:
            java.lang.String r0 = "scene_8"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 9
            goto L_0x0087
        L_0x002b:
            java.lang.String r0 = "scene_7"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 8
            goto L_0x0087
        L_0x0036:
            java.lang.String r0 = "scene_6"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 7
            goto L_0x0087
        L_0x0040:
            java.lang.String r0 = "scene_5"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 6
            goto L_0x0087
        L_0x004a:
            java.lang.String r0 = "scene_4"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 5
            goto L_0x0087
        L_0x0054:
            java.lang.String r0 = "scene_3"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 4
            goto L_0x0087
        L_0x005e:
            java.lang.String r0 = "scene_2"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 3
            goto L_0x0087
        L_0x0068:
            java.lang.String r0 = "scene_1"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 2
            goto L_0x0087
        L_0x0072:
            java.lang.String r0 = "white"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 0
            goto L_0x0087
        L_0x007c:
            java.lang.String r0 = "colour"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x0086
            r14 = 1
            goto L_0x0087
        L_0x0086:
            r14 = -1
        L_0x0087:
            switch(r14) {
                case 0: goto L_0x0094;
                case 1: goto L_0x0093;
                case 2: goto L_0x0092;
                case 3: goto L_0x0091;
                case 4: goto L_0x0090;
                case 5: goto L_0x008f;
                case 6: goto L_0x008e;
                case 7: goto L_0x008d;
                case 8: goto L_0x008c;
                case 9: goto L_0x008b;
                default: goto L_0x008a;
            }
        L_0x008a:
            return r12
        L_0x008b:
            return r2
        L_0x008c:
            return r3
        L_0x008d:
            return r4
        L_0x008e:
            return r5
        L_0x008f:
            return r6
        L_0x0090:
            return r7
        L_0x0091:
            return r8
        L_0x0092:
            return r9
        L_0x0093:
            return r10
        L_0x0094:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.OO000o0.O0000O0o(java.lang.String):byte");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte O0000OOo(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.hashCode()
            r1 = 7
            r2 = 6
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = -1
            switch(r0) {
                case 48657: goto L_0x0055;
                case 48658: goto L_0x004b;
                case 48659: goto L_0x0041;
                case 48660: goto L_0x0037;
                case 48661: goto L_0x002d;
                case 48662: goto L_0x0023;
                case 48663: goto L_0x0019;
                case 48664: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x005f
        L_0x000f:
            java.lang.String r0 = "118"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 7
            goto L_0x0060
        L_0x0019:
            java.lang.String r0 = "117"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 6
            goto L_0x0060
        L_0x0023:
            java.lang.String r0 = "116"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 5
            goto L_0x0060
        L_0x002d:
            java.lang.String r0 = "115"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 4
            goto L_0x0060
        L_0x0037:
            java.lang.String r0 = "114"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 3
            goto L_0x0060
        L_0x0041:
            java.lang.String r0 = "113"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r0 = "112"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 1
            goto L_0x0060
        L_0x0055:
            java.lang.String r0 = "111"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x005f
            r9 = 0
            goto L_0x0060
        L_0x005f:
            r9 = -1
        L_0x0060:
            switch(r9) {
                case 0: goto L_0x006f;
                case 1: goto L_0x006e;
                case 2: goto L_0x006d;
                case 3: goto L_0x006c;
                case 4: goto L_0x006b;
                case 5: goto L_0x006a;
                case 6: goto L_0x0067;
                case 7: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            return r7
        L_0x0064:
            r9 = 9
            return r9
        L_0x0067:
            r9 = 8
            return r9
        L_0x006a:
            return r1
        L_0x006b:
            return r2
        L_0x006c:
            return r3
        L_0x006d:
            return r4
        L_0x006e:
            return r5
        L_0x006f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.OO000o0.O0000OOo(java.lang.String):byte");
    }

    public DpsParseBean O000000o(String str) {
        DpsParseBean O000000o2 = super.O000000o(str);
        return O000000o2 != null ? O000000o2 : O000000o(str, (byte) 0);
    }

    public String O000000o(String str, byte b2, byte[] bArr, String str2) {
        return b2 == b.BLE_GATT_OP_CTRL_DB.f() ? O000000o(str, bArr, str2, "") : b2 == b.BLE_GATT_OP_CTRL_EB.f() ? O000000o(str, bArr, str2) : "";
    }

    public String O000000o(String str, OO00O0o.O000000o o000000o, DeviceBean deviceBean) {
        Boolean bool;
        Map<String, Object> map;
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDevRespBean(str, deviceBean.getNodeId());
        int O00000Oo2 = o000000o.O00000Oo();
        HashMap hashMap = new HashMap();
        if (O00000Oo2 == 0) {
            hashMap.put("1", Boolean.FALSE);
            hashMap.put(O00000o, Integer.valueOf(O00000Oo2));
            map = subDevRespBean.getDps();
            bool = Boolean.FALSE;
        } else {
            hashMap.put("1", Boolean.TRUE);
            hashMap.put(O00000o, Integer.valueOf(O00000Oo2));
            map = subDevRespBean.getDps();
            bool = Boolean.TRUE;
        }
        map.put("1", bool);
        subDevRespBean.getDps().put(O00000o, Integer.valueOf(O00000Oo2));
        return JSON.toJSONString(hashMap);
    }

    public String[] O000000o() {
        return new String[]{"1", O00000o0, O00000o, "101", "102", "103", "104", "105", "106", O0000OoO, O0000Ooo, O0000o00, O0000o0, O0000o0O, O0000o0o, O0000o, O0000oO0, O0000oO, O0000oOO, O0000oOo};
    }

    public DpsParseBean O00000Oo(String str) {
        return O000000o(str, (byte) 1);
    }

    public DpsParseBean O00000o(String str) {
        if (Integer.parseInt(str) < Integer.parseInt(O0000o0) || Integer.parseInt(str) > Integer.parseInt(O0000oOo)) {
            return null;
        }
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_EA.f());
        dpsParseBean.setParams(new byte[]{Tnaf.POW_2_WIDTH, 1, O0000OOo(str)});
        return dpsParseBean;
    }

    public Object O00000oO(String str) {
        int i;
        LinkedHashMap O00000o02 = O00000o0(str);
        O000000o o000000o = new O000000o();
        for (Map.Entry entry : O00000o02.entrySet()) {
            String str2 = (String) entry.getKey();
            if (TextUtils.equals(str2, "1") || TextUtils.equals(str2, O0000Ooo)) {
                return str;
            }
            if (Integer.parseInt(str2) >= Integer.parseInt(O0000o0) && Integer.parseInt(str2) <= Integer.parseInt(O0000oOo)) {
                String valueOf = String.valueOf(entry.getValue());
                if (!TextUtils.isEmpty(valueOf)) {
                    return O000000o(str2, valueOf);
                }
            }
            if (TextUtils.equals(str2, O00000o)) {
                o000000o.O0000o00 = ((Integer) entry.getValue()).intValue();
                i = O000000o.O000000o();
            } else if (TextUtils.equals(str2, "104")) {
                o000000o.O0000OoO = ((Integer) entry.getValue()).intValue();
                i = O000000o.O00000Oo();
            } else if (TextUtils.equals(str2, "105")) {
                o000000o.O0000Ooo = ((Integer) entry.getValue()).intValue();
                i = O000000o.O00000o0();
            } else if (TextUtils.equals(str2, "101")) {
                o000000o.O0000OOo = ((Integer) entry.getValue()).intValue();
                i = O000000o.O00000o();
            } else if (TextUtils.equals(str2, "102")) {
                o000000o.O0000Oo0 = ((Integer) entry.getValue()).intValue();
                i = O000000o.O00000oO();
            } else {
                if (TextUtils.equals(str2, "103")) {
                    o000000o.O0000Oo = ((Integer) entry.getValue()).intValue();
                } else if (TextUtils.equals(str2, "106")) {
                    o000000o.O0000o0 = ((Integer) entry.getValue()).intValue();
                }
                i = O000000o.O00000oo();
            }
            o000000o.O000000o(i);
        }
        O00000o02.put(O0000OoO, Byte.valueOf(o000000o.O0000Oo0()));
        O00000o02.remove(O0000o00);
        JSONObject jSONObject = new JSONObject((Map<String, Object>) O00000o02);
        StringBuilder n = a.n("parseForWifi: ");
        n.append(jSONObject.toJSONString());
        L.d(O000000o, n.toString());
        return jSONObject.toJSONString();
    }
}
