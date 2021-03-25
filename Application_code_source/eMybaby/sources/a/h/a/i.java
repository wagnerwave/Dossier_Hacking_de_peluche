package a.h.a;

import android.app.Dialog;
import android.view.View;
import com.sozpic.miniland.MainActivity;

public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dialog f3478a;

    public i(MainActivity mainActivity, Dialog dialog) {
        this.f3478a = dialog;
    }

    public void onClick(View view) {
        this.f3478a.dismiss();
    }
}
