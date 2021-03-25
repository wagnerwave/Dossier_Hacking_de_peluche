package a.c.d.s.e.d.d.b;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public long f1047c;

    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_TRIPITA);
    }

    public b(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("idMyBelly", -1);
        this.f1047c = optLong;
        this.f42a = Boolean.valueOf(optLong != -1);
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_TRIPITA);
    }
}
