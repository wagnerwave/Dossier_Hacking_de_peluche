package com.sozpic.miniland.video;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.sozpic.miniland.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class SearchEventActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public Calendar f4750a;

    /* renamed from: b  reason: collision with root package name */
    public Calendar f4751b;

    /* renamed from: c  reason: collision with root package name */
    public int f4752c;

    /* renamed from: d  reason: collision with root package name */
    public String f4753d;

    /* renamed from: e  reason: collision with root package name */
    public List<m> f4754e = Collections.synchronizedList(new ArrayList());
    public n f;
    public AdapterView.OnItemClickListener g = new d();

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TimePickerDialog.OnTimeSetListener f4755a;

        public a(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
            this.f4755a = onTimeSetListener;
        }

        public void onClick(View view) {
            Calendar instance = Calendar.getInstance();
            new TimePickerDialog(SearchEventActivity.this, this.f4755a, instance.get(11), instance.get(12), false).show();
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f4757a;

        public b(AlertDialog alertDialog) {
            this.f4757a = alertDialog;
        }

        public void onClick(View view) {
            a.h.a.n0.a aVar = new a.h.a.n0.a(SearchEventActivity.this);
            SearchEventActivity searchEventActivity = SearchEventActivity.this;
            String str = searchEventActivity.f4753d;
            int i = searchEventActivity.f4752c;
            long timeInMillis = searchEventActivity.f4750a.getTimeInMillis();
            long timeInMillis2 = SearchEventActivity.this.f4751b.getTimeInMillis();
            SQLiteDatabase writableDatabase = aVar.f3524a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("dev_uid", str);
            contentValues.put("search_event_type", Integer.valueOf(i));
            contentValues.put("search_start_time", Long.valueOf(timeInMillis));
            contentValues.put("search_stop_time", Long.valueOf(timeInMillis2));
            writableDatabase.insertOrThrow("search_history", (String) null, contentValues);
            writableDatabase.close();
            Bundle bundle = new Bundle();
            bundle.putInt("event_type", SearchEventActivity.this.f4752c);
            bundle.putLong("start_time", SearchEventActivity.this.f4750a.getTimeInMillis());
            bundle.putLong("stop_time", SearchEventActivity.this.f4751b.getTimeInMillis());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            SearchEventActivity.this.setResult(-1, intent);
            SearchEventActivity.this.finish();
            this.f4757a.dismiss();
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f4759a;

        public c(SearchEventActivity searchEventActivity, AlertDialog alertDialog) {
            this.f4759a = alertDialog;
        }

        public void onClick(View view) {
            this.f4759a.dismiss();
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2;
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
            Calendar instance2 = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
            if (i < 4) {
                if (i == 0) {
                    instance.add(10, -1);
                } else if (i == 1) {
                    instance.add(11, -12);
                } else if (i == 2) {
                    instance.add(6, -1);
                } else if (i == 3) {
                    instance.add(6, -7);
                }
                i2 = 0;
            } else if (i == 4) {
                SearchEventActivity.this.c();
                return;
            } else {
                m mVar = SearchEventActivity.this.f4754e.get(i - 5);
                instance.setTimeInMillis(mVar.f4784b);
                instance2.setTimeInMillis(mVar.f4785c);
                i2 = mVar.f4783a;
            }
            bundle.putInt("event_type", i2);
            bundle.putLong("start_time", instance.getTimeInMillis());
            bundle.putLong("stop_time", instance2.getTimeInMillis());
            intent.putExtras(bundle);
            SearchEventActivity.this.setResult(-1, intent);
            SearchEventActivity.this.finish();
        }
    }

    public class e implements AdapterView.OnItemSelectedListener {
        public e() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchEventActivity.this.f4752c = i;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class f implements DatePickerDialog.OnDateSetListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Button f4762a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f4763b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Button f4764c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Button f4765d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f4766e;

        public f(Button button, SimpleDateFormat simpleDateFormat, Button button2, Button button3, SimpleDateFormat simpleDateFormat2) {
            this.f4762a = button;
            this.f4763b = simpleDateFormat;
            this.f4764c = button2;
            this.f4765d = button3;
            this.f4766e = simpleDateFormat2;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Calendar calendar = SearchEventActivity.this.f4750a;
            calendar.set(i, i2, i3, calendar.get(11), SearchEventActivity.this.f4750a.get(12), 0);
            this.f4762a.setText(this.f4763b.format(SearchEventActivity.this.f4750a.getTime()));
            SearchEventActivity searchEventActivity = SearchEventActivity.this;
            if (searchEventActivity.f4750a.after(searchEventActivity.f4751b)) {
                SearchEventActivity searchEventActivity2 = SearchEventActivity.this;
                searchEventActivity2.f4751b.setTimeInMillis(searchEventActivity2.f4750a.getTimeInMillis());
                this.f4764c.setText(this.f4763b.format(SearchEventActivity.this.f4751b.getTime()));
                this.f4765d.setText(this.f4766e.format(SearchEventActivity.this.f4751b.getTime()));
            }
        }
    }

    public class g implements DatePickerDialog.OnDateSetListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Button f4767a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f4768b;

        public g(Button button, SimpleDateFormat simpleDateFormat) {
            this.f4767a = button;
            this.f4768b = simpleDateFormat;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Calendar instance = Calendar.getInstance();
            instance.set(i, i2, i3, SearchEventActivity.this.f4751b.get(11), SearchEventActivity.this.f4751b.get(12), 0);
            if (instance.after(SearchEventActivity.this.f4750a) || instance.equals(SearchEventActivity.this.f4750a)) {
                Calendar calendar = SearchEventActivity.this.f4751b;
                calendar.set(i, i2, i3, calendar.get(11), SearchEventActivity.this.f4751b.get(12), 0);
                this.f4767a.setText(this.f4768b.format(SearchEventActivity.this.f4751b.getTime()));
            }
        }
    }

    public class h implements TimePickerDialog.OnTimeSetListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Button f4770a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f4771b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Button f4772c;

        public h(Button button, SimpleDateFormat simpleDateFormat, Button button2) {
            this.f4770a = button;
            this.f4771b = simpleDateFormat;
            this.f4772c = button2;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Calendar calendar = SearchEventActivity.this.f4750a;
            calendar.set(calendar.get(1), SearchEventActivity.this.f4750a.get(2), SearchEventActivity.this.f4750a.get(5), i, i2);
            this.f4770a.setText(this.f4771b.format(SearchEventActivity.this.f4750a.getTime()));
            SearchEventActivity searchEventActivity = SearchEventActivity.this;
            if (searchEventActivity.f4750a.after(searchEventActivity.f4751b)) {
                SearchEventActivity searchEventActivity2 = SearchEventActivity.this;
                searchEventActivity2.f4751b.setTimeInMillis(searchEventActivity2.f4750a.getTimeInMillis());
                this.f4772c.setText(this.f4771b.format(SearchEventActivity.this.f4751b.getTime()));
            }
        }
    }

    public class i implements TimePickerDialog.OnTimeSetListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Button f4774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f4775b;

        public i(Button button, SimpleDateFormat simpleDateFormat) {
            this.f4774a = button;
            this.f4775b = simpleDateFormat;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Calendar instance = Calendar.getInstance();
            instance.set(SearchEventActivity.this.f4751b.get(1), SearchEventActivity.this.f4751b.get(2), SearchEventActivity.this.f4751b.get(5), i, i2, 0);
            if (instance.after(SearchEventActivity.this.f4750a) || instance.equals(SearchEventActivity.this.f4750a)) {
                Calendar calendar = SearchEventActivity.this.f4751b;
                calendar.set(calendar.get(1), SearchEventActivity.this.f4751b.get(2), SearchEventActivity.this.f4751b.get(5), i, i2);
                this.f4774a.setText(this.f4775b.format(SearchEventActivity.this.f4751b.getTime()));
            }
        }
    }

    public class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DatePickerDialog.OnDateSetListener f4777a;

        public j(DatePickerDialog.OnDateSetListener onDateSetListener) {
            this.f4777a = onDateSetListener;
        }

        public void onClick(View view) {
            Calendar instance = Calendar.getInstance();
            new DatePickerDialog(SearchEventActivity.this, this.f4777a, instance.get(1), instance.get(2), instance.get(5)).show();
        }
    }

    public class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TimePickerDialog.OnTimeSetListener f4779a;

        public k(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
            this.f4779a = onTimeSetListener;
        }

        public void onClick(View view) {
            Calendar instance = Calendar.getInstance();
            new TimePickerDialog(SearchEventActivity.this, this.f4779a, instance.get(11), instance.get(12), false).show();
        }
    }

    public class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DatePickerDialog.OnDateSetListener f4781a;

        public l(DatePickerDialog.OnDateSetListener onDateSetListener) {
            this.f4781a = onDateSetListener;
        }

        public void onClick(View view) {
            Calendar instance = Calendar.getInstance();
            new DatePickerDialog(SearchEventActivity.this, this.f4781a, instance.get(1), instance.get(2), instance.get(5)).show();
        }
    }

    public class m {

        /* renamed from: a  reason: collision with root package name */
        public int f4783a;

        /* renamed from: b  reason: collision with root package name */
        public long f4784b;

        /* renamed from: c  reason: collision with root package name */
        public long f4785c;

        public m(SearchEventActivity searchEventActivity, int i, long j, long j2) {
            this.f4783a = i;
            this.f4784b = j;
            this.f4785c = j2;
        }
    }

    public class n extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public LayoutInflater f4786a;

        public final class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f4788a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f4789b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f4790c;

            public a(n nVar, d dVar) {
            }
        }

        public n(Context context) {
            this.f4786a = LayoutInflater.from(context);
        }

        public int getCount() {
            return SearchEventActivity.this.f4754e.size();
        }

        public Object getItem(int i) {
            return SearchEventActivity.this.f4754e.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            m mVar = SearchEventActivity.this.f4754e.get(i);
            if (view == null) {
                view = this.f4786a.inflate(R.layout.search_event_history_item, (ViewGroup) null);
                aVar = new a(this, (d) null);
                aVar.f4788a = (TextView) view.findViewById(R.id.txtEventType);
                aVar.f4789b = (TextView) view.findViewById(R.id.txtStartTime);
                aVar.f4790c = (TextView) view.findViewById(R.id.txtStopTime);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (mVar != null) {
                Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
                Calendar instance2 = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
                instance.setTimeInMillis(mVar.f4784b);
                instance2.setTimeInMillis(mVar.f4785c);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                simpleDateFormat.setTimeZone(TimeZone.getDefault());
                aVar.f4788a.setText(MainActivity3.f(SearchEventActivity.this, mVar.f4783a, true));
                aVar.f4789b.setText(simpleDateFormat.format(instance.getTime()));
                aVar.f4790c.setText(simpleDateFormat.format(instance2.getTime()));
            }
            return view;
        }
    }

    public final void b() {
        SQLiteDatabase b2 = new a.h.a.n0.a(this).b();
        int i2 = 2;
        int i3 = 3;
        int i4 = 4;
        SQLiteDatabase sQLiteDatabase = b2;
        Cursor query = sQLiteDatabase.query("search_history", new String[]{"_id", "dev_uid", "search_event_type", "search_start_time", "search_stop_time"}, a.a.a.a.a.m(a.a.a.a.a.n("dev_uid = '"), this.f4753d, "'"), (String[]) null, (String) null, (String) null, "_id DESC LIMIT 10");
        while (query.moveToNext()) {
            this.f4754e.add(new m(this, query.getInt(i2), query.getLong(i3), query.getLong(i4)));
            i4 = 4;
            i2 = 2;
            i3 = 3;
        }
        query.close();
        b2.close();
    }

    public final void c() {
        AlertDialog create = new AlertDialog.Builder(new ContextThemeWrapper()).create();
        create.setTitle(a.c.a.d.a.h(R.string.TR_EVENT_SEARCH));
        create.setIcon(17301659);
        View inflate = create.getLayoutInflater().inflate(R.layout.search_event_custom, (ViewGroup) null);
        create.setView(inflate);
        ((TextView) inflate.findViewById(R.id.txtSearchFrom)).setText(a.c.a.d.a.h(R.string.TR_SEARCH_EVENT_FROM));
        ((TextView) inflate.findViewById(R.id.txtSearchTo)).setText(a.c.a.d.a.h(R.string.TR_SEARCH_EVENT_TO));
        ((TextView) inflate.findViewById(R.id.txtSearchEventType)).setText(a.c.a.d.a.h(R.string.TR_EVENT_TYPE));
        Spinner spinner = (Spinner) inflate.findViewById(R.id.spinEventType);
        Button button = (Button) inflate.findViewById(R.id.btnStartDate);
        Button button2 = (Button) inflate.findViewById(R.id.btnStartTime);
        Button button3 = (Button) inflate.findViewById(R.id.btnStopDate);
        Button button4 = (Button) inflate.findViewById(R.id.btnStopTime);
        Button button5 = (Button) inflate.findViewById(R.id.btnOK);
        button5.setText(a.c.a.d.a.h(R.string.TR_OK));
        Button button6 = (Button) inflate.findViewById(R.id.btnCancel);
        button6.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
        Calendar instance = Calendar.getInstance();
        this.f4750a = instance;
        instance.set(13, 0);
        Calendar instance2 = Calendar.getInstance();
        this.f4751b = instance2;
        instance2.set(13, 0);
        button.setText(simpleDateFormat.format(this.f4750a.getTime()));
        button2.setText(simpleDateFormat2.format(this.f4750a.getTime()));
        button3.setText(simpleDateFormat.format(this.f4751b.getTime()));
        button4.setText(simpleDateFormat2.format(this.f4751b.getTime()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.c.a.d.a.h(R.string.TR_EVENT_TYPE_ALL));
        arrayList.add(a.c.a.d.a.h(R.string.TR_EVENT_TYPE_MOTION_DETECTION));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new e());
        Button button7 = button6;
        f fVar = r0;
        f fVar2 = new f(button, simpleDateFormat, button3, button4, simpleDateFormat2);
        g gVar = new g(button3, simpleDateFormat);
        SimpleDateFormat simpleDateFormat3 = simpleDateFormat2;
        h hVar = new h(button2, simpleDateFormat3, button4);
        i iVar = new i(button4, simpleDateFormat3);
        button.setOnClickListener(new j(fVar));
        button2.setOnClickListener(new k(hVar));
        button3.setOnClickListener(new l(gVar));
        button4.setOnClickListener(new a(iVar));
        button5.setOnClickListener(new b(create));
        button7.setOnClickListener(new c(this, create));
        create.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.search_event);
        this.f4753d = getIntent().getExtras().getString("dev_uid");
        this.f = new n(this);
        ListView listView = (ListView) findViewById(R.id.lstEventSearch);
        View inflate = getLayoutInflater().inflate(R.layout.search_event_predefined_item, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.txtSearchPredefined)).setText(a.c.a.d.a.h(R.string.TR_TIPS_SEARCH_WITHIN_AN_HOUR));
        listView.addHeaderView(inflate);
        View inflate2 = getLayoutInflater().inflate(R.layout.search_event_predefined_item, (ViewGroup) null);
        ((TextView) inflate2.findViewById(R.id.txtSearchPredefined)).setText(a.c.a.d.a.h(R.string.TR_TIPS_SEARCH_WITHIN_HALF_A_DAY));
        listView.addHeaderView(inflate2);
        View inflate3 = getLayoutInflater().inflate(R.layout.search_event_predefined_item, (ViewGroup) null);
        ((TextView) inflate3.findViewById(R.id.txtSearchPredefined)).setText(a.c.a.d.a.h(R.string.TR_TIPS_SEARCH_WITHIN_A_DAY));
        listView.addHeaderView(inflate3);
        View inflate4 = getLayoutInflater().inflate(R.layout.search_event_predefined_item, (ViewGroup) null);
        ((TextView) inflate4.findViewById(R.id.txtSearchPredefined)).setText(a.c.a.d.a.h(R.string.TR_TIPS_SEARCH_WITHIN_A_WEEK));
        listView.addHeaderView(inflate4);
        View inflate5 = getLayoutInflater().inflate(R.layout.search_event_predefined_item, (ViewGroup) null);
        ((TextView) inflate5.findViewById(R.id.txtSearchPredefined)).setText(a.c.a.d.a.h(R.string.TR_TIPS_SEARCH_CUSTOM));
        listView.addHeaderView(inflate5);
        b();
        listView.setAdapter(this.f);
        listView.setOnItemClickListener(this.g);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
