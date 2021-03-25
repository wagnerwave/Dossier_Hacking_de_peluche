package com.cuatroochenta.miniland.utils;

import a.i.a.c0;
import a.i.a.t;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class LoadeablePicassoImageView extends FrameLayout implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f4085a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f4086b;

    public LoadeablePicassoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4086b = new ProgressBar(context, attributeSet);
        this.f4085a = new ImageView(context, attributeSet);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f4086b.setLayoutParams(layoutParams);
        addView(this.f4086b);
        addView(this.f4085a);
    }

    public void a(Drawable drawable) {
        this.f4086b.setVisibility(8);
        this.f4085a.setVisibility(8);
    }

    public void b(Drawable drawable) {
        this.f4086b.setVisibility(0);
        this.f4085a.setVisibility(8);
    }

    public void c(Bitmap bitmap, t.d dVar) {
        this.f4085a.setImageBitmap(bitmap);
        this.f4085a.setVisibility(0);
        this.f4086b.setVisibility(8);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f4085a.setImageBitmap(bitmap);
        this.f4085a.setVisibility(0);
        this.f4086b.setVisibility(8);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f4085a.setImageDrawable(drawable);
        this.f4085a.setVisibility(0);
        this.f4086b.setVisibility(8);
    }

    public void setImageURI(Uri uri) {
        this.f4085a.setImageURI(uri);
        this.f4085a.setVisibility(0);
        this.f4086b.setVisibility(8);
    }
}
