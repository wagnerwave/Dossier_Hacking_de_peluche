package com.tuya.smart.sdk.api;

import androidx.annotation.Nullable;
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
import com.tuya.smart.android.user.api.IValidateCallback;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.sdk.enums.TempUnitEnum;
import java.io.File;

public interface ITuyaUser {
    void bindMobile(String str, String str2, String str3, IResultCallback iResultCallback);

    void cancelAccount(IResultCallback iResultCallback);

    void checkCodeWithUserName(String str, String str2, String str3, String str4, int i, IResultCallback iResultCallback);

    void checkEmailPassword(String str, ICheckAccountCallback iCheckAccountCallback);

    void checkPhoneCode(String str, String str2, String str3, ICheckAccountCallback iCheckAccountCallback);

    boolean checkVersionUpgrade();

    void getCommonServices(ICommonConfigCallback iCommonConfigCallback);

    void getEmailValidateCode(String str, String str2, IValidateCallback iValidateCallback);

    void getRegionListWithCountryCode(String str, IGetRegionCallback iGetRegionCallback);

    void getRegisterEmailValidateCode(String str, String str2, IResultCallback iResultCallback);

    @Nullable
    User getUser();

    void getValidateCode(String str, String str2, IValidateCallback iValidateCallback);

    boolean isLogin();

    void loginByFacebook(String str, String str2, ILoginCallback iLoginCallback);

    void loginByQQ(String str, String str2, String str3, ILoginCallback iLoginCallback);

    void loginByTwitter(String str, String str2, String str3, ILoginCallback iLoginCallback);

    void loginByWechat(String str, String str2, ILoginCallback iLoginCallback);

    void loginOrRegisterWithUid(String str, String str2, String str3, ILoginCallback iLoginCallback);

    void loginOrRegisterWithUid(String str, String str2, String str3, boolean z, IUidLoginCallback iUidLoginCallback);

    void loginWithEmail(String str, String str2, String str3, ILoginCallback iLoginCallback);

    void loginWithPhone(String str, String str2, String str3, ILoginCallback iLoginCallback);

    void loginWithPhonePassword(String str, String str2, String str3, ILoginCallback iLoginCallback);

    void loginWithUid(String str, String str2, String str3, ILoginCallback iLoginCallback);

    void logout(ILogoutCallback iLogoutCallback);

    void onDestroy();

    void queryAllBizDomains(IQurryDomainCallback iQurryDomainCallback);

    void queryDomainByBizCodeAndKey(String str, String str2, IQurryDomainCallback iQurryDomainCallback);

    String queryDomainByBizCodeAndKeyFromCache(String str, String str2);

    void reRickName(String str, IReNickNameCallback iReNickNameCallback);

    @Deprecated
    void registerAccountWithEmail(String str, String str2, String str3, IRegisterCallback iRegisterCallback);

    void registerAccountWithEmail(String str, String str2, String str3, String str4, IRegisterCallback iRegisterCallback);

    void registerAccountWithPhone(String str, String str2, String str3, String str4, IRegisterCallback iRegisterCallback);

    void registerAccountWithUid(String str, String str2, String str3, IRegisterCallback iRegisterCallback);

    void registerWithUserName(String str, String str2, String str3, String str4, String str5, IRegisterCallback iRegisterCallback);

    boolean removeUser();

    void resetEmailPassword(String str, String str2, String str3, String str4, IResetPasswordCallback iResetPasswordCallback);

    void resetPhonePassword(String str, String str2, String str3, String str4, IResetPasswordCallback iResetPasswordCallback);

    boolean saveUser(User user);

    void sendBindVerifyCode(String str, String str2, IResultCallback iResultCallback);

    void sendVerifyCodeWithUserName(String str, String str2, String str3, int i, IResultCallback iResultCallback);

    void setTempUnit(TempUnitEnum tempUnitEnum, IResultCallback iResultCallback);

    void switchUserRegion(String str, ILoginCallback iLoginCallback);

    void updateTimeZone(String str, IResultCallback iResultCallback);

    void upgradeVersion(IResultCallback iResultCallback);

    void uploadUserAvatar(File file, IBooleanCallback iBooleanCallback);
}
