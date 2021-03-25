package a.c.d.j.c;

import android.content.DialogInterface;

public class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f244a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f246c;

    public j(h hVar, String str, String str2) {
        this.f246c = hVar;
        this.f244a = str;
        this.f245b = str2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            this.f246c.c(this.f244a, this.f245b);
        } else if (i == -1) {
            this.f246c.e();
        }
    }
}
