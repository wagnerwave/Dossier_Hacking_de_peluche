package com.tuya.sdk.sigmesh.bean;

import android.os.Parcelable;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.util.RelaySettings;
import com.tuya.smart.android.blemesh.bean.Element;
import com.tuya.smart.common.o000o0o0o0;
import com.tuya.smart.common.o00o000o0o;
import com.tuya.smart.common.oo0o0ooo0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class ProvisionedBaseMeshNode implements Parcelable {
    public static final int HIGH = 1;
    public static final int LOW = 0;
    public static final String TAG = ProvisionedBaseMeshNode.class.getSimpleName();
    public boolean blackListed = false;
    public String bluetoothAddress;
    public String bluetoothDeviceAddress;
    public Integer companyIdentifier = null;
    public Integer crpl = null;
    public byte[] deviceKey;
    public Boolean friendFeatureSupported = null;
    public byte[] generatedNetworkId;
    public byte[] identityKey;
    public boolean isConfigured;
    public boolean isProvisioned;
    public byte[] ivIndex;
    public byte[] keyIndex;
    public Boolean lowPowerFeatureSupported = null;
    public List<Integer> mAddedAppKeyIndexes = new ArrayList();
    public Map<Integer, o000o0o0o0> mAddedApplicationKeys = new LinkedHashMap();
    public List<Integer> mAddedNetworkKeyIndexes = new ArrayList();
    public List<NetworkKey> mAddedNetworkKeys = new ArrayList();
    public byte[] mConfigurationSrc = {Byte.MAX_VALUE, -1};
    public Map<Integer, Element> mElements = new LinkedHashMap();
    public byte[] mFlags;
    public int mReceivedSequenceNumber;
    public o00o000o0o mSeqAuth = new o00o000o0o();
    public long mTimeStampInMillis;
    public String meshUuid;
    public int netKeyIndex;
    public byte[] networkKey;
    public oo0o0ooo0 nodeFeatures = null;
    public String nodeIdentifier;
    public String nodeName = "My Node";
    public int numberOfElements;
    public Integer productIdentifier = null;
    public Boolean proxyFeatureSupported = null;
    public Boolean relayFeatureSupported = null;
    public RelaySettings relaySettings;
    public Boolean secureNetworkBeaconSupported;
    public int security = 0;
    public Integer ttl = 5;
    public byte[] unicastAddress;
    public String uuid;
    public Integer versionIdentifier = null;

    public List<Integer> getAddedAppKeyIndexes() {
        return this.mAddedAppKeyIndexes;
    }

    public final byte[] getConfigurationSrc() {
        return this.mConfigurationSrc;
    }

    public final byte[] getFlags() {
        return this.mFlags;
    }

    public final byte[] getIdentityKey() {
        return this.identityKey;
    }

    @Deprecated
    public final byte[] getIvIndex() {
        return this.ivIndex;
    }

    @Deprecated
    public final byte[] getKeyIndex() {
        return this.keyIndex;
    }

    public String getMeshUuid() {
        return this.meshUuid;
    }

    public byte[] getNetworkKey() {
        return this.networkKey;
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public RelaySettings getRelaySettings() {
        return this.relaySettings;
    }

    public int getSecurity() {
        return this.security;
    }

    public long getTimeStamp() {
        return this.mTimeStampInMillis;
    }

    public final Integer getTtl() {
        return this.ttl;
    }

    public final byte[] getUnicastAddress() {
        return this.unicastAddress;
    }

    public final int getUnicastAddressInt() {
        return ByteBuffer.wrap(this.unicastAddress).order(ByteOrder.BIG_ENDIAN).getShort();
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isBlackListed() {
        return this.blackListed;
    }

    public final boolean isConfigured() {
        return this.isConfigured;
    }

    public boolean isProvisioned() {
        return this.isProvisioned;
    }

    public Boolean isSecureNetworkBeaconSupported() {
        return this.secureNetworkBeaconSupported;
    }

    public void setBlackListed(boolean z) {
        this.blackListed = z;
    }

    @Deprecated
    public void setBluetoothDeviceAddress(String str) {
        this.bluetoothDeviceAddress = str;
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

    public void setMeshUuid(String str) {
        this.meshUuid = str;
    }

    public final void setNodeName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nodeName = str;
        }
    }

    public void setRelaySettings(RelaySettings relaySettings2) {
        this.relaySettings = relaySettings2;
    }

    public void setSecureNetworkBeaconSupported(Boolean bool) {
        this.secureNetworkBeaconSupported = bool;
    }

    public void setSecurity(int i) {
        this.security = i;
    }

    public void setTimeStamp(long j) {
        this.mTimeStampInMillis = j;
    }

    public final void setTtl(Integer num) {
        this.ttl = num;
    }

    public final void setUnicastAddress(byte[] bArr) {
        this.unicastAddress = bArr;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
