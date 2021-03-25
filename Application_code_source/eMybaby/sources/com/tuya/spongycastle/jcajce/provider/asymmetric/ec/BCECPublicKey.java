package com.tuya.spongycastle.jcajce.provider.asymmetric.ec;

import com.tuya.spongycastle.asn1.ASN1OctetString;
import com.tuya.spongycastle.asn1.ASN1Primitive;
import com.tuya.spongycastle.asn1.x509.AlgorithmIdentifier;
import com.tuya.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import com.tuya.spongycastle.asn1.x9.X9ECPoint;
import com.tuya.spongycastle.asn1.x9.X9ObjectIdentifiers;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.tuya.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration;
import com.tuya.spongycastle.jce.interfaces.ECPointEncoder;
import com.tuya.spongycastle.jce.interfaces.ECPublicKey;
import com.tuya.spongycastle.jce.provider.BouncyCastleProvider;
import com.tuya.spongycastle.jce.spec.ECPublicKeySpec;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public class BCECPublicKey implements ECPointEncoder, ECPublicKey, java.security.interfaces.ECPublicKey {
    public static final long serialVersionUID = 2422789860422731812L;
    public String algorithm = "EC";
    public transient ProviderConfiguration configuration;
    public transient ECPublicKeyParameters ecPublicKey;
    public transient ECParameterSpec ecSpec;
    public boolean withCompression;

    public BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.configuration = providerConfiguration;
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.ecSpec = null;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, com.tuya.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecSpec = eCParameterSpec == null ? createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters) : EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        this.ecPublicKey = eCPublicKeyParameters;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, BCECPublicKey bCECPublicKey) {
        this.algorithm = str;
        this.ecPublicKey = bCECPublicKey.ecPublicKey;
        this.ecSpec = bCECPublicKey.ecSpec;
        this.withCompression = bCECPublicKey.withCompression;
        this.configuration = bCECPublicKey.configuration;
    }

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.getQ(), ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.ecSpec = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
        } else {
            this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(providerConfiguration, (ECParameterSpec) null));
            this.ecSpec = null;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, java.security.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKeySpec.getW(), false), EC5Util.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(java.security.interfaces.ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKey.getW(), false), EC5Util.getDomainParameters(providerConfiguration, eCPublicKey.getParams()));
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new ECPoint(eCDomainParameters.getG().getAffineXCoord().toBigInteger(), eCDomainParameters.getG().getAffineYCoord().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    /* JADX WARNING: type inference failed for: r7v6, types: [com.tuya.spongycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(com.tuya.spongycastle.asn1.x509.SubjectPublicKeyInfo r7) {
        /*
            r6 = this;
            com.tuya.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r7.getAlgorithm()
            com.tuya.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.tuya.spongycastle.asn1.x9.X962Parameters r0 = com.tuya.spongycastle.asn1.x9.X962Parameters.getInstance(r0)
            com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration r1 = r6.configuration
            com.tuya.spongycastle.math.ec.ECCurve r1 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.EC5Util.getCurve(r1, r0)
            java.security.spec.ECParameterSpec r2 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.EC5Util.convertToSpec(r0, r1)
            r6.ecSpec = r2
            com.tuya.spongycastle.asn1.DERBitString r7 = r7.getPublicKeyData()
            byte[] r7 = r7.getBytes()
            com.tuya.spongycastle.asn1.DEROctetString r2 = new com.tuya.spongycastle.asn1.DEROctetString
            r2.<init>((byte[]) r7)
            r3 = 0
            byte r3 = r7[r3]
            r4 = 4
            if (r3 != r4) goto L_0x0059
            r3 = 1
            byte r3 = r7[r3]
            int r4 = r7.length
            r5 = 2
            int r4 = r4 - r5
            if (r3 != r4) goto L_0x0059
            byte r3 = r7[r5]
            r4 = 3
            if (r3 == r5) goto L_0x003c
            byte r3 = r7[r5]
            if (r3 != r4) goto L_0x0059
        L_0x003c:
            com.tuya.spongycastle.asn1.x9.X9IntegerConverter r3 = new com.tuya.spongycastle.asn1.x9.X9IntegerConverter
            r3.<init>()
            int r3 = r3.getByteLength((com.tuya.spongycastle.math.ec.ECCurve) r1)
            int r5 = r7.length
            int r5 = r5 - r4
            if (r3 < r5) goto L_0x0059
            com.tuya.spongycastle.asn1.ASN1Primitive r7 = com.tuya.spongycastle.asn1.ASN1Primitive.fromByteArray(r7)     // Catch:{ IOException -> 0x0051 }
            r2 = r7
            com.tuya.spongycastle.asn1.ASN1OctetString r2 = (com.tuya.spongycastle.asn1.ASN1OctetString) r2     // Catch:{ IOException -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r7.<init>(r0)
            throw r7
        L_0x0059:
            com.tuya.spongycastle.asn1.x9.X9ECPoint r7 = new com.tuya.spongycastle.asn1.x9.X9ECPoint
            r7.<init>((com.tuya.spongycastle.math.ec.ECCurve) r1, (com.tuya.spongycastle.asn1.ASN1OctetString) r2)
            com.tuya.spongycastle.crypto.params.ECPublicKeyParameters r1 = new com.tuya.spongycastle.crypto.params.ECPublicKeyParameters
            com.tuya.spongycastle.math.ec.ECPoint r7 = r7.getPoint()
            com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration r2 = r6.configuration
            com.tuya.spongycastle.crypto.params.ECDomainParameters r0 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getDomainParameters((com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration) r2, (com.tuya.spongycastle.asn1.x9.X962Parameters) r0)
            r1.<init>(r7, r0)
            r6.ecPublicKey = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey.populateFromPubKeyInfo(com.tuya.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.configuration = BouncyCastleProvider.CONFIGURATION;
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public ECPublicKeyParameters engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    public com.tuya.spongycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec, this.withCompression) : this.configuration.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        return this.ecPublicKey.getQ().equals(bCECPublicKey.ecPublicKey.getQ()) && engineGetSpec().equals(bCECPublicKey.engineGetSpec());
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, ECUtils.getDomainParametersFromName(this.ecSpec, this.withCompression)), ASN1OctetString.getInstance(new X9ECPoint(this.ecPublicKey.getQ(), this.withCompression).toASN1Primitive()).getOctets()));
    }

    public String getFormat() {
        return "X.509";
    }

    public com.tuya.spongycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec, this.withCompression);
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public com.tuya.spongycastle.math.ec.ECPoint getQ() {
        com.tuya.spongycastle.math.ec.ECPoint q = this.ecPublicKey.getQ();
        return this.ecSpec == null ? q.getDetachedPoint() : q;
    }

    public ECPoint getW() {
        com.tuya.spongycastle.math.ec.ECPoint q = this.ecPublicKey.getQ();
        return new ECPoint(q.getAffineXCoord().toBigInteger(), q.getAffineYCoord().toBigInteger());
    }

    public int hashCode() {
        return this.ecPublicKey.getQ().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return ECUtil.publicKeyToString("EC", this.ecPublicKey.getQ(), engineGetSpec());
    }
}
