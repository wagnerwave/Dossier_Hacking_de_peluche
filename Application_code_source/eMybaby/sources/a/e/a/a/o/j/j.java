package a.e.a.a.o.j;

import a.e.a.a.o.h.d;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
public class j extends BluetoothGattCallback {

    /* renamed from: a  reason: collision with root package name */
    public d f3257a;

    public j(d dVar) {
        this.f3257a = dVar;
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3257a.n(bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f3257a.e(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f3257a.d(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f3257a.t(i, i2);
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.f3257a.b(bluetoothGattDescriptor, i, bluetoothGattDescriptor.getValue());
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.f3257a.a(bluetoothGattDescriptor, i);
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f3257a.c(i, i2);
    }

    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f3257a.f(i, i2);
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        this.f3257a.q(i);
    }
}
