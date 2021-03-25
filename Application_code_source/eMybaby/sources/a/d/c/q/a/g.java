package a.d.c.q.a;

import android.app.Activity;
import android.content.DialogInterface;

public final class g implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f2931a;

    public g(Activity activity) {
        this.f2931a = activity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f2931a.finish();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2931a.finish();
    }

    public void run() {
        this.f2931a.finish();
    }
}
