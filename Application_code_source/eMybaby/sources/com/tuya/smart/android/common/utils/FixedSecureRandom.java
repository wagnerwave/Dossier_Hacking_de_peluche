package com.tuya.smart.android.common.utils;

import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom {
    public static final long serialVersionUID = -144076469992183815L;
    public byte[] seed = {-86, -3, 18, -10, 89, -54, -26, 52, -119, -76, 121, -27, 7, 109, -34, -62, -16, 108, -75, -113};

    public void nextBytes(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = this.seed;
            if (bArr2.length + i < bArr.length) {
                System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
                i += this.seed.length;
            } else {
                System.arraycopy(bArr2, 0, bArr, i, bArr.length - i);
                return;
            }
        }
    }
}
