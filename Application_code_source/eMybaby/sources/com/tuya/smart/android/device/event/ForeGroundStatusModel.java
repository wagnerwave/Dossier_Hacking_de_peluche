package com.tuya.smart.android.device.event;

public class ForeGroundStatusModel {
    public final boolean isForeground;

    public ForeGroundStatusModel(boolean z) {
        this.isForeground = z;
    }

    public boolean isForeground() {
        return this.isForeground;
    }
}
