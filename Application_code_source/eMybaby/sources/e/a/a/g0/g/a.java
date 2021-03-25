package e.a.a.g0.g;

import e.a.a.b0.j;
import e.a.a.c0.b;
import e.a.a.k0.c;
import e.a.a.o;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f4974b = Collections.unmodifiableList(Arrays.asList(new String[]{"negotiate", "NTLM", "Digest", "Basic"}));

    /* renamed from: a  reason: collision with root package name */
    public final Log f4975a = LogFactory.getLog(getClass());

    public List<String> c(o oVar, c cVar) {
        return f4974b;
    }

    public Map<String, e.a.a.c> d(e.a.a.c[] cVarArr) {
        e.a.a.l0.b bVar;
        int i;
        HashMap hashMap = new HashMap(cVarArr.length);
        for (e.a.a.b bVar2 : cVarArr) {
            if (bVar2 instanceof e.a.a.b) {
                e.a.a.b bVar3 = bVar2;
                bVar = bVar3.b();
                i = bVar3.d();
            } else {
                String value = bVar2.getValue();
                if (value != null) {
                    bVar = new e.a.a.l0.b(value.length());
                    bVar.b(value);
                    i = 0;
                } else {
                    throw new j("Header value is null");
                }
            }
            while (i < bVar.f5184b && a.e.a.a.r.b.N(bVar.f5183a[i])) {
                i++;
            }
            int i2 = i;
            while (i2 < bVar.f5184b && !a.e.a.a.r.b.N(bVar.f5183a[i2])) {
                i2++;
            }
            hashMap.put(bVar.h(i, i2).toLowerCase(Locale.ENGLISH), bVar2);
        }
        return hashMap;
    }
}
