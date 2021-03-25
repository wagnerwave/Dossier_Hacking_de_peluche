package e.a.a.j0;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class b extends a implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f5174a = new HashMap();

    public Object clone() {
        b bVar = (b) super.clone();
        for (Map.Entry entry : this.f5174a.entrySet()) {
            if (entry.getKey() instanceof String) {
                bVar.setParameter((String) entry.getKey(), entry.getValue());
            }
        }
        return bVar;
    }

    public Object e(String str) {
        return this.f5174a.get(str);
    }

    public c setParameter(String str, Object obj) {
        this.f5174a.put(str, obj);
        return this;
    }
}
