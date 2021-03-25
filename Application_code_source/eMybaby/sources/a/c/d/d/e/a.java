package a.c.d.d.e;

import a.g.a.b.b;
import a.g.a.b.l.c;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Imagen;
import java.util.ArrayList;

public class a extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Activity f61a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Imagen> f62b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f63c;

    public a(Activity activity, ArrayList<Imagen> arrayList) {
        this.f61a = activity;
        this.f62b = arrayList;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((RelativeLayout) obj);
    }

    public int getCount() {
        return this.f62b.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) this.f61a.getSystemService("layout_inflater");
        this.f63c = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.item_album_viewflow, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.item_album_image);
        Imagen imagen = this.f62b.get(i);
        if (imagen != null) {
            if (!a.c.a.d.a.j(imagen.getUrl())) {
                AppMiniland.f().k.b(imagen.getUrl(), imageView, (b) null, (c) null);
            } else {
                imageView.setImageResource(R.drawable.imagenes_default);
            }
        }
        ((ViewPager) viewGroup).addView(inflate);
        return inflate;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == ((RelativeLayout) obj);
    }
}
