package a.c.d.h;

import a.c.d.r.g;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cuatroochenta.miniland.emyscale.MyScaleSelectOptionActivity;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.ListadoMedicaActivity;
import com.sozpic.miniland.ListadoTermometroPreviaActivity;
import com.sozpic.miniland.NuevoBebeActivity;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Usuario;

public class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public ListView f127a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressDialog f128b;

    /* renamed from: c  reason: collision with root package name */
    public int f129c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f130d = new b();

    /* renamed from: a.c.d.h.a$a  reason: collision with other inner class name */
    public class C0005a implements AdapterView.OnItemClickListener {
        public C0005a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent;
            a.c.d.h.g.b bVar = (a.c.d.h.g.b) a.this.f127a.getAdapter();
            if (bVar != null) {
                Bebe bebe = bVar.f148b.get(i);
                a aVar = a.this;
                int i2 = aVar.f129c;
                if (i2 != 0) {
                    if (i2 == 1) {
                        intent = new Intent(a.this.getActivity(), ListadoTermometroPreviaActivity.class);
                    } else if (i2 == 2) {
                        intent = new Intent(a.this.getActivity(), ListadoMedicaActivity.class);
                    } else {
                        return;
                    }
                    intent.putExtra("KEY_INTENT_BABY", bebe);
                    a.this.startActivity(intent);
                    return;
                }
                FragmentActivity activity = aVar.getActivity();
                if (bebe != null) {
                    Intent intent2 = new Intent(activity, MyScaleSelectOptionActivity.class);
                    intent2.putExtra("KEY_INTENT_BABY", bebe);
                    activity.startActivity(intent2);
                }
            }
        }
    }

    public class b extends Handler {

        /* renamed from: a.c.d.h.a$b$a  reason: collision with other inner class name */
        public class C0006a implements DialogInterface.OnClickListener {
            public C0006a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.startActivity(new Intent(a.this.getActivity(), NuevoBebeActivity.class));
            }
        }

        public b() {
        }

        public void handleMessage(Message message) {
            a.this.f128b.dismiss();
            if (message != null) {
                try {
                    if (!message.obj.equals("null")) {
                        a.this.n(a.e.a.a.r.b.S(message.obj.toString()));
                        return;
                    }
                    a.this.n((Bebe[]) null);
                    a.c.a.f.b.m0(a.this.getActivity(), (String) null, a.c.a.d.a.h(R.string.TR_ADD_BABY_QUESTION), a.c.a.d.a.h(R.string.TR_ACEPTAR), a.c.a.d.a.h(R.string.TR_CANCEL), new C0006a());
                } catch (Exception unused) {
                }
            } else {
                Toast.makeText(a.this.getActivity(), "Error", 0).show();
            }
        }
    }

    public static a m(int i) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("SELECTOR_MODE", i);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void n(Bebe[] bebeArr) {
        ListView listView = this.f127a;
        if (listView != null) {
            a.c.d.h.g.b bVar = (a.c.d.h.g.b) listView.getAdapter();
            if (bVar == null) {
                bVar = new a.c.d.h.g.b(getActivity(), this.f129c);
                this.f127a.setAdapter(bVar);
            }
            bVar.f148b.clear();
            if (bebeArr != null && bebeArr.length > 0) {
                for (Bebe add : bebeArr) {
                    bVar.f148b.add(add);
                }
            }
            bVar.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f129c = arguments.getInt("SELECTOR_MODE", 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        View inflate = layoutInflater.inflate(R.layout.fragment_myscale_baby_list, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.baby_list_header);
        TextView textView = (TextView) findViewById.findViewById(R.id.list_header);
        ListView listView = (ListView) inflate.findViewById(R.id.baby_list_listview);
        this.f127a = listView;
        listView.setOnItemClickListener(new C0005a());
        int i2 = this.f129c;
        if (i2 != 0) {
            if (i2 == 1) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.termomether_pink));
                i = R.string.TR_THERMOMETER_SELECT_BABY_INSTRUCTIONS;
            } else if (i2 == 2) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.medical_green));
                i = R.string.TR_SELECT_BABY_CONSULT_MEDICAL_RECORD;
            }
            textView.setText(a.c.a.d.a.h(i));
        } else {
            findViewById.setBackgroundColor(getResources().getColor(R.color.list_selector_header));
            textView.setText(a.c.a.d.a.h(R.string.TR_SELECT_BABY_PROFILE));
            if (a.c.d.a.l().o() == -1) {
                a.c.a.d.a.q(getActivity(), (g) null);
            }
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            if (a.c.a.d.a.k(getActivity())) {
                Usuario i = AppMiniland.f().i();
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                this.f128b = progressDialog;
                progressDialog.setCancelable(true);
                this.f128b.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                this.f128b.setIndeterminate(true);
                this.f128b.show();
                try {
                    new a.h.a.l0.b(this.f130d, "&bd=" + i.getBd() + "&bdpre=" + i.getBdpre(), "bebe.php?listarbebe=1").start();
                } catch (Exception unused) {
                    this.f128b.dismiss();
                }
            } else if (isAdded()) {
                try {
                    a.c.a.f.b.l0(getActivity(), a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                } catch (WindowManager.BadTokenException unused2) {
                }
            }
        }
    }
}
