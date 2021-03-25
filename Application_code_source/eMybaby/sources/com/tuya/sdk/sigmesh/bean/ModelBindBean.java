package com.tuya.sdk.sigmesh.bean;

import com.tuya.smart.common.o000o0oooo;

public class ModelBindBean {
    public int meshAddress;
    public o000o0oooo meshModel;
    public int modelId;

    public ModelBindBean(int i, int i2, o000o0oooo o000o0oooo) {
        this.meshAddress = i;
        this.modelId = i2;
        this.meshModel = o000o0oooo;
    }

    public int getMeshAddress() {
        return this.meshAddress;
    }

    public o000o0oooo getMeshModel() {
        return this.meshModel;
    }

    public int getModelId() {
        return this.modelId;
    }

    public void setMeshAddress(int i) {
        this.meshAddress = i;
    }

    public void setMeshModel(o000o0oooo o000o0oooo) {
        this.meshModel = o000o0oooo;
    }

    public void setModelId(int i) {
        this.modelId = i;
    }
}
