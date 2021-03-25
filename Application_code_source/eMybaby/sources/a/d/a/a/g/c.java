package a.d.a.a.g;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

public final class c implements DynamiteModule.b {
    public final DynamiteModule.b.a a(Context context, String str, DynamiteModule.b.C0093b bVar) {
        DynamiteModule.b.a aVar = new DynamiteModule.b.a();
        int a2 = bVar.a(context, str);
        aVar.f4252a = a2;
        aVar.f4253b = a2 != 0 ? bVar.b(context, str, false) : bVar.b(context, str, true);
        if (aVar.f4252a == 0 && aVar.f4253b == 0) {
            aVar.f4254c = 0;
        } else if (aVar.f4252a >= aVar.f4253b) {
            aVar.f4254c = -1;
        } else {
            aVar.f4254c = 1;
        }
        return aVar;
    }
}
