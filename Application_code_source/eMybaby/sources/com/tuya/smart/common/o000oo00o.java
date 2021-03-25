package com.tuya.smart.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.hardware.IUDPBroadcastAidlInterface;
import com.tuya.smart.android.hardware.IUDPMonitorAidlInterface;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class o000oo00o {
    public static final String O000000o = "GwBroadcastMonitorModel";
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    public static final int O00000oO = 4;
    public static final int O00000oo = 5;
    public volatile Timer O0000O0o;
    public CopyOnWriteArrayList<o0000oooo> O0000OOo = new CopyOnWriteArrayList<>();
    public IUDPMonitorAidlInterface O0000Oo = new IUDPMonitorAidlInterface.Stub() {
        public void closeService() {
            o000oo00o.this.O0000OoO.sendEmptyMessage(5);
        }

        public String getAppId() {
            Context context = (Context) o000oo00o.this.O0000o00.get();
            if (context != null) {
                return context.getPackageName();
            }
            return null;
        }

        public void update(List<HgwBean> list) {
            Message obtain = Message.obtain();
            obtain.obj = list;
            obtain.what = 2;
            o000oo00o.this.O0000OoO.sendMessage(obtain);
        }
    };
    public volatile IUDPBroadcastAidlInterface O0000Oo0;
    public final Handler O0000OoO = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                L.d(o000oo00o.O000000o, "add");
                o000oo00o.this.O000000o(message);
            } else if (i == 2) {
                L.d(o000oo00o.O000000o, "update");
                o000oo00o.this.O00000o0(message);
            } else if (i == 3) {
                L.d(o000oo00o.O000000o, "del");
                o000oo00o.this.O00000Oo(message);
            } else if (i == 4) {
                L.d(o000oo00o.O000000o, "service_connect");
                final IBinder iBinder = (IBinder) message.obj;
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        o000oo00o.this.O000000o(iBinder);
                    }
                });
            } else if (i == 5) {
                L.d(o000oo00o.O000000o, "close_service");
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        o000oo00o o000oo00o = o000oo00o.this;
                        o000oo00o.O00000o0((Context) o000oo00o.O0000o00.get());
                    }
                });
            }
            return true;
        }
    });
    public final ServiceConnection O0000Ooo = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            L.d(o000oo00o.O000000o, "onServiceConnected ");
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = iBinder;
            o000oo00o.this.O0000OoO.sendMessage(obtain);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            L.d(o000oo00o.O000000o, "onServiceDisconnected ");
            IUDPBroadcastAidlInterface unused = o000oo00o.this.O0000Oo0 = null;
        }
    };
    public WeakReference<Context> O0000o00;

    private Intent O000000o() {
        Intent intent = new Intent();
        intent.setAction(o000o0o0o.O0000Oo);
        intent.addCategory("tuya");
        return TuyaUtil.getExplicitIntent((Context) this.O0000o00.get(), intent, GwBroadcastMonitorService.class.getName());
    }

    /* access modifiers changed from: private */
    public void O000000o(IBinder iBinder) {
        this.O0000Oo0 = IUDPBroadcastAidlInterface.Stub.asInterface(iBinder);
        try {
            this.O0000Oo0.registerCallback(this.O0000Oo);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        O00000o0();
    }

    /* access modifiers changed from: private */
    public void O000000o(Message message) {
        this.O0000OOo.add((o0000oooo) message.obj);
    }

    private String O00000Oo() {
        if (this.O0000Oo0 == null) {
            return null;
        }
        try {
            return this.O0000Oo0.getServiceVersion();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(Message message) {
        this.O0000OOo.remove((o0000oooo) message.obj);
    }

    private void O00000o() {
        if (this.O0000Oo0 != null) {
            try {
                this.O0000Oo0.closeService();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void O00000o0() {
        if (this.O0000Oo0 != null) {
            String O00000Oo2 = O00000Oo();
            if (TuyaUtil.checkServiceVersion(O00000Oo2, GwBroadcastMonitorService.mVersion)) {
                L.d(O000000o, String.format("the run service version %s is low", new Object[]{O00000Oo2}));
                O00000o();
                if (this.O0000O0o == null) {
                    this.O0000O0o = new Timer();
                }
                this.O0000O0o.schedule(new TimerTask() {
                    public void run() {
                        o000oo00o o000oo00o = o000oo00o.this;
                        o000oo00o.O000000o((Context) o000oo00o.O0000o00.get());
                    }
                }, 5000);
                return;
            }
            L.d(O000000o, String.format("the run service version %s is ok", new Object[]{O00000Oo2}));
        }
    }

    /* access modifiers changed from: private */
    public void O00000o0(Context context) {
        L.d(O000000o, "closeMonitor");
        if (context != null && this.O0000Oo0 != null) {
            try {
                this.O0000Oo0.unRegisterCallback(context.getPackageName());
                context.unbindService(this.O0000Ooo);
            } catch (Exception e2) {
                L.e(O000000o, "unbindService exception");
                e2.printStackTrace();
            }
            try {
                Intent O000000o2 = O000000o();
                if (O000000o2 != null) {
                    context.stopService(O000000o2);
                }
            } catch (Exception e3) {
                L.e(O000000o, "stopService exception");
                e3.printStackTrace();
            }
            this.O0000Oo0 = null;
        }
    }

    /* access modifiers changed from: private */
    public void O00000o0(Message message) {
        Iterator<o0000oooo> it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            it.next().O000000o((List) message.obj);
        }
    }

    public void O000000o(Context context) {
        L.d(O000000o, "try to startMonitor service");
        if (context != null) {
            try {
                if (this.O0000Oo0 == null) {
                    this.O0000o00 = new WeakReference<>(context);
                    Intent O000000o2 = O000000o();
                    if (O000000o2 == null) {
                        O000000o2 = new Intent(context, GwBroadcastMonitorService.class);
                        O000000o2.setAction(o000o0o0o.O0000Oo);
                        O000000o2.addCategory("tuya");
                        if (!TuyaUtil.isAppForeground(context)) {
                            L.d(O000000o, "startService in background");
                            O000000o2.putExtra(o000o0ooo.O000000o, false);
                            o00o00ooo.O000000o(context, O000000o2);
                        } else {
                            L.d(O000000o, "startService in foreground");
                            O000000o2.putExtra(o000o0ooo.O000000o, true);
                            context.startService(O000000o2);
                        }
                    }
                    context.bindService(O000000o2, this.O0000Ooo, 1);
                    return;
                }
                L.d(O000000o, "service started");
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void O000000o(o0000oooo o0000oooo) {
        if (o0000oooo != null && !this.O0000OOo.contains(o0000oooo)) {
            this.O0000OOo.add(o0000oooo);
        }
        Message obtain = Message.obtain();
        obtain.obj = o0000oooo;
        obtain.what = 1;
        this.O0000OoO.sendMessage(obtain);
    }

    public void O00000Oo(Context context) {
        O00000o0(context);
        this.O0000Oo0 = null;
        if (this.O0000O0o != null) {
            this.O0000O0o.cancel();
            this.O0000O0o = null;
        }
    }

    public void O00000Oo(o0000oooo o0000oooo) {
        if (o0000oooo != null) {
            this.O0000OOo.remove(o0000oooo);
        }
        Message obtain = Message.obtain();
        obtain.obj = o0000oooo;
        obtain.what = 3;
        this.O0000OoO.sendMessage(obtain);
    }
}
