package com.decoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class DecG726 {
    static {
        try {
            System.loadLibrary("G726Android");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(G726Android),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native int g726_dec_state_create(byte b2, byte b3);

    public static native void g726_dec_state_destroy();

    public static native int g726_decode(byte[] bArr, long j, byte[] bArr2, long[] jArr);
}
