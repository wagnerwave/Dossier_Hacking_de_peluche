package com.tuya.sdk.sweeper.utils;

import android.os.Handler;
import com.tuya.smart.android.common.task.TuyaExecutor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TuyaRequestCloudTools {
    public static final String TAG = "TuyaRequestCloudTools";
    public Handler mHandler = new Handler();

    public interface ByteArrayCallback {
        void onFailure(int i, String str);

        void onSuccess(byte[] bArr);
    }

    /* access modifiers changed from: private */
    public byte[] inputStream2ByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        inputStream.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return byteArray;
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                try {
                    inputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void postFailed(final ByteArrayCallback byteArrayCallback, final int i, final String str) {
        if (byteArrayCallback != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    byteArrayCallback.onFailure(i, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void postSuccessByte(final ByteArrayCallback byteArrayCallback, final byte[] bArr) {
        if (byteArrayCallback != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    byteArrayCallback.onSuccess(bArr);
                }
            });
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void requestCloudBytes(final String str, final ByteArrayCallback byteArrayCallback) {
        TuyaExecutor.getInstance().submitCallerRunsPolicy(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
            /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    r0 = 0
                    java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0068, all -> 0x0063 }
                    java.lang.String r2 = r3     // Catch:{ Exception -> 0x0068, all -> 0x0063 }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x0068, all -> 0x0063 }
                    java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0068, all -> 0x0063 }
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0068, all -> 0x0063 }
                    java.lang.String r0 = "GET"
                    r1.setRequestMethod(r0)     // Catch:{ Exception -> 0x0061 }
                    r0 = 5000(0x1388, float:7.006E-42)
                    r1.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0061 }
                    r1.setReadTimeout(r0)     // Catch:{ Exception -> 0x0061 }
                    r0 = 0
                    r1.setUseCaches(r0)     // Catch:{ Exception -> 0x0061 }
                    r1.connect()     // Catch:{ Exception -> 0x0061 }
                    int r0 = r1.getResponseCode()     // Catch:{ Exception -> 0x0061 }
                    r2 = 200(0xc8, float:2.8E-43)
                    if (r0 != r2) goto L_0x004a
                    java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x0061 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools r2 = com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools.this     // Catch:{ Exception -> 0x0061 }
                    byte[] r0 = r2.inputStream2ByteArray(r0)     // Catch:{ Exception -> 0x0061 }
                    if (r0 == 0) goto L_0x003e
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools r2 = com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools.this     // Catch:{ Exception -> 0x0061 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools$ByteArrayCallback r3 = r4     // Catch:{ Exception -> 0x0061 }
                    r2.postSuccessByte(r3, r0)     // Catch:{ Exception -> 0x0061 }
                    goto L_0x007e
                L_0x003e:
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools r0 = com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools.this     // Catch:{ Exception -> 0x0061 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools$ByteArrayCallback r2 = r4     // Catch:{ Exception -> 0x0061 }
                    r3 = -1000(0xfffffffffffffc18, float:NaN)
                    java.lang.String r4 = "bytes empty"
                    r0.postFailed(r2, r3, r4)     // Catch:{ Exception -> 0x0061 }
                    goto L_0x007e
                L_0x004a:
                    java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0061 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools r3 = com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools.this     // Catch:{ Exception -> 0x0061 }
                    java.io.InputStream r4 = r1.getErrorStream()     // Catch:{ Exception -> 0x0061 }
                    byte[] r3 = r3.inputStream2ByteArray(r4)     // Catch:{ Exception -> 0x0061 }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x0061 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools r3 = com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools.this     // Catch:{ Exception -> 0x0061 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools$ByteArrayCallback r4 = r4     // Catch:{ Exception -> 0x0061 }
                    r3.postFailed(r4, r0, r2)     // Catch:{ Exception -> 0x0061 }
                    goto L_0x007e
                L_0x0061:
                    r0 = move-exception
                    goto L_0x006c
                L_0x0063:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                    goto L_0x0083
                L_0x0068:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                L_0x006c:
                    r0.printStackTrace()     // Catch:{ all -> 0x0082 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools r2 = com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools.this     // Catch:{ all -> 0x0082 }
                    com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools$ByteArrayCallback r3 = r4     // Catch:{ all -> 0x0082 }
                    r4 = -1001(0xfffffffffffffc17, float:NaN)
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0082 }
                    r2.postFailed(r3, r4, r0)     // Catch:{ all -> 0x0082 }
                    if (r1 == 0) goto L_0x0081
                L_0x007e:
                    r1.disconnect()
                L_0x0081:
                    return
                L_0x0082:
                    r0 = move-exception
                L_0x0083:
                    if (r1 == 0) goto L_0x0088
                    r1.disconnect()
                L_0x0088:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools.AnonymousClass1.run():void");
            }
        });
    }
}
