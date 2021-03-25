package a.h.a;

import android.view.View;
import com.sozpic.miniland.RegistroActivity;

public class h0 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RegistroActivity f3477a;

    public h0(RegistroActivity registroActivity) {
        this.f3477a = registroActivity;
    }

    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.f3477a.p(this.f3477a.r.getText().toString());
        }
    }
}
