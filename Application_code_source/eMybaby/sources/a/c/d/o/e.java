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
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RequiresApi(api = 18)
public class e {
    public static final UUID p = UUID.fromString("0000ffb0-0000-1000-8000-00805f9b34fb");
    public static final UUID q = UUID.fromString("0000ffb2-0000-1000-8000-00805f9b34fb");

    /* renamed from: a  reason: collision with root package name */
    public BluetoothManager f749a;

    /* renamed from: b  reason: collision with root package name */
    public BluetoothAdapter f750b;

    /* renamed from: c  reason: collision with root package name */
    public BluetoothLeScanner f751c;

    /* renamed from: d  reason: collision with root package name */
    public b<Long> f752d;

    /* renamed from: e  reason: collision with root package name */
    public Context f753e;
    public long f;
    public Handler g;
    public boolean h = false;
    public BluetoothGatt i;
    public a j;
    public int k;
    public final BluetoothGattCallback l = new a();
    public final ScanCallback m;
    public final BluetoothAdapter.LeScanCallback n = new b();
    public final Runnable o = new c();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            StringBuilder n = a.a.a.a.a.n("[BLUETHOOTH GATT] OnCharacteristicChanged:");
            n.append(bluetoothGattCharacteristic.getValue());
            Log.d("SCALE", n.toString());
            e.a(e.this, bluetoothGattCharacteristic.getValue());
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Log.d("SCALE", "[BLUETHOOTH GATT] OnCharacteristicRead:" + i);
            Log.d("SCALE", "[BLUETHOOTH GATT] OnCharacteristicRead:" + bluetoothGattCharacteristic.getValue());
            if (i == 0) {
                e.a(e.this, bluetoothGattCharacteristic.getValue());
            }
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 2) {
                e.this.k = 2;
                Log.i("SCALE", "[BLUETHOOTH GATT] Connected to GATT server.");
                Log.i("SCALE", "[BLUETHOOTH GATT] Attempting to start service discovery: " + e.this.i.discoverServices());
            } else if (i2 == 0) {
                e eVar = e.this;
                eVar.k = 0;
                eVar.c();
                Log.i("SCALE", "[BLUETHOOTH GATT] Disconnected from GATT server.Status->" + i);
                a aVar = e.this.j;
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
                Log.d("SCALE", "[BLUETHOOTH GATT] onServicesDiscovered success");
                for (BluetoothGattService next : bluetoothGatt.getServices()) {
                    StringBuilder n = a.a.a.a.a.n("[BLUETHOOTH GATT] Service: ");
                    n.append(next.getUuid());
                    a.c.a.f.e.a("SCALE", n.toString());
                    if (e.p.equals(next.getUuid())) {
                        for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                            StringBuilder n2 = a.a.a.a.a.n("[BLUETHOOTH GATT] characteristic: ");
                            n2.append(next2.getUuid());
                            n2.append(", ");
                            n2.append(next2.getDescriptors().size());
                            a.c.a.f.e.a("SCALE", n2.toString());
                            if (e.q.equals(next2.getUuid())) {
                                e.this.i.setCharacteristicNotification(next2, true);
                                for (BluetoothGattDescriptor next3 : next2.getDescriptors()) {
                                    next3.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                    e.this.i.writeDescriptor(next3);
                                }
                                return;
                            }
                        }
                        return;
                    }
                }
                return;
            }
            Log.w("SCALE", "[BLUETHOOTH GATT] onServicesDiscovered received: " + i);
        }
    }

    public class b implements BluetoothAdapter.LeScanCallback {
        public b() {
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            e.b(e.this, bluetoothDevice);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            StringBuilder n = a.a.a.a.a.n("Timeout-> Scanning:");
            n.append(e.this.h);
            Log.d("SCALE", n.toString());
            e eVar = e.this;
            if (eVar.h) {
                a aVar = eVar.j;
                if (aVar != null) {
                    ((MyScaleBabyActivity) aVar).z();
                }
                e.this.d();
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
            Log.d("SCALE", "Scan Failed: " + i);
        }

        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            e.b(e.this, scanResult.getDevice());
        }
    }

    /* renamed from: a.c.d.o.e$e  reason: collision with other inner class name */
    public class C0038e implements Runnable {
        public C0038e() {
        }

        public void run() {
            e eVar = e.this;
            if (eVar.i != null) {
                if (eVar.h) {
                    eVar.d();
                }
                e.this.i.close();
                e.this.i = null;
            }
        }
    }

    public e(Context context, a aVar) {
        this.f753e = context;
        this.g = new Handler(this.f753e.getMainLooper());
        this.f = 60;
        this.f752d = new b<>(5);
        BluetoothManager bluetoothManager = (BluetoothManager) this.f753e.getSystemService("bluetooth");
        this.f749a = bluetoothManager;
        this.f750b = bluetoothManager.getAdapter();
        this.j = aVar;
        this.m = Build.VERSION.SDK_INT >= 21 ? new d() : null;
    }

    public static void a(e eVar, byte[] bArr) {
        boolean z;
        float f2;
        String str;
        if (eVar.j == null) {
            str = "Listener measure is null!";
        } else {
            int length = bArr.length;
            if (length != 11) {
                str = "Incorrect size measure. Expected 11, received " + length;
            } else {
                long j2 = (((long) bArr[6]) & 255) + 0 + ((255 & ((long) bArr[5])) << 8);
                if (j2 <= 0) {
                    str = "Weight is 0";
                } else {
                    b<Long> bVar = eVar.f752d;
                    bVar.f735a.add(Long.valueOf(j2));
                    while (bVar.f735a.size() > bVar.f736b) {
                        bVar.f735a.poll();
                    }
                    b<Long> bVar2 = eVar.f752d;
                    int i2 = 0;
                    if (bVar2.f735a.size() >= bVar2.f736b) {
                        T peek = bVar2.f735a.peek();
                        Iterator it = bVar2.f735a.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!peek.equals(it.next())) {
                                    break;
                                }
                            } else {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        byte b2 = bArr[8];
                        if (b2 == 0) {
                            i2 = 4;
                            f2 = (float) j2;
                        } else if (b2 == 1) {
                            f2 = ((float) j2) / 10.0f;
                            i2 = 3;
                        } else if (b2 == 2) {
                            f2 = ((float) j2) / 100.0f;
                            i2 = 1;
                        } else if (b2 == 3) {
                            f2 = ((float) j2) / 1000.0f;
                        } else {
                            return;
                        }
                        a.c.d.a.l().v(i2);
                        ((MyScaleBabyActivity) eVar.j).A(f2, i2);
                        eVar.c();
                        return;
                    }
                    return;
                }
            }
        }
        Log.d("SCALE", str);
    }

    public static void b(e eVar, BluetoothDevice bluetoothDevice) {
        int i2 = eVar.k;
        if (i2 == 2 || i2 == 1) {
            StringBuilder n2 = a.a.a.a.a.n("Discard manage device found: state[");
            n2.append(eVar.k);
            n2.append("], scanning->");
            n2.append(eVar.h);
            Log.d("SCALE", n2.toString());
            return;
        }
        StringBuilder n3 = a.a.a.a.a.n("Device Found. Name:");
        n3.append(bluetoothDevice.getName());
        n3.append("->");
        n3.append(bluetoothDevice.getAddress());
        Log.d("SCALE", n3.toString());
        if (a.c.a.d.a.j(bluetoothDevice.getName())) {
            return;
        }
        if (("SCALE".equalsIgnoreCase(bluetoothDevice.getName()) || bluetoothDevice.getName().toUpperCase().startsWith("Ailink".toUpperCase()) || "eMyScale Plus".equalsIgnoreCase(bluetoothDevice.getName())) && eVar.k == 0) {
            eVar.d();
            if (eVar.k != 2) {
                eVar.g.post(new f(eVar, bluetoothDevice));
                eVar.k = 1;
            }
        }
    }

    public void c() {
        this.k = 0;
        if (this.i != null) {
            this.g.post(new C0038e());
        }
    }

    public final void d() {
        BluetoothLeScanner bluetoothLeScanner;
        this.h = false;
        if (Build.VERSION.SDK_INT < 23 || (bluetoothLeScanner = this.f751c) == null) {
            this.f750b.stopLeScan(this.n);
            return;
        }
        bluetoothLeScanner.flushPendingScanResults(this.m);
        this.f751c.stopScan(this.m);
    }
}
