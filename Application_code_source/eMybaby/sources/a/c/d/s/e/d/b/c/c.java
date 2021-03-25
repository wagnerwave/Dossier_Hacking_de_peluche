package a.c.d.s.e.d.b.c;

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
    public b f1009a;

    public b a(String str) {
        this.f1009a = new b();
        if (str.equals("null")) {
            this.f1009a.f42a = Boolean.TRUE;
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    long optLong = optJSONObject.optLong("id", -1);
                    boolean z = true;
                    Boolean valueOf = Boolean.valueOf(optJSONObject.optInt("active1", 0) != 0);
                    if (optJSONObject.optInt("active2", 0) == 0) {
                        z = false;
                    }
                    MeasureWithTwoValues measureWithTwoValues = new MeasureWithTwoValues(optLong, valueOf, Boolean.valueOf(z), optJSONObject.optString(NotificationCompatJellybean.KEY_TITLE, ""), optJSONObject.optString("date", ""));
                    measureWithTwoValues.setTitle(i.d(new Date(measureWithTwoValues.getDate().longValue())));
                    b bVar = this.f1009a;
                    if (bVar != null) {
                        bVar.f1008c.add(measureWithTwoValues);
                        i++;
                    } else {
                        throw null;
                    }
                }
                this.f1009a.f42a = Boolean.TRUE;
            } catch (JSONException e2) {
                b bVar2 = this.f1009a;
                bVar2.f42a = Boolean.FALSE;
                bVar2.f43b = e2.getMessage();
                e2.printStackTrace();
            }
        }
        return this.f1009a;
    }
}
