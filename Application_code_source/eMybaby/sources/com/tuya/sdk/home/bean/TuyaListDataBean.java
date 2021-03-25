package com.tuya.sdk.home.bean;

import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.ProductBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.List;

public class TuyaListDataBean {
    public List<DeviceRespBean> deviceRespBeen;
    public List<DeviceRespBean> deviceRespShareList;
    public List<DeviceSortResponseBean> deviceSortResponseBeans;
    public List<GroupRespBean> groupBeen;
    public List<GroupRespBean> groupRespShareList;
    public HomeResponseBean homeResponseBean;
    public List<BlueMeshBean> meshBeen;
    public List<ProductBean> productBeen;
    public String relation;
    public List<RoomBean> roomBeen;
    public List<SigMeshBean> sigMeshBeen;

    public List<DeviceRespBean> getDeviceRespBeen() {
        return this.deviceRespBeen;
    }

    public List<DeviceRespBean> getDeviceRespShareList() {
        return this.deviceRespShareList;
    }

    public List<DeviceSortResponseBean> getDeviceSortResponseBeans() {
        return this.deviceSortResponseBeans;
    }

    public List<GroupRespBean> getGroupBeen() {
        return this.groupBeen;
    }

    public List<GroupRespBean> getGroupRespShareList() {
        return this.groupRespShareList;
    }

    public HomeResponseBean getHomeResponseBean() {
        return this.homeResponseBean;
    }

    public List<BlueMeshBean> getMeshBeen() {
        return this.meshBeen;
    }

    public List<ProductBean> getProductBeen() {
        return this.productBeen;
    }

    public String getRelation() {
        return this.relation;
    }

    public List<RoomBean> getRoomBeen() {
        return this.roomBeen;
    }

    public List<SigMeshBean> getSigMeshBeen() {
        return this.sigMeshBeen;
    }

    public void setDeviceRespBeen(List<DeviceRespBean> list) {
        this.deviceRespBeen = list;
    }

    public void setDeviceRespShareList(List<DeviceRespBean> list) {
        this.deviceRespShareList = list;
    }

    public void setDeviceSortResponseBeans(List<DeviceSortResponseBean> list) {
        this.deviceSortResponseBeans = list;
    }

    public void setGroupBeen(List<GroupRespBean> list) {
        this.groupBeen = list;
    }

    public void setGroupRespShareList(List<GroupRespBean> list) {
        this.groupRespShareList = list;
    }

    public void setHomeResponseBean(HomeResponseBean homeResponseBean2) {
        this.homeResponseBean = homeResponseBean2;
    }

    public void setMeshBeen(List<BlueMeshBean> list) {
        this.meshBeen = list;
    }

    public void setProductBeen(List<ProductBean> list) {
        this.productBeen = list;
    }

    public void setRelation(String str) {
        this.relation = str;
    }

    public void setRoomBeen(List<RoomBean> list) {
        this.roomBeen = list;
    }

    public void setSigMeshBeen(List<SigMeshBean> list) {
        this.sigMeshBeen = list;
    }
}
