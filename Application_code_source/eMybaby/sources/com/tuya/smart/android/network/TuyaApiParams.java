package com.tuya.smart.android.network;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.request.OKHttpBusinessRequest;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.common.oo000o0o0;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TuyaApiParams implements OKHttpBusinessRequest.ApiRequest {
    public static final String ET_VERSION = "0.0.1";
    public static final String KEY_API = "a";
    public static final String KEY_APP_ID = "clientId";
    public static final String KEY_APP_LANG = "lang";
    public static final String KEY_APP_OS = "os";
    public static final String KEY_APP_RN_VERSION = "appRnVersion";
    public static final String KEY_APP_SIGN = "sign";
    public static final String KEY_APP_VERSION = "appVersion";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_DEVICEID = "deviceId";
    public static final String KEY_ET = "et";
    public static final String KEY_GID = "gid";
    public static final String KEY_H5 = "isH5";
    public static final String KEY_H5TOKEN = "h5Token";
    public static final String KEY_IMEI = "imei";
    public static final String KEY_IMSI = "imsi";
    public static final String KEY_LAT = "lat";
    public static final String KEY_LON = "lon";
    public static final String KEY_N4H5 = "n4h5";
    public static final String KEY_OS_SYSTEM = "osSystem";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_POST = "postData";
    public static final String KEY_REQUEST_ID = "requestId";
    public static final String KEY_SDK_VERSION = "sdkVersion";
    public static final String KEY_SESSION = "sid";
    public static final String KEY_SP = "sp";
    public static final String KEY_TIMESTAMP = "time";
    public static final String KEY_TIME_ZONE_ID = "timeZoneId";
    public static final String KEY_TTID = "ttid";
    public static final String KEY_VERSION = "v";
    public static final String TAG = "TuyaApiParams";
    public String apiName;
    public String apiVersion = "*";
    public Object cacheDefaultData;
    public byte[] dataBytes;
    public String ecode;
    public long gid;
    public String h5Token;
    public boolean isH5Request = false;
    public boolean isN4H5Request = false;
    public Business.ResultListener listener = null;
    public boolean locationRequire = true;
    public JSONObject postData;
    public String serverHostUrl;
    public String session;
    public boolean sessionRequire = true;
    public boolean shouldCache = false;
    public boolean spRequest;
    public boolean throwCache = false;
    public ConcurrentHashMap<String, String> urlGETParams = new ConcurrentHashMap<>();

    public TuyaApiParams() {
        initUrlParams((String) null);
    }

    public TuyaApiParams(String str) {
        this.apiName = str;
        initUrlParams((String) null);
    }

    public TuyaApiParams(String str, String str2) {
        this.apiName = str;
        this.apiVersion = str2;
        initUrlParams((String) null);
    }

    public TuyaApiParams(String str, String str2, String str3) {
        this.apiName = str;
        this.apiVersion = str2;
        initUrlParams(str3);
    }

    private boolean isSpRequest() {
        return this.spRequest;
    }

    public String getApiName() {
        return this.apiName;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public byte[] getDataBytes() {
        return this.dataBytes;
    }

    public String getEcode() {
        return this.ecode;
    }

    public long getGid() {
        return this.gid;
    }

    public String getH5Token() {
        return this.h5Token;
    }

    public Business.ResultListener getListener() {
        return this.listener;
    }

    public JSONObject getPostData() {
        return this.postData;
    }

    public String getPostDataString() {
        return hasPostData() ? this.postData.toJSONString() : "";
    }

    public Map<String, String> getRequestBody() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (hasPostData()) {
            concurrentHashMap.put(KEY_POST, getPostDataString());
        }
        return concurrentHashMap;
    }

    public byte[] getRequestBytes() {
        return this.dataBytes;
    }

    public String getRequestKey() {
        Map<String, String> urlParams = getUrlParams();
        urlParams.put(KEY_POST, getPostDataString());
        return oo000o0o0.O00000Oo(urlParams);
    }

    public Map<String, String> getRequestSignBody() {
        return getRequestBody();
    }

    public String getRequestUrl() {
        Map<String, String> urlParams = getUrlParams();
        urlParams.put("time", String.valueOf(TimeStampManager.instance().getCurrentTimeStamp()));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(urlParams);
        concurrentHashMap.putAll(getRequestSignBody());
        urlParams.put("sign", oo000o0o0.O000000o(concurrentHashMap, this));
        return oo000o0o0.O000000o(true, getServerHostUrl(), urlParams);
    }

    public String getServerHostUrl() {
        return this.serverHostUrl;
    }

    public String getSession() {
        return this.session;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> getUrlParams() {
        /*
            r6 = this;
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = r6.urlGETParams
            r0.<init>(r1)
            java.lang.String r1 = r6.getApiName()
            java.lang.String r2 = "a"
            r0.put(r2, r1)
            long r1 = r6.gid
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0021
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gid"
            r0.put(r2, r1)
        L_0x0021:
            java.lang.String r1 = r6.getApiVersion()
            java.lang.String r2 = "v"
            r0.put(r2, r1)
            boolean r1 = r6.isSessionRequire()
            java.lang.String r2 = "sid"
            if (r1 == 0) goto L_0x004b
            java.lang.String r1 = r6.getSession()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0044
            java.lang.String r1 = r6.getSession()
            r0.put(r2, r1)
            goto L_0x004e
        L_0x0044:
            java.lang.String r1 = "TuyaApiParams"
            java.lang.String r3 = "Need Login"
            com.tuya.smart.android.common.utils.L.i(r1, r3)
        L_0x004b:
            r0.remove(r2)
        L_0x004e:
            boolean r1 = r6.isH5Request()
            java.lang.String r2 = "h5Token"
            java.lang.String r3 = "isH5"
            java.lang.String r4 = "1"
            if (r1 == 0) goto L_0x0065
            r0.put(r3, r4)
            java.lang.String r1 = r6.getH5Token()
            r0.put(r2, r1)
            goto L_0x006b
        L_0x0065:
            r0.remove(r3)
            r0.remove(r2)
        L_0x006b:
            boolean r1 = r6.isSpRequest()
            java.lang.String r2 = "sp"
            if (r1 == 0) goto L_0x0077
            r0.put(r2, r4)
            goto L_0x007a
        L_0x0077:
            r0.remove(r2)
        L_0x007a:
            boolean r1 = r6.isN4H5Request()
            java.lang.String r2 = "n4h5"
            if (r1 == 0) goto L_0x0086
            r0.put(r2, r4)
            goto L_0x0089
        L_0x0086:
            r0.remove(r2)
        L_0x0089:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.network.TuyaApiParams.getUrlParams():java.util.Map");
    }

    public boolean hasPostData() {
        return this.postData != null;
    }

    public void initUrlParams(String str) {
        this.urlGETParams.put("v", "*");
        this.urlGETParams.put(KEY_APP_ID, TuyaSmartNetWork.mAppId);
        this.urlGETParams.put(KEY_APP_OS, "Android");
        this.urlGETParams.put(KEY_APP_VERSION, TuyaSmartNetWork.mAppVersion);
        this.urlGETParams.put(KEY_APP_LANG, TuyaUtil.getLang(TuyaSmartNetWork.mAppContext));
        this.urlGETParams.put(KEY_SDK_VERSION, TuyaSmartNetWork.mSdkVersion);
        this.urlGETParams.put(KEY_TTID, TuyaSmartNetWork.getTtid());
        this.urlGETParams.put(KEY_OS_SYSTEM, Build.VERSION.RELEASE);
        this.urlGETParams.put(KEY_REQUEST_ID, UUID.randomUUID().toString());
        this.urlGETParams.put(KEY_PLATFORM, Build.MODEL);
        this.urlGETParams.put(KEY_TIME_ZONE_ID, TyCommonUtil.getTimeZoneId());
        this.urlGETParams.put(KEY_ET, ET_VERSION);
        this.urlGETParams.put(KEY_CHANNEL, TuyaSmartNetWork.mChannel);
        if (!TextUtils.isEmpty(TuyaSmartNetWork.mAppRNVersion)) {
            this.urlGETParams.put(KEY_APP_RN_VERSION, TuyaSmartNetWork.mAppRNVersion);
        }
        this.serverHostUrl = TextUtils.isEmpty(str) ? TuyaSmartNetWork.getServiceHostUrl() : TuyaSmartNetWork.getServiceHostUrl(str);
    }

    public boolean isH5Request() {
        return this.isH5Request;
    }

    public boolean isLocationRequire() {
        return this.locationRequire;
    }

    public boolean isN4H5Request() {
        return this.isN4H5Request;
    }

    public boolean isSessionRequire() {
        return this.sessionRequire;
    }

    public TuyaApiParams putPostData(String str, Object obj) {
        if (this.postData == null) {
            this.postData = new JSONObject();
        }
        this.postData.put(str, obj);
        return this;
    }

    public void setApiName(String str) {
        this.apiName = str;
    }

    public void setApiVersion(String str) {
        this.apiVersion = str;
    }

    public void setCacheDefaultData(Object obj) {
        this.cacheDefaultData = obj;
    }

    public void setDataBytes(byte[] bArr) {
        this.dataBytes = bArr;
    }

    public void setEcode(String str) {
        this.ecode = str;
    }

    public void setGid(long j) {
        this.gid = j;
    }

    public void setH5Token(String str) {
        if (TextUtils.isEmpty(str)) {
            this.isH5Request = false;
            return;
        }
        this.isH5Request = true;
        this.h5Token = str;
    }

    public void setIsN4H5Request(boolean z) {
        this.isN4H5Request = z;
    }

    public void setListener(Business.ResultListener resultListener) {
        this.listener = resultListener;
    }

    public void setLocationRequire(boolean z) {
        this.locationRequire = z;
    }

    public void setPostData(JSONObject jSONObject) {
        this.postData = jSONObject;
    }

    public void setServerHostUrl(String str) {
        this.serverHostUrl = str;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public void setSessionRequire(boolean z) {
        this.sessionRequire = z;
    }

    public void setShouldCache(boolean z) {
        this.shouldCache = z;
    }

    public void setSpRequest(boolean z) {
        this.spRequest = z;
    }

    public void setThrowCache(boolean z) {
        this.throwCache = z;
    }

    public boolean shouldCache() {
        return this.shouldCache;
    }

    public boolean throwCache() {
        return this.throwCache;
    }

    public Object throwCacheDefaultData() {
        return this.cacheDefaultData;
    }
}
