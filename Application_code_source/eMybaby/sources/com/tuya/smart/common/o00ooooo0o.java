package com.tuya.smart.common;

import android.content.Context;
import android.text.TextUtils;
import com.tuya.sdk.user.bean.TokenBean;
import com.tuya.smart.android.common.utils.MD5Util;
import com.tuya.smart.android.common.utils.RSAUtil;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.user.api.ICheckAccountCallback;
import com.tuya.smart.android.user.api.ILoginCallback;
import com.tuya.smart.android.user.api.IRegisterCallback;
import com.tuya.smart.android.user.api.IResetPasswordCallback;
import com.tuya.smart.android.user.api.IUidLoginCallback;
import com.tuya.smart.android.user.api.IValidateCallback;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.interior.bean.UserRespBean;
import com.tuya.smart.sdk.api.IResultCallback;

public class o00ooooo0o extends o00oooo000 {
    public static final String O00000Oo = "WHAT_USERNAME_ERROR";
    public static final String O00000o0 = "WHAT_PASSWORD_ERROR";
    public o00ooo0o00 O00000o = new o00ooo0o00();

    public o00ooooo0o(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
    }

    private Result O000000o(String str) {
        return TextUtils.isEmpty(str) ? new Result(O00000Oo, "username error") : new Result();
    }

    private boolean O000000o(String str, String str2, ILoginCallback iLoginCallback) {
        Result O000000o = O000000o(str);
        if (!O000000o.isSuccess()) {
            if (iLoginCallback != null) {
                iLoginCallback.onError(O000000o.getErrorCode(), O000000o.getError());
            }
            return false;
        }
        Result O00000Oo2 = O00000Oo(str2);
        if (O00000Oo2.isSuccess()) {
            return true;
        }
        if (iLoginCallback != null) {
            iLoginCallback.onError(O00000Oo2.getErrorCode(), O00000Oo2.getError());
        }
        return false;
    }

    private Result O00000Oo(String str) {
        return TextUtils.isEmpty(str) ? new Result(O00000o0, "password error") : new Result();
    }

