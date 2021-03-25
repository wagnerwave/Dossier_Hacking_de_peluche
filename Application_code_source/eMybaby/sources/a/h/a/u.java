package a.h.a;

import a.c.d.d.d;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cuatroochenta.miniland.album.AlbumViewFlowActivity;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Imagen;
import com.sozpic.miniland.modelos.Usuario;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u extends Fragment implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public View f3543a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressDialog f3544b;

    /* renamed from: c  reason: collision with root package name */
    public Usuario f3545c;

    /* renamed from: d  reason: collision with root package name */
    public a.h.a.m0.c f3546d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f3547e = new ArrayList<>();
    public ArrayList<String> f = new ArrayList<>();
    public a.h.a.m0.a g;
    public GridView h;
    public int i;
    public a.c.d.d.d j;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            u.this.j.t(0, (a.c.d.s.g.b) null);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                u.this.m();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class c implements Runnable {

        public class a implements AdapterView.OnItemClickListener {
            public a() {
            }

            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                Intent intent = new Intent(u.this.getActivity(), AlbumViewFlowActivity.class);
                intent.putExtra("KEY_INTENT_IMAGE_POSITION", i);
                u.this.startActivity(intent);
            }
        }

        public c() {
        }

        public void run() {
            u uVar = u.this;
            Display defaultDisplay = ((WindowManager) uVar.f3546d.f3522a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            try {
                defaultDisplay.getSize(point);
            } catch (NoSuchMethodError unused) {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
            uVar.i = (int) ((((float) point.x) - 40.0f) / 3.0f);
            u uVar2 = u.this;
            FragmentActivity activity = u.this.getActivity();
            u uVar3 = u.this;
            uVar2.g = new a.h.a.m0.a(activity, uVar3.f3547e, uVar3.i);
            u uVar4 = u.this;
            uVar4.h.setAdapter(uVar4.g);
            u.this.h.setOnItemClickListener(new a());
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            Toast.makeText(u.this.getActivity(), a.c.a.d.a.h(R.string.TR_NO_PHOTOS), 1).show();
        }
    }

    public void l(String str) {
        n();
    }

    public void m() {
        String str;
        try {
            try {
                str = a.e.a.a.r.b.v("&bd=" + this.f3545c.getBd() + "&bdpre=" + this.f3545c.getBdpre() + "&carpeta=" + this.f3545c.getCarpeta(), "album.php?veralbum=1");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            if (!(str == null || str.length() <= 0 || str.length() == 0)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        Imagen imagen = new Imagen();
                        if (jSONObject.has("foto")) {
                            imagen.setUrl(jSONObject.getString("foto"));
                        }
                        if (jSONObject.has("idFoto")) {
                            imagen.setId(jSONObject.getString("idFoto"));
                        }
                        this.f3547e.add(imagen.getUrl());
                        this.f.add(imagen.getId());
                    }
                } catch (JSONException e3) {
                    a.e.a.a.r.b.j("parsejson", "Ex: " + e3.toString());
                }
            }
            this.f3544b.dismiss();
            getActivity().runOnUiThread(new c());
        } catch (Exception e4) {
            this.f3544b.dismiss();
            getActivity().runOnUiThread(new d());
            Log.d("MINILAND_EBABY", "ERROR EN GALERIA: " + e4.toString());
        }
    }

    public final void n() {
        this.f3547e.clear();
        this.f.clear();
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        this.f3544b = progressDialog;
        progressDialog.requestWindowFeature(1);
        this.f3544b.setOwnerActivity(getActivity());
        this.f3544b.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
        this.f3544b.setCancelable(true);
        this.f3544b.show();
        new Thread(new b()).start();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        a.c.d.d.d dVar = this.j;
        if (dVar == null || !dVar.n(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new a.c.d.d.d((Fragment) this, (d.a) this, bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3543a = layoutInflater.inflate(R.layout.activity_album, viewGroup, false);
        this.f3545c = AppMiniland.f().i();
        this.h = (GridView) this.f3543a.findViewById(R.id.grid_view);
        this.f3546d = new a.h.a.m0.c(getActivity());
        ViewGroup viewGroup2 = (ViewGroup) this.f3543a.findViewById(R.id.album_buttons_container);
        ((ImageView) viewGroup2.findViewById(R.id.layout_ed_delete_button)).setVisibility(8);
        ((ImageView) viewGroup2.findViewById(R.id.layout_ed_edit_button)).setOnClickListener(new a());
        return this.f3543a;
    }

    public void onResume() {
        super.onResume();
        n();
    }
}
