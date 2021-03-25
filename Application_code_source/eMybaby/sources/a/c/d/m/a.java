package a.c.d.m;

import a.c.d.r.j;
import a.c.d.s.e.f.a.e;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MainActivity;
import com.sozpic.miniland.R;
import java.util.Calendar;

public class a extends Fragment implements a.c.d.s.e.f.a.a, a.h.a.a {

    /* renamed from: a  reason: collision with root package name */
    public i f314a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f315b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f316c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f317d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f318e;
    public TextView f;
    public ViewGroup g;
    public TextView h;
    public Calendar i;
    public Calendar j;
    public Calendar k;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public TextView s;

    /* renamed from: a.c.d.m.a$a  reason: collision with other inner class name */
    public class C0018a implements View.OnClickListener {

        /* renamed from: a.c.d.m.a$a$a  reason: collision with other inner class name */
        public class C0019a implements DatePickerDialog.OnDateSetListener {
            public C0019a() {
            }

            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                a aVar = a.this;
                if (aVar.i == null) {
                    aVar.i = Calendar.getInstance();
                }
                a.this.i.set(1, i);
                a.this.i.set(2, i2);
                a.this.i.set(5, i3);
                a aVar2 = a.this;
                aVar2.f317d.setText(j.h.format(aVar2.i.getTime()));
            }
        }

        public C0018a() {
        }

