package a.c.d.s.e.c;

import a.c.a.g.c;
import com.tuya.smart.android.network.http.BusinessResponse;
import org.json.JSONObject;

public class b extends c {
    public b() {
        this.f42a = Boolean.FALSE;
    }

    public b(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.optBoolean(BusinessResponse.KEY_RESULT));
    }
}
