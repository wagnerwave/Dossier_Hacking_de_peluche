package com.tuya.spongycastle.jcajce.provider.util;

import com.tuya.spongycastle.asn1.pkcs.PrivateKeyInfo;
import com.tuya.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface AsymmetricKeyInfoConverter {
    PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo);

    PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo);
}
