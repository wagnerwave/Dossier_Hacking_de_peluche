package a.c.d.s.e.g.a;

import a.c.a.g.c;
import com.tuya.smart.android.network.http.BusinessResponse;
import org.json.JSONObject;

public class b extends c {
    public b() {
        this.f42a = Boolean.FALSE;
    }

    public b(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.getBoolean(BusinessResponse.KEY_RESULT));
    }

    public b(boolean z) {
        this.f42a = Boolean.valueOf(z);
    }
}
