package com.tuya.spongycastle.jcajce.provider.asymmetric.ec;

import a.a.a.a.a;
import com.tuya.spongycastle.asn1.x9.X9IntegerConverter;
import com.tuya.spongycastle.crypto.BasicAgreement;
import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.DerivationFunction;
import com.tuya.spongycastle.crypto.agreement.ECDHBasicAgreement;
import com.tuya.spongycastle.crypto.agreement.ECDHCBasicAgreement;
import com.tuya.spongycastle.crypto.agreement.ECMQVBasicAgreement;
import com.tuya.spongycastle.crypto.agreement.kdf.ConcatenationKDFGenerator;
import com.tuya.spongycastle.crypto.generators.KDF2BytesGenerator;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.crypto.params.MQVPublicParameters;
import com.tuya.spongycastle.crypto.util.DigestFactory;
import com.tuya.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.tuya.spongycastle.jcajce.spec.MQVParameterSpec;
import com.tuya.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
import com.tuya.spongycastle.jce.interfaces.ECPublicKey;
import com.tuya.spongycastle.jce.interfaces.MQVPublicKey;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class KeyAgreementSpi extends BaseAgreementSpi {
    public static final X9IntegerConverter converter = new X9IntegerConverter();
    public BasicAgreement agreement;
    public String kaAlgorithm;
    public MQVParameterSpec mqvParameters;
    public ECDomainParameters parameters;
    public BigInteger result;

    public static class CDHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA1KDFAndSharedInfo() {
            super("ECCDHwithSHA1KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
        }
    }

    public static class CDHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA224KDFAndSharedInfo() {
            super("ECCDHwithSHA224KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA224()));
        }
    }

    public static class CDHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA256KDFAndSharedInfo() {
            super("ECCDHwithSHA256KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class CDHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA384KDFAndSharedInfo() {
            super("ECCDHwithSHA384KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA384()));
        }
    }

    public static class CDHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA512KDFAndSharedInfo() {
            super("ECCDHwithSHA512KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA512()));
        }
    }

    public static class DH extends KeyAgreementSpi {
        public DH() {
            super("ECDH", new ECDHBasicAgreement(), (DerivationFunction) null);
        }
    }

    public static class DHC extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), (DerivationFunction) null);
        }
    }

    public static class DHwithSHA1CKDF extends KeyAgreementSpi {
        public DHwithSHA1CKDF() {
            super("ECDHwithSHA1CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA1()));
        }
    }

    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
        }
    }

    public static class DHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA1KDFAndSharedInfo() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
        }
    }

    public static class DHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA224KDFAndSharedInfo() {
            super("ECDHwithSHA224KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA224()));
        }
    }

    public static class DHwithSHA256CKDF extends KeyAgreementSpi {
        public DHwithSHA256CKDF() {
            super("ECDHwithSHA256CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class DHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA256KDFAndSharedInfo() {
            super("ECDHwithSHA256KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class DHwithSHA384CKDF extends KeyAgreementSpi {
        public DHwithSHA384CKDF() {
            super("ECDHwithSHA384CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
        }
    }

    public static class DHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA384KDFAndSharedInfo() {
            super("ECDHwithSHA384KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA384()));
        }
    }

    public static class DHwithSHA512CKDF extends KeyAgreementSpi {
        public DHwithSHA512CKDF() {
            super("ECDHwithSHA512CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    public static class DHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA512KDFAndSharedInfo() {
            super("ECDHwithSHA512KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA512()));
        }
    }

    public static class MQV extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), (DerivationFunction) null);
        }
    }

    public static class MQVwithSHA1CKDF extends KeyAgreementSpi {
        public MQVwithSHA1CKDF() {
            super("ECMQVwithSHA1CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA1()));
        }
    }

    public static class MQVwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA1KDFAndSharedInfo() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
        }
    }

    public static class MQVwithSHA224CKDF extends KeyAgreementSpi {
        public MQVwithSHA224CKDF() {
            super("ECMQVwithSHA224CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA224()));
        }
    }

    public static class MQVwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA224KDFAndSharedInfo() {
            super("ECMQVwithSHA224KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA224()));
        }
    }

    public static class MQVwithSHA256CKDF extends KeyAgreementSpi {
        public MQVwithSHA256CKDF() {
            super("ECMQVwithSHA256CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class MQVwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA256KDFAndSharedInfo() {
            super("ECMQVwithSHA256KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class MQVwithSHA384CKDF extends KeyAgreementSpi {
        public MQVwithSHA384CKDF() {
            super("ECMQVwithSHA384CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
        }
    }

    public static class MQVwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA384KDFAndSharedInfo() {
            super("ECMQVwithSHA384KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA384()));
        }
    }

    public static class MQVwithSHA512CKDF extends KeyAgreementSpi {
        public MQVwithSHA512CKDF() {
            super("ECMQVwithSHA512CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    public static class MQVwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA512KDFAndSharedInfo() {
            super("ECMQVwithSHA512KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA512()));
        }
    }

    public KeyAgreementSpi(String str, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        super(str, derivationFunction);
        this.kaAlgorithm = str;
        this.agreement = basicAgreement;
    }

    public static String getSimpleName(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.tuya.spongycastle.crypto.params.ECPublicKeyParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: com.tuya.spongycastle.crypto.params.MQVPrivateParameters} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initFromKey(java.security.Key r6, java.security.spec.AlgorithmParameterSpec r7) {
        /*
            r5 = this;
            com.tuya.spongycastle.crypto.BasicAgreement r0 = r5.agreement
            boolean r0 = r0 instanceof com.tuya.spongycastle.crypto.agreement.ECMQVBasicAgreement
            java.lang.String r1 = " for initialisation"
            java.lang.String r2 = " key agreement requires "
            r3 = 0
            if (r0 == 0) goto L_0x009d
            r5.mqvParameters = r3
            boolean r0 = r6 instanceof com.tuya.spongycastle.jce.interfaces.MQVPrivateKey
            if (r0 != 0) goto L_0x0039
            boolean r4 = r7 instanceof com.tuya.spongycastle.jcajce.spec.MQVParameterSpec
            if (r4 == 0) goto L_0x0016
            goto L_0x0039
        L_0x0016:
            java.security.InvalidKeyException r6 = new java.security.InvalidKeyException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = r5.kaAlgorithm
            r7.append(r0)
            r7.append(r2)
            java.lang.Class<com.tuya.spongycastle.jcajce.spec.MQVParameterSpec> r0 = com.tuya.spongycastle.jcajce.spec.MQVParameterSpec.class
            java.lang.String r0 = getSimpleName(r0)
            r7.append(r0)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0039:
            if (r0 == 0) goto L_0x0063
            com.tuya.spongycastle.jce.interfaces.MQVPrivateKey r6 = (com.tuya.spongycastle.jce.interfaces.MQVPrivateKey) r6
            java.security.PrivateKey r7 = r6.getStaticPrivateKey()
            com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter r7 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r7)
            com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters r7 = (com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters) r7
            java.security.PrivateKey r0 = r6.getEphemeralPrivateKey()
            com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter r0 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r0)
            com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters r0 = (com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters) r0
            java.security.PublicKey r1 = r6.getEphemeralPublicKey()
            if (r1 == 0) goto L_0x0091
            java.security.PublicKey r6 = r6.getEphemeralPublicKey()
            com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter r6 = com.tuya.spongycastle.jcajce.provider.asymmetric.ec.ECUtils.generatePublicKeyParameter(r6)
            r3 = r6
            com.tuya.spongycastle.crypto.params.ECPublicKeyParameters r3 = (com.tuya.spongycastle.crypto.params.ECPublicKeyParameters) r3
            goto L_0x0091
        L_0x0063:
            com.tuya.spongycastle.jcajce.spec.MQVParameterSpec r7 = (com.tuya.spongycastle.jcajce.spec.MQVParameterSpec) r7
            java.security.PrivateKey r6 = (java.security.PrivateKey) r6
            com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter r6 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r6)
            com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters r6 = (com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters) r6
            java.security.PrivateKey r0 = r7.getEphemeralPrivateKey()
            com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter r0 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r0)
            com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters r0 = (com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters) r0
            java.security.PublicKey r1 = r7.getEphemeralPublicKey()
            if (r1 == 0) goto L_0x0088
            java.security.PublicKey r1 = r7.getEphemeralPublicKey()
            com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter r1 = com.tuya.spongycastle.jcajce.provider.asymmetric.ec.ECUtils.generatePublicKeyParameter(r1)
            r3 = r1
            com.tuya.spongycastle.crypto.params.ECPublicKeyParameters r3 = (com.tuya.spongycastle.crypto.params.ECPublicKeyParameters) r3
        L_0x0088:
            r5.mqvParameters = r7
            byte[] r7 = r7.getUserKeyingMaterial()
            r5.ukmParameters = r7
            r7 = r6
        L_0x0091:
            com.tuya.spongycastle.crypto.params.MQVPrivateParameters r6 = new com.tuya.spongycastle.crypto.params.MQVPrivateParameters
            r6.<init>(r7, r0, r3)
            com.tuya.spongycastle.crypto.params.ECDomainParameters r7 = r7.getParameters()
            r5.parameters = r7
            goto L_0x00bb
        L_0x009d:
            boolean r0 = r6 instanceof java.security.PrivateKey
            if (r0 == 0) goto L_0x00c1
            java.security.PrivateKey r6 = (java.security.PrivateKey) r6
            com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter r6 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r6)
            com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters r6 = (com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters) r6
            com.tuya.spongycastle.crypto.params.ECDomainParameters r0 = r6.getParameters()
            r5.parameters = r0
            boolean r0 = r7 instanceof com.tuya.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            if (r0 == 0) goto L_0x00b9
            com.tuya.spongycastle.jcajce.spec.UserKeyingMaterialSpec r7 = (com.tuya.spongycastle.jcajce.spec.UserKeyingMaterialSpec) r7
            byte[] r3 = r7.getUserKeyingMaterial()
        L_0x00b9:
            r5.ukmParameters = r3
        L_0x00bb:
            com.tuya.spongycastle.crypto.BasicAgreement r7 = r5.agreement
            r7.init(r6)
            return
        L_0x00c1:
            java.security.InvalidKeyException r6 = new java.security.InvalidKeyException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = r5.kaAlgorithm
            r7.append(r0)
            r7.append(r2)
            java.lang.Class<com.tuya.spongycastle.jce.interfaces.ECPrivateKey> r0 = com.tuya.spongycastle.jce.interfaces.ECPrivateKey.class
            java.lang.String r0 = getSimpleName(r0)
            r7.append(r0)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi.initFromKey(java.security.Key, java.security.spec.AlgorithmParameterSpec):void");
    }

    public byte[] bigIntToBytes(BigInteger bigInteger) {
        X9IntegerConverter x9IntegerConverter = converter;
        return x9IntegerConverter.integerToBytes(bigInteger, x9IntegerConverter.getByteLength(this.parameters.getCurve()));
    }

    public byte[] calcSecret() {
        return bigIntToBytes(this.result);
    }

    public Key engineDoPhase(Key key, boolean z) {
        CipherParameters cipherParameters;
        if (this.parameters == null) {
            throw new IllegalStateException(a.m(new StringBuilder(), this.kaAlgorithm, " not initialised."));
        } else if (z) {
            if (this.agreement instanceof ECMQVBasicAgreement) {
                if (!(key instanceof MQVPublicKey)) {
                    cipherParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtils.generatePublicKeyParameter((PublicKey) key), (ECPublicKeyParameters) ECUtils.generatePublicKeyParameter(this.mqvParameters.getOtherPartyEphemeralKey()));
                } else {
                    MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
                    cipherParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtils.generatePublicKeyParameter(mQVPublicKey.getStaticKey()), (ECPublicKeyParameters) ECUtils.generatePublicKeyParameter(mQVPublicKey.getEphemeralKey()));
                }
            } else if (key instanceof PublicKey) {
                cipherParameters = ECUtils.generatePublicKeyParameter((PublicKey) key);
            } else {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
            }
            try {
                this.result = this.agreement.calculateAgreement(cipherParameters);
                return null;
            } catch (Exception e2) {
                StringBuilder n = a.n("calculation failed: ");
                n.append(e2.getMessage());
                throw new InvalidKeyException(n.toString()) {
                    public Throwable getCause() {
                        return e2;
                    }
                };
            }
        } else {
            throw new IllegalStateException(a.m(new StringBuilder(), this.kaAlgorithm, " can only be between two parties."));
        }
    }

    public void engineInit(Key key, SecureRandom secureRandom) {
        initFromKey(key, (AlgorithmParameterSpec) null);
    }

    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof MQVParameterSpec) || (algorithmParameterSpec instanceof UserKeyingMaterialSpec)) {
            initFromKey(key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }
}
