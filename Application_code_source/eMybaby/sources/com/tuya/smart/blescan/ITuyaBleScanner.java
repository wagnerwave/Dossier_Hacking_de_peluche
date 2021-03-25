package com.tuya.smart.blescan;

public interface ITuyaBleScanner {
    void addScanRequest(ScanRequest scanRequest);

    void clearCache();

    void removeScanRequest(ScanRequest scanRequest);

    void stopScan();
}
