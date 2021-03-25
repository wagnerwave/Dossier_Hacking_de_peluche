package com.tuya.sdk.timer.bean;

public class CategoryStatusBean {
    public static final int STATUE_CLOSE = 0;
    public static final int STATUE_OPEN = 1;
    public String category;
    public int status;

    public String getCategory() {
        return this.category;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isOpen() {
        return this.status == 1;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
