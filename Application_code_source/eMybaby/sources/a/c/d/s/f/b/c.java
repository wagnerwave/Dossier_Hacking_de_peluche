package a.c.d.s.f.b;

import a.c.a.g.b;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.mqtt.MqttServiceConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f1141a;

    public b a(JSONObject jSONObject) {
        b bVar = new b();
        this.f1141a = bVar;
        bVar.f42a = Boolean.FALSE;
        try {
            this.f1141a.f42a = Boolean.valueOf(Boolean.TRUE.equals(Boolean.valueOf(jSONObject.getBoolean(BusinessResponse.KEY_RESULT))));
            this.f1141a.f43b = jSONObject.has(MqttServiceConstants.TRACE_ERROR) ? jSONObject.getString(MqttServiceConstants.TRACE_ERROR) : "";
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f1141a.f42a = Boolean.FALSE;
        }
        return this.f1141a;
    }
}
