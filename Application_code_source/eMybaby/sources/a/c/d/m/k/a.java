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

public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityPrengnacySettings f709a;

    /* renamed from: a.c.d.m.k.a$a  reason: collision with other inner class name */
    public class C0033a implements DialogInterface.OnClickListener {
        public C0033a(a aVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a.c.d.m.k.a$b$a  reason: collision with other inner class name */
        public class C0034a implements a.c.d.s.e.c.a {
            public C0034a() {
            }

            public void a(a.c.d.s.e.c.b bVar) {
                a.this.f709a.o();
                if (Boolean.TRUE.equals(bVar.f42a)) {
                    f.c().d("MI_EMBARAZO", "AJUSTES_NUEVO", "");
                    AppMiniland.f().i().setBirthDate((Date) null);
                    Intent intent = new Intent();
                    intent.putExtra("KEY_EXTRA_DELETE_MODE", 1);
                    a.this.f709a.setResult(-1, intent);
                    a.this.f709a.finish();
                }
            }
        }

        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.f709a.p((String) null, false);
            new c.a(new C0034a()).start();
        }
    }

    public a(ActivityPrengnacySettings activityPrengnacySettings) {
        this.f709a = activityPrengnacySettings;
    }

    public void onClick(View view) {
        new AlertDialog.Builder(this.f709a).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_ESTA_SEGURO_DE_QUE_QUIERE_CREAR_U_NUEVO_EMBARAZO)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new b()).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new C0033a(this)).show();
    }
}
