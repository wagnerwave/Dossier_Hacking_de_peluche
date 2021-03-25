package a.c.d.s.a.c.c;

import a.c.a.g.b;
import com.cuatroochenta.miniland.model.Song;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.mqtt.MqttServiceConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public c f850a;

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f850a.f847a = Boolean.TRUE.equals(Boolean.valueOf(jSONObject.getBoolean(BusinessResponse.KEY_RESULT)));
            this.f850a.f848b = jSONObject.has(MqttServiceConstants.TRACE_ERROR) ? jSONObject.getString(MqttServiceConstants.TRACE_ERROR) : "";
            if (jSONObject.has("song")) {
                this.f850a.f849c = new Song(jSONObject.getJSONObject("song"));
            }
        } catch (JSONException e2) {
            this.f850a.f847a = false;
            e2.printStackTrace();
        }
    }
}
