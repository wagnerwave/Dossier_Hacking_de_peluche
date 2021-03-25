package com.tuya.spongycastle.asn1.x9;

public abstract class X9ECParametersHolder {
    public X9ECParameters params;

    public abstract X9ECParameters createParameters();

    public synchronized X9ECParameters getParameters() {
        if (this.params == null) {
            this.params = createParameters();
        }
        return this.params;
    }
}
