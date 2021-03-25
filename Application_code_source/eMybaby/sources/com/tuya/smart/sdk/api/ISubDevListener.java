package com.tuya.smart.sdk.api;

import java.util.List;

public interface ISubDevListener {
    void onSubDevAdded(String str);

    void onSubDevDpUpdate(String str, String str2);

    void onSubDevInfoUpdate(String str);

    void onSubDevRemoved(String str);

    void onSubDevStatusChanged(List<String> list, List<String> list2);
}
