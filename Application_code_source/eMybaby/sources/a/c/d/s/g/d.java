package a.c.d.s.g;

import a.c.a.g.b;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.mqtt.MqttServiceConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public c f1151a;

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f1151a.f1149a = Boolean.TRUE.equals(Boolean.valueOf(jSONObject.getBoolean(BusinessResponse.KEY_RESULT)));
            this.f1151a.f1150b = jSONObject.has(MqttServiceConstants.TRACE_ERROR) ? jSONObject.getString(MqttServiceConstants.TRACE_ERROR) : "";
        } catch (JSONException e2) {
            this.f1151a.f1149a = false;
            e2.printStackTrace();
        }
    }
}
