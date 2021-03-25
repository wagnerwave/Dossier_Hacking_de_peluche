package com.tuya.smart.sdk.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.util.Map;

public class PushBean {

    /* renamed from: a  reason: collision with root package name */
    public String f4802a;

    /* renamed from: c  reason: collision with root package name */
    public String f4803c;
    public String cc;
    public String ct;
    public String link;
    public Map<String, Object> p;

    public static PushBean formatMessage(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str) || !str.startsWith("tuya://")) {
            return null;
        }
        PushBean pushBean = new PushBean();
        String[] split = str.substring(str.indexOf("//") + 2).split("[?]");
        int i = 0;
        pushBean.setC(split[0]);
        if (split.length > 1) {
            str2 = split[1];
        }
        if (!TextUtils.isEmpty(str2)) {
            String[] split2 = str2.split("=|&");
            while (i < split2.length) {
                if (TextUtils.equals(split2[i], "a")) {
                    i++;
                    pushBean.setA(split2[i]);
                } else if (TextUtils.equals(split2[i], "ct")) {
                    i++;
                    pushBean.setCt(split2[i]);
                } else if (TextUtils.equals(split2[i], "cc")) {
                    i++;
                    pushBean.setCc(split2[i]);
                } else if (TextUtils.equals(split2[i], "p")) {
                    i++;
                    pushBean.setP(JSON.parseObject(split2[i]));
                } else if (TextUtils.equals(split2[i], "link")) {
                    i++;
                    pushBean.setLink(split2[i]);
                }
                i++;
            }
        }
        return pushBean;
    }

    public String getA() {
        return this.f4802a;
    }

    public String getC() {
        return this.f4803c;
    }

    public String getCc() {
        return this.cc;
    }

    public String getCt() {
        return this.ct;
    }

    public String getLink() {
        return this.link;
    }

    public Map<String, Object> getP() {
        return this.p;
    }

    public void setA(String str) {
        this.f4802a = str;
    }

    public void setC(String str) {
        this.f4803c = str;
    }

    public void setCc(String str) {
        this.cc = str;
    }

    public void setCt(String str) {
        this.ct = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setP(Map<String, Object> map) {
        this.p = map;
    }
}
