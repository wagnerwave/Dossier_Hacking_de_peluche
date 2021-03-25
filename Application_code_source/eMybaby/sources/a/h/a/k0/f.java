package a.h.a.k0;

import a.c.a.d.a;
import a.c.d.r.j;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Termo;
import com.tuya.smart.common.oOO0O0O0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class f extends ArrayAdapter<Termo> {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3504a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Termo> f3505b;

    public f(Activity activity, ArrayList<Termo> arrayList) {
        super(activity, R.layout.row_termo, arrayList);
        this.f3504a = activity;
        this.f3505b = arrayList;
        Collections.sort(arrayList);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        View inflate = this.f3504a.getLayoutInflater().inflate(R.layout.row_termo, (ViewGroup) null, true);
        Termo termo = this.f3505b.get(i);
        try {
            TextView textView = (TextView) inflate.findViewById(R.id.texto1);
            TextView textView2 = (TextView) inflate.findViewById(R.id.texto2);
            if (termo.getId().equals(oOO0O0O0.O0000oO0) || termo.getFecha() == null) {
                textView.setText(a.h(R.string.TR_EMPTY));
                textView2.setText((CharSequence) null);
            } else {
                textView.setText(j.f.format(termo.getFecha()));
                textView2.setText(j.l.format(termo.getFecha()));
            }
        } catch (Exception unused) {
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.texto3);
        if (!termo.getId().equals(oOO0O0O0.O0000oO0)) {
            str = String.format(Locale.ENGLISH, "%.1f ºC", new Object[]{termo.getTmp()});
        } else {
            str = "";
        }
        textView3.setText(str);
        return inflate;
    }
}
