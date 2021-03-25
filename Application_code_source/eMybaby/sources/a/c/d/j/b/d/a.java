package a.c.d.j.b.d;

import android.content.DialogInterface;

public class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f173a;

    public a(e eVar) {
        this.f173a = eVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f173a.getActivity().finish();
    }
}
