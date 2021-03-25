package a.c.d.s.e.a.c.d;

import a.c.a.g.b;
import a.c.d.r.j;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public b f959a;

    public final void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            LinkedList<UltrasoundPhoto> linkedList = new LinkedList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UltrasoundPhoto ultrasoundPhoto = new UltrasoundPhoto();
                ultrasoundPhoto.setId(jSONObject.getLong("id"));
                ultrasoundPhoto.setTitle(jSONObject.getString(NotificationCompatJellybean.KEY_TITLE));
                ultrasoundPhoto.setDate(j.j.parse(jSONObject.getString("date")));
                ultrasoundPhoto.setPhotoPath(jSONObject.getString("url"));
                ultrasoundPhoto.setDescription(jSONObject.getString("descripcion"));
                linkedList.add(ultrasoundPhoto);
            }
            this.f959a.f42a = Boolean.TRUE;
            this.f959a.f958c = linkedList;
        } catch (JSONException e2) {
            b bVar = this.f959a;
            bVar.f42a = Boolean.FALSE;
            bVar.f43b = e2.getMessage();
            e2.printStackTrace();
        }
    }
}
