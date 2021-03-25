package a.d.a.a.h.g;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class s1 implements v1 {

    /* renamed from: a  reason: collision with root package name */
    public final p1 f1927a;

    public s1(p1 p1Var) {
        this.f1927a = p1Var;
    }

    /* JADX INFO: finally extract failed */
    public final Object a() {
        p1 p1Var = this.f1927a;
        Cursor query = p1Var.f1876a.query(p1Var.f1877b, p1.h, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                Map emptyMap = Collections.emptyMap();
                query.close();
                return emptyMap;
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                arrayMap.put(query.getString(0), query.getString(1));
            }
            query.close();
            return arrayMap;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}
