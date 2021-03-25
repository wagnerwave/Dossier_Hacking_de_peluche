package com.tuya.smart.home.sdk.bean.scene;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tuya.smart.android.device.bean.ValueSchemaBean;
import java.io.Serializable;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class FunctionDataPoint implements Serializable {
    public static final long serialVersionUID = -3333929182000764941L;
    public int colorType;
    public Object defaultValue;
    public String dpCode;
    public int dpId;
    public String dpName;
    public String dpProperty;
    public boolean editable;
    public String mode;
    public LinkedHashMap<Object, String> tasks;
    public String valueRangeDisplay;
    public String valueRangeJson;
    public String valueType;

    public int getColorType() {
        return this.colorType;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public String getDpCode() {
        return this.dpCode;
    }

    public int getDpId() {
        return this.dpId;
    }

    public String getDpName() {
        return this.dpName;
    }

    public String getDpProperty() {
        return this.dpProperty;
    }

    public String getMode() {
        return this.mode;
    }

    public LinkedHashMap<Object, String> getTasks() {
        if (this.tasks == null) {
            this.tasks = new LinkedHashMap<>();
            JSONArray<Object> parseArray = JSON.parseArray(this.valueRangeJson);
            if (parseArray != null && !parseArray.isEmpty()) {
                for (Object obj : parseArray) {
                    JSONArray parseArray2 = JSON.parseArray(obj.toString());
                    this.tasks.put(parseArray2.get(0), parseArray2.get(1).toString());
                }
            }
        }
        return this.tasks;
    }

    public String getType() {
        try {
            return new JSONObject(getDpProperty()).getString("type");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "value";
        }
    }

    public String getValueRangeDisplay() {
        return this.valueRangeDisplay;
    }

    public String getValueRangeJson() {
        return this.valueRangeJson;
    }

    public ValueSchemaBean getValueSceheamData() {
        return (ValueSchemaBean) JSON.parseObject(this.dpProperty, ValueSchemaBean.class);
    }

    public String getValueType() {
        return this.valueType;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public void setColorType(int i) {
        this.colorType = i;
    }

    public void setDefaultValue(Object obj) {
        this.defaultValue = obj;
    }

    public void setDpCode(String str) {
        this.dpCode = str;
    }

    public void setDpId(int i) {
        this.dpId = i;
    }

    public void setDpName(String str) {
        this.dpName = str;
    }

    public void setDpProperty(String str) {
        this.dpProperty = str;
    }

    public void setEditable(boolean z) {
        this.editable = z;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setValueRangeDisplay(String str) {
        this.valueRangeDisplay = str;
    }

    public void setValueRangeJson(String str) {
        this.valueRangeJson = str;
    }

    public void setValueType(String str) {
        this.valueType = str;
    }
}
