package com.tuya.smart.android.network.util;

import com.tuya.smart.android.common.utils.L;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {
    public SSLSocketFactory internalSSLSocketFactory;

    public TLSSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.internalSSLSocketFactory = sSLSocketFactory;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = (javax.net.ssl.SSLSocket) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.Socket enableTLSOnSocket(java.net.Socket r3) {
        /*
            if (r3 == 0) goto L_0x001c
            boolean r0 = r3 instanceof javax.net.ssl.SSLSocket
            if (r0 == 0) goto L_0x001c
            r0 = r3
            javax.net.ssl.SSLSocket r0 = (javax.net.ssl.SSLSocket) r0
            java.lang.String[] r1 = getSupportedProtocols(r0)
            if (r1 == 0) goto L_0x001c
            int r2 = r1.length
            if (r2 <= 0) goto L_0x001c
            r0.setEnabledProtocols(r1)
            java.lang.String r0 = "TLSSocketFactory"
            java.lang.String r1 = "enable SupportedProtocols"
            com.tuya.smart.android.common.utils.L.d(r0, r1)
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.network.util.TLSSocketFactory.enableTLSOnSocket(java.net.Socket):java.net.Socket");
    }

    public static String[] getSupportedProtocols(SSLSocket sSLSocket) {
        String[] supportedProtocols = sSLSocket.getSupportedProtocols();
        if (supportedProtocols == null || supportedProtocols.length == 0) {
            L.d("TLSSocketFactory", "no supportedProtocols");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : supportedProtocols) {
            L.d("TLSSocketFactory", "support protocol: " + str);
            if ("TLSv1.1".equals(str) || "TLSv1.2".equals(str) || "TLSv1".equals(str)) {
                L.d("TLSSocketFactory", "add " + str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Socket createSocket(String str, int i) {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.internalSSLSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.internalSSLSocketFactory.getSupportedCipherSuites();
    }
}
