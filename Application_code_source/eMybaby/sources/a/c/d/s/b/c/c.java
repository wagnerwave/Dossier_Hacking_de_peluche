package a.c.d.s.b.c;

import a.c.a.f.e;
import a.c.a.g.b;
import a.c.d.a;
import com.cuatroochenta.miniland.model.Measure;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f876a;

    public final void a(String str) {
        Double d2;
        float floatValue;
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Measure measure = new Measure();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Long valueOf = Long.valueOf(jSONObject.getLong("idPeso"));
                String string = jSONObject.getString("fecharevision");
                try {
                    d2 = Double.valueOf(jSONObject.getDouble("peso"));
                } catch (JSONException unused) {
                    d2 = Double.valueOf(0.0d);
                }
                measure.setIdCrecimiento(valueOf);
                measure.setStringDate(string);
                int o = a.l().o();
                if (o != -1) {
                    measure.setUnit(o);
                    floatValue = Measure.convertValueToUnit(d2.floatValue(), 0, o);
                } else {
                    measure.setUnit(0);
                    floatValue = d2.floatValue();
                }
                measure.setValue(floatValue);
                e.b("Measure received from server -> " + d2.floatValue() + "KG");
                e.b(String.format("Measure converted -> %s", new Object[]{measure.toString()}));
                this.f876a.f875c.add(measure);
            }
            this.f876a.f42a = Boolean.TRUE;
        } catch (JSONException e2) {
            b bVar = this.f876a;
            bVar.f42a = Boolean.FALSE;
            bVar.f43b = e2.getMessage();
            e2.printStackTrace();
        }
    }
}
