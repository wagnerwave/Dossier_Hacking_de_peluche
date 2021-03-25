package a.i.a;

import a.i.a.t;
import a.i.a.y;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;

public class b extends y {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f3584a;

    public b(Context context) {
        this.f3584a = context.getAssets();
    }

    public boolean c(w wVar) {
        Uri uri = wVar.f3680d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public y.a f(w wVar, int i) {
        return new y.a(this.f3584a.open(wVar.f3680d.toString().substring(22)), t.d.DISK);
    }
}
