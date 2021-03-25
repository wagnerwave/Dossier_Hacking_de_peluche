package com.sozpic.miniland.modelos;

import a.c.d.a;
import com.tuya.smart.android.network.TuyaApiParams;
import java.util.Date;
import org.json.JSONObject;

public class Usuario {
    public String bd;
    public String bdpre;
    public Date birthDate;
    public boolean buddyActive;
    public String carpeta;
    public String id;
    public String lang;
    public JSONObject originalJson;

    public Usuario(JSONObject jSONObject) {
        this.id = jSONObject.getString("id");
        this.bd = jSONObject.getString("bd");
        this.bdpre = jSONObject.getString("bdpre");
        this.carpeta = jSONObject.getString("carpeta");
        this.lang = jSONObject.getString(TuyaApiParams.KEY_APP_LANG);
        this.buddyActive = jSONObject.getBoolean("buddy_active");
        this.originalJson = jSONObject;
    }

    public String getBd() {
        return this.bd;
    }

    public String getBdpre() {
        return this.bdpre;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public String getCarpeta() {
        return this.carpeta;
    }

    public String getCorreo() {
        return a.l().m();
    }

    public String getId() {
        return this.id;
    }

    public String getLang() {
        return this.lang;
    }

    public JSONObject getOriginalJson() {
        return this.originalJson;
    }

    public String getPass() {
        return a.l().n() == null ? "" : a.l().n();
    }

    public boolean isBuddyActive() {
        return this.buddyActive;
    }

    public void setBd(String str) {
        this.bd = str;
    }

    public void setBdpre(String str) {
        this.bdpre = str;
    }

    public void setBirthDate(Date date) {
        this.birthDate = date;
    }

    public void setBuddyActive(boolean z) {
        this.buddyActive = z;
    }

    public void setCarpeta(String str) {
        this.carpeta = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
