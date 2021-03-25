package a.c.d.s.e.g.b;

import a.c.a.f.e;
import com.cuatroochenta.miniland.model.HeartBeatSound;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a.c.a.g.c {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<HeartBeatSound> f1120c;

    public c() {
        this.f42a = Boolean.FALSE;
    }

    public c(JSONArray jSONArray) {
        this.f1120c = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            try {
                this.f1120c.add(new HeartBeatSound(jSONObject));
            } catch (JSONException e2) {
                e2.printStackTrace();
                e.e("HeartSound skipped -->" + jSONObject.toString());
            }
        }
        this.f42a = Boolean.TRUE;
    }
}
