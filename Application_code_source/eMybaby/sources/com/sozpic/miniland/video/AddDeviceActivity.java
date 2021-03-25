package com.sozpic.miniland.video;

import a.c.a.e.f;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.zxing.client.android.CaptureActivity;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import java.util.ArrayList;
import java.util.Iterator;

public class AddDeviceActivity extends Activity implements TopMenuActivityVideo.c {

    /* renamed from: a  reason: collision with root package name */
    public EditText f4590a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f4591b;

    /* renamed from: c  reason: collision with root package name */
    public Button f4592c;

    /* renamed from: d  reason: collision with root package name */
    public Button f4593d;

    /* renamed from: e  reason: collision with root package name */
    public Button f4594e;
    public Button f;
    public TopMenuActivityVideo g;
    public View.OnClickListener h = new a();
    public View.OnClickListener i = new b();
    public View.OnClickListener j = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(AddDeviceActivity.this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                ActivityCompat.requestPermissions(AddDeviceActivity.this, new String[]{"android.permission.CAMERA"}, 103);
                return;
            }
            AddDeviceActivity.this.d();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            boolean z;
            String obj = AddDeviceActivity.this.f4591b.getText().toString();
            String trim = AddDeviceActivity.this.f4590a.getText().toString().trim();
            Log.i("1MENSAJE", "1 " + obj);
            Log.i("1MENSAJE", "2 " + trim);
            if (obj.length() == 0) {
                MainActivity3.k(AddDeviceActivity.this, a.c.a.d.a.h(R.string.TR_TIPS_WARNING), a.c.a.d.a.h(R.string.TR_TIPS_CAMERA_NAME), a.c.a.d.a.h(R.string.TR_OK));
            } else if (trim.length() == 0) {
                MainActivity3.k(AddDeviceActivity.this, a.c.a.d.a.h(R.string.TR_TIPS_WARNING), a.c.a.d.a.h(R.string.TR_TIPS_DEV_UID), a.c.a.d.a.h(R.string.TR_OK));
            } else if (trim.length() != 20) {
                MainActivity3.k(AddDeviceActivity.this, a.c.a.d.a.h(R.string.TR_TIPS_WARNING), a.c.a.d.a.h(R.string.TR_TIPS_DEV_UID_CHARACTER), a.c.a.d.a.h(R.string.TR_OK));
            } else {
                Iterator<a.h.a.n0.c> it = MainActivity3.o.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (trim.equalsIgnoreCase(it.next().f3531b)) {
                            z = true;
                            Log.i("3MENSAJE", "3 duplicado");
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    MainActivity3.k(AddDeviceActivity.this, a.c.a.d.a.h(R.string.TR_TIPS_WARNING), a.c.a.d.a.h(R.string.TR_TIPS_ADD_CAMERA_DUPLICATED), a.c.a.d.a.h(R.string.TR_OK));
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("dev_nickname", obj);
                bundle.putString("dev_uid", trim);
                bundle.putString("dev_name", "");
                bundle.putString("dev_pwd", "");
                bundle.putString("view_acc", "admin");
                bundle.putString("view_pwd", "admin");
                bundle.putInt("video_quality", 0);
                bundle.putInt("camera_channel", 0);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                AddDeviceActivity.this.setResult(-1, intent);
                AddDeviceActivity.this.finish();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            AddDeviceActivity.this.setResult(0, new Intent());
            AddDeviceActivity.this.finish();
        }
    }

    public AddDeviceActivity() {
        new ArrayList();
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public final void d() {
        Intent intent = new Intent(this, CaptureActivity.class);
        intent.setAction("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        intent.setFlags(67108864);
        startActivityForResult(intent, 1001);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1001 && i3 == -1) {
            this.f4590a.setText(intent.getStringExtra("SCAN_RESULT"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.add_device);
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabecera);
        this.g = topMenuActivityVideo;
        topMenuActivityVideo.setListener(this);
        this.g.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_CAMERA));
        ((TextView) findViewById(R.id.header)).setText(a.c.a.d.a.h(R.string.TR_DEVICE_SETTINGS));
        ((TextView) findViewById(R.id.security_code_title)).setText(a.c.a.d.a.h(R.string.TR_SECURITY_CODE));
        EditText editText = (EditText) findViewById(R.id.edtUID);
        this.f4590a = editText;
        editText.setHint(a.c.a.d.a.h(R.string.TR_UID));
        EditText editText2 = (EditText) findViewById(R.id.edtNickName);
        this.f4591b = editText2;
        editText2.setHint(a.c.a.d.a.h(R.string.TR_NAME));
        Button button = (Button) findViewById(R.id.btnScan);
        this.f4592c = button;
        button.setText(a.c.a.d.a.h(R.string.TR_SCAN).toUpperCase());
        this.f4592c.setOnClickListener(this.h);
        Button button2 = (Button) findViewById(R.id.btnSearch);
        this.f4593d = button2;
        button2.setText(a.c.a.d.a.h(R.string.TR_SEARCH));
        Button button3 = (Button) findViewById(R.id.btnOK);
        this.f4594e = button3;
        button3.setOnClickListener(this.i);
        this.f4594e.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
        Button button4 = (Button) findViewById(R.id.btnCancel);
        this.f = button4;
        button4.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
        this.f.setOnClickListener(this.j);
        getWindow().setSoftInputMode(3);
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != 103) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length > 0 && iArr[0] == 0) {
            d();
        }
    }

    public void onResume() {
        super.onResume();
        f.c().e("VIGILABEBES_ANYADIR");
    }
}
