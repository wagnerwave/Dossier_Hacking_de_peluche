package a.h.a;

import android.app.Dialog;
import android.view.View;
import com.sozpic.miniland.ListadoTermometroActivity;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dialog f3468a;

    public e(ListadoTermometroActivity listadoTermometroActivity, Dialog dialog) {
        this.f3468a = dialog;
    }

    public void onClick(View view) {
        this.f3468a.dismiss();
    }
}
