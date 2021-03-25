package com.tuya.spongycastle.asn1.sec;

import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.x9.X9ObjectIdentifiers;

public interface SECObjectIdentifiers {
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha224kdf_scheme = secg_scheme.branch("14.0");
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha256kdf_scheme = secg_scheme.branch("14.1");
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha384kdf_scheme = secg_scheme.branch("14.2");
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha512kdf_scheme = secg_scheme.branch("14.3");
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha224kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha256kdf_scheme = secg_scheme.branch("11.1");
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha384kdf_scheme = secg_scheme.branch("11.2");
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha512kdf_scheme = secg_scheme.branch("11.3");
    public static final ASN1ObjectIdentifier ellipticCurve = new ASN1ObjectIdentifier("1.3.132.0");
    public static final ASN1ObjectIdentifier mqvFull_sha224kdf_scheme = secg_scheme.branch("16.0");
    public static final ASN1ObjectIdentifier mqvFull_sha256kdf_scheme = secg_scheme.branch("16.1");
    public static final ASN1ObjectIdentifier mqvFull_sha384kdf_scheme = secg_scheme.branch("16.2");
    public static final ASN1ObjectIdentifier mqvFull_sha512kdf_scheme = secg_scheme.branch("16.3");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha224kdf_scheme = secg_scheme.branch("15.0");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha256kdf_scheme = secg_scheme.branch("15.1");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha384kdf_scheme = secg_scheme.branch("15.2");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha512kdf_scheme = secg_scheme.branch("15.3");
    public static final ASN1ObjectIdentifier secg_scheme;
    public static final ASN1ObjectIdentifier secp256r1 = X9ObjectIdentifiers.prime256v1;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.132.1");
        secg_scheme = aSN1ObjectIdentifier;
        dhSinglePass_stdDH_sha224kdf_scheme = aSN1ObjectIdentifier.branch("11.0");
    }
}
