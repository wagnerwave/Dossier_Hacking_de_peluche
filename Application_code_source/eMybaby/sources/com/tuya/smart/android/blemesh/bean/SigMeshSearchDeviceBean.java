package com.tuya.smart.android.blemesh.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.sigmesh.bean.ScanRecord;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import java.util.Map;

public class SigMeshSearchDeviceBean extends SearchDeviceBean implements Parcelable {
    public static final Parcelable.Creator<SigMeshSearchDeviceBean> CREATOR = new Parcelable.Creator<SigMeshSearchDeviceBean>() {
        public SigMeshSearchDeviceBean createFromParcel(Parcel parcel) {
            return new SigMeshSearchDeviceBean(parcel);
        }

        public SigMeshSearchDeviceBean[] newArray(int i) {
            return new SigMeshSearchDeviceBean[i];
        }
    };
    public ProvisioningCapabilities capabilities;
    public Map<Integer, Element> element;
    public MeshBeacon meshBeacon;
    public int productIdentifier;
    public ProvisionedMeshNode provisionedMeshNode;
    public ScanRecord scanRecordBean;
    public UnprovisionedMeshNode unprovisionedMeshNode;
    public int versionIdentifier;

    public SigMeshSearchDeviceBean() {
    }

    public SigMeshSearchDeviceBean(Parcel parcel) {
        super(parcel);
        this.meshBeacon = (MeshBeacon) parcel.readParcelable(MeshBeacon.class.getClassLoader());
        this.unprovisionedMeshNode = (UnprovisionedMeshNode) parcel.readParcelable(UnprovisionedMeshNode.class.getClassLoader());
        this.capabilities = (ProvisioningCapabilities) parcel.readParcelable(ProvisioningCapabilities.class.getClassLoader());
        this.provisionedMeshNode = (ProvisionedMeshNode) parcel.readParcelable(ProvisionedMeshNode.class.getClassLoader());
        this.productIdentifier = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public ProvisioningCapabilities getCapabilities() {
        return this.capabilities;
    }

    public Map<Integer, Element> getElement() {
        return this.element;
    }

    public MeshBeacon getMeshBeacon() {
        return this.meshBeacon;
    }

    public int getProductIdentifier() {
        return this.productIdentifier;
    }

    public ProvisionedMeshNode getProvisionedMeshNode() {
        return this.provisionedMeshNode;
    }

    public ScanRecord getScanRecordBean() {
        return this.scanRecordBean;
    }

    public UnprovisionedMeshNode getUnprovisionedMeshNode() {
        return this.unprovisionedMeshNode;
    }

    public int getVersionIdentifier() {
        return this.versionIdentifier;
    }

    public void setCapabilities(ProvisioningCapabilities provisioningCapabilities) {
        this.capabilities = provisioningCapabilities;
    }

    public void setElement(Map<Integer, Element> map) {
        this.element = map;
    }

    public void setMeshBeacon(MeshBeacon meshBeacon2) {
        this.meshBeacon = meshBeacon2;
    }

    public void setProductIdentifier(int i) {
        this.productIdentifier = i;
    }

    public void setProvisionedMeshNode(ProvisionedMeshNode provisionedMeshNode2) {
        this.provisionedMeshNode = provisionedMeshNode2;
    }

    public void setScanRecordBean(ScanRecord scanRecord) {
        this.scanRecordBean = scanRecord;
    }

    public void setUnprovisionedMeshNode(UnprovisionedMeshNode unprovisionedMeshNode2) {
        this.unprovisionedMeshNode = unprovisionedMeshNode2;
    }

    public void setVersionIdentifier(int i) {
        this.versionIdentifier = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.meshBeacon, i);
        parcel.writeParcelable(this.unprovisionedMeshNode, i);
        parcel.writeParcelable(this.capabilities, i);
        parcel.writeParcelable(this.provisionedMeshNode, i);
        parcel.writeInt(this.productIdentifier);
    }
}
