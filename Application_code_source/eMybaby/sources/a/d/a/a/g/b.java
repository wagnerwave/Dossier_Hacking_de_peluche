package a.d.a.a.g;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

public final class b implements DynamiteModule.b {
    public final DynamiteModule.b.a a(Context context, String str, DynamiteModule.b.C0093b bVar) {
        DynamiteModule.b.a aVar = new DynamiteModule.b.a();
        int a2 = bVar.a(context, str);
        aVar.f4252a = a2;
        if (a2 != 0) {
            aVar.f4254c = -1;
        } else {
            int b2 = bVar.b(context, str, true);
            aVar.f4253b = b2;
            if (b2 != 0) {
                aVar.f4254c = 1;
            }
        }
        return aVar;
    }
}
