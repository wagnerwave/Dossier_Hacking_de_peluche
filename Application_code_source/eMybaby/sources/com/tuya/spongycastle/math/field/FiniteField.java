package com.tuya.spongycastle.math.field;

import java.math.BigInteger;

public interface FiniteField {
    BigInteger getCharacteristic();

    int getDimension();
}
