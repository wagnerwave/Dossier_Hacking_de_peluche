package a.c.d.d;

import android.app.Dialog;
import android.view.View;
import com.cuatroochenta.miniland.album.AlbumViewFlowActivity;

public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dialog f55a;

    public a(AlbumViewFlowActivity albumViewFlowActivity, Dialog dialog) {
        this.f55a = dialog;
    }

    public void onClick(View view) {
        this.f55a.dismiss();
    }
}
