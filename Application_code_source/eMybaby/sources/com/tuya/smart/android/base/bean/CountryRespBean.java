package com.tuya.smart.android.base.bean;

import a.a.a.a.a;

public class CountryRespBean {

    /* renamed from: a  reason: collision with root package name */
    public String f4797a;

    /* renamed from: c  reason: collision with root package name */
    public String f4798c;
    public String n;
    public String p;

    public String getA() {
        return this.f4797a;
    }

    public String getC() {
        return this.f4798c;
    }

    public String getN() {
        return this.n;
    }

    public String getP() {
        return this.p;
    }

    public void setA(String str) {
        this.f4797a = str;
    }

    public void setC(String str) {
        this.f4798c = str;
    }

    public void setN(String str) {
        this.n = str;
    }

    public void setP(String str) {
        this.p = str;
    }

    public String toString() {
        StringBuilder n2 = a.n("CountryRespBean{a='");
        a.x(n2, this.f4797a, '\'', ", c='");
        a.x(n2, this.f4798c, '\'', ", n='");
        a.x(n2, this.n, '\'', ", p='");
        n2.append(this.p);
        n2.append('\'');
        n2.append('}');
        return n2.toString();
    }
}
