package a.c.d.s.e.f.a;

import a.c.a.g.b;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.mqtt.MqttServiceConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public c f1104a;

    public c a(JSONObject jSONObject) {
        c cVar = new c();
        this.f1104a = cVar;
        cVar.f42a = Boolean.FALSE;
        try {
            this.f1104a.f42a = Boolean.valueOf(Boolean.TRUE.equals(Boolean.valueOf(jSONObject.getBoolean(BusinessResponse.KEY_RESULT))));
            this.f1104a.f43b = jSONObject.has(MqttServiceConstants.TRACE_ERROR) ? jSONObject.getString(MqttServiceConstants.TRACE_ERROR) : "";
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f1104a.f42a = Boolean.FALSE;
        }
        return this.f1104a;
    }
}
