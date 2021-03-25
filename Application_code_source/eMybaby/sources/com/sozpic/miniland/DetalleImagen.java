package com.sozpic.miniland;

import a.c.a.e.f;
import a.g.a.b.b;
import a.g.a.b.d;
import a.g.a.b.l.h;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Usuario;
import com.sozpic.miniland.utiles.ZoomableImageView;
import com.tuya.smart.common.o0O00000;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DetalleImagen extends FragmentActivity implements TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public String f4377a;

    /* renamed from: b  reason: collision with root package name */
    public a.g.a.b.b f4378b;

    /* renamed from: c  reason: collision with root package name */
    public d f4379c = d.e();

    /* renamed from: d  reason: collision with root package name */
    public a.g.a.b.l.c f4380d = new b((a) null);

    /* renamed from: e  reason: collision with root package name */
    public ProgressDialog f4381e;
    public ImageView f;
    public String g = "";
    public TopMenuActivity h;

    public class a implements View.OnClickListener {

        /* renamed from: com.sozpic.miniland.DetalleImagen$a$a  reason: collision with other inner class name */
        public class C0095a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4383a;

            public C0095a(a aVar, Dialog dialog) {
                this.f4383a = dialog;
            }

            public void onClick(View view) {
                this.f4383a.dismiss();
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4384a;

            public b(Dialog dialog) {
                this.f4384a = dialog;
            }

            public void onClick(View view) {
                DetalleImagen.this.f4381e = new ProgressDialog(DetalleImagen.this);
                DetalleImagen.this.f4381e.setCancelable(false);
                DetalleImagen.this.f4381e.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                DetalleImagen.this.f4381e.setIndeterminate(true);
                DetalleImagen.this.f4381e.show();
                try {
                    new c((a) null).execute(new String[]{DetalleImagen.this.g});
                } catch (Exception unused) {
                    DetalleImagen.this.f4381e.dismiss();
                }
                this.f4384a.dismiss();
            }
        }

        public a() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(DetalleImagen.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_IMAGE_CONFIRM_DIALOG, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new C0095a(this, dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new b(dialog));
            dialog.show();
        }
    }

    public static class b extends h {

        /* renamed from: a  reason: collision with root package name */
        public static final List<String> f4386a = Collections.synchronizedList(new LinkedList());

        public b(a aVar) {
        }

        public void a(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                ImageView imageView = (ImageView) view;
                if (!f4386a.contains(str)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration((long) 500);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    imageView.startAnimation(alphaAnimation);
                    f4386a.add(str);
                }
            }
        }
    }

    public class c extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public ProgressDialog f4387a;

        public c(a aVar) {
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
            this.f4387a.dismiss();
            DetalleImagen detalleImagen = DetalleImagen.this;
            if (detalleImagen != null) {
                Intent intent = new Intent();
                intent.putExtra("eliminar", o0O00000.O000000o);
                detalleImagen.setResult(100, intent);
                detalleImagen.finish();
                return;
            }
            throw null;
        }

        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(DetalleImagen.this);
            this.f4387a = progressDialog;
            progressDialog.requestWindowFeature(1);
            this.f4387a.setOwnerActivity(DetalleImagen.this);
            this.f4387a.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f4387a.setCancelable(true);
            this.f4387a.show();
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void clickOnVolver(View view) {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_fullscreen_view);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.h = topMenuActivity;
        topMenuActivity.setListener(this);
        this.h.setSeccion(a.c.a.d.a.h(R.string.TR_PHOTO_ALBUM).toUpperCase());
        Bundle extras = getIntent().getExtras();
        try {
            this.f4377a = extras.getString("imagen");
            this.g = extras.getString("idphoto");
        } catch (Exception unused) {
        }
        b.C0080b bVar = new b.C0080b();
        bVar.f3365c = R.drawable.imagenes_default;
        bVar.f3366d = R.drawable.imagenes_default;
        bVar.f = true;
        bVar.i = a.g.a.b.l.d.NONE;
        bVar.g = true;
        bVar.j = Bitmap.Config.RGB_565;
        a.g.a.b.b b2 = bVar.b();
        this.f4378b = b2;
        this.f4379c.b(this.f4377a, (ZoomableImageView) findViewById(R.id.imagen), b2, this.f4380d);
        ImageView imageView = (ImageView) findViewById(R.id.btnDelete);
        this.f = imageView;
        imageView.setOnClickListener(new a());
    }

    public void onResume() {
        super.onResume();
        f.c().e("ALBUM_FOTOS_DETALLE");
    }
}
