package a.c.d.s.e.a.a.a;

import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public long f890c;

    public a() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_ADDING_ENTRADA_DIARIO);
    }

    public a(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.has("idEntrada"));
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_ADDING_ENTRADA_DIARIO);
        this.f890c = jSONObject.optLong("idEntrada", -1);
    }
}
