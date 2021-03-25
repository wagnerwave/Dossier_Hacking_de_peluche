package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.MD5Util;
import com.tuya.smart.android.common.utils.StringUtils;
import com.tuya.smart.android.network.TuyaApiParams;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;

public class oo000o0o0 {
    public static final List<String> O000000o = Arrays.asList(new String[]{"a", "v", TuyaApiParams.KEY_LAT, TuyaApiParams.KEY_LON, TuyaApiParams.KEY_APP_LANG, "deviceId", TuyaApiParams.KEY_APP_VERSION, TuyaApiParams.KEY_TTID, TuyaApiParams.KEY_H5, TuyaApiParams.KEY_H5TOKEN, TuyaApiParams.KEY_APP_OS, TuyaApiParams.KEY_APP_ID, TuyaApiParams.KEY_POST, "time", TuyaApiParams.KEY_REQUEST_ID, TuyaApiParams.KEY_ET, TuyaApiParams.KEY_N4H5, TuyaApiParams.KEY_SESSION, TuyaApiParams.KEY_SP});
    public static final String O00000Oo = "TuyaApiSignManager";

    public static String O000000o(String str) {
        return !TextUtils.isEmpty(str) ? O00000Oo(MD5Util.md5AsBase64(str)) : "";
    }

    public static String O000000o(Map<String, String> map) {
        LinkedList linkedList = new LinkedList(map.keySet());
        Collections.sort(linkedList);
        Iterator it = linkedList.iterator();
        String str = "";
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (O000000o.contains(str2) && !TextUtils.isEmpty(map.get(str2))) {
                if (str2.equals(TuyaApiParams.KEY_POST)) {
                    String str3 = map.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        map.put(str2, O000000o(str3));
                    }
                }
                if (!"".equals(str)) {
                    str = a.k(str, o0ooo00oo.O0000Oo);
                }
                StringBuilder q = a.q(str, str2, o0ooo00oo.O0000Oo0);
                q.append(map.get(str2));
                str = q.toString();
            }
        }
        try {
            return oo00o000o.O000000o().O000000o(str);
        } catch (Exception e2) {
            StringBuilder n = a.n("Exception Errorcode ");
            n.append(e2.getMessage());
            return n.toString();
        }
    }

    public static String O000000o(ConcurrentHashMap<String, String> concurrentHashMap, TuyaApiParams tuyaApiParams) {
        return O000000o((Map<String, String>) concurrentHashMap);
    }

    public static String O000000o(boolean z, String str, Map<String, String> map) {
        HttpUrl.Builder builder;
        if (str == null) {
            return null;
        }
        if (z) {
            str = str.replace(" ", "%20");
        }
        if (map == null) {
            return str;
        }
        HttpUrl parse = HttpUrl.parse(str);
        if (str.substring(parse.isHttps() ? 8 : 7).contains(":")) {
            try {
                builder = new HttpUrl.Builder().port(new URL(str).getPort());
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                builder = new HttpUrl.Builder();
            }
        } else {
            builder = new HttpUrl.Builder();
        }
        for (Map.Entry next : map.entrySet()) {
            builder.addQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        for (String addPathSegment : parse.pathSegments()) {
            builder.addPathSegment(addPathSegment);
        }
        return builder.scheme(parse.scheme()).host(parse.host()).build().toString();
    }

    public static String O00000Oo(String str) {
        String substring = StringUtils.substring(str, 0, 8);
        String substring2 = StringUtils.substring(str, 8, 24);
        String substring3 = StringUtils.substring(substring2, 0, 8);
        String substring4 = StringUtils.substring(substring2, 8, 16);
        String substring5 = StringUtils.substring(str, 24, 32);
        return substring3 + substring + substring5 + substring4;
    }

    public static String O00000Oo(Map<String, String> map) {
        LinkedList linkedList = new LinkedList(map.keySet());
        Collections.sort(linkedList);
        Iterator it = linkedList.iterator();
        String str = "";
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!TextUtils.isEmpty(map.get(str2))) {
                if (!"".equals(str)) {
                    str = a.k(str, o0ooo00oo.O0000Oo);
                }
                StringBuilder q = a.q(str, str2, o0ooo00oo.O0000Oo0);
                q.append(map.get(str2));
                str = q.toString();
            }
        }
        return MD5Util.md5AsBase64(str);
    }
}
