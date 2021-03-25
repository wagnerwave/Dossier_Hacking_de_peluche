package com.tuya.smart.android.device.utils;

import a.a.a.a.a;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WiFiUtil {
    public static final String TAG = "WifiUtils";
    public static final int WIFICIPHER_NOPASS = 0;
    public static final int WIFICIPHER_WEP = 1;
    public static final int WIFICIPHER_WPA = 3;
    public static final int WIFICIPHER_WPA2 = 4;

    public static WifiConfiguration IsExsits(WifiManager wifiManager, String str) {
        for (WifiConfiguration next : wifiManager.getConfiguredNetworks()) {
            String str2 = next.SSID;
            if (str2.equals("\"" + str + "\"")) {
                return next;
            }
        }
        return null;
    }

    public static boolean checkWifiIsInScanResult(List<ScanResult> list, String str) {
        if (list == null) {
            return false;
        }
        for (ScanResult scanResult : list) {
            if (scanResult.SSID.replace("\"", "").equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean connectNearNetwork(Context context, List<ScanResult> list) {
        WifiManager wifiManager;
        List<WifiConfiguration> existConfig;
        if (context == null || list == null || (existConfig = getExistConfig(wifiManager)) == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        for (ScanResult scanResult : list) {
            hashMap.put(scanResult.SSID.replace("\"", ""), Boolean.TRUE);
        }
        for (int size = existConfig.size() - 1; size >= 0; size--) {
            WifiConfiguration wifiConfiguration = existConfig.get(size);
            String str = wifiConfiguration.SSID;
            Boolean bool = (Boolean) hashMap.get(str != null ? str.replace("\"", "") : "");
            if (bool != null && bool.booleanValue()) {
                return enableNetwork((wifiManager = getWifiManager(context)), wifiConfiguration.networkId);
            }
        }
        return false;
    }

    public static WifiConfiguration createWifiConfig(WifiManager wifiManager, String str, String str2, int i) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.priority = 40;
        wifiConfiguration.status = 1;
        wifiConfiguration.SSID = a.l("\"", str, "\"");
        WifiConfiguration IsExsits = IsExsits(wifiManager, str);
        if (IsExsits != null) {
            wifiManager.removeNetwork(IsExsits.networkId);
        }
        if (i == 0) {
            wifiConfiguration.wepKeys[0] = "";
            wifiConfiguration.wepTxKeyIndex = 0;
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.allowedProtocols.set(1);
            wifiConfiguration.allowedProtocols.set(0);
        } else {
            if (i == 1) {
                wifiConfiguration.wepKeys[0] = a.l("\"", str2, "\"");
                wifiConfiguration.wepTxKeyIndex = 0;
                wifiConfiguration.allowedKeyManagement.set(0);
                wifiConfiguration.allowedProtocols.set(1);
                wifiConfiguration.allowedProtocols.set(0);
                wifiConfiguration.allowedAuthAlgorithms.set(0);
                wifiConfiguration.allowedAuthAlgorithms.set(1);
                wifiConfiguration.allowedPairwiseCiphers.set(2);
                wifiConfiguration.allowedPairwiseCiphers.set(1);
                wifiConfiguration.allowedGroupCiphers.set(0);
                wifiConfiguration.allowedGroupCiphers.set(1);
            } else if (i == 3 || i == 4) {
                wifiConfiguration.preSharedKey = a.l("\"", str2, "\"");
                wifiConfiguration.allowedProtocols.set(1);
                wifiConfiguration.allowedProtocols.set(0);
                wifiConfiguration.allowedKeyManagement.set(1);
            }
            return wifiConfiguration;
        }
        wifiConfiguration.allowedPairwiseCiphers.set(2);
        wifiConfiguration.allowedPairwiseCiphers.set(1);
        wifiConfiguration.allowedGroupCiphers.set(0);
        wifiConfiguration.allowedGroupCiphers.set(1);
        wifiConfiguration.allowedGroupCiphers.set(3);
        wifiConfiguration.allowedGroupCiphers.set(2);
        return wifiConfiguration;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r1 = getWifiManager(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean disableNetwork(android.content.Context r1, java.lang.String r2) {
        /*
            android.net.wifi.WifiConfiguration r2 = getWifiConfigBySSid(r1, r2)
            r0 = 0
            if (r2 != 0) goto L_0x0008
            return r0
        L_0x0008:
            android.net.wifi.WifiManager r1 = getWifiManager(r1)
            if (r1 == 0) goto L_0x0017
            int r2 = r2.networkId
            boolean r1 = r1.disableNetwork(r2)
            if (r1 == 0) goto L_0x0017
            r0 = 1
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.device.utils.WiFiUtil.disableNetwork(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = getWifiManager(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean enableNetwork(android.content.Context r2, java.lang.String r3) {
        /*
            android.net.wifi.WifiConfiguration r3 = getWifiConfigBySSid(r2, r3)
            r0 = 0
            if (r3 != 0) goto L_0x0008
            return r0
        L_0x0008:
            android.net.wifi.WifiManager r2 = getWifiManager(r2)
            r1 = 1
            if (r2 == 0) goto L_0x0018
            int r3 = r3.networkId
            boolean r2 = r2.enableNetwork(r3, r1)
            if (r2 == 0) goto L_0x0018
            r0 = 1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.device.utils.WiFiUtil.enableNetwork(android.content.Context, java.lang.String):boolean");
    }

    public static boolean enableNetwork(WifiManager wifiManager, int i) {
        return wifiManager != null && wifiManager.enableNetwork(i, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r1 = r1.getConnectionInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getBssid(android.content.Context r1) {
        /*
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r0 = "wifi"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1
            java.lang.String r0 = ""
            if (r1 != 0) goto L_0x0011
            return r0
        L_0x0011:
            android.net.wifi.WifiInfo r1 = r1.getConnectionInfo()
            if (r1 != 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            java.lang.String r0 = r1.getBSSID()
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.device.utils.WiFiUtil.getBssid(android.content.Context):java.lang.String");
    }

    public static String getCurrentSSID(Context context) {
        return getCurrentSSID((WifiManager) context.getApplicationContext().getSystemService(NetworkUtil.CONN_TYPE_WIFI));
    }

    public static String getCurrentSSID(WifiManager wifiManager) {
        return wifiManager == null ? "" : getSSID(wifiManager);
    }

    public static WifiConfiguration getCurrentWifiConfig(Context context) {
        String currentSSID = getCurrentSSID(context);
        List<WifiConfiguration> existConfig = getExistConfig(context);
        if (existConfig == null) {
            return null;
        }
        for (int size = existConfig.size() - 1; size >= 0; size--) {
            WifiConfiguration wifiConfiguration = existConfig.get(size);
            String str = wifiConfiguration.SSID;
            if (str != null && str.replace("\"", "").equals(currentSSID)) {
                return wifiConfiguration;
            }
        }
        return null;
    }

    public static List<WifiConfiguration> getExistConfig(Context context) {
        WifiManager wifiManager = getWifiManager(context);
        if (wifiManager == null) {
            return null;
        }
        return getExistConfig(wifiManager);
    }

    public static List<WifiConfiguration> getExistConfig(WifiManager wifiManager) {
        if (wifiManager == null) {
            return null;
        }
        return wifiManager.getConfiguredNetworks();
    }

    public static String getIpAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(NetworkUtil.CONN_TYPE_WIFI);
        return wifiManager == null ? "" : getIpAddress(wifiManager);
    }

    public static String getIpAddress(WifiManager wifiManager) {
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return connectionInfo == null ? "" : intToIp(connectionInfo.getIpAddress());
    }

    public static String getSSID(WifiManager wifiManager) {
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return "";
        }
        String ssid = connectionInfo.getSSID();
        return TextUtils.isEmpty(ssid) ? "" : (Build.VERSION.SDK_INT < 17 || !ssid.startsWith("\"") || !ssid.endsWith("\"")) ? ssid : ssid.replaceAll("^\"|\"$", "");
    }

    public static ScanResult getScanResult(List<ScanResult> list, String str) {
        if (list == null) {
            return null;
        }
        for (ScanResult next : list) {
            if (next.SSID.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static List<ScanResult> getScanResultWithoutSsId(List<ScanResult> list, String str) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ScanResult next : list) {
            if (!next.SSID.startsWith(str)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static SupplicantState getSupplicantState(WifiManager wifiManager) {
        return wifiManager.getConnectionInfo().getSupplicantState();
    }

    public static WifiConfiguration getWifiConfigBySSid(Context context, String str) {
        List<WifiConfiguration> existConfig = getExistConfig(context);
        if (existConfig == null) {
            return null;
        }
        try {
            for (int size = existConfig.size() - 1; size >= 0; size--) {
                WifiConfiguration wifiConfiguration = existConfig.get(size);
                if (wifiConfiguration.SSID != null && wifiConfiguration.SSID.replace("\"", "").equals(str)) {
                    return wifiConfiguration;
                }
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static WifiManager getWifiManager(Context context) {
        if (context == null) {
            return null;
        }
        return (WifiManager) context.getApplicationContext().getSystemService(NetworkUtil.CONN_TYPE_WIFI);
    }

    public static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static boolean isWifiConnected(Context context, String str) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            return false;
        }
        String currentSSID = getCurrentSSID(context);
        return !TextUtils.isEmpty(currentSSID) && !TextUtils.isEmpty(str) && str.equals(currentSSID);
    }

    public static boolean isWifiOpen(WifiManager wifiManager) {
        return wifiManager != null && wifiManager.isWifiEnabled();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r1 = getWifiManager(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean removeNetwork(android.content.Context r1, java.lang.String r2) {
        /*
            android.net.wifi.WifiConfiguration r2 = getWifiConfigBySSid(r1, r2)
            r0 = 0
            if (r2 != 0) goto L_0x0008
            return r0
        L_0x0008:
            android.net.wifi.WifiManager r1 = getWifiManager(r1)
            if (r1 == 0) goto L_0x0017
            int r2 = r2.networkId
            boolean r1 = r1.removeNetwork(r2)
            if (r1 == 0) goto L_0x0017
            r0 = 1
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.device.utils.WiFiUtil.removeNetwork(android.content.Context, java.lang.String):boolean");
    }
}
