package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.enums.FirmwareUpgradeEnum;

public interface IFirmwareUpgradeListener {
    void onFailure(FirmwareUpgradeEnum firmwareUpgradeEnum, String str, String str2);

    void onProgress(FirmwareUpgradeEnum firmwareUpgradeEnum, int i);

    void onSuccess(FirmwareUpgradeEnum firmwareUpgradeEnum);
}
