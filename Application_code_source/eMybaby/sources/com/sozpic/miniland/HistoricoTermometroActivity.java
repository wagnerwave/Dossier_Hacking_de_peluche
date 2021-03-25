package com.sozpic.miniland;

import a.c.d.r.j;
import a.h.a.k0.f;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Termo;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.oOO0O0O0;
import de.timroes.swipetodismiss.SwipeDismissList;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HistoricoTermometroActivity extends Activity implements View.OnClickListener, TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f4421a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressDialog f4422b;

    /* renamed from: c  reason: collision with root package name */
    public Usuario f4423c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f4424d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4425e;
    public TextView f;
    public ArrayList<Termo> g = new ArrayList<>();
    public TopMenuActivity h;
    public SwipeDismissList.OnDismissCallback i;
    public Bebe j;
    public Handler k = new b();

    public class a implements SwipeDismissList.OnDismissCallback {

        /* renamed from: com.sozpic.miniland.HistoricoTermometroActivity$a$a  reason: collision with other inner class name */
        public class C0099a extends SwipeDismissList.Undoable {
            public C0099a(a aVar) {
            }

            public void discard() {
            }

            public String getTitle() {
                return "";
            }

            public void undo() {
            }
        }

        public a() {
        }

        public SwipeDismissList.Undoable onDismiss(AbsListView absListView, int i) {
            HistoricoTermometroActivity historicoTermometroActivity = HistoricoTermometroActivity.this;
            Termo termo = (Termo) historicoTermometroActivity.f4424d.getAdapter().getItem(i);
            if (Integer.parseInt(termo.getId()) != 0) {
                Dialog dialog = new Dialog(historicoTermometroActivity, 2131886561);
                dialog.requestWindowFeature(1);
                dialog.setContentView(R.layout.popup_mensaje);
                dialog.setCancelable(true);
                Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_TEMPERATURE_CONFIRM_QUESTION, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
                button.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
                button.setOnClickListener(new a.h.a.b(historicoTermometroActivity, dialog));
                Button button2 = (Button) dialog.findViewById(R.id.ook);
                button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
                button2.setOnClickListener(new a.h.a.c(historicoTermometroActivity, i, termo, dialog));
                dialog.show();
            }
            return new C0099a(this);
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            f fVar;
            HistoricoTermometroActivity.this.f4422b.dismiss();
            if (message != null) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                HistoricoTermometroActivity historicoTermometroActivity = HistoricoTermometroActivity.this;
                String obj = message.obj.toString();
                ArrayList<Termo> arrayList = new ArrayList<>();
                if (obj != null && obj.length() > 0) {
                    if (obj.length() == 0) {
                        arrayList = null;
                    } else {
                        try {
                            JSONArray jSONArray = new JSONArray(obj);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                Termo termo = new Termo();
                                termo.setId(jSONObject.getString("idTemperatura"));
                                termo.setFecha(j.i.parse(jSONObject.getString("fecharevision")));
                                termo.setTmp(Double.valueOf(jSONObject.getDouble("temperatura")));
                                arrayList.add(termo);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            a.e.a.a.r.b.j("TERMO parsejson", "Ex: " + e2.toString());
                        } catch (ParseException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                historicoTermometroActivity.g = arrayList;
                if (HistoricoTermometroActivity.this.g.size() > 0) {
                    HistoricoTermometroActivity historicoTermometroActivity2 = HistoricoTermometroActivity.this;
                    fVar = new f(historicoTermometroActivity2, historicoTermometroActivity2.g);
                } else {
                    Termo termo2 = new Termo();
                    termo2.setId(oOO0O0O0.O0000oO0);
                    HistoricoTermometroActivity.this.g.add(termo2);
                    HistoricoTermometroActivity historicoTermometroActivity3 = HistoricoTermometroActivity.this;
                    fVar = new f(historicoTermometroActivity3, historicoTermometroActivity3.g);
                }
                HistoricoTermometroActivity.this.f4424d.setAdapter(fVar);
            } else {
                Toast.makeText(HistoricoTermometroActivity.this.f4421a, "Error", 0).show();
            }
            a.e.a.a.r.b.Z(HistoricoTermometroActivity.this.f4424d);
        }
    }

    public class c extends AsyncTask<String, Void, String> {
        public c(a aVar) {
        }

        public Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            try {
                Usuario i = AppMiniland.f().i();
                a.e.a.a.r.b.v("&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&idBebe=" + HistoricoTermometroActivity.this.j.getId() + "&id=" + strArr[0], "termometro.php?eliminartemperatura=1");
                return "";
            } catch (Exception unused) {
                return "";
            }
        }

        public void onPostExecute(Object obj) {
            String str = (String) obj;
        }

        public void onPreExecute() {
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onClick(View view) {
        if (view == null) {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4421a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_temperatura_3);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.h = topMenuActivity;
        topMenuActivity.setListener(this);
        this.h.setSeccion(a.c.a.d.a.h(R.string.TR_THERMOMETER));
        ((TextView) findViewById(R.id.ultimos_title)).setText(a.c.a.d.a.h(R.string.TR_LATEST).toUpperCase());
        ((TextView) findViewById(R.id.registros_title)).setText(a.c.a.d.a.h(R.string.TR_RECORDS).toUpperCase());
        ((TextView) findViewById(R.id.delete_measure_text)).setText(a.c.a.d.a.h(R.string.TR_DELETE_MEASURE_TITLE).toUpperCase());
        this.f4424d = (ListView) findViewById(R.id.listadohistorico);
        a aVar = new a();
        this.i = aVar;
        new SwipeDismissList(this.f4424d, aVar, SwipeDismissList.UndoMode.SINGLE_UNDO);
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("KEY_INTENT_BABY")) {
            finish();
            return;
        }
        this.j = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.lo);
        circularImageView.setBorder(true);
        circularImageView.setBorderColor(getResources().getColor(R.color.rosa));
        circularImageView.setImageResource(R.drawable.baby_big_default);
        if (!this.j.isPhotoEmpty()) {
            AppMiniland.f().k.b(this.j.getFoto(), circularImageView, (a.g.a.b.b) null, (a.g.a.b.l.c) null);
        }
        TextView textView = (TextView) findViewById(R.id.nombrebb);
        this.f4425e = textView;
        textView.setText(a.c.a.d.a.g(this.j.getNombre()));
        TextView textView2 = (TextView) findViewById(R.id.apellidobb);
        this.f = textView2;
        textView2.setText(a.c.a.d.a.g(this.j.getApellidos()));
        this.f4423c = AppMiniland.f().i();
        ProgressDialog progressDialog = new ProgressDialog(this.f4421a);
        this.f4422b = progressDialog;
        progressDialog.setCancelable(true);
        this.f4422b.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
        this.f4422b.setIndeterminate(true);
        this.f4422b.show();
        try {
            new a.h.a.l0.b(this.k, "&bd=" + this.f4423c.getBd() + "&bdpre=" + this.f4423c.getBdpre() + "&idBebe=" + this.j.getId(), "termometro.php?vertemperatura=1").start();
        } catch (Exception unused) {
            this.f4422b.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
        a.c.a.e.f.c().e("TERMOMETRO_HISTORICO");
    }
}
