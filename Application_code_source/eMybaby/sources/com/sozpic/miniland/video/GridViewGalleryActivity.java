package com.sozpic.miniland.video;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.video.TopMenuActivityVideo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GridViewGalleryActivity extends Activity implements TopMenuActivityVideo.c {

    /* renamed from: a  reason: collision with root package name */
    public String f4654a;

    /* renamed from: b  reason: collision with root package name */
    public GridView f4655b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f4656c = new ArrayList(20);

    /* renamed from: d  reason: collision with root package name */
    public c f4657d;

    /* renamed from: e  reason: collision with root package name */
    public TopMenuActivityVideo f4658e;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent(GridViewGalleryActivity.this, PhotoViewerActivity.class);
            intent.putExtra("filename", GridViewGalleryActivity.this.f4656c.get(i));
            GridViewGalleryActivity.this.startActivity(intent);
        }
    }

    public class b implements AdapterView.OnItemLongClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4661a;

            public a(b bVar, Dialog dialog) {
                this.f4661a = dialog;
            }

            public void onClick(View view) {
                this.f4661a.dismiss();
            }
        }

        /* renamed from: com.sozpic.miniland.video.GridViewGalleryActivity$b$b  reason: collision with other inner class name */
        public class C0103b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f4662a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Dialog f4663b;

            /* renamed from: com.sozpic.miniland.video.GridViewGalleryActivity$b$b$a */
            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    C0103b bVar = C0103b.this;
                    c cVar = GridViewGalleryActivity.this.f4657d;
                    int i = bVar.f4662a;
                    if (cVar != null) {
                        new File(GridViewGalleryActivity.this.f4656c.get(i)).delete();
                        GridViewGalleryActivity.this.f4656c.remove(i);
                        cVar.notifyDataSetChanged();
                        return;
                    }
                    throw null;
                }
            }

            public C0103b(int i, Dialog dialog) {
                this.f4662a = i;
                this.f4663b = dialog;
            }

            public void onClick(View view) {
                GridViewGalleryActivity.this.runOnUiThread(new a());
                this.f4663b.dismiss();
            }
        }

        public b() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            Dialog dialog = new Dialog(GridViewGalleryActivity.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) dialog.findViewById(R.id.ccancel);
            button.setOnClickListener(new a(this, dialog));
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            Button button2 = (Button) a.a.a.a.a.A(R.string.TR_DIALOG_DELETE_SNAPSHOT_CONFIRM, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new C0103b(i, dialog));
            dialog.show();
            return true;
        }
    }

    public class c extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public Context f4666a;

        public c(Context context) {
            this.f4666a = context;
        }

        public int getCount() {
            return GridViewGalleryActivity.this.f4656c.size();
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) this.f4666a.getSystemService("layout_inflater")).inflate(R.layout.grid_campaign, viewGroup, false);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            if (BitmapFactory.decodeFile(GridViewGalleryActivity.this.f4656c.get(i)) == null) {
                int count = getCount() - 1;
                while (count >= 0 && BitmapFactory.decodeFile(GridViewGalleryActivity.this.f4656c.get(count)) == null) {
                    count--;
                }
            }
            imageView.setImageURI(Uri.parse(GridViewGalleryActivity.this.f4656c.get(i)));
            return view;
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        System.gc();
        this.f4654a = getIntent().getExtras().getString("images_path");
        setContentView(R.layout.gridviewgalleryactivity);
        String str = this.f4654a;
        synchronized (this) {
            this.f4656c.clear();
            String[] list = new File(str).list();
            if (list != null && list.length > 0) {
                Arrays.sort(list);
                for (String str2 : list) {
                    List<String> list2 = this.f4656c;
                    list2.add(str + "/" + str2);
                }
                Collections.reverse(this.f4656c);
            }
        }
        Iterator<String> it = this.f4656c.iterator();
        while (it.hasNext()) {
            if (BitmapFactory.decodeFile(it.next()) == null) {
                it.remove();
            }
        }
        this.f4657d = new c(this);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        this.f4655b = gridView;
        gridView.setAdapter(this.f4657d);
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabeceras);
        this.f4658e = topMenuActivityVideo;
        topMenuActivityVideo.setListener(this);
        this.f4658e.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_CAMERA));
        ((TextView) findViewById(R.id.header)).setText(a.c.a.d.a.h(R.string.TR_CAMERA_SNAPSHOTS));
        this.f4655b.setOnItemClickListener(new a());
        this.f4655b.setOnItemLongClickListener(new b());
    }
}
