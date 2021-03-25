package com.tuya.spongycastle.asn1.pkcs;

import a.a.a.a.a;
import com.tuya.smart.common.OO0000o;
import com.tuya.smart.common.OO000o0;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;

public interface PKCSObjectIdentifiers {
    public static final ASN1ObjectIdentifier RC2_CBC = encryptionAlgorithm.branch("2");
    public static final ASN1ObjectIdentifier bagtypes;
    public static final ASN1ObjectIdentifier canNotDecryptAny = pkcs_9.branch("15.2");
    public static final ASN1ObjectIdentifier certBag = bagtypes.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier certTypes;
    public static final ASN1ObjectIdentifier crlBag = bagtypes.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier crlTypes;
    public static final ASN1ObjectIdentifier data = a.c("1.2.840.113549.1.7.1");
    public static final ASN1ObjectIdentifier des_EDE3_CBC;
    public static final ASN1ObjectIdentifier dhKeyAgreement;
    public static final ASN1ObjectIdentifier digestAlgorithm;
    public static final ASN1ObjectIdentifier digestedData = a.c("1.2.840.113549.1.7.5");
    public static final ASN1ObjectIdentifier encryptedData = a.c("1.2.840.113549.1.7.6");
    public static final ASN1ObjectIdentifier encryptionAlgorithm;
    public static final ASN1ObjectIdentifier envelopedData = a.c("1.2.840.113549.1.7.3");
    public static final ASN1ObjectIdentifier id_PBES2 = pkcs_5.branch("13");
    public static final ASN1ObjectIdentifier id_PBKDF2 = pkcs_5.branch("12");
    public static final ASN1ObjectIdentifier id_RSAES_OAEP = pkcs_1.branch("7");
    public static final ASN1ObjectIdentifier id_RSASSA_PSS = pkcs_1.branch("10");
    public static final ASN1ObjectIdentifier id_aa;
    public static final ASN1ObjectIdentifier id_aa_asymmDecryptKeyID = id_aa.branch("54");
    public static final ASN1ObjectIdentifier id_aa_cmsAlgorithmProtect = pkcs_9.branch("52").intern();
    public static final ASN1ObjectIdentifier id_aa_commitmentType = id_aa_ets_commitmentType;
    public static final ASN1ObjectIdentifier id_aa_communityIdentifiers = id_aa.branch("40");
    public static final ASN1ObjectIdentifier id_aa_contentHint = id_aa.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier id_aa_contentIdentifier = id_aa.branch("7");
    public static final ASN1ObjectIdentifier id_aa_contentReference = id_aa.branch("10");
    public static final ASN1ObjectIdentifier id_aa_decryptKeyID = id_aa.branch("37");
    public static final ASN1ObjectIdentifier id_aa_encrypKeyPref = id_aa.branch("11");
    public static final ASN1ObjectIdentifier id_aa_ets_archiveTimestamp = id_aa.branch("27");
    public static final ASN1ObjectIdentifier id_aa_ets_certCRLTimestamp = id_aa.branch("26");
    public static final ASN1ObjectIdentifier id_aa_ets_certValues = id_aa.branch("23");
    public static final ASN1ObjectIdentifier id_aa_ets_certificateRefs = id_aa.branch("21");
    public static final ASN1ObjectIdentifier id_aa_ets_commitmentType;
    public static final ASN1ObjectIdentifier id_aa_ets_contentTimestamp = id_aa.branch("20");
    public static final ASN1ObjectIdentifier id_aa_ets_escTimeStamp = id_aa.branch("25");
    public static final ASN1ObjectIdentifier id_aa_ets_otherSigCert = id_aa.branch("19");
    public static final ASN1ObjectIdentifier id_aa_ets_revocationRefs = id_aa.branch("22");
    public static final ASN1ObjectIdentifier id_aa_ets_revocationValues = id_aa.branch("24");
    public static final ASN1ObjectIdentifier id_aa_ets_sigPolicyId;
    public static final ASN1ObjectIdentifier id_aa_ets_signerAttr = id_aa.branch("18");
    public static final ASN1ObjectIdentifier id_aa_ets_signerLocation = id_aa.branch("17");
    public static final ASN1ObjectIdentifier id_aa_implCompressAlgs = id_aa.branch(OO0000o.O00000oO);
    public static final ASN1ObjectIdentifier id_aa_implCryptoAlgs = id_aa.branch("38");
    public static final ASN1ObjectIdentifier id_aa_msgSigDigest = id_aa.branch("5");
    public static final ASN1ObjectIdentifier id_aa_otherSigCert = id_aa_ets_otherSigCert;
    public static final ASN1ObjectIdentifier id_aa_receiptRequest;
    public static final ASN1ObjectIdentifier id_aa_sigPolicyId = id_aa_ets_sigPolicyId;
    public static final ASN1ObjectIdentifier id_aa_signatureTimeStampToken = id_aa.branch("14");
    public static final ASN1ObjectIdentifier id_aa_signerLocation = id_aa_ets_signerLocation;
    public static final ASN1ObjectIdentifier id_aa_signingCertificate = id_aa.branch("12");
    public static final ASN1ObjectIdentifier id_aa_signingCertificateV2 = id_aa.branch(OO0000o.O0000Oo0);
    public static final ASN1ObjectIdentifier id_alg;
    public static final ASN1ObjectIdentifier id_alg_CMS3DESwrap = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.6");
    public static final ASN1ObjectIdentifier id_alg_CMSRC2wrap = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.7");
    public static final ASN1ObjectIdentifier id_alg_ESDH = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.5");
    public static final ASN1ObjectIdentifier id_alg_PWRI_KEK;
    public static final ASN1ObjectIdentifier id_alg_SSDH = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.10");
    public static final ASN1ObjectIdentifier id_ct;
    public static final ASN1ObjectIdentifier id_ct_TSTInfo = id_ct.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier id_ct_authData;
    public static final ASN1ObjectIdentifier id_ct_authEnvelopedData = id_ct.branch("23");
    public static final ASN1ObjectIdentifier id_ct_compressedData = id_ct.branch("9");
    public static final ASN1ObjectIdentifier id_ct_timestampedData = id_ct.branch("31");
    public static final ASN1ObjectIdentifier id_cti;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfApproval = id_cti.branch("5");
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfCreation = id_cti.branch("6");
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfDelivery = id_cti.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfOrigin;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfReceipt = id_cti.branch("2");
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfSender = id_cti.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier id_hmacWithSHA1 = digestAlgorithm.branch("7").intern();
    public static final ASN1ObjectIdentifier id_hmacWithSHA224 = digestAlgorithm.branch("8").intern();
    public static final ASN1ObjectIdentifier id_hmacWithSHA256 = digestAlgorithm.branch("9").intern();
    public static final ASN1ObjectIdentifier id_hmacWithSHA384 = digestAlgorithm.branch("10").intern();
    public static final ASN1ObjectIdentifier id_hmacWithSHA512 = digestAlgorithm.branch("11").intern();
    public static final ASN1ObjectIdentifier id_mgf1 = pkcs_1.branch("8");
    public static final ASN1ObjectIdentifier id_pSpecified = pkcs_1.branch("9");
    public static final ASN1ObjectIdentifier id_rsa_KEM = id_alg.branch("14");
    public static final ASN1ObjectIdentifier id_smime;
    public static final String id_spq = "1.2.840.113549.1.9.16.5";
    public static final ASN1ObjectIdentifier id_spq_ets_unotice = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.5.2");
    public static final ASN1ObjectIdentifier id_spq_ets_uri = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.5.1");
    public static final ASN1ObjectIdentifier keyBag;
    public static final ASN1ObjectIdentifier md2;
    public static final ASN1ObjectIdentifier md2WithRSAEncryption = pkcs_1.branch("2");
    public static final ASN1ObjectIdentifier md4 = digestAlgorithm.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier md4WithRSAEncryption = pkcs_1.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier md5 = digestAlgorithm.branch("5");
    public static final ASN1ObjectIdentifier md5WithRSAEncryption = pkcs_1.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier pbeWithMD2AndDES_CBC;
    public static final ASN1ObjectIdentifier pbeWithMD2AndRC2_CBC = pkcs_5.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier pbeWithMD5AndDES_CBC = pkcs_5.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier pbeWithMD5AndRC2_CBC = pkcs_5.branch("6");
    public static final ASN1ObjectIdentifier pbeWithSHA1AndDES_CBC = pkcs_5.branch("10");
    public static final ASN1ObjectIdentifier pbeWithSHA1AndRC2_CBC = pkcs_5.branch("11");
    public static final ASN1ObjectIdentifier pbeWithSHAAnd128BitRC2_CBC = pkcs_12PbeIds.branch("5");
    public static final ASN1ObjectIdentifier pbeWithSHAAnd128BitRC4;
    public static final ASN1ObjectIdentifier pbeWithSHAAnd2_KeyTripleDES_CBC = pkcs_12PbeIds.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier pbeWithSHAAnd3_KeyTripleDES_CBC = pkcs_12PbeIds.branch(OO000o0.O00000o);
    public static final ASN1ObjectIdentifier pbeWithSHAAnd40BitRC2_CBC = pkcs_12PbeIds.branch("6");
    public static final ASN1ObjectIdentifier pbeWithSHAAnd40BitRC4 = pkcs_12PbeIds.branch("2");
    public static final ASN1ObjectIdentifier pbewithSHAAnd40BitRC2_CBC = pkcs_12PbeIds.branch("6");
    public static final ASN1ObjectIdentifier pkcs8ShroudedKeyBag = bagtypes.branch("2");
    public static final ASN1ObjectIdentifier pkcs_1;
    public static final ASN1ObjectIdentifier pkcs_12;
    public static final ASN1ObjectIdentifier pkcs_12PbeIds;
    public static final ASN1ObjectIdentifier pkcs_3;
    public static final ASN1ObjectIdentifier pkcs_5;
    public static final ASN1ObjectIdentifier pkcs_7 = a.c("1.2.840.113549.1.7");
    public static final ASN1ObjectIdentifier pkcs_9;
    public static final ASN1ObjectIdentifier pkcs_9_at_challengePassword = pkcs_9.branch("7").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_contentType = pkcs_9.branch(OO000o0.O00000o).intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_counterSignature = pkcs_9.branch("6").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_emailAddress;
    public static final ASN1ObjectIdentifier pkcs_9_at_extendedCertificateAttributes = pkcs_9.branch("9").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_extensionRequest = pkcs_9.branch("14").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_friendlyName = pkcs_9.branch("20").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_localKeyId = pkcs_9.branch("21").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_messageDigest = pkcs_9.branch(OO000o0.O00000o0).intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_signingDescription = pkcs_9.branch("13").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_signingTime = pkcs_9.branch("5").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_smimeCapabilities;
    public static final ASN1ObjectIdentifier pkcs_9_at_unstructuredAddress = pkcs_9.branch("8").intern();
    public static final ASN1ObjectIdentifier pkcs_9_at_unstructuredName = pkcs_9.branch("2").intern();
    public static final ASN1ObjectIdentifier preferSignedData = pkcs_9.branch("15.1");
    public static final ASN1ObjectIdentifier rc4 = encryptionAlgorithm.branch(OO000o0.O00000o0);
    public static final ASN1ObjectIdentifier rsaEncryption;
    public static final ASN1ObjectIdentifier sMIMECapabilitiesVersions = pkcs_9.branch("15.3");
    public static final ASN1ObjectIdentifier safeContentsBag = bagtypes.branch("6");
    public static final ASN1ObjectIdentifier sdsiCertificate = certTypes.branch("2").intern();
    public static final ASN1ObjectIdentifier secretBag = bagtypes.branch("5");
    public static final ASN1ObjectIdentifier sha1WithRSAEncryption = pkcs_1.branch("5");
    public static final ASN1ObjectIdentifier sha224WithRSAEncryption = pkcs_1.branch("14");
    public static final ASN1ObjectIdentifier sha256WithRSAEncryption = pkcs_1.branch("11");
    public static final ASN1ObjectIdentifier sha384WithRSAEncryption = pkcs_1.branch("12");
    public static final ASN1ObjectIdentifier sha512WithRSAEncryption = pkcs_1.branch("13");
    public static final ASN1ObjectIdentifier sha512_224WithRSAEncryption = pkcs_1.branch("15");
    public static final ASN1ObjectIdentifier sha512_256WithRSAEncryption = pkcs_1.branch("16");
    public static final ASN1ObjectIdentifier signedAndEnvelopedData = a.c("1.2.840.113549.1.7.4");
    public static final ASN1ObjectIdentifier signedData = a.c("1.2.840.113549.1.7.2");
    public static final ASN1ObjectIdentifier srsaOAEPEncryptionSET = pkcs_1.branch("6");
    public static final ASN1ObjectIdentifier x509Certificate;
    public static final ASN1ObjectIdentifier x509Crl;
    public static final ASN1ObjectIdentifier x509certType = pkcs_9.branch("22.1");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.113549.1.1");
        pkcs_1 = aSN1ObjectIdentifier;
        rsaEncryption = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.2.840.113549.1.3");
        pkcs_3 = aSN1ObjectIdentifier2;
        dhKeyAgreement = aSN1ObjectIdentifier2.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("1.2.840.113549.1.5");
        pkcs_5 = aSN1ObjectIdentifier3;
        pbeWithMD2AndDES_CBC = aSN1ObjectIdentifier3.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("1.2.840.113549.3");
        encryptionAlgorithm = aSN1ObjectIdentifier4;
        des_EDE3_CBC = aSN1ObjectIdentifier4.branch("7");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.2.840.113549.2");
        digestAlgorithm = aSN1ObjectIdentifier5;
        md2 = aSN1ObjectIdentifier5.branch("2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("1.2.840.113549.1.9");
        pkcs_9 = aSN1ObjectIdentifier6;
        pkcs_9_at_emailAddress = aSN1ObjectIdentifier6.branch("1").intern();
        String str = "15";
        pkcs_9_at_smimeCapabilities = pkcs_9.branch(str).intern();
        String str2 = "16";
        id_smime = pkcs_9.branch(str2).intern();
        ASN1ObjectIdentifier branch = pkcs_9.branch("22");
        certTypes = branch;
        x509Certificate = branch.branch("1").intern();
        ASN1ObjectIdentifier branch2 = pkcs_9.branch("23");
        crlTypes = branch2;
        x509Crl = branch2.branch("1").intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.1");
        id_ct = aSN1ObjectIdentifier7;
        id_ct_authData = aSN1ObjectIdentifier7.branch("2");
        ASN1ObjectIdentifier branch3 = id_smime.branch(OO000o0.O00000o);
        id_alg = branch3;
        id_alg_PWRI_KEK = branch3.branch("9");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.6");
        id_cti = aSN1ObjectIdentifier8;
        id_cti_ets_proofOfOrigin = aSN1ObjectIdentifier8.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.2");
        id_aa = aSN1ObjectIdentifier9;
        id_aa_receiptRequest = aSN1ObjectIdentifier9.branch("1");
        id_aa_ets_sigPolicyId = id_aa.branch(str);
        id_aa_ets_commitmentType = id_aa.branch(str2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("1.2.840.113549.1.12");
        pkcs_12 = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier branch4 = aSN1ObjectIdentifier10.branch("10.1");
        bagtypes = branch4;
        keyBag = branch4.branch("1");
        ASN1ObjectIdentifier branch5 = pkcs_12.branch("1");
        pkcs_12PbeIds = branch5;
        pbeWithSHAAnd128BitRC4 = branch5.branch("1");
    }
}
