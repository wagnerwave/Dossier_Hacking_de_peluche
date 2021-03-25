package com.tuya.smart.common;

import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.android.user.api.ICheckAccountCallback;
import com.tuya.smart.android.user.api.ICommonConfigCallback;
import com.tuya.smart.android.user.api.IGetRegionCallback;
import com.tuya.smart.android.user.api.ILoginCallback;
import com.tuya.smart.android.user.api.ILogoutCallback;
import com.tuya.smart.android.user.api.IQurryDomainCallback;
import com.tuya.smart.android.user.api.IReNickNameCallback;
import com.tuya.smart.android.user.api.IRegisterCallback;
import com.tuya.smart.android.user.api.IResetPasswordCallback;
import com.tuya.smart.android.user.api.IUidLoginCallback;
import com.tuya.smart.android.user.api.IUserStorage;
import com.tuya.smart.android.user.api.IValidateCallback;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaUser;
import com.tuya.smart.sdk.enums.TempUnitEnum;
import java.io.File;

public class o00ooo00o0 implements ITuyaUser {
    public static o00ooo00o0 O000000o;
    public o00oooo0oo O00000Oo = new o00ooooooo(TuyaSmartSdk.getApplication(), new o0o00000oo(TuyaSmartNetWork.mSdk));
    public o00ooooo0o O00000o = new o00ooooo0o(TuyaSmartSdk.getApplication(), (SafeHandler) null);
    public o00ooooo00 O00000o0 = new o00ooooo00(TuyaSmartSdk.getApplication(), (SafeHandler) null);
    public o00ooo0ooo O00000oO = new o00ooo0ooo(TuyaSmartSdk.getApplication(), (SafeHandler) null);
    public o00oooooo0 O00000oo = new o00oooooo0(TuyaSmartSdk.getApplication(), (SafeHandler) null);

    public static synchronized o00ooo00o0 O000000o() {
        o00ooo00o0 o00ooo00o0;
        synchronized (o00ooo00o0.class) {
            if (O000000o == null) {
                O000000o = new o00ooo00o0();
            }
            o00ooo00o0 = O000000o;
        }
        return o00ooo00o0;
    }

    public void O000000o(IUserStorage iUserStorage) {
        this.O00000Oo.O000000o(iUserStorage);
    }

    public void O000000o(String str, String str2, String str3, IResetPasswordCallback iResetPasswordCallback) {
        this.O00000o.O000000o("86", str, str2, str3, iResetPasswordCallback);
    }

    public String O00000Oo() {
        return this.O00000Oo.O00000o();
    }

    public void O00000Oo(String str, String str2, String str3, IResetPasswordCallback iResetPasswordCallback) {
        this.O00000o.O000000o(str, str2, str3, iResetPasswordCallback);
    }

