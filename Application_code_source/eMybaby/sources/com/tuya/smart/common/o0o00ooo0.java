package com.tuya.smart.common;

import com.tuya.sdk.home.bean.DeviceSortResponseBean;
import com.tuya.sdk.home.bean.RoomResponseBean;
import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.api.ITuyaGroupModel;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInHomeBean;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetRoomListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaRoomResultCallback;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.CloudZigbeeGroupCreateBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.GroupDeviceBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class o0o00ooo0 extends BaseModel implements o0o0o000o {
    public static final String O000000o = "HomeKitModel";
    public final long O00000Oo;
    public o0o000ooo O00000o = new o0o000ooo();
    public o0o0000oo O00000o0 = new o0o0000oo();
    public o0o000oo0 O00000oO = new o0o000oo0();
    public o0o000o00 O00000oo = new o0o000o00();
    public o0o00oo0o O0000O0o = new o0o00oo0o(TuyaSdk.getApplication());
    public ITuyaGroupModel O0000OOo;

    public o0o00ooo0(long j) {
        super(TuyaSdk.getApplication());
        this.O00000Oo = j;
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        if (o0o00o00oo != null) {
            this.O0000OOo = o0o00o00oo.O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(final IResultCallback iResultCallback) {
        this.O0000O0o.O000000o(this.O00000Oo, (o0o0oo000<Boolean>) new o0o0oo000<Boolean>() {
            public void O000000o(Boolean bool) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }

            public void O000000o(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }
        });
    }

    private void O00000o(List<RoomBean> list) {
        Collections.sort(list, new Comparator<RoomBean>() {
            /* renamed from: O000000o */
            public int compare(RoomBean roomBean, RoomBean roomBean2) {
                return roomBean.getDisplayOrder() - roomBean2.getDisplayOrder();
            }
        });
    }

    public HomeBean O000000o() {
        HomeBean homeBean = TuyaHomeRelationCacheManager.O000000o().getHomeBean(this.O00000Oo);
        if (homeBean == null) {
            return null;
        }
        O00000o(homeBean.getRooms());
        return homeBean;
    }

    public List<RoomBean> O000000o(List<DeviceBean> list) {
        ArrayList arrayList = new ArrayList();
        for (DeviceBean devId : list) {
            RoomBean roomBeanBydevice = TuyaHomeRelationCacheManager.O000000o().getRoomBeanBydevice(this.O00000Oo, devId.getDevId());
            if (roomBeanBydevice != null) {
                arrayList.add(roomBeanBydevice);
            }
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public void O000000o(final long j, final IResultCallback iResultCallback) {
        this.O00000o.O00000Oo(j, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                TuyaHomeRelationCacheManager.O000000o().removeRoom(j);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(long j, String str, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback) {
        this.O0000OOo.getGroupDeviceList(this.O00000Oo, j, str, iTuyaResultCallback);
    }

    public void O000000o(long j, String str, String str2, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback) {
        this.O0000OOo.getZigbeeGroupDeviceList(this.O00000Oo, j, str, str2, iTuyaResultCallback);
    }

    public void O000000o(final ITuyaGetRoomListCallback iTuyaGetRoomListCallback) {
        this.O00000o.O000000o(this.O00000Oo, (Business.ResultListener<ArrayList<RoomResponseBean>>) new Business.ResultListener<ArrayList<RoomResponseBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<RoomResponseBean> arrayList, String str) {
                ITuyaGetRoomListCallback iTuyaGetRoomListCallback = iTuyaGetRoomListCallback;
                if (iTuyaGetRoomListCallback != null) {
                    iTuyaGetRoomListCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<RoomResponseBean> arrayList, String str) {
                ITuyaGetRoomListCallback iTuyaGetRoomListCallback = iTuyaGetRoomListCallback;
                if (iTuyaGetRoomListCallback != null) {
                    iTuyaGetRoomListCallback.onSuccess(o0o0oooo0.O00000o0(arrayList));
                }
            }
        });
    }

    public void O000000o(final ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        o0o0ooo0o.O00000Oo().O00000o0();
        this.O0000O0o.O00000Oo(this.O00000Oo, (o0o0oo000<HomeBean>) new o0o0oo000<HomeBean>() {
            public void O000000o(HomeBean homeBean) {
                ITuyaHomeResultCallback iTuyaHomeResultCallback = iTuyaHomeResultCallback;
                if (iTuyaHomeResultCallback != null) {
                    iTuyaHomeResultCallback.onSuccess(homeBean);
                }
            }

            public void O000000o(String str, String str2) {
                ITuyaHomeResultCallback iTuyaHomeResultCallback = iTuyaHomeResultCallback;
                if (iTuyaHomeResultCallback != null) {
                    iTuyaHomeResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void O000000o(final IResultCallback iResultCallback) {
        this.O00000o0.O00000Oo(this.O00000Oo, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                o0o00oo00.O000000o(o0o00ooo0.this.O00000Oo);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, double d2, double d3, String str2, IResultCallback iResultCallback) {
        final IResultCallback iResultCallback2 = iResultCallback;
        final String str3 = str;
        final double d4 = d2;
        final double d5 = d3;
        final String str4 = str2;
        this.O00000o0.O000000o(this.O00000Oo, str, d2, d3, str2, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                HomeBean homeBean = TuyaHomeRelationCacheManager.O000000o().getHomeBean(o0o00ooo0.this.O00000Oo);
                if (homeBean == null) {
                    homeBean = new HomeBean();
                }
                homeBean.setName(str3);
                double d2 = d4;
                if (d2 != 0.0d) {
                    homeBean.setLon(d2);
                }
                double d3 = d5;
                if (d3 != 0.0d) {
                    homeBean.setLat(d3);
                }
                homeBean.setGeoName(str4);
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
                o0o00oo00.O000000o(o0o00ooo0.this.O00000Oo, str3);
            }
        });
    }

    public void O000000o(String str, double d2, double d3, String str2, List<String> list, boolean z, IResultCallback iResultCallback) {
        final IResultCallback iResultCallback2 = iResultCallback;
        final String str3 = str;
        final double d4 = d2;
        final double d5 = d3;
        final String str4 = str2;
        this.O00000o0.O000000o(this.O00000Oo, str, d2, d3, str2, list, z, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                HomeBean homeBean = TuyaHomeRelationCacheManager.O000000o().getHomeBean(o0o00ooo0.this.O00000Oo);
                if (homeBean == null) {
                    homeBean = new HomeBean();
                }
                homeBean.setName(str3);
                double d2 = d4;
                if (d2 != 0.0d) {
                    homeBean.setLon(d2);
                }
                double d3 = d5;
                if (d3 != 0.0d) {
                    homeBean.setLat(d3);
                }
                homeBean.setGeoName(str4);
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
                o0o00oo00.O000000o(o0o00ooo0.this.O00000Oo, str3);
            }
        });
    }

    public void O000000o(String str, final ITuyaRoomResultCallback iTuyaRoomResultCallback) {
        final RoomBean roomBean = new RoomBean();
        roomBean.setName(str);
        this.O00000o.O000000o(roomBean, this.O00000Oo, (Business.ResultListener<RoomResponseBean>) new Business.ResultListener<RoomResponseBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, RoomResponseBean roomResponseBean, String str) {
                ITuyaRoomResultCallback iTuyaRoomResultCallback = iTuyaRoomResultCallback;
                if (iTuyaRoomResultCallback != null) {
                    iTuyaRoomResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, RoomResponseBean roomResponseBean, String str) {
                if (iTuyaRoomResultCallback != null) {
                    roomBean.setRoomId(roomResponseBean.getId());
                    roomBean.setDisplayOrder(roomResponseBean.getDisplayOrder());
                    TuyaHomeRelationCacheManager.O000000o().addRoomToHome(o0o00ooo0.this.O00000Oo, roomBean);
                    iTuyaRoomResultCallback.onSuccess(roomBean);
                }
            }
        });
    }

    public void O000000o(String str, String str2, int i, String str3, ITuyaResultCallback<CloudZigbeeGroupCreateBean> iTuyaResultCallback) {
        this.O0000OOo.createZigbeeEmptyGroup(str, this.O00000Oo, str2, i, str3, iTuyaResultCallback);
    }

    public void O000000o(String str, String str2, List<String> list, ITuyaResultCallback<Long> iTuyaResultCallback) {
        this.O0000OOo.createNewGroup(this.O00000Oo, str, str2, list, iTuyaResultCallback);
    }

    public void O000000o(String str, List<DeviceAndGroupInHomeBean> list, final IResultCallback iResultCallback) {
        this.O00000oo.O000000o(str, list, (Business.ResultListener<ArrayList<DeviceSortResponseBean>>) new Business.ResultListener<ArrayList<DeviceSortResponseBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<DeviceSortResponseBean> arrayList, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<DeviceSortResponseBean> arrayList, String str) {
                o0o00ooo0.this.O00000o0(arrayList);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(List<Long> list, final IResultCallback iResultCallback) {
        this.O00000o0.O000000o(list, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public List<RoomBean> O00000Oo(List<GroupBean> list) {
        ArrayList arrayList = new ArrayList();
        for (GroupBean id : list) {
            RoomBean roomBeanByGroup = TuyaHomeRelationCacheManager.O000000o().getRoomBeanByGroup(this.O00000Oo, id.getId());
            if (roomBeanByGroup != null) {
                arrayList.add(roomBeanByGroup);
            }
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public void O00000Oo(final ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        this.O0000O0o.O00000o0(this.O00000Oo, new o0o0oo000<HomeBean>() {
            public void O000000o(HomeBean homeBean) {
                ITuyaHomeResultCallback iTuyaHomeResultCallback = iTuyaHomeResultCallback;
                if (iTuyaHomeResultCallback != null) {
                    iTuyaHomeResultCallback.onSuccess(homeBean);
                }
            }

            public void O000000o(String str, String str2) {
                ITuyaHomeResultCallback iTuyaHomeResultCallback = iTuyaHomeResultCallback;
                if (iTuyaHomeResultCallback != null) {
                    iTuyaHomeResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void O00000Oo(List<Long> list, final IResultCallback iResultCallback) {
        this.O00000o.O000000o(list, (Business.ResultListener<ArrayList<RoomResponseBean>>) new Business.ResultListener<ArrayList<RoomResponseBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<RoomResponseBean> arrayList, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<RoomResponseBean> arrayList, String str) {
                o0o00o0o0.O000000o().O000000o(arrayList);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000o0(List<DeviceSortResponseBean> list) {
        DeviceRespBean devRespBean;
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        for (DeviceSortResponseBean next : list) {
            if (o0o00o00oo != null && next.getBizType() == BizParentTypeEnum.GROUP.getType()) {
                GroupRespBean O00000o02 = o0o00o00oo.O000000o().O00000o0(Long.valueOf(next.getBizId()).longValue());
                if (O00000o02 != null) {
                    O00000o02.setHomeDisplayOrder(next.getHomeDisplayOrder());
                }
            } else if (!(o0o00o00o0 == null || next.getBizType() != BizParentTypeEnum.DEVICE.getType() || (devRespBean = o0o00o00o0.O0000OOo().getDevRespBean(next.getBizId())) == null)) {
                devRespBean.setHomeDisplayOrder(next.getHomeDisplayOrder());
            }
        }
    }

    public void O00000o0(List<String> list, final IResultCallback iResultCallback) {
        this.O00000o0.O000000o(this.O00000Oo, list, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    o0o00ooo0.this.O00000Oo(iResultCallback);
                }
            }
        });
    }

    public void onDestroy() {
        o0o0ooo0o.O00000Oo().O000000o(this.O00000Oo);
        this.O00000o0.onDestroy();
        this.O00000o.onDestroy();
        this.O00000oO.onDestroy();
        this.O00000oo.onDestroy();
        this.O0000O0o.onDestroy();
        ITuyaGroupModel iTuyaGroupModel = this.O0000OOo;
        if (iTuyaGroupModel != null) {
            iTuyaGroupModel.onDestroy();
        }
    }
}
