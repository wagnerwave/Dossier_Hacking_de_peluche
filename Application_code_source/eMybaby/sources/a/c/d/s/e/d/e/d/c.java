package a.c.d.s.e.d.e.d;

import a.c.a.g.b;
import a.c.d.a;
import a.c.d.r.i;
import a.c.d.r.j;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.model.Measure;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f1081a;

    public final void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int o = a.l().o();
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                MeasurePregnancyMama measurePregnancyMama = new MeasurePregnancyMama();
                Double valueOf = Double.valueOf(optJSONObject.optDouble(ActivityChooserModel.ATTRIBUTE_WEIGHT));
                measurePregnancyMama.setIdCrecimiento(Long.valueOf(optJSONObject.optLong("id", -1)));
                measurePregnancyMama.setStringDate(optJSONObject.optString(NotificationCompatJellybean.KEY_TITLE));
                measurePregnancyMama.setDate(j.j.parse(optJSONObject.optString("date")));
                measurePregnancyMama.setTitle(i.d(measurePregnancyMama.getDate()));
                if (o == -1) {
                    measurePregnancyMama.setUnit(0);
                } else {
                    measurePregnancyMama.setUnit(o);
                }
                measurePregnancyMama.setValue(Measure.convertValueToUnit(valueOf.floatValue(), 0, o));
                b bVar = this.f1081a;
                if (bVar != null) {
                    bVar.f1080c.add(measurePregnancyMama);
                    i++;
                } else {
                    throw null;
                }
            }
            this.f1081a.f42a = Boolean.TRUE;
        } catch (JSONException e2) {
            b bVar2 = this.f1081a;
            bVar2.f42a = Boolean.FALSE;
            bVar2.f43b = e2.getMessage();
            e2.printStackTrace();
        }
    }
}
