package a.e.a.a.p.i;

import a.e.a.a.f;
import a.e.a.a.o.j.d;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class b extends g {
    public String a() {
        return b.class.getSimpleName();
    }

    public void onInvoke(Object... objArr) {
        List list;
        UUID uuid = objArr[1];
        UUID uuid2 = objArr[2];
        byte[] bArr = objArr[3];
        f fVar = (f) this;
        fVar.f3223a.p(true);
        a.e.a.a.b bVar = fVar.f3223a;
        bVar.p(true);
        HashMap hashMap = bVar.g.get(objArr[0]);
        if (hashMap != null && (list = (List) hashMap.get(bVar.q(uuid, uuid2))) != null) {
            for (int i = 0; i < list.size(); i++) {
                byte[] bArr2 = new byte[bArr.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                ((d) list.get(i)).onNotify(uuid, uuid2, bArr2);
            }
        }
    }
}
