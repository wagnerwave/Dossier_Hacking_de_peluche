package com.tuya.spongycastle.math.ec.endo;

import a.a.a.a.a;
import java.math.BigInteger;

public class GLVTypeBParameters {
    public final BigInteger beta;
    public final int bits;
    public final BigInteger g1;
    public final BigInteger g2;
    public final BigInteger lambda;
    public final BigInteger v1A;
    public final BigInteger v1B;
    public final BigInteger v2A;
    public final BigInteger v2B;

    public GLVTypeBParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger3, BigInteger bigInteger4, int i) {
        checkVector(bigIntegerArr, "v1");
        checkVector(bigIntegerArr2, "v2");
        this.beta = bigInteger;
        this.lambda = bigInteger2;
        this.v1A = bigIntegerArr[0];
        this.v1B = bigIntegerArr[1];
        this.v2A = bigIntegerArr2[0];
        this.v2B = bigIntegerArr2[1];
        this.g1 = bigInteger3;
        this.g2 = bigInteger4;
        this.bits = i;
    }

    public static void checkVector(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException(a.l("'", str, "' must consist of exactly 2 (non-null) values"));
        }
    }

    public BigInteger getBeta() {
        return this.beta;
    }

    public int getBits() {
        return this.bits;
    }

    public BigInteger getG1() {
        return this.g1;
    }

    public BigInteger getG2() {
        return this.g2;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public BigInteger[] getV1() {
        return new BigInteger[]{this.v1A, this.v1B};
    }

    public BigInteger getV1A() {
        return this.v1A;
    }

    public BigInteger getV1B() {
        return this.v1B;
    }

    public BigInteger[] getV2() {
        return new BigInteger[]{this.v2A, this.v2B};
    }

    public BigInteger getV2A() {
        return this.v2A;
    }

    public BigInteger getV2B() {
        return this.v2B;
    }
}
