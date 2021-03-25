package a.e.a.a.o;

import a.e.a.a.h;
import a.e.a.a.m;
import a.e.a.a.o.h.c;
import a.e.a.a.o.h.e;
import a.e.a.a.o.h.f;
import a.e.a.a.o.h.g;
import a.e.a.a.o.h.i;
import a.e.a.a.o.h.j;
import a.e.a.a.o.h.k;
import a.e.a.a.r.a;
import a.e.a.a.r.c.b;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.inuker.bluetooth.library.model.BleGattProfile;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public class d implements Handler.Callback, m, g, a.e.a.a.o.h.d, b {

    /* renamed from: a  reason: collision with root package name */
    public BluetoothGatt f3244a;

    /* renamed from: b  reason: collision with root package name */
    public BluetoothDevice f3245b;

    /* renamed from: c  reason: collision with root package name */
    public c f3246c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f3247d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f3248e;
    public BleGattProfile f;
    public Map<UUID, Map<UUID, BluetoothGattCharacteristic>> g;
    public a.e.a.a.o.h.d h;
    public m i;

    public d(String str, m mVar) {
        BluetoothAdapter D = a.c.a.f.b.D();
        if (D != null) {
            this.f3245b = D.getRemoteDevice(str);
            this.i = mVar;
            this.f3247d = new Handler(Looper.myLooper(), this);
            this.g = new HashMap();
            this.h = (a.e.a.a.o.h.d) a.e.a.a.r.b.A(this, a.e.a.a.o.h.d.class, this);
            return;
        }
        throw new IllegalStateException("ble adapter null");
    }

    public void A(c cVar) {
        this.i.y();
        this.f3246c = cVar;
    }

    public void B(c cVar) {
        this.i.y();
        if (this.f3246c == cVar) {
            this.f3246c = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean C() {
        /*
            r13 = this;
            a.e.a.a.m r0 = r13.i
            r0.y()
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = r13.E()
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "openGatt for %s"
            java.lang.String r1 = a.e.a.a.r.b.o(r2, r1)
            java.lang.String r2 = "miio-bluetooth"
            android.util.Log.v(r2, r1)
            android.bluetooth.BluetoothGatt r1 = r13.f3244a
            if (r1 == 0) goto L_0x002a
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r3 = "Previous gatt not closed"
            java.lang.String r1 = a.e.a.a.r.b.o(r3, r1)
            android.util.Log.e(r2, r1)
            return r0
        L_0x002a:
            android.content.Context r1 = a.c.a.f.b.E()
            a.e.a.a.o.j.j r4 = new a.e.a.a.o.j.j
            a.e.a.a.o.h.d r5 = r13.h
            r4.<init>(r5)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r5 < r6) goto L_0x003d
            r5 = 1
            goto L_0x003e
        L_0x003d:
            r5 = 0
        L_0x003e:
            r6 = 2
            if (r5 == 0) goto L_0x004a
            android.bluetooth.BluetoothDevice r5 = r13.f3245b
            android.bluetooth.BluetoothGatt r1 = r5.connectGatt(r1, r3, r4, r6)
        L_0x0047:
            r13.f3244a = r1
            goto L_0x009e
        L_0x004a:
            boolean r5 = a.e.a.a.r.b.L()
            if (r5 == 0) goto L_0x0097
            android.bluetooth.BluetoothDevice r5 = r13.f3245b
            java.lang.Class r7 = r5.getClass()     // Catch:{ Exception -> 0x008c }
            java.lang.String r8 = "connectGatt"
            r9 = 4
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x008c }
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            r10[r3] = r11     // Catch:{ Exception -> 0x008c }
            java.lang.Class r11 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x008c }
            r10[r0] = r11     // Catch:{ Exception -> 0x008c }
            java.lang.Class<android.bluetooth.BluetoothGattCallback> r11 = android.bluetooth.BluetoothGattCallback.class
            r10[r6] = r11     // Catch:{ Exception -> 0x008c }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x008c }
            r12 = 3
            r10[r12] = r11     // Catch:{ Exception -> 0x008c }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r10)     // Catch:{ Exception -> 0x008c }
            java.lang.String r8 = "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE) (hidden)"
            android.util.Log.w(r2, r8)     // Catch:{ Exception -> 0x008c }
            java.lang.Object[] r8 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x008c }
            r8[r3] = r1     // Catch:{ Exception -> 0x008c }
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x008c }
            r8[r0] = r9     // Catch:{ Exception -> 0x008c }
            r8[r6] = r4     // Catch:{ Exception -> 0x008c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008c }
            r8[r12] = r6     // Catch:{ Exception -> 0x008c }
            java.lang.Object r6 = r7.invoke(r5, r8)     // Catch:{ Exception -> 0x008c }
            android.bluetooth.BluetoothGatt r6 = (android.bluetooth.BluetoothGatt) r6     // Catch:{ Exception -> 0x008c }
            goto L_0x0094
        L_0x008c:
            r6 = move-exception
            r6.printStackTrace()
            android.bluetooth.BluetoothGatt r6 = r5.connectGatt(r1, r3, r4)
        L_0x0094:
            r13.f3244a = r6
            goto L_0x009e
        L_0x0097:
            android.bluetooth.BluetoothDevice r5 = r13.f3245b
            android.bluetooth.BluetoothGatt r1 = r5.connectGatt(r1, r3, r4)
            goto L_0x0047
        L_0x009e:
            android.bluetooth.BluetoothGatt r1 = r13.f3244a
            if (r1 != 0) goto L_0x00ae
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "openGatt failed: connectGatt return null!"
            java.lang.String r0 = a.e.a.a.r.b.o(r1, r0)
            android.util.Log.e(r2, r0)
            return r3
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.o.d.C():boolean");
    }

    public final void D(int i2) {
        Intent intent = new Intent("action.connect_status_changed");
        intent.putExtra("extra.mac", this.f3245b.getAddress());
        intent.putExtra("extra.status", i2);
        a.c.a.f.b.E().sendBroadcast(intent);
    }

    public final String E() {
        return this.f3245b.getAddress();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.g.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.bluetooth.BluetoothGattCharacteristic F(java.util.UUID r3, java.util.UUID r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0015
            if (r4 == 0) goto L_0x0015
            java.util.Map<java.util.UUID, java.util.Map<java.util.UUID, android.bluetooth.BluetoothGattCharacteristic>> r0 = r2.g
            java.lang.Object r0 = r0.get(r3)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.get(r4)
            android.bluetooth.BluetoothGattCharacteristic r0 = (android.bluetooth.BluetoothGattCharacteristic) r0
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x0026
            android.bluetooth.BluetoothGatt r1 = r2.f3244a
            if (r1 == 0) goto L_0x0026
            android.bluetooth.BluetoothGattService r3 = r1.getService(r3)
            if (r3 == 0) goto L_0x0026
            android.bluetooth.BluetoothGattCharacteristic r0 = r3.getCharacteristic(r4)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.o.d.F(java.util.UUID, java.util.UUID):android.bluetooth.BluetoothGattCharacteristic");
    }

    public final void G(int i2) {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("setConnectStatus status = %s", h.a(i2)));
        this.f3248e = i2;
    }

    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onDescriptorWrite for %s: status = %d, service = 0x%s, character = 0x%s, descriptor = 0x%s", this.f3245b.getAddress(), Integer.valueOf(i2), bluetoothGattDescriptor.getCharacteristic().getService().getUuid(), bluetoothGattDescriptor.getCharacteristic().getUuid(), bluetoothGattDescriptor.getUuid()));
        c cVar = this.f3246c;
        if (cVar != null && (cVar instanceof k)) {
            ((k) cVar).a(bluetoothGattDescriptor, i2);
        }
    }

    public void b(BluetoothGattDescriptor bluetoothGattDescriptor, int i2, byte[] bArr) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onDescriptorRead for %s: status = %d, service = 0x%s, character = 0x%s, descriptor = 0x%s", this.f3245b.getAddress(), Integer.valueOf(i2), bluetoothGattDescriptor.getCharacteristic().getService().getUuid(), bluetoothGattDescriptor.getCharacteristic().getUuid(), bluetoothGattDescriptor.getUuid()));
        c cVar = this.f3246c;
        if (cVar != null && (cVar instanceof f)) {
            ((f) cVar).b(bluetoothGattDescriptor, i2, bArr);
        }
    }

    public void c(int i2, int i3) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onMtuChanged for %s, mtu = %d, status = %d", this.f3245b.getAddress(), Integer.valueOf(i2), Integer.valueOf(i3)));
        c cVar = this.f3246c;
        if (cVar != null && (cVar instanceof a.e.a.a.o.h.h)) {
            ((a.e.a.a.o.h.h) cVar).c(i2, i3);
        }
    }

    public void d(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2, byte[] bArr) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onCharacteristicWrite for %s: status = %d, service = 0x%s, character = 0x%s, value = %s", this.f3245b.getAddress(), Integer.valueOf(i2), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), a.b(bArr)));
        c cVar = this.f3246c;
        if (cVar != null && (cVar instanceof j)) {
            ((j) cVar).d(bluetoothGattCharacteristic, i2, bArr);
        }
    }

    public void disconnect() {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("disconnect for %s", E()));
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        } else {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("disconnect but gatt is null!", new Object[0]));
        }
        c cVar = this.f3246c;
        if (cVar != null) {
            cVar.q(false);
        }
        G(0);
        D(32);
    }

    public void e(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2, byte[] bArr) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onCharacteristicRead for %s: status = %d, service = 0x%s, character = 0x%s, value = %s", this.f3245b.getAddress(), Integer.valueOf(i2), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), a.b(bArr)));
        c cVar = this.f3246c;
        if (cVar != null && (cVar instanceof e)) {
            ((e) cVar).e(bluetoothGattCharacteristic, i2, bArr);
        }
    }

    public void f(int i2, int i3) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onReadRemoteRssi for %s, rssi = %d, status = %d", this.f3245b.getAddress(), Integer.valueOf(i2), Integer.valueOf(i3)));
        c cVar = this.f3246c;
        if (cVar != null && (cVar instanceof g)) {
            ((g) cVar).f(i2, i3);
        }
    }

    public boolean g(UUID uuid, UUID uuid2) {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("readCharacteristic for %s: service = 0x%s, character = 0x%s", this.f3245b.getAddress(), uuid, uuid2));
        this.i.y();
        BluetoothGattCharacteristic F = F(uuid, uuid2);
        if (F == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("characteristic not exist!", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else if (bluetoothGatt.readCharacteristic(F)) {
            return true;
        } else {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("readCharacteristic failed", new Object[0]));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r7 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = r7.E()
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "refreshDeviceCache for %s"
            java.lang.String r1 = a.e.a.a.r.b.o(r2, r1)
            java.lang.String r2 = "miio-bluetooth"
            android.util.Log.v(r2, r1)
            a.e.a.a.m r1 = r7.i
            r1.y()
            android.bluetooth.BluetoothGatt r1 = r7.f3244a
            if (r1 != 0) goto L_0x002a
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "ble gatt null"
            java.lang.String r0 = a.e.a.a.r.b.o(r1, r0)
            android.util.Log.e(r2, r0)
            return r3
        L_0x002a:
            if (r1 == 0) goto L_0x004c
            java.lang.Class<android.bluetooth.BluetoothGatt> r4 = android.bluetooth.BluetoothGatt.class
            java.lang.String r5 = "refresh"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0048 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ Exception -> 0x0048 }
            if (r4 == 0) goto L_0x004c
            r4.setAccessible(r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r1 = r4.invoke(r1, r5)     // Catch:{ Exception -> 0x0048 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0048 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0048 }
            goto L_0x004d
        L_0x0048:
            r1 = move-exception
            a.c.a.f.b.z(r1)
        L_0x004c:
            r1 = 0
        L_0x004d:
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r4[r3] = r5
            java.lang.String r5 = "refreshDeviceCache return %b"
            java.lang.String r4 = a.e.a.a.r.b.o(r5, r4)
            android.util.Log.v(r2, r4)
            if (r1 != 0) goto L_0x006c
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "refreshDeviceCache failed"
            java.lang.String r0 = a.e.a.a.r.b.o(r1, r0)
            android.util.Log.e(r2, r0)
            return r3
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.o.d.h():boolean");
    }

    public boolean handleMessage(Message message) {
        if (message.what != 288) {
            return true;
        }
        a.e.a.a.r.c.a.a(message.obj);
        return true;
    }

    @TargetApi(21)
    public boolean i(int i2) {
        this.i.y();
        if (this.f3244a == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("discoverService but gatt is null!", new Object[0]));
            return false;
        } else if (a.e.a.a.r.b.L()) {
            return this.f3244a.requestMtu(i2);
        } else {
            return false;
        }
    }

    public boolean j(UUID uuid, UUID uuid2, UUID uuid3) {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("readDescriptor for %s: service = 0x%s, character = 0x%s, descriptor = 0x%s", this.f3245b.getAddress(), uuid, uuid2, uuid3));
        this.i.y();
        BluetoothGattCharacteristic F = F(uuid, uuid2);
        if (F == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("characteristic not exist!", new Object[0]));
            return false;
        }
        BluetoothGattDescriptor descriptor = F.getDescriptor(uuid3);
        if (descriptor == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("descriptor not exist", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else if (bluetoothGatt.readDescriptor(descriptor)) {
            return true;
        } else {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("readDescriptor failed", new Object[0]));
            return false;
        }
    }

    public boolean k() {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("discoverService for %s", E()));
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("discoverService but gatt is null!", new Object[0]));
            return false;
        } else if (bluetoothGatt.discoverServices()) {
            return true;
        } else {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("discoverServices failed", new Object[0]));
            return false;
        }
    }

    public boolean l(UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("writeDescriptor for %s: service = 0x%s, character = 0x%s, descriptor = 0x%s, value = 0x%s", this.f3245b.getAddress(), uuid, uuid2, uuid3, a.b(bArr)));
        this.i.y();
        BluetoothGattCharacteristic F = F(uuid, uuid2);
        if (F == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("characteristic not exist!", new Object[0]));
            return false;
        }
        BluetoothGattDescriptor descriptor = F.getDescriptor(uuid3);
        if (descriptor == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("descriptor not exist", new Object[0]));
            return false;
        } else if (this.f3244a == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else {
            if (bArr == null) {
                bArr = a.f3295a;
            }
            descriptor.setValue(bArr);
            if (this.f3244a.writeDescriptor(descriptor)) {
                return true;
            }
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("writeDescriptor failed", new Object[0]));
            return false;
        }
    }

    public BleGattProfile m() {
        return this.f;
    }

    public void n(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onCharacteristicChanged for %s: value = %s, service = 0x%s, character = 0x%s", this.f3245b.getAddress(), a.b(bArr), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid()));
        UUID uuid = bluetoothGattCharacteristic.getService().getUuid();
        UUID uuid2 = bluetoothGattCharacteristic.getUuid();
        Intent intent = new Intent("action.character_changed");
        intent.putExtra("extra.mac", this.f3245b.getAddress());
        intent.putExtra("extra.service.uuid", uuid);
        intent.putExtra("extra.character.uuid", uuid2);
        intent.putExtra("extra.byte.value", bArr);
        a.c.a.f.b.E().sendBroadcast(intent);
    }

    public int o() {
        this.i.y();
        return this.f3248e;
    }

    public boolean p(UUID uuid, UUID uuid2, byte[] bArr) {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("writeCharacteristic for %s: service = 0x%s, character = 0x%s, value = 0x%s", this.f3245b.getAddress(), uuid, uuid2, a.b(bArr)));
        this.i.y();
        BluetoothGattCharacteristic F = F(uuid, uuid2);
        if (F == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("characteristic not exist!", new Object[0]));
            return false;
        } else if (this.f3244a == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else {
            if (bArr == null) {
                bArr = a.f3295a;
            }
            F.setValue(bArr);
            if (this.f3244a.writeCharacteristic(F)) {
                return true;
            }
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("writeCharacteristic failed", new Object[0]));
            return false;
        }
    }

    public void q(int i2) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onServicesDiscovered for %s: status = %d", this.f3245b.getAddress(), Integer.valueOf(i2)));
        if (i2 == 0) {
            G(19);
            D(16);
            Log.v("miio-bluetooth", a.e.a.a.r.b.o("refreshServiceProfile for %s", this.f3245b.getAddress()));
            List<BluetoothGattService> services = this.f3244a.getServices();
            HashMap hashMap = new HashMap();
            for (BluetoothGattService next : services) {
                UUID uuid = next.getUuid();
                Map map = (Map) hashMap.get(uuid);
                if (map == null) {
                    Log.v("miio-bluetooth", "Service: " + uuid);
                    map = new HashMap();
                    hashMap.put(next.getUuid(), map);
                }
                for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                    UUID uuid2 = next2.getUuid();
                    Log.v("miio-bluetooth", "character: uuid = " + uuid2);
                    map.put(next2.getUuid(), next2);
                }
            }
            this.g.clear();
            this.g.putAll(hashMap);
            this.f = new BleGattProfile(this.g);
        }
        c cVar = this.f3246c;
        if (cVar != null && (cVar instanceof i)) {
            ((i) cVar).n(i2, this.f);
        }
    }

    public void r() {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("closeGatt for %s", E()));
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.f3244a = null;
        }
        c cVar = this.f3246c;
        if (cVar != null) {
            cVar.q(false);
        }
        G(0);
        D(32);
    }

    public void s(int i2) {
        if (this.f3244a == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("discoverService but gatt is null!", new Object[0]));
        } else if (a.e.a.a.r.b.L()) {
            this.f3244a.requestConnectionPriority(i2);
        }
    }

    public void t(int i2, int i3) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("onConnectionStateChange for %s: status = %d, newState = %d", this.f3245b.getAddress(), Integer.valueOf(i2), Integer.valueOf(i3)));
        if (i2 == 0 && i3 == 2) {
            G(2);
            c cVar = this.f3246c;
            if (cVar != null) {
                cVar.q(true);
                return;
            }
            return;
        }
        r();
    }

    public boolean u() {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("readRemoteRssi for %s", E()));
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else if (bluetoothGatt.readRemoteRssi()) {
            return true;
        } else {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("readRemoteRssi failed", new Object[0]));
            return false;
        }
    }

    public boolean v(UUID uuid, UUID uuid2, boolean z) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("setCharacteristicIndication for %s, service = %s, character = %s, enable = %b", E(), uuid, uuid2, Boolean.valueOf(z)));
        BluetoothGattCharacteristic F = F(uuid, uuid2);
        if (F == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("characteristic not exist!", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else if (!bluetoothGatt.setCharacteristicNotification(F, z)) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("setCharacteristicIndication failed", new Object[0]));
            return false;
        } else {
            BluetoothGattDescriptor descriptor = F.getDescriptor(h.f3227a);
            if (descriptor == null) {
                Log.e("miio-bluetooth", a.e.a.a.r.b.o("getDescriptor for indicate null!", new Object[0]));
                return false;
            }
            if (!descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                Log.e("miio-bluetooth", a.e.a.a.r.b.o("setValue for indicate descriptor failed!", new Object[0]));
                return false;
            } else if (this.f3244a.writeDescriptor(descriptor)) {
                return true;
            } else {
                Log.e("miio-bluetooth", a.e.a.a.r.b.o("writeDescriptor for indicate failed", new Object[0]));
                return false;
            }
        }
    }

    public boolean w(UUID uuid, UUID uuid2, byte[] bArr) {
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("writeCharacteristicWithNoRsp for %s: service = 0x%s, character = 0x%s, value = 0x%s", this.f3245b.getAddress(), uuid, uuid2, a.b(bArr)));
        this.i.y();
        BluetoothGattCharacteristic F = F(uuid, uuid2);
        if (F == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("characteristic not exist!", new Object[0]));
            return false;
        } else if (this.f3244a == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else {
            if (bArr == null) {
                bArr = a.f3295a;
            }
            F.setValue(bArr);
            F.setWriteType(1);
            if (this.f3244a.writeCharacteristic(F)) {
                return true;
            }
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("writeCharacteristic failed", new Object[0]));
            return false;
        }
    }

    public boolean x(Object obj, Method method, Object[] objArr) {
        this.f3247d.obtainMessage(288, new a.e.a.a.r.c.a(obj, method, objArr)).sendToTarget();
        return true;
    }

    public void y() {
        this.i.y();
    }

    public boolean z(UUID uuid, UUID uuid2, boolean z) {
        this.i.y();
        Log.v("miio-bluetooth", a.e.a.a.r.b.o("setCharacteristicNotification for %s, service = %s, character = %s, enable = %b", E(), uuid, uuid2, Boolean.valueOf(z)));
        BluetoothGattCharacteristic F = F(uuid, uuid2);
        if (F == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("characteristic not exist!", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f3244a;
        if (bluetoothGatt == null) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("ble gatt null", new Object[0]));
            return false;
        } else if (!bluetoothGatt.setCharacteristicNotification(F, z)) {
            Log.e("miio-bluetooth", a.e.a.a.r.b.o("setCharacteristicNotification failed", new Object[0]));
            return false;
        } else {
            BluetoothGattDescriptor descriptor = F.getDescriptor(h.f3227a);
            if (descriptor != null) {
                if (!descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                    Log.e("miio-bluetooth", a.e.a.a.r.b.o("setValue for notify descriptor failed!", new Object[0]));
                    return false;
                } else if (this.f3244a.writeDescriptor(descriptor)) {
                    return true;
                } else {
                    Log.e("miio-bluetooth", a.e.a.a.r.b.o("writeDescriptor for notify failed", new Object[0]));
                    return false;
                }
            } else if (F.getDescriptor(h.f3228b) != null) {
                return true;
            } else {
                Log.e("miio-bluetooth", a.e.a.a.r.b.o("getDescriptor for notify null!", new Object[0]));
                return false;
            }
        }
    }
}
