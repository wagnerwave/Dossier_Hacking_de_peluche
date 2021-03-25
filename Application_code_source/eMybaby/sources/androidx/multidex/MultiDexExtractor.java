package androidx.multidex;

import a.a.a.a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class MultiDexExtractor implements Closeable {
    public static final int BUFFER_SIZE = 16384;
    public static final String DEX_PREFIX = "classes";
    public static final String DEX_SUFFIX = ".dex";
    public static final String EXTRACTED_NAME_EXT = ".classes";
    public static final String EXTRACTED_SUFFIX = ".zip";
    public static final String KEY_CRC = "crc";
    public static final String KEY_DEX_CRC = "dex.crc.";
    public static final String KEY_DEX_NUMBER = "dex.number";
    public static final String KEY_DEX_TIME = "dex.time.";
    public static final String KEY_TIME_STAMP = "timestamp";
    public static final String LOCK_FILENAME = "MultiDex.lock";
    public static final int MAX_EXTRACT_ATTEMPTS = 3;
    public static final long NO_VALUE = -1;
    public static final String PREFS_FILE = "multidex.version";
    public static final String TAG = "MultiDex";
    public final FileLock cacheLock;
    public final File dexDir;
    public final FileChannel lockChannel;
    public final RandomAccessFile lockRaf;
    public final File sourceApk;
    public final long sourceCrc;

    public static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    public MultiDexExtractor(File file, File file2) {
        StringBuilder n = a.n("MultiDexExtractor(");
        n.append(file.getPath());
        n.append(", ");
        n.append(file2.getPath());
        n.append(")");
        Log.i("MultiDex", n.toString());
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            this.lockChannel = randomAccessFile.getChannel();
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.cacheLock = this.lockChannel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e4) {
                e = e4;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            closeQuietly(this.lockRaf);
            throw e5;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            StringBuilder n = a.n("Failed to list secondary dex dir content (");
            n.append(this.dexDir.getPath());
            n.append(").");
            Log.w("MultiDex", n.toString());
            return;
        }
        for (File file : listFiles) {
            StringBuilder n2 = a.n("Trying to delete old file ");
            n2.append(file.getPath());
            n2.append(" of size ");
            n2.append(file.length());
            Log.i("MultiDex", n2.toString());
            if (!file.delete()) {
                StringBuilder n3 = a.n("Failed to delete old file ");
                n3.append(file.getPath());
                Log.w("MultiDex", n3.toString());
            } else {
                StringBuilder n4 = a.n("Deleted old file ");
                n4.append(file.getPath());
                Log.i("MultiDex", n4.toString());
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }

    public static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(a.k("tmp-", str), EXTRACTED_SUFFIX, file.getParentFile());
        StringBuilder n = a.n("Extracting ");
        n.append(createTempFile.getPath());
        Log.i("MultiDex", n.toString());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    public static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    public static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    public static long getZipCrc(File file) {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    public static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + "timestamp", -1) == getTimeStamp(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(KEY_CRC);
            return multiDexPreferences.getLong(sb.toString(), -1) != j;
        }
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i = multiDexPreferences.getInt(str2 + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str3 + i2 + EXTRACTED_SUFFIX);
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j = multiDexPreferences.getLong(str2 + KEY_DEX_CRC + i2, -1);
                long j2 = multiDexPreferences.getLong(str2 + KEY_DEX_TIME + i2, -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        multiDexPreferences = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
            }
            StringBuilder n = a.n("Missing extracted secondary dex file '");
            n.append(extractedDex.getPath());
            n.append("'");
            throw new IOException(n.toString());
        }
        return arrayList;
    }

    private List<ExtractedDex> performExtractions() {
        ExtractedDex extractedDex;
        boolean z;
        String str = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        int i = 2;
        String str2 = "classes2.dex";
        while (true) {
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry != null) {
                    extractedDex = new ExtractedDex(this.dexDir, str + i + EXTRACTED_SUFFIX);
                    arrayList.add(extractedDex);
                    Log.i("MultiDex", "Extraction is needed for file " + extractedDex);
                    int i2 = 0;
                    z = false;
                    while (i2 < 3 && !z) {
                        i2++;
                        extract(zipFile, entry, extractedDex, str);
                        extractedDex.crc = getZipCrc(extractedDex);
                        z = true;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Extraction ");
                        sb.append(z ? "succeeded" : "failed");
                        sb.append(" '");
                        sb.append(extractedDex.getAbsolutePath());
                        sb.append("': length ");
                        sb.append(extractedDex.length());
                        sb.append(" - crc: ");
                        sb.append(extractedDex.crc);
                        Log.i("MultiDex", sb.toString());
                        if (!z) {
                            extractedDex.delete();
                            if (extractedDex.exists()) {
                                Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                            }
                        }
                    }
                    if (z) {
                        i++;
                        str2 = DEX_PREFIX + i + DEX_SUFFIX;
                    } else {
                        throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i + ")");
                    }
                } else {
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        Log.w("MultiDex", "Failed to close resource", e2);
                    }
                    return arrayList;
                }
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e3);
                z = false;
            } catch (Throwable th) {
                try {
                    zipFile.close();
                } catch (IOException e4) {
                    Log.w("MultiDex", "Failed to close resource", e4);
                }
                throw th;
            }
        }
    }

    public static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(a.m(new StringBuilder(), str, KEY_CRC), j2);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + KEY_DEX_CRC + i, next.crc);
            edit.putLong(str + KEY_DEX_TIME + i, next.lastModified());
            i++;
        }
        edit.commit();
    }

    public void close() {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    public List<? extends File> load(Context context, String str, boolean z) {
        List<ExtractedDex> list;
        StringBuilder n = a.n("MultiDexExtractor.load(");
        n.append(this.sourceApk.getPath());
        n.append(", ");
        n.append(z);
        n.append(", ");
        n.append(str);
        n.append(")");
        Log.i("MultiDex", n.toString());
        if (this.cacheLock.isValid()) {
            if (z || isModified(context, this.sourceApk, this.sourceCrc, str)) {
                Log.i("MultiDex", z ? "Forced extraction must be performed." : "Detected that extraction must be performed.");
            } else {
                try {
                    list = loadExistingExtractions(context, str);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                }
                StringBuilder n2 = a.n("load found ");
                n2.append(list.size());
                n2.append(" secondary dex files");
                Log.i("MultiDex", n2.toString());
                return list;
            }
            List<ExtractedDex> performExtractions = performExtractions();
            putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
            list = performExtractions;
            StringBuilder n22 = a.n("load found ");
            n22.append(list.size());
            n22.append(" secondary dex files");
            Log.i("MultiDex", n22.toString());
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
