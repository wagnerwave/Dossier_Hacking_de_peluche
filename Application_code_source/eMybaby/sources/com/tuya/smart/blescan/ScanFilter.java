package com.tuya.smart.blescan;

public interface ScanFilter {
    boolean filter(ScanLeBean scanLeBean);

    boolean filterOnly(ScanLeBean scanLeBean);
}
