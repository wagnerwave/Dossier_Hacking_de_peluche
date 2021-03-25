package a.c.d.m.f;

import androidx.viewpager.widget.ViewPager;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;

public class e implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity f437a;

    public e(BabyDiaryActivity babyDiaryActivity) {
        this.f437a = babyDiaryActivity;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.f437a.q();
        p pVar = this.f437a.k;
        n a2 = pVar.a();
        a2.f455d = false;
        a2.g.q();
        pVar.a().notifyDataSetChanged();
    }
}
