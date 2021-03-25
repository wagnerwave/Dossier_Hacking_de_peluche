package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.mqttprotocol.bean.PublishBean;
import com.tuya.smart.android.common.utils.ByteUtils;
import com.tuya.smart.android.common.utils.CRC32Utils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.MD5;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class o0ooo00oo {
    public static final String O000000o = "CloudMqttParams";
    public static final String O00000Oo = "data";
    public static final String O00000o = "protocol";
    public static final String O00000o0 = "gwId";
    public static final String O00000oO = "pv";
    public static final String O00000oo = "t";
    public static final List<String> O0000O0o = Arrays.asList(new String[]{"data", O00000o0, O00000o, O00000oO, O00000oo});
    public static final String O0000OOo = "sign";
    public static final String O0000Oo = "||";
    public static final String O0000Oo0 = "=";

    public static String O000000o(JSONObject jSONObject, String str) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : jSONObject.entrySet()) {
            if (next.getValue() != null && !((String) next.getKey()).equals("sign")) {
                treeMap.put(next.getKey(), next.getValue().toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeMap.keySet()) {
            if (!TextUtils.isEmpty((CharSequence) treeMap.get(str2))) {
                sb.append(str2);
                sb.append(O0000Oo0);
                sb.append((String) treeMap.get(str2));
                sb.append(O0000Oo);
            }
        }
        sb.append(str);
        String md5 = MD5.md5(sb.toString());
        if (md5 == null) {
            return "";
        }
        StringBuilder n = a.n("Mqtt.generateSignature: ");
        n.append(sb.toString());
        n.append(" =>MD5: ");
        n.append(md5);
        L.i(O000000o, n.toString());
        return md5;
    }

    public static String O000000o(PublishBean publishBean, String str) {
        return O000000o((Map<String, String>) O000000o(publishBean), str).toLowerCase();
    }

    public static String O000000o(String str, String str2, String str3) {
        String md5 = MD5.md5("data=" + str2 + O0000Oo + O00000oO + O0000Oo0 + str + O0000Oo + str3);
        if (md5 == null) {
            return null;
        }
        return md5.toLowerCase().substring(8, 24);
    }

    public static String O000000o(Map<String, String> map, String str) {
        LinkedList linkedList = new LinkedList(map.keySet());
        Collections.sort(linkedList);
        Iterator it = linkedList.iterator();
        String str2 = "";
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (O0000O0o.contains(str3) && !TextUtils.isEmpty(map.get(str3))) {
                if (!"".equals(str2)) {
                    str2 = a.k(str2, O0000Oo);
                }
                StringBuilder q = a.q(str2, str3, O0000Oo0);
                q.append(map.get(str3));
                str2 = q.toString();
            }
        }
        String l = a.l(str2, O0000Oo, str);
        String md5 = MD5.md5(l);
        L.i(O000000o, "Mqtt.generateSignature: " + l + " =>MD5: " + md5);
        return md5;
    }

    public static ConcurrentHashMap<String, String> O000000o(PublishBean publishBean) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("data", publishBean.getData());
        concurrentHashMap.put(O00000o0, publishBean.getGwId());
        concurrentHashMap.put(O00000o, String.valueOf(publishBean.getProtocol()));
        concurrentHashMap.put(O00000oO, publishBean.getPv());
        concurrentHashMap.put(O00000oo, String.valueOf(publishBean.getT()));
        return concurrentHashMap;
    }

    public static byte[] O000000o(int i, int i2, byte[] bArr) {
        return ByteUtils.intToBytes2(CRC32Utils.crc32(ByteUtils.contact(ByteUtils.intToBytes2(i), ByteUtils.intToBytes2(i2), bArr)));
    }

    public static byte[] O000000o(int i, int i2, byte[] bArr, String str) {
        byte[] contact = ByteUtils.contact(ByteUtils.intToBytes2(i), ByteUtils.intToBytes2(i2), ByteUtils.intToBytes2(CRC32Utils.crc32(bArr)), str.getBytes());
        if (L.getLogStatus()) {
            StringBuilder n = a.n("signStr: ");
            n.append(ByteUtils.bytesToHexString(contact, ":"));
            L.d(O000000o, n.toString());
        }
        return ByteUtils.intToBytes2(CRC32Utils.crc32(contact));
    }
}
