package a.c.d.s.c;

import a.c.d.r.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends a.c.a.g.b {

    /* renamed from: a  reason: collision with root package name */
    public a f881a;

    public a a(JSONObject jSONObject) {
        try {
            a aVar = new a();
            this.f881a = aVar;
            aVar.f42a = Boolean.FALSE;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.get(next) instanceof JSONArray) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    a.f781d.f784c.put(next, arrayList);
                }
            }
            this.f881a.f42a = Boolean.TRUE;
            return this.f881a;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
