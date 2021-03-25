package a.c.d.p;

import a.c.a.e.f;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.sozpic.miniland.R;

public class a extends DialogFragment {

    /* renamed from: a.c.d.p.a$a  reason: collision with other inner class name */
    public class C0039a implements View.OnClickListener {
        public C0039a() {
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
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_default_dialog, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.default_dialog_title);
        textView.setText(Html.fromHtml(a.c.a.d.a.h(R.string.TR_CONTACTO_INFO_HTML_TEXT)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setGravity(3);
        ((TextView) inflate.findViewById(R.id.default_dialog_left)).setVisibility(8);
        TextView textView2 = (TextView) inflate.findViewById(R.id.default_dialog_right);
        textView2.setText(a.c.a.d.a.h(R.string.TR_ACEPTAR));
        textView2.setOnClickListener(new C0039a());
        ((EditText) inflate.findViewById(R.id.default_dialog_edit)).setVisibility(8);
        inflate.findViewById(R.id.default_dialog_button_vertical_separator).setVisibility(8);
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
        f.c().e("SETTINGS_MYSCALE_CONTACTO");
    }
}
