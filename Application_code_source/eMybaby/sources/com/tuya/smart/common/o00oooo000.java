package com.tuya.smart.common;

import android.content.Context;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.bean.ResultBean;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.android.user.api.ILogoutCallback;
import com.tuya.smart.android.user.bean.User;

public abstract class o00oooo000 extends BaseModel implements o00oooo00o {
    public o00ooo0o00 O000000o;

    public o00oooo000(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
    }

    public void O000000o(final ILogoutCallback iLogoutCallback) {
        this.O000000o.O00000Oo(new Business.ResultListener<ResultBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ResultBean resultBean, String str) {
                ILogoutCallback iLogoutCallback = iLogoutCallback;
                if (iLogoutCallback != null) {
                    iLogoutCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ResultBean resultBean, String str) {
                o00ooo00o0.O000000o().removeUser();
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (o0o00o00o0 != null) {
                    o0o00o00o0.O00000o0();
                }
                if (iLogoutCallback == null) {
                    return;
                }
                if (resultBean.isSuccess()) {
                    iLogoutCallback.onSuccess();
                } else {
                    iLogoutCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(User user) {
        TimeStampManager.instance().onCreated();
        o00ooo00o0.O000000o().saveUser(user);
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().startServerService();
            o0o00o00o0.O0000o00().startHardwareService();
        }
    }
}
