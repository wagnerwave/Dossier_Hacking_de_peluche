package com.tuya.smart.sdk.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.enums.DataTypeEnum;
import com.tuya.smart.sdk.api.IStorageCache;
import java.util.HashMap;
import java.util.Map;

public class ProductBean implements IStorageCache {
    public static final int ATTRIBUTE_LOW_POWER = 4096;
    public static final int ATTR_HONGWAI_SUB = 33554432;
    public static final int CAP_433 = 16384;
    public static final int CAP_BLEMESH = 2048;
    public static final int CAP_BLUETOOTH = 1024;
    public static final int CAP_CABLE = 2;
    public static final int CAP_GPRS = 4;
    public static final int CAP_HONGWAI = 8192;
    public static final int CAP_NB_IOT = 8;
    public static final int CAP_SIGMESH = 32768;
    public static final int CAP_WIFI = 1;
    public static final int CAP_ZIGBEE = 4096;
    public long attribute;
    public int capability;
    public String category;
    public long i18nTime;
    public String id;
    public String meshCategory;
    public Map<String, Object> panelConfig;
    public long resptime;
    public SchemaInfo schemaInfo;
    public ShortCutBean shortcut;
    public boolean supportGroup;
    public UiInfo uiInfo;

    public static class SchemaInfo {
        public String schema;
        public String schemaExt;
        public Map<String, SchemaBean> schemaMap = new HashMap();

        public void buildSchema() {
            if (!TextUtils.isEmpty(this.schema)) {
                for (SchemaBean next : JSON.parseArray(this.schema, SchemaBean.class)) {
                    if (next.getType().equals(DataTypeEnum.OBJ.getType())) {
                        next.setSchemaType(JSON.parseObject(next.getProperty()).getString("type"));
                    }
                    this.schemaMap.put(next.getId(), next);
                }
            }
        }

        public String getSchema() {
            return this.schema;
        }

        public String getSchemaExt() {
            return this.schemaExt;
        }

        public Map<String, SchemaBean> getSchemaMap() {
            buildSchema();
            return this.schemaMap;
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
    }

    public long getAttribute() {
        return this.attribute;
    }

    public int getCapability() {
        return this.capability;
    }

    public String getCategory() {
        return this.category;
    }

    public long getI18nTime() {
        return this.i18nTime;
    }

    public String getId() {
        return this.id;
    }

    public Object getKey() {
        return this.id;
    }

    public String getMeshCategory() {
        return this.meshCategory;
    }

    public Map<String, Object> getPanelConfig() {
        return this.panelConfig;
    }

    public long getResptime() {
        return this.resptime;
    }

    public SchemaInfo getSchemaInfo() {
        return this.schemaInfo;
    }

    public ShortCutBean getShortcut() {
        return this.shortcut;
    }

    public UiInfo getUiInfo() {
        return this.uiInfo;
    }

    public boolean has433() {
        return (this.capability & 16384) > 0;
    }

    public boolean hasBleMesh() {
        return hasBlueMesh() || hasSigMesh();
    }

    public boolean hasBlueMesh() {
        return (this.capability & 2048) > 0;
    }

    public boolean hasBluetooth() {
        return (this.capability & 1024) > 0;
    }

    public boolean hasInfrared() {
        return (this.capability & 8192) > 0;
    }

    public boolean hasSigMesh() {
        return (this.capability & 32768) > 0;
    }

    public boolean hasWifi() {
        return (this.capability & 1) > 0;
    }

    public boolean hasZigBee() {
        return (this.capability & 4096) > 0;
    }

    public boolean isInfraredSubDevDisplayInList() {
        return (this.attribute & 33554432) > 0;
    }

    public boolean isSupportGroup() {
        return this.supportGroup;
    }

    public boolean isWifi() {
        return this.capability == 1;
    }

    public void setAttribute(long j) {
        this.attribute = j;
    }

    public void setCapability(int i) {
        this.capability = i;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setI18nTime(long j) {
        this.i18nTime = j;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMeshCategory(String str) {
        this.meshCategory = str;
    }

    public void setPanelConfig(Map<String, Object> map) {
        this.panelConfig = map;
    }

    public void setResptime(long j) {
        this.resptime = j;
    }

    public void setSchemaInfo(SchemaInfo schemaInfo2) {
        this.schemaInfo = schemaInfo2;
    }

    public void setShortcut(ShortCutBean shortCutBean) {
        this.shortcut = shortCutBean;
    }

    public void setSupportGroup(boolean z) {
        this.supportGroup = z;
    }

    public void setUiInfo(UiInfo uiInfo2) {
        this.uiInfo = uiInfo2;
    }
}
