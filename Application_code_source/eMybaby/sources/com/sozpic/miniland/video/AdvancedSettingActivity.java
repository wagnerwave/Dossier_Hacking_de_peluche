package com.sozpic.miniland.video;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tutk.IOTC.Camera;
import com.tutk.IOTC.IRegisterIOTCListener;
import java.util.ArrayList;
import java.util.List;

public class AdvancedSettingActivity extends Activity implements IRegisterIOTCListener, TopMenuActivityVideo.c {
    public static String S = null;
    public static boolean T = false;
    public static boolean U = false;
    public static List<AVIOCTRLDEFs.SWifiAp> V = new ArrayList();
    public Spinner A;
    public Spinner B;
    public int C = -1;
    public int D = -1;
    public int E = -1;
    public int F = -1;
    public int G = -1;
    public int H = -1;
    public ImageView I;
    public TextView J;
    public TopMenuActivityVideo K;
    public ProgressDialog L;
    public View.OnClickListener M = new a();
    public View.OnClickListener N = new b();
    public View.OnClickListener O = new c();
    public View.OnClickListener P = new d();
    public View.OnClickListener Q = new e();
    public Handler R = new f();

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f4598a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f4599b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f4600c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f4601d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f4602e;
    public LinearLayout f;
    public LinearLayout g;
    public LinearLayout h;
    public Button i;
    public Button j;
    public Button k;
    public Button l;
    public Button m;
    public a.h.a.n0.c n;
    public a.h.a.n0.b o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public Spinner w;
    public Spinner x;
    public Spinner y;
    public Spinner z;

    public class a implements View.OnClickListener {

        /* renamed from: com.sozpic.miniland.video.AdvancedSettingActivity$a$a  reason: collision with other inner class name */
        public class C0101a implements AdapterView.OnItemSelectedListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TextView f4604a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TextView f4605b;

            public C0101a(a aVar, TextView textView, TextView textView2) {
                this.f4604a = textView;
                this.f4605b = textView2;
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                AVIOCTRLDEFs.SWifiAp sWifiAp = AdvancedSettingActivity.V.get(i);
                byte b2 = sWifiAp.enctype;
                this.f4604a.setText(b2 == 0 ? "Invalid" : b2 == 1 ? "None" : b2 == 2 ? "WEP" : b2 == 6 ? "WPA2 AES" : b2 == 5 ? "WPA2 TKIP" : b2 == 4 ? "WPA AES" : b2 == 3 ? "WPA TKIP" : "Unknown");
                TextView textView = this.f4605b;
                textView.setText(sWifiAp.signal + " %");
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }

        public class b implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EditText f4606a;

            public b(a aVar, EditText editText) {
                this.f4606a = editText;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f4606a.setTransformationMethod(!z ? PasswordTransformationMethod.getInstance() : HideReturnsTransformationMethod.getInstance());
            }
        }

        public class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EditText f4607a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Spinner f4608b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AlertDialog f4609c;

            public c(EditText editText, Spinner spinner, AlertDialog alertDialog) {
                this.f4607a = editText;
                this.f4608b = spinner;
                this.f4609c = alertDialog;
            }

