package a.c.d.s.e.a.c.c;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public long f949c;

    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_ECOGRAFIA);
    }

    public b(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("idEcografia", -1);
        this.f949c = optLong;
        this.f42a = Boolean.valueOf(optLong != -1);
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_ECOGRAFIA);
    }
}
