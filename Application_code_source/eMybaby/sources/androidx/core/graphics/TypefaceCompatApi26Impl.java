package androidx.core.graphics;

import a.a.a.a.a;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    public static final String ABORT_CREATION_METHOD = "abortCreation";
    public static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    public static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    public static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    public static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    public static final String FREEZE_METHOD = "freeze";
    public static final int RESOLVE_BY_FONT_TABLE = -1;
    public static final String TAG = "TypefaceCompatApi26Impl";
    public final Method mAbortCreation;
    public final Method mAddFontFromAssetManager;
    public final Method mAddFontFromBuffer;
    public final Method mCreateFromFamiliesWithDefault;
    public final Class<?> mFontFamily;
    public final Constructor<?> mFontFamilyCtor;
    public final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> obtainFontFamily = obtainFontFamily();
            constructor = obtainFontFamilyCtor(obtainFontFamily);
            method4 = obtainAddFontFromAssetManagerMethod(obtainFontFamily);
            method3 = obtainAddFontFromBufferMethod(obtainFontFamily);
            method2 = obtainFreezeMethod(obtainFontFamily);
            method = obtainAbortCreationMethod(obtainFontFamily);
            Class<?> cls2 = obtainFontFamily;
            method5 = obtainCreateFromFamiliesWithDefaultMethod(obtainFontFamily);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            StringBuilder n = a.n("Unable to collect necessary methods for class ");
            n.append(e2.getClass().getName());
            Log.e(TAG, n.toString(), e2);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method4;
        this.mAddFontFromBuffer = method3;
        this.mFreeze = method2;
        this.mAbortCreation = method;
        this.mCreateFromFamiliesWithDefault = method5;
    }

    private void abortCreation(Object obj) {
        try {
            this.mAbortCreation.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3, @Nullable FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.mAddFontFromBuffer.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean freeze(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.mAddFontFromAssetManager != null;
    }

    @Nullable
    private Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    public Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.mFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (!freeze(newFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        Typeface createFromFamiliesWithDefault;
        ParcelFileDescriptor openFileDescriptor;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (!isFontFamilyPrivateAPIAvailable()) {
            FontsContractCompat.FontInfo findBestInfo = findBestInfo(fontInfoArr, i);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.getUri(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.getWeight()).setItalic(findBestInfo.isItalic()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map<Uri, ByteBuffer> prepareFontData = FontsContractCompat.prepareFontData(context, fontInfoArr, cancellationSignal);
            Object newFamily = newFamily();
            if (newFamily == null) {
                return null;
            }
            boolean z = false;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                ByteBuffer byteBuffer = prepareFontData.get(fontInfo.getUri());
                if (byteBuffer != null) {
                    if (!addFontFromBuffer(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic() ? 1 : 0)) {
                        abortCreation(newFamily);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                abortCreation(newFamily);
                return null;
            } else if (freeze(newFamily) && (createFromFamiliesWithDefault = createFromFamiliesWithDefault(newFamily)) != null) {
                return Typeface.create(createFromFamiliesWithDefault, i);
            } else {
                return null;
            }
        }
        throw th;
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            abortCreation(newFamily);
            return null;
        } else if (!freeze(newFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(newFamily);
        }
    }

    public Method obtainAbortCreationMethod(Class<?> cls) {
        return cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    public Method obtainAddFontFromBufferMethod(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> obtainFontFamily() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    public Method obtainFreezeMethod(Class<?> cls) {
        return cls.getMethod(FREEZE_METHOD, new Class[0]);
    }
}
