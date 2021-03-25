package com.tuya.smart.common;

import a.e.a.a.n.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class o00o000oo0 {
    public static final String O000000o = "TuyaOtaDataPacket";

    public static byte[] O000000o() {
        byte[] bArr = new byte[16];
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) random.nextInt(255);
        }
        return bArr;
    }

    public static byte[] O000000o(int i, int i2, int i3, byte[] bArr, int i4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(o00o0000oo.O00000o(i));
        arrayList.add(o00o0000oo.O00000o(i2));
        arrayList.add(o00o0000oo.O00000oO(i3));
        arrayList.add(o00o0000oo.O00000oO(i4));
        if (i4 != 0) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            arrayList.add(bArr);
        }
        byte[] O000000o2 = o00o0000oo.O000000o((List<byte[]>) arrayList);
        return o00o0000oo.O000000o(O000000o2, o00o0000oo.O0000oO0(O000000o2));
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            return O00000Oo(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return O000000o();
        }
    }

    public static byte[] O000000o(byte[] bArr, int i, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        if (i == 0) {
            byte[] bArr4 = new byte[(bArr3.length + 1)];
            bArr4[0] = (byte) i;
            System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
            return bArr4;
        }
        if (bArr2 == null) {
            bArr2 = O000000o();
        }
        int length = bArr3.length % 16;
        if (length != 0) {
            byte[] bArr5 = new byte[(16 - length)];
            Arrays.fill(bArr5, (byte) 0);
            bArr3 = o00o0000oo.O000000o(bArr3, bArr5);
        }
        byte[] O000000o2 = o00o0000oo.O000000o(bArr, bArr2, bArr3);
        if (O000000o2 == null) {
            O000000o2 = new byte[0];
        }
        byte[] bArr6 = new byte[(bArr2.length + O000000o2.length + 1)];
        bArr6[0] = (byte) i;
        System.arraycopy(bArr2, 0, bArr6, 1, bArr2.length);
        System.arraycopy(O000000o2, 0, bArr6, bArr2.length + 1, O000000o2.length);
        return bArr6;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new byte[]{0});
        arrayList.add(o00o0000oo.O00000o0(str));
        arrayList.add(bArr2);
        arrayList.add(bArr3);
        byte[] O00000o = o00o0000oo.O00000o(bArr.length);
        arrayList.add(O00000o);
        byte[] O00000o2 = o00o0000oo.O00000o(a.a(bArr));
        arrayList.add(O00000o2);
        StringBuilder n = a.a.a.a.a.n("md5:");
        n.append(o00o0000oo.O000000o(bArr3, false));
        o00oo0oo00.O000000o(O000000o, n.toString());
        o00oo0oo00.O000000o(O000000o, "fileLength:" + o00o0000oo.O000000o(O00000o, false));
        o00oo0oo00.O000000o(O000000o, "fileCrc32:" + o00o0000oo.O000000o(O00000o2, false));
        return o00o0000oo.O000000o((List<byte[]>) arrayList);
    }

    public static byte[] O00000Oo(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
