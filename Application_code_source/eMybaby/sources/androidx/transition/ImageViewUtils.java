package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

public class ImageViewUtils {
    public static Field sDrawMatrixField = null;
    public static boolean sDrawMatrixFieldFetched = false;
    public static boolean sTryHiddenAnimateTransform = true;

    public static void animateTransform(@NonNull ImageView imageView, @Nullable Matrix matrix) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
            } else {
                return;
            }
        } else if (i >= 21) {
            hiddenAnimateTransform(imageView, matrix);
            return;
        } else {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                Matrix matrix2 = null;
                fetchDrawMatrixField();
                Field field = sDrawMatrixField;
                if (field != null) {
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                matrix2 = new Matrix();
                                sDrawMatrixField.set(imageView, matrix2);
                            } catch (IllegalAccessException unused) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException unused2) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
            } else {
                return;
            }
        }
        imageView.invalidate();
    }

    public static void fetchDrawMatrixField() {
        if (!sDrawMatrixFieldFetched) {
            try {
                Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                sDrawMatrixField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sDrawMatrixFieldFetched = true;
        }
    }

    @RequiresApi(21)
    @SuppressLint({"NewApi"})
    public static void hiddenAnimateTransform(@NonNull ImageView imageView, @Nullable Matrix matrix) {
        if (sTryHiddenAnimateTransform) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenAnimateTransform = false;
            }
        }
    }
}
