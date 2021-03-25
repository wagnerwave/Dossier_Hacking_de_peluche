package com.tuya.smart.home.sdk.bean.scene;

public class SceneIdBean {
    public String gid;
    public String gwId;
    public String sid;

    public boolean equals(Object obj) {
        if (!(obj instanceof SceneIdBean)) {
            return super.equals(obj);
        }
        SceneIdBean sceneIdBean = (SceneIdBean) obj;
        return this.sid.equals(sceneIdBean.getSid()) && this.gid.equals(sceneIdBean.getGid()) && this.gwId.equals(sceneIdBean.getGwId());
    }

    public String getGid() {
        return this.gid;
    }

    public String getGwId() {
        return this.gwId;
    }

    public String getSid() {
        return this.sid;
    }

    public int hashCode() {
        int hashCode = this.gid.hashCode();
        return this.gwId.hashCode() + ((hashCode + ((this.sid.hashCode() + 527) * 31)) * 31);
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }
}
