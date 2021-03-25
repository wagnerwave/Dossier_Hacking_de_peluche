package com.decoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class DecADPCM {
    static {
        try {
            System.loadLibrary("ADPCMAndroid");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(ADPCMAndroid),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native int Decode(byte[] bArr, int i, byte[] bArr2);

    public static native int ResetDecoder();
}
