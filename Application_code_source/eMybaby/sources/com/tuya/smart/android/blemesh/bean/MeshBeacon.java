package com.tuya.smart.android.blemesh.bean;

import android.os.Parcelable;

public abstract class MeshBeacon implements Parcelable {
    public static final int MESH_BEACON = 43;
    public static final String TAG = MeshBeacon.class.getSimpleName();
    public final byte[] beaconData;
    public final int beaconType;

    public MeshBeacon(byte[] bArr) {
        if (bArr != null) {
            this.beaconData = bArr;
            this.beaconType = bArr[0];
            return;
        }
        throw new IllegalArgumentException("Invalid beacon data");
    }

    public abstract int getBeaconType();
}
