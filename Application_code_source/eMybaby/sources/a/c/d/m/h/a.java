package a.c.d.m.h;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTListActivity;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity;

public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PregnancyBTListActivity f488a;

    public a(PregnancyBTListActivity pregnancyBTListActivity) {
        this.f488a = pregnancyBTListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f488a.h.isDiscovering()) {
            this.f488a.h.cancelDiscovery();
        }
        BluetoothDevice bluetoothDevice = this.f488a.f4002e.get(i);
        PregnancyBTListActivity pregnancyBTListActivity = this.f488a;
        if (bluetoothDevice != null) {
            Intent intent = new Intent(pregnancyBTListActivity, PregnancyEscuchaLatidosActivity.class);
            intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothDevice);
            pregnancyBTListActivity.startActivity(intent);
        }
        this.f488a.finish();
    }
}
