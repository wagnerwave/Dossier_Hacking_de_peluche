package com.cuatroochenta.miniland.pregnancy.baby;

import a.c.d.m.e.e;
import a.c.d.m.e.g;
import a.c.d.m.e.h;
import a.c.d.m.e.k.f;
import a.c.d.m.e.k.i;
import a.c.d.m.e.k.o;
import a.c.d.m.e.l.m;
import a.c.d.m.e.l.n;
import a.c.d.s.e.a.c.a.c;
import a.c.d.s.e.a.c.d.d;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.cuatroochenta.miniland.model.MedicalDataEntry;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.add.MedicalDataEntryDataAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.add.UltrasoundAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.list.UltrasoundListRequest;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.ArrayList;

public class MyPregnancyFragmentContainerActivity extends a.c.d.c {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f3944b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f3945c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f3946d;

    /* renamed from: e  reason: collision with root package name */
    public Fragment f3947e;
    public LinearLayout f;
    public LinearLayout g;
    public boolean h;
    public ImageView i;
    public ImageView j;
    public ArrayList<UltrasoundPhoto> k;
    public ImageView l;
    public ImageView m;
    public TopMenuActivity n;

    public class a implements a.c.d.s.e.a.c.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f3948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UltrasoundPhoto f3949b;

        /* renamed from: com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity$a$a  reason: collision with other inner class name */
        public class C0091a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.c.d.s.e.a.c.a.b f3951a;

            public C0091a(a.c.d.s.e.a.c.a.b bVar) {
                this.f3951a = bVar;
            }

