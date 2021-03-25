package com.cuatroochenta.miniland.album;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Imagen;
import com.sozpic.miniland.modelos.Usuario;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlbumViewFlowActivity extends Activity implements TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f3798a;

    /* renamed from: b  reason: collision with root package name */
    public Usuario f3799b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressDialog f3800c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f3801d;

    /* renamed from: e  reason: collision with root package name */
    public int f3802e = -1;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Imagen imagen;
            a.c.d.d.e.a aVar = (a.c.d.d.e.a) AlbumViewFlowActivity.this.f3801d.getAdapter();
            if (aVar != null && (imagen = aVar.f62b.get(AlbumViewFlowActivity.this.f3801d.getCurrentItem())) != null && !a.c.a.d.a.j(imagen.getId())) {
                AlbumViewFlowActivity albumViewFlowActivity = AlbumViewFlowActivity.this;
                String id = imagen.getId();
                if (albumViewFlowActivity != null) {
                    Dialog dialog = new Dialog(albumViewFlowActivity, 2131886561);
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(R.layout.popup_mensaje);
                    dialog.setCancelable(true);
                    Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_IMAGE_CONFIRM_DIALOG, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
                    button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
                    button.setOnClickListener(new a.c.d.d.a(albumViewFlowActivity, dialog));
                    Button button2 = (Button) dialog.findViewById(R.id.ook);
                    button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
                    button2.setOnClickListener(new a.c.d.d.b(albumViewFlowActivity, id, dialog));
                    dialog.show();
                    return;
                }
                throw null;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                AlbumViewFlowActivity.this.d();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3805a;

        public c(ArrayList arrayList) {
            this.f3805a = arrayList;
        }

        public void run() {
            AlbumViewFlowActivity.c(AlbumViewFlowActivity.this, this.f3805a);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            Toast.makeText(AlbumViewFlowActivity.this, a.c.a.d.a.h(R.string.TR_NO_PHOTOS), 1).show();
        }
    }

    public class e extends AsyncTask<String, Void, String> {
        public e(a aVar) {
        }

        public Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            try {
                Usuario i = AppMiniland.f().i();
                a.e.a.a.r.b.w("&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&id=" + strArr[0], "album.php?eliminarfoto=1");
                return "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public void onPostExecute(Object obj) {
            String str = (String) obj;
            AlbumViewFlowActivity.this.f3800c.dismiss();
            AlbumViewFlowActivity.this.e();
        }

        public void onPreExecute() {
        }
    }

    public static void c(AlbumViewFlowActivity albumViewFlowActivity, ArrayList arrayList) {
        if (albumViewFlowActivity != null) {
            albumViewFlowActivity.f3801d.setAdapter(new a.c.d.d.e.a(albumViewFlowActivity, arrayList));
            int i = albumViewFlowActivity.f3802e;
            if (i != -1) {
                albumViewFlowActivity.f3801d.setCurrentItem(i);
                albumViewFlowActivity.f3802e = -1;
            }
            if (arrayList.size() == 0) {
                albumViewFlowActivity.finish();
                return;
            }
            return;
        }
        throw null;
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void d() {
        String str;
        try {
            String str2 = "&bd=" + this.f3799b.getBd() + "&bdpre=" + this.f3799b.getBdpre() + "&carpeta=" + this.f3799b.getCarpeta();
            ArrayList arrayList = new ArrayList();
            try {
                str = a.e.a.a.r.b.v(str2, "album.php?veralbum=1");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            if (!(str == null || str.length() <= 0 || str.length() == 0)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        Imagen imagen = new Imagen();
                        if (jSONObject.has("foto")) {
                            imagen.setUrl(jSONObject.getString("foto"));
                        }
                        if (jSONObject.has("idFoto")) {
                            imagen.setId(jSONObject.getString("idFoto"));
                        }
                        arrayList.add(imagen);
                    }
                } catch (JSONException e3) {
                    a.e.a.a.r.b.j("parsejson", "Ex: " + e3.toString());
                }
            }
            this.f3798a.dismiss();
            runOnUiThread(new c(arrayList));
        } catch (Exception e4) {
            this.f3798a.dismiss();
            runOnUiThread(new d());
            Log.d("MINILAND_EBABY", "ERROR EN GALERIA: " + e4.toString());
        }
    }

    public final void e() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f3798a = progressDialog;
        progressDialog.requestWindowFeature(1);
        this.f3798a.setOwnerActivity(this);
        this.f3798a.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
        this.f3798a.setCancelable(true);
        this.f3798a.show();
        new Thread(new b()).start();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_viewflow_album);
        this.f3799b = AppMiniland.f().i();
        this.f3801d = (ViewPager) findViewById(R.id.album_viewpager);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.album_cabecera);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_PHOTO_ALBUM).toUpperCase());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.album_buttons_container);
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_delete_button)).setOnClickListener(new a());
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_edit_button)).setVisibility(8);
        this.f3802e = getIntent().getIntExtra("KEY_INTENT_IMAGE_POSITION", -1);
    }

    public void onResume() {
        super.onResume();
        e();
    }
}
