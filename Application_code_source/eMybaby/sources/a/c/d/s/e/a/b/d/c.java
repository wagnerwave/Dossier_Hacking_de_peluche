package a.c.d.s.e.a.b.d;

import a.c.a.g.b;
import a.c.d.r.i;
import a.c.d.r.j;
import com.cuatroochenta.miniland.model.MedicalDataEntry;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f931a;

    public final void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                MedicalDataEntry medicalDataEntry = new MedicalDataEntry();
                medicalDataEntry.setId(optJSONObject.optLong("id"));
                medicalDataEntry.setDate(j.j.parse(optJSONObject.optString("date")));
                medicalDataEntry.setTitle(i.b(medicalDataEntry.getDate()));
                medicalDataEntry.setFL((float) optJSONObject.optDouble("fl"));
                medicalDataEntry.setHC((float) optJSONObject.optDouble("hc"));
                medicalDataEntry.setAC((float) optJSONObject.optDouble("ac"));
                medicalDataEntry.setEFW(optJSONObject.optInt("efw"));
                linkedList.add(medicalDataEntry);
            }
            this.f931a.f930c = linkedList;
            this.f931a.f42a = Boolean.TRUE;
        } catch (JSONException e2) {
            b bVar = this.f931a;
            bVar.f42a = Boolean.FALSE;
            bVar.f43b = e2.getMessage();
            e2.printStackTrace();
        }
    }
}
