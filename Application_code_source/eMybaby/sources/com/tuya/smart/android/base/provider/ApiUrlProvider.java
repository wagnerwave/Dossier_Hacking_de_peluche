package com.tuya.smart.android.base.provider;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.tuya.smart.android.base.bean.CountryBean;
import com.tuya.smart.android.base.bean.CountryRespBean;
import com.tuya.smart.android.base.utils.AssetsManager;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.network.IApiUrlProvider;
import com.tuya.smart.android.user.bean.Domain;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00oo0oo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public class ApiUrlProvider implements IApiUrlProvider {
    public static final String DEFAULT_DOMAIN = "{\n  \"AY\": {\n    \"mobileApiUrl\": \"https://a1.tuyacn.com/api.json\",\n    \"logUrl\": \"https://a1.tuyacn.com/log.json\",\n    \"mobileMqttUrl\": \"mq.mb.tuyacn.com\",\n    \"gwApiUrl\": \"http://a.gw.tuyacn.com/gw.json\",\n    \"gwMqttUrl\": \"mq.gw.tuyacn.com\",\n    \"mobileMediaMqttUrl\": \"s.tuyacn.com\",\n    \"aispeechHttpsUrl\": \"https://aispeech.tuyacn.com/api.json\"\n  },\n  \"AZ\": {\n    \"mobileApiUrl\": \"https://a1.tuyaus.com/api.json\",\n    \"logUrl\": \"https://a1.tuyaus.com/log.json\",\n    \"mobileMqttUrl\": \"mq.mb.tuyaus.com\",\n    \"gwApiUrl\": \"http://a.gw.tuyaus.com/gw.json\",\n    \"gwMqttUrl\": \"mq.gw.tuyaus.com\",\n    \"mobileMediaMqttUrl\": \"s.tuyaus.com\"\n  },\n  \"EU\": {\n    \"mobileApiUrl\": \"https://a1.tuyaeu.com/api.json\",\n    \"logUrl\": \"https://a1.tuyaeu.com/log.json\",\n    \"mobileMqttUrl\": \"mq.mb.tuyaeu.com\",\n    \"gwApiUrl\": \"http://a.gw.tuyaeu.com/gw.json\",\n    \"gwMqttUrl\": \"mq.gw.tuyaeu.com\",\n    \"mobileMediaMqttUrl\": \"s.tuyaeu.com\"\n  }\n}";
    public static String americaList = ",61,591,1,56,57,593,594,502,62,81,82,60,52,95,64,595,51,63,1787,597,66,598,58,84,54,55,852,853,886,";
    public static Context mContext;
    public o0o00oo0oo iTuyaUserPlugin = ((o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class));
    public Domain mDefaultDomain;
    public String mDomainJson = DEFAULT_DOMAIN;
    public String mRegion;

    public ApiUrlProvider(Context context) {
        mContext = context;
        String defaultRegion = getDefaultRegion(context);
        this.mRegion = defaultRegion;
        this.mDefaultDomain = getDefaultDomainByRegion(defaultRegion);
    }

    public ApiUrlProvider(Context context, String str) {
        mContext = context;
        this.mDomainJson = str;
        this.mRegion = getDefaultRegion(context);
        this.mDefaultDomain = getDefaultDomainByRegion(str);
    }

    public static String getCountryIOSCode(String str) {
        Iterator<CountryBean> it = getDefaultCountryData().iterator();
        while (it.hasNext()) {
            CountryBean next = it.next();
            if (next.getCode().equals(str)) {
                return next.getAbbr();
            }
        }
        return null;
    }

    public static ArrayList<CountryBean> getDefaultCountryData() {
        return transforBean(jsonStringToCountryRespBean(AssetsManager.getStringFromAssets(mContext, "countryList.en.json")));
    }

    private Domain getDefaultDomainByRegion(String str) {
        return (Domain) JSON.parseObject(this.mDomainJson).getObject(str, Domain.class);
    }

    public static String getDefaultRegion(Context context) {
        return getDefaultRegion(TyCommonUtil.getCountryCode(context, (String) null));
    }

    public static String getDefaultRegion(Context context, String str) {
        String countryIOSCode = getCountryIOSCode(str);
        return TextUtils.isEmpty(countryIOSCode) ? getDefaultRegion(context) : getDefaultRegion(countryIOSCode);
    }

    public static String getDefaultRegion(String str) {
        if (TextUtils.isEmpty(str)) {
            String id = TimeZone.getDefault().getID();
            return TextUtils.equals(id, "Asia/Shanghai") ? "AY" : id.startsWith("Europe") ? "EU" : "AZ";
        } else if ("CN".equals(str.toUpperCase())) {
            return "AY";
        } else {
            String phoneCode = getPhoneCode(str);
            if (phoneCode != null) {
                String str2 = americaList;
                if (str2.contains("," + phoneCode + ",")) {
                    return "AZ";
                }
            }
            return "EU";
        }
    }

    public static String getDefaultRegionByPhoneCode(String str) {
        if (TextUtils.equals(str, "86")) {
            return "AY";
        }
        if (str == null) {
            return "EU";
        }
        String str2 = americaList;
        StringBuilder sb = new StringBuilder();
        sb.append(",");
        sb.append(str);
        sb.append(",");
        return str2.contains(sb.toString()) ? "AZ" : "EU";
    }

    public static String getPhoneCode(String str) {
        Iterator<CountryBean> it = getDefaultCountryData().iterator();
        while (it.hasNext()) {
            CountryBean next = it.next();
            if (next.getAbbr().equals(str)) {
                return next.getCode();
            }
        }
        return null;
    }

    public static ArrayList<CountryRespBean> jsonStringToCountryRespBean(String str) {
        try {
            return (ArrayList) JSON.parseArray(JSON.parseArray(str).toJSONString(), CountryRespBean.class);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArrayList<CountryBean> transforBean(ArrayList<CountryRespBean> arrayList) {
        ArrayList<CountryBean> arrayList2 = new ArrayList<>();
        Iterator<CountryRespBean> it = arrayList.iterator();
        while (it.hasNext()) {
            CountryRespBean next = it.next();
            CountryBean countryBean = new CountryBean();
            countryBean.setAbbr(next.getA());
            countryBean.setChinese(next.getN());
            countryBean.setEnglish(next.getN());
            countryBean.setCode(next.getC());
            countryBean.setSpell(next.getP());
            arrayList2.add(countryBean);
        }
        return arrayList2;
    }

    public String getApiUrl() {
        User user;
        String mobileApiUrl = this.mDefaultDomain.getMobileApiUrl();
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null) {
            return mobileApiUrl;
        }
        Domain domain = user.getDomain();
        if (domain == null) {
            return getOldApiUrl();
        }
        return domain.getMobileApiUrl() + "/api.json";
    }

    public String getApiUrlByCountryCode(String str) {
        Context context = mContext;
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        return (o0o00oo0oo == null || o0o00oo0oo.O000000o().getUser() == null || TextUtils.isEmpty(this.iTuyaUserPlugin.O000000o().getUser().getDomain().getRegionCode())) ? getDefaultDomainByRegion(getDefaultRegion(context, str)).getMobileApiUrl() : getApiUrl();
    }

    public String getAudioUrl() {
        User user;
        Domain domain;
        String aispeechHttpsUrl = this.mDefaultDomain.getAispeechHttpsUrl();
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null || (domain = user.getDomain()) == null) {
            return aispeechHttpsUrl;
        }
        if (TextUtils.isEmpty(domain.getAispeechHttpsUrl())) {
            return getDefaultDomainByRegion(domain.getRegionCode()).getAispeechHttpsUrl();
        }
        return domain.getAispeechHttpsUrl() + "/api.json";
    }

    public String getEncrptUrl() {
        User user;
        Domain domain;
        String logUrl = this.mDefaultDomain.getLogUrl();
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null || (domain = user.getDomain()) == null) {
            return logUrl;
        }
        if (TextUtils.isEmpty(domain.getMobileApiUrl())) {
            return getDefaultDomainByRegion(domain.getRegionCode()).getLogUrl();
        }
        return domain.getMobileApiUrl() + "/log.json";
    }

    public String getGwApiUrl() {
        User user;
        String gwApiUrl = this.mDefaultDomain.getGwApiUrl();
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null) {
            return gwApiUrl;
        }
        Domain domain = user.getDomain();
        return domain != null ? domain.getGwApiUrl() : getOldGwApiUrl();
    }

    public String[] getGwMqttUrl() {
        User user;
        String mobileMqttUrl = this.mDefaultDomain.getMobileMqttUrl();
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        if (!(o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null)) {
            Domain domain = user.getDomain();
            if (domain == null) {
                return getOldGwMqttUrl();
            }
            mobileMqttUrl = domain.getMobileMqttUrl();
        }
        return new String[]{mobileMqttUrl};
    }

    public String[] getMediaMqttUrl() {
        return new String[0];
    }

    public String[] getMqttUrl() {
        String str;
        User user;
        String mobileMqttUrl = this.mDefaultDomain.getMobileMqttUrl();
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null) {
            str = null;
        } else {
            Domain domain = user.getDomain();
            if (domain == null) {
                return getOldMqttUrl(this.mRegion);
            }
            String mobileMqttUrl2 = domain.getMobileMqttUrl();
            str = domain.getMobileMqttsUrl();
            if (TextUtils.isEmpty(str)) {
                String regionCode = domain.getRegionCode();
                L.i("ApiUrlProvider", regionCode);
                str = getOldMqttUrl(regionCode)[1];
            }
            mobileMqttUrl = mobileMqttUrl2;
        }
        return new String[]{mobileMqttUrl, str};
    }

    public String getOldApiUrl() {
        return this.mRegion.equals("AY") ? "https://a1.mb.airtakeapp.com/api.json" : "https://a1.mb.getairtake.com/api.json";
    }

    public String getOldGwApiUrl() {
        return this.mRegion.equals("AY") ? "http://a.gw.airtakeapp.com/gw.json" : "http://a.gw.getairtake.com/gw.json";
    }

    public String[] getOldGwMqttUrl() {
        if (this.mRegion.equals("AY")) {
            return new String[]{"mq.gw.airtakeapp.com", "mq.gw1.airtakeapp.com"};
        }
        return new String[]{"mq.gw.getairtake.com", "mq.gw.getairtake.com"};
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] getOldMqttUrl(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 2
            java.lang.String[] r1 = new java.lang.String[r0]
            int r2 = r8.hashCode()
            r3 = 2104(0x838, float:2.948E-42)
            r4 = 3
            r5 = 0
            r6 = 1
            if (r2 == r3) goto L_0x0039
            r3 = 2105(0x839, float:2.95E-42)
            if (r2 == r3) goto L_0x002f
            r3 = 2224(0x8b0, float:3.116E-42)
            if (r2 == r3) goto L_0x0025
            r3 = 2645(0xa55, float:3.706E-42)
            if (r2 == r3) goto L_0x001b
            goto L_0x0043
        L_0x001b:
            java.lang.String r2 = "SH"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x0025:
            java.lang.String r2 = "EU"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0043
            r8 = 3
            goto L_0x0044
        L_0x002f:
            java.lang.String r2 = "AZ"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0043
            r8 = 2
            goto L_0x0044
        L_0x0039:
            java.lang.String r2 = "AY"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0043
            r8 = 0
            goto L_0x0044
        L_0x0043:
            r8 = -1
        L_0x0044:
            if (r8 == 0) goto L_0x0063
            if (r8 == r6) goto L_0x0063
            if (r8 == r0) goto L_0x0058
            if (r8 == r4) goto L_0x004d
            goto L_0x006d
        L_0x004d:
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r8 = "mq.mb.tuyaeu.com"
            r1[r5] = r8
            java.lang.String r8 = "m1.tuyaeu.com"
            r1[r6] = r8
            goto L_0x006d
        L_0x0058:
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r8 = "mq.mb.tuyaus.com"
            r1[r5] = r8
            java.lang.String r8 = "m1.tuyaus.com"
            r1[r6] = r8
            goto L_0x006d
        L_0x0063:
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r8 = "mq.mb.tuyacn.com"
            r1[r5] = r8
            java.lang.String r8 = "m1.tuyacn.com"
            r1[r6] = r8
        L_0x006d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.base.provider.ApiUrlProvider.getOldMqttUrl(java.lang.String):java.lang.String[]");
    }

    public String getRegion() {
        o0o00oo0oo o0o00oo0oo = this.iTuyaUserPlugin;
        if (o0o00oo0oo == null) {
            return this.mRegion;
        }
        User user = o0o00oo0oo.O000000o().getUser();
        return user == null ? this.mRegion : user.getDomain() != null ? user.getDomain().getRegionCode() : this.mRegion;
    }

    public void setDefaultDomain(Domain domain) {
        this.mDefaultDomain = domain;
    }

    public void setDomainJson(String str) {
        this.mDomainJson = str;
    }

    public void setRegion(String str) {
        this.mRegion = str;
    }
}
