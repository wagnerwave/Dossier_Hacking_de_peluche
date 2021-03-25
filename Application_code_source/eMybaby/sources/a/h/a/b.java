package a.h.a;

import a.h.a.k0.f;
import android.app.Dialog;
import android.view.View;
import com.sozpic.miniland.HistoricoTermometroActivity;

public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dialog f3456a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoricoTermometroActivity f3457b;

    public b(HistoricoTermometroActivity historicoTermometroActivity, Dialog dialog) {
        this.f3457b = historicoTermometroActivity;
        this.f3456a = dialog;
    }

    public void onClick(View view) {
        ((f) this.f3457b.f4424d.getAdapter()).notifyDataSetChanged();
        this.f3456a.dismiss();
    }
}
