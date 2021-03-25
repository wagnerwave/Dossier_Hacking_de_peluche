package a.c.d.m.f;

import android.view.View;
import android.widget.ImageView;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;

public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f453b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f454c;

    public m(n nVar, int i, ImageView imageView) {
        this.f454c = nVar;
        this.f452a = i;
        this.f453b = imageView;
    }

    public void onClick(View view) {
        n nVar;
        int i;
        if (this.f454c.f != this.f452a || !this.f453b.isSelected() || !(this.f453b.getContext() instanceof BabyDiaryActivity)) {
            View view2 = this.f454c.f456e;
            if (view2 != null) {
                view2.setSelected(false);
            }
            this.f454c.f456e = view;
            view.setSelected(true);
            nVar = this.f454c;
            i = this.f452a;
        } else {
            this.f453b.setSelected(false);
            nVar = this.f454c;
            nVar.f456e = null;
            i = -1;
        }
        nVar.f = i;
    }
}
