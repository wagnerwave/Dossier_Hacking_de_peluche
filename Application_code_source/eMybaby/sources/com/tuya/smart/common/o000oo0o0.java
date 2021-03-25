package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tuya.sdk.hardware.bean.HResponse;
import com.tuya.smart.android.common.task.TuyaExecutor;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.hardware.ITransferAidlInterface;
import com.tuya.smart.android.hardware.ITransferServiceAidlInterface;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.hardware.service.DevTransferService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class o000oo0o0 implements Handler.Callback, o000o0000, o000oo0oo {
    public static final String O000000o = "GwTransferModel";
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    public static final int O00000oO = 4;
    public static final int O00000oo = 5;
    public static final int O0000O0o = 6;
    public CopyOnWriteArrayList<o000o0000> O0000OOo = new CopyOnWriteArrayList<>();
    public volatile boolean O0000Oo = false;
    public CopyOnWriteArrayList<o000o000o> O0000Oo0 = new CopyOnWriteArrayList<>();
    public volatile ITransferServiceAidlInterface O0000OoO;
    public final ServiceConnection O0000Ooo = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            obtain.obj = iBinder;
            o000oo0o0.this.O0000o0O.sendMessage(obtain);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            o000oo0o0.this.O0000o0O.sendMessage(obtain);
        }
    };
    public WeakReference<Context> O0000o0;
    public ITransferAidlInterface.Stub O0000o00 = new ITransferAidlInterface.Stub() {
        public void closeService() {
            Message obtain = Message.obtain();
            obtain.what = 4;
            o000oo0o0.this.O0000o0O.sendMessage(obtain);
        }

        public String getAppId() {
            Context context = (Context) o000oo0o0.this.O0000o0.get();
            return context == null ? "" : context.getPackageName();
        }

        public void gwOff(HgwBean hgwBean) {
            Message obtain = Message.obtain();
            obtain.obj = hgwBean;
            obtain.what = 2;
            o000oo0o0.this.O0000o0O.sendMessage(obtain);
        }

        public void gwOn(HgwBean hgwBean) {
            Message obtain = Message.obtain();
            obtain.obj = hgwBean;
            obtain.what = 1;
            o000oo0o0.this.O0000o0O.sendMessage(obtain);
        }

        public void responseByBinary(String str, String str2, int i, int i2, int i3, byte[] bArr) {
            HResponse hResponse = new HResponse(str, i, i2, i3, bArr, str2);
            Message obtain = Message.obtain();
            obtain.obj = hResponse;
            obtain.what = 3;
            o000oo0o0.this.O0000o0O.sendMessage(obtain);
        }
    };
    public Handler O0000o0O = new Handler(Looper.getMainLooper(), this);

    private void O00000o0(Context context) {
        try {
            context.unbindService(this.O0000Ooo);
        } catch (Exception e2) {
            L.e(O000000o, "releaseTCPService unbindservice exception");
            e2.printStackTrace();
        }
        try {
            context.stopService(new Intent(context, DevTransferService.class));
        } catch (Exception e3) {
            L.e(O000000o, "stop failure");
            e3.printStackTrace();
        }
        L.d(O000000o, "releaseTCPService success");
    }

    public List<HgwBean> O000000o() {
        if (!this.O0000Oo) {
            return null;
        }
        try {
            if (this.O0000OoO != null) {
                return this.O0000OoO.queryGw();
            }
        } catch (Exception e2) {
            L.e(O000000o, e2.getMessage());
        }
        return null;
    }

    public void O000000o(Context context) {
        L.d(O000000o, "try to startService");
        try {
            if (!this.O0000Oo) {
                this.O0000o0 = new WeakReference<>(context);
                L.d(O000000o, "serviceConnected: " + this.O0000Oo + " mDevTransferService: ");
                Intent intent = new Intent(context, DevTransferService.class);
                intent.setAction(o000o0o0o.O0000OoO);
                intent.addCategory("tuya");
                if (!TuyaUtil.isAppForeground(context)) {
                    L.d(O000000o, "startService in background");
                    intent.putExtra(o000o0ooo.O000000o, false);
                    if (!o00o00ooo.O000000o(context, intent)) {
                        return;
                    }
                } else {
                    L.d(O000000o, "startService in foreground");
                    intent.putExtra(o000o0ooo.O000000o, true);
                    context.startService(intent);
                }
                context.bindService(intent, this.O0000Ooo, 1);
                return;
            }
            L.d(O000000o, "service started");
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    public void O000000o(HResponse hResponse) {
        Iterator<o000o0000> it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            o000o0000 next = it.next();
            if (next != null) {
                next.O000000o(hResponse);
            }
        }
    }

    public void O000000o(final HgwBean hgwBean) {
        if (!this.O0000Oo) {
            L.e(O000000o, "addDev failure with transfer service null");
        } else {
            TuyaExecutor.getInstance().excutorDiscardOldestPolicy(new Runnable() {
                public void run() {
                    try {
                        if (o000oo0o0.this.O0000OoO != null) {
                            o000oo0o0.this.O0000OoO.addGw(hgwBean);
                        }
                    } catch (Exception e2) {
                        L.e(o000oo0o0.O000000o, e2.getMessage());
                    }
                }
            });
        }
    }

    public void O000000o(HgwBean hgwBean, boolean z) {
        Iterator<o000o0000> it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            o000o0000 next = it.next();
            if (next != null) {
                next.O000000o(hgwBean, z);
            }
        }
    }

    public void O000000o(o000o0000 o000o0000) {
        if (o000o0000 != null && !this.O0000OOo.contains(o000o0000)) {
            this.O0000OOo.add(o000o0000);
        }
    }

    public void O000000o(o000o000o o000o000o) {
        if (o000o000o != null && !this.O0000Oo0.contains(o000o000o)) {
            this.O0000Oo0.add(o000o000o);
        }
    }

    public void O000000o(final String str) {
        if (!this.O0000Oo) {
            L.d(O000000o, "service disconnected");
            return;
        }
        L.d(O000000o, "deleteDev: " + str);
        TuyaExecutor.getInstance().excutorDiscardOldestPolicy(new Runnable() {
            public void run() {
                try {
                    if (o000oo0o0.this.O0000OoO != null) {
                        o000oo0o0.this.O0000OoO.deleteGw(str);
                    }
                } catch (Exception e2) {
                    L.e(o000oo0o0.O000000o, e2.getMessage());
                }
            }
        });
    }

    public void O000000o(String str, int i, byte[] bArr, o000o00o0 o000o00o0) {
        if (!this.O0000Oo) {
            L.e(O000000o, "dev transfer is closed");
            if (o000o00o0 != null) {
                o000o00o0.O000000o("11005", "dev transfer is closed");
                return;
            }
            return;
        }
        final String str2 = str;
        final int i2 = i;
        final byte[] bArr2 = bArr;
        final o000o00o0 o000o00o02 = o000o00o0;
        TuyaExecutor.getInstance().excutorDiscardOldestPolicy(new Runnable() {
            public void run() {
                try {
                    if (o000oo0o0.this.O0000OoO != null) {
                        final boolean controlByBinary = o000oo0o0.this.O0000OoO.controlByBinary(str2, i2, bArr2);
                        if (o000o00o02 != null) {
                            o000oo0o0.this.O0000o0O.post(new Runnable() {
                                public void run() {
                                    if (controlByBinary) {
                                        L.d(o000oo0o0.O000000o, "hardware control success");
                                        o000o00o02.O000000o();
                                        return;
                                    }
                                    L.e(o000oo0o0.O000000o, "tcp control failure");
                                    o000o00o02.O000000o("11005", "tcp is not exist");
                                }
                            });
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    L.e(o000oo0o0.O000000o, e2.getMessage());
                }
            }
        });
    }

    public HgwBean O00000Oo(String str) {
        if (!this.O0000Oo) {
            L.d(O000000o, "service disconnected");
            return null;
        }
        try {
            if (this.O0000OoO != null) {
                return this.O0000OoO.getGw(str);
            }
        } catch (Exception e2) {
            L.e(O000000o, e2.getMessage());
        }
        return null;
    }

    public void O00000Oo(Context context) {
        L.d(O000000o, "stopService");
        O00000o0(context);
        this.O0000OOo.clear();
        this.O0000Oo0.clear();
        this.O0000Oo = false;
    }

    public void O00000Oo(o000o0000 o000o0000) {
        if (o000o0000 != null) {
            this.O0000OOo.remove(o000o0000);
        }
    }

    public void O00000Oo(o000o000o o000o000o) {
        if (o000o000o != null) {
            this.O0000Oo0.remove(o000o000o);
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                HgwBean hgwBean = (HgwBean) message.obj;
                StringBuilder n = a.n("gwOn: ");
                n.append(hgwBean.getGwId());
                L.d(O000000o, n.toString());
                O000000o(hgwBean, true);
                break;
            case 2:
                HgwBean hgwBean2 = (HgwBean) message.obj;
                StringBuilder n2 = a.n("gwOff: ");
                n2.append(hgwBean2.getGwId());
                L.d(O000000o, n2.toString());
                O000000o(hgwBean2, false);
                break;
            case 3:
                HResponse hResponse = (HResponse) message.obj;
                StringBuilder n3 = a.n("response devId:");
                n3.append(hResponse.getDevId());
                n3.append(";version: ");
                n3.append(hResponse.getVersion());
                n3.append(";data:");
                n3.append(hResponse.getDataBinary().length);
                n3.append(";type:");
                n3.append(hResponse.getType());
                n3.append(";code:");
                n3.append(hResponse.getCode());
                n3.append("; time=");
                n3.append(System.currentTimeMillis());
                L.d(O000000o, n3.toString());
                O000000o(hResponse);
                break;
            case 4:
                L.d(O000000o, "closeService");
                Context context = (Context) this.O0000o0.get();
                if (context != null) {
                    O00000o0(context);
                    break;
                }
                break;
            case 5:
                this.O0000Oo = false;
                L.d(O000000o, "onServiceDisconnected");
                Iterator<o000o000o> it = this.O0000Oo0.iterator();
                while (it.hasNext()) {
                    it.next().O00000Oo();
                }
                break;
            case 6:
                final IBinder iBinder = (IBinder) message.obj;
                TuyaExecutor.getInstance().excutorDiscardOldestPolicy(new Runnable() {
                    public void run() {
                        ITransferServiceAidlInterface unused = o000oo0o0.this.O0000OoO = ITransferServiceAidlInterface.Stub.asInterface(iBinder);
                        try {
                            o000oo0o0.this.O0000OoO.registerCallback(o000oo0o0.this.O0000o00);
                            Iterator it = o000oo0o0.this.O0000Oo0.iterator();
                            while (it.hasNext()) {
                                o000o000o o000o000o = (o000o000o) it.next();
                                if (o000o000o != null) {
                                    o000o000o.O000000o();
                                }
                            }
                            L.d(o000oo0o0.O000000o, "onServiceConnected");
                            boolean unused2 = o000oo0o0.this.O0000Oo = true;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                break;
        }
        return false;
    }
}
