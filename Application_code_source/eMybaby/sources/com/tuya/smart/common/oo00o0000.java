package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.content.pm.PackageManager;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class oo00o0000 {
    public static String O000000o(Context context) {
        try {
            try {
                try {
                    try {
                        return O000000o(MessageDigest.getInstance("SHA256").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()))).getEncoded()));
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                        return null;
                    } catch (CertificateEncodingException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return "";
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                return "";
            }
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String O000000o(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = a.k(oOO0O0O0.O0000oO0, hexString);
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }
}
