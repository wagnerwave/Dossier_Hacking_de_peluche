package com.tuya.smart.android.base.event;

public class NetWorkStatusEventModel {
    public boolean isAvailable;

    public NetWorkStatusEventModel(boolean z) {
        this.isAvailable = z;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean z) {
        this.isAvailable = z;
    }
}
