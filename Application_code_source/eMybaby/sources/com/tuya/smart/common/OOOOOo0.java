package com.tuya.smart.common;

import com.tuya.smart.home.sdk.api.ITuyaGwActivator;
import com.tuya.smart.home.sdk.api.ITuyaGwSearcher;
import com.tuya.smart.home.sdk.builder.TuyaGwActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwSubDevActivatorBuilder;
import com.tuya.smart.sdk.api.ITuyaActivator;

public class OOOOOo0 implements ITuyaGwActivator {
    public ITuyaActivator newDevActivator(TuyaGwActivatorBuilder tuyaGwActivatorBuilder) {
        return new OOOo000(tuyaGwActivatorBuilder);
    }

    public ITuyaGwSearcher newSearcher() {
        return new OOo000();
    }

    public ITuyaActivator newSubDevActivator(TuyaGwSubDevActivatorBuilder tuyaGwSubDevActivatorBuilder) {
        return new Oo000(tuyaGwSubDevActivatorBuilder);
    }
}
