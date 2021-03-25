package a.c.d.j.c;

import android.content.DialogInterface;
import android.content.Intent;

public class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f243a;

    public i(h hVar) {
        this.f243a = hVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f243a.f239b.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1315);
        dialogInterface.dismiss();
    }
}
