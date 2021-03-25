package com.tuya.spongycastle.jcajce.provider.asymmetric.util;

import a.a.a.a.a;
import com.tuya.spongycastle.asn1.pkcs.PrivateKeyInfo;
import com.tuya.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import com.tuya.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public abstract class BaseKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return generatePrivate(PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e2) {
                StringBuilder n = a.n("encoded key spec not recognized: ");
                n.append(e2.getMessage());
                throw new InvalidKeySpecException(n.toString());
            }
        } else {
            throw new InvalidKeySpecException("key spec not recognized");
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e2) {
                StringBuilder n = a.n("encoded key spec not recognized: ");
                n.append(e2.getMessage());
                throw new InvalidKeySpecException(n.toString());
            }
        } else {
            throw new InvalidKeySpecException("key spec not recognized");
        }
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        throw new InvalidKeySpecException("not implemented yet " + key + " " + cls);
    }
}
