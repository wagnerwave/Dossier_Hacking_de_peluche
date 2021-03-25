package a.c.d.g.j;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f81a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BluetoothDevice> f82b = new ArrayList<>();

    /* renamed from: a.c.d.g.j.a$a  reason: collision with other inner class name */
    public class C0000a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f83a;

        public C0000a(a aVar) {
        }
    }

    public a(Context context) {
        this.f81a = context;
    }

    public int getCount() {
        return this.f82b.size();
    }

    public Object getItem(int i) {
        return this.f82b.get(i);
    }

    public long getItemId(int i) {
        if (this.f82b.get(i) == null) {
            return 0;
        }
        return (long) this.f82b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0000a aVar;
        if (view == null || !(view.getTag() instanceof C0000a)) {
            view = ((LayoutInflater) this.f81a.getSystemService("layout_inflater")).inflate(R.layout.item_buddy_bt_devices, (ViewGroup) null);
            aVar = new C0000a(this);
            ImageView imageView = (ImageView) view.findViewById(R.id.buddy_bt_devices_item_disclosure);
            aVar.f83a = (TextView) view.findViewById(R.id.buddy_bt_devices_item_name);
            view.setTag(aVar);
        } else {
            aVar = (C0000a) view.getTag();
        }
        BluetoothDevice bluetoothDevice = this.f82b.get(i);
        if (bluetoothDevice != null) {
            aVar.f83a.setText(a.c.a.d.a.g(a.c.a.d.a.j(bluetoothDevice.getName()) ? bluetoothDevice.getAddress() : bluetoothDevice.getName()));
        }
        return view;
    }
}
