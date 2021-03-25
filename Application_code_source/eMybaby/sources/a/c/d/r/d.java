package a.c.d.r;

import android.app.Activity;
import android.content.DialogInterface;

public final class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f786a;

    public d(Activity activity) {
        this.f786a = activity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f786a.finish();
    }
}
