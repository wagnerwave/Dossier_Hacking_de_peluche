package a.h.a.k0;

import a.e.a.a.r.b;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Agenda;
import com.tuya.smart.common.oOO0O0O0;
import java.util.ArrayList;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3487a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Agenda> f3488b = new ArrayList<>();

    public a(Activity activity) {
        this.f3487a = activity;
    }

    public int getCount() {
        return this.f3488b.size();
    }

    public Object getItem(int i) {
        return this.f3488b.get(i);
    }

    public long getItemId(int i) {
        return (long) this.f3488b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String h;
        View inflate = this.f3487a.getLayoutInflater().inflate(R.layout.row_calendario, (ViewGroup) null, true);
        Agenda agenda = this.f3488b.get(i);
        try {
            if (agenda.getId().equals(oOO0O0O0.O0000oO0)) {
                TextView textView = (TextView) inflate.findViewById(R.id.texto3);
                textView.setPadding(0, 5, 0, 0);
                textView.setText(agenda.getNombre());
            } else {
                TextView textView2 = (TextView) inflate.findViewById(R.id.texto2);
                ((TextView) inflate.findViewById(R.id.texto1)).setText(agenda.getNombre());
                TextView textView3 = (TextView) inflate.findViewById(R.id.texto3);
                if (agenda.getTododia().equals(oOO0O0O0.O0000oO0)) {
                    String[] split = agenda.getFechainicio().split(" ");
                    String fechainicio = agenda.getFechainicio();
                    if (split.length >= 2) {
                        String[] a0 = b.a0(split[1], ":");
                        fechainicio = a0[0] + ":" + a0[1];
                    }
                    String[] split2 = agenda.getFechafin().split(" ");
                    String fechafin = agenda.getFechafin();
                    if (split2.length >= 2) {
                        String[] a02 = b.a0(split2[1], ":");
                        fechafin = a02[0] + ":" + a02[1];
                    }
                    if (agenda.getMedicalRecord() != null) {
                        textView3.setText(fechainicio);
                    } else {
                        if (!fechainicio.equals("00:00")) {
                            if (!fechafin.equals("00:00")) {
                                h = fechainicio + " - " + fechafin;
                            }
                        }
                        textView3.setText(" - ");
                    }
                } else {
                    h = a.c.a.d.a.h(R.string.TR_ALL_DAY);
                }
                textView3.setText(h);
            }
        } catch (Exception unused) {
        }
        return inflate;
    }
}
