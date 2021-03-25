package com.encoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class EncG726 {
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

    public static native int g726_enc_state_create(byte b2, byte b3);

    public static native void g726_enc_state_destroy();

    public static native int g726_encode(byte[] bArr, long j, byte[] bArr2, long[] jArr);
}
