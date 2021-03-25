package com.wnafee.vector.compat;

import android.os.Build;

public class ResourcesCompat {
    public static final boolean LOLLIPOP = (Build.VERSION.SDK_INT >= 21);

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return com.wnafee.vector.compat.AnimatedVectorDrawable.getDrawable(r2, r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001d */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable getDrawable(android.content.Context r2, int r3) {
        /*
            boolean r0 = LOLLIPOP     // Catch:{ NotFoundException -> 0x0017 }
            if (r0 == 0) goto L_0x000e
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ NotFoundException -> 0x0017 }
            r1 = 0
            android.graphics.drawable.Drawable r2 = r0.getDrawable(r3, r1)     // Catch:{ NotFoundException -> 0x0017 }
            goto L_0x0021
        L_0x000e:
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ NotFoundException -> 0x0017 }
            android.graphics.drawable.Drawable r2 = r0.getDrawable(r3)     // Catch:{ NotFoundException -> 0x0017 }
            goto L_0x0021
        L_0x0017:
            r0 = move-exception
            com.wnafee.vector.compat.VectorDrawable r2 = com.wnafee.vector.compat.VectorDrawable.getDrawable(r2, r3)     // Catch:{ IllegalArgumentException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            com.wnafee.vector.compat.AnimatedVectorDrawable r2 = com.wnafee.vector.compat.AnimatedVectorDrawable.getDrawable(r2, r3)     // Catch:{ IllegalArgumentException -> 0x0022 }
        L_0x0021:
            return r2
        L_0x0022:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.ResourcesCompat.getDrawable(android.content.Context, int):android.graphics.drawable.Drawable");
    }
}
