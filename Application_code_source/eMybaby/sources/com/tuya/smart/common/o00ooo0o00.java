package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.user.bean.StorageSign;
import com.tuya.sdk.user.bean.TokenBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.common.utils.MD5Util;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.bean.ResultBean;
import com.tuya.smart.android.user.bean.CommonConfigBean;
import com.tuya.smart.android.user.bean.Region;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.interior.bean.UserRespBean;

public class o00ooo0o00 extends Business {
    public static final String O000000o = "tuya.m.user.qq.login";
    public static final String O00000Oo = "tuya.m.user.wx.login";
    public static final String O00000o = "tuya.m.user.instagram.login";
    public static final String O00000o0 = "tuya.m.user.facebook.login";
    public static final String O00000oO = "airtake.user.login.weibo";
    public static final String O00000oo = "tuya.m.user.twitter.login";
    public static final String O0000O0o = "tuya.m.app.domain.query";
    public static final String O0000OOo = "tuya.m.user.region.list";
    public static final String O0000Oo = "tuya.m.user.username.code.get";
    public static final String O0000Oo0 = "tuya.m.user.area.select";
    public static final String O0000OoO = "tuya.m.user.username.code.verify";
    public static final String O0000Ooo = "tuya.m.user.username.token.get";
    public static final String O0000o = "tuya.m.user.email.code.send";
    public static final String O0000o0 = "tuya.m.user.update";
    public static final String O0000o00 = "tuya.m.user.username.register";
    public static final String O0000o0O = "tuya.m.storage.upload.sign";
    public static final String O0000o0o = "tuya.m.user.update";
    public static final String O0000oO = "tuya.m.user.mobile.passwd.reset";
    public static final String O0000oO0 = "tuya.m.user.mobile.sendcode";
    public static final String O0000oOO = "tuya.m.user.email.password.reset";
    public static final String O0000oOo = "tuya.m.user.uid.password.reset";
    public static final String O0000oo = "tuya.m.user.email.register";
    public static final String O0000oo0 = "tuya.m.user.uid.register";
    public static final String O0000ooO = "tuya.m.user.mobile.register";
    public static final String O0000ooo = "tuya.m.user.code.login";
    public static final String O000O00o = "tuya.m.user.uid.password.login.reg";
    public static final String O000O0OO = "tuya.m.user.mobile.passwd.login";
    public static final String O000O0Oo = "tuya.m.user.email.password.login";
    public static final String O000O0o = "tuya.m.user.mobile.token.get";
    public static final String O000O0o0 = "tuya.m.user.email.token.create";
    public static final String O000O0oO = "tuya.m.user.uid.token.create";
    public static final String O000O0oo = "tuya.m.user.password.check.token.create";
    public static final String O000OO = "tuya.m.user.bind.mobile.sendcode";
    public static final String O000OO00 = "tuya.m.user.password.check";
    public static final String O000OO0o = "s.m.user.mobile.check.code";
    public static final String O000OOOo = "s.m.user.bind.mobile";
    public static final String O000OOo = "email";
    public static final String O000OOo0 = "countryCode";
    public static final String O000OOoO = "mobile";
    public static final String O000OOoo = "codeType";
    public static final String O000Oo0 = "server";
    public static final String O000Oo00 = "code";
    public static final String O000Oo0O = "username";
    public static final String O000Oo0o = "tuya.m.app.build.common.get";
    public static final String O00oOoOo = "tuya.m.user.loginout";
    public static final String O00oOooO = "tuya.m.user.mobile.code.login";
    public static final String O00oOooo = "tuya.m.user.uid.password.login";
    public final String O000OoO0 = "tuya.m.user.timezone.update";

