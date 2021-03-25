package com.tuya.spongycastle.asn1.eac;

import com.tuya.smart.common.OO000o0;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;

public interface EACObjectIdentifiers {
    public static final ASN1ObjectIdentifier bsi_de;
    public static final ASN1ObjectIdentifier id_CA;
    public static final ASN1ObjectIdentifier id_CA_DH;
    public static final ASN1ObjectIdentifier id_CA_DH_3DES_CBC_CBC;
    public static final ASN1ObjectIdentifier id_CA_ECDH;
    public static final ASN1ObjectIdentifier id_CA_ECDH_3DES_CBC_CBC;
    public static final ASN1ObjectIdentifier id_EAC_ePassport = bsi_de.branch("3.1.2.1");
    public static final ASN1ObjectIdentifier id_PK;
    public static final ASN1ObjectIdentifier id_PK_DH;
    public static final ASN1ObjectIdentifier id_PK_ECDH = id_PK.branch("2");
    public static final ASN1ObjectIdentifier id_TA;
    public static final ASN1ObjectIdentifier id_TA_ECDSA;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_1;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_224 = id_TA_ECDSA.branch("2");
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_256 = id_TA_ECDSA.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_384 = id_TA_ECDSA.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_512 = id_TA_ECDSA.branch("5");
    public static final ASN1ObjectIdentifier id_TA_RSA;
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_1 = id_TA_RSA.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_256 = id_TA_RSA.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_512 = id_TA_RSA.branch("6");
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_1;
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_256 = id_TA_RSA.branch("2");
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_512 = id_TA_RSA.branch("5");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("2.2.1");
        id_PK = branch;
        id_PK_DH = branch.branch("1");
        ASN1ObjectIdentifier branch2 = bsi_de.branch("2.2.3");
        id_CA = branch2;
        ASN1ObjectIdentifier branch3 = branch2.branch("1");
        id_CA_DH = branch3;
        id_CA_DH_3DES_CBC_CBC = branch3.branch("1");
        ASN1ObjectIdentifier branch4 = id_CA.branch("2");
        id_CA_ECDH = branch4;
        id_CA_ECDH_3DES_CBC_CBC = branch4.branch("1");
        ASN1ObjectIdentifier branch5 = bsi_de.branch("2.2.2");
        id_TA = branch5;
        ASN1ObjectIdentifier branch6 = branch5.branch("1");
        id_TA_RSA = branch6;
        id_TA_RSA_v1_5_SHA_1 = branch6.branch("1");
        ASN1ObjectIdentifier branch7 = id_TA.branch("2");
        id_TA_ECDSA = branch7;
        id_TA_ECDSA_SHA_1 = branch7.branch("1");
    }
}
