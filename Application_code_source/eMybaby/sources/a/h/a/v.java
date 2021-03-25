package a.h.a;

import a.h.a.k0.c;
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
import com.sozpic.miniland.DetalleBebeActivity;
import com.sozpic.miniland.NuevoBebeActivity;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Usuario;

public class v extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f3553a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f3554b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f3555c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressDialog f3556d;

    /* renamed from: e  reason: collision with root package name */
    public Usuario f3557e;
    public Bebe[] f = null;
    public Handler g = new b();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Bebe bebe = (Bebe) v.this.f3554b.getAdapter().getItem(i);
            if (bebe.getId() != 0) {
                Intent intent = new Intent(v.this.getActivity(), DetalleBebeActivity.class);
                intent.putExtra("KEY_INTENT_BABY", bebe);
                v.this.startActivity(intent);
            }
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            v.this.f3556d.dismiss();
            if (message != null) {
                try {
                    Log.d("MINILAND_EBABY", "SH2:" + message.toString());
                    if (message.obj == null || message.obj.equals("null")) {
                        v.this.f3554b.setAdapter((ListAdapter) null);
                        return;
                    }
                    v.this.f = a.e.a.a.r.b.S(message.obj.toString());
                    v.this.f3554b.setAdapter(new c(v.this.getActivity(), v.this.f));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Toast.makeText(v.this.getActivity(), "Error", 0).show();
        }
    }

    public void onClick(View view) {
        if (view == this.f3555c) {
            startActivityForResult(new Intent(getActivity(), NuevoBebeActivity.class), 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bebe, viewGroup, false);
        this.f3553a = inflate;
        ((TextView) inflate.findViewById(R.id.textView1)).setText(a.c.a.d.a.h(R.string.TR_TAP_ADD_NEWBORN));
        this.f3557e = AppMiniland.f().i();
        this.f3554b = (ListView) this.f3553a.findViewById(R.id.listadobebe);
        LinearLayout linearLayout = (LinearLayout) this.f3553a.findViewById(R.id.linear_bebe);
        this.f3555c = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f3554b.setOnItemClickListener(new a());
        return this.f3553a;
    }

    public void onResume() {
        super.onResume();
        if (a.c.a.d.a.k(getActivity())) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.f3556d = progressDialog;
            progressDialog.setCancelable(true);
            this.f3556d.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f3556d.setIndeterminate(true);
            this.f3556d.show();
            try {
                new a.h.a.l0.b(this.g, "&bd=" + this.f3557e.getBd() + "&bdpre=" + this.f3557e.getBdpre() + "&carpeta=" + this.f3557e.getCarpeta(), "bebe.php?listarbebe=1").start();
            } catch (Exception unused) {
                this.f3556d.dismiss();
            }
        } else if (isAdded()) {
            try {
                a.c.a.f.b.l0(getActivity(), a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            } catch (WindowManager.BadTokenException unused2) {
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
