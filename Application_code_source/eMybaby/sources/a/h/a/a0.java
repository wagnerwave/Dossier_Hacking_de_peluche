package a.h.a;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.DetalleFamiliaActivity;
import com.sozpic.miniland.NuevoFamiliaActivity;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Familia;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.oOO0O0O0;

public class a0 extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f3448a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f3449b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressDialog f3450c;

    /* renamed from: d  reason: collision with root package name */
    public Usuario f3451d;

    /* renamed from: e  reason: collision with root package name */
    public Familia[] f3452e = null;
    public Handler f = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            a0.this.startActivityForResult(new Intent(a0.this.getActivity(), NuevoFamiliaActivity.class), 0);
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Familia familia = (Familia) a0.this.f3449b.getAdapter().getItem(i);
            if (!familia.getId().equals(oOO0O0O0.O0000oO0)) {
                Intent intent = new Intent(a0.this.getActivity(), DetalleFamiliaActivity.class);
                intent.putExtra("KEY_INTENT_FAMILIAR", familia);
                a0.this.startActivity(intent);
            }
        }
    }

    public class c extends Handler {
        public c() {
        }

        public void handleMessage(Message message) {
            a0.this.f3450c.dismiss();
            try {
                Log.d("MINILAND_EBABY", "SH2:" + message.toString());
                if (message.obj == null || message.obj.equals("null")) {
                    a0.this.f3449b.setAdapter((ListAdapter) null);
                    return;
                }
                a0.this.f3452e = a.e.a.a.r.b.T(message.obj.toString());
                a0.this.f3449b.setAdapter(new a.h.a.k0.b(a0.this.getActivity(), a0.this.f3452e));
            } catch (Exception e2) {
                Toast.makeText(a0.this.getActivity(), "Error", 0).show();
                a.e.a.a.r.b.j("FAMILIA", "Excepcion: " + e2.toString());
            }
        }
    }

    public void onClick(View view) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_familia, viewGroup, false);
        this.f3448a = inflate;
        ((TextView) inflate.findViewById(R.id.textView1)).setText(a.c.a.d.a.h(R.string.TR_TAP_ADD_FAMILY_MEMBER));
        this.f3451d = AppMiniland.f().i();
        this.f3449b = (ListView) this.f3448a.findViewById(R.id.listadofamilia);
        ((LinearLayout) this.f3448a.findViewById(R.id.linear_familia)).setOnClickListener(new a());
        this.f3449b.setOnItemClickListener(new b());
        return this.f3448a;
    }

    public void onResume() {
        super.onResume();
        if (a.c.a.d.a.k(getActivity())) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.f3450c = progressDialog;
            progressDialog.setCancelable(true);
            this.f3450c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f3450c.setIndeterminate(true);
            this.f3450c.show();
            try {
                new a.h.a.l0.b(this.f, "&bd=" + this.f3451d.getBd() + "&bdpre=" + this.f3451d.getBdpre() + "&carpeta=" + this.f3451d.getCarpeta(), "familia.php?listarfamilia=1").start();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f3450c.dismiss();
            }
        } else if (isAdded()) {
            try {
                a.c.a.f.b.l0(getActivity(), a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            } catch (WindowManager.BadTokenException unused) {
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
    }
}
