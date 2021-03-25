package com.tuya.spongycastle.crypto.ec;

import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.sec.SECObjectIdentifiers;
import com.tuya.spongycastle.asn1.x9.X9ECParameters;
import com.tuya.spongycastle.asn1.x9.X9ECParametersHolder;
import com.tuya.spongycastle.asn1.x9.X9ECPoint;
import com.tuya.spongycastle.math.ec.ECCurve;
import com.tuya.spongycastle.math.ec.custom.djb.Curve25519;
import com.tuya.spongycastle.math.ec.custom.sec.SecP256R1Curve;
import com.tuya.spongycastle.math.ec.endo.GLVTypeBEndomorphism;
import com.tuya.spongycastle.math.ec.endo.GLVTypeBParameters;
import com.tuya.spongycastle.util.Strings;
import com.tuya.spongycastle.util.encoders.Hex;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class CustomNamedCurves {
    public static X9ECParametersHolder curve25519 = new X9ECParametersHolder() {
        public X9ECParameters createParameters() {
            ECCurve access$000 = CustomNamedCurves.configureCurve(new Curve25519());
            return new X9ECParameters(access$000, new X9ECPoint(access$000, Hex.decode("042AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD245A20AE19A1B8A086B4E01EDD2C7748D14C923D4D7E6D7C61B229E9C5A27ECED3D9")), access$000.getOrder(), access$000.getCofactor(), (byte[]) null);
        }
    };
    public static final Hashtable nameToCurve = new Hashtable();
    public static final Hashtable nameToOID = new Hashtable();
    public static final Vector names = new Vector();
    public static final Hashtable oidToCurve = new Hashtable();
    public static final Hashtable oidToName = new Hashtable();
    public static X9ECParametersHolder secp256r1 = new X9ECParametersHolder() {
        public X9ECParameters createParameters() {
            byte[] decode = Hex.decode("C49D360886E704936A6678E1139D26B7819F7E90");
            ECCurve access$000 = CustomNamedCurves.configureCurve(new SecP256R1Curve());
            return new X9ECParameters(access$000, new X9ECPoint(access$000, Hex.decode("046B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C2964FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5")), access$000.getOrder(), access$000.getCofactor(), decode);
        }
    };

    static {
        defineCurve("curve25519", curve25519);
        defineCurveWithOID("secp256r1", SECObjectIdentifiers.secp256r1, secp256r1);
        defineCurveAlias("P-256", SECObjectIdentifiers.secp256r1);
    }

    public static ECCurve configureCurve(ECCurve eCCurve) {
        return eCCurve;
    }

    public static ECCurve configureCurveGLV(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        return eCCurve.configure().setEndomorphism(new GLVTypeBEndomorphism(eCCurve, gLVTypeBParameters)).create();
    }

    public static void defineCurve(String str, X9ECParametersHolder x9ECParametersHolder) {
        names.addElement(str);
        nameToCurve.put(Strings.toLowerCase(str), x9ECParametersHolder);
    }

    public static void defineCurveAlias(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Object obj = oidToCurve.get(aSN1ObjectIdentifier);
        if (obj != null) {
            String lowerCase = Strings.toLowerCase(str);
            nameToOID.put(lowerCase, aSN1ObjectIdentifier);
            nameToCurve.put(lowerCase, obj);
            return;
        }
        throw new IllegalStateException();
    }

    public static void defineCurveWithOID(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParametersHolder x9ECParametersHolder) {
        names.addElement(str);
        oidToName.put(aSN1ObjectIdentifier, str);
        oidToCurve.put(aSN1ObjectIdentifier, x9ECParametersHolder);
        String lowerCase = Strings.toLowerCase(str);
        nameToOID.put(lowerCase, aSN1ObjectIdentifier);
        nameToCurve.put(lowerCase, x9ECParametersHolder);
    }

    public static X9ECParameters getByName(String str) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) nameToCurve.get(Strings.toLowerCase(str));
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.getParameters();
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) oidToCurve.get(aSN1ObjectIdentifier);
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.getParameters();
    }

    public static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) oidToName.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return names.elements();
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) nameToOID.get(Strings.toLowerCase(str));
    }
}
