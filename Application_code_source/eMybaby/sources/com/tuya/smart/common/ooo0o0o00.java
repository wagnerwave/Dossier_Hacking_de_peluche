package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.util.List;

public class ooo0o0o00 extends ooo0oo000 {
    public static final String O00000oo = "ProxyCommandAction";
    public String O0000O0o;
    public o00o0o0o0o.O000000o O0000OOo;
    public o000oo0000 O0000Oo;
    public Message O0000Oo0;

    public ooo0o0o00() {
    }

    public ooo0o0o00(String str, o00o0o0o0o.O000000o o000000o, o000oo0000 o000oo0000) {
        this.O0000O0o = str;
        this.O0000OOo = o000000o;
        this.O0000Oo = o000oo0000;
    }

    public void O000000o(Message message) {
        this.O0000Oo0 = message;
    }

    public void O000000o(List<Integer> list) {
        StringBuilder n = a.n("executeResend size ");
        n.append(list.size());
        o00oo0oo00.O000000o(O00000oo, n.toString());
        if (this.O0000Oo0.getNetworkPdu().size() > 0 && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                int intValue = list.get(i).intValue();
                if (this.O0000Oo0.getNetworkPdu().get(intValue) != null) {
                    a.y(this.O0000Oo0.getNetworkPdu().get(intValue), false, a.o("Resending segment ", intValue, " : "), O00000oo);
                    O000000o(O00000Oo(this.O0000O0o, this.O0000Oo.O000000o(this.O0000Oo0, intValue).getNetworkPdu().get(intValue), CommandBean.CommandType.WRITE_NO_RESPONSE), oo0o0oooo.O000000o().O00000Oo(), (o00o0o0o0o.O000000o) null);
                }
            }
        }
    }

    public void O0000o() {
        if (this.O0000Oo0 != null) {
            oo0o0oooo.O000000o().O000000o(this);
            for (int i = 0; i < this.O0000Oo0.getNetworkPdu().size(); i++) {
                CommandBean O00000Oo = O00000Oo(this.O0000O0o, this.O0000Oo0.getNetworkPdu().get(i), CommandBean.CommandType.WRITE_NO_RESPONSE);
                a.y(this.O0000Oo0.getNetworkPdu().get(i), false, a.n("send:  "), "miio");
                o00o0o0o0o.O000000o o000000o = null;
                if (i == this.O0000Oo0.getNetworkPdu().size() - 1) {
                    o000000o = this.O0000OOo;
                }
                O000000o(O00000Oo, oo0o0oooo.O000000o().O00000Oo(), o000000o);
            }
        }
    }

    public Message O0000oO0() {
        return this.O0000Oo0;
    }
}
