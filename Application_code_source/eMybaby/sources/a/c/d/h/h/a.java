package a.c.d.h.h;

import a.c.d.r.j;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.sozpic.miniland.R;

public class a extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public c f154a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f155b;

    /* renamed from: c  reason: collision with root package name */
    public int f156c = -1;

    /* renamed from: a.c.d.h.h.a$a  reason: collision with other inner class name */
    public class C0008a implements View.OnClickListener {
        public C0008a() {
        }

        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            int i;
            if (!a.c.a.d.a.j(a.this.f155b.getText().toString())) {
                a aVar = a.this;
                c cVar = aVar.f154a;
                if (cVar != null) {
                    try {
                        float parseFloat = Float.parseFloat(aVar.f155b.getText().toString());
                        if (a.this.f156c == -1) {
                            i = 0;
                        } else {
                            i = a.this.f156c;
                        }
                        cVar.g(parseFloat, i);
                        a.this.dismiss();
                        return;
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    return;
                }
            }
            Toast.makeText(a.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_SAVE_MEASURE), 0).show();
        }
    }

    public interface c {
        void g(float f, int i);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f154a = (c) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnMeasureSourceSelected");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f156c = a.c.d.a.l().o();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_default_dialog, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.default_dialog_left);
        TextView textView2 = (TextView) inflate.findViewById(R.id.default_dialog_right);
        this.f155b = (EditText) inflate.findViewById(R.id.default_dialog_edit);
        textView.setOnClickListener(new C0008a());
        textView2.setOnClickListener(new b());
        this.f155b.setHint(j.c(this.f156c));
        ((TextView) inflate.findViewById(R.id.default_dialog_title)).setText(a.c.a.d.a.h(R.string.TR_INTRODUCE_MEASURE_TITLE));
        textView.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        textView2.setText(a.c.a.d.a.h(R.string.TR_OK));
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.f154a = null;
    }
}
