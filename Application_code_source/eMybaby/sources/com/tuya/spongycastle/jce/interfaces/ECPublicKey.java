package com.tuya.spongycastle.jce.interfaces;

import com.tuya.spongycastle.math.ec.ECPoint;
import java.security.PublicKey;

public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}
