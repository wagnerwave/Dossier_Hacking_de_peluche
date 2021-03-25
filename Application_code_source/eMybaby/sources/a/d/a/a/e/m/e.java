package a.d.a.a.e.m;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.util.Log;

public abstract class e implements DialogInterface.OnClickListener {
    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
