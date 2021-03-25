package com.sozpic.miniland.video;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tutk.IOTC.Camera;
import com.tutk.IOTC.IRegisterIOTCListener;
import java.util.Iterator;

public class EditDeviceActivity extends Activity implements IRegisterIOTCListener, TopMenuActivityVideo.c {

    /* renamed from: a  reason: collision with root package name */
    public Button f4627a;

    /* renamed from: b  reason: collision with root package name */
    public Button f4628b;

    /* renamed from: c  reason: collision with root package name */
    public Button f4629c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f4630d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f4631e;
    public EditText f;
    public TextView g;
    public a.h.a.n0.c h = null;
    public a.h.a.n0.b i = null;
    public ImageView j;
    public boolean k = false;
    public TopMenuActivityVideo l;
    public View.OnClickListener m = new a();
    public View.OnClickListener n = new b();
    public View.OnClickListener o = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("dev_uuid", EditDeviceActivity.this.i.f3526b);
            bundle.putString("dev_uid", EditDeviceActivity.this.i.f3528d);
            Intent intent = new Intent();
            intent.setClass(EditDeviceActivity.this, AdvancedSettingActivity.class);
            intent.putExtras(bundle);
            EditDeviceActivity.this.startActivityForResult(intent, 0);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            EditDeviceActivity.this.d(true);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            EditDeviceActivity.this.d(false);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            EditDeviceActivity.this.f4629c.setEnabled(true);
        }
    }

    public void a() {
        d(false);
    }

    public void b() {
    }

    public final void d(boolean z) {
        Intent intent;
        String h2;
        String h3;
        String str;
        String str2;
        if (!z && !this.k) {
            a.h.a.n0.c cVar = this.h;
            if (cVar != null) {
                cVar.unregisterIOTCListener(this);
            }
            setResult(0, new Intent());
        } else if (z || !this.k) {
            if (z && this.k) {
                String obj = this.f.getText().toString();
                String obj2 = this.f4630d.getText().toString();
                String str3 = this.i.f3529e;
                String obj3 = this.f4631e.getText().toString();
                if (obj.length() != 0) {
                    if (obj2.length() == 0) {
                        h2 = a.c.a.d.a.h(R.string.TR_TIPS_WIFI_WEAK_SIGNAL);
                        h3 = a.c.a.d.a.h(R.string.TR_TIPS_DEV_UID);
                        MainActivity3.k(this, h2, h3, a.c.a.d.a.h(R.string.TR_OK));
                        return;
                    }
                    if (obj2.length() == 20) {
                        if (obj3.length() > 0) {
                            if (!obj.equalsIgnoreCase(this.i.f3527c) || !obj2.equalsIgnoreCase(this.i.f3528d) || !str3.equalsIgnoreCase(this.i.f3529e) || !obj3.equalsIgnoreCase(this.i.f)) {
                                a.h.a.n0.b bVar = this.i;
                                bVar.f3527c = obj;
                                bVar.f3528d = obj2;
                                bVar.f3529e = str3;
                                bVar.f = obj3;
                                a.h.a.n0.a aVar = new a.h.a.n0.a(this);
                                a.h.a.n0.b bVar2 = this.i;
                                str = str3;
                                a.h.a.n0.a aVar2 = aVar;
                                str2 = obj2;
                                aVar2.g(bVar2.f3525a, bVar2.f3528d, obj, "", "", str, obj3, bVar2.i, bVar2.j);
                            } else {
                                str = str3;
                                str2 = obj2;
                            }
                            a.h.a.n0.c cVar2 = this.h;
                            if (cVar2 != null) {
                                cVar2.f3533d = obj3;
                                cVar2.unregisterIOTCListener(this);
                                this.h.stop(0);
                                this.h.disconnect();
                                this.h.connect(str2);
                                this.h.start(0, str, obj3);
                                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
                                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent());
                                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent());
                            }
                            Toast.makeText(this, a.c.a.d.a.h(R.string.TR_TIPS_EDIT_CAMERA_OK), 0).show();
                            intent = new Intent();
                            setResult(-1, intent);
                        }
                        h2 = a.c.a.d.a.h(R.string.TR_TIPS_WARNING);
                        h3 = a.c.a.d.a.h(R.string.TR_TIPS_DEV_SECURITY_CODE);
                        MainActivity3.k(this, h2, h3, a.c.a.d.a.h(R.string.TR_OK));
                        return;
                    }
                    h2 = a.c.a.d.a.h(R.string.TR_TIPS_WARNING);
                    h3 = a.c.a.d.a.h(R.string.TR_TIPS_DEV_UID_CHARACTER);
                    MainActivity3.k(this, h2, h3, a.c.a.d.a.h(R.string.TR_OK));
                    return;
                }
            } else if (z && !this.k) {
                String obj4 = this.f.getText().toString();
                String obj5 = this.f4630d.getText().toString();
                String str4 = this.i.f3529e;
                String obj6 = this.f4631e.getText().toString();
                if (obj4.length() != 0) {
                    if (obj5.length() == 0) {
                        h2 = a.c.a.d.a.h(R.string.TR_TIPS_WARNING);
                        h3 = a.c.a.d.a.h(R.string.TR_TIPS_DEV_UID);
                        MainActivity3.k(this, h2, h3, a.c.a.d.a.h(R.string.TR_OK));
                        return;
                    }
                    if (obj5.length() == 20) {
                        if (obj6.length() > 0) {
                            if (this.h != null && (!obj5.equalsIgnoreCase(this.i.f3528d) || !str4.equalsIgnoreCase(this.i.f3529e) || !obj6.equalsIgnoreCase(this.i.f))) {
                                a.h.a.n0.c cVar3 = this.h;
                                cVar3.f3533d = obj6;
                                cVar3.unregisterIOTCListener(this);
                                this.h.stop(0);
                                this.h.disconnect();
                                this.h.connect(obj5);
                                this.h.start(0, str4, obj6);
                                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
                                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent());
                                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent());
                            }
                            if (!obj4.equalsIgnoreCase(this.i.f3527c) || !obj5.equalsIgnoreCase(this.i.f3528d) || !str4.equalsIgnoreCase(this.i.f3529e) || !obj6.equalsIgnoreCase(this.i.f)) {
                                a.h.a.n0.b bVar3 = this.i;
                                bVar3.f3527c = obj4;
                                bVar3.f3528d = obj5;
                                bVar3.f3529e = str4;
                                bVar3.f = obj6;
                                a.h.a.n0.a aVar3 = new a.h.a.n0.a(this);
                                a.h.a.n0.b bVar4 = this.i;
                                String str5 = str4;
                                aVar3.g(bVar4.f3525a, bVar4.f3528d, obj4, "", "", str5, obj6, bVar4.i, bVar4.j);
                            }
                            intent = new Intent();
                            setResult(-1, intent);
                        }
                        h2 = a.c.a.d.a.h(R.string.TR_TIPS_WARNING);
                        h3 = a.c.a.d.a.h(R.string.TR_TIPS_DEV_SECURITY_CODE);
                        MainActivity3.k(this, h2, h3, a.c.a.d.a.h(R.string.TR_OK));
                        return;
                    }
                    h2 = a.c.a.d.a.h(R.string.TR_TIPS_WARNING);
                    h3 = a.c.a.d.a.h(R.string.TR_TIPS_DEV_UID_CHARACTER);
                    MainActivity3.k(this, h2, h3, a.c.a.d.a.h(R.string.TR_OK));
                    return;
                }
            } else {
                return;
            }
            h2 = a.c.a.d.a.h(R.string.TR_TIPS_WARNING);
            h3 = a.c.a.d.a.h(R.string.TR_TIPS_CAMERA_NAME);
            MainActivity3.k(this, h2, h3, a.c.a.d.a.h(R.string.TR_OK));
            return;
        } else {
            a.h.a.n0.c cVar4 = this.h;
            if (cVar4 != null) {
                cVar4.f3533d = this.i.f;
                cVar4.stop(0);
                this.h.disconnect();
                this.h.connect(this.i.f3528d);
                a.h.a.n0.c cVar5 = this.h;
                a.h.a.n0.b bVar5 = this.i;
                cVar5.start(0, bVar5.f3529e, bVar5.f);
                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent());
                this.h.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent());
            }
            setResult(-1, new Intent());
        }
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0) {
            Bundle extras = intent.getExtras();
            if (i3 == -1) {
                this.k = extras.getBoolean("need_reconnect");
                boolean z = extras.getBoolean("change_password");
                String string = extras.getString("new_password");
                if (z) {
                    this.f4631e.setText(string);
                }
            }
            a.h.a.n0.c cVar = this.h;
            if (cVar != null) {
                this.f4629c.setEnabled(cVar.isChannelConnected(0));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = true;
        requestWindowFeature(1);
        setContentView(R.layout.edit_device);
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabecera);
        this.l = topMenuActivityVideo;
        topMenuActivityVideo.setListener(this);
        this.l.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_CAMERA));
        ((TextView) findViewById(R.id.device_name)).setText(a.c.a.d.a.h(R.string.TR_NAME));
        ((TextView) findViewById(R.id.txtUID)).setText(a.c.a.d.a.h(R.string.TR_UID));
        ((TextView) findViewById(R.id.txtSecurityCode)).setText(a.c.a.d.a.h(R.string.TR_SECURITY_CODE));
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("dev_uuid");
        String string2 = extras.getString("dev_uid");
        Iterator<a.h.a.n0.b> it = MainActivity3.p.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.h.a.n0.b next = it.next();
            if (string.equalsIgnoreCase(next.f3526b) && string2.equalsIgnoreCase(next.f3528d)) {
                this.i = next;
                break;
            }
        }
        Iterator<a.h.a.n0.c> it2 = MainActivity3.o.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            a.h.a.n0.c next2 = it2.next();
            if (string.equalsIgnoreCase(next2.b()) && string2.equalsIgnoreCase(next2.f3531b)) {
                this.h = next2;
                next2.registerIOTCListener(this);
                break;
            }
        }
        ImageView imageView = (ImageView) findViewById(R.id.imagencamara);
        this.j = imageView;
        imageView.setImageBitmap(this.i.h);
        this.f4630d = (EditText) findViewById(R.id.edtUID);
        this.g = (TextView) findViewById(R.id.udid);
        this.f4631e = (EditText) findViewById(R.id.edtSecurityCode);
        this.f = (EditText) findViewById(R.id.edtNickName);
        Button button = (Button) findViewById(R.id.btnOK);
        this.f4627a = button;
        button.setText(a.c.a.d.a.h(R.string.TR_OK));
        Button button2 = (Button) findViewById(R.id.btnCancel);
        this.f4628b = button2;
        button2.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        Button button3 = (Button) findViewById(R.id.btnAdvanced);
        this.f4629c = button3;
        button3.setText(a.c.a.d.a.h(R.string.TR_ADVANCED_SETTINGS));
        Button button4 = this.f4629c;
        a.h.a.n0.c cVar = this.h;
        if (cVar == null || !cVar.isChannelConnected(0)) {
            z = false;
        }
        button4.setEnabled(z);
        this.f4630d.setText(string2);
        this.g.setText(string2);
        this.f4630d.setEnabled(false);
        this.f4631e.setText(this.i.f);
        this.f.setText(this.i.f3527c);
        this.f4627a.setOnClickListener(this.n);
        this.f4628b.setOnClickListener(this.o);
        this.f4629c.setOnClickListener(this.m);
        getWindow().setSoftInputMode(3);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            d(false);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void receiveChannelInfo(Camera camera, int i2, int i3) {
        if (this.h == camera && i3 == 2) {
            runOnUiThread(new d());
        }
    }

    public void receiveFrameData(Camera camera, int i2, Bitmap bitmap) {
    }

    public void receiveFrameInfo(Camera camera, int i2, long j2, int i3, int i4, int i5, int i6) {
    }

    public void receiveIOCtrlData(Camera camera, int i2, int i3, byte[] bArr) {
    }

    public void receiveSessionInfo(Camera camera, int i2) {
    }
}
