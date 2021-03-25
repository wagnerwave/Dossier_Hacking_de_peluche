package com.cuatroochenta.miniland.humidificador.config;

import a.c.d.j.c.d;
import a.c.d.j.c.e;
import a.c.d.j.c.g;
import a.c.d.j.c.k;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cuatroochenta.miniland.humidificador.base.widget.circleprogress.CircleProgressView;
import com.sozpic.miniland.R;
import com.tuya.smart.sdk.TuyaSdk;
import com.wnafee.vector.compat.VectorDrawable;

public class ECBindActivity extends a.c.d.j.b.a.b implements k {
    public CircleProgressView g;
    public TextView h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public LinearLayout n;
    public TextView o;
    public g p;
    public TextView q;
    public TextView r;
    public RelativeLayout s;
    public View.OnClickListener t = new a();
    public final BroadcastReceiver u = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (view.getId() == R.id.tv_retry_button) {
                ECBindActivity eCBindActivity = ECBindActivity.this;
                eCBindActivity.g.setValue(0.0f);
                g gVar = eCBindActivity.p;
                if (gVar.f235c == 0) {
                    a.c.a.f.b.w0((Activity) gVar.f233a, new Intent(gVar.f233a, AddDeviceTipActivity.class), 0, true);
                    return;
                }
                a.c.a.f.b.w0((Activity) gVar.f233a, new Intent(gVar.f233a, ECActivity.class), 0, true);
            } else if (view.getId() == R.id.tv_finish_button) {
                ECBindActivity eCBindActivity2 = ECBindActivity.this;
                if (eCBindActivity2 != null) {
                    Intent intent = new Intent();
                    intent.setAction("refresh_devices");
                    eCBindActivity2.sendBroadcast(intent);
                    eCBindActivity2.onBackPressed();
                    return;
                }
                throw null;
            } else if (view.getId() == R.id.tv_ec_find_search_help && ECBindActivity.this == null) {
                throw null;
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo.isAvailable() && networkInfo.isConnected()) {
                    ECBindActivity.this.t();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ec_bind1);
        ((TextView) findViewById(R.id.tv_ap_connect_description)).setText(a.c.a.d.a.h(R.string.TR_CONNECT_PHONE_NETWORK));
        ((TextView) findViewById(R.id.tv_keep_router)).setText(a.c.a.d.a.h(R.string.TR_KEEP_ROUTER));
        this.g = (CircleProgressView) findViewById(R.id.circleView);
        TextView textView = (TextView) findViewById(R.id.ec_connect_tip);
        this.h = textView;
        textView.setText(a.c.a.d.a.h(R.string.TR_CONNECTING_DEVICE));
        this.i = (LinearLayout) findViewById(R.id.ec_connecting);
        TextView textView2 = (TextView) findViewById(R.id.tv_finish_button);
        this.j = textView2;
        textView2.setText(a.c.a.d.a.h(R.string.TR_ACEPTAR));
        this.j.setOnClickListener(this.t);
        TextView textView3 = (TextView) findViewById(R.id.tv_retry_button);
        this.k = textView3;
        textView3.setText(a.c.a.d.a.h(R.string.TR_RETRY));
        this.k.setOnClickListener(this.t);
        this.n = (LinearLayout) findViewById(R.id.ll_add_device_success);
        TextView textView4 = (TextView) findViewById(R.id.tv_add_device_success);
        this.l = textView4;
        textView4.setText(a.c.a.d.a.h(R.string.TR_DEVICE_ADDED_SUCCESSFULLY));
        this.m = (LinearLayout) findViewById(R.id.ll_failure_view);
        TextView textView5 = (TextView) findViewById(R.id.network_tip);
        this.o = textView5;
        textView5.setText(a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION));
        TextView textView6 = (TextView) findViewById(R.id.tv_ec_find_search_help);
        this.q = textView6;
        textView6.setOnClickListener(this.t);
        int color = Build.VERSION.SDK_INT >= 23 ? getColor(R.color.color_humidificador) : getResources().getColor(R.color.color_humidificador);
        this.g.setBarColor(color);
        this.g.setSpinBarColor(color);
        this.g.setTextColor(color);
        this.g.setUnitColor(color);
        this.g.setRimColor(Color.argb(51, Color.red(color), Color.green(color), Color.blue(color)));
        ((ImageView) findViewById(R.id.iv_add_device_fail)).setImageDrawable(VectorDrawable.getDrawable(TuyaSdk.getApplication(), R.drawable.add_device_fail_icon));
        TextView textView7 = (TextView) findViewById(R.id.tv_device_init_tip);
        this.r = textView7;
        textView7.setText(a.c.a.d.a.h(R.string.TR_CONFIG_DEVICE_INIT_TIP));
        this.s = (RelativeLayout) findViewById(R.id.switch_wifi_layout);
        ((TextView) findViewById(R.id.tv_ap_ssid)).setText("SmartLife".concat("_XXX"));
        Button button = (Button) findViewById(R.id.tv_bottom_button);
        button.setText(a.c.a.d.a.h(R.string.TR_CONNECT_NOW));
        button.setOnClickListener(new d(this));
        TextView textView8 = (TextView) findViewById(R.id.add_device_tip_help);
        textView8.setText(a.c.a.d.a.h(R.string.TR_STATUS_CONNECTION_FAILED));
        textView8.setOnClickListener(new e(this));
        o();
        r(a.c.a.d.a.h(R.string.TR_CONNECTING_DEVICE));
        q();
        this.p = new g(this, this);
        this.g.setValueInterpolator(new LinearInterpolator());
        try {
            registerReceiver(this.u, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDestroy() {
        this.p.onDestroy();
        try {
            if (this.u != null) {
                unregisterReceiver(this.u);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        t();
    }

    public final void t() {
        if (!this.f167b && a.c.a.f.b.L()) {
            try {
                if (this.u != null) {
                    unregisterReceiver(this.u);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a.c.d.j.b.a.b.setViewGone(this.s);
            this.p.a();
        }
    }

    public void u() {
        r(a.c.a.d.a.h(R.string.TR_STATUS_CONNECTION_FAILED));
        a.c.d.j.b.a.b.setViewGone(this.i);
        a.c.d.j.b.a.b.setViewVisible(this.m);
        a.c.d.j.b.a.b.setViewVisible(this.k);
        this.q.setText(a.c.a.d.a.h(R.string.TR_STATUS_CONNECTION_FAILED));
    }
}
