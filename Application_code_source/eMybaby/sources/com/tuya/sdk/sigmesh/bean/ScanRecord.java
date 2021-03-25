package com.tuya.sdk.sigmesh.bean;

import a.a.a.a.a;
import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o00o0000oo;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ScanRecord {
    public static ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public static final int DATA_TYPE_FLAGS = 1;
    public static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    public static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    public static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    public static final int DATA_TYPE_SERVICE_DATA_128_BIT = 33;
    public static final int DATA_TYPE_SERVICE_DATA_16_BIT = 22;
    public static final int DATA_TYPE_SERVICE_DATA_32_BIT = 32;
    public static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    public static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    public static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    public static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    public static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    public static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    public static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    public static final String TAG = "ScanRecord";
    public int mAdvertiseFlags;
    public byte[] mBytes;
    public String mDeviceName;
    public SparseArray<byte[]> mManufacturerSpecificData;
    public Map<ParcelUuid, byte[]> mServiceData;
    public List<ParcelUuid> mServiceUuids;
    public int mTxPowerLevel;

    public ScanRecord() {
    }

    public ScanRecord(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.mServiceUuids = list;
        this.mManufacturerSpecificData = sparseArray;
        this.mServiceData = map;
        this.mDeviceName = str;
        this.mAdvertiseFlags = i;
        this.mTxPowerLevel = i2;
        this.mBytes = bArr;
    }

    public static byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static ScanRecord parseFromBytes(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap hashMap = new HashMap();
        String str = null;
        byte b2 = -1;
        byte b3 = -2147483648;
        while (true) {
            try {
                if (i < bArr.length) {
                    int i2 = i + 1;
                    byte b4 = bArr[i] & AVFrame.FRM_STATE_UNKOWN;
                    if (b4 != 0) {
                        int i3 = b4 - 1;
                        int i4 = i2 + 1;
                        byte b5 = bArr[i2] & AVFrame.FRM_STATE_UNKOWN;
                        int i5 = 16;
                        if (b5 != 22) {
                            if (b5 != 255) {
                                if (!(b5 == 32 || b5 == 33)) {
                                    switch (b5) {
                                        case 1:
                                            b2 = bArr[i4] & AVFrame.FRM_STATE_UNKOWN;
                                            break;
                                        case 2:
                                        case 3:
                                            parseServiceUuid(bArr, i4, i3, 2, arrayList);
                                            break;
                                        case 4:
                                        case 5:
                                            parseServiceUuid(bArr, i4, i3, 4, arrayList);
                                            break;
                                        case 6:
                                        case 7:
                                            parseServiceUuid(bArr, i4, i3, 16, arrayList);
                                            break;
                                        case 8:
                                        case 9:
                                            str = new String(extractBytes(bArr, i4, i3));
                                            break;
                                        case 10:
                                            b3 = bArr[i4];
                                            break;
                                    }
                                }
                            } else {
                                sparseArray.put(((bArr[i4 + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) + (255 & bArr[i4]), extractBytes(bArr, i4 + 2, i3 - 2));
                            }
                            i = i3 + i4;
                        }
                        if (b5 == 32) {
                            i5 = 4;
                        } else if (b5 != 33) {
                            i5 = 2;
                        }
                        hashMap.put(parseUuidFrom(extractBytes(bArr, i4, i5)), extractBytes(bArr, i4 + i5, i3 - i5));
                        i = i3 + i4;
                    }
                }
            } catch (Exception unused) {
                StringBuilder n = a.n("unable to parse scan record: ");
                n.append(Arrays.toString(bArr));
                Log.e(TAG, n.toString());
                return new ScanRecord((List<ParcelUuid>) null, (SparseArray<byte[]>) null, (Map<ParcelUuid, byte[]>) null, -1, Integer.MIN_VALUE, (String) null, bArr);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new ScanRecord(arrayList, sparseArray, hashMap, b2, b3, str, bArr);
    }

    public static int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    public static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException(a.h("uuidBytes length invalid - ", length));
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & AVFrame.FRM_STATE_UNKOWN)) + ((long) ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8));
                } else {
                    j = ((long) ((bArr[3] & AVFrame.FRM_STATE_UNKOWN) << 24)) + ((long) (bArr[0] & AVFrame.FRM_STATE_UNKOWN)) + ((long) ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8)) + ((long) ((bArr[2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH));
                }
                return new ParcelUuid(new UUID(BASE_UUID.getUuid().getMostSignificantBits() + (j << 32), BASE_UUID.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScanRecord.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.mBytes, ((ScanRecord) obj).mBytes);
    }

    public int getAdvertiseFlags() {
        return this.mAdvertiseFlags;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public SparseArray<byte[]> getManufacturerSpecificData() {
        return this.mManufacturerSpecificData;
    }

    public byte[] getManufacturerSpecificData(int i) {
        return this.mManufacturerSpecificData.get(i);
    }

    public Map<ParcelUuid, byte[]> getServiceData() {
        return this.mServiceData;
    }

    public byte[] getServiceData(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return this.mServiceData.get(parcelUuid);
    }

    public List<ParcelUuid> getServiceUuids() {
        return this.mServiceUuids;
    }

    public int getTxPowerLevel() {
        return this.mTxPowerLevel;
    }

    public String toString() {
        StringBuilder n = a.n("ScanRecord [mAdvertiseFlags=");
        n.append(this.mAdvertiseFlags);
        n.append(", mServiceUuids=");
        n.append(this.mServiceUuids);
        n.append(", mManufacturerSpecificData=");
        n.append(o00o0000oo.O000000o(this.mManufacturerSpecificData));
        n.append(", mServiceData=");
        n.append(o00o0000oo.O000000o(this.mServiceData));
        n.append(", mTxPowerLevel=");
        n.append(this.mTxPowerLevel);
        n.append(", mDeviceName=");
        return a.m(n, this.mDeviceName, "]");
    }
}
