package com.tuya.spongycastle.jcajce.provider.asymmetric.util;

import a.a.a.a.a;
import androidx.drawerlayout.widget.DrawerLayout;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.common.o00o0000o0;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.tuya.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import com.tuya.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import com.tuya.spongycastle.asn1.misc.MiscObjectIdentifiers;
import com.tuya.spongycastle.asn1.nist.NISTObjectIdentifiers;
import com.tuya.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import com.tuya.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import com.tuya.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.tuya.spongycastle.crypto.DerivationFunction;
import com.tuya.spongycastle.crypto.DerivationParameters;
import com.tuya.spongycastle.crypto.agreement.kdf.DHKDFParameters;
import com.tuya.spongycastle.crypto.agreement.kdf.DHKEKGenerator;
import com.tuya.spongycastle.crypto.params.DESParameters;
import com.tuya.spongycastle.crypto.params.KDFParameters;
import com.tuya.spongycastle.util.Integers;
import com.tuya.spongycastle.util.Strings;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    public static final Map<String, ASN1ObjectIdentifier> defaultOids = new HashMap();
    public static final Hashtable des = new Hashtable();
    public static final Map<String, Integer> keySizes = new HashMap();
    public static final Map<String, String> nameTable = new HashMap();
    public static final Hashtable oids = new Hashtable();
    public final String kaAlgorithm;
    public final DerivationFunction kdf;
    public byte[] ukmParameters;

    static {
        Integer valueOf = Integers.valueOf(64);
        Integer valueOf2 = Integers.valueOf(128);
        Integer valueOf3 = Integers.valueOf(o00o0000o0.O00000Oo);
        Integer valueOf4 = Integers.valueOf(256);
        keySizes.put("DES", valueOf);
        keySizes.put("DESEDE", valueOf3);
        keySizes.put("BLOWFISH", valueOf2);
        keySizes.put(EncryptionManager.O0000ooO, valueOf4);
        keySizes.put(NISTObjectIdentifiers.id_aes128_ECB.getId(), valueOf2);
        keySizes.put(NISTObjectIdentifiers.id_aes192_ECB.getId(), valueOf3);
        keySizes.put(NISTObjectIdentifiers.id_aes256_ECB.getId(), valueOf4);
        keySizes.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), valueOf2);
        keySizes.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), valueOf3);
        keySizes.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), valueOf4);
        keySizes.put(NISTObjectIdentifiers.id_aes128_CFB.getId(), valueOf2);
        keySizes.put(NISTObjectIdentifiers.id_aes192_CFB.getId(), valueOf3);
        keySizes.put(NISTObjectIdentifiers.id_aes256_CFB.getId(), valueOf4);
        keySizes.put(NISTObjectIdentifiers.id_aes128_OFB.getId(), valueOf2);
        keySizes.put(NISTObjectIdentifiers.id_aes192_OFB.getId(), valueOf3);
        keySizes.put(NISTObjectIdentifiers.id_aes256_OFB.getId(), valueOf4);
        keySizes.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), valueOf2);
        keySizes.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), valueOf3);
        keySizes.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), valueOf4);
        keySizes.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), valueOf2);
        keySizes.put(NISTObjectIdentifiers.id_aes192_CCM.getId(), valueOf3);
        keySizes.put(NISTObjectIdentifiers.id_aes256_CCM.getId(), valueOf4);
        keySizes.put(NISTObjectIdentifiers.id_aes128_GCM.getId(), valueOf2);
        keySizes.put(NISTObjectIdentifiers.id_aes192_GCM.getId(), valueOf3);
        keySizes.put(NISTObjectIdentifiers.id_aes256_GCM.getId(), valueOf4);
        keySizes.put(NTTObjectIdentifiers.id_camellia128_wrap.getId(), valueOf2);
        keySizes.put(NTTObjectIdentifiers.id_camellia192_wrap.getId(), valueOf3);
        keySizes.put(NTTObjectIdentifiers.id_camellia256_wrap.getId(), valueOf4);
        keySizes.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId(), valueOf2);
        keySizes.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), valueOf3);
        keySizes.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), valueOf3);
        keySizes.put(OIWObjectIdentifiers.desCBC.getId(), valueOf);
        keySizes.put(CryptoProObjectIdentifiers.gostR28147_gcfb.getId(), valueOf4);
        keySizes.put(CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.getId(), valueOf4);
        keySizes.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.getId(), valueOf4);
        keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA1.getId(), Integers.valueOf(DrawerLayout.PEEK_DELAY));
        keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA256.getId(), valueOf4);
        keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA384.getId(), Integers.valueOf(384));
        keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA512.getId(), Integers.valueOf(512));
        defaultOids.put("DESEDE", PKCSObjectIdentifiers.des_EDE3_CBC);
        defaultOids.put(EncryptionManager.O0000ooO, NISTObjectIdentifiers.id_aes256_CBC);
        defaultOids.put("CAMELLIA", NTTObjectIdentifiers.id_camellia256_cbc);
        defaultOids.put("SEED", KISAObjectIdentifiers.id_seedCBC);
        defaultOids.put("DES", OIWObjectIdentifiers.desCBC);
        nameTable.put(MiscObjectIdentifiers.cast5CBC.getId(), "CAST5");
        nameTable.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.getId(), "IDEA");
        nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.getId(), "Blowfish");
        nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.getId(), "Blowfish");
        nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.getId(), "Blowfish");
        nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.getId(), "Blowfish");
        nameTable.put(OIWObjectIdentifiers.desECB.getId(), "DES");
        nameTable.put(OIWObjectIdentifiers.desCBC.getId(), "DES");
        nameTable.put(OIWObjectIdentifiers.desCFB.getId(), "DES");
        nameTable.put(OIWObjectIdentifiers.desOFB.getId(), "DES");
        nameTable.put(OIWObjectIdentifiers.desEDE.getId(), "DESede");
        nameTable.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), "DESede");
        nameTable.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), "DESede");
        nameTable.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.getId(), "RC2");
        nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA1.getId(), "HmacSHA1");
        nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA224.getId(), "HmacSHA224");
        nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA256.getId(), EncryptionManager.O000O0o0);
        nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA384.getId(), "HmacSHA384");
        nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA512.getId(), "HmacSHA512");
        nameTable.put(NTTObjectIdentifiers.id_camellia128_cbc.getId(), "Camellia");
        nameTable.put(NTTObjectIdentifiers.id_camellia192_cbc.getId(), "Camellia");
        nameTable.put(NTTObjectIdentifiers.id_camellia256_cbc.getId(), "Camellia");
        nameTable.put(NTTObjectIdentifiers.id_camellia128_wrap.getId(), "Camellia");
        nameTable.put(NTTObjectIdentifiers.id_camellia192_wrap.getId(), "Camellia");
        nameTable.put(NTTObjectIdentifiers.id_camellia256_wrap.getId(), "Camellia");
        nameTable.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId(), "SEED");
        nameTable.put(KISAObjectIdentifiers.id_seedCBC.getId(), "SEED");
        nameTable.put(KISAObjectIdentifiers.id_seedMAC.getId(), "SEED");
        nameTable.put(CryptoProObjectIdentifiers.gostR28147_gcfb.getId(), "GOST28147");
        nameTable.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), EncryptionManager.O0000ooO);
        nameTable.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), EncryptionManager.O0000ooO);
        nameTable.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), EncryptionManager.O0000ooO);
        oids.put("DESEDE", PKCSObjectIdentifiers.des_EDE3_CBC);
        oids.put(EncryptionManager.O0000ooO, NISTObjectIdentifiers.id_aes256_CBC);
        oids.put("DES", OIWObjectIdentifiers.desCBC);
        des.put("DES", "DES");
        des.put("DESEDE", "DES");
        des.put(OIWObjectIdentifiers.desCBC.getId(), "DES");
        des.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), "DES");
        des.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), "DES");
    }

    public BaseAgreementSpi(String str, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.kdf = derivationFunction;
    }

    public static String getAlgorithm(String str) {
        if (str.indexOf(91) > 0) {
            return str.substring(0, str.indexOf(91));
        }
        if (str.startsWith(NISTObjectIdentifiers.aes.getId())) {
            return EncryptionManager.O0000ooO;
        }
        if (str.startsWith(GNUObjectIdentifiers.Serpent.getId())) {
            return "Serpent";
        }
        String str2 = nameTable.get(Strings.toUpperCase(str));
        return str2 != null ? str2 : str;
    }

    public static int getKeySize(String str) {
        if (str.indexOf(91) > 0) {
            return Integer.parseInt(str.substring(str.indexOf(91) + 1, str.indexOf(93)));
        }
        String upperCase = Strings.toUpperCase(str);
        if (!keySizes.containsKey(upperCase)) {
            return -1;
        }
        return keySizes.get(upperCase).intValue();
    }

    public static byte[] trimZeroes(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i = 0;
        while (i < bArr.length && bArr[i] == 0) {
            i++;
        }
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    public abstract byte[] calcSecret();

    public int engineGenerateSecret(byte[] bArr, int i) {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + engineGenerateSecret.length + " bytes");
    }

    public SecretKey engineGenerateSecret(String str) {
        DerivationParameters derivationParameters;
        byte[] calcSecret = calcSecret();
        String upperCase = Strings.toUpperCase(str);
        String id = oids.containsKey(upperCase) ? ((ASN1ObjectIdentifier) oids.get(upperCase)).getId() : str;
        int keySize = getKeySize(id);
        DerivationFunction derivationFunction = this.kdf;
        if (derivationFunction != null) {
            if (keySize >= 0) {
                int i = keySize / 8;
                byte[] bArr = new byte[i];
                if (derivationFunction instanceof DHKEKGenerator) {
                    try {
                        derivationParameters = new DHKDFParameters(new ASN1ObjectIdentifier(id), keySize, calcSecret, this.ukmParameters);
                    } catch (IllegalArgumentException unused) {
                        throw new NoSuchAlgorithmException(a.k("no OID for algorithm: ", id));
                    }
                } else {
                    derivationParameters = new KDFParameters(calcSecret, this.ukmParameters);
                }
                this.kdf.init(derivationParameters);
                this.kdf.generateBytes(bArr, 0, i);
                calcSecret = bArr;
            } else {
                throw new NoSuchAlgorithmException(a.k("unknown algorithm encountered: ", id));
            }
        } else if (keySize > 0) {
            int i2 = keySize / 8;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(calcSecret, 0, bArr2, 0, i2);
            calcSecret = bArr2;
        }
        String algorithm = getAlgorithm(str);
        if (des.containsKey(algorithm)) {
            DESParameters.setOddParity(calcSecret);
        }
        return new SecretKeySpec(calcSecret, algorithm);
    }

    public byte[] engineGenerateSecret() {
        if (this.kdf == null) {
            return calcSecret();
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }
}
