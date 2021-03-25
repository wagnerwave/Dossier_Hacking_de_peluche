package a.c.d.m.e.l;

import a.c.a.d.a;
import a.c.a.e.f;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;
import com.sozpic.miniland.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class m extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public TextView f423a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f424b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f425c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f426d;

    /* renamed from: e  reason: collision with root package name */
    public n f427e;
    public List<UltrasoundPhoto> f;
    public ImageView g;

    public void m(UltrasoundPhoto ultrasoundPhoto) {
        this.f.add(0, ultrasoundPhoto);
        n nVar = this.f427e;
        nVar.f428a.add(0, ultrasoundPhoto.getPhotoPath());
        this.f427e.notifyDataSetChanged();
        this.f426d.setCurrentItem(0);
        this.f423a.setText(ultrasoundPhoto.getDescription());
        this.f424b.setText(ultrasoundPhoto.getTitle());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4023 && i2 == -1) {
            m((UltrasoundPhoto) intent.getParcelableExtra("ARGS_ECOGRAPHY_PHOTO"));
            if (getActivity() instanceof MyPregnancyFragmentContainerActivity) {
                ((MyPregnancyFragmentContainerActivity) getActivity()).r();
            }
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ecography, viewGroup, false);
        this.f423a = (TextView) inflate.findViewById(R.id.ecography_text_mi_nino_esta_grandisimo);
        this.g = (ImageView) inflate.findViewById(R.id.ecography_button_add_ultrasound);
        this.f426d = (ViewPager) inflate.findViewById(R.id.ecography_viewpager);
        this.f424b = (TextView) inflate.findViewById(R.id.ecography_text_semana_23);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.ecography_header);
        this.f425c = viewGroup2;
        ((ImageView) viewGroup2.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_ecography_baby);
        ((TextView) this.f425c.findViewById(R.id.pregnancy_section_header_title)).setText(a.h(R.string.TR_BEBE).toUpperCase());
        ((TextView) this.f425c.findViewById(R.id.pregnancy_section_header_subtitle)).setText(a.h(R.string.TR_ECOGRAFIA).toUpperCase());
        this.f426d.setOnLongClickListener(new i(this));
        this.g.setOnClickListener(new j(this));
        n nVar = new n();
        this.f427e = nVar;
        this.f426d.setAdapter(nVar);
        this.f426d.setOnLongClickListener(new g(this));
        this.f423a.setBackgroundColor(0);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        f.c().e("MI_EMBARAZO_BEBE_ECOGRAFIA");
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ArrayList<UltrasoundPhoto> parcelableArrayList = getArguments().getParcelableArrayList("ARGS_PHOTO_LIST");
        this.f = parcelableArrayList;
        if (!parcelableArrayList.isEmpty()) {
            this.f423a.setText(((UltrasoundPhoto) parcelableArrayList.get(0)).getDescription());
            this.f424b.setText(((UltrasoundPhoto) parcelableArrayList.get(0)).getTitle());
            LinkedList linkedList = new LinkedList();
            for (UltrasoundPhoto photoPath : parcelableArrayList) {
                linkedList.add(photoPath.getPhotoPath());
            }
            n nVar = this.f427e;
            nVar.f428a = linkedList;
            nVar.notifyDataSetChanged();
            this.f426d.addOnPageChangeListener(new h(this, parcelableArrayList));
        }
    }
}
