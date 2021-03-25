package androidx.multidex;

import a.a.a.a.a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

public final class MultiDex {
    public static final String CODE_CACHE_NAME = "code_cache";
    public static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
    public static final boolean IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
    public static final int MAX_SUPPORTED_SDK_VERSION = 20;
    public static final int MIN_SDK_VERSION = 4;
    public static final String NO_KEY_PREFIX = "";
    public static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    public static final String TAG = "MultiDex";
    public static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    public static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
    public static final Set<File> installedApk = new HashSet();

    public static final class V14 {
        public static final int EXTRACTED_SUFFIX_LENGTH = 4;
        public final ElementConstructor elementConstructor;

        public interface ElementConstructor {
            Object newInstance(File file, DexFile dexFile);
        }

        public static class ICSElementConstructor implements ElementConstructor {
            public final Constructor<?> elementConstructor;

            public ICSElementConstructor(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            public Object newInstance(File file, DexFile dexFile) {
                return this.elementConstructor.newInstance(new Object[]{file, new ZipFile(file), dexFile});
            }
        }

        public static class JBMR11ElementConstructor implements ElementConstructor {
            public final Constructor<?> elementConstructor;

            public JBMR11ElementConstructor(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(new Class[]{File.class, File.class, DexFile.class});
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            public Object newInstance(File file, DexFile dexFile) {
                return this.elementConstructor.newInstance(new Object[]{file, file, dexFile});
            }
        }

        public static class JBMR2ElementConstructor implements ElementConstructor {
            public final Constructor<?> elementConstructor;

