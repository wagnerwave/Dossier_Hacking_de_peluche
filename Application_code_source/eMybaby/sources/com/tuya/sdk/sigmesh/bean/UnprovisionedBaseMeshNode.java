package com.tuya.sdk.sigmesh.bean;

import android.os.Parcelable;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public abstract class UnprovisionedBaseMeshNode implements Parcelable {
    public static final String TAG = UnprovisionedBaseMeshNode.class.getSimpleName();
    public byte[] authenticationValue;
    public String bluetoothDeviceAddress;
    public byte[] deviceKey;
    public UUID deviceUuid;
    public byte[] identityKey;
    public boolean isConfigured;
    public boolean isProvisioned;
    public byte[] ivIndex;
    public int keyIndex;
    public byte[] mConfigurationSrc = {Byte.MAX_VALUE, -1};
    public byte[] mFlags;
    public long mTimeStampInMillis;
    public byte[] networkKey;
    public String nodeName = "My Node";
    public int numberOfElements;
    public byte[] provisioneeConfirmation;
    public byte[] provisioneePublicKeyXY;
    public byte[] provisioneeRandom;
    public byte[] provisionerPublicKeyXY;
    public byte[] provisionerRandom;
    public ProvisioningCapabilities provisioningCapabilities;
    public byte[] sharedECDHSecret;
    public int ttl = 5;
    public byte[] unicastAddress;

    public UnprovisionedBaseMeshNode(UUID uuid) {
        this.deviceUuid = uuid;
    }

    public int describeContents() {
        return 0;
    }

    public final byte[] getConfigurationSrc() {
        return this.mConfigurationSrc;
    }

    public byte[] getDeviceKey() {
        return this.deviceKey;
    }

    public UUID getDeviceUuid() {
        return this.deviceUuid;
    }

    public final byte[] getFlags() {
        return this.mFlags;
    }

    public final byte[] getIdentityKey() {
        return this.identityKey;
    }

    public final byte[] getIvIndex() {
        return this.ivIndex;
    }

    public final int getKeyIndex() {
        return this.keyIndex;
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    public ProvisioningCapabilities getProvisioningCapabilities() {
        return this.provisioningCapabilities;
    }

    public long getTimeStamp() {
        return this.mTimeStampInMillis;
    }

    public int getTtl() {
        return this.ttl;
    }

    public final byte[] getUnicastAddress() {
        return this.unicastAddress;
    }

    public final int getUnicastAddressInt() {
        return ByteBuffer.wrap(this.unicastAddress).order(ByteOrder.BIG_ENDIAN).getShort();
    }

    public final boolean isConfigured() {
        return this.isConfigured;
    }

    public boolean isProvisioned() {
        return this.isProvisioned;
    }

    public final void setConfigurationSrc(byte[] bArr) {
        this.mConfigurationSrc = bArr;
    }

    public final void setConfigured(boolean z) {
        this.isConfigured = z;
    }

    public final void setFlags(byte[] bArr) {
        this.mFlags = bArr;
    }

    public final void setIvIndex(byte[] bArr) {
        this.ivIndex = bArr;
    }

    public final void setKeyIndex(int i) {
        this.keyIndex = i;
    }

    public final void setNodeName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nodeName = str;
        }
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public final void setUnicastAddress(byte[] bArr) {
        this.unicastAddress = bArr;
    }
}
