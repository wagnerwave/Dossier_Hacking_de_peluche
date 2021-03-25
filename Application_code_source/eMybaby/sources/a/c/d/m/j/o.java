package a.c.d.m.j;

import a.c.d.r.j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cuatroochenta.miniland.model.MedicalAppointment;
import com.sozpic.miniland.R;
import java.util.LinkedList;
import java.util.List;

public class o extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<MedicalAppointment> f703a = new LinkedList();

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f704a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f705b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f706c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f707d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f708e;

        public b() {
        }

        public b(a aVar) {
        }
    }

    public MedicalAppointment a(int i) {
        return this.f703a.get(i);
    }

    public int getCount() {
        return this.f703a.size();
    }

    public Object getItem(int i) {
        return this.f703a.get(i);
    }

    public long getItemId(int i) {
        return this.f703a.get(i).getId();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        MedicalAppointment medicalAppointment = this.f703a.get(i);
        int i2 = 0;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_appointment, viewGroup, false);
            b bVar = new b((a) null);
            bVar.f704a = (TextView) view.findViewById(R.id.appointment_text_matrona);
            bVar.f705b = (TextView) view.findViewById(R.id.appointment_text_hospital_general_alicante);
            bVar.f706c = (TextView) view.findViewById(R.id.appointment_text_25_02_17);
            bVar.f707d = (TextView) view.findViewById(R.id.appointment_text_11_46);
            bVar.f708e = (ImageView) view.findViewById(R.id.appointment_icon_exclamation);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.f704a.setText(medicalAppointment.getTypeAsString());
        bVar2.f705b.setText(medicalAppointment.getPlace());
        bVar2.f706c.setText(j.g.format(medicalAppointment.getDate()));
        bVar2.f707d.setText(j.l.format(medicalAppointment.getDate()));
        ImageView imageView = bVar2.f708e;
        if (medicalAppointment.getObservation() == null || medicalAppointment.getObservation().isEmpty()) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        return view;
    }
}