    public void O000000o(int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.user.unit.temp.update", "2.0");
        apiParams.putPostData("tempUnit", Integer.valueOf(i));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<TokenBean> resultListener) {
        asyncRequest(a.E(O000O0oo, "1.0", true), TokenBean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<Boolean> resultListener) {
        asyncRequest(a.F("tuya.m.user.update", "1.0", true, "nickname", str), Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oO0, "1.0", str);
        apiParams.setSessionRequire(false);
        apiParams.setShouldCache(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, int i, Business.ResultListener<String> resultListener) {
        ApiParams apiParams = new ApiParams(O0000Oo, GwBroadcastMonitorService.mVersion, str3);
        apiParams.setSessionRequire(false);
        apiParams.putPostData(O000OOo0, str3);
        apiParams.putPostData(O000Oo0O, str);
        apiParams.putPostData(O000OOoo, Integer.valueOf(i));
        asyncRequest(apiParams, String.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O000OO0o, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        apiParams.putPostData("code", str3);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000OoO, "1.0", str3);
        apiParams.putPostData(O000OOo0, str3);
        apiParams.putPostData(O000Oo0O, str);
        apiParams.putPostData("code", str4);
        apiParams.putPostData(O000OOoo, Integer.valueOf(i));
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, Business.ResultListener<User> resultListener) {
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, boolean z, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O0000o00, GwBroadcastMonitorService.mVersion, str2);
        apiParams.putPostData("authCode", str);
        apiParams.putPostData(O000OOo0, str2);
        apiParams.putPostData(O000Oo0O, str3);
        apiParams.putPostData("passwd", str4);
        apiParams.putPostData("token", str5);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, boolean z, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oo, "2.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("email", str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.putPostData("authCode", str5);
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, boolean z, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O000O0OO, GwBroadcastMonitorService.mVersion, str);
        apiParams.setSessionRequire(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, boolean z, boolean z2, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O000O00o, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("uid", str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.putPostData("createGroup", Boolean.valueOf(z2));
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O000000o(String str, String str2, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O000OO00, "1.0", "token", str2);
        D.putPostData("passwd", str);
        D.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, boolean z, String str3, Business.ResultListener<TokenBean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000Ooo, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000Oo0O, str2);
        apiParams.putPostData("isUid", Boolean.valueOf(z));
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, TokenBean.class, resultListener);
    }

