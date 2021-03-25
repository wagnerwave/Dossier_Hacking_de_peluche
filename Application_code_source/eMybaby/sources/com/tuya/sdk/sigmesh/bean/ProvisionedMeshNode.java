package com.tuya.sdk.sigmesh.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tuya.sdk.sigmesh.util.RelaySettings;
import com.tuya.smart.common.o00000o000;
import com.tuya.smart.common.o000o0o0o0;
import com.tuya.smart.common.o000oo0o0o;
import com.tuya.smart.common.o00o00000o;
import com.tuya.smart.common.o00o0000oo;
import com.tuya.smart.common.oo0o0ooo0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public final class ProvisionedMeshNode extends ProvisionedBaseMeshNode {
    public static final Parcelable.Creator<ProvisionedMeshNode> CREATOR = new Parcelable.Creator<ProvisionedMeshNode>() {
        public ProvisionedMeshNode createFromParcel(Parcel parcel) {
            return new ProvisionedMeshNode(parcel);
        }

        public ProvisionedMeshNode[] newArray(int i) {
            return new ProvisionedMeshNode[i];
        }
    };
    public o00o00000o.O000000o k2Output;
    public String nodeMac;

    public ProvisionedMeshNode() {
    }

    public ProvisionedMeshNode(Parcel parcel) {
        Class<Integer> cls = Integer.class;
        this.uuid = parcel.readString();
        boolean z = false;
        this.isProvisioned = parcel.readByte() != 1;
        this.isConfigured = parcel.readByte() != 1;
        this.nodeName = parcel.readString();
        this.mAddedNetworkKeyIndexes = parcel.readArrayList(cls.getClassLoader());
        this.mAddedNetworkKeys = parcel.readArrayList(NetworkKey.class.getClassLoader());
        this.mFlags = parcel.createByteArray();
        this.unicastAddress = parcel.createByteArray();
        this.deviceKey = parcel.createByteArray();
        this.ttl = (Integer) parcel.readValue(cls.getClassLoader());
        this.numberOfElements = parcel.readInt();
        this.mReceivedSequenceNumber = parcel.readInt();
        this.k2Output = (o00o00000o.O000000o) parcel.readParcelable(o00o00000o.O000000o.class.getClassLoader());
        this.companyIdentifier = (Integer) parcel.readValue(cls.getClassLoader());
        this.productIdentifier = (Integer) parcel.readValue(cls.getClassLoader());
        this.versionIdentifier = (Integer) parcel.readValue(cls.getClassLoader());
        this.crpl = (Integer) parcel.readValue(cls.getClassLoader());
        this.generatedNetworkId = parcel.createByteArray();
        this.mAddedAppKeyIndexes = parcel.readArrayList(cls.getClassLoader());
        this.mTimeStampInMillis = parcel.readLong();
        this.mConfigurationSrc = parcel.createByteArray();
        this.secureNetworkBeaconSupported = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.relaySettings = (RelaySettings) parcel.readParcelable(RelaySettings.class.getClassLoader());
        this.blackListed = parcel.readByte() != 1 ? true : z;
    }

    public ProvisionedMeshNode(UnprovisionedMeshNode unprovisionedMeshNode) {
        this.uuid = unprovisionedMeshNode.getDeviceUuid().toString();
        this.isProvisioned = unprovisionedMeshNode.isProvisioned();
        this.isConfigured = unprovisionedMeshNode.isConfigured();
        this.nodeName = unprovisionedMeshNode.getNodeName();
        this.networkKey = unprovisionedMeshNode.getNetworkKey();
        NetworkKey networkKey = new NetworkKey(unprovisionedMeshNode.getKeyIndex(), unprovisionedMeshNode.getNetworkKey());
        this.mAddedNetworkKeys.add(networkKey);
        this.identityKey = unprovisionedMeshNode.getIdentityKey();
        this.mFlags = unprovisionedMeshNode.getFlags();
        this.unicastAddress = unprovisionedMeshNode.getUnicastAddress();
        this.deviceKey = unprovisionedMeshNode.getDeviceKey();
        this.ttl = Integer.valueOf(unprovisionedMeshNode.getTtl());
        this.k2Output = o00o00000o.O00000Oo(networkKey.getKey(), o00o00000o.O00000oO);
        this.mTimeStampInMillis = unprovisionedMeshNode.getTimeStamp();
        this.mConfigurationSrc = unprovisionedMeshNode.getConfigurationSrc();
        this.numberOfElements = unprovisionedMeshNode.getNumberOfElements();
    }

    public static ProvisionedMeshNode createDefaultMeshNode(String str, String str2, String str3, int i, byte[] bArr, byte[] bArr2) {
        ProvisionedMeshNode provisionedMeshNode = new ProvisionedMeshNode();
        provisionedMeshNode.nodeMac = str2;
        provisionedMeshNode.isProvisioned = true;
        provisionedMeshNode.isConfigured = true;
        provisionedMeshNode.nodeName = str;
        provisionedMeshNode.networkKey = o00o0000oo.O000000o(str3);
        NetworkKey networkKey = new NetworkKey(0, o00o0000oo.O000000o(str3));
        provisionedMeshNode.mAddedNetworkKeys.add(networkKey);
        provisionedMeshNode.identityKey = o00o00000o.O00000o(o00o0000oo.O000000o(str3));
        provisionedMeshNode.mFlags = ByteBuffer.allocate(1).put((byte) 0).array();
        provisionedMeshNode.unicastAddress = o000oo0o0o.O000000o(i);
        provisionedMeshNode.deviceKey = bArr;
        provisionedMeshNode.setAddedAppKey(0, new o000o0o0o0(0, bArr2));
        provisionedMeshNode.ttl = 5;
        provisionedMeshNode.k2Output = o00o00000o.O00000Oo(networkKey.getKey(), o00o00000o.O00000oO);
        return provisionedMeshNode;
    }

    private int getFeatureState(Boolean bool) {
        return (bool == null || !bool.booleanValue()) ? 0 : 2;
    }

    public int describeContents() {
        return 0;
    }

    public /* bridge */ /* synthetic */ List getAddedAppKeyIndexes() {
        return super.getAddedAppKeyIndexes();
    }

    public final Map<Integer, o000o0o0o0> getAddedApplicationKeys() {
        return this.mAddedApplicationKeys;
    }

    public List<NetworkKey> getAddedNetworkKeys() {
        return this.mAddedNetworkKeys;
    }

    public final Integer getCompanyIdentifier() {
        return this.companyIdentifier;
    }

    public final Integer getCrpl() {
        return this.crpl;
    }

    public final byte[] getDeviceKey() {
        return this.deviceKey;
    }

    public final o00o00000o.O000000o getK2Output() {
        return this.k2Output;
    }

    public /* bridge */ /* synthetic */ String getMeshUuid() {
        return super.getMeshUuid();
    }

    public /* bridge */ /* synthetic */ byte[] getNetworkKey() {
        return super.getNetworkKey();
    }

    public String getNodeMac() {
        return this.nodeMac;
    }

    public final Integer getProductIdentifier() {
        return this.productIdentifier;
    }

    public final int getReceivedSequenceNumber() {
        return this.mReceivedSequenceNumber;
    }

    public /* bridge */ /* synthetic */ RelaySettings getRelaySettings() {
        return super.getRelaySettings();
    }

    public /* bridge */ /* synthetic */ int getSecurity() {
        return super.getSecurity();
    }

    public Integer getSeqAuth(byte[] bArr) {
        if (this.mSeqAuth.size() == 0) {
            return null;
        }
        return Integer.valueOf(this.mSeqAuth.get(o000oo0o0o.O00000Oo(bArr)));
    }

    public /* bridge */ /* synthetic */ long getTimeStamp() {
        return super.getTimeStamp();
    }

    public /* bridge */ /* synthetic */ String getUuid() {
        return super.getUuid();
    }

    public final Integer getVersionIdentifier() {
        return this.versionIdentifier;
    }

    public /* bridge */ /* synthetic */ boolean isBlackListed() {
        return super.isBlackListed();
    }

    public final Boolean isFriendFeatureSupported() {
        return this.friendFeatureSupported;
    }

    public final Boolean isLowPowerFeatureSupported() {
        return this.lowPowerFeatureSupported;
    }

    public /* bridge */ /* synthetic */ boolean isProvisioned() {
        return super.isProvisioned();
    }

    public final Boolean isProxyFeatureSupported() {
        return this.proxyFeatureSupported;
    }

    @Deprecated
    public final Boolean isRelayFeatureSupported() {
        return this.relayFeatureSupported;
    }

    public /* bridge */ /* synthetic */ Boolean isSecureNetworkBeaconSupported() {
        return super.isSecureNetworkBeaconSupported();
    }

    public final void setAddedAppKey(int i, o000o0o0o0 o000o0o0o0) {
        this.mAddedApplicationKeys.put(Integer.valueOf(i), o000o0o0o0);
    }

    public final void setAddedApplicationKeys(Map<Integer, o000o0o0o0> map) {
        this.mAddedApplicationKeys = map;
    }

    public /* bridge */ /* synthetic */ void setBlackListed(boolean z) {
        super.setBlackListed(z);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void setBluetoothDeviceAddress(String str) {
        super.setBluetoothDeviceAddress(str);
    }

    public final void setCompanyIdentifier(Integer num) {
        this.companyIdentifier = num;
    }

    public final void setCompositionData(o00000o000 o00000o000) {
        if (o00000o000 != null) {
            this.companyIdentifier = Integer.valueOf(o00000o000.e_());
            this.productIdentifier = Integer.valueOf(o00000o000.f_());
            this.versionIdentifier = Integer.valueOf(o00000o000.g_());
            this.crpl = Integer.valueOf(o00000o000.O00000oo());
            boolean O0000OOo = o00000o000.O0000OOo();
            boolean O0000Oo0 = o00000o000.O0000Oo0();
            boolean O0000Oo = o00000o000.O0000Oo();
            boolean O0000OoO = o00000o000.O0000OoO();
            int i = 1;
            int i2 = O0000Oo ? 1 : 2;
            int i3 = O0000OoO ? 1 : 2;
            int i4 = O0000Oo0 ? 1 : 2;
            if (!O0000OOo) {
                i = 2;
            }
            this.nodeFeatures = new oo0o0ooo0(i2, i3, i4, i);
            this.mElements.putAll(o00000o000.O0000Ooo());
        }
    }

    public final void setCrpl(Integer num) {
        this.crpl = num;
    }

    public void setDeviceKey(byte[] bArr) {
        this.deviceKey = bArr;
    }

    public final void setK2Output(o00o00000o.O000000o o000000o) {
        this.k2Output = o000000o;
    }

    @Deprecated
    public final void setLowPowerFeatureSupported(Boolean bool) {
        this.lowPowerFeatureSupported = bool;
    }

    public /* bridge */ /* synthetic */ void setMeshUuid(String str) {
        super.setMeshUuid(str);
    }

    public void setNodeMac(String str) {
        this.nodeMac = str;
    }

    public final void setProductIdentifier(Integer num) {
        this.productIdentifier = num;
    }

    public final void setReceivedSequenceNumber(int i) {
        this.mReceivedSequenceNumber = i;
    }

    public /* bridge */ /* synthetic */ void setRelaySettings(RelaySettings relaySettings) {
        super.setRelaySettings(relaySettings);
    }

    public /* bridge */ /* synthetic */ void setSecureNetworkBeaconSupported(Boolean bool) {
        super.setSecureNetworkBeaconSupported(bool);
    }

    public /* bridge */ /* synthetic */ void setSecurity(int i) {
        super.setSecurity(i);
    }

    public void setSeqAuth(byte[] bArr, int i) {
        this.mSeqAuth.put(o000oo0o0o.O00000Oo(bArr), i);
    }

    public /* bridge */ /* synthetic */ void setTimeStamp(long j) {
        super.setTimeStamp(j);
    }

    public /* bridge */ /* synthetic */ void setUuid(String str) {
        super.setUuid(str);
    }

    public final void setVersionIdentifier(Integer num) {
        this.versionIdentifier = num;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uuid);
        parcel.writeByte(this.isProvisioned ? (byte) 1 : 0);
        parcel.writeByte(this.isConfigured ? (byte) 1 : 0);
        parcel.writeString(this.nodeName);
        parcel.writeList(this.mAddedNetworkKeyIndexes);
        parcel.writeByteArray(this.mFlags);
        parcel.writeByteArray(this.unicastAddress);
        parcel.writeByteArray(this.deviceKey);
        parcel.writeValue(this.ttl);
        parcel.writeInt(this.numberOfElements);
        parcel.writeInt(this.mReceivedSequenceNumber);
        parcel.writeParcelable(this.k2Output, i);
        parcel.writeValue(this.companyIdentifier);
        parcel.writeValue(this.productIdentifier);
        parcel.writeValue(this.versionIdentifier);
        parcel.writeValue(this.crpl);
        parcel.writeByteArray(this.generatedNetworkId);
        parcel.writeList(this.mAddedAppKeyIndexes);
        parcel.writeLong(this.mTimeStampInMillis);
        parcel.writeByteArray(this.mConfigurationSrc);
        parcel.writeValue(this.secureNetworkBeaconSupported);
        parcel.writeParcelable(this.relaySettings, i);
        parcel.writeValue(Byte.valueOf(this.blackListed ? (byte) 1 : 0));
    }
}
