package com.tuya.smart.android.device.bean;

import java.io.Serializable;

public class SchemaBean implements Serializable {
    public String code;
    public String iconname;
    public String id;
    public String mode;
    public String name;
    public Boolean passive;
    public String property;
    public String schemaType;
    public String type;

    public String getCode() {
        return this.code;
    }

    public String getIconname() {
        return this.iconname;
    }

    public String getId() {
        return this.id;
    }

    public String getMode() {
        return this.mode;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getPassive() {
        return this.passive;
    }

    public String getProperty() {
        return this.property;
    }

    public String getSchemaType() {
        return this.schemaType;
    }

    public String getType() {
        return this.type;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setIconname(String str) {
        this.iconname = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPassive(Boolean bool) {
        this.passive = bool;
    }

    public void setProperty(String str) {
        this.property = str;
    }

    public void setSchemaType(String str) {
        this.schemaType = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
