package com.tuya.sdk.sigmesh.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tuya.smart.android.blemesh.bean.MeshBeacon;
import java.nio.ByteBuffer;
import java.util.UUID;

public class UnprovisionedBeacon extends MeshBeacon {
    public static final int BEACON_DATA_LENGTH = 19;
    public static final Parcelable.Creator<UnprovisionedBeacon> CREATOR = new Parcelable.Creator<UnprovisionedBeacon>() {
        public UnprovisionedBeacon createFromParcel(Parcel parcel) {
            return new UnprovisionedBeacon(parcel.createByteArray());
        }

        public UnprovisionedBeacon[] newArray(int i) {
            return new UnprovisionedBeacon[i];
        }
    };
    public static final int OOB_INDEX = 17;
    public static final int URI_HASH_INDEX = 19;
    public final byte[] oobInformation = new byte[2];
    public final byte[] uriHash = new byte[4];
    public final UUID uuid;

    public UnprovisionedBeacon(byte[] bArr) {
        super(bArr);
        if (bArr.length >= 19) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.position(1);
            this.uuid = new UUID(wrap.getLong(), wrap.getLong());
            wrap.get(this.oobInformation, 0, 2);
            if (wrap.remaining() == 4) {
                wrap.get(this.uriHash, 0, 4);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid unprovisioned beacon data");
    }

    public int describeContents() {
        return 0;
    }

    public int getBeaconType() {
        return this.beaconType;
    }

    public byte[] getOobInformation() {
        return this.oobInformation;
    }

    public byte[] getUriHash() {
        return this.uriHash;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.beaconData);
    }
}
