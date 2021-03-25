package a.c.d.m.f;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;

public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity f435a;

    public c(BabyDiaryActivity babyDiaryActivity) {
        this.f435a = babyDiaryActivity;
    }

    public void onClick(View view) {
        ViewPager viewPager = this.f435a.h;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }
}
