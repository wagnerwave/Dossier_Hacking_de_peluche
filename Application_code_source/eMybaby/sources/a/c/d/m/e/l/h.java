package a.c.d.m.e.l;

import androidx.viewpager.widget.ViewPager;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import java.util.List;

public class h implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f416b;

    public h(m mVar, List list) {
        this.f416b = mVar;
        this.f415a = list;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.f416b.f423a.setText(((UltrasoundPhoto) this.f415a.get(i)).getDescription());
        this.f416b.f424b.setText(((UltrasoundPhoto) this.f415a.get(i)).getTitle());
    }
}
