package a.c.d.s.e.a.a.d;

import a.c.a.g.c;
import a.c.d.r.i;
import a.c.d.r.j;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.sozpic.miniland.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<BabyDiaryEntry> f912c;

    public a() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_ENTRADAS_DIARIO);
    }

    public a(JSONArray jSONArray) {
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_ENTRADAS_DIARIO);
        this.f912c = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            optJSONObject.optInt("numWeek");
            JSONArray optJSONArray = optJSONObject.optJSONArray("entries");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                BabyDiaryEntry babyDiaryEntry = new BabyDiaryEntry();
                babyDiaryEntry.setId(optJSONObject2.optLong("id"));
                babyDiaryEntry.setTitle(optJSONObject2.optString(NotificationCompatJellybean.KEY_TITLE));
                babyDiaryEntry.setDate(j.f.parse(optJSONObject2.optString("date")));
                babyDiaryEntry.setBody(optJSONObject2.optString("entryDescription"));
                babyDiaryEntry.setPhotoPath(optJSONObject2.optString("url"));
                if (babyDiaryEntry.getPhotoPath().equals("https://emybaby.com/embarazo/")) {
                    babyDiaryEntry.setPhotoPath((String) null);
                }
                babyDiaryEntry.setWeek((int) i.c(babyDiaryEntry.getDate()));
                this.f912c.add(babyDiaryEntry);
            }
        }
        this.f42a = Boolean.TRUE;
    }
}
