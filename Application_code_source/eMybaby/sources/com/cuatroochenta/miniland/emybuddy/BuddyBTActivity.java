package com.cuatroochenta.miniland.emybuddy;

import a.c.a.f.e;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.Set;

public class BuddyBTActivity extends a.c.d.c {

    /* renamed from: b  reason: collision with root package name */
    public ListView f3817b;

    /* renamed from: c  reason: collision with root package name */
    public a.c.d.g.j.a f3818c;

    /* renamed from: d  reason: collision with root package name */
    public BluetoothAdapter f3819d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f3820e;
    public boolean f = false;
    public BluetoothA2dp g;
    public final BroadcastReceiver h = new a();
    public BluetoothProfile.ServiceListener i = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            String str;
            BuddyBTActivity buddyBTActivity;
            String action = intent.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                BluetoothClass bluetoothClass = (BluetoothClass) intent.getParcelableExtra("android.bluetooth.device.extra.CLASS");
                e.b(String.format("Found BT Device-> %s ,class %d, boundstate %d", new Object[]{bluetoothDevice.getName(), Integer.valueOf(bluetoothClass.getDeviceClass()), Integer.valueOf(bluetoothDevice.getBondState())}));
                int deviceClass = bluetoothClass.getDeviceClass();
                if (deviceClass == 1028 || deviceClass == 1048) {
                    StringBuilder n = a.a.a.a.a.n("Add Device ");
                    n.append(bluetoothDevice.getName());
                    e.b(n.toString());
                    a.c.d.g.j.a aVar = BuddyBTActivity.this.f3818c;
                    aVar.f82b.add(bluetoothDevice);
                    aVar.notifyDataSetChanged();
                }
                StringBuilder n2 = a.a.a.a.a.n("Device skipped ");
                n2.append(bluetoothDevice.getName());
                e.b(n2.toString());
            } else if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                a.c.d.g.j.a aVar2 = BuddyBTActivity.this.f3818c;
                if (aVar2 != null) {
                    aVar2.f82b.clear();
                    aVar2.notifyDataSetChanged();
                }
                BuddyBTActivity.this.r();
                BuddyBTActivity.this.q();
                if (intExtra == 12 && intExtra2 == 11) {
                    buddyBTActivity = BuddyBTActivity.this;
                    str = "Paired";
                } else if (intExtra == 10 && intExtra2 == 12) {
                    buddyBTActivity = BuddyBTActivity.this;
                    str = "Unpaired";
                } else {
                    return;
                }
                Toast.makeText(buddyBTActivity, str, 0).show();
            }
        }
    }

    public class b implements BluetoothProfile.ServiceListener {
        public b() {
        }

        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i == 2) {
                BuddyBTActivity.this.g = (BluetoothA2dp) bluetoothProfile;
                e.b("Service A2DP Connected");
                for (BluetoothDevice name : BuddyBTActivity.this.g.getConnectedDevices()) {
                    e.b(String.format("Connected Audio BT Device-> %s", new Object[]{name.getName()}));
                }
                for (BluetoothDevice name2 : BuddyBTActivity.this.g.getDevicesMatchingConnectionStates(new int[]{0})) {
                    e.b(String.format("Disconnected Audio BT Device-> %s", new Object[]{name2.getName()}));
                }
            }
        }

        public void onServiceDisconnected(int i) {
            if (i == 2) {
                BuddyBTActivity.this.g = null;
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            BuddyBTActivity buddyBTActivity = BuddyBTActivity.this;
            a.c.d.g.j.a aVar = buddyBTActivity.f3818c;
            if (aVar != null) {
                aVar.f82b.clear();
                aVar.notifyDataSetChanged();
            }
            buddyBTActivity.r();
            if (buddyBTActivity.f3819d != null) {
                buddyBTActivity.registerReceiver(buddyBTActivity.h, new IntentFilter("android.bluetooth.device.action.FOUND"));
                buddyBTActivity.f = true;
                buddyBTActivity.f3819d.startDiscovery();
            }
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.c.d.g.j.a aVar = BuddyBTActivity.this.f3818c;
            if (aVar != null) {
                BluetoothDevice bluetoothDevice = aVar.f82b.get(i);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1001) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            q();
            this.f3819d.getProfileProxy(this, this.i, 2);
        } else {
            a.c.a.f.b.i0(this, a.c.a.d.a.h(R.string.TR_NECESITA_ACTIVAR_BLUETOOTH), a.c.a.d.a.h(R.string.TR_OK));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mybuddy_bluetooth);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.buddy_bt_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_BEMYBUDDY_TITLE_IOS).toUpperCase());
        Button button = (Button) findViewById(R.id.buddy_bt_search);
        button.setText(a.c.a.d.a.h(R.string.TR_SEARCH));
        button.setOnClickListener(new c());
        this.f3820e = (ViewGroup) findViewById(R.id.buddy_bt_paired_devices);
        ListView listView = (ListView) findViewById(R.id.buddy_bt_device_list);
        this.f3817b = listView;
        listView.setOnItemClickListener(new d());
        a.c.d.g.j.a aVar = new a.c.d.g.j.a(this);
        this.f3818c = aVar;
        this.f3817b.setAdapter(aVar);
        if (this.f3819d == null) {
            this.f3819d = BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothAdapter bluetoothAdapter = this.f3819d;
        if (bluetoothAdapter != null) {
            if (!bluetoothAdapter.isEnabled()) {
                a.c.a.d.a.a(this, 1001);
                return;
            }
            q();
            this.f3819d.getProfileProxy(this, this.i, 2);
        }
    }

    public void onDestroy() {
        if (this.f) {
            try {
                unregisterReceiver(this.h);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        r();
        this.f3819d.closeProfileProxy(2, this.g);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    public final void q() {
        BluetoothAdapter bluetoothAdapter = this.f3819d;
        if (bluetoothAdapter != null) {
            Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
            if (bondedDevices.size() > 0) {
                this.f3820e.removeAllViews();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, (float) 1, getResources().getDisplayMetrics()));
                for (BluetoothDevice name : bondedDevices) {
                    RelativeLayout relativeLayout = (RelativeLayout) getWindow().getLayoutInflater().inflate(R.layout.item_buddy_bt_devices, (ViewGroup) null);
                    ((ImageView) relativeLayout.findViewById(R.id.buddy_bt_devices_item_disclosure)).setVisibility(4);
                    ((TextView) relativeLayout.findViewById(R.id.buddy_bt_devices_item_name)).setText(name.getName());
                    this.f3820e.addView(relativeLayout);
                    View view = new View(this);
                    view.setBackgroundColor(getResources().getColor(R.color.list_divider));
                    view.setLayoutParams(layoutParams);
                    this.f3820e.addView(view);
                }
                return;
            }
            Toast.makeText(this, "NO paired devices found", 0).show();
        }
    }

    public final void r() {
        if (this.f3819d.isDiscovering()) {
            this.f3819d.cancelDiscovery();
        }
    }
}
