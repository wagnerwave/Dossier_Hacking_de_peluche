package a.h.a;

import a.e.a.a.r.b;
import a.h.a.k0.f;
import android.app.Dialog;
import android.view.View;
import com.sozpic.miniland.HistoricoTermometroActivity;
import com.sozpic.miniland.modelos.Termo;

public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3458a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Termo f3459b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f3460c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HistoricoTermometroActivity f3461d;

    public c(HistoricoTermometroActivity historicoTermometroActivity, int i, Termo termo, Dialog dialog) {
        this.f3461d = historicoTermometroActivity;
        this.f3458a = i;
        this.f3459b = termo;
        this.f3460c = dialog;
    }

    public void onClick(View view) {
        f fVar = (f) this.f3461d.f4424d.getAdapter();
        fVar.f3505b.remove(this.f3458a);
        fVar.notifyDataSetChanged();
        b.Z(this.f3461d.f4424d);
        new HistoricoTermometroActivity.c((HistoricoTermometroActivity.a) null).execute(new String[]{this.f3459b.getId()});
        this.f3460c.dismiss();
    }
}
