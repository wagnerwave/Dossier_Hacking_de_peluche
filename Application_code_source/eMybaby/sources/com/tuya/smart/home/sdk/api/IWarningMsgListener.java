package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.WarnMessageBean;

public interface IWarningMsgListener {
    void onWarnMessageArrived(WarnMessageBean warnMessageBean);
}
