package a.c.d.m.e;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;

public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyFragmentContainerActivity f343a;

    public c(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        this.f343a = myPregnancyFragmentContainerActivity;
    }

    public void onClick(View view) {
        MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity = this.f343a;
        if (myPregnancyFragmentContainerActivity.f3944b != view) {
            myPregnancyFragmentContainerActivity.s(0);
        }
    }
}
