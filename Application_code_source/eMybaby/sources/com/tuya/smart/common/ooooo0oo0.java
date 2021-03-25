package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.util.Log;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.control.TransportControlMessage;
import com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException;
import java.util.List;

public class ooooo0oo0 {
    public static final String O000000o = "SigMeshNotifyParseModel";
    public final o000oo0000 O00000Oo;
    public Context O00000o0;

    /* renamed from: com.tuya.smart.common.ooooo0oo0$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] O000000o;

        static {
            int[] iArr = new int[TransportControlMessage.TransportControlMessageState.values().length];
            O000000o = iArr;
            try {
                TransportControlMessage.TransportControlMessageState transportControlMessageState = TransportControlMessage.TransportControlMessageState.LOWER_TRANSPORT_BLOCK_ACKNOWLEDGEMENT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ooooo0oo0(Context context, o000oo0000 o000oo0000) {
        this.O00000o0 = context;
        this.O00000Oo = o000oo0000;
    }

    public Message O000000o(byte[] bArr) {
        try {
            return this.O00000Oo.O00000o(bArr);
        } catch (ExtendedInvalidCipherTextException e2) {
            StringBuilder n = a.n("Decryption failed in ");
            n.append(e2.getTag());
            n.append(" : ");
            n.append(e2.getMessage());
            Log.e(O000000o, n.toString());
            return null;
        }
    }

    public o000o0ooo0 O000000o(AccessMessage accessMessage) {
        String str;
        o000o00ooo o000o00ooo;
        int i = (accessMessage.getAccessPdu()[0] & 240) >> 6;
        if (i != 2) {
            if (i == 3) {
                if ((oo0o0oooo.O000000o().O0000O0o() instanceof ooo00o0o0) || (oo0o0oooo.O000000o().O0000O0o() instanceof ooo00o0oo)) {
                    o000o0000o o000o0000o = new o000o0000o(accessMessage, ((oooo00000) oo0o0oooo.O000000o().O0000O0o()).O0000OoO());
                    o00oo0oo00.O00000Oo(O000000o, "vendor model message success");
                    return o000o0000o;
                }
                o000o00ooo o000o00ooo2 = new o000o00ooo(accessMessage, oooooo000.O0000Oo0);
                str = "Tuya vendor message success";
                o000o00ooo = o000o00ooo2;
            }
            return null;
        } else if (accessMessage.getOpCode() == 32842) {
            o0000o000o o0000o000o = new o0000o000o(accessMessage);
            str = "reset success";
            o000o00ooo = o0000o000o;
        } else if (accessMessage.getOpCode() == 33284) {
            o0000o00o0 o0000o00o0 = new o0000o00o0(accessMessage);
            StringBuilder n = a.n("on/off success parent:");
            n.append(o0000o00o0.q_());
            n.append("  target:");
            n.append(o0000o00o0.r_());
            str = n.toString();
            o000o00ooo = o0000o00o0;
        } else if (accessMessage.getOpCode() == 32830) {
            o00000o0o0 o00000o0o0 = new o00000o0o0(accessMessage);
            if (o00000o0o0.O00000oo()) {
                str = "app bind success";
                o000o00ooo = o00000o0o0;
            } else {
                str = "app bind fail";
                o000o00ooo = o00000o0o0;
            }
        } else if (accessMessage.getOpCode() == 32799) {
            o00000ooo0 o00000ooo0 = new o00000ooo0(accessMessage);
            if (o00000ooo0.O00000oo()) {
                str = "subscription success";
                o000o00ooo = o00000ooo0;
            } else {
                str = "subscription fail";
                o000o00ooo = o00000ooo0;
            }
        } else if (accessMessage.getOpCode() == 33358) {
            o000o00000 o000o00000 = new o000o00000(accessMessage);
            str = "lightness success";
            o000o00ooo = o000o00000;
        } else if (accessMessage.getOpCode() == 33382) {
            o0000oooo0 o0000oooo0 = new o0000oooo0(accessMessage);
            str = "ctl temperature success";
            o000o00ooo = o0000oooo0;
        } else if (accessMessage.getOpCode() == 33376) {
            o0000ooo0o o0000ooo0o = new o0000ooo0o(accessMessage);
            str = "ctl success";
            o000o00ooo = o0000ooo0o;
        } else {
            if (accessMessage.getOpCode() == 33400) {
                o0000ooooo o0000ooooo = new o0000ooooo(accessMessage);
                str = "hsl success";
                o000o00ooo = o0000ooooo;
            }
            return null;
        }
        o00oo0oo00.O00000Oo(O000000o, str);
        return o000o00ooo;
    }

    public o000oo0000 O000000o() {
        return this.O00000Oo;
    }

    public void O000000o(ControlMessage controlMessage, ooo0o0o00 ooo0o0o00) {
        if (ooo0o0o00 != null && controlMessage != null) {
            int size = ooo0o0o00.O0000oO0().getNetworkPdu().size();
            if (controlMessage.getPduType() == 0) {
                if (AnonymousClass1.O000000o[controlMessage.getTransportControlMessage().O000000o().ordinal()] != 1) {
                    o00oo0oo00.O000000o(O000000o, "Unexpected control message received, ignoring message");
                    return;
                }
                StringBuilder n = a.n("Acknowledgement payload: ");
                n.append(o00o0000oo.O000000o(controlMessage.getTransportControlPdu(), false));
                o00oo0oo00.O000000o(O000000o, n.toString());
                ooo0o0o00.O000000o((List<Integer>) oooo0o0oo.O000000o(controlMessage.getTransportControlPdu(), size));
                return;
            }
            controlMessage.getPduType();
        }
    }
}
