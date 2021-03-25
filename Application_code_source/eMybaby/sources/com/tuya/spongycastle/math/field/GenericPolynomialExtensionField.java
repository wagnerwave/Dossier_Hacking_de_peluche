package com.tuya.spongycastle.math.field;

import com.tuya.spongycastle.util.Integers;
import java.math.BigInteger;

public class GenericPolynomialExtensionField implements PolynomialExtensionField {
    public final Polynomial minimalPolynomial;
    public final FiniteField subfield;

    public GenericPolynomialExtensionField(FiniteField finiteField, Polynomial polynomial) {
        this.subfield = finiteField;
        this.minimalPolynomial = polynomial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField)) {
            return false;
        }
        GenericPolynomialExtensionField genericPolynomialExtensionField = (GenericPolynomialExtensionField) obj;
        return this.subfield.equals(genericPolynomialExtensionField.subfield) && this.minimalPolynomial.equals(genericPolynomialExtensionField.minimalPolynomial);
    }

    public BigInteger getCharacteristic() {
        return this.subfield.getCharacteristic();
    }

    public int getDegree() {
        return this.minimalPolynomial.getDegree();
    }

    public int getDimension() {
        return this.minimalPolynomial.getDegree() * this.subfield.getDimension();
    }

    public Polynomial getMinimalPolynomial() {
        return this.minimalPolynomial;
    }

    public FiniteField getSubfield() {
        return this.subfield;
    }

    public int hashCode() {
        return this.subfield.hashCode() ^ Integers.rotateLeft(this.minimalPolynomial.hashCode(), 16);
    }
}
