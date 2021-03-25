package com.cuatroochenta.miniland.humidificador.device;

import a.c.d.j.b.a.b;
import a.c.d.j.d.c;
import a.c.d.j.d.d;
import a.c.d.j.d.f;
import a.c.d.j.d.h;
import a.c.d.j.d.i;
import a.c.d.j.d.j;
import a.c.d.j.d.k;
import a.c.d.j.d.l;
import a.c.d.j.d.m;
import a.c.d.j.d.n;
import a.c.d.j.d.o;
import a.c.d.j.d.p;
import a.c.d.j.d.r;
import a.c.d.r.e;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker;
import com.cuatroochenta.miniland.utils.MyProgress;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import com.tuya.smart.android.device.bean.EnumSchemaBean;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeviceControlActivity extends b implements r, TopMenuActivityVideo.c {
    public ViewGroup A;
    public ViewGroup B;
    public ImageView C;
    public int D = 2;
    public List<String> E;
    public List<String> F;
    public NumberPicker G;
    public NumberPicker H;
    public int I;
    public ScrollView J;
    public TextView g;
    public View h;
    public TextView i;
    public MyProgress j;
    public MyProgress k;
    public TextView l;
    public TextView m;
    public a.c.d.j.d.s.a n;
    public boolean o;
    public SwitchCompat p;
    public SwitchCompat q;
    public SwitchCompat r;
    public SwitchCompat s;
    public SwitchCompat t;
    public CompoundButton.OnCheckedChangeListener u;
    public CompoundButton.OnCheckedChangeListener v;
    public CompoundButton.OnCheckedChangeListener w;
    public CompoundButton.OnCheckedChangeListener x;
    public CompoundButton.OnCheckedChangeListener y;
    public ViewGroup z;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyProgress f3902a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3903b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f3904c;

        public a(MyProgress myProgress, int i, TextView textView) {
            this.f3902a = myProgress;
            this.f3903b = i;
            this.f3904c = textView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object obj;
            int i;
            SpannableStringBuilder spannableStringBuilder;
            MyProgress myProgress = this.f3902a;
            DeviceControlActivity deviceControlActivity = DeviceControlActivity.this;
            if (myProgress == deviceControlActivity.j) {
                spannableStringBuilder = new SpannableStringBuilder(String.format("%s%%", new Object[]{String.valueOf((int) (valueAnimator.getAnimatedFraction() * ((float) this.f3903b)))}));
                obj = new RelativeSizeSpan(0.3f);
                i = spannableStringBuilder.length() - 1;
            } else {
                spannableStringBuilder = new SpannableStringBuilder(String.format(deviceControlActivity.o ? "%sºF" : "%sºC", new Object[]{String.valueOf((int) (valueAnimator.getAnimatedFraction() * ((float) this.f3903b)))}));
                obj = new TopAlignSuperscriptSpan(0.2f);
                i = spannableStringBuilder.length() - 2;
            }
            spannableStringBuilder.setSpan(obj, i, spannableStringBuilder.length(), 33);
            this.f3904c.setText(spannableStringBuilder);
        }
    }

    public static void s(DeviceControlActivity deviceControlActivity, NumberPicker numberPicker) {
        if (deviceControlActivity.I == 0) {
            Map<String, Object> dps = deviceControlActivity.n.f270d.getDps();
            HashMap hashMap = new HashMap();
            if (!((Boolean) dps.get("1")).booleanValue()) {
                hashMap.put("1", Boolean.TRUE);
            }
            hashMap.put("103", String.valueOf(deviceControlActivity.E.get(numberPicker.getValue())));
            hashMap.put("2", "humidity");
            deviceControlActivity.n.b(oOO0O0O0.O0000oO0, hashMap);
        }
    }

    public static void w(Context context, DeviceBean deviceBean) {
        Intent intent = new Intent(context, DeviceControlActivity.class);
        intent.putExtra("intent_devId", deviceBean.getDevId());
        intent.putExtra("DEVICE_NAME", deviceBean.getName());
        context.startActivity(intent);
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_control);
        this.J = (ScrollView) findViewById(R.id.scroll_view);
        TextView textView = (TextView) findViewById(R.id.btn_switch_on_device);
        this.g = textView;
        textView.setOnClickListener(new h(this));
        TextView textView2 = (TextView) findViewById(R.id.tv_progress_humidity_label);
        textView2.setText(a.c.a.d.a.h(R.string.TR_HUMIDITY));
        textView2.setTypeface(e.a().f789b);
        this.j = (MyProgress) findViewById(R.id.progress_humidity);
        TextView textView3 = (TextView) findViewById(R.id.tv_progress_humidity);
        this.l = textView3;
        textView3.setTypeface(e.a().f789b);
        TextView textView4 = (TextView) findViewById(R.id.tv_progress_temp_label);
        textView4.setText(a.c.a.d.a.h(R.string.TR_TEMP));
        textView4.setTypeface(e.a().f789b);
        this.k = (MyProgress) findViewById(R.id.progress_temp);
        TextView textView5 = (TextView) findViewById(R.id.tv_progress_temp);
        this.m = textView5;
        textView5.setTypeface(e.a().f789b);
        this.k.setOnClickListener(new i(this));
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.sw_screen);
        this.p = switchCompat;
        switchCompat.setTypeface(e.a().f789b);
        this.p.setText(a.c.a.d.a.h(R.string.TR_SCREEN));
        j jVar = new j(this);
        this.u = jVar;
        this.p.setOnCheckedChangeListener(jVar);
        SwitchCompat switchCompat2 = (SwitchCompat) findViewById(R.id.sw_night_light);
        this.q = switchCompat2;
        switchCompat2.setTypeface(e.a().f789b);
        this.q.setText(a.c.a.d.a.h(R.string.TR_NIGHT_LIGHT));
        k kVar = new k(this);
        this.v = kVar;
        this.q.setOnCheckedChangeListener(kVar);
        SwitchCompat switchCompat3 = (SwitchCompat) findViewById(R.id.sw_manual_mode);
        this.r = switchCompat3;
        switchCompat3.setText(a.c.a.d.a.h(R.string.TR_MANUAL));
        l lVar = new l(this);
        this.w = lVar;
        this.r.setOnCheckedChangeListener(lVar);
        this.r.setTypeface(e.a().f789b);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ll_manual_mode);
        this.z = viewGroup;
        viewGroup.setOnClickListener(new m(this));
        TextView textView6 = (TextView) findViewById(R.id.tv_manual_mode);
        textView6.setText(a.c.a.d.a.h(R.string.TR_MANUAL));
        textView6.setTypeface(e.a().f789b);
        TextView textView7 = (TextView) findViewById(R.id.tv_manual_mode_select);
        textView7.setText(a.c.a.d.a.h(R.string.TR_FOG_DENSITY));
        textView7.setTypeface(e.a().f789b);
        this.C = (ImageView) findViewById(R.id.iv_manual_mode);
        SwitchCompat switchCompat4 = (SwitchCompat) findViewById(R.id.sw_automatic_mode);
        this.s = switchCompat4;
        switchCompat4.setTypeface(e.a().f789b);
        this.s.setText(a.c.a.d.a.h(R.string.TR_AUTOMATIC));
        n nVar = new n(this);
        this.x = nVar;
        this.s.setOnCheckedChangeListener(nVar);
        this.A = (ViewGroup) findViewById(R.id.ll_automatic_mode);
        TextView textView8 = (TextView) findViewById(R.id.tv_automatic_mode);
        textView8.setTypeface(e.a().f789b);
        textView8.setText(a.c.a.d.a.h(R.string.TR_AUTOMATIC));
        TextView textView9 = (TextView) findViewById(R.id.tv_automatic_mode_select);
        textView9.setTypeface(e.a().f789b);
        textView9.setText(a.c.a.d.a.h(R.string.TR_HUMIDITY_TARGET));
        this.G = (NumberPicker) findViewById(R.id.np_humidity);
        SwitchCompat switchCompat5 = (SwitchCompat) findViewById(R.id.sw_timer);
        this.t = switchCompat5;
        switchCompat5.setTypeface(e.a().f789b);
        this.t.setText(a.c.a.d.a.h(R.string.TR_PROGRAM));
        o oVar = new o(this);
        this.y = oVar;
        this.t.setOnCheckedChangeListener(oVar);
        this.B = (ViewGroup) findViewById(R.id.ll_timer);
        TextView textView10 = (TextView) findViewById(R.id.tv_timer);
        textView10.setTypeface(e.a().f789b);
        textView10.setText(a.c.a.d.a.h(R.string.TR_PROGRAM));
        TextView textView11 = (TextView) findViewById(R.id.tv_timer_select);
        textView11.setTypeface(e.a().f789b);
        textView11.setText(a.c.a.d.a.h(R.string.TR_SELECT_SWITCH_OFF_TIME));
        this.H = (NumberPicker) findViewById(R.id.np_timer);
        ((CardView) findViewById(R.id.card_timer_ok)).setOnClickListener(new p(this));
        TextView textView12 = (TextView) findViewById(R.id.tv_timer_ok);
        textView12.setTypeface(e.a().f788a);
        textView12.setText(a.c.a.d.a.h(R.string.TR_OK));
        this.h = findViewById(R.id.v_off_line);
        this.i = (TextView) findViewById(R.id.network_tip);
        this.n = new a.c.d.j.d.s.a(this, this);
        Bundle extras = getIntent().getExtras();
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabeceras);
        topMenuActivityVideo.setListener(this);
        topMenuActivityVideo.setSeccion((extras == null || !extras.containsKey("DEVICE_NAME")) ? a.c.a.d.a.h(R.string.TR_HUMITOP_CONNECT) : extras.getString("DEVICE_NAME"));
        Map<String, Object> dps = this.n.f270d.getDps();
        Set<String> range = ((EnumSchemaBean) JSON.parseObject(this.n.f270d.getSchemaMap().get("103").getProperty(), EnumSchemaBean.class)).getRange();
        this.E = new ArrayList();
        for (String next : range) {
            if (!next.equals("Co")) {
                this.E.add(next);
            }
        }
        Collections.sort(this.E, new a.c.d.j.d.b(this));
        String[] strArr = (String[]) this.E.toArray(new String[this.E.size()]);
        this.G.setDisplayedValues(strArr);
        this.G.setMaxValue(strArr.length - 1);
        this.G.setWrapSelectorWheel(true);
        this.G.setOnScrollListener(new c(this));
        this.G.setOnValueChangedListener(new d(this));
        Set<String> range2 = ((EnumSchemaBean) JSON.parseObject(this.n.f270d.getSchemaMap().get("13").getProperty(), EnumSchemaBean.class)).getRange();
        ArrayList arrayList = new ArrayList();
        this.F = arrayList;
        arrayList.addAll(range2);
        Collections.sort(this.F, new a.c.d.j.d.e(this));
        String[] strArr2 = (String[]) this.F.toArray(new String[this.F.size()]);
        this.H.setDisplayedValues(strArr2);
        this.H.setMaxValue(strArr2.length - 1);
        this.H.setWrapSelectorWheel(true);
        this.H.setOnScrollListener(new f(this));
        x(dps);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.n.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void u(String str, Object obj) {
        if (((Boolean) this.n.f270d.getDps().get("1")).booleanValue()) {
            this.n.a(str, obj);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("1", Boolean.TRUE);
        hashMap.put(str, obj);
        this.n.b(oOO0O0O0.O0000oO0, hashMap);
    }

    public final void v(MyProgress myProgress, TextView textView, int i2) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(myProgress, NotificationCompat.CATEGORY_PROGRESS, new int[]{0, i2});
        ofInt.addUpdateListener(new a(myProgress, i2, textView));
        ofInt.setDuration(1800);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0281, code lost:
        r0.setOnCheckedChangeListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x029d, code lost:
        v(r1, r2, ((java.lang.Integer) r0.getValue()).intValue());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x(java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r11 = this;
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x0008:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x02e4
            java.lang.Object r0 = r12.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 54
            r5 = 3
            java.lang.String r6 = "1"
            r7 = 8
            r8 = 2
            r9 = 0
            r10 = 1
            if (r3 == r4) goto L_0x0091
            r4 = 1571(0x623, float:2.201E-42)
            if (r3 == r4) goto L_0x0086
            switch(r3) {
                case 49: goto L_0x004b;
                case 50: goto L_0x0041;
                case 51: goto L_0x0037;
                default: goto L_0x0032;
            }
        L_0x0032:
            switch(r3) {
                case 48627: goto L_0x007c;
                case 48628: goto L_0x0071;
                case 48629: goto L_0x0067;
                case 48630: goto L_0x005d;
                case 48631: goto L_0x0053;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x009a
        L_0x0037:
            java.lang.String r3 = "3"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 1
            goto L_0x009a
        L_0x0041:
            java.lang.String r3 = "2"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 7
            goto L_0x009a
        L_0x004b:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x009a
            r2 = 0
            goto L_0x009a
        L_0x0053:
            java.lang.String r3 = "106"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 4
            goto L_0x009a
        L_0x005d:
            java.lang.String r3 = "105"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 3
            goto L_0x009a
        L_0x0067:
            java.lang.String r3 = "104"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 2
            goto L_0x009a
        L_0x0071:
            java.lang.String r3 = "103"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 8
            goto L_0x009a
        L_0x007c:
            java.lang.String r3 = "102"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 5
            goto L_0x009a
        L_0x0086:
            java.lang.String r3 = "14"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 9
            goto L_0x009a
        L_0x0091:
            java.lang.String r3 = "6"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x009a
            r2 = 6
        L_0x009a:
            java.lang.String r1 = "0"
            r3 = 0
            switch(r2) {
                case 0: goto L_0x02ac;
                case 1: goto L_0x0299;
                case 2: goto L_0x0294;
                case 3: goto L_0x0286;
                case 4: goto L_0x0268;
                case 5: goto L_0x024d;
                case 6: goto L_0x0221;
                case 7: goto L_0x01c1;
                case 8: goto L_0x019c;
                case 9: goto L_0x00a2;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            goto L_0x0008
        L_0x00a2:
            java.lang.Object r2 = r0.getValue()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            boolean r1 = r1.equals(r2)
            r2 = 2131821234(0x7f1102b2, float:1.9275205E38)
            if (r1 != 0) goto L_0x0170
            java.lang.Object r1 = r0.getValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r1 = java.lang.Integer.parseInt(r1)
            int r4 = r1 / 60
            int r1 = r1 % 60
            if (r4 == 0) goto L_0x00d7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "h"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x00d9
        L_0x00d7:
            java.lang.String r4 = ""
        L_0x00d9:
            if (r1 == 0) goto L_0x010a
            boolean r5 = r4.isEmpty()
            java.lang.String r7 = "m"
            if (r5 == 0) goto L_0x00f3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            goto L_0x010a
        L_0x00f3:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = " "
            r5.append(r4)
            r5.append(r1)
            r5.append(r7)
            java.lang.String r4 = r5.toString()
        L_0x010a:
            java.lang.String r1 = " ("
            java.lang.String r5 = ")"
            java.lang.String r1 = a.a.a.a.a.l(r1, r4, r5)
            java.lang.Object[] r4 = new java.lang.Object[r8]
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r4[r9] = r2
            r4[r10] = r1
            java.lang.String r2 = "%s%s"
            java.lang.String r2 = java.lang.String.format(r2, r4)
            android.text.SpannableString r4 = new android.text.SpannableString
            r4.<init>(r2)
            android.text.style.StyleSpan r5 = new android.text.style.StyleSpan
            r5.<init>(r10)
            int r7 = r2.length()
            int r1 = r1.length()
            int r7 = r7 - r1
            int r1 = r2.length()
            r2 = 33
            r4.setSpan(r5, r7, r1, r2)
            androidx.appcompat.widget.SwitchCompat r1 = r11.t
            r1.setText(r4)
            androidx.appcompat.widget.SwitchCompat r1 = r11.t
            r1.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r1 = r11.t
            r1.setChecked(r10)
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker r1 = r11.H
            java.util.List<java.lang.String> r2 = r11.F
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r0 = java.lang.Integer.parseInt(r0)
            int r3 = r0 / 60
            int r0 = r0 % 60
            if (r3 == 0) goto L_0x016b
            if (r0 == 0) goto L_0x0167
            int r3 = r3 + 1
        L_0x0167:
            java.lang.String r6 = java.lang.String.valueOf(r3)
        L_0x016b:
            int r0 = r2.indexOf(r6)
            goto L_0x0193
        L_0x0170:
            androidx.appcompat.widget.SwitchCompat r1 = r11.t
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r1.setText(r2)
            androidx.appcompat.widget.SwitchCompat r1 = r11.t
            r1.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r1 = r11.t
            r1.setChecked(r9)
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker r1 = r11.H
            java.util.List<java.lang.String> r2 = r11.F
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r0 = r2.indexOf(r0)
        L_0x0193:
            r1.setValue(r0)
            androidx.appcompat.widget.SwitchCompat r0 = r11.t
            android.widget.CompoundButton$OnCheckedChangeListener r1 = r11.y
            goto L_0x0281
        L_0x019c:
            java.lang.Object r1 = r0.getValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Co"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0008
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker r1 = r11.G
            java.util.List<java.lang.String> r2 = r11.E
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r0 = r2.indexOf(r0)
            r1.setValue(r0)
            goto L_0x0008
        L_0x01c1:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "manual"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01f7
            androidx.appcompat.widget.SwitchCompat r0 = r11.r
            r0.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r0 = r11.r
            r0.setChecked(r10)
            android.view.ViewGroup r0 = r11.z
            r0.setVisibility(r9)
            androidx.appcompat.widget.SwitchCompat r0 = r11.r
            android.widget.CompoundButton$OnCheckedChangeListener r1 = r11.w
            r0.setOnCheckedChangeListener(r1)
            androidx.appcompat.widget.SwitchCompat r0 = r11.s
            r0.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r0 = r11.s
            r0.setChecked(r9)
            android.view.ViewGroup r0 = r11.A
            r0.setVisibility(r7)
            goto L_0x021c
        L_0x01f7:
            androidx.appcompat.widget.SwitchCompat r0 = r11.r
            r0.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r0 = r11.r
            r0.setChecked(r9)
            android.view.ViewGroup r0 = r11.z
            r0.setVisibility(r7)
            androidx.appcompat.widget.SwitchCompat r0 = r11.r
            android.widget.CompoundButton$OnCheckedChangeListener r1 = r11.w
            r0.setOnCheckedChangeListener(r1)
            androidx.appcompat.widget.SwitchCompat r0 = r11.s
            r0.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r0 = r11.s
            r0.setChecked(r10)
            android.view.ViewGroup r0 = r11.A
            r0.setVisibility(r9)
        L_0x021c:
            androidx.appcompat.widget.SwitchCompat r0 = r11.s
            android.widget.CompoundButton$OnCheckedChangeListener r1 = r11.x
            goto L_0x0281
        L_0x0221:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r0 = java.lang.Integer.parseInt(r0)
            r11.D = r0
            if (r0 == r10) goto L_0x0243
            if (r0 == r8) goto L_0x023d
            if (r0 == r5) goto L_0x0237
            goto L_0x0008
        L_0x0237:
            android.widget.ImageView r0 = r11.C
            r1 = 2131231124(0x7f080194, float:1.807832E38)
            goto L_0x0248
        L_0x023d:
            android.widget.ImageView r0 = r11.C
            r1 = 2131231123(0x7f080193, float:1.8078318E38)
            goto L_0x0248
        L_0x0243:
            android.widget.ImageView r0 = r11.C
            r1 = 2131231122(0x7f080192, float:1.8078316E38)
        L_0x0248:
            r0.setImageResource(r1)
            goto L_0x0008
        L_0x024d:
            androidx.appcompat.widget.SwitchCompat r2 = r11.q
            r2.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r2 = r11.q
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            boolean r0 = r1.equals(r0)
            r2.setChecked(r0)
            androidx.appcompat.widget.SwitchCompat r0 = r11.q
            android.widget.CompoundButton$OnCheckedChangeListener r1 = r11.v
            goto L_0x0281
        L_0x0268:
            androidx.appcompat.widget.SwitchCompat r1 = r11.p
            r1.setOnCheckedChangeListener(r3)
            androidx.appcompat.widget.SwitchCompat r1 = r11.p
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r0 = r0 ^ r10
            r1.setChecked(r0)
            androidx.appcompat.widget.SwitchCompat r0 = r11.p
            android.widget.CompoundButton$OnCheckedChangeListener r1 = r11.u
        L_0x0281:
            r0.setOnCheckedChangeListener(r1)
            goto L_0x0008
        L_0x0286:
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r11.o = r0
            goto L_0x0008
        L_0x0294:
            com.cuatroochenta.miniland.utils.MyProgress r1 = r11.k
            android.widget.TextView r2 = r11.m
            goto L_0x029d
        L_0x0299:
            com.cuatroochenta.miniland.utils.MyProgress r1 = r11.j
            android.widget.TextView r2 = r11.l
        L_0x029d:
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r11.v(r1, r2, r0)
            goto L_0x0008
        L_0x02ac:
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x02ca
            android.widget.TextView r0 = r11.g
            r1 = 2131821230(0x7f1102ae, float:1.9275197E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            android.widget.TextView r0 = r11.g
            r1 = 2131099737(0x7f060059, float:1.7811836E38)
            goto L_0x02db
        L_0x02ca:
            android.widget.TextView r0 = r11.g
            r1 = 2131821231(0x7f1102af, float:1.92752E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            android.widget.TextView r0 = r11.g
            r1 = 2131099751(0x7f060067, float:1.7811864E38)
        L_0x02db:
            int r1 = androidx.core.content.ContextCompat.getColor(r11, r1)
            r0.setBackgroundColor(r1)
            goto L_0x0008
        L_0x02e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity.x(java.util.Map):void");
    }
}
