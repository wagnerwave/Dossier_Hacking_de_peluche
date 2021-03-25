package a.c.d.j.c;

import a.c.a.d.a;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.cuatroochenta.miniland.humidificador.base.activity.BrowserActivity;
import com.cuatroochenta.miniland.humidificador.config.ECBindActivity;
import com.sozpic.miniland.R;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECBindActivity f231a;

    public e(ECBindActivity eCBindActivity) {
        this.f231a = eCBindActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f231a, BrowserActivity.class);
        intent.putExtra("Login", false);
        intent.putExtra("Refresh", true);
        intent.putExtra(Toolbar.TAG, true);
        intent.putExtra("Title", a.h(R.string.TR_HELP));
        intent.putExtra("Uri", "https://smart.tuya.com/reset");
        this.f231a.startActivity(intent);
    }
}
