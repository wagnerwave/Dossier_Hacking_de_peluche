package a.c.d.s.e.e.b;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import com.tuya.smart.android.network.http.BusinessResponse;
import org.json.JSONObject;

public class b extends c {
    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_BORRAR_CITA_MEDICA);
    }

    public b(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.optBoolean(BusinessResponse.KEY_RESULT));
    }
}
