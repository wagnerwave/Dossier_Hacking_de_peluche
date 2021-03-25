package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.builder.TuyaGwActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwSubDevActivatorBuilder;
import com.tuya.smart.sdk.api.ITuyaActivator;

public interface ITuyaGwActivator {
    ITuyaActivator newDevActivator(TuyaGwActivatorBuilder tuyaGwActivatorBuilder);

    ITuyaGwSearcher newSearcher();

    ITuyaActivator newSubDevActivator(TuyaGwSubDevActivatorBuilder tuyaGwSubDevActivatorBuilder);
}
