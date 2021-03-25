package com.tuya.smart.android.network;

public interface IApiUrlProvider {
    String getApiUrl();

    String getApiUrlByCountryCode(String str);

    String getAudioUrl();

    String getEncrptUrl();

    String getGwApiUrl();

    String[] getGwMqttUrl();

    String[] getMediaMqttUrl();

    String[] getMqttUrl();

    String getRegion();

    void setRegion(String str);
}
