package a.c.d.h.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cuatroochenta.miniland.model.Measure;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f142a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Measure> f143b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public int f144c;

    /* renamed from: a.c.d.h.g.a$a  reason: collision with other inner class name */
    public class C0007a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f145a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f146b;

        public C0007a(a aVar) {
        }
    }

    public a(Context context) {
        this.f142a = context;
        this.f144c = 0;
    }

    public int getCount() {
        int size = this.f143b.size();
        int i = this.f144c;
        return i <= 0 ? this.f143b.size() : i > size ? size : i;
    }

    public Object getItem(int i) {
        return this.f143b.get(i);
    }

    public long getItemId(int i) {
        if (this.f143b.get(i) == null) {
            return 0;
        }
        return (long) this.f143b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0007a aVar;
        if (view == null || !(view.getTag() instanceof C0007a)) {
            view = ((LayoutInflater) this.f142a.getSystemService("layout_inflater")).inflate(R.layout.item_myscale_baby_measure, (ViewGroup) null);
            aVar = new C0007a(this);
            aVar.f145a = (TextView) view.findViewById(R.id.baby_measure_date);
            TextView textView = (TextView) view.findViewById(R.id.baby_measure_time);
            aVar.f146b = (TextView) view.findViewById(R.id.baby_measure_value);
            view.setTag(aVar);
        } else {
            aVar = (C0007a) view.getTag();
        }
        Measure measure = this.f143b.get(i);
        if (measure != null) {
            aVar.f145a.setText(measure.getStringDate());
            aVar.f146b.setText(measure.toString());
        }
        return view;
    }
}
