package com.inuker.bluetooth.library.model;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(18)
public class BleGattCharacter implements Parcelable {
    public static final Parcelable.Creator<BleGattCharacter> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public ParcelUuid f4325a;

    /* renamed from: b  reason: collision with root package name */
    public int f4326b;

    /* renamed from: c  reason: collision with root package name */
    public int f4327c;

    /* renamed from: d  reason: collision with root package name */
    public List<BleGattDescriptor> f4328d;

    public static class a implements Parcelable.Creator<BleGattCharacter> {
        public Object createFromParcel(Parcel parcel) {
            return new BleGattCharacter(parcel);
        }

        public Object[] newArray(int i) {
            return new BleGattCharacter[i];
        }
    }

    public BleGattCharacter(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f4325a = new ParcelUuid(bluetoothGattCharacteristic.getUuid());
        this.f4326b = bluetoothGattCharacteristic.getProperties();
        this.f4327c = bluetoothGattCharacteristic.getPermissions();
        for (BluetoothGattDescriptor next : bluetoothGattCharacteristic.getDescriptors()) {
            if (this.f4328d == null) {
                this.f4328d = new ArrayList();
            }
            this.f4328d.add(new BleGattDescriptor(next));
        }
    }

    public BleGattCharacter(Parcel parcel) {
        this.f4325a = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
        this.f4326b = parcel.readInt();
        this.f4327c = parcel.readInt();
        this.f4328d = parcel.createTypedArrayList(BleGattDescriptor.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("BleGattCharacter{uuid=");
        n.append(this.f4325a);
        n.append(", property=");
        n.append(this.f4326b);
        n.append(", permissions=");
        n.append(this.f4327c);
        n.append(", descriptors=");
        n.append(this.f4328d);
        n.append('}');
        return n.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4325a, i);
        parcel.writeInt(this.f4326b);
        parcel.writeInt(this.f4327c);
        parcel.writeTypedList(this.f4328d);
    }
}
