package a.c.d.d;

import a.c.a.d.a;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import com.cuatroochenta.miniland.album.AlbumViewFlowActivity;
import com.sozpic.miniland.R;

public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f56a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f57b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AlbumViewFlowActivity f58c;

    public b(AlbumViewFlowActivity albumViewFlowActivity, String str, Dialog dialog) {
        this.f58c = albumViewFlowActivity;
        this.f56a = str;
        this.f57b = dialog;
    }

    public void onClick(View view) {
        this.f58c.f3800c = new ProgressDialog(this.f58c);
        this.f58c.f3800c.setCancelable(false);
        this.f58c.f3800c.setMessage(a.h(R.string.TR_UPDATING));
        this.f58c.f3800c.setIndeterminate(true);
        this.f58c.f3800c.show();
        try {
            new AlbumViewFlowActivity.e((AlbumViewFlowActivity.a) null).execute(new String[]{this.f56a});
        } catch (Exception unused) {
            this.f58c.f3800c.dismiss();
        }
        this.f57b.dismiss();
    }
}
