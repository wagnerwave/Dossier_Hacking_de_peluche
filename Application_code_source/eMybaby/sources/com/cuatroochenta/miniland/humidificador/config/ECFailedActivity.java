package com.cuatroochenta.miniland.humidificador.config;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.cuatroochenta.miniland.humidificador.base.activity.BrowserActivity;
import com.sozpic.miniland.R;

public class ECFailedActivity extends a.c.d.j.b.a.b {
    public String g;
    public String h;
    public int i;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(ECFailedActivity.this, ECBindActivity.class);
            intent.putExtra("config_password", ECFailedActivity.this.g);
            intent.putExtra("config_ssid", ECFailedActivity.this.h);
            intent.putExtra("config_mode", 0);
            a.c.a.f.b.w0(ECFailedActivity.this, intent, 0, true);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(ECFailedActivity.this, BrowserActivity.class);
            intent.putExtra("Login", false);
            intent.putExtra("Refresh", true);
            intent.putExtra(Toolbar.TAG, true);
            intent.putExtra("Title", a.c.a.d.a.h(R.string.TR_HELP));
            intent.putExtra("Uri", "https://smart.tuya.com/reset");
            ECFailedActivity.this.startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_device_failed);
        o();
        setTitle(R.string.TR_ADD_DEVICE);
        q();
        this.g = getIntent().getStringExtra("config_password");
        this.h = getIntent().getStringExtra("config_ssid");
        int intExtra = getIntent().getIntExtra("from", 2);
        this.i = intExtra;
        if (intExtra == 1) {
            a.c.d.j.b.a.b.setViewGone(findViewById(R.id.tv_network_tip));
        }
        Button button = (Button) findViewById(R.id.tv_bottom_button);
        button.setText(a.c.a.d.a.h(R.string.TR_INIT_COMFIRM));
        button.setOnClickListener(new a());
        TextView textView = (TextView) findViewById(R.id.add_device_tip_help);
        textView.setText(a.c.a.d.a.h(R.string.TR_STATUS_CONNECTION_FAILED));
        textView.setOnClickListener(new b());
    }
}
