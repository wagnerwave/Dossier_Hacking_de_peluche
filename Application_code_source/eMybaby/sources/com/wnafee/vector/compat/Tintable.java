package com.wnafee.vector.compat;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface Tintable {
    void setTintList(ColorStateList colorStateList);

    void setTintMode(PorterDuff.Mode mode);
}
