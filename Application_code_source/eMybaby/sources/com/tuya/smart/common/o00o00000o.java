package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.tuya.spongycastle.crypto.InvalidCipherTextException;
import com.tuya.spongycastle.crypto.engines.AESEngine;
import com.tuya.spongycastle.crypto.engines.AESLightEngine;
import com.tuya.spongycastle.crypto.macs.CMac;
import com.tuya.spongycastle.crypto.modes.CCMBlockCipher;
import com.tuya.spongycastle.crypto.params.AEADParameters;
import com.tuya.spongycastle.crypto.params.KeyParameter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.SecureRandom;

public class o00o00000o {
    public static final byte[] O000000o = "prck".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O00000Oo = "prsk".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O00000o = "prdk".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O00000o0 = "prsn".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O00000oO = {0};
    public static final byte[] O00000oo = "smk2".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O0000O0o = "smk3".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O0000OOo = "id64".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O0000Oo = "smk4".getBytes(Charset.forName("US-ASCII"));
    public static final int O0000Oo0 = 127;
    public static final byte[] O0000OoO = "id6".getBytes(Charset.forName("US-ASCII"));
    public static final int O0000Ooo = 63;
    public static final byte[] O0000o = "nkik".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O0000o0 = {0, 0, 0, 0, 0, 0, 0, 0};
    public static final byte[] O0000o00 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int O0000o0O = 16;
    public static final String O0000o0o = o00o00000o.class.getSimpleName();
    public static final byte[] O0000oO = "id128".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O0000oO0 = "nkbk".getBytes(Charset.forName("US-ASCII"));
    public static final byte[] O0000oOO = {0, 0, 0, 0, 0, 0};
    public static final int O0000oOo = 8;

    public static class O000000o implements Parcelable {
        public static final Parcelable.Creator<O000000o> CREATOR = new Parcelable.Creator<O000000o>() {
            /* renamed from: O000000o */
            public O000000o createFromParcel(Parcel parcel) {
                return new O000000o(parcel);
            }

            /* renamed from: O000000o */
            public O000000o[] newArray(int i) {
                return new O000000o[i];
            }
        };
        public byte O000000o;
        public byte[] O00000Oo;
        public byte[] O00000o0;

        public O000000o(byte b2, byte[] bArr, byte[] bArr2) {
            this.O000000o = b2;
            this.O00000Oo = bArr;
            this.O00000o0 = bArr2;
        }

        public O000000o(Parcel parcel) {
            this.O000000o = parcel.readByte();
            this.O00000Oo = parcel.createByteArray();
            this.O00000o0 = parcel.createByteArray();
        }

        public byte O000000o() {
            return this.O000000o;
        }

        public byte[] O00000Oo() {
            return this.O00000Oo;
        }

        public byte[] O00000o0() {
            return this.O00000o0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte(this.O000000o);
            parcel.writeByteArray(this.O00000Oo);
            parcel.writeByteArray(this.O00000o0);
        }
    }

    public static byte[] O000000o() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static byte[] O000000o(int i) {
        byte[] bArr = new byte[(i / 8)];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static byte[] O000000o(byte[] bArr) {
        return O000000o(bArr, O0000o00);
    }

    public static byte[] O000000o(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] O000000o2 = O000000o(bArr, bArr2, bArr3, bArr4);
        int length = bArr2.length + bArr3.length + bArr4.length;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.put(bArr2);
        allocate.put(bArr3);
        allocate.put(bArr4);
        ByteBuffer allocate2 = ByteBuffer.allocate(length + 1 + 8);
        allocate2.put((byte) i);
        allocate2.put(allocate.array());
        allocate2.put(O000000o2, 0, 8);
        return allocate2.array();
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[16];
        KeyParameter keyParameter = new KeyParameter(bArr2);
        CMac cMac = new CMac(new AESEngine());
        cMac.init(keyParameter);
        cMac.update(bArr, 0, bArr.length);
        cMac.doFinal(bArr3, 0);
        return bArr3;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[bArr.length];
        KeyParameter keyParameter = new KeyParameter(bArr2);
        CMac cMac = new CMac(new AESEngine());
        cMac.init(keyParameter);
        cMac.update(bArr, i, bArr.length);
        cMac.doFinal(bArr3, 0);
        return bArr3;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[33];
        ByteBuffer.allocate(41);
        CCMBlockCipher cCMBlockCipher = new CCMBlockCipher(new AESEngine());
        cCMBlockCipher.init(true, new AEADParameters(new KeyParameter(bArr2), 64, bArr3));
        cCMBlockCipher.processBytes(bArr, 0, bArr.length, bArr4, bArr.length);
        try {
            cCMBlockCipher.doFinal(bArr4, 0);
        } catch (InvalidCipherTextException e2) {
            e2.printStackTrace();
        }
        return bArr4;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        byte[] bArr4 = new byte[(bArr.length + i)];
        CCMBlockCipher cCMBlockCipher = new CCMBlockCipher(new AESEngine());
        cCMBlockCipher.init(true, new AEADParameters(new KeyParameter(bArr2), i * 8, bArr3));
        cCMBlockCipher.processBytes(bArr, 0, bArr.length, bArr4, bArr.length);
        try {
            cCMBlockCipher.doFinal(bArr4, 0);
            return bArr4;
        } catch (InvalidCipherTextException e2) {
            String str = O0000o0o;
            StringBuilder n = a.n("Error wile encrypting: ");
            n.append(e2.getMessage());
            Log.e(str, n.toString());
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr2.length + bArr3.length + bArr4.length);
        allocate.put(bArr2);
        allocate.put(bArr3);
        allocate.put(bArr4);
        return O000000o(allocate.array(), O00000oO(bArr));
    }

