package a.i.a;

import a.i.a.t;
import a.i.a.y;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import java.io.InputStream;

public class k extends g {
    public k(Context context) {
        super(context);
    }

    public boolean c(w wVar) {
        return "file".equals(wVar.f3680d.getScheme());
    }

    public y.a f(w wVar, int i) {
        InputStream openInputStream = this.f3606a.getContentResolver().openInputStream(wVar.f3680d);
        t.d dVar = t.d.DISK;
        int attributeInt = new ExifInterface(wVar.f3680d.getPath()).getAttributeInt("Orientation", 1);
        return new y.a((Bitmap) null, openInputStream, dVar, attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : BottomAppBarTopEdgeTreatment.ANGLE_UP : 90 : 180);
    }
}
