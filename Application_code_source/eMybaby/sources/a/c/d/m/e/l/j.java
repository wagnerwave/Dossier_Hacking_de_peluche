package a.c.d.m.e.l;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity;

public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f418a;

    public j(m mVar) {
        this.f418a = mVar;
    }

    public void onClick(View view) {
        m mVar = this.f418a;
        mVar.startActivityForResult(new Intent(mVar.getActivity(), UltrasoundFormActivity.class), 4023);
    }
}
