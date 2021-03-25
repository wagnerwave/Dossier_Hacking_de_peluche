package com.tuya.smart.android.common.utils;

import com.tuya.smart.common.o00o0000o0;

public class Base64 {
    public static final int BASELENGTH = 255;
    public static final byte[] CHUNK_SEPARATOR = "\r\n".getBytes();
    public static final int CHUNK_SIZE = 76;
    public static final int EIGHTBIT = 8;
    public static final int FOURBYTE = 4;
    public static final int LOOKUPLENGTH = 64;
    public static final byte PAD = 61;
    public static final int SIGN = -128;
    public static final int SIXTEENBIT = 16;
    public static final int TWENTYFOURBITGROUP = 24;
    public static byte[] base64Alphabet = new byte[255];
    public static byte[] lookUpBase64Alphabet = new byte[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 255; i4++) {
            base64Alphabet[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            base64Alphabet[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            base64Alphabet[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            base64Alphabet[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = base64Alphabet;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            lookUpBase64Alphabet[i8] = (byte) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            lookUpBase64Alphabet[i] = (byte) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            lookUpBase64Alphabet[i2] = (byte) (i3 + 48);
            i2++;
            i3++;
        }
        byte[] bArr2 = lookUpBase64Alphabet;
        bArr2[62] = 43;
        bArr2[63] = 47;
    }

    public static synchronized byte[] decodeBase64(byte[] bArr) {
        synchronized (Base64.class) {
            byte[] discardNonBase64 = discardNonBase64(bArr);
            if (discardNonBase64.length == 0) {
                byte[] bArr2 = new byte[0];
                return bArr2;
            }
            int length = discardNonBase64.length / 4;
            int length2 = discardNonBase64.length;
            while (discardNonBase64[length2 - 1] == 61) {
                length2--;
                if (length2 == 0) {
                    byte[] bArr3 = new byte[0];
                    return bArr3;
                }
            }
            byte[] bArr4 = new byte[(length2 - length)];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 4;
                byte b2 = discardNonBase64[i3 + 2];
                byte b3 = discardNonBase64[i3 + 3];
                byte b4 = base64Alphabet[discardNonBase64[i3]];
                byte b5 = base64Alphabet[discardNonBase64[i3 + 1]];
                if (b2 != 61 && b3 != 61) {
                    byte b6 = base64Alphabet[b2];
                    byte b7 = base64Alphabet[b3];
                    bArr4[i] = (byte) ((b4 << 2) | (b5 >> 4));
                    bArr4[i + 1] = (byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15));
                    bArr4[i + 2] = (byte) ((b6 << 6) | b7);
                } else if (b2 == 61) {
                    bArr4[i] = (byte) ((b5 >> 4) | (b4 << 2));
                } else if (b3 == 61) {
                    byte b8 = base64Alphabet[b2];
                    bArr4[i] = (byte) ((b4 << 2) | (b5 >> 4));
                    bArr4[i + 1] = (byte) (((b5 & 15) << 4) | ((b8 >> 2) & 15));
                }
                i += 3;
            }
            return bArr4;
        }
    }

    public static byte[] discardNonBase64(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (isBase64(bArr[i2])) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public static byte[] discardWhitespace(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            if (!(b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32)) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        int i;
        byte[] bArr2 = bArr;
        int length = bArr2.length * 8;
        int i2 = length % 24;
        int i3 = length / 24;
        int i4 = i2 != 0 ? (i3 + 1) * 4 : i3 * 4;
        if (z) {
            i = CHUNK_SEPARATOR.length == 0 ? 0 : (int) Math.ceil((double) (((float) i4) / 76.0f));
            i4 += CHUNK_SEPARATOR.length * i;
        } else {
            i = 0;
        }
        byte[] bArr3 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 76;
        while (i5 < i3) {
            int i9 = i5 * 3;
            byte b2 = bArr2[i9];
            byte b3 = bArr2[i9 + 1];
            byte b4 = bArr2[i9 + 2];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            byte b7 = b2 & Byte.MIN_VALUE;
            int i10 = b2 >> 2;
            if (b7 != 0) {
                i10 ^= o00o0000o0.O00000Oo;
            }
            byte b8 = (byte) i10;
            byte b9 = b3 & Byte.MIN_VALUE;
            int i11 = b3 >> 4;
            if (b9 != 0) {
                i11 ^= 240;
            }
            byte b10 = (byte) i11;
            int i12 = b4 >> 6;
            if ((b4 & Byte.MIN_VALUE) != 0) {
                i12 ^= 252;
            }
            byte[] bArr4 = lookUpBase64Alphabet;
            bArr3[i6] = bArr4[b8];
            bArr3[i6 + 1] = bArr4[(b6 << 4) | b10];
            bArr3[i6 + 2] = bArr4[(b5 << 2) | ((byte) i12)];
            bArr3[i6 + 3] = bArr4[b4 & 63];
            i6 += 4;
            if (z && i6 == i8) {
                byte[] bArr5 = CHUNK_SEPARATOR;
                System.arraycopy(bArr5, 0, bArr3, i6, bArr5.length);
                i7++;
                byte[] bArr6 = CHUNK_SEPARATOR;
                i8 = (bArr6.length * i7) + ((i7 + 1) * 76);
                i6 += bArr6.length;
            }
            i5++;
        }
        int i13 = i5 * 3;
        if (i2 == 8) {
            byte b11 = bArr2[i13];
            byte b12 = (byte) (b11 & 3);
            byte b13 = b11 & Byte.MIN_VALUE;
            int i14 = b11 >> 2;
            if (b13 != 0) {
                i14 ^= o00o0000o0.O00000Oo;
            }
            byte[] bArr7 = lookUpBase64Alphabet;
            bArr3[i6] = bArr7[(byte) i14];
            bArr3[i6 + 1] = bArr7[b12 << 4];
            bArr3[i6 + 2] = PAD;
            bArr3[i6 + 3] = PAD;
        } else if (i2 == 16) {
            byte b14 = bArr2[i13];
            byte b15 = bArr2[i13 + 1];
            byte b16 = (byte) (b15 & 15);
            byte b17 = (byte) (b14 & 3);
            byte b18 = b14 & Byte.MIN_VALUE;
            int i15 = b14 >> 2;
            if (b18 != 0) {
                i15 ^= o00o0000o0.O00000Oo;
            }
            byte b19 = (byte) i15;
            byte b20 = b15 & Byte.MIN_VALUE;
            int i16 = b15 >> 4;
            if (b20 != 0) {
                i16 ^= 240;
            }
            byte[] bArr8 = lookUpBase64Alphabet;
            bArr3[i6] = bArr8[b19];
            bArr3[i6 + 1] = bArr8[((byte) i16) | (b17 << 4)];
            bArr3[i6 + 2] = bArr8[b16 << 2];
            bArr3[i6 + 3] = PAD;
        }
        if (z && i7 < i) {
            byte[] bArr9 = CHUNK_SEPARATOR;
            System.arraycopy(bArr9, 0, bArr3, i4 - bArr9.length, bArr9.length);
        }
        return bArr3;
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        if (r0 == 0) {
            return true;
        }
        for (byte isBase64 : discardWhitespace(bArr)) {
            if (!isBase64(isBase64)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBase64(byte b2) {
        return b2 == 61 || base64Alphabet[b2] != -1;
    }

    public byte[] decode(byte[] bArr) {
        return decodeBase64(bArr);
    }

    public byte[] encode(byte[] bArr) {
        return encodeBase64(bArr, false);
    }
}
