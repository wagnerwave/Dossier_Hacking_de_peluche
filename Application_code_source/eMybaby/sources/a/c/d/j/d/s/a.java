package a.c.d.j.d.s;

import a.c.d.j.d.g;
import a.c.d.j.d.q;
import a.c.d.j.d.r;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.sozpic.miniland.R;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.enums.ModeEnum;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.sdk.api.IDevListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDevice;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a extends BasePresenter implements IDevListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f267a;

    /* renamed from: b  reason: collision with root package name */
    public r f268b;

    /* renamed from: c  reason: collision with root package name */
    public String f269c;

    /* renamed from: d  reason: collision with root package name */
    public DeviceBean f270d;

    /* renamed from: e  reason: collision with root package name */
    public ITuyaDevice f271e;
    public c f;

    /* renamed from: a.c.d.j.d.s.a$a  reason: collision with other inner class name */
    public class C0014a implements IResultCallback {
        public C0014a() {
        }

        public void onError(String str, String str2) {
            c cVar = a.this.f;
            cVar.f274a = 2;
            cVar.g = String.format("%s %s", new Object[]{a.c.a.d.a.h(R.string.TR_SEND_FAILURE), str2});
            a.this.f.countDown();
        }

        public void onSuccess() {
            Log.i("CommonDeviceDebugPrese", "onSuccess");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                if (!a.this.f.f.equals(oOO0O0O0.O0000oO0)) {
                    a.this.f.await(10, TimeUnit.SECONDS);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            c cVar = a.this.f;
            if (cVar != null) {
                cVar.f276c = System.currentTimeMillis();
                a aVar = a.this;
                c cVar2 = aVar.f;
                int i = cVar2.f274a;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            cVar2.g = a.c.a.d.a.h(R.string.TR_SEND_TIME_OUT);
                            a aVar2 = a.this;
                            r rVar = aVar2.f268b;
                            aVar2.f.a();
                            if (((DeviceControlActivity) rVar) == null) {
                                throw null;
                            }
                        }
                    } else if (((DeviceControlActivity) aVar.f268b) == null) {
                        throw null;
                    }
                } else if (((DeviceControlActivity) aVar.f268b) == null) {
                    throw null;
                }
                a.this.f = null;
            }
        }
    }

    public static class c extends CountDownLatch {

        /* renamed from: a  reason: collision with root package name */
        public int f274a = 3;

        /* renamed from: b  reason: collision with root package name */
        public long f275b;

        /* renamed from: c  reason: collision with root package name */
        public long f276c;

        /* renamed from: d  reason: collision with root package name */
        public String f277d;

        /* renamed from: e  reason: collision with root package name */
        public String f278e;
        public String f;
        public String g;

        public c(int i) {
            super(i);
        }

        public q a() {
            return new q(this.f275b, this.f276c, this.f277d, this.f278e, this.g);
        }
    }

    public a(Context context, r rVar) {
        this.f267a = context;
        this.f268b = rVar;
        this.f269c = ((Activity) context).getIntent().getStringExtra("intent_devId");
        DeviceBean deviceBean = TuyaHomeSdk.getDataInstance().getDeviceBean(this.f269c);
        this.f270d = deviceBean;
        if (deviceBean == null) {
            ((Activity) this.f267a).finish();
        }
        ITuyaDevice newDeviceInstance = TuyaHomeSdk.newDeviceInstance(this.f269c);
        this.f271e = newDeviceInstance;
        newDeviceInstance.registerDevListener(this);
    }

    public void a(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        b(str, hashMap);
    }

    public void b(String str, HashMap<String, Object> hashMap) {
        if (this.f == null) {
            this.f = new c(1);
            String jSONString = JSON.toJSONString(hashMap);
            c cVar = this.f;
            cVar.f277d = jSONString;
            cVar.f275b = System.currentTimeMillis();
            this.f.f = str;
            this.f271e.publishDps(jSONString, new C0014a());
            new Thread(new b()).start();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f;
        if (cVar != null) {
            cVar.countDown();
        }
        ITuyaDevice iTuyaDevice = this.f271e;
        if (iTuyaDevice != null) {
            iTuyaDevice.onDestroy();
        }
    }

    public void onDevInfoUpdate(String str) {
        DeviceControlActivity deviceControlActivity = (DeviceControlActivity) this.f268b;
        DeviceBean deviceBean = deviceControlActivity.n.f270d;
        deviceControlActivity.r(deviceBean == null ? "" : deviceBean.getName());
    }

    public void onDpUpdate(String str, String str2) {
        Object obj;
        SchemaBean schemaBean;
        DeviceControlActivity deviceControlActivity = (DeviceControlActivity) this.f268b;
        if (deviceControlActivity != null) {
            deviceControlActivity.x(JSON.parseObject(str2));
            DeviceBean deviceBean = TuyaHomeSdk.getDataInstance().getDeviceBean(str);
            if (deviceBean == null || !deviceBean.getIsLocalOnline().booleanValue()) {
            }
            if (((DeviceControlActivity) this.f268b) != null) {
                JSONObject parseObject = JSON.parseObject(str2);
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, Object> key : parseObject.entrySet()) {
                    String str3 = (String) key.getKey();
                    Map<String, SchemaBean> schema = TuyaHomeSdk.getDataInstance().getSchema(str);
                    if (!(schema == null || (schemaBean = schema.get(str3)) == null || !TextUtils.equals(schemaBean.getMode(), ModeEnum.RO.getType()))) {
                        arrayList.add(str3);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    parseObject.remove((String) it.next());
                }
                c cVar = this.f;
                if (cVar != null && cVar.getCount() > 0 && !parseObject.isEmpty() && (obj = parseObject.get(this.f.f)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(this.f.f, obj);
                    if (TextUtils.equals(JSON.toJSONString(hashMap), this.f.f277d)) {
                        this.f.f274a = 1;
                    } else {
                        this.f.f274a = 2;
                    }
                    c cVar2 = this.f;
                    cVar2.f278e = str2;
                    cVar2.countDown();
                    return;
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    public void onNetworkStatusChanged(String str, boolean z) {
        DeviceControlActivity deviceControlActivity = (DeviceControlActivity) this.f268b;
        if (z) {
            deviceControlActivity.h.setVisibility(8);
            return;
        }
        deviceControlActivity.h.setVisibility(0);
        deviceControlActivity.i.setText(a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION));
    }

    public void onRemoved(String str) {
        DeviceControlActivity deviceControlActivity = (DeviceControlActivity) this.f268b;
        if (deviceControlActivity != null) {
            String h = a.c.a.d.a.h(R.string.TR_DEVICE_UNBINDED);
            a.c.d.j.b.f.a aVar = new a.c.d.j.b.f.a(new g(deviceControlActivity));
            AlertDialog.Builder builder = new AlertDialog.Builder(deviceControlActivity, 2131886313);
            builder.setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_CONFIRM), (DialogInterface.OnClickListener) aVar);
            builder.setMessage((CharSequence) h);
            builder.setCancelable(false);
            builder.create().show();
            return;
        }
        throw null;
    }

    public void onStatusChanged(String str, boolean z) {
        DeviceControlActivity deviceControlActivity = (DeviceControlActivity) this.f268b;
        if (z) {
            deviceControlActivity.h.setVisibility(8);
            return;
        }
        deviceControlActivity.h.setVisibility(0);
        deviceControlActivity.i.setText(a.c.a.d.a.h(R.string.TR_DEVICE_OFFLINE));
    }
}
