package com.tuya.smart.android.network.api;

public interface IApiEvent {
    <T> void onFailure(T t);

    <T> void onSuccess(T t);
}
