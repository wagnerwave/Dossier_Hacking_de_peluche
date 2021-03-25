package com.tuya.spongycastle.jce.provider;

import a.a.a.a.a;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.pkcs.PrivateKeyInfo;
import com.tuya.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import com.tuya.spongycastle.jcajce.provider.config.ConfigurableProvider;
import com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration;
import com.tuya.spongycastle.jcajce.provider.symmetric.util.ClassUtil;
import com.tuya.spongycastle.jcajce.provider.util.AlgorithmProvider;
import com.tuya.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    public static final String[] ASYMMETRIC_CIPHERS = {"DSA", "DH", "EC", EncryptionManager.O0000ooo, "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM"};
    public static final String[] ASYMMETRIC_GENERIC = {"X509", "IES"};
    public static final String ASYMMETRIC_PACKAGE = "com.tuya.spongycastle.jcajce.provider.asymmetric.";
    public static final ProviderConfiguration CONFIGURATION = new BouncyCastleProviderConfiguration();
    public static final String[] DIGESTS = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "DSTU7564"};
    public static final String DIGEST_PACKAGE = "com.tuya.spongycastle.jcajce.provider.digest.";
    public static final String[] KEYSTORES = {"BC", "BCFKS", "PKCS12"};
    public static final String KEYSTORE_PACKAGE = "com.tuya.spongycastle.jcajce.provider.keystore.";
    public static final String PROVIDER_NAME = "SC";
    public static final String[] SECURE_RANDOMS = {"DRBG"};
    public static final String SECURE_RANDOM_PACKAGE = "com.tuya.spongycastle.jcajce.provider.drbg.";
    public static final String[] SYMMETRIC_CIPHERS = {EncryptionManager.O0000ooO, "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624"};
    public static final String[] SYMMETRIC_GENERIC = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF"};
    public static final String[] SYMMETRIC_MACS = {"SipHash", "Poly1305"};
    public static final String SYMMETRIC_PACKAGE = "com.tuya.spongycastle.jcajce.provider.symmetric.";
    public static String info = "BouncyCastle Security Provider v1.58";
    public static final Map keyInfoConverters = new HashMap();

    public BouncyCastleProvider() {
        super(PROVIDER_NAME, 1.58d, info);
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                BouncyCastleProvider.this.setup();
                return null;
            }
        });
    }

    public static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        synchronized (keyInfoConverters) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) keyInfoConverters.get(aSN1ObjectIdentifier);
        }
        return asymmetricKeyInfoConverter;
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo privateKeyInfo) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePrivate(privateKeyInfo);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(subjectPublicKeyInfo.getAlgorithm().getAlgorithm());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePublic(subjectPublicKeyInfo);
    }

    private void loadAlgorithms(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            StringBuilder n = a.n(str);
            n.append(strArr[i]);
            n.append("$Mappings");
            Class loadClass = ClassUtil.loadClass(BouncyCastleProvider.class, n.toString());
            if (loadClass != null) {
                try {
                    ((AlgorithmProvider) loadClass.newInstance()).configure(this);
                } catch (Exception e2) {
                    StringBuilder p = a.p("cannot create instance of ", str);
                    p.append(strArr[i]);
                    p.append("$Mappings : ");
                    p.append(e2);
                    throw new InternalError(p.toString());
                }
            }
        }
    }

    private void loadPQCKeys() {
    }

    /* access modifiers changed from: private */
    public void setup() {
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_CIPHERS);
        loadPQCKeys();
    }

    public void addAlgorithm(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        addAlgorithm(str + "." + aSN1ObjectIdentifier, str2);
        addAlgorithm(str + ".OID." + aSN1ObjectIdentifier, str2);
    }

    public void addAlgorithm(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException(a.l("duplicate provider key (", str, ") found"));
    }

    public void addAttributes(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            String l = a.l(str, " ", next);
            if (!containsKey(l)) {
                put(l, map.get(next));
            } else {
                throw new IllegalStateException(a.l("duplicate provider attribute key (", l, ") found"));
            }
        }
    }

    public void addKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        synchronized (keyInfoConverters) {
            keyInfoConverters.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }

    public boolean hasAlgorithm(String str, String str2) {
        if (!containsKey(str + "." + str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Alg.Alias.");
            sb.append(str);
            sb.append(".");
            sb.append(str2);
            return containsKey(sb.toString());
        }
    }

    public void setParameter(String str, Object obj) {
        synchronized (CONFIGURATION) {
            ((BouncyCastleProviderConfiguration) CONFIGURATION).setParameter(str, obj);
        }
    }
}
