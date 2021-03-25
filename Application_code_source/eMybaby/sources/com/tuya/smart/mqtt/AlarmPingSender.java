package com.tuya.smart.mqtt;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import e.b.a.a.a.c;
import e.b.a.a.a.g;
import e.b.a.a.a.n;
import e.b.a.a.a.r;
import e.b.a.a.a.t;
import e.b.a.a.a.u.a;

public class AlarmPingSender implements r {
    public static final String TAG = "AlarmPingSender";
    public BroadcastReceiver alarmReceiver;
    public a comms;
    public volatile boolean hasStarted = false;
    public PendingIntent pendingIntent;
    public MqttService service;
    public AlarmPingSender that;

    public class AlarmReceiver extends BroadcastReceiver {
        public final String wakeLockTag;
        public PowerManager.WakeLock wakelock;

        public AlarmReceiver() {
            StringBuilder n = a.a.a.a.a.n(MqttServiceConstants.PING_WAKELOCK);
            n.append(AlarmPingSender.this.that.comms.f5224a.getClientId());
            this.wakeLockTag = n.toString();
        }

        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            StringBuilder n = a.a.a.a.a.n("Sending Ping at:");
            n.append(System.currentTimeMillis());
            Log.d(AlarmPingSender.TAG, n.toString());
            PowerManager powerManager = (PowerManager) AlarmPingSender.this.service.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, this.wakeLockTag);
                this.wakelock = newWakeLock;
                newWakeLock.acquire(600000);
                a access$100 = AlarmPingSender.this.comms;
                AnonymousClass1 r4 = new c() {
                    public void onFailure(g gVar, Throwable th) {
                        StringBuilder n = a.a.a.a.a.n("Failure. Release lock(");
                        n.append(AlarmReceiver.this.wakeLockTag);
                        n.append("):");
                        n.append(System.currentTimeMillis());
                        Log.d(AlarmPingSender.TAG, n.toString());
                        AlarmReceiver.this.wakelock.release();
                    }

                    public void onSuccess(g gVar) {
                        StringBuilder n = a.a.a.a.a.n("Success. Release lock(");
                        n.append(AlarmReceiver.this.wakeLockTag);
                        n.append("):");
                        n.append(System.currentTimeMillis());
                        Log.d(AlarmPingSender.TAG, n.toString());
                        AlarmReceiver.this.wakelock.release();
                    }
                };
                t tVar = null;
                if (access$100 != null) {
                    try {
                        tVar = access$100.g.a(r4);
                    } catch (n | Exception e2) {
                        access$100.d(e2);
                    }
                    if (tVar == null && this.wakelock.isHeld()) {
                        this.wakelock.release();
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public AlarmPingSender(MqttService mqttService) {
        if (mqttService != null) {
            this.service = mqttService;
            this.that = this;
            return;
        }
        throw new IllegalArgumentException("Neither service nor client can be null.");
    }

    public void init(a aVar) {
        this.comms = aVar;
        this.alarmReceiver = new AlarmReceiver();
    }

    public void schedule(long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        Log.d(TAG, "Schedule next alarm at " + currentTimeMillis);
        AlarmManager alarmManager = (AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                Log.d(TAG, "Alarm scheule using setExactAndAllowWhileIdle, next: " + j);
                alarmManager.setExactAndAllowWhileIdle(0, currentTimeMillis, this.pendingIntent);
            } else if (i >= 19) {
                Log.d(TAG, "Alarm scheule using setExact, delay: " + j);
                alarmManager.setExact(0, currentTimeMillis, this.pendingIntent);
            } else {
                alarmManager.set(0, currentTimeMillis, this.pendingIntent);
            }
        }
    }

    public void start() {
        StringBuilder n = a.a.a.a.a.n(MqttServiceConstants.PING_SENDER);
        n.append(this.comms.f5224a.getClientId());
        String sb = n.toString();
        Log.d(TAG, "Register alarmreceiver to MqttService" + sb);
        this.service.registerReceiver(this.alarmReceiver, new IntentFilter(sb));
        this.pendingIntent = PendingIntent.getBroadcast(this.service, 0, new Intent(sb), 134217728);
        schedule(this.comms.g.h);
        this.hasStarted = true;
    }

    public void stop() {
        StringBuilder n = a.a.a.a.a.n("Unregister alarmreceiver to MqttService");
        n.append(this.comms.f5224a.getClientId());
        Log.d(TAG, n.toString());
        if (this.hasStarted) {
            if (this.pendingIntent != null) {
                AlarmManager alarmManager = (AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (alarmManager != null) {
                    alarmManager.cancel(this.pendingIntent);
                } else {
                    return;
                }
            }
            this.hasStarted = false;
            try {
                this.service.unregisterReceiver(this.alarmReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
