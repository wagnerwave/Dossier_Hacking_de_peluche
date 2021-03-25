package e.b.a.a.a.u;

import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class o extends p {
    public static final b l = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", o.class.getName());
    public String[] g;
    public int h;
    public HostnameVerifier i;
    public String j;
    public int k;

    public o(SSLSocketFactory sSLSocketFactory, String str, int i2, String str2) {
        super(sSLSocketFactory, str, i2, str2);
        this.j = str;
        this.k = i2;
        l.i(str2);
    }

    public String c() {
        return "ssl://" + this.j + ":" + this.k;
    }

    public void d(String[] strArr) {
        this.g = strArr;
        if (this.f5285a != null && strArr != null) {
            if (l.f(5)) {
                String str = "";
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (i2 > 0) {
                        str = String.valueOf(str) + ",";
                    }
                    str = String.valueOf(str) + strArr[i2];
                }
                l.e("e.b.a.a.a.u.o", "setEnabledCiphers", "260", new Object[]{str});
            }
            ((SSLSocket) this.f5285a).setEnabledCipherSuites(strArr);
        }
    }

    public void start() {
        super.start();
        d(this.g);
        int soTimeout = this.f5285a.getSoTimeout();
        this.f5285a.setSoTimeout(this.h * 1000);
        ((SSLSocket) this.f5285a).startHandshake();
        if (this.i != null) {
            this.i.verify(this.j, ((SSLSocket) this.f5285a).getSession());
        }
        this.f5285a.setSoTimeout(soTimeout);
    }
}
