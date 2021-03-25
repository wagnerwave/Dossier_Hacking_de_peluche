package com.tuya.smart.interior.config.bean;

import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import java.util.ArrayList;

public class ConfigDevResp {
    public ArrayList<ConfigErrorRespBean> errorDevices;
    public ArrayList<GwDevResp> successDevices;

    public ArrayList<ConfigErrorRespBean> getErrorDevices() {
        return this.errorDevices;
    }

    public ArrayList<GwDevResp> getSuccessDevices() {
        return this.successDevices;
    }

    public void setErrorDevices(ArrayList<ConfigErrorRespBean> arrayList) {
        this.errorDevices = arrayList;
    }

    public void setSuccessDevices(ArrayList<GwDevResp> arrayList) {
        this.successDevices = arrayList;
    }
}
