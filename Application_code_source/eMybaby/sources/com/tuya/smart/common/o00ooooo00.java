package com.tuya.smart.common;

import android.content.Context;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.user.api.ICheckAccountCallback;
import com.tuya.smart.android.user.api.ILoginCallback;
import com.tuya.smart.android.user.api.IReNickNameCallback;
import com.tuya.smart.android.user.api.IValidateCallback;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.sdk.api.IResultCallback;

public class o00ooooo00 extends o00oooo000 implements o00oooo0o0 {
    public o00ooooo00(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
        this.O000000o = new o00ooo0o00();
    }

    public void O000000o(final int i, final IResultCallback iResultCallback) {
        this.O000000o.O000000o(i, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                User user = o00ooo00o0.O000000o().getUser();
                if (user != null) {
                    user.setTempUnit(i);
                    o00ooo00o0.O000000o().saveUser(user);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(final String str, final IReNickNameCallback iReNickNameCallback) {
        this.O000000o.O000000o(str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IReNickNameCallback iReNickNameCallback = iReNickNameCallback;
                if (iReNickNameCallback != null) {
                    iReNickNameCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                User user = o00ooo00o0.O000000o().getUser();
                user.setNickName(str);
                o00ooo00o0.O000000o().saveUser(user);
                IReNickNameCallback iReNickNameCallback = iReNickNameCallback;
                if (iReNickNameCallback != null) {
                    iReNickNameCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(final String str, final IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(str, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                User user = o00ooo00o0.O000000o().getUser();
                if (user != null) {
                    user.setTimezoneId(str);
                    o00ooo00o0.O000000o().saveUser(user);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, String str2, final ILoginCallback iLoginCallback) {
        this.O000000o.O00000oo(str, str2, new Business.ResultListener<User>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                o00ooooo00.this.O000000o(user);
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onSuccess(user);
                }
            }
        });
    }

    public void O000000o(String str, String str2, final IValidateCallback iValidateCallback) {
        this.O000000o.O000000o(str, str2, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IValidateCallback iValidateCallback = iValidateCallback;
                if (iValidateCallback != null) {
                    iValidateCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iValidateCallback == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    iValidateCallback.onSuccess();
                } else {
                    iValidateCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(String str, String str2, final IResultCallback iResultCallback) {
        this.O000000o.O00000oO(str, str2, new Business.ResultListener<Boolean>() {
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

    public void O000000o(String str, String str2, String str3, final ICheckAccountCallback iCheckAccountCallback) {
        this.O000000o.O000000o(str, str2, str3, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                ICheckAccountCallback iCheckAccountCallback = iCheckAccountCallback;
                if (iCheckAccountCallback != null) {
                    iCheckAccountCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iCheckAccountCallback == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    iCheckAccountCallback.onSuccess();
                } else {
                    iCheckAccountCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, final ILoginCallback iLoginCallback) {
        this.O000000o.O00000o(str, str2, str3, new Business.ResultListener<User>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                o00ooooo00.this.O000000o(user);
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onSuccess(user);
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, final IResultCallback iResultCallback) {
        this.O000000o.O00000oO(str, str2, str3, new Business.ResultListener<Boolean>() {
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

    public void O00000Oo(String str, String str2, final ILoginCallback iLoginCallback) {
        this.O000000o.O0000OOo(str, str2, new Business.ResultListener<User>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                o00ooooo00.this.O000000o(user);
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onSuccess(user);
                }
            }
        });
    }

    public void O00000Oo(String str, String str2, final IResultCallback iResultCallback) {
        this.O000000o.O0000Oo(str, str2, new Business.ResultListener<Boolean>() {
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

    public void O00000Oo(String str, String str2, String str3, final ILoginCallback iLoginCallback) {
        this.O000000o.O0000O0o(str, str2, str3, new Business.ResultListener<User>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                o00ooooo00.this.O000000o(user);
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onSuccess(user);
                }
            }
        });
    }

    public void O00000o0(String str, String str2, String str3, final ILoginCallback iLoginCallback) {
        this.O000000o.O00000oo(str, str2, str3, new Business.ResultListener<User>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                o00ooooo00.this.O000000o(user);
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onSuccess(user);
                }
            }
        });
    }

    public void onDestroy() {
        o00ooo0o00 o00ooo0o00 = this.O000000o;
        if (o00ooo0o00 != null) {
            o00ooo0o00.cancelAll();
        }
    }
}
