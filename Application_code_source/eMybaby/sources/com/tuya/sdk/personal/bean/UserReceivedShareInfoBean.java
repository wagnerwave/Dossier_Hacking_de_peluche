package com.tuya.sdk.personal.bean;

import com.tuya.smart.sdk.bean.BlueMeshShareBean;
import com.tuya.smart.sdk.bean.GroupShareBean;
import java.util.List;

public class UserReceivedShareInfoBean {
    public List<DevShareBean> devices;
    public List<GroupShareBean> groups;
    public List<BlueMeshShareBean> meshes;
    public String mobile;
    public String name;
    public String nameWithoutRemark;
    public String receivedName;
    public String remarkName;

    public List<DevShareBean> getDevices() {
        return this.devices;
    }

    public List<GroupShareBean> getGroups() {
        return this.groups;
    }

    public List<BlueMeshShareBean> getMeshes() {
        return this.meshes;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public String getNameWithoutRemark() {
        return this.nameWithoutRemark;
    }

    public String getReceivedName() {
        return this.receivedName;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public void setDevices(List<DevShareBean> list) {
        this.devices = list;
    }

    public void setGroups(List<GroupShareBean> list) {
        this.groups = list;
    }

    public void setMeshes(List<BlueMeshShareBean> list) {
        this.meshes = list;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameWithoutRemark(String str) {
        this.nameWithoutRemark = str;
    }

    public void setReceivedName(String str) {
        this.receivedName = str;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }
}
