package com.tuya.spongycastle.asn1.misc;

import com.tuya.smart.common.OO000o0;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;

public interface MiscObjectIdentifiers {
    public static final ASN1ObjectIdentifier as_sys_sec_alg_ideaCBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
    public static final ASN1ObjectIdentifier blake2;
    public static final ASN1ObjectIdentifier cast5CBC = entrust.branch("66.10");
    public static final ASN1ObjectIdentifier cryptlib;
    public static final ASN1ObjectIdentifier cryptlib_algorithm;
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_CBC = cryptlib_algorithm.branch("1.2");
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_CFB = cryptlib_algorithm.branch("1.3");
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_ECB;
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_OFB = cryptlib_algorithm.branch("1.4");
    public static final ASN1ObjectIdentifier entrust;
    public static final ASN1ObjectIdentifier entrustVersionExtension;
    public static final ASN1ObjectIdentifier id_blake2b160;
    public static final ASN1ObjectIdentifier id_blake2b256 = blake2.branch("1.8");
    public static final ASN1ObjectIdentifier id_blake2b384 = blake2.branch("1.12");
    public static final ASN1ObjectIdentifier id_blake2b512 = blake2.branch("1.16");
    public static final ASN1ObjectIdentifier netscape;
    public static final ASN1ObjectIdentifier netscapeBaseURL = netscape.branch("2");
    public static final ASN1ObjectIdentifier netscapeCARevocationURL = netscape.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier netscapeCApolicyURL = netscape.branch("8");
    public static final ASN1ObjectIdentifier netscapeCertComment = netscape.branch("13");
    public static final ASN1ObjectIdentifier netscapeCertType;
    public static final ASN1ObjectIdentifier netscapeRenewalURL = netscape.branch("7");
    public static final ASN1ObjectIdentifier netscapeRevocationURL = netscape.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier netscapeSSLServerName = netscape.branch("12");
    public static final ASN1ObjectIdentifier novell;
    public static final ASN1ObjectIdentifier novellSecurityAttribs;
    public static final ASN1ObjectIdentifier verisign;
    public static final ASN1ObjectIdentifier verisignBitString_6_13 = verisign.branch("6.13");
    public static final ASN1ObjectIdentifier verisignCzagExtension;
    public static final ASN1ObjectIdentifier verisignDnbDunsNumber = verisign.branch("6.15");
    public static final ASN1ObjectIdentifier verisignIssStrongCrypto = verisign.branch("8.1");
    public static final ASN1ObjectIdentifier verisignOnSiteJurisdictionHash = verisign.branch("6.11");
    public static final ASN1ObjectIdentifier verisignPrivate_6_9 = verisign.branch("6.9");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113730.1");
        netscape = aSN1ObjectIdentifier;
        netscapeCertType = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.16.840.1.113733.1");
        verisign = aSN1ObjectIdentifier2;
        verisignCzagExtension = aSN1ObjectIdentifier2.branch("6.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.16.840.1.113719");
        novell = aSN1ObjectIdentifier3;
        novellSecurityAttribs = aSN1ObjectIdentifier3.branch("1.9.4.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("1.2.840.113533.7");
        entrust = aSN1ObjectIdentifier4;
        entrustVersionExtension = aSN1ObjectIdentifier4.branch("65.0");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.3.6.1.4.1.3029");
        cryptlib = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier5.branch("1");
        cryptlib_algorithm = branch;
        cryptlib_algorithm_blowfish_ECB = branch.branch("1.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("1.3.6.1.4.1.1722.12.2");
        blake2 = aSN1ObjectIdentifier6;
        id_blake2b160 = aSN1ObjectIdentifier6.branch("1.5");
    }
}
