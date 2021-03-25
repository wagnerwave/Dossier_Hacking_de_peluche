package com.tuya.smart.sdk.bean;

import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.List;
import java.util.Map;

public class DeviceBean {
    public static final String TAG = "DeviceBean";
    public static final String UI_TYPE_RN = "RN";
    public int ability;
    public String appRnVersion;
    public long attribute;
    public String bv;
    public String cadv;
    public String category;
    public long devAttribute;
    public String devId;
    public String devKey;
    public String displayDps;
    public String displayMsgs;
    public int displayOrder;
    public long dpMaxTime;
    public Map<String, String> dpName;
    public Map<String, Object> dps;
    public long errorCode;
    public List<Integer> faultDps;
    public String gwType;
    public HgwBean hgwBean;
    public int homeDisplayOrder;
    public long i18nTime;
    public String iconUrl;
    public Boolean isLocalOnline;
    public Boolean isOnline = Boolean.FALSE;
    public Boolean isShare;
    public String lat;
    public String localKey;
    public String lon;
    public String mac;
    public String meshId;
    public String name;
    public String nodeId;
    public Map<String, Object> panelConfig;
    public String parentId;
    public ProductBean productBean;
    public String productId;
    public String pv;
    public String quickOpDps;
    public boolean rnFind;
    public String runtimeEnv;
    public String schema;
    public String schemaExt;
    public Map<String, SchemaBean> schemaMap;
    public Map<String, Object> skills;
    public boolean supportGroup;
    public int switchDp;
    public long time;
    public String timezoneId;
    public int topoType = -1;
    public String ui;
    public Map<String, Object> uiConfig;
    public String uiName;
    public String uiPhase;
    public String uiType;
    public String uuid;
    public String verSw;
    public boolean virtual;

    public int getAbility() {
        return this.ability;
    }

