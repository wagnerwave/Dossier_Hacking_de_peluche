package a.c.d.q;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.sozpic.miniland.ListadoTermometroActivity;
import java.util.Arrays;
import java.util.BitSet;
import java.util.UUID;

@RequiresApi(api = 18)
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final UUID f766a = UUID.fromString("00001809-0000-1000-8000-00805f9b34fb");

    /* renamed from: b  reason: collision with root package name */
    public final UUID f767b = UUID.fromString("00002a1c-0000-1000-8000-00805f9b34fb");

    /* renamed from: c  reason: collision with root package name */
    public final Context f768c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f769d;

    /* renamed from: e  reason: collision with root package name */
    public a f770e;
    public BluetoothAdapter f;
    public ScanCallback g = null;
    public BluetoothAdapter.LeScanCallback h;
    public BluetoothGatt i;
    public boolean j = false;
    public int k = 0;
    public final BluetoothGattCallback l = new c();
    public final Runnable m = new d();

    public class a extends ScanCallback {
        public a() {
        }

        public void onScanResult(int i, ScanResult scanResult) {
            b.a(b.this, scanResult.getDevice());
        }
    }

    /* renamed from: a.c.d.q.b$b  reason: collision with other inner class name */
    public class C0041b implements BluetoothAdapter.LeScanCallback {
        public C0041b() {
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            b.a(b.this, bluetoothDevice);
        }
    }

    public class c extends BluetoothGattCallback {
        public c() {
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            b.b(b.this, "onCharacteristicChanged");
            b.c(b.this, bluetoothGattCharacteristic.getValue());
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            b.b(b.this, "onCharacteristicRead");
            if (i == 0) {
                b.c(b.this, bluetoothGattCharacteristic.getValue());
            }
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            a aVar;
            b bVar = b.this;
            bVar.k = i2;
            if (i2 == 2) {
                StringBuilder n = a.a.a.a.a.n("Trying to discover gatt services: ");
                n.append(b.this.i.discoverServices());
                Log.d("ThermPharmaManager", n.toString());
            } else if (i2 == 0 && (aVar = bVar.f770e) != null) {
                ListadoTermometroActivity listadoTermometroActivity = (ListadoTermometroActivity) aVar;
                if (!listadoTermometroActivity.isFinishing()) {
                    listadoTermometroActivity.runOnUiThread(new a.h.a.d(listadoTermometroActivity, i));
                }
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                b.b(b.this, "Gatt server connection success!");
                for (BluetoothGattService next : bluetoothGatt.getServices()) {
                    b bVar = b.this;
                    StringBuilder n = a.a.a.a.a.n("found service: ");
                    n.append(next.getUuid());
                    b.b(bVar, n.toString());
                    if (next.getUuid().equals(b.this.f766a)) {
                        for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                            b bVar2 = b.this;
                            StringBuilder n2 = a.a.a.a.a.n("found characteristic: ");
                            n2.append(next2.getUuid());
                            b.b(bVar2, n2.toString());
                            if (next2.getUuid().equals(b.this.f767b)) {
                                b.this.i.setCharacteristicNotification(next2, true);
                                for (BluetoothGattDescriptor next3 : next2.getDescriptors()) {
                                    next3.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                    next3.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                                    b bVar3 = b.this;
                                    StringBuilder n3 = a.a.a.a.a.n("WriteDescriptor: ");
                                    n3.append(b.this.i.writeDescriptor(next3));
                                    b.b(bVar3, n3.toString());
                                }
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            b bVar = b.this;
            if (bVar.j) {
                a aVar = bVar.f770e;
                if (aVar != null) {
                    ListadoTermometroActivity listadoTermometroActivity = (ListadoTermometroActivity) aVar;
                    if (!listadoTermometroActivity.isFinishing()) {
                        listadoTermometroActivity.runOnUiThread(listadoTermometroActivity.u);
                    }
                }
                b.this.e();
            }
        }
    }

    public b(Context context, a aVar) {
        this.f768c = context;
        this.f769d = new Handler(context.getMainLooper());
        this.f770e = aVar;
        BluetoothManager bluetoothManager = (BluetoothManager) this.f768c.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.f = bluetoothManager.getAdapter();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.g = new a();
        }
        this.h = new C0041b();
    }

    public static void a(b bVar, BluetoothDevice bluetoothDevice) {
        int i2 = bVar.k;
        if (i2 != 2 && i2 != 1) {
            StringBuilder n = a.a.a.a.a.n("BTDevice found: ");
            n.append(bluetoothDevice.getName());
            n.append(" (");
            n.append(bluetoothDevice.getAddress());
            n.append(")");
            Log.d("ThermPharmaManager", n.toString());
            if (bluetoothDevice.getName() == null) {
                return;
            }
            if (bluetoothDevice.getName().equalsIgnoreCase("CARETALK") || bluetoothDevice.getName().equalsIgnoreCase("TH1009N-C")) {
                bVar.e();
                if (bVar.k != 2) {
                    bVar.f769d.post(new d(bVar, bluetoothDevice));
                }
            }
        }
    }

    public static void b(b bVar, String str) {
        if (bVar != null) {
            Log.d("ThermPharmaManager", str);
            return;
        }
        throw null;
    }

    public static void c(b bVar, byte[] bArr) {
        float f2;
        if (bVar != null) {
            StringBuilder n = a.a.a.a.a.n("processCharacteristicValue");
            n.append(Arrays.toString(bArr));
            Log.d("ThermPharmaManager", n.toString());
            if (Build.VERSION.SDK_INT >= 19) {
                byte b2 = bArr[0];
                BitSet bitSet = BitSet.valueOf(bArr).get(8, 40);
                BitSet bitSet2 = bitSet.get(24, 32);
                BitSet bitSet3 = bitSet.get(0, 24);
                int d2 = bVar.d(bitSet2, 8, true);
                int d3 = bVar.d(bitSet3, 24, true);
                if (d2 == 0) {
                    if (d3 == 8388607) {
                        f2 = Float.NaN;
                    } else if (d3 == 8388606) {
                        f2 = Float.POSITIVE_INFINITY;
                    } else if (d3 == -8388606) {
                        f2 = Float.NEGATIVE_INFINITY;
                    }
                    bVar.f769d.post(new e(bVar, Float.valueOf(f2), b2));
                    return;
                }
                double d4 = (double) d3;
                double pow = Math.pow(10.0d, (double) d2);
                Double.isNaN(d4);
                Double.isNaN(d4);
                Double.isNaN(d4);
                f2 = (float) (pow * d4);
                bVar.f769d.post(new e(bVar, Float.valueOf(f2), b2));
                return;
            }
            return;
        }
        throw null;
    }

    public final int d(BitSet bitSet, int i2, boolean z) {
        if (i2 <= 32) {
            int i3 = 0;
            if (i2 == 1) {
                z = false;
            }
            boolean z2 = z && i2 > 1 && bitSet.get(i2 + -1);
            int i4 = z2 ? -1 : 0;
            while (i3 < bitSet.length() && i3 < i2) {
                if (z2 && !bitSet.get(i3)) {
                    i4 ^= 1 << i3;
                } else if (!z2 && bitSet.get(i3)) {
                    i4 |= 1 << i3;
                }
                i3++;
            }
            return i4;
        }
        throw new IllegalArgumentException("size must be less or equal 32");
    }

    public final void e() {
        this.j = false;
        if (Build.VERSION.SDK_INT < 23 || this.f.getBluetoothLeScanner() == null) {
            this.f.stopLeScan(this.h);
            return;
        }
        this.f.getBluetoothLeScanner().flushPendingScanResults(this.g);
        this.f.getBluetoothLeScanner().stopScan(this.g);
    }
}
