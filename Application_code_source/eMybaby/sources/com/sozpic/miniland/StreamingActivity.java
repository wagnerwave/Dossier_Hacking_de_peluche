package com.sozpic.miniland;

import a.c.a.e.f;
import a.c.d.s.h.d;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.sozpic.miniland.TopMenuActivity;

public class StreamingActivity extends a.c.d.c implements TopMenuActivity.c, a.c.d.s.h.a {

    /* renamed from: b  reason: collision with root package name */
    public VideoView f4549b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f4550c;

    /* renamed from: d  reason: collision with root package name */
    public TopMenuActivity f4551d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f4552e;
    public String f;
    public String g;
    public ImageView h;
    public int i;
    public long j;
    public Handler k = new Handler();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            StreamingActivity streamingActivity = StreamingActivity.this;
            a.c.a.d.a.l(streamingActivity, streamingActivity.f);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            try {
                StreamingActivity.this.q();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4555a;

        public c(Dialog dialog) {
            this.f4555a = dialog;
        }

        public void onClick(View view) {
            this.f4555a.dismiss();
            StreamingActivity.this.p(a.c.a.d.a.h(R.string.TR_LOADING), true);
            a.c.d.s.h.d dVar = new a.c.d.s.h.d();
            dVar.f1162b = "https://emybaby.com/api/retrieve-url.php";
            new d.a(StreamingActivity.this).start();
        }
    }

    public class d implements MediaPlayer.OnPreparedListener {
        public d() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            a.c.a.f.e.b("Video prepared");
            StreamingActivity.this.o();
            StreamingActivity.this.f4549b.start();
        }
    }

    public class e implements MediaPlayer.OnErrorListener {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                StreamingActivity.this.j = System.currentTimeMillis();
                StreamingActivity streamingActivity = StreamingActivity.this;
                streamingActivity.f4549b.setVideoURI(Uri.parse(streamingActivity.g));
            }
        }

        public e() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.c.a.f.e.c(String.format("Streaming MediaPlayer error What: %d Extra: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            if (StreamingActivity.this.i < 5 && i == 1 && i2 == -1004) {
                long currentTimeMillis = System.currentTimeMillis() - StreamingActivity.this.j;
                long j = 0;
                if (currentTimeMillis < 10000) {
                    j = 10000 - currentTimeMillis;
                }
                StreamingActivity streamingActivity = StreamingActivity.this;
                int i3 = streamingActivity.i + 1;
                streamingActivity.i = i3;
                a.c.a.f.e.b(String.format("Streaming retry num %d in %d miliseconds...", new Object[]{Integer.valueOf(i3), Long.valueOf(j)}));
                StreamingActivity.this.k.postDelayed(new a(), j);
            } else {
                StreamingActivity.this.o();
                StreamingActivity.this.f4550c.setVisibility(0);
                StreamingActivity.this.f4552e.setVisibility(8);
                StreamingActivity.this.r();
            }
            return true;
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1004) {
            r();
        } else {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_streaming);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.f4551d = topMenuActivity;
        topMenuActivity.setListener(this);
        this.f4551d.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_CAMERA));
        ((TextView) findViewById(R.id.reproducir_title)).setText(a.c.a.d.a.h(R.string.TR_PLAY).toUpperCase());
        this.f4552e = (LinearLayout) findViewById(R.id.player);
        this.f4549b = (VideoView) findViewById(R.id.surface_view);
        this.f4550c = (ViewGroup) findViewById(R.id.streaming_text_container);
        ((TextView) findViewById(R.id.mensaje)).setText(a.c.a.d.a.h(R.string.TR_CAMERA_START_TEXT));
        this.f = getIntent().getStringExtra("KEY_INTENT_HELP_SECTION_CODE");
        ImageView imageView = (ImageView) findViewById(R.id.streaming_help_icon);
        imageView.setOnClickListener(new a());
        boolean containsKey = a.c.d.r.a.f781d.f784c.containsKey(this.f);
        imageView.setVisibility(containsKey ? 0 : 4);
        if (a.c.a.d.a.j(this.f) || !containsKey || a.c.d.a.l().q(this.f)) {
            r();
        } else {
            a.c.a.d.a.l(this, this.f);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.reproducir);
        this.h = imageView2;
        imageView2.setAlpha(0.5f);
        this.h.setEnabled(false);
        this.h.setOnClickListener(new b());
    }

    public void q() {
        this.f4550c.setVisibility(8);
        this.f4552e.setVisibility(0);
        new MediaController(this).setMediaPlayer(this.f4549b);
        this.i = 1;
        this.j = System.currentTimeMillis();
        p(a.c.a.d.a.h(R.string.TR_RECIBIENDO_SENYAL), true);
        try {
            this.f4549b.setVideoURI(Uri.parse(this.g));
            this.f4549b.requestFocus();
            this.f4549b.setOnPreparedListener(new d());
            this.f4549b.setOnErrorListener(new e());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        f.c().d("VIGILABEBE", "PLAY", "");
    }

    public void r() {
        Dialog dialog = new Dialog(this, 2131886561);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.popup_streaming);
        dialog.setCancelable(true);
        Button button = (Button) a.a.a.a.a.A(R.string.TR_CAMERA_MONITOR_ADVERTISMENT, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
        button.setText(a.c.a.d.a.h(R.string.TR_OK));
        button.setOnClickListener(new c(dialog));
        dialog.show();
    }
}
