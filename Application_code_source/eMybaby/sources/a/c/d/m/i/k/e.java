package a.c.d.m.i.k;

import a.c.d.s.e.d.b.c.d;
import a.c.d.s.e.d.b.d.c;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.cuatroochenta.miniland.pregnancy.mama.MamaMainActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.list.MamaFetalMovListRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.remove.MamaFetalMovRemoveRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import java.util.Calendar;
import java.util.List;

public class e extends m0 implements a.c.d.s.e.d.b.c.a, a.c.d.s.e.d.b.a.a, a.c.d.s.e.d.b.d.a {
    public ListView l;
    public i m;
    public Dialog n;
    public ImageView o;
    public ImageView p;
    public TextView q;
    public Calendar r;
    public MeasureWithTwoValues<Boolean, Boolean> s;
    public View t;
    public boolean u;
    public ImageView v;
    public ImageView w;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (!a.c.a.d.a.j(e.this.q.getText().toString())) {
                e.this.q.setText("");
                e.this.o.clearColorFilter();
                e.this.p.clearColorFilter();
            }
            e eVar = e.this;
            eVar.r = null;
            eVar.o.clearColorFilter();
            e.this.p.clearColorFilter();
            e.this.o.setTag(Boolean.FALSE);
            e.this.p.setTag(Boolean.FALSE);
            e.this.n.show();
        }
    }

    public class b implements AdapterView.OnItemLongClickListener {
        public b() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar = e.this;
            View view2 = eVar.t;
            if (view2 != null) {
                view2.setBackgroundResource(eVar.p());
            }
            view.setBackgroundColor(e.this.getResources().getColor(R.color.mama_selected_item_background));
            e eVar2 = e.this;
            eVar2.t = view;
            eVar2.s = (MeasureWithTwoValues) adapterView.getItemAtPosition(i);
            e.this.z();
            return true;
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar = e.this;
            View view2 = eVar.t;
            if (view2 != null) {
                view2.setBackgroundResource(eVar.p());
            }
            e eVar2 = e.this;
            eVar2.s = null;
            eVar2.y();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            Boolean bool;
            ImageView imageView;
            Boolean bool2;
            ImageView imageView2;
            e eVar = e.this;
            MeasureWithTwoValues<Boolean, Boolean> measureWithTwoValues = eVar.s;
            if (measureWithTwoValues != null) {
                eVar.u = true;
                if (measureWithTwoValues.getFirstValue().booleanValue()) {
                    eVar.o.setColorFilter(eVar.getResources().getColor(R.color.mama_menu_options_color));
                    imageView = eVar.o;
                    bool = Boolean.TRUE;
                } else {
                    eVar.o.clearColorFilter();
                    imageView = eVar.o;
                    bool = Boolean.FALSE;
                }
                imageView.setTag(bool);
                if (eVar.s.getSecondValue().booleanValue()) {
                    eVar.p.setColorFilter(eVar.getResources().getColor(R.color.mama_menu_options_color));
                    imageView2 = eVar.p;
                    bool2 = Boolean.TRUE;
                } else {
                    eVar.p.clearColorFilter();
                    imageView2 = eVar.p;
                    bool2 = Boolean.FALSE;
                }
                imageView2.setTag(bool2);
                eVar.q.setText(eVar.s.getStringDate());
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(eVar.s.getDate().longValue());
                eVar.r = instance;
                eVar.n.show();
            }
        }
    }

    /* renamed from: a.c.d.m.i.k.e$e  reason: collision with other inner class name */
    public class C0027e implements View.OnClickListener {

        /* renamed from: a.c.d.m.i.k.e$e$a */
        public class a implements DialogInterface.OnClickListener {
            public a(C0027e eVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        /* renamed from: a.c.d.m.i.k.e$e$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                e eVar = e.this;
                Long id = eVar.s.getId();
                if (eVar != null) {
                    ProgressDialog progressDialog = new ProgressDialog(eVar.getActivity());
                    progressDialog.show();
                    new c.a(new a.c.d.s.e.d.b.d.c(), new MamaFetalMovRemoveRequest(id), new f(eVar, progressDialog)).start();
                    return;
                }
                throw null;
            }
        }

        public C0027e() {
        }

        public void onClick(View view) {
            e eVar = e.this;
            if (eVar.s != null) {
                new AlertDialog.Builder(eVar.getActivity()).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_DELETE_MOVIMIENTOS_FETALES_CONFIRM)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new b()).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new a(this)).show();
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.b.c.b f560a;

        public f(a.c.d.s.e.d.b.c.b bVar) {
            this.f560a = bVar;
        }

        public void run() {
            e.this.s();
            if (this.f560a.f42a.booleanValue()) {
                e.this.m.a(this.f560a.f1008c);
                return;
            }
            a.c.a.f.b.h0(e.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_BABY_MOVEMENTS), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.b.a.b f562a;

        public g(a.c.d.s.e.d.b.a.b bVar) {
            this.f562a = bVar;
        }

        public void run() {
            e.this.s();
            if (this.f562a.f42a.booleanValue()) {
                e.this.E();
                a.c.a.f.b.l0(e.this.getActivity(), a.c.a.d.a.h(R.string.TR_MOVIMIENTO_FETAL_ANADIDO_CORRECTAMENTE), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                return;
            }
            a.c.a.f.b.h0(e.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_ADDING_NEW_FETAL_MOV), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.b.d.b f564a;

        public h(a.c.d.s.e.d.b.d.b bVar) {
            this.f564a = bVar;
        }

        public void run() {
            e.this.s();
            if (this.f564a.f42a.booleanValue()) {
                e.this.E();
                a.c.a.f.b.l0(e.this.getActivity(), a.c.a.d.a.h(R.string.TR_DELETE_MOVIMIENTOS_FETALES_OK), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                return;
            }
            a.c.a.f.b.h0(e.this.getActivity(), a.c.a.d.a.h(R.string.TR_DELETE_MOVIMIENTOS_FETALES_KO), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public class i extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<MeasureWithTwoValues<Boolean, Boolean>> f566a;

        /* renamed from: b  reason: collision with root package name */
        public Context f567b;

        /* renamed from: c  reason: collision with root package name */
        public int f568c;

        /* renamed from: d  reason: collision with root package name */
        public int f569d;

        public i(e eVar, Context context) {
            this.f567b = context;
            this.f568c = eVar.getResources().getColor(R.color.mama_menu_options_color);
            this.f569d = eVar.getResources().getColor(R.color.grey);
        }

        public void a(List<MeasureWithTwoValues<Boolean, Boolean>> list) {
            this.f566a = list;
            super.notifyDataSetChanged();
        }

        public int getCount() {
            List<MeasureWithTwoValues<Boolean, Boolean>> list = this.f566a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public Object getItem(int i) {
            return this.f566a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            j jVar;
            int i2;
            ImageView imageView;
            int i3;
            ImageView imageView2;
            MeasureWithTwoValues measureWithTwoValues = this.f566a.get(i);
            if (view == null) {
                view = LayoutInflater.from(this.f567b).inflate(R.layout.mama_baby_movements_value_item, viewGroup, false);
                jVar = new j((a) null);
                jVar.f570a = (TextView) view.findViewById(R.id.mama_weight_height_item_week);
                jVar.f571b = (TextView) view.findViewById(R.id.mama_weight_height_item_date);
                jVar.f572c = (ImageView) view.findViewById(R.id.img_item_baby_movements_1);
                jVar.f573d = (ImageView) view.findViewById(R.id.img_item_baby_movements_2);
                view.setTag(jVar);
            } else {
                jVar = (j) view.getTag();
            }
            jVar.f570a.setText(measureWithTwoValues.getTitle());
            jVar.f571b.setText(measureWithTwoValues.getStringDate());
            if (((Boolean) measureWithTwoValues.getFirstValue()).booleanValue()) {
                imageView = jVar.f572c;
                i2 = this.f568c;
            } else {
                imageView = jVar.f572c;
                i2 = this.f569d;
            }
            imageView.setColorFilter(i2);
            if (((Boolean) measureWithTwoValues.getSecondValue()).booleanValue()) {
                imageView2 = jVar.f573d;
                i3 = this.f568c;
            } else {
                imageView2 = jVar.f573d;
                i3 = this.f569d;
            }
            imageView2.setColorFilter(i3);
            return view;
        }

        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public TextView f570a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f571b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f572c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f573d;

        public j() {
        }

        public j(a aVar) {
        }
    }

    public static void D(e eVar, ImageView imageView, boolean z) {
        if (eVar != null) {
            if (z) {
                imageView.setColorFilter(eVar.getResources().getColor(R.color.mama_menu_options_color));
            } else {
                imageView.clearColorFilter();
            }
            imageView.setTag(Boolean.valueOf(z));
            return;
        }
        throw null;
    }

    public void A() {
        this.i.setOnClickListener(new C0027e());
    }

    public void B() {
        this.h.setOnClickListener(new d());
    }

    public final void E() {
        Usuario i2 = AppMiniland.f().i();
        if (i2 != null) {
            C(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            new d.a(new MamaFetalMovListRequest(i2.getId(), i2.getPass()), this).start();
        }
    }

    public void F(a.c.d.s.e.d.b.c.b bVar) {
        getActivity().runOnUiThread(new f(bVar));
    }

    public void c(a.c.d.s.e.d.b.d.b bVar) {
        getActivity().runOnUiThread(new h(bVar));
    }

    public void g(a.c.d.s.e.d.b.a.b bVar) {
        getActivity().runOnUiThread(new g(bVar));
    }

    public boolean h() {
        if (this.s == null) {
            return false;
        }
        this.t.setBackgroundResource(p());
        this.s = null;
        y();
        return true;
    }

    public String n() {
        return a.c.a.d.a.h(R.string.TR_ANYADIR_NUEVA_MEDIDA).toUpperCase();
    }

    public View.OnClickListener o() {
        return new a();
    }

    public void onStart() {
        super.onStart();
        a.c.a.e.f.c().e("MI_EMBARAZO_MAMA_MOV_FETAL");
    }

    public int q() {
        return R.layout.fragment_mama_baby_movements;
    }

    public String r() {
        return MamaMainActivity.b.MAMA_OPTION_BABY_MOVEMENTS.f4048b.toUpperCase();
    }

    public void t() {
        this.l.setOnItemLongClickListener(new b());
        this.l.setOnItemClickListener(new c());
    }

    public void u() {
        this.l = (ListView) m(R.id.lv_mama_baby_movements);
    }

    public void w() {
    }

    public void x() {
        Dialog dialog = new Dialog(getActivity(), 16973941);
        this.n = dialog;
        dialog.setContentView(R.layout.dialog_pregnancy_mama_baby_movements);
        ((TextView) this.n.findViewById(R.id.tv_dialog_baby_movements)).setText(a.c.a.d.a.h(R.string.TR_MOVIMIENTOS_FETALES));
        ((TextView) this.n.findViewById(R.id.tv_date)).setText(a.c.a.d.a.h(R.string.TR_FECHA));
        ImageView imageView = (ImageView) this.n.findViewById(R.id.img_dialog_baby_movements_1);
        this.v = imageView;
        imageView.setTag(Boolean.FALSE);
        this.v.setOnClickListener(new g(this));
        this.o = this.v;
        ImageView imageView2 = (ImageView) this.n.findViewById(R.id.img_dialog_baby_movements_2);
        this.w = imageView2;
        imageView2.setTag(Boolean.FALSE);
        this.w.setOnClickListener(new h(this));
        this.p = this.w;
        TextView textView = (TextView) this.n.findViewById(R.id.tv_dialog_cancel);
        textView.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        textView.setOnClickListener(new i(this));
        TextView textView2 = (TextView) this.n.findViewById(R.id.tv_dialog_save);
        textView2.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
        textView2.setOnClickListener(new j(this));
        TextView textView3 = (TextView) this.n.findViewById(R.id.dialog_mama_dateselector);
        this.q = textView3;
        ((LinearLayout) this.n.findViewById(R.id.dialog_mama_select_date_container)).setOnClickListener(new b(this, textView3));
        i iVar = new i(this, getActivity());
        this.m = iVar;
        this.l.setAdapter(iVar);
        E();
    }
}
