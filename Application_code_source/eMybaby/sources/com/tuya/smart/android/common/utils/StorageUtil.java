package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public class StorageUtil {
    public static final String CACHE_DIR_ROOT = "/Tuya";
    public static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";

    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File externalCacheDir = (!z || !"mounted".equals(str) || !hasExternalStoragePermission(context)) ? null : getExternalCacheDir(context);
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        StringBuilder n = a.n("/data/data/");
        n.append(context.getPackageName());
        n.append("/cache/");
        return new File(n.toString());
    }

    public static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        noMediaForCacheDir(file);
        return file;
    }

    public static File getOwnCacheDirectory(Context context, String str) {
        File file = (!"mounted".equals(Environment.getExternalStorageState()) || !hasExternalStoragePermission(context)) ? null : new File(Environment.getExternalStorageDirectory(), str);
        if (file == null || (!file.exists() && !file.mkdirs())) {
            file = context.getCacheDir();
        }
        noMediaForCacheDir(file);
        return file;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) == 0;
    }

    public static void noMediaForCacheDir(File file) {
        if (!file.exists() && file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
            }
        }
    }
}
