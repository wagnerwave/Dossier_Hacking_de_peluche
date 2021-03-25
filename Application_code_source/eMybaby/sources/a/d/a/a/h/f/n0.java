package a.d.a.a.h.f;

import a.a.a.a.a;
import a.c.a.f.b;
import android.text.TextUtils;
import com.tuya.smart.common.o0ooo00oo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f1538a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1539b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1540c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1541d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1542e;
    public final String f = null;

    public n0(e eVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        boolean z2;
        String a2;
        String a3;
        b.k(eVar);
        b.k(map);
        this.f1540c = j;
        this.f1542e = z;
        this.f1539b = j2;
        this.f1541d = i;
        Collections.emptyList();
        TextUtils.isEmpty((CharSequence) null);
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            boolean z3 = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            Object key = next.getKey();
            if ((key != null ? key.toString().startsWith("&") : z3) && (a3 = a(eVar, next.getKey())) != null) {
                hashMap.put(a3, b(eVar, next.getValue()));
            }
        }
        for (Map.Entry next2 : map.entrySet()) {
            Object key2 = next2.getKey();
            if (key2 == null) {
                z2 = false;
            } else {
                z2 = key2.toString().startsWith("&");
            }
            if (!z2 && (a2 = a(eVar, next2.getKey())) != null) {
                hashMap.put(a2, b(eVar, next2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.f)) {
            String str = this.f;
            if (str != null && !hashMap.containsKey("_v")) {
                hashMap.put("_v", str);
            }
            if (this.f.equals("ma4.0.0") || this.f.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.f1538a = Collections.unmodifiableMap(hashMap);
    }

    public static String a(e eVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            eVar.f("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    public static String b(e eVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        eVar.f("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    public final String toString() {
        StringBuilder n = a.n("ht=");
        n.append(this.f1540c);
        if (this.f1539b != 0) {
            n.append(", dbId=");
            n.append(this.f1539b);
        }
        if (this.f1541d != 0) {
            n.append(", appUID=");
            n.append(this.f1541d);
        }
        ArrayList arrayList = new ArrayList(this.f1538a.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            n.append(", ");
            n.append(str);
            n.append(o0ooo00oo.O0000Oo0);
            n.append(this.f1538a.get(str));
        }
        return n.toString();
    }
}
