package a.c.d.m.e;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;

public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyFragmentContainerActivity f344a;

    public d(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        this.f344a = myPregnancyFragmentContainerActivity;
    }

    public void onClick(View view) {
        MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity = this.f344a;
        if (myPregnancyFragmentContainerActivity.f3944b != view) {
            myPregnancyFragmentContainerActivity.s(1);
        }
    }
}
