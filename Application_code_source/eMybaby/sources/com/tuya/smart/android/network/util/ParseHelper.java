package com.tuya.smart.android.network.util;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.network.bean.PageList;
import com.tuya.smart.android.network.http.BusinessResponse;
import java.util.ArrayList;
import java.util.List;

public class ParseHelper {
    public static <T> ArrayList<T> parse2ArrayList(BusinessResponse businessResponse, Class<T> cls, String str) {
        JSONArray jSONArray;
        List<T> parseArray;
        ArrayList<T> arrayList = new ArrayList<>();
        if (!businessResponse.isSuccess()) {
            return arrayList;
        }
        try {
            String parser = parser(businessResponse);
            if (TextUtils.isEmpty(parser)) {
                return arrayList;
            }
            if (TextUtils.isEmpty(str)) {
                parseArray = JSON.parseArray(parser, cls);
            } else {
                JSONObject parseObject = JSON.parseObject(parser);
                if (parseObject == null || parseObject.size() <= 0 || (jSONArray = parseObject.getJSONArray(str)) == null) {
                    return arrayList;
                }
                parseArray = JSON.parseArray(jSONArray.toJSONString(), cls);
            }
            return (ArrayList) parseArray;
        } catch (Exception unused) {
            businessResponse.setSuccess(Boolean.FALSE);
            businessResponse.setErrorCode(BusinessResponse.RESULT_EXCEPTION);
            businessResponse.setErrorMsg("JSON PARSE EXCEPTION");
            return arrayList;
        }
    }

    public static <T> ArrayList<ArrayList<T>> parse2ArrayLists(BusinessResponse businessResponse, Class<T> cls, String str) {
        ArrayList<ArrayList<T>> arrayList = new ArrayList<>();
        if (businessResponse.isSuccess()) {
            try {
                String parser = parser(businessResponse);
                if (!TextUtils.isEmpty(parser)) {
                    if (!TextUtils.isEmpty(str)) {
                        JSONArray jSONArray = null;
                        JSONObject parseObject = JSON.parseObject(parser);
                        if (parseObject != null) {
                            jSONArray = parseObject.getJSONArray(str);
                        }
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        parser = jSONArray.toJSONString();
                    }
                    List<String> parseArray = JSON.parseArray(parser, String.class);
                    if (parseArray != null) {
                        for (String parseArray2 : parseArray) {
                            arrayList.add((ArrayList) JSON.parseArray(parseArray2, cls));
                        }
                    }
                }
            } catch (Exception unused) {
                businessResponse.setSuccess(Boolean.FALSE);
                businessResponse.setErrorCode(BusinessResponse.RESULT_EXCEPTION);
                businessResponse.setErrorMsg("JSON PARSE EXCEPTION");
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[Catch:{ Exception -> 0x0047 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.util.HashMap<java.lang.String, T> parse2HashMap(com.tuya.smart.android.network.http.BusinessResponse r4, java.lang.Class<T> r5, java.lang.String[] r6) {
        /*
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            boolean r1 = r4.isSuccess()
            if (r1 == 0) goto L_0x0056
            java.lang.Class<com.alibaba.fastjson.JSONObject> r1 = com.alibaba.fastjson.JSONObject.class
            java.lang.Object r1 = parser(r4, r1)     // Catch:{ Exception -> 0x0047 }
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1     // Catch:{ Exception -> 0x0047 }
            if (r1 == 0) goto L_0x0056
            if (r6 == 0) goto L_0x0025
            int r2 = r6.length     // Catch:{ Exception -> 0x0047 }
            if (r2 != 0) goto L_0x001b
            goto L_0x0025
        L_0x001b:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ Exception -> 0x0047 }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ Exception -> 0x0047 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0029
        L_0x0025:
            java.util.Set r2 = r1.keySet()     // Catch:{ Exception -> 0x0047 }
        L_0x0029:
            java.util.Iterator r6 = r2.iterator()     // Catch:{ Exception -> 0x0047 }
        L_0x002d:
            boolean r2 = r6.hasNext()     // Catch:{ Exception -> 0x0047 }
            if (r2 == 0) goto L_0x0056
            java.lang.Object r2 = r6.next()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0047 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0047 }
            if (r3 != 0) goto L_0x002d
            java.lang.Object r3 = r1.getObject(r2, r5)     // Catch:{ Exception -> 0x0047 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0047 }
            goto L_0x002d
        L_0x0047:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r4.setSuccess(r5)
            java.lang.String r5 = "EXCEPTION"
            r4.setErrorCode(r5)
            java.lang.String r5 = "JSON PARSE EXCEPTION"
            r4.setErrorMsg(r5)
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.network.util.ParseHelper.parse2HashMap(com.tuya.smart.android.network.http.BusinessResponse, java.lang.Class, java.lang.String[]):java.util.HashMap");
    }

    public static <T> PageList<T> parse2PageList(BusinessResponse businessResponse, Class<T> cls, String str, String str2) {
        PageList<T> pageList = new PageList<>();
        if (businessResponse.isSuccess()) {
            int i = 0;
            try {
                String parser = parser(businessResponse);
                if (!TextUtils.isEmpty(parser)) {
                    List<T> arrayList = new ArrayList<>();
                    if (TextUtils.isEmpty(str)) {
                        arrayList = JSON.parseArray(parser, cls);
                    } else {
                        JSONObject parseObject = JSON.parseObject(parser);
                        if (parseObject != null && parseObject.size() > 0) {
                            if (!TextUtils.isEmpty(str2)) {
                                i = parseObject.getInteger(str2).intValue();
                            }
                            JSONArray jSONArray = parseObject.getJSONArray(str);
                            if (jSONArray != null) {
                                arrayList = JSON.parseArray(jSONArray.toJSONString(), cls);
                            }
                        }
                    }
                    int size = arrayList.size();
                    pageList.setData(arrayList);
                    if (str != null && i >= size) {
                        pageList.setTotal(i);
                    } else {
                        pageList.setTotal(size);
                    }
                }
            } catch (Exception unused) {
                pageList.setData(new ArrayList());
                pageList.setTotal(-1);
                businessResponse.setSuccess(Boolean.FALSE);
                businessResponse.setErrorCode(BusinessResponse.RESULT_EXCEPTION);
                businessResponse.setErrorMsg("JSON PARSE EXCEPTION");
            }
        } else {
            pageList.setData(new ArrayList());
            pageList.setTotal(-1);
        }
        return pageList;
    }

    public static <T> T parser(BusinessResponse businessResponse, Class<T> cls) {
        return JSON.parseObject(parser(businessResponse), cls);
    }

    public static <T> T parser(BusinessResponse businessResponse, Class<T> cls, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return cls == String.class ? parser(businessResponse) : parser(businessResponse, cls);
            }
            JSONObject jSONObject = (JSONObject) parser(businessResponse, JSONObject.class);
            if (jSONObject != null) {
                return jSONObject.getObject(str, cls);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            businessResponse.setSuccess(Boolean.FALSE);
            businessResponse.setErrorCode(BusinessResponse.RESULT_EXCEPTION);
            businessResponse.setErrorMsg("JSON PARSE EXCEPTION");
            return null;
        }
    }

    public static String parser(BusinessResponse businessResponse) {
        return businessResponse.getResult();
    }
}
