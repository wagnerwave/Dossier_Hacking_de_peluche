package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener implements View.OnTouchListener {
    @NonNull
    public final Dialog dialog;
    public final int leftInset;
    public final int prePieSlop;
    public final int topInset;

    public InsetDialogOnTouchListener(@NonNull Dialog dialog2, @NonNull Rect rect) {
        this.dialog = dialog2;
        this.leftInset = rect.left;
        this.topInset = rect.top;
        this.prePieSlop = ViewConfiguration.get(dialog2.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.leftInset;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.topInset;
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.prePieSlop;
            obtain.setLocation((float) ((-i) - 1), (float) ((-i) - 1));
        }
        view.performClick();
        return this.dialog.onTouchEvent(obtain);
    }
}