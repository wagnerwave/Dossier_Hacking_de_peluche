package a.c.d.j.c;

import a.c.a.d.a;
import a.c.d.j.b.a.b;
import a.c.d.j.e.c;
import android.app.Activity;
import android.content.Context;
import com.cuatroochenta.miniland.humidificador.config.ECBindActivity;
import com.sozpic.miniland.R;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.sdk.api.ITuyaActivator;

public class g extends BasePresenter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f233a;

    /* renamed from: b  reason: collision with root package name */
    public final k f234b;

    /* renamed from: c  reason: collision with root package name */
    public final int f235c;

    /* renamed from: d  reason: collision with root package name */
    public int f236d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f237e;
    public c f;
    public final String g = ((Activity) this.f233a).getIntent().getStringExtra("config_password");
    public final String h = ((Activity) this.f233a).getIntent().getStringExtra("config_ssid");
    public boolean i;

    public g(Context context, k kVar) {
        super(context);
        this.f233a = context;
        this.f234b = kVar;
        this.f235c = ((Activity) context).getIntent().getIntExtra("config_mode", 1);
        this.f = new c(context, this.mHandler);
        if (this.f235c == 1) {
            b.setViewGone(((ECBindActivity) this.f234b).s);
        } else {
            ECBindActivity eCBindActivity = (ECBindActivity) this.f234b;
            b.setViewGone(eCBindActivity.i);
            b.setViewGone(eCBindActivity.j);
            b.setViewGone(eCBindActivity.k);
            b.setViewGone(eCBindActivity.n);
            b.setViewGone(eCBindActivity.r);
            b.setViewGone(eCBindActivity.m);
            b.setViewVisible(((ECBindActivity) this.f234b).s);
        }
        a.c.a.f.b.n0(this.f233a, R.string.TR_LOADING);
        HomeBean a2 = c.b().a();
        TuyaHomeSdk.getActivatorInstance().getActivatorToken(a2 == null ? -1 : a2.getHomeId(), new f(this));
    }

    public void a() {
        ITuyaActivator iTuyaActivator = this.f.f228a;
        if (iTuyaActivator != null) {
            iTuyaActivator.start();
        }
        ECBindActivity eCBindActivity = (ECBindActivity) this.f234b;
        if (eCBindActivity != null) {
            eCBindActivity.r(a.h(R.string.TR_CONNECTING_DEVICE));
            b.setViewVisible(eCBindActivity.i);
            b.setViewGone(eCBindActivity.m);
            b.setViewGone(eCBindActivity.k);
            this.i = false;
            this.f236d = 0;
            this.f237e = false;
            this.mHandler.sendEmptyMessage(22);
            return;
        }
        throw null;
    }

    public final void b() {
        this.f237e = true;
        this.mHandler.removeMessages(22);
        ITuyaActivator iTuyaActivator = this.f.f228a;
        if (iTuyaActivator != null) {
            iTuyaActivator.stop();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ea, code lost:
        r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r7.f234b;
        a.c.d.j.b.a.b.setViewVisible(r0.n);
        a.c.d.j.b.a.b.setViewVisible(r0.j);
        a.c.d.j.b.a.b.setViewGone(r0.i);
        a.c.d.j.b.a.b.setViewVisible(r0.r);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            int r0 = r8.what
            r1 = 2
            r2 = 1000(0x3e8, double:4.94E-321)
            r4 = 22
            if (r0 == r4) goto L_0x011f
            r4 = 1001(0x3e9, float:1.403E-42)
            if (r0 == r4) goto L_0x010b
            r5 = 0
            java.lang.String r6 = "ECBindPresenter"
            switch(r0) {
                case 2: goto L_0x00de;
                case 3: goto L_0x00b1;
                case 4: goto L_0x008a;
                case 5: goto L_0x00b1;
                case 6: goto L_0x0072;
                case 7: goto L_0x0056;
                case 8: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0157
        L_0x0015:
            java.lang.String r0 = "bind_device_success"
            com.tuya.smart.android.common.utils.L.d(r6, r0)
            java.lang.Object r0 = r8.obj
            com.tuya.smart.android.mvp.bean.Result r0 = (com.tuya.smart.android.mvp.bean.Result) r0
            java.lang.Object r0 = r0.getObj()
            com.tuya.smart.interior.device.bean.GwDevResp r0 = (com.tuya.smart.interior.device.bean.GwDevResp) r0
            java.lang.String r0 = r0.getName()
            boolean r2 = r7.f237e
            if (r2 != 0) goto L_0x0157
            r2 = 1
            r7.i = r2
            a.c.d.j.c.k r3 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r3 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r3
            android.widget.TextView r3 = r3.l
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r4 = 0
            r1[r4] = r0
            java.lang.CharSequence r0 = r3.getText()
            java.lang.String r0 = r0.toString()
            r1[r2] = r0
            java.lang.String r0 = "%s%s"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r3.setText(r0)
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            if (r0 == 0) goto L_0x0055
            goto L_0x0157
        L_0x0055:
            throw r5
        L_0x0056:
            java.lang.String r0 = "device_find"
            com.tuya.smart.android.common.utils.L.d(r6, r0)
            java.lang.Object r0 = r8.obj
            com.tuya.smart.android.mvp.bean.Result r0 = (com.tuya.smart.android.mvp.bean.Result) r0
            java.lang.Object r0 = r0.getObj()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r7.f237e
            if (r0 != 0) goto L_0x0157
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            if (r0 == 0) goto L_0x0071
            goto L_0x0157
        L_0x0071:
            throw r5
        L_0x0072:
            r7.b()
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            r0.u()
            android.widget.TextView r0 = r0.q
            r1 = 2131821174(0x7f110276, float:1.9275084E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            goto L_0x0157
        L_0x008a:
            java.lang.String r0 = "ap_active_error"
            com.tuya.smart.android.common.utils.L.d(r6, r0)
            r7.b()
            boolean r0 = r7.i
            if (r0 == 0) goto L_0x0097
            goto L_0x00ea
        L_0x0097:
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            r0.u()
            android.content.Context r0 = r7.f233a
            java.lang.String r0 = com.tuya.smart.android.device.utils.WiFiUtil.getCurrentSSID((android.content.Context) r0)
            boolean r1 = a.c.a.f.b.L()
            if (r1 == 0) goto L_0x0157
            android.content.Context r1 = r7.f233a
            com.tuya.smart.android.device.utils.WiFiUtil.removeNetwork(r1, r0)
            goto L_0x0157
        L_0x00b1:
            java.lang.String r0 = "active_success"
            com.tuya.smart.android.common.utils.L.d(r6, r0)
            java.lang.Object r0 = r8.obj
            com.tuya.smart.android.mvp.bean.Result r0 = (com.tuya.smart.android.mvp.bean.Result) r0
            java.lang.Object r0 = r0.getObj()
            com.tuya.smart.sdk.bean.DeviceBean r0 = (com.tuya.smart.sdk.bean.DeviceBean) r0
            r7.b()
            r7.b()
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            if (r0 == 0) goto L_0x00dd
            r1 = 1120403456(0x42c80000, float:100.0)
            r5 = 800(0x320, float:1.121E-42)
            com.cuatroochenta.miniland.humidificador.base.widget.circleprogress.CircleProgressView r0 = r0.g
            long r5 = (long) r5
            r0.k(r1, r5)
            com.tuya.smart.android.common.utils.SafeHandler r0 = r7.mHandler
            r0.sendEmptyMessageDelayed(r4, r2)
            goto L_0x0157
        L_0x00dd:
            throw r5
        L_0x00de:
            java.lang.String r0 = "ec_active_error"
            com.tuya.smart.android.common.utils.L.d(r6, r0)
            r7.b()
            boolean r0 = r7.i
            if (r0 == 0) goto L_0x0103
        L_0x00ea:
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            android.widget.LinearLayout r1 = r0.n
            a.c.d.j.b.a.b.setViewVisible(r1)
            android.widget.TextView r1 = r0.j
            a.c.d.j.b.a.b.setViewVisible(r1)
            android.widget.LinearLayout r1 = r0.i
            a.c.d.j.b.a.b.setViewGone(r1)
            android.widget.TextView r0 = r0.r
            a.c.d.j.b.a.b.setViewVisible(r0)
            goto L_0x0157
        L_0x0103:
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            r0.u()
            goto L_0x0157
        L_0x010b:
            a.c.d.j.c.k r0 = r7.f234b
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r0 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r0
            android.widget.LinearLayout r1 = r0.n
            a.c.d.j.b.a.b.setViewVisible(r1)
            android.widget.TextView r1 = r0.j
            a.c.d.j.b.a.b.setViewVisible(r1)
            android.widget.LinearLayout r0 = r0.i
            a.c.d.j.b.a.b.setViewGone(r0)
            goto L_0x0157
        L_0x011f:
            boolean r0 = r7.f237e
            if (r0 == 0) goto L_0x0124
            goto L_0x0157
        L_0x0124:
            int r0 = r7.f236d
            r5 = 100
            if (r0 < r5) goto L_0x0141
            r7.b()
            a.c.d.j.c.c r0 = r7.f
            com.tuya.smart.sdk.enums.ActivatorModelEnum r2 = r0.f229b
            if (r2 != 0) goto L_0x0134
            goto L_0x0157
        L_0x0134:
            com.tuya.smart.sdk.enums.ActivatorModelEnum r3 = com.tuya.smart.sdk.enums.ActivatorModelEnum.TY_AP
            if (r2 != r3) goto L_0x0139
            r1 = 4
        L_0x0139:
            java.lang.String r2 = "TIME_ERROR"
            java.lang.String r3 = "OutOfTime"
            r0.resultError(r1, r2, r3)
            goto L_0x0157
        L_0x0141:
            a.c.d.j.c.k r1 = r7.f234b
            int r5 = r0 + 1
            r7.f236d = r5
            float r0 = (float) r0
            r5 = 1000(0x3e8, float:1.401E-42)
            com.cuatroochenta.miniland.humidificador.config.ECBindActivity r1 = (com.cuatroochenta.miniland.humidificador.config.ECBindActivity) r1
            com.cuatroochenta.miniland.humidificador.base.widget.circleprogress.CircleProgressView r1 = r1.g
            long r5 = (long) r5
            r1.k(r0, r5)
            com.tuya.smart.android.common.utils.SafeHandler r0 = r7.mHandler
            r0.sendEmptyMessageDelayed(r4, r2)
        L_0x0157:
            boolean r8 = super.handleMessage(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.j.c.g.handleMessage(android.os.Message):boolean");
    }

    public void onDestroy() {
        this.mHandler.removeMessages(22);
        this.mHandler.removeMessages(1001);
        this.f.onDestroy();
        super.onDestroy();
    }
}
