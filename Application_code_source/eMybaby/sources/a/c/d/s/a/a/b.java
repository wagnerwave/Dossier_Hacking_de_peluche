package a.c.d.s.a.a;

import com.cuatroochenta.miniland.model.SongCategory;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends a.c.a.g.b {

    /* renamed from: a  reason: collision with root package name */
    public a f818a;

    public a a(JSONObject jSONObject) {
        try {
            a aVar = new a();
            this.f818a = aVar;
            aVar.f42a = Boolean.FALSE;
            if (jSONObject.has("helpImagesAndroid")) {
                JSONArray jSONArray = jSONObject.getJSONArray("helpImagesAndroid");
                for (int i = 0; i < jSONArray.length(); i++) {
                    a aVar2 = this.f818a;
                    aVar2.f816c.add(jSONArray.getString(i));
                }
            }
            if (jSONObject.has("categories")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("categories");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    a aVar3 = this.f818a;
                    aVar3.f817d.add(new SongCategory(jSONObject2));
                }
            }
            this.f818a.f42a = Boolean.TRUE;
            return this.f818a;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
