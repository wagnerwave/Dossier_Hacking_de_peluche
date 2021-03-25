package a.c.d.m.i.k;

import a.c.d.r.i;
import a.c.d.r.j;
import a.c.d.s.e.d.a.c.d;
import a.c.d.s.e.d.a.d.c;
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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.cuatroochenta.miniland.pregnancy.mama.MamaMainActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.list.MamaBloodPressureListRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.remove.MamaBloodPressureDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class k extends m0 implements a.c.d.s.e.d.a.c.a, a.c.d.s.e.d.a.a.a, a.c.d.s.e.d.a.d.a {
    public ListView l;
    public g m;
    public Dialog n;
    public Calendar o;
    public MeasureWithTwoValues<Integer, Integer> p;
    public View q;
    public TextView r;
    public EditText s;
    public EditText t;
    public boolean u;

    public class a implements View.OnClickListener {

        /* renamed from: a.c.d.m.i.k.k$a$a  reason: collision with other inner class name */
        public class C0029a implements DialogInterface.OnClickListener {
            public C0029a(a aVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                k kVar = k.this;
                Long id = kVar.p.getId();
                if (kVar != null) {
                    kVar.C(a.c.a.d.a.h(R.string.TR_DELETING_MEDIDA_TENSION), false);
                    new c.a(new a.c.d.s.e.d.a.d.c(), new MamaBloodPressureDeleteRequest(id), kVar).start();
                    return;
                }
                throw null;
            }
        }

        public a() {
        }

        public void onClick(View view) {
            k kVar = k.this;
            if (kVar.p != null) {
                new AlertDialog.Builder(kVar.getActivity()).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_DELETE_MEDIDA_TENSION_CONFIRM)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new b()).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new C0029a(this)).show();
            }
        }
    }

    public class b implements AdapterView.OnItemLongClickListener {
        public b() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            k kVar = k.this;
            View view2 = kVar.q;
            if (view2 != null) {
                view2.setBackgroundResource(kVar.p());
            }
            view.setBackgroundColor(k.this.getResources().getColor(R.color.mama_selected_item_background));
            k kVar2 = k.this;
            kVar2.q = view;
            kVar2.p = (MeasureWithTwoValues) adapterView.getItemAtPosition(i);
            k.this.z();
            return true;
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            k kVar = k.this;
            View view2 = kVar.q;
            if (view2 != null) {
                view2.setBackgroundResource(kVar.p());
            }
            k kVar2 = k.this;
            kVar2.p = null;
            kVar2.y();
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.a.c.b f614a;

        public d(a.c.d.s.e.d.a.c.b bVar) {
            this.f614a = bVar;
        }

        public void run() {
            k.this.s();
            if (this.f614a.f42a.booleanValue()) {
                k.this.m.a(this.f614a.f988c);
                return;
            }
            a.c.a.f.b.h0(k.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_MAMA_BLOOD_PRESSURE), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            if (!a.c.a.d.a.j(k.this.r.getText().toString())) {
                k.this.r.setText("");
                k.this.s.setText("");
                k.this.t.setText("");
            }
            k kVar = k.this;
            kVar.o = null;
            kVar.n.show();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            k kVar = k.this;
            if (kVar.p != null) {
                kVar.u = true;
            }
            k kVar2 = k.this;
            kVar2.r.setText(j.h.format(new Date(kVar2.p.getDate().longValue())));
            kVar2.s.setText(String.valueOf(kVar2.p.getFirstValue()));
            kVar2.t.setText(String.valueOf(kVar2.p.getSecondValue()));
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(kVar2.p.getDate().longValue());
            kVar2.o = instance;
            kVar2.n.show();
        }
    }

    public class g extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<MeasureWithTwoValues<Integer, Integer>> f618a;

        /* renamed from: b  reason: collision with root package name */
        public Context f619b;

        public g(Context context) {
            this.f619b = context;
        }

        public void a(List<MeasureWithTwoValues<Integer, Integer>> list) {
            this.f618a = list;
            super.notifyDataSetChanged();
        }

        public int getCount() {
            List<MeasureWithTwoValues<Integer, Integer>> list = this.f618a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public Object getItem(int i) {
            return this.f618a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            h hVar;
            MeasureWithTwoValues measureWithTwoValues = this.f618a.get(i);
            if (view == null) {
                view = LayoutInflater.from(this.f619b).inflate(R.layout.mama_blood_pressure_value_item, viewGroup, false);
                hVar = new h((d) null);
                hVar.f621a = (TextView) view.findViewById(R.id.mama_blood_pressure_item_week);
                hVar.f622b = (TextView) view.findViewById(R.id.mama_blood_pressure_item_date);
                hVar.f623c = (TextView) view.findViewById(R.id.mama_blood_pressure_item_sistolic);
                hVar.f624d = (TextView) view.findViewById(R.id.mama_blood_pressure_item_diastolic);
                view.setTag(hVar);
            } else {
                hVar = (h) view.getTag();
            }
            hVar.f621a.setText(measureWithTwoValues.getTitle());
            hVar.f622b.setText(measureWithTwoValues.getStringDate());
            hVar.f623c.setText(String.valueOf(measureWithTwoValues.getFirstValue()));
            hVar.f624d.setText(String.valueOf(measureWithTwoValues.getSecondValue()));
            return view;
        }

        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public TextView f621a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f622b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f623c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f624d;

        public h() {
        }

        public h(d dVar) {
        }
    }

    public static void D(k kVar, Long l2) {
        MeasureWithTwoValues<Integer, Integer> E = kVar.E();
        kVar.p.setFirstValue(E.getFirstValue());
        kVar.p.setSecondValue(E.getSecondValue());
        kVar.p.setDate(E.getDate());
        kVar.p.setTitle(E.getTitle());
        kVar.p.setId(l2);
        kVar.m.notifyDataSetChanged();
        kVar.y();
        View view = kVar.q;
        if (view != null) {
            view.setBackgroundResource(kVar.p());
        }
        kVar.u = false;
        kVar.n.dismiss();
        kVar.s();
    }

    public void A() {
        this.i.setOnClickListener(new a());
    }

    public void B() {
        this.h.setOnClickListener(new f());
    }

    @NonNull
    public final MeasureWithTwoValues<Integer, Integer> E() {
        return new MeasureWithTwoValues(-1, Integer.valueOf(Integer.parseInt(this.s.getText().toString())), Integer.valueOf(Integer.parseInt(this.t.getText().toString())), i.d(this.o.getTime()), j.j.format(this.o.getTime()));
    }

    public void F(a.c.d.s.e.d.a.c.b bVar) {
        getActivity().runOnUiThread(new d(bVar));
    }

    public boolean h() {
        if (this.p == null) {
            return false;
        }
        View view = this.q;
        if (view != null) {
            view.setBackgroundResource(p());
        }
        this.p = null;
        y();
        return true;
    }

    public String n() {
        return a.c.a.d.a.h(R.string.TR_ANYADIR_NUEVA_MEDIDA).toUpperCase();
    }

    public View.OnClickListener o() {
        return new e();
    }

    public void onStart() {
        super.onStart();
        a.c.a.e.f.c().e("MI_EMBARAZO_MAMA_TENSION");
    }

    public int q() {
        return R.layout.fragment_mama_blood_pressure;
    }

    public String r() {
        return MamaMainActivity.b.MAMA_OPTION_BLOOD_PRESSURE.f4048b.toUpperCase();
    }

    public void t() {
        this.l.setOnItemLongClickListener(new b());
        this.l.setOnItemClickListener(new c());
    }

    public void u() {
        this.l = (ListView) m(R.id.lv_mama_blood_pressure);
    }

    public void w() {
        ((TextView) m(R.id.tv_mama_blood_pressure_sistolica)).setText(a.c.a.d.a.h(R.string.TR_SISTOLICA).toUpperCase());
        ((TextView) m(R.id.tv_mama_blood_pressure_diastolica)).setText(a.c.a.d.a.h(R.string.TR_DIASTOLICA).toUpperCase());
    }

    public void x() {
        Dialog dialog = new Dialog(getActivity(), 16973941);
        this.n = dialog;
        dialog.setContentView(R.layout.dialog_pregnancy_mama_blood_pressure);
        ((TextView) this.n.findViewById(R.id.tv_dialog_blood_pressure_new_sistolic)).setText(a.c.a.d.a.h(R.string.TR_INTRODUCE_TENSION_SISTOLICA));
        ((TextView) this.n.findViewById(R.id.tv_dialog_blood_pressure_new_diastolic)).setText(a.c.a.d.a.h(R.string.TR_INTRODUCE_TENSION_DIASTOLICA));
        ((TextView) this.n.findViewById(R.id.tv_date)).setText(a.c.a.d.a.h(R.string.TR_FECHA_MEDIDA));
        EditText editText = (EditText) this.n.findViewById(R.id.et_dialog_blood_pressure_new_sistolic);
        this.s = editText;
        EditText editText2 = (EditText) this.n.findViewById(R.id.et_dialog_blood_pressure_new_diastolic);
        this.t = editText2;
        TextView textView = (TextView) this.n.findViewById(R.id.tv_dialog_cancel);
        textView.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        textView.setOnClickListener(new p(this));
        TextView textView2 = (TextView) this.n.findViewById(R.id.tv_dialog_save);
        textView2.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
        textView2.setOnClickListener(new q(this, editText, editText2));
        TextView textView3 = (TextView) this.n.findViewById(R.id.dialog_mama_dateselector);
        this.r = textView3;
        ((LinearLayout) this.n.findViewById(R.id.dialog_mama_select_date_container)).setOnClickListener(new r(this, textView3));
        this.m = new g(getActivity());
        this.l.addFooterView(new View(getActivity()), (Object) null, true);
        this.l.addHeaderView(new View(getActivity()), (Object) null, true);
        this.l.setAdapter(this.m);
        Usuario i = AppMiniland.f().i();
        if (i != null) {
            C(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            a.c.d.s.e.d.a.c.d dVar = new a.c.d.s.e.d.a.c.d();
            MamaBloodPressureListRequest mamaBloodPressureListRequest = new MamaBloodPressureListRequest();
            mamaBloodPressureListRequest.f4118a = i.getId();
            mamaBloodPressureListRequest.f4119b = i.getPass();
            new d.a(mamaBloodPressureListRequest, this).start();
        }
    }
}
