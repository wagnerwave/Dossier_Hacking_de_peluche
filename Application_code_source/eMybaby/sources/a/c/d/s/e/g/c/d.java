package a.c.d.s.e.g.c;

import a.c.a.g.b;
import com.tuya.smart.mqtt.MqttServiceConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public c f1128a;

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f1128a.f1126a = jSONObject.has("idSonido") && !jSONObject.isNull("idSonido");
            this.f1128a.f1127b = jSONObject.has(MqttServiceConstants.TRACE_ERROR) ? jSONObject.getString(MqttServiceConstants.TRACE_ERROR) : "";
            if (!this.f1128a.f1126a) {
                return;
            }
            if (this.f1128a == null) {
                throw null;
            }
        } catch (JSONException e2) {
            this.f1128a.f1126a = false;
            e2.printStackTrace();
        }
    }
}
