package a.c.d.s.e.d.a.c;

import a.c.a.g.b;
import a.c.d.r.i;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f989a;

    public b a(String str) {
        this.f989a = new b();
        if (str.equals("null")) {
            this.f989a.f42a = Boolean.TRUE;
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    MeasureWithTwoValues measureWithTwoValues = new MeasureWithTwoValues(optJSONObject.optLong("id", -1), Integer.valueOf(optJSONObject.optInt("sistolica", -1)), Integer.valueOf(optJSONObject.optInt("distolica", -1)), optJSONObject.optString(NotificationCompatJellybean.KEY_TITLE, ""), optJSONObject.optString("date", ""));
                    measureWithTwoValues.setTitle(i.d(new Date(measureWithTwoValues.getDate().longValue())));
                    b bVar = this.f989a;
                    if (bVar != null) {
                        bVar.f988c.add(measureWithTwoValues);
                        i++;
                    } else {
                        throw null;
                    }
                }
                this.f989a.f42a = Boolean.TRUE;
            } catch (JSONException e2) {
                b bVar2 = this.f989a;
                bVar2.f42a = Boolean.FALSE;
                bVar2.f43b = e2.getMessage();
                e2.printStackTrace();
            }
        }
        return this.f989a;
    }
}
