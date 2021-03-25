package a.c.d.s.e.e.c;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {
    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_CITA_MEDICA);
    }

    public b(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.has("idCitaMedica"));
        jSONObject.optLong("idCitaMedica", -1);
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_CITA_MEDICA);
    }
}
