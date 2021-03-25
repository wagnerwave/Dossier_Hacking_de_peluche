package a.c.d.j.c;

import a.c.d.j.b.a.b;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import com.cuatroochenta.miniland.humidificador.config.ECActivity;
import com.cuatroochenta.miniland.humidificador.config.ECBindActivity;
import com.sozpic.miniland.R;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.android.mvp.presenter.BasePresenter;

public class h extends BasePresenter {

    /* renamed from: a  reason: collision with root package name */
    public final int f238a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f239b;

    /* renamed from: c  reason: collision with root package name */
    public l f240c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f241d = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                h.this.b();
            }
        }
    }

    public h(Activity activity, l lVar) {
        this.f239b = activity;
        this.f240c = lVar;
        this.f238a = activity.getIntent().getIntExtra("config_mode", 1);
        try {
            this.f239b.registerReceiver(this.f241d, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean d(String str, Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService(NetworkUtil.CONN_TYPE_WIFI)).getConnectionInfo();
        if (connectionInfo == null || Build.VERSION.SDK_INT < 21) {
            return str.toUpperCase().endsWith("5G");
        }
        int frequency = connectionInfo.getFrequency();
        return frequency > 4900 && frequency < 5900;
    }

    public boolean a(String str, int i) {
        int i2;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        try {
            i2 = this.f239b.getPackageManager().getPackageInfo(this.f239b.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (Build.VERSION.SDK_INT < 23 || (i2 < 23 ? PermissionChecker.checkSelfPermission(this.f239b, str) == 0 : ContextCompat.checkSelfPermission(this.f239b, str) == 0)) {
            return true;
        }
        ActivityCompat.requestPermissions(this.f239b, new String[]{str}, i);
        return false;
    }

    public void b() {
        if (NetworkUtil.isNetworkAvailable(this.f239b)) {
            String currentSSID = WiFiUtil.getCurrentSSID((Context) this.f239b);
            if (!TextUtils.isEmpty(currentSSID)) {
                ECActivity eCActivity = (ECActivity) this.f240c;
                b.setViewVisible(eCActivity.g);
                eCActivity.j.setColorFilter(eCActivity.o);
                eCActivity.k.setText(a.c.a.d.a.h(R.string.TR_CONNECTED_WIFI));
                eCActivity.g.setText(currentSSID);
                if (d(currentSSID, this.f239b)) {
                    b.setViewVisible(((ECActivity) this.f240c).p);
                    return;
                } else {
                    b.setViewGone(((ECActivity) this.f240c).p);
                    return;
                }
            }
        }
        ECActivity eCActivity2 = (ECActivity) this.f240c;
        b.setViewGone(eCActivity2.g);
        b.setViewGone(eCActivity2.p);
        eCActivity2.h.setText("");
        eCActivity2.j.setColorFilter(-7829368);
        eCActivity2.k.setText(a.c.a.d.a.h(R.string.TR_NO_WI_FI_NETWORK_FOUND));
    }

    public final void c(String str, String str2) {
        Intent intent = new Intent(this.f239b, ECBindActivity.class);
        intent.putExtra("config_password", str2);
        intent.putExtra("config_ssid", str);
        intent.putExtra("config_mode", this.f238a);
        a.c.a.f.b.w0(this.f239b, intent, 0, true);
    }

    public void e() {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        if (intent.resolveActivity(this.f239b.getPackageManager()) == null) {
            intent = new Intent("android.settings.WIFI_SETTINGS");
            if (intent.resolveActivity(this.f239b.getPackageManager()) == null) {
                return;
            }
        }
        this.f239b.startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f241d != null) {
                this.f239b.unregisterReceiver(this.f241d);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
