package com.sozpic.miniland.video;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tutk.IOTC.Camera;
import com.tutk.IOTC.IRegisterIOTCListener;
import com.tutk.IOTC.Monitor;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

@SuppressLint({"NewApi"})
public class LiveViewActivity extends Activity implements ViewSwitcher.ViewFactory, IRegisterIOTCListener, View.OnClickListener, TopMenuActivityVideo.c {

    /* renamed from: a  reason: collision with root package name */
    public Monitor f4668a = null;

    /* renamed from: b  reason: collision with root package name */
    public a.h.a.n0.c f4669b = null;

    /* renamed from: c  reason: collision with root package name */
    public a.h.a.n0.b f4670c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4671d;

    /* renamed from: e  reason: collision with root package name */
    public String f4672e;
    public String f = "";
    public int g;
    public int h;
    public int i;
    public TextView j;
    public boolean k = false;
    public boolean l = false;
    public Button m;
    public Button n;
    public Button o;
    public Button p;
    public Button q;
    public TextView r;
    public TopMenuActivityVideo s;
    public boolean t = false;
    public Handler u = new Handler();
    public Handler v = new c();

    public class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f4673a;

        public a(View view) {
            this.f4673a = view;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == this.f4673a.findViewById(R.id.radioSpeaker).getId()) {
                LiveViewActivity liveViewActivity = LiveViewActivity.this;
                if (liveViewActivity.f4669b.isChannelConnected(liveViewActivity.i)) {
                    LiveViewActivity liveViewActivity2 = LiveViewActivity.this;
                    liveViewActivity2.f4669b.stopSpeaking(liveViewActivity2.i);
                    LiveViewActivity liveViewActivity3 = LiveViewActivity.this;
                    liveViewActivity3.f4669b.startListening(liveViewActivity3.i);
                    LiveViewActivity liveViewActivity4 = LiveViewActivity.this;
                    liveViewActivity4.k = true;
                    liveViewActivity4.l = false;
                }
            } else if (i == this.f4673a.findViewById(R.id.radioMicrophone).getId()) {
                LiveViewActivity liveViewActivity5 = LiveViewActivity.this;
                if (liveViewActivity5.f4669b.isChannelConnected(liveViewActivity5.i)) {
                    LiveViewActivity liveViewActivity6 = LiveViewActivity.this;
                    liveViewActivity6.f4669b.stopListening(liveViewActivity6.i);
                    LiveViewActivity liveViewActivity7 = LiveViewActivity.this;
                    liveViewActivity7.f4669b.startSpeaking(liveViewActivity7.i);
                    LiveViewActivity liveViewActivity8 = LiveViewActivity.this;
                    liveViewActivity8.k = false;
                    liveViewActivity8.l = true;
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            LiveViewActivity liveViewActivity = LiveViewActivity.this;
            if (liveViewActivity.t) {
                liveViewActivity.t = false;
                liveViewActivity.g();
                return;
            }
            liveViewActivity.f4669b.stopSpeaking(liveViewActivity.i);
            LiveViewActivity liveViewActivity2 = LiveViewActivity.this;
            liveViewActivity2.f4669b.startListening(liveViewActivity2.i);
            LiveViewActivity liveViewActivity3 = LiveViewActivity.this;
            liveViewActivity3.k = true;
            liveViewActivity3.l = false;
        }
    }

