package e.b.a.a.a.u.r;

import com.tutk.IOTC.AVFrame;
import e.b.a.a.a.s;
import e.b.a.a.a.v.b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f5295d = {"com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication"};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f5296e = {-99, -89, -39, Byte.MIN_VALUE, 5, -72, -119, -100};

    /* renamed from: a  reason: collision with root package name */
    public Hashtable f5297a = new Hashtable();

    /* renamed from: b  reason: collision with root package name */
    public Properties f5298b;

    /* renamed from: c  reason: collision with root package name */
    public b f5299c = null;

    public static char[] b(String str) {
        try {
            byte[] a2 = b.a(str.substring(5));
            int i = 0;
            for (int i2 = 0; i2 < a2.length; i2++) {
                byte b2 = a2[i2];
                byte[] bArr = f5296e;
                a2[i2] = (byte) ((b2 ^ bArr[i2 % bArr.length]) & AVFrame.FRM_STATE_UNKOWN);
            }
            char[] cArr = new char[(a2.length / 2)];
            int i3 = 0;
            while (i < a2.length) {
                int i4 = i + 1;
                cArr[i3] = (char) ((a2[i] & AVFrame.FRM_STATE_UNKOWN) + ((a2[i4] & AVFrame.FRM_STATE_UNKOWN) << 8));
                i3++;
                i = i4 + 1;
            }
            return cArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String r(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = new byte[(cArr.length * 2)];
        int i = 0;
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i + 1;
            bArr[i] = (byte) (cArr[i2] & 255);
            i = i3 + 1;
            bArr[i3] = (byte) ((cArr[i2] >> 8) & 255);
        }
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte b2 = bArr[i4];
            byte[] bArr2 = f5296e;
            bArr[i4] = (byte) ((b2 ^ bArr2[i4 % bArr2.length]) & AVFrame.FRM_STATE_UNKOWN);
        }
        return "{xor}" + new String(b.b(bArr));
    }

    public SSLSocketFactory a(String str) {
        SSLContext j = j((String) null);
        b bVar = this.f5299c;
        if (bVar != null) {
            Object[] objArr = new Object[2];
            objArr[0] = "null (broker defaults)";
            objArr[1] = c((String) null) != null ? i((String) null, "com.ibm.ssl.enabledCipherSuites", (String) null) : "null (using platform-enabled cipher suites)";
            bVar.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "createSocketFactory", "12020", objArr);
        }
        return j.getSocketFactory();
    }

    public String[] c(String str) {
        String i = i(str, "com.ibm.ssl.enabledCipherSuites", (String) null);
        if (i == null) {
            return null;
        }
        Vector vector = new Vector();
        int indexOf = i.indexOf(44);
        int i2 = 0;
        while (indexOf > -1) {
            vector.add(i.substring(i2, indexOf));
            i2 = indexOf + 1;
            indexOf = i.indexOf(44, i2);
        }
        vector.add(i.substring(i2));
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public String d(String str) {
        return i(str, "com.ibm.ssl.contextProvider", (String) null);
    }

    public String e(String str) {
        return i(str, "com.ibm.ssl.keyManager", "ssl.KeyManagerFactory.algorithm");
    }

    public char[] f(String str) {
        String i = i(str, "com.ibm.ssl.keyStorePassword", "javax.net.ssl.keyStorePassword");
        if (i != null) {
            return i.startsWith("{xor}") ? b(i) : i.toCharArray();
        }
        return null;
    }

    public String g(String str) {
        return i(str, "com.ibm.ssl.keyStoreProvider", (String) null);
    }

    public String h(String str) {
        return i(str, "com.ibm.ssl.keyStoreType", "javax.net.ssl.keyStoreType");
    }

    public final String i(String str, String str2, String str3) {
        Properties properties;
        String str4 = null;
        Properties properties2 = str != null ? (Properties) this.f5297a.get(str) : null;
        if ((properties2 == null || (str4 = properties2.getProperty(str2)) == null) && (properties = this.f5298b) != null) {
            str4 = properties.getProperty(str2);
        }
        return (str4 == null && str3 != null) ? System.getProperty(str3) : str4;
    }

    public final SSLContext j(String str) {
        SSLContext sSLContext;
        KeyManager[] keyManagerArr;
        TrustManager[] trustManagerArr;
        String str2 = str;
        String k = k(str);
        if (k == null) {
            k = "TLS";
        }
        b bVar = this.f5299c;
        if (bVar != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr[1] = k;
            bVar.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12000", objArr);
        }
        String d2 = d(str);
        if (d2 == null) {
            try {
                sSLContext = SSLContext.getInstance(k);
            } catch (KeyStoreException e2) {
                throw new s((Throwable) e2);
            } catch (CertificateException e3) {
                throw new s((Throwable) e3);
            } catch (FileNotFoundException e4) {
                throw new s((Throwable) e4);
            } catch (IOException e5) {
                throw new s((Throwable) e5);
            } catch (KeyStoreException e6) {
                throw new s((Throwable) e6);
            } catch (CertificateException e7) {
                throw new s((Throwable) e7);
            } catch (FileNotFoundException e8) {
                throw new s((Throwable) e8);
            } catch (IOException e9) {
                throw new s((Throwable) e9);
            } catch (UnrecoverableKeyException e10) {
                throw new s((Throwable) e10);
            } catch (NoSuchAlgorithmException e11) {
                throw new s((Throwable) e11);
            } catch (NoSuchProviderException e12) {
                throw new s((Throwable) e12);
            } catch (KeyManagementException e13) {
                throw new s((Throwable) e13);
            }
        } else {
            sSLContext = SSLContext.getInstance(k, d2);
        }
        if (this.f5299c != null) {
            b bVar2 = this.f5299c;
            Object[] objArr2 = new Object[2];
            objArr2[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr2[1] = sSLContext.getProvider().getName();
            bVar2.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12001", objArr2);
        }
        String i = i(str2, "com.ibm.ssl.keyStore", (String) null);
        if (i == null) {
            i = i(str2, "com.ibm.ssl.keyStore", "javax.net.ssl.keyStore");
        }
        String str3 = "null";
        if (this.f5299c != null) {
            b bVar3 = this.f5299c;
            Object[] objArr3 = new Object[2];
            objArr3[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr3[1] = i != null ? i : str3;
            bVar3.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12004", objArr3);
        }
        char[] f = f(str);
        if (this.f5299c != null) {
            b bVar4 = this.f5299c;
            Object[] objArr4 = new Object[2];
            objArr4[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr4[1] = f != null ? r(f) : str3;
            bVar4.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12005", objArr4);
        }
        String h = h(str);
        if (h == null) {
            h = KeyStore.getDefaultType();
        }
        if (this.f5299c != null) {
            b bVar5 = this.f5299c;
            Object[] objArr5 = new Object[2];
            objArr5[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr5[1] = h != null ? h : str3;
            bVar5.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12006", objArr5);
        }
        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        String g = g(str);
        String e14 = e(str);
        if (e14 != null) {
            defaultAlgorithm = e14;
        }
        if (i == null || h == null || defaultAlgorithm == null) {
            keyManagerArr = null;
        } else {
            KeyStore instance = KeyStore.getInstance(h);
            instance.load(new FileInputStream(i), f);
            KeyManagerFactory instance2 = g != null ? KeyManagerFactory.getInstance(defaultAlgorithm, g) : KeyManagerFactory.getInstance(defaultAlgorithm);
            if (this.f5299c != null) {
                b bVar6 = this.f5299c;
                Object[] objArr6 = new Object[2];
                objArr6[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr6[1] = defaultAlgorithm;
                bVar6.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12010", objArr6);
                b bVar7 = this.f5299c;
                Object[] objArr7 = new Object[2];
                objArr7[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr7[1] = instance2.getProvider().getName();
                bVar7.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12009", objArr7);
            }
            instance2.init(instance, f);
            keyManagerArr = instance2.getKeyManagers();
        }
        String m = m(str);
        if (this.f5299c != null) {
            b bVar8 = this.f5299c;
            Object[] objArr8 = new Object[2];
            objArr8[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr8[1] = m != null ? m : str3;
            bVar8.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12011", objArr8);
        }
        char[] n = n(str);
        if (this.f5299c != null) {
            b bVar9 = this.f5299c;
            Object[] objArr9 = new Object[2];
            objArr9[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr9[1] = n != null ? r(n) : str3;
            bVar9.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12012", objArr9);
        }
        String p = p(str);
        if (p == null) {
            p = KeyStore.getDefaultType();
        }
        if (this.f5299c != null) {
            b bVar10 = this.f5299c;
            Object[] objArr10 = new Object[2];
            objArr10[0] = str2 != null ? str2 : "null (broker defaults)";
            if (p != null) {
                str3 = p;
            }
            objArr10[1] = str3;
            bVar10.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12013", objArr10);
        }
        String defaultAlgorithm2 = TrustManagerFactory.getDefaultAlgorithm();
        String o = o(str);
        String l = l(str);
        if (l != null) {
            defaultAlgorithm2 = l;
        }
        if (m == null || p == null || defaultAlgorithm2 == null) {
            trustManagerArr = null;
        } else {
            KeyStore instance3 = KeyStore.getInstance(p);
            instance3.load(new FileInputStream(m), n);
            TrustManagerFactory instance4 = o != null ? TrustManagerFactory.getInstance(defaultAlgorithm2, o) : TrustManagerFactory.getInstance(defaultAlgorithm2);
            if (this.f5299c != null) {
                b bVar11 = this.f5299c;
                Object[] objArr11 = new Object[2];
                objArr11[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr11[1] = defaultAlgorithm2;
                bVar11.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12017", objArr11);
                b bVar12 = this.f5299c;
                Object[] objArr12 = new Object[2];
                if (str2 == null) {
                    str2 = "null (broker defaults)";
                }
                objArr12[0] = str2;
                objArr12[1] = instance4.getProvider().getName();
                bVar12.e("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12016", objArr12);
            }
            instance4.init(instance3);
            trustManagerArr = instance4.getTrustManagers();
        }
        sSLContext.init(keyManagerArr, trustManagerArr, (SecureRandom) null);
        return sSLContext;
    }

    public String k(String str) {
        return i(str, "com.ibm.ssl.protocol", (String) null);
    }

    public String l(String str) {
        return i(str, "com.ibm.ssl.trustManager", "ssl.TrustManagerFactory.algorithm");
    }

    public String m(String str) {
        return i(str, "com.ibm.ssl.trustStore", "javax.net.ssl.trustStore");
    }

    public char[] n(String str) {
        String i = i(str, "com.ibm.ssl.trustStorePassword", "javax.net.ssl.trustStorePassword");
        if (i != null) {
            return i.startsWith("{xor}") ? b(i) : i.toCharArray();
        }
        return null;
    }

    public String o(String str) {
        return i(str, "com.ibm.ssl.trustStoreProvider", (String) null);
    }

    public String p(String str) {
        return i(str, "com.ibm.ssl.trustStoreType", (String) null);
    }

    public void q(Properties properties, String str) {
        for (String str2 : properties.keySet()) {
            boolean z = false;
            int i = 0;
            while (true) {
                String[] strArr = f5295d;
                if (i < strArr.length && !strArr[i].equals(str2)) {
                    i++;
                }
            }
            if (i < f5295d.length) {
                z = true;
                continue;
            }
            if (!z) {
                throw new IllegalArgumentException(String.valueOf(str2) + " is not a valid IBM SSL property key.");
            }
        }
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        String property = properties2.getProperty("com.ibm.ssl.keyStorePassword");
        if (property != null && !property.startsWith("{xor}")) {
            properties2.put("com.ibm.ssl.keyStorePassword", r(property.toCharArray()));
        }
        String property2 = properties2.getProperty("com.ibm.ssl.trustStorePassword");
        if (property2 != null && !property2.startsWith("{xor}")) {
            properties2.put("com.ibm.ssl.trustStorePassword", r(property2.toCharArray()));
        }
        this.f5298b = properties2;
    }
}
