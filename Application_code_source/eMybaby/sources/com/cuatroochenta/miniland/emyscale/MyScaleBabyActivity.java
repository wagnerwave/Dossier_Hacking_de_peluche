package com.cuatroochenta.miniland.emyscale;

import a.c.d.h.h.a;
import a.c.d.s.b.a.c;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.cuatroochenta.miniland.model.Measure;
import com.cuatroochenta.miniland.webservices.emyscale.addweight.AddWeightRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import java.util.Calendar;

public class MyScaleBabyActivity extends a.c.d.c implements a.c.d.o.a, a.c, a.c.d.s.b.a.d, DatePickerDialog.OnDateSetListener {

    /* renamed from: b  reason: collision with root package name */
    public a.c.d.o.c f3850b;

    /* renamed from: c  reason: collision with root package name */
    public a.c.d.o.e f3851c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f3852d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f3853e;
    public ViewGroup f;
    public Button g;
    public TextView h;
    public TextView i;
    public Bebe j;
    public Measure k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            MyScaleBabyActivity.v(MyScaleBabyActivity.this, a.c.a.d.a.h(R.string.TR_ERROR_CONNECT_DEVICE_TIMEOUT));
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f3855a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3856b;

        public b(float f, int i) {
            this.f3855a = f;
            this.f3856b = i;
        }

        public void run() {
            MyScaleBabyActivity.this.f.setVisibility(8);
            MyScaleBabyActivity.this.x(this.f3855a, this.f3856b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.b.a.a f3858a;

        public c(a.c.d.s.b.a.a aVar) {
            this.f3858a = aVar;
        }

        public void run() {
            MyScaleBabyActivity.this.o();
            if (this.f3858a.f42a.booleanValue()) {
                MyScaleBabyActivity myScaleBabyActivity = MyScaleBabyActivity.this;
                myScaleBabyActivity.k = null;
                myScaleBabyActivity.g.setText(a.c.a.d.a.h(R.string.TR_HISTORICAL));
                MyScaleBabyActivity.this.h.setVisibility(0);
                MyScaleBabyActivity.this.i.setVisibility(8);
                MyScaleBabyActivity.this.f3852d.setVisibility(8);
                MyScaleBabyActivity myScaleBabyActivity2 = MyScaleBabyActivity.this;
                a.c.a.d.a.m(myScaleBabyActivity2, myScaleBabyActivity2.j);
                MyScaleBabyActivity.this.finish();
                return;
            }
            MyScaleBabyActivity.this.f3853e.setVisibility(0);
            Toast.makeText(MyScaleBabyActivity.this, a.c.a.d.a.h(R.string.TR_ERROR_SAVE_MEASURE), 0).show();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            MyScaleBabyActivity.this.B();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(MyScaleBabyActivity.this.k.getDate());
            int i = instance.get(1);
            int i2 = instance.get(2);
            int i3 = instance.get(5);
            MyScaleBabyActivity myScaleBabyActivity = MyScaleBabyActivity.this;
            new DatePickerDialog(myScaleBabyActivity, myScaleBabyActivity, i, i2, i3).show();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            MyScaleBabyActivity.this.B();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            MyScaleBabyActivity myScaleBabyActivity = MyScaleBabyActivity.this;
            if (myScaleBabyActivity.k == null) {
                a.c.a.d.a.m(myScaleBabyActivity, myScaleBabyActivity.j);
                MyScaleBabyActivity.this.finish();
                return;
            }
            myScaleBabyActivity.p(a.c.a.d.a.h(R.string.TR_SAVING_MEASURE), true);
            a.c.d.s.b.a.c cVar = new a.c.d.s.b.a.c();
            cVar.f865b = "https://emybaby.com/api/fichamedica.php";
            AddWeightRequest addWeightRequest = new AddWeightRequest();
            addWeightRequest.f4092a = myScaleBabyActivity.k;
            addWeightRequest.f4093b = myScaleBabyActivity.j.getId();
            new c.a(addWeightRequest, myScaleBabyActivity).start();
            myScaleBabyActivity.f3853e.setVisibility(8);
        }
    }

    public class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f3864a;

        public h(Dialog dialog) {
            this.f3864a = dialog;
        }

        public void onClick(View view) {
            a.c.a.e.f.c().d("MY_SCALE", "MEDIDA_MANUAL", "");
            MyScaleBabyActivity.q(MyScaleBabyActivity.this);
            this.f3864a.dismiss();
        }
    }

    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f3866a;

