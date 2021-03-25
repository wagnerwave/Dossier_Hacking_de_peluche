package com.cuatroochenta.miniland.humidificador.config;

import a.c.a.d.a;
import a.c.d.j.b.a.b;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.sozpic.miniland.R;

public class AddDeviceAPTipActivity extends b implements View.OnClickListener {
    public TextView g;
    public TextView h;
    public ImageView i;
    public AnimationDrawable j;

    public void onBackPressed() {
        a.c.a.f.b.w0(this, new Intent(this, AddDeviceTipActivity.class), 1, true);
    }

    public void onClick(View view) {
        if (view.getId() != R.id.btn_status_light) {
            return;
        }
        if (getIntent().getBooleanExtra("FROM_EZ_FAILURE", false)) {
            Intent intent = getIntent();
            Intent intent2 = new Intent(this, ECBindActivity.class);
            intent2.putExtra("config_password", intent.getStringExtra("config_password"));
            intent2.putExtra("config_ssid", intent.getStringExtra("config_ssid"));
            intent2.putExtra("config_mode", 0);
            a.c.a.f.b.w0(this, intent2, 0, true);
            return;
        }
        Intent intent3 = new Intent(this, ECActivity.class);
        intent3.putExtra("config_mode", 0);
        a.c.a.f.b.w0(this, intent3, 0, true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_device_tip);
        o();
        TextView textView = (TextView) findViewById(R.id.status_light_tip);
        this.g = textView;
        textView.setText(a.h(R.string.TR_ADD_DEVICE_AP_INFO));
        this.i = (ImageView) findViewById(R.id.status_light_imageview);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        this.j = animationDrawable;
        animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.ty_adddevice_lighting), 1500);
        this.j.addFrame(ContextCompat.getDrawable(this, R.drawable.ty_adddevice_light), 1500);
        this.j.setOneShot(false);
        this.i.setImageDrawable(this.j);
        this.j.start();
        TextView textView2 = (TextView) findViewById(R.id.btn_status_light);
        this.h = textView2;
        textView2.setText(a.h(R.string.TR_START_CONNECTION));
        this.h.setOnClickListener(this);
        if (getIntent().getBooleanExtra("FROM_EZ_FAILURE", false)) {
            this.g.setText(a.h(R.string.TR_ADD_DEVICE_AP_INFO_FAILURE));
        }
        setTitle(R.string.TR_ADD_DEVICE);
        q();
    }

    public void onDestroy() {
        super.onDestroy();
        AnimationDrawable animationDrawable = this.j;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.j.stop();
        }
    }

    public void onPause() {
        super.onPause();
        AnimationDrawable animationDrawable = this.j;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.j.stop();
        }
    }

    public void onResume() {
        super.onResume();
        AnimationDrawable animationDrawable = this.j;
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            this.j.start();
        }
    }
}