    public class c extends Handler {
        public c() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x00af, code lost:
            if (r1 != null) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c2, code lost:
            if (r1 != null) goto L_0x0152;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d5, code lost:
            if (r1 != null) goto L_0x0152;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e3, code lost:
            r1 = r4.f4676a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0100, code lost:
            if (r1 != null) goto L_0x0152;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0117, code lost:
            if (r0.f4669b.isChannelConnected(r0.i) == false) goto L_0x0119;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0128, code lost:
            if (r1 != null) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x012a, code lost:
            r1.setText(r0.f);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0150, code lost:
            if (r1 != null) goto L_0x0152;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r5) {
            /*
                r4 = this;
                android.os.Bundle r0 = r5.getData()
                java.lang.String r1 = "avChannel"
                int r0 = r0.getInt(r1)
                int r1 = r5.what
                r2 = 8
                if (r1 == r2) goto L_0x0141
                r2 = 98
                r3 = 0
                if (r1 == r2) goto L_0x0130
                r2 = 809(0x329, float:1.134E-42)
                if (r1 == r2) goto L_0x0157
                switch(r1) {
                    case 1: goto L_0x0103;
                    case 2: goto L_0x00d9;
                    case 3: goto L_0x00c6;
                    case 4: goto L_0x00b3;
                    case 5: goto L_0x00a0;
                    case 6: goto L_0x001e;
                    default: goto L_0x001c;
                }
            L_0x001c:
                goto L_0x015c
            L_0x001e:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                if (r1 == 0) goto L_0x015c
                int r0 = r0.i
                r1.stopSpeaking(r0)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                int r0 = r0.i
                r1.stopListening(r0)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                int r0 = r0.i
                r1.stopShow(r0)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                int r0 = r0.i
                r1.stop(r0)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r0 = r0.f4669b
                r0.disconnect()
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                java.lang.String r0 = r0.f4671d
                r1.connect(r0)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                a.h.a.n0.b r0 = r0.f4670c
                java.lang.String r2 = r0.f3529e
                java.lang.String r0 = r0.f
                r1.start(r3, r2, r0)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                int r0 = r0.i
                r1.startShow(r0)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r0 = r0.f4669b
                r1 = 808(0x328, float:1.132E-42)
                byte[] r2 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent()
                r0.sendIOCtrl(r3, r1, r2)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r0 = r0.f4669b
                r1 = 816(0x330, float:1.143E-42)
                byte[] r2 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent()
                r0.sendIOCtrl(r3, r1, r2)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r0 = r0.f4669b
                r1 = 810(0x32a, float:1.135E-42)
                byte[] r2 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent()
                r0.sendIOCtrl(r3, r1, r2)
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                boolean r1 = r0.k
                if (r1 == 0) goto L_0x015c
                a.h.a.n0.c r1 = r0.f4669b
                int r0 = r0.i
                r1.startListening(r0)
                goto L_0x015c
            L_0x00a0:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r1 = 2131821351(0x7f110327, float:1.9275443E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)
                r0.f = r1
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                android.widget.TextView r1 = r0.j
                if (r1 == 0) goto L_0x015c
                goto L_0x012a
            L_0x00b3:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r1 = 2131821350(0x7f110326, float:1.927544E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)
                r0.f = r1
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                android.widget.TextView r1 = r0.j
                if (r1 == 0) goto L_0x0157
                goto L_0x0152
            L_0x00c6:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r1 = 2131821347(0x7f110323, float:1.9275435E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)
                r0.f = r1
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                android.widget.TextView r1 = r0.j
                if (r1 == 0) goto L_0x0157
                goto L_0x0152
            L_0x00d9:
                com.sozpic.miniland.video.LiveViewActivity r1 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r1.f4669b
                boolean r1 = r1.isSessionConnected()
                if (r1 == 0) goto L_0x015c
                com.sozpic.miniland.video.LiveViewActivity r1 = com.sozpic.miniland.video.LiveViewActivity.this
                int r2 = r1.i
                if (r0 != r2) goto L_0x015c
                a.h.a.n0.c r0 = r1.f4669b
                boolean r0 = r0.isChannelConnected(r2)
                if (r0 == 0) goto L_0x015c
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r1 = 2131821348(0x7f110324, float:1.9275437E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)
                r0.f = r1
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                android.widget.TextView r1 = r0.j
                if (r1 == 0) goto L_0x0157
                goto L_0x0152
            L_0x0103:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r0 = r0.f4669b
                boolean r0 = r0.isSessionConnected()
                if (r0 == 0) goto L_0x0119
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                a.h.a.n0.c r1 = r0.f4669b
                int r0 = r0.i
                boolean r0 = r1.isChannelConnected(r0)
                if (r0 != 0) goto L_0x015c
            L_0x0119:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r1 = 2131821345(0x7f110321, float:1.927543E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)
                r0.f = r1
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                android.widget.TextView r1 = r0.j
                if (r1 == 0) goto L_0x015c
            L_0x012a:
                java.lang.String r0 = r0.f
                r1.setText(r0)
                goto L_0x015c
            L_0x0130:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r1 = 2131821416(0x7f110368, float:1.9275575E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r3)
                r0.show()
                goto L_0x015c
            L_0x0141:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r1 = 2131821346(0x7f110322, float:1.9275433E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)
                r0.f = r1
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                android.widget.TextView r1 = r0.j
                if (r1 == 0) goto L_0x0157
            L_0x0152:
                java.lang.String r0 = r0.f
                r1.setText(r0)
            L_0x0157:
                com.sozpic.miniland.video.LiveViewActivity r0 = com.sozpic.miniland.video.LiveViewActivity.this
                r0.invalidateOptionsMenu()
            L_0x015c:
                super.handleMessage(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.video.LiveViewActivity.c.handleMessage(android.os.Message):void");
        }
    }

    public class d implements MediaScannerConnection.OnScanCompletedListener {
        public d() {
        }

        public void onScanCompleted(String str, Uri uri) {
            Log.i("ExternalStorage", "Scanned " + str + ":");
            StringBuilder sb = new StringBuilder();
            sb.append("-> uri=");
            sb.append(uri);
            Log.i("ExternalStorage", sb.toString());
            Message obtainMessage = LiveViewActivity.this.v.obtainMessage();
            obtainMessage.what = 98;
            LiveViewActivity.this.v.sendMessage(obtainMessage);
        }
    }

    public class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4678a;

        public e(Dialog dialog) {
            this.f4678a = dialog;
        }

        public void onClick(View view) {
            Log.e("SONIDO", "A Silencio");
            LiveViewActivity.this.o.setBackgroundResource(R.drawable.altavoz_desactivado);
            LiveViewActivity liveViewActivity = LiveViewActivity.this;
            liveViewActivity.f4669b.stopListening(liveViewActivity.i);
            LiveViewActivity liveViewActivity2 = LiveViewActivity.this;
            liveViewActivity2.f4669b.stopSpeaking(liveViewActivity2.i);
            LiveViewActivity liveViewActivity3 = LiveViewActivity.this;
            liveViewActivity3.k = false;
            liveViewActivity3.l = false;
            this.f4678a.dismiss();
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4680a;

        public f(Dialog dialog) {
            this.f4680a = dialog;
        }

        public void onClick(View view) {
            if (!LiveViewActivity.this.k) {
                Log.e("SONIDO", "A escuchar");
                LiveViewActivity liveViewActivity = LiveViewActivity.this;
                liveViewActivity.f4669b.stopSpeaking(liveViewActivity.i);
                LiveViewActivity liveViewActivity2 = LiveViewActivity.this;
                liveViewActivity2.f4669b.startListening(liveViewActivity2.i);
                LiveViewActivity liveViewActivity3 = LiveViewActivity.this;
                liveViewActivity3.l = false;
                liveViewActivity3.o.setBackgroundResource(R.drawable.altavoz_activo);
                LiveViewActivity.this.k = true;
            }
            this.f4680a.dismiss();
        }
    }

    public class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4682a;

        public g(Dialog dialog) {
            this.f4682a = dialog;
        }

        public void onClick(View view) {
            LiveViewActivity.this.d();
            this.f4682a.dismiss();
        }
    }

    public void a() {
        e();
    }

    public void b() {
    }

    public final void d() {
        if (this.l) {
            return;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 101);
            return;
        }
        g();
    }

    public final void e() {
        byte[] bArr;
        Bitmap Snapshot = this.f4669b.Snapshot(this.i);
        int i2 = 0;
        if (Snapshot == null || Snapshot.isRecycled()) {
            bArr = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Snapshot.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        }
        a.h.a.n0.a aVar = new a.h.a.n0.a(this);
        aVar.f(this.f4671d, this.i);
        if (bArr != null) {
            aVar.h(this.f4671d, bArr);
        }
        Monitor monitor = this.f4668a;
        if (monitor != null) {
            monitor.deattachCamera();
        }
        a.h.a.n0.c cVar = this.f4669b;
        if (cVar != null) {
            if (this.k) {
                i2 = 1;
            } else if (this.l) {
                i2 = 2;
            }
            cVar.f3530a = i2;
            this.f4669b.unregisterIOTCListener(this);
            this.f4669b.stopSpeaking(this.i);
            this.f4669b.stopListening(this.i);
            this.f4669b.stopShow(this.i);
        }
        Bundle bundle = new Bundle();
        bundle.putString("dev_uuid", this.f4672e);
        bundle.putString("dev_uid", this.f4671d);
        bundle.putByteArray("snapshot", bArr);
        bundle.putInt("camera_channel", this.i);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public final void f() {
        getWindow().setFlags(128, 128);
        getWindow().addFlags(1024);
        getWindow().clearFlags(2048);
        setContentView(R.layout.live_view_portrait);
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabeceras);
        this.s = topMenuActivityVideo;
        topMenuActivityVideo.setListener(this);
        this.s.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_CAMERA));
        TextView textView = (TextView) findViewById(R.id.txtConnectionStatus);
        this.j = textView;
        textView.setText(this.f);
        this.m = (Button) findViewById(R.id.bverfotos);
        this.n = (Button) findViewById(R.id.bhacerfoto);
        this.o = (Button) findViewById(R.id.bsonido);
        this.p = (Button) findViewById(R.id.bhablar);
        TextView textView2 = (TextView) findViewById(R.id.texto);
        this.r = textView2;
        textView2.setText(a.c.a.d.a.h(R.string.TR_LISTENING));
        this.q = (Button) findViewById(R.id.bfull);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        Monitor monitor = this.f4668a;
        if (monitor != null) {
            monitor.deattachCamera();
        }
        this.f4668a = null;
        Monitor monitor2 = (Monitor) findViewById(R.id.monitor);
        this.f4668a = monitor2;
        monitor2.setMaxZoom(3.0f);
        this.f4668a.attachCamera(this.f4669b, this.i);
    }

    public final void g() {
        if (!this.l) {
            this.f4669b.stopListening(this.i);
            this.o.setBackgroundResource(R.drawable.hablar);
            this.f4669b.startSpeaking(this.i);
            this.l = true;
            this.k = false;
        }
    }

    public View makeView() {
        return new TextView(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 99) {
            Monitor monitor = (Monitor) findViewById(R.id.monitor);
            this.f4668a = monitor;
            monitor.setMaxZoom(3.0f);
            this.f4668a.attachCamera(this.f4669b, this.i);
        }
    }

    public void onBackPressed() {
        e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0125, code lost:
        if (r2 != null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0131, code lost:
        if (r2 != null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0134, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r12) {
        /*
            r11 = this;
            android.widget.Button r0 = r11.n
            java.lang.String r1 = "/Snapshot/"
            r2 = 0
            r3 = 1
            r4 = 0
            if (r12 != r0) goto L_0x0158
            a.h.a.n0.c r12 = r11.f4669b
            if (r12 == 0) goto L_0x02aa
            int r0 = r11.i
            boolean r12 = r12.isChannelConnected(r0)
            if (r12 == 0) goto L_0x02aa
            java.lang.String r12 = android.os.Environment.getExternalStorageState()
            java.lang.String r0 = "mounted"
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto L_0x0154
            java.io.File r12 = r11.getExternalFilesDir(r2)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.io.File r12 = r12.getAbsoluteFile()
            r5.append(r12)
            r5.append(r1)
            java.lang.String r12 = r11.f4671d
            r5.append(r12)
            java.lang.String r12 = r5.toString()
            r0.<init>(r12)
            boolean r12 = r0.exists()
            if (r12 != 0) goto L_0x004d
            r0.mkdirs()     // Catch:{ SecurityException -> 0x004c }
            goto L_0x004d
        L_0x004c:
        L_0x004d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.io.File r0 = r0.getAbsoluteFile()
            r12.append(r0)
            java.lang.String r0 = "/"
            r12.append(r0)
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            int r1 = r0.get(r3)
            r5 = 2
            int r5 = r0.get(r5)
            int r5 = r5 + r3
            r6 = 5
            int r6 = r0.get(r6)
            r7 = 11
            int r7 = r0.get(r7)
            r8 = 12
            int r8 = r0.get(r8)
            r9 = 13
            int r9 = r0.get(r9)
            r10 = 14
            r0.get(r10)
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r10 = "IMG_"
            r0.append(r10)
            r0.append(r1)
            r1 = 48
            r10 = 10
            if (r5 >= r10) goto L_0x009e
            r0.append(r1)
        L_0x009e:
            r0.append(r5)
            if (r6 >= r10) goto L_0x00a6
            r0.append(r1)
        L_0x00a6:
            r0.append(r6)
            r5 = 95
            r0.append(r5)
            if (r7 >= r10) goto L_0x00b3
            r0.append(r1)
        L_0x00b3:
            r0.append(r7)
            if (r8 >= r10) goto L_0x00bb
            r0.append(r1)
        L_0x00bb:
            r0.append(r8)
            if (r9 >= r10) goto L_0x00c3
            r0.append(r1)
        L_0x00c3:
            r0.append(r9)
            java.lang.String r1 = ".jpg"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            a.h.a.n0.c r0 = r11.f4669b
            if (r0 == 0) goto L_0x00e1
            int r1 = r11.i
            android.graphics.Bitmap r0 = r0.Snapshot(r1)
            goto L_0x00e2
        L_0x00e1:
            r0 = r2
        L_0x00e2:
            if (r0 == 0) goto L_0x0150
            if (r12 == 0) goto L_0x0139
            int r1 = r12.length()
            if (r1 > 0) goto L_0x00ed
            goto L_0x0139
        L_0x00ed:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x010a, all -> 0x0107 }
            r1.<init>(r12, r4)     // Catch:{ Exception -> 0x010a, all -> 0x0107 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            r5 = 90
            r0.compress(r2, r5, r1)     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            r1.flush()     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            r1.close()     // Catch:{ Exception -> 0x0104, all -> 0x0101 }
            r0 = 1
            goto L_0x013a
        L_0x0101:
            r0 = move-exception
            r2 = r1
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            r2 = r1
            goto L_0x010b
        L_0x0107:
            r0 = move-exception
        L_0x0108:
            r1 = 0
            goto L_0x012f
        L_0x010a:
            r0 = move-exception
        L_0x010b:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x012d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x012d }
            r5.<init>()     // Catch:{ all -> 0x012d }
            java.lang.String r6 = "saveImage(.): "
            r5.append(r6)     // Catch:{ all -> 0x012d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x012d }
            r5.append(r0)     // Catch:{ all -> 0x012d }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x012d }
            r1.println(r0)     // Catch:{ all -> 0x012d }
            if (r2 == 0) goto L_0x0139
        L_0x0127:
            r2.close()     // Catch:{ IOException -> 0x012b }
            goto L_0x0139
        L_0x012b:
            r0 = move-exception
            goto L_0x0134
        L_0x012d:
            r0 = move-exception
            r1 = 1
        L_0x012f:
            if (r1 == 0) goto L_0x0138
            if (r2 == 0) goto L_0x0139
            goto L_0x0127
        L_0x0134:
            r0.printStackTrace()
            goto L_0x0139
        L_0x0138:
            throw r0
        L_0x0139:
            r0 = 0
        L_0x013a:
            if (r0 == 0) goto L_0x0150
            java.lang.String[] r0 = new java.lang.String[r3]
            r0[r4] = r12
            java.lang.String[] r12 = new java.lang.String[r3]
            java.lang.String r1 = "image/*"
            r12[r4] = r1
            com.sozpic.miniland.video.LiveViewActivity$d r1 = new com.sozpic.miniland.video.LiveViewActivity$d
            r1.<init>()
            android.media.MediaScannerConnection.scanFile(r11, r0, r12, r1)
            goto L_0x02aa
        L_0x0150:
            r12 = 2131821415(0x7f110367, float:1.9275573E38)
            goto L_0x01b2
        L_0x0154:
            r12 = 2131821406(0x7f11035e, float:1.9275554E38)
            goto L_0x01b2
        L_0x0158:
            android.widget.Button r0 = r11.q
            if (r12 != r0) goto L_0x015e
            goto L_0x02aa
        L_0x015e:
            android.widget.Button r0 = r11.m
            if (r12 != r0) goto L_0x01bf
            com.tutk.IOTC.Monitor r12 = r11.f4668a
            if (r12 == 0) goto L_0x0169
            r12.deattachCamera()
        L_0x0169:
            java.io.File r12 = r11.getExternalFilesDir(r2)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r12 = r12.getAbsoluteFile()
            r2.append(r12)
            r2.append(r1)
            java.lang.String r12 = r11.f4671d
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r0.<init>(r12)
            java.lang.String[] r12 = r0.list()
            if (r12 == 0) goto L_0x01af
            int r12 = r12.length
            if (r12 <= 0) goto L_0x01af
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<com.sozpic.miniland.video.GridViewGalleryActivity> r1 = com.sozpic.miniland.video.GridViewGalleryActivity.class
            r12.<init>(r11, r1)
            java.lang.String r1 = r11.f4671d
            java.lang.String r2 = "snap"
            r12.putExtra(r2, r1)
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r1 = "images_path"
            r12.putExtra(r1, r0)
            r11.startActivity(r12)
            goto L_0x02aa
        L_0x01af:
            r12 = 2131821407(0x7f11035f, float:1.9275556E38)
        L_0x01b2:
            java.lang.String r12 = a.c.a.d.a.h(r12)
            android.widget.Toast r12 = android.widget.Toast.makeText(r11, r12, r4)
            r12.show()
            goto L_0x02aa
        L_0x01bf:
            android.widget.Button r0 = r11.o
            r1 = 2131821357(0x7f11032d, float:1.9275455E38)
            r2 = 2131821049(0x7f1101f9, float:1.927483E38)
            if (r12 != r0) goto L_0x024b
            android.app.Dialog r12 = new android.app.Dialog
            r0 = 2131886561(0x7f1201e1, float:1.9407704E38)
            r12.<init>(r11, r0)
            android.view.WindowManager$LayoutParams r0 = new android.view.WindowManager$LayoutParams
            r0.<init>()
            android.view.Window r4 = r12.getWindow()
            android.view.WindowManager$LayoutParams r5 = r4.getAttributes()
            r0.copyFrom(r5)
            r5 = -1
            r0.width = r5
            r5 = -2
            r0.height = r5
            r4.setAttributes(r0)
            r12.requestWindowFeature(r3)
            r0 = 2131493121(0x7f0c0101, float:1.8609713E38)
            r12.setContentView(r0)
            r12.setCancelable(r3)
            r0 = 2131297801(0x7f090609, float:1.8213557E38)
            android.view.View r0 = r12.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = 2131821151(0x7f11025f, float:1.9275037E38)
            r4 = 2131297768(0x7f0905e8, float:1.821349E38)
            android.view.View r0 = a.a.a.a.a.A(r3, r0, r12, r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = 2131297806(0x7f09060e, float:1.8213567E38)
            android.view.View r0 = a.a.a.a.a.A(r2, r0, r12, r3)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2 = 2131297464(0x7f0904b8, float:1.8212874E38)
            android.view.View r0 = a.a.a.a.a.A(r1, r0, r12, r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.sozpic.miniland.video.LiveViewActivity$e r1 = new com.sozpic.miniland.video.LiveViewActivity$e
            r1.<init>(r12)
            r0.setOnClickListener(r1)
            r0 = 2131296730(0x7f0901da, float:1.8211385E38)
            android.view.View r0 = r12.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.sozpic.miniland.video.LiveViewActivity$f r1 = new com.sozpic.miniland.video.LiveViewActivity$f
            r1.<init>(r12)
            r0.setOnClickListener(r1)
            r0 = 2131296845(0x7f09024d, float:1.8211618E38)
            android.view.View r0 = r12.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.sozpic.miniland.video.LiveViewActivity$g r1 = new com.sozpic.miniland.video.LiveViewActivity$g
            r1.<init>(r12)
            r0.setOnClickListener(r1)
            r12.show()
            goto L_0x02aa
        L_0x024b:
            android.widget.Button r0 = r11.p
            if (r12 != r0) goto L_0x02aa
            boolean r12 = r11.l
            if (r12 != 0) goto L_0x027f
            a.h.a.n0.c r12 = r11.f4669b
            int r0 = r11.i
            r12.stopListening(r0)
            android.widget.Button r12 = r11.o
            r0 = 2131230819(0x7f080063, float:1.8077702E38)
            r12.setBackgroundResource(r0)
            android.widget.Button r12 = r11.p
            r0 = 2131231063(0x7f080157, float:1.8078196E38)
            r12.setBackgroundResource(r0)
            android.widget.TextView r12 = r11.r
            java.lang.String r0 = a.c.a.d.a.h(r1)
            r12.setText(r0)
            a.h.a.n0.c r12 = r11.f4669b
            int r0 = r11.i
            r12.startSpeaking(r0)
            r11.l = r3
            r11.k = r4
            goto L_0x02aa
        L_0x027f:
            a.h.a.n0.c r12 = r11.f4669b
            int r0 = r11.i
            r12.stopSpeaking(r0)
            r11.k = r3
            android.widget.Button r12 = r11.p
            r0 = 2131231064(0x7f080158, float:1.8078198E38)
            r12.setBackgroundResource(r0)
            r11.l = r4
            a.h.a.n0.c r12 = r11.f4669b
            int r0 = r11.i
            r12.startListening(r0)
            android.widget.Button r12 = r11.o
            r0 = 2131230818(0x7f080062, float:1.80777E38)
            r12.setBackgroundResource(r0)
            android.widget.TextView r12 = r11.r
            java.lang.String r0 = a.c.a.d.a.h(r2)
            r12.setText(r0)
        L_0x02aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.video.LiveViewActivity.onClick(android.view.View):void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = getResources().getConfiguration().orientation;
        if (i2 == 2) {
            getWindow().setFlags(128, 128);
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
            setContentView(R.layout.live_view_landscape);
            Monitor monitor = this.f4668a;
            if (monitor != null) {
                monitor.deattachCamera();
            }
            this.f4668a = null;
            Monitor monitor2 = (Monitor) findViewById(R.id.monitor);
            this.f4668a = monitor2;
            monitor2.setMaxZoom(3.0f);
            this.f4668a.attachCamera(this.f4669b, this.i);
        } else if (i2 == 1) {
            f();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.live_view_portrait);
        Bundle extras = getIntent().getExtras();
        this.f4671d = extras.getString("dev_uid");
        this.f4672e = extras.getString("dev_uuid");
        this.f = extras.getString("conn_status");
        this.i = extras.getInt("camera_channel");
        Iterator<a.h.a.n0.c> it = MainActivity3.o.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.h.a.n0.c next = it.next();
            if (this.f4671d.equalsIgnoreCase(next.f3531b) && this.f4672e.equalsIgnoreCase(next.b())) {
                this.f4669b = next;
                break;
            }
        }
        Iterator<a.h.a.n0.b> it2 = MainActivity3.p.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            a.h.a.n0.b next2 = it2.next();
            if (this.f4671d.equalsIgnoreCase(next2.f3528d) && this.f4672e.equalsIgnoreCase(next2.f3526b)) {
                this.f4670c = next2;
                break;
            }
        }
        if (((WindowManager) getSystemService("window")).getDefaultDisplay().getOrientation() != 0) {
        }
        f();
        a.h.a.n0.c cVar = this.f4669b;
        if (cVar != null) {
            cVar.registerIOTCListener(this);
            if (!this.f4669b.isSessionConnected()) {
                this.f4669b.connect(this.f4671d);
                a.h.a.n0.c cVar2 = this.f4669b;
                a.h.a.n0.b bVar = this.f4670c;
                cVar2.start(0, bVar.f3529e, bVar.f);
                this.f4669b.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent());
                this.f4669b.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
                this.f4669b.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent());
            }
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.two_way_audio, (ViewGroup) null);
        ((RadioGroup) inflate.findViewById(R.id.radioAudio)).setOnCheckedChangeListener(new a(inflate));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        a.h.a.n0.c cVar = this.f4669b;
        if (cVar != null) {
            cVar.stopSpeaking(this.i);
            this.f4669b.stopListening(this.i);
            this.f4669b.stopShow(this.i);
        }
        Monitor monitor = this.f4668a;
        if (monitor != null) {
            monitor.deattachCamera();
        }
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 == 101 && iArr.length > 0 && iArr[0] == 0) {
            this.t = true;
        }
    }

    public void onResume() {
        super.onResume();
        Monitor monitor = this.f4668a;
        if (monitor != null) {
            monitor.attachCamera(this.f4669b, this.i);
        }
        a.h.a.n0.c cVar = this.f4669b;
        if (cVar != null) {
            cVar.startShow(this.i);
            this.u.postDelayed(new b(), 200);
        }
    }

    public void receiveChannelInfo(Camera camera, int i2, int i3) {
        if (this.f4669b == camera && i2 == this.i) {
            Bundle bundle = new Bundle();
            bundle.putInt("avChannel", i2);
            Message obtainMessage = this.v.obtainMessage();
            obtainMessage.what = i3;
            obtainMessage.setData(bundle);
            this.v.sendMessage(obtainMessage);
        }
    }

    public void receiveFrameData(Camera camera, int i2, Bitmap bitmap) {
        if (this.f4669b != camera || i2 != this.i) {
            return;
        }
        if (bitmap.getWidth() != this.g || bitmap.getHeight() != this.h) {
            this.g = bitmap.getWidth();
            this.h = bitmap.getHeight();
        }
    }

    public void receiveFrameInfo(Camera camera, int i2, long j2, int i3, int i4, int i5, int i6) {
        if (this.f4669b == camera && i2 == this.i) {
            Bundle bundle = new Bundle();
            bundle.putInt("avChannel", i2);
            Message obtainMessage = this.v.obtainMessage();
            obtainMessage.what = 99;
            obtainMessage.setData(bundle);
            this.v.sendMessage(obtainMessage);
        }
    }

    public void receiveIOCtrlData(Camera camera, int i2, int i3, byte[] bArr) {
        if (this.f4669b == camera) {
            Bundle bundle = new Bundle();
            bundle.putInt("avChannel", i2);
            bundle.putByteArray("data", bArr);
            Message obtainMessage = this.v.obtainMessage();
            obtainMessage.what = i3;
            this.v.sendMessage(obtainMessage);
        }
    }

    public void receiveSessionInfo(Camera camera, int i2) {
        if (i2 == 2) {
            camera.stopSpeaking(this.i);
            camera.startListening(this.i);
        }
        if (this.f4669b == camera) {
            Bundle bundle = new Bundle();
            Message obtainMessage = this.v.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.setData(bundle);
            this.v.sendMessage(obtainMessage);
        }
    }
}
