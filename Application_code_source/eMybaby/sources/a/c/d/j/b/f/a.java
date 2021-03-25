package a.c.d.j.b.f;

import android.content.DialogInterface;

public final class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f200a;

    public a(DialogInterface.OnClickListener onClickListener) {
        this.f200a = onClickListener;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        DialogInterface.OnClickListener onClickListener = this.f200a;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
    }
}
