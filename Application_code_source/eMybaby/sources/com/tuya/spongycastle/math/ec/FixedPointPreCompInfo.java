package com.tuya.spongycastle.math.ec;

public class FixedPointPreCompInfo implements PreCompInfo {
    public ECPoint offset = null;
    public ECPoint[] preComp = null;
    public int width = -1;

    public ECPoint getOffset() {
        return this.offset;
    }

    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    public int getWidth() {
        return this.width;
    }

    public void setOffset(ECPoint eCPoint) {
        this.offset = eCPoint;
    }

    public void setPreComp(ECPoint[] eCPointArr) {
        this.preComp = eCPointArr;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
