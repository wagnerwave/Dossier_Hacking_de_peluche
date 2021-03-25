package e.a.a.i0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class p implements Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final List f5166a = new ArrayList(16);

    public Object clone() {
        p pVar = (p) super.clone();
        pVar.f5166a.clear();
        pVar.f5166a.addAll(this.f5166a);
        return pVar;
    }

    public String toString() {
        return this.f5166a.toString();
    }
}
