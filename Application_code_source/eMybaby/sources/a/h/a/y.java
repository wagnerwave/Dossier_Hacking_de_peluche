package a.h.a;

import com.sozpic.miniland.R;
import java.util.Date;

public class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Date f3562a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f3563b;

    public y(z zVar, Date date) {
        this.f3563b = zVar;
        this.f3562a = date;
    }

    public void run() {
        this.f3563b.f.cleanBG();
        this.f3563b.f.setBackgroundResourceForDate(R.color.lila, this.f3562a);
        this.f3563b.f.refreshView();
    }
}
