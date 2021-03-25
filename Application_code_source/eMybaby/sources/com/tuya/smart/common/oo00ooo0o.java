package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.tuya.sdk.personal.bean.DevShareBean;
import com.tuya.sdk.personal.bean.DevShareUserBean;
import com.tuya.sdk.personal.bean.UserReceivedShareBean;
import com.tuya.sdk.personal.bean.UserReceivedShareInfoBean;
import com.tuya.sdk.personal.bean.UserShareInfoBean;
import com.tuya.smart.home.sdk.bean.DeviceShareBean;
import com.tuya.smart.home.sdk.bean.PersonBean;
import com.tuya.smart.home.sdk.bean.ShareReceivedUserDetailBean;
import com.tuya.smart.home.sdk.bean.ShareSentUserDetailBean;
import com.tuya.smart.home.sdk.bean.SharedUserInfoBean;
import com.tuya.smart.home.sdk.bean.SharerInfoBean;
import java.util.ArrayList;
import java.util.List;

public class oo00ooo0o {
    public static ShareReceivedUserDetailBean O000000o(UserReceivedShareInfoBean userReceivedShareInfoBean) {
        ShareReceivedUserDetailBean shareReceivedUserDetailBean = (ShareReceivedUserDetailBean) JSON.parseObject(JSON.toJSONString(userReceivedShareInfoBean), ShareReceivedUserDetailBean.class);
        shareReceivedUserDetailBean.setDevices(O00000o(userReceivedShareInfoBean.getDevices()));
        return shareReceivedUserDetailBean;
    }

    public static ShareSentUserDetailBean O000000o(UserShareInfoBean userShareInfoBean) {
        ShareSentUserDetailBean shareSentUserDetailBean = (ShareSentUserDetailBean) JSON.parseObject(JSON.toJSONString(userShareInfoBean), ShareSentUserDetailBean.class);
        shareSentUserDetailBean.setDevices(O00000o(userShareInfoBean.getDevices()));
        return shareSentUserDetailBean;
    }

    public static SharedUserInfoBean O000000o(DevShareUserBean devShareUserBean) {
        SharedUserInfoBean sharedUserInfoBean = (SharedUserInfoBean) JSON.parseObject(JSON.toJSONString(devShareUserBean), SharedUserInfoBean.class);
        sharedUserInfoBean.setMemeberId(devShareUserBean.getId());
        sharedUserInfoBean.setIconUrl(devShareUserBean.getHeadPic());
        sharedUserInfoBean.setRemarkName(devShareUserBean.getName());
        sharedUserInfoBean.setUserName(devShareUserBean.getUsername());
        sharedUserInfoBean.setHomeId(devShareUserBean.getGid());
        return sharedUserInfoBean;
    }

    public static SharedUserInfoBean O000000o(UserReceivedShareBean userReceivedShareBean) {
        SharedUserInfoBean sharedUserInfoBean = (SharedUserInfoBean) JSON.parseObject(JSON.toJSONString(userReceivedShareBean), SharedUserInfoBean.class);
        sharedUserInfoBean.setMemeberId(userReceivedShareBean.getId());
        sharedUserInfoBean.setRemarkName(userReceivedShareBean.getReceivedName());
        return sharedUserInfoBean;
    }

    public static SharedUserInfoBean O000000o(PersonBean personBean) {
        SharedUserInfoBean sharedUserInfoBean = (SharedUserInfoBean) JSON.parseObject(JSON.toJSONString(personBean), SharedUserInfoBean.class);
        sharedUserInfoBean.setRemarkName(personBean.getName());
        sharedUserInfoBean.setMemeberId(personBean.getId());
        sharedUserInfoBean.setUserName(personBean.getUsername());
        sharedUserInfoBean.setHomeId((long) personBean.getGid().intValue());
        sharedUserInfoBean.setRemarkName(personBean.getMemberName());
        sharedUserInfoBean.setIconUrl(personBean.getHeadPic());
        return sharedUserInfoBean;
    }

    public static SharedUserInfoBean O000000o(SharerInfoBean sharerInfoBean) {
        SharedUserInfoBean sharedUserInfoBean = (SharedUserInfoBean) JSON.parseObject(JSON.toJSONString(sharerInfoBean), SharedUserInfoBean.class);
        sharedUserInfoBean.setIconUrl(sharerInfoBean.getHeadPic());
        sharedUserInfoBean.setRemarkName(sharerInfoBean.getName());
        return sharedUserInfoBean;
    }

    public static List<SharedUserInfoBean> O000000o(List<PersonBean> list) {
        ArrayList arrayList = new ArrayList();
        for (PersonBean O000000o : list) {
            arrayList.add(O000000o(O000000o));
        }
        return arrayList;
    }

    public static List<SharedUserInfoBean> O00000Oo(List<UserReceivedShareBean> list) {
        ArrayList arrayList = new ArrayList();
        for (UserReceivedShareBean O000000o : list) {
            arrayList.add(O000000o(O000000o));
        }
        return arrayList;
    }

    public static List<DeviceShareBean> O00000o(List<DevShareBean> list) {
        ArrayList arrayList = new ArrayList();
        for (DevShareBean next : list) {
            DeviceShareBean deviceShareBean = new DeviceShareBean();
            deviceShareBean.setDevId(next.getId());
            deviceShareBean.setDeviceName(next.getName());
            deviceShareBean.setHomeName(next.getHomeName());
            deviceShareBean.setIconUrl(next.getIconUrl());
            deviceShareBean.setRoom(next.getRoom());
            deviceShareBean.setShare(next.isShare());
            deviceShareBean.setTempShare(next.isTempShare());
            arrayList.add(deviceShareBean);
        }
        return arrayList;
    }

    public static List<SharedUserInfoBean> O00000o0(List<DevShareUserBean> list) {
        ArrayList arrayList = new ArrayList();
        for (DevShareUserBean O000000o : list) {
            arrayList.add(O000000o(O000000o));
        }
        return arrayList;
    }
}
