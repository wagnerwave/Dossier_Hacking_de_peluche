package com.tuya.smart.blescan;

import a.e.a.a.a;
import a.e.a.a.q.i.b;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.tuya.smart.blescan.utils.BluetoothUtils;
import com.tuya.smart.blescan.utils.ScanLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class BleScanner {
    public static final String TAG = "BleScanner";
    public a client;
    public Context context;
    public AtomicBoolean isScanning = new AtomicBoolean(false);
    public LeScanResponse leScanResponse;

    public BleScanner(Context context2) {
        this.context = context2;
        this.client = new a(context2);
    }

    private boolean checkPermission() {
        if (BluetoothUtils.hasBlePermission(this.context)) {
            return false;
        }
        ScanLog.e(TAG, "checkPermission: ", new RuntimeException("Ble Permission not granted check permissions:\n\t\t\tandroid.permission.BLUETOOTH\n\t\t\tandroid.permission.BLUETOOTH_ADMIN\n\t\t\tandroid.permission.ACCESS_FINE_LOCATION\n"));
        return true;
    }

    /* access modifiers changed from: private */
    public ScanLeBean convertBean(SearchResult searchResult) {
        ScanLeBean scanLeBean = new ScanLeBean();
        scanLeBean.rssi = searchResult.f4337b;
        BluetoothDevice bluetoothDevice = searchResult.f4336a;
        scanLeBean.address = bluetoothDevice != null ? bluetoothDevice.getAddress() : "";
        BluetoothDevice bluetoothDevice2 = searchResult.f4336a;
        scanLeBean.device = bluetoothDevice2;
        String name = bluetoothDevice2.getName();
        if (TextUtils.isEmpty(name)) {
            name = "NULL";
        }
        scanLeBean.name = name;
        scanLeBean.scanRecord = searchResult.f4338c;
        return scanLeBean;
    }

    public boolean isScanning() {
        return this.isScanning.get();
    }

    public void startLeScan(SearchRequest searchRequest, LeScanResponse leScanResponse2) {
        if (this.isScanning.getAndSet(true)) {
            ScanLog.e(TAG, "startLeScan: already scanning");
            return;
        }
        this.isScanning.set(true);
        this.leScanResponse = leScanResponse2;
        if (!checkPermission() && BluetoothUtils.isBluetoothEnabled()) {
            this.client.m(searchRequest, new b() {
                public void onDeviceFounded(SearchResult searchResult) {
                    BleScanner.this.leScanResponse.onDeviceFounded(BleScanner.this.convertBean(searchResult));
                }

                public void onSearchCanceled() {
                    BleScanner.this.isScanning.set(false);
                    BleScanner.this.leScanResponse.onScanCancel();
                }

                public void onSearchStarted() {
                    BleScanner.this.isScanning.set(true);
                    BleScanner.this.leScanResponse.onScanStart();
                }

                public void onSearchStopped() {
                    BleScanner.this.isScanning.set(false);
                    BleScanner.this.leScanResponse.onScanStop();
                }
            });
            return;
        }
        this.leScanResponse.onScanCancel();
        this.isScanning.set(false);
    }

    public void stopLeScan() {
        this.isScanning.set(false);
        this.client.stopSearch();
    }
}
