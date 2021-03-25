package a.h.a;

import android.content.Intent;
import android.view.View;
import com.sozpic.miniland.NuevoCalendarioActivity;

public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f3561a;

    public x(z zVar) {
        this.f3561a = zVar;
    }

    public void onClick(View view) {
        try {
            this.f3561a.startActivityForResult(new Intent(this.f3561a.getActivity(), NuevoCalendarioActivity.class), 0);
        } catch (Exception unused) {
        }
    }
}
