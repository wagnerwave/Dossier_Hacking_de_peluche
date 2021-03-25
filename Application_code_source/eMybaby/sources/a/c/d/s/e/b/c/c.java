package a.c.d.s.e.b.c;

import a.c.a.d.a;
import a.c.a.f.e;
import com.cuatroochenta.miniland.model.Contraction;
import com.sozpic.miniland.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends a.c.a.g.c {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Contraction> f974c = new ArrayList<>();

    public c() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_RETRIEVING_CONTRACTIONS);
    }

    public c(JSONArray jSONArray) {
        this.f43b = a.h(R.string.TR_ERROR_RETRIEVING_CONTRACTIONS);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            try {
                this.f974c.add(new Contraction(jSONObject));
            } catch (Exception unused) {
                StringBuilder n = a.a.a.a.a.n("Contraction skipped -->");
                n.append(jSONObject.toString());
                e.e(n.toString());
            }
        }
        this.f42a = Boolean.TRUE;
    }
}
