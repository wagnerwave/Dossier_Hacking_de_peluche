package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileWriter;

public class FileUtil {
    public static final int RANDOM_FILE_SIZE = 5;

    public static void delete(File file) {
        if (file.isFile()) {
            deleteFileSafely(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                deleteFileSafely(file);
                return;
            }
            for (File delete : listFiles) {
                delete(delete);
            }
            deleteFileSafely(file);
        }
    }

    public static boolean deleteFileSafely(File file) {
        if (file == null) {
            return false;
        }
        File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis());
        return file.renameTo(file2) && file2.delete();
    }

    public static boolean fileExists(String str) {
        return new File(str).exists();
    }

    public static boolean isExists(String str) {
        return !TextUtils.isEmpty(str) && fileExists(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x002f A[SYNTHETIC, Splitter:B:28:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0036 A[SYNTHETIC, Splitter:B:35:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFile(java.io.File r3, long r4, int r6) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0033, all -> 0x002c }
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch:{ IOException -> 0x0033, all -> 0x002c }
            r1.seek(r4)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            byte[] r3 = new byte[r6]     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            int r4 = r1.read(r3)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            r5 = -1
            if (r4 != r5) goto L_0x0018
            r1.close()     // Catch:{ IOException -> 0x0017 }
        L_0x0017:
            return r0
        L_0x0018:
            if (r4 >= r6) goto L_0x0023
            r5 = 0
            byte[] r3 = java.util.Arrays.copyOfRange(r3, r5, r4)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            r1.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            return r3
        L_0x0023:
            r1.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
            return r3
        L_0x0027:
            r3 = move-exception
            r0 = r1
            goto L_0x002d
        L_0x002a:
            goto L_0x0034
        L_0x002c:
            r3 = move-exception
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            throw r3
        L_0x0033:
            r1 = r0
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.common.utils.FileUtil.readFile(java.io.File, long, int):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0031 A[SYNTHETIC, Splitter:B:21:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0038 A[SYNTHETIC, Splitter:B:28:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFileByLine(java.io.File r3, int r4, int r5) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0035, all -> 0x002e }
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch:{ IOException -> 0x0035, all -> 0x002e }
            long r3 = (long) r4
            r1.seek(r3)     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r3.<init>()     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r4 = 0
        L_0x0012:
            if (r4 >= r5) goto L_0x0021
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            if (r2 != 0) goto L_0x001b
            goto L_0x0021
        L_0x001b:
            r3.append(r2)     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0021:
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r1.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            return r3
        L_0x0029:
            r3 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x002c:
            goto L_0x0036
        L_0x002e:
            r3 = move-exception
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            throw r3
        L_0x0035:
            r1 = r0
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.common.utils.FileUtil.readFileByLine(java.io.File, int, int):java.lang.String");
    }

    public static boolean renameFilePath(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        delete(file2);
        return file.renameTo(file2);
    }

    public static void writeData(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            deleteFileSafely(new File(str));
            if (Environment.getExternalStorageState().equals("mounted")) {
                try {
                    FileWriter fileWriter = new FileWriter(str, false);
                    fileWriter.write(str2);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void writeDataAppend(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String k = a.k(str2, "\n");
            if (Environment.getExternalStorageState().equals("mounted")) {
                try {
                    FileWriter fileWriter = new FileWriter(str, true);
                    fileWriter.write(k);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
