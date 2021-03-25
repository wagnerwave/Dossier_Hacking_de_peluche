package a.c.d.j.b.f;

import android.content.DialogInterface;

public final class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f201a;

    public b(DialogInterface.OnClickListener onClickListener) {
        this.f201a = onClickListener;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        DialogInterface.OnClickListener onClickListener = this.f201a;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
    }
}