    public void O000000o(final IResultCallback iResultCallback) {
        this.O00000o.O00000o0(new Business.ResultListener<Boolean>() {
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
                    user.setDataVersion(1);
                    o00ooo00o0.O000000o().saveUser(user);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(final String str, final ICheckAccountCallback iCheckAccountCallback) {
        this.O00000o.O000000o(new Business.ResultListener<TokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                ICheckAccountCallback iCheckAccountCallback = iCheckAccountCallback;
                if (iCheckAccountCallback != null) {
                    iCheckAccountCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                boolean z;
                String md5AsBase64 = MD5Util.md5AsBase64(str);
                try {
                    RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                    md5AsBase64 = RSAUtil.encrypt(md5AsBase64);
                    z = true;
                } catch (Exception unused) {
                    z = false;
                }
                o00ooooo0o.this.O00000o.O000000o(md5AsBase64, tokenBean.getToken(), z, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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
        });
    }

    public void O000000o(String str, String str2, final IValidateCallback iValidateCallback) {
        Result O000000o = O000000o(str2);
        if (O000000o.isSuccess()) {
            this.O00000o.O00000Oo(str, str2, TuyaUtil.getApplicationName(this.mContext), new Business.ResultListener<Boolean>() {
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
        } else if (iValidateCallback != null) {
            iValidateCallback.onError(O000000o.getErrorCode(), O000000o.getError());
        }
    }

    public void O000000o(String str, String str2, String str3, int i, final IResultCallback iResultCallback) {
        this.O00000o.O000000o(str, str2, str3, i, (Business.ResultListener<String>) new Business.ResultListener<String>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        if (O000000o(str2, str3, iLoginCallback)) {
            final ILoginCallback iLoginCallback2 = iLoginCallback;
            final String str4 = str3;
            final String str5 = str;
            final String str6 = str2;
            this.O00000o.O00000o0(str, str2, new Business.ResultListener<TokenBean>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                    ILoginCallback iLoginCallback = iLoginCallback2;
                    if (iLoginCallback != null) {
                        iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                    boolean z;
                    String str2;
                    String md5AsBase64 = MD5Util.md5AsBase64(str4);
                    try {
                        RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                        str2 = RSAUtil.encrypt(md5AsBase64);
                        z = true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        str2 = md5AsBase64;
                        z = false;
                    }
                    o00ooooo0o.this.O00000o.O00000Oo(str5, str6, str2, tokenBean.getToken(), z, new Business.ResultListener<User>() {
                        /* renamed from: O000000o */
                        public void onFailure(BusinessResponse businessResponse, User user, String str) {
                            ILoginCallback iLoginCallback = iLoginCallback2;
                            if (iLoginCallback != null) {
                                iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                            }
                        }

                        /* renamed from: O00000Oo */
                        public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                            o00ooooo0o.this.O000000o(user);
                            ILoginCallback iLoginCallback = iLoginCallback2;
                            if (iLoginCallback != null) {
                                iLoginCallback.onSuccess(user);
                            }
                        }
                    });
                }
            });
        }
    }

    public void O000000o(String str, String str2, String str3, IRegisterCallback iRegisterCallback) {
        final IRegisterCallback iRegisterCallback2 = iRegisterCallback;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        this.O00000o.O00000o0(str, str2, new Business.ResultListener<TokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                IRegisterCallback iRegisterCallback = iRegisterCallback2;
                if (iRegisterCallback != null) {
                    iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                boolean z;
                String str2;
                String md5AsBase64 = MD5Util.md5AsBase64(str4);
                try {
                    RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                    str2 = RSAUtil.encrypt(md5AsBase64);
                    z = true;
                } catch (Exception unused) {
                    str2 = md5AsBase64;
                    z = false;
                }
                o00ooooo0o.this.O00000o.O00000o0(str5, str6, str2, tokenBean.getToken(), z, new Business.ResultListener<User>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, User user, String str) {
                        IRegisterCallback iRegisterCallback = iRegisterCallback2;
                        if (iRegisterCallback != null) {
                            iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                        o00ooooo0o.this.O000000o(user);
                        IRegisterCallback iRegisterCallback = iRegisterCallback2;
                        if (iRegisterCallback != null) {
                            iRegisterCallback.onSuccess(user);
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, String str3, IResetPasswordCallback iResetPasswordCallback) {
        final IResetPasswordCallback iResetPasswordCallback2 = iResetPasswordCallback;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        this.O00000o.O00000o(str, str2, new Business.ResultListener<TokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                IResetPasswordCallback iResetPasswordCallback = iResetPasswordCallback2;
                if (iResetPasswordCallback != null) {
                    iResetPasswordCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                boolean z;
                String str2;
                String md5AsBase64 = MD5Util.md5AsBase64(str4);
                try {
                    RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                    str2 = RSAUtil.encrypt(md5AsBase64);
                    z = true;
                } catch (Exception unused) {
                    str2 = md5AsBase64;
                    z = false;
                }
                o00ooooo0o.this.O00000o.O00000oo(str5, str6, str2, tokenBean.getToken(), z, new Business.ResultListener<Boolean>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                        IResetPasswordCallback iResetPasswordCallback = iResetPasswordCallback2;
                        if (iResetPasswordCallback != null) {
                            iResetPasswordCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                        if (iResetPasswordCallback2 == null) {
                            return;
                        }
                        if (bool.booleanValue()) {
                            iResetPasswordCallback2.onSuccess();
                        } else {
                            iResetPasswordCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, String str3, String str4, int i, final IResultCallback iResultCallback) {
        this.O00000o.O000000o(str, str2, str3, str4, i, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iResultCallback == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    iResultCallback.onSuccess();
                } else {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, String str4, ILoginCallback iLoginCallback) {
        if (str4.equals("email")) {
            O000000o(str, str2, str3, iLoginCallback);
        } else {
            O00000Oo(str, str2, str3, iLoginCallback);
        }
    }

    public void O000000o(String str, String str2, String str3, String str4, IRegisterCallback iRegisterCallback) {
        final IRegisterCallback iRegisterCallback2 = iRegisterCallback;
        final String str5 = str3;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str4;
        this.O00000o.O00000o0(str, str2, new Business.ResultListener<TokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                IRegisterCallback iRegisterCallback = iRegisterCallback2;
                if (iRegisterCallback != null) {
                    iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                boolean z;
                String str2;
                String md5AsBase64 = MD5Util.md5AsBase64(str5);
                try {
                    RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                    str2 = RSAUtil.encrypt(md5AsBase64);
                    z = true;
                } catch (Exception unused) {
                    str2 = md5AsBase64;
                    z = false;
                }
                o00ooooo0o.this.O00000o.O000000o(str6, str7, str2, tokenBean.getToken(), str8, z, (Business.ResultListener<User>) new Business.ResultListener<User>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, User user, String str) {
                        IRegisterCallback iRegisterCallback = iRegisterCallback2;
                        if (iRegisterCallback != null) {
                            iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                        o00ooooo0o.this.O000000o(user);
                        IRegisterCallback iRegisterCallback = iRegisterCallback2;
                        if (iRegisterCallback != null) {
                            iRegisterCallback.onSuccess(user);
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, String str3, String str4, final IResetPasswordCallback iResetPasswordCallback) {
        this.O00000o.O00000o0(str, str2, str3, MD5Util.md5AsBase64(str4), new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResetPasswordCallback iResetPasswordCallback = iResetPasswordCallback;
                if (iResetPasswordCallback != null) {
                    iResetPasswordCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iResetPasswordCallback == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    iResetPasswordCallback.onSuccess();
                } else {
                    iResetPasswordCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, IRegisterCallback iRegisterCallback) {
        final IRegisterCallback iRegisterCallback2 = iRegisterCallback;
        final String str6 = str5;
        final String str7 = str4;
        final String str8 = str3;
        final String str9 = str;
        final String str10 = str2;
        this.O00000o.O000000o(str3, str, false, str2, (Business.ResultListener<TokenBean>) new Business.ResultListener<TokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                IRegisterCallback iRegisterCallback = iRegisterCallback2;
                if (iRegisterCallback != null) {
                    iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                boolean z;
                String str2;
                String md5AsBase64 = MD5Util.md5AsBase64(str6);
                try {
                    RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                    str2 = RSAUtil.encrypt(md5AsBase64);
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str2 = md5AsBase64;
                    z = false;
                }
                o00ooooo0o.this.O00000o.O000000o(str7, str8, str9, str2, tokenBean.getToken(), str10, z, new Business.ResultListener<User>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, User user, String str) {
                        iRegisterCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                        o00ooooo0o.this.O000000o(user);
                        IRegisterCallback iRegisterCallback = iRegisterCallback2;
                        if (iRegisterCallback != null) {
                            iRegisterCallback.onSuccess(user);
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, String str3, boolean z, ILoginCallback iLoginCallback) {
        Result O000000o = O000000o(str2);
        if (O000000o.isSuccess()) {
            Result O00000Oo2 = O00000Oo(str3);
            if (O00000Oo2.isSuccess()) {
                final ILoginCallback iLoginCallback2 = iLoginCallback;
                final String str4 = str3;
                final String str5 = str;
                final String str6 = str2;
                final boolean z2 = z;
                this.O00000o.O00000o(str, str2, new Business.ResultListener<TokenBean>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                        ILoginCallback iLoginCallback = iLoginCallback2;
                        if (iLoginCallback != null) {
                            iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                        boolean z;
                        String str2;
                        String md5AsBase64 = MD5Util.md5AsBase64(str4);
                        try {
                            RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                            str2 = RSAUtil.encrypt(md5AsBase64);
                            z = true;
                        } catch (Exception unused) {
                            str2 = md5AsBase64;
                            z = false;
                        }
                        o00ooooo0o.this.O00000o.O000000o(str5, str6, str2, tokenBean.getToken(), z, z2, (Business.ResultListener<User>) new Business.ResultListener<User>() {
                            /* renamed from: O000000o */
                            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                                ILoginCallback iLoginCallback = iLoginCallback2;
                                if (iLoginCallback != null) {
                                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                                }
                            }

                            /* renamed from: O00000Oo */
                            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                                o00ooooo0o.this.O000000o(user);
                                ILoginCallback iLoginCallback = iLoginCallback2;
                                if (iLoginCallback != null) {
                                    iLoginCallback.onSuccess(user);
                                }
                            }
                        });
                    }
                });
            } else if (iLoginCallback != null) {
                iLoginCallback.onError(O00000Oo2.getErrorCode(), O00000Oo2.getError());
            }
        } else if (iLoginCallback != null) {
            iLoginCallback.onError(O000000o.getErrorCode(), O000000o.getError());
        }
    }

    public void O000000o(String str, String str2, String str3, boolean z, IUidLoginCallback iUidLoginCallback) {
        Result O000000o = O000000o(str2);
        if (O000000o.isSuccess()) {
            Result O00000Oo2 = O00000Oo(str3);
            if (O00000Oo2.isSuccess()) {
                final IUidLoginCallback iUidLoginCallback2 = iUidLoginCallback;
                final String str4 = str3;
                final String str5 = str;
                final String str6 = str2;
                final boolean z2 = z;
                this.O00000o.O00000o(str, str2, new Business.ResultListener<TokenBean>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                        IUidLoginCallback iUidLoginCallback = iUidLoginCallback2;
                        if (iUidLoginCallback != null) {
                            iUidLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                        boolean z;
                        String str2;
                        String md5AsBase64 = MD5Util.md5AsBase64(str4);
                        try {
                            RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                            str2 = RSAUtil.encrypt(md5AsBase64);
                            z = true;
                        } catch (Exception unused) {
                            str2 = md5AsBase64;
                            z = false;
                        }
                        o00ooooo0o.this.O00000o.O00000Oo(str5, str6, str2, tokenBean.getToken(), z, z2, new Business.ResultListener<UserRespBean>() {
                            /* renamed from: O000000o */
                            public void onFailure(BusinessResponse businessResponse, UserRespBean userRespBean, String str) {
                                IUidLoginCallback iUidLoginCallback = iUidLoginCallback2;
                                if (iUidLoginCallback != null) {
                                    iUidLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                                }
                            }

                            /* renamed from: O00000Oo */
                            public void onSuccess(BusinessResponse businessResponse, UserRespBean userRespBean, String str) {
                                o00ooooo0o.this.O000000o((User) userRespBean);
                                IUidLoginCallback iUidLoginCallback = iUidLoginCallback2;
                                if (iUidLoginCallback != null) {
                                    iUidLoginCallback.onSuccess(userRespBean, userRespBean.getGid());
                                }
                            }
                        });
                    }
                });
            } else if (iUidLoginCallback != null) {
                iUidLoginCallback.onError(O00000Oo2.getErrorCode(), O00000Oo2.getError());
            }
        } else if (iUidLoginCallback != null) {
            iUidLoginCallback.onError(O000000o.getErrorCode(), O000000o.getError());
        }
    }

    public void O00000Oo(final IResultCallback iResultCallback) {
        this.O00000o.O00000o(new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                o00ooo00o0.O000000o().removeUser();
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (o0o00o00o0 != null) {
                    o0o00o00o0.O00000o0();
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000Oo(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        if (O000000o(str2, str3, iLoginCallback)) {
            final ILoginCallback iLoginCallback2 = iLoginCallback;
            final String str4 = str3;
            final String str5 = str;
            final String str6 = str2;
            this.O00000o.O00000Oo(str, str2, new Business.ResultListener<TokenBean>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                    ILoginCallback iLoginCallback = iLoginCallback2;
                    if (iLoginCallback != null) {
                        iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                    boolean z;
                    String str2;
                    String md5AsBase64 = MD5Util.md5AsBase64(str4);
                    try {
                        RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                        str2 = RSAUtil.encrypt(md5AsBase64);
                        z = true;
                    } catch (Exception unused) {
                        str2 = md5AsBase64;
                        z = false;
                    }
                    o00ooooo0o.this.O00000o.O000000o(str5, str6, str2, tokenBean.getToken(), z, (Business.ResultListener<User>) new Business.ResultListener<User>() {
                        /* renamed from: O000000o */
                        public void onFailure(BusinessResponse businessResponse, User user, String str) {
                            ILoginCallback iLoginCallback = iLoginCallback2;
                            if (iLoginCallback != null) {
                                iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                            }
                        }

                        /* renamed from: O00000Oo */
                        public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                            o00ooooo0o.this.O000000o(user);
                            ILoginCallback iLoginCallback = iLoginCallback2;
                            if (iLoginCallback != null) {
                                iLoginCallback.onSuccess(user);
                            }
                        }
                    });
                }
            });
        }
    }

    public void O00000Oo(String str, String str2, String str3, IRegisterCallback iRegisterCallback) {
        final IRegisterCallback iRegisterCallback2 = iRegisterCallback;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        this.O00000o.O00000o(str, str2, new Business.ResultListener<TokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                IRegisterCallback iRegisterCallback = iRegisterCallback2;
                if (iRegisterCallback != null) {
                    iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                boolean z;
                String str2;
                String md5AsBase64 = MD5Util.md5AsBase64(str4);
                try {
                    RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                    str2 = RSAUtil.encrypt(md5AsBase64);
                    z = true;
                } catch (Exception unused) {
                    str2 = md5AsBase64;
                    z = false;
                }
                o00ooooo0o.this.O00000o.O00000o(str5, str6, str2, tokenBean.getToken(), z, new Business.ResultListener<User>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, User user, String str) {
                        IRegisterCallback iRegisterCallback = iRegisterCallback2;
                        if (iRegisterCallback != null) {
                            iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                        o00ooooo0o.this.O000000o(user);
                        IRegisterCallback iRegisterCallback = iRegisterCallback2;
                        if (iRegisterCallback != null) {
                            iRegisterCallback.onSuccess(user);
                        }
                    }
                });
            }
        });
    }

    public void O00000Oo(String str, String str2, String str3, String str4, final IRegisterCallback iRegisterCallback) {
        this.O00000o.O00000Oo(str, str2, str3, str4, new Business.ResultListener<User>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                IRegisterCallback iRegisterCallback = iRegisterCallback;
                if (iRegisterCallback != null) {
                    iRegisterCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                o00ooooo0o.this.O000000o(user);
                IRegisterCallback iRegisterCallback = iRegisterCallback;
                if (iRegisterCallback != null) {
                    iRegisterCallback.onSuccess(user);
                }
            }
        });
    }

    public void O00000Oo(String str, String str2, String str3, String str4, final IResetPasswordCallback iResetPasswordCallback) {
        this.O00000o.O00000o(str, str2, str3, MD5Util.md5AsBase64(str4), new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResetPasswordCallback iResetPasswordCallback = iResetPasswordCallback;
                if (iResetPasswordCallback != null) {
                    iResetPasswordCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (iResetPasswordCallback == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    iResetPasswordCallback.onSuccess();
                } else {
                    iResetPasswordCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O00000o0(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        Result O000000o = O000000o(str2);
        if (O000000o.isSuccess()) {
            Result O00000Oo2 = O00000Oo(str3);
            if (O00000Oo2.isSuccess()) {
                final ILoginCallback iLoginCallback2 = iLoginCallback;
                final String str4 = str3;
                final String str5 = str;
                final String str6 = str2;
                this.O00000o.O00000o(str, str2, new Business.ResultListener<TokenBean>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                        ILoginCallback iLoginCallback = iLoginCallback2;
                        if (iLoginCallback != null) {
                            iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, TokenBean tokenBean, String str) {
                        boolean z;
                        String str2;
                        String md5AsBase64 = MD5Util.md5AsBase64(str4);
                        try {
                            RSAUtil.generateRSAPublicKey(tokenBean.getPublicKey() + "\n" + tokenBean.getExponent());
                            str2 = RSAUtil.encrypt(md5AsBase64);
                            z = true;
                        } catch (Exception unused) {
                            str2 = md5AsBase64;
                            z = false;
                        }
                        o00ooooo0o.this.O00000o.O00000oO(str5, str6, str2, tokenBean.getToken(), z, new Business.ResultListener<User>() {
                            /* renamed from: O000000o */
                            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                                ILoginCallback iLoginCallback = iLoginCallback2;
                                if (iLoginCallback != null) {
                                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                                }
                            }

                            /* renamed from: O00000Oo */
                            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                                o00ooooo0o.this.O000000o(user);
                                ILoginCallback iLoginCallback = iLoginCallback2;
                                if (iLoginCallback != null) {
                                    iLoginCallback.onSuccess(user);
                                }
                            }
                        });
                    }
                });
            } else if (iLoginCallback != null) {
                iLoginCallback.onError(O00000Oo2.getErrorCode(), O00000Oo2.getError());
            }
        } else if (iLoginCallback != null) {
            iLoginCallback.onError(O000000o.getErrorCode(), O000000o.getError());
        }
    }

    public void onDestroy() {
        this.O00000o.onDestroy();
    }
}
