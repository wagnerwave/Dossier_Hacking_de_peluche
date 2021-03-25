package com.tuya.sdk.sigmesh.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tuya.smart.common.o00o00000o;
import java.util.UUID;

public final class UnprovisionedMeshNode extends UnprovisionedBaseMeshNode {
    public static final Parcelable.Creator<UnprovisionedMeshNode> CREATOR = new Parcelable.Creator<UnprovisionedMeshNode>() {
        public UnprovisionedMeshNode createFromParcel(Parcel parcel) {
            return new UnprovisionedMeshNode(parcel);
        }

        public UnprovisionedMeshNode[] newArray(int i) {
            return new UnprovisionedMeshNode[i];
        }
    };

    public UnprovisionedMeshNode(Parcel parcel) {
        super((UUID) parcel.readSerializable());
        boolean z = true;
        this.isProvisioned = parcel.readByte() != 0;
        this.isConfigured = parcel.readByte() == 0 ? false : z;
        this.nodeName = parcel.readString();
        this.provisionerPublicKeyXY = parcel.createByteArray();
        this.provisioneePublicKeyXY = parcel.createByteArray();
        this.sharedECDHSecret = parcel.createByteArray();
        this.provisionerRandom = parcel.createByteArray();
        this.provisioneeConfirmation = parcel.createByteArray();
        this.authenticationValue = parcel.createByteArray();
        this.provisioneeRandom = parcel.createByteArray();
        this.networkKey = parcel.createByteArray();
        this.identityKey = parcel.createByteArray();
        this.keyIndex = parcel.readInt();
        this.mFlags = parcel.createByteArray();
        this.ivIndex = parcel.createByteArray();
        this.unicastAddress = parcel.createByteArray();
        this.deviceKey = parcel.createByteArray();
        this.ttl = parcel.readInt();
        ProvisioningCapabilities provisioningCapabilities = (ProvisioningCapabilities) parcel.readParcelable(ProvisioningCapabilities.class.getClassLoader());
        this.provisioningCapabilities = provisioningCapabilities;
        this.numberOfElements = provisioningCapabilities.getNumberOfElements();
    }

    public UnprovisionedMeshNode(UUID uuid) {
        super(uuid);
    }

    public int describeContents() {
        return 0;
    }

    public final byte[] getAuthenticationValue() {
        return this.authenticationValue;
    }

    public /* bridge */ /* synthetic */ byte[] getDeviceKey() {
        return super.getDeviceKey();
    }

    public /* bridge */ /* synthetic */ UUID getDeviceUuid() {
        return super.getDeviceUuid();
    }

    public final byte[] getNetworkKey() {
        return this.networkKey;
    }

    public /* bridge */ /* synthetic */ int getNumberOfElements() {
        return super.getNumberOfElements();
    }

    public final byte[] getProvisioneeConfirmation() {
        return this.provisioneeConfirmation;
    }

    public final byte[] getProvisioneePublicKeyXY() {
        return this.provisioneePublicKeyXY;
    }

    public final byte[] getProvisioneeRandom() {
        return this.provisioneeRandom;
    }

    public final byte[] getProvisionerPublicKeyXY() {
        return this.provisionerPublicKeyXY;
    }

    public final byte[] getProvisionerRandom() {
        return this.provisionerRandom;
    }

    public /* bridge */ /* synthetic */ ProvisioningCapabilities getProvisioningCapabilities() {
        return super.getProvisioningCapabilities();
    }

    public final byte[] getSharedECDHSecret() {
        return this.sharedECDHSecret;
    }

    public /* bridge */ /* synthetic */ long getTimeStamp() {
        return super.getTimeStamp();
    }

    public /* bridge */ /* synthetic */ int getTtl() {
        return super.getTtl();
    }

    public /* bridge */ /* synthetic */ boolean isProvisioned() {
        return super.isProvisioned();
    }

    public final void setAuthenticationValue(byte[] bArr) {
        this.authenticationValue = bArr;
    }

    public final void setDeviceKey(byte[] bArr) {
        this.deviceKey = bArr;
    }

    public final void setIsProvisioned(boolean z) {
        this.isProvisioned = z;
        if (z) {
            this.identityKey = o00o00000o.O00000o(this.networkKey);
        }
    }

    public final void setNetworkKey(byte[] bArr) {
        this.networkKey = bArr;
    }

    public final void setProvisionedTime(long j) {
        this.mTimeStampInMillis = j;
    }

    public final void setProvisioneeConfirmation(byte[] bArr) {
        this.provisioneeConfirmation = bArr;
    }

    public final void setProvisioneePublicKeyXY(byte[] bArr) {
        this.provisioneePublicKeyXY = bArr;
    }

    public final void setProvisioneeRandom(byte[] bArr) {
        this.provisioneeRandom = bArr;
    }

    public final void setProvisionerPublicKeyXY(byte[] bArr) {
        this.provisionerPublicKeyXY = bArr;
    }

    public final void setProvisionerRandom(byte[] bArr) {
        this.provisionerRandom = bArr;
    }

    public void setProvisioningCapabilities(ProvisioningCapabilities provisioningCapabilities) {
        this.numberOfElements = provisioningCapabilities.getNumberOfElements();
        this.provisioningCapabilities = provisioningCapabilities;
    }

    public final void setSharedECDHSecret(byte[] bArr) {
        this.sharedECDHSecret = bArr;
    }

    public /* bridge */ /* synthetic */ void setTtl(int i) {
        super.setTtl(i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.deviceUuid);
        parcel.writeByte(this.isProvisioned ? (byte) 1 : 0);
        parcel.writeByte(this.isConfigured ? (byte) 1 : 0);
        parcel.writeString(this.nodeName);
        parcel.writeByteArray(this.provisionerPublicKeyXY);
        parcel.writeByteArray(this.provisioneePublicKeyXY);
        parcel.writeByteArray(this.sharedECDHSecret);
        parcel.writeByteArray(this.provisionerRandom);
        parcel.writeByteArray(this.provisioneeConfirmation);
        parcel.writeByteArray(this.authenticationValue);
        parcel.writeByteArray(this.provisioneeRandom);
        parcel.writeByteArray(this.networkKey);
        parcel.writeByteArray(this.identityKey);
        parcel.writeInt(this.keyIndex);
        parcel.writeByteArray(this.mFlags);
        parcel.writeByteArray(this.ivIndex);
        parcel.writeByteArray(this.unicastAddress);
        parcel.writeByteArray(this.deviceKey);
        parcel.writeInt(this.ttl);
        parcel.writeParcelable(this.provisioningCapabilities, i);
    }
}
