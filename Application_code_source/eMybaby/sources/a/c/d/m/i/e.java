package a.c.d.m.i;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.pregnancy.mama.MamaMainActivity;
import com.cuatroochenta.miniland.pregnancy.mama.MyBellyImageFormActivity;
import com.sozpic.miniland.R;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MamaMainActivity f498a;

    public class a implements DialogInterface.OnClickListener {
        public a(e eVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MamaMainActivity mamaMainActivity = e.this.f498a;
            mamaMainActivity.startActivityForResult(new Intent(mamaMainActivity, MyBellyImageFormActivity.class), 1043);
        }
    }

    public e(MamaMainActivity mamaMainActivity) {
        this.f498a = mamaMainActivity;
    }

    public void onClick(View view) {
        if (this.f498a.f4039b.m.getCount() == 0) {
            new AlertDialog.Builder(view.getContext()).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_NO_TIENES_NINGUNA_TRIPITIA)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACCEPT), (DialogInterface.OnClickListener) new b()).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new a(this)).show();
        } else {
            this.f498a.q(MamaMainActivity.b.MAMA_OPTION_MY_BELLY);
        }
    }
}
