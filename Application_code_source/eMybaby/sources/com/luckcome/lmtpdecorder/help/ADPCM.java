package com.luckcome.lmtpdecorder.help;

public class ADPCM {
    static {
        System.loadLibrary("ADPCM");
    }

    public static native int decodeAdpcm(short[] sArr, int i, byte[] bArr, int i2, int i3, byte b2, byte b3, byte b4);

    public static native int decodeAdpcmFor10Or12Bit(short[] sArr, int i, byte[] bArr, int i2, int i3, byte b2, byte b3, byte b4, byte b5);
}