            public void onClick(View view) {
                String obj = this.f4607a.getText().toString();
                AVIOCTRLDEFs.SWifiAp sWifiAp = AdvancedSettingActivity.V.get(this.f4608b.getSelectedItemPosition());
                a.h.a.n0.c cVar = AdvancedSettingActivity.this.n;
                if (!(cVar == null || sWifiAp == null)) {
                    cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SETWIFI_REQ, AVIOCTRLDEFs.SMsgAVIoctrlSetWifiReq.parseContent(sWifiAp.ssid, obj.getBytes(), sWifiAp.mode, sWifiAp.enctype));
                    AdvancedSettingActivity.U = true;
                    AdvancedSettingActivity.this.p.setText(AdvancedSettingActivity.c(sWifiAp.ssid));
                    AdvancedSettingActivity.this.p.setTypeface((Typeface) null, 1);
                    AdvancedSettingActivity.this.q.setText(a.c.a.d.a.h(R.string.TR_STATUS_CONNECTING));
                }
                this.f4609c.dismiss();
            }
        }

        public class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AlertDialog f4611a;

            public d(a aVar, AlertDialog alertDialog) {
                this.f4611a = alertDialog;
            }

            public void onClick(View view) {
                this.f4611a.dismiss();
            }
        }

        public a() {
        }

        public void onClick(View view) {
            AlertDialog create = new AlertDialog.Builder(AdvancedSettingActivity.this).create();
            View inflate = create.getLayoutInflater().inflate(R.layout.manage_device_wifi, (ViewGroup) null);
            create.setView(inflate);
            ((TextView) inflate.findViewById(R.id.txtTitleWiFiSignal)).setText(a.c.a.d.a.h(R.string.TR_WIFI_SIGNAL));
            ((TextView) inflate.findViewById(R.id.txtTitWiFiSecurity)).setText(a.c.a.d.a.h(R.string.TR_SECURITY));
            Spinner spinner = (Spinner) inflate.findViewById(R.id.spinWiFiSSID);
            TextView textView = (TextView) inflate.findViewById(R.id.txtWiFiSignal);
            TextView textView2 = (TextView) inflate.findViewById(R.id.txtWiFiSecurity);
            EditText editText = (EditText) inflate.findViewById(R.id.edtWiFiPassword);
            editText.setHint(a.c.a.d.a.h(R.string.TR_WIFI_PASSWORD));
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.chbShowHiddenPassword);
            checkBox.setText(a.c.a.d.a.h(R.string.TR_SHOW_PASSWORD));
            Button button = (Button) inflate.findViewById(R.id.btnOK);
            button.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
            Button button2 = (Button) inflate.findViewById(R.id.btnCancel);
            button2.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
            String[] strArr = new String[AdvancedSettingActivity.V.size()];
            for (int i = 0; i < AdvancedSettingActivity.V.size(); i++) {
                strArr[i] = AdvancedSettingActivity.c(AdvancedSettingActivity.V.get(i).ssid);
            }
            if (AdvancedSettingActivity.V.size() == 0) {
                spinner.setEnabled(false);
                button.setEnabled(false);
                checkBox.setEnabled(false);
                editText.setEnabled(false);
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(AdvancedSettingActivity.this, R.layout.spinner_item, strArr);
            arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
            spinner.setAdapter(arrayAdapter);
            spinner.setOnItemSelectedListener(new C0101a(this, textView2, textView));
            checkBox.setPadding(checkBox.getPaddingLeft() + ((int) (AdvancedSettingActivity.this.getResources().getDisplayMetrics().density * 5.0f)), checkBox.getPaddingTop(), checkBox.getPaddingRight(), checkBox.getPaddingBottom());
            checkBox.setOnCheckedChangeListener(new b(this, editText));
            button.setOnClickListener(new c(editText, spinner, create));
            button2.setOnClickListener(new d(this, create));
            create.show();
        }
    }

    public class b implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4613a;

            public a(b bVar, Dialog dialog) {
                this.f4613a = dialog;
            }

            public void onClick(View view) {
                this.f4613a.dismiss();
            }
        }

        /* renamed from: com.sozpic.miniland.video.AdvancedSettingActivity$b$b  reason: collision with other inner class name */
        public class C0102b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4614a;

            public C0102b(Dialog dialog) {
                this.f4614a = dialog;
            }

            public void onClick(View view) {
                AdvancedSettingActivity.this.n.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ, AVIOCTRLDEFs.SMsgAVIoctrlFormatExtStorageReq.parseContent(0));
                this.f4614a.dismiss();
                AdvancedSettingActivity.this.L = new ProgressDialog(AdvancedSettingActivity.this);
                AdvancedSettingActivity.this.L.setCancelable(false);
                AdvancedSettingActivity.this.L.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                AdvancedSettingActivity.this.L.setIndeterminate(true);
                AdvancedSettingActivity.this.L.show();
            }
        }

        public b() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(AdvancedSettingActivity.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) dialog.findViewById(R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new a(this, dialog));
            Button button2 = (Button) a.a.a.a.a.A(R.string.TR_FORMAT_SDCARD_CONFIRM_QUESTION, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new C0102b(dialog));
            dialog.show();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            AdvancedSettingActivity.this.k(true);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            AdvancedSettingActivity.this.k(false);
        }
    }

    public class e implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EditText f4619a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EditText f4620b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ EditText f4621c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ AlertDialog f4622d;

            public a(EditText editText, EditText editText2, EditText editText3, AlertDialog alertDialog) {
                this.f4619a = editText;
                this.f4620b = editText2;
                this.f4621c = editText3;
                this.f4622d = alertDialog;
            }

            public void onClick(View view) {
                String obj = this.f4619a.getText().toString();
                String obj2 = this.f4620b.getText().toString();
                String obj3 = this.f4621c.getText().toString();
                if (obj.length() == 0 || obj2.length() == 0 || obj3.length() == 0) {
                    Toast.makeText(AdvancedSettingActivity.this, a.c.a.d.a.h(R.string.TR_TIPS_ALL_FIELD_CAN_NOT_EMPTY), 0).show();
                } else if (!obj.equalsIgnoreCase(AdvancedSettingActivity.this.o.f)) {
                    Toast.makeText(AdvancedSettingActivity.this, a.c.a.d.a.h(R.string.TR_TIPS_OLD_PASSWORD_IS_WRONG), 0).show();
                } else if (!obj2.equalsIgnoreCase(obj3)) {
                    Toast.makeText(AdvancedSettingActivity.this, a.c.a.d.a.h(R.string.TR_TIPS_NEW_PASSWORD_DO_NOT_MATCH), 0).show();
                } else {
                    a.h.a.n0.c cVar = AdvancedSettingActivity.this.n;
                    if (cVar != null) {
                        cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SETPASSWORD_REQ, AVIOCTRLDEFs.SMsgAVIoctrlSetPasswdReq.parseContent(obj, obj2));
                    }
                    AdvancedSettingActivity.S = obj2;
                    AdvancedSettingActivity.T = true;
                    this.f4622d.dismiss();
                }
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AlertDialog f4624a;

            public b(e eVar, AlertDialog alertDialog) {
                this.f4624a = alertDialog;
            }

            public void onClick(View view) {
                this.f4624a.dismiss();
            }
        }

        public e() {
        }

        public void onClick(View view) {
            AlertDialog create = new AlertDialog.Builder(new ContextThemeWrapper()).create();
            create.setTitle(a.c.a.d.a.h(R.string.TR_MODIFY_SECURITY_CODE));
            create.setIcon(17301573);
            View inflate = create.getLayoutInflater().inflate(R.layout.modify_security_code, (ViewGroup) null);
            create.setView(inflate);
            ((TextView) inflate.findViewById(R.id.txtOldPassword)).setText(a.c.a.d.a.h(R.string.TR_OLD_PASSWORD));
            ((TextView) inflate.findViewById(R.id.txtNewPassword)).setText(a.c.a.d.a.h(R.string.TR_NEW_PASSWORD));
            ((TextView) inflate.findViewById(R.id.txtConfirmPassword)).setText(a.c.a.d.a.h(R.string.TR_CONFIRM_PASSWORD));
            Button button = (Button) inflate.findViewById(R.id.btnOK);
            button.setText(a.c.a.d.a.h(R.string.TR_OK));
            Button button2 = (Button) inflate.findViewById(R.id.btnCancel);
            button2.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
            button.setOnClickListener(new a((EditText) inflate.findViewById(R.id.edtOldPassword), (EditText) inflate.findViewById(R.id.edtNewPassword), (EditText) inflate.findViewById(R.id.edtConfirmPassword), create));
            button2.setOnClickListener(new b(this, create));
            create.show();
        }
    }

    public class f extends Handler {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                AdvancedSettingActivity.this.n.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_LISTWIFIAP_REQ, AVIOCTRLDEFs.SMsgAVIoctrlListWifiApReq.parseContent());
            }
        }

        public f() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x011f, code lost:
            r1.setText(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x02c4, code lost:
            r0.f4625a.j.setEnabled(true);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r27) {
            /*
                r26 = this;
                r0 = r26
                android.os.Bundle r1 = r27.getData()
                java.lang.String r2 = "data"
                byte[] r1 = r1.getByteArray(r2)
                r2 = r27
                int r3 = r2.what
                r5 = 1
                r6 = 2131821419(0x7f11036b, float:1.927558E38)
                r7 = 2131821349(0x7f110325, float:1.9275439E38)
                r8 = 32
                r9 = 0
                r10 = 2131821351(0x7f110327, float:1.9275443E38)
                r11 = 2131821348(0x7f110324, float:1.9275437E38)
                r12 = 2131821347(0x7f110323, float:1.9275435E38)
                r13 = 2
                r14 = 3
                r15 = 4
                r4 = 0
                switch(r3) {
                    case 787: goto L_0x0443;
                    case 803: goto L_0x0427;
                    case 807: goto L_0x03c9;
                    case 817: goto L_0x02e4;
                    case 819: goto L_0x02cd;
                    case 833: goto L_0x01d3;
                    case 835: goto L_0x01c3;
                    case 837: goto L_0x0124;
                    case 839: goto L_0x0082;
                    case 867: goto L_0x0068;
                    case 883: goto L_0x004e;
                    case 897: goto L_0x002c;
                    default: goto L_0x002a;
                }
            L_0x002a:
                goto L_0x0468
            L_0x002c:
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.app.ProgressDialog r3 = r3.L
                if (r3 == 0) goto L_0x0035
                r3.dismiss()
            L_0x0035:
                byte r1 = r1[r15]
                if (r1 != 0) goto L_0x003f
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r3 = 2131821402(0x7f11035a, float:1.9275546E38)
                goto L_0x0044
            L_0x003f:
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r3 = 2131821401(0x7f110359, float:1.9275544E38)
            L_0x0044:
                java.lang.String r3 = a.c.a.d.a.h(r3)
                android.widget.Toast r1 = android.widget.Toast.makeText(r1, r3, r9)
                goto L_0x02df
            L_0x004e:
                byte r1 = r1[r15]
                if (r1 < 0) goto L_0x0468
                if (r1 > r14) goto L_0x0468
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r3 = r3.x
                r3.setSelection(r1, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r3 = r3.x
                r3.setEnabled(r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r3.D = r1
                goto L_0x0468
            L_0x0068:
                byte r1 = r1[r15]
                if (r1 < 0) goto L_0x0468
                if (r1 > r14) goto L_0x0468
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r3 = r3.y
                r3.setSelection(r1, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r3 = r3.y
                r3.setEnabled(r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r3.E = r1
                goto L_0x0468
            L_0x0082:
                com.tutk.IOTC.AVIOCTRLDEFs.SWifiAp.getTotalSize()
                byte[] r3 = new byte[r8]
                java.lang.System.arraycopy(r1, r9, r3, r9, r8)
                r8 = 99
                byte r1 = r1[r8]
                if (r1 != 0) goto L_0x00ac
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r12)
                goto L_0x011f
            L_0x00ac:
                if (r1 != r5) goto L_0x00c9
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r11)
                goto L_0x011f
            L_0x00c9:
                if (r1 != r13) goto L_0x00e6
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r10)
                goto L_0x011f
            L_0x00e6:
                if (r1 != r14) goto L_0x0103
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r6)
                goto L_0x011f
            L_0x0103:
                if (r1 != r15) goto L_0x02c4
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r7)
            L_0x011f:
                r1.setText(r3)
                goto L_0x02c4
            L_0x0124:
                com.tutk.IOTC.AVIOCTRLDEFs.SWifiAp.getTotalSize()
                byte[] r3 = new byte[r8]
                java.lang.System.arraycopy(r1, r9, r3, r9, r8)
                r8 = 67
                byte r1 = r1[r8]
                if (r1 != 0) goto L_0x014d
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r12)
                goto L_0x011f
            L_0x014d:
                if (r1 != r5) goto L_0x016a
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r11)
                goto L_0x011f
            L_0x016a:
                if (r1 != r13) goto L_0x0187
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r10)
                goto L_0x011f
            L_0x0187:
                if (r1 != r14) goto L_0x01a5
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r6)
                goto L_0x011f
            L_0x01a5:
                if (r1 != r15) goto L_0x02c4
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r3)
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.p
                r1.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.q
                java.lang.String r3 = a.c.a.d.a.h(r7)
                goto L_0x011f
            L_0x01c3:
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.os.Handler r1 = r1.R
                com.sozpic.miniland.video.AdvancedSettingActivity$f$a r3 = new com.sozpic.miniland.video.AdvancedSettingActivity$f$a
                r3.<init>()
                r4 = 30000(0x7530, double:1.4822E-319)
                r1.postDelayed(r3, r4)
                goto L_0x0468
            L_0x01d3:
                int r3 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r1, r9)
                int r17 = com.tutk.IOTC.AVIOCTRLDEFs.SWifiAp.getTotalSize()
                java.util.List<com.tutk.IOTC.AVIOCTRLDEFs$SWifiAp> r18 = com.sozpic.miniland.video.AdvancedSettingActivity.V
                r18.clear()
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.p
                r19 = 2131821163(0x7f11026b, float:1.9275061E38)
                java.lang.String r6 = a.c.a.d.a.h(r19)
                r7.setText(r6)
                com.sozpic.miniland.video.AdvancedSettingActivity r6 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r6 = r6.p
                r6.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r6 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r6 = r6.q
                java.lang.String r7 = a.c.a.d.a.h(r12)
                r6.setText(r7)
                if (r3 <= 0) goto L_0x02c4
                int r6 = r1.length
                r7 = 40
                if (r6 < r7) goto L_0x02c4
                r6 = 0
            L_0x0208:
                if (r6 >= r3) goto L_0x02c4
                byte[] r7 = new byte[r8]
                int r12 = r6 * r17
                int r12 = r12 + r15
                java.lang.System.arraycopy(r1, r12, r7, r9, r8)
                int r16 = r12 + 32
                byte r22 = r1[r16]
                int r16 = r12 + 33
                byte r23 = r1[r16]
                int r16 = r12 + 34
                byte r24 = r1[r16]
                int r12 = r12 + 35
                byte r12 = r1[r12]
                java.util.List<com.tutk.IOTC.AVIOCTRLDEFs$SWifiAp> r8 = com.sozpic.miniland.video.AdvancedSettingActivity.V
                com.tutk.IOTC.AVIOCTRLDEFs$SWifiAp r9 = new com.tutk.IOTC.AVIOCTRLDEFs$SWifiAp
                r20 = r9
                r21 = r7
                r25 = r12
                r20.<init>(r21, r22, r23, r24, r25)
                r8.add(r9)
                if (r12 != r5) goto L_0x024f
                com.sozpic.miniland.video.AdvancedSettingActivity r8 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r8 = r8.p
                java.lang.String r7 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r7)
                r8.setText(r7)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.p
                r7.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.q
                java.lang.String r8 = a.c.a.d.a.h(r11)
                goto L_0x026b
            L_0x024f:
                if (r12 != r13) goto L_0x0275
                com.sozpic.miniland.video.AdvancedSettingActivity r8 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r8 = r8.p
                java.lang.String r7 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r7)
                r8.setText(r7)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.p
                r7.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.q
                java.lang.String r8 = a.c.a.d.a.h(r10)
            L_0x026b:
                r7.setText(r8)
                r8 = 2131821419(0x7f11036b, float:1.927558E38)
            L_0x0271:
                r9 = 2131821349(0x7f110325, float:1.9275439E38)
                goto L_0x02bd
            L_0x0275:
                if (r12 != r14) goto L_0x0298
                com.sozpic.miniland.video.AdvancedSettingActivity r8 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r8 = r8.p
                java.lang.String r7 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r7)
                r8.setText(r7)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.p
                r7.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.q
                r8 = 2131821419(0x7f11036b, float:1.927558E38)
                java.lang.String r9 = a.c.a.d.a.h(r8)
                r7.setText(r9)
                goto L_0x0271
            L_0x0298:
                r8 = 2131821419(0x7f11036b, float:1.927558E38)
                if (r12 != r15) goto L_0x0271
                com.sozpic.miniland.video.AdvancedSettingActivity r9 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r9 = r9.p
                java.lang.String r7 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r7)
                r9.setText(r7)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.p
                r7.setTypeface(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r7 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r7 = r7.q
                r9 = 2131821349(0x7f110325, float:1.9275439E38)
                java.lang.String r12 = a.c.a.d.a.h(r9)
                r7.setText(r12)
            L_0x02bd:
                int r6 = r6 + 1
                r8 = 32
                r9 = 0
                goto L_0x0208
            L_0x02c4:
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Button r1 = r1.j
                r1.setEnabled(r5)
                goto L_0x0468
            L_0x02cd:
                r3 = 0
                byte r1 = r1[r3]
                if (r1 != 0) goto L_0x0468
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r4 = 2131821403(0x7f11035b, float:1.9275548E38)
                java.lang.String r4 = a.c.a.d.a.h(r4)
                android.widget.Toast r1 = android.widget.Toast.makeText(r1, r4, r3)
            L_0x02df:
                r1.show()
                goto L_0x0468
            L_0x02e4:
                r3 = 0
                r6 = 16
                byte[] r7 = new byte[r6]
                byte[] r8 = new byte[r6]
                java.lang.System.arraycopy(r1, r3, r7, r3, r6)
                java.lang.System.arraycopy(r1, r6, r8, r3, r6)
                java.lang.String r3 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r7)
                java.lang.String r6 = com.sozpic.miniland.video.AdvancedSettingActivity.c(r8)
                r7 = 32
                int r7 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r1, r7)
                r8 = 44
                int r8 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r1, r8)
                com.sozpic.miniland.video.AdvancedSettingActivity r9 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r10 = 40
                int r1 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r1, r10)
                r9.H = r1
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.r
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.s
                byte[] r3 = new byte[r15]
                java.lang.StringBuffer r9 = new java.lang.StringBuffer
                r9.<init>()
                byte r10 = (byte) r7
                r3[r14] = r10
                int r10 = r7 >>> 8
                byte r10 = (byte) r10
                r3[r13] = r10
                int r10 = r7 >>> 16
                byte r10 = (byte) r10
                r3[r5] = r10
                int r7 = r7 >>> 24
                byte r7 = (byte) r7
                r10 = 0
                r3[r10] = r7
                byte r7 = r3[r10]
                r7 = r7 & 255(0xff, float:3.57E-43)
                r9.append(r7)
                r7 = 46
                r9.append(r7)
                byte r5 = r3[r5]
                r5 = r5 & 255(0xff, float:3.57E-43)
                r9.append(r5)
                r9.append(r7)
                byte r5 = r3[r13]
                r5 = r5 & 255(0xff, float:3.57E-43)
                r9.append(r5)
                r9.append(r7)
                byte r3 = r3[r14]
                r3 = r3 & 255(0xff, float:3.57E-43)
                r9.append(r3)
                java.lang.String r3 = r9.toString()
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.t
                r1.setText(r6)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.v
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = java.lang.String.valueOf(r8)
                r3.append(r5)
                java.lang.String r5 = " MB"
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                r1.setText(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.r
                r3 = 0
                r1.setTypeface(r4, r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.s
                r1.setTypeface(r4, r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.t
                r1.setTypeface(r4, r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.u
                r1.setTypeface(r4, r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.v
                r1.setTypeface(r4, r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.TextView r1 = r1.u
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                com.sozpic.miniland.video.AdvancedSettingActivity r4 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                int r4 = r4.H
                java.lang.String r4 = java.lang.String.valueOf(r4)
                r3.append(r4)
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                r1.setText(r3)
                goto L_0x0468
            L_0x03c9:
                int r1 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r1, r15)
                if (r1 != 0) goto L_0x03dc
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r1 = r1.z
                r3 = 0
                r1.setSelection(r3)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r1.G = r3
                goto L_0x041f
            L_0x03dc:
                r3 = 25
                if (r1 <= 0) goto L_0x03ee
                if (r1 > r3) goto L_0x03ee
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r1 = r1.z
                r1.setSelection(r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r1.G = r5
                goto L_0x041f
            L_0x03ee:
                r4 = 45
                if (r1 <= r3) goto L_0x0400
                if (r1 > r4) goto L_0x0400
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r1 = r1.z
                r1.setSelection(r13)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r1.G = r13
                goto L_0x041f
            L_0x0400:
                r3 = 65
                if (r1 <= r4) goto L_0x0412
                if (r1 > r3) goto L_0x0412
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r1 = r1.z
                r1.setSelection(r14)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r1.G = r14
                goto L_0x041f
            L_0x0412:
                if (r1 <= r3) goto L_0x041f
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r1 = r1.z
                r1.setSelection(r15)
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r1.G = r15
            L_0x041f:
                com.sozpic.miniland.video.AdvancedSettingActivity r1 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r1 = r1.z
                r1.setEnabled(r5)
                goto L_0x0468
            L_0x0427:
                byte r1 = r1[r15]
                if (r1 < 0) goto L_0x0468
                r3 = 5
                if (r1 > r3) goto L_0x0468
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r3 = r3.w
                int r4 = r1 + -1
                r3.setSelection(r4, r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                android.widget.Spinner r3 = r3.w
                r3.setEnabled(r5)
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this
                r3.C = r1
                goto L_0x0468
            L_0x0443:
                int r1 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r1, r15)
                if (r1 != 0) goto L_0x0458
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this     // Catch:{ Exception -> 0x0468 }
                android.widget.Spinner r3 = r3.B     // Catch:{ Exception -> 0x0468 }
                r3.setSelection(r1)     // Catch:{ Exception -> 0x0468 }
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this     // Catch:{ Exception -> 0x0468 }
            L_0x0452:
                android.widget.Spinner r3 = r3.B     // Catch:{ Exception -> 0x0468 }
                r3.setEnabled(r5)     // Catch:{ Exception -> 0x0468 }
                goto L_0x0464
            L_0x0458:
                if (r1 != r13) goto L_0x0468
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this     // Catch:{ Exception -> 0x0468 }
                android.widget.Spinner r3 = r3.B     // Catch:{ Exception -> 0x0468 }
                r3.setSelection(r5)     // Catch:{ Exception -> 0x0468 }
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this     // Catch:{ Exception -> 0x0468 }
                goto L_0x0452
            L_0x0464:
                com.sozpic.miniland.video.AdvancedSettingActivity r3 = com.sozpic.miniland.video.AdvancedSettingActivity.this     // Catch:{ Exception -> 0x0468 }
                r3.F = r1     // Catch:{ Exception -> 0x0468 }
            L_0x0468:
                super.handleMessage(r27)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.video.AdvancedSettingActivity.f.handleMessage(android.os.Message):void");
        }
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < bArr.length && bArr[i2] != 0) {
            sb.append((char) bArr[i2]);
            i2++;
        }
        return sb.toString();
    }

    public void a() {
        k(false);
    }

    public void b() {
    }

    public final void e() {
        this.r.setText(a.c.a.d.a.h(R.string.TR_LOADING));
        this.s.setText(a.c.a.d.a.h(R.string.TR_LOADING));
        this.t.setText(a.c.a.d.a.h(R.string.TR_LOADING));
        this.u.setText(a.c.a.d.a.h(R.string.TR_LOADING));
        this.v.setText(a.c.a.d.a.h(R.string.TR_LOADING));
        this.r.setTypeface((Typeface) null, 3);
        this.s.setTypeface((Typeface) null, 3);
        this.t.setTypeface((Typeface) null, 3);
        this.u.setTypeface((Typeface) null, 3);
        this.v.setTypeface((Typeface) null, 3);
        a.h.a.n0.c cVar = this.n;
        if (cVar != null) {
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
        }
    }

    public final void f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.c.a.d.a.h(R.string.TR_EVENT_NOTIFICATION_SILENCE));
        arrayList.add(a.c.a.d.a.h(R.string.TR_EVENT_NOTIFICATION_RINGTONE_ONLY));
        arrayList.add(a.c.a.d.a.h(R.string.TR_EVENT_NOTIFICATION_VIBRATION_ONLY));
        arrayList.add(a.c.a.d.a.h(R.string.TR_EVENT_NOTIFICATION_RINGTONE_AND_VIBRATION));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.A.setAdapter(arrayAdapter);
        this.A.setSelection(this.o.i);
    }

    public final void g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.c.a.d.a.h(R.string.TR_MOTION_DETECTION_OFF));
        arrayList.add(a.c.a.d.a.h(R.string.TR_MOTION_DETECTION_LOW));
        arrayList.add(a.c.a.d.a.h(R.string.TR_MOTION_DETECTION_MEDIUM));
        arrayList.add(a.c.a.d.a.h(R.string.TR_MOTION_DETECTION_HIGH));
        arrayList.add(a.c.a.d.a.h(R.string.TR_MOTION_DETECTION_MAX));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.z.setAdapter(arrayAdapter);
        this.z.setEnabled(false);
        a.h.a.n0.c cVar = this.n;
        if (cVar != null) {
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETMOTIONDETECT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetMotionDetectReq.parseContent(this.o.j));
        }
    }

    public final void h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.c.a.d.a.h(R.string.TR_RECORDING_MODE_OFF));
        arrayList.add(a.c.a.d.a.h(R.string.TR_RECORDING_MODE_ON));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.B.setAdapter(arrayAdapter);
        this.B.setEnabled(false);
        a.h.a.n0.c cVar = this.n;
        if (cVar != null) {
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETRECORD_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetMotionDetectReq.parseContent(this.o.j));
        }
    }

    public final void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.c.a.d.a.h(R.string.TR_VIDEO_QUALITY_MAX));
        arrayList.add(a.c.a.d.a.h(R.string.TR_VIDEO_QUALITY_ALTO));
        arrayList.add(a.c.a.d.a.h(R.string.TR_VIDEO_QUALITY_MEDIO));
        arrayList.add(a.c.a.d.a.h(R.string.TR_VIDEO_QUALITY_BAJO));
        arrayList.add(a.c.a.d.a.h(R.string.TR_VIDEO_QUALITY_MIN));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.w.setAdapter(arrayAdapter);
        this.w.setSelection(2);
        this.w.setEnabled(false);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(a.c.a.d.a.h(R.string.TR_VIDEO_FLIP_NORMAL));
        arrayList2.add(a.c.a.d.a.h(R.string.TR_VIDEO_FLIP_FLIP));
        arrayList2.add(a.c.a.d.a.h(R.string.TR_VIDEO_FLIP_MIRROR));
        arrayList2.add(a.c.a.d.a.h(R.string.TR_VIDEO_FLIP_FLIP_MIRROR));
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        this.x.setAdapter(arrayAdapter2);
        this.x.setSelection(0);
        this.x.setEnabled(false);
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this, R.array.environment_mode, R.layout.spinner_item);
        createFromResource.setDropDownViewResource(R.layout.spinner_item);
        this.y.setAdapter(createFromResource);
        this.y.setSelection(0);
        this.y.setEnabled(false);
        a.h.a.n0.c cVar = this.n;
        if (cVar != null) {
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSTREAMCTRL_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetStreamCtrlReq.parseContent(this.o.j));
            this.n.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GET_VIDEOMODE_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetVideoModeReq.parseContent(this.o.j));
            this.n.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GET_ENVIRONMENT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetEnvironmentReq.parseContent(this.o.j));
        }
    }

    public final void j() {
        this.p.setText(a.c.a.d.a.h(R.string.TR_LOADING));
        this.p.setTypeface((Typeface) null, 3);
        this.j.setEnabled(false);
        a.h.a.n0.c cVar = this.n;
        if (cVar != null) {
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_LISTWIFIAP_REQ, AVIOCTRLDEFs.SMsgAVIoctrlListWifiApReq.parseContent());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0179  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(boolean r23) {
        /*
            r22 = this;
            r0 = r22
            android.widget.Spinner r1 = r0.w
            int r1 = r1.getSelectedItemPosition()
            r2 = 1
            int r1 = r1 + r2
            android.widget.Spinner r3 = r0.x
            int r3 = r3.getSelectedItemPosition()
            android.widget.Spinner r4 = r0.y
            int r4 = r4.getSelectedItemPosition()
            android.widget.Spinner r5 = r0.B
            int r5 = r5.getSelectedItemPosition()
            android.widget.Spinner r6 = r0.A
            int r6 = r6.getSelectedItemPosition()
            android.widget.Spinner r7 = r0.z
            int r7 = r7.getSelectedItemPosition()
            r8 = -1
            r9 = 0
            if (r23 == 0) goto L_0x0110
            a.h.a.n0.b r10 = r0.o
            r10.i = r6
            a.h.a.n0.a r11 = new a.h.a.n0.a
            r11.<init>(r0)
            a.h.a.n0.b r6 = r0.o
            long r12 = r6.f3525a
            java.lang.String r14 = r6.f3528d
            java.lang.String r15 = r6.f3527c
            java.lang.String r10 = r6.f
            int r2 = r6.i
            int r6 = r6.j
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            java.lang.String r18 = "admin"
            r19 = r10
            r20 = r2
            r21 = r6
            r11.g(r12, r14, r15, r16, r17, r18, r19, r20, r21)
            a.h.a.n0.c r2 = r0.n
            if (r2 == 0) goto L_0x0110
            int r6 = r0.C
            if (r6 == r8) goto L_0x006a
            if (r6 == r1) goto L_0x006a
            r6 = 800(0x320, float:1.121E-42)
            a.h.a.n0.b r10 = r0.o
            int r10 = r10.j
            byte r11 = (byte) r1
            byte[] r10 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlSetStreamCtrlReq.parseContent(r10, r11)
            r2.sendIOCtrl(r9, r6, r10)
        L_0x006a:
            int r2 = r0.D
            if (r2 == r8) goto L_0x0080
            if (r2 == r3) goto L_0x0080
            a.h.a.n0.c r2 = r0.n
            r6 = 880(0x370, float:1.233E-42)
            a.h.a.n0.b r10 = r0.o
            int r10 = r10.j
            byte r11 = (byte) r3
            byte[] r10 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlSetVideoModeReq.parseContent(r10, r11)
            r2.sendIOCtrl(r9, r6, r10)
        L_0x0080:
            int r2 = r0.E
            if (r2 == r8) goto L_0x0096
            if (r2 == r4) goto L_0x0096
            a.h.a.n0.c r2 = r0.n
            r6 = 864(0x360, float:1.211E-42)
            a.h.a.n0.b r10 = r0.o
            int r10 = r10.j
            byte r11 = (byte) r4
            byte[] r10 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlSetEnvironmentReq.parseContent(r10, r11)
            r2.sendIOCtrl(r9, r6, r10)
        L_0x0096:
            int r2 = r0.G
            r6 = 2
            if (r2 == r8) goto L_0x00e4
            if (r2 == r7) goto L_0x00e4
            android.widget.Spinner r2 = r0.z
            int r2 = r2.getSelectedItemPosition()
            if (r2 != 0) goto L_0x00a7
        L_0x00a5:
            r2 = 0
            goto L_0x00d5
        L_0x00a7:
            android.widget.Spinner r2 = r0.z
            int r2 = r2.getSelectedItemPosition()
            r10 = 1
            if (r2 != r10) goto L_0x00b3
            r2 = 25
            goto L_0x00d5
        L_0x00b3:
            android.widget.Spinner r2 = r0.z
            int r2 = r2.getSelectedItemPosition()
            if (r2 != r6) goto L_0x00be
            r2 = 45
            goto L_0x00d5
        L_0x00be:
            android.widget.Spinner r2 = r0.z
            int r2 = r2.getSelectedItemPosition()
            r10 = 3
            if (r2 != r10) goto L_0x00ca
            r2 = 65
            goto L_0x00d5
        L_0x00ca:
            android.widget.Spinner r2 = r0.z
            int r2 = r2.getSelectedItemPosition()
            r10 = 4
            if (r2 != r10) goto L_0x00a5
            r2 = 80
        L_0x00d5:
            a.h.a.n0.c r10 = r0.n
            r11 = 804(0x324, float:1.127E-42)
            a.h.a.n0.b r12 = r0.o
            int r12 = r12.j
            byte[] r2 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlSetMotionDetectReq.parseContent(r12, r2)
            r10.sendIOCtrl(r9, r11, r2)
        L_0x00e4:
            int r2 = r0.F
            if (r2 == r8) goto L_0x0110
            if (r2 == r5) goto L_0x0110
            android.widget.Spinner r2 = r0.B
            int r2 = r2.getSelectedItemPosition()
            if (r2 != 0) goto L_0x00f5
            r6 = 0
            r10 = 1
            goto L_0x0100
        L_0x00f5:
            android.widget.Spinner r2 = r0.B
            int r2 = r2.getSelectedItemPosition()
            r10 = 1
            if (r2 != r10) goto L_0x00ff
            goto L_0x0100
        L_0x00ff:
            r6 = 0
        L_0x0100:
            a.h.a.n0.c r2 = r0.n
            r11 = 784(0x310, float:1.099E-42)
            a.h.a.n0.b r12 = r0.o
            int r12 = r12.j
            byte[] r6 = com.tutk.IOTC.AVIOCTRLDEFs.SMsgAVIoctrlSetRecordReq.parseContent(r12, r6)
            r2.sendIOCtrl(r9, r11, r6)
            goto L_0x0111
        L_0x0110:
            r10 = 1
        L_0x0111:
            boolean r2 = T
            if (r2 == 0) goto L_0x0142
            a.h.a.n0.b r6 = r0.o
            if (r2 == 0) goto L_0x011c
            java.lang.String r2 = S
            goto L_0x011e
        L_0x011c:
            java.lang.String r2 = r6.f
        L_0x011e:
            r6.f = r2
            a.h.a.n0.a r11 = new a.h.a.n0.a
            r11.<init>(r0)
            a.h.a.n0.b r2 = r0.o
            long r12 = r2.f3525a
            java.lang.String r14 = r2.f3528d
            java.lang.String r15 = r2.f3527c
            java.lang.String r6 = r2.f
            int r9 = r2.i
            int r2 = r2.j
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            java.lang.String r18 = "admin"
            r19 = r6
            r20 = r9
            r21 = r2
            r11.g(r12, r14, r15, r16, r17, r18, r19, r20, r21)
        L_0x0142:
            a.h.a.n0.c r2 = r0.n
            if (r2 == 0) goto L_0x0149
            r2.unregisterIOTCListener(r0)
        L_0x0149:
            if (r23 == 0) goto L_0x016b
            int r2 = r0.C
            if (r2 == r8) goto L_0x0151
            if (r1 != r2) goto L_0x0169
        L_0x0151:
            int r1 = r0.D
            if (r1 == r8) goto L_0x0157
            if (r3 != r1) goto L_0x0169
        L_0x0157:
            int r1 = r0.E
            if (r1 == r8) goto L_0x015d
            if (r4 != r1) goto L_0x0169
        L_0x015d:
            int r1 = r0.F
            if (r1 == r8) goto L_0x0163
            if (r5 != r1) goto L_0x0169
        L_0x0163:
            int r1 = r0.G
            if (r1 == r8) goto L_0x016b
            if (r7 == r1) goto L_0x016b
        L_0x0169:
            r1 = 1
            goto L_0x016c
        L_0x016b:
            r1 = 0
        L_0x016c:
            if (r1 != 0) goto L_0x0179
            boolean r1 = T
            if (r1 != 0) goto L_0x0179
            boolean r1 = U
            if (r1 == 0) goto L_0x0177
            goto L_0x0179
        L_0x0177:
            r2 = 0
            goto L_0x017a
        L_0x0179:
            r2 = 1
        L_0x017a:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = "need_reconnect"
            r3.putBoolean(r4, r2)
            boolean r2 = T
            java.lang.String r4 = "change_password"
            r3.putBoolean(r4, r2)
            java.lang.String r2 = S
            java.lang.String r4 = "new_password"
            r3.putString(r4, r2)
            r1.putExtras(r3)
            if (r23 != 0) goto L_0x01a6
            boolean r2 = T
            if (r2 != 0) goto L_0x01a6
            boolean r2 = U
            if (r2 == 0) goto L_0x01a5
            goto L_0x01a6
        L_0x01a5:
            r8 = 0
        L_0x01a6:
            r0.setResult(r8, r1)
            r22.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.video.AdvancedSettingActivity.k(boolean):void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = getResources().getConfiguration().orientation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0472  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            super.onCreate(r11)
            r11 = 1
            r10.requestWindowFeature(r11)
            android.view.Window r0 = r10.getWindow()
            r1 = 128(0x80, float:1.794E-43)
            r0.setFlags(r1, r1)
            r0 = 2131492961(0x7f0c0061, float:1.8609389E38)
            r10.setContentView(r0)
            r0 = 2131296574(0x7f09013e, float:1.8211069E38)
            android.view.View r0 = r10.findViewById(r0)
            com.sozpic.miniland.video.TopMenuActivityVideo r0 = (com.sozpic.miniland.video.TopMenuActivityVideo) r0
            r10.K = r0
            r0.setListener(r10)
            com.sozpic.miniland.video.TopMenuActivityVideo r0 = r10.K
            r1 = 2131821106(0x7f110232, float:1.9274946E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setSeccion(r1)
            r0 = 2131297842(0x7f090632, float:1.821364E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821476(0x7f1103a4, float:1.9275696E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297841(0x7f090631, float:1.8213638E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821470(0x7f11039e, float:1.9275684E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297839(0x7f09062f, float:1.8213634E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821465(0x7f110399, float:1.9275674E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131296729(0x7f0901d9, float:1.8211383E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820833(0x7f110121, float:1.9274392E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297800(0x7f090608, float:1.8213555E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821290(0x7f1102ea, float:1.927532E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297821(0x7f09061d, float:1.8213598E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821491(0x7f1103b3, float:1.9275727E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297758(0x7f0905de, float:1.821347E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820901(0x7f110165, float:1.927453E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297773(0x7f0905ed, float:1.82135E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820913(0x7f110171, float:1.9274554E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297779(0x7f0905f3, float:1.8213513E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821164(0x7f11026c, float:1.9275063E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297771(0x7f0905eb, float:1.8213496E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821137(0x7f110251, float:1.9275009E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297761(0x7f0905e1, float:1.8213476E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821400(0x7f110358, float:1.9275542E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297753(0x7f0905d9, float:1.821346E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820775(0x7f1100e7, float:1.9274274E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297772(0x7f0905ec, float:1.8213498E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821138(0x7f110252, float:1.927501E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297815(0x7f090617, float:1.8213586E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821461(0x7f110395, float:1.9275666E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297748(0x7f0905d4, float:1.821345E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820672(0x7f110080, float:1.9274066E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297810(0x7f090612, float:1.8213575E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821425(0x7f110371, float:1.9275593E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297764(0x7f0905e4, float:1.8213482E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820977(0x7f1101b1, float:1.9274684E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297808(0x7f090610, float:1.8213571E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821493(0x7f1103b5, float:1.927573E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297757(0x7f0905dd, float:1.8213468E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820852(0x7f110134, float:1.927443E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r0.setText(r1)
            r0 = 2131297790(0x7f0905fe, float:1.8213535E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131821256(0x7f1102c8, float:1.927525E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            android.content.Intent r0 = r10.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r1 = "dev_uuid"
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "dev_uid"
            java.lang.String r0 = r0.getString(r2)
            r2 = 2131297825(0x7f090621, float:1.8213606E38)
            android.view.View r2 = r10.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r10.J = r2
            r2.setText(r0)
            java.util.List<a.h.a.n0.c> r2 = com.sozpic.miniland.video.MainActivity3.o
            java.util.Iterator r2 = r2.iterator()
        L_0x01d8:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01fb
            java.lang.Object r3 = r2.next()
            a.h.a.n0.c r3 = (a.h.a.n0.c) r3
            java.lang.String r4 = r3.b()
            boolean r4 = r1.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x01d8
            java.lang.String r4 = r3.f3531b
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x01d8
            r10.n = r3
            r3.registerIOTCListener(r10)
        L_0x01fb:
            java.util.List<a.h.a.n0.b> r2 = com.sozpic.miniland.video.MainActivity3.p
            java.util.Iterator r2 = r2.iterator()
        L_0x0201:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x021f
            java.lang.Object r3 = r2.next()
            a.h.a.n0.b r3 = (a.h.a.n0.b) r3
            java.lang.String r4 = r3.f3526b
            boolean r4 = r1.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0201
            java.lang.String r4 = r3.f3528d
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0201
            r10.o = r3
        L_0x021f:
            r0 = 2131296872(0x7f090268, float:1.8211673E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r10.I = r0
            a.h.a.n0.b r1 = r10.o
            android.graphics.Bitmap r1 = r1.h
            r0.setImageBitmap(r1)
            a.h.a.n0.b r0 = r10.o
            java.lang.String r0 = r0.f
            S = r0
            r0 = 2131297216(0x7f0903c0, float:1.821237E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.f4598a = r0
            r0 = 2131297215(0x7f0903bf, float:1.8212369E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.f4599b = r0
            r0 = 2131297211(0x7f0903bb, float:1.821236E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.f4600c = r0
            r0 = 2131297217(0x7f0903c1, float:1.8212373E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.f4601d = r0
            r0 = 2131297212(0x7f0903bc, float:1.8212363E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.f4602e = r0
            r0 = 2131297214(0x7f0903be, float:1.8212367E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.f = r0
            r0 = 2131297213(0x7f0903bd, float:1.8212365E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.g = r0
            r0 = 2131297210(0x7f0903ba, float:1.8212358E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.h = r0
            r0 = 2131296497(0x7f0900f1, float:1.8210912E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r10.i = r0
            r1 = 2131821140(0x7f110254, float:1.9275015E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131296496(0x7f0900f0, float:1.821091E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r10.j = r0
            r1 = 2131821062(0x7f110206, float:1.9274857E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131296495(0x7f0900ef, float:1.8210908E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r10.k = r0
            r0 = 2131296498(0x7f0900f2, float:1.8210914E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r10.l = r0
            r1 = 2131821192(0x7f110288, float:1.927512E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r0.setText(r1)
            r0 = 2131296492(0x7f0900ec, float:1.8210902E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r10.m = r0
            r1 = 2131820651(0x7f11006b, float:1.9274023E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r0.setText(r1)
            r0 = 2131297484(0x7f0904cc, float:1.8212914E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r10.w = r0
            r0 = 2131297483(0x7f0904cb, float:1.8212912E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r10.x = r0
            r0 = 2131297478(0x7f0904c6, float:1.8212902E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r10.y = r0
            r0 = 2131297481(0x7f0904c9, float:1.8212908E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r10.z = r0
            r0 = 2131297479(0x7f0904c7, float:1.8212904E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r10.A = r0
            r0 = 2131297482(0x7f0904ca, float:1.821291E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r10.B = r0
            r0 = 2131297817(0x7f090619, float:1.821359E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.p = r0
            r0 = 2131297820(0x7f09061c, float:1.8213596E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.q = r0
            r0 = 2131297754(0x7f0905da, float:1.8213462E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.r = r0
            r0 = 2131297755(0x7f0905db, float:1.8213464E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.s = r0
            r0 = 2131297814(0x7f090616, float:1.8213584E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.t = r0
            r0 = 2131297805(0x7f09060d, float:1.8213565E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.u = r0
            r0 = 2131297804(0x7f09060c, float:1.8213563E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.v = r0
            android.widget.Button r0 = r10.i
            android.view.View$OnClickListener r1 = r10.Q
            r0.setOnClickListener(r1)
            android.widget.Button r0 = r10.j
            android.view.View$OnClickListener r1 = r10.M
            r0.setOnClickListener(r1)
            android.widget.Button r0 = r10.k
            android.view.View$OnClickListener r1 = r10.N
            r0.setOnClickListener(r1)
            android.widget.Button r0 = r10.k
            r1 = 2131820972(0x7f1101ac, float:1.9274674E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            android.widget.Button r0 = r10.l
            android.view.View$OnClickListener r1 = r10.O
            r0.setOnClickListener(r1)
            android.widget.Button r0 = r10.m
            android.view.View$OnClickListener r1 = r10.P
            r0.setOnClickListener(r1)
            android.widget.LinearLayout r0 = r10.f4599b
            a.h.a.n0.c r1 = r10.n
            r2 = 0
            r4 = 8
            r5 = 0
            if (r1 == 0) goto L_0x03d1
            long r6 = r1.getChannelServiceType(r5)
            r8 = 512(0x200, double:2.53E-321)
            long r6 = r6 & r8
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x03cc
            r1 = 1
            goto L_0x03cd
        L_0x03cc:
            r1 = 0
        L_0x03cd:
            if (r1 == 0) goto L_0x03d1
            r1 = 0
            goto L_0x03d3
        L_0x03d1:
            r1 = 8
        L_0x03d3:
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r10.f4600c
            r0.setVisibility(r4)
            r10.i()
            r10.e()
            a.h.a.n0.c r0 = r10.n
            if (r0 == 0) goto L_0x03fe
            long r0 = r0.getChannelServiceType(r5)
            r6 = 32
            long r0 = r0 & r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x03f2
            r0 = 1
            goto L_0x03f3
        L_0x03f2:
            r0 = 0
        L_0x03f3:
            if (r0 == 0) goto L_0x03fe
            r10.j()
            android.widget.LinearLayout r0 = r10.f4601d
            r0.setVisibility(r5)
            goto L_0x0403
        L_0x03fe:
            android.widget.LinearLayout r0 = r10.f4601d
            r0.setVisibility(r4)
        L_0x0403:
            a.h.a.n0.c r0 = r10.n
            if (r0 == 0) goto L_0x0423
            long r0 = r0.getChannelServiceType(r5)
            r6 = 64
            long r0 = r0 & r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0414
            r0 = 1
            goto L_0x0415
        L_0x0414:
            r0 = 0
        L_0x0415:
            if (r0 == 0) goto L_0x0423
            r10.g()
            r10.f()
            android.widget.LinearLayout r0 = r10.f4602e
            r0.setVisibility(r5)
            goto L_0x0428
        L_0x0423:
            android.widget.LinearLayout r0 = r10.f4602e
            r0.setVisibility(r4)
        L_0x0428:
            a.h.a.n0.c r0 = r10.n
            if (r0 == 0) goto L_0x0445
            long r0 = r0.getChannelServiceType(r5)
            r6 = 128(0x80, double:6.32E-322)
            long r0 = r0 & r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0439
            r0 = 1
            goto L_0x043a
        L_0x0439:
            r0 = 0
        L_0x043a:
            if (r0 == 0) goto L_0x0445
            r10.h()
            android.widget.LinearLayout r0 = r10.f
            r0.setVisibility(r5)
            goto L_0x044a
        L_0x0445:
            android.widget.LinearLayout r0 = r10.f
            r0.setVisibility(r4)
        L_0x044a:
            android.widget.LinearLayout r0 = r10.g
            r0.setVisibility(r5)
            a.h.a.n0.c r0 = r10.n
            if (r0 == 0) goto L_0x0469
            long r0 = r0.getChannelServiceType(r5)
            r6 = 8192(0x2000, double:4.0474E-320)
            long r0 = r0 & r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0460
            r0 = 1
            goto L_0x0461
        L_0x0460:
            r0 = 0
        L_0x0461:
            if (r0 == 0) goto L_0x0469
            android.widget.LinearLayout r0 = r10.f4598a
            r0.setVisibility(r5)
            goto L_0x046e
        L_0x0469:
            android.widget.LinearLayout r0 = r10.f4598a
            r0.setVisibility(r4)
        L_0x046e:
            a.h.a.n0.c r0 = r10.n
            if (r0 == 0) goto L_0x0487
            long r0 = r0.getChannelServiceType(r5)
            r6 = 16384(0x4000, double:8.0948E-320)
            long r0 = r0 & r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x047e
            goto L_0x047f
        L_0x047e:
            r11 = 0
        L_0x047f:
            if (r11 == 0) goto L_0x0487
            android.widget.LinearLayout r11 = r10.h
            r11.setVisibility(r5)
            goto L_0x048c
        L_0x0487:
            android.widget.LinearLayout r11 = r10.h
            r11.setVisibility(r4)
        L_0x048c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.video.AdvancedSettingActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            k(false);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void receiveChannelInfo(Camera camera, int i2, int i3) {
    }

    public void receiveFrameData(Camera camera, int i2, Bitmap bitmap) {
    }

    public void receiveFrameInfo(Camera camera, int i2, long j2, int i3, int i4, int i5, int i6) {
    }

    public void receiveIOCtrlData(Camera camera, int i2, int i3, byte[] bArr) {
        if (this.n == camera) {
            Bundle bundle = new Bundle();
            bundle.putInt("sessionChannel", i2);
            bundle.putByteArray("data", bArr);
            Message message = new Message();
            message.what = i3;
            message.setData(bundle);
            this.R.sendMessage(message);
        }
    }

    public void receiveSessionInfo(Camera camera, int i2) {
    }
}
