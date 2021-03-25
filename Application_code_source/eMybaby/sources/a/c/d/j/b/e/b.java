package a.c.d.j.b.e;

import a.c.d.j.b.d.e;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.alibaba.fastjson.JSON;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.tuya.smart.android.base.event.NetWorkStatusEvent;
import com.tuya.smart.android.base.event.NetWorkStatusEventModel;
import com.tuya.smart.android.base.utils.PreferencesUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.home.sdk.api.ITuyaHomeStatusListener;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

public class b extends BasePresenter implements NetWorkStatusEvent {

    /* renamed from: a  reason: collision with root package name */
    public Activity f190a;

    /* renamed from: b  reason: collision with root package name */
    public a.c.d.j.b.g.a f191b;

    public class a implements ITuyaGetHomeListCallback {

        /* renamed from: a.c.d.j.b.e.b$a$a  reason: collision with other inner class name */
        public class C0011a implements ITuyaHomeResultCallback {
            public C0011a() {
            }

            public void onError(String str, String str2) {
                Log.e("DeviceListFragmentPr", "onError");
            }

            public void onSuccess(HomeBean homeBean) {
                b.b(b.this, homeBean.getDeviceList());
                Log.e("DeviceListFragmentPr", "onSuccess");
            }
        }

        /* renamed from: a.c.d.j.b.e.b$a$b  reason: collision with other inner class name */
        public class C0012b implements ITuyaHomeStatusListener {
            public C0012b(a aVar) {
            }

            public void onDeviceAdded(String str) {
                int i;
                Log.e("DeviceListFragmentPr", "onDeviceAdded");
                HashMap<String, Integer> s = a.c.d.a.l().s();
                if (!s.containsKey(str)) {
                    if (s.isEmpty()) {
                        i = 1;
                    } else {
                        Integer num = -1;
                        for (Integer next : s.values()) {
                            if (next.intValue() > num.intValue()) {
                                num = next;
                            }
                        }
                        i = Integer.valueOf(num.intValue() + 1);
                    }
                    s.put(str, i);
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(AppMiniland.f().getCacheDir().getAbsolutePath() + "/HumidifyDevices.dat"));
                        objectOutputStream.writeObject(s);
                        objectOutputStream.close();
                    } catch (Exception unused) {
                    }
                }
            }

            public void onDeviceRemoved(String str) {
                Log.e("DeviceListFragmentPr", "onDeviceRemoved");
                a.c.d.a.l().s().remove(str);
            }

            public void onGroupAdded(long j) {
                Log.e("DeviceListFragmentPr", "onGroupAdded");
            }

            public void onGroupRemoved(long j) {
                Log.e("DeviceListFragmentPr", "onGroupRemoved");
            }

            public void onMeshAdded(String str) {
                a.a.a.a.a.v("onMeshAdded: ", str, "DeviceListFragmentPr");
            }
        }

        public class c implements ITuyaHomeResultCallback {
            public c() {
            }

            public void onError(String str, String str2) {
                Log.e("DeviceListFragmentPr", "onError onError");
            }

            public void onSuccess(HomeBean homeBean) {
                L.d("DeviceListFragmentPr", JSON.toJSONString(homeBean));
                b.b(b.this, homeBean.getDeviceList());
            }
        }

        public a() {
        }

        public void onError(String str, String str2) {
            TuyaHomeSdk.newHomeInstance(a.c.d.j.b.c.a.f171a).getHomeLocalCache(new c());
        }

        public void onSuccess(List<HomeBean> list) {
            if (list.size() != 0) {
                long homeId = list.get(0).getHomeId();
                a.c.d.j.b.c.a.f171a = homeId;
                PreferencesUtil.set("homeId", homeId);
                TuyaHomeSdk.newHomeInstance(homeId).getHomeDetail(new C0011a());
                TuyaHomeSdk.newHomeInstance(homeId).registerHomeStatusListener(new C0012b(this));
            } else if (((e) b.this.f191b) == null) {
                throw null;
            }
        }
    }

    public b(e eVar, a.c.d.j.b.g.a aVar) {
        this.f190a = eVar.getActivity();
        this.f191b = aVar;
        TuyaSdk.getEventBus().register(this);
        a.c.d.j.b.c.a.f171a = PreferencesUtil.getLong("homeId", a.c.d.j.b.c.a.f171a);
    }

    public static void a(b bVar, DeviceBean deviceBean) {
        a.c.a.f.b.n0(bVar.f190a, R.string.TR_LOADING);
        TuyaHomeSdk.newDeviceInstance(deviceBean.getDevId()).removeDevice(new e(bVar));
    }

    public static void b(b bVar, List list) {
        if (bVar != null) {
            if (list.size() == 0) {
                e eVar = (e) bVar.f191b;
                a.c.d.j.b.a.b.setViewGone(eVar.f181e);
                a.c.d.j.b.a.b.setViewVisible(eVar.h);
            } else {
                e eVar2 = (e) bVar.f191b;
                a.c.d.j.b.a.b.setViewVisible(eVar2.f181e);
                a.c.d.j.b.a.b.setViewGone(eVar2.h);
                a.c.d.j.d.a aVar = ((e) bVar.f191b).f180d;
                if (aVar != null) {
                    aVar.f248b = a.c.d.a.l().s();
                    aVar.f247a.clear();
                    aVar.f247a.addAll(list);
                    aVar.notifyDataSetChanged();
                }
            }
            ((e) bVar.f191b).o();
            return;
        }
        throw null;
    }

    public void c() {
        TuyaHomeSdk.getHomeManagerInstance().queryHomeList(new a());
    }

    public void onDestroy() {
        super.onDestroy();
        TuyaSdk.getEventBus().unregister(this);
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        if (netWorkStatusEventModel.isAvailable()) {
            e eVar = (e) this.f191b;
            if (eVar.f.getVisibility() != 8) {
                View view = eVar.g;
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) eVar.f.getHeight(), 0.0f);
                translateAnimation.setDuration(300);
                translateAnimation.setFillAfter(false);
                translateAnimation.setAnimationListener((Animation.AnimationListener) null);
                view.startAnimation(translateAnimation);
                eVar.f.setVisibility(8);
                return;
            }
            return;
        }
        e eVar2 = (e) this.f191b;
        eVar2.f.setText(a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION));
        if (eVar2.f.getVisibility() != 0) {
            View view2 = eVar2.g;
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, (float) (-eVar2.f.getHeight()), 0.0f);
            translateAnimation2.setDuration(300);
            translateAnimation2.setFillAfter(false);
            translateAnimation2.setAnimationListener((Animation.AnimationListener) null);
            view2.startAnimation(translateAnimation2);
            eVar2.f.setVisibility(0);
        }
    }
}
