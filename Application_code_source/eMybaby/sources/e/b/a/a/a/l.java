package e.b.a.a.a;

import a.e.a.a.r.b;
import e.b.a.a.a.x.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public int f5216a = 60;

    /* renamed from: b  reason: collision with root package name */
    public int f5217b = 10;

    /* renamed from: c  reason: collision with root package name */
    public String f5218c = null;

    /* renamed from: d  reason: collision with root package name */
    public o f5219d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f5220e;
    public char[] f;
    public SocketFactory g;
    public Properties h = null;
    public HostnameVerifier i = null;
    public boolean j = true;
    public int k = 30;
    public String[] l = null;
    public int m = 0;
    public boolean n = false;

    public static int c(String str) {
        try {
            URI uri = new URI(str);
            if ("ws".equals(uri.getScheme())) {
                return 3;
            }
            if ("wss".equals(uri.getScheme())) {
                return 4;
            }
            if (uri.getPath() != null) {
                if (!uri.getPath().isEmpty()) {
                    throw new IllegalArgumentException(str);
                }
            }
            if ("tcp".equals(uri.getScheme())) {
                return 0;
            }
            if ("ssl".equals(uri.getScheme())) {
                return 1;
            }
            if ("local".equals(uri.getScheme())) {
                return 2;
            }
            throw new IllegalArgumentException(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException(str);
        }
    }

    public void a(int i2) {
        if (i2 == 0 || i2 == 3 || i2 == 4) {
            this.m = i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void b(String str, byte[] bArr, int i2, boolean z) {
        if (str == null || bArr == null) {
            throw new IllegalArgumentException();
        }
        b.e0(str, false);
        o oVar = new o(bArr);
        this.f5218c = str;
        this.f5219d = oVar;
        oVar.setQos(i2);
        this.f5219d.setRetained(z);
        this.f5219d.setMutable(false);
    }

    public String toString() {
        Properties properties = new Properties();
        properties.put("MqttVersion", new Integer(this.m));
        properties.put("CleanSession", Boolean.valueOf(this.j));
        properties.put("ConTimeout", new Integer(this.k));
        properties.put("KeepAliveInterval", new Integer(this.f5216a));
        String str = this.f5220e;
        if (str == null) {
            str = "null";
        }
        properties.put("UserName", str);
        String str2 = this.f5218c;
        if (str2 == null) {
            str2 = "null";
        }
        properties.put("WillDestination", str2);
        SocketFactory socketFactory = this.g;
        if (socketFactory == null) {
            properties.put("SocketFactory", "null");
        } else {
            properties.put("SocketFactory", socketFactory);
        }
        Properties properties2 = this.h;
        if (properties2 == null) {
            properties.put("SSLProperties", "null");
        } else {
            properties.put("SSLProperties", properties2);
        }
        return a.a(properties, "Connection options");
    }
}