            public void run() {
                a.this.f3948a.dismiss();
                if (this.f3951a.f42a.booleanValue()) {
                    a.this.f3949b.setId(this.f3951a.f936c);
                    a aVar = a.this;
                    MyPregnancyFragmentContainerActivity.this.k.add(aVar.f3949b);
                    a aVar2 = a.this;
                    Fragment fragment = MyPregnancyFragmentContainerActivity.this.f3947e;
                    if (fragment instanceof m) {
                        ((m) fragment).m(aVar2.f3949b);
                        return;
                    }
                    return;
                }
                a.c.a.f.b.j0(MyPregnancyFragmentContainerActivity.this, this.f3951a.f43b);
            }
        }

        public a(ProgressDialog progressDialog, UltrasoundPhoto ultrasoundPhoto) {
            this.f3948a = progressDialog;
            this.f3949b = ultrasoundPhoto;
        }

        public void a(a.c.d.s.e.a.c.a.b bVar) {
            MyPregnancyFragmentContainerActivity.this.runOnUiThread(new C0091a(bVar));
        }
    }

    public class b implements a.c.d.s.e.a.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f3953a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MedicalDataEntry f3954b;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.c.d.s.e.a.b.a.b f3956a;

            public a(a.c.d.s.e.a.b.a.b bVar) {
                this.f3956a = bVar;
            }

            public void run() {
                b.this.f3953a.dismiss();
                if (this.f3956a.f42a.booleanValue()) {
                    b.this.f3954b.setId(this.f3956a.f916c);
                    b bVar = b.this;
                    Fragment fragment = MyPregnancyFragmentContainerActivity.this.f3947e;
                    if (fragment instanceof o) {
                        MedicalDataEntry medicalDataEntry = bVar.f3954b;
                        Fragment fragment2 = ((o) fragment).f392a;
                        if (fragment2 instanceof i) {
                            i iVar = (i) fragment2;
                            if (iVar != null) {
                                ProgressDialog progressDialog = new ProgressDialog(iVar.getActivity());
                                progressDialog.show();
                                new a.c.d.s.e.a.b.a.c().a(new MedicalDataEntryDataAddRequest(medicalDataEntry), new f(iVar, medicalDataEntry, progressDialog));
                                return;
                            }
                            throw null;
                        }
                        return;
                    }
                    return;
                }
                a.c.a.f.b.j0(MyPregnancyFragmentContainerActivity.this, this.f3956a.f43b);
            }
        }

        public b(ProgressDialog progressDialog, MedicalDataEntry medicalDataEntry) {
            this.f3953a = progressDialog;
            this.f3954b = medicalDataEntry;
        }

        public void a(a.c.d.s.e.a.b.a.b bVar) {
            MyPregnancyFragmentContainerActivity.this.runOnUiThread(new a(bVar));
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity = MyPregnancyFragmentContainerActivity.this;
            myPregnancyFragmentContainerActivity.startActivityForResult(new Intent(myPregnancyFragmentContainerActivity, UltrasoundFormActivity.class), 9842);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 9842) {
            if (i3 == -1 && intent != null) {
                this.k.add((UltrasoundPhoto) intent.getParcelableExtra("ARGS_ECOGRAPHY_PHOTO"));
                s(0);
            }
        } else if (i2 == 2480) {
            if (i3 != -1) {
                return;
            }
            if (intent.getAction().equals("ACTION_ECOGRAPHY_ADDED")) {
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.show();
                UltrasoundPhoto ultrasoundPhoto = (UltrasoundPhoto) intent.getParcelableExtra("ARGS_ECOGRAPHY_PHOTO");
                new c.b(new UltrasoundAddRequest(ultrasoundPhoto), new a(progressDialog, ultrasoundPhoto)).start();
            } else if (intent.getAction().equals("ACTION_MEDICAL_ENTRY_ADDED")) {
                ProgressDialog progressDialog2 = new ProgressDialog(this);
                progressDialog2.show();
                MedicalDataEntry medicalDataEntry = (MedicalDataEntry) intent.getParcelableExtra("ARGS_MEDICAL_DATA_ENTRY");
                new a.c.d.s.e.a.b.a.c().a(new MedicalDataEntryDataAddRequest(medicalDataEntry), new b(progressDialog2, medicalDataEntry));
            }
        } else if (i2 == 1932) {
            if (i3 == -1) {
                UltrasoundPhoto ultrasoundPhoto2 = (UltrasoundPhoto) intent.getParcelableExtra("ARGS_ECOGRAPHY_PHOTO");
                Fragment fragment = this.f3947e;
                if (fragment instanceof m) {
                    m mVar = (m) fragment;
                    mVar.f423a.setText(ultrasoundPhoto2.getDescription());
                    mVar.f424b.setText(ultrasoundPhoto2.getTitle());
                    mVar.f.set(mVar.f426d.getCurrentItem(), ultrasoundPhoto2);
                    n nVar = mVar.f427e;
                    nVar.f428a.set(mVar.f426d.getCurrentItem(), ultrasoundPhoto2.getPhotoPath());
                    mVar.f427e.notifyDataSetChanged();
                }
            }
        } else if (i2 == 48293 && i3 == -1) {
            MedicalDataEntry medicalDataEntry2 = (MedicalDataEntry) intent.getParcelableExtra("ARGS_MEDICAL_DATA_ENTRY");
            Fragment fragment2 = this.f3947e;
            if (fragment2 instanceof o) {
                o oVar = (o) fragment2;
                Fragment fragment3 = oVar.f392a;
                if (fragment3 instanceof i) {
                    i iVar = (i) fragment3;
                    a.c.d.m.e.k.a aVar = iVar.j;
                    int i4 = aVar.j;
                    if (!(((MedicalDataEntry) aVar.g()) == null || i4 == -1)) {
                        iVar.j.f803a.set(i4, medicalDataEntry2);
                        a.c.d.m.e.k.a aVar2 = iVar.j;
                        aVar2.h(aVar2.j);
                        aVar2.f();
                        iVar.j.notifyDataSetChanged();
                    }
                }
                if (oVar.getActivity() instanceof MyPregnancyFragmentContainerActivity) {
                    ((MyPregnancyFragmentContainerActivity) oVar.getActivity()).r();
                }
            }
        }
    }

    public void onBackPressed() {
        if (this.h) {
            r();
            Fragment fragment = this.f3947e;
            if (fragment instanceof o) {
                Fragment fragment2 = ((o) fragment).f392a;
                if (fragment2 instanceof i) {
                    i iVar = (i) fragment2;
                    a.c.d.m.e.k.a aVar = iVar.j;
                    aVar.h(aVar.j);
                    aVar.f();
                    iVar.j.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_pregnancy_fragment_container);
        this.l = (ImageView) findViewById(R.id.my_pregnancy_fragment_container_button_ecography);
        this.f = (LinearLayout) findViewById(R.id.my_pregnancy_fragment_container_bottombar_normal);
        this.g = (LinearLayout) findViewById(R.id.my_pregnancy_fragment_container_bottombar_edit);
        this.i = (ImageView) findViewById(R.id.my_pregnancy_fragment_container_button_delete);
        this.f3945c = (ImageView) findViewById(R.id.my_pregnancy_fragment_container_button_graph);
        this.j = (ImageView) findViewById(R.id.my_pregnancy_fragment_container_button_edit);
        this.m = (ImageView) findViewById(R.id.my_pregnancy_fragment_container_button_rule);
        this.f3946d = (ImageView) findViewById(R.id.my_pregnancy_fragment_container_button_plus);
        this.n = (TopMenuActivity) findViewById(R.id.my_pregnancy_fragment_container_toolbar);
        new d.a(new UltrasoundListRequest(), new a.c.d.m.e.i(this)).start();
        s(getIntent().getIntExtra("ARGS_KEY_FRAGMENT_ID", 0));
        this.n.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO));
        this.n.setListener(this);
        this.l.setOnClickListener(new a.c.d.m.e.c(this));
        this.m.setOnClickListener(new a.c.d.m.e.d(this));
        this.f3945c.setOnClickListener(new e(this));
        this.f3946d.setOnClickListener(new a.c.d.m.e.f(this));
        this.j.setOnClickListener(new g(this));
        this.i.setOnClickListener(new h(this));
    }

    public void q() {
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        this.h = true;
    }

    public void r() {
        this.h = false;
        this.f.setVisibility(0);
        this.g.setVisibility(8);
    }

    public void s(int i2) {
        FragmentTransaction beginTransaction;
        Fragment mVar;
        FragmentTransaction fragmentTransaction;
        if (i2 == 0) {
            ArrayList<UltrasoundPhoto> arrayList = this.k;
            if (arrayList == null || arrayList.isEmpty()) {
                new AlertDialog.Builder(this).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new d()).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new c(this)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_NO_TIENES_NINGUNA_ECOGRAFIA)).show();
                return;
            }
            t(this.l);
            beginTransaction = getSupportFragmentManager().beginTransaction();
            ArrayList<UltrasoundPhoto> arrayList2 = this.k;
            mVar = new m();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("ARGS_PHOTO_LIST", arrayList2);
            mVar.setArguments(bundle);
        } else if (i2 == 1) {
            t(this.m);
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            o oVar = new o();
            oVar.setArguments(new Bundle());
            this.f3947e = oVar;
            fragmentTransaction = beginTransaction2.replace(R.id.my_pregnancy_fragment_container_container, oVar);
            fragmentTransaction.commit();
        } else if (i2 == 2) {
            t(this.f3945c);
            beginTransaction = getSupportFragmentManager().beginTransaction();
            mVar = new o();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("ARGS_INITIAL_FRAGMENT", 3);
            mVar.setArguments(bundle2);
        } else {
            return;
        }
        this.f3947e = mVar;
        fragmentTransaction = beginTransaction.replace(R.id.my_pregnancy_fragment_container_container, mVar);
        fragmentTransaction.commit();
    }

    public final void t(ImageView imageView) {
        imageView.setColorFilter(getResources().getColor(R.color.pregnancy_button_state_selected_unpressed));
        ImageView imageView2 = this.f3944b;
        if (imageView2 != null) {
            imageView2.clearColorFilter();
        }
        this.f3944b = imageView;
    }
}
