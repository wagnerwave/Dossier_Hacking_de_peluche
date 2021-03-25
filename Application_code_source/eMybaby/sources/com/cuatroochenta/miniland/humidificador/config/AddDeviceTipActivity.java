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

public class AddDeviceTipActivity extends b implements View.OnClickListener {
    public AnimationDrawable g;

    public void onBackPressed() {
        finish();
        a.c.a.f.b.Y(this, 4);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_status_light) {
            Intent intent = new Intent(this, ECActivity.class);
            intent.putExtra("config_mode", 1);
            a.c.a.f.b.w0(this, intent, 0, true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_device_tip);
        o();
        ((TextView) findViewById(R.id.status_light_tip)).setText(a.h(R.string.TR_ADD_DEVICE_EZ_INFO));
        AnimationDrawable animationDrawable = new AnimationDrawable();
        this.g = animationDrawable;
        animationDrawable.addFrame(ContextCompat.getDrawable(this, R.drawable.ty_adddevice_lighting), 250);
        this.g.addFrame(ContextCompat.getDrawable(this, R.drawable.ty_adddevice_light), 250);
        this.g.setOneShot(false);
        ((ImageView) findViewById(R.id.status_light_imageview)).setImageDrawable(this.g);
        this.g.start();
        TextView textView = (TextView) findViewById(R.id.btn_status_light);
        textView.setText(a.h(R.string.TR_START_CONNECTION));
        textView.setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_tip_connect)).setText(a.h(R.string.TR_CONNECT_INTRUCTIONS));
        setTitle(R.string.TR_ADD_DEVICE);
        q();
    }

    public void onDestroy() {
        super.onDestroy();
        AnimationDrawable animationDrawable = this.g;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.g.stop();
        }
    }

    public void onPause() {
        super.onPause();
        AnimationDrawable animationDrawable = this.g;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.g.stop();
        }
    }

    public void onResume() {
        super.onResume();
        AnimationDrawable animationDrawable = this.g;
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            this.g.start();
        }
    }
}
