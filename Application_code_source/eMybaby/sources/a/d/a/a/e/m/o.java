package a.d.a.a.e.m;

import a.c.a.f.b;
import androidx.annotation.Nullable;
import com.tuya.smart.common.o0ooo00oo;
import java.util.ArrayList;
import java.util.List;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f1405a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Object f1406b;

    public o(Object obj, r0 r0Var) {
        b.k(obj);
        this.f1406b = obj;
    }

    public final o a(String str, @Nullable Object obj) {
        List<String> list = this.f1405a;
        b.k(str);
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + str.length() + 1);
        sb.append(str);
        sb.append(o0ooo00oo.O0000Oo0);
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.f1406b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f1405a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f1405a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
