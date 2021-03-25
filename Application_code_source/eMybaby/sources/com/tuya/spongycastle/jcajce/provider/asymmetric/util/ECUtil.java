package com.tuya.spongycastle.jcajce.provider.asymmetric.util;

import a.a.a.a.a;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.anssi.ANSSINamedCurves;
import com.tuya.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import com.tuya.spongycastle.asn1.gm.GMNamedCurves;
import com.tuya.spongycastle.asn1.nist.NISTNamedCurves;
import com.tuya.spongycastle.asn1.pkcs.PrivateKeyInfo;
import com.tuya.spongycastle.asn1.sec.SECNamedCurves;
import com.tuya.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import com.tuya.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import com.tuya.spongycastle.asn1.x9.ECNamedCurveTable;
import com.tuya.spongycastle.asn1.x9.X962NamedCurves;
import com.tuya.spongycastle.asn1.x9.X9ECParameters;
import com.tuya.spongycastle.crypto.ec.CustomNamedCurves;
import com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.crypto.params.ECNamedDomainParameters;
import com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration;
import com.tuya.spongycastle.jce.interfaces.ECPrivateKey;
import com.tuya.spongycastle.jce.interfaces.ECPublicKey;
import com.tuya.spongycastle.jce.provider.BouncyCastleProvider;
import com.tuya.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import com.tuya.spongycastle.jce.spec.ECParameterSpec;
import com.tuya.spongycastle.math.ec.ECCurve;
import com.tuya.spongycastle.math.ec.ECPoint;
import com.tuya.spongycastle.util.Arrays;
import com.tuya.spongycastle.util.Fingerprint;
import com.tuya.spongycastle.util.Strings;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Enumeration;

public class ECUtil {
    public static ECPoint calculateQ(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        return eCParameterSpec.getG().multiply(bigInteger).normalize();
    }

