package a.c.d.m.f;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;

public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity f436a;

    public d(BabyDiaryActivity babyDiaryActivity) {
        this.f436a = babyDiaryActivity;
    }

    public void onClick(View view) {
        ViewPager viewPager = this.f436a.h;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
}
