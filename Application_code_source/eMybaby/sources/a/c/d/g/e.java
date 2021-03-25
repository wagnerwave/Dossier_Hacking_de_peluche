package a.c.d.g;

import a.c.d.c;
import a.c.d.g.j.b;
import a.c.d.g.k.a;
import a.c.d.s.a.a.c;
import a.c.d.s.a.a.d;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cuatroochenta.miniland.emybuddy.BuddyActivateActivity;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.emybuddy.BuddySettingsActivity;
import com.cuatroochenta.miniland.webservices.emybuddy.info.BuddyInfoRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;

public class e extends Fragment implements d, a.e {

    /* renamed from: a  reason: collision with root package name */
    public GridView f71a;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) e.this.f71a.getAdapter();
            if (bVar != null) {
                String str = bVar.f85b.get(i);
                e eVar = e.this;
                if (eVar == null) {
                    throw null;
                } else if (!a.c.a.d.a.j(str)) {
                    if ("BUDDY_SETTINGS".equals(str)) {
                        a.a.a.a.a.t(eVar.getActivity(), BuddySettingsActivity.class);
                    } else if (!"BUDDY_PARENTS".equals(str) || AppMiniland.f().i().isBuddyActive()) {
                        FragmentActivity activity = eVar.getActivity();
                        if (!a.c.a.d.a.j(str)) {
                            Intent intent = new Intent(activity, BuddyPlayerActivity.class);
                            intent.putExtra("KEY_INTENT_PLAYER_SECTION", str);
                            activity.startActivity(intent);
                        }
                    } else {
                        a.a.a.a.a.t(eVar.getActivity(), BuddyActivateActivity.class);
                    }
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_mybuddy_menu, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.menu_buddy_list);
        this.f71a = gridView;
        gridView.setOnItemClickListener(new a());
        return inflate;
    }

    public void onPause() {
        super.onPause();
        if (getActivity() instanceof c) {
            ((c) getActivity()).o();
        }
    }

    public void onResume() {
        super.onResume();
        b bVar = (b) this.f71a.getAdapter();
        if (bVar == null) {
            bVar = new b(getActivity());
            this.f71a.setAdapter(bVar);
        }
        bVar.f85b.clear();
        bVar.f85b.add("BUDDY_PARENTS");
        bVar.f85b.add("BUDDY_NATURE");
        bVar.f85b.add("BUDDY_CLOSE_MUM");
        bVar.f85b.add("BUDDY_CLASSIC");
        bVar.f85b.add("BUDDY_LULLABIES");
        bVar.f85b.add("BUDDY_DEVICE");
        bVar.f85b.add("BUDDY_FAVOURITES");
        bVar.f85b.add("BUDDY_SETTINGS");
        bVar.notifyDataSetChanged();
        a.c.d.s.a.a.c cVar = new a.c.d.s.a.a.c();
        cVar.f819b = "https://emybaby.com/api/emybuddy.php";
        new c.a(new BuddyInfoRequest(), this).start();
        if (getActivity() instanceof a.c.d.c) {
            ((a.c.d.c) getActivity()).p(a.c.a.d.a.h(R.string.TR_UPDATING), false);
        }
    }
}
