package androidx.core.view;

import a.a.a.a.a;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
    public static final String TAG = "LayoutInflaterCompatHC";
    public static boolean sCheckedField;
    public static Field sLayoutInflaterFactory2Field;

    public static class Factory2Wrapper implements LayoutInflater.Factory2 {
        public final LayoutInflaterFactory mDelegateFactory;

        public Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView((View) null, str, context, attributeSet);
        }

        @NonNull
        public String toString() {
            return Factory2Wrapper.class.getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    public static void forceSetFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!sCheckedField) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                StringBuilder n = a.n("forceSetFactory2 Could not find field 'mFactory2' on class ");
                n.append(LayoutInflater.class.getName());
                n.append("; inflation may have unexpected results.");
                Log.e(TAG, n.toString(), e2);
            }
            sCheckedField = true;
        }
        Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2Wrapper) {
            return ((Factory2Wrapper) factory).mDelegateFactory;
        }
        return null;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflaterFactory layoutInflaterFactory) {
        Factory2Wrapper factory2Wrapper = null;
        if (Build.VERSION.SDK_INT >= 21) {
            if (layoutInflaterFactory != null) {
                factory2Wrapper = new Factory2Wrapper(layoutInflaterFactory);
            }
            layoutInflater.setFactory2(factory2Wrapper);
            return;
        }
        if (layoutInflaterFactory != null) {
            factory2Wrapper = new Factory2Wrapper(layoutInflaterFactory);
        }
        layoutInflater.setFactory2(factory2Wrapper);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            forceSetFactory2(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            forceSetFactory2(layoutInflater, factory2Wrapper);
        }
    }

    public static void setFactory2(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                forceSetFactory2(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                forceSetFactory2(layoutInflater, factory2);
            }
        }
    }
}
