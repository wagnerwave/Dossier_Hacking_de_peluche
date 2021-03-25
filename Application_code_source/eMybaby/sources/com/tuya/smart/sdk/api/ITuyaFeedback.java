package com.tuya.smart.sdk.api;

public interface ITuyaFeedback {
    ITuyaFeedbackManager getFeedbackManager();

    ITuyaFeedbackMag getFeedbackMsg(String str, int i);
}