        public i(Dialog dialog) {
            this.f3866a = dialog;
        }

        public void onClick(View view) {
            a.c.a.e.f.c().d("MY_SCALE", "MEDIDA_AUTOMATICA", "eMyScale");
            MyScaleBabyActivity.r(MyScaleBabyActivity.this);
            this.f3866a.dismiss();
        }
    }

    public class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f3868a;

        public j(Dialog dialog) {
            this.f3868a = dialog;
        }

        public void onClick(View view) {
            a.c.a.e.f.c().d("MY_SCALE", "MEDIDA_AUTOMATICA", "eMyScale Pro");
            MyScaleBabyActivity.s(MyScaleBabyActivity.this);
            this.f3868a.dismiss();
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MyScaleBabyActivity.t(MyScaleBabyActivity.this);
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MyScaleBabyActivity.u(MyScaleBabyActivity.this);
        }
    }

    public static void q(MyScaleBabyActivity myScaleBabyActivity) {
        if (myScaleBabyActivity != null) {
            new a.c.d.h.h.a().show(myScaleBabyActivity.getSupportFragmentManager(), "ADD_MEASURE");
            return;
        }
        throw null;
    }

    public static void r(MyScaleBabyActivity myScaleBabyActivity) {
        boolean z = false;
        if (!myScaleBabyActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || Build.VERSION.SDK_INT < 18) {
            Toast.makeText(myScaleBabyActivity, a.c.a.d.a.h(R.string.TR_BLE_NOT_SUPPORTED), 0).show();
            return;
        }
        if (myScaleBabyActivity.f3850b == null) {
            a.c.d.o.c cVar = new a.c.d.o.c(myScaleBabyActivity, myScaleBabyActivity);
            myScaleBabyActivity.f3850b = cVar;
            cVar.j = a.c.d.a.l().o();
        }
        BluetoothAdapter bluetoothAdapter = myScaleBabyActivity.f3850b.f738b;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            z = true;
        }
        if (!z) {
            a.c.a.d.a.a(myScaleBabyActivity, 1001);
        } else {
            myScaleBabyActivity.w();
        }
    }

    public static void s(MyScaleBabyActivity myScaleBabyActivity) {
        boolean z = false;
        if (!myScaleBabyActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || Build.VERSION.SDK_INT < 18) {
            Toast.makeText(myScaleBabyActivity, a.c.a.d.a.h(R.string.TR_BLE_NOT_SUPPORTED), 0).show();
            return;
        }
        if (myScaleBabyActivity.f3851c == null) {
            myScaleBabyActivity.f3851c = new a.c.d.o.e(myScaleBabyActivity, myScaleBabyActivity);
            a.c.d.a.l().o();
        }
        BluetoothAdapter bluetoothAdapter = myScaleBabyActivity.f3851c.f750b;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            z = true;
        }
        if (!z) {
            a.c.a.d.a.a(myScaleBabyActivity, 1001);
        } else {
            myScaleBabyActivity.w();
        }
    }

    public static void t(MyScaleBabyActivity myScaleBabyActivity) {
        if (myScaleBabyActivity != null) {
            ActivityCompat.requestPermissions(myScaleBabyActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
            return;
        }
        throw null;
    }

    public static void u(MyScaleBabyActivity myScaleBabyActivity) {
        if (myScaleBabyActivity != null) {
            a.c.a.f.b.k0(myScaleBabyActivity, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH));
            return;
        }
        throw null;
    }

    public static void v(MyScaleBabyActivity myScaleBabyActivity, String str) {
        myScaleBabyActivity.f.setVisibility(8);
        AlertDialog.Builder builder = new AlertDialog.Builder(myScaleBabyActivity);
        builder.setTitle((CharSequence) null);
        builder.setMessage(str);
        builder.setPositiveButton(a.c.a.d.a.h(R.string.TR_OK), new a.c.d.h.c(myScaleBabyActivity));
        AlertDialog create = builder.create();
        Button button = create.getButton(-1);
        if (button != null) {
            button.setTextColor(myScaleBabyActivity.getResources().getColor(R.color.green));
        }
        create.show();
    }

    public void A(float f2, int i2) {
        runOnUiThread(new b(f2, i2));
    }

    public void B() {
        if (this.f.getVisibility() != 0) {
            Dialog dialog = new Dialog(this, 2131886561);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            Window window = dialog.getWindow();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            window.setAttributes(layoutParams);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje_three_options);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_SELECT_MEASURE_SOURCE_TITLE, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_MANUAL_MEASURE));
            button.setOnClickListener(new h(dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_EMYSCALE_MEASURE));
            button2.setOnClickListener(new i(dialog));
            Button button3 = (Button) dialog.findViewById(R.id.butt_popup_three_options_3);
            button3.setText(a.c.a.d.a.h(R.string.TR_EMYSCALE_PLUS_MEASURE));
            button3.setOnClickListener(new j(dialog));
            dialog.show();
        }
    }

    public void g(float f2, int i2) {
        x(f2, i2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1001) {
            return;
        }
        if (i3 == -1) {
            w();
        } else {
            a.c.a.f.b.h0(this, a.c.a.d.a.h(R.string.TR_NECESITA_ACTIVAR_BLUETOOTH), a.c.a.d.a.h(R.string.TR_OK));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_myscale_baby);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.scale_manager_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_EMYSCALE).toUpperCase());
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.scale_manager_header_image);
        circularImageView.setBorder(true);
        circularImageView.setImageResource(R.drawable.baby_big_default);
        circularImageView.setBorderColor(getResources().getColor(R.color.baby_profile_border));
        TextView textView = (TextView) findViewById(R.id.scale_manager_header_name);
        TextView textView2 = (TextView) findViewById(R.id.scale_manager_header_surname);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("KEY_INTENT_BABY")) {
            this.j = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        Bebe bebe = this.j;
        if (bebe == null) {
            finish();
            return;
        }
        textView.setText(bebe.getNombre());
        textView2.setText(this.j.getApellidos());
        if (!this.j.isPhotoEmpty()) {
            AppMiniland.f().k.b(this.j.getFoto(), circularImageView, (a.g.a.b.b) null, (a.g.a.b.l.c) null);
        }
        TextView textView3 = (TextView) findViewById(R.id.scale_manager_new_measure);
        this.h = textView3;
        textView3.setText(a.c.a.d.a.h(R.string.TR_TAP_TO_READ_THE_WEIGHT));
        this.h.setOnClickListener(new d());
        this.f3852d = (TextView) findViewById(R.id.scale_manager_result);
        TextView textView4 = (TextView) findViewById(R.id.scale_manager_result_date);
        this.i = textView4;
        textView4.setOnClickListener(new e());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.scale_manager_button_container);
        this.f3853e = viewGroup;
        viewGroup.setVisibility(8);
        Button button = (Button) findViewById(R.id.scale_manager_new_reading);
        button.setText(a.c.a.d.a.h(R.string.TR_NEW_READING));
        button.setOnClickListener(new f());
        Button button2 = (Button) findViewById(R.id.scale_manager_add_to_record);
        this.g = button2;
        button2.setText(a.c.a.d.a.h(R.string.TR_SAVE_WEIGHT));
        this.g.setOnClickListener(new g());
        this.f = (ViewGroup) findViewById(R.id.scale_manager_waiting);
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i2);
        instance.set(2, i3);
        instance.set(5, i4);
        this.k.setDate(instance.getTime());
        this.i.setText(a.c.d.r.j.f.format(instance.getTime()));
    }

    public void onDestroy() {
        a.c.d.o.c cVar;
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 18 && (cVar = this.f3850b) != null) {
            if (cVar != null) {
                cVar.c();
            }
            a.c.d.o.e eVar = this.f3851c;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != 102) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            a.c.a.f.b.k0(this, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH));
        } else {
            w();
        }
    }

    public void onResume() {
        super.onResume();
        a.c.a.e.f.c().e("EMYSCALE_NUEVA_TOMA");
    }

    public final void w() {
        if (Build.VERSION.SDK_INT < 18) {
            z();
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (!(this.f3850b == null && this.f3851c == null)) {
                this.f.setVisibility(0);
            }
            a.c.d.o.c cVar = this.f3850b;
            if (cVar != null) {
                if (cVar.k != 0 || cVar.g) {
                    StringBuilder n = a.a.a.a.a.n("Discard connection: state[");
                    n.append(cVar.k);
                    n.append("], scanning->");
                    n.append(cVar.g);
                    Log.d("SAMICO-BABYSC", n.toString());
                } else {
                    cVar.f.postDelayed(cVar.o, cVar.f741e * 10000);
                    cVar.g = true;
                    Log.d("SAMICO-BABYSC", "Scan Start");
                    if (Build.VERSION.SDK_INT >= 23) {
                        BluetoothLeScanner bluetoothLeScanner = cVar.f738b.getBluetoothLeScanner();
                        cVar.f739c = bluetoothLeScanner;
                        bluetoothLeScanner.startScan(cVar.m);
                    } else {
                        cVar.f738b.startLeScan(cVar.n);
                    }
                }
            }
            a.c.d.o.e eVar = this.f3851c;
            if (eVar == null) {
                return;
            }
            if (eVar.k != 0 || eVar.h) {
                StringBuilder n2 = a.a.a.a.a.n("Discard connection: state[");
                n2.append(eVar.k);
                n2.append("], scanning->");
                n2.append(eVar.h);
                Log.d("SCALE", n2.toString());
                return;
            }
            eVar.g.postDelayed(eVar.o, eVar.f * 1000);
            eVar.h = true;
            Log.d("SCALE", "Scan Start");
            if (Build.VERSION.SDK_INT >= 23) {
                BluetoothLeScanner bluetoothLeScanner2 = eVar.f750b.getBluetoothLeScanner();
                eVar.f751c = bluetoothLeScanner2;
                bluetoothLeScanner2.startScan(eVar.m);
                return;
            }
            eVar.f750b.startLeScan(eVar.n);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION")) {
            a.c.a.f.b.p0(this, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH_WHY_REASON), a.c.a.d.a.h(R.string.TR_ACEPTAR), new k(), a.c.a.d.a.h(R.string.TR_CANCEL), new l());
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
        }
    }

    public final void x(float f2, int i2) {
        a.c.d.o.c cVar;
        Measure measure = this.k;
        if (measure == null) {
            this.k = new Measure(f2, i2);
        } else {
            measure.setValue(f2);
            this.k.setUnit(i2);
        }
        this.h.setVisibility(8);
        this.f3852d.setVisibility(0);
        this.i.setVisibility(0);
        this.i.setText(a.c.d.r.j.f.format(this.k.getDate()));
        this.g.setText(a.c.a.d.a.h(R.string.TR_SAVE_WEIGHT));
        this.f3852d.setText(this.k.toString());
        if (Build.VERSION.SDK_INT >= 18 && (cVar = this.f3850b) != null) {
            cVar.c();
        }
        this.f3853e.setVisibility(0);
    }

    public void y(a.c.d.s.b.a.a aVar) {
        runOnUiThread(new c(aVar));
    }

    public void z() {
        if (!isFinishing()) {
            runOnUiThread(new a());
        }
    }
}
