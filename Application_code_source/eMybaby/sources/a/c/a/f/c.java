package a.c.a.f;

import android.app.Activity;
import android.content.DialogInterface;

public final class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f37a;

    public c(Activity activity) {
        this.f37a = activity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f37a.finish();
    }
}
