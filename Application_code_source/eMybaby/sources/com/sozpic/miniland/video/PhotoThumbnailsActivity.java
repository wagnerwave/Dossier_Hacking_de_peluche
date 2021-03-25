package com.sozpic.miniland.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozpic.miniland.R;
import java.util.ArrayList;
import java.util.List;

public class PhotoThumbnailsActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public GridView f4734a;

    /* renamed from: b  reason: collision with root package name */
    public String f4735b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f4736c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public AdapterView.OnItemClickListener f4737d = new a();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            System.gc();
            Intent intent = new Intent(PhotoThumbnailsActivity.this.getApplicationContext(), PhotoViewerActivity.class);
            intent.putExtra("filename", PhotoThumbnailsActivity.this.f4736c.get(i));
            PhotoThumbnailsActivity.this.startActivity(intent);
        }
    }

    public class b extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public Context f4739a;

        public b(Context context) {
            this.f4739a = context;
        }

        public int getCount() {
            return PhotoThumbnailsActivity.this.f4736c.size();
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            System.gc();
            ImageView imageView = new ImageView(this.f4739a.getApplicationContext());
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (view != null) {
                return (ImageView) view;
            }
            try {
                imageView.setImageBitmap(BitmapFactory.decodeFile(PhotoThumbnailsActivity.this.f4736c.get(i), options));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new AbsListView.LayoutParams(120, 90));
                return imageView;
            } catch (Exception unused) {
                return imageView;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4735b = getIntent().getExtras().getString("dev_uid");
        SQLiteDatabase b2 = new a.h.a.n0.a(this).b();
        Cursor query = b2.query("snapshot", new String[]{"_id", "dev_uid", "file_path", "time"}, a.a.a.a.a.m(a.a.a.a.a.n("dev_uid = '"), this.f4735b, "'"), (String[]) null, (String) null, (String) null, "_id");
        while (query.moveToNext()) {
            this.f4736c.add(query.getString(2));
        }
        query.close();
        b2.close();
        if (this.f4736c.size() == 0) {
            setContentView(R.layout.no_photo);
            ((TextView) findViewById(R.id.txtNoPhotos)).setText(a.c.a.d.a.h(R.string.TR_NO_PHOTOS));
            ((TextView) findViewById(R.id.txtNoPhotosDetail)).setText(a.c.a.d.a.h(R.string.TR_NO_PHOTOS_DETAIL));
            return;
        }
        setContentView(R.layout.photo_thumbnails);
        GridView gridView = (GridView) findViewById(R.id.PhoneImageGrid);
        this.f4734a = gridView;
        gridView.setAdapter(new b(getApplicationContext()));
        this.f4734a.setOnItemClickListener(this.f4737d);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(-1, new Intent());
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
