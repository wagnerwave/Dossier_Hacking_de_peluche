package com.decoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class DecSpeex {
    static {
        try {
            System.loadLibrary("SpeexAndroid");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(SpeexAndroid),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native int Decode(byte[] bArr, int i, short[] sArr);

    public static native int InitDecoder(int i);

    public static native int UninitDecoder();
}
