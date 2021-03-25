package a.e.a.a.p;

import a.e.a.a.p.i.g;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3260b = {"action.character_changed"};

    public b(h hVar) {
        super(hVar);
    }

    public List<String> a() {
        return Arrays.asList(f3260b);
    }

    public boolean c(Context context, Intent intent) {
        Object stringExtra = intent.getStringExtra("extra.mac");
        Object obj = (UUID) intent.getSerializableExtra("extra.service.uuid");
        Object obj2 = (UUID) intent.getSerializableExtra("extra.character.uuid");
        Object byteArrayExtra = intent.getByteArrayExtra("extra.byte.value");
        for (g invoke : b(a.e.a.a.p.i.b.class)) {
            invoke.invoke(stringExtra, obj, obj2, byteArrayExtra);
        }
        return true;
    }
}
