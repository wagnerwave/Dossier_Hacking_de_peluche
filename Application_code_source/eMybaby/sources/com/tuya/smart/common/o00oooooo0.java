package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.sdk.user.bean.BizCodeDomainBean;
import com.tuya.smart.android.base.utils.PreferencesUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.user.api.ICommonConfigCallback;
import com.tuya.smart.android.user.api.IGetRegionCallback;
import com.tuya.smart.android.user.api.ILoginCallback;
import com.tuya.smart.android.user.api.IQurryDomainCallback;
import com.tuya.smart.android.user.bean.CommonConfigBean;
import com.tuya.smart.android.user.bean.Region;
import com.tuya.smart.android.user.bean.User;
import java.util.List;
import java.util.Map;

public class o00oooooo0 extends o00oooo000 {
    public static final String O00000Oo = "bizcode_domain_list";

    public o00oooooo0(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
        this.O000000o = new o00ooo0o00();
    }

    /* access modifiers changed from: private */
    public String O000000o(String str, String str2, String str3, IQurryDomainCallback iQurryDomainCallback) {
        String str4;
        String str5;
        Map map = (Map) JSON.parseObject(str3, new TypeReference<Map<String, List<BizCodeDomainBean>>>() {
        }, new Feature[0]);
        if (map == null || map.size() <= 0) {
            L.e("GuidePresenter", "NO_DOMAINS ");
            if (iQurryDomainCallback == null) {
                return "";
            }
            iQurryDomainCallback.onError("NO_DOMAINS", "NO_DOMAINS");
            return "";
        }
        List<BizCodeDomainBean> list = (List) map.get(str);
        if (list == null || list.size() <= 0) {
            str4 = "NO_THIS_BIZCODE_DOMAIN";
            L.e("GuidePresenter", str4);
            if (iQurryDomainCallback == null) {
                return "";
            }
            str5 = a.k(str, str4);
        } else {
            for (BizCodeDomainBean bizCodeDomainBean : list) {
                if (bizCodeDomainBean.getKey().equals(str2)) {
                    String uri = bizCodeDomainBean.getUri();
                    if (!uri.startsWith("/")) {
                        uri = a.k("/", uri);
                    }
                    StringBuilder n = a.n(bizCodeDomainBean.getAppPort().equals("80") ? "http://" : "https://");
                    n.append(bizCodeDomainBean.getAppDomain());
                    n.append(":");
                    n.append(bizCodeDomainBean.getAppPort());
                    n.append(uri);
                    String sb = n.toString();
                    if (iQurryDomainCallback != null) {
                        iQurryDomainCallback.onSuccess(sb);
                    }
                    return sb;
                }
            }
            L.e("GuidePresenter", "no key domains ");
            if (iQurryDomainCallback == null) {
                return "";
            }
            str5 = a.k(str2, " NO_THIS_KEY_DOMAIN");
            str4 = "NO_THIS_KEY_DOMAIN";
        }
        iQurryDomainCallback.onError(str4, str5);
        return "";
    }

    public String O000000o(String str, String str2) {
        String string = PreferencesUtil.getString(O00000Oo);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        L.i("GET DOMAIN", "from cache");
        return O000000o(str, str2, string, (IQurryDomainCallback) null);
    }

    public void O000000o(final ICommonConfigCallback iCommonConfigCallback) {
        this.O000000o.O00000oO(new Business.ResultListener<CommonConfigBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, CommonConfigBean commonConfigBean, String str) {
                iCommonConfigCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, CommonConfigBean commonConfigBean, String str) {
                iCommonConfigCallback.onSuccess(commonConfigBean);
            }
        });
    }

    public void O000000o(final IQurryDomainCallback iQurryDomainCallback) {
        this.O000000o.O00000oO("ALL", new Business.ResultListener<JSONObject>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iQurryDomainCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                String jSONString = jSONObject.toJSONString();
                if (!TextUtils.isEmpty(jSONString)) {
                    PreferencesUtil.set(o00oooooo0.O00000Oo, jSONString);
                }
                iQurryDomainCallback.onSuccess(jSONString);
            }
        });
    }

    public void O000000o(String str, final IGetRegionCallback iGetRegionCallback) {
        this.O000000o.O00000o0(str, new Business.ResultListener<Region>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Region region, String str) {
                IGetRegionCallback iGetRegionCallback = iGetRegionCallback;
                if (iGetRegionCallback != null) {
                    iGetRegionCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Region region, String str) {
                IGetRegionCallback iGetRegionCallback = iGetRegionCallback;
                if (iGetRegionCallback != null) {
                    iGetRegionCallback.onSuccess(region);
                }
            }
        });
    }

    public void O000000o(String str, final ILoginCallback iLoginCallback) {
        this.O000000o.O00000o(str, new Business.ResultListener<User>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, User user, String str) {
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, User user, String str) {
                ILoginCallback iLoginCallback = iLoginCallback;
                if (iLoginCallback != null) {
                    iLoginCallback.onSuccess(user);
                }
            }
        });
    }

    public void O000000o(final String str, final String str2, final IQurryDomainCallback iQurryDomainCallback) {
        String string = PreferencesUtil.getString(O00000Oo);
        if (!TextUtils.isEmpty(string)) {
            L.i("GET DOMAIN", "from cache");
            O000000o(str, str2, string, iQurryDomainCallback);
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
            L.i("GET DOMAIN", "no cache");
            this.O000000o.O00000oO("ALL", new Business.ResultListener<JSONObject>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                    iQurryDomainCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                    String jSONString = jSONObject.toJSONString();
                    if (!TextUtils.isEmpty(jSONString)) {
                        PreferencesUtil.set(o00oooooo0.O00000Oo, jSONString);
                    }
                    String unused = o00oooooo0.this.O000000o(str, str2, jSONString, iQurryDomainCallback);
                }
            });
        }
    }

    public void onDestroy() {
        o00ooo0o00 o00ooo0o00 = this.O000000o;
        if (o00ooo0o00 != null) {
            o00ooo0o00.cancelAll();
        }
    }
}
