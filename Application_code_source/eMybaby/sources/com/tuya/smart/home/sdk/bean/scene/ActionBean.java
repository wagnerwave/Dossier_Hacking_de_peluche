package com.tuya.smart.home.sdk.bean.scene;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.bean.ValueSchemaBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionBean implements Serializable {
    public static final long serialVersionUID = 4808799797309683848L;
    public String actDetail;
    public Object chooseKey;
    public long dpId;
    public long id;
    public String name;
    public List<String> operators;
    public List<Object> rangeKeys = new ArrayList();
    public List<String> rangeValues = new ArrayList();
    public String type;

    public ActionBean() {
    }

    public ActionBean(ActRespBean actRespBean) {
        setName(actRespBean.getDpName());
        setId(actRespBean.getId());
        setDpId(actRespBean.getDpId());
        this.actDetail = actRespBean.getActDetail();
        JSONArray<Object> parseArray = JSON.parseArray(actRespBean.getValueRangeJson());
        if (parseArray != null && !parseArray.isEmpty()) {
            for (Object obj : parseArray) {
                JSONArray parseArray2 = JSON.parseArray(obj.toString());
                this.rangeKeys.add(parseArray2.get(0));
                this.rangeValues.add(parseArray2.get(1).toString());
            }
        }
        try {
            setType(new JSONObject(getSchema().getProperty()).getString("type"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public String getActDetail() {
        return this.actDetail;
    }

    public Object getChooseKey() {
        return this.chooseKey;
    }

    public String getChooseRangeValue() {
        if ("value".equals(getType())) {
            Object obj = this.chooseKey;
            return obj != null ? String.valueOf(obj) : "";
        } else if (this.chooseKey == null) {
            return "";
        } else {
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= this.rangeKeys.size()) {
                    break;
                } else if (String.valueOf(this.chooseKey).equals(String.valueOf(this.rangeKeys.get(i2)))) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            return (i < 0 || i > this.rangeValues.size()) ? "" : this.rangeValues.get(i);
        }
    }

    public long getDpId() {
        return this.dpId;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOperators() {
        return this.operators;
    }

    public List<Object> getRangeKeys() {
        return this.rangeKeys;
    }

    public List<String> getRangeValues() {
        return this.rangeValues;
    }

    public SchemaBean getSchema() {
        return (SchemaBean) JSON.parseObject(this.actDetail, SchemaBean.class);
    }

    public String getType() {
        return this.type;
    }

    public ValueSchemaBean getValueSceheamData() {
        return (ValueSchemaBean) JSON.parseObject(getSchema().getProperty(), ValueSchemaBean.class);
    }

    public String getValueUnit() {
        return !getType().equals("value") ? "" : getValueSceheamData().getUnit();
    }

    public void setActDetail(String str) {
        this.actDetail = str;
    }

    public void setChooseKey(Object obj) {
        this.chooseKey = obj;
    }

    public void setChooseKeyFromActions(String str) {
        try {
            setChooseKey(new JSONObject(str).get(String.valueOf(getDpId())));
        } catch (JSONException unused) {
        }
    }

    public void setDpId(long j) {
        this.dpId = j;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperators(List<String> list) {
        this.operators = list;
    }

    public void setRangeKeys(List<Object> list) {
        this.rangeKeys = list;
    }

    public void setRangeValues(List<String> list) {
        this.rangeValues = list;
    }

    public void setType(String str) {
        this.type = str;
    }
}
