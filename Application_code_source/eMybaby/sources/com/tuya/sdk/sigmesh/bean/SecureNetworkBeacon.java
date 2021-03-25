package com.tuya.sdk.sigmesh.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tuya.smart.android.blemesh.bean.MeshBeacon;
import java.nio.ByteBuffer;

public class SecureNetworkBeacon extends MeshBeacon {
    public static final int BEACON_DATA_LENGTH = 23;
    public static final Parcelable.Creator<SecureNetworkBeacon> CREATOR = new Parcelable.Creator<SecureNetworkBeacon>() {
        public SecureNetworkBeacon createFromParcel(Parcel parcel) {
            return new SecureNetworkBeacon(parcel.createByteArray());
        }

        public SecureNetworkBeacon[] newArray(int i) {
            return new SecureNetworkBeacon[i];
        }
    };
    public final byte[] authenticationValue = new byte[8];
    public final int flags;
    public final int ivIndex;
    public final byte[] networkId = new byte[8];

    public SecureNetworkBeacon(byte[] bArr) {
        super(bArr);
        if (bArr.length == 23) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(1);
            this.flags = wrap.get();
            wrap.get(this.networkId, 0, 8);
            this.ivIndex = wrap.getInt();
            wrap.get(this.authenticationValue, 0, 8);
            return;
        }
        throw new IllegalArgumentException("Invalid secure network beacon data");
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getAuthenticationValue() {
        return this.authenticationValue;
    }

    public int getBeaconType() {
        return this.beaconType;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getIvIndex() {
        return this.ivIndex;
    }

    public byte[] getNetworkId() {
        return this.networkId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.beaconData);
    }
}
