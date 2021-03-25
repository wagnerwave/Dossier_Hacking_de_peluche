package a.c.d.m.i.k;

import a.c.d.s.e.d.e.b.c;
import a.c.d.s.e.d.e.d.d;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;
import com.cuatroochenta.miniland.pregnancy.mama.MamaMainActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.delete.MamaWeightDeleteRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.list.MamaWeightListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.sdk.bean.ProductBean;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class h0 extends m0 implements a.c.d.s.e.d.e.d.a, a.c.d.s.e.d.e.a.a, a.c.d.s.e.d.e.b.a {
    public View A;
    public boolean B = false;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public WebView s;
    public ListView t;
    public i u;
    public Dialog v;
    public Calendar w;
    public EditText x;
    public TextView y;
    public MeasurePregnancyMama z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            h0 h0Var = h0.this;
            MeasurePregnancyMama measurePregnancyMama = h0Var.z;
            if (measurePregnancyMama != null) {
                h0Var.B = true;
                String valueOf = String.valueOf(measurePregnancyMama.getValue());
                h0Var.y.setText(a.c.d.r.j.h.format(h0.this.z.getDate()));
                h0Var.x.setText(valueOf);
                h0Var.v.show();
                h0.this.w = Calendar.getInstance();
                h0 h0Var2 = h0.this;
                h0Var2.w.setTime(h0Var2.z.getDate());
            }
        }
    }

    public class b implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {
            public a(b bVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        /* renamed from: a.c.d.m.i.k.h0$b$b  reason: collision with other inner class name */
        public class C0028b implements DialogInterface.OnClickListener {
            public C0028b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                h0 h0Var = h0.this;
                Long idCrecimiento = h0Var.z.getIdCrecimiento();
                if (h0Var != null) {
                    h0Var.C(a.c.a.d.a.h(R.string.TR_DELETING_PESOS_EMBARAZO), false);
                    new c.a(new a.c.d.s.e.d.e.b.c(), new MamaWeightDeleteRequest(idCrecimiento), h0Var).start();
                    return;
                }
                throw null;
            }
        }

        public b() {
        }

        public void onClick(View view) {
            if (h0.this.z != null) {
                new AlertDialog.Builder(h0.this.getActivity()).setTitle(a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage(a.c.a.d.a.h(R.string.TR_DELETE_PESOS_EMBARAZO_CONFIRM)).setPositiveButton(a.c.a.d.a.h(R.string.TR_ACEPTAR), new C0028b()).setNegativeButton(a.c.a.d.a.h(R.string.TR_CANCEL), new a(this)).show();
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.e.d.b f591a;

        public c(a.c.d.s.e.d.e.d.b bVar) {
            this.f591a = bVar;
        }

        public void run() {
            h0.this.s();
            if (this.f591a.f42a.booleanValue()) {
                List<MeasurePregnancyMama> list = this.f591a.f1080c;
                h0.this.u.b(list);
                if (list.size() >= 2) {
                    h0 h0Var = h0.this;
                    float value = h0Var.u.a(0).getValue();
                    i iVar = h0.this.u;
                    h0.D(h0Var, value, iVar.a(iVar.getCount() - 1).getValue(), h0.this.u.a(0).getMeasureUnitName());
                } else if (list.size() == 1) {
                    h0.D(h0.this, list.get(0).getValue(), list.get(0).getValue(), list.get(0).getMeasureUnitName());
                } else {
                    h0.D(h0.this, 0.0f, 0.0f, a.c.a.d.a.h(R.string.TR_UNIT_TYPE_KGS));
                }
            } else {
                a.c.a.f.b.h0(h0.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_MAMA_WEIGHT), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.e.a.b f593a;

        public d(a.c.d.s.e.d.e.a.b bVar) {
            this.f593a = bVar;
        }

        public void run() {
            h0.this.s();
            if (this.f593a.f42a.booleanValue()) {
                h0.this.E();
                if (h0.this.isAdded()) {
                    try {
                        a.c.a.f.b.l0(h0.this.getActivity(), a.c.a.d.a.h(R.string.TR_PESO_GUARDADO_CORRECTAMENTE), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                    } catch (WindowManager.BadTokenException unused) {
                    }
                }
            } else {
                a.c.a.f.b.h0(h0.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_ADDING_NEW_WEIGHT), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            if (h0.this.t.getVisibility() == 8) {
                h0.this.r.setText(a.c.a.d.a.h(R.string.TR_VER_GRAFICA_EVOLUCION).toUpperCase());
                h0.this.s.setVisibility(8);
                h0.this.t.setVisibility(0);
                return;
            }
            h0.this.r.setText(a.c.a.d.a.h(R.string.TR_VER_TODOS_LOS_PESOS).toUpperCase());
            h0.this.s.setVisibility(0);
            h0.this.F();
            h0.this.t.setVisibility(8);
        }
    }

    public class f implements AdapterView.OnItemLongClickListener {
        public f() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            h0 h0Var = h0.this;
            View view2 = h0Var.A;
            if (view2 != null) {
                view2.setBackgroundResource(h0Var.p());
            }
            view.setBackgroundColor(h0.this.getResources().getColor(R.color.mama_selected_item_background));
            h0 h0Var2 = h0.this;
            h0Var2.A = view;
            h0Var2.z = (MeasurePregnancyMama) adapterView.getItemAtPosition(i);
            h0.this.z();
            return true;
        }
    }

    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            h0 h0Var = h0.this;
            View view2 = h0Var.A;
            if (view2 != null) {
                view2.setBackgroundResource(h0Var.p());
            }
            h0Var.z = null;
            h0Var.y();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            if (!a.c.a.d.a.j(h0.this.y.getText().toString())) {
                h0.this.y.setText("");
                h0.this.x.setText("");
            }
            h0 h0Var = h0.this;
            h0Var.w = null;
            h0Var.v.show();
        }
    }

    public class i extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<MeasurePregnancyMama> f599a;

        /* renamed from: b  reason: collision with root package name */
        public Context f600b;

        public i(Context context) {
            this.f600b = context;
        }

        public MeasurePregnancyMama a(int i) {
            return this.f599a.get(i);
        }

        public void b(List<MeasurePregnancyMama> list) {
            this.f599a = list;
            super.notifyDataSetChanged();
        }

        public int getCount() {
            List<MeasurePregnancyMama> list = this.f599a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public Object getItem(int i) {
            return this.f599a.get(i);
        }

        public long getItemId(int i) {
            return this.f599a.get(i).getIdCrecimiento().longValue();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            j jVar;
            MeasurePregnancyMama measurePregnancyMama = this.f599a.get(i);
            if (view == null) {
                view = LayoutInflater.from(this.f600b).inflate(R.layout.mama_weight_height_value_item, viewGroup, false);
                jVar = new j((c0) null);
                jVar.f602a = (TextView) view.findViewById(R.id.mama_weight_height_item_week);
                jVar.f603b = (TextView) view.findViewById(R.id.mama_weight_height_item_date);
                jVar.f604c = (TextView) view.findViewById(R.id.mama_weight_height_item_value);
                view.setTag(jVar);
            } else {
                jVar = (j) view.getTag();
            }
            jVar.f602a.setText(measurePregnancyMama.getTitle());
            jVar.f603b.setText(measurePregnancyMama.getStringDate());
            TextView textView = jVar.f604c;
            textView.setText(String.format(Locale.getDefault(), "%.02f", new Object[]{Float.valueOf(measurePregnancyMama.getValue())}) + measurePregnancyMama.getMeasureUnitName());
            return view;
        }

        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public TextView f602a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f603b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f604c;

        public j() {
        }

        public j(c0 c0Var) {
        }
    }

    public static void D(h0 h0Var, float f2, float f3, String str) {
        if (h0Var != null) {
            String str2 = String.format(Locale.getDefault(), "%.02f", new Object[]{Float.valueOf(f2)}) + " " + str;
            h0Var.m.setText(str2);
            h0Var.o.setText(String.format(Locale.getDefault(), "%.02f", new Object[]{Float.valueOf(f3)}) + " " + str);
            h0Var.q.setText(String.format(Locale.getDefault(), "%.02f", new Object[]{Float.valueOf(Math.abs(f3 - f2))}) + " " + str);
            return;
        }
        throw null;
    }

    public void A() {
        this.i.setOnClickListener(new b());
    }

    public void B() {
        this.h.setOnClickListener(new a());
    }

    public final void E() {
        Usuario i2 = AppMiniland.f().i();
        if (i2 != null) {
            C(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            a.c.d.s.e.d.e.d.d dVar = new a.c.d.s.e.d.e.d.d();
            MamaWeightListRequest mamaWeightListRequest = new MamaWeightListRequest();
            mamaWeightListRequest.f4151a = i2.getId();
            mamaWeightListRequest.f4152b = i2.getPass();
            new d.a(mamaWeightListRequest, this).start();
        }
    }

    public final void F() {
        HashMap hashMap = new HashMap();
        Usuario i2 = AppMiniland.f().i();
        if (i2 != null) {
            hashMap.put("bd", i2.getBd());
            hashMap.put("bdpre", i2.getBdpre());
            try {
                this.s.loadUrl(a.c.a.d.a.c("https://emybaby.com/api/graficopeso.php", hashMap));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void G(a.c.d.s.e.d.e.d.b bVar) {
        getActivity().runOnUiThread(new c(bVar));
    }

    public void a(a.c.d.s.e.d.e.a.b bVar) {
        getActivity().runOnUiThread(new d(bVar));
    }

    public boolean h() {
        if (this.z == null) {
            return false;
        }
        this.A.setBackgroundResource(p());
        this.z = null;
        y();
        return true;
    }

    public String n() {
        return a.c.a.d.a.h(R.string.TR_ANYADIR_NUEVO_PESO).toUpperCase();
    }

    public View.OnClickListener o() {
        return new h();
    }

    public void onStart() {
        super.onStart();
        a.c.a.e.f.c().e("MI_EMBARAZO_MAMA_GRAFICA");
    }

    public int q() {
        return R.layout.fragment_mama_weight_evolution;
    }

    public String r() {
        return MamaMainActivity.b.MAMA_OPTION_WEIGHT_EVOLUTION.f4048b.toUpperCase();
    }

    public void t() {
        this.r.setOnClickListener(new e());
        this.t.setOnItemLongClickListener(new f());
        this.t.setOnItemClickListener(new g());
    }

    public void u() {
        this.l = (TextView) m(R.id.tv_initial_weight);
        this.m = (TextView) m(R.id.tv_initial_weight_number);
        this.n = (TextView) m(R.id.tv_current_weight);
        this.o = (TextView) m(R.id.tv_current_weight_number);
        this.p = (TextView) m(R.id.tv_changed_weight);
        this.q = (TextView) m(R.id.tv_changed_weight_number);
        this.r = (TextView) m(R.id.tv_weight_evolution_see_all);
        WebView webView = (WebView) m(R.id.wv_statistic_summary);
        this.s = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.s.setScrollBarStyle(ProductBean.ATTR_HONGWAI_SUB);
        this.s.getSettings().setBuiltInZoomControls(true);
        F();
        this.t = (ListView) m(R.id.lv_weight_evolution);
    }

    public void w() {
        this.l.setText(a.c.a.d.a.h(R.string.TR_PESO_INICIAL));
        this.n.setText(a.c.a.d.a.h(R.string.TR_PESO_ACTUAL));
        this.p.setText(a.c.a.d.a.h(R.string.TR_CAMBIO));
        this.r.setText(a.c.a.d.a.h(R.string.TR_VER_TODOS_LOS_PESOS).toUpperCase());
    }

    public void x() {
        Dialog dialog = new Dialog(getActivity(), 16973941);
        this.v = dialog;
        dialog.setContentView(R.layout.dialog_pregnancy_mama_select_weight);
        ((TextView) this.v.findViewById(R.id.tv_new_weight)).setText(a.c.a.d.a.h(R.string.TR_INTRODUCE_UN_NUEVO_PESO));
        ((TextView) this.v.findViewById(R.id.tv_date)).setText(a.c.a.d.a.h(R.string.TR_FECHA_MEDIDA));
        EditText editText = (EditText) this.v.findViewById(R.id.et_dialog_new_value);
        this.x = editText;
        TextView textView = (TextView) this.v.findViewById(R.id.tv_dialog_cancel);
        textView.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        textView.setOnClickListener(new j0(this));
        TextView textView2 = (TextView) this.v.findViewById(R.id.tv_dialog_save);
        textView2.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
        textView2.setOnClickListener(new d0(this, editText));
        TextView textView3 = (TextView) this.v.findViewById(R.id.dialog_mama_dateselector);
        this.y = textView3;
        ((LinearLayout) this.v.findViewById(R.id.dialog_mama_select_date_container)).setOnClickListener(new e0(this, textView3));
        i iVar = new i(getActivity());
        this.u = iVar;
        this.t.setAdapter(iVar);
        E();
    }
}
