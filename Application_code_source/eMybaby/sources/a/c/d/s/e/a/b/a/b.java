package a.c.d.s.e.a.b.a;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public long f916c;

    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_DATOS_MEDICOS);
    }

    public b(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.has("idDatoMedico"));
        this.f916c = jSONObject.optLong("idDatoMedico", -1);
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_DATOS_MEDICOS);
    }
}
