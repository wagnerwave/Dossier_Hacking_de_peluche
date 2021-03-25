package com.cuatroochenta.miniland.humidificador.config;

import a.c.d.j.b.a.b;
import a.c.d.j.c.h;
import a.c.d.j.c.i;
import a.c.d.j.c.j;
import a.c.d.j.c.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.sozpic.miniland.R;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.sdk.TuyaSdk;
import com.wnafee.vector.compat.VectorDrawable;

public class ECActivity extends b implements l {
    public TextView g;
    public EditText h;
    public ImageButton i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public h m;
    public boolean n = true;
    public int o;
    public TextView p;
    public View.OnClickListener q = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (view.getId() == R.id.tv_other_wifi) {
                ECActivity.this.m.e();
            } else if (view.getId() == R.id.ec_password_switch) {
                ECActivity.this.clickPasswordSwitch(view);
            } else if (view.getId() == R.id.tv_bottom_button) {
                h hVar = ECActivity.this.m;
                String obj = ((ECActivity) hVar.f240c).h.getText().toString();
                String currentSSID = WiFiUtil.getCurrentSSID((Context) hVar.f239b);
                if (!NetworkUtil.isNetworkAvailable(hVar.f239b) || TextUtils.isEmpty(currentSSID)) {
                    a.c.a.f.b.q0(hVar.f239b, R.string.TR_CONNECT_PHONE_NETWORK);
                } else if (!h.d(currentSSID, hVar.f239b)) {
                    hVar.c(currentSSID, obj);
                } else {
                    a.c.a.f.b.x(hVar.f239b, (String) null, a.c.a.d.a.h(R.string.TR_SELECT_VALID_WIFI), a.c.a.d.a.h(R.string.TR_CHANGE), a.c.a.d.a.h(R.string.TR_CONTINUAR), (String) null, new j(hVar, currentSSID, obj)).show();
                }
            }
        }
    }

    public void clickPasswordSwitch(View view) {
        EditText editText;
        int i2;
        boolean z = !this.n;
        this.n = z;
        if (z) {
            this.i.setImageResource(R.drawable.ty_password_on);
            editText = this.h;
            i2 = 144;
        } else {
            this.i.setImageResource(R.drawable.ty_password_off);
            editText = this.h;
            i2 = 129;
        }
        editText.setInputType(i2);
        if (this.h.getText().length() > 0) {
            EditText editText2 = this.h;
            editText2.setSelection(editText2.getText().length());
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1315 && ((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
            this.m.a("android.permission.ACCESS_FINE_LOCATION", 222);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ec_mode);
        o();
        View findViewById = findViewById(R.id.v_title_down_line);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        TextView textView = (TextView) findViewById(R.id.tv_network);
        this.g = textView;
        textView.setVisibility(0);
        EditText editText = (EditText) findViewById(R.id.et_password);
        this.h = editText;
        editText.setHint(a.c.a.d.a.h(R.string.TR_INPUT_WIFI_PASSWORD));
        ImageButton imageButton = (ImageButton) findViewById(R.id.ec_password_switch);
        this.i = imageButton;
        imageButton.setOnClickListener(this.q);
        ImageView imageView = (ImageView) findViewById(R.id.iv_wifi);
        this.j = imageView;
        VectorDrawable drawable = VectorDrawable.getDrawable(TuyaSdk.getApplication(), R.drawable.wifi_status);
        this.j.setBackground(getResources().getDrawable(R.drawable.bg_bt_circle));
        drawable.setAlpha(128);
        imageView.setImageDrawable(drawable);
        this.j.setColorFilter(this.o);
        this.k = (TextView) findViewById(R.id.tv_wifi_status);
        TextView textView2 = (TextView) findViewById(R.id.tv_other_wifi);
        this.l = textView2;
        textView2.setText(a.c.a.d.a.h(R.string.TR_CONNECT_OTHER_WIFI));
        this.l.setOnClickListener(this.q);
        TextView textView3 = (TextView) findViewById(R.id.tv_bottom_button);
        textView3.setText(a.c.a.d.a.h(R.string.TR_NEXT));
        textView3.setOnClickListener(this.q);
        TextView textView4 = (TextView) findViewById(R.id.network_tip);
        this.p = textView4;
        textView4.setText(a.c.a.d.a.h(R.string.TR_SELECT_VALID_WIFI));
        r(a.c.a.d.a.h(R.string.TR_SETUP_WIFI_DEVICE));
        q();
        h hVar = new h(this, this);
        this.m = hVar;
        if (TextUtils.isEmpty(((ECActivity) hVar.f240c).g.getText().toString())) {
            WifiManager wifiManager = (WifiManager) hVar.f239b.getApplicationContext().getSystemService(NetworkUtil.CONN_TYPE_WIFI);
            if (!(wifiManager != null && !wifiManager.isWifiEnabled())) {
                boolean isProviderEnabled = ((LocationManager) hVar.f239b.getSystemService("location")).isProviderEnabled("gps");
                if (!isProviderEnabled) {
                    new AlertDialog.Builder(hVar.f239b).setIcon(17301659).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_TIP)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH_WHY_REASON)).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_SETTINGS), (DialogInterface.OnClickListener) new i(hVar)).show();
                }
                if (isProviderEnabled) {
                    hVar.a("android.permission.ACCESS_FINE_LOCATION", 222);
                }
            }
        }
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        this.o = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.color_humidificador));
        obtainStyledAttributes.recycle();
    }

    public void onDestroy() {
        super.onDestroy();
        this.m.onDestroy();
    }

    public void onResume() {
        super.onResume();
        this.m.b();
    }

    public boolean p(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        this.m.f239b.onBackPressed();
        return true;
    }
}
