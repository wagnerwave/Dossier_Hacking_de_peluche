package com.tuya.smart.blescan;

public interface LeScanResponse {
    void onDeviceFounded(ScanLeBean scanLeBean);

    void onScanCancel();

    void onScanStart();

    void onScanStop();
}
