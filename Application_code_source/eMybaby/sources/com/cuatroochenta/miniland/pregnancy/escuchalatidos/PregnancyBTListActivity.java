package com.cuatroochenta.miniland.pregnancy.escuchalatidos;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.ArrayList;
import java.util.List;

public class PregnancyBTListActivity extends a.c.d.c implements TopMenuActivity.c {

    /* renamed from: b  reason: collision with root package name */
    public ListView f3999b;

    /* renamed from: c  reason: collision with root package name */
    public Button f4000c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f4001d;

    /* renamed from: e  reason: collision with root package name */
    public List<BluetoothDevice> f4002e;
    public ArrayList<String> f;
    public ArrayAdapter<String> g;
    public BluetoothAdapter h = BluetoothAdapter.getDefaultAdapter();
    public BroadcastReceiver i = new a();
    public BroadcastReceiver j = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (!PregnancyBTListActivity.this.f4002e.contains(bluetoothDevice)) {
                String name = bluetoothDevice.getName();
                if (!a.c.a.d.a.j(name)) {
                    PregnancyBTListActivity pregnancyBTListActivity = PregnancyBTListActivity.this;
                    if (pregnancyBTListActivity != null) {
                        if (name.startsWith("iFM")) {
                            pregnancyBTListActivity.f.add("sweetBeat");
                        } else {
                            pregnancyBTListActivity.f.add(name);
                        }
                        pregnancyBTListActivity.g.notifyDataSetChanged();
                        PregnancyBTListActivity.this.f4002e.add(bluetoothDevice);
                        return;
                    }
                    throw null;
                }
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            PregnancyBTListActivity.this.f4001d.setVisibility(8);
            PregnancyBTListActivity.this.f4000c.setText(a.c.a.d.a.h(R.string.TR_RETRY));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            if (PregnancyBTListActivity.this.h.isDiscovering()) {
                PregnancyBTListActivity.this.h.cancelDiscovery();
            } else {
                PregnancyBTListActivity.this.s();
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PregnancyBTListActivity.q(PregnancyBTListActivity.this);
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PregnancyBTListActivity.r(PregnancyBTListActivity.this);
        }
    }

    public class f extends Thread {
        public f(a aVar) {
        }

        public void run() {
            PregnancyBTListActivity.this.h.startDiscovery();
        }
    }

    public static void q(PregnancyBTListActivity pregnancyBTListActivity) {
        if (pregnancyBTListActivity != null) {
            ActivityCompat.requestPermissions(pregnancyBTListActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
            return;
        }
        throw null;
    }

    public static void r(PregnancyBTListActivity pregnancyBTListActivity) {
        if (pregnancyBTListActivity != null) {
            a.c.a.f.b.k0(pregnancyBTListActivity, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH));
            return;
        }
        throw null;
    }

    public void a() {
        onBackPressed();
    }

    public void b() {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1001) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            s();
        } else {
            a.c.a.f.b.i0(this, a.c.a.d.a.h(R.string.TR_NECESITA_ACTIVAR_BLUETOOTH), a.c.a.d.a.h(R.string.TR_OK));
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.h.isDiscovering()) {
            this.h.cancelDiscovery();
        }
        setResult(0, new Intent());
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pregnancy_bluetooth);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.pregnancy_bt_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO).toUpperCase());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.pregnancy_bt_header);
        viewGroup.findViewById(R.id.pregnancy_section_header_background).setBackgroundColor(-5504940);
        ((ImageView) viewGroup.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_hearthbeat);
        ((TextView) viewGroup.findViewById(R.id.pregnancy_section_header_title)).setText(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_ESCUCHALATIDOS));
        ((TextView) findViewById(R.id.pregnancy_bluetooth_title)).setText(a.c.a.d.a.h(R.string.TR_BLUETOOTH_CONECTION));
        ((TextView) findViewById(R.id.pregnancy_bluetooth_instructions)).setText(a.c.a.d.a.h(R.string.TR_PREGNANCY_BT_INSTRUCTIONS));
        ((TextView) findViewById(R.id.pregnancy_bluetooth_devices)).setText(a.c.a.d.a.h(R.string.TR_AVAILABLE_DEVICES));
        this.f4002e = new ArrayList();
        this.f = new ArrayList<>();
        Button button = (Button) findViewById(R.id.pregnancy_bluetooth_button);
        this.f4000c = button;
        button.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        this.f4000c.setOnClickListener(new c());
        this.f3999b = (ListView) findViewById(R.id.pregnancy_bluetooth_listview);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pregnancy_bluetooth_progressbar);
        this.f4001d = progressBar;
        progressBar.setVisibility(8);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.item_pregnancy_bt_device, this.f);
        this.g = arrayAdapter;
        this.f3999b.setAdapter(arrayAdapter);
        this.f3999b.setOnItemClickListener(new a.c.d.m.h.a(this));
        registerReceiver(this.i, new IntentFilter("android.bluetooth.device.action.FOUND"));
        registerReceiver(this.j, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED"));
        s();
        if (!a.c.d.a.l().a("KEY_WARN_NOT_MEDICAL_SWEETBEAT", false)) {
            a.c.d.a.l().g("KEY_WARN_NOT_MEDICAL_SWEETBEAT", Boolean.TRUE);
            a.c.a.f.b.j0(this, a.c.a.d.a.h(R.string.TR_MESSAGE_APP_NOT_MEDICAL_DEVICE));
        }
        a.c.a.e.f.c().e("MI_EMBARAZO_BLUETOOTH");
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.i);
        unregisterReceiver(this.j);
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != 102) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            a.c.a.f.b.k0(this, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH));
        } else {
            s();
        }
    }

    public final void s() {
        BluetoothAdapter bluetoothAdapter = this.h;
        if (bluetoothAdapter == null) {
            a.c.a.f.b.i0(this, a.c.a.d.a.h(R.string.TR_BLUETOOTH_NOT_SUPPORTED), a.c.a.d.a.h(R.string.TR_OK));
        } else if (!bluetoothAdapter.isEnabled()) {
            a.c.a.d.a.a(this, 1001);
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            new f((a) null).start();
            this.f4000c.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
            this.f4001d.setVisibility(0);
            this.f4000c.setVisibility(0);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION")) {
            a.c.a.f.b.p0(this, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH_WHY_REASON), a.c.a.d.a.h(R.string.TR_ACEPTAR), new d(), a.c.a.d.a.h(R.string.TR_CANCEL), new e());
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
        }
    }
}
