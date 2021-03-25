package com.tuya.spongycastle.asn1.x509;

import a.a.a.a.a;
import com.tuya.smart.common.OO0000o;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;

public interface X509ObjectIdentifiers {
    public static final ASN1ObjectIdentifier commonName = a.c("2.5.4.3");
    public static final ASN1ObjectIdentifier countryName = a.c("2.5.4.6");
    public static final ASN1ObjectIdentifier crlAccessMethod = id_ad_caIssuers;
    public static final ASN1ObjectIdentifier id_SHA1 = a.c("1.3.14.3.2.26");
    public static final ASN1ObjectIdentifier id_ad;
    public static final ASN1ObjectIdentifier id_ad_caIssuers;
    public static final ASN1ObjectIdentifier id_ad_ocsp;
    public static final ASN1ObjectIdentifier id_at_name = a.c("2.5.4.41");
    public static final ASN1ObjectIdentifier id_at_organizationIdentifier = a.c("2.5.4.97");
    public static final ASN1ObjectIdentifier id_at_telephoneNumber = a.c("2.5.4.20");
    public static final ASN1ObjectIdentifier id_ce = new ASN1ObjectIdentifier("2.5.29");
    public static final ASN1ObjectIdentifier id_ea_rsa = a.c("2.5.8.1.1");
    public static final ASN1ObjectIdentifier id_pe;
    public static final ASN1ObjectIdentifier id_pkix;
    public static final ASN1ObjectIdentifier localityName = a.c("2.5.4.7");
    public static final ASN1ObjectIdentifier ocspAccessMethod;
    public static final ASN1ObjectIdentifier organization = a.c("2.5.4.10");
    public static final ASN1ObjectIdentifier organizationalUnitName = a.c("2.5.4.11");
    public static final ASN1ObjectIdentifier ripemd160 = a.c("1.3.36.3.2.1");
    public static final ASN1ObjectIdentifier ripemd160WithRSAEncryption = a.c("1.3.36.3.3.1.2");
    public static final ASN1ObjectIdentifier stateOrProvinceName = a.c("2.5.4.8");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = aSN1ObjectIdentifier;
        id_pe = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier branch = id_pkix.branch(OO0000o.O0000Oo);
        id_ad = branch;
        id_ad_caIssuers = branch.branch("2").intern();
        ASN1ObjectIdentifier intern = id_ad.branch("1").intern();
        id_ad_ocsp = intern;
        ocspAccessMethod = intern;
    }
}
