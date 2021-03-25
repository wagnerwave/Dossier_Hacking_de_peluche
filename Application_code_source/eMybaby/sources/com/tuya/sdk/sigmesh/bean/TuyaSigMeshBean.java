package com.tuya.sdk.sigmesh.bean;

import com.tuya.smart.sdk.bean.SigMeshBean;

public class TuyaSigMeshBean extends SigMeshBean {
    public String macAdress;
    public ProvisionedMeshNode provisionedMeshNode;
    public int status;

    public TuyaSigMeshBean(SigMeshBean sigMeshBean) {
        this(sigMeshBean, (ProvisionedMeshNode) null);
    }

    public TuyaSigMeshBean(SigMeshBean sigMeshBean, ProvisionedMeshNode provisionedMeshNode2) {
        setMeshId(sigMeshBean.getMeshId());
        setCode(sigMeshBean.getCode());
        setPassword(sigMeshBean.getPassword());
        setShare(sigMeshBean.isShare());
        setLocalKey(sigMeshBean.getLocalKey());
        setName(sigMeshBean.getName());
        setPv(sigMeshBean.getPv());
        setMeshkey(sigMeshBean.getMeshkey());
        setProvisionedMeshNode(provisionedMeshNode2);
    }

    public String getMacAdress() {
        return this.macAdress;
    }

    public ProvisionedMeshNode getProvisionedMeshNode() {
        return this.provisionedMeshNode;
    }

    public int getStatus() {
        return this.status;
    }

    public void setMacAdress(String str) {
        this.macAdress = str;
    }

    public void setProvisionedMeshNode(ProvisionedMeshNode provisionedMeshNode2) {
        this.provisionedMeshNode = provisionedMeshNode2;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