    public static int[] convertMidTerms(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else if (iArr.length != 3) {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        } else if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
            iArr2[0] = iArr[0];
            if (iArr[1] < iArr[2]) {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[1];
            }
        } else if (iArr[1] < iArr[2]) {
            iArr2[0] = iArr[1];
            if (iArr[0] < iArr[2]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[0];
            }
        } else {
            iArr2[0] = iArr[2];
            if (iArr[0] < iArr[1]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[1];
            } else {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[0];
            }
        }
        return iArr2;
    }

    public static String generateKeyFingerprint(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        ECCurve curve = eCParameterSpec.getCurve();
        return curve != null ? new Fingerprint(Arrays.concatenate(eCPoint.getEncoded(false), curve.getA().getEncoded(), curve.getB().getEncoded(), eCParameterSpec.getG().getEncoded(false))).toString() : new Fingerprint(eCPoint.getEncoded(false)).toString();
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            ECParameterSpec parameters = eCPrivateKey.getParameters();
            if (parameters == null) {
                parameters = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
            }
            return new ECPrivateKeyParameters(eCPrivateKey.getD(), new ECDomainParameters(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
        } else if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey2 = (java.security.interfaces.ECPrivateKey) privateKey;
            ECParameterSpec convertSpec = EC5Util.convertSpec(eCPrivateKey2.getParams(), false);
            return new ECPrivateKeyParameters(eCPrivateKey2.getS(), new ECDomainParameters(convertSpec.getCurve(), convertSpec.getG(), convertSpec.getN(), convertSpec.getH(), convertSpec.getSeed()));
        } else {
            try {
                byte[] encoded = privateKey.getEncoded();
                if (encoded != null) {
                    PrivateKey privateKey2 = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(encoded));
                    if (privateKey2 instanceof java.security.interfaces.ECPrivateKey) {
                        return generatePrivateKeyParameter(privateKey2);
                    }
                    throw new InvalidKeyException("can't identify EC private key.");
                }
                throw new InvalidKeyException("no encoding for EC private key");
            } catch (Exception e2) {
                throw new InvalidKeyException(a.f(e2, a.n("cannot identify EC private key: ")));
            }
        }
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) {
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            ECParameterSpec parameters = eCPublicKey.getParameters();
            return new ECPublicKeyParameters(eCPublicKey.getQ(), new ECDomainParameters(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
        } else if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            java.security.interfaces.ECPublicKey eCPublicKey2 = (java.security.interfaces.ECPublicKey) publicKey;
            ECParameterSpec convertSpec = EC5Util.convertSpec(eCPublicKey2.getParams(), false);
            return new ECPublicKeyParameters(EC5Util.convertPoint(eCPublicKey2.getParams(), eCPublicKey2.getW(), false), new ECDomainParameters(convertSpec.getCurve(), convertSpec.getG(), convertSpec.getN(), convertSpec.getH(), convertSpec.getSeed()));
        } else {
            try {
                byte[] encoded = publicKey.getEncoded();
                if (encoded != null) {
                    PublicKey publicKey2 = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(encoded));
                    if (publicKey2 instanceof java.security.interfaces.ECPublicKey) {
                        return generatePublicKeyParameter(publicKey2);
                    }
                    throw new InvalidKeyException("cannot identify EC public key.");
                }
                throw new InvalidKeyException("no encoding for EC public key");
            } catch (Exception e2) {
                throw new InvalidKeyException(a.f(e2, a.n("cannot identify EC public key: ")));
            }
        }
    }

    public static String getCurveName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String name = X962NamedCurves.getName(aSN1ObjectIdentifier);
        if (name != null) {
            return name;
        }
        String name2 = SECNamedCurves.getName(aSN1ObjectIdentifier);
        if (name2 == null) {
            name2 = NISTNamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name2 == null) {
            name2 = TeleTrusTNamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name2 == null) {
            name2 = ECGOST3410NamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name2 == null) {
            name2 = ANSSINamedCurves.getName(aSN1ObjectIdentifier);
        }
        return name2 == null ? GMNamedCurves.getName(aSN1ObjectIdentifier) : name2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: com.tuya.spongycastle.asn1.x9.X9ECParameters} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tuya.spongycastle.crypto.params.ECDomainParameters getDomainParameters(com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration r7, com.tuya.spongycastle.asn1.x9.X962Parameters r8) {
        /*
            boolean r0 = r8.isNamedCurve()
            if (r0 == 0) goto L_0x003a
            com.tuya.spongycastle.asn1.ASN1Primitive r8 = r8.getParameters()
            com.tuya.spongycastle.asn1.ASN1ObjectIdentifier r1 = com.tuya.spongycastle.asn1.ASN1ObjectIdentifier.getInstance(r8)
            com.tuya.spongycastle.asn1.x9.X9ECParameters r8 = getNamedCurveByOid(r1)
            if (r8 != 0) goto L_0x001f
            java.util.Map r7 = r7.getAdditionalECParameters()
            java.lang.Object r7 = r7.get(r1)
            r8 = r7
            com.tuya.spongycastle.asn1.x9.X9ECParameters r8 = (com.tuya.spongycastle.asn1.x9.X9ECParameters) r8
        L_0x001f:
            com.tuya.spongycastle.crypto.params.ECNamedDomainParameters r7 = new com.tuya.spongycastle.crypto.params.ECNamedDomainParameters
            com.tuya.spongycastle.math.ec.ECCurve r2 = r8.getCurve()
            com.tuya.spongycastle.math.ec.ECPoint r3 = r8.getG()
            java.math.BigInteger r4 = r8.getN()
            java.math.BigInteger r5 = r8.getH()
            byte[] r6 = r8.getSeed()
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x0082
        L_0x003a:
            boolean r0 = r8.isImplicitlyCA()
            if (r0 == 0) goto L_0x005f
            com.tuya.spongycastle.jce.spec.ECParameterSpec r7 = r7.getEcImplicitlyCa()
            com.tuya.spongycastle.crypto.params.ECDomainParameters r8 = new com.tuya.spongycastle.crypto.params.ECDomainParameters
            com.tuya.spongycastle.math.ec.ECCurve r1 = r7.getCurve()
            com.tuya.spongycastle.math.ec.ECPoint r2 = r7.getG()
            java.math.BigInteger r3 = r7.getN()
            java.math.BigInteger r4 = r7.getH()
            byte[] r5 = r7.getSeed()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0081
        L_0x005f:
            com.tuya.spongycastle.asn1.ASN1Primitive r7 = r8.getParameters()
            com.tuya.spongycastle.asn1.x9.X9ECParameters r7 = com.tuya.spongycastle.asn1.x9.X9ECParameters.getInstance(r7)
            com.tuya.spongycastle.crypto.params.ECDomainParameters r8 = new com.tuya.spongycastle.crypto.params.ECDomainParameters
            com.tuya.spongycastle.math.ec.ECCurve r1 = r7.getCurve()
            com.tuya.spongycastle.math.ec.ECPoint r2 = r7.getG()
            java.math.BigInteger r3 = r7.getN()
            java.math.BigInteger r4 = r7.getH()
            byte[] r5 = r7.getSeed()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0081:
            r7 = r8
        L_0x0082:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getDomainParameters(com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration, com.tuya.spongycastle.asn1.x9.X962Parameters):com.tuya.spongycastle.crypto.params.ECDomainParameters");
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            ECNamedCurveParameterSpec eCNamedCurveParameterSpec = (ECNamedCurveParameterSpec) eCParameterSpec;
            return new ECNamedDomainParameters(getNamedCurveOid(eCNamedCurveParameterSpec.getName()), eCNamedCurveParameterSpec.getCurve(), eCNamedCurveParameterSpec.getG(), eCNamedCurveParameterSpec.getN(), eCNamedCurveParameterSpec.getH(), eCNamedCurveParameterSpec.getSeed());
        } else if (eCParameterSpec != null) {
            return new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed());
        } else {
            ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
            return new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed());
        }
    }

    public static X9ECParameters getNamedCurveByName(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        if (byName != null) {
            return byName;
        }
        X9ECParameters byName2 = X962NamedCurves.getByName(str);
        if (byName2 == null) {
            byName2 = SECNamedCurves.getByName(str);
        }
        if (byName2 == null) {
            byName2 = NISTNamedCurves.getByName(str);
        }
        if (byName2 == null) {
            byName2 = TeleTrusTNamedCurves.getByName(str);
        }
        if (byName2 == null) {
            byName2 = ANSSINamedCurves.getByName(str);
        }
        return byName2 == null ? GMNamedCurves.getByName(str) : byName2;
    }

    public static X9ECParameters getNamedCurveByOid(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        if (byOID != null) {
            return byOID;
        }
        X9ECParameters byOID2 = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
        if (byOID2 == null) {
            byOID2 = SECNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID2 == null) {
            byOID2 = NISTNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID2 == null) {
            byOID2 = TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID2 == null) {
            byOID2 = ANSSINamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        return byOID2 == null ? GMNamedCurves.getByOID(aSN1ObjectIdentifier) : byOID2;
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(ECParameterSpec eCParameterSpec) {
        Enumeration names = ECNamedCurveTable.getNames();
        while (names.hasMoreElements()) {
            String str = (String) names.nextElement();
            X9ECParameters byName = ECNamedCurveTable.getByName(str);
            if (byName.getN().equals(eCParameterSpec.getN()) && byName.getH().equals(eCParameterSpec.getH()) && byName.getCurve().equals(eCParameterSpec.getCurve()) && byName.getG().equals(eCParameterSpec.getG())) {
                return ECNamedCurveTable.getOID(str);
            }
        }
        return null;
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(String str) {
        if (str.indexOf(32) > 0) {
            str = str.substring(str.indexOf(32) + 1);
        }
        try {
            return (str.charAt(0) < '0' || str.charAt(0) > '2') ? lookupOidByName(str) : new ASN1ObjectIdentifier(str);
        } catch (IllegalArgumentException unused) {
            return lookupOidByName(str);
        }
    }

    public static int getOrderBitLength(ProviderConfiguration providerConfiguration, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
        return ecImplicitlyCa == null ? bigInteger2.bitLength() : ecImplicitlyCa.getN().bitLength();
    }

    public static ASN1ObjectIdentifier lookupOidByName(String str) {
        ASN1ObjectIdentifier oid = X962NamedCurves.getOID(str);
        if (oid != null) {
            return oid;
        }
        ASN1ObjectIdentifier oid2 = SECNamedCurves.getOID(str);
        if (oid2 == null) {
            oid2 = NISTNamedCurves.getOID(str);
        }
        if (oid2 == null) {
            oid2 = TeleTrusTNamedCurves.getOID(str);
        }
        if (oid2 == null) {
            oid2 = ECGOST3410NamedCurves.getOID(str);
        }
        if (oid2 == null) {
            oid2 = ANSSINamedCurves.getOID(str);
        }
        return oid2 == null ? GMNamedCurves.getOID(str) : oid2;
    }

    public static String privateKeyToString(String str, BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        ECPoint calculateQ = calculateQ(bigInteger, eCParameterSpec);
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(generateKeyFingerprint(calculateQ, eCParameterSpec));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(calculateQ.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(calculateQ.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public static String publicKeyToString(String str, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(generateKeyFingerprint(eCPoint, eCParameterSpec));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(eCPoint.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(eCPoint.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }
}
