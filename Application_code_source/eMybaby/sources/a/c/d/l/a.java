package a.c.d.l;

import a.c.d.r.e;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import java.util.Locale;
import org.json.JSONException;

public class a extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public String f305a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f306b = "";

    /* renamed from: c  reason: collision with root package name */
    public boolean f307c;

    /* renamed from: a.c.d.l.a$a  reason: collision with other inner class name */
    public class C0016a implements View.OnClickListener {
        public C0016a() {
        }

        public void onClick(View view) {
            String str;
            Context context = a.this.getContext();
            if (a.this.f307c) {
                StringBuilder n = a.a.a.a.a.n("https://emybaby.com");
                n.append(a.this.f305a);
                str = n.toString();
            } else {
                str = a.c.a.d.a.h(R.string.TR_WEB_REGISTER);
            }
            a.c.a.d.a.n(context, str);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Context context = a.this.getContext();
            StringBuilder n = a.a.a.a.a.n("https://emybaby.com");
            n.append(a.this.f306b);
            a.c.a.d.a.n(context, n.toString());
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f307c = getArguments().getBoolean("ARG_IS_ACTIVE");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_chefy_download_dialog, viewGroup, false);
        if (this.f307c) {
            Context context = getContext();
            int i2 = Build.VERSION.SDK_INT;
            Configuration configuration = context.getResources().getConfiguration();
            Locale locale = i2 >= 24 ? configuration.getLocales().get(0) : configuration.locale;
            Usuario i3 = AppMiniland.f().i();
            try {
                this.f305a = i3.getOriginalJson().getJSONObject("chefy_5").getJSONObject(locale.getLanguage()).getString("archivo");
                this.f306b = i3.getOriginalJson().getJSONObject("chefy_6").getJSONObject(locale.getLanguage()).getString("archivo");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        TextView textView = (TextView) inflate.findViewById(R.id.tv_chefy_select);
        textView.setTypeface(e.a().f789b);
        textView.setText(a.c.a.d.a.h(this.f307c ? R.string.TR_SELECCIONA_EL_RECETARIO_DE_LA_CHEFY : R.string.TR_DEBES_REGISTRAR_TU_CHEFY));
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_chefy5_btn);
        textView2.setTypeface(e.a().f788a);
        textView2.setText(a.c.a.d.a.h(this.f307c ? R.string.TR_DESCARGA_EL_RECETARIO_CHEFY5 : R.string.TR_REGISTER));
        textView2.setOnClickListener(new C0016a());
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_chefy6_btn);
        textView3.setTypeface(e.a().f788a);
        textView3.setText(a.c.a.d.a.h(R.string.TR_DESCARGA_EL_RECETARIO_CHEFY6));
        textView3.setOnClickListener(new b());
        if (!this.f307c) {
            i = 8;
        }
        textView3.setVisibility(i);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_cancel_btn);
        textView4.setTypeface(e.a().f788a);
        textView4.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        textView4.setOnClickListener(new c());
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
    }
}
