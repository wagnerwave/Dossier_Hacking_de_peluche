package a.h.a;

import a.h.a.k0.g;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.StreamingActivity;
import com.sozpic.miniland.modelos.Usuario;
import com.sozpic.miniland.modelos.Video;
import com.sozpic.miniland.video.MainActivity3;

public class c0 extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f3462a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f3463b;

    /* renamed from: c  reason: collision with root package name */
    public Usuario f3464c;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Video video = (Video) c0.this.f3463b.getAdapter().getItem(i);
            if (video.getId() < 1 || video.getId() >= 7) {
                Intent intent = new Intent(c0.this.getActivity(), MainActivity3.class);
                AppMiniland f = AppMiniland.f();
                boolean z = f.h.getBoolean("pv4", true);
                f.j = z;
                intent.putExtra("primera", z);
                intent.putExtra("bdpre", c0.this.f3464c.getBdpre());
                intent.putExtra("bd", c0.this.f3464c.getBd());
                intent.putExtra("email", c0.this.f3464c.getCorreo());
                intent.putExtra("pass", c0.this.f3464c.getPass());
                AppMiniland appMiniland = (AppMiniland) a.c.a.a.f;
                boolean z2 = appMiniland.h.getBoolean("pv4", true);
                appMiniland.j = z2;
                if (z2) {
                    AppMiniland appMiniland2 = (AppMiniland) a.c.a.a.f;
                    appMiniland2.i.putBoolean("pv4", false);
                    appMiniland2.i.commit();
                }
                intent.putExtra("KEY_INTENT_HELP_SECTION_CODE", video.getHelpSection());
                c0.this.startActivity(intent);
                return;
            }
            c0 c0Var = c0.this;
            if (c0Var != null) {
                Intent intent2 = new Intent(c0Var.getActivity(), StreamingActivity.class);
                intent2.putExtra("KEY_INTENT_HELP_SECTION_CODE", video.getHelpSection());
                c0Var.startActivityForResult(intent2, 0);
                return;
            }
            throw null;
        }
    }

    public void onClick(View view) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vigilabebes, viewGroup, false);
        this.f3462a = inflate;
        ((TextView) inflate.findViewById(R.id.select_baby_text)).setText(a.c.a.d.a.h(R.string.TR_SELECT_BABY_MONITOR));
        this.f3463b = (ListView) this.f3462a.findViewById(R.id.listadovideo);
        this.f3464c = AppMiniland.f().i();
        this.f3463b.setAdapter(new g(getActivity(), new Video[]{new Video(1, "digimonitor 8'' plus", "BABY_MONITOR_DIGIMONITOR_8"), new Video(2, "digimonitor 7''", "BABY_MONITOR_DIGIMONITOR_7"), new Video(3, "digimonitor 3.5'' touch", "BABY_MONITOR_DIGIMONITOR_3_5_TOUCH"), new Video(4, "digimonitor 3.5'' plus", "BABY_MONITOR_DIGIMONITOR_3_5_PLUS"), new Video(5, "digimonitor 2.4'' plus", "BABY_MONITOR_DIGIMONITOR_2_4_PLUS"), new Video(6, "digimonitor 2.4'' gold", "BABY_MONITOR_DIGIMONITOR_2_4_GOLD"), new Video(7, "everywhere IPcam", "EVERYWHERE_IPCAM"), new Video(8, "spin IPcam", "SPIN_IPCAM")}));
        this.f3463b.setOnItemClickListener(new a());
        return this.f3462a;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
    }
}
