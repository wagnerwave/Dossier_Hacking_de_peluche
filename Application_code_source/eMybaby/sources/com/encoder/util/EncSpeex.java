package com.encoder.util;

import a.a.a.a.a;
import java.io.PrintStream;

public class EncSpeex {
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

    public static native int Encode(short[] sArr, int i, byte[] bArr);

    public static native int InitEncoder(int i);

    public static native int UninitEncoder();
}
