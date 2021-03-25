package com.tuya.smart.sdk.bean;

import com.tuya.smart.android.device.bean.SchemaBean;
import java.util.List;
import java.util.Map;

@Deprecated
public class BlueMeshSubDevBean {
    public long activeTime;
    public int attribute;
    public String category;
    public String devId;
    public String displayDps;
    public String displayMsgs;
    public Map<String, Object> dps;
    public List<Integer> faultDps;
    public long i18nTime;
    public String icon;
    public String iconUrl;
    public String localKey;
    public boolean localOnline;
    public BlueMeshModuleMapBean moduleMap;
    public String name;
    public String nodeId;
    public Map<String, Object> panelConfig;
    public ProductBean productBean;
    public String productId;
    public String quickOpDps;
    public boolean rnFind;
    public String schema;
    public String schemaExt;
    public Map<String, SchemaBean> schemaMap;
    public boolean supportGroup;
    public int switchDp;
    public String ui;
    public Map<String, Object> uiConfig;
    public String uiName;
    public String uiPhase;
    public String uiType;

    public long getActiveTime() {
        return this.activeTime;
    }

    public int getAttribute() {
        return this.attribute;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getDisplayDps() {
        return this.displayDps;
    }

    public String getDisplayMsgs() {
        return this.displayMsgs;
    }

    public Map<String, Object> getDps() {
        return this.dps;
    }

    public List<Integer> getFaultDps() {
        return this.faultDps;
    }

    public long getI18nTime() {
        return this.i18nTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getLocalKey() {
        return this.localKey;
    }

    public BlueMeshModuleMapBean getModuleMap() {
        return this.moduleMap;
    }

    public String getName() {
        return this.name;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public Map<String, Object> getPanelConfig() {
        return this.panelConfig;
    }

    public ProductBean getProductBean() {
        return this.productBean;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getQuickOpDps() {
        return this.quickOpDps;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSchemaExt() {
        return this.schemaExt;
    }

    public Map<String, SchemaBean> getSchemaMap() {
        return this.schemaMap;
    }

    public int getSwitchDp() {
        return this.switchDp;
    }

    public String getUi() {
        return this.ui;
    }

    public Map<String, Object> getUiConfig() {
        return this.uiConfig;
    }

    public String getUiName() {
        return this.uiName;
    }

    public String getUiPhase() {
        return this.uiPhase;
    }

    public String getUiType() {
        return this.uiType;
    }

    public boolean isLocalOnline() {
        return this.localOnline;
    }

    public boolean isRnFind() {
        return this.rnFind;
    }

    public boolean isSupportGroup() {
        return this.supportGroup;
    }

    public void setActiveTime(long j) {
        this.activeTime = j;
    }

    public void setAttribute(int i) {
        this.attribute = i;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDisplayDps(String str) {
        this.displayDps = str;
    }

    public void setDisplayMsgs(String str) {
        this.displayMsgs = str;
    }

    public void setDps(Map<String, Object> map) {
        this.dps = map;
    }

    public void setFaultDps(List<Integer> list) {
        this.faultDps = list;
    }

    public void setI18nTime(long j) {
        this.i18nTime = j;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setLocalKey(String str) {
        this.localKey = str;
    }

    public void setLocalOnline(boolean z) {
        this.localOnline = z;
    }

    public void setModuleMap(BlueMeshModuleMapBean blueMeshModuleMapBean) {
        this.moduleMap = blueMeshModuleMapBean;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNodeId(String str) {
        this.nodeId = str;
    }

    public void setPanelConfig(Map<String, Object> map) {
        this.panelConfig = map;
    }

    public void setProductBean(ProductBean productBean2) {
        this.productBean = productBean2;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setQuickOpDps(String str) {
        this.quickOpDps = str;
    }

    public void setRnFind(boolean z) {
        this.rnFind = z;
    }

    public void setSchema(String str) {
        this.schema = str;
    }

    public void setSchemaExt(String str) {
        this.schemaExt = str;
    }

    public void setSchemaMap(Map<String, SchemaBean> map) {
        this.schemaMap = map;
    }

    public void setSupportGroup(boolean z) {
        this.supportGroup = z;
    }

    public void setSwitchDp(int i) {
        this.switchDp = i;
    }

    public void setUi(String str) {
        this.ui = str;
    }

    public void setUiConfig(Map<String, Object> map) {
        this.uiConfig = map;
    }

    public void setUiName(String str) {
        this.uiName = str;
    }

    public void setUiPhase(String str) {
        this.uiPhase = str;
    }

    public void setUiType(String str) {
        this.uiType = str;
    }
}
