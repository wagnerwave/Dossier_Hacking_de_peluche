package a.c.d.s.e.d.c.c;

import a.c.a.g.b;
import a.c.d.r.i;
import a.c.d.r.j;
import androidx.appcompat.widget.ActivityChooserModel;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;
import java.text.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f1029a;

    public b a(String str) {
        this.f1029a = new b();
        if (str.equals("null")) {
            this.f1029a.f42a = Boolean.TRUE;
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    MeasurePregnancyMama measurePregnancyMama = new MeasurePregnancyMama();
                    measurePregnancyMama.setValue((float) optJSONObject.optInt(ActivityChooserModel.ATTRIBUTE_WEIGHT, -1));
                    measurePregnancyMama.setIdCrecimiento(Long.valueOf(optJSONObject.optLong("id", -1)));
                    measurePregnancyMama.setStringDate(optJSONObject.optString("date", ""));
                    measurePregnancyMama.setDate(j.j.parse(optJSONObject.optString("date", "")));
                    measurePregnancyMama.setTitle(i.d(measurePregnancyMama.getDate()));
                    b bVar = this.f1029a;
                    if (bVar != null) {
                        bVar.f1028c.add(measurePregnancyMama);
                        i++;
                    } else {
                        throw null;
                    }
                }
                this.f1029a.f42a = Boolean.TRUE;
            } catch (JSONException e2) {
                b bVar2 = this.f1029a;
                bVar2.f42a = Boolean.FALSE;
                bVar2.f43b = e2.getMessage();
                e2.printStackTrace();
            } catch (ParseException e3) {
                e3.printStackTrace();
                b bVar3 = this.f1029a;
                bVar3.f42a = Boolean.FALSE;
                bVar3.f43b = e3.getMessage();
            }
        }
        return this.f1029a;
    }
}
