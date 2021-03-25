package com.tuya.sdk.security;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.tuya.sdk.security.SecuredPreferenceStore;
import com.tuya.smart.android.common.utils.AESUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableEntryException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public class EncryptionManager {
    public static final String O00000o = "sps";
    public static final String O00000o0 = "OverridingAlias";
    public static final String O0000o0 = "UTF-8";
    public static final String O0000oOO = "rsa_key";
    public static final String O0000oOo = "aes_key";
    public static final String O0000oo0 = "mac_key";
    public static final String O0000ooO = "AES";
    public static final String O0000ooo = "RSA";
    public static final String O000O00o = "CBC";
    public static final String O000O0OO = "PKCS1Padding";
    public static final String O000O0Oo = "PKCS7Padding";
    public static final String O000O0o0 = "HmacSHA256";
    public static final String O000OO0o = "data_in_compat";
    public static final String O00oOoOo = "NoPadding";
    public static final String O00oOooO = "ECB";
    public static final String O00oOooo = "GCM";
    public final String O000000o;
    public final String O00000Oo;
    public final String O00000oO;
    public SharedPreferences O00000oo;
    public SecuredPreferenceStore.O00000Oo O0000O0o;
    public final int O0000OOo;
    public final int O0000Oo;
    public final int O0000Oo0;
    public final int O0000OoO;
    public final int O0000Ooo;
    public final String O0000o;
    public final int O0000o00;
    public final String O0000o0O;
    public final String O0000o0o;
    public final String O0000oO;
    public final byte[] O0000oO0;
    public final String O0000oo;
    public final String O000O0o;
    public final String O000O0oO;
    public final String O000O0oo;
    public KeyStore O000OO;
    public final String O000OO00;
    public SecretKey O000OOOo;
    public RSAPublicKey O000OOo;
    public SecretKey O000OOo0;
    public RSAPrivateKey O000OOoO;
    public String O000OOoo;
    public boolean O000Oo0;
    public boolean O000Oo00;
    public Context O000Oo0O;

    public class InvalidMacException extends GeneralSecurityException {
        public InvalidMacException() {
            super("Invalid Mac, failed to verify integrity.");
        }
    }

    public static class O000000o {
        public byte[] O000000o;
        public byte[] O00000Oo;
        public byte[] O00000o0;

        public O000000o() {
            this.O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
        }

        public O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.O000000o = bArr;
            this.O00000Oo = bArr2;
            this.O00000o0 = bArr3;
        }

        public void O000000o(byte[] bArr) {
            this.O000000o = bArr;
        }

        public byte[] O000000o() {
            return this.O000000o;
        }

        public void O00000Oo(byte[] bArr) {
            this.O00000Oo = bArr;
        }

        public byte[] O00000Oo() {
            return this.O00000Oo;
        }

        public byte[] O00000o() {
            byte[] bArr = this.O000000o;
            byte[] bArr2 = new byte[(bArr.length + this.O00000Oo.length)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            byte[] bArr3 = this.O00000Oo;
            System.arraycopy(bArr3, 0, bArr2, this.O000000o.length, bArr3.length);
            return bArr2;
        }

        public void O00000o0(byte[] bArr) {
            this.O00000o0 = bArr;
        }

        public byte[] O00000o0() {
            return this.O00000o0;
        }
    }

    public EncryptionManager(Context context, SharedPreferences sharedPreferences, SecuredPreferenceStore.O00000Oo o00000Oo) {
        this(context, sharedPreferences, (String) null, (byte[]) null, o00000Oo);
    }

    public EncryptionManager(Context context, SharedPreferences sharedPreferences, @Nullable String str, @Nullable byte[] bArr, SecuredPreferenceStore.O00000Oo o00000Oo) {
        this.O0000OOo = 2048;
        this.O0000Oo0 = 256;
        this.O0000Oo = 256;
        this.O0000OoO = 128;
        this.O0000Ooo = 16;
        this.O0000o00 = 12;
        this.O0000o0O = "AndroidKeyStore";
        this.O0000o0o = "AndroidOpenSSL";
        this.O0000o = "BC";
        this.O0000oo = "]";
        this.O000O0o = "RSA/ECB/PKCS1Padding";
        this.O000O0oO = "AES/GCM/NoPadding";
        this.O000O0oo = "AES/CBC/PKCS7Padding";
        this.O000OO00 = O000O0o0;
        boolean z = false;
        this.O000Oo00 = false;
        this.O000Oo0 = false;
        this.O0000oO0 = bArr;
        this.O000Oo0 = Build.VERSION.SDK_INT <= 17;
        this.O000Oo0O = context;
        this.O00000oo = sharedPreferences;
        this.O0000O0o = o00000Oo;
        try {
            str = sharedPreferences.getString(O00000o0(O00000o0), str);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        str = str == null ? O00000o : str;
        this.O000OOoo = str;
        this.O00000oO = String.format("%s_%s", new Object[]{str, O000OO0o});
        this.O0000oO = String.format("%s_%s", new Object[]{this.O000OOoo, O0000oOO});
        this.O000000o = String.format("%s_%s", new Object[]{this.O000OOoo, O0000oOo});
        this.O00000Oo = String.format("%s_%s", new Object[]{this.O000OOoo, O0000oo0});
        if (!this.O000Oo0) {
            try {
                this.O000Oo00 = sharedPreferences.getBoolean(O00000o0(this.O00000oO), Build.VERSION.SDK_INT < 23);
                O00000Oo();
                O000000o(context, sharedPreferences, bArr);
            } catch (Exception e4) {
                if (O000000o(e4)) {
                    z = O00000Oo(e4);
                } else {
                    throw e4;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                this.O000Oo0 = true;
                return;
            }
            if (z) {
                O000000o(context, sharedPreferences, bArr);
            }
        }
    }

    public static String O00000o(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] O00000o(String str) {
        return Base64.decode(str, 2);
    }

    public static String O00000o0(String str) {
        return O00000o0(MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8")));
    }

    public static String O00000o0(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return sb.toString();
    }

    private byte[] O00000oO(byte[] bArr, byte[] bArr2) {
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(O0000ooO);
        aESUtil.setKeyValue(bArr2);
        try {
            return aESUtil.decryptWithBytes(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private byte[] O00000oo(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length == 0) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    public O000000o O000000o(byte[] bArr) {
        boolean z;
        O000000o o000000o;
        try {
            o000000o = O00000Oo(bArr);
            z = false;
        } catch (Exception e2) {
            if (O000000o(e2)) {
                z = O00000Oo(e2);
                o000000o = null;
            } else {
                throw e2;
            }
        }
        if (!z) {
            return o000000o;
        }
        O000000o(this.O000Oo0O, this.O00000oo, (byte[]) null);
        return O00000Oo(bArr);
    }

    @TargetApi(19)
    public O000000o O000000o(byte[] bArr, byte[] bArr2) {
        Cipher O000000o2 = O000000o(bArr2, true);
        O000000o o000000o = new O000000o();
        o000000o.O000000o = O000000o2.getIV();
        o000000o.O00000Oo = O000000o2.doFinal(bArr);
        return o000000o;
    }

    public String O000000o(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return O00000o0(O000000o(str.getBytes("UTF-8")));
    }

    public List<String> O000000o() {
        return Arrays.asList(new String[]{this.O000000o, this.O0000oO});
    }

    @TargetApi(19)
    public Cipher O000000o(byte[] bArr, boolean z) {
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(z ? 1 : 2, this.O000OOOo, new GCMParameterSpec(128, bArr));
        return instance;
    }

    public void O000000o(Context context, SharedPreferences sharedPreferences, @Nullable byte[] bArr) {
        if (O000000o(context, bArr, sharedPreferences)) {
            this.O00000oo.edit().putString(O00000o0(O00000o0), this.O000OOoo).apply();
        }
        O000000o(sharedPreferences);
    }

    public void O000000o(SharedPreferences sharedPreferences) {
        if (!this.O000Oo00) {
            this.O000OOOo = (SecretKey) this.O000OO.getKey(this.O000000o, (char[]) null);
            return;
        }
        this.O000OOOo = O00000Oo(sharedPreferences);
        this.O000OOo0 = O00000o0(sharedPreferences);
    }

    public void O000000o(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        boolean z;
        try {
            O00000o0(bufferedInputStream, bufferedOutputStream);
            z = false;
        } catch (Exception e2) {
            if (O000000o(e2)) {
                z = O00000Oo(e2);
            } else {
                throw e2;
            }
        }
        if (z) {
            O000000o(this.O000Oo0O, this.O00000oo, (byte[]) null);
            O00000o0(bufferedInputStream, bufferedOutputStream);
        }
    }

    public boolean O000000o(Context context, @Nullable byte[] bArr) {
        KeyPairGeneratorSpec.Builder serialNumber;
        X500Principal x500Principal;
        if (!this.O000OO.containsAlias(this.O0000oO)) {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(O0000ooo, "AndroidKeyStore");
            Calendar instance2 = Calendar.getInstance();
            instance2.add(11, -26);
            Calendar instance3 = Calendar.getInstance();
            instance3.add(1, 100);
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                serialNumber = new KeyPairGeneratorSpec.Builder(context).setAlias(this.O0000oO).setKeySize(2048).setKeyType(O0000ooo).setSerialNumber(BigInteger.ONE);
                x500Principal = new X500Principal("CN = Secured Preference Store, O = Devliving Online");
            } else if (i >= 18) {
                serialNumber = new KeyPairGeneratorSpec.Builder(context).setAlias(this.O0000oO).setSerialNumber(BigInteger.ONE);
                x500Principal = new X500Principal("CN = Secured Preference Store, O = Devliving Online");
            }
            KeyPairGeneratorSpec build = serialNumber.setSubject(x500Principal).setStartDate(instance2.getTime()).setEndDate(instance3.getTime()).build();
            if (bArr == null || bArr.length <= 0) {
                instance.initialize(build);
            } else {
                instance.initialize(build, new SecureRandom(bArr));
            }
            instance.generateKeyPair();
            return true;
        }
        return false;
    }

    public boolean O000000o(Context context, @Nullable byte[] bArr, SharedPreferences sharedPreferences) {
        if (!this.O000Oo00) {
            return O00000oO(bArr);
        }
        boolean O000000o2 = O000000o(context, bArr);
        O00000o();
        return O00000Oo(sharedPreferences, bArr) || (O000000o(sharedPreferences, bArr) || O000000o2);
    }

    public boolean O000000o(SharedPreferences sharedPreferences, @Nullable byte[] bArr) {
        String O00000o02 = O00000o0(this.O000000o);
        if (sharedPreferences.contains(O00000o02)) {
            return false;
        }
        KeyGenerator instance = KeyGenerator.getInstance(O0000ooO);
        if (bArr == null || bArr.length <= 0) {
            instance.init(256);
        } else {
            instance.init(256, new SecureRandom(bArr));
        }
        boolean commit = sharedPreferences.edit().putString(O00000o02, O00000o(O0000O0o(O00000oo(instance.generateKey().getEncoded(), this.O0000oO0)))).commit();
        sharedPreferences.edit().putBoolean(O00000o0(this.O00000oO), true).apply();
        return commit;
    }

    public <T extends Exception> boolean O000000o(T t) {
        return (t instanceof KeyStoreException) || (t instanceof UnrecoverableEntryException) || (t instanceof InvalidKeyException) || (t instanceof IllegalStateException) || ((t instanceof IOException) && t.getCause() != null && (t.getCause() instanceof BadPaddingException));
    }

    public byte[] O000000o(O000000o o000000o) {
        boolean z;
        byte[] bArr;
        try {
            bArr = O00000Oo(o000000o);
            z = false;
        } catch (Exception e2) {
            if (O000000o(e2)) {
                z = O00000Oo(e2);
                bArr = null;
            } else {
                throw e2;
            }
        }
        if (!z) {
            return bArr;
        }
        O000000o(this.O000Oo0O, this.O00000oo, (byte[]) null);
        return O00000Oo(o000000o);
    }

    public O000000o O00000Oo(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        byte[] O00000o02 = O00000o0();
        return this.O000Oo0 ? O00000o0(bArr, this.O0000oO0) : this.O000Oo00 ? O00000Oo(bArr, O00000o02) : O000000o(bArr, O00000o02);
    }

    public O000000o O00000Oo(byte[] bArr, byte[] bArr2) {
        Cipher O00000Oo2 = O00000Oo(bArr2, true);
        O000000o o000000o = new O000000o();
        o000000o.O000000o = O00000Oo2.getIV();
        o000000o.O00000Oo = O00000Oo2.doFinal(bArr);
        o000000o.O00000o0 = O00000oo(o000000o.O00000o());
        return o000000o;
    }

    public String O00000Oo(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] O000000o2 = O000000o(O00000oO(str));
        return new String(O000000o2, 0, O000000o2.length, "UTF-8");
    }

    public Cipher O00000Oo(byte[] bArr, boolean z) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
        instance.init(z ? 1 : 2, this.O000OOOo, new IvParameterSpec(bArr));
        return instance;
    }

    public SecretKey O00000Oo(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(O00000o0(this.O000000o), (String) null);
        if (string != null) {
            return new SecretKeySpec(O00000oo(O0000OOo(O00000o(string)), this.O0000oO0), O0000ooO);
        }
        return null;
    }

    public void O00000Oo() {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        this.O000OO = instance;
        instance.load((KeyStore.LoadStoreParameter) null);
    }

    public void O00000Oo(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        boolean z;
        try {
            O00000o(bufferedInputStream, bufferedOutputStream);
            z = false;
        } catch (Exception e2) {
            if (O000000o(e2)) {
                z = O00000Oo(e2);
            } else {
                throw e2;
            }
        }
        if (z) {
            O000000o(this.O000Oo0O, this.O00000oo, (byte[]) null);
            O00000o(bufferedInputStream, bufferedOutputStream);
        }
    }

    public boolean O00000Oo(SharedPreferences sharedPreferences, @Nullable byte[] bArr) {
        String O00000o02 = O00000o0(this.O00000Oo);
        if (sharedPreferences.contains(O00000o02)) {
            return false;
        }
        byte[] bArr2 = new byte[32];
        ((bArr == null || bArr.length <= 0) ? new SecureRandom() : new SecureRandom(bArr)).nextBytes(bArr2);
        return sharedPreferences.edit().putString(O00000o02, O00000o(O0000O0o(bArr2))).commit();
    }

    public <T extends Exception> boolean O00000Oo(T t) {
        SecuredPreferenceStore.O00000Oo o00000Oo = this.O0000O0o;
        return o00000Oo != null && o00000Oo.O000000o(t, this.O000OO, O000000o());
    }

    public byte[] O00000Oo(O000000o o000000o) {
        byte[] bArr;
        if (o000000o == null || (bArr = o000000o.O00000Oo) == null) {
            return null;
        }
        return this.O000Oo0 ? O00000oO(bArr, this.O0000oO0) : this.O000Oo00 ? O00000oO(o000000o) : O00000o(o000000o);
    }

    public void O00000o() {
        if (this.O000OO.containsAlias(this.O0000oO) && this.O000OO.entryInstanceOf(this.O0000oO, KeyStore.PrivateKeyEntry.class)) {
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) this.O000OO.getEntry(this.O0000oO, (KeyStore.ProtectionParameter) null);
            this.O000OOo = (RSAPublicKey) privateKeyEntry.getCertificate().getPublicKey();
            this.O000OOoO = (RSAPrivateKey) privateKeyEntry.getPrivateKey();
        }
    }

    public void O00000o(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        int i = this.O000Oo00 ? 16 : 12;
        byte[] bArr = new byte[i];
        int read = bufferedInputStream.read(bArr, 0, i);
        if (read == -1 || read != i) {
            throw new IllegalArgumentException("Unexpected encryption state");
        }
        CipherInputStream cipherInputStream = new CipherInputStream(bufferedInputStream, this.O000Oo00 ? O00000Oo(bArr, false) : O000000o(bArr, false));
        byte[] bArr2 = new byte[4096];
        while (true) {
            int read2 = cipherInputStream.read(bArr2);
            if (read2 != -1) {
                bufferedOutputStream.write(bArr2, 0, read2);
            } else {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                cipherInputStream.close();
                return;
            }
        }
    }

    public boolean O00000o(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        byte[] O00000oo2 = O00000oo(bArr2);
        if (O00000oo2.length != bArr.length) {
            return false;
        }
        byte b2 = 0;
        for (int i = 0; i < O00000oo2.length; i++) {
            b2 |= O00000oo2[i] ^ bArr[i];
        }
        return b2 == 0;
    }

    @TargetApi(19)
    public byte[] O00000o(O000000o o000000o) {
        return O000000o(o000000o.O000000o, false).doFinal(o000000o.O00000Oo);
    }

    public O000000o O00000o0(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(O0000ooO);
        aESUtil.setKeyValue(bArr2);
        try {
            bArr3 = aESUtil.encryptWithBytes(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr3 = null;
        }
        O000000o o000000o = new O000000o();
        o000000o.O000000o = bArr2;
        o000000o.O00000o0 = null;
        o000000o.O00000Oo = bArr3;
        return o000000o;
    }

    public String O00000o0(O000000o o000000o) {
        StringBuilder sb;
        String O00000o2;
        if (o000000o.O00000o0 != null) {
            sb = new StringBuilder();
            sb.append(O00000o(o000000o.O000000o));
            sb.append("]");
            sb.append(O00000o(o000000o.O00000Oo));
            sb.append("]");
            O00000o2 = O00000o(o000000o.O00000o0);
        } else {
            sb = new StringBuilder();
            sb.append(O00000o(o000000o.O000000o));
            sb.append("]");
            O00000o2 = O00000o(o000000o.O00000Oo);
        }
        sb.append(O00000o2);
        return sb.toString();
    }

    public SecretKey O00000o0(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(O00000o0(this.O00000Oo), (String) null);
        if (string != null) {
            return new SecretKeySpec(O0000OOo(O00000o(string)), O000O0o0);
        }
        return null;
    }

    public void O00000o0(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        byte[] O00000o02 = O00000o0();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(bufferedOutputStream, this.O000Oo00 ? O00000Oo(O00000o02, true) : O000000o(O00000o02, true));
        bufferedOutputStream.write(O00000o02);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                cipherOutputStream.write(bArr, 0, read);
            } else {
                cipherOutputStream.flush();
                cipherOutputStream.close();
                bufferedInputStream.close();
                return;
            }
        }
    }

    public byte[] O00000o0() {
        byte[] bArr = new byte[(!this.O000Oo00 ? 12 : 16)];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public O000000o O00000oO(String str) {
        O000000o o000000o = new O000000o();
        String[] split = str.split("]");
        o000000o.O000000o = O00000o(split[0]);
        o000000o.O00000Oo = O00000o(split[1]);
        if (split.length > 2) {
            o000000o.O00000o0 = O00000o(split[2]);
        }
        return o000000o;
    }

    @TargetApi(23)
    public boolean O00000oO(@Nullable byte[] bArr) {
        if (this.O000OO.containsAlias(this.O000000o)) {
            return false;
        }
        KeyGenerator instance = KeyGenerator.getInstance(O0000ooO, "AndroidKeyStore");
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(this.O000000o, 3).setCertificateSubject(new X500Principal("CN = Secured Preference Store, O = Devliving Online")).setCertificateSerialNumber(BigInteger.ONE).setKeySize(256).setBlockModes(new String[]{O00oOooo}).setEncryptionPaddings(new String[]{O00oOoOo}).setRandomizedEncryptionRequired(false).build();
        if (bArr == null || bArr.length <= 0) {
            instance.init(build);
        } else {
            instance.init(build, new SecureRandom(bArr));
        }
        instance.generateKey();
        return true;
    }

    public byte[] O00000oO(O000000o o000000o) {
        if (O00000o(o000000o.O00000o0, o000000o.O00000o())) {
            return O00000Oo(o000000o.O000000o, false).doFinal(o000000o.O00000Oo);
        }
        throw new InvalidMacException();
    }

    public byte[] O00000oo(byte[] bArr) {
        Mac instance = Mac.getInstance(O000O0o0);
        instance.init(this.O000OOo0);
        return instance.doFinal(bArr);
    }

    public byte[] O0000O0o(byte[] bArr) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
        instance.init(1, this.O000OOo);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] O0000OOo(byte[] bArr) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
        instance.init(2, this.O000OOoO);
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(bArr), instance);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int read = cipherInputStream.read();
            if (read == -1) {
                break;
            }
            arrayList.add(Byte.valueOf((byte) read));
        }
        int size = arrayList.size();
        byte[] bArr2 = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        cipherInputStream.close();
        return bArr2;
    }
}
