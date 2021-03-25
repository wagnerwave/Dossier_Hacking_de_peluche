package com.decoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class DecMp3 {
    static {
        try {
            System.loadLibrary("Mp3Android");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(Mp3Android),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native int Decode(byte[] bArr, int i, byte[] bArr2);

    public static native int InitDecoder(int i, int i2);

    public static native int UninitDecoder();
}