            public JBMR2ElementConstructor(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            public Object newInstance(File file, DexFile dexFile) {
                return this.elementConstructor.newInstance(new Object[]{file, Boolean.FALSE, file, dexFile});
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V14() {
            /*
                r2 = this;
                r2.<init>()
                java.lang.String r0 = "dalvik.system.DexPathList$Element"
                java.lang.Class r0 = java.lang.Class.forName(r0)
                androidx.multidex.MultiDex$V14$ICSElementConstructor r1 = new androidx.multidex.MultiDex$V14$ICSElementConstructor     // Catch:{ NoSuchMethodException -> 0x000f }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x000f }
                goto L_0x001a
            L_0x000f:
                androidx.multidex.MultiDex$V14$JBMR11ElementConstructor r1 = new androidx.multidex.MultiDex$V14$JBMR11ElementConstructor     // Catch:{ NoSuchMethodException -> 0x0015 }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x0015 }
                goto L_0x001a
            L_0x0015:
                androidx.multidex.MultiDex$V14$JBMR2ElementConstructor r1 = new androidx.multidex.MultiDex$V14$JBMR2ElementConstructor
                r1.<init>(r0)
            L_0x001a:
                r2.elementConstructor = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDex.V14.<init>():void");
        }

        public static void install(ClassLoader classLoader, List<? extends File> list) {
            Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
            Object[] makeDexElements = new V14().makeDexElements(list);
            try {
                MultiDex.expandFieldArray(obj, "dexElements", makeDexElements);
            } catch (NoSuchFieldException e2) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e2);
                MultiDex.expandFieldArray(obj, "pathElements", makeDexElements);
            }
        }

        private Object[] makeDexElements(List<? extends File> list) {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                File file = (File) list.get(i);
                objArr[i] = this.elementConstructor.newInstance(file, DexFile.loadDex(file.getPath(), optimizedPathFor(file), 0));
            }
            return objArr;
        }

        public static String optimizedPathFor(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - EXTRACTED_SUFFIX_LENGTH) + MultiDexExtractor.DEX_SUFFIX).getPath();
        }
    }

    public static final class V19 {
        public static void install(ClassLoader classLoader, List<? extends File> list, File file) {
            IOException[] iOExceptionArr;
            Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field access$000 = MultiDex.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) access$000.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                access$000.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        public static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    public static final class V4 {
        public static void install(ClassLoader classLoader, List<? extends File> list) {
            int size = list.size();
            Field access$000 = MultiDex.findField(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) access$000.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + MultiDexExtractor.DEX_SUFFIX, 0);
            }
            access$000.set(classLoader, sb.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
        }
    }

    public static void clearOldDexDir(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder n = a.n("Clearing old secondary dex dir (");
            n.append(file.getPath());
            n.append(").");
            Log.i("MultiDex", n.toString());
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder n2 = a.n("Failed to list secondary dex dir content (");
                n2.append(file.getPath());
                n2.append(").");
                Log.w("MultiDex", n2.toString());
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder n3 = a.n("Trying to delete old file ");
                n3.append(file2.getPath());
                n3.append(" of size ");
                n3.append(file2.length());
                Log.i("MultiDex", n3.toString());
                if (!file2.delete()) {
                    StringBuilder n4 = a.n("Failed to delete old file ");
                    n4.append(file2.getPath());
                    Log.w("MultiDex", n4.toString());
                } else {
                    StringBuilder n5 = a.n("Deleted old file ");
                    n5.append(file2.getPath());
                    Log.i("MultiDex", n5.toString());
                }
            }
            if (!file.delete()) {
                StringBuilder n6 = a.n("Failed to delete secondary dex dir ");
                n6.append(file.getPath());
                Log.w("MultiDex", n6.toString());
                return;
            }
            StringBuilder n7 = a.n("Deleted old secondary dex dir ");
            n7.append(file.getPath());
            Log.i("MultiDex", n7.toString());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:41|42|43|44|45) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x009d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doInstallation(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            java.util.Set<java.io.File> r0 = installedApk
            monitor-enter(r0)
            java.util.Set<java.io.File> r1 = installedApk     // Catch:{ all -> 0x009e }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x000d:
            java.util.Set<java.io.File> r1 = installedApk     // Catch:{ all -> 0x009e }
            r1.add(r6)     // Catch:{ all -> 0x009e }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x009e }
            r2 = 20
            if (r1 <= r2) goto L_0x0055
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r3.<init>()     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "MultiDex is not guaranteed to work in SDK version "
            r3.append(r4)     // Catch:{ all -> 0x009e }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x009e }
            r3.append(r4)     // Catch:{ all -> 0x009e }
            java.lang.String r4 = ": SDK version higher than "
            r3.append(r4)     // Catch:{ all -> 0x009e }
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = " should be backed by "
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "runtime with built-in multidex capabilty but it's not the "
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "case here: java.vm.version=\""
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ all -> 0x009e }
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x009e }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x009e }
        L_0x0055:
            java.lang.ClassLoader r1 = getDexClassloader(r5)     // Catch:{ all -> 0x009e }
            if (r1 != 0) goto L_0x005d
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x005d:
            clearOldDexDir(r5)     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r2 = move-exception
            java.lang.String r3 = "MultiDex"
            java.lang.String r4 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
            android.util.Log.w(r3, r4, r2)     // Catch:{ all -> 0x009e }
        L_0x0069:
            java.io.File r7 = getDexDir(r5, r7, r8)     // Catch:{ all -> 0x009e }
            androidx.multidex.MultiDexExtractor r8 = new androidx.multidex.MultiDexExtractor     // Catch:{ all -> 0x009e }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x009e }
            r6 = 0
            r2 = 0
            java.util.List r2 = r8.load(r5, r9, r2)     // Catch:{ all -> 0x0099 }
            installSecondaryDexes(r1, r7, r2)     // Catch:{ IOException -> 0x007c }
            goto L_0x008e
        L_0x007c:
            r2 = move-exception
            if (r10 == 0) goto L_0x0098
            java.lang.String r10 = "MultiDex"
            java.lang.String r3 = "Failed to install extracted secondary dex files, retrying with forced extraction"
            android.util.Log.w(r10, r3, r2)     // Catch:{ all -> 0x0099 }
            r10 = 1
            java.util.List r5 = r8.load(r5, r9, r10)     // Catch:{ all -> 0x0099 }
            installSecondaryDexes(r1, r7, r5)     // Catch:{ all -> 0x0099 }
        L_0x008e:
            r8.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0093
        L_0x0092:
            r6 = move-exception
        L_0x0093:
            if (r6 != 0) goto L_0x0097
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x0097:
            throw r6     // Catch:{ all -> 0x009e }
        L_0x0098:
            throw r2     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r5 = move-exception
            r8.close()     // Catch:{ IOException -> 0x009d }
        L_0x009d:
            throw r5     // Catch:{ all -> 0x009e }
        L_0x009e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDex.doInstallation(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    public static void expandFieldArray(Object obj, String str, Object[] objArr) {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    public static Field findField(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder q = a.q("Field ", str, " not found in ");
        q.append(obj.getClass());
        throw new NoSuchFieldException(q.toString());
    }

    public static Method findMethod(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder q = a.q("Method ", str, " with parameters ");
        q.append(Arrays.asList(clsArr));
        q.append(" not found in ");
        q.append(obj.getClass());
        throw new NoSuchMethodException(q.toString());
    }

    public static ApplicationInfo getApplicationInfo(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e2) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    public static ClassLoader getDexClassloader(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                return classLoader;
            }
            Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e2) {
            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    public static File getDexDir(Context context, File file, String str) {
        File file2 = new File(file, CODE_CACHE_NAME);
        try {
            mkdirChecked(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), CODE_CACHE_NAME);
            mkdirChecked(file2);
        }
        File file3 = new File(file2, str);
        mkdirChecked(file3);
        return file3;
    }

    public static void install(Context context) {
        String str;
        Log.i("MultiDex", "Installing application");
        if (IS_VM_MULTIDEX_CAPABLE) {
            str = "VM has multidex support, MultiDex support library is disabled.";
        } else {
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                doInstallation(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
                str = "install done";
            } catch (Exception e2) {
                Log.e("MultiDex", "MultiDex installation failure", e2);
                StringBuilder n = a.n("MultiDex installation failed (");
                n.append(e2.getMessage());
                n.append(").");
                throw new RuntimeException(n.toString());
            }
        }
        Log.i("MultiDex", str);
    }

    public static void installInstrumentation(Context context, Context context2) {
        String str;
        Log.i("MultiDex", "Installing instrumentation");
        if (IS_VM_MULTIDEX_CAPABLE) {
            str = "VM has multidex support, MultiDex support library is disabled.";
        } else {
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo == null) {
                    Log.i("MultiDex", "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                ApplicationInfo applicationInfo2 = getApplicationInfo(context2);
                if (applicationInfo2 == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                String str2 = context.getPackageName() + ".";
                File file = new File(applicationInfo2.dataDir);
                doInstallation(context2, new File(applicationInfo.sourceDir), file, str2 + "secondary-dexes", str2, false);
                doInstallation(context2, new File(applicationInfo2.sourceDir), file, "secondary-dexes", "", false);
                str = "Installation done";
            } catch (Exception e2) {
                Log.e("MultiDex", "MultiDex installation failure", e2);
                StringBuilder n = a.n("MultiDex installation failed (");
                n.append(e2.getMessage());
                n.append(").");
                throw new RuntimeException(n.toString());
            }
        }
        Log.i("MultiDex", str);
    }

    public static void installSecondaryDexes(ClassLoader classLoader, File file, List<? extends File> list) {
        if (list.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            V19.install(classLoader, list, file);
        } else {
            V14.install(classLoader, list);
        }
    }

    public static boolean isVMMultidexCapable(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String str2 = null;
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreTokens()) {
                str2 = stringTokenizer.nextToken();
            }
            if (!(nextToken == null || str2 == null)) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder p = a.p("VM with version ", str);
        p.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", p.toString());
        return z;
    }

    public static void mkdirChecked(File file) {
        String str;
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                StringBuilder n = a.n("Failed to create dir ");
                n.append(file.getPath());
                n.append(". Parent file is null.");
                str = n.toString();
            } else {
                StringBuilder n2 = a.n("Failed to create dir ");
                n2.append(file.getPath());
                n2.append(". parent file is a dir ");
                n2.append(parentFile.isDirectory());
                n2.append(", a file ");
                n2.append(parentFile.isFile());
                n2.append(", exists ");
                n2.append(parentFile.exists());
                n2.append(", readable ");
                n2.append(parentFile.canRead());
                n2.append(", writable ");
                n2.append(parentFile.canWrite());
                str = n2.toString();
            }
            Log.e("MultiDex", str);
            StringBuilder n3 = a.n("Failed to create directory ");
            n3.append(file.getPath());
            throw new IOException(n3.toString());
        }
    }
}
