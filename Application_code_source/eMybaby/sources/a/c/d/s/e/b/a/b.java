package a.c.d.s.e.b.a;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {
    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_CONTRACCION);
    }

    public b(JSONObject jSONObject) {
        this.f42a = Boolean.valueOf(jSONObject.has("idContraccion"));
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_CONTRACCION);
    }
}