        public void onClick(View view) {
            int i;
            int i2;
            int i3;
            Calendar calendar = a.this.i;
            if (calendar != null) {
                int i4 = calendar.get(1);
                int i5 = a.this.i.get(2);
                i3 = i4;
                i = a.this.i.get(5);
                i2 = i5;
            } else {
                Calendar instance = Calendar.getInstance();
                int i6 = instance.get(1);
                int i7 = instance.get(2);
                i = instance.get(5);
                i2 = i7;
                i3 = i6;
            }
            new DatePickerDialog(a.this.getActivity(), new C0019a(), i3, i2, i).show();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            a.m(a.this);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.this.f316c.setVisibility(0);
            a.this.i = null;
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            a.m(a.this);
        }
    }

    public class e implements View.OnClickListener {

        /* renamed from: a.c.d.m.a$e$a  reason: collision with other inner class name */
        public class C0020a implements DatePickerDialog.OnDateSetListener {
            public C0020a() {
            }

            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                a aVar = a.this;
                if (aVar.j == null) {
                    aVar.j = Calendar.getInstance();
                }
                a.this.j.set(1, i);
                a.this.j.set(2, i2);
                a.this.j.set(5, i3);
                a aVar2 = a.this;
                if (aVar2.i == null) {
                    aVar2.i = Calendar.getInstance();
                }
                a aVar3 = a.this;
                aVar3.i.setTime(aVar3.j.getTime());
                a.this.i.add(6, 280);
                a aVar4 = a.this;
                aVar4.f318e.setText(j.h.format(aVar4.j.getTime()));
                a.n(a.this);
            }
        }

        public e() {
        }

        public void onClick(View view) {
            int i;
            int i2;
            int i3;
            Calendar calendar = a.this.j;
            if (calendar != null) {
                int i4 = calendar.get(1);
                int i5 = a.this.j.get(2);
                i3 = i4;
                i = a.this.j.get(5);
                i2 = i5;
            } else {
                Calendar instance = Calendar.getInstance();
                int i6 = instance.get(1);
                int i7 = instance.get(2);
                i = instance.get(5);
                i2 = i7;
                i3 = i6;
            }
            new DatePickerDialog(a.this.getActivity(), new C0020a(), i3, i2, i).show();
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: a.c.d.m.a$f$a  reason: collision with other inner class name */
        public class C0021a implements DatePickerDialog.OnDateSetListener {
            public C0021a() {
            }

            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                a aVar = a.this;
                if (aVar.k == null) {
                    aVar.k = Calendar.getInstance();
                }
                a.this.k.set(1, i);
                a.this.k.set(2, i2);
                a.this.k.set(5, i3);
                a aVar2 = a.this;
                if (aVar2.i == null) {
                    aVar2.i = Calendar.getInstance();
                }
                a aVar3 = a.this;
                aVar3.i.setTime(aVar3.k.getTime());
                a.this.i.add(6, 266);
                a aVar4 = a.this;
                aVar4.f.setText(j.h.format(aVar4.k.getTime()));
                a.n(a.this);
            }
        }

        public f() {
        }

        public void onClick(View view) {
            int i;
            int i2;
            int i3;
            Calendar calendar = a.this.k;
            if (calendar != null) {
                int i4 = calendar.get(1);
                int i5 = a.this.k.get(2);
                i3 = i4;
                i = a.this.k.get(5);
                i2 = i5;
            } else {
                Calendar instance = Calendar.getInstance();
                int i6 = instance.get(1);
                int i7 = instance.get(2);
                i = instance.get(5);
                i2 = i7;
                i3 = i6;
            }
            new DatePickerDialog(a.this.getActivity(), new C0021a(), i3, i2, i).show();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            a aVar = a.this;
            new e.a(new a.c.d.s.e.f.a.b(aVar.i.getTime()), new b(aVar)).start();
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.f.a.c f329a;

        /* renamed from: a.c.d.m.a$h$a  reason: collision with other inner class name */
        public class C0022a implements DialogInterface.OnClickListener {
            public C0022a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                i iVar = a.this.f314a;
                if (iVar != null) {
                    ((MainActivity) iVar).t();
                }
            }
        }

        public h(a.c.d.s.e.f.a.c cVar) {
            this.f329a = cVar;
        }

        public void run() {
            if (a.this.getActivity() instanceof a.c.d.c) {
                ((a.c.d.c) a.this.getActivity()).o();
            }
            if (this.f329a.f42a.booleanValue()) {
                a.c.a.f.b.m0(a.this.getActivity(), (String) null, a.c.a.d.a.h(R.string.TR_FECHA_PARTO_GUARDADA), a.c.a.d.a.h(R.string.TR_ACEPTAR), a.c.a.d.a.h(R.string.TR_CANCEL), new C0022a());
            } else {
                a.c.a.f.b.h0(a.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_GUARDANDO_FECHA_DE_PARTO), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            }
        }
    }

    public interface i {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m(a.c.d.m.a r16) {
        /*
            r0 = r16
            java.util.Calendar r1 = r0.i
            r2 = 2131820553(0x7f110009, float:1.9273824E38)
            r3 = 3
            r4 = 0
            r5 = 1
            if (r1 != 0) goto L_0x0014
            androidx.fragment.app.FragmentActivity r1 = r16.getActivity()
            r6 = 2131820936(0x7f110188, float:1.92746E38)
            goto L_0x003b
        L_0x0014:
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            r7 = 40
            r6.add(r3, r7)
            java.util.Calendar r7 = r0.i
            boolean r1 = r7.before(r1)
            if (r1 != 0) goto L_0x0034
            java.util.Calendar r1 = r0.i
            boolean r1 = r1.after(r6)
            if (r1 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 1
            goto L_0x0047
        L_0x0034:
            androidx.fragment.app.FragmentActivity r1 = r16.getActivity()
            r6 = 2131820951(0x7f110197, float:1.9274631E38)
        L_0x003b:
            java.lang.String r6 = a.c.a.d.a.h(r6)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            a.c.a.f.b.h0(r1, r6, r2)
            r1 = 0
        L_0x0047:
            if (r1 == 0) goto L_0x00de
            android.widget.RelativeLayout r1 = r0.l
            r1.setVisibility(r4)
            java.util.Calendar r1 = r0.i
            a.c.a.d.a.p(r1)
            java.util.Calendar r1 = r0.i
            java.lang.Object r1 = r1.clone()
            java.util.Calendar r1 = (java.util.Calendar) r1
            r2 = -40
            r1.add(r3, r2)
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            a.c.a.d.a.p(r2)
            long r6 = r2.getTimeInMillis()
            long r8 = r1.getTimeInMillis()
            long r6 = r6 - r8
            java.util.Calendar r1 = r0.i
            long r8 = r1.getTimeInMillis()
            long r1 = r2.getTimeInMillis()
            long r8 = r8 - r1
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r1 = r1.toDays(r6)
            r10 = 7
            long r1 = r1 % r10
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r6 = r3.toDays(r6)
            long r6 = r6 / r10
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r12 = r3.toDays(r8)
            long r12 = r12 % r10
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r8 = r3.toDays(r8)
            long r8 = r8 / r10
            android.widget.TextView r3 = r0.m
            java.util.Locale r10 = java.util.Locale.getDefault()
            r11 = 2131821306(0x7f1102fa, float:1.9275351E38)
            java.lang.String r14 = a.c.a.d.a.i(r11)
            r15 = 2
            java.lang.Object[] r11 = new java.lang.Object[r15]
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r11[r4] = r6
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r11[r5] = r1
            java.lang.String r1 = java.lang.String.format(r10, r14, r11)
            r3.setText(r1)
            android.widget.TextView r0 = r0.r
            java.util.Locale r1 = java.util.Locale.getDefault()
            r2 = 2131821306(0x7f1102fa, float:1.9275351E38)
            java.lang.String r2 = a.c.a.d.a.i(r2)
            java.lang.Object[] r3 = new java.lang.Object[r15]
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            r3[r4] = r6
            java.lang.Long r4 = java.lang.Long.valueOf(r12)
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r2, r3)
            r0.setText(r1)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.m.a.m(a.c.d.m.a):void");
    }

    public static void n(a aVar) {
        if (aVar.i != null) {
            aVar.g.setVisibility(0);
            aVar.h.setText(j.h.format(aVar.i.getTime()));
        }
    }

    public static a o(i iVar) {
        a aVar = new a();
        aVar.f314a = iVar;
        return aVar;
    }

    public void f(a.c.d.s.e.f.a.c cVar) {
        getActivity().runOnUiThread(new h(cVar));
    }

    public boolean i() {
        if (this.l.getVisibility() == 0) {
            this.l.setVisibility(8);
            return true;
        } else if (this.f316c.getVisibility() != 0) {
            return false;
        } else {
            this.f316c.setVisibility(8);
            return true;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        i iVar;
        if (!(AppMiniland.f().i().getBirthDate() == null || (iVar = this.f314a) == null)) {
            ((MainActivity) iVar).t();
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_pregnancy_introduce_date, (ViewGroup) null);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.frg_pregnancy_introduce_birth_container);
        this.f315b = viewGroup2;
        ((TextView) viewGroup2.findViewById(R.id.frg_pregnancy_introduce_birth_title)).setText(a.c.a.d.a.h(R.string.TR_MI_FECHA_DE_PARTO));
        ViewGroup viewGroup3 = (ViewGroup) this.f315b.findViewById(R.id.frg_pregnancy_introduce_birth_dateselector_container);
        viewGroup3.setOnClickListener(new C0018a());
        this.f317d = (TextView) viewGroup3.findViewById(R.id.frg_pregnancy_introduce_birth_dateselector);
        Button button = (Button) this.f315b.findViewById(R.id.frg_pregnancy_introduce_birth_save);
        button.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
        button.setTypeface(a.c.d.r.e.a().f790c);
        button.setOnClickListener(new b());
        TextView textView = (TextView) this.f315b.findViewById(R.id.frg_pregnancy_introduce_birth_dont_know);
        SpannableString spannableString = new SpannableString(a.c.a.d.a.h(R.string.TR_NO_SE_MI_FECHA_DE_PARTO));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        textView.setText(spannableString);
        textView.setOnClickListener(new c());
        ViewGroup viewGroup4 = (ViewGroup) inflate.findViewById(R.id.frg_pregnancy_introduce_calculator_container);
        this.f316c = viewGroup4;
        ((TextView) viewGroup4.findViewById(R.id.frg_pregnancy_introduce_calculator_title)).setText(a.c.a.d.a.h(R.string.TR_CALCULAR_MI_FECHA_DE_PARTO));
        ((TextView) this.f316c.findViewById(R.id.frg_pregnancy_calculator_period_title)).setText(a.c.a.d.a.h(R.string.TR_INDICAR_EL_PRIMER_DIA_DE_TU_ULTIMA_REGLA));
        ((TextView) this.f316c.findViewById(R.id.frg_pregnancy_calculator_conception_title)).setText(a.c.a.d.a.h(R.string.TR_O_LA_FECHA_DE_CONCEPCION));
        Button button2 = (Button) this.f316c.findViewById(R.id.frg_pregnancy_introduce_calculator_save);
        button2.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
        button2.setTypeface(a.c.d.r.e.a().f790c);
        button2.setOnClickListener(new d());
        ((ViewGroup) this.f316c.findViewById(R.id.frg_pregnancy_introduce_calculator_period_container)).setOnClickListener(new e());
        ((ViewGroup) this.f316c.findViewById(R.id.frg_pregnancy_introduce_calculator_conception_container)).setOnClickListener(new f());
        this.f = (TextView) this.f316c.findViewById(R.id.frg_pregnancy_calculator_conception_dateselector);
        this.f318e = (TextView) this.f316c.findViewById(R.id.frg_pregnancy_calculator_period_dateselector);
        this.f317d.setText(a.c.a.d.a.h(R.string.TR_CHOOSE_DATE));
        this.f318e.setText(a.c.a.d.a.h(R.string.TR_CHOOSE_DATE));
        this.f.setText(a.c.a.d.a.h(R.string.TR_CHOOSE_DATE));
        ViewGroup viewGroup5 = (ViewGroup) this.f316c.findViewById(R.id.frg_pregnancy_introduce_calculator_result_container);
        this.g = viewGroup5;
        viewGroup5.setVisibility(8);
        ((TextView) this.g.findViewById(R.id.frg_pregnancy_introduce_calculator_result_title)).setText(a.c.a.d.a.h(R.string.TR_EN_BASE_A_ESTO_TU_SALIDA_DE_CUENTAS_ES));
        this.h = (TextView) this.g.findViewById(R.id.frg_pregnancy_introduce_calculator_result_date);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.frg_pregnancy_result_container);
        this.l = relativeLayout;
        this.m = (TextView) relativeLayout.findViewById(R.id.pregnancy_weeks_days_left_text_5_semanas_1_dia);
        this.n = (TextView) this.l.findViewById(R.id.pregnancy_weeks_days_left_text_cuenta_atras);
        this.o = (TextView) this.l.findViewById(R.id.pregnancy_weeks_days_left_text_tu_embarazo);
        this.p = (LinearLayout) this.l.findViewById(R.id.pregnancy_weeks_days_left_button_continuar);
        this.q = (TextView) this.l.findViewById(R.id.pregnancy_weeks_days_left_text_felicidades);
        this.r = (TextView) this.l.findViewById(R.id.pregnancy_weeks_days_left_text_34_semanas_6_dias);
        this.s = (TextView) this.l.findViewById(R.id.pregnancy_weeks_days_left_text_continuar);
        this.n.setText(a.c.a.d.a.h(R.string.TR_CUENTA_ATRAS));
        this.o.setText(a.c.a.d.a.h(R.string.TR_TU_EMBARAZO));
        this.q.setText(a.c.a.d.a.h(R.string.TR_FELICIDADES));
        this.s.setText(a.c.a.d.a.h(R.string.TR_CONTINUAR));
        this.p.setOnClickListener(new g());
        return inflate;
    }

    public void onStart() {
        super.onStart();
        a.c.a.e.f.c().e("MI_EMBARAZO_FECHA_PARTO");
    }
}
