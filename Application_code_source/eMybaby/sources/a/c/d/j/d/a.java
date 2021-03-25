package a.c.d.j.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final List<DeviceBean> f247a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Integer> f248b;

    /* renamed from: c  reason: collision with root package name */
    public final LayoutInflater f249c;

    /* renamed from: d  reason: collision with root package name */
    public Context f250d;

    /* renamed from: a.c.d.j.d.a$a  reason: collision with other inner class name */
    public static class C0013a extends a.c.d.j.b.b.a<DeviceBean> {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f251a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f252b;

        public C0013a(View view) {
            super(view);
            this.f251a = (ImageView) view.findViewById(R.id.iv_device_list_dot);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_device_icon);
            this.f252b = (TextView) view.findViewById(R.id.tv_device);
        }
    }

    public a(Context context) {
        this.f250d = context;
        this.f249c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f247a.size();
    }

    public Object getItem(int i) {
        return this.f247a.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0013a aVar;
        String str;
        if (view == null) {
            view = this.f249c.inflate(R.layout.list_common_device_item, (ViewGroup) null);
            aVar = new C0013a(view);
            view.setTag(aVar);
        } else {
            aVar = (C0013a) view.getTag();
        }
        DeviceBean deviceBean = this.f247a.get(i);
        if (this.f248b.containsKey(deviceBean.getDevId())) {
            str = a.c.a.d.a.h(R.string.TR_HUMITOP_CONNECT) + " " + this.f248b.get(deviceBean.getDevId());
        } else {
            str = a.c.a.d.a.h(R.string.TR_HUMITOP_CONNECT);
        }
        deviceBean.setName(str);
        aVar.f251a.setVisibility(4);
        aVar.f252b.setText(deviceBean.getName());
        return view;
    }
}
