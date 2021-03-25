package a.c.d.m;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTListActivity;
import com.cuatroochenta.miniland.pregnancy.mama.MamaMainActivity;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AppointmentListActivity;
import com.cuatroochenta.miniland.pregnancy.settings.ActivityPrengnacySettings;
import com.cuatroochenta.miniland.pregnancy.sounds.PregnancySoundsListActivity;
import com.sozpic.miniland.R;

public class d extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public GridView f339a;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c cVar = (c) d.this.f339a.getAdapter();
            if (cVar != null) {
                String str = cVar.f336b.get(i);
                d dVar = d.this;
                if (dVar == null) {
                    throw null;
                } else if (!a.c.a.d.a.j(str)) {
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case -1989339448:
                            if (str.equals("PREGNANCY_BABY")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 74386105:
                            if (str.equals("PREGNANCY_MOM")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 605322517:
                            if (str.equals("PREGNANCY_SETTINGS")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case 725961642:
                            if (str.equals("PREGNANCY_ESCUCHA")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 770540654:
                            if (str.equals("PREGNANCY_JOURNEY")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 1191154821:
                            if (str.equals("PREGNANCY_MY_SOUNDS")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1207341346:
                            if (str.equals("PREGNANCY_MEDICAL_RECORDS")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1768460655:
                            if (str.equals("PREGNANCY_CONTRACTIONS")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            a.a.a.a.a.t(dVar.getActivity(), PregnancyBTListActivity.class);
                            return;
                        case 1:
                            a.a.a.a.a.t(dVar.getActivity(), PregnancySoundsListActivity.class);
                            return;
                        case 2:
                            a.a.a.a.a.t(dVar.getActivity(), PregnancyContractionListActivity.class);
                            return;
                        case 3:
                            FragmentActivity activity = dVar.getActivity();
                            Intent intent = new Intent(activity, MyPregnancyFragmentContainerActivity.class);
                            intent.putExtra("ARGS_KEY_FRAGMENT_ID", 1);
                            activity.startActivity(intent);
                            return;
                        case 4:
                            a.a.a.a.a.t(dVar.getActivity(), MamaMainActivity.class);
                            return;
                        case 5:
                            a.a.a.a.a.t(dVar.getActivity(), AppointmentListActivity.class);
                            return;
                        case 6:
                            a.a.a.a.a.t(dVar.getActivity(), BabyDiaryActivity.class);
                            return;
                        case 7:
                            if (dVar.isAdded()) {
                                ActivityPrengnacySettings.q(dVar.getActivity());
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_mybuddy_menu, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.menu_buddy_list);
        this.f339a = gridView;
        gridView.setOnItemClickListener(new a());
        c cVar = (c) this.f339a.getAdapter();
        if (cVar == null) {
            cVar = new c(getActivity());
            this.f339a.setAdapter(cVar);
        }
        cVar.f336b.clear();
        cVar.f336b.add("PREGNANCY_ESCUCHA");
        cVar.f336b.add("PREGNANCY_MY_SOUNDS");
        cVar.f336b.add("PREGNANCY_BABY");
        cVar.f336b.add("PREGNANCY_MOM");
        cVar.f336b.add("PREGNANCY_MEDICAL_RECORDS");
        cVar.f336b.add("PREGNANCY_CONTRACTIONS");
        cVar.f336b.add("PREGNANCY_JOURNEY");
        cVar.f336b.add("PREGNANCY_SETTINGS");
        cVar.notifyDataSetChanged();
        return inflate;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}