    public void bindMobile(String str, String str2, String str3, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, str2, str3, iResultCallback);
    }

    public void cancelAccount(IResultCallback iResultCallback) {
        this.O00000o.O00000Oo(iResultCallback);
    }

    public void checkCodeWithUserName(String str, String str2, String str3, String str4, int i, IResultCallback iResultCallback) {
        this.O00000o.O000000o(str, str2, str3, str4, i, iResultCallback);
    }

    public void checkEmailPassword(String str, ICheckAccountCallback iCheckAccountCallback) {
        this.O00000o.O000000o(str, iCheckAccountCallback);
    }

    public void checkPhoneCode(String str, String str2, String str3, ICheckAccountCallback iCheckAccountCallback) {
        this.O00000o0.O000000o(str, str2, str3, iCheckAccountCallback);
    }

    public boolean checkVersionUpgrade() {
        User user = getUser();
        return user != null && user.getDataVersion() == 0;
    }

    public void getCommonServices(ICommonConfigCallback iCommonConfigCallback) {
        this.O00000oo.O000000o(iCommonConfigCallback);
    }

    public void getEmailValidateCode(String str, String str2, IValidateCallback iValidateCallback) {
        this.O00000o.O000000o(str, str2, iValidateCallback);
    }

    public void getRegionListWithCountryCode(String str, IGetRegionCallback iGetRegionCallback) {
        this.O00000oo.O000000o(str, iGetRegionCallback);
    }

    public void getRegisterEmailValidateCode(String str, String str2, IResultCallback iResultCallback) {
        this.O00000o0.O00000Oo(str, str2, iResultCallback);
    }

    public User getUser() {
        return this.O00000Oo.O000000o();
    }

    public void getValidateCode(String str, String str2, IValidateCallback iValidateCallback) {
        this.O00000o0.O000000o(str, str2, iValidateCallback);
    }

    public boolean isLogin() {
        return this.O00000Oo.O00000o0();
    }

    public void loginByFacebook(String str, String str2, ILoginCallback iLoginCallback) {
        this.O00000o0.O00000Oo(str, str2, iLoginCallback);
    }

    public void loginByQQ(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        this.O00000o0.O00000o0(str, str2, str3, iLoginCallback);
    }

    public void loginByTwitter(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        this.O00000o0.O00000Oo(str, str2, str3, iLoginCallback);
    }

    public void loginByWechat(String str, String str2, ILoginCallback iLoginCallback) {
        this.O00000o0.O000000o(str, str2, iLoginCallback);
    }

    public void loginOrRegisterWithUid(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        this.O00000o.O000000o(str, str2, str3, false, iLoginCallback);
    }

    public void loginOrRegisterWithUid(String str, String str2, String str3, boolean z, IUidLoginCallback iUidLoginCallback) {
        this.O00000o.O000000o(str, str2, str3, z, iUidLoginCallback);
    }

    public void loginWithEmail(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        this.O00000o.O000000o(str, str2, str3, iLoginCallback);
    }

    public void loginWithPhone(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        this.O00000o0.O000000o(str, str2, str3, iLoginCallback);
    }

    public void loginWithPhonePassword(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        this.O00000o.O00000Oo(str, str2, str3, iLoginCallback);
    }

    public void loginWithUid(String str, String str2, String str3, ILoginCallback iLoginCallback) {
        this.O00000o.O00000o0(str, str2, str3, iLoginCallback);
    }

    public void logout(ILogoutCallback iLogoutCallback) {
        this.O00000o0.O000000o(iLogoutCallback);
    }

    public void onDestroy() {
        O000000o = null;
        this.O00000o.onDestroy();
        this.O00000o0.onDestroy();
        this.O00000oo.onDestroy();
    }

    public void queryAllBizDomains(IQurryDomainCallback iQurryDomainCallback) {
        this.O00000oo.O000000o(iQurryDomainCallback);
    }

    public void queryDomainByBizCodeAndKey(String str, String str2, IQurryDomainCallback iQurryDomainCallback) {
        this.O00000oo.O000000o(str, str2, iQurryDomainCallback);
    }

    public String queryDomainByBizCodeAndKeyFromCache(String str, String str2) {
        return this.O00000oo.O000000o(str, str2);
    }

    public void reRickName(String str, IReNickNameCallback iReNickNameCallback) {
        this.O00000o0.O000000o(str, iReNickNameCallback);
    }

    public void registerAccountWithEmail(String str, String str2, String str3, IRegisterCallback iRegisterCallback) {
        this.O00000o.O000000o(str, str2, str3, iRegisterCallback);
    }

    public void registerAccountWithEmail(String str, String str2, String str3, String str4, IRegisterCallback iRegisterCallback) {
        this.O00000o.O000000o(str, str2, str3, str4, iRegisterCallback);
    }

    public void registerAccountWithPhone(String str, String str2, String str3, String str4, IRegisterCallback iRegisterCallback) {
        this.O00000o.O00000Oo(str, str2, str3, str4, iRegisterCallback);
    }

    public void registerAccountWithUid(String str, String str2, String str3, IRegisterCallback iRegisterCallback) {
        this.O00000o.O00000Oo(str, str2, str3, iRegisterCallback);
    }

    public void registerWithUserName(String str, String str2, String str3, String str4, String str5, IRegisterCallback iRegisterCallback) {
        this.O00000o.O000000o(str, str2, str3, str4, str5, iRegisterCallback);
    }

    public boolean removeUser() {
        return this.O00000Oo.O00000Oo();
    }

    public void resetEmailPassword(String str, String str2, String str3, String str4, IResetPasswordCallback iResetPasswordCallback) {
        this.O00000o.O000000o(str, str2, str3, str4, iResetPasswordCallback);
    }

    public void resetPhonePassword(String str, String str2, String str3, String str4, IResetPasswordCallback iResetPasswordCallback) {
        this.O00000o.O00000Oo(str, str2, str3, str4, iResetPasswordCallback);
    }

    public boolean saveUser(User user) {
        return this.O00000Oo.O000000o(user);
    }

    public void sendBindVerifyCode(String str, String str2, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, str2, iResultCallback);
    }

    public void sendVerifyCodeWithUserName(String str, String str2, String str3, int i, IResultCallback iResultCallback) {
        this.O00000o.O000000o(str, str2, str3, i, iResultCallback);
    }

    public void setTempUnit(TempUnitEnum tempUnitEnum, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(tempUnitEnum.getType(), iResultCallback);
    }

    public void switchUserRegion(String str, ILoginCallback iLoginCallback) {
        this.O00000oo.O000000o(str, iLoginCallback);
    }

    public void updateTimeZone(String str, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, iResultCallback);
    }

    public void upgradeVersion(IResultCallback iResultCallback) {
        this.O00000o.O000000o(iResultCallback);
    }

    public void uploadUserAvatar(File file, IBooleanCallback iBooleanCallback) {
        User user = getUser();
        if (user != null) {
            this.O00000oO.O000000o(user.getUid() + System.currentTimeMillis() + ((int) (Math.random() * 100.0d)) + ".png", file, iBooleanCallback);
        } else if (iBooleanCallback != null) {
            iBooleanCallback.onError("2309", "user==null");
        }
    }
}
