package com.tuya.spongycastle.jce.spec;

import com.tuya.spongycastle.math.ec.ECPoint;

public class ECPublicKeySpec extends ECKeySpec {
    public ECPoint q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.q = eCPoint.getCurve() != null ? eCPoint.normalize() : eCPoint;
    }

    public ECPoint getQ() {
        return this.q;
    }
}
