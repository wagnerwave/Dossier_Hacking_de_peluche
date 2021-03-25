package com.tuya.smart.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.smart.home.sdk.bean.TransferDataBean;
import com.tuya.smart.home.sdk.callback.ITuyaSingleTransfer;
import com.tuya.smart.home.sdk.callback.ITuyaTransferCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class oO0O0O00 implements o0oo0oo00o, o0oo0ooo00, ITuyaSingleTransfer {
    public static final String O00000oO = "m/m/i/";
    public final o0o00o0oo0 O000000o;
    public CopyOnWriteArrayList<ITuyaDataCallback<TransferDataBean>> O00000Oo;
    public volatile boolean O00000o;
    public CopyOnWriteArrayList<ITuyaTransferCallback> O00000o0;
    public Handler O00000oo;

    public static class O000000o {
        public static oO0O0O00 O000000o = new oO0O0O00();
    }

    public oO0O0O00() {
        this.O00000oo = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (!oO0O0O00.this.isOnline()) {
                    return false;
                }
                oO0O0O00.this.O000000o();
                return false;
            }
        });
        this.O000000o = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        this.O00000Oo = new CopyOnWriteArrayList<>();
        this.O00000o0 = new CopyOnWriteArrayList<>();
    }

    public static oO0O0O00 O00000Oo() {
        return O000000o.O000000o;
    }

    private String O00000Oo(String str) {
        return (!TextUtils.isEmpty(str) && str.contains("m/m/i/")) ? str.replace("m/m/i/", "") : "";
    }

    public String O000000o(String str) {
        return oO00O0o0.O000000o().O00000Oo(str).getLocalKey();
    }

    public void O000000o() {
        if (!this.O00000o0.isEmpty()) {
            Iterator<ITuyaTransferCallback> it = this.O00000o0.iterator();
            while (it.hasNext()) {
                it.next().onConnectSuccess();
            }
        }
    }

    public void O000000o(String str, String str2) {
        if (!this.O00000o0.isEmpty()) {
            Iterator<ITuyaTransferCallback> it = this.O00000o0.iterator();
            while (it.hasNext()) {
                it.next().onConnectError(str, str2);
            }
        }
    }

    public void O000000o(String str, byte[] bArr) {
        if (!this.O00000Oo.isEmpty()) {
            Iterator<ITuyaDataCallback<TransferDataBean>> it = this.O00000Oo.iterator();
            while (it.hasNext()) {
                it.next().onSuccess(new TransferDataBean(bArr, O00000Oo(str)));
            }
        }
    }

    public void O00000Oo(String str, String str2) {
        if (!this.O00000Oo.isEmpty()) {
            Iterator<ITuyaDataCallback<TransferDataBean>> it = this.O00000Oo.iterator();
            while (it.hasNext()) {
                it.next().onError(str, str2);
            }
        }
    }

    public boolean isOnline() {
        if (this.O000000o == null) {
            return false;
        }
        return oOo0oooO.O000000o().O00000Oo();
    }

    public void registerTransferCallback(ITuyaTransferCallback iTuyaTransferCallback) {
        if (iTuyaTransferCallback != null && !this.O00000o0.contains(iTuyaTransferCallback)) {
            this.O00000o0.add(iTuyaTransferCallback);
        }
    }

    public void registerTransferDataListener(ITuyaDataCallback<TransferDataBean> iTuyaDataCallback) {
        if (iTuyaDataCallback != null && !this.O00000Oo.contains(iTuyaDataCallback)) {
            this.O00000Oo.add(iTuyaDataCallback);
        }
    }

    public void startConnect() {
        if (this.O000000o != null && !this.O00000o) {
            this.O00000o = true;
            this.O000000o.O000000o().O000000o((o0oo0oo00o) this);
            this.O000000o.O000000o().O000000o((o0oo0ooo00) this);
            this.O00000oo.sendEmptyMessageDelayed(1, 100);
        }
    }

    public void stopConnect() {
        if (this.O000000o != null) {
            this.O00000oo.removeMessages(1);
            if (this.O00000o) {
                this.O00000o = false;
                if (!this.O00000o0.isEmpty()) {
                    this.O00000o0.clear();
                }
                this.O000000o.O000000o().O00000Oo((o0oo0ooo00) this);
                this.O000000o.O000000o().O00000Oo((o0oo0oo00o) this);
                if (!this.O00000Oo.isEmpty()) {
                    this.O00000Oo.clear();
                }
            }
        }
    }

    public void subscribeDevice(String str) {
        o0o00o0oo0 o0o00o0oo0 = this.O000000o;
        if (o0o00o0oo0 != null) {
            o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
            O000000o2.O00000Oo("m/m/i/" + str, (IResultCallback) null);
        }
    }

    public void unRegisterTransferCallback(ITuyaTransferCallback iTuyaTransferCallback) {
        if (iTuyaTransferCallback != null && this.O00000o0.contains(iTuyaTransferCallback)) {
            this.O00000o0.remove(iTuyaTransferCallback);
        }
    }

    public void unRegisterTransferDataListener(ITuyaDataCallback<TransferDataBean> iTuyaDataCallback) {
        if (iTuyaDataCallback != null && this.O00000Oo.contains(iTuyaDataCallback)) {
            this.O00000Oo.remove(iTuyaDataCallback);
        }
    }

    public void unSubscribeDevice(String str) {
        o0o00o0oo0 o0o00o0oo0 = this.O000000o;
        if (o0o00o0oo0 != null) {
            o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
            O000000o2.O000000o("m/m/i/" + str, (IResultCallback) null);
        }
    }
}
