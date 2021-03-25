package e.b.a.a.a.w;

import a.a.a.a.a;
import e.b.a.a.a.k;
import e.b.a.a.a.p;
import e.b.a.a.a.q;
import e.b.a.a.a.u.i;
import e.b.a.a.a.u.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class b implements k {
    public static FilenameFilter FILENAME_FILTER = null;
    public static final String LOCK_FILENAME = ".lck";
    public static final String MESSAGE_BACKUP_FILE_EXTENSION = ".bup";
    public static final String MESSAGE_FILE_EXTENSION = ".msg";
    public File clientDir;
    public File dataDir;
    public i fileLock;

    public b() {
        this(System.getProperty("user.dir"));
    }

    public b(String str) {
        this.clientDir = null;
        this.fileLock = null;
        this.dataDir = new File(str);
    }

    private void checkIsOpen() {
        if (this.clientDir == null) {
            throw new q();
        }
    }

    public static FilenameFilter getFilenameFilter() {
        if (FILENAME_FILTER == null) {
            FILENAME_FILTER = new d(MESSAGE_FILE_EXTENSION);
        }
        return FILENAME_FILTER;
    }

    private File[] getFiles() {
        checkIsOpen();
        File[] listFiles = this.clientDir.listFiles(getFilenameFilter());
        if (listFiles != null) {
            return listFiles;
        }
        throw new q();
    }

    private boolean isSafeChar(char c2) {
        return Character.isJavaIdentifierPart(c2) || c2 == '-';
    }

    private void restoreBackups(File file) {
        File[] listFiles = file.listFiles(new c(MESSAGE_BACKUP_FILE_EXTENSION));
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                File file2 = new File(file, listFiles[i].getName().substring(0, listFiles[i].getName().length() - 4));
                if (!listFiles[i].renameTo(file2)) {
                    file2.delete();
                    listFiles[i].renameTo(file2);
                }
            }
            return;
        }
        throw new q();
    }

    public void clear() {
        checkIsOpen();
        File[] files = getFiles();
        for (File delete : files) {
            delete.delete();
        }
        this.clientDir.delete();
    }

    public void close() {
        synchronized (this) {
            if (this.fileLock != null) {
                this.fileLock.a();
            }
            if (getFiles().length == 0) {
                this.clientDir.delete();
            }
            this.clientDir = null;
        }
    }

    public boolean containsKey(String str) {
        checkIsOpen();
        File file = this.clientDir;
        return new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION).exists();
    }

    public p get(String str) {
        checkIsOpen();
        try {
            File file = this.clientDir;
            FileInputStream fileInputStream = new FileInputStream(new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION));
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            for (int i = 0; i < available; i += fileInputStream.read(bArr, i, available - i)) {
            }
            fileInputStream.close();
            return new l(str, bArr, 0, available, (byte[]) null, 0, 0);
        } catch (IOException e2) {
            throw new q(e2);
        }
    }

    public Enumeration keys() {
        checkIsOpen();
        File[] files = getFiles();
        Vector vector = new Vector(files.length);
        for (File name : files) {
            String name2 = name.getName();
            vector.addElement(name2.substring(0, name2.length() - 4));
        }
        return vector.elements();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:21|22|(2:24|(1:26))|27|28|29|30|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0076 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void open(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0017
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.isDirectory()
            if (r0 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            e.b.a.a.a.q r6 = new e.b.a.a.a.q
            r6.<init>()
            throw r6
        L_0x0017:
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x002e
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.mkdirs()
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            e.b.a.a.a.q r6 = new e.b.a.a.a.q
            r6.<init>()
            throw r6
        L_0x002e:
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.canWrite()
            if (r0 == 0) goto L_0x00a0
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x003d:
            int r3 = r6.length()
            if (r2 < r3) goto L_0x0090
            java.lang.String r6 = "-"
            r0.append(r6)
        L_0x0048:
            int r6 = r7.length()
            if (r1 < r6) goto L_0x0080
            monitor-enter(r5)
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x007d }
            if (r6 != 0) goto L_0x006b
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x007d }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x007d }
            java.io.File r0 = r5.dataDir     // Catch:{ all -> 0x007d }
            r7.<init>(r0, r6)     // Catch:{ all -> 0x007d }
            r5.clientDir = r7     // Catch:{ all -> 0x007d }
            boolean r6 = r7.exists()     // Catch:{ all -> 0x007d }
            if (r6 != 0) goto L_0x006b
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x007d }
            r6.mkdir()     // Catch:{ all -> 0x007d }
        L_0x006b:
            e.b.a.a.a.u.i r6 = new e.b.a.a.a.u.i     // Catch:{ Exception -> 0x0076 }
            java.io.File r7 = r5.clientDir     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = ".lck"
            r6.<init>(r7, r0)     // Catch:{ Exception -> 0x0076 }
            r5.fileLock = r6     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x007d }
            r5.restoreBackups(r6)     // Catch:{ all -> 0x007d }
            monitor-exit(r5)     // Catch:{ all -> 0x007d }
            return
        L_0x007d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007d }
            throw r6
        L_0x0080:
            char r6 = r7.charAt(r1)
            boolean r2 = r5.isSafeChar(r6)
            if (r2 == 0) goto L_0x008d
            r0.append(r6)
        L_0x008d:
            int r1 = r1 + 1
            goto L_0x0048
        L_0x0090:
            char r3 = r6.charAt(r2)
            boolean r4 = r5.isSafeChar(r3)
            if (r4 == 0) goto L_0x009d
            r0.append(r3)
        L_0x009d:
            int r2 = r2 + 1
            goto L_0x003d
        L_0x00a0:
            e.b.a.a.a.q r6 = new e.b.a.a.a.q
            r6.<init>()
            goto L_0x00a7
        L_0x00a6:
            throw r6
        L_0x00a7:
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.w.b.open(java.lang.String, java.lang.String):void");
    }

    public void put(String str, p pVar) {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION);
        File file3 = new File(this.clientDir, a.m(new StringBuilder(String.valueOf(str)), MESSAGE_FILE_EXTENSION, MESSAGE_BACKUP_FILE_EXTENSION));
        if (file2.exists() && !file2.renameTo(file3)) {
            file3.delete();
            file2.renameTo(file3);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(pVar.e(), pVar.b(), pVar.f());
            if (pVar.c() != null) {
                fileOutputStream.write(pVar.c(), pVar.d(), pVar.a());
            }
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            if (file3.exists()) {
                file3.delete();
            }
            if (file3.exists() && !file3.renameTo(file2)) {
                file2.delete();
                file3.renameTo(file2);
            }
        } catch (IOException e2) {
            throw new q(e2);
        } catch (Throwable th) {
            if (file3.exists() && !file3.renameTo(file2)) {
                file2.delete();
                file3.renameTo(file2);
            }
            throw th;
        }
    }

    public void remove(String str) {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, String.valueOf(str) + MESSAGE_FILE_EXTENSION);
        if (file2.exists()) {
            file2.delete();
        }
    }
}
