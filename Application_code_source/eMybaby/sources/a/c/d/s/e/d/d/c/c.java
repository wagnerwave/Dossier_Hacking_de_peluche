package a.c.d.s.e.d.d.c;

import a.c.a.g.b;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.model.MyBellyData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f1057a;

    public b a(String str) {
        this.f1057a = new b();
        if (str.equals("null")) {
            this.f1057a.f42a = Boolean.TRUE;
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    MyBellyData myBellyData = new MyBellyData(Long.valueOf(optJSONObject.optLong("id", -1)), optJSONObject.optString(NotificationCompatJellybean.KEY_TITLE, ""), optJSONObject.optString("descripcion", ""), optJSONObject.optString("date", ""), optJSONObject.optString("url", ""));
                    b bVar = this.f1057a;
                    if (bVar != null) {
                        bVar.f1056c.add(myBellyData);
                        i++;
                    } else {
                        throw null;
                    }
                }
                this.f1057a.f42a = Boolean.TRUE;
            } catch (JSONException e2) {
                b bVar2 = this.f1057a;
                bVar2.f42a = Boolean.FALSE;
                bVar2.f43b = e2.getMessage();
                e2.printStackTrace();
            }
        }
        return this.f1057a;
    }
}
