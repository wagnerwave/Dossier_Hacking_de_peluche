package com.tuya.spongycastle.crypto;

import java.security.SecureRandom;

public class KeyGenerationParameters {
    public SecureRandom random;
    public int strength;

    public KeyGenerationParameters(SecureRandom secureRandom, int i) {
        this.random = secureRandom;
        this.strength = i;
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public int getStrength() {
        return this.strength;
    }
}
