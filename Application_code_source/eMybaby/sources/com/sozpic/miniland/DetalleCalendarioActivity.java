package com.sozpic.miniland;

import a.c.a.e.f;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Agenda;
import com.sozpic.miniland.modelos.Usuario;

public class DetalleCalendarioActivity extends Activity implements TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f4353a;

    /* renamed from: b  reason: collision with root package name */
    public Agenda f4354b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4355c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4356d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4357e;
    public TextView f;
    public LinearLayout g;
    public View h;
    public CheckBox i;
    public TopMenuActivity j;
    public ProgressDialog k;
    public Handler l = new d();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(DetalleCalendarioActivity.this, NuevoCalendarioActivity.class);
            intent.putExtra("KEY_INTENT_AGENDA", DetalleCalendarioActivity.this.f4354b);
            DetalleCalendarioActivity.this.startActivity(intent);
            DetalleCalendarioActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4360a;

            public a(b bVar, Dialog dialog) {
                this.f4360a = dialog;
            }

            public void onClick(View view) {
                this.f4360a.dismiss();
            }
        }

        /* renamed from: com.sozpic.miniland.DetalleCalendarioActivity$b$b  reason: collision with other inner class name */
        public class C0094b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4361a;

            public C0094b(Dialog dialog) {
                this.f4361a = dialog;
            }

            public void onClick(View view) {
                DetalleCalendarioActivity.this.k = new ProgressDialog(DetalleCalendarioActivity.this.f4353a);
                DetalleCalendarioActivity.this.k.setCancelable(false);
                DetalleCalendarioActivity.this.k.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                DetalleCalendarioActivity.this.k.setIndeterminate(true);
                DetalleCalendarioActivity.this.k.show();
                try {
                    Usuario i = AppMiniland.f().i();
                    new a.h.a.l0.b(DetalleCalendarioActivity.this.l, "&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&idActividad=" + DetalleCalendarioActivity.this.f4354b.getId(), "calendario.php?borraractividad=1").start();
                } catch (Exception unused) {
                    DetalleCalendarioActivity.this.k.dismiss();
                }
                this.f4361a.dismiss();
            }
        }

        public b() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(DetalleCalendarioActivity.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_CALENDAR_CONFIRM_DIALOG, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new a(this, dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new C0094b(dialog));
            dialog.show();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            DetalleCalendarioActivity detalleCalendarioActivity = DetalleCalendarioActivity.this;
            a.c.a.d.a.b(detalleCalendarioActivity, detalleCalendarioActivity.f4354b);
        }
    }

    public class d extends Handler {
        public d() {
        }

        public void handleMessage(Message message) {
            DetalleCalendarioActivity.this.k.dismiss();
            if (!(message == null || message.obj == null)) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                if ("OK".equalsIgnoreCase(message.obj.toString())) {
                    DetalleCalendarioActivity.this.finish();
                    return;
                }
            }
            Toast.makeText(DetalleCalendarioActivity.this.f4353a, "Error", 0).show();
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0183, code lost:
        if (r3 != null) goto L_0x0185;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            r5.f4353a = r5
            r6 = 1
            r5.requestWindowFeature(r6)
            r0 = 2131492904(0x7f0c0028, float:1.8609273E38)
            r5.setContentView(r0)
            r0 = 2131296574(0x7f09013e, float:1.8211069E38)
            android.view.View r0 = r5.findViewById(r0)
            com.sozpic.miniland.TopMenuActivity r0 = (com.sozpic.miniland.TopMenuActivity) r0
            r5.j = r0
            r0.setListener(r5)
            com.sozpic.miniland.TopMenuActivity r0 = r5.j
            r1 = 2131821105(0x7f110231, float:1.9274944E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r0.setSeccion(r1)
            r0 = 2131296777(0x7f090209, float:1.821148E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820899(0x7f110163, float:1.9274526E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297628(0x7f09055c, float:1.8213206E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820586(0x7f11002a, float:1.9273891E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131296787(0x7f090213, float:1.82115E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821340(0x7f11031c, float:1.927542E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131296786(0x7f090212, float:1.8211499E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820824(0x7f110118, float:1.9274374E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            android.content.Intent r0 = r5.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0093
            java.lang.String r1 = "KEY_INTENT_AGENDA"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L_0x0093
            android.os.Parcelable r0 = r0.getParcelable(r1)
            com.sozpic.miniland.modelos.Agenda r0 = (com.sozpic.miniland.modelos.Agenda) r0
            r5.f4354b = r0
        L_0x0093:
            com.sozpic.miniland.modelos.Agenda r0 = r5.f4354b
            if (r0 != 0) goto L_0x009b
            r5.finish()
            return
        L_0x009b:
            r0 = 2131297443(0x7f0904a3, float:1.8212831E38)
            android.view.View r0 = r5.findViewById(r0)
            r5.h = r0
            r0 = 2131296737(0x7f0901e1, float:1.82114E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r5.f4355c = r0
            r1 = 2131821354(0x7f11032a, float:1.9275449E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setHint(r1)
            r0 = 2131296743(0x7f0901e7, float:1.8211411E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r5.f4356d = r0
            r1 = 2131820772(0x7f1100e4, float:1.9274268E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setHint(r1)
            r0 = 2131296747(0x7f0901eb, float:1.821142E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r5.f4357e = r0
            r0 = 2131296748(0x7f0901ec, float:1.8211421E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r5.f = r0
            r0 = 2131297627(0x7f09055b, float:1.8213204E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r5.i = r0
            r0 = 2131296951(0x7f0902b7, float:1.8211833E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r5.g = r0
            android.widget.TextView r0 = r5.f4355c
            com.sozpic.miniland.modelos.Agenda r1 = r5.f4354b
            java.lang.String r1 = r1.getNombre()
            r0.setText(r1)
            android.widget.TextView r0 = r5.f4356d
            com.sozpic.miniland.modelos.Agenda r1 = r5.f4354b
            java.lang.String r1 = r1.getTexto()
            r0.setText(r1)
            com.sozpic.miniland.modelos.Agenda r0 = r5.f4354b
            boolean r0 = r0.isAllDay()
            r1 = 8
            if (r0 != 0) goto L_0x0141
            android.widget.CheckBox r6 = r5.i
            r0 = 0
            r6.setChecked(r0)
            android.widget.LinearLayout r6 = r5.g
            r6.setVisibility(r0)
            android.view.View r6 = r5.h
            r6.setVisibility(r0)
            android.widget.TextView r6 = r5.f4357e
            com.sozpic.miniland.modelos.Agenda r0 = r5.f4354b
            java.lang.String r0 = r0.getFechainicio()
            r6.setText(r0)
            android.widget.TextView r6 = r5.f
            com.sozpic.miniland.modelos.Agenda r0 = r5.f4354b
            java.lang.String r0 = r0.getFechafin()
            r6.setText(r0)
            goto L_0x0150
        L_0x0141:
            android.widget.CheckBox r0 = r5.i
            r0.setChecked(r6)
            android.widget.LinearLayout r6 = r5.g
            r6.setVisibility(r1)
            android.view.View r6 = r5.h
            r6.setVisibility(r1)
        L_0x0150:
            com.sozpic.miniland.modelos.Agenda r6 = r5.f4354b
            java.lang.String r6 = r6.getFechainicio()
            com.sozpic.miniland.modelos.Agenda r0 = r5.f4354b
            java.lang.String r0 = r0.getFechafin()
            com.sozpic.miniland.modelos.Agenda r2 = r5.f4354b
            java.util.Date r2 = r2.getStartDate()
            com.sozpic.miniland.modelos.Agenda r3 = r5.f4354b
            java.util.Date r3 = r3.getEndDate()
            android.widget.CheckBox r4 = r5.i
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x018e
            if (r2 == 0) goto L_0x017e
            android.widget.TextView r6 = r5.f4357e
            java.text.DateFormat r4 = a.c.d.r.j.f
            java.lang.String r2 = r4.format(r2)
            r6.setText(r2)
            goto L_0x0183
        L_0x017e:
            android.widget.TextView r2 = r5.f4357e
            r2.setText(r6)
        L_0x0183:
            if (r3 == 0) goto L_0x01ba
        L_0x0185:
            android.widget.TextView r6 = r5.f
            java.text.DateFormat r0 = a.c.d.r.j.f
        L_0x0189:
            java.lang.String r0 = r0.format(r3)
            goto L_0x01bc
        L_0x018e:
            if (r2 == 0) goto L_0x01a7
            int r6 = r2.getHours()
            if (r6 != 0) goto L_0x019b
            android.widget.TextView r6 = r5.f4357e
            java.text.DateFormat r4 = a.c.d.r.j.f
            goto L_0x019f
        L_0x019b:
            android.widget.TextView r6 = r5.f4357e
            java.text.DateFormat r4 = a.c.d.r.j.k
        L_0x019f:
            java.lang.String r2 = r4.format(r2)
            r6.setText(r2)
            goto L_0x01ac
        L_0x01a7:
            android.widget.TextView r2 = r5.f4357e
            r2.setText(r6)
        L_0x01ac:
            if (r3 == 0) goto L_0x01ba
            int r6 = r3.getHours()
            if (r6 != 0) goto L_0x01b5
            goto L_0x0185
        L_0x01b5:
            android.widget.TextView r6 = r5.f
            java.text.DateFormat r0 = a.c.d.r.j.k
            goto L_0x0189
        L_0x01ba:
            android.widget.TextView r6 = r5.f
        L_0x01bc:
            r6.setText(r0)
            com.sozpic.miniland.modelos.Agenda r6 = r5.f4354b
            java.lang.String r6 = r6.getNombre()
            r0 = 2131820604(0x7f11003c, float:1.9273928E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            int r6 = r6.indexOf(r0)
            r0 = -1
            if (r6 == r0) goto L_0x01dd
            android.widget.LinearLayout r6 = r5.g
            r6.setVisibility(r1)
            android.view.View r6 = r5.h
            r6.setVisibility(r1)
        L_0x01dd:
            com.sozpic.miniland.modelos.Agenda r6 = r5.f4354b
            java.lang.String r6 = r6.getNombre()
            r2 = 2131821454(0x7f11038e, float:1.9275652E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            int r6 = r6.indexOf(r2)
            if (r6 == r0) goto L_0x01fa
            android.widget.LinearLayout r6 = r5.g
            r6.setVisibility(r1)
            android.view.View r6 = r5.h
            r6.setVisibility(r1)
        L_0x01fa:
            r6 = 2131296680(0x7f0901a8, float:1.8211284E38)
            android.view.View r6 = r5.findViewById(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0 = 2131296959(0x7f0902bf, float:1.821185E38)
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.sozpic.miniland.DetalleCalendarioActivity$a r1 = new com.sozpic.miniland.DetalleCalendarioActivity$a
            r1.<init>()
            r0.setOnClickListener(r1)
            r0 = 2131296958(0x7f0902be, float:1.8211847E38)
            android.view.View r6 = r6.findViewById(r0)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            com.sozpic.miniland.DetalleCalendarioActivity$b r0 = new com.sozpic.miniland.DetalleCalendarioActivity$b
            r0.<init>()
            r6.setOnClickListener(r0)
            r6 = 2131296679(0x7f0901a7, float:1.8211281E38)
            android.view.View r6 = r5.findViewById(r6)
            android.widget.Button r6 = (android.widget.Button) r6
            r0 = 2131820579(0x7f110023, float:1.9273877E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r6.setText(r0)
            com.sozpic.miniland.DetalleCalendarioActivity$c r0 = new com.sozpic.miniland.DetalleCalendarioActivity$c
            r0.<init>()
            r6.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.DetalleCalendarioActivity.onCreate(android.os.Bundle):void");
    }

    public void onResume() {
        super.onResume();
        f.c().e("CALENDARIO_EVENTO_DETALLE");
    }
}
