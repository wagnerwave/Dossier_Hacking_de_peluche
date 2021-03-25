package a.d.a.a.e;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

public class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Dialog f1228a = null;

    /* renamed from: b  reason: collision with root package name */
    public DialogInterface.OnCancelListener f1229b = null;

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f1229b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f1228a == null) {
            setShowsDialog(false);
        }
        return this.f1228a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
