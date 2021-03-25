package com.tuya.smart.android.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tuya.smart.android.base.event.BaseEventSender;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;

public class NetworkBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "NetworkBroadcastReceive";
    public static boolean mRegisterReceiver = false;

    public static class InstanceHolder {
        public static final NetworkBroadcastReceiver INSTANCE = new NetworkBroadcastReceiver();
    }

    public static synchronized void registerReceiver(Context context) {
        synchronized (NetworkBroadcastReceiver.class) {
            if (mRegisterReceiver) {
                L.d(TAG, "receiver has registered");
                return;
            }
            mRegisterReceiver = true;
            context.registerReceiver(InstanceHolder.INSTANCE, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public static synchronized void unregisterReceiver(Context context) {
        synchronized (NetworkBroadcastReceiver.class) {
            if (!mRegisterReceiver) {
                L.d(TAG, "receiver is not registered");
                return;
            }
            mRegisterReceiver = false;
            context.unregisterReceiver(InstanceHolder.INSTANCE);
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            BaseEventSender.sendNetworkStatus(NetworkUtil.isNetworkAvailable(context));
        }
    }
}
