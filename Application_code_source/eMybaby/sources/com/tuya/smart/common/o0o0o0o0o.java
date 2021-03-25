package com.tuya.smart.common;

import com.tuya.sdk.home.bean.RoomDeviceResponseBean;
import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInRoomBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.home.sdk.bean.UniversalBean;
import com.tuya.smart.home.sdk.callback.ITuyaRoomResultCallback;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class o0o0o0o0o extends BaseModel implements o0o0o0o00 {
    public final o0o000ooo O000000o = new o0o000ooo();
    public final o0o000o00 O00000Oo = new o0o000o00();
    public final long O00000o0;

    public o0o0o0o0o(long j) {
        super(TuyaSdk.getApplication());
        this.O00000o0 = j;
    }

    public void O000000o(final IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(this.O00000o0, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                TuyaHomeRelationCacheManager.O000000o().removeRoom(o0o0o0o0o.this.O00000o0);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(final Long l, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000o0(l, BizParentTypeEnum.GROUP, Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                RoomBean roomBeanByGroup = TuyaHomeRelationCacheManager.O000000o().getRoomBeanByGroup(l.longValue());
                if (roomBeanByGroup != null) {
                    TuyaHomeRelationCacheManager.O000000o().removeGroupFromRoom(roomBeanByGroup.getRoomId(), l.longValue());
                }
                TuyaHomeRelationCacheManager.O000000o().addGroupToRoom(o0o0o0o0o.this.O00000o0, l.longValue());
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(Object obj, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(obj, Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, new Business.ResultListener<ArrayList<RoomDeviceResponseBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<RoomDeviceResponseBean> arrayList, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<RoomDeviceResponseBean> arrayList, String str) {
                o0o0o0o0o.this.O000000o(arrayList);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, long j, ITuyaRoomResultCallback iTuyaRoomResultCallback) {
    }

    public void O000000o(final String str, final IResultCallback iResultCallback) {
        this.O000000o.O000000o(this.O00000o0, str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                o0o00o0o0.O000000o().O000000o(Long.valueOf(o0o0o0o0o.this.O00000o0)).setName(str);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(ArrayList<RoomDeviceResponseBean> arrayList) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        Iterator<RoomDeviceResponseBean> it = arrayList.iterator();
        while (it.hasNext()) {
            RoomDeviceResponseBean next = it.next();
            if (o0o00o00oo != null && next.getType() == BizParentTypeEnum.GROUP.getType()) {
                o0o00o00oo.O000000o().O000000o(Long.valueOf(next.getId()).longValue()).setDisplayOrder(next.getDisplayOrder());
            } else if (o0o00o00o0 != null && next.getType() == BizParentTypeEnum.DEVICE.getType()) {
                o0o00o00o0.O0000OOo().getDevRespBean(next.getId()).setDisplayOrder(next.getDisplayOrder());
            }
        }
    }

    public void O000000o(final List<String> list, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000o(list, BizParentTypeEnum.DEVICE, Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                TuyaHomeRelationCacheManager.O000000o().addDevListToRoom(o0o0o0o0o.this.O00000o0, list);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000Oo(final Long l, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(l, BizParentTypeEnum.GROUP, Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                TuyaHomeRelationCacheManager.O000000o().removeGroupFromRoom(o0o0o0o0o.this.O00000o0, l.longValue());
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000Oo(final String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000o0(str, BizParentTypeEnum.DEVICE, Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                RoomBean deviceRoomBean;
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (!(o0o00o00o0 == null || (deviceRoomBean = o0o00o00o0.O0000OOo().getDeviceRoomBean(str)) == null)) {
                    TuyaHomeRelationCacheManager.O000000o().removeDevFromRoom(deviceRoomBean.getRoomId(), str);
                }
                TuyaHomeRelationCacheManager.O000000o().addDevToRoom(o0o0o0o0o.this.O00000o0, str);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000Oo(final List<Long> list, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000o(list, BizParentTypeEnum.GROUP, Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                TuyaHomeRelationCacheManager.O000000o().addGroupListToRoom(o0o0o0o0o.this.O00000o0, list);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000o0(final String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(str, BizParentTypeEnum.DEVICE, Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                TuyaHomeRelationCacheManager.O000000o().removeDevFromRoom(o0o0o0o0o.this.O00000o0, str);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000o0(final List<DeviceAndGroupInRoomBean> list, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o((Object) Long.valueOf(this.O00000o0), BizParentTypeEnum.ROOM, list, true, (Business.ResultListener<ArrayList<UniversalBean>>) new Business.ResultListener<ArrayList<UniversalBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<UniversalBean> arrayList, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<UniversalBean> arrayList, String str) {
                TuyaHomeRelationCacheManager.O000000o().replaceDevGroupToRoom(list, o0o0o0o0o.this.O00000o0);
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
                Iterator<UniversalBean> it = arrayList.iterator();
                while (it.hasNext()) {
                    UniversalBean next = it.next();
                    if (o0o00o00o0 != null && next.getType() == TuyaHomeRelationCacheManager.HomeDataType.DEVICE.getType()) {
                        o0o00o00o0.O0000OOo().getDevRespBean(next.getId()).setDisplayOrder(next.getDisplayOrder());
                    } else if (o0o00o00oo != null && next.getType() == TuyaHomeRelationCacheManager.HomeDataType.GROUP.getType()) {
                        o0o00o00oo.O000000o().O00000o0(Long.valueOf(next.getId()).longValue()).setDisplayOrder(next.getDisplayOrder());
                    }
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void onDestroy() {
        this.O000000o.onDestroy();
        this.O00000Oo.onDestroy();
    }
}
