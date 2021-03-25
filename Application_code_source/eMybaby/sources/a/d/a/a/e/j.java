package a.d.a.a.e;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class j extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Dialog f1248a = null;

    /* renamed from: b  reason: collision with root package name */
    public DialogInterface.OnCancelListener f1249b = null;

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f1249b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f1248a == null) {
            setShowsDialog(false);
        }
        return this.f1248a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
