package com.tuya.smart.common;

import com.tuya.smart.android.device.bean.GroupDeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.GroupDeviceBean;

public class oOO0OOo0 {
    public static GroupBean O000000o(GroupRespBean groupRespBean) {
        GroupBean groupBean = new GroupBean();
        groupBean.setName(groupRespBean.getName());
        groupBean.setIconUrl(groupRespBean.getIconUrl());
        groupBean.setId(groupRespBean.getId());
        groupBean.setMeshId(groupRespBean.getMeshId());
        groupBean.setLocalId(groupRespBean.getLocalId());
        groupBean.setProductId(groupRespBean.getProductId());
        groupBean.setDisplayOrder(groupRespBean.getDisplayOrder());
        groupBean.setCategory(groupRespBean.getCategory());
        groupBean.setTime(groupRespBean.getTime());
        groupBean.setDps(groupRespBean.getDps());
        groupBean.setIsShare(groupRespBean.isShare());
        groupBean.setType((groupRespBean.getType() == 1 && groupRespBean.getGroupType() == 2) ? groupRespBean.getGroupType() : groupRespBean.getType());
        groupBean.setLocalKey(groupRespBean.getLocalKey());
        groupBean.setPv(groupRespBean.getPv());
        groupBean.setDeviceNum(groupRespBean.getDeviceNum());
        groupBean.setDpName(groupRespBean.getDpName());
        groupBean.setHomeDisplayOrder(groupRespBean.getHomeDisplayOrder());
        return groupBean;
    }

    public static GroupDeviceBean O000000o(GroupDeviceRespBean groupDeviceRespBean) {
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(groupDeviceRespBean.getDevId());
        if (deviceBean == null) {
            return null;
        }
        GroupDeviceBean groupDeviceBean = new GroupDeviceBean();
        groupDeviceBean.setDeviceBean(deviceBean);
        groupDeviceBean.setChecked(groupDeviceRespBean.isChecked());
        groupDeviceBean.setProductId(groupDeviceRespBean.getProductId());
        return groupDeviceBean;
    }
}
