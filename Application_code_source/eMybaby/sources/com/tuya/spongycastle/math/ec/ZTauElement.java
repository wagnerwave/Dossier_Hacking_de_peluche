package com.tuya.spongycastle.math.ec;

import java.math.BigInteger;

public class ZTauElement {
    public final BigInteger u;
    public final BigInteger v;

    public ZTauElement(BigInteger bigInteger, BigInteger bigInteger2) {
        this.u = bigInteger;
        this.v = bigInteger2;
    }
}
