package a.i.a;

import a.a.a.a.a;
import a.i.a.t;
import a.i.a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class z extends y {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3696a;

    public z(Context context) {
        this.f3696a = context;
    }

    public boolean c(w wVar) {
        if (wVar.f3681e != 0) {
            return true;
        }
        return "android.resource".equals(wVar.f3680d.getScheme());
    }

    public y.a f(w wVar, int i) {
        int i2;
        Uri uri;
        Resources m = g0.m(this.f3696a, wVar);
        boolean z = true;
        if (wVar.f3681e != 0 || (uri = wVar.f3680d) == null) {
            i2 = wVar.f3681e;
        } else {
            String authority = uri.getAuthority();
            if (authority != null) {
                List<String> pathSegments = wVar.f3680d.getPathSegments();
                if (pathSegments == null || pathSegments.isEmpty()) {
                    StringBuilder n = a.n("No path segments: ");
                    n.append(wVar.f3680d);
                    throw new FileNotFoundException(n.toString());
                } else if (pathSegments.size() == 1) {
                    try {
                        i2 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                        StringBuilder n2 = a.n("Last path segment is not a resource ID: ");
                        n2.append(wVar.f3680d);
                        throw new FileNotFoundException(n2.toString());
                    }
                } else if (pathSegments.size() == 2) {
                    i2 = m.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                } else {
                    StringBuilder n3 = a.n("More than two path segments: ");
                    n3.append(wVar.f3680d);
                    throw new FileNotFoundException(n3.toString());
                }
            } else {
                StringBuilder n4 = a.n("No package provided: ");
                n4.append(wVar.f3680d);
                throw new FileNotFoundException(n4.toString());
            }
        }
        BitmapFactory.Options d2 = y.d(wVar);
        if (d2 == null || !d2.inJustDecodeBounds) {
            z = false;
        }
        if (z) {
            BitmapFactory.decodeResource(m, i2, d2);
            y.b(wVar.h, wVar.i, d2, wVar);
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(m, i2, d2);
        t.d dVar = t.d.DISK;
        g0.d(decodeResource, "bitmap == null");
        return new y.a(decodeResource, (InputStream) null, dVar, 0);
    }
}
