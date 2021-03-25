package a.h.a;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;
import com.roomorama.caldroid.CalendarHelper;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Agenda;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.oOO0O0O0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class z extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public Calendar f3564a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressDialog f3565b;

    /* renamed from: c  reason: collision with root package name */
    public Usuario f3566c;

    /* renamed from: d  reason: collision with root package name */
    public Agenda f3567d;

    /* renamed from: e  reason: collision with root package name */
    public ListView f3568e;
    public CaldroidFragment f;
    public HashMap<Date, ArrayList<Agenda>> g = new HashMap<>();
    public Handler h = new b();

    public class a extends CaldroidListener {
        public a() {
        }

        public void onSelectDate(Date date, View view) {
            z zVar = z.this;
            zVar.getActivity().runOnUiThread(new y(zVar, date));
            z zVar2 = z.this;
            if (zVar2.f3564a == null) {
                zVar2.f3564a = Calendar.getInstance();
            }
            z.this.f3564a.setTime(date);
            z.m(z.this);
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            z.this.f3565b.dismiss();
            if (message != null) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                z.this.g.clear();
                String obj = message.obj.toString();
                if (!a.c.a.d.a.j(obj)) {
                    try {
                        JSONArray jSONArray = new JSONArray(obj);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            Agenda agenda = new Agenda(jSONArray.getJSONObject(i));
                            if (agenda.getStartDate() != null) {
                                Calendar instance = Calendar.getInstance();
                                instance.setTime(agenda.getStartDate());
                                instance.set(11, 0);
                                instance.set(12, 0);
                                instance.set(13, 0);
                                instance.set(14, 0);
                                Calendar instance2 = Calendar.getInstance();
                                if (agenda.getEndDate() != null) {
                                    instance2.setTime(agenda.getEndDate());
                                    instance2.set(11, 0);
                                    instance2.set(12, 0);
                                    instance2.set(13, 0);
                                    instance2.set(14, 0);
                                } else {
                                    instance2.setTime(instance.getTime());
                                }
                                while (true) {
                                    if (!instance2.after(instance) && !instance2.equals(instance)) {
                                        break;
                                    }
                                    if (z.this.g.containsKey(instance.getTime())) {
                                        z.this.g.get(instance.getTime()).add(agenda);
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(agenda);
                                        z.this.g.put(instance.getTime(), arrayList);
                                    }
                                    instance.add(5, 1);
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            z.this.n();
            z.m(z.this);
        }
    }

    public static void m(z zVar) {
        a.h.a.k0.a aVar = (a.h.a.k0.a) zVar.f3568e.getAdapter();
        if (aVar == null) {
            aVar = new a.h.a.k0.a(zVar.getActivity());
            zVar.f3568e.setAdapter(aVar);
        }
        ArrayList arrayList = zVar.g.get(zVar.f3564a.getTime());
        aVar.f3488b.clear();
        if (arrayList == null || arrayList.isEmpty()) {
            aVar.f3488b.add(new Agenda());
        } else {
            aVar.f3488b.addAll(arrayList);
        }
        aVar.notifyDataSetChanged();
        a.e.a.a.r.b.Z(zVar.f3568e);
    }

    public void n() {
        this.f = new CaldroidFragment();
        Bundle bundle = new Bundle();
        if (this.f3564a == null) {
            this.f3564a = Calendar.getInstance();
        }
        bundle.putInt(CaldroidFragment.MONTH, this.f3564a.get(2) + 1);
        bundle.putInt(CaldroidFragment.YEAR, this.f3564a.get(1));
        bundle.putBoolean(CaldroidFragment.ENABLE_SWIPE, false);
        bundle.putInt(CaldroidFragment.START_DAY_OF_WEEK, CaldroidFragment.MONDAY);
        bundle.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);
        ArrayList arrayList = new ArrayList();
        for (Date convertDateToDateTime : this.g.keySet()) {
            arrayList.add(CalendarHelper.convertDateToDateTime(convertDateToDateTime));
        }
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList(CaldroidFragment.SELECTED_DATES, CalendarHelper.convertToStringList(arrayList));
        }
        this.f.setArguments(bundle);
        if (!isStateSaved()) {
            FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.calendar1, this.f);
            beginTransaction.commit();
        }
        this.f.setCaldroidListener(new a());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_calendario, viewGroup, false);
        this.f3566c = AppMiniland.f().i();
        Agenda agenda = new Agenda();
        this.f3567d = agenda;
        agenda.setId(oOO0O0O0.O0000oO0);
        this.f3567d.setNombre(a.c.a.d.a.h(R.string.TR_EMPTY_EVENTS));
        n();
        ListView listView = (ListView) inflate.findViewById(R.id.listacalendar);
        this.f3568e = listView;
        listView.setOnItemClickListener(new w(this));
        a.e.a.a.r.b.Z(this.f3568e);
        ((LinearLayout) inflate.findViewById(R.id.ly_home_buttonlogin)).setOnClickListener(new x(this));
        return inflate;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r4 = this;
            super.onResume()
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            if (r0 != 0) goto L_0x000b
            goto L_0x009f
        L_0x000b:
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            boolean r0 = a.c.a.d.a.k(r0)
            if (r0 == 0) goto L_0x0084
            android.app.ProgressDialog r0 = new android.app.ProgressDialog
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()
            r0.<init>(r1)
            r4.f3565b = r0
            r1 = 1
            r0.setCancelable(r1)
            android.app.ProgressDialog r0 = r4.f3565b
            r2 = 2131821439(0x7f11037f, float:1.9275621E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setMessage(r2)
            android.app.ProgressDialog r0 = r4.f3565b
            r0.setIndeterminate(r1)
            android.app.ProgressDialog r0 = r4.f3565b
            r0.show()
            java.util.Calendar r0 = r4.f3564a     // Catch:{ Exception -> 0x009f }
            if (r0 != 0) goto L_0x0044
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x009f }
            r4.f3564a = r0     // Catch:{ Exception -> 0x009f }
        L_0x0044:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r0.<init>()     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "&bd="
            r0.append(r1)     // Catch:{ Exception -> 0x009f }
            com.sozpic.miniland.modelos.Usuario r1 = r4.f3566c     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = r1.getBd()     // Catch:{ Exception -> 0x009f }
            r0.append(r1)     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "&bdpre="
            r0.append(r1)     // Catch:{ Exception -> 0x009f }
            com.sozpic.miniland.modelos.Usuario r1 = r4.f3566c     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = r1.getBdpre()     // Catch:{ Exception -> 0x009f }
            r0.append(r1)     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = "&lang="
            r0.append(r1)     // Catch:{ Exception -> 0x009f }
            com.sozpic.miniland.AppMiniland r1 = com.sozpic.miniland.AppMiniland.f()     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = r1.f1b     // Catch:{ Exception -> 0x009f }
            r0.append(r1)     // Catch:{ Exception -> 0x009f }
            a.h.a.l0.b r1 = new a.h.a.l0.b     // Catch:{ Exception -> 0x009f }
            android.os.Handler r2 = r4.h     // Catch:{ Exception -> 0x009f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009f }
            java.lang.String r3 = "calendario.php?listaractividades=1"
            r1.<init>(r2, r0, r3)     // Catch:{ Exception -> 0x009f }
            r1.start()     // Catch:{ Exception -> 0x009f }
            goto L_0x009f
        L_0x0084:
            boolean r0 = r4.isAdded()
            if (r0 == 0) goto L_0x009f
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()     // Catch:{  }
            r1 = 2131821174(0x7f110276, float:1.9275084E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)     // Catch:{  }
            r2 = 2131820553(0x7f110009, float:1.9273824E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)     // Catch:{  }
            a.c.a.f.b.l0(r0, r1, r2)     // Catch:{  }
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h.a.z.onResume():void");
    }
}
