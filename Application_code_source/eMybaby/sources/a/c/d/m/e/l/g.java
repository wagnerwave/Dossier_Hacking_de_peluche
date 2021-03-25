package a.c.d.m.e.l;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;

public class g implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f414a;

    public g(m mVar) {
        this.f414a = mVar;
    }

    public boolean onLongClick(View view) {
        if (!(this.f414a.getActivity() instanceof MyPregnancyFragmentContainerActivity)) {
            return false;
        }
        ((MyPregnancyFragmentContainerActivity) this.f414a.getActivity()).q();
        return false;
    }
}
