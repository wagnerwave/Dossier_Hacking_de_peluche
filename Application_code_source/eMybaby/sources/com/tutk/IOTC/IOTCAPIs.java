package com.tutk.IOTC;

import a.a.a.a.a;
import java.io.PrintStream;

public class IOTCAPIs {
    public static final int API_ER_ANDROID_NULL = -10000;
    public static final int IOTC_ER_AES_CERTIFY_FAIL = -29;
    public static final int IOTC_ER_ALREADY_INITIALIZED = -3;
    public static final int IOTC_ER_CAN_NOT_FIND_DEVICE = -19;
    public static final int IOTC_ER_CH_NOT_ON = -26;
    public static final int IOTC_ER_CLIENT_NOT_SECURE_MODE = -34;
    public static final int IOTC_ER_CLIENT_SECURE_MODE = -35;
    public static final int IOTC_ER_CONNECT_IS_CALLING = -20;
    public static final int IOTC_ER_DEVICE_NOT_LISTENING = -24;
    public static final int IOTC_ER_DEVICE_NOT_SECURE_MODE = -36;
    public static final int IOTC_ER_DEVICE_SECURE_MODE = -37;
    public static final int IOTC_ER_EXCEED_MAX_SESSION = -18;
    public static final int IOTC_ER_EXIT_LISTEN = -39;
    public static final int IOTC_ER_FAIL_CONNECT_SEARCH = -27;
    public static final int IOTC_ER_FAIL_CREATE_MUTEX = -4;
    public static final int IOTC_ER_FAIL_CREATE_SOCKET = -6;
    public static final int IOTC_ER_FAIL_CREATE_THREAD = -5;
    public static final int IOTC_ER_FAIL_GET_LOCAL_IP = -16;
    public static final int IOTC_ER_FAIL_RESOLVE_HOSTNAME = -2;
    public static final int IOTC_ER_FAIL_SETUP_RELAY = -42;
    public static final int IOTC_ER_FAIL_SOCKET_BIND = -8;
    public static final int IOTC_ER_FAIL_SOCKET_OPT = -7;
    public static final int IOTC_ER_INVALID_MODE = -38;
    public static final int IOTC_ER_INVALID_SID = -14;
    public static final int IOTC_ER_LISTEN_ALREADY_CALLED = -17;
    public static final int IOTC_ER_LOGIN_ALREADY_CALLED = -11;
    public static final int IOTC_ER_MASTER_TOO_FEW = -28;
    public static final int IOTC_ER_NETWORK_UNREACHABLE = -41;
    public static final int IOTC_ER_NOT_INITIALIZED = -12;
    public static final int IOTC_ER_NOT_SUPPORT_RELAY = -43;
    public static final int IOTC_ER_NO_TCP_SUPPORT = -40;
    public static final int IOTC_ER_NoERROR = 0;
    public static final int IOTC_ER_REMOTE_TIMEOUT_DISCONNECT = -23;
    public static final int IOTC_ER_SERVER_NOT_RESPONSE = -1;
    public static final int IOTC_ER_SESSION_CLOSE_BY_REMOTE = -22;
    public static final int IOTC_ER_SESSION_NO_FREE_CHANNEL = -31;
    public static final int IOTC_ER_TCP_CONNECT_TO_SERVER_FAILED = -33;
    public static final int IOTC_ER_TCP_TRAVEL_FAILED = -32;
    public static final int IOTC_ER_TIMEOUT = -13;
    public static final int IOTC_ER_UNKNOWN_DEVICE = -15;
    public static final int IOTC_ER_UNLICENSE = -10;

    static {
        try {
            System.loadLibrary("IOTCAPIs");
        } catch (UnsatisfiedLinkError e2) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("loadLibrary(IOTCAPIs),");
            n.append(e2.getMessage());
            printStream.println(n.toString());
        }
    }

    public static native short AT(int i, long j);

    public static native int IOTC_Connect_ByName(String str, String str2);

    public static native int IOTC_Connect_ByName2(String str, String str2, String str3, int i);

    public static native int IOTC_Connect_ByUID(String str);

    public static native int IOTC_Connect_ByUID2(String str, String str2, int i);

    public static native void IOTC_Connect_Stop();

    public static native int IOTC_DeInitialize();

    public static native int IOTC_Device_Login(String str, String str2, String str3);

    public static native int IOTC_Get_Login_Info(long[] jArr);

    public static native int IOTC_Get_Nat_Type();

    public static native void IOTC_Get_Version(long[] jArr);

    public static native int IOTC_Initialize(int i, String str, String str2, String str3, String str4);

    public static native int IOTC_Initialize2(int i);

    public static native int IOTC_IsDeviceSecureMode(int i);

    public static native int IOTC_Listen(long j);

    public static native int IOTC_Listen2(long j, String str, int i);

    public static native int IOTC_Session_Channel_OFF(int i, int i2);

    public static native int IOTC_Session_Channel_ON(int i, int i2);

    public static native int IOTC_Session_Check(int i, St_SInfo st_SInfo);

    public static native void IOTC_Session_Close(int i);

    public static native int IOTC_Session_Get_Free_Channel(int i);

    public static native int IOTC_Session_Read(int i, byte[] bArr, int i2, int i3, int i4);

    public static native int IOTC_Session_Write(int i, byte[] bArr, int i2, int i3);

    public static native void IOTC_Set_Max_Session_Number(long j);

    public static native float PL(int i, int i2, long j);

    public static native long RT(int i, long j);

    public static native St_LanSearchResp[] SA(int[] iArr, long j);

    public static native int XD(String str, long j);
}
