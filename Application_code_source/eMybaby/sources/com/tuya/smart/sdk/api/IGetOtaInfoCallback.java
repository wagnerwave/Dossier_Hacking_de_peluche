package com.tuya.smart.sdk.api;

import com.tuya.smart.android.device.bean.UpgradeInfoBean;
import java.util.List;

public interface IGetOtaInfoCallback {
    void onFailure(String str, String str2);

    void onSuccess(List<UpgradeInfoBean> list);
}
