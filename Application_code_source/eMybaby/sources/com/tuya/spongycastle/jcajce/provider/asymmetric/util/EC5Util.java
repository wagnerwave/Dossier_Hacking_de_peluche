package com.tuya.spongycastle.jcajce.provider.asymmetric.util;

import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.x9.ECNamedCurveTable;
import com.tuya.spongycastle.asn1.x9.X962Parameters;
import com.tuya.spongycastle.asn1.x9.X9ECParameters;
import com.tuya.spongycastle.crypto.ec.CustomNamedCurves;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration;
import com.tuya.spongycastle.jce.provider.BouncyCastleProvider;
import com.tuya.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import com.tuya.spongycastle.jce.spec.ECNamedCurveSpec;
import com.tuya.spongycastle.math.ec.ECAlgorithms;
import com.tuya.spongycastle.math.ec.ECCurve;
import com.tuya.spongycastle.math.ec.ECPoint;
import com.tuya.spongycastle.math.field.FiniteField;
import com.tuya.spongycastle.math.field.Polynomial;
import com.tuya.spongycastle.math.field.PolynomialExtensionField;
import com.tuya.spongycastle.util.Arrays;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class EC5Util {
    public static Map customCurves = new HashMap();

    static {
        Enumeration names = CustomNamedCurves.getNames();
        while (names.hasMoreElements()) {
            String str = (String) names.nextElement();
            X9ECParameters byName = ECNamedCurveTable.getByName(str);
            if (byName != null) {
                customCurves.put(byName.getCurve(), CustomNamedCurves.getByName(str).getCurve());
            }
        }
        X9ECParameters byName2 = CustomNamedCurves.getByName("Curve25519");
        customCurves.put(new ECCurve.Fp(byName2.getCurve().getField().getCharacteristic(), byName2.getCurve().getA().toBigInteger(), byName2.getCurve().getB().toBigInteger()), byName2.getCurve());
    }

    public static ECCurve convertCurve(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a2 = ellipticCurve.getA();
        BigInteger b2 = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            ECCurve.Fp fp = new ECCurve.Fp(((ECFieldFp) field).getP(), a2, b2);
            return customCurves.containsKey(fp) ? (ECCurve) customCurves.get(fp) : fp;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] convertMidTerms = ECUtil.convertMidTerms(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new ECCurve.F2m(m, convertMidTerms[0], convertMidTerms[1], convertMidTerms[2], a2, b2);
    }

    public static EllipticCurve convertCurve(ECCurve eCCurve, byte[] bArr) {
        return new EllipticCurve(convertField(eCCurve.getField()), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), (byte[]) null);
    }

    public static ECField convertField(FiniteField finiteField) {
        if (ECAlgorithms.isFpField(finiteField)) {
            return new ECFieldFp(finiteField.getCharacteristic());
        }
        Polynomial minimalPolynomial = ((PolynomialExtensionField) finiteField).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), Arrays.reverse(Arrays.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    public static ECPoint convertPoint(ECCurve eCCurve, java.security.spec.ECPoint eCPoint, boolean z) {
        return eCCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ECPoint convertPoint(ECParameterSpec eCParameterSpec, java.security.spec.ECPoint eCPoint, boolean z) {
        return convertPoint(convertCurve(eCParameterSpec.getCurve()), eCPoint, z);
    }

    public static com.tuya.spongycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec eCParameterSpec, boolean z) {
        ECCurve convertCurve = convertCurve(eCParameterSpec.getCurve());
        return new com.tuya.spongycastle.jce.spec.ECParameterSpec(convertCurve, convertPoint(convertCurve, eCParameterSpec.getGenerator(), z), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, com.tuya.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        if (!(eCParameterSpec instanceof ECNamedCurveParameterSpec)) {
            return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        }
        return new ECNamedCurveSpec(((ECNamedCurveParameterSpec) eCParameterSpec).getName(), ellipticCurve, new java.security.spec.ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH());
    }

    public static ECParameterSpec convertToSpec(X962Parameters x962Parameters, ECCurve eCCurve) {
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) x962Parameters.getParameters();
            X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier);
            if (namedCurveByOid == null) {
                Map additionalECParameters = BouncyCastleProvider.CONFIGURATION.getAdditionalECParameters();
                if (!additionalECParameters.isEmpty()) {
                    namedCurveByOid = (X9ECParameters) additionalECParameters.get(aSN1ObjectIdentifier);
                }
            }
            return new ECNamedCurveSpec(ECUtil.getCurveName(aSN1ObjectIdentifier), convertCurve(eCCurve, namedCurveByOid.getSeed()), new java.security.spec.ECPoint(namedCurveByOid.getG().getAffineXCoord().toBigInteger(), namedCurveByOid.getG().getAffineYCoord().toBigInteger()), namedCurveByOid.getN(), namedCurveByOid.getH());
        } else if (x962Parameters.isImplicitlyCA()) {
            return null;
        } else {
            X9ECParameters instance = X9ECParameters.getInstance(x962Parameters.getParameters());
            EllipticCurve convertCurve = convertCurve(eCCurve, instance.getSeed());
            return instance.getH() != null ? new ECParameterSpec(convertCurve, new java.security.spec.ECPoint(instance.getG().getAffineXCoord().toBigInteger(), instance.getG().getAffineYCoord().toBigInteger()), instance.getN(), instance.getH().intValue()) : new ECParameterSpec(convertCurve, new java.security.spec.ECPoint(instance.getG().getAffineXCoord().toBigInteger(), instance.getG().getAffineYCoord().toBigInteger()), instance.getN(), 1);
        }
    }

    public static ECParameterSpec convertToSpec(X9ECParameters x9ECParameters) {
        return new ECParameterSpec(convertCurve(x9ECParameters.getCurve(), (byte[]) null), new java.security.spec.ECPoint(x9ECParameters.getG().getAffineXCoord().toBigInteger(), x9ECParameters.getG().getAffineYCoord().toBigInteger()), x9ECParameters.getN(), x9ECParameters.getH().intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.tuya.spongycastle.asn1.x9.X9ECParameters} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tuya.spongycastle.math.ec.ECCurve getCurve(com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration r2, com.tuya.spongycastle.asn1.x9.X962Parameters r3) {
        /*
            java.util.Set r0 = r2.getAcceptableNamedCurves()
            boolean r1 = r3.isNamedCurve()
            if (r1 == 0) goto L_0x003d
            com.tuya.spongycastle.asn1.ASN1Primitive r3 = r3.getParameters()
            com.tuya.spongycastle.asn1.ASN1ObjectIdentifier r3 = com.tuya.spongycastle.asn1.ASN1ObjectIdentifier.getInstance(r3)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0027
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "named curve not acceptable"
            r2.<init>(r3)
            throw r2
        L_0x0027:
            com.tuya.spongycastle.asn1.x9.X9ECParameters r0 = com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r3)
            if (r0 != 0) goto L_0x0038
            java.util.Map r2 = r2.getAdditionalECParameters()
            java.lang.Object r2 = r2.get(r3)
            r0 = r2
            com.tuya.spongycastle.asn1.x9.X9ECParameters r0 = (com.tuya.spongycastle.asn1.x9.X9ECParameters) r0
        L_0x0038:
            com.tuya.spongycastle.math.ec.ECCurve r2 = r0.getCurve()
            goto L_0x005e
        L_0x003d:
            boolean r1 = r3.isImplicitlyCA()
            if (r1 == 0) goto L_0x004c
            com.tuya.spongycastle.jce.spec.ECParameterSpec r2 = r2.getEcImplicitlyCa()
            com.tuya.spongycastle.math.ec.ECCurve r2 = r2.getCurve()
            goto L_0x005e
        L_0x004c:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x005f
            com.tuya.spongycastle.asn1.ASN1Primitive r2 = r3.getParameters()
            com.tuya.spongycastle.asn1.x9.X9ECParameters r2 = com.tuya.spongycastle.asn1.x9.X9ECParameters.getInstance(r2)
            com.tuya.spongycastle.math.ec.ECCurve r2 = r2.getCurve()
        L_0x005e:
            return r2
        L_0x005f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "encoded parameters not acceptable"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.spongycastle.jcajce.provider.asymmetric.util.EC5Util.getCurve(com.tuya.spongycastle.jcajce.provider.config.ProviderConfiguration, com.tuya.spongycastle.asn1.x9.X962Parameters):com.tuya.spongycastle.math.ec.ECCurve");
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return ECUtil.getDomainParameters(providerConfiguration, convertSpec(eCParameterSpec, false));
        }
        com.tuya.spongycastle.jce.spec.ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
        return new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed());
    }
}
