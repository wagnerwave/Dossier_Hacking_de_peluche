package com.tuya.sdk.sigmesh.bean;

import android.util.SparseArray;

public abstract class Message {
    public int aid;
    public int akf;
    public int aszmic;
    public int companyIdentifier;
    public int ctl;
    public byte[] dst;
    public byte[] encryptionKey;
    public byte[] ivIndex;
    public byte[] key;
    public byte[] mSequenceNumber;
    public String netKey;
    public SparseArray<byte[]> networkPdu;
    public int opCode;
    public byte[] parameters;
    public int pduType;
    public byte[] privacyKey;
    public boolean segmented;
    public byte[] src;
    public int ttl = 4;

    public final int getAid() {
        return this.aid;
    }

    public final int getAkf() {
        return this.akf;
    }

    public final int getAszmic() {
        return this.aszmic;
    }

    public final int getCompanyIdentifier() {
        return this.companyIdentifier;
    }

    public abstract int getCtl();

    public final byte[] getDst() {
        return this.dst;
    }

    public final byte[] getEncryptionKey() {
        return this.encryptionKey;
    }

    public final byte[] getIvIndex() {
        return this.ivIndex;
    }

    public final byte[] getKey() {
        return this.key;
    }

    public String getNetKey() {
        return this.netKey;
    }

    public final SparseArray<byte[]> getNetworkPdu() {
        return this.networkPdu;
    }

    public final int getOpCode() {
        return this.opCode;
    }

    public final byte[] getParameters() {
        return this.parameters;
    }

    public int getPduType() {
        return this.pduType;
    }

    public final byte[] getPrivacyKey() {
        return this.privacyKey;
    }

    public final byte[] getSequenceNumber() {
        return this.mSequenceNumber;
    }

    public final byte[] getSrc() {
        return this.src;
    }

    public final int getTtl() {
        return this.ttl;
    }

    public final boolean isSegmented() {
        return this.segmented;
    }

    public final void setAid(int i) {
        this.aid = i;
    }

    public final void setAkf(int i) {
        this.akf = i;
    }

    public final void setAszmic(int i) {
        this.aszmic = i;
    }

    public final void setCompanyIdentifier(int i) {
        this.companyIdentifier = i;
    }

    public final void setDst(byte[] bArr) {
        this.dst = bArr;
    }

    public final void setEncryptionKey(byte[] bArr) {
        this.encryptionKey = bArr;
    }

    public final void setIvIndex(byte[] bArr) {
        this.ivIndex = bArr;
    }

    public final void setKey(byte[] bArr) {
        this.key = bArr;
    }

    public void setNetKey(String str) {
        this.netKey = str;
    }

    public final void setNetworkPdu(SparseArray<byte[]> sparseArray) {
        this.networkPdu = sparseArray;
    }

    public final void setOpCode(int i) {
        this.opCode = i;
    }

    public final void setParameters(byte[] bArr) {
        this.parameters = bArr;
    }

    public void setPduType(int i) {
        this.pduType = i;
    }

    public final void setPrivacyKey(byte[] bArr) {
        this.privacyKey = bArr;
    }

    public final void setSegmented(boolean z) {
        this.segmented = z;
    }

    public final void setSequenceNumber(byte[] bArr) {
        this.mSequenceNumber = bArr;
    }

    public final void setSrc(byte[] bArr) {
        this.src = bArr;
    }

    public final void setTtl(int i) {
        this.ttl = i;
    }
}
