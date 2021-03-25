package a.h.a.k0;

import a.c.a.d.a;
import a.e.a.a.r.b;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Medica;
import com.tuya.smart.common.oOO0O0O0;

public class d extends ArrayAdapter<Medica> {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3500a;

    /* renamed from: b  reason: collision with root package name */
    public final Medica[] f3501b;

    public d(Activity activity, Medica[] medicaArr) {
        super(activity, R.layout.row_medica, medicaArr);
        this.f3500a = activity;
        this.f3501b = medicaArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.f3500a.getLayoutInflater();
        View inflate = layoutInflater.inflate(R.layout.row_medica, (ViewGroup) null, true);
        Medica medica = this.f3501b[i];
        try {
            if (medica.getId().equals(oOO0O0O0.O0000oO0)) {
                TextView textView = (TextView) inflate.findViewById(R.id.texto1);
                textView.setPadding(0, 10, 0, 0);
                textView.setText(medica.getFechacrecimiento());
                ((TextView) inflate.findViewById(R.id.texto2)).setText("");
                ((TextView) inflate.findViewById(R.id.texto3)).setText("");
            } else {
                if (medica.getTipo() == 1) {
                    inflate = layoutInflater.inflate(R.layout.row_crecimiento, (ViewGroup) null, true);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.crecimiento_height_unit);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.crecimiento_weight_unit);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.crecimiento_head_unit);
                    ((TextView) inflate.findViewById(R.id.texto1)).setText(medica.getFechacrecimiento());
                    TextView textView5 = (TextView) inflate.findViewById(R.id.texto2);
                    if (!a.j(medica.getPesocrecimiento())) {
                        textView5.setText(medica.getPesocrecimiento());
                        textView3.setVisibility(0);
                    } else {
                        textView3.setVisibility(4);
                    }
                    TextView textView6 = (TextView) inflate.findViewById(R.id.texto3);
                    if (!a.j(medica.getAlturacrecimiento())) {
                        textView6.setText(medica.getAlturacrecimiento());
                        textView2.setVisibility(0);
                    } else {
                        textView2.setVisibility(4);
                    }
                    TextView textView7 = (TextView) inflate.findViewById(R.id.texto4);
                    textView7.setVisibility(8);
                    textView7.setText(medica.getHoracitaCorta());
                    TextView textView8 = (TextView) inflate.findViewById(R.id.crecimiento_head_value);
                    if (!a.j(medica.getMedidaCabCrecimiento())) {
                        textView8.setText(medica.getMedidaCabCrecimiento());
                        textView4.setVisibility(0);
                    } else {
                        textView4.setVisibility(4);
                    }
                }
                if (medica.getTipo() == 2) {
                    ((TextView) inflate.findViewById(R.id.texto1)).setText("" + medica.getFechacitaCorta());
                    ((TextView) inflate.findViewById(R.id.texto4)).setText(medica.getHoracitaCorta());
                    ((TextView) inflate.findViewById(R.id.texto2)).setText("" + b.R(medica.getEspecialistacita()));
                    ((TextView) inflate.findViewById(R.id.texto3)).setText(medica.getMedicocita());
                }
                if (medica.getTipo() == 3) {
                    ((TextView) inflate.findViewById(R.id.texto1)).setText(medica.getFechavacunaCorta());
                    ((TextView) inflate.findViewById(R.id.texto2)).setText("" + medica.getBebibleinyectablevacuna());
                    ((TextView) inflate.findViewById(R.id.texto3)).setText(medica.getVacunavacuna());
                }
            }
        } catch (Exception unused) {
        }
        return inflate;
    }
}