    public void O00000Oo(Business.ResultListener<ResultBean> resultListener) {
        asyncRequest(a.E(O00oOoOo, "1.0", true), ResultBean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.user.timezone.update", "1.0");
        apiParams.putPostData("timezoneId", str);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, Business.ResultListener<TokenBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000O0o, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, TokenBean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000o, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.setSessionRequire(false);
        apiParams.putPostData("email", str2);
        apiParams.putPostData(NotificationCompatJellybean.KEY_TITLE, str3);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, String str3, String str4, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O0000ooO, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        apiParams.putPostData("passwd", MD5Util.md5AsBase64(str3));
        apiParams.putPostData("code", str4);
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000Oo(String str, String str2, String str3, String str4, boolean z, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O000O0Oo, GwBroadcastMonitorService.mVersion, str);
        apiParams.setSessionRequire(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("email", str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000Oo(String str, String str2, String str3, String str4, boolean z, boolean z2, Business.ResultListener<UserRespBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000O00o, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("uid", str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.putPostData("createGroup", Boolean.valueOf(z2));
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, UserRespBean.class, resultListener);
    }

    public void O00000o(Business.ResultListener<Boolean> resultListener) {
        asyncRequest(new ApiParams("tuya.m.user.apply.logout", "1.0"), Boolean.class, resultListener);
    }

    public void O00000o(String str, Business.ResultListener<User> resultListener) {
        ApiParams E = a.E(O0000Oo0, "1.0", true);
        if (!TextUtils.isEmpty(str)) {
            E.putPostData(O000Oo0, str);
        }
        asyncRequest(E, User.class, resultListener);
    }

    public void O00000o(String str, String str2, Business.ResultListener<TokenBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000O0oO, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("uid", str2);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, TokenBean.class, resultListener);
    }

    public void O00000o(String str, String str2, String str3, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O00oOooO, GwBroadcastMonitorService.mVersion, str);
        apiParams.setSessionRequire(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        apiParams.putPostData("code", str3);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000o(String str, String str2, String str3, String str4, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oO, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        apiParams.putPostData("code", str3);
        apiParams.putPostData("newPasswd", str4);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o(String str, String str2, String str3, String str4, boolean z, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oo0, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("uid", str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.putPostData("token", str4);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000o0(Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.user.data.upgrade", "1.0");
        apiParams.putPostData("dataVersion", 1);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o0(String str, Business.ResultListener<Region> resultListener) {
        ApiParams apiParams = new ApiParams(O0000OOo, GwBroadcastMonitorService.mVersion, str);
        apiParams.setSessionRequire(false);
        apiParams.putPostData(O000OOo0, str);
        asyncRequest(apiParams, Region.class, resultListener);
    }

    public void O00000o0(String str, String str2, Business.ResultListener<TokenBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000O0o0, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("email", str2);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, TokenBean.class, resultListener);
    }

    public void O00000o0(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        O00000Oo(str, str2, str3, resultListener);
    }

    public void O00000o0(String str, String str2, String str3, String str4, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oOO, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("email", str2);
        apiParams.putPostData("emailCode", str3);
        apiParams.putPostData("newPasswd", str4);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o0(String str, String str2, String str3, String str4, boolean z, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oo, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("email", str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000oO(Business.ResultListener<CommonConfigBean> resultListener) {
        asyncRequest(a.E(O000Oo0o, "2.0", false), CommonConfigBean.class, resultListener);
    }

    public void O00000oO(String str, Business.ResultListener<JSONObject> resultListener) {
        ApiParams E = a.E(O0000O0o, "2.0", true);
        if (TextUtils.isEmpty(str)) {
            str = "ALL";
        }
        E.putPostData("bizCode", str);
        asyncRequest(E, JSONObject.class, resultListener);
    }

    public void O00000oO(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.user.bind.mobile.sendcode", "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setShouldCache(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData(O000OOoO, str2);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000oO(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("s.m.user.bind.mobile", "1.0", O000OOo0, str);
        D.putPostData(O000OOoO, str2);
        D.putPostData("code", str3);
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O00000oO(String str, String str2, String str3, String str4, Business.ResultListener<StorageSign> resultListener) {
        ApiParams F = a.F("tuya.m.storage.upload.sign", "2.0", true, "uploadFileName", str);
        F.putPostData("type", str2);
        F.putPostData("method", str3);
        F.putPostData("biz", str4);
        asyncRequest(F, StorageSign.class, resultListener);
    }

    public void O00000oO(String str, String str2, String str3, String str4, boolean z, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O00oOooo, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("uid", str2);
        apiParams.putPostData("passwd", str3);
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000oo(String str, String str2, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "1.0", str);
        apiParams.setSessionRequire(false);
        apiParams.setShouldCache(false);
        apiParams.putPostData("code", str2);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("options", "{\"group\": 1}");
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000oo(String str, String str2, String str3, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "1.0", str);
        apiParams.setSessionRequire(false);
        apiParams.setShouldCache(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("userId", str2);
        apiParams.putPostData("accessToken", str3);
        apiParams.putPostData("options", "{\"group\": 1}");
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O00000oo(String str, String str2, String str3, String str4, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oOo, "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("uid", str2);
        apiParams.putPostData("newPasswd", str3);
        apiParams.putPostData("token", str4);
        apiParams.putPostData("ifencrypt", Integer.valueOf(z ? 1 : 0));
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O0000O0o(String str, String str2, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oO, "1.0");
        apiParams.setSessionRequire(false);
        apiParams.setShouldCache(false);
        apiParams.putPostData("userId", str);
        apiParams.putPostData("accessToken", str2);
        apiParams.putPostData("options", "{\"group\": 1}");
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O0000O0o(String str, String str2, String str3, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oo, "1.0", str);
        apiParams.setSessionRequire(false);
        apiParams.setShouldCache(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("accessToken", str2);
        apiParams.putPostData("accessTokenSecret", str3);
        apiParams.putPostData("options", "{\"group\": 1}");
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O0000OOo(String str, String str2, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o0, "1.0", str);
        apiParams.setSessionRequire(false);
        apiParams.setShouldCache(false);
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("accessToken", str2);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O0000Oo(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.user.email.auth.code", "1.0", str);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("email", str2);
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O0000Oo0(String str, String str2, Business.ResultListener<User> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o, "1.0", str);
        apiParams.setSessionRequire(false);
        apiParams.setShouldCache(false);
        apiParams.putPostData(O000OOo0, str);
        apiParams.putPostData("options", "{\"group\": 1}");
        apiParams.putPostData("accessToken", str2);
        asyncRequest(apiParams, User.class, resultListener);
    }

    public void O0000OoO(String str, String str2, Business.ResultListener<String> resultListener) {
        ApiParams F = a.F("tuya.m.user.update", "2.0", true, "nickname", str);
        F.putPostData("headImg", str2);
        asyncRequest(F, String.class, resultListener);
    }
}
