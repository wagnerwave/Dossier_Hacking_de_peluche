package a.c.d.m.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cuatroochenta.miniland.model.Contraction;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f479a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Contraction> f480b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f481c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f482d;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f483a;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f484b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f485c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f486d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f487e;
        public TextView f;

        public a(d dVar) {
        }
    }

    public d(Context context) {
        this.f479a = context;
        this.f482d = 1;
    }

    public void a() {
        if (this.f482d == 2) {
            this.f482d = 1;
            this.f481c.clear();
        } else {
            this.f482d = 2;
        }
        notifyDataSetChanged();
    }

    public Contraction b(int i) {
        return this.f480b.get(i);
    }

    public void c(Contraction contraction) {
        if (contraction != null && !a.c.a.d.a.j(contraction.getId()) && this.f482d == 2) {
            if (this.f481c.contains(contraction.getId())) {
                this.f481c.remove(contraction.getId());
                if (this.f481c.isEmpty()) {
                    Context context = this.f479a;
                    if (context instanceof PregnancyContractionListActivity) {
                        ((PregnancyContractionListActivity) context).onBackPressed();
                    }
                }
            } else {
                this.f481c.add(contraction.getId());
            }
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f480b.size();
    }

    public Object getItem(int i) {
        return this.f480b.get(i);
    }

    public long getItemId(int i) {
        if (this.f480b.get(i) == null) {
            return 0;
        }
        return (long) this.f480b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        ViewGroup viewGroup2;
        if (view == null || !(view.getTag() instanceof a)) {
            view = ((LayoutInflater) this.f479a.getSystemService("layout_inflater")).inflate(R.layout.item_pregnancy_contraction, (ViewGroup) null);
            aVar = new a(this);
            aVar.f483a = (ViewGroup) view.findViewById(R.id.pregnancy_contraction_item_root);
            aVar.f484b = (ViewGroup) view.findViewById(R.id.pregnancy_contraction_item_root_elapsed);
            aVar.f485c = (ImageView) view.findViewById(R.id.pregnancy_contraction_item_right_image);
            aVar.f486d = (TextView) view.findViewById(R.id.pregnancy_contraction_item_duration_between_contractions);
            aVar.f487e = (TextView) view.findViewById(R.id.pregnancy_contraction_item_date);
            aVar.f = (TextView) view.findViewById(R.id.pregnancy_contraction_item_duration);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Contraction contraction = this.f480b.get(i);
        if (contraction != null) {
            if (this.f482d == 2) {
                aVar.f485c.setVisibility(0);
                aVar.f485c.setSelected(this.f481c.contains(contraction.getId()));
                viewGroup2 = aVar.f483a;
                i2 = this.f479a.getResources().getColor(aVar.f485c.isSelected() ? R.color.grey_light : 17170443);
            } else {
                aVar.f485c.setVisibility(4);
                i2 = -1;
                aVar.f483a.setBackgroundColor(-1);
                viewGroup2 = aVar.f483a;
            }
            viewGroup2.setBackgroundColor(i2);
            aVar.f487e.setText(contraction.getDateFormatted());
            aVar.f.setText(a.c.a.d.a.e(contraction.getDuration()));
            int i3 = i + 1;
            if (i3 < this.f480b.size()) {
                Contraction b2 = b(i3);
                if (!(b2.getDate() == null || contraction.getDate() == null)) {
                    aVar.f484b.setVisibility(0);
                    aVar.f486d.setText(a.c.a.d.a.f((int) Math.abs((b2.getDate().getTime() - contraction.getDate().getTime()) / 1000), true));
                }
            }
            aVar.f484b.setVisibility(8);
        }
        return view;
    }
}
