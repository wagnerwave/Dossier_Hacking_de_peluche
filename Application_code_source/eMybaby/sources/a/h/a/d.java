package a.h.a;

import a.a.a.a.a;
import android.widget.Toast;
import com.sozpic.miniland.ListadoTermometroActivity;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3466a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListadoTermometroActivity f3467b;

    public d(ListadoTermometroActivity listadoTermometroActivity, int i) {
        this.f3467b = listadoTermometroActivity;
        this.f3466a = i;
    }

    public void run() {
        ListadoTermometroActivity listadoTermometroActivity = this.f3467b;
        StringBuilder n = a.n("Error ");
        n.append(this.f3466a);
        Toast.makeText(listadoTermometroActivity, n.toString(), 0).show();
    }
}