    public String getAppRnVersion() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getUiInfo().getAppRnVersion();
    }

    public long getAttribute() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return 0;
        }
        return productBean2.getAttribute();
    }

    public String getBv() {
        return this.bv;
    }

    public String getCadv() {
        return this.cadv;
    }

    public String getCategory() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getMeshCategory();
    }

    public long getDevAttribute() {
        return this.devAttribute;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getDevKey() {
        return this.devKey;
    }

    public String getDisplayDps() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return JSON.toJSONString(productBean2.getShortcut().getDisplayDps());
    }

    public String getDisplayMsgs() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return JSON.toJSONString(productBean2.getShortcut().getDisplayMsgs());
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public long getDpMaxTime() {
        return this.dpMaxTime;
    }

    public Map<String, String> getDpName() {
        return this.dpName;
    }

    public Map<String, Object> getDps() {
        return this.dps;
    }

    public long getErrorCode() {
        return this.errorCode;
    }

    public List<Integer> getFaultDps() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getShortcut().getFaultDps();
    }

    public String getGwType() {
        return this.gwType;
    }

    public HgwBean getHgwBean() {
        return this.hgwBean;
    }

    public int getHomeDisplayOrder() {
        return this.homeDisplayOrder;
    }

    public long getI18nTime() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return 0;
        }
        return productBean2.getI18nTime();
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public Boolean getIsLocalOnline() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        return Boolean.valueOf(o0o00o00o0 != null && o0o00o00o0.O000000o().O000000o(this, this.isOnline).booleanValue());
    }

    public Boolean getIsOnline() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        return Boolean.valueOf(o0o00o00o0 != null && o0o00o00o0.O000000o().O00000Oo(this, this.isOnline));
    }

    public Boolean getIsShare() {
        return this.isShare;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLocalKey() {
        return this.localKey;
    }

    public String getLon() {
        return this.lon;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMeshId() {
        return this.meshId;
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

    public String getParentId() {
        return this.parentId;
    }

    public ProductBean getProductBean() {
        return this.productBean;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPv() {
        return this.pv;
    }

    public String getQuickOpDps() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return JSON.toJSONString(productBean2.getShortcut().getQuickOpDps());
    }

    public boolean getRnFind() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.getUiInfo().getRnFind();
    }

    public String getRuntimeEnv() {
        return this.runtimeEnv;
    }

    public String getSchema() {
        ProductBean.SchemaInfo schemaInfo;
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null || (schemaInfo = productBean2.getSchemaInfo()) == null) {
            return null;
        }
        return schemaInfo.getSchema();
    }

    public String getSchemaExt() {
        ProductBean.SchemaInfo schemaInfo;
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null || (schemaInfo = productBean2.getSchemaInfo()) == null) {
            return null;
        }
        return schemaInfo.getSchemaExt();
    }

    public Map<String, SchemaBean> getSchemaMap() {
        ProductBean.SchemaInfo schemaInfo;
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null || (schemaInfo = productBean2.getSchemaInfo()) == null) {
            return null;
        }
        return schemaInfo.getSchemaMap();
    }

    public Map<String, Object> getSkills() {
        return this.skills;
    }

    public int getSwitchDp() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return 0;
        }
        return productBean2.getShortcut().getSwitchDp();
    }

    public long getTime() {
        return this.time;
    }

    public String getTimezoneId() {
        return this.timezoneId;
    }

    public int getTopoType() {
        return this.topoType;
    }

    public String getUi() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getUiInfo().getUi();
    }

    public Map<String, Object> getUiConfig() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getUiInfo().getUiConfig();
    }

    public String getUiName() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getUiInfo().getName();
    }

    public String getUiPhase() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getUiInfo().getPhase();
    }

    public String getUiType() {
        ProductBean productBean2 = this.productBean;
        if (productBean2 == null) {
            return null;
        }
        return productBean2.getUiInfo().getType();
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVerSw() {
        return this.verSw;
    }

    public boolean hasZigBee() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasZigBee();
    }

    public boolean is433SubDev() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.has433() && !this.productBean.hasWifi();
    }

    public boolean is433Wifi() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.has433() && this.productBean.hasWifi();
    }

    public boolean isBleMesh() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasBleMesh();
    }

    public boolean isBleMeshWifi() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasBleMesh() && this.productBean.hasWifi();
    }

    public boolean isBlueMesh() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasBlueMesh();
    }

    public boolean isBluetooth() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasBluetooth();
    }

    public boolean isCloudOnline() {
        if (!isBlueMesh() || isBleMeshWifi()) {
            return this.isOnline.booleanValue();
        }
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        return o0o00o00o0 != null && o0o00o00o0.O000000o().O000000o(this);
    }

    public boolean isEncrypt() {
        HgwBean hgwBean2 = this.hgwBean;
        return hgwBean2 != null && hgwBean2.isEncrypt();
    }

    public boolean isInfraredSubDev() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasInfrared() && !this.productBean.hasWifi();
    }

    public boolean isSigMesh() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasSigMesh();
    }

    public boolean isSupportGroup() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.isSupportGroup();
    }

    public boolean isVirtual() {
        return this.virtual;
    }

    public boolean isWifiDevice() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.isWifi();
    }

    public boolean isZigBeeSubDev() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasZigBee() && !this.productBean.hasWifi();
    }

    public boolean isZigBeeWifi() {
        ProductBean productBean2 = this.productBean;
        return productBean2 != null && productBean2.hasZigBee() && this.productBean.hasWifi();
    }

    public void setAbility(int i) {
        this.ability = i;
    }

    public void setAppRnVersion(String str) {
        this.appRnVersion = str;
    }

    @Deprecated
    public void setAttribute(long j) {
        this.attribute = j;
    }

    public void setBv(String str) {
        this.bv = str;
    }

    public void setCadv(String str) {
        this.cadv = str;
    }

    @Deprecated
    public void setCategory(String str) {
        this.category = str;
    }

    public void setDevAttribute(long j) {
        this.devAttribute = j;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDevKey(String str) {
        this.devKey = str;
    }

    @Deprecated
    public void setDisplayDps(String str) {
        this.displayDps = str;
    }

    @Deprecated
    public void setDisplayMsgs(String str) {
        this.displayMsgs = str;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setDpMaxTime(long j) {
        this.dpMaxTime = j;
    }

    public void setDpName(Map<String, String> map) {
        this.dpName = map;
    }

    public void setDps(Map<String, Object> map) {
        this.dps = map;
    }

    public void setErrorCode(long j) {
        this.errorCode = j;
    }

    @Deprecated
    public void setFaultDps(List<Integer> list) {
        this.faultDps = list;
    }

    public void setGwType(String str) {
        this.gwType = str;
    }

    public void setHgwBean(HgwBean hgwBean2) {
        this.hgwBean = hgwBean2;
    }

    public void setHomeDisplayOrder(int i) {
        this.homeDisplayOrder = i;
    }

    @Deprecated
    public void setI18nTime(long j) {
        this.i18nTime = j;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setIsOnline(Boolean bool) {
        this.isOnline = bool;
    }

    public void setIsShare(Boolean bool) {
        this.isShare = bool;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLocalKey(String str) {
        this.localKey = str;
    }

    public void setLocalOnline(Boolean bool) {
        this.isLocalOnline = bool;
    }

    public void setLon(String str) {
        this.lon = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMeshId(String str) {
        this.meshId = str;
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

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setProductBean(ProductBean productBean2) {
        this.productBean = productBean2;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPv(String str) {
        this.pv = str;
    }

    @Deprecated
    public void setQuickOpDps(String str) {
        this.quickOpDps = str;
    }

    @Deprecated
    public void setRnFind(boolean z) {
        this.rnFind = z;
    }

    public void setRuntimeEnv(String str) {
        this.runtimeEnv = str;
    }

    @Deprecated
    public void setSchema(String str) {
        this.schema = str;
    }

    public void setSchemaExt(String str) {
        this.schemaExt = str;
    }

    @Deprecated
    public void setSchemaMap(Map<String, SchemaBean> map) {
        this.schemaMap = map;
    }

    public void setSkills(Map<String, Object> map) {
        this.skills = map;
    }

    @Deprecated
    public void setSupportGroup(boolean z) {
        this.supportGroup = z;
    }

    public void setSwitchDp(int i) {
        this.switchDp = i;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTimezoneId(String str) {
        this.timezoneId = str;
    }

    public void setTopoType(int i) {
        this.topoType = i;
    }

    @Deprecated
    public void setUi(String str) {
        this.ui = str;
    }

    @Deprecated
    public void setUiConfig(Map<String, Object> map) {
        this.uiConfig = map;
    }

    @Deprecated
    public void setUiName(String str) {
        this.uiName = str;
    }

    @Deprecated
    public void setUiPhase(String str) {
        this.uiPhase = str;
    }

    @Deprecated
    public void setUiType(String str) {
        this.uiType = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVerSw(String str) {
        this.verSw = str;
    }

    public void setVirtual(boolean z) {
        this.virtual = z;
    }
}
