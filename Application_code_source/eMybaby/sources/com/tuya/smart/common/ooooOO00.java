package com.tuya.smart.common;

import com.tuya.smart.home.sdk.api.IWarningMsgListener;
import com.tuya.smart.sdk.TuyaSdk;

public class ooooOO00 implements o0OOOO00 {
    public IWarningMsgListener O000000o;

    public ooooOO00(IWarningMsgListener iWarningMsgListener) {
        this.O000000o = iWarningMsgListener;
        TuyaSdk.getEventBus().register(this);
    }

    public void O000000o() {
        TuyaSdk.getEventBus().unregister(this);
        this.O000000o = null;
    }

    public void onEventMainThread(o0oo0000oo o0oo0000oo) {
        IWarningMsgListener iWarningMsgListener = this.O000000o;
        if (iWarningMsgListener != null) {
            iWarningMsgListener.onWarnMessageArrived(o0oo0000oo.O000000o());
        }
    }
}
