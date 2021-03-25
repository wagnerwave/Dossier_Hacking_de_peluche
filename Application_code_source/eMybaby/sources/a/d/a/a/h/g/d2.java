package a.d.a.a.h.g;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;

public final class d2 {
    @GuardedBy("PhenotypeConstants.class")

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayMap<String, Uri> f1660a = new ArrayMap<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        synchronized (d2.class) {
            uri = f1660a.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                f1660a.put(str, uri);
            }
        }
        return uri;
    }
}
