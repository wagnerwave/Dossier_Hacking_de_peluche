package com.tuya.spongycastle.math.field;

public interface PolynomialExtensionField extends ExtensionField {
    Polynomial getMinimalPolynomial();
}
