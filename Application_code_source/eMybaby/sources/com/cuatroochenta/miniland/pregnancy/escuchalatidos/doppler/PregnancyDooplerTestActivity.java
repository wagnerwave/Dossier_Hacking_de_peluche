package com.cuatroochenta.miniland.pregnancy.escuchalatidos.doppler;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService;
import com.sozpic.miniland.R;

public class PregnancyDooplerTestActivity extends a.c.d.c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f4032b = null;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4033c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4034d;

    /* renamed from: e  reason: collision with root package name */
    public Button f4035e;
    public Button f;
    public Button g;
    public Button h;
    public Button i;
    public BluetoothAdapter j = BluetoothAdapter.getDefaultAdapter();
    public BluetoothDevice k;
    public PregnancyBTService l = null;
    public boolean m = false;
    public ServiceConnection n = new a();
    public Handler o = new b();
    public PregnancyBTService.c p = new c();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PregnancyDooplerTestActivity pregnancyDooplerTestActivity = PregnancyDooplerTestActivity.this;
            PregnancyBTService pregnancyBTService = PregnancyBTService.this;
            pregnancyDooplerTestActivity.l = pregnancyBTService;
            pregnancyBTService.f4011c = pregnancyDooplerTestActivity.k;
            pregnancyBTService.f4009a = pregnancyDooplerTestActivity.p;
            pregnancyBTService.d();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            PregnancyDooplerTestActivity.this.l = null;
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                PregnancyDooplerTestActivity.this.f4034d.setText(message.getData().getString(NotificationCompat.CATEGORY_ERROR));
            } else if (i == 10) {
                PregnancyDooplerTestActivity.this.f4033c.setText(message.getData().getString("infor"));
            } else if (i == 11) {
                PregnancyDooplerTestActivity.this.f4032b.setText(message.getData().getString("status"));
            }
        }
    }

    public class c implements PregnancyBTService.c {
        public c() {
        }

        public void a(int i) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.clear();
            bundle.putInt("status", i);
            obtain.setData(bundle);
            obtain.what = 11;
            PregnancyDooplerTestActivity.this.o.sendMessage(obtain);
        }

        public void b(String str) {
        }

        public void c(a.f.a.d.c cVar) {
            String format = String.format("FHR1:%-3d\nTOCO:%-3d\n AFM:%-3d\nSIGN:%-3d\nBATT:%-3d\nisFHR1:%-3d\nisTOCO:%-3d\n isAFM:%-3d\n", new Object[]{Integer.valueOf(cVar.f3325a), Byte.valueOf(cVar.f3326b), Byte.valueOf(cVar.f3327c), Byte.valueOf(cVar.f3328d), Byte.valueOf(cVar.g), Byte.valueOf(cVar.h), Byte.valueOf(cVar.i), Byte.valueOf(cVar.j)});
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.clear();
            bundle.putString("infor", format);
            obtain.setData(bundle);
            obtain.what = 10;
            PregnancyDooplerTestActivity.this.o.sendMessage(obtain);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            this.k = bluetoothDevice;
            this.f4034d.setText("requestCode:" + i2 + "\n" + "resultCode:" + i3 + "\n" + bluetoothDevice.getName() + "\n" + bluetoothDevice.getAddress() + "\n");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        android.widget.Toast.makeText(r8, getResources().getString(com.sozpic.miniland.R.string.start_bluetooth_connect), 0).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00aa, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0160, code lost:
        r9 = r9.getString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0164, code lost:
        android.widget.Toast.makeText(r8, r9, 0).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r9) {
        /*
            r8 = this;
            int r9 = r9.getId()
            r0 = 0
            r1 = 1
            r2 = 2131821776(0x7f1104d0, float:1.9276305E38)
            switch(r9) {
                case 2131296636: goto L_0x0107;
                case 2131297207: goto L_0x00d5;
                case 2131297352: goto L_0x0097;
                case 2131297415: goto L_0x0072;
                case 2131297626: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x016b
        L_0x000e:
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r9 = r8.l
            if (r9 != 0) goto L_0x0014
            goto L_0x009b
        L_0x0014:
            a.f.a.a r9 = r9.g
            a.f.a.b r2 = r9.g
            if (r2 == 0) goto L_0x0066
            r3 = 9
            byte[] r3 = new byte[r3]
            r4 = 2
            byte r5 = (byte) r4
            r6 = 85
            r3[r0] = r6
            r6 = -86
            r3[r1] = r6
            r6 = 10
            r3[r4] = r6
            r4 = -1
            r6 = 3
            r3[r6] = r4
            r6 = 4
            r3[r6] = r5
            r5 = 5
            r3[r5] = r1
            r6 = 6
            r3[r6] = r4
            r6 = 7
            r3[r6] = r4
            r4 = 8
            r6 = 0
        L_0x003f:
            if (r0 < r5) goto L_0x005b
            r3[r4] = r6
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService$e r2 = (com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService.e) r2
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r0 = com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService.this
            java.io.OutputStream r0 = r0.f4013e
            if (r0 == 0) goto L_0x0066
            r0.write(r3)     // Catch:{ IOException -> 0x0056 }
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r0 = com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService.this     // Catch:{ IOException -> 0x0056 }
            java.io.OutputStream r0 = r0.f4013e     // Catch:{ IOException -> 0x0056 }
            r0.flush()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0066
        L_0x0056:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0066
        L_0x005b:
            int r7 = r0 + 3
            byte r7 = r3[r7]
            int r6 = r6 + r7
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            int r0 = r0 + 1
            goto L_0x003f
        L_0x0066:
            monitor-enter(r9)
            int r0 = r9.k     // Catch:{ all -> 0x006f }
            int r0 = r0 + r1
            r9.k = r0     // Catch:{ all -> 0x006f }
            monitor-exit(r9)
            goto L_0x016b
        L_0x006f:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L_0x0072:
            android.bluetooth.BluetoothAdapter r9 = r8.j
            if (r9 == 0) goto L_0x0093
            boolean r9 = r9.isEnabled()
            if (r9 == 0) goto L_0x008a
            android.content.Intent r9 = new android.content.Intent
            java.lang.Class<com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTListActivity> r0 = com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTListActivity.class
            r9.<init>(r8, r0)
            r0 = 20
            r8.startActivityForResult(r9, r0)
            goto L_0x016b
        L_0x008a:
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821708(0x7f11048c, float:1.9276167E38)
            goto L_0x0160
        L_0x0093:
            java.lang.String r9 = "mAdapter = null"
            goto L_0x0164
        L_0x0097:
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r9 = r8.l
            if (r9 != 0) goto L_0x00ab
        L_0x009b:
            android.content.res.Resources r9 = r8.getResources()
            java.lang.String r9 = r9.getString(r2)
            android.widget.Toast r9 = android.widget.Toast.makeText(r8, r9, r0)
            r9.show()
            return
        L_0x00ab:
            boolean r1 = r9.m
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r9.f
            if (r1 == 0) goto L_0x00bf
            r9.b()
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821751(0x7f1104b7, float:1.9276254E38)
            goto L_0x0160
        L_0x00bf:
            r9.c()
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821752(0x7f1104b8, float:1.9276256E38)
            goto L_0x0160
        L_0x00cb:
            android.content.res.Resources r9 = r8.getResources()
            java.lang.String r9 = r9.getString(r2)
            goto L_0x0164
        L_0x00d5:
            boolean r9 = r8.m
            if (r9 == 0) goto L_0x00ff
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821533(0x7f1103dd, float:1.9275812E38)
            java.lang.String r9 = r9.getString(r1)
            android.widget.Toast r9 = android.widget.Toast.makeText(r8, r9, r0)
            r9.show()
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r9 = r8.l
            boolean r1 = r9.f
            if (r1 == 0) goto L_0x00f4
            r9.b()
        L_0x00f4:
            android.content.ServiceConnection r9 = r8.n
            r8.unbindService(r9)
            r9 = 0
            r8.l = r9
            r8.m = r0
            goto L_0x016b
        L_0x00ff:
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821534(0x7f1103de, float:1.9275814E38)
            goto L_0x0160
        L_0x0107:
            android.bluetooth.BluetoothDevice r9 = r8.k
            if (r9 == 0) goto L_0x0159
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r9 = r8.l
            if (r9 != 0) goto L_0x0130
            android.content.res.Resources r9 = r8.getResources()
            r2 = 2131821535(0x7f1103df, float:1.9275816E38)
            java.lang.String r9 = r9.getString(r2)
            android.widget.Toast r9 = android.widget.Toast.makeText(r8, r9, r0)
            r9.show()
            android.content.Intent r9 = new android.content.Intent
            java.lang.Class<com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService> r0 = com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService.class
            r9.<init>(r8, r0)
            android.content.ServiceConnection r0 = r8.n
            r8.bindService(r9, r0, r1)
            r8.m = r1
            goto L_0x016b
        L_0x0130:
            boolean r9 = r9.m
            if (r9 == 0) goto L_0x013c
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821600(0x7f110420, float:1.9275948E38)
            goto L_0x0160
        L_0x013c:
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821601(0x7f110421, float:1.927595E38)
            java.lang.String r9 = r9.getString(r1)
            android.widget.Toast r9 = android.widget.Toast.makeText(r8, r9, r0)
            r9.show()
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r9 = r8.l
            r9.a()
            com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService r9 = r8.l
            r9.d()
            goto L_0x016b
        L_0x0159:
            android.content.res.Resources r9 = r8.getResources()
            r1 = 2131821705(0x7f110489, float:1.927616E38)
        L_0x0160:
            java.lang.String r9 = r9.getString(r1)
        L_0x0164:
            android.widget.Toast r9 = android.widget.Toast.makeText(r8, r9, r0)
            r9.show()
        L_0x016b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.pregnancy.escuchalatidos.doppler.PregnancyDooplerTestActivity.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pregnancy_doopler_test);
        this.f4032b = (TextView) findViewById(R.id.service_status);
        this.f4033c = (TextView) findViewById(R.id.service_info);
        this.f4034d = (TextView) findViewById(R.id.infor);
        this.f4035e = (Button) findViewById(R.id.openBt);
        this.f = (Button) findViewById(R.id.searchBt);
        this.g = (Button) findViewById(R.id.connectBt);
        this.h = (Button) findViewById(R.id.recordBt);
        this.i = (Button) findViewById(R.id.tocoBt);
        this.f4035e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.m) {
            unbindService(this.n);
            this.l = null;
            this.m = false;
        }
    }

    public void onStop() {
        super.onStop();
    }
}
