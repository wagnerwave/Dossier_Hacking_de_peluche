package com.tuya.spongycastle.jce.spec;

import com.tuya.spongycastle.math.ec.ECCurve;
import com.tuya.spongycastle.math.ec.ECPoint;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ECParameterSpec implements AlgorithmParameterSpec {
    public ECPoint G;
    public ECCurve curve;
    public BigInteger h;
    public BigInteger n;
    public byte[] seed;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.G = eCPoint.normalize();
        this.n = bigInteger;
        this.h = BigInteger.valueOf(1);
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.G = eCPoint.normalize();
        this.n = bigInteger;
        this.h = bigInteger2;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.G = eCPoint.normalize();
        this.n = bigInteger;
        this.h = bigInteger2;
        this.seed = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        return getCurve().equals(eCParameterSpec.getCurve()) && getG().equals(eCParameterSpec.getG());
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.h;
    }

    public BigInteger getN() {
        return this.n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }
}
