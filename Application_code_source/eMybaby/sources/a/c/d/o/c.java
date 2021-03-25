package a.c.d.o;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.cuatroochenta.miniland.emyscale.MyScaleBabyActivity;
import java.util.List;
import java.util.UUID;

@RequiresApi(api = 18)
public class c {
    public static final UUID p = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
    public static final UUID q = UUID.fromString("0000fff4-0000-1000-8000-00805f9b34fb");

    /* renamed from: a  reason: collision with root package name */
    public BluetoothManager f737a;

    /* renamed from: b  reason: collision with root package name */
    public BluetoothAdapter f738b;

    /* renamed from: c  reason: collision with root package name */
    public BluetoothLeScanner f739c;

    /* renamed from: d  reason: collision with root package name */
    public Context f740d;

    /* renamed from: e  reason: collision with root package name */
    public long f741e;
    public Handler f;
    public boolean g = false;
    public BluetoothGatt h;
    public a i;
    public int j = -1;
    public int k;
    public final BluetoothGattCallback l = new a();
    public final ScanCallback m;
    public final BluetoothAdapter.LeScanCallback n = new b();
    public final Runnable o = new C0037c();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            c.a(c.this, bluetoothGattCharacteristic.getValue());
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Log.d("SAMICO-BABYSC", "[BLUETHOOTH GATT] OnCharacteristicRead:" + i);
            if (i == 0) {
                c.a(c.this, bluetoothGattCharacteristic.getValue());
            }
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 2) {
                c.this.k = 2;
                Log.i("SAMICO-BABYSC", "[BLUETHOOTH GATT] Connected to GATT server.");
                Log.i("SAMICO-BABYSC", "[BLUETHOOTH GATT] Attempting to start service discovery: " + c.this.h.discoverServices());
            } else if (i2 == 0) {
                c cVar = c.this;
                cVar.k = 0;
                cVar.c();
                Log.i("SAMICO-BABYSC", "[BLUETHOOTH GATT] Disconnected from GATT server.Status->" + i);
                a aVar = c.this.i;
                if (aVar != null) {
                    MyScaleBabyActivity myScaleBabyActivity = (MyScaleBabyActivity) aVar;
                    if (!myScaleBabyActivity.isFinishing()) {
                        myScaleBabyActivity.runOnUiThread(new a.c.d.h.b(myScaleBabyActivity, i));
                    }
                }
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                Log.d("SAMICO-BABYSC", "[BLUETHOOTH GATT] onServicesDiscovered success");
                for (BluetoothGattService next : bluetoothGatt.getServices()) {
                    StringBuilder n = a.a.a.a.a.n("[BLUETHOOTH GATT] Service: ");
                    n.append(next.getUuid());
                    a.c.a.f.e.a("SAMICO-BABYSC", n.toString());
                    if (c.p.equals(next.getUuid())) {
                        for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                            StringBuilder n2 = a.a.a.a.a.n("[BLUETHOOTH GATT] characteristic: ");
                            n2.append(next2.getUuid());
                            a.c.a.f.e.a("SAMICO-BABYSC", n2.toString());
                            if (c.q.equals(next2.getUuid())) {
                                c.this.h.setCharacteristicNotification(next2, true);
                                for (BluetoothGattDescriptor next3 : next2.getDescriptors()) {
                                    next3.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                    c.this.h.writeDescriptor(next3);
                                }
                                return;
                            }
                        }
                        return;
                    }
                }
                return;
            }
            Log.w("SAMICO-BABYSC", "[BLUETHOOTH GATT] onServicesDiscovered received: " + i);
        }
    }

    public class b implements BluetoothAdapter.LeScanCallback {
        public b() {
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            c.b(c.this, bluetoothDevice);
        }
    }

    /* renamed from: a.c.d.o.c$c  reason: collision with other inner class name */
    public class C0037c implements Runnable {
        public C0037c() {
        }

        public void run() {
            StringBuilder n = a.a.a.a.a.n("Timeout-> Scanning:");
            n.append(c.this.g);
            Log.d("SAMICO-BABYSC", n.toString());
            c cVar = c.this;
            if (cVar.g) {
                a aVar = cVar.i;
                if (aVar != null) {
                    ((MyScaleBabyActivity) aVar).z();
                }
                c.this.d();
            }
        }
    }

    public class d extends ScanCallback {
        public d() {
        }

        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        public void onScanFailed(int i) {
            super.onScanFailed(i);
            Log.d("SAMICO-BABYSC", "Scan Failed: " + i);
        }

        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            c.b(c.this, scanResult.getDevice());
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            c cVar = c.this;
            if (cVar.h != null) {
                if (cVar.g) {
                    cVar.d();
                }
                c.this.h.close();
                c.this.h = null;
            }
        }
    }

    public c(Context context, a aVar) {
        this.f740d = context;
        this.f = new Handler(this.f740d.getMainLooper());
        this.f741e = 60;
        BluetoothManager bluetoothManager = (BluetoothManager) this.f740d.getSystemService("bluetooth");
        this.f737a = bluetoothManager;
        this.f738b = bluetoothManager.getAdapter();
        this.i = aVar;
        this.m = Build.VERSION.SDK_INT >= 21 ? new d() : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(a.c.d.o.c r14, byte[] r15) {
        /*
            if (r14 == 0) goto L_0x0110
            int r0 = r15.length
            r1 = 0
            byte r2 = r15[r1]
            r3 = -54
            r4 = 1
            if (r2 != r3) goto L_0x000d
            r2 = 1
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            java.lang.String r3 = "SAMICO-BABYSC"
            if (r2 == 0) goto L_0x001a
            byte r2 = r15[r4]
            if (r2 < 0) goto L_0x001a
            java.lang.String r14 = "Intermediate measure received"
            goto L_0x00af
        L_0x001a:
            r2 = 5
            if (r0 >= r2) goto L_0x0025
            java.lang.String r14 = "Incorrect size measure. Expected 5, received "
            java.lang.String r14 = a.a.a.a.a.h(r14, r0)
            goto L_0x00af
        L_0x0025:
            r0 = 4
            byte r5 = r15[r0]
            if (r5 != 0) goto L_0x002b
            r1 = 1
        L_0x002b:
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r1 != 0) goto L_0x0032
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0034
        L_0x0032:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0034:
            byte r2 = r15[r2]
            r6 = -4
            if (r2 == r6) goto L_0x005d
            r6 = -3
            if (r2 == r6) goto L_0x0056
            r6 = -2
            if (r2 == r6) goto L_0x004f
            r6 = -1
            if (r2 == r6) goto L_0x0048
            if (r2 == 0) goto L_0x0045
            goto L_0x0069
        L_0x0045:
            float r1 = r1 * r5
            goto L_0x0069
        L_0x0048:
            double r1 = (double) r1
            r5 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            goto L_0x0063
        L_0x004f:
            double r1 = (double) r1
            r5 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            goto L_0x0063
        L_0x0056:
            double r1 = (double) r1
            r5 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            goto L_0x0063
        L_0x005d:
            double r1 = (double) r1
            r5 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
        L_0x0063:
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r5
            float r1 = (float) r1
        L_0x0069:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Multiplier:"
            r2.append(r5)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r3, r2)
            r2 = 2
            byte r5 = r15[r2]
            r6 = 3
            byte r7 = r15[r6]
            long r8 = (long) r5
            r10 = 255(0xff, double:1.26E-321)
            long r8 = r8 & r10
            r12 = 0
            long r8 = r8 + r12
            long r12 = (long) r7
            long r10 = r10 & r12
            r5 = 8
            long r10 = r10 << r5
            long r8 = r8 + r10
            float r5 = (float) r8
            float r5 = r5 * r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "Float Value:"
            r1.append(r7)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r3, r1)
            byte r15 = r15[r4]
            a.c.d.o.a r1 = r14.i
            if (r1 != 0) goto L_0x00b3
            java.lang.String r14 = "Listener measure is null!"
        L_0x00af:
            android.util.Log.d(r3, r14)
            goto L_0x010f
        L_0x00b3:
            java.lang.String r1 = "Remove timeout"
            android.util.Log.d(r3, r1)
            android.os.Handler r1 = r14.f
            java.lang.Runnable r7 = r14.o
            r1.removeCallbacks(r7)
            int r1 = r14.j
            r7 = -16
            java.lang.String r8 = "Measure received from scale is Kg"
            if (r1 == 0) goto L_0x00fc
            if (r1 == r4) goto L_0x00f0
            if (r1 == r2) goto L_0x00e7
            if (r1 == r6) goto L_0x00de
            if (r1 == r0) goto L_0x00d0
            goto L_0x010f
        L_0x00d0:
            if (r15 == 0) goto L_0x00d4
            if (r15 != r7) goto L_0x010f
        L_0x00d4:
            android.util.Log.d(r3, r8)
            a.c.d.o.a r15 = r14.i
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r5 = r5 * r0
            goto L_0x0105
        L_0x00de:
            if (r15 == r6) goto L_0x00e4
            r0 = -13
            if (r15 != r0) goto L_0x010f
        L_0x00e4:
            java.lang.String r15 = "Measure received from scale is Oz"
            goto L_0x00f8
        L_0x00e7:
            if (r15 == r2) goto L_0x00ed
            r0 = -14
            if (r15 != r0) goto L_0x010f
        L_0x00ed:
            java.lang.String r15 = "Measure received from scale is Stone"
            goto L_0x00f8
        L_0x00f0:
            if (r15 == r4) goto L_0x00f6
            r0 = -15
            if (r15 != r0) goto L_0x010f
        L_0x00f6:
            java.lang.String r15 = "Measure received from scale is Lib"
        L_0x00f8:
            android.util.Log.d(r3, r15)
            goto L_0x0103
        L_0x00fc:
            if (r15 == 0) goto L_0x0100
            if (r15 != r7) goto L_0x010f
        L_0x0100:
            android.util.Log.d(r3, r8)
        L_0x0103:
            a.c.d.o.a r15 = r14.i
        L_0x0105:
            int r0 = r14.j
            com.cuatroochenta.miniland.emyscale.MyScaleBabyActivity r15 = (com.cuatroochenta.miniland.emyscale.MyScaleBabyActivity) r15
            r15.A(r5, r0)
            r14.c()
        L_0x010f:
            return
        L_0x0110:
            r14 = 0
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.o.c.a(a.c.d.o.c, byte[]):void");
    }

    public static void b(c cVar, BluetoothDevice bluetoothDevice) {
        int i2 = cVar.k;
        if (i2 == 2 || i2 == 1) {
            StringBuilder n2 = a.a.a.a.a.n("Discard manage device found: state[");
            n2.append(cVar.k);
            n2.append("], scanning->");
            n2.append(cVar.g);
            Log.d("SAMICO-BABYSC", n2.toString());
            return;
        }
        StringBuilder n3 = a.a.a.a.a.n("Device Found. Name:");
        n3.append(bluetoothDevice.getName());
        n3.append("->");
        n3.append(bluetoothDevice.getAddress());
        Log.d("SAMICO-BABYSC", n3.toString());
        if ("Samico-BabySC".equalsIgnoreCase(bluetoothDevice.getName()) && cVar.k == 0) {
            cVar.d();
            if (cVar.k != 2) {
                cVar.f.post(new d(cVar, bluetoothDevice));
                cVar.k = 1;
            }
        }
    }

    public void c() {
        this.k = 0;
        if (this.h != null) {
            this.f.post(new e());
        }
    }

    public final void d() {
        BluetoothLeScanner bluetoothLeScanner;
        this.g = false;
        if (Build.VERSION.SDK_INT < 23 || (bluetoothLeScanner = this.f739c) == null) {
            this.f738b.stopLeScan(this.n);
            return;
        }
        bluetoothLeScanner.flushPendingScanResults(this.m);
        this.f739c.stopScan(this.m);
    }
}
