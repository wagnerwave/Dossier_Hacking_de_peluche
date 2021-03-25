package com.tuya.smart.android.network;

import a.a.a.a.a;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.stat.TuyaDNS;
import com.tuya.smart.android.network.util.TLSSocketFactory;
import com.tuya.smart.common.oo000o0oo;
import com.tuya.smart.common.oo000oo0o;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

public class TuyaSmartNetWork {
    public static final String CHANNEL_OEM = "oem";
    public static final String CHANNEL_SDK = "sdk";
    public static final String DOMAIN_AY = "AY";
    public static final String DOMAIN_AZ = "AZ";
    public static final String DOMAIN_EU = "EU";
    public static final String DOMAIN_IN = "IN";
    public static final String DOMAIN_SH = "SH";
    public static final String DOMAIN_Undefined = "UE";
    public static final String TAG = "TuyaSmartNetWork";
    public static String USER_AGENT = "TY-UA=APP/Android";
    public static IApiUrlProvider mApiUrlProvider = null;
    public static Context mAppContext = null;
    public static boolean mAppDebug = false;
    public static String mAppId = null;
    public static String mAppRNVersion = null;
    public static String mAppSecret = null;
    public static String mAppVersion = null;
    public static String mChannel = "sdk";
    public static boolean mD = false;
    public static boolean mNTY = false;
    public static Business.OnNeedLoginListener mNeedLoginListener = null;
    public static boolean mSdk = true;
    public static String mSdkVersion;
    public static String mTtid;
    public static volatile OkHttpClient sOkHttpClient;

    public static void cancelALlNetwork() {
        getOkHttpClient().dispatcher().cancelAll();
    }

    public static Context getAppContext() {
        return mAppContext.getApplicationContext();
    }

    public static String getDefaultRegionByPhoneCode(String str) {
        if (TextUtils.equals(str, "86")) {
            return "AY";
        }
        if (str == null) {
            return "EU";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(",");
        sb.append(str);
        sb.append(",");
        return ",61,591,1,56,57,593,594,502,62,81,82,60,52,95,64,595,51,63,1787,39,597,66,598,58,84,54,55,852,853,886,505,".contains(sb.toString()) ? "AZ" : "EU";
    }

    public static String getGwApiUrl() {
        return mApiUrlProvider.getGwApiUrl();
    }

    public static String[] getGwMqttUrl() {
        return mApiUrlProvider.getGwMqttUrl();
    }

    public static String[] getMediaMqttUrl() {
        return mApiUrlProvider.getMediaMqttUrl();
    }

    public static String[] getMqttUrl() {
        return mApiUrlProvider.getMqttUrl();
    }

    public static OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (TuyaSmartNetWork.class) {
                if (sOkHttpClient == null) {
                    sOkHttpClient = newOKHttpClient();
                }
            }
        }
        return sOkHttpClient;
    }

    public static String getRegion() {
        return mApiUrlProvider.getRegion();
    }

    public static Map<String, String> getRequestHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", USER_AGENT);
        return hashMap;
    }

    public static String getServiceHostUrl() {
        return mApiUrlProvider.getApiUrl();
    }

    public static String getServiceHostUrl(String str) {
        return mApiUrlProvider.getApiUrlByCountryCode(str);
    }

    public static String getTtid() {
        return mTtid;
    }

    public static void initialize(Context context, String str, String str2, String str3, String str4, String str5, IApiUrlProvider iApiUrlProvider) {
        initialize(context, str, str2, str3, CHANNEL_SDK, str4, str5, iApiUrlProvider);
    }

    public static void initialize(Context context, String str, String str2, String str3, String str4, String str5, String str6, IApiUrlProvider iApiUrlProvider) {
        mAppContext = context;
        mAppId = str;
        mAppSecret = str2;
        mTtid = str3;
        if (TextUtils.isEmpty(mAppVersion)) {
            String appVersionName = TyCommonUtil.getAppVersionName(context);
            if (!TextUtils.isEmpty(appVersionName)) {
                mAppVersion = appVersionName;
            }
        } else {
            mAppVersion = str5;
        }
        if (TextUtils.isEmpty(mAppVersion)) {
            mAppVersion = mSdkVersion;
        }
        if (iApiUrlProvider != null) {
            mApiUrlProvider = iApiUrlProvider;
        }
        if (!TextUtils.isEmpty(str6)) {
            mAppRNVersion = str6;
        }
        if (TextUtils.isEmpty(str4)) {
            mChannel = CHANNEL_SDK;
        } else {
            mChannel = str4;
        }
        USER_AGENT += "/" + mAppVersion + "/SDK/" + mSdkVersion;
        setDebugMode(mAppDebug);
        oo000o0oo.O000000o(context);
    }

    public static void needLogin() {
        Business.OnNeedLoginListener onNeedLoginListener = mNeedLoginListener;
        if (onNeedLoginListener != null) {
            onNeedLoginListener.onNeedLogin(mAppContext);
        }
    }

    public static OkHttpClient newOKHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.addInterceptor(new oo000oo0o());
        builder.dns(new TuyaDNS());
        if (!mSdk) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Protocol.HTTP_1_1);
            builder.protocols(arrayList);
            L.d(TAG, "enable protocol 1.1");
        }
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                X509TrustManager systemDefaultTrustManager = systemDefaultTrustManager();
                builder.sslSocketFactory(new TLSSocketFactory(systemDefaultSslSocketFactory(systemDefaultTrustManager)), systemDefaultTrustManager);
                L.d(TAG, "enable support protocols");
            } catch (Throwable th) {
                StringBuilder n = a.n("enable support protocols error");
                n.append(th.getMessage());
                L.e(TAG, n.toString());
            }
        }
        return builder.build();
    }

    public static void setDebugMode(boolean z) {
        mAppDebug = z;
    }

    public static void setOnNeedLoginListener(Business.OnNeedLoginListener onNeedLoginListener) {
        mNeedLoginListener = onNeedLoginListener;
    }

    public static void switchServer(String str) {
        mApiUrlProvider.setRegion(str);
    }

    public static SSLSocketFactory systemDefaultSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            L.e(TAG, "The system has no SSLSocketFactory");
            throw new AssertionError();
        }
    }

    public static X509TrustManager systemDefaultTrustManager() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            L.e(TAG, "The system has no X509TrustManager");
            throw new AssertionError();
        }
    }
}
