package a.h.a;

import a.h.a.k0.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.MainActivity;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.ElementoMenu;

public class k extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public View f3483a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f3484b;

    /* renamed from: c  reason: collision with root package name */
    public ElementoMenu[] f3485c;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (k.this.f3484b.getAdapter().getItem(i) instanceof ElementoMenu) {
                ((MainActivity) k.this.getActivity()).s(((ElementoMenu) k.this.f3484b.getAdapter().getItem(i)).getId(), true);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_menu_lateral_izquierdo, viewGroup, false);
        this.f3483a = inflate;
        this.f3484b = (ListView) inflate.findViewById(R.id.list);
        this.f3485c = new ElementoMenu[15];
        ElementoMenu C = a.a.a.a.a.C(0);
        a.a.a.a.a.s(R.string.TR_MAIN, C, R.drawable.ic_menu_lateral_home);
        this.f3485c[0] = C;
        ElementoMenu C2 = a.a.a.a.a.C(1);
        a.a.a.a.a.s(R.string.TR_MENU_MY_BABY, C2, R.drawable.ic_menu_lateral_baby);
        this.f3485c[1] = C2;
        ElementoMenu C3 = a.a.a.a.a.C(2);
        a.a.a.a.a.s(R.string.TR_MENU_FAMILY, C3, R.drawable.ic_menu_lateral_family);
        this.f3485c[2] = C3;
        ElementoMenu C4 = a.a.a.a.a.C(3);
        a.a.a.a.a.s(R.string.TR_MENU_CAMERA, C4, R.drawable.ic_menu_lateral_baby_monitor);
        this.f3485c[3] = C4;
        ElementoMenu C5 = a.a.a.a.a.C(4);
        a.a.a.a.a.s(R.string.TR_MENU_MI_EMBARAZO, C5, R.drawable.ic_menu_lateral_pregnancy);
        this.f3485c[4] = C5;
        ElementoMenu C6 = a.a.a.a.a.C(5);
        a.a.a.a.a.s(R.string.TR_BEMYBUDDY_TITLE_IOS, C6, R.drawable.ic_menu_lateral_buddy);
        this.f3485c[5] = C6;
        ElementoMenu C7 = a.a.a.a.a.C(6);
        a.a.a.a.a.s(R.string.TR_THERMOMETER, C7, R.drawable.ic_menu_lateral_termo);
        this.f3485c[6] = C7;
        ElementoMenu C8 = a.a.a.a.a.C(7);
        a.a.a.a.a.s(R.string.TR_EMYSCALE, C8, R.drawable.ic_menu_lateral_myscale);
        this.f3485c[7] = C8;
        ElementoMenu C9 = a.a.a.a.a.C(8);
        a.a.a.a.a.s(R.string.TR_MENU_HUMIDIFICADOR, C9, R.drawable.ic_menu_lateral_humidificador);
        this.f3485c[8] = C9;
        ElementoMenu C10 = a.a.a.a.a.C(9);
        a.a.a.a.a.s(R.string.TR_MENU_MEDICAL_RECORDS, C10, R.drawable.ic_menu_lateral_medical_record);
        this.f3485c[9] = C10;
        ElementoMenu C11 = a.a.a.a.a.C(10);
        a.a.a.a.a.s(R.string.TR_MENU_PHOTO_ALBUM, C11, R.drawable.ic_menu_lateral_photo);
        this.f3485c[10] = C11;
        ElementoMenu C12 = a.a.a.a.a.C(11);
        a.a.a.a.a.s(R.string.TR_MENU_NUTRICION, C12, R.drawable.ic_menu_lateral_nutricion);
        this.f3485c[11] = C12;
        ElementoMenu C13 = a.a.a.a.a.C(12);
        a.a.a.a.a.s(R.string.TR_MENU_MINILAND_WORLD, C13, R.drawable.ic_menu_lateral_world);
        this.f3485c[12] = C13;
        ElementoMenu C14 = a.a.a.a.a.C(13);
        a.a.a.a.a.s(R.string.TR_MENU_CALENDAR, C14, R.drawable.ic_menu_lateral_calendar);
        this.f3485c[13] = C14;
        ElementoMenu C15 = a.a.a.a.a.C(14);
        a.a.a.a.a.s(R.string.TR_MENU_SETTINGS, C15, R.drawable.ic_menu_lateral_settings);
        this.f3485c[14] = C15;
        this.f3484b.setAdapter(new e(getActivity(), this.f3485c));
        this.f3484b.setOnItemClickListener(new a());
        return this.f3483a;
    }
}
