package com.sozpic.miniland.video;

import a.c.a.d.a;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.sozpic.miniland.R;
import com.sozpic.miniland.utiles.ZoomableImageView;
import com.sozpic.miniland.video.TopMenuActivityVideo;

public class PhotoViewerActivity extends Activity implements TopMenuActivityVideo.c {

    /* renamed from: a  reason: collision with root package name */
    public String f4741a;

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivityVideo f4742b;

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_detalle_imagen);
        TopMenuActivityVideo topMenuActivityVideo = (TopMenuActivityVideo) findViewById(R.id.cabeceras);
        this.f4742b = topMenuActivityVideo;
        topMenuActivityVideo.setListener(this);
        this.f4742b.setSeccion(a.h(R.string.TR_MENU_CAMERA));
        System.gc();
        this.f4741a = getIntent().getExtras().getString("filename");
        ((ZoomableImageView) findViewById(R.id.iv)).setImageBitmap(BitmapFactory.decodeFile(this.f4741a));
    }
}
