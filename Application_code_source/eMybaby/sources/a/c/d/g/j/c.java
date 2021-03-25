package a.c.d.g.j;

import a.c.a.e.f;
import a.c.d.s.a.b.d;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.model.Song;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.tuya.smart.common.oOO0O0O0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f88a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Song> f89b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public int f90c = -1;

    /* renamed from: d  reason: collision with root package name */
    public C0001c f91d;

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f92a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f93b;

        public a(b bVar, int i) {
            this.f92a = bVar;
            this.f93b = i;
        }

        public void onClick(View view) {
            ViewGroup viewGroup = this.f92a.f96b;
            viewGroup.setSelected(!viewGroup.isSelected());
            C0001c cVar = c.this.f91d;
            if (cVar != null) {
                int i = this.f93b;
                BuddyPlayerActivity buddyPlayerActivity = (BuddyPlayerActivity) cVar;
                c cVar2 = (c) buddyPlayerActivity.f3828e.getAdapter();
                if (cVar2 != null) {
                    Song song = cVar2.f89b.get(i);
                    f.c().d("MY_BUDDY", !song.isFavourite() ? "ADD_FAVORITE" : "REMOVE_FAVORITE", a.c.a.d.a.g(song.getTitle()));
                    if (Song.DEVICE_TYPE == song.getType()) {
                        song.setFavourite(!song.isFavourite());
                        if (!song.isFavourite()) {
                            a.c.d.a l = a.c.d.a.l();
                            if (l == null) {
                                throw null;
                            } else if (!a.c.a.d.a.j(song.getId())) {
                                ArrayList<String> k = l.k();
                                if (k == null) {
                                    k = new ArrayList<>();
                                }
                                if (k.contains(song.getId())) {
                                    k.remove(song.getId());
                                    l.i("KEY_FAVOURITE_ID_SONGS", a.c.a.b.f(k));
                                }
                            }
                        } else {
                            a.c.d.a l2 = a.c.d.a.l();
                            if (l2 == null) {
                                throw null;
                            } else if (!a.c.a.d.a.j(song.getId())) {
                                ArrayList<String> k2 = l2.k();
                                if (k2 == null) {
                                    k2 = new ArrayList<>();
                                }
                                if (!k2.contains(song.getId())) {
                                    k2.add(song.getId());
                                    l2.i("KEY_FAVOURITE_ID_SONGS", a.c.a.b.f(k2));
                                }
                            }
                        }
                        if ("BUDDY_FAVOURITES".equals(buddyPlayerActivity.f3826c)) {
                            a.c.a.f.b.e0(buddyPlayerActivity, i);
                            buddyPlayerActivity.v();
                            return;
                        }
                        cVar2.notifyDataSetChanged();
                        return;
                    }
                    a.c.d.s.a.b.a aVar = new a.c.d.s.a.b.a();
                    aVar.f822a = song;
                    d dVar = new d();
                    dVar.f825b = "https://emybaby.com/api/emybuddy.php";
                    new d.a(aVar, buddyPlayerActivity).start();
                }
            }
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f95a;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f96b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f97c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f98d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f99e;
        public TextView f;
        public ImageView g;

        public b(c cVar) {
        }
    }

    /* renamed from: a.c.d.g.j.c$c  reason: collision with other inner class name */
    public interface C0001c {
    }

    public c(Context context) {
        this.f88a = context;
    }

    public int a(Song song) {
        if (song != null) {
            return -1;
        }
        for (int i = 0; i < this.f89b.size(); i++) {
            Song song2 = this.f89b.get(i);
            if (song2 != null && !a.c.a.d.a.j(song2.getId()) && song2.getId().equals(song.getId())) {
                return i;
            }
        }
        return -1;
    }

    public void b(ArrayList<Song> arrayList) {
        this.f89b.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Song> it = arrayList.iterator();
            while (it.hasNext()) {
                Song next = it.next();
                if (next.getType() == Song.DEVICE_TYPE || (next.getType() == Song.SERVER_TYPE && a.c.c.b.c().b(next.getUrlFile()).exists())) {
                    this.f89b.add(next);
                }
            }
        }
    }

    public int getCount() {
        return this.f89b.size();
    }

    public Object getItem(int i) {
        return this.f89b.get(i);
    }

    public long getItemId(int i) {
        if (this.f89b.get(i) == null) {
            return 0;
        }
        return (long) this.f89b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        ViewGroup viewGroup2;
        String str;
        TextView textView;
        if (view == null || !(view.getTag() instanceof b)) {
            view = ((LayoutInflater) this.f88a.getSystemService("layout_inflater")).inflate(R.layout.item_mybuddy_song, (ViewGroup) null);
            bVar = new b(this);
            bVar.f95a = (ViewGroup) view.findViewById(R.id.buddy_player_item_icon_container);
            bVar.f97c = (ImageView) view.findViewById(R.id.buddy_player_item_icon_image);
            bVar.f98d = (TextView) view.findViewById(R.id.buddy_player_item_icon_text);
            bVar.f99e = (TextView) view.findViewById(R.id.buddy_player_item_name);
            bVar.f = (TextView) view.findViewById(R.id.buddy_player_item_duration);
            bVar.g = (ImageView) view.findViewById(R.id.buddy_player_item_favourites);
            bVar.f96b = (ViewGroup) view.findViewById(R.id.buddy_player_item_favourites_container);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Song song = this.f89b.get(i);
        if (song != null) {
            if (i == this.f90c) {
                view.setBackgroundColor(this.f88a.getResources().getColor(R.color.bg_light_purple));
                bVar.f98d.setTextColor(this.f88a.getResources().getColor(17170443));
                viewGroup2 = bVar.f95a;
                i2 = this.f88a.getResources().getColor(R.color.purple);
            } else {
                view.setBackgroundColor(this.f88a.getResources().getColor(17170443));
                bVar.f98d.setTextColor(this.f88a.getResources().getColor(R.color.purple));
                viewGroup2 = bVar.f95a;
                i2 = this.f88a.getResources().getColor(17170443);
            }
            viewGroup2.setBackgroundColor(i2);
            if (a.c.a.d.a.j(song.getUrlImage())) {
                int i3 = i + 1;
                if (i3 < 10) {
                    textView = bVar.f98d;
                    str = String.valueOf(oOO0O0O0.O0000oO0 + i3);
                } else {
                    textView = bVar.f98d;
                    str = String.valueOf(i3);
                }
                textView.setText(str);
                bVar.f98d.setVisibility(0);
                bVar.f97c.setVisibility(8);
            } else {
                bVar.f98d.setVisibility(8);
                bVar.f97c.setVisibility(0);
                File a2 = AppMiniland.f().k.c().a(song.getUrlImage());
                if (a2 == null || !a2.exists()) {
                    ((AppMiniland) a.c.a.a.f).k.b(song.getUrlImage(), bVar.f97c, (a.g.a.b.b) null, (a.g.a.b.l.c) null);
                } else {
                    try {
                        bVar.f97c.setImageBitmap(BitmapFactory.decodeFile(a2.getAbsolutePath()));
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
            }
            bVar.f99e.setText(a.c.a.d.a.g(song.getTitle()));
            bVar.f.setText(song.getDurationFormatted());
            bVar.g.setSelected(song.isFavourite());
            bVar.f96b.setOnClickListener(new a(bVar, i));
        }
        return view;
    }
}
