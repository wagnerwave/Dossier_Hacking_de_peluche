package com.tuya.spongycastle.jcajce.provider.util;

import com.tuya.spongycastle.jcajce.provider.config.ConfigurableProvider;

public abstract class AlgorithmProvider {
    public abstract void configure(ConfigurableProvider configurableProvider);
}
