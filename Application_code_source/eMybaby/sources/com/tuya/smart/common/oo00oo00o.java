package com.tuya.smart.common;

import com.tuya.smart.home.sdk.api.ITuyaHomeDeviceShare;
import com.tuya.smart.home.sdk.bean.DeviceType;
import com.tuya.smart.home.sdk.bean.ShareReceivedUserDetailBean;
import com.tuya.smart.home.sdk.bean.ShareSentUserDetailBean;
import com.tuya.smart.home.sdk.bean.SharedUserInfoBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.ShareIdBean;
import java.util.List;

public class oo00oo00o implements ITuyaHomeDeviceShare {
    public static oo00oo00o O00000Oo;
    public final oo00o0ooo O000000o = oo00oo000.O00000Oo();

    public static oo00oo00o O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new oo00oo00o();
        }
        return O00000Oo;
    }

    public void addShare(long j, String str, String str2, ShareIdBean shareIdBean, boolean z, final ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback) {
        this.O000000o.O000000o(j, str, str2, shareIdBean, z, new ITuyaResultCallback<SharedUserInfoBean>() {
            /* renamed from: O000000o */
            public void onSuccess(SharedUserInfoBean sharedUserInfoBean) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(sharedUserInfoBean);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void addShareWithHomeId(long j, String str, String str2, List<String> list, final ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback) {
        this.O000000o.O000000o(j, str, str2, list, (ITuyaResultCallback<SharedUserInfoBean>) new ITuyaResultCallback<SharedUserInfoBean>() {
            /* renamed from: O000000o */
            public void onSuccess(SharedUserInfoBean sharedUserInfoBean) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(sharedUserInfoBean);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void addShareWithMemberId(long j, List<String> list, IResultCallback iResultCallback) {
        this.O000000o.O000000o(j, list, iResultCallback);
    }

    public void confirmShareInviteShare(int i, IResultCallback iResultCallback) {
        this.O000000o.O000000o(i, iResultCallback);
    }

    public void disableDevShare(String str, long j, IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(str, j, iResultCallback);
    }

    public void enableDevShare(String str, long j, IResultCallback iResultCallback) {
        this.O000000o.O000000o(str, j, iResultCallback);
    }

    public void getReceivedShareInfo(long j, final ITuyaResultCallback<ShareReceivedUserDetailBean> iTuyaResultCallback) {
        this.O000000o.O00000Oo(j, (ITuyaResultCallback<ShareReceivedUserDetailBean>) new ITuyaResultCallback<ShareReceivedUserDetailBean>() {
            /* renamed from: O000000o */
            public void onSuccess(ShareReceivedUserDetailBean shareReceivedUserDetailBean) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(shareReceivedUserDetailBean);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void getUserShareInfo(long j, final ITuyaResultCallback<ShareSentUserDetailBean> iTuyaResultCallback) {
        this.O000000o.O000000o(j, (ITuyaResultCallback<ShareSentUserDetailBean>) new ITuyaResultCallback<ShareSentUserDetailBean>() {
            /* renamed from: O000000o */
            public void onSuccess(ShareSentUserDetailBean shareSentUserDetailBean) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(shareSentUserDetailBean);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void inviteShare(String str, String str2, String str3, ITuyaResultCallback<Integer> iTuyaResultCallback) {
        this.O000000o.O000000o(str, DeviceType.DEVICE, str2, str3, iTuyaResultCallback);
    }

    public void onDestroy() {
        this.O000000o.O000000o();
    }

    public void queryDevShareUserList(String str, final ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback) {
        this.O000000o.O000000o(str, (ITuyaResultCallback<List<SharedUserInfoBean>>) new ITuyaResultCallback<List<SharedUserInfoBean>>() {
            /* renamed from: O000000o */
            public void onSuccess(List<SharedUserInfoBean> list) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(list);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void queryShareDevFromInfo(String str, final ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback) {
        this.O000000o.O00000Oo(str, (ITuyaResultCallback<SharedUserInfoBean>) new ITuyaResultCallback<SharedUserInfoBean>() {
            /* renamed from: O000000o */
            public void onSuccess(SharedUserInfoBean sharedUserInfoBean) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(sharedUserInfoBean);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void queryShareReceivedUserList(final ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback) {
        this.O000000o.O000000o(new ITuyaResultCallback<List<SharedUserInfoBean>>() {
            /* renamed from: O000000o */
            public void onSuccess(List<SharedUserInfoBean> list) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(list);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void queryUserShareList(long j, final ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback) {
        this.O000000o.O00000o0(j, new ITuyaResultCallback<List<SharedUserInfoBean>>() {
            /* renamed from: O000000o */
            public void onSuccess(List<SharedUserInfoBean> list) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(list);
                }
            }

            public void onError(String str, String str2) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void removeReceivedDevShare(String str, IResultCallback iResultCallback) {
        this.O000000o.O000000o(str, iResultCallback);
    }

    public void removeReceivedUserShare(long j, IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(j, iResultCallback);
    }

    public void removeUserShare(long j, IResultCallback iResultCallback) {
        this.O000000o.O000000o(j, iResultCallback);
    }

    public void renameReceivedShareNickname(long j, String str, IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(j, str, iResultCallback);
    }

    public void renameShareNickname(long j, String str, IResultCallback iResultCallback) {
        this.O000000o.O000000o(j, str, iResultCallback);
    }
}
