package com.cuatroochenta.miniland.model;

import com.tuya.smart.android.network.http.BusinessResponse;
import org.json.JSONObject;

public class AddCameraResult {
    public String error;
    public String idCamera;
    public boolean success;

    public AddCameraResult() {
        this.success = false;
    }

    public AddCameraResult(JSONObject jSONObject) {
        this.success = "success".equalsIgnoreCase(jSONObject.optString(BusinessResponse.KEY_RESULT));
        this.error = jSONObject.optString("message");
        this.idCamera = jSONObject.optString("idCamara");
    }

    public String getError() {
        return this.error;
    }

    public String getIdCamera() {
        return this.idCamera;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setIdCamera(String str) {
        this.idCamera = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
