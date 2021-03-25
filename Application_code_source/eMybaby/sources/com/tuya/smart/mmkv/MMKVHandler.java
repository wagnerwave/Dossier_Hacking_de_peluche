package com.tuya.smart.mmkv;

public interface MMKVHandler {
    MMKVRecoverStrategic onMMKVCRCCheckFail(String str);

    MMKVRecoverStrategic onMMKVFileLengthError(String str);
}
