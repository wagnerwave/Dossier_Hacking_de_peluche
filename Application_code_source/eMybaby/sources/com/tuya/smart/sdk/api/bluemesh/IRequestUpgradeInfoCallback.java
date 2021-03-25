package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.android.blemesh.bean.BLEUpgradeBean;
import java.util.ArrayList;

public interface IRequestUpgradeInfoCallback {
    void onError(String str, String str2);

    void onSuccess(ArrayList<BLEUpgradeBean> arrayList);
}
