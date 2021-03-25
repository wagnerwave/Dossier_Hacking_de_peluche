package a.c.d.s.e.d.a.d;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import com.tuya.smart.android.network.http.BusinessResponse;
import org.json.JSONObject;

public class b extends c {
    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_DELETE_MEDIDA_TENSION_KO);
    }

    public b(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.optBoolean(BusinessResponse.KEY_RESULT));
        this.f43b = a.h(R.string.TR_DELETE_MEDIDA_TENSION_KO);
    }
}
