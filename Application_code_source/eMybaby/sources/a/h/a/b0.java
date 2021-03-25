package a.h.a;

import a.c.a.d.a;
import a.c.a.e.f;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.MainActivity;
import com.sozpic.miniland.R;

public class b0 extends Fragment implements View.OnClickListener {
    public void onClick(View view) {
        int i;
        switch (view.getId()) {
            case R.id.x1 /*2131297857*/:
                i = 3;
                break;
            case R.id.x10 /*2131297858*/:
                i = 10;
                break;
            case R.id.x11 /*2131297859*/:
                i = 11;
                break;
            case R.id.x12 /*2131297860*/:
                i = 12;
                break;
            case R.id.x13 /*2131297861*/:
                i = 13;
                break;
            case R.id.x14 /*2131297862*/:
                i = 14;
                break;
            case R.id.x2 /*2131297863*/:
                i = 6;
                break;
            case R.id.x3 /*2131297864*/:
                i = 1;
                break;
            case R.id.x4 /*2131297865*/:
                i = 7;
                break;
            case R.id.x5 /*2131297866*/:
                i = 2;
                break;
            case R.id.x6 /*2131297867*/:
                i = 8;
                break;
            case R.id.x7 /*2131297868*/:
                i = 4;
                break;
            case R.id.x8 /*2131297869*/:
                i = 5;
                break;
            case R.id.x9 /*2131297870*/:
                i = 9;
                break;
            default:
                i = -1;
                break;
        }
        ((MainActivity) getActivity()).s(i, false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tmibebe)).setText(a.h(R.string.TR_MENU_MY_BABY).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_family)).setText(a.h(R.string.TR_MENU_FAMILY).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_camera)).setText(a.h(R.string.TR_MENU_CAMERA).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_termometro)).setText(a.h(R.string.TR_THERMOMETER).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_buddy)).setText(a.h(R.string.TR_BEMYBUDDY_TITLE_IOS).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_menu_humidificador)).setText(a.h(R.string.TR_MENU_HUMIDIFICADOR).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_ficha_medica)).setText(a.h(R.string.TR_MENU_MEDICAL_RECORDS).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_menu_album_fotos)).setText(a.h(R.string.TR_MENU_PHOTO_ALBUM).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_emyscale)).setText(a.h(R.string.TR_EMYSCALE).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_ajustes)).setText(a.h(R.string.TR_MENU_SETTINGS).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_my_pregnancy)).setText(a.h(R.string.TR_MENU_MI_EMBARAZO).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_menu_calendario)).setText(a.h(R.string.TR_MENU_CALENDAR).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_menu_nutrition)).setText(a.h(R.string.TR_MENU_NUTRICION).toUpperCase());
        ((TextView) inflate.findViewById(R.id.menu_text_menu_world)).setText(a.h(R.string.TR_MENU_MINILAND_WORLD).toUpperCase());
        ((ImageView) inflate.findViewById(R.id.x1)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x2)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x3)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x4)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x5)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x6)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x7)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x8)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x9)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x10)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x11)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x12)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x13)).setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.x14)).setOnClickListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        f.c().e("MENU");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
    }
}
