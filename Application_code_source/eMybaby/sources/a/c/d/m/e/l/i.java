package a.c.d.m.e.l;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;

public class i implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f417a;

    public i(m mVar) {
        this.f417a = mVar;
    }

    public boolean onLongClick(View view) {
        if (!(this.f417a.getActivity() instanceof MyPregnancyFragmentContainerActivity)) {
            return true;
        }
        ((MyPregnancyFragmentContainerActivity) this.f417a.getActivity()).q();
        return true;
    }
}
