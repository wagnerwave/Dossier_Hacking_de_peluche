package com.decoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class DecMpeg4 {
    static {
        try {
            System.loadLibrary("FFmpeg");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(FFmpeg),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native int Decode(byte[] bArr, int i, byte[] bArr2, int[] iArr, int[] iArr2, int[] iArr3);

    public static native int InitDecoder(int i, int i2);

    public static native int UninitDecoder();
}
