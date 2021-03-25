package com.tuya.smart.common;

import a.e.a.a.r.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;

public class oooo0o00o implements O0Oo00, oooo0oo00 {
    public static final String O000000o = "SigMeshCommandCallBack";
    public static final long O00000oo = 5000;
    public static final int O0000O0o = 1001;
    public int O00000Oo;
    public IResultCallback O00000o;
    public int O00000o0;
    public Handler O00000oO = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1001) {
                if (oooo0o00o.this.O00000o != null) {
                    oooo0o00o.this.O00000o.onError(o00oo0o0o0.O0000o0o, "TIME_OUT");
                }
                oooo0o00o.this.O000000o();
            }
        }
    };

    public oooo0o00o(String str, int i, IResultCallback iResultCallback) {
        this.O00000Oo = a.c(str);
        this.O00000o0 = i;
        this.O00000o = iResultCallback;
        TuyaSdk.getEventBus().register(this);
        O00000Oo();
    }

    private void O00000Oo() {
        this.O00000oO.sendEmptyMessageDelayed(1001, 5000);
    }

    public void O000000o() {
        TuyaSdk.getEventBus().unregister(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00d6, code lost:
        if (r9 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0071, code lost:
        if (r9 != null) goto L_0x00d8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventMainThread(com.tuya.smart.common.oooo0oo0o r9) {
        /*
            r8 = this;
            com.tuya.smart.common.o000o0ooo0 r0 = r9.O000000o()
            boolean r1 = r0 instanceof com.tuya.smart.common.o000o0oo00
            r2 = 1001(0x3e9, float:1.403E-42)
            r3 = 65528(0xfff8, float:9.1824E-41)
            java.lang.String r4 = "  target address:"
            java.lang.String r5 = "  target code:"
            java.lang.String r6 = "SigMeshCommandCallBack"
            if (r1 == 0) goto L_0x0074
            com.tuya.smart.common.o000o0oo00 r0 = (com.tuya.smart.common.o000o0oo00) r0
            java.lang.String r1 = "receive GenericStatus callback code:"
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            com.tuya.smart.common.o000o0ooo0 r7 = r9.O000000o()
            int r7 = r7.O00000Oo()
            r1.append(r7)
            r1.append(r5)
            int r5 = r8.O00000o0
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.tuya.smart.android.common.utils.L.d(r6, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "receive GenericStatus callback address:"
            r1.append(r5)
            int r5 = r0.O0000oOO()
            r1.append(r5)
            r1.append(r4)
            int r4 = r8.O00000Oo
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.tuya.smart.android.common.utils.L.d(r6, r1)
            com.tuya.smart.common.o000o0ooo0 r9 = r9.O000000o()
            int r9 = r9.O00000Oo()
            int r1 = r8.O00000o0
            if (r9 != r1) goto L_0x00de
            int r9 = r0.O0000oOO()
            r9 = r9 & r3
            int r0 = r8.O00000Oo
            if (r9 != r0) goto L_0x00de
            android.os.Handler r9 = r8.O00000oO
            r9.removeMessages(r2)
            com.tuya.smart.sdk.api.IResultCallback r9 = r8.O00000o
            if (r9 == 0) goto L_0x00db
            goto L_0x00d8
        L_0x0074:
            boolean r1 = r0 instanceof com.tuya.sdk.sigmesh.transport.ConfigStatusMessage
            if (r1 == 0) goto L_0x00de
            com.tuya.sdk.sigmesh.transport.ConfigStatusMessage r0 = (com.tuya.sdk.sigmesh.transport.ConfigStatusMessage) r0
            java.lang.String r1 = "receive ConfigStatus callback code:"
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            com.tuya.smart.common.o000o0ooo0 r7 = r9.O000000o()
            int r7 = r7.O00000Oo()
            r1.append(r7)
            r1.append(r5)
            int r5 = r8.O00000o0
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.tuya.smart.android.common.utils.L.d(r6, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "receive ConfigStatus callback address:"
            r1.append(r5)
            int r5 = r0.O0000oOO()
            r1.append(r5)
            r1.append(r4)
            int r4 = r8.O00000Oo
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.tuya.smart.android.common.utils.L.d(r6, r1)
            com.tuya.smart.common.o000o0ooo0 r9 = r9.O000000o()
            int r9 = r9.O00000Oo()
            int r1 = r8.O00000o0
            if (r9 != r1) goto L_0x00de
            int r9 = r0.O0000oOO()
            r9 = r9 & r3
            int r0 = r8.O00000Oo
            if (r9 != r0) goto L_0x00de
            android.os.Handler r9 = r8.O00000oO
            r9.removeMessages(r2)
            com.tuya.smart.sdk.api.IResultCallback r9 = r8.O00000o
            if (r9 == 0) goto L_0x00db
        L_0x00d8:
            r9.onSuccess()
        L_0x00db:
            r8.O000000o()
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oooo0o00o.onEventMainThread(com.tuya.smart.common.oooo0oo0o):void");
    }
}
