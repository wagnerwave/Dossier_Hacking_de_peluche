package com.tuya.smart.home.sdk.bean.scene;

import androidx.annotation.NonNull;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0ooo00oo;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SceneTask implements Serializable {
    public static final long serialVersionUID = 2265313656820949794L;
    public Map<String, List<String>> actionDisplayNew;
    public String actionExecutor;
    public String devIcon;
    public String entityId;
    public String entityName;
    public Map<String, Object> executorProperty;
    public Map<String, Object> extraProperty;
    public String id;
    public boolean isDevOnline;
    public String uiid;

    public SceneTask() {
    }

    public SceneTask(SceneTask sceneTask) {
        this.id = sceneTask.getId();
        this.actionDisplayNew = sceneTask.getActionDisplayNew();
        this.entityId = sceneTask.getEntityId();
        this.entityName = sceneTask.getEntityName();
        this.actionExecutor = sceneTask.getActionExecutor();
        this.executorProperty = sceneTask.getExecutorProperty();
    }

    public static SceneTask createDelayTask(int i, int i2) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("delay");
        HashMap hashMap = new HashMap();
        hashMap.put("minutes", i + "");
        hashMap.put("seconds", i2 + "");
        sceneTask.setExecutorProperty(hashMap);
        sceneTask.setEntityId("delay");
        return sceneTask;
    }

    public static SceneTask createDpGroupTask(@NonNull long j, HashMap<String, Object> hashMap) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("deviceGroupDpIssue");
        sceneTask.setEntityId(String.valueOf(j));
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            GroupBean groupBean = o0o00o00o0.O0000OOo().getGroupBean(j);
            if (groupBean != null) {
                sceneTask.setDevIcon(groupBean.getIconUrl());
                sceneTask.setDevOnline(groupBean.getIsOnline());
                sceneTask.setEntityName(groupBean.getName());
            }
            if (hashMap == null || hashMap.size() == 0) {
                o00oo0oo00.O00000Oo("TuyaHomeScene", "task cannot be empty!");
                return null;
            }
        }
        sceneTask.setExecutorProperty(hashMap);
        return sceneTask;
    }

    @Deprecated
    public static SceneTask createDpTask(@NonNull String str, HashMap<String, Object> hashMap) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("dpIssue");
        sceneTask.setEntityId(str);
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(sceneTask.getEntityId());
            if (deviceBean != null) {
                sceneTask.setDevIcon(deviceBean.getIconUrl());
                sceneTask.setDevOnline(deviceBean.getIsOnline().booleanValue());
                sceneTask.setEntityName(deviceBean.getName());
            }
            if (hashMap == null || hashMap.size() == 0) {
                o00oo0oo00.O00000Oo("TuyaHomeScene", "task cannot be empty!");
                return null;
            }
        }
        sceneTask.setExecutorProperty(hashMap);
        return sceneTask;
    }

    public static SceneTask createPhoneNotice() {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("mobileVoiceSend");
        return sceneTask;
    }

    public static SceneTask createPushMessage() {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("appPushTrigger");
        return sceneTask;
    }

    @Deprecated
    public static SceneTask createSceneTask(SceneBean sceneBean) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor((sceneBean.getConditions() == null || sceneBean.getConditions().size() < 1) ? "ruleTrigger" : sceneBean.isEnabled() ? "ruleEnable" : "ruleDisable");
        sceneTask.setEntityId(sceneBean.getId());
        return sceneTask;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SceneTask.class != obj.getClass()) {
            return false;
        }
        SceneTask sceneTask = (SceneTask) obj;
        if (this.isDevOnline != sceneTask.isDevOnline) {
            return false;
        }
        String str = this.id;
        if (str == null ? sceneTask.id != null : !str.equals(sceneTask.id)) {
            return false;
        }
        String str2 = this.actionExecutor;
        if (str2 == null ? sceneTask.actionExecutor != null : !str2.equals(sceneTask.actionExecutor)) {
            return false;
        }
        String str3 = this.entityId;
        if (str3 == null ? sceneTask.entityId != null : !str3.equals(sceneTask.entityId)) {
            return false;
        }
        String str4 = this.entityName;
        if (str4 == null ? sceneTask.entityName != null : !str4.equals(sceneTask.entityName)) {
            return false;
        }
        Map<String, List<String>> map = this.actionDisplayNew;
        if (map == null ? sceneTask.actionDisplayNew != null : !map.equals(sceneTask.actionDisplayNew)) {
            return false;
        }
        Map<String, Object> map2 = this.executorProperty;
        if (map2 == null ? sceneTask.executorProperty != null : !map2.equals(sceneTask.executorProperty)) {
            return false;
        }
        Map<String, Object> map3 = this.extraProperty;
        if (map3 == null ? sceneTask.extraProperty != null : !map3.equals(sceneTask.extraProperty)) {
            return false;
        }
        String str5 = this.devIcon;
        String str6 = sceneTask.devIcon;
        return str5 != null ? str5.equals(str6) : str6 == null;
    }

    public Map<String, List<String>> getActionDisplayNew() {
        return this.actionDisplayNew;
    }

    public String getActionExecutor() {
        return this.actionExecutor;
    }

    public String getDevIcon() {
        return this.devIcon;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public Map<String, Object> getExecutorProperty() {
        return this.executorProperty;
    }

    public Map<String, Object> getExtraProperty() {
        return this.extraProperty;
    }

    public String getId() {
        return this.id;
    }

    public SceneIdBean getSceneIdBean() {
        if (this.extraProperty == null) {
            return null;
        }
        SceneIdBean sceneIdBean = new SceneIdBean();
        sceneIdBean.setGid(String.valueOf(this.extraProperty.get(TuyaApiParams.KEY_GID)));
        sceneIdBean.setSid(String.valueOf(this.extraProperty.get(TuyaApiParams.KEY_SESSION)));
        sceneIdBean.setGwId(String.valueOf(this.extraProperty.get(o0ooo00oo.O00000o0)));
        return sceneIdBean;
    }

    public String getUiid() {
        return this.uiid;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.actionExecutor;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.entityName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Map<String, List<String>> map = this.actionDisplayNew;
        int hashCode5 = (hashCode4 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, Object> map2 = this.executorProperty;
        int hashCode6 = (hashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Object> map3 = this.extraProperty;
        int hashCode7 = (hashCode6 + (map3 != null ? map3.hashCode() : 0)) * 31;
        String str5 = this.devIcon;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((hashCode7 + i) * 31) + (this.isDevOnline ? 1 : 0);
    }

    public boolean isDevOnline() {
        return this.isDevOnline;
    }

    public void setActionDisplayNew(Map<String, List<String>> map) {
        this.actionDisplayNew = map;
    }

    public void setActionExecutor(String str) {
        this.actionExecutor = str;
    }

    public void setDevIcon(String str) {
        this.devIcon = str;
    }

    public void setDevOnline(boolean z) {
        this.isDevOnline = z;
    }

    public void setEntityId(String str) {
        this.entityId = str;
    }

    public void setEntityName(String str) {
        this.entityName = str;
    }

    public void setExecutorProperty(Map<String, Object> map) {
        this.executorProperty = map;
    }

    public void setExtraProperty(Map<String, Object> map) {
        this.extraProperty = map;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSceneId(SceneIdBean sceneIdBean) {
        if (this.extraProperty == null) {
            this.extraProperty = new HashMap();
        }
        this.extraProperty.put(TuyaApiParams.KEY_GID, sceneIdBean.getGid());
        this.extraProperty.put(TuyaApiParams.KEY_SESSION, sceneIdBean.getSid());
        this.extraProperty.put(o0ooo00oo.O00000o0, sceneIdBean.getGwId());
    }

    public void setUiid(String str) {
        this.uiid = str;
    }
}
