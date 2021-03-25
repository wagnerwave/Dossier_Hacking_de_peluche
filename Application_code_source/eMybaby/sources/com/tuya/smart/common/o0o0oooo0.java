package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.tuya.sdk.home.bean.HomeResponseBean;
import com.tuya.sdk.home.bean.MemberResponseBean;
import com.tuya.sdk.home.bean.RoomResponseBean;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.MemberBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import java.util.ArrayList;
import java.util.List;

public class o0o0oooo0 {
    public static HomeBean O000000o(HomeResponseBean homeResponseBean) {
        HomeBean homeBean = (HomeBean) JSON.parseObject(JSON.toJSONString(homeResponseBean), HomeBean.class);
        homeBean.setRooms(O00000o0(homeResponseBean.getRooms()));
        homeBean.setHomeId(homeResponseBean.getGid());
        homeBean.setInviteName(homeResponseBean.getNickName());
        homeBean.setHomeStatus(homeResponseBean.getDealStatus());
        return homeBean;
    }

    public static MemberBean O000000o(MemberResponseBean memberResponseBean) {
        MemberBean memberBean = (MemberBean) JSON.parseObject(JSON.toJSONString(memberResponseBean), MemberBean.class);
        memberBean.setHomeId(memberResponseBean.getGid());
        memberBean.setMemberId(memberResponseBean.getId());
        memberBean.setNickName(memberResponseBean.getName());
        memberBean.setAccount(memberResponseBean.getUsername());
        memberBean.setMemberStatus(memberResponseBean.getDealStatus());
        return memberBean;
    }

    public static RoomBean O000000o(RoomResponseBean roomResponseBean) {
        RoomBean roomBean = (RoomBean) JSON.parseObject(JSON.toJSONString(roomResponseBean), RoomBean.class);
        roomBean.setRoomId(roomResponseBean.getId());
        return roomBean;
    }

    public static List<HomeBean> O000000o(List<HomeResponseBean> list) {
        ArrayList arrayList = new ArrayList();
        for (HomeResponseBean O000000o : list) {
            arrayList.add(O000000o(O000000o));
        }
        return arrayList;
    }

    public static List<MemberBean> O00000Oo(List<MemberResponseBean> list) {
        ArrayList arrayList = new ArrayList();
        for (MemberResponseBean O000000o : list) {
            arrayList.add(O000000o(O000000o));
        }
        return arrayList;
    }

    public static List<RoomBean> O00000o0(List<RoomResponseBean> list) {
        ArrayList arrayList = new ArrayList();
        for (RoomResponseBean O000000o : list) {
            arrayList.add(O000000o(O000000o));
        }
        return arrayList;
    }
}
