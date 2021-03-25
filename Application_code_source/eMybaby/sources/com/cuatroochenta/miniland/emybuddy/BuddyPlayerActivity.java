package com.cuatroochenta.miniland.emybuddy;

import a.c.d.g.j.c;
import a.c.d.g.k.b;
import a.c.d.s.a.c.a.e;
import a.c.d.s.a.c.b.e;
import a.c.d.s.a.c.c.e;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.cuatroochenta.miniland.model.Song;
import com.cuatroochenta.miniland.player.PlayerReceiver;
import com.cuatroochenta.miniland.player.PlayerService;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import de.timroes.swipetodismiss.SwipeDismissList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class BuddyPlayerActivity extends a.c.d.c implements b.c, c.C0001c, a.c.d.s.a.c.c.a, a.c.d.s.a.b.e, a.c.d.s.a.c.b.a, a.c.d.s.a.c.a.a {
    public Handler A = new Handler();

    /* renamed from: b  reason: collision with root package name */
    public Runnable f3825b = new h();

    /* renamed from: c  reason: collision with root package name */
    public String f3826c;

    /* renamed from: d  reason: collision with root package name */
    public String f3827d;

    /* renamed from: e  reason: collision with root package name */
    public ListView f3828e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public SeekBar j;
    public TextView k;
    public TextView l;
    public boolean m = false;
    public PlayerReceiver n;
    public int o = -1;
    public int p = -1;
    public MediaRecorder q;
    public ViewGroup r;
    public ViewGroup s;
    public ViewGroup t;
    public ViewGroup u;
    public TextView v;
    public File w;
    public ViewGroup x;
    public Chronometer y;
    public a.c.d.g.k.c z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            BuddyPlayerActivity.this.z(true, false);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            BuddyPlayerActivity.this.z(false, false);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            BuddyPlayerActivity buddyPlayerActivity = BuddyPlayerActivity.this;
            int i = buddyPlayerActivity.o;
            int i2 = buddyPlayerActivity.p;
            a.c.d.g.k.c cVar = new a.c.d.g.k.c();
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_STATUS", i);
            bundle.putInt("ARG_TIME_FINISH", i2);
            cVar.setArguments(bundle);
            buddyPlayerActivity.z = cVar;
            BuddyPlayerActivity buddyPlayerActivity2 = BuddyPlayerActivity.this;
            buddyPlayerActivity2.z.show(buddyPlayerActivity2.getSupportFragmentManager(), "TIME_PICKER");
        }
    }

    public class d implements AdapterView.OnItemLongClickListener {
        public d() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            Song song;
            if (!"BUDDY_PARENTS".equals(BuddyPlayerActivity.this.f3826c)) {
                return false;
            }
            a.c.d.g.j.c cVar = (a.c.d.g.j.c) BuddyPlayerActivity.this.f3828e.getAdapter();
            if (cVar != null && i >= 0 && i < cVar.getCount() && (song = cVar.f89b.get(i)) != null) {
                a.c.d.g.k.b.m(1, song).show(BuddyPlayerActivity.this.getSupportFragmentManager(), "EDIT_PARENT_SOUND");
            }
            return true;
        }
    }

    public class e implements SwipeDismissList.OnDismissCallback {
        public e() {
        }

        public SwipeDismissList.Undoable onDismiss(AbsListView absListView, int i) {
            Song song;
            a.c.d.g.j.c cVar = (a.c.d.g.j.c) BuddyPlayerActivity.this.f3828e.getAdapter();
            if (cVar == null || i < 0 || i >= cVar.getCount() || (song = cVar.f89b.get(i)) == null) {
                return null;
            }
            a.c.d.g.k.b.m(3, song).show(BuddyPlayerActivity.this.getSupportFragmentManager(), "EDIT_PARENT_SOUND");
            return null;
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            BuddyPlayerActivity.this.u();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            BuddyPlayerActivity.this.v();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            BuddyPlayerActivity buddyPlayerActivity = BuddyPlayerActivity.this;
            if (buddyPlayerActivity.q != null) {
                buddyPlayerActivity.z(true, true);
            }
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BuddyPlayerActivity.this.w(i);
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public void onClick(View view) {
            a.c.d.g.j.c cVar = (a.c.d.g.j.c) BuddyPlayerActivity.this.f3828e.getAdapter();
            if (cVar != null) {
                BuddyPlayerActivity.this.w(cVar.f90c);
            }
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public void onClick(View view) {
            a.c.a.f.b.g0(BuddyPlayerActivity.this, 4);
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        public void onClick(View view) {
            a.c.a.f.b.g0(BuddyPlayerActivity.this, 3);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        public void onClick(View view) {
            view.setSelected(!view.isSelected());
            if (view.isSelected() && BuddyPlayerActivity.this.h.isSelected()) {
                BuddyPlayerActivity.this.h.setSelected(false);
            }
            BuddyPlayerActivity buddyPlayerActivity = BuddyPlayerActivity.this;
            boolean isSelected = view.isSelected();
            if (a.c.a.f.b.U(buddyPlayerActivity)) {
                Intent intent = new Intent(buddyPlayerActivity, PlayerService.class);
                intent.putExtra("EXTRA_KEY_LOOP_CURRENT_LIST", isSelected);
                buddyPlayerActivity.startService(intent);
            }
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        public void onClick(View view) {
            view.setSelected(!view.isSelected());
            if (view.isSelected() && BuddyPlayerActivity.this.g.isSelected()) {
                BuddyPlayerActivity.this.g.setSelected(false);
            }
            BuddyPlayerActivity buddyPlayerActivity = BuddyPlayerActivity.this;
            boolean isSelected = view.isSelected();
            if (a.c.a.f.b.U(buddyPlayerActivity)) {
                Intent intent = new Intent(buddyPlayerActivity, PlayerService.class);
                intent.putExtra("EXTRA_KEY_SHUFFLE_CURRENT_LIST", isSelected);
                buddyPlayerActivity.startService(intent);
            }
        }
    }

    public class o implements SeekBar.OnSeekBarChangeListener {
        public o() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            BuddyPlayerActivity buddyPlayerActivity = BuddyPlayerActivity.this;
            int progress = seekBar.getProgress();
            if (a.c.a.f.b.U(buddyPlayerActivity)) {
                Intent intent = new Intent(buddyPlayerActivity, PlayerService.class);
                intent.putExtra("EXTRA_KEY_SEEK_TO_CURRENT_TRACK", progress);
                buddyPlayerActivity.startService(intent);
            }
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        public void onClick(View view) {
            a.c.d.g.j.c cVar = (a.c.d.g.j.c) BuddyPlayerActivity.this.f3828e.getAdapter();
            if (cVar != null) {
                Iterator<Song> it = cVar.f89b.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j += it.next().getFileSize();
                }
                a.c.a.f.e.b(String.format("Parent Sounds size: %s", new Object[]{a.c.a.f.b.u0(j)}));
                if (31457280 < j) {
                    a.c.a.f.b.h0(BuddyPlayerActivity.this, a.c.a.d.a.h(R.string.TR_MAX_USER_SPACE_REACHED), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                    return;
                }
            }
            if (ContextCompat.checkSelfPermission(view.getContext(), "android.permission.RECORD_AUDIO") != 0) {
                ActivityCompat.requestPermissions(BuddyPlayerActivity.this, new String[]{"android.permission.RECORD_AUDIO"}, 101);
                return;
            }
            BuddyPlayerActivity.this.y();
        }
    }

    public void f(a.c.d.s.a.c.a.b bVar) {
        p(a.c.a.d.a.h(R.string.TR_DELETING_SONG), true);
        a.c.d.s.a.c.a.e eVar = new a.c.d.s.a.c.a.e();
        eVar.f832b = "https://emybaby.com/api/emybuddy.php";
        new e.a(bVar, this).start();
    }

    public void h() {
    }

    public void k(a.c.d.s.a.c.c.b bVar) {
        p(a.c.a.d.a.h(R.string.TR_UPLOADING_SONG), true);
        new e.b(bVar, this).start();
    }

    public void m(a.c.d.s.a.c.b.b bVar) {
        p(a.c.a.d.a.h(R.string.TR_UPDATING), true);
        a.c.d.s.a.c.b.e eVar = new a.c.d.s.a.c.b.e();
        eVar.f840b = "https://emybaby.com/api/emybuddy.php";
        new e.a(bVar, this).start();
    }

    public void onBackPressed() {
        if (this.q != null) {
            z(true, false);
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        this.n = new PlayerReceiver(this);
        setContentView(R.layout.activity_mybuddy_player);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.buddy_player_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_BEMYBUDDY_TITLE_IOS).toUpperCase());
        String stringExtra = getIntent().getStringExtra("KEY_INTENT_PLAYER_SECTION");
        this.f3826c = stringExtra;
        if (a.c.a.d.a.j(stringExtra)) {
            finish();
            return;
        }
        ListView listView = (ListView) findViewById(R.id.buddy_player_playlist);
        this.f3828e = listView;
        listView.setOnItemClickListener(new i());
        ImageView imageView = (ImageView) findViewById(R.id.buddy_player_btplay);
        this.f = imageView;
        imageView.setOnClickListener(new j());
        ((ImageView) findViewById(R.id.buddy_player_btforward)).setOnClickListener(new k());
        ((ImageView) findViewById(R.id.buddy_player_btrewind)).setOnClickListener(new l());
        ImageView imageView2 = (ImageView) findViewById(R.id.buddy_player_loop);
        this.g = imageView2;
        imageView2.setOnClickListener(new m());
        ImageView imageView3 = (ImageView) findViewById(R.id.buddy_player_shuffle);
        this.h = imageView3;
        imageView3.setOnClickListener(new n());
        SeekBar seekBar = (SeekBar) findViewById(R.id.buddy_player_progress);
        this.j = seekBar;
        seekBar.setOnSeekBarChangeListener(new o());
        this.k = (TextView) findViewById(R.id.buddy_player_played_elapsedtime);
        this.l = (TextView) findViewById(R.id.buddy_player_played_timetofinish);
        this.t = (ViewGroup) findViewById(R.id.buddy_player_play_controls_container);
        this.u = (ViewGroup) findViewById(R.id.buddy_player_progress_container);
        TextView textView = (TextView) findViewById(R.id.buddy_player_record_start);
        this.v = textView;
        textView.setText(a.c.a.d.a.h(R.string.TR_RECORD_A_NEW_SOUND));
        this.v.setOnClickListener(new p());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.buddy_player_record_controls);
        this.r = viewGroup;
        viewGroup.setVisibility(8);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.buddy_player_record_progress_container);
        this.s = viewGroup2;
        viewGroup2.setVisibility(4);
        this.x = (ViewGroup) findViewById(R.id.buddy_player_record_controls_container);
        Chronometer chronometer = (Chronometer) findViewById(R.id.buddy_player_record_progress);
        this.y = chronometer;
        chronometer.setFormat(a.c.a.d.a.i(R.string.TR_RECORDING_TIME_PLACEHOLDER));
        TextView textView2 = (TextView) findViewById(R.id.buddy_player_record_stop_and_save);
        textView2.setText(a.c.a.d.a.h(R.string.TR_STOP_AND_SAVE));
        textView2.setOnClickListener(new a());
        TextView textView3 = (TextView) findViewById(R.id.buddy_player_record_cancel);
        textView3.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        textView3.setOnClickListener(new b());
        ImageView imageView4 = (ImageView) findViewById(R.id.buddy_player_timer);
        this.i = imageView4;
        imageView4.setOnClickListener(new c());
        if ("BUDDY_PARENTS".equals(this.f3826c)) {
            this.f3828e.setOnItemLongClickListener(new d());
            new SwipeDismissList(this.f3828e, new e(), SwipeDismissList.UndoMode.SINGLE_UNDO);
        }
        ImageView imageView5 = (ImageView) findViewById(R.id.buddy_player_head_background_image);
        ((TextView) findViewById(R.id.buddy_player_category_name)).setText(a.c.d.r.j.b().e(this.f3826c).toUpperCase());
        if ("BUDDY_PARENTS".equals(this.f3826c)) {
            imageView5.setBackgroundResource(R.drawable.bg_cat_parents);
            this.x.setVisibility(0);
        } else {
            if ("BUDDY_NATURE".equals(this.f3826c)) {
                i2 = R.drawable.bg_cat_nature;
            } else if ("BUDDY_CLOSE_MUM".equals(this.f3826c)) {
                i2 = R.drawable.bg_cat_mom;
            } else if ("BUDDY_CLASSIC".equals(this.f3826c)) {
                i2 = R.drawable.bg_cat_classical;
            } else if ("BUDDY_LULLABIES".equals(this.f3826c)) {
                i2 = R.drawable.bg_cat_lullabies;
            } else if ("BUDDY_DEVICE".equals(this.f3826c)) {
                i2 = R.drawable.bg_cat_device;
            } else if ("BUDDY_FAVOURITES".equals(this.f3826c)) {
                i2 = R.drawable.bg_cat_favourites;
            }
            imageView5.setBackgroundResource(i2);
        }
        v();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.q != null) {
            z(false, false);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.n);
        Intent intent = new Intent();
        intent.putExtra("EXTRA_KEY_PLAYLIST_TYPE", this.f3827d);
        intent.putExtra("EXTRA_KEY_INFO_IS_PLAYING", this.m);
        intent.putExtra("EXTRA_KEY_INFO_CURRENT_POSITION", this.j.getProgress());
        intent.putExtra("EXTRA_KEY_INFO_TRACK_DURATION", this.j.getMax());
        a.c.a.f.b.s0(this, intent);
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != 100) {
            if (i2 == 101 && iArr.length > 0 && iArr[0] == 0) {
                y();
            }
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            a.c.a.f.b.k0(this, a.c.a.d.a.h(R.string.TR_PERMISSION_READ_DEVICE_MUSIC));
        } else {
            v();
        }
    }

    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.n, new IntentFilter("com.cuatroochenta.miniland.PLAYER_ACTION"));
        if (a.c.a.f.b.U(this)) {
            a.c.a.f.b.g0(this, 6);
        } else {
            this.m = false;
            this.f.setImageResource(0 != 0 ? R.drawable.ic_pause : R.drawable.ic_play);
        }
        ((NotificationManager) getSystemService("notification")).cancel(480480);
        a.c.a.e.f.c().e("BEMYBUDDY_PLAYER");
        a.c.a.e.f.c().d("MY_BUDDY", "PLAYER_SECTION", a.c.d.r.j.b().e(this.f3826c));
    }

    public final void t() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(2);
        } else {
            layoutParams.addRule(2, 0);
        }
        layoutParams.addRule(8, R.id.buddy_player_head_background_image);
        this.v.setVisibility(8);
        this.t.setVisibility(4);
        this.r.setVisibility(0);
        this.u.setVisibility(8);
        this.s.setVisibility(0);
        this.y.setBase(SystemClock.elapsedRealtime());
        this.y.start();
    }

    public final void u() {
        int elapsedRealtime = (int) ((SystemClock.elapsedRealtime() - this.y.getBase()) / 1000);
        String absolutePath = this.w.getAbsolutePath();
        a.c.d.g.k.b bVar = new a.c.d.g.k.b();
        Bundle bundle = new Bundle();
        if (!a.c.a.d.a.j(absolutePath)) {
            bundle.putString("ARG_FILE_ABSOLUTE_PATH", absolutePath);
        }
        bundle.putInt("DURATION", elapsedRealtime);
        bundle.putInt("MODE", 0);
        bVar.setArguments(bundle);
        bVar.setCancelable(false);
        bVar.show(getSupportFragmentManager(), "SAVE_PARENT_SOUND");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x010d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v() {
        /*
            r6 = this;
            android.widget.ListView r0 = r6.f3828e
            android.widget.ListAdapter r0 = r0.getAdapter()
            a.c.d.g.j.c r0 = (a.c.d.g.j.c) r0
            if (r0 != 0) goto L_0x0016
            a.c.d.g.j.c r0 = new a.c.d.g.j.c
            r0.<init>(r6)
            r0.f91d = r6
            android.widget.ListView r1 = r6.f3828e
            r1.setAdapter(r0)
        L_0x0016:
            java.lang.String r1 = r6.f3826c
            java.lang.String r2 = "BUDDY_DEVICE"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            int r2 = androidx.core.content.ContextCompat.checkSelfPermission(r6, r1)
            if (r2 == 0) goto L_0x0035
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 100
            androidx.core.app.ActivityCompat.requestPermissions(r6, r2, r1)
            goto L_0x0113
        L_0x0035:
            java.util.ArrayList r1 = a.c.a.f.b.f0(r6)
        L_0x0039:
            r0.b(r1)
            goto L_0x0113
        L_0x003e:
            java.lang.String r1 = r6.f3826c
            java.lang.String r2 = "BUDDY_FAVOURITES"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x00b3
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            a.c.d.r.a r2 = a.c.d.r.a.f781d
            java.util.Collection r2 = r2.b()
            java.util.Iterator r2 = r2.iterator()
        L_0x0057:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0081
            java.lang.Object r3 = r2.next()
            com.cuatroochenta.miniland.model.SongCategory r3 = (com.cuatroochenta.miniland.model.SongCategory) r3
            java.util.ArrayList r3 = r3.getSongList()
            java.util.Iterator r3 = r3.iterator()
        L_0x006b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0057
            java.lang.Object r4 = r3.next()
            com.cuatroochenta.miniland.model.Song r4 = (com.cuatroochenta.miniland.model.Song) r4
            boolean r5 = r4.isFavourite()
            if (r5 == 0) goto L_0x006b
            r1.add(r4)
            goto L_0x006b
        L_0x0081:
            a.c.d.a r2 = a.c.d.a.l()
            java.util.ArrayList r2 = r2.k()
            if (r2 == 0) goto L_0x0039
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0039
            java.util.ArrayList r3 = a.c.a.f.b.f0(r6)
            java.util.Iterator r3 = r3.iterator()
        L_0x0099:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r3.next()
            com.cuatroochenta.miniland.model.Song r4 = (com.cuatroochenta.miniland.model.Song) r4
            java.lang.String r5 = r4.getId()
            boolean r5 = r2.contains(r5)
            if (r5 == 0) goto L_0x0099
            r1.add(r4)
            goto L_0x0099
        L_0x00b3:
            a.c.d.r.a r1 = a.c.d.r.a.f781d
            java.lang.String r2 = r6.f3826c
            if (r1 == 0) goto L_0x0117
            boolean r3 = a.c.a.d.a.j(r2)
            if (r3 != 0) goto L_0x0106
            java.lang.String r3 = "BUDDY_CLASSIC"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00d2
            java.util.HashMap<java.lang.String, com.cuatroochenta.miniland.model.SongCategory> r1 = r1.f783b
            java.lang.String r2 = a.c.d.r.j.r
        L_0x00cb:
            java.lang.Object r1 = r1.get(r2)
            com.cuatroochenta.miniland.model.SongCategory r1 = (com.cuatroochenta.miniland.model.SongCategory) r1
            goto L_0x010b
        L_0x00d2:
            java.lang.String r3 = "BUDDY_NATURE"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00df
            java.util.HashMap<java.lang.String, com.cuatroochenta.miniland.model.SongCategory> r1 = r1.f783b
            java.lang.String r2 = a.c.d.r.j.p
            goto L_0x00cb
        L_0x00df:
            java.lang.String r3 = "BUDDY_CLOSE_MUM"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00ec
            java.util.HashMap<java.lang.String, com.cuatroochenta.miniland.model.SongCategory> r1 = r1.f783b
            java.lang.String r2 = a.c.d.r.j.q
            goto L_0x00cb
        L_0x00ec:
            java.lang.String r3 = "BUDDY_LULLABIES"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00f9
            java.util.HashMap<java.lang.String, com.cuatroochenta.miniland.model.SongCategory> r1 = r1.f783b
            java.lang.String r2 = a.c.d.r.j.s
            goto L_0x00cb
        L_0x00f9:
            java.lang.String r3 = "BUDDY_PARENTS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0106
            java.util.HashMap<java.lang.String, com.cuatroochenta.miniland.model.SongCategory> r1 = r1.f783b
            java.lang.String r2 = a.c.d.r.j.o
            goto L_0x00cb
        L_0x0106:
            com.cuatroochenta.miniland.model.SongCategory r1 = new com.cuatroochenta.miniland.model.SongCategory
            r1.<init>()
        L_0x010b:
            if (r1 == 0) goto L_0x0113
            java.util.ArrayList r1 = r1.getSongList()
            goto L_0x0039
        L_0x0113:
            r0.notifyDataSetChanged()
            return
        L_0x0117:
            r0 = 0
            goto L_0x011a
        L_0x0119:
            throw r0
        L_0x011a:
            goto L_0x0119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity.v():void");
    }

    public void w(int i2) {
        a.c.d.g.j.c cVar = (a.c.d.g.j.c) this.f3828e.getAdapter();
        boolean z2 = (cVar == null || i2 == cVar.f90c) ? false : true;
        if (!a.c.a.f.b.U(this) || (z2 && !this.f3826c.equals(this.f3827d))) {
            ArrayList<Song> arrayList = cVar.f89b;
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<Song> it = arrayList.iterator();
                while (it.hasNext()) {
                    Song next = it.next();
                    if (next.getSource() != null) {
                        arrayList2.add(next);
                    }
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                String str = this.f3826c;
                boolean isSelected = this.g.isSelected();
                boolean isSelected2 = this.h.isSelected();
                if (!arrayList2.isEmpty()) {
                    Intent intent = new Intent(this, PlayerService.class);
                    intent.putParcelableArrayListExtra("EXTRA_KEY_PLAY_PLAYER_LIST", arrayList2);
                    intent.putExtra("EXTRA_KEY_PLAYLIST_TYPE", str);
                    intent.putExtra("EXTRA_KEY_LOOP_CURRENT_LIST", isSelected);
                    intent.putExtra("EXTRA_KEY_SHUFFLE_CURRENT_LIST", isSelected2);
                    intent.putExtra("EXTRA_KEY_FIRST_SONG_POSITION", i2);
                    startService(intent);
                }
            }
        } else if (!z2) {
            a.c.a.f.b.g0(this, 0);
        } else if (a.c.a.f.b.U(this)) {
            Intent intent2 = new Intent(this, PlayerService.class);
            intent2.putExtra("EXTRA_KEY_MOVE_TO_TRACK_NUM", i2);
            startService(intent2);
        }
    }

    public void x(a.c.d.s.a.b.b bVar) {
        a.c.d.g.j.c cVar;
        int a2;
        if (bVar.f42a.booleanValue()) {
            if ("BUDDY_FAVOURITES".equals(this.f3826c) && (cVar = (a.c.d.g.j.c) this.f3828e.getAdapter()) != null && (a2 = cVar.a(bVar.f823c)) >= 0) {
                a.c.a.f.b.e0(this, a2);
            }
            runOnUiThread(new g());
        }
    }

    public final void y() {
        a.c.a.e.f.c().d("MY_BUDDY", "RECORD", "");
        a.c.a.f.b.x0(this);
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.q = mediaRecorder;
        mediaRecorder.setAudioSource(1);
        this.q.setOutputFormat(2);
        if (a.c.d.r.j.b() != null) {
            String packageName = AppMiniland.f().getPackageName();
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + packageName + "/parentsounds/");
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(file, a.c.d.r.j.f799e.format(Calendar.getInstance().getTime()));
                StringBuilder n2 = a.a.a.a.a.n("Creating file for save parent sound:");
                n2.append(file2.getAbsolutePath());
                a.c.a.f.e.b(n2.toString());
                this.w = file2;
                this.q.setOutputFile(file2.getAbsolutePath());
                this.q.setAudioEncoder(1);
                try {
                    this.q.prepare();
                    this.q.start();
                    this.A.postDelayed(this.f3825b, 180000);
                    t();
                } catch (IOException e2) {
                    a.c.a.f.e.c("prepare() failed");
                    e2.printStackTrace();
                }
            } else {
                throw new RuntimeException("Error al crear el directorio");
            }
        } else {
            throw null;
        }
    }

    public final void z(boolean z2, boolean z3) {
        if (!z3) {
            this.A.removeCallbacks(this.f3825b);
        }
        this.q.stop();
        this.q.release();
        this.q = null;
        this.v.setVisibility(0);
        this.r.setVisibility(8);
        this.u.setVisibility(0);
        this.t.setVisibility(0);
        this.s.setVisibility(8);
        this.y.stop();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(8);
        } else {
            layoutParams.addRule(8, 0);
        }
        layoutParams.addRule(2, R.id.buddy_player_progress_container);
        if (!z2) {
            File file = this.w;
            if (file != null && file.exists()) {
                this.w.delete();
            }
        } else if (z3) {
            String h2 = a.c.a.d.a.h(R.string.TR_MAX_RECORDING_TIME_REACHED);
            String h3 = a.c.a.d.a.h(R.string.TR_ACEPTAR);
            f fVar = new f();
            if (!a.c.a.d.a.j(h2)) {
                new AlertDialog.Builder(this).setIcon(17301543).setMessage(h2).setPositiveButton(h3, fVar).setCancelable(false).show();
            }
        } else {
            u();
        }
    }
}
