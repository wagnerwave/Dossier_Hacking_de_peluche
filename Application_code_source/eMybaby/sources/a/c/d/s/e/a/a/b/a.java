package a.c.d.s.e.a.a.b;

import a.c.a.g.c;
import com.sozpic.miniland.R;
import com.tuya.smart.android.network.http.BusinessResponse;
import org.json.JSONObject;

public class a extends c {
    public a() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.c.a.d.a.h(R.string.TR_DELETE_ENTRADA_DIARIO_KO);
    }

    public a(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.getBoolean(BusinessResponse.KEY_RESULT));
        this.f43b = a.c.a.d.a.h(R.string.TR_DELETE_ENTRADA_DIARIO_KO);
    }
}
