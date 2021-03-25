package com.tuya.smart.common;

import com.tuya.sdk.personal.bean.AddShareInfoBean;
import com.tuya.sdk.personal.bean.DevShareUserBean;
import com.tuya.sdk.personal.bean.UserReceivedShareBean;
import com.tuya.sdk.personal.bean.UserReceivedShareInfoBean;
import com.tuya.sdk.personal.bean.UserShareInfoBean;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.bean.DeviceType;
import com.tuya.smart.home.sdk.bean.PersonBean;
import com.tuya.smart.home.sdk.bean.ShareReceivedUserDetailBean;
import com.tuya.smart.home.sdk.bean.ShareSentUserDetailBean;
import com.tuya.smart.home.sdk.bean.SharedUserInfoBean;
import com.tuya.smart.home.sdk.bean.SharerInfoBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.ShareIdBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oo00oo000 implements oo00o0ooo {
    public static oo00oo000 O000000o;
    public final oo00o0oo0 O00000Oo = new oo00o0oo0();

    public static oo00oo000 O00000Oo() {
        if (O000000o == null) {
            O000000o = new oo00oo000();
        }
        return O000000o;
    }

    public void O000000o() {
        this.O00000Oo.onDestroy();
    }

    public void O000000o(int i, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(i, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O000000o(long j, final ITuyaResultCallback<ShareSentUserDetailBean> iTuyaResultCallback) {
        this.O00000Oo.O00000o(j, new Business.ResultListener<UserShareInfoBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, UserShareInfoBean userShareInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, UserShareInfoBean userShareInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo00ooo0o.O000000o(userShareInfoBean));
                }
            }
        });
    }

    public void O000000o(long j, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000oO(j, new Business.ResultListener<Boolean>() {
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

    public void O000000o(long j, String str, long j2, long j3, IResultCallback iResultCallback) {
        final IResultCallback iResultCallback2 = iResultCallback;
        this.O00000Oo.O000000o(j, str, j2, j3, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iResultCallback2 == null || !bool.booleanValue()) {
                    IResultCallback iResultCallback = iResultCallback2;
                    if (iResultCallback != null) {
                        iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        return;
                    }
                    return;
                }
                iResultCallback2.onSuccess();
            }
        });
    }

    public void O000000o(long j, String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O000000o(long j, String str, final String str2, ShareIdBean shareIdBean, boolean z, ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback) {
        oo00o0oo0 oo00o0oo0 = this.O00000Oo;
        List<String> devIds = shareIdBean.getDevIds();
        List<String> meshIds = shareIdBean.getMeshIds();
        final ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback2 = iTuyaResultCallback;
        AnonymousClass5 r10 = new Business.ResultListener<AddShareInfoBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, AddShareInfoBean addShareInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback2;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, AddShareInfoBean addShareInfoBean, String str) {
                if (iTuyaResultCallback2 != null) {
                    SharedUserInfoBean sharedUserInfoBean = new SharedUserInfoBean();
                    sharedUserInfoBean.setUserName(str2);
                    sharedUserInfoBean.setMemeberId(addShareInfoBean.getRelationId());
                    sharedUserInfoBean.setRemarkName(addShareInfoBean.getReceiverName());
                    iTuyaResultCallback2.onSuccess(sharedUserInfoBean);
                }
            }
        };
        oo00o0oo0.O000000o(j, str, str2, devIds, (List<Long>) null, meshIds, z, r10);
    }

    public void O000000o(long j, String str, final String str2, List<String> list, final ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback) {
        this.O00000Oo.O000000o(Long.valueOf(j), str, str2, list, (Business.ResultListener<AddShareInfoBean>) new Business.ResultListener<AddShareInfoBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, AddShareInfoBean addShareInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, AddShareInfoBean addShareInfoBean, String str) {
                if (iTuyaResultCallback != null) {
                    SharedUserInfoBean sharedUserInfoBean = new SharedUserInfoBean();
                    sharedUserInfoBean.setUserName(str2);
                    sharedUserInfoBean.setMemeberId(addShareInfoBean.getRelationId());
                    sharedUserInfoBean.setRemarkName(addShareInfoBean.getReceiverName());
                    iTuyaResultCallback.onSuccess(sharedUserInfoBean);
                }
            }
        });
    }

    public void O000000o(long j, List<String> list, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, list, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O000000o(long j, boolean z, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, z, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O000000o(final ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(new Business.ResultListener<ArrayList<UserReceivedShareBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<UserReceivedShareBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<UserReceivedShareBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo00ooo0o.O00000Oo(arrayList));
                }
            }
        });
    }

    public void O000000o(String str, long j, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, j, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O000000o(String str, DeviceType deviceType, String str2, String str3, final ITuyaResultCallback<Integer> iTuyaResultCallback) {
        this.O00000Oo.O000000o(str, deviceType, str2, str3, (Business.ResultListener<Integer>) new Business.ResultListener<Integer>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Integer num, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Integer num, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(num);
                }
            }
        });
    }

    public void O000000o(String str, final ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000Oo(str, (Business.ResultListener<ArrayList<DevShareUserBean>>) new Business.ResultListener<ArrayList<DevShareUserBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<DevShareUserBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<DevShareUserBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo00ooo0o.O00000o0(arrayList));
                }
            }
        });
    }

    public void O000000o(final String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (o0o00o00o0 != null) {
                    o0o00o00o0.O0000o00().removeDevCache(str);
                }
            }
        });
    }

    public void O00000Oo(long j, final ITuyaResultCallback<ShareReceivedUserDetailBean> iTuyaResultCallback) {
        this.O00000Oo.O0000O0o(j, new Business.ResultListener<UserReceivedShareInfoBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, UserReceivedShareInfoBean userReceivedShareInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, UserReceivedShareInfoBean userReceivedShareInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo00ooo0o.O000000o(userReceivedShareInfoBean));
                }
            }
        });
    }

    public void O00000Oo(long j, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000oo(j, new Business.ResultListener<Boolean>() {
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

    public void O00000Oo(long j, String str, long j2, long j3, IResultCallback iResultCallback) {
        final IResultCallback iResultCallback2 = iResultCallback;
        this.O00000Oo.O00000Oo(j, str, j2, j3, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback2;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iResultCallback2 == null || !bool.booleanValue()) {
                    IResultCallback iResultCallback = iResultCallback2;
                    if (iResultCallback != null) {
                        iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        return;
                    }
                    return;
                }
                iResultCallback2.onSuccess();
            }
        });
    }

    public void O00000Oo(long j, String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(j, str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O00000Oo(final ITuyaResultCallback<List<DeviceRespBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000Oo(new Business.ResultListener<ArrayList<DeviceRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<DeviceRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<DeviceRespBean> arrayList, String str) {
                if (iTuyaResultCallback != null) {
                    Iterator<DeviceRespBean> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().setResptime(businessResponse.getT());
                    }
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O00000Oo(String str, long j, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(str, j, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O00000Oo(String str, final ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback) {
        this.O00000Oo.O00000o0(str, (Business.ResultListener<SharerInfoBean>) new Business.ResultListener<SharerInfoBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, SharerInfoBean sharerInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, SharerInfoBean sharerInfoBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo00ooo0o.O000000o(sharerInfoBean));
                }
            }
        });
    }

    public void O00000o(String str, long j, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000o(str, j, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iResultCallback == null || !bool.booleanValue()) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        return;
                    }
                    return;
                }
                iResultCallback.onSuccess();
            }
        });
    }

    public void O00000o0(long j, final ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000Oo(j, (Business.ResultListener<ArrayList<PersonBean>>) new Business.ResultListener<ArrayList<PersonBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<PersonBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<PersonBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo00ooo0o.O000000o((List<PersonBean>) arrayList));
                }
            }
        });
    }

    public void O00000o0(final ITuyaResultCallback<List<GroupRespBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000o0(new Business.ResultListener<ArrayList<GroupRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<GroupRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<GroupRespBean> arrayList, String str) {
                if (iTuyaResultCallback != null) {
                    Iterator<GroupRespBean> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().setResptime(businessResponse.getT());
                    }
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O00000o0(String str, long j, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000o0(str, j, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iResultCallback == null || !bool.booleanValue()) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        return;
                    }
                    return;
                }
                iResultCallback.onSuccess();
            }
        });
    }
}
