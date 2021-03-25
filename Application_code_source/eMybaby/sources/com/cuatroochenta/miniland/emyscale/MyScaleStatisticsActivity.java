package com.cuatroochenta.miniland.emyscale;

import a.c.d.h.d;
import a.c.d.h.e;
import a.c.d.s.b.c.d;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.cuatroochenta.miniland.model.Measure;
import com.cuatroochenta.miniland.webservices.emyscale.weightlist.WeightListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.android.network.TuyaApiParams;
import de.timroes.swipetodismiss.SwipeDismissList;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MyScaleStatisticsActivity extends a.c.d.c implements View.OnClickListener, a.c.d.s.b.c.a, a.c.d.s.b.b.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f3878b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f3879c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f3880d;

    /* renamed from: e  reason: collision with root package name */
    public ListView f3881e;
    public ViewGroup f;
    public ArrayList<Measure> g;
    public int h = 0;
    public Bebe i;
    public WebView j;
    public HashMap<String, String> k;
    public String l;

    public class a implements SwipeDismissList.OnDismissCallback {
        public a() {
        }

        public SwipeDismissList.Undoable onDismiss(AbsListView absListView, int i) {
            ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
            if (listAdapter != null) {
                MyScaleStatisticsActivity myScaleStatisticsActivity = MyScaleStatisticsActivity.this;
                Measure measure = (Measure) listAdapter.getItem(i);
                if (myScaleStatisticsActivity == null) {
                    throw null;
                } else if (measure != null) {
                    Dialog dialog = new Dialog(myScaleStatisticsActivity, 2131886561);
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(R.layout.popup_mensaje);
                    dialog.setCancelable(true);
                    Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_WEIGHT_CONFIRM, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
                    button.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
                    button.setOnClickListener(new d(myScaleStatisticsActivity, dialog));
                    Button button2 = (Button) dialog.findViewById(R.id.ook);
                    button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
                    button2.setOnClickListener(new e(myScaleStatisticsActivity, measure, dialog));
                    dialog.show();
                }
            }
            return null;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            MyScaleStatisticsActivity myScaleStatisticsActivity = MyScaleStatisticsActivity.this;
            Bebe bebe = myScaleStatisticsActivity.i;
            if (bebe != null) {
                Intent intent = new Intent(myScaleStatisticsActivity, MyScaleGraphFullScreenActivity.class);
                intent.putExtra("KEY_INTENT_BABY", bebe);
                myScaleStatisticsActivity.startActivity(intent);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.b.c.b f3884a;

        public c(a.c.d.s.b.c.b bVar) {
            this.f3884a = bVar;
        }

        public void run() {
            MyScaleStatisticsActivity.this.o();
            a.c.d.s.b.c.b bVar = this.f3884a;
            if (bVar == null || !bVar.f42a.booleanValue()) {
                MyScaleStatisticsActivity.this.g = new ArrayList<>();
                MyScaleStatisticsActivity.this.r();
                Toast.makeText(MyScaleStatisticsActivity.this, a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_BABY_HISTORICAL), 0).show();
                return;
            }
            MyScaleStatisticsActivity myScaleStatisticsActivity = MyScaleStatisticsActivity.this;
            myScaleStatisticsActivity.g = this.f3884a.f875c;
            myScaleStatisticsActivity.r();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r0 = r8.getId()
            r1 = 2131297509(0x7f0904e5, float:1.8212965E38)
            r2 = 2131297506(0x7f0904e2, float:1.8212959E38)
            r3 = 2131297501(0x7f0904dd, float:1.8212949E38)
            r4 = 8
            r5 = 1
            r6 = 0
            if (r0 == r3) goto L_0x003e
            if (r0 == r2) goto L_0x002b
            if (r0 == r1) goto L_0x0018
            goto L_0x0054
        L_0x0018:
            android.view.ViewGroup r0 = r7.f
            r0.setVisibility(r4)
            android.widget.ListView r0 = r7.f3881e
            r0.setVisibility(r6)
            r7.h = r5
            a.c.a.e.f r0 = a.c.a.e.f.c()
            java.lang.String r4 = "EMYSCALE_HISTORICO_ALL"
            goto L_0x0051
        L_0x002b:
            android.view.ViewGroup r0 = r7.f
            r0.setVisibility(r4)
            android.widget.ListView r0 = r7.f3881e
            r0.setVisibility(r6)
            r7.h = r6
            a.c.a.e.f r0 = a.c.a.e.f.c()
            java.lang.String r4 = "EMYSCALE_HISTORICO_LATEST"
            goto L_0x0051
        L_0x003e:
            android.view.ViewGroup r0 = r7.f
            r0.setVisibility(r6)
            android.widget.ListView r0 = r7.f3881e
            r0.setVisibility(r4)
            r0 = 2
            r7.h = r0
            a.c.a.e.f r0 = a.c.a.e.f.c()
            java.lang.String r4 = "EMYSCALE_HISTORICO_GRAFICO"
        L_0x0051:
            r0.e(r4)
        L_0x0054:
            android.view.ViewGroup r0 = r7.f3878b
            int r4 = r8.getId()
            if (r4 != r2) goto L_0x005e
            r2 = 1
            goto L_0x005f
        L_0x005e:
            r2 = 0
        L_0x005f:
            r0.setSelected(r2)
            android.view.ViewGroup r0 = r7.f3879c
            int r2 = r8.getId()
            if (r2 != r1) goto L_0x006c
            r1 = 1
            goto L_0x006d
        L_0x006c:
            r1 = 0
        L_0x006d:
            r0.setSelected(r1)
            android.view.ViewGroup r0 = r7.f3880d
            int r8 = r8.getId()
            if (r8 != r3) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r5 = 0
        L_0x007a:
            r0.setSelected(r5)
            r7.r()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.emyscale.MyScaleStatisticsActivity.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_myscale_statistics);
        this.k = new HashMap<>();
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.statistics_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_EMYSCALE).toUpperCase());
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.statistics_baby_header_image);
        circularImageView.setBorderColor(getResources().getColor(R.color.baby_list_imgborder));
        circularImageView.setBorder(true);
        circularImageView.setImageResource(R.drawable.baby_big_default);
        TextView textView = (TextView) findViewById(R.id.statistics_baby_header_name);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("KEY_INTENT_BABY")) {
            this.i = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        Bebe bebe = this.i;
        if (bebe == null) {
            finish();
        } else if (bebe != null) {
            textView.setText(bebe.getTwoLineFormattName());
            if (!this.i.isPhotoEmpty()) {
                AppMiniland.f().k.b(this.i.getFoto(), circularImageView, (a.g.a.b.b) null, (a.g.a.b.l.c) null);
            }
            ((TextView) findViewById(R.id.statistics_latest_title)).setText(a.c.a.d.a.h(R.string.TR_LATEST).toUpperCase());
            ((TextView) findViewById(R.id.statistics_latest_subtitle)).setText(a.c.a.d.a.h(R.string.TR_RECORDS).toUpperCase());
            ((TextView) findViewById(R.id.statistics_month_title)).setText(a.c.a.d.a.h(R.string.TR_ALL).toUpperCase());
            ((TextView) findViewById(R.id.statistics_month_subtitle)).setText(a.c.a.d.a.h(R.string.TR_RECORDS).toUpperCase());
            ((TextView) findViewById(R.id.statistics_data_title)).setText(a.c.a.d.a.h(R.string.TR_WEIGHT).toUpperCase());
            ((TextView) findViewById(R.id.statistics_data_subtitle)).setText(a.c.a.d.a.h(R.string.TR_GRAPH).toUpperCase());
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.statistics_latest_container);
            this.f3878b = viewGroup;
            viewGroup.setOnClickListener(this);
            this.f3878b.setSelected(true);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.statistics_data_container);
            this.f3880d = viewGroup2;
            viewGroup2.setOnClickListener(this);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.statistics_month_container);
            this.f3879c = viewGroup3;
            viewGroup3.setOnClickListener(this);
            ListView listView = (ListView) findViewById(R.id.statitstics_list_listview);
            this.f3881e = listView;
            new SwipeDismissList(listView, new a(), SwipeDismissList.UndoMode.SINGLE_UNDO);
            WebView webView = (WebView) findViewById(R.id.statistics_graph_web);
            this.j = webView;
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            this.k.put("idBebe", String.valueOf(this.i.getId()));
            Usuario i2 = AppMiniland.f().i();
            this.k.put("bd", i2.getBd());
            this.k.put("bdpre", i2.getBdpre());
            this.k.put(TuyaApiParams.KEY_APP_LANG, a.c.d.a.l().c());
            this.k.put("unidad", Measure.getMeasureNameForWebservice(a.c.d.a.l().o()));
            try {
                this.l = a.c.a.d.a.c("https://emybaby.com/api/grafico.php", this.k);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            this.j.loadUrl(this.l);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.statistics_graph_web_container);
            this.f = viewGroup4;
            viewGroup4.setVisibility(8);
            ((ImageView) findViewById(R.id.statitstics_graph_fullscreen)).setOnClickListener(new b());
        } else {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.g == null) {
            t();
        } else {
            r();
        }
    }

    public void q(a.c.d.s.b.c.b bVar) {
        runOnUiThread(new c(bVar));
    }

    public void r() {
        int i2 = this.h;
        if (i2 == 0 || i2 == 1) {
            s();
        }
    }

    public void s() {
        ListView listView = this.f3881e;
        if (listView != null) {
            a.c.d.h.g.a aVar = (a.c.d.h.g.a) listView.getAdapter();
            if (aVar == null) {
                aVar = new a.c.d.h.g.a(this);
                this.f3881e.setAdapter(aVar);
            }
            aVar.f144c = this.h == 0 ? 10 : 0;
            ArrayList<Measure> arrayList = this.g;
            aVar.f143b.clear();
            if (arrayList != null) {
                aVar.f143b.addAll(arrayList);
                Collections.sort(aVar.f143b);
            }
            aVar.notifyDataSetChanged();
        }
    }

    public void t() {
        p(a.c.a.d.a.h(R.string.TR_GETTING_INFO), true);
        a.c.d.s.b.c.d dVar = new a.c.d.s.b.c.d();
        dVar.f877b = "https://emybaby.com/api/fichamedica.php";
        WeightListRequest weightListRequest = new WeightListRequest();
        weightListRequest.f4094a = this.i.getId();
        new d.a(weightListRequest, this).start();
    }
}
