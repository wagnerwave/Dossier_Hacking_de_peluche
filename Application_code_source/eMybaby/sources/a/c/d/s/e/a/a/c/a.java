package a.c.d.s.e.a.a.c;

import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public long f903c;

    public a() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_EDITAR_ENTRADA);
    }

    public a(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("idEntrada", -1);
        this.f903c = optLong;
        this.f42a = Boolean.valueOf(optLong != -1);
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_EDITAR_ENTRADA);
    }
}
