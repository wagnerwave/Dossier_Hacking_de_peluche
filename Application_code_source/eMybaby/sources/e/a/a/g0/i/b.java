package e.a.a.g0.i;

import e.a.a.e0.l;
import java.io.Serializable;
import java.util.Date;

public class b extends c implements l, Serializable {
    public int[] i;
    public boolean j;

    public b(String str, String str2) {
        super(str, str2);
    }

    public Object clone() {
        b bVar = (b) super.clone();
        int[] iArr = this.i;
        if (iArr != null) {
            bVar.i = (int[]) iArr.clone();
        }
        return bVar;
    }

    public boolean f(Date date) {
        return this.j || super.f(date);
    }

    public void i(boolean z) {
        this.j = z;
    }

    public int[] j() {
        return this.i;
    }

    public void k(String str) {
    }

    public void l(int[] iArr) {
        this.i = iArr;
    }
}
