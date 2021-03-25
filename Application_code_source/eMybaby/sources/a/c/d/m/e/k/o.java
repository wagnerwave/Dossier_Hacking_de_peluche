package a.c.d.m.e.k;

import a.c.a.e.f;
import a.c.d.m.e.j.e;
import a.c.d.r.i;
import a.c.d.s.e.a.b.a.b;
import a.c.d.s.e.a.b.a.c;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.cuatroochenta.miniland.model.MedicalDataEntry;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.add.MedicalDataEntryDataAddRequest;
import com.google.android.material.badge.BadgeDrawable;
import com.sozpic.miniland.R;
import java.util.Calendar;
import java.util.Date;

public class o extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public Fragment f392a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f393b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f394c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f395d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f396e;

    public class a implements a.c.d.s.e.a.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MedicalDataEntry f397a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f398b;

        /* renamed from: a.c.d.m.e.k.o$a$a  reason: collision with other inner class name */
        public class C0023a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f400a;

            public C0023a(b bVar) {
                this.f400a = bVar;
            }

            public void run() {
                if (this.f400a.f42a.booleanValue()) {
                    a.this.f397a.setId(this.f400a.f916c);
                    a aVar = a.this;
                    Fragment fragment = o.this.f392a;
                    if (fragment instanceof i) {
                        i iVar = (i) fragment;
                        iVar.j.f803a.add(aVar.f397a);
                        iVar.j.notifyDataSetChanged();
                    }
                } else {
                    a.c.a.f.b.j0(o.this.getActivity(), this.f400a.f43b);
                }
                a.this.f398b.dismiss();
            }
        }

        public a(MedicalDataEntry medicalDataEntry, ProgressDialog progressDialog) {
            this.f397a = medicalDataEntry;
            this.f398b = progressDialog;
        }

        public void a(b bVar) {
            o.this.getActivity().runOnUiThread(new C0023a(bVar));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4293 && i2 == -1) {
            MedicalDataEntry medicalDataEntry = (MedicalDataEntry) intent.getParcelableExtra("ARGS_MEDICAL_DATA_ENTRY");
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.show();
            new c().a(new MedicalDataEntryDataAddRequest(medicalDataEntry), new a(medicalDataEntry, progressDialog));
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Fragment fragment;
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_medical_data, viewGroup, false);
        this.f393b = (ViewGroup) inflate.findViewById(R.id.medical_data_header);
        this.f394c = (TextView) inflate.findViewById(R.id.medical_data_text_weeks);
        this.f395d = (TextView) inflate.findViewById(R.id.medical_data_button_anadir_nuevos_datos);
        this.f396e = (TextView) inflate.findViewById(R.id.medical_data_label_semanas_hoy);
        ((TextView) this.f393b.findViewById(R.id.pregnancy_section_header_title)).setText(a.c.a.d.a.h(R.string.TR_BEBE).toUpperCase());
        ((TextView) this.f393b.findViewById(R.id.pregnancy_section_header_subtitle)).setText(a.c.a.d.a.h(R.string.TR_DATOS_MEDICOS).toUpperCase());
        ((ImageView) this.f393b.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_baby_radiography_rotated);
        this.f395d.setText(a.c.a.d.a.h(R.string.TR_ANADIR_NUEVOS_DATOS).toUpperCase());
        this.f396e.setText(a.c.a.d.a.h(R.string.TR_SEMANAS_HOY).toUpperCase());
        int i2 = getArguments().getInt("ARGS_INITIAL_FRAGMENT", 0);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i3 = 1;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    if (i2 != 4) {
                        fragment = new i();
                        this.f392a = fragment;
                        beginTransaction.replace(R.id.medical_data_fragment_container, fragment);
                        beginTransaction.commit();
                        this.f395d.setOnClickListener(new n(this));
                        Date time = Calendar.getInstance().getTime();
                        TextView textView = this.f394c;
                        String str = i.c(time) + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + i.a(time);
                        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.6f);
                        SpannableString spannableString = new SpannableString(str);
                        spannableString.setSpan(relativeSizeSpan, str.length() - 2, str.length(), 33);
                        textView.setText(spannableString);
                        return inflate;
                    }
                }
            }
            fragment = e.o(i3);
            this.f392a = fragment;
            beginTransaction.replace(R.id.medical_data_fragment_container, fragment);
            beginTransaction.commit();
            this.f395d.setOnClickListener(new n(this));
            Date time2 = Calendar.getInstance().getTime();
            TextView textView2 = this.f394c;
            String str2 = i.c(time2) + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + i.a(time2);
            RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(0.6f);
            SpannableString spannableString2 = new SpannableString(str2);
            spannableString2.setSpan(relativeSizeSpan2, str2.length() - 2, str2.length(), 33);
            textView2.setText(spannableString2);
            return inflate;
        }
        fragment = e.o(i);
        this.f392a = fragment;
        beginTransaction.replace(R.id.medical_data_fragment_container, fragment);
        beginTransaction.commit();
        this.f395d.setOnClickListener(new n(this));
        Date time22 = Calendar.getInstance().getTime();
        TextView textView22 = this.f394c;
        String str22 = i.c(time22) + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + i.a(time22);
        RelativeSizeSpan relativeSizeSpan22 = new RelativeSizeSpan(0.6f);
        SpannableString spannableString22 = new SpannableString(str22);
        spannableString22.setSpan(relativeSizeSpan22, str22.length() - 2, str22.length(), 33);
        textView22.setText(spannableString22);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        f.c().e("MI_EMBARAZO_BEBE_DATOS");
    }
}
