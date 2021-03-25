package com.tutk.IOTC;

import a.a.a.a.a;
import java.io.PrintStream;

public class AVAPIs {
    public static final int API_ER_ANDROID_NULL = -10000;
    public static final int AV_ER_BUFPARA_MAXSIZE_INSUFF = -20001;
    public static final int AV_ER_CLIENT_EXIT = -20018;
    public static final int AV_ER_CLIENT_NOT_SUPPORT = -20020;
    public static final int AV_ER_CLIENT_NO_AVLOGIN = -20008;
    public static final int AV_ER_DATA_NOREADY = -20012;
    public static final int AV_ER_EXCEED_MAX_ALARM = -20005;
    public static final int AV_ER_EXCEED_MAX_CHANNEL = -20002;
    public static final int AV_ER_EXCEED_MAX_SIZE = -20006;
    public static final int AV_ER_FAIL_CREATE_THREAD = -20004;
    public static final int AV_ER_INCOMPLETE_FRAME = -20013;
    public static final int AV_ER_INVALID_ARG = -20000;
    public static final int AV_ER_INVALID_SID = -20010;
    public static final int AV_ER_LOSED_THIS_FRAME = -20014;
    public static final int AV_ER_MEM_INSUFF = -20003;
    public static final int AV_ER_NOT_INITIALIZED = -20019;
    public static final int AV_ER_NoERROR = 0;
    public static final int AV_ER_REMOTE_TIMEOUT_DISCONNECT = -20016;
    public static final int AV_ER_SENDIOCTRL_ALREADY_CALLED = -20021;
    public static final int AV_ER_SENDIOCTRL_EXIT = -20022;
    public static final int AV_ER_SERVER_EXIT = -20017;
    public static final int AV_ER_SERV_NO_RESPONSE = -20007;
    public static final int AV_ER_SESSION_CLOSE_BY_REMOTE = -20015;
    public static final int AV_ER_TIMEOUT = -20011;
    public static final int AV_ER_WRONG_VIEWACCorPWD = -20009;
    public static final int IOTYPE_INNER_SND_DATA_DELAY = 255;
    public static final int TIME_DELAY_DELTA = 1;
    public static final int TIME_DELAY_INITIAL = 0;
    public static final int TIME_DELAY_MAX = 500;
    public static final int TIME_DELAY_MIN = 4;
    public static final int TIME_SPAN_LOSED = 1000;

    static {
        try {
            System.loadLibrary("AVAPIs");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(AVAPIs),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native int avCheckAudioBuf(int i);

    public static native int avClientCleanBuf(int i);

    public static native void avClientExit(int i, int i2);

    public static native void avClientSetMaxBufSize(int i);

    public static native int avClientStart(int i, String str, String str2, long j, long[] jArr, int i2);

    public static native int avClientStart2(int i, String str, String str2, int i2, int[] iArr, int i3, int[] iArr2);

    public static native void avClientStop(int i);

    public static native int avDeInitialize();

    public static native int avGetAVApiVer();

    public static native int avInitialize(int i);

    public static native int avRecvAudioData(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int[] iArr);

    public static native int avRecvFrameData(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int[] iArr);

    public static native int avRecvFrameData2(int i, byte[] bArr, int i2, int[] iArr, int[] iArr2, byte[] bArr2, int i3, int[] iArr3, int[] iArr4);

    public static native int avRecvIOCtrl(int i, int[] iArr, byte[] bArr, int i2, int i3);

    public static native int avSendAudioData(int i, byte[] bArr, int i2, byte[] bArr2, int i3);

    public static native int avSendFrameData(int i, byte[] bArr, int i2, byte[] bArr2, int i3);

    public static native int avSendIOCtrl(int i, int i2, byte[] bArr, int i3);

    public static native int avSendIOCtrlExit(int i);

    public static native void avServExit(int i, int i2);

    public static native int avServStart(int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4);

    public static native void avServStop(int i);
}
