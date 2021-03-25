package com.tuya.spongycastle.asn1.nist;

import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.sec.SECNamedCurves;
import com.tuya.spongycastle.asn1.sec.SECObjectIdentifiers;
import com.tuya.spongycastle.asn1.x9.X9ECParameters;
import com.tuya.spongycastle.util.Strings;
import java.util.Enumeration;
import java.util.Hashtable;

public class NISTNamedCurves {
    public static final Hashtable names = new Hashtable();
    public static final Hashtable objIds = new Hashtable();

    static {
        defineCurve("P-256", SECObjectIdentifiers.secp256r1);
    }

    public static void defineCurve(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        objIds.put(str, aSN1ObjectIdentifier);
        names.put(aSN1ObjectIdentifier, str);
    }

    public static X9ECParameters getByName(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) objIds.get(Strings.toUpperCase(str));
        if (aSN1ObjectIdentifier != null) {
            return getByOID(aSN1ObjectIdentifier);
        }
        return null;
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return SECNamedCurves.getByOID(aSN1ObjectIdentifier);
    }

    public static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) names.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return objIds.keys();
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) objIds.get(Strings.toUpperCase(str));
    }
}