    public static int O00000Oo(int i) {
        return i == 0 ? 4 : 8;
    }

    public static O000000o O00000Oo(byte[] bArr, byte[] bArr2) {
        byte[] O000000o2 = O000000o(bArr, O000000o(O00000oo));
        ByteBuffer allocate = ByteBuffer.allocate(0 + bArr2.length + 1);
        allocate.put(new byte[0]);
        allocate.put(bArr2);
        allocate.put((byte) 1);
        byte[] O000000o3 = O000000o(allocate.array(), O000000o2);
        ByteBuffer allocate2 = ByteBuffer.allocate(O000000o3.length + bArr2.length + 1);
        allocate2.put(O000000o3);
        allocate2.put(bArr2);
        allocate2.put((byte) 2);
        byte[] O000000o4 = O000000o(allocate2.array(), O000000o2);
        ByteBuffer allocate3 = ByteBuffer.allocate(O000000o4.length + bArr2.length + 1);
        allocate3.put(O000000o4);
        allocate3.put(bArr2);
        allocate3.put((byte) 3);
        return new O000000o((byte) (O000000o3[15] & Byte.MAX_VALUE), O000000o4, O000000o(allocate3.array(), O000000o2));
    }

    public static byte[] O00000Oo() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        ByteBuffer order = ByteBuffer.allocate(O0000o0.length + 8).order(ByteOrder.BIG_ENDIAN);
        order.put(O0000o0);
        order.put(bArr);
        return bArr;
    }

    public static byte[] O00000Oo(byte[] bArr) {
        byte[] O000000o2 = O000000o(bArr, O000000o(O0000O0o));
        ByteBuffer allocate = ByteBuffer.allocate(O0000OOo.length + 1);
        allocate.put(O0000OOo);
        allocate.put((byte) 1);
        byte[] O000000o3 = O000000o(allocate.array(), O000000o2);
        byte[] bArr2 = new byte[8];
        System.arraycopy(O000000o3, O000000o3.length - 8, bArr2, 0, 8);
        return bArr2;
    }

    public static byte[] O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return O000000o(bArr3, O000000o(bArr, bArr2));
    }

    public static byte[] O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        byte[] bArr4 = new byte[(bArr.length - i)];
        CCMBlockCipher cCMBlockCipher = new CCMBlockCipher(new AESEngine());
        cCMBlockCipher.init(false, new AEADParameters(new KeyParameter(bArr2), i * 8, bArr3));
        cCMBlockCipher.processBytes(bArr, 0, bArr.length, bArr4, 0);
        cCMBlockCipher.doFinal(bArr4, 0);
        return bArr4;
    }

    public static String O00000o() {
        return o00o0000oo.O000000o(O000000o(), false);
    }

    public static byte[] O00000o(byte[] bArr) {
        byte[] O000000o2 = O000000o(O0000o);
        ByteBuffer allocate = ByteBuffer.allocate(O0000oO.length + 1);
        allocate.put(O0000oO);
        allocate.put((byte) 1);
        return O00000Oo(bArr, O000000o2, allocate.array());
    }

    public static byte[] O00000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        KeyParameter keyParameter = new KeyParameter(bArr2);
        AESLightEngine aESLightEngine = new AESLightEngine();
        aESLightEngine.init(false, keyParameter);
        aESLightEngine.processBlock(bArr, 0, bArr3, 0);
        return bArr3;
    }

    public static byte O00000o0(byte[] bArr) {
        byte[] O000000o2 = O000000o(bArr, O000000o(O0000Oo));
        ByteBuffer allocate = ByteBuffer.allocate(O0000OoO.length + 1);
        allocate.put(O0000OoO);
        allocate.put((byte) 1);
        return (byte) (O000000o(allocate.array(), O000000o2)[15] & 63);
    }

    public static int O00000o0(int i) {
        return i == 0 ? 4 : 8;
    }

    public static String O00000o0() {
        return o00o0000oo.O000000o(O000000o(), false);
    }

    public static byte[] O00000o0(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        KeyParameter keyParameter = new KeyParameter(bArr2);
        AESLightEngine aESLightEngine = new AESLightEngine();
        aESLightEngine.init(true, keyParameter);
        aESLightEngine.processBlock(bArr, 0, bArr3, 0);
        return bArr3;
    }

    public static byte[] O00000o0(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer order = ByteBuffer.allocate(O0000oOO.length + bArr2.length + bArr3.length).order(ByteOrder.BIG_ENDIAN);
        order.put(O0000oOO);
        order.put(bArr2);
        order.put(bArr3);
        byte[] O00000o02 = O00000o0(order.array(), bArr);
        ByteBuffer order2 = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        order2.put(O00000o02, 8, 8);
        return order2.array();
    }

    public static byte[] O00000oO(byte[] bArr) {
        byte[] O000000o2 = O000000o(O0000oO0);
        ByteBuffer allocate = ByteBuffer.allocate(O0000oO.length + 1);
        allocate.put(O0000oO);
        allocate.put((byte) 1);
        return O00000Oo(bArr, O000000o2, allocate.array());
    }
}
