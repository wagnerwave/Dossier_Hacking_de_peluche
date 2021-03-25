package com.decoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class DecH264 {
    static {
        try {
            System.loadLibrary("H264Android");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(H264Android),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native int DecoderNal(byte[] bArr, int i, int[] iArr, byte[] bArr2);

    public static native int InitDecoder();

    public static native int UninitDecoder();
}
