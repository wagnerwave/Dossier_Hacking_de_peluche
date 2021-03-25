package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;
import java.util.List;

public class FunctionListBean implements Serializable {
    public static final String FUNCTION_CODE_COLOR = "color_light";
    public static final String FUNCTION_CODE_WHITE = "white_light";
    public static final long serialVersionUID = 6507727761794458588L;
    public List<FunctionDataPoint> dataPoints;
    public String functionCode;
    public String functionName;
    public int functionType;
    public int id;
    public String productId;
    public int status;

    public List<FunctionDataPoint> getDataPoints() {
        return this.dataPoints;
    }

    public String getFunctionCode() {
        return this.functionCode;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public int getFunctionType() {
        return this.functionType;
    }

    public int getId() {
        return this.id;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDataPoints(List<FunctionDataPoint> list) {
        this.dataPoints = list;
    }

    public void setFunctionCode(String str) {
        this.functionCode = str;
    }

    public void setFunctionName(String str) {
        this.functionName = str;
    }

    public void setFunctionType(int i) {
        this.functionType = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
