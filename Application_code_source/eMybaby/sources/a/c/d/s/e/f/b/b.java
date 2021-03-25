package a.c.d.s.e.f.b;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public String f1109c;

    public b(String str) {
        this.f43b = a.h(R.string.TR_ERROR_RETRIEVING_FECHA_PARTO);
        if (str != null && !str.isEmpty()) {
            try {
                String string = new JSONObject(str).getString("expectedBirthday");
                if (!"00-00-0000".equals(string)) {
                    this.f1109c = string;
                    this.f42a = Boolean.TRUE;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f42a = Boolean.FALSE;
                this.f43b = a.h(R.string.TR_ERROR_RETRIEVING_FECHA_PARTO);
            }
        }
    }
}
