package a.c.d.m.k;

import a.c.a.e.f;
import a.c.d.s.e.c.c;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.pregnancy.settings.ActivityPrengnacySettings;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.Date;

public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityPrengnacySettings f712a;

    public class a implements DialogInterface.OnClickListener {
        public a(b bVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: a.c.d.m.k.b$b  reason: collision with other inner class name */
    public class C0035b implements DialogInterface.OnClickListener {

        /* renamed from: a.c.d.m.k.b$b$a */
        public class a implements a.c.d.s.e.c.a {
            public a() {
            }

            public void a(a.c.d.s.e.c.b bVar) {
                b.this.f712a.o();
                if (Boolean.TRUE.equals(bVar.f42a)) {
                    f.c().d("MI_EMBARAZO", "AJUSTES_BORRAR", "");
                    AppMiniland.f().i().setBirthDate((Date) null);
                    Intent intent = new Intent();
                    intent.putExtra("KEY_EXTRA_DELETE_MODE", 2);
                    b.this.f712a.setResult(-1, intent);
                    b.this.f712a.finish();
                }
            }
        }

        public C0035b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            b.this.f712a.p((String) null, false);
            new c.a(new a()).start();
        }
    }

    public b(ActivityPrengnacySettings activityPrengnacySettings) {
        this.f712a = activityPrengnacySettings;
    }

    public void onClick(View view) {
        new AlertDialog.Builder(this.f712a).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_ESTA_SEGURO_DE_QUE_QUIERE_BORRAR_EL_EMBARAZO)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new C0035b()).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new a(this)).show();
    }
}
