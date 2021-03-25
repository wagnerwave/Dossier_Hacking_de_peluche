package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;

public class MCGroup implements Serializable {
    public String groupName;
    public int id;

    public String getGroupName() {
        return this.groupName;
    }

    public int getId() {
        return this.id;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setId(int i) {
        this.id = i;
    }
}
