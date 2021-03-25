package com.cuatroochenta.miniland.pregnancy.escuchalatidos;

import a.c.d.r.j;
import a.c.d.s.e.g.c.e;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.cuatroochenta.miniland.model.HeartBeatSound;
import com.cuatroochenta.miniland.model.TimeData;
import com.cuatroochenta.miniland.pregnancy.customs.FhrView;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService;
import com.sozpic.miniland.R;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;

public class PregnancyEscuchaLatidosActivity extends a.c.d.c implements a.c.d.s.e.g.c.a, MediaPlayer.OnPreparedListener, a.c.d.f.a, MediaPlayer.OnCompletionListener {
    public FhrView A;
    public AudioManager B;
    public View C;
    public Runnable D = new a();
    public BroadcastReceiver E = new b();
    public boolean F = false;
    public ServiceConnection G = new d();
    public PregnancyBTService.c H = new e();
    public Handler I = new f();

    /* renamed from: b  reason: collision with root package name */
    public TextView f4021b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4022c;

    /* renamed from: d  reason: collision with root package name */
    public Chronometer f4023d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4024e;
    public ImageView f;
    public SeekBar g;
    public ImageView h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public ImageView l;
    public TextView m;
    public int n;
    public int o = 0;
    public long p;
    public Date q;
    public String r;
    public long s = 0;
    public int t = -1;
    public BluetoothDevice u;
    public PregnancyBTService v = null;
    public Button w;
    public HeartBeatSound x;
    public int y = 0;
    public MediaPlayer z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            MediaPlayer mediaPlayer = PregnancyEscuchaLatidosActivity.this.z;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                a.c.a.f.e.b("Oh no!");
                return;
            }
            StringBuilder n = a.a.a.a.a.n("Media Player position -> ");
            n.append(PregnancyEscuchaLatidosActivity.this.z.getCurrentPosition());
            a.c.a.f.e.b(n.toString());
            float currentPosition = ((float) PregnancyEscuchaLatidosActivity.this.z.getCurrentPosition()) / 1000.0f;
            int size = PregnancyEscuchaLatidosActivity.this.x.getFhrValues().size();
            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = PregnancyEscuchaLatidosActivity.this;
            if (size > pregnancyEscuchaLatidosActivity.y) {
                pregnancyEscuchaLatidosActivity.f4021b.setText(String.valueOf(pregnancyEscuchaLatidosActivity.x.getFhrValues().get(PregnancyEscuchaLatidosActivity.this.y).getHeartRate()));
                while (true) {
                    PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity2 = PregnancyEscuchaLatidosActivity.this;
                    if (pregnancyEscuchaLatidosActivity2.y >= pregnancyEscuchaLatidosActivity2.x.getFhrValues().size()) {
                        break;
                    }
                    TimeData timeData = PregnancyEscuchaLatidosActivity.this.x.getFhrValues().get(PregnancyEscuchaLatidosActivity.this.y);
                    if (timeData.getSecondsElapsed() >= currentPosition) {
                        break;
                    }
                    PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity3 = PregnancyEscuchaLatidosActivity.this;
                    pregnancyEscuchaLatidosActivity3.A.a(pregnancyEscuchaLatidosActivity3.x.getFhrValues().get(PregnancyEscuchaLatidosActivity.this.y), false);
                    if (timeData.isFetalMovement()) {
                        PregnancyEscuchaLatidosActivity.this.o++;
                    }
                    PregnancyEscuchaLatidosActivity.this.y++;
                }
            }
            a.c.a.f.e.b("CurrentPositionSec:" + currentPosition);
            PregnancyEscuchaLatidosActivity.this.f4024e.setText(a.c.a.d.a.e((int) currentPosition) + "/" + a.c.a.d.a.e(PregnancyEscuchaLatidosActivity.this.x.getDuration()));
            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity4 = PregnancyEscuchaLatidosActivity.this;
            pregnancyEscuchaLatidosActivity4.f4022c.setText(String.valueOf(pregnancyEscuchaLatidosActivity4.o));
            PregnancyEscuchaLatidosActivity.this.A.postInvalidate();
            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity5 = PregnancyEscuchaLatidosActivity.this;
            pregnancyEscuchaLatidosActivity5.I.postDelayed(pregnancyEscuchaLatidosActivity5.D, 500);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra("android.bluetooth.device.extra.BOND_STATE")) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
                if (!((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(PregnancyEscuchaLatidosActivity.this.u.getAddress())) {
                    return;
                }
                if (intExtra == 12) {
                    PregnancyEscuchaLatidosActivity.this.q();
                } else if (10 == intExtra) {
                    PregnancyEscuchaLatidosActivity.this.o();
                    a.c.a.f.b.k0(PregnancyEscuchaLatidosActivity.this, a.c.a.d.a.h(R.string.TR_ERROR_CONNECT_ESCUCHALATIDOS));
                }
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f4027a;

        public c(boolean z) {
            this.f4027a = z;
        }

        public void run() {
            PregnancyEscuchaLatidosActivity.this.o();
            if (this.f4027a) {
                PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = PregnancyEscuchaLatidosActivity.this;
                pregnancyEscuchaLatidosActivity.r(pregnancyEscuchaLatidosActivity.x.getLocalFile());
                return;
            }
            a.c.a.f.b.h0(PregnancyEscuchaLatidosActivity.this, a.c.a.d.a.h(R.string.TR_ERROR_DOWNLOADING_PREGNANCY_SOUNDS), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public class d implements ServiceConnection {
        public d() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = PregnancyEscuchaLatidosActivity.this;
            PregnancyBTService pregnancyBTService = PregnancyBTService.this;
            pregnancyEscuchaLatidosActivity.v = pregnancyBTService;
            pregnancyBTService.f4011c = pregnancyEscuchaLatidosActivity.u;
            pregnancyBTService.f4009a = pregnancyEscuchaLatidosActivity.H;
            pregnancyBTService.d();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            PregnancyEscuchaLatidosActivity.this.v = null;
        }
    }

    public class e implements PregnancyBTService.c {
        public e() {
        }

        public void a(int i) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putInt("EXTRA_MSG_SERVICE_STATUS_VALUE", i);
            obtain.setData(bundle);
            obtain.what = 12;
            PregnancyEscuchaLatidosActivity.this.I.sendMessage(obtain);
        }

        public void b(String str) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.clear();
            bundle.putString("EXTRA_MSG_SERVICE_RECORD_ABSOLUTE_PATH", str);
            obtain.setData(bundle);
            obtain.what = 10;
            PregnancyEscuchaLatidosActivity.this.I.sendMessage(obtain);
        }

        public void c(a.f.a.d.c cVar) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = PregnancyEscuchaLatidosActivity.this;
            if (pregnancyEscuchaLatidosActivity.p == 0) {
                pregnancyEscuchaLatidosActivity.p = SystemClock.elapsedRealtime();
            }
            float elapsedRealtime = ((float) (SystemClock.elapsedRealtime() - pregnancyEscuchaLatidosActivity.p)) / 1000.0f;
            if (elapsedRealtime > 0.0f) {
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity2 = PregnancyEscuchaLatidosActivity.this;
                if (timeInMillis - pregnancyEscuchaLatidosActivity2.s > 500) {
                    pregnancyEscuchaLatidosActivity2.s = timeInMillis;
                    bundle.putInt("EXTRA_MSG_SERVICE_FHR_VALUE", cVar.f3325a);
                    bundle.putFloat("EXTRA_MSG_SERVICE_FHR_SECONDS_ELAPSED", elapsedRealtime);
                    int i = PregnancyEscuchaLatidosActivity.this.t;
                    byte b2 = cVar.g;
                    if (i != b2) {
                        bundle.putInt("EXTRA_MSG_SERVICE_BATTERY_VALUE", b2);
                        PregnancyEscuchaLatidosActivity.this.t = cVar.g;
                    }
                    obtain.setData(bundle);
                    obtain.what = 11;
                    PregnancyEscuchaLatidosActivity.this.I.sendMessage(obtain);
                }
            }
        }
    }

    public class f extends Handler {
        public f() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 10:
                    String string = message.getData().getString("EXTRA_MSG_SERVICE_RECORD_ABSOLUTE_PATH");
                    PregnancyEscuchaLatidosActivity.this.w.setText(a.c.a.d.a.h(R.string.TR_RECORD));
                    PregnancyEscuchaLatidosActivity.this.f4023d.stop();
                    PregnancyEscuchaLatidosActivity.this.f4023d.setVisibility(8);
                    PregnancyEscuchaLatidosActivity.this.f4024e.setVisibility(8);
                    PregnancyEscuchaLatidosActivity.this.f.setVisibility(8);
                    if (string != null) {
                        int elapsedRealtime = (int) ((SystemClock.elapsedRealtime() - PregnancyEscuchaLatidosActivity.this.f4023d.getBase()) / 1000);
                        if (new File(string).exists()) {
                            PregnancyEscuchaLatidosActivity.this.p(a.c.a.d.a.h(R.string.TR_UPLOADING_PREGNANCY_SOUND), false);
                            a.c.d.s.e.g.c.e eVar = new a.c.d.s.e.g.c.e("https://emybaby.com/api/sonidosembarazo.php");
                            a.c.d.s.e.g.c.b bVar = new a.c.d.s.e.g.c.b();
                            bVar.f1122b = elapsedRealtime;
                            bVar.f1123c = PregnancyEscuchaLatidosActivity.this.i.getText().toString();
                            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = PregnancyEscuchaLatidosActivity.this;
                            bVar.f1124d = pregnancyEscuchaLatidosActivity.q;
                            bVar.f1121a = string;
                            bVar.f1125e = pregnancyEscuchaLatidosActivity.A.getRecordingDataList();
                            new e.b(bVar, PregnancyEscuchaLatidosActivity.this).start();
                            a.c.d.r.a aVar = a.c.d.r.a.f781d;
                            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity2 = PregnancyEscuchaLatidosActivity.this;
                            aVar.f782a.add(new HeartBeatSound(pregnancyEscuchaLatidosActivity2.q, string, pregnancyEscuchaLatidosActivity2.r, elapsedRealtime));
                            return;
                        }
                        return;
                    }
                    return;
                case 11:
                    Bundle data = message.getData();
                    if (data.containsKey("EXTRA_MSG_SERVICE_FHR_VALUE")) {
                        int i = data.getInt("EXTRA_MSG_SERVICE_FHR_VALUE");
                        PregnancyEscuchaLatidosActivity.this.A.a(new TimeData(i, data.getFloat("EXTRA_MSG_SERVICE_FHR_SECONDS_ELAPSED")), true);
                        if (i > 0) {
                            PregnancyEscuchaLatidosActivity.this.f4021b.setText(String.valueOf(i));
                        } else {
                            PregnancyEscuchaLatidosActivity.this.f4021b.setText("--");
                        }
                    }
                    if (data.containsKey("EXTRA_MSG_SERVICE_BATTERY_VALUE")) {
                        int i2 = data.getInt("EXTRA_MSG_SERVICE_BATTERY_VALUE");
                        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? R.drawable.ic_pregnancy_battery_3 : R.drawable.ic_pregnancy_battery_2 : R.drawable.ic_pregnancy_battery_1 : R.drawable.ic_pregnancy_battery_0;
                        PregnancyEscuchaLatidosActivity.this.h.setVisibility(0);
                        PregnancyEscuchaLatidosActivity.this.h.setImageResource(i3);
                        return;
                    }
                    return;
                case 12:
                    int i4 = message.getData().getInt("EXTRA_MSG_SERVICE_STATUS_VALUE");
                    if (i4 == 3) {
                        PregnancyEscuchaLatidosActivity.this.o();
                        a.c.a.f.b.k0(PregnancyEscuchaLatidosActivity.this, a.c.a.d.a.h(R.string.TR_ERROR_CONNECT_ESCUCHALATIDOS));
                        return;
                    } else if (i4 == 4) {
                        PregnancyEscuchaLatidosActivity.this.o();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void d(int i2, boolean z2) {
        j b2 = j.b();
        if (!b2.f800a.contains(this)) {
            b2.f800a.add(this);
        }
        runOnUiThread(new c(z2));
    }

    public void e(long j2, long j3) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.w.setText(a.c.a.d.a.h(R.string.TR_PLAY));
        this.w.setSelected(false);
        this.f.setSelected(false);
        this.I.removeCallbacks(this.D);
        this.y = 0;
        TextView textView = this.f4024e;
        textView.setText(a.c.a.d.a.e(0) + "/" + a.c.a.d.a.e(this.x.getDuration()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x032b, code lost:
        if (r10 != 12) goto L_0x0343;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle r10) {
        /*
            r9 = this;
            super.onCreate(r10)
            r10 = 2131492946(0x7f0c0052, float:1.8609358E38)
            r9.setContentView(r10)
            android.content.Intent r10 = r9.getIntent()
            android.os.Bundle r10 = r10.getExtras()
            r0 = 1
            r1 = 2
            java.lang.String r2 = "KEY_INTENT_HEART_BEAT_SOUND"
            if (r10 == 0) goto L_0x0039
            java.lang.String r3 = "android.bluetooth.device.extra.DEVICE"
            boolean r4 = r10.containsKey(r3)
            if (r4 == 0) goto L_0x0029
            android.os.Parcelable r3 = r10.getParcelable(r3)
            android.bluetooth.BluetoothDevice r3 = (android.bluetooth.BluetoothDevice) r3
            r9.u = r3
            r9.n = r0
        L_0x0029:
            boolean r3 = r10.containsKey(r2)
            if (r3 == 0) goto L_0x0039
            android.os.Parcelable r10 = r10.getParcelable(r2)
            com.cuatroochenta.miniland.model.HeartBeatSound r10 = (com.cuatroochenta.miniland.model.HeartBeatSound) r10
            r9.x = r10
            r9.n = r1
        L_0x0039:
            android.bluetooth.BluetoothDevice r10 = r9.u
            if (r10 != 0) goto L_0x0045
            com.cuatroochenta.miniland.model.HeartBeatSound r10 = r9.x
            if (r10 != 0) goto L_0x0045
            r9.finish()
            return
        L_0x0045:
            r10 = 2131297263(0x7f0903ef, float:1.8212466E38)
            android.view.View r10 = r9.findViewById(r10)
            com.sozpic.miniland.TopMenuActivity r10 = (com.sozpic.miniland.TopMenuActivity) r10
            r10.setListener(r9)
            r3 = 2131821111(0x7f110237, float:1.9274956E38)
            java.lang.String r3 = a.c.a.d.a.h(r3)
            java.lang.String r3 = r3.toUpperCase()
            r10.setSeccion(r3)
            r10 = 2131297271(0x7f0903f7, float:1.8212482E38)
            android.view.View r10 = r9.findViewById(r10)
            r9.C = r10
            r3 = 2131297290(0x7f09040a, float:1.821252E38)
            android.view.View r10 = r10.findViewById(r3)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r9.j = r10
            android.view.View r10 = r9.C
            r3 = 2131297292(0x7f09040c, float:1.8212525E38)
            android.view.View r10 = r10.findViewById(r3)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.k = r10
            r10 = 2131297272(0x7f0903f8, float:1.8212484E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.i = r10
            r10 = 2131297264(0x7f0903f0, float:1.8212468E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.m = r10
            r10 = 2131297268(0x7f0903f4, float:1.8212476E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r9.l = r10
            r10 = 2131297267(0x7f0903f3, float:1.8212474E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.f4021b = r10
            java.lang.String r3 = "--"
            r10.setText(r3)
            r10 = 2131297266(0x7f0903f2, float:1.8212472E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r3 = 2131820955(0x7f11019b, float:1.927464E38)
            java.lang.String r3 = a.c.a.d.a.h(r3)
            r10.setText(r3)
            r10 = 2131297270(0x7f0903f6, float:1.821248E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.f4022c = r10
            r10 = 2131297269(0x7f0903f5, float:1.8212478E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r3 = 2131820963(0x7f1101a3, float:1.9274656E38)
            java.lang.String r3 = a.c.a.d.a.h(r3)
            r10.setText(r3)
            java.lang.String r10 = "audio"
            java.lang.Object r10 = r9.getSystemService(r10)
            android.media.AudioManager r10 = (android.media.AudioManager) r10
            r9.B = r10
            r10 = 2131297281(0x7f090401, float:1.8212502E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.SeekBar r10 = (android.widget.SeekBar) r10
            r9.g = r10
            android.media.AudioManager r3 = r9.B
            r4 = 3
            int r3 = r3.getStreamMaxVolume(r4)
            r10.setMax(r3)
            android.widget.SeekBar r10 = r9.g
            android.media.AudioManager r3 = r9.B
            int r3 = r3.getStreamVolume(r4)
            r10.setProgress(r3)
            android.widget.SeekBar r10 = r9.g
            a.c.d.m.h.c r3 = new a.c.d.m.h.c
            r3.<init>(r9)
            r10.setOnSeekBarChangeListener(r3)
            r10 = 2131297262(0x7f0903ee, float:1.8212464E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.Button r10 = (android.widget.Button) r10
            r9.w = r10
            a.c.d.m.h.d r3 = new a.c.d.m.h.d
            r3.<init>(r9)
            r10.setOnClickListener(r3)
            r10 = 2131297277(0x7f0903fd, float:1.8212494E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.f4024e = r10
            r3 = 8
            r10.setVisibility(r3)
            r10 = 2131297276(0x7f0903fc, float:1.8212492E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r9.f = r10
            r10.setVisibility(r3)
            r10 = 2131297274(0x7f0903fa, float:1.8212488E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.Chronometer r10 = (android.widget.Chronometer) r10
            r9.f4023d = r10
            r10.setVisibility(r3)
            r10 = 2131297283(0x7f090403, float:1.8212507E38)
            android.view.View r10 = r9.findViewById(r10)
            com.cuatroochenta.miniland.pregnancy.customs.FhrView r10 = (com.cuatroochenta.miniland.pregnancy.customs.FhrView) r10
            r9.A = r10
            r10 = 2131297261(0x7f0903ed, float:1.8212462E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r9.h = r10
            r3 = 4
            r10.setVisibility(r3)
            int r10 = r9.n
            r5 = 0
            if (r10 == r0) goto L_0x028a
            if (r10 == r1) goto L_0x0178
            goto L_0x0343
        L_0x0178:
            android.view.View r10 = r9.C
            r3 = -4511900(0xffffffffffbb2764, float:NaN)
            r10.setBackgroundColor(r3)
            com.cuatroochenta.miniland.pregnancy.customs.FhrView r10 = r9.A
            com.cuatroochenta.miniland.model.HeartBeatSound r3 = r9.x
            java.util.ArrayList r3 = r3.getFhrValues()
            if (r10 == 0) goto L_0x0288
            java.util.Iterator r3 = r3.iterator()
        L_0x018e:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x01af
            java.lang.Object r6 = r3.next()
            com.cuatroochenta.miniland.model.TimeData r6 = (com.cuatroochenta.miniland.model.TimeData) r6
            float r7 = r6.getSecondsElapsed()
            r8 = 1127481344(0x43340000, float:180.0)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x01a9
            int r7 = r10.o
            int r7 = r7 + r0
            r10.o = r7
        L_0x01a9:
            java.util.LinkedList<com.cuatroochenta.miniland.model.TimeData> r7 = r10.p
            r7.add(r6)
            goto L_0x018e
        L_0x01af:
            r10.postInvalidate()
            android.widget.ImageView r10 = r9.j
            r0 = 2131231211(0x7f0801eb, float:1.8078497E38)
            r10.setImageResource(r0)
            android.widget.TextView r10 = r9.k
            r0 = 2131821119(0x7f11023f, float:1.9274972E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r10.setText(r0)
            android.widget.TextView r10 = r9.i
            com.cuatroochenta.miniland.model.HeartBeatSound r0 = r9.x
            java.lang.String r0 = r0.getTitle()
            r10.setText(r0)
            android.widget.TextView r10 = r9.m
            com.cuatroochenta.miniland.model.HeartBeatSound r0 = r9.x
            java.lang.String r0 = r0.getCaptureDateFormatted()
            r10.setText(r0)
            android.widget.Button r10 = r9.w
            r0 = 2131821220(0x7f1102a4, float:1.9275177E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r10.setText(r0)
            android.widget.ImageView r10 = r9.f
            r0 = 2131231212(0x7f0801ec, float:1.8078499E38)
            r10.setImageResource(r0)
            android.widget.ImageView r10 = r9.f
            r10.setVisibility(r5)
            android.widget.TextView r10 = r9.f4024e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = a.c.a.d.a.e(r5)
            r0.append(r3)
            java.lang.String r3 = "/"
            r0.append(r3)
            com.cuatroochenta.miniland.model.HeartBeatSound r3 = r9.x
            java.lang.String r3 = r3.getDurationFormatted()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r10.setText(r0)
            android.widget.TextView r10 = r9.f4024e
            android.content.res.Resources r0 = r9.getResources()
            r3 = 2131099812(0x7f0600a4, float:1.7811988E38)
            int r0 = r0.getColor(r3)
            r10.setTextColor(r0)
            android.widget.TextView r10 = r9.f4024e
            r10.setVisibility(r5)
            android.widget.Button r10 = r9.w
            r10.setEnabled(r5)
            android.media.MediaPlayer r10 = new android.media.MediaPlayer
            r10.<init>()
            r9.z = r10
            r10.setAudioStreamType(r4)
            android.media.MediaPlayer r10 = r9.z
            r10.setOnPreparedListener(r9)
            android.media.MediaPlayer r10 = r9.z
            r10.setOnCompletionListener(r9)
            com.cuatroochenta.miniland.model.HeartBeatSound r10 = r9.x
            java.io.File r10 = r10.getLocalFile()
            boolean r0 = r10.exists()
            if (r0 == 0) goto L_0x0257
            r9.r(r10)
            goto L_0x0343
        L_0x0257:
            a.c.d.r.j r10 = a.c.d.r.j.b()
            java.util.ArrayList<a.c.d.f.a> r0 = r10.f800a
            boolean r0 = r0.contains(r9)
            if (r0 != 0) goto L_0x0268
            java.util.ArrayList<a.c.d.f.a> r10 = r10.f800a
            r10.add(r9)
        L_0x0268:
            r10 = 2131820791(0x7f1100f7, float:1.9274307E38)
            java.lang.String r10 = a.c.a.d.a.h(r10)
            r9.p(r10, r5)
            android.content.Intent r10 = new android.content.Intent
            java.lang.Class<com.cuatroochenta.miniland.downloader.FileDownloaderService> r0 = com.cuatroochenta.miniland.downloader.FileDownloaderService.class
            r10.<init>(r9, r0)
            java.lang.String r0 = "KEY_INTENT_DOWNLOADER_MODE"
            r10.putExtra(r0, r1)
            com.cuatroochenta.miniland.model.HeartBeatSound r0 = r9.x
            r10.putExtra(r2, r0)
            r9.startService(r10)
            goto L_0x0343
        L_0x0288:
            r10 = 0
            throw r10
        L_0x028a:
            android.view.View r10 = r9.C
            r2 = -5504940(0xffffffffffac0054, float:NaN)
            r10.setBackgroundColor(r2)
            android.widget.ImageView r10 = r9.j
            r2 = 2131231133(0x7f08019d, float:1.8078338E38)
            r10.setImageResource(r2)
            android.widget.TextView r10 = r9.k
            r2 = 2131821117(0x7f11023d, float:1.9274968E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r10.setText(r2)
            android.widget.Button r10 = r9.w
            r2 = 2131821247(0x7f1102bf, float:1.9275232E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r10.setText(r2)
            android.widget.ImageView r10 = r9.l
            a.c.d.m.h.e r2 = new a.c.d.m.h.e
            r2.<init>(r9)
            r10.setOnClickListener(r2)
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            android.widget.TextView r2 = r9.i
            r4 = 2131820816(0x7f110110, float:1.9274358E38)
            java.lang.String r4 = a.c.a.d.a.i(r4)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.util.Date r6 = r10.getTime()
            long r6 = a.c.d.r.i.c(r6)
            int r7 = (int) r6
            java.lang.String r6 = java.lang.String.valueOf(r7)
            r1[r5] = r6
            java.util.Date r10 = r10.getTime()
            long r6 = a.c.d.r.i.a(r10)
            int r10 = (int) r6
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r1[r0] = r10
            java.lang.String r10 = java.lang.String.format(r4, r1)
            r2.setText(r10)
            android.widget.TextView r10 = r9.m
            r10.setVisibility(r3)
            android.widget.TextView r10 = r9.f4022c
            int r0 = r9.o
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.setText(r0)
            android.widget.TextView r10 = r9.f4024e
            r0 = 2131821249(0x7f1102c1, float:1.9275236E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r10.setText(r0)
            android.widget.ImageView r10 = r9.f
            r0 = 2131231219(0x7f0801f3, float:1.8078513E38)
            r10.setImageResource(r0)
            java.lang.String r10 = ""
            r9.p(r10, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r10 < r0) goto L_0x0340
            android.bluetooth.BluetoothDevice r10 = r9.u
            int r10 = r10.getBondState()
            r0 = 10
            if (r10 == r0) goto L_0x032e
            r0 = 12
            if (r10 == r0) goto L_0x0340
            goto L_0x0343
        L_0x032e:
            android.content.BroadcastReceiver r10 = r9.E
            android.content.IntentFilter r0 = new android.content.IntentFilter
            java.lang.String r1 = "android.bluetooth.device.action.BOND_STATE_CHANGED"
            r0.<init>(r1)
            r9.registerReceiver(r10, r0)
            android.bluetooth.BluetoothDevice r10 = r9.u
            r10.createBond()
            goto L_0x0343
        L_0x0340:
            r9.q()
        L_0x0343:
            a.c.a.e.f r10 = a.c.a.e.f.c()
            java.lang.String r0 = "MI_EMBARAZO_ESCUCHALATIDOS"
            r10.e(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.E);
        if (this.F) {
            unbindService(this.G);
            this.v = null;
            this.F = false;
        }
        j b2 = j.b();
        if (b2.f800a.contains(this)) {
            b2.f800a.remove(this);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && (i2 == 25 || i2 == 24)) {
            a.c.a.f.e.b("System volume changed");
            this.g.setProgress(this.B.getStreamVolume(3));
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onPause() {
        super.onPause();
        MediaPlayer mediaPlayer = this.z;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            s();
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.w.setEnabled(true);
    }

    public final void q() {
        if (this.u != null) {
            PregnancyBTService pregnancyBTService = this.v;
            if (pregnancyBTService == null) {
                bindService(new Intent(this, PregnancyBTService.class), this.G, 1);
                this.F = true;
            } else if (!pregnancyBTService.m) {
                pregnancyBTService.a();
                this.v.d();
            }
        } else {
            finish();
        }
    }

    public final void r(File file) {
        try {
            this.z.setDataSource(new FileInputStream(file).getFD());
            this.z.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void s() {
        MediaPlayer mediaPlayer = this.z;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.w.setText(a.c.a.d.a.h(R.string.TR_PLAY));
                this.z.pause();
                this.w.setSelected(false);
                this.f.setSelected(false);
                this.I.removeCallbacks(this.D);
                return;
            }
            if (this.y == 0) {
                FhrView fhrView = this.A;
                fhrView.p.clear();
                fhrView.invalidate();
                fhrView.o = 0;
            }
            a.c.a.e.f.c().d("MI_EMBARAZO", "SWEETBEAT_PLAY", "");
            this.z.start();
            this.w.setText(a.c.a.d.a.h(R.string.TR_PAUSE));
            this.w.setSelected(true);
            this.f.setSelected(true);
            this.I.post(this.D);
        }
    }
}
