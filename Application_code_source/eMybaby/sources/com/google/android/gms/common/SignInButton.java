package com.google.android.gms.common;

import a.d.a.a.d.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;

public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public int f4198a;

    /* renamed from: b  reason: collision with root package name */
    public int f4199b;

    /* renamed from: c  reason: collision with root package name */
    public View f4200c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f4201d = null;

    /* JADX INFO: finally extract failed */
    public SignInButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.SignInButton, 0, 0);
        try {
            this.f4198a = obtainStyledAttributes.getInt(d.SignInButton_buttonSize, 0);
            this.f4199b = obtainStyledAttributes.getInt(d.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            a(this.f4198a, this.f4199b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10) {
        /*
            r8 = this;
            r8.f4198a = r9
            r8.f4199b = r10
            android.content.Context r9 = r8.getContext()
            android.view.View r10 = r8.f4200c
            if (r10 == 0) goto L_0x000f
            r8.removeView(r10)
        L_0x000f:
            int r10 = r8.f4198a     // Catch:{ a -> 0x001b }
            int r0 = r8.f4199b     // Catch:{ a -> 0x001b }
            android.view.View r10 = a.d.a.a.e.m.q.c(r9, r10, r0)     // Catch:{ a -> 0x001b }
            r8.f4200c = r10     // Catch:{ a -> 0x001b }
            goto L_0x00eb
        L_0x001b:
            java.lang.String r10 = "SignInButton"
            java.lang.String r0 = "Sign in button not found, using placeholder instead"
            android.util.Log.w(r10, r0)
            int r10 = r8.f4198a
            int r0 = r8.f4199b
            a.d.a.a.e.m.r r1 = new a.d.a.a.e.m.r
            r1.<init>(r9)
            android.content.res.Resources r9 = r9.getResources()
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT_BOLD
            r1.setTypeface(r2)
            r2 = 1096810496(0x41600000, float:14.0)
            r1.setTextSize(r2)
            android.util.DisplayMetrics r2 = r9.getDisplayMetrics()
            float r2 = r2.density
            r3 = 1111490560(0x42400000, float:48.0)
            float r2 = r2 * r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            int r2 = (int) r2
            r1.setMinHeight(r2)
            r1.setMinWidth(r2)
            int r2 = a.d.a.a.d.b.common_google_signin_btn_icon_dark
            int r3 = a.d.a.a.d.b.common_google_signin_btn_icon_light
            int r2 = a.d.a.a.e.m.r.a(r0, r2, r3, r3)
            int r3 = a.d.a.a.d.b.common_google_signin_btn_text_dark
            int r4 = a.d.a.a.d.b.common_google_signin_btn_text_light
            int r3 = a.d.a.a.e.m.r.a(r0, r3, r4, r4)
            java.lang.String r4 = "Unknown button size: "
            r5 = 32
            r6 = 2
            r7 = 1
            if (r10 == 0) goto L_0x007f
            if (r10 == r7) goto L_0x007f
            if (r10 != r6) goto L_0x006a
            goto L_0x0080
        L_0x006a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            r0.append(r4)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.<init>(r10)
            throw r9
        L_0x007f:
            r2 = r3
        L_0x0080:
            android.graphics.drawable.Drawable r2 = r9.getDrawable(r2)
            android.graphics.drawable.Drawable r2 = androidx.core.graphics.drawable.DrawableCompat.wrap(r2)
            int r3 = a.d.a.a.d.a.common_google_signin_btn_tint
            android.content.res.ColorStateList r3 = r9.getColorStateList(r3)
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r2, r3)
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_ATOP
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(r2, r3)
            r1.setBackgroundDrawable(r2)
            int r2 = a.d.a.a.d.a.common_google_signin_btn_text_dark
            int r3 = a.d.a.a.d.a.common_google_signin_btn_text_light
            int r0 = a.d.a.a.e.m.r.a(r0, r2, r3, r3)
            android.content.res.ColorStateList r0 = r9.getColorStateList(r0)
            a.c.a.f.b.k(r0)
            r1.setTextColor(r0)
            r0 = 0
            if (r10 == 0) goto L_0x00ce
            if (r10 == r7) goto L_0x00cb
            if (r10 != r6) goto L_0x00b6
            r1.setText(r0)
            goto L_0x00d7
        L_0x00b6:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            r0.append(r4)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.<init>(r10)
            throw r9
        L_0x00cb:
            int r10 = a.d.a.a.d.c.common_signin_button_text_long
            goto L_0x00d0
        L_0x00ce:
            int r10 = a.d.a.a.d.c.common_signin_button_text
        L_0x00d0:
            java.lang.String r9 = r9.getString(r10)
            r1.setText(r9)
        L_0x00d7:
            r1.setTransformationMethod(r0)
            android.content.Context r9 = r1.getContext()
            boolean r9 = a.c.a.f.b.V(r9)
            if (r9 == 0) goto L_0x00e9
            r9 = 19
            r1.setGravity(r9)
        L_0x00e9:
            r8.f4200c = r1
        L_0x00eb:
            android.view.View r9 = r8.f4200c
            r8.addView(r9)
            android.view.View r9 = r8.f4200c
            boolean r10 = r8.isEnabled()
            r9.setEnabled(r10)
            android.view.View r9 = r8.f4200c
            r9.setOnClickListener(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.SignInButton.a(int, int):void");
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f4201d;
        if (onClickListener != null && view == this.f4200c) {
            onClickListener.onClick(this);
        }
    }

    public final void setColorScheme(int i) {
        a(this.f4198a, i);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f4200c.setEnabled(z);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f4201d = onClickListener;
        View view = this.f4200c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        a(this.f4198a, this.f4199b);
    }

    public final void setSize(int i) {
        a(i, this.f4199b);
    }
}
