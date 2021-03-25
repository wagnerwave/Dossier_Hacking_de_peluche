package com.tuya.smart.android.base.bean;

public class CountryBean {
    public String abbr;
    public String chinese;
    public String code;
    public String english;
    public String spell;

    public String getAbbr() {
        return this.abbr;
    }

    public String getChinese() {
        return this.chinese;
    }

    public String getCode() {
        return this.code;
    }

    public String getEnglish() {
        return this.english;
    }

    public String getSpell() {
        return this.spell;
    }

    public void setAbbr(String str) {
        this.abbr = str;
    }

    public void setChinese(String str) {
        this.chinese = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setEnglish(String str) {
        this.english = str;
    }

    public void setSpell(String str) {
        this.spell = str;
    }
}
