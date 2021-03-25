package com.tuya.smart.common;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import a.e.a.a.o.j.i;
import a.e.a.a.r.b;
import a.j.a.a;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.sdk.tuyamesh.blemesh.action.LoginAction$2;
import com.tuya.sdk.tuyamesh.blemesh.action.LoginAction$3;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class o00o0oo00o extends o00o0o0o0o {
    public static final String O00000Oo = "LoginAction";
    public static final int O0000Oo0 = 34;
    public int O000000o = 3;
    public final byte[] O00000o;
    public final byte[] O00000o0;
    public O000000o O00000oO;
    public final byte[] O00000oo = new byte[8];
    public String O0000O0o;
    public Random O0000OOo = new SecureRandom();
    public Handler O0000Oo = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 34) {
                StringBuilder n = a.n("Retry login ");
                n.append(o00o0oo00o.this.O000000o);
                o00oo0oo00.O00000Oo(o00o0oo00o.O00000Oo, n.toString());
                o00o0oo00o o00o0oo00o = o00o0oo00o.this;
                int i = o00o0oo00o.O000000o;
                if (i > 0) {
                    o00o0oo00o.O000000o = i - 1;
                    o00o0oo00o.O000000o();
                    return;
                }
                o00o0oo00o.O000000o("13003", "login time out");
            }
        }
    };
    public e O0000OoO = new LoginAction$3(this);

    public interface O000000o {
        void O000000o(String str, String str2);

        void O000000o(byte[] bArr);
    }

    public o00o0oo00o(byte[] bArr, byte[] bArr2, O000000o o000000o) {
        this.O00000o0 = (byte[]) bArr.clone();
        this.O00000o = (byte[]) bArr2.clone();
        this.O00000oO = o000000o;
        this.O000000o = 3;
    }

    /* access modifiers changed from: private */
    public void O000000o(String str, String str2) {
        this.O0000Oo.removeMessages(34);
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O000000o(str, str2);
        }
    }

    private byte[] O000000o(byte[] bArr) {
        this.O0000OOo.nextBytes(bArr);
        return bArr;
    }

    public void O000000o() {
        if (!TextUtils.isEmpty(this.O0000O0o)) {
            O000000o(this.O0000O0o);
        } else {
            O000000o("13003", "reLogin Fail");
        }
    }

    public void O000000o(String str) {
        o00oo0oo00.O000000o(O00000Oo, "login " + str);
        this.O0000O0o = str;
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (this.O00000o0[i] ^ this.O00000o[i]);
        }
        byte[] O000000o2 = O000000o(this.O00000oo);
        byte[] bArr2 = new byte[16];
        System.arraycopy(O000000o2, 0, bArr2, 0, O000000o2.length);
        try {
            byte[] l = b.l(bArr2, bArr);
            a.j.a.a a2 = a.j.a.a.a();
            UUID b2 = a2.b(a.c.SERVICE);
            UUID b3 = a2.b(a.c.PAIR);
            byte[] bArr3 = new byte[17];
            bArr3[0] = a.j.a.b.BLE_GATT_OP_PAIR_ENC_REQ.f();
            System.arraycopy(O000000o2, 0, bArr3, 1, O000000o2.length);
            System.arraycopy(l, 8, bArr3, 9, 8);
            o00oo0o00o.O000000o(bArr3, 9, 16);
            CommandBean newInstance = CommandBean.newInstance();
            newInstance.type = CommandBean.CommandType.WRITE;
            newInstance.data = bArr3;
            newInstance.macAddress = str;
            newInstance.serviceUUID = b2;
            newInstance.characteristicUUID = b3;
            CommandBean newInstance2 = CommandBean.newInstance();
            newInstance2.type = CommandBean.CommandType.READ;
            newInstance2.serviceUUID = b2;
            newInstance2.macAddress = str;
            newInstance2.characteristicUUID = b3;
            O000000o(newInstance, (i) new LoginAction$2(this, newInstance2));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            O000000o("13003", e2.getMessage());
        }
    }

    public void O00000Oo() {
        this.O00000oO = null;
    }
}
