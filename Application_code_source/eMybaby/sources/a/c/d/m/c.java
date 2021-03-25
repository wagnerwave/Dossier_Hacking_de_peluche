package a.c.d.m;

import a.c.d.r.j;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f335a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f336b = new ArrayList<>();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f337a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f338b;

        public a(c cVar) {
        }
    }

    public c(Context context) {
        this.f335a = context;
    }

    public int getCount() {
        return this.f336b.size();
    }

    public Object getItem(int i) {
        return this.f336b.get(i);
    }

    public long getItemId(int i) {
        if (this.f336b.get(i) == null) {
            return 0;
        }
        return (long) this.f336b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = ((LayoutInflater) this.f335a.getSystemService("layout_inflater")).inflate(R.layout.item_mybuddy_menuitem, (ViewGroup) null);
            aVar = new a(this);
            aVar.f337a = (ImageView) view.findViewById(R.id.menu_buddy_item_image);
            aVar.f338b = (TextView) view.findViewById(R.id.menu_buddy_item_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = this.f336b.get(i);
        if (!a.c.a.d.a.j(str)) {
            aVar.f338b.setText(j.b().e(str).toUpperCase());
            aVar.f337a.setImageResource(j.b().d(str));
        }
        return view;
    }
}
