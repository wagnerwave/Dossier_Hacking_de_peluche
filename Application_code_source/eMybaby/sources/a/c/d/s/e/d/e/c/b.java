package a.c.d.s.e.d.e.c;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public Long f1075c;

    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_PESO);
    }

    public b(JSONObject jSONObject) {
        Long valueOf = Long.valueOf(jSONObject.optLong("idPeso", -1));
        this.f1075c = valueOf;
        this.f42a = Boolean.valueOf(valueOf.longValue() != -1);
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_PESO);
    }
}
