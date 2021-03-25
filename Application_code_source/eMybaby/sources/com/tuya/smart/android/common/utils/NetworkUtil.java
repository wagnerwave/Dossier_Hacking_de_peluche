package com.tuya.smart.android.common.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import java.util.HashMap;

public class NetworkUtil {
    public static final int CHINA_MOBILE = 1;
    public static final int CHINA_TELECOM = 3;
    public static final int CHINA_UNICOM = 2;
    public static final String CONN_TYPE_GPRS = "gprs";
    public static final String CONN_TYPE_NONE = "none";
    public static final String CONN_TYPE_WIFI = "wifi";
    public static final int SIM_NO = -1;
    public static final int SIM_OK = 0;
    public static final int SIM_UNKNOW = -2;
    public static BroadcastReceiver connChangerRvr = null;
    public static boolean proxy = false;

    public interface ApnUriGetter {
        Uri[] getUriList();
    }

    public static class ConnectionChangeReceiver extends BroadcastReceiver {
        public ApnUriGetter uriGetter;

        public ConnectionChangeReceiver(ApnUriGetter apnUriGetter) {
            this.uriGetter = apnUriGetter;
        }

        public void onReceive(Context context, Intent intent) {
            Uri[] uriList = this.uriGetter.getUriList();
            HashMap<String, String> hashMap = null;
            for (int i = 0; i < uriList.length; i++) {
                if (uriList[i] != null) {
                    hashMap = NetworkUtil.getProxyInfo(context, uriList[i]);
                }
                if (hashMap != null) {
                    NetworkUtil.setProxy(hashMap.get("host"), hashMap.get("port"));
                    return;
                }
            }
        }
    }

    public static class DefaultApnUriGetter implements ApnUriGetter {
        public Uri[] getUriList() {
            return new Uri[]{Uri.parse("content://telephony/carriers/preferapn"), Uri.parse("content://telephony/carriers/current")};
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r3 = r3.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getNetConnType(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
            java.lang.String r0 = "none"
            if (r3 != 0) goto L_0x000d
            return r0
        L_0x000d:
            r1 = 1
            android.net.NetworkInfo r1 = r3.getNetworkInfo(r1)
            if (r1 == 0) goto L_0x001f
            android.net.NetworkInfo$State r1 = r1.getState()
            android.net.NetworkInfo$State r2 = android.net.NetworkInfo.State.CONNECTED
            if (r2 != r1) goto L_0x001f
            java.lang.String r3 = "wifi"
            return r3
        L_0x001f:
            r1 = 0
            android.net.NetworkInfo r3 = r3.getNetworkInfo(r1)
            if (r3 == 0) goto L_0x0031
            android.net.NetworkInfo$State r3 = r3.getState()
            android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTED
            if (r1 != r3) goto L_0x0031
            java.lang.String r3 = "gprs"
            return r3
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.common.utils.NetworkUtil.getNetConnType(android.content.Context):java.lang.String");
    }

    public static String getNetworkType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            return activeNetworkInfo.getTypeName() + " " + activeNetworkInfo.getSubtypeName() + extraInfo;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        if (r11 != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007e, code lost:
        if (r11 != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> getProxyInfo(android.content.Context r11, android.net.Uri r12) {
        /*
            java.lang.String r0 = "port"
            java.lang.String r1 = getNetworkType(r11)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            if (r1 != 0) goto L_0x000f
            return r3
        L_0x000f:
            java.lang.String r4 = "WIFI"
            boolean r4 = r1.contains(r4)
            if (r4 != 0) goto L_0x008c
            java.lang.String r4 = "MOBILE UMTS"
            int r4 = r1.compareToIgnoreCase(r4)
            if (r4 != 0) goto L_0x0021
            goto L_0x008c
        L_0x0021:
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r7 = 0
            java.lang.String r8 = "mcc ='460'"
            r9 = 0
            r10 = 0
            r6 = r12
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r11 == 0) goto L_0x0074
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x0072 }
            if (r12 == 0) goto L_0x0074
        L_0x0037:
            int r12 = r11.getCount()     // Catch:{ Exception -> 0x0072 }
            if (r12 <= 0) goto L_0x006b
            java.lang.String r12 = "host"
            java.lang.String r4 = "proxy"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x0072 }
            r2.put(r12, r4)     // Catch:{ Exception -> 0x0072 }
            int r12 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0072 }
            r2.put(r0, r12)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r12 = "apn"
            int r12 = r11.getColumnIndex(r12)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0072 }
            boolean r12 = r1.contains(r12)     // Catch:{ Exception -> 0x0072 }
            if (r12 == 0) goto L_0x006b
            r11.close()
            return r2
        L_0x006b:
            boolean r12 = r11.moveToNext()     // Catch:{ Exception -> 0x0072 }
            if (r12 != 0) goto L_0x0037
            goto L_0x0074
        L_0x0072:
            r12 = move-exception
            goto L_0x007b
        L_0x0074:
            if (r11 == 0) goto L_0x0083
            goto L_0x0080
        L_0x0077:
            r12 = move-exception
            goto L_0x0086
        L_0x0079:
            r12 = move-exception
            r11 = r3
        L_0x007b:
            r12.printStackTrace()     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0083
        L_0x0080:
            r11.close()
        L_0x0083:
            return r3
        L_0x0084:
            r12 = move-exception
            r3 = r11
        L_0x0086:
            if (r3 == 0) goto L_0x008b
            r3.close()
        L_0x008b:
            throw r12
        L_0x008c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.common.utils.NetworkUtil.getProxyInfo(android.content.Context, android.net.Uri):java.util.HashMap");
    }

    public static int getSimState(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        if (simState == 5) {
            return 0;
        }
        return simState == 1 ? -1 : -2;
    }

    public static boolean isNetworkAvailable(Context context) {
        return getNetworkType(context) != null;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static boolean networkUsable(Context context) {
        return !getNetConnType(context).equals(CONN_TYPE_NONE);
    }

    public static void setProxy(String str, String str2) {
        if (str == null || str.length() == 0) {
            System.getProperties().put("proxySet", "false");
            proxy = false;
            return;
        }
        proxy = true;
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("proxyHost", str);
        if (str2 == null || str2.length() <= 0) {
            System.getProperties().put("proxyPort", "80");
        } else {
            System.getProperties().put("proxyPort", str2);
        }
    }

    public static void supportWap(Context context) {
        supportWap(context, new DefaultApnUriGetter());
    }

    public static void supportWap(Context context, ApnUriGetter apnUriGetter) {
        Uri[] uriList = apnUriGetter.getUriList();
        HashMap<String, String> hashMap = null;
        int i = 0;
        while (true) {
            if (i >= uriList.length) {
                break;
            }
            if (uriList[i] != null) {
                hashMap = getProxyInfo(context, uriList[i]);
            }
            if (hashMap != null) {
                setProxy(hashMap.get("host"), hashMap.get("port"));
                break;
            }
            i++;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        ConnectionChangeReceiver connectionChangeReceiver = new ConnectionChangeReceiver(apnUriGetter);
        connChangerRvr = connectionChangeReceiver;
        context.registerReceiver(connectionChangeReceiver, intentFilter);
    }

    public static void unRegNetWorkRev(Context context) {
        setProxy((String) null, (String) null);
        try {
            if (connChangerRvr != null) {
                context.unregisterReceiver(connChangerRvr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
