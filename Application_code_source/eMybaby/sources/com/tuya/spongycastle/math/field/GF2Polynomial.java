package com.tuya.spongycastle.math.field;

import com.tuya.spongycastle.util.Arrays;

public class GF2Polynomial implements Polynomial {
    public final int[] exponents;

    public GF2Polynomial(int[] iArr) {
        this.exponents = Arrays.clone(iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GF2Polynomial)) {
            return false;
        }
        return Arrays.areEqual(this.exponents, ((GF2Polynomial) obj).exponents);
    }

    public int getDegree() {
        int[] iArr = this.exponents;
        return iArr[iArr.length - 1];
    }

    public int[] getExponentsPresent() {
        return Arrays.clone(this.exponents);
    }

    public int hashCode() {
        return Arrays.hashCode(this.exponents);
    }
}
