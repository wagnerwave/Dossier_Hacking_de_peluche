package com.cuatroochenta.miniland.pregnancy.medicalAppointments;

import a.c.a.e.f;
import a.c.a.f.b;
import a.c.d.c;
import a.c.d.m.j.l;
import a.c.d.m.j.m;
import a.c.d.m.j.n;
import a.c.d.m.j.o;
import a.c.d.s.e.e.d.c;
import a.c.d.s.e.e.d.d;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.list.MedicalAppointmentListRequest;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class AppointmentListActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivity f4063b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f4064c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f4065d;

    /* renamed from: e  reason: collision with root package name */
    public ListView f4066e;
    public o f;

    public class a implements a.c.d.s.e.e.d.a {

        /* renamed from: com.cuatroochenta.miniland.pregnancy.medicalAppointments.AppointmentListActivity$a$a  reason: collision with other inner class name */
        public class C0092a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f4068a;

            public C0092a(d dVar) {
                this.f4068a = dVar;
            }

            public void run() {
                if (this.f4068a.f42a.booleanValue()) {
                    o oVar = AppointmentListActivity.this.f;
                    oVar.f703a = this.f4068a.f1102c;
                    oVar.notifyDataSetChanged();
                    return;
                }
                b.j0(AppointmentListActivity.this, this.f4068a.f43b);
            }
        }

        public a() {
        }

        public void a(d dVar) {
            AppointmentListActivity.this.runOnUiThread(new C0092a(dVar));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 48203) {
            if (i2 != -1) {
                return;
            }
        } else if (!(i == 48204 && i2 == -1)) {
            return;
        }
        r();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_medical_appointment_list);
        ((TextView) findViewById(R.id.appointment_list_button_anadir_nueva_cita_medica_title)).setText(a.c.a.d.a.h(R.string.TR_NUEVA_CITA_MEDICA).toUpperCase());
        this.f4064c = (LinearLayout) findViewById(R.id.appointment_list_button_anadir_nueva_cita_medica);
        this.f4066e = (ListView) findViewById(R.id.appointment_list_listview);
        this.f4063b = (TopMenuActivity) findViewById(R.id.appointment_list_toolbar);
        this.f4065d = (ViewGroup) findViewById(R.id.appointment_list_header);
        this.f4063b.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO));
        this.f4063b.setListener(this);
        this.f4065d.setBackgroundColor(-3052133);
        ((TextView) this.f4065d.findViewById(R.id.pregnancy_section_header_title)).setText(a.c.a.d.a.h(R.string.TR_CITAS_MEDICAS).toUpperCase());
        ((TextView) this.f4065d.findViewById(R.id.pregnancy_section_header_subtitle)).setText(a.c.a.d.a.h(R.string.TR_CITAS_PENDIENTES).toUpperCase());
        ((ImageView) this.f4065d.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_calendar);
        this.f4064c.setOnClickListener(new n(this));
        o oVar = new o();
        this.f = oVar;
        this.f4066e.setAdapter(oVar);
        this.f4066e.setOnItemClickListener(new l(this));
        this.f4066e.setOnItemLongClickListener(new m(this));
        r();
        f.c().e("MI_EMBARAZO_CITAS");
    }

    public final void r() {
        new c.a(new MedicalAppointmentListRequest(), new a()).start();
    }
}
