package a.c.d.s.e.d.d.a;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public Long f1038c;

    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_MI_TRIPITA);
    }

    public b(JSONObject jSONObject) {
        this.f1038c = Long.valueOf(jSONObject.optLong("idMiTripita", -1));
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_MI_TRIPITA);
    }
}
