package com.sozpic.miniland.video;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.model.AddCameraResult;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tutk.IOTC.Camera;
import com.tutk.IOTC.IRegisterIOTCListener;
import com.tuya.smart.common.oOO0O0O0;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity3 extends Activity implements IRegisterIOTCListener, TopMenuActivityVideo.c {
    public static List<a.h.a.n0.c> o = new ArrayList();
    public static List<a.h.a.n0.b> p = Collections.synchronizedList(new ArrayList());
    public static Timer q = new Timer();

    /* renamed from: a  reason: collision with root package name */
    public s f4684a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f4685b;

    /* renamed from: c  reason: collision with root package name */
    public a.h.a.n0.b f4686c = null;

    /* renamed from: d  reason: collision with root package name */
    public a.h.a.n0.c f4687d = null;

    /* renamed from: e  reason: collision with root package name */
    public TopMenuActivityVideo f4688e;
    public boolean f = true;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public a.h.a.n0.a l;
    public boolean m;
    public Handler n;

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4689a;

        public a(Dialog dialog) {
            this.f4689a = dialog;
        }

        public void onClick(View view) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putLong("db_id", MainActivity3.this.f4686c.f3525a);
            bundle.putString("dev_uuid", MainActivity3.this.f4686c.f3526b);
            bundle.putString("dev_uid", MainActivity3.this.f4686c.f3528d);
            bundle.putString("view_acc", MainActivity3.this.f4686c.f3529e);
            bundle.putString("view_pwd", MainActivity3.this.f4686c.f);
            bundle.putString("dev_nickname", MainActivity3.this.f4686c.f3527c);
            bundle.putInt("camera_channel", MainActivity3.this.f4686c.j);
            intent.putExtras(bundle);
            intent.setClass(MainActivity3.this, EditDeviceActivity.class);
            MainActivity3.this.startActivityForResult(intent, 2);
            this.f4689a.dismiss();
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4691a;

        public b(Dialog dialog) {
            this.f4691a = dialog;
        }

        public void onClick(View view) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putString("dev_uuid", MainActivity3.this.f4686c.f3526b);
            bundle.putString("dev_uid", MainActivity3.this.f4686c.f3528d);
            bundle.putString("dev_nickname", MainActivity3.this.f4686c.f3527c);
            bundle.putString("view_acc", MainActivity3.this.f4686c.f3529e);
            bundle.putString("view_pwd", MainActivity3.this.f4686c.f);
            bundle.putInt("camera_channel", MainActivity3.this.f4686c.j);
            intent.putExtras(bundle);
            intent.setClass(MainActivity3.this, EventListActivity.class);
            MainActivity3.this.startActivity(intent);
            this.f4691a.dismiss();
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4693a;

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4695a;

            public a(c cVar, Dialog dialog) {
                this.f4695a = dialog;
            }

            public void onClick(View view) {
                this.f4695a.dismiss();
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4696a;

            public b(Dialog dialog) {
                this.f4696a = dialog;
            }

            public void onClick(View view) {
                MainActivity3.this.f4687d.stop(0);
                MainActivity3.this.f4687d.disconnect();
                MainActivity3 mainActivity3 = MainActivity3.this;
                mainActivity3.f4687d.unregisterIOTCListener(mainActivity3);
                MainActivity3.o.remove(MainActivity3.this.f4687d);
                a.h.a.n0.a aVar = new a.h.a.n0.a(MainActivity3.this);
                SQLiteDatabase b2 = aVar.b();
                Cursor query = b2.query("snapshot", new String[]{"_id", "dev_uid", "file_path", "time"}, a.a.a.a.a.m(a.a.a.a.a.n("dev_uid = '"), MainActivity3.this.f4686c.f3528d, "'"), (String[]) null, (String) null, (String) null, "_id LIMIT 4");
                while (query.moveToNext()) {
                    File file = new File(query.getString(2));
                    if (file.exists()) {
                        file.delete();
                    }
                }
                query.close();
                b2.close();
                String str = MainActivity3.this.f4686c.f3528d;
                SQLiteDatabase writableDatabase = aVar.f3524a.getWritableDatabase();
                writableDatabase.delete("snapshot", a.a.a.a.a.l("dev_uid = '", str, "'"), (String[]) null);
                writableDatabase.close();
                aVar.c(MainActivity3.this.f4686c.f3528d);
                MainActivity3.p.remove(MainActivity3.this.f4686c);
                MainActivity3.this.f4684a.notifyDataSetChanged();
                this.f4696a.dismiss();
                new r((h) null).execute(new String[]{a.a.a.a.a.m(new StringBuilder(), MainActivity3.this.f4686c.f3528d, "")});
            }
        }

        public c(Dialog dialog) {
            this.f4693a = dialog;
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(MainActivity3.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) dialog.findViewById(R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new a(this, dialog));
            Button button2 = (Button) a.a.a.a.a.A(R.string.TR_TIPS_REMOVE_CAMERA_CONFIRM, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new b(dialog));
            dialog.show();
            this.f4693a.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            MainActivity3 mainActivity3 = MainActivity3.this;
            a.c.a.d.a.l(mainActivity3, mainActivity3.k);
        }
    }

    public class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Camera f4699a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.h.a.n0.b f4700b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CheckBox f4701c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f4702d;

        public e(Camera camera, a.h.a.n0.b bVar, CheckBox checkBox, AlertDialog alertDialog) {
            this.f4699a = camera;
            this.f4700b = bVar;
            this.f4701c = checkBox;
            this.f4702d = alertDialog;
        }

        public void onClick(View view) {
            this.f4699a.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ, AVIOCTRLDEFs.SMsgAVIoctrlFormatExtStorageReq.parseContent(0));
            this.f4700b.k = this.f4701c.isChecked();
            a.h.a.n0.a aVar = new a.h.a.n0.a(MainActivity3.this);
            a.h.a.n0.b bVar = this.f4700b;
            aVar.e(bVar.f3528d, bVar.k);
            this.f4702d.dismiss();
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h.a.n0.b f4704a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CheckBox f4705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f4706c;

        public f(a.h.a.n0.b bVar, CheckBox checkBox, AlertDialog alertDialog) {
            this.f4704a = bVar;
            this.f4705b = checkBox;
            this.f4706c = alertDialog;
        }

        public void onClick(View view) {
            this.f4704a.k = this.f4705b.isChecked();
            a.h.a.n0.a aVar = new a.h.a.n0.a(MainActivity3.this);
            a.h.a.n0.b bVar = this.f4704a;
            aVar.e(bVar.f3528d, bVar.k);
            this.f4706c.dismiss();
        }
    }

    public class g extends Handler {
        public g() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
            if (r3 != null) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
            if (r1 != null) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a2, code lost:
            if (r1 != null) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a4, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0143  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r11) {
            /*
                r10 = this;
                android.os.Bundle r0 = r11.getData()
                java.lang.String r1 = "requestDevice"
                java.lang.String r1 = r0.getString(r1)
                java.lang.String r2 = "data"
                byte[] r0 = r0.getByteArray(r2)
                r2 = 0
                r3 = 0
            L_0x0012:
                java.util.List<a.h.a.n0.b> r4 = com.sozpic.miniland.video.MainActivity3.p
                int r4 = r4.size()
                r5 = 0
                if (r3 >= r4) goto L_0x0037
                java.util.List<a.h.a.n0.b> r4 = com.sozpic.miniland.video.MainActivity3.p
                java.lang.Object r4 = r4.get(r3)
                a.h.a.n0.b r4 = (a.h.a.n0.b) r4
                java.lang.String r4 = r4.f3526b
                boolean r4 = r4.equalsIgnoreCase(r1)
                if (r4 == 0) goto L_0x0034
                java.util.List<a.h.a.n0.b> r4 = com.sozpic.miniland.video.MainActivity3.p
                java.lang.Object r3 = r4.get(r3)
                a.h.a.n0.b r3 = (a.h.a.n0.b) r3
                goto L_0x0038
            L_0x0034:
                int r3 = r3 + 1
                goto L_0x0012
            L_0x0037:
                r3 = r5
            L_0x0038:
                r4 = 0
            L_0x0039:
                java.util.List<a.h.a.n0.c> r6 = com.sozpic.miniland.video.MainActivity3.o
                int r6 = r6.size()
                if (r4 >= r6) goto L_0x0060
                java.util.List<a.h.a.n0.c> r6 = com.sozpic.miniland.video.MainActivity3.o
                java.lang.Object r6 = r6.get(r4)
                a.h.a.n0.c r6 = (a.h.a.n0.c) r6
                java.lang.String r6 = r6.b()
                boolean r6 = r6.equalsIgnoreCase(r1)
                if (r6 == 0) goto L_0x005d
                java.util.List<a.h.a.n0.c> r1 = com.sozpic.miniland.video.MainActivity3.o
                java.lang.Object r1 = r1.get(r4)
                r5 = r1
                a.h.a.n0.c r5 = (a.h.a.n0.c) r5
                goto L_0x0060
            L_0x005d:
                int r4 = r4 + 1
                goto L_0x0039
            L_0x0060:
                r1 = r5
                int r4 = r11.what
                r5 = 8
                if (r4 == r5) goto L_0x013a
                r6 = 817(0x331, float:1.145E-42)
                if (r4 == r6) goto L_0x0113
                r6 = 897(0x381, float:1.257E-42)
                r7 = 4
                if (r4 == r6) goto L_0x00f8
                r6 = 8191(0x1fff, float:1.1478E-41)
                if (r4 == r6) goto L_0x00d1
                r0 = 2131821347(0x7f110323, float:1.9275435E38)
                switch(r4) {
                    case 1: goto L_0x00bd;
                    case 2: goto L_0x00a9;
                    case 3: goto L_0x009a;
                    case 4: goto L_0x008d;
                    case 5: goto L_0x007f;
                    case 6: goto L_0x007c;
                    default: goto L_0x007a;
                }
            L_0x007a:
                goto L_0x0141
            L_0x007c:
                if (r3 == 0) goto L_0x0141
                goto L_0x0092
            L_0x007f:
                if (r3 == 0) goto L_0x008a
                r0 = 2131821351(0x7f110327, float:1.9275443E38)
                java.lang.String r0 = a.c.a.d.a.h(r0)
                r3.g = r0
            L_0x008a:
                if (r1 == 0) goto L_0x0141
                goto L_0x00a4
            L_0x008d:
                if (r3 == 0) goto L_0x0141
                r0 = 2131821350(0x7f110326, float:1.927544E38)
            L_0x0092:
                java.lang.String r0 = a.c.a.d.a.h(r0)
                r3.g = r0
                goto L_0x0141
            L_0x009a:
                if (r3 == 0) goto L_0x00a2
                java.lang.String r0 = a.c.a.d.a.h(r0)
                r3.g = r0
            L_0x00a2:
                if (r1 == 0) goto L_0x0141
            L_0x00a4:
                r1.disconnect()
                goto L_0x0141
            L_0x00a9:
                if (r1 == 0) goto L_0x0141
                boolean r0 = r1.isSessionConnected()
                if (r0 == 0) goto L_0x0141
                boolean r0 = r1.isChannelConnected(r2)
                if (r0 == 0) goto L_0x0141
                if (r3 == 0) goto L_0x0141
                r0 = 2131821348(0x7f110324, float:1.9275437E38)
                goto L_0x0092
            L_0x00bd:
                if (r1 == 0) goto L_0x0141
                boolean r0 = r1.isSessionConnected()
                if (r0 == 0) goto L_0x00cb
                boolean r0 = r1.isChannelConnected(r2)
                if (r0 != 0) goto L_0x0141
            L_0x00cb:
                if (r3 == 0) goto L_0x0141
                r0 = 2131821345(0x7f110321, float:1.927543E38)
                goto L_0x0092
            L_0x00d1:
                byte[] r4 = new byte[r5]
                java.lang.System.arraycopy(r0, r2, r4, r2, r5)
                com.tutk.IOTC.AVIOCTRLDEFs$STimeDay r2 = new com.tutk.IOTC.AVIOCTRLDEFs$STimeDay
                r2.<init>(r4)
                r4 = 12
                int r6 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r0, r4)
                r4 = 16
                int r0 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r0, r4)
                if (r0 == r7) goto L_0x0141
                r4 = 6
                if (r0 == r4) goto L_0x0141
                com.sozpic.miniland.video.MainActivity3 r4 = com.sozpic.miniland.video.MainActivity3.this
                long r8 = r2.getTimeInMillis()
                r5 = r3
                r7 = r0
                r4.m(r5, r6, r7, r8)
                goto L_0x0141
            L_0x00f8:
                byte r0 = r0[r7]
                if (r0 != 0) goto L_0x0102
                com.sozpic.miniland.video.MainActivity3 r0 = com.sozpic.miniland.video.MainActivity3.this
                r4 = 2131821402(0x7f11035a, float:1.9275546E38)
                goto L_0x0107
            L_0x0102:
                com.sozpic.miniland.video.MainActivity3 r0 = com.sozpic.miniland.video.MainActivity3.this
                r4 = 2131821401(0x7f110359, float:1.9275544E38)
            L_0x0107:
                java.lang.String r4 = a.c.a.d.a.h(r4)
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r4, r2)
                r0.show()
                goto L_0x0141
            L_0x0113:
                r4 = 40
                int r0 = com.tutk.IOTC.Packet.byteArrayToInt_Little(r0, r4)
                r4 = -1
                if (r0 != r4) goto L_0x0141
                if (r1 == 0) goto L_0x0141
                long r4 = r1.getChannelServiceType(r2)
                r6 = 256(0x100, double:1.265E-321)
                long r4 = r4 & r6
                r6 = 0
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 != 0) goto L_0x012c
                r2 = 1
            L_0x012c:
                if (r2 == 0) goto L_0x0141
                if (r3 == 0) goto L_0x0141
                boolean r0 = r3.k
                if (r0 == 0) goto L_0x0141
                com.sozpic.miniland.video.MainActivity3 r0 = com.sozpic.miniland.video.MainActivity3.this
                r0.n(r1, r3)
                goto L_0x0141
            L_0x013a:
                if (r3 == 0) goto L_0x0141
                r0 = 2131821346(0x7f110322, float:1.9275433E38)
                goto L_0x0092
            L_0x0141:
                if (r3 == 0) goto L_0x0146
                r1.getSessionMode()
            L_0x0146:
                com.sozpic.miniland.video.MainActivity3 r0 = com.sozpic.miniland.video.MainActivity3.this
                com.sozpic.miniland.video.MainActivity3$s r0 = r0.f4684a
                r0.notifyDataSetChanged()
                super.handleMessage(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.video.MainActivity3.g.handleMessage(android.os.Message):void");
        }
    }

    public class h extends TimerTask {
        public h() {
        }

        public void run() {
            new t((h) null).execute(new String[0]);
        }
    }

    public class i implements CompoundButton.OnCheckedChangeListener {
        public i(MainActivity3 mainActivity3) {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            a.c.d.a.l().g("KEY_SHOW_CAMERA_IP_WARNING", Boolean.valueOf(!z));
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public void onClick(View view) {
            if (a.c.a.d.a.k(MainActivity3.this)) {
                MainActivity3.this.j();
            }
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public void onClick(View view) {
            MainActivity3 mainActivity3 = MainActivity3.this;
            a.c.a.d.a.l(mainActivity3, mainActivity3.k);
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        public void onClick(View view) {
            if (MainActivity3.o.size() < 4) {
                Intent intent = new Intent();
                intent.setClass(MainActivity3.this, AddDeviceActivity.class);
                MainActivity3.this.startActivityForResult(intent, 0);
            }
        }
    }

    public class m implements AdapterView.OnItemClickListener {
        public m() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.h.a.n0.b bVar = (a.h.a.n0.b) MainActivity3.this.f4684a.getItem(i);
            if (bVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("dev_uid", bVar.f3528d);
                bundle.putString("dev_uuid", bVar.f3526b);
                bundle.putString("dev_nickname", bVar.f3527c);
                bundle.putString("conn_status", bVar.g);
                bundle.putString("view_acc", bVar.f3529e);
                bundle.putString("view_pwd", bVar.f);
                bundle.putInt("camera_channel", bVar.j);
                Intent intent = new Intent(MainActivity3.this, LiveViewActivity.class);
                intent.putExtras(bundle);
                MainActivity3.this.startActivityForResult(intent, 1);
            }
        }
    }

    public class n implements AdapterView.OnItemLongClickListener {
        public n() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= MainActivity3.p.size() || i >= MainActivity3.o.size()) {
                return false;
            }
            MainActivity3.this.f4687d = MainActivity3.o.get(i);
            MainActivity3.this.f4686c = MainActivity3.p.get(i);
            MainActivity3.this.h();
            return true;
        }
    }

    public static class o implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f4715a;

        public p(Dialog dialog) {
            this.f4715a = dialog;
        }

        public void onClick(View view) {
            MainActivity3.this.f4687d.disconnect();
            MainActivity3 mainActivity3 = MainActivity3.this;
            mainActivity3.f4687d.connect(mainActivity3.f4686c.f3528d);
            MainActivity3 mainActivity32 = MainActivity3.this;
            a.h.a.n0.c cVar = mainActivity32.f4687d;
            a.h.a.n0.b bVar = mainActivity32.f4686c;
            cVar.start(0, bVar.f3529e, bVar.f);
            MainActivity3.this.f4687d.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
            MainActivity3.this.f4687d.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent());
            MainActivity3.this.f4687d.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent());
            this.f4715a.dismiss();
        }
    }

    public class q extends AsyncTask<Void, Void, AddCameraResult> {

        /* renamed from: a  reason: collision with root package name */
        public a.h.a.n0.c f4717a;

        /* renamed from: b  reason: collision with root package name */
        public a.h.a.n0.b f4718b;

        public q(a.h.a.n0.c cVar, a.h.a.n0.b bVar) {
            this.f4717a = cVar;
            this.f4718b = bVar;
        }

        public Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            try {
                Log.i("CAMARAS", "Nueva camara: " + this.f4717a.f3531b);
                String v = a.e.a.a.r.b.v("&bd=" + MainActivity3.this.g + "&bdpre=" + MainActivity3.this.h + "&idCamara=" + this.f4717a.f3531b, "altacamara.php?altacamarav2=1");
                StringBuilder sb = new StringBuilder();
                sb.append("Resultado: ");
                sb.append(v);
                Log.i("CAMARAS", sb.toString());
                return new AddCameraResult(new JSONObject(v));
            } catch (Exception e2) {
                e2.printStackTrace();
                return new AddCameraResult();
            }
        }

        public void onPostExecute(Object obj) {
            AddCameraResult addCameraResult = (AddCameraResult) obj;
            super.onPostExecute(addCameraResult);
            if (addCameraResult.isSuccess()) {
                this.f4717a.registerIOTCListener(MainActivity3.this);
                a.h.a.n0.c cVar = this.f4717a;
                cVar.connect(cVar.f3531b);
                this.f4717a.c(0);
                this.f4717a.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
                this.f4717a.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent());
                this.f4717a.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent());
                this.f4717a.f3530a = 1;
                a.h.a.n0.a aVar = new a.h.a.n0.a(MainActivity3.this);
                a.h.a.n0.b bVar = this.f4718b;
                String str = bVar.f3527c;
                String str2 = bVar.f3528d;
                String str3 = bVar.f;
                SQLiteDatabase writableDatabase = aVar.f3524a.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("dev_nickname", str);
                contentValues.put("dev_uid", str2);
                contentValues.put("dev_name", "");
                contentValues.put("dev_pwd", "");
                contentValues.put("view_acc", "admin");
                contentValues.put("view_pwd", str3);
                contentValues.put("event_notification", 3);
                contentValues.put("camera_channel", 0);
                long insertOrThrow = writableDatabase.insertOrThrow(oOO0O0O0.O0000oOO, (String) null, contentValues);
                writableDatabase.close();
                this.f4718b.f3525a = insertOrThrow;
                MainActivity3.o.add(this.f4717a);
                MainActivity3.p.add(this.f4718b);
                MainActivity3.this.f4684a.notifyDataSetChanged();
                Toast.makeText(MainActivity3.this, a.c.a.d.a.h(R.string.TR_TIPS_ADD_CAMERA_OK), 0).show();
            } else if (!a.c.a.d.a.j(addCameraResult.getError())) {
                MainActivity3.k(MainActivity3.this, (CharSequence) null, addCameraResult.getError(), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            }
        }

        public void onPreExecute() {
        }
    }

    public class r extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public ProgressDialog f4720a;

        /* renamed from: b  reason: collision with root package name */
        public String f4721b = "";

        public r(h hVar) {
        }

        public Object doInBackground(Object[] objArr) {
            try {
                this.f4721b = ((String[]) objArr)[0];
                a.e.a.a.r.b.v("&bd=" + MainActivity3.this.g + "&bdpre=" + MainActivity3.this.h + "&idCamara=" + this.f4721b, "altacamara.php?bajacamara=1");
                return "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public void onPostExecute(Object obj) {
            String str = (String) obj;
            this.f4720a.dismiss();
        }

        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(MainActivity3.this);
            this.f4720a = progressDialog;
            progressDialog.requestWindowFeature(1);
            this.f4720a.setOwnerActivity(MainActivity3.this);
            this.f4720a.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f4720a.setCancelable(true);
            this.f4720a.show();
        }
    }

    public class s extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public LayoutInflater f4723a;

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.h.a.n0.b f4725a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a.h.a.n0.c f4726b;

            public a(a.h.a.n0.b bVar, a.h.a.n0.c cVar) {
                this.f4725a = bVar;
                this.f4726b = cVar;
            }

            public void onClick(View view) {
                MainActivity3 mainActivity3 = MainActivity3.this;
                mainActivity3.f4686c = this.f4725a;
                mainActivity3.f4687d = this.f4726b;
                mainActivity3.h();
            }
        }

        public final class b {

            /* renamed from: a  reason: collision with root package name */
            public ImageView f4728a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f4729b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f4730c;

            /* renamed from: d  reason: collision with root package name */
            public TextView f4731d;

            /* renamed from: e  reason: collision with root package name */
            public FrameLayout f4732e;

            public b(s sVar) {
            }
        }

        public s(Context context) {
            this.f4723a = LayoutInflater.from(context);
        }

        public int getCount() {
            return MainActivity3.p.size();
        }

        public Object getItem(int i) {
            return MainActivity3.p.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            a.h.a.n0.b bVar2 = MainActivity3.p.get(i);
            a.h.a.n0.c cVar = MainActivity3.o.get(i);
            if (bVar2 == null || cVar == null) {
                return null;
            }
            if (view == null) {
                view = this.f4723a.inflate(R.layout.device_list, (ViewGroup) null);
                bVar = new b(this);
                bVar.f4728a = (ImageView) view.findViewById(R.id.img);
                bVar.f4729b = (TextView) view.findViewById(R.id.title);
                bVar.f4730c = (TextView) view.findViewById(R.id.info);
                bVar.f4731d = (TextView) view.findViewById(R.id.status);
                bVar.f4732e = (FrameLayout) view.findViewById(R.id.eventLayout);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (bVar != null) {
                bVar.f4728a.setImageBitmap(bVar2.h);
                bVar.f4729b.setText(bVar2.f3527c);
                bVar.f4730c.setText(bVar2.f3528d);
                bVar.f4731d.setText(bVar2.g);
                bVar.f4732e.setOnClickListener(new a(bVar2, cVar));
            }
            return view;
        }
    }

    public class t extends AsyncTask<String, Void, String> {
        public t(h hVar) {
        }

        public Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            String str = "";
            try {
                str = a.e.a.a.r.b.v("&email=" + MainActivity3.this.i + "&pass=" + MainActivity3.this.j, "login.php?applogin=1");
                StringBuilder sb = new StringBuilder();
                sb.append("Resultado: ");
                sb.append(str);
                Log.i("CAMARAS", sb.toString());
                return str;
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }

        public void onPostExecute(Object obj) {
            String str = (String) obj;
            Log.e("JM", "DEVUELTO CAMARAS:" + str);
            if (str != null && str.length() > 0) {
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("cam");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    MainActivity3.this.l.d(arrayList);
                    if (MainActivity3.o.size() != arrayList.size()) {
                        a.c.a.f.e.b("Actualizando listado de camaras ....");
                        MainActivity3.this.g();
                    }
                } catch (JSONException e2) {
                    StringBuilder n = a.a.a.a.a.n("Ex: ");
                    n.append(e2.toString());
                    Log.e("parsejson", n.toString());
                }
            }
        }

        public void onPreExecute() {
        }
    }

    public MainActivity3() {
        new ArrayList();
        this.m = false;
        this.n = new g();
    }

    public static final String f(Context context, int i2, boolean z) {
        int i3;
        if (i2 == 16) {
            i3 = R.string.TR_EVENT_TYPE_SYSTEM_REBOOT;
        } else if (i2 != 17) {
            switch (i2) {
                case 0:
                    if (!z) {
                        i3 = R.string.TR_EVENT_TYPE_FULLTIME_RECORDING;
                        break;
                    } else {
                        i3 = R.string.TR_EVENT_TYPE_ALL;
                        break;
                    }
                case 1:
                    i3 = R.string.TR_EVENT_TYPE_MOTION_DETECTION;
                    break;
                case 2:
                    i3 = R.string.TR_EVENT_TYPE_VIDEO_LOST;
                    break;
                case 3:
                    i3 = R.string.TR_EVENT_TYPE_IO_ALARM;
                    break;
                case 4:
                    i3 = R.string.TR_EVENT_TYPE_MOTION_PASS;
                    break;
                case 5:
                    i3 = R.string.TR_EVENT_TYPE_VIDEO_RESUME;
                    break;
                case 6:
                    i3 = R.string.TR_EVENT_TYPE_IO_ALARM_PASS;
                    break;
                default:
                    return "";
            }
        } else {
            i3 = R.string.TR_EVENT_TYPE_SDCARD_FAULT;
        }
        return a.c.a.d.a.h(i3);
    }

    public static void k(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(17301543);
        builder.setTitle(charSequence);
        builder.setMessage(charSequence2);
        builder.setPositiveButton(charSequence3, new o()).show();
    }

    public void a() {
        e();
    }

    public void b() {
    }

    public void e() {
        try {
            for (a.h.a.n0.c next : o) {
                next.disconnect();
                next.unregisterIOTCListener(this);
            }
            Camera.uninit();
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            notificationManager.cancel(0);
            notificationManager.cancel(1);
            Process.killProcess(Process.myPid());
        } catch (Exception unused) {
        }
        finish();
    }

    public final void g() {
        SQLiteDatabase b2 = this.l.b();
        Cursor query = b2.query(oOO0O0O0.O0000oOO, new String[]{"_id", "dev_nickname", "dev_uid", "dev_name", "dev_pwd", "view_acc", "view_pwd", "event_notification", "camera_channel", "snapshot", "ask_format_sdcard"}, (String) null, (String[]) null, (String) null, (String) null, "_id LIMIT 4");
        p.clear();
        o.clear();
        while (query.moveToNext()) {
            long j2 = query.getLong(0);
            String string = query.getString(1);
            String string2 = query.getString(2);
            String string3 = query.getString(5);
            String string4 = query.getString(6);
            int i2 = query.getInt(7);
            int i3 = query.getInt(8);
            byte[] blob = query.getBlob(9);
            int i4 = query.getInt(10);
            Bitmap a2 = (blob == null || blob.length <= 0) ? null : a.h.a.n0.a.a(blob);
            a.h.a.n0.c cVar = new a.h.a.n0.c(string, string2, string3, string4);
            a.h.a.n0.b bVar = new a.h.a.n0.b(j2, cVar.b(), string, string2, string3, string4, "", i2, i3, a2);
            bVar.k = i4 == 1;
            if (!this.f) {
                p.add(bVar);
            }
            cVar.registerIOTCListener(this);
            cVar.connect(string2);
            cVar.start(0, string3, string4);
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetSupportStreamReq.parseContent());
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_DEVINFO_REQ, AVIOCTRLDEFs.SMsgAVIoctrlDeviceInfoReq.parseContent());
            cVar.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlGetAudioOutFormatReq.parseContent());
            if (!this.f) {
                o.add(cVar);
            } else {
                this.l.c(string2);
                Toast.makeText(this, "Debido a una actualización del sistema debe volver a registrar sus cámaras IP", 0).show();
            }
        }
        if (this.f) {
            this.f = false;
        }
        query.close();
        b2.close();
        this.f4684a.notifyDataSetChanged();
    }

    public final void h() {
        Dialog dialog = new Dialog(this, 2131886561);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        window.setAttributes(layoutParams);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.popup_context_video);
        dialog.setCancelable(true);
        ((LinearLayout) a.a.a.a.a.A(R.string.TR_HELP, (TextView) a.a.a.a.a.A(R.string.TR_REMOVE, (TextView) a.a.a.a.a.A(R.string.TR_VIEW_EVENTS, (TextView) a.a.a.a.a.A(R.string.TR_EDIT_CAMERA, (TextView) a.a.a.a.a.A(R.string.TR_RECONNECT, (TextView) dialog.findViewById(R.id.txtReconnect), dialog, R.id.txtEditCamera), dialog, R.id.txtViewEvent), dialog, R.id.txtRemoveCamera), dialog, R.id.txtHelp), dialog, R.id.reconn)).setOnClickListener(new p(dialog));
        ((LinearLayout) dialog.findViewById(R.id.editar)).setOnClickListener(new a(dialog));
        ((LinearLayout) dialog.findViewById(R.id.event)).setOnClickListener(new b(dialog));
        ((LinearLayout) dialog.findViewById(R.id.delete)).setOnClickListener(new c(dialog));
        ((ViewGroup) dialog.findViewById(R.id.popup_video_help)).setOnClickListener(new d());
        dialog.show();
    }

    public final void i() {
        if (a.c.a.d.a.k(this)) {
            j();
            return;
        }
        getWindow().setFlags(128, 128);
        setContentView(R.layout.no_network_connection);
        ((TextView) findViewById(R.id.text_no_network)).setText(a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION));
        Button button = (Button) findViewById(R.id.btnRetry);
        button.setText(a.c.a.d.a.h(R.string.TR_RETRY));
        button.setOnClickListener(new j());
    }

    public final void j() {
        getWindow().setFlags(128, 128);
        setContentView(R.layout.main_video);
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabecera);
        this.f4688e = topMenuActivityVideo;
        topMenuActivityVideo.setListener(this);
        this.f4688e.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_CAMERA));
        ((ImageView) findViewById(R.id.video_help_button)).setOnClickListener(new k());
        ((TextView) findViewById(R.id.click_to_add_camera)).setText(a.c.a.d.a.h(R.string.TR_ADD_CAMERA));
        ((RelativeLayout) findViewById(R.id.xs)).setOnClickListener(new l());
        this.f4685b = (ListView) findViewById(R.id.lstCameraList);
        s sVar = new s(this);
        this.f4684a = sVar;
        this.f4685b.setAdapter(sVar);
        this.f4685b.setOnItemClickListener(new m());
        this.f4685b.setOnItemLongClickListener(new n());
    }

    public final void l() {
        if (a.c.d.a.l().w()) {
            View inflate = View.inflate(this, R.layout.item_checkbox_dialog, (ViewGroup) null);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkbox_dialog);
            checkBox.setOnCheckedChangeListener(new i(this));
            checkBox.setText(a.c.a.d.a.h(R.string.TR_DO_NOT_SHOW_AGAIN));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(a.c.a.d.a.h(R.string.TR_INFORMATION));
            builder.setMessage(a.c.a.d.a.h(R.string.TR_CAMARA_IP_WIFI_WARNING)).setView(inflate).setCancelable(false).setPositiveButton(a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) null).show();
        }
    }

    public final void m(a.h.a.n0.b bVar, int i2, int i3, long j2) {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Bundle bundle = new Bundle();
            bundle.putString("dev_uuid", bVar.f3526b);
            bundle.putString("dev_uid", bVar.f3528d);
            bundle.putString("dev_nickname", bVar.f3527c);
            bundle.putInt("camera_channel", i2);
            bundle.putString("view_acc", bVar.f3529e);
            bundle.putString("view_pwd", bVar.f);
            Intent intent = new Intent(this, EventListActivity.class);
            intent.setFlags(335544320);
            intent.putExtras(bundle);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
            Calendar instance = Calendar.getInstance();
            instance.setTimeZone(TimeZone.getDefault());
            instance.setTimeInMillis(j2);
            instance.add(2, -1);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID");
            builder.setSmallIcon(R.mipmap.ic_launcher).setTicker(String.format(a.c.a.d.a.i(R.string.TR_INCOMING_EVENT_PLACEHOLDER), new Object[]{bVar.f3527c})).setWhen(instance.getTimeInMillis()).setContentTitle(String.format(a.c.a.d.a.i(R.string.TR_INCOMING_EVENT_PLACEHOLDER), new Object[]{bVar.f3527c})).setContentText(String.format(a.c.a.d.a.i(R.string.TR_LAST_EVENT_IS_PLACEHOLDER), new Object[]{f(this, i3, false)})).setContentIntent(activity).setAutoCancel(true);
            Notification build = builder.build();
            if (bVar.i == 0) {
                build.defaults = 4;
            } else if (bVar.i == 1) {
                build.defaults = 1;
            } else if (bVar.i == 2) {
                build.defaults = 2;
            } else {
                build.defaults = -1;
            }
            a.c.a.d.a.o(notificationManager);
            notificationManager.notify(1, build);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void n(Camera camera, a.h.a.n0.b bVar) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle(a.c.a.d.a.h(R.string.TR_FORMAT_SDCARD));
        create.setIcon(17301573);
        View inflate = create.getLayoutInflater().inflate(R.layout.format_sdcard, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.format_title)).setText(a.c.a.d.a.h(R.string.TR_FORMAT_SDCARD_TITLE));
        ((TextView) inflate.findViewById(R.id.format_desc)).setText(a.c.a.d.a.h(R.string.TR_FORMAT_SDCARD_DESC));
        create.setView(inflate);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.chbShowTipsFormatSDCard);
        checkBox.setText(a.c.a.d.a.h(R.string.TR_SHOW_TIPS_FORMAT_SDCARD));
        Button button = (Button) inflate.findViewById(R.id.btnFormatSDCard);
        Button button2 = (Button) inflate.findViewById(R.id.btnClose);
        button.setText(a.c.a.d.a.h(R.string.TR_FORMAT));
        button.setOnClickListener(new e(camera, bVar, checkBox, create));
        button2.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        button2.setOnClickListener(new f(bVar, checkBox, create));
    }

    public final void o() {
        q = new Timer();
        q.schedule(new h(), 0, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = i2;
        int i5 = i3;
        super.onActivityResult(i2, i3, intent);
        int i6 = 0;
        if (i4 != 0) {
            if (i4 == 1) {
                if (i5 == -1) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("dev_uuid");
                    String string2 = extras.getString("dev_uid");
                    byte[] byteArray = extras.getByteArray("snapshot");
                    int i7 = extras.getInt("camera_channel");
                    Bitmap bitmap = null;
                    if (byteArray != null && byteArray.length > 0) {
                        bitmap = a.h.a.n0.a.a(byteArray);
                    }
                    while (i6 < p.size()) {
                        if (!string.equalsIgnoreCase(p.get(i6).f3526b) || !string2.equalsIgnoreCase(p.get(i6).f3528d)) {
                            i6++;
                        } else {
                            p.get(i6).j = i7;
                            if (bitmap != null) {
                                p.get(i6).h = bitmap;
                            }
                        }
                    }
                    return;
                }
                return;
            } else if (i4 == 2) {
                if (i5 != -1) {
                    return;
                }
            } else if (i4 != 3 && i4 == 1004) {
                List<a.h.a.n0.c> list = o;
                if (list == null || list.isEmpty()) {
                    i();
                    l();
                    this.m = false;
                    return;
                }
                return;
            } else {
                return;
            }
            this.f4684a.notifyDataSetChanged();
        } else if (i5 == -1) {
            Bundle extras2 = intent.getExtras();
            String string3 = extras2.getString("dev_nickname");
            String string4 = extras2.getString("dev_uid");
            String string5 = extras2.getString("view_acc");
            String string6 = extras2.getString("view_pwd");
            int i8 = extras2.getInt("camera_channel");
            a.h.a.n0.c cVar = new a.h.a.n0.c(string3, string4, string5, string6);
            new q(cVar, new a.h.a.n0.b(0, cVar.b(), string3, string4, string5, string6, "", 3, i8, (Bitmap) null)).execute(new Void[0]);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        String str;
        super.onConfigurationChanged(configuration);
        int i2 = getResources().getConfiguration().orientation;
        if (i2 == 2) {
            str = "ORIENTATION_LANDSCAPE";
        } else if (i2 == 1) {
            str = "ORIENTATION_PORTRAIT";
        } else {
            return;
        }
        a.c.a.f.e.b(str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.l = new a.h.a.n0.a(this);
        Bundle extras = getIntent().getExtras();
        try {
            this.f = extras.getBoolean("primera");
            this.g = extras.getString("bd");
            this.h = extras.getString("bdpre");
            this.i = extras.getString("email");
            this.j = extras.getString("pass");
        } catch (Exception unused) {
        }
        o = new ArrayList();
        p = Collections.synchronizedList(new ArrayList());
        Camera.init();
        String stringExtra = getIntent().getStringExtra("KEY_INTENT_HELP_SECTION_CODE");
        this.k = stringExtra;
        if (a.c.a.d.a.j(stringExtra) || a.c.d.a.l().q(this.k)) {
            o();
            i();
            l();
            return;
        }
        a.c.a.d.a.l(this, this.k);
        this.m = true;
    }

    public void onDestroy() {
        super.onDestroy();
        e();
    }

    public void onPause() {
        super.onPause();
        q.cancel();
        q.purge();
    }

    public void onResume() {
        super.onResume();
        a.c.a.e.f.c().e("VIGILABEBES_CAMARA");
        if (!this.m) {
            o();
        }
    }

    public void receiveChannelInfo(Camera camera, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("requestDevice", ((a.h.a.n0.c) camera).b());
        bundle.putInt("sessionChannel", i2);
        Message obtainMessage = this.n.obtainMessage();
        obtainMessage.what = i3;
        obtainMessage.setData(bundle);
        this.n.sendMessage(obtainMessage);
    }

    public void receiveFrameData(Camera camera, int i2, Bitmap bitmap) {
    }

    public void receiveFrameInfo(Camera camera, int i2, long j2, int i3, int i4, int i5, int i6) {
    }

    public void receiveIOCtrlData(Camera camera, int i2, int i3, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putString("requestDevice", ((a.h.a.n0.c) camera).b());
        bundle.putInt("sessionChannel", i2);
        bundle.putByteArray("data", bArr);
        Message obtainMessage = this.n.obtainMessage();
        obtainMessage.what = i3;
        obtainMessage.setData(bundle);
        this.n.sendMessage(obtainMessage);
    }

    public void receiveSessionInfo(Camera camera, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("requestDevice", ((a.h.a.n0.c) camera).b());
        Message obtainMessage = this.n.obtainMessage();
        obtainMessage.what = i2;
        obtainMessage.setData(bundle);
        this.n.sendMessage(obtainMessage);
    }
}
