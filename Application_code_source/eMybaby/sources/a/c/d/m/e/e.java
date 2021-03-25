package a.c.d.m.e;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyFragmentContainerActivity f345a;

    public e(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        this.f345a = myPregnancyFragmentContainerActivity;
    }

    public void onClick(View view) {
        MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity = this.f345a;
        if (myPregnancyFragmentContainerActivity.f3944b != view) {
            myPregnancyFragmentContainerActivity.s(2);
        }
    }
}
