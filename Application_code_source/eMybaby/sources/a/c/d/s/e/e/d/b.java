package a.c.d.s.e.e.d;

import com.cuatroochenta.miniland.model.MedicalAppointment;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

public class b extends a.c.a.g.b {

    /* renamed from: a  reason: collision with root package name */
    public d f1098a;

    public final void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(new MedicalAppointment(jSONArray.getJSONObject(i)));
            }
            this.f1098a.f42a = Boolean.TRUE;
            this.f1098a.f1102c = linkedList;
        } catch (JSONException e2) {
            this.f1098a.f1102c = new LinkedList();
            d dVar = this.f1098a;
            dVar.f42a = Boolean.FALSE;
            dVar.f43b = e2.getMessage();
            e2.printStackTrace();
        }
    }
}
