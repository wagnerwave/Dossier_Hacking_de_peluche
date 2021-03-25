package a.c.d.j.b.d;

import a.c.d.j.e.f.c;
import a.c.d.j.e.f.d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.sozpic.miniland.R;
import com.tuya.smart.android.base.BaseConfig;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import java.util.ArrayList;
import java.util.List;

public class e extends Fragment implements a.c.d.j.b.g.a, a.c.d.j.f.a, a.c.d.j.e.d.a {
    public static volatile e m;

    /* renamed from: a  reason: collision with root package name */
    public View f177a;

    /* renamed from: b  reason: collision with root package name */
    public a.c.d.j.b.e.b f178b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeRefreshLayout f179c;

    /* renamed from: d  reason: collision with root package name */
    public a.c.d.j.d.a f180d;

    /* renamed from: e  reason: collision with root package name */
    public ListView f181e;
    public TextView f;
    public View g;
    public View h;
    public a.c.d.j.f.b.b i;
    public a.c.d.j.e.g.b j;
    public d k;
    public final BroadcastReceiver l = new b();

    public class a implements ITuyaGetHomeListCallback {
        public a() {
        }

        public void onError(String str, String str2) {
            Log.e("DeviceListFrag", str + " " + str2);
        }

        public void onSuccess(List<HomeBean> list) {
            if (a.c.a.f.b.R(list)) {
                e eVar = e.this;
                if (eVar != null) {
                    eVar.j = new a.c.d.j.e.g.b(eVar);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("room");
                    a.c.d.j.e.g.b bVar = eVar.j;
                    if (bVar == null) {
                        throw null;
                    } else if (!a.c.a.f.b.R(arrayList)) {
                        c cVar = bVar.f286a;
                        a.c.d.j.e.g.a aVar = new a.c.d.j.e.g.a(bVar);
                        if (((a.c.d.j.e.f.a) cVar) != null) {
                            a.c.d.j.e.c b2 = a.c.d.j.e.c.b();
                            if (b2 != null) {
                                TuyaHomeSdk.getHomeManagerInstance().createHome("home", 0.0d, 0.0d, "", arrayList, new a.c.d.j.e.b(b2, aVar));
                                return;
                            }
                            throw null;
                        }
                        throw null;
                    }
                } else {
                    throw null;
                }
            } else {
                e.this.q();
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("refresh_devices".equals(intent.getAction())) {
                a.c.d.j.b.e.b bVar = e.this.f178b;
                ((e) bVar.f191b).f179c.setRefreshing(true);
                bVar.c();
            }
        }
    }

    public static String n(String str, Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void m() {
        d dVar = this.k;
        a aVar = new a();
        if (((a.c.d.j.e.f.b) dVar) != null) {
            a.c.d.j.e.c b2 = a.c.d.j.e.c.b();
            if (b2 != null) {
                TuyaHomeSdk.getHomeManagerInstance().queryHomeList(new a.c.d.j.e.a(b2, aVar));
                return;
            }
            throw null;
        }
        throw null;
    }

    public void o() {
        this.f179c.setRefreshing(false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String n = n(BaseConfig.TUYA_SMART_APPKEY, getActivity());
        String n2 = n(BaseConfig.TUYA_SMART_SECRET, getActivity());
        boolean z = false;
        if (!TextUtils.equals("null", n) && !TextUtils.equals("null", n2) && !TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2)) {
            z = true;
        }
        if (!z) {
            a.c.a.f.b.t0(getActivity(), "appkey or appsecret is empty. \nPlease check your configuration", new a(this));
        } else if (!TuyaHomeSdk.getUserInstance().isLogin()) {
            a.c.a.f.b.n0(getActivity(), R.string.TR_LOGINING);
            a.c.d.j.f.b.b bVar = new a.c.d.j.f.b.b(getActivity(), this);
            this.i = bVar;
            TuyaHomeSdk.getUserInstance().loginWithUid(bVar.f291c, a.c.d.j.a.f164a, "123456yuiop", new a.c.d.j.f.b.a(bVar));
        } else {
            m();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f177a = layoutInflater.inflate(R.layout.fragment_device_list, viewGroup, false);
        this.k = new a.c.d.j.e.f.b(getActivity());
        this.f179c = (SwipeRefreshLayout) this.f177a.findViewById(R.id.swipe_container);
        this.f = (TextView) this.f177a.findViewById(R.id.network_tip);
        this.f181e = (ListView) this.f177a.findViewById(R.id.lv_device_list);
        this.g = this.f177a.findViewById(R.id.rl_list);
        this.h = this.f177a.findViewById(R.id.list_background_tip);
        ((TextView) this.f177a.findViewById(R.id.tv_none_content)).setText(a.c.a.d.a.h(R.string.TR_ADD_NEW_DEVICE));
        TextView textView = (TextView) this.f177a.findViewById(R.id.tv_add_button);
        textView.setText(a.c.a.d.a.h(R.string.TR_ADD));
        textView.setOnClickListener(new f(this));
        TextView textView2 = (TextView) this.f177a.findViewById(R.id.tv_add_device_tip);
        textView2.setTypeface(a.c.d.r.e.a().f789b);
        textView2.setText(a.c.a.d.a.h(R.string.TR_HUMIDIFIER_HEADER_INFO));
        textView2.setOnClickListener(new g(this));
        a.c.d.j.d.a aVar = new a.c.d.j.d.a(getActivity());
        this.f180d = aVar;
        this.f181e.setAdapter(aVar);
        this.f181e.setOnItemLongClickListener(new c(this));
        this.f181e.setOnItemClickListener(new d(this));
        this.f179c.setColorSchemeColors(getResources().getColor(R.color.primary), getResources().getColor(R.color.color_humidificador), getResources().getColor(R.color.dark));
        this.f179c.setOnRefreshListener(new b(this));
        this.f178b = new a.c.d.j.b.e.b(this, this);
        return this.f177a;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f178b.onDestroy();
        a.c.d.j.e.g.b bVar = this.j;
        if (bVar != null) {
            bVar.onDestroy();
        }
        if (getContext() != null) {
            try {
                getContext().unregisterReceiver(this.l);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void p(int i2, Result result) {
        if (i2 == 15) {
            a.c.a.f.b.J();
            m();
        } else if (i2 == 16) {
            a.c.a.f.b.J();
            FragmentActivity activity = getActivity();
            String str = result.error;
            synchronized (a.c.a.f.b.class) {
                if (a.c.a.f.b.f34c == null) {
                    a.c.a.f.b.f34c = Toast.makeText(activity, "", 0);
                }
                a.c.a.f.b.f34c.setText(str);
                a.c.a.f.b.f34c.show();
            }
        }
    }

    public final void q() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("refresh_devices");
        if (getContext() != null) {
            getContext().registerReceiver(this.l, intentFilter);
        }
        this.f178b.c();
        this.f179c.setRefreshing(true);
    }
}
