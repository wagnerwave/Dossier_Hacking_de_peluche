package androidx.media;

import android.media.VolumeProvider;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    public Callback mCallback;
    public final String mControlId;
    public final int mControlType;
    public int mCurrentVolume;
    public final int mMaxVolume;
    public VolumeProvider mVolumeProviderFwk;

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this(i, i2, i3, (String) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public VolumeProviderCompat(int i, int i2, int i3, @Nullable String str) {
        this.mControlType = i;
        this.mMaxVolume = i2;
        this.mCurrentVolume = i3;
        this.mControlId = str;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final String getVolumeControlId() {
        return this.mControlId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: androidx.media.VolumeProviderCompat$2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.media.VolumeProviderCompat$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.media.VolumeProviderCompat$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.media.VolumeProviderCompat$1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getVolumeProvider() {
        /*
            r8 = this;
            android.media.VolumeProvider r0 = r8.mVolumeProviderFwk
            if (r0 != 0) goto L_0x002c
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x001c
            androidx.media.VolumeProviderCompat$1 r0 = new androidx.media.VolumeProviderCompat$1
            int r4 = r8.mControlType
            int r5 = r8.mMaxVolume
            int r6 = r8.mCurrentVolume
            java.lang.String r7 = r8.mControlId
            r2 = r0
            r3 = r8
            r2.<init>(r4, r5, r6, r7)
        L_0x0019:
            r8.mVolumeProviderFwk = r0
            goto L_0x002c
        L_0x001c:
            r1 = 21
            if (r0 < r1) goto L_0x002c
            androidx.media.VolumeProviderCompat$2 r0 = new androidx.media.VolumeProviderCompat$2
            int r1 = r8.mControlType
            int r2 = r8.mMaxVolume
            int r3 = r8.mCurrentVolume
            r0.<init>(r1, r2, r3)
            goto L_0x0019
        L_0x002c:
            android.media.VolumeProvider r0 = r8.mVolumeProviderFwk
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media.VolumeProviderCompat.getVolumeProvider():java.lang.Object");
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        if (Build.VERSION.SDK_INT >= 21) {
            ((VolumeProvider) getVolumeProvider()).setCurrentVolume(i);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
