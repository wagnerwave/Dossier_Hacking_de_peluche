package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {
    public final Context mContext;
    public TypedValue mTypedValue;
    public final TypedArray mWrapped;

    public TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean getBoolean(int i, boolean z) {
        return this.mWrapped.getBoolean(i, z);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return this.mWrapped.getChangingConfigurations();
    }

    public int getColor(int i, int i2) {
        return this.mWrapped.getColor(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r2.mContext, (r0 = r2.mWrapped.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList getColorStateList(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.mWrapped
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.mWrapped
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.mContext
            android.content.res.ColorStateList r0 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r1, r0)
            if (r0 == 0) goto L_0x001a
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.mWrapped
            android.content.res.ColorStateList r3 = r0.getColorStateList(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.TintTypedArray.getColorStateList(int):android.content.res.ColorStateList");
    }

    public float getDimension(int i, float f) {
        return this.mWrapped.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.mWrapped.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.mWrapped.getDimensionPixelSize(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.mWrapped.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable getDrawable(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.mWrapped
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x0018
            android.content.res.TypedArray r0 = r2.mWrapped
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x0018
            android.content.Context r3 = r2.mContext
            android.graphics.drawable.Drawable r3 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r3, r0)
            return r3
        L_0x0018:
            android.content.res.TypedArray r0 = r2.mWrapped
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.TintTypedArray.getDrawable(int):android.graphics.drawable.Drawable");
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.mWrapped.hasValue(i) || (resourceId = this.mWrapped.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
    }

    public float getFloat(int i, float f) {
        return this.mWrapped.getFloat(i, f);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i, int i2, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i2, fontCallback);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.mWrapped.getFraction(i, i2, i3, f);
    }

    public int getIndex(int i) {
        return this.mWrapped.getIndex(i);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i, int i2) {
        return this.mWrapped.getInt(i, i2);
    }

    public int getInteger(int i, int i2) {
        return this.mWrapped.getInteger(i, i2);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.mWrapped.getLayoutDimension(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.mWrapped.getLayoutDimension(i, str);
    }

    public String getNonResourceString(int i) {
        return this.mWrapped.getNonResourceString(i);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i, int i2) {
        return this.mWrapped.getResourceId(i, i2);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i) {
        return this.mWrapped.getString(i);
    }

    public CharSequence getText(int i) {
        return this.mWrapped.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        return this.mWrapped.getTextArray(i);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.mWrapped.getType(i);
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        this.mWrapped.getValue(i, this.mTypedValue);
        return this.mTypedValue.type;
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.mWrapped.getValue(i, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i) {
        return this.mWrapped.hasValue(i);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i) {
        return this.mWrapped.peekValue(i);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }
}
