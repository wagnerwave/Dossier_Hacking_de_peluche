package a.h.a.m0;

import a.i.a.e;
import a.i.a.t;
import a.i.a.x;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Activity f3517a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f3518b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f3519c;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f3520a;

        public b() {
        }

        public b(C0082a aVar) {
        }
    }

    public a(Activity activity, ArrayList<String> arrayList, int i) {
        this.f3517a = activity;
        this.f3518b = arrayList;
        this.f3519c = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f3518b.size();
    }

    public Object getItem(int i) {
        return this.f3518b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f3519c.inflate(R.layout.persona_view, viewGroup, false);
            bVar = new b((C0082a) null);
            bVar.f3520a = (ImageView) view.findViewById(R.id.imagen);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        x d2 = t.f(bVar.f3520a.getContext()).d(this.f3518b.get(i));
        d2.f3691e = R.drawable.imagenes_default;
        d2.b(bVar.f3520a, (e) null);
        return view;
    }
}
