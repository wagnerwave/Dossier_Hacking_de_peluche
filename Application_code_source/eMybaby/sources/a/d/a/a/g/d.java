package a.d.a.a.g;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

public final class d implements DynamiteModule.b {
    public final DynamiteModule.b.a a(Context context, String str, DynamiteModule.b.C0093b bVar) {
        int i;
        DynamiteModule.b.a aVar = new DynamiteModule.b.a();
        aVar.f4252a = bVar.a(context, str);
        int b2 = bVar.b(context, str, true);
        aVar.f4253b = b2;
        if (aVar.f4252a == 0 && b2 == 0) {
            i = 0;
        } else if (aVar.f4253b >= aVar.f4252a) {
            aVar.f4254c = 1;
            return aVar;
        } else {
            i = -1;
        }
        aVar.f4254c = i;
        return aVar;
    }
}
