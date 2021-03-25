package a.c.d.i.a;

import a.g.a.b.l.c;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f159a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f160b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public String f161c;

    /* renamed from: a.c.d.i.a.a$a  reason: collision with other inner class name */
    public class C0009a implements View.OnClickListener {
        public C0009a() {
        }

        public void onClick(View view) {
            if ("HELP_BUDDY".equals(a.this.f161c)) {
                a.this.f159a.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f163a;

        public b() {
        }

        public b(C0009a aVar) {
        }
    }

    public a(Context context) {
        this.f159a = context;
    }

    public int getCount() {
        return this.f160b.size();
    }

    public Object getItem(int i) {
        return this.f160b.get(i);
    }

    public long getItemId(int i) {
        return (long) this.f160b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || !(view.getTag() instanceof b)) {
            view = ((LayoutInflater) this.f159a.getSystemService("layout_inflater")).inflate(R.layout.item_help_viewflow_item, (ViewGroup) null);
            bVar = new b((C0009a) null);
            ImageView imageView = (ImageView) view.findViewById(R.id.help_item_imagen);
            bVar.f163a = imageView;
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            bVar.f163a.setScaleType(ImageView.ScaleType.FIT_CENTER);
            bVar.f163a.setOnClickListener(new C0009a());
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        String str = this.f160b.get(i);
        if (!a.c.a.d.a.j(str)) {
            AppMiniland.f().k.b(str, bVar.f163a, (a.g.a.b.b) null, (c) null);
        }
        return view;
    }
}
