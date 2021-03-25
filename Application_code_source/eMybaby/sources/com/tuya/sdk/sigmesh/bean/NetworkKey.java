package com.tuya.sdk.sigmesh.bean;

import android.os.Parcel;
import android.os.Parcelable;

public final class NetworkKey implements Parcelable {
    public static final Parcelable.Creator<NetworkKey> CREATOR = new Parcelable.Creator<NetworkKey>() {
        public NetworkKey createFromParcel(Parcel parcel) {
            return new NetworkKey(parcel);
        }

        public NetworkKey[] newArray(int i) {
            return new NetworkKey[i];
        }
    };
    public static final int PHASE_0 = 0;
    public static final int PHASE_1 = 1;
    public static final int PHASE_2 = 2;
    public byte[] key;
    public int keyIndex;
    public String meshUuid;
    public boolean minSecurity;
    public String name;
    public byte[] oldKey;
    public int phase;
    public long timestamp;

    public NetworkKey(int i, byte[] bArr) {
        this.name = "Network Key";
        this.phase = 0;
        this.timestamp = 0;
        this.key = bArr;
        this.keyIndex = i;
    }

    public NetworkKey(Parcel parcel) {
        this.name = "Network Key";
        boolean z = false;
        this.phase = 0;
        this.timestamp = 0;
        this.meshUuid = parcel.readString();
        this.keyIndex = parcel.readInt();
        this.name = parcel.readString();
        this.key = parcel.createByteArray();
        this.phase = parcel.readInt();
        this.minSecurity = parcel.readByte() != 0 ? true : z;
        this.oldKey = parcel.createByteArray();
        this.timestamp = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getKeyIndex() {
        return this.keyIndex;
    }

    public String getMeshUuid() {
        return this.meshUuid;
    }

    public String getName() {
        return this.name;
    }

    public byte[] getOldKey() {
        return this.oldKey;
    }

    public int getPhase() {
        return this.phase;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isMinSecurity() {
        return this.minSecurity;
    }

    public void setKey(byte[] bArr) {
        this.key = bArr;
    }

    public void setKeyIndex(int i) {
        this.keyIndex = i;
    }

    public void setMeshUuid(String str) {
        this.meshUuid = str;
    }

    public void setMinSecurity(boolean z) {
        this.minSecurity = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOldKey(byte[] bArr) {
        this.oldKey = bArr;
    }

    public void setPhase(int i) {
        this.phase = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.meshUuid);
        parcel.writeInt(this.keyIndex);
        parcel.writeString(this.name);
        parcel.writeByteArray(this.key);
        parcel.writeInt(this.phase);
        parcel.writeByte(this.minSecurity ? (byte) 1 : 0);
        parcel.writeByteArray(this.oldKey);
        parcel.writeLong(this.timestamp);
    }
}
