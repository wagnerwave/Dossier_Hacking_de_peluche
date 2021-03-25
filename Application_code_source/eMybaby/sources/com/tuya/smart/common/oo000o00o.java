package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;

public class oo000o00o implements o0oooo00o {
    public static final String O000000o = "TuyaMessageManager";
    public final o0oooo0oo O00000Oo;

    public oo000o00o(o0oooo0oo o0oooo0oo) {
        this.O00000Oo = o0oooo0oo;
    }

    private void O000000o(int i, String str, JSONObject jSONObject, o0ooooo00 o0ooooo00) {
        StringBuilder n = a.n("dealWithDeviceTopicSigned obj=");
        n.append(jSONObject.toString());
        n.append("---topicId=");
        n.append(str);
        L.d(O000000o, n.toString());
        String string = jSONObject.getString("sign");
        String O000000o2 = this.O00000Oo.O00000oO().O000000o(str);
        if (TextUtils.isEmpty(O000000o2)) {
            o0ooooo00.O000000o(o0oooooo0.O0000o0, "localKey == null");
        } else if (!TextUtils.equals(o0ooo00oo.O000000o(jSONObject, O000000o2).toLowerCase(), string.toLowerCase())) {
            o0ooooo00.O000000o("11004", "sign is not equals");
        } else {
            JSONObject parseObject = JSON.parseObject(o0ooo0o00.O000000o(jSONObject.getString("data"), O000000o2));
            jSONObject.remove("data");
            jSONObject.put("data", (Object) parseObject);
            o0ooooo00.O000000o(i, jSONObject);
        }
    }

    private void O000000o(String str, JSONObject jSONObject, o0ooooo00 o0ooooo00) {
        StringBuilder n = a.n("dealWithMqttArrivedTopic obj=");
        n.append(jSONObject.toString());
        n.append("---topic=");
        n.append(str);
        L.d(O000000o, n.toString());
        if (str.startsWith("smart/mb/in/")) {
            O00000Oo(str, jSONObject, o0ooooo00);
        } else {
            o0ooooo00.O000000o(jSONObject.getIntValue(o0ooo00oo.O00000o), jSONObject);
        }
    }

    private void O00000Oo(String str, JSONObject jSONObject, o0ooooo00 o0ooooo00) {
        StringBuilder n = a.n("dealWithDeviceTopic obj=");
        n.append(jSONObject.toString());
        n.append("---topicId=");
        n.append(str);
        L.d(O000000o, n.toString());
        int intValue = jSONObject.getIntValue(o0ooo00oo.O00000o);
        if (intValue == 16 || !TextUtils.equals(jSONObject.getString(o0ooo00oo.O00000oO), "2.0")) {
            o0ooooo00.O000000o(intValue, jSONObject);
        } else {
            O000000o(intValue, str, jSONObject, o0ooooo00);
        }
    }

    public void O000000o(o0ooooo00 o0ooooo00) {
        if (this.O00000Oo.O00000Oo() != null) {
            byte[] bArr = new byte[3];
            System.arraycopy(this.O00000Oo.O00000Oo(), 0, bArr, 0, 3);
            String str = new String(bArr);
            L.d(O000000o, "msgProtocol " + str);
            if (!str.startsWith("{")) {
                String O000000o2 = this.O00000Oo.O000000o();
                a.v("topic: ", O000000o2, O000000o);
                String O000000o3 = this.O00000Oo.O00000oO().O000000o(O000000o2);
                if (!TextUtils.isEmpty(O000000o3)) {
                    for (String str2 : this.O00000Oo.O00000oo()) {
                        if (O000000o2.startsWith(str2)) {
                            O000000o2 = O000000o2.replace(str2, "");
                            o0oooo0oo o0oooo0oo = this.O00000Oo;
                            o0oooo0oo.O000000o = O000000o3;
                            o0oooo0oo.O000000o(str);
                            if (TextUtils.isEmpty(O000000o3)) {
                                o0ooooo00.O000000o(o0oooooo0.O0000o0, "localkey ==null");
                            }
                            if (TuyaUtil.checkPvVersion(this.O00000Oo.O00000o0(), 2.2f)) {
                                L.d(O000000o, "pv_2_2");
                                new oo000o000(this.O00000Oo).O000000o(o0ooooo00);
                            } else if (TuyaUtil.checkPvVersion(this.O00000Oo.O00000o0(), 2.1f)) {
                                L.d(O000000o, "pv_2_1");
                                new oo0000ooo(this.O00000Oo).O000000o(o0ooooo00);
                            } else if (TuyaUtil.checkPvVersion(this.O00000Oo.O00000o0(), 1.1f)) {
                                L.d(O000000o, "pv_1_1");
                                new oo0000oo0(this.O00000Oo).O000000o(o0ooooo00);
                            } else {
                                StringBuilder n = a.n("pv：");
                                n.append(this.O00000Oo.O00000o0());
                                n.append(" support min：");
                                n.append(1.1f);
                                L.d(O000000o, n.toString());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            O000000o(this.O00000Oo.O000000o(), JSON.parseObject(new String(this.O00000Oo.O00000Oo())), o0ooooo00);
        }
    }
}
