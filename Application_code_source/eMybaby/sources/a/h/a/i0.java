package a.h.a;

import android.view.View;
import com.sozpic.miniland.RegistroActivity;

public class i0 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RegistroActivity f3479a;

    public i0(RegistroActivity registroActivity) {
        this.f3479a = registroActivity;
    }

    public void onFocusChange(View view, boolean z) {
        if (!z && !this.f3479a.s.getText().toString().equals("") && !this.f3479a.r.getText().toString().equals("")) {
            this.f3479a.q();
        }
    }
}
