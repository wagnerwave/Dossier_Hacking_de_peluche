package com.tuya.smart.common;

import com.tuya.sdk.home.bean.MemberResponseBean;
import com.tuya.sdk.home.bean.StorageSignResponseBean;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.home.sdk.bean.MemberBean;
import com.tuya.smart.home.sdk.bean.MemberWrapperBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetMemberListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaMemberResultCallback;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class o0o0o0000 extends BaseModel implements o0o0o00oo {
    public o0o000oo0 O000000o = new o0o000oo0();

    public o0o0o0000() {
        super(TuyaSdk.getApplication());
    }

    /* access modifiers changed from: private */
    public void O000000o(StorageSignResponseBean storageSignResponseBean, File file, final IBooleanCallback iBooleanCallback) {
        TuyaSmartNetWork.getOkHttpClient().newCall(new Request.Builder().url(storageSignResponseBean.getUri()).put(RequestBody.create(MediaType.parse((String) storageSignResponseBean.getHeaders().get("Content-Type")), file)).addHeader("Content-Type", (String) storageSignResponseBean.getHeaders().get("Content-Type")).addHeader("Authorization", (String) storageSignResponseBean.getHeaders().get("Authorization")).addHeader("Date", (String) storageSignResponseBean.getHeaders().get("Date")).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                iBooleanCallback.onError(iOException.getMessage(), iOException.getMessage());
            }

            public void onResponse(Call call, Response response) {
                iBooleanCallback.onSuccess();
            }
        });
    }

    public void O000000o(long j, final ITuyaGetMemberListCallback iTuyaGetMemberListCallback) {
        this.O000000o.O00000Oo(j, (Business.ResultListener<ArrayList<MemberResponseBean>>) new Business.ResultListener<ArrayList<MemberResponseBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<MemberResponseBean> arrayList, String str) {
                ITuyaGetMemberListCallback iTuyaGetMemberListCallback = iTuyaGetMemberListCallback;
                if (iTuyaGetMemberListCallback != null) {
                    iTuyaGetMemberListCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<MemberResponseBean> arrayList, String str) {
                ITuyaGetMemberListCallback iTuyaGetMemberListCallback = iTuyaGetMemberListCallback;
                if (iTuyaGetMemberListCallback != null) {
                    iTuyaGetMemberListCallback.onSuccess(o0o0oooo0.O00000Oo(arrayList));
                }
            }
        });
    }

    public void O000000o(long j, final IResultCallback iResultCallback) {
        this.O000000o.O000000o(j, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O000000o(long j, final ITuyaDataCallback<Map<String, Object>> iTuyaDataCallback) {
        this.O000000o.O00000o0(j, new Business.ResultListener<Map<String, Object>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Map<String, Object> map, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Map<String, Object> map, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(map);
                }
            }
        });
    }

    public void O000000o(long j, String str, String str2, String str3, boolean z, ITuyaMemberResultCallback iTuyaMemberResultCallback) {
        final MemberBean memberBean = new MemberBean();
        memberBean.setHomeId(j);
        memberBean.setNickName(str3);
        memberBean.setAccount(str2);
        boolean z2 = z;
        memberBean.setAdmin(z2);
        o0o000oo0 o0o000oo0 = this.O000000o;
        final ITuyaMemberResultCallback iTuyaMemberResultCallback2 = iTuyaMemberResultCallback;
        AnonymousClass7 r9 = new Business.ResultListener<Long>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Long l, String str) {
                ITuyaMemberResultCallback iTuyaMemberResultCallback = iTuyaMemberResultCallback2;
                if (iTuyaMemberResultCallback != null) {
                    iTuyaMemberResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Long l, String str) {
                if (iTuyaMemberResultCallback2 != null) {
                    memberBean.setMemberId(l.longValue());
                    iTuyaMemberResultCallback2.onSuccess(memberBean);
                }
            }
        };
        String str4 = str;
        o0o000oo0.O000000o(j, str4, str2, str3, z2, r9);
    }

    public void O000000o(long j, String str, String str2, boolean z, final IResultCallback iResultCallback) {
        this.O000000o.O000000o(j, str, str2, z, new Business.ResultListener<Boolean>() {
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

    public void O000000o(long j, String str, boolean z, final IResultCallback iResultCallback) {
        this.O000000o.O000000o(j, str, z, new Business.ResultListener<Boolean>() {
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
        this.O000000o.O000000o(j, z, new Business.ResultListener<Boolean>() {
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

    public void O000000o(MemberWrapperBean memberWrapperBean, final IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(memberWrapperBean, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void O000000o(MemberWrapperBean memberWrapperBean, final ITuyaDataCallback<MemberBean> iTuyaDataCallback) {
        final MemberBean memberBean = new MemberBean();
        memberBean.setHomeId(memberWrapperBean.getHomeId());
        memberBean.setNickName(memberWrapperBean.getNickName());
        memberBean.setHeadPic(memberWrapperBean.getHeadPic());
        memberBean.setAccount(memberWrapperBean.getAccount());
        memberBean.setAdmin(memberWrapperBean.isAdmin());
        this.O000000o.O000000o(memberWrapperBean, (Business.ResultListener<Long>) new Business.ResultListener<Long>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Long l, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Long l, String str) {
                if (iTuyaDataCallback != null) {
                    memberBean.setMemberId(l.longValue());
                    iTuyaDataCallback.onSuccess(memberBean);
                }
            }
        });
    }

    public void O000000o(String str, final File file, final IBooleanCallback iBooleanCallback) {
        this.O000000o.O000000o(str, (Business.ResultListener<StorageSignResponseBean>) new Business.ResultListener<StorageSignResponseBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, StorageSignResponseBean storageSignResponseBean, String str) {
                iBooleanCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, StorageSignResponseBean storageSignResponseBean, String str) {
                o0o0o0000.this.O000000o(storageSignResponseBean, file, iBooleanCallback);
            }
        });
    }

    public void O00000Oo(long j, boolean z, final IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(j, z, new Business.ResultListener<Boolean>() {
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

    public void onDestroy() {
        this.O000000o.onDestroy();
    }
}
