package com.tuya.smart.android.common.utils;

import com.tuya.sdk.security.EncryptionManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

public class RSAUtil {
    public static final int KEY_SIZE = 512;
    public static final String TAG = "RSAUtil";
    public static RSAPublicKey pubKey;

    public static final class CryptoProvider extends Provider {
        public CryptoProvider() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    @Deprecated
    public static byte[] decrypt(PrivateKey privateKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance(EncryptionManager.O0000ooo, "BC");
            instance.init(2, privateKey);
            int blockSize = instance.getBlockSize();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
            int i = 0;
            while (true) {
                int i2 = i * blockSize;
                if (bArr.length - i2 <= 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(instance.doFinal(bArr, i2, blockSize));
                i++;
            }
        } catch (Exception e2) {
            throw new Exception(e2.getMessage());
        }
    }

    @Deprecated
    public static String encrypt(String str) {
        return HexUtil.bytesToHexString(encrypt(pubKey, str.getBytes()));
    }

    @Deprecated
    public static byte[] encrypt(PublicKey publicKey, byte[] bArr) {
        try {
            FixedSecureRandom fixedSecureRandom = new FixedSecureRandom();
            Cipher instance = Cipher.getInstance(EncryptionManager.O0000ooo);
            instance.init(1, publicKey, fixedSecureRandom);
            int blockSize = instance.getBlockSize();
            int outputSize = instance.getOutputSize(bArr.length);
            byte[] bArr2 = new byte[((bArr.length % blockSize != 0 ? (bArr.length / blockSize) + 1 : bArr.length / blockSize) * outputSize)];
            int i = 0;
            while (true) {
                int i2 = i * blockSize;
                if (bArr.length - i2 <= 0) {
                    return bArr2;
                }
                if (bArr.length - i2 > blockSize) {
                    instance.doFinal(bArr, i2, blockSize, bArr2, i * outputSize);
                } else {
                    instance.doFinal(bArr, i2, bArr.length - i2, bArr2, i * outputSize);
                }
                i++;
            }
        } catch (Exception e2) {
            throw new Exception(e2.getMessage());
        }
    }

    public static RSAPublicKey generateRSAPublicKey(String str) {
        if (str != null && !str.equals("")) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
            try {
                pubKey = generateRSAPublicKey(new BigInteger(bufferedReader.readLine()), new BigInteger(bufferedReader.readLine()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return pubKey;
    }

    public static RSAPublicKey generateRSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(EncryptionManager.O0000ooo).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception(e2.getMessage());
        }
    }
}
