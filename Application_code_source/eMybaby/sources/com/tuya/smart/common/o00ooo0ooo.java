package com.tuya.smart.common;

import android.content.Context;
import com.tuya.sdk.user.bean.StorageSign;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.android.user.bean.User;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class o00ooo0ooo extends BaseModel {
    public static final int O000000o = 20001;
    public static final String O00000Oo = "AvatarUploadModel";
    public o00ooo0o00 O00000o = new o00ooo0o00();
    public Context O00000o0;

    public o00ooo0ooo(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
        this.O00000o0 = context;
    }

    /* access modifiers changed from: private */
    public void O000000o(StorageSign storageSign, File file, final String str, final IBooleanCallback iBooleanCallback) {
        Request.Builder addHeader = new Request.Builder().url(storageSign.getUrl()).put(RequestBody.create(MediaType.parse((String) storageSign.getHeaders().get("Content-Type")), file)).addHeader("Content-Type", String.valueOf(storageSign.getHeaders().get("Content-Type"))).addHeader("Date", String.valueOf(storageSign.getHeaders().get("Date")));
        if (storageSign.getHeaders().get("Authorization") != null) {
            addHeader.addHeader("Authorization", String.valueOf(storageSign.getHeaders().get("Authorization")));
        }
        TuyaSmartNetWork.getOkHttpClient().newCall(addHeader.build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                iBooleanCallback.onError(iOException.getMessage(), iOException.getMessage());
                o00ooo0ooo.this.resultError(10000, iOException.getMessage(), iOException.getMessage());
            }

            public void onResponse(Call call, Response response) {
                o00ooo0ooo.this.O000000o(str, iBooleanCallback);
            }
        });
    }

    /* access modifiers changed from: private */
    public void O000000o(String str, final IBooleanCallback iBooleanCallback) {
        User user = o00ooo00o0.O000000o().getUser();
        if (user != null) {
            this.O00000o.O0000OoO(user.getNickName(), str, new Business.ResultListener<String>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, String str, String str2) {
                    o00ooo0ooo.this.resultError(10000, businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    iBooleanCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, String str, String str2) {
                    User user = o00ooo00o0.O000000o().getUser();
                    user.setHeadPic(str);
                    o00ooo00o0.O000000o().saveUser(user);
                    o00ooo0ooo.this.resultSuccess(o00ooo0ooo.O000000o, str2);
                    iBooleanCallback.onSuccess();
                }
            });
        } else if (iBooleanCallback != null) {
            iBooleanCallback.onError("2309", "user==null");
        }
    }

    public void O000000o(final String str, final File file, final IBooleanCallback iBooleanCallback) {
        this.O00000o.O00000oO(str, "image", "PUT", "avatar", new Business.ResultListener<StorageSign>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, StorageSign storageSign, String str) {
                o00ooo0ooo.this.resultError(10000, businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                iBooleanCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, StorageSign storageSign, String str) {
                o00ooo0ooo.this.O000000o(storageSign, file, str, iBooleanCallback);
            }
        });
    }

    public void onDestroy() {
        o00ooo0o00 o00ooo0o00 = this.O00000o;
        if (o00ooo0o00 != null) {
            o00ooo0o00.onDestroy();
        }
    }
}
