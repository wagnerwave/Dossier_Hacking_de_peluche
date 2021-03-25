package a.c.d.h;

import a.c.a.d.a;
import com.cuatroochenta.miniland.emyscale.MyScaleBabyActivity;
import com.sozpic.miniland.R;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f134a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyScaleBabyActivity f135b;

    public b(MyScaleBabyActivity myScaleBabyActivity, int i) {
        this.f135b = myScaleBabyActivity;
        this.f134a = i;
    }

    public void run() {
        MyScaleBabyActivity myScaleBabyActivity = this.f135b;
        MyScaleBabyActivity.v(myScaleBabyActivity, a.h(R.string.TR_ERROR_CONNECT_ESCUCHALATIDOS) + "[" + this.f134a + "]");
    }
}
