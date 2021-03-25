package com.tuya.smart.interior.event;

public interface DeviceUpdateEvent {
    void onEventMainThread(DeviceUpdateEventModel deviceUpdateEventModel);
}
