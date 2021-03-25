package com.sozpic.miniland.video;

import a.h.a.n0.c;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.R;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tutk.IOTC.Camera;
import com.tutk.IOTC.IRegisterIOTCListener;
import com.tutk.IOTC.Monitor;
import com.tutk.IOTC.Packet;
import com.tuya.smart.common.oOO0O0O0;
import java.util.Iterator;

public class PlaybackActivity extends Activity implements IRegisterIOTCListener {

    /* renamed from: a  reason: collision with root package name */
    public Monitor f4743a = null;

    /* renamed from: b  reason: collision with root package name */
    public c f4744b = null;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4745c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4746d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4747e;
    public TextView f;
    public TextView g;
    public TextView h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public AVIOCTRLDEFs.STimeDay o;
    public int p;
    public int q;
    public int r = -1;
    public int s = 0;
    public BitmapDrawable t;
    public BitmapDrawable u;
    public Handler v = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            PlaybackActivity playbackActivity = PlaybackActivity.this;
            if (playbackActivity.r < 0 && playbackActivity.s == 3) {
                playbackActivity.s = 0;
                Toast.makeText(playbackActivity, a.c.a.d.a.h(R.string.TR_PLAY_RECORD_TIMEOUT), 0).show();
            }
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            PlaybackActivity playbackActivity;
            c cVar;
            c cVar2;
            Bundle data = message.getData();
            byte[] byteArray = data.getByteArray("data");
            int i = message.what;
            if (i == 99) {
                int i2 = data.getInt("videoFPS");
                long j = data.getLong("videoBPS");
                int i3 = data.getInt("frameCount");
                int i4 = data.getInt("inCompleteFrameCount");
                TextView textView = PlaybackActivity.this.f4746d;
                if (textView != null) {
                    textView.setText(String.valueOf(PlaybackActivity.this.p) + "x" + String.valueOf(PlaybackActivity.this.q));
                }
                TextView textView2 = PlaybackActivity.this.f4747e;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(i2));
                }
                TextView textView3 = PlaybackActivity.this.f;
                if (textView3 != null) {
                    textView3.setText(String.valueOf(j) + "Kb");
                }
                TextView textView4 = PlaybackActivity.this.g;
                if (textView4 != null) {
                    textView4.setText(String.valueOf(i3));
                }
                TextView textView5 = PlaybackActivity.this.h;
                if (textView5 != null) {
                    textView5.setText(String.valueOf(i4));
                }
            } else if (i == 795) {
                int byteArrayToInt_Little = Packet.byteArrayToInt_Little(byteArray, 0);
                int byteArrayToInt_Little2 = Packet.byteArrayToInt_Little(byteArray, 4);
                if (byteArrayToInt_Little != 0) {
                    if (byteArrayToInt_Little == 1) {
                        System.out.println("AVIOCTRL_RECORD_PLAY_STOP");
                        PlaybackActivity playbackActivity2 = PlaybackActivity.this;
                        int i5 = playbackActivity2.r;
                        if (i5 >= 0 && (cVar = playbackActivity2.f4744b) != null) {
                            cVar.stopListening(i5);
                            PlaybackActivity playbackActivity3 = PlaybackActivity.this;
                            playbackActivity3.f4744b.stopShow(playbackActivity3.r);
                            PlaybackActivity playbackActivity4 = PlaybackActivity.this;
                            playbackActivity4.f4744b.stop(playbackActivity4.r);
                            PlaybackActivity.this.f4743a.deattachCamera();
                        }
                    } else if (byteArrayToInt_Little == 7) {
                        System.out.println("AVIOCTRL_RECORD_PLAY_END");
                        PlaybackActivity playbackActivity5 = PlaybackActivity.this;
                        int i6 = playbackActivity5.r;
                        if (i6 >= 0 && (cVar2 = playbackActivity5.f4744b) != null) {
                            cVar2.stopListening(i6);
                            PlaybackActivity playbackActivity6 = PlaybackActivity.this;
                            playbackActivity6.f4744b.stopShow(playbackActivity6.r);
                            PlaybackActivity playbackActivity7 = PlaybackActivity.this;
                            playbackActivity7.f4744b.stop(playbackActivity7.r);
                            PlaybackActivity.this.f4743a.deattachCamera();
                            PlaybackActivity playbackActivity8 = PlaybackActivity.this;
                            playbackActivity8.f4744b.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_RECORD_PLAYCONTROL, AVIOCTRLDEFs.SMsgAVIoctrlPlayRecord.parseContent(playbackActivity8.m, 1, 0, playbackActivity8.o.toByteArray()));
                        }
                        Toast.makeText(PlaybackActivity.this, a.c.a.d.a.h(R.string.TR_PLAY_RECORD_END), 1).show();
                        TextView textView6 = PlaybackActivity.this.f4747e;
                        if (textView6 != null) {
                            textView6.setText(oOO0O0O0.O0000oO0);
                        }
                        TextView textView7 = PlaybackActivity.this.f;
                        if (textView7 != null) {
                            textView7.setText("0kb");
                        }
                    } else if (byteArrayToInt_Little == 16) {
                        System.out.println("AVIOCTRL_RECORD_PLAY_START");
                        PlaybackActivity playbackActivity9 = PlaybackActivity.this;
                        if (playbackActivity9.s == 3) {
                            if (byteArrayToInt_Little2 < 0 || byteArrayToInt_Little2 > 31) {
                                Toast.makeText(PlaybackActivity.this, a.c.a.d.a.h(R.string.TR_PLAY_RECORD_FAILED), 0).show();
                            } else {
                                playbackActivity9.r = byteArrayToInt_Little2;
                                playbackActivity9.s = 1;
                                c cVar3 = playbackActivity9.f4744b;
                                if (cVar3 != null) {
                                    cVar3.start(byteArrayToInt_Little2, playbackActivity9.j, playbackActivity9.k);
                                    PlaybackActivity playbackActivity10 = PlaybackActivity.this;
                                    playbackActivity10.f4744b.startShow(playbackActivity10.r);
                                    PlaybackActivity playbackActivity11 = PlaybackActivity.this;
                                    playbackActivity11.f4744b.startListening(playbackActivity11.r);
                                    playbackActivity = PlaybackActivity.this;
                                }
                            }
                        }
                    }
                    PlaybackActivity playbackActivity12 = PlaybackActivity.this;
                    playbackActivity12.r = -1;
                    playbackActivity12.s = 0;
                } else {
                    System.out.println("AVIOCTRL_RECORD_PLAY_PAUSE");
                    PlaybackActivity playbackActivity13 = PlaybackActivity.this;
                    if (playbackActivity13.r >= 0 && playbackActivity13.f4744b != null) {
                        int i7 = playbackActivity13.s;
                        if (i7 == 2) {
                            playbackActivity13.s = 1;
                        } else if (i7 == 1) {
                            playbackActivity13.s = 2;
                        }
                        playbackActivity = PlaybackActivity.this;
                        if (playbackActivity.s == 2) {
                            playbackActivity.f4743a.deattachCamera();
                        }
                    }
                }
                playbackActivity.f4743a.attachCamera(playbackActivity.f4744b, playbackActivity.r);
            }
            super.handleMessage(message);
        }
    }

    public final void b() {
        int i2;
        Monitor monitor = this.f4743a;
        if (monitor != null) {
            monitor.deattachCamera();
        }
        c cVar = this.f4744b;
        if (cVar != null && (i2 = this.r) >= 0) {
            cVar.stopListening(i2);
            this.f4744b.stopShow(this.r);
            this.f4744b.stop(this.r);
            this.f4744b.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_RECORD_PLAYCONTROL, AVIOCTRLDEFs.SMsgAVIoctrlPlayRecord.parseContent(this.m, 1, 0, this.o.toByteArray()));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("event_type", this.n);
        bundle.putByteArray("event_time2", this.o.toByteArray());
        bundle.putString("event_uuid", this.l);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public final void c() {
        getWindow().setFlags(128, 128);
        getWindow().addFlags(1024);
        getWindow().clearFlags(2048);
        setContentView(R.layout.playback_landscape);
        this.f4745c = null;
        this.f4746d = null;
        this.f4747e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        Monitor monitor = (Monitor) findViewById(R.id.monitor);
        this.f4743a = monitor;
        monitor.setMaxZoom(3.0f);
        int i2 = this.r;
        if (i2 >= 0) {
            this.f4743a.attachCamera(this.f4744b, i2);
        }
    }

    public final void d() {
        getWindow().setFlags(128, 128);
        getWindow().addFlags(1024);
        getWindow().clearFlags(2048);
        setContentView(R.layout.playback_portrait);
        this.f4745c = (TextView) findViewById(R.id.txtEventType);
        this.f4746d = (TextView) findViewById(R.id.txtResolution);
        this.f4747e = (TextView) findViewById(R.id.txtFrameRate);
        this.f = (TextView) findViewById(R.id.txtBitRate);
        this.g = (TextView) findViewById(R.id.txtFrameCount);
        this.h = (TextView) findViewById(R.id.txtIncompleteFrameCount);
        this.f4745c.setText(MainActivity3.f(this, this.n, false));
        Monitor monitor = (Monitor) findViewById(R.id.monitor);
        this.f4743a = monitor;
        monitor.setMaxZoom(3.0f);
        int i2 = this.r;
        if (i2 >= 0) {
            this.f4743a.attachCamera(this.f4744b, i2);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Monitor monitor = this.f4743a;
        if (monitor != null) {
            monitor.deattachCamera();
        }
        int i2 = getResources().getConfiguration().orientation;
        if (i2 == 2) {
            c();
        } else if (i2 == 1) {
            d();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.playback_portrait);
        this.t = (BitmapDrawable) getResources().getDrawable(R.drawable.bg_striped);
        this.u = (BitmapDrawable) getResources().getDrawable(R.drawable.bg_striped_split_img);
        Bundle extras = getIntent().getExtras();
        String str = "";
        this.i = extras != null ? extras.getString("dev_uuid") : str;
        if (extras != null) {
            extras.getString("dev_nickname");
        }
        int i2 = -1;
        this.m = extras != null ? extras.getInt("camera_channel") : -1;
        this.j = extras != null ? extras.getString("view_acc") : str;
        if (extras != null) {
            str = extras.getString("view_pwd");
        }
        this.k = str;
        if (extras != null) {
            i2 = extras.getInt("event_type");
        }
        this.n = i2;
        AVIOCTRLDEFs.STimeDay sTimeDay = null;
        this.l = extras != null ? extras.getString("event_uuid") : null;
        if (extras != null) {
            sTimeDay = new AVIOCTRLDEFs.STimeDay(extras.getByteArray("event_time2"));
        }
        this.o = sTimeDay;
        Iterator<c> it = MainActivity3.o.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (this.i.equalsIgnoreCase(next.b())) {
                this.f4744b = next;
                next.registerIOTCListener(this);
                this.f4744b.f3534e = 0;
                break;
            }
        }
        int orientation = ((WindowManager) getSystemService("window")).getDefaultDisplay().getOrientation();
        if (orientation == 0 || orientation == 2) {
            d();
        } else {
            c();
        }
        c cVar = this.f4744b;
        if (cVar != null) {
            this.s = 3;
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_RECORD_PLAYCONTROL, AVIOCTRLDEFs.SMsgAVIoctrlPlayRecord.parseContent(this.m, 16, 0, this.o.toByteArray()));
            this.v.postDelayed(new a(), 5000);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        b();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            b();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onPause() {
        super.onPause();
        c cVar = this.f4744b;
        if (cVar != null) {
            cVar.stopListening(this.r);
            this.f4744b.stopShow(this.r);
            this.f4744b.stop(this.r);
            this.f4743a.deattachCamera();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void receiveChannelInfo(Camera camera, int i2, int i3) {
    }

    public void receiveFrameData(Camera camera, int i2, Bitmap bitmap) {
        if (this.f4744b == camera && i2 == this.r && bitmap != null) {
            this.p = bitmap.getWidth();
            this.q = bitmap.getHeight();
        }
    }

    public void receiveFrameInfo(Camera camera, int i2, long j2, int i3, int i4, int i5, int i6) {
        if (this.f4744b == camera && i2 == this.r) {
            Bundle bundle = new Bundle();
            bundle.putInt("sessionChannel", i2);
            bundle.putInt("videoFPS", i3);
            bundle.putLong("videoBPS", j2);
            bundle.putInt("frameCount", i5);
            bundle.putInt("inCompleteFrameCount", i6);
            Message obtainMessage = this.v.obtainMessage();
            obtainMessage.what = 99;
            obtainMessage.setData(bundle);
            this.v.sendMessage(obtainMessage);
        }
    }

    public void receiveIOCtrlData(Camera camera, int i2, int i3, byte[] bArr) {
        if (this.f4744b == camera) {
            Bundle bundle = new Bundle();
            bundle.putInt("sessionChannel", i2);
            bundle.putByteArray("data", bArr);
            Message message = new Message();
            message.what = i3;
            message.setData(bundle);
            this.v.sendMessage(message);
        }
    }

    public void receiveSessionInfo(Camera camera, int i2) {
    }
}
