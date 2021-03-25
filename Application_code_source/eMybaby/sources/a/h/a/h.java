package a.h.a;

import a.c.a.d.a;
import a.c.d.r.j;
import a.c.d.s.e.f.b.b;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MainActivity;
import com.sozpic.miniland.R;
import java.text.ParseException;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3475a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MainActivity.b f3476b;

    public h(MainActivity.b bVar, b bVar2) {
        this.f3476b = bVar;
        this.f3475a = bVar2;
    }

    public void run() {
        MainActivity.this.o();
        MainActivity.this.f4475c.setSeccion(a.h(R.string.TR_MENU_MI_EMBARAZO).toUpperCase());
        if (this.f3475a.f42a.booleanValue() && !a.j(this.f3475a.f1109c)) {
            try {
                AppMiniland.f().i().setBirthDate(j.f.parse(this.f3475a.f1109c));
                MainActivity.this.u(a.c.d.m.a.o(MainActivity.this), true);
                return;
            } catch (ParseException unused) {
            }
        }
        MainActivity mainActivity = MainActivity.this;
        mainActivity.u(a.c.d.m.a.o(mainActivity), true);
    }
}
