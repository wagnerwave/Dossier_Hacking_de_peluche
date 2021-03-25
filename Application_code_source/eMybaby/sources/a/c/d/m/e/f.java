package a.c.d.m.e;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyActivity;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;

public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyFragmentContainerActivity f346a;

    public f(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        this.f346a = myPregnancyFragmentContainerActivity;
    }

    public void onClick(View view) {
        MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity = this.f346a;
        myPregnancyFragmentContainerActivity.startActivityForResult(new Intent(myPregnancyFragmentContainerActivity, MyPregnancyActivity.class), 2480);
    }
}
