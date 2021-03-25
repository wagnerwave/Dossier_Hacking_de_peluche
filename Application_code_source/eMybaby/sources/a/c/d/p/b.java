package a.c.d.p;

import a.c.d.r.g;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MyProfileActivity;
import com.sozpic.miniland.R;

public class b extends Fragment implements g {

    /* renamed from: a  reason: collision with root package name */
    public TextView f762a;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Context context = b.this.getContext();
            context.startActivity(new Intent(context, MyProfileActivity.class));
        }
    }

    /* renamed from: a.c.d.p.b$b  reason: collision with other inner class name */
    public class C0040b implements View.OnClickListener {
        public C0040b() {
        }

        public void onClick(View view) {
            a.c.a.d.a.q(b.this.getActivity(), b.this);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            new a().show(b.this.getChildFragmentManager(), "CONTACT_SETTINGS_FRG");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.settings_profile);
        viewGroup2.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_section_opened));
        ((TextView) viewGroup2.findViewById(R.id.settings_item_name)).setText(a.c.a.d.a.h(R.string.TR_MI_PERFIL));
        viewGroup2.setOnClickListener(new a());
        ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.settings_scaleunit);
        viewGroup3.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_section_opened));
        TextView textView = (TextView) viewGroup3.findViewById(R.id.settings_item_name);
        this.f762a = textView;
        textView.setText(a.c.a.d.a.h(R.string.TR_SETTINGS_SCALEUNIT_PLACEHOLDER));
        viewGroup3.setOnClickListener(new C0040b());
        ViewGroup viewGroup4 = (ViewGroup) inflate.findViewById(R.id.settings_version);
        viewGroup4.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_section_opened));
        ((ImageView) viewGroup4.findViewById(R.id.settings_item_disclosure)).setVisibility(8);
        ((TextView) viewGroup4.findViewById(R.id.settings_item_name)).setText(a.c.a.d.a.h(R.string.TR_VERSION));
        TextView textView2 = (TextView) viewGroup4.findViewById(R.id.settings_item_right_text);
        textView2.setVisibility(0);
        textView2.setText(AppMiniland.f().a());
        ViewGroup viewGroup5 = (ViewGroup) inflate.findViewById(R.id.settings_contact);
        viewGroup5.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_section_opened));
        viewGroup5.setOnClickListener(new c());
        ((TextView) viewGroup5.findViewById(R.id.settings_item_name)).setText(a.c.a.d.a.h(R.string.TR_CONTACTO));
        ViewGroup viewGroup6 = (ViewGroup) inflate.findViewById(R.id.settings_not_medical_device);
        viewGroup6.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_section_opened));
        ((ImageView) viewGroup6.findViewById(R.id.settings_item_disclosure)).setVisibility(8);
        ((TextView) viewGroup6.findViewById(R.id.settings_item_name)).setText(a.c.a.d.a.h(R.string.TR_MESSAGE_APP_NOT_MEDICAL_DEVICE));
        return inflate;
    }
}
