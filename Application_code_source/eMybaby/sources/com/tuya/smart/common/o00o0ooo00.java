package com.tuya.smart.common;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import a.e.a.a.o.j.i;
import a.e.a.a.r.b;
import a.j.a.a;
import android.os.Handler;
import android.os.Message;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.sdk.tuyamesh.blemesh.action.ResetMeshAction$2;
import com.tuya.sdk.tuyamesh.blemesh.action.ResetMeshAction$3;
import com.tuya.smart.common.o00o0o0o0o;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class o00o0ooo00 extends o00o0o0o0o {
    public static final int O000000o = 113;
    public static final String O00000o0 = "ResetMeshAction";
    public int O00000Oo = 3;
    public final byte[] O00000o;
    public final byte[] O00000oO;
    public final byte[] O00000oo;
    public o00o0o0o0o.O000000o O0000O0o;
    public byte[] O0000OOo;
    public Handler O0000Oo = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 113) {
                o00o0ooo00 o00o0ooo00 = o00o0ooo00.this;
                if (o00o0ooo00.O00000Oo > 0) {
                    StringBuilder n = a.n("Retry reset ");
                    n.append(o00o0ooo00.this.O00000Oo);
                    o00oo0oo00.O00000Oo(o00o0ooo00.O00000o0, n.toString());
                    o00o0ooo00 o00o0ooo002 = o00o0ooo00.this;
                    o00o0ooo002.O00000Oo--;
                    o00o0ooo002.O00000o0();
                    return;
                }
                o00o0ooo00.O000000o("13004", "set mesh failure");
            }
        }
    };
    public String O0000Oo0;
    public final e O0000OoO = new ResetMeshAction$3(this);

    public o00o0ooo00(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, o00o0o0o0o.O000000o o000000o) {
        this.O0000O0o = o000000o;
        this.O0000Oo0 = str;
        this.O00000o = (byte[]) bArr.clone();
        this.O00000oO = (byte[]) bArr2.clone();
        this.O0000OOo = (byte[]) bArr4.clone();
        if (bArr3 == null) {
            byte[] bArr5 = a.j.a.a.a().f3698b;
            bArr3 = bArr5 != null ? (byte[]) bArr5.clone() : null;
        }
        this.O00000oo = (byte[]) bArr3.clone();
        this.O00000Oo = 3;
    }

    /* access modifiers changed from: private */
    public void O000000o(String str, String str2) {
        this.O0000Oo.removeMessages(113);
        o00o0o0o0o.O000000o o000000o = this.O0000O0o;
        if (o000000o != null) {
            o000000o.O000000o(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public boolean O000000o(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr2[i] = (byte) ((this.O00000o[i] ^ this.O00000oO[i]) ^ this.O00000oo[i]);
            }
            byte[] O000000o2 = o00oo0o00o.O000000o(b.l(this.O0000OOo, bArr2));
            byte[] bArr3 = new byte[16];
            o00oo0oo00.O000000o(O00000o0, "checkResponseData data:" + bArr.length + " sk1:" + 16);
            System.arraycopy(bArr, 1, bArr3, 0, 16);
            return o00oo0o00o.O000000o(O000000o2, bArr3);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void O00000o() {
        o00o0o0o0o.O000000o o000000o = this.O0000O0o;
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public void O00000o0() {
        o00oo0oo00.O000000o(O00000o0, "reset check");
        this.O0000Oo.sendEmptyMessageDelayed(113, 2000);
        a.j.a.a a2 = a.j.a.a.a();
        CommandBean commandBean = new CommandBean(a2.b(a.c.SERVICE), a2.b(a.c.PAIR), CommandBean.CommandType.READ, (byte[]) null);
        commandBean.macAddress = this.O0000Oo0;
        O000000o(commandBean, this.O0000OoO);
    }

    public void O000000o() {
        try {
            byte[] l = b.l(this.O0000OOo, this.O00000o);
            byte[] l2 = b.l(this.O0000OOo, this.O00000oO);
            byte[] l3 = b.l(this.O0000OOo, this.O00000oo);
            o00oo0o00o.O000000o(l, 0, l.length - 1);
            o00oo0o00o.O000000o(l2, 0, l2.length - 1);
            o00oo0o00o.O000000o(l3, 0, l3.length - 1);
            byte[] bArr = new byte[17];
            bArr[0] = a.j.a.b.BLE_GATT_OP_PAIR_NETWORK_NAME.f();
            System.arraycopy(l, 0, bArr, 1, l.length);
            byte[] bArr2 = new byte[17];
            bArr2[0] = a.j.a.b.BLE_GATT_OP_PAIR_PASS.f();
            System.arraycopy(l2, 0, bArr2, 1, l2.length);
            byte[] bArr3 = new byte[17];
            bArr3[0] = a.j.a.b.BLE_GATT_OP_PAIR_LTK.f();
            System.arraycopy(l3, 0, bArr3, 1, l3.length);
            a.j.a.a a2 = a.j.a.a.a();
            UUID b2 = a2.b(a.c.SERVICE);
            UUID b3 = a2.b(a.c.PAIR);
            CommandBean commandBean = new CommandBean(b2, b3, CommandBean.CommandType.WRITE, bArr);
            commandBean.macAddress = this.O0000Oo0;
            CommandBean commandBean2 = new CommandBean(b2, b3, CommandBean.CommandType.WRITE, bArr2);
            commandBean2.macAddress = this.O0000Oo0;
            CommandBean commandBean3 = new CommandBean(b2, b3, CommandBean.CommandType.WRITE, bArr3);
            commandBean3.macAddress = this.O0000Oo0;
            O000000o(commandBean, (i) new ResetMeshAction$2(this, commandBean2, commandBean3));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            O000000o("13004", e2.getMessage());
        }
    }

    public void O00000Oo() {
        this.O0000O0o = null;
    }
}
