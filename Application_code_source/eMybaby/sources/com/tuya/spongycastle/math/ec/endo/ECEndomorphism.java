package com.tuya.spongycastle.math.ec.endo;

import com.tuya.spongycastle.math.ec.ECPointMap;

public interface ECEndomorphism {
    ECPointMap getPointMap();

    boolean hasEfficientPointMap();
}
