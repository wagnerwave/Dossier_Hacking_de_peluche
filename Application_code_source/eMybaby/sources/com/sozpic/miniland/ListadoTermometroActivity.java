package com.sozpic.miniland;

import a.c.d.r.j;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Usuario;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tuya.smart.common.oooo000oo;
import generalplus.com.GPLib.ComAirWrapper;
import java.util.Calendar;
import java.util.Locale;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

public class ListadoTermometroActivity extends a.c.d.c implements View.OnClickListener, ComAirWrapper.IOnCommandReceived, a.c.d.q.a {
    public static TextView x;

    /* renamed from: b  reason: collision with root package name */
    public Context f4441b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f4442c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f4443d;

    /* renamed from: e  reason: collision with root package name */
    public Button f4444e;
    public Button f;
    public LinearLayout g;
    public TextView h;
    public TextView i;
    @Nullable
    public ComAirWrapper j = new ComAirWrapper();
    public ProgressDialog k;
    public TopMenuActivity l;
    public ViewGroup m;
    public ImageView n;
    public int o = -1;
    public int p = -1;
    public float q = -1.0f;
    public float r = -1.0f;
    public Handler s = new Handler();
    public a.c.d.q.b t;
    public Runnable u = new c();
    public Bebe v;
    @SuppressLint({"HandlerLeak"})
    public Handler w = new a();

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            ListadoTermometroActivity.this.k.dismiss();
            if (message != null) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                try {
                    if (new JSONObject(message.obj.toString()).has("idTemperatura")) {
                        Intent intent = new Intent(ListadoTermometroActivity.this.f4441b, HistoricoTermometroActivity.class);
                        intent.putExtra("KEY_INTENT_BABY", ListadoTermometroActivity.this.v);
                        ListadoTermometroActivity.this.startActivity(intent);
                        ListadoTermometroActivity.this.finish();
                        return;
                    }
                } catch (JSONException unused) {
                }
            }
            Toast.makeText(ListadoTermometroActivity.this.f4441b, "Error", 0).show();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ListadoTermometroActivity.this.B();
            ListadoTermometroActivity.this.z();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            if (ListadoTermometroActivity.this.m.getVisibility() == 0) {
                ListadoTermometroActivity.this.z();
                ListadoTermometroActivity.this.v();
                if (!ListadoTermometroActivity.this.isFinishing()) {
                    try {
                        a.c.a.f.b.l0(ListadoTermometroActivity.this, a.c.a.d.a.h(R.string.TR_MEDIDA_NO_RECIBIDA), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                    } catch (WindowManager.BadTokenException unused) {
                    }
                }
            }
        }
    }

    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4448a;

        public d(Dialog dialog) {
            this.f4448a = dialog;
        }

        public void onClick(View view) {
            a.c.a.e.f.c().d("TERMOMETRO", "MEDIDA_MANUAL", "");
            ListadoTermometroActivity listadoTermometroActivity = ListadoTermometroActivity.this;
            if (listadoTermometroActivity != null) {
                Dialog dialog = new Dialog(listadoTermometroActivity, 2131886561);
                dialog.requestWindowFeature(1);
                dialog.setContentView(R.layout.pregunta_toma);
                dialog.setCancelable(true);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = dialog.getWindow();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                window.setAttributes(layoutParams);
                EditText editText = (EditText) dialog.findViewById(R.id.tomatexto);
                editText.setFilters(new InputFilter[]{new a.c.d.r.b(4, 1)});
                ((InputMethodManager) listadoTermometroActivity.getSystemService("input_method")).toggleSoftInput(2, 1);
                Button button = (Button) a.a.a.a.a.A(R.string.TR_ADD_NEW_TEMPERATURE, (TextView) dialog.findViewById(R.id.Tv1), dialog, R.id.no);
                button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
                button.setOnClickListener(new a.h.a.e(listadoTermometroActivity, dialog));
                Button button2 = (Button) dialog.findViewById(R.id.si);
                button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
                button2.setOnClickListener(new a.h.a.f(listadoTermometroActivity, editText, dialog));
                dialog.show();
                this.f4448a.dismiss();
                return;
            }
            throw null;
        }
    }

    public class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4450a;

        public e(Dialog dialog) {
            this.f4450a = dialog;
        }

        public void onClick(View view) {
            a.c.a.e.f.c().d("TERMOMETRO", "MEDIDA_AUTOMATICA", "thermoadvanced plus");
            if (ContextCompat.checkSelfPermission(view.getContext(), "android.permission.RECORD_AUDIO") != 0) {
                ActivityCompat.requestPermissions(ListadoTermometroActivity.this, new String[]{"android.permission.RECORD_AUDIO"}, 101);
            } else {
                ListadoTermometroActivity.this.y();
            }
            this.f4450a.dismiss();
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4452a;

        public f(Dialog dialog) {
            this.f4452a = dialog;
        }

        public void onClick(View view) {
            ListadoTermometroActivity.r(ListadoTermometroActivity.this);
            this.f4452a.dismiss();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListadoTermometroActivity.s(ListadoTermometroActivity.this);
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ListadoTermometroActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (Exception unused) {
            }
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListadoTermometroActivity.t(ListadoTermometroActivity.this);
        }
    }

    public static void r(ListadoTermometroActivity listadoTermometroActivity) {
        if (listadoTermometroActivity != null) {
            a.c.a.e.f.c().d("TERMOMETRO", "MEDIDA_AUTOMATICA", "thermoadvanced pharma");
            if (ContextCompat.checkSelfPermission(listadoTermometroActivity, "android.permission.BLUETOOTH") != 0) {
                ActivityCompat.requestPermissions(listadoTermometroActivity, new String[]{"android.permission.BLUETOOTH"}, 1001);
                return;
            }
            Log.d("ListadoTermometro", "checkForBTStatusAndConnect BT Enabled");
            listadoTermometroActivity.u();
            return;
        }
        throw null;
    }

    public static void s(ListadoTermometroActivity listadoTermometroActivity) {
        if (listadoTermometroActivity != null) {
            ActivityCompat.requestPermissions(listadoTermometroActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
            return;
        }
        throw null;
    }

    public static void t(ListadoTermometroActivity listadoTermometroActivity) {
        if (listadoTermometroActivity != null) {
            a.c.a.f.b.k0(listadoTermometroActivity, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH));
            return;
        }
        throw null;
    }

    public void A() {
        if (this.m.getVisibility() != 0) {
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
            Button button = (Button) a.a.a.a.a.A(R.string.TR_ADD_TEMPERATURE_SELECT_QUESTION, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_MANUAL_MEASURE));
            button.setOnClickListener(new d(dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_TOMA_DE_TERMOMETRO_PLUS));
            button2.setOnClickListener(new e(dialog));
            Button button3 = (Button) dialog.findViewById(R.id.butt_popup_three_options_3);
            button3.setText(a.c.a.d.a.h(R.string.TR_TOMA_DE_TERMOMETRO_PHARMA));
            button3.setOnClickListener(new f(dialog));
            dialog.show();
        }
    }

    public final void B() {
        x.setBackgroundResource(R.drawable.boton_redondeado_blanco_vacio);
        x.setText(String.format(Locale.ENGLISH, "%.1f ºC", new Object[]{Float.valueOf(this.r)}));
        this.f4442c.setVisibility(8);
        this.f4443d.setVisibility(0);
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i2 != 1001) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            u();
        } else {
            a.c.a.f.b.h0(this, a.c.a.d.a.h(R.string.TR_NECESITA_ACTIVAR_BLUETOOTH), a.c.a.d.a.h(R.string.TR_OK));
        }
    }

    public void onBackPressed() {
        if (this.m.getVisibility() == 0) {
            z();
            v();
            return;
        }
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view != this.g) {
            if (view == this.f4444e) {
                if (this.r != -1.0f) {
                    Usuario i2 = AppMiniland.f().i();
                    ProgressDialog progressDialog = new ProgressDialog(this.f4441b);
                    this.k = progressDialog;
                    progressDialog.setCancelable(true);
                    this.k.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                    this.k.setIndeterminate(true);
                    this.k.show();
                    try {
                        Calendar instance = Calendar.getInstance();
                        new a.h.a.l0.b(this.w, "&bd=" + i2.getBd() + "&bdpre=" + i2.getBdpre() + "&idBebe=" + this.v.getId() + "&fecharevision=" + j.f.format(instance.getTime()) + "&hora=" + j.m.format(instance.getTime()) + "&temperatura=" + String.format("%.1f", new Object[]{Float.valueOf(this.r)}), "termometro.php?anadirtemperatura=1").start();
                        return;
                    } catch (Exception unused) {
                        this.k.dismiss();
                        return;
                    }
                } else {
                    return;
                }
            } else if (view != this.f) {
                return;
            }
        }
        A();
    }

    public void onCommandReceived(int i2) {
        String hexString = Integer.toHexString(i2);
        a.c.a.f.e.b("Command received:" + i2);
        a.c.a.f.e.b("Hex String:" + hexString);
        if (hexString.length() == 2) {
            char charAt = hexString.charAt(0);
            int numericValue = Character.getNumericValue(hexString.charAt(1));
            if (charAt == '3') {
                this.o = numericValue;
            } else if (charAt == '1') {
                this.p = numericValue;
            }
        }
        if (this.p >= 0 && this.o >= 0) {
            StringBuilder n2 = a.a.a.a.a.n("FirstLow:");
            n2.append(this.o);
            n2.append(", SecondLow:");
            n2.append(this.p);
            a.c.a.f.e.b(n2.toString());
            float f2 = ((float) (((this.o * 16) + this.p) + AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ)) / 10.0f;
            this.q = f2;
            a.c.a.f.e.b(String.format("%.1f ºF", new Object[]{Float.valueOf(f2)}));
            float f3 = ((this.q - 32.0f) * 5.0f) / 9.0f;
            this.r = f3;
            a.c.a.f.e.b(String.format("%.1f ºC", new Object[]{Float.valueOf(f3)}));
            runOnUiThread(new b());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4441b = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_temperatura_1);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.l = topMenuActivity;
        topMenuActivity.setListener(this);
        this.l.setSeccion(a.c.a.d.a.h(R.string.TR_THERMOMETER));
        ((TextView) findViewById(R.id.nueva)).setText(a.c.a.d.a.h(R.string.TR_TAP_TO_READ_THE_TEMPERATURE));
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("KEY_INTENT_BABY")) {
            finish();
            return;
        }
        this.v = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.icono);
        circularImageView.setBorder(true);
        circularImageView.setBorderColor(getResources().getColor(R.color.rosa));
        circularImageView.setImageResource(R.drawable.baby_big_default);
        if (!this.v.isPhotoEmpty()) {
            AppMiniland.f().k.b(this.v.getFoto(), circularImageView, (a.g.a.b.b) null, (a.g.a.b.l.c) null);
        }
        TextView textView = (TextView) findViewById(R.id.tmptomada);
        x = textView;
        textView.setText("");
        TextView textView2 = (TextView) findViewById(R.id.nombrebb);
        this.h = textView2;
        textView2.setText(a.c.a.d.a.g(this.v.getNombre()));
        TextView textView3 = (TextView) findViewById(R.id.apellidobb);
        this.i = textView3;
        textView3.setText(a.c.a.d.a.g(this.v.getApellidos()));
        Button button = (Button) findViewById(R.id.registrar);
        this.f4444e = button;
        button.setText(a.c.a.d.a.h(R.string.TR_REGISTER_TEMPERATURE));
        Button button2 = (Button) findViewById(R.id.nuevatemp);
        this.f = button2;
        button2.setText(a.c.a.d.a.h(R.string.TR_NEW_READING));
        this.g = (LinearLayout) findViewById(R.id.linear_nueva);
        this.f4443d = (LinearLayout) findViewById(R.id.centro);
        this.f4442c = (LinearLayout) findViewById(R.id.lnuevatmp);
        this.f = (Button) findViewById(R.id.nuevatemp);
        this.g.setOnClickListener(this);
        this.f4443d.setOnClickListener(this);
        this.f4444e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        ComAirWrapper comAirWrapper = new ComAirWrapper();
        this.j = comAirWrapper;
        comAirWrapper.SetComAirDecodeMode(ComAirWrapper.eAudioDecodeMode.eDecodeMode_05Sec.getVal());
        this.j.SetComAirEncodeMode(ComAirWrapper.eAudioEncodeMode.eEncodeMode_05Sec.getVal());
        this.j.setListener(this);
        ComAirWrapper comAirWrapper2 = this.j;
        ComAirWrapper.eComAirPropertyTarget ecomairpropertytarget = ComAirWrapper.eComAirPropertyTarget.eComAirPropertyTarget_Both;
        ComAirWrapper.eComAirProperty ecomairproperty = ComAirWrapper.eComAirProperty.eComAirProperty_RegCode;
        int SetComAirProperty = comAirWrapper2.SetComAirProperty(0, 0, "ZewEhexk");
        ComAirWrapper.eComAirErrCode ecomairerrcode = ComAirWrapper.eComAirErrCode.COMAIR_NOERR;
        if (SetComAirProperty != 0) {
            a.c.a.f.e.c("Error when set Register code to Thermometer");
        }
        this.m = (ViewGroup) findViewById(R.id.temperature_manager_waiting);
        this.n = (ImageView) findViewById(R.id.temperature_manager_waiting_image);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        v();
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != 101) {
            if (i2 != 102) {
                if (i2 == 1001) {
                    if (iArr.length <= 0 || iArr[0] != 0) {
                        a.c.a.f.b.h0(this, a.c.a.d.a.h(R.string.TR_NECESITA_ACTIVAR_BLUETOOTH), a.c.a.d.a.h(R.string.TR_OK));
                    } else {
                        u();
                    }
                }
                super.onRequestPermissionsResult(i2, strArr, iArr);
            } else if (iArr.length <= 0 || iArr[0] != 0) {
                a.c.a.f.b.k0(this, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH));
            } else {
                w();
            }
        } else if (iArr.length > 0 && iArr[0] == 0) {
            y();
        }
    }

    public void onResume() {
        super.onResume();
        a.c.a.e.f.c().e("TERMOMETRO_NUEVA_TOMA");
        if (!a.c.d.a.l().a("KEY_WARN_NOT_MEDICAL_TERMOMETHER", false)) {
            a.c.d.a.l().g("KEY_WARN_NOT_MEDICAL_TERMOMETHER", Boolean.TRUE);
            a.c.a.f.b.j0(this, a.c.a.d.a.h(R.string.TR_MESSAGE_APP_NOT_MEDICAL_DEVICE));
        }
    }

    public final void u() {
        if (Build.VERSION.SDK_INT < 18) {
            Toast.makeText(this, a.c.a.d.a.h(R.string.TR_BLE_NOT_SUPPORTED), 0).show();
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            Log.d("ListadoTermometro", "checkForLocationPermissionAndManage permission granted");
            w();
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION")) {
            x(new g());
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
        }
    }

    public final void v() {
        a.c.d.q.b bVar = this.t;
        if (bVar != null && Build.VERSION.SDK_INT >= 18) {
            bVar.k = 0;
            bVar.f769d.post(new a.c.d.q.c(bVar));
        }
    }

    public final void w() {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT < 18) {
            Toast.makeText(this, a.c.a.d.a.h(R.string.TR_BLE_NOT_SUPPORTED), 0).show();
            return;
        }
        if (this.t == null) {
            this.t = new a.c.d.q.b(this, this);
        }
        BluetoothAdapter bluetoothAdapter = this.t.f;
        if (!(bluetoothAdapter != null && bluetoothAdapter.isEnabled())) {
            a.c.a.d.a.a(this, 1001);
            return;
        }
        LocationManager locationManager = (LocationManager) this.t.f768c.getSystemService("location");
        if (locationManager != null) {
            try {
                z = locationManager.isProviderEnabled("gps");
            } catch (Exception unused) {
                z = false;
            }
            try {
                z2 = locationManager.isProviderEnabled("network");
            } catch (Exception unused2) {
                z2 = false;
            }
        } else {
            z2 = false;
            z = false;
        }
        if (!(z || z2)) {
            x(new h());
            return;
        }
        this.n.setImageResource(R.drawable.bg_termometer_pharma_bg_explain);
        this.m.setVisibility(0);
        a.c.d.q.b bVar = this.t;
        if (bVar.k == 0 && !bVar.j) {
            bVar.f769d.postDelayed(bVar.m, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
            bVar.j = true;
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.f.getBluetoothLeScanner().startScan(bVar.g);
                return;
            }
            StringBuilder n2 = a.a.a.a.a.n("Starting old leScan : ");
            n2.append(bVar.f.startLeScan(bVar.h));
            Log.d("ThermPharmaManager", n2.toString());
        }
    }

    public final void x(DialogInterface.OnClickListener onClickListener) {
        a.c.a.f.b.p0(this, a.c.a.d.a.h(R.string.TR_PERMISSION_LOCATION_BLUETOOTH_WHY_REASON), a.c.a.d.a.h(R.string.TR_ACEPTAR), onClickListener, a.c.a.d.a.h(R.string.TR_CANCEL), new i());
    }

    public void y() {
        if (this.j != null) {
            this.n.setImageResource(R.drawable.circulo_termometro_pop);
            this.m.setVisibility(0);
            x.setBackgroundResource(0);
            x.setText("--ºC");
            this.f4442c.setVisibility(0);
            this.f4443d.setVisibility(8);
            int StartComAirDecodeProcess = this.j.StartComAirDecodeProcess();
            this.p = -1;
            this.o = -1;
            this.q = -1.0f;
            this.r = -1.0f;
            ComAirWrapper.eComAirErrCode ecomairerrcode = ComAirWrapper.eComAirErrCode.COMAIR_NOERR;
            if (StartComAirDecodeProcess != 0) {
                a.c.a.f.e.c("Error occurred when start Thermometer ");
            }
            this.s.postDelayed(this.u, oooo000oo.O0000ooo);
        }
    }

    public void z() {
        if (this.j != null) {
            this.m.setVisibility(8);
            this.s.removeCallbacks(this.u);
            int StopComAirDecodeProcess = this.j.StopComAirDecodeProcess();
            ComAirWrapper.eComAirErrCode ecomairerrcode = ComAirWrapper.eComAirErrCode.COMAIR_NOERR;
            a.c.a.f.e.b(StopComAirDecodeProcess == 0 ? "Stopped succesfully" : "Stopped with errors");
        }
    }
}
