package com.sozpic.miniland.video;

import a.c.a.e.f;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tutk.IOTC.Camera;
import com.tutk.IOTC.IRegisterIOTCListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

public class EventListActivity extends Activity implements IRegisterIOTCListener, View.OnClickListener, TopMenuActivityVideo.c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f4636a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b  reason: collision with root package name */
    public e f4637b;

    /* renamed from: c  reason: collision with root package name */
    public a.h.a.n0.c f4638c;

    /* renamed from: d  reason: collision with root package name */
    public View f4639d = null;

    /* renamed from: e  reason: collision with root package name */
    public View f4640e = null;
    public View f = null;
    public View g = null;
    public ListView h = null;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public LinearLayout o;
    public Boolean p = Boolean.FALSE;
    public TopMenuActivityVideo q;
    public AdapterView.OnItemClickListener r = new a();
    public Handler s = new c();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int headerViewsCount;
            if (EventListActivity.this.f4636a.size() != 0 && EventListActivity.this.f4636a.size() >= i && EventListActivity.this.f4638c.a(0) && (headerViewsCount = i - EventListActivity.this.h.getHeaderViewsCount()) >= 0) {
                d dVar = EventListActivity.this.f4636a.get(headerViewsCount);
                if (dVar.f4647d != 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("dev_uuid", EventListActivity.this.i);
                    bundle.putString("dev_nickname", EventListActivity.this.k);
                    bundle.putInt("camera_channel", EventListActivity.this.n);
                    bundle.putInt("event_type", dVar.f4644a);
                    bundle.putLong("event_time", dVar.f4645b);
                    bundle.putString("event_uuid", dVar.a());
                    bundle.putString("view_acc", EventListActivity.this.l);
                    bundle.putString("view_pwd", EventListActivity.this.m);
                    bundle.putByteArray("event_time2", dVar.f4646c.toByteArray());
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(EventListActivity.this, PlaybackActivity.class);
                    EventListActivity.this.startActivityForResult(intent, 0);
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (EventListActivity.this.p.booleanValue()) {
                EventListActivity eventListActivity = EventListActivity.this;
                eventListActivity.p = Boolean.FALSE;
                eventListActivity.h.removeHeaderView(eventListActivity.f4639d);
                EventListActivity eventListActivity2 = EventListActivity.this;
                eventListActivity2.h.removeFooterView(eventListActivity2.f4640e);
                EventListActivity eventListActivity3 = EventListActivity.this;
                eventListActivity3.h.addFooterView(eventListActivity3.g);
                EventListActivity.this.f4637b.notifyDataSetChanged();
            }
        }
    }

    public class c extends Handler {
        public c() {
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            byte[] byteArray = data.getByteArray("data");
            int i = data.getInt("sessionChannel");
            int i2 = message.what;
            if (i2 != 2) {
                if (!(i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6)) {
                    int i3 = 8;
                    if (i2 != 8) {
                        if (i2 == 793 && byteArray.length >= 12 && EventListActivity.this.p.booleanValue()) {
                            byte b2 = byteArray[9];
                            byte b3 = byteArray[10];
                            if (b3 > 0) {
                                int totalSize = AVIOCTRLDEFs.SAvEvent.getTotalSize();
                                int i4 = 0;
                                while (i4 < b3) {
                                    byte[] bArr = new byte[i3];
                                    int i5 = (i4 * totalSize) + 12;
                                    System.arraycopy(byteArray, i5, bArr, 0, i3);
                                    AVIOCTRLDEFs.STimeDay sTimeDay = new AVIOCTRLDEFs.STimeDay(bArr);
                                    byte b4 = byteArray[i5 + 8];
                                    byte b5 = byteArray[i5 + 9];
                                    EventListActivity eventListActivity = EventListActivity.this;
                                    eventListActivity.f4636a.add(new d(eventListActivity, b4, sTimeDay, b5));
                                    i4++;
                                    i3 = 8;
                                }
                                EventListActivity.this.f4637b.notifyDataSetChanged();
                            }
                            if (b2 == 1) {
                                EventListActivity eventListActivity2 = EventListActivity.this;
                                eventListActivity2.p = Boolean.FALSE;
                                eventListActivity2.h.removeFooterView(eventListActivity2.f4640e);
                                EventListActivity eventListActivity3 = EventListActivity.this;
                                eventListActivity3.h.removeFooterView(eventListActivity3.g);
                                if (EventListActivity.this.f4636a.size() == 0) {
                                    Toast.makeText(EventListActivity.this, a.c.a.d.a.h(R.string.TR_NO_RESULT_FOUND), 0).show();
                                }
                            }
                        }
                    }
                }
                if (EventListActivity.this.h.getFooterViewsCount() == 0) {
                    EventListActivity.this.f4636a.clear();
                    EventListActivity eventListActivity4 = EventListActivity.this;
                    eventListActivity4.h.addFooterView(eventListActivity4.f);
                    EventListActivity eventListActivity5 = EventListActivity.this;
                    eventListActivity5.h.setAdapter(eventListActivity5.f4637b);
                }
            } else if (i == 0) {
                EventListActivity eventListActivity6 = EventListActivity.this;
                eventListActivity6.h.removeFooterView(eventListActivity6.f);
                EventListActivity.this.f4637b.notifyDataSetChanged();
            }
            super.handleMessage(message);
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public int f4644a;

        /* renamed from: b  reason: collision with root package name */
        public long f4645b;

        /* renamed from: c  reason: collision with root package name */
        public AVIOCTRLDEFs.STimeDay f4646c;

        /* renamed from: d  reason: collision with root package name */
        public int f4647d;

        /* renamed from: e  reason: collision with root package name */
        public UUID f4648e = UUID.randomUUID();

        public d(EventListActivity eventListActivity, int i, AVIOCTRLDEFs.STimeDay sTimeDay, int i2) {
            this.f4644a = i;
            this.f4646c = sTimeDay;
            this.f4647d = i2;
        }

        public String a() {
            return this.f4648e.toString();
        }
    }

    public class e extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public LayoutInflater f4649a;

        public final class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f4651a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f4652b;

            /* renamed from: c  reason: collision with root package name */
            public FrameLayout f4653c;

            public a(e eVar, a aVar) {
            }
        }

        public e(Context context) {
            this.f4649a = LayoutInflater.from(context);
        }

        public int getCount() {
            return EventListActivity.this.f4636a.size();
        }

        public Object getItem(int i) {
            return EventListActivity.this.f4636a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            int i2;
            TextView textView;
            d dVar = EventListActivity.this.f4636a.get(i);
            if (view == null) {
                view = this.f4649a.inflate(R.layout.event_list, (ViewGroup) null);
                aVar = new a(this, (a) null);
                aVar.f4651a = (TextView) view.findViewById(R.id.event);
                aVar.f4652b = (TextView) view.findViewById(R.id.time);
                aVar.f4653c = (FrameLayout) view.findViewById(R.id.eventLayout);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.f4651a.setText(MainActivity3.f(EventListActivity.this, dVar.f4644a, false));
            aVar.f4652b.setText(dVar.f4646c.getLocalTime());
            aVar.f4653c.setVisibility(EventListActivity.this.f4638c.a(0) & (dVar.f4647d != 2) ? 0 : 8);
            if (dVar.f4647d == 0) {
                aVar.f4651a.setTypeface((Typeface) null, 1);
                textView = aVar.f4651a;
                i2 = ViewCompat.MEASURED_STATE_MASK;
            } else {
                aVar.f4651a.setTypeface((Typeface) null, 0);
                textView = aVar.f4651a;
                i2 = -6710887;
            }
            textView.setTextColor(i2);
            return view;
        }

        public boolean isEnabled(int i) {
            if (EventListActivity.this.f4636a.size() == 0) {
                return false;
            }
            return super.isEnabled(i);
        }
    }

    public static String d(long j2, boolean z) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
        instance.setTimeInMillis(j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        if (z) {
            instance.add(2, -1);
        }
        return simpleDateFormat.format(instance.getTime());
    }

    public void a() {
        super.onBackPressed();
    }

    public void b() {
    }

    public final void e(long j2, long j3, int i2) {
        if (this.f4638c != null) {
            this.f4636a.clear();
            this.f4637b.notifyDataSetChanged();
            this.f4638c.sendIOCtrl(0, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_LISTEVENT_REQ, AVIOCTRLDEFs.SMsgAVIoctrlListEventReq.parseConent(this.n, j2, j3, (byte) i2, (byte) 0));
            this.h.removeFooterView(this.g);
            this.h.addFooterView(this.f4640e);
            String d2 = d(j2, false);
            String d3 = d(j3, false);
            ((TextView) this.f4639d.findViewById(R.id.txtSearchTimeDuration)).setText(d2 + " - " + d3);
            if (this.h.getHeaderViewsCount() == 0) {
                this.h.addHeaderView(this.f4639d);
            }
            this.h.setAdapter(this.f4637b);
            this.f4637b.notifyDataSetChanged();
            this.p = Boolean.TRUE;
            this.s.postDelayed(new b(), 180000);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0) {
            String string = intent.getExtras().getString("event_uuid");
            for (d next : this.f4636a) {
                if (next.a().equalsIgnoreCase(string)) {
                    next.f4647d = 1;
                    this.f4637b.notifyDataSetChanged();
                    return;
                }
            }
        } else if (i2 == 1 && i3 == -1) {
            Bundle extras = intent.getExtras();
            e(extras.getLong("start_time"), extras.getLong("stop_time"), extras.getInt("event_type"));
        }
    }

    public void onClick(View view) {
        if (view == this.o && !this.p.booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("dev_uid", this.j);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClass(this, SearchEventActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.event_view);
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabecera);
        this.q = topMenuActivityVideo;
        topMenuActivityVideo.setListener(this);
        this.q.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_CAMERA));
        Bundle extras = getIntent().getExtras();
        this.i = extras.getString("dev_uuid");
        this.j = extras.getString("dev_uid");
        this.k = extras.getString("dev_nickname");
        this.n = extras.getInt("camera_channel");
        this.l = extras.getString("view_acc");
        this.m = extras.getString("view_pwd");
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_buscar);
        this.o = linearLayout;
        linearLayout.setOnClickListener(this);
        this.o.setVisibility(8);
        ((TextView) findViewById(R.id.buscar)).setText(a.c.a.d.a.h(R.string.TR_SEARCH));
        Iterator<a.h.a.n0.c> it = MainActivity3.o.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a.h.a.n0.c next = it.next();
            if (this.i.equalsIgnoreCase(next.b())) {
                this.f4638c = next;
                next.registerIOTCListener(this);
                this.f4638c.f3534e = 0;
                break;
            }
        }
        this.f4637b = new e(this);
        ListView listView = (ListView) findViewById(R.id.lstEventList);
        this.h = listView;
        listView.setOnItemClickListener(this.r);
        View inflate = getLayoutInflater().inflate(R.layout.search_event_result, (ViewGroup) null);
        this.f4639d = inflate;
        ((TextView) inflate.findViewById(R.id.txtSearchEventDuration)).setText(a.c.a.d.a.h(R.string.TR_SEARCH_EVENT_FROM));
        this.f4640e = getLayoutInflater().inflate(R.layout.loading_events, (ViewGroup) null);
        View inflate2 = getLayoutInflater().inflate(R.layout.camera_is_offline, (ViewGroup) null);
        this.f = inflate2;
        ((TextView) inflate2.findViewById(R.id.camera_offline)).setText(a.c.a.d.a.h(R.string.TR_CAMERA_OFFLINE));
        View inflate3 = getLayoutInflater().inflate(R.layout.no_result, (ViewGroup) null);
        this.g = inflate3;
        ((TextView) inflate3.findViewById(R.id.txtNoResults)).setText(a.c.a.d.a.h(R.string.TR_NO_RESULT_FOUND));
        a.h.a.n0.c cVar = this.f4638c;
        if (cVar == null || !cVar.isChannelConnected(0)) {
            this.h.addFooterView(this.f);
            this.h.setAdapter(this.f4637b);
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        Calendar instance2 = Calendar.getInstance();
        instance2.add(5, 1);
        e(instance.getTimeInMillis(), instance2.getTimeInMillis(), 1);
    }

    public void onDestroy() {
        super.onDestroy();
        a.h.a.n0.c cVar = this.f4638c;
        if (cVar != null) {
            cVar.unregisterIOTCListener(this);
            this.f4638c = null;
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        a.h.a.n0.c cVar;
        if (i2 == 4 && (cVar = this.f4638c) != null) {
            cVar.unregisterIOTCListener(this);
            this.f4638c = null;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onResume() {
        super.onResume();
        f.c().e("VIGILABEBES_EVENTOS");
    }

    public void receiveChannelInfo(Camera camera, int i2, int i3) {
        if (this.f4638c == camera) {
            Bundle bundle = new Bundle();
            bundle.putInt("sessionChannel", i2);
            Message obtainMessage = this.s.obtainMessage();
            obtainMessage.what = i3;
            obtainMessage.setData(bundle);
            this.s.sendMessage(obtainMessage);
        }
    }

    public void receiveFrameData(Camera camera, int i2, Bitmap bitmap) {
    }

    public void receiveFrameInfo(Camera camera, int i2, long j2, int i3, int i4, int i5, int i6) {
    }

    public void receiveIOCtrlData(Camera camera, int i2, int i3, byte[] bArr) {
        if (this.f4638c == camera) {
            Bundle bundle = new Bundle();
            bundle.putInt("sessionChannel", i2);
            bundle.putByteArray("data", bArr);
            Message message = new Message();
            message.what = i3;
            message.setData(bundle);
            this.s.sendMessage(message);
        }
    }

    public void receiveSessionInfo(Camera camera, int i2) {
        if (this.f4638c == camera) {
            Bundle bundle = new Bundle();
            Message obtainMessage = this.s.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.setData(bundle);
            this.s.sendMessage(obtainMessage);
        }
    }
}
