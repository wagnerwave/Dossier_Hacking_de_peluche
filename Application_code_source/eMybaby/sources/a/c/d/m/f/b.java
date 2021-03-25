package a.c.d.m.f;

import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity f434b;

    public b(BabyDiaryActivity babyDiaryActivity, int i) {
        this.f434b = babyDiaryActivity;
        this.f433a = i;
    }

    public void run() {
        float min = Math.min(((float) this.f433a) / 40.0f, 1.0f);
        this.f434b.i.getLayoutParams().width = (int) (min * ((float) this.f434b.j.getWidth()));
        this.f434b.i.requestLayout();
    }
}
