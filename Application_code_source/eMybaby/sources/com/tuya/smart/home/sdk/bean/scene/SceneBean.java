package com.tuya.smart.home.sdk.bean.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

public class SceneBean implements Serializable {
    public static final int MATCH_TYPE_AND = 2;
    public static final int MATCH_TYPE_BY_EXPR = 3;
    public static final int MATCH_TYPE_OR = 1;
    public static final int RULEGENRE_TYPE_MANUAL = 1;
    public static final int RULEGENRE_TYPE_SMART = 2;
    public static final long serialVersionUID = 4267985378494994443L;
    public List<SceneTask> actions;
    public String background;
    public boolean boundForPanel;
    public String code;
    public List<SceneCondition> conditions;
    public boolean enabled;
    public String id;
    public boolean localLinkage;
    public int matchType;
    public String name;
    public boolean newLocalScene;
    public List<PreCondition> preConditions;
    public int ruleGenre;
    public boolean stickyOnTop;

    public static SceneBean createSceneBean(@NonNull String str, String str2, List<SceneCondition> list, @NonNull List<SceneTask> list2, int i) {
        return createSceneBean(str, (String) null, false, str2, list, list2, i);
    }

    public static SceneBean createSceneBean(@NonNull String str, @Nullable String str2, boolean z, String str3, @Nullable List<SceneCondition> list, @NonNull List<SceneTask> list2, int i) {
        return createSceneBean(str, str2, z, str3, list, list2, (List<PreCondition>) null, i);
    }

    public static SceneBean createSceneBean(@NonNull String str, @Nullable String str2, boolean z, String str3, @Nullable List<SceneCondition> list, @NonNull List<SceneTask> list2, List<PreCondition> list3, int i) {
        SceneBean sceneBean = new SceneBean();
        sceneBean.setName(str);
        sceneBean.setStickyOnTop(z);
        sceneBean.setBackground(str3);
        sceneBean.setMatchType(i);
        if ((true ^ TextUtils.isEmpty(str2)) && (str2 != null)) {
            sceneBean.setId(str2);
        }
        if (list != null) {
            sceneBean.setConditions(list);
        }
        if (list3 != null) {
            sceneBean.setPreConditions(list3);
        }
        sceneBean.setActions(list2);
        return sceneBean;
    }

    public List<SceneTask> getActions() {
        return this.actions;
    }

    public String getBackground() {
        return this.background;
    }

    public String getCode() {
        return this.code;
    }

    public List<SceneCondition> getConditions() {
        return this.conditions;
    }

    public String getId() {
        return this.id;
    }

    public int getMatchType() {
        return this.matchType;
    }

    public String getName() {
        return this.name;
    }

    public List<PreCondition> getPreConditions() {
        return this.preConditions;
    }

    public int getRuleGenre() {
        return this.ruleGenre;
    }

    public boolean isBoundForPanel() {
        return this.boundForPanel;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isLocalLinkage() {
        return this.localLinkage;
    }

    public boolean isNewLocalScene() {
        return this.newLocalScene;
    }

    public boolean isStickyOnTop() {
        return this.stickyOnTop;
    }

    public void setActions(List<SceneTask> list) {
        this.actions = list;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setBoundForPanel(boolean z) {
        this.boundForPanel = z;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setConditions(List<SceneCondition> list) {
        this.conditions = list;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLocalLinkage(boolean z) {
        this.localLinkage = z;
    }

    public void setMatchType(int i) {
        this.matchType = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNewLocalScene(boolean z) {
        this.newLocalScene = z;
    }

    public void setPreConditions(List<PreCondition> list) {
        this.preConditions = list;
    }

    public void setRuleGenre(int i) {
        this.ruleGenre = i;
    }

    public void setStickyOnTop(boolean z) {
        this.stickyOnTop = z;
    }
}
