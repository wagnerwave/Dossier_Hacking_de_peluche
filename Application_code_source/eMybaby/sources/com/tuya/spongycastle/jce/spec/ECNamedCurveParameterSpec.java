package com.tuya.spongycastle.jce.spec;

import com.tuya.spongycastle.math.ec.ECCurve;
import com.tuya.spongycastle.math.ec.ECPoint;
import java.math.BigInteger;

public class ECNamedCurveParameterSpec extends ECParameterSpec {
    public String name;

    public ECNamedCurveParameterSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(eCCurve, eCPoint, bigInteger);
        this.name = str;
    }

    public ECNamedCurveParameterSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(eCCurve, eCPoint, bigInteger, bigInteger2);
        this.name = str;
    }

    public ECNamedCurveParameterSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(eCCurve, eCPoint, bigInteger, bigInteger2, bArr);
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
