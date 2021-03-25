package com.tuya.spongycastle.util;

public interface Memoable {
    Memoable copy();

    void reset(Memoable memoable);
}
