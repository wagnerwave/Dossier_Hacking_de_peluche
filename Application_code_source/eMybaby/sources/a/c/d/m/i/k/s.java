package a.c.d.m.i.k;

import a.c.d.r.j;
import a.c.d.s.e.d.c.c.d;
import a.c.d.s.e.d.c.d.c;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;
import com.cuatroochenta.miniland.pregnancy.mama.MamaMainActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.list.MamaFundHeightListRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.remove.MamaFundHeightRemoveRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import java.util.Calendar;
import java.util.List;

public class s extends m0 implements a.c.d.s.e.d.c.c.a, a.c.d.s.e.d.c.a.a, a.c.d.s.e.d.c.d.a {
    public ListView l;
    public g m;
    public Dialog n;
    public EditText o;
    public TextView p;
    public Calendar q;
    public MeasurePregnancyMama r;
    public View s;
    public boolean t;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            s sVar = s.this;
            View view2 = sVar.s;
            if (view2 != null) {
                view2.setBackgroundResource(sVar.p());
            }
            s sVar2 = s.this;
            sVar2.r = null;
            sVar2.y();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            s sVar = s.this;
            MeasurePregnancyMama measurePregnancyMama = sVar.r;
            if (measurePregnancyMama != null) {
                sVar.t = true;
                sVar.o.setText(String.valueOf((int) measurePregnancyMama.getValue()));
                sVar.p.setText(j.h.format(sVar.r.getDate()));
                Calendar instance = Calendar.getInstance();
                instance.setTime(sVar.r.getDate());
                sVar.q = instance;
                sVar.n.show();
            }
        }
    }

    public class c implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {
            public a(c cVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                s sVar = s.this;
                Long idCrecimiento = sVar.r.getIdCrecimiento();
                if (sVar != null) {
                    sVar.C(a.c.a.d.a.h(R.string.TR_DELETING_ALTURA_UTERO), false);
                    new c.a(new a.c.d.s.e.d.c.d.c(), new MamaFundHeightRemoveRequest(idCrecimiento), sVar).start();
                    return;
                }
                throw null;
            }
        }

        public c() {
        }

        public void onClick(View view) {
            if (s.this.r != null) {
                new AlertDialog.Builder(s.this.getActivity()).setTitle(a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage(a.c.a.d.a.h(R.string.TR_DELETE_ALTURA_UTERO_CONFIRM)).setPositiveButton(a.c.a.d.a.h(R.string.TR_ACEPTAR), new b()).setNegativeButton(a.c.a.d.a.h(R.string.TR_CANCEL), new a(this)).show();
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.c.c.b f649a;

        public d(a.c.d.s.e.d.c.c.b bVar) {
            this.f649a = bVar;
        }

        public void run() {
            s.this.s();
            if (this.f649a.f42a.booleanValue()) {
                a.c.a.e.f.c().d("MI_EMBARAZO", "MAMA_NUEVA_MEDIDA", "");
                s.this.m.a(this.f649a.f1028c);
                return;
            }
            a.c.a.f.b.h0(s.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_FUNDAL_HEIGHT), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            if (!a.c.a.d.a.j(s.this.p.getText().toString())) {
                s.this.p.setText("");
                s.this.o.setText("");
            }
            s sVar = s.this;
            sVar.q = null;
            sVar.n.show();
        }
    }

    public class f implements AdapterView.OnItemLongClickListener {
        public f() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            s sVar = s.this;
            View view2 = sVar.s;
            if (view2 != null) {
                view2.setBackgroundResource(sVar.p());
            }
            view.setBackgroundColor(s.this.getResources().getColor(R.color.mama_selected_item_background));
            s sVar2 = s.this;
            sVar2.s = view;
            sVar2.r = (MeasurePregnancyMama) adapterView.getItemAtPosition(i);
            s.this.z();
            return true;
        }
    }

    public class g extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<MeasurePregnancyMama> f653a;

        /* renamed from: b  reason: collision with root package name */
        public Context f654b;

        public g(s sVar, Context context) {
            this.f654b = context;
        }

        public void a(List<MeasurePregnancyMama> list) {
            this.f653a = list;
            super.notifyDataSetChanged();
        }

        public int getCount() {
            List<MeasurePregnancyMama> list = this.f653a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public Object getItem(int i) {
            return this.f653a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            h hVar;
            MeasurePregnancyMama measurePregnancyMama = this.f653a.get(i);
            if (view == null) {
                view = LayoutInflater.from(this.f654b).inflate(R.layout.mama_weight_height_value_item, viewGroup, false);
                hVar = new h((d) null);
                hVar.f655a = (TextView) view.findViewById(R.id.mama_weight_height_item_week);
                hVar.f656b = (TextView) view.findViewById(R.id.mama_weight_height_item_date);
                hVar.f657c = (TextView) view.findViewById(R.id.mama_weight_height_item_value);
                view.setTag(hVar);
            } else {
                hVar = (h) view.getTag();
            }
            hVar.f655a.setText(measurePregnancyMama.getTitle());
            hVar.f656b.setText(measurePregnancyMama.getStringDate());
            hVar.f657c.setText(String.valueOf((int) measurePregnancyMama.getValue()));
            return view;
        }

        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public TextView f655a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f656b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f657c;

        public h() {
        }

        public h(d dVar) {
        }
    }

    public void A() {
        this.i.setOnClickListener(new c());
    }

    public void B() {
        this.h.setOnClickListener(new b());
    }

    public void D(a.c.d.s.e.d.c.c.b bVar) {
        getActivity().runOnUiThread(new d(bVar));
    }

    public boolean h() {
        if (this.r == null) {
            return false;
        }
        this.s.setBackgroundResource(p());
        this.r = null;
        y();
        return true;
    }

    public String n() {
        return a.c.a.d.a.h(R.string.TR_INTRODUCE_UNA_NUEVA_MEDIDA_ALTURA_UTERO);
    }

    public View.OnClickListener o() {
        return new e();
    }

    public void onStart() {
        super.onStart();
        a.c.a.e.f.c().e("MI_EMBARAZO_MAMA_UTERO");
    }

    public int q() {
        return R.layout.fragment_mama_utherus_height;
    }

    public String r() {
        return MamaMainActivity.b.MAMA_OPTION_UTERUS_HEIGHT.f4048b;
    }

    public void t() {
        this.l.setOnItemLongClickListener(new f());
        this.l.setOnItemClickListener(new a());
    }

    public void u() {
        this.l = (ListView) m(R.id.lv_mama_utherus_height);
    }

    public void w() {
    }

    public void x() {
        Dialog dialog = new Dialog(getActivity(), 16973941);
        this.n = dialog;
        dialog.setContentView(R.layout.dialog_pregnancy_mama_select_weight);
        ((TextView) this.n.findViewById(R.id.tv_new_weight)).setText(a.c.a.d.a.h(R.string.TR_INTRODUCE_UNA_NUEVA_MEDIDA_ALTURA_UTERO));
        ((TextView) this.n.findViewById(R.id.tv_date)).setText(a.c.a.d.a.h(R.string.TR_FECHA));
        EditText editText = (EditText) this.n.findViewById(R.id.et_dialog_new_value);
        this.o = editText;
        editText.setInputType(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        TextView textView = (TextView) this.n.findViewById(R.id.tv_dialog_cancel);
        textView.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        textView.setOnClickListener(new v(this));
        TextView textView2 = (TextView) this.n.findViewById(R.id.tv_dialog_save);
        textView2.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
        textView2.setOnClickListener(new w(this, editText));
        TextView textView3 = (TextView) this.n.findViewById(R.id.dialog_mama_dateselector);
        this.p = textView3;
        ((LinearLayout) this.n.findViewById(R.id.dialog_mama_select_date_container)).setOnClickListener(new x(this, textView3));
        g gVar = new g(this, getActivity());
        this.m = gVar;
        this.l.setAdapter(gVar);
        Usuario i = AppMiniland.f().i();
        if (i != null) {
            C(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            new d.a(new MamaFundHeightListRequest(i.getId(), i.getPass()), this).start();
        }
    }
}
